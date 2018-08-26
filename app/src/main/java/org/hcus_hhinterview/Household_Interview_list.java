package org.hcus_hhinterview;
 //Android Manifest Code
 //<activity android:name=".Household_Interview_list" android:label="Household_Interview: List" />
 import java.util.ArrayList;
 import java.util.List;
 import android.app.*;
 import android.app.AlertDialog;
 import android.content.Context;
 import android.content.DialogInterface;
 import android.content.Intent;
 import android.location.Location;
 import android.view.KeyEvent;
 import android.os.Bundle;
 import android.view.View;
 import android.view.MotionEvent;
 import android.view.ViewGroup;
 import android.view.LayoutInflater;
 import android.widget.LinearLayout;
 import android.widget.TextView;
 import android.widget.Button;
 import android.widget.ImageButton;
 import Common.*;
 import android.support.v7.widget.RecyclerView;
 import android.support.v7.app.AppCompatActivity;
 import android.content.res.TypedArray;
 import android.graphics.Canvas;
 import android.graphics.Rect;
 import android.graphics.drawable.Drawable;
 import android.support.v7.widget.LinearLayoutManager;
 import android.view.GestureDetector;
 import android.support.v7.widget.DefaultItemAnimator;
 import data_model.Household_Interview_DataModel;

 public class Household_Interview_list extends AppCompatActivity {
    boolean networkAvailable=false;
    Location currentLocation; 
    double currentLatitude,currentLongitude; 
    //Disabled Back/Home key
    //--------------------------------------------------------------------------------------------------
    @Override 
    public boolean onKeyDown(int iKeyCode, KeyEvent event)
    {
        if(iKeyCode == KeyEvent.KEYCODE_BACK || iKeyCode == KeyEvent.KEYCODE_HOME) 
             { return false; }
        else { return true;  }
    }
    String VariableID;
    private int mDay;
    private int mMonth;
    private int mYear;
    static final int DATE_DIALOG = 1;
    static final int TIME_DIALOG = 2;

    Connection C;
    Global g;
    private List<Household_Interview_DataModel> dataList = new ArrayList<>();
    private RecyclerView recyclerView;
    private Household_Interview_list.DataAdapter mAdapter;
    static String TableName;

    TextView lblHeading;
    Button btnAdd;
    Button btnRefresh;

    static String STARTTIME = "";
    static String UNCODE = "";
    static String STRUCTURENO = "";
    static String HOUSEHOLDSL = "";
    static String VISITNO = "";

 public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
   try
     {
         setContentView(R.layout.household_interview_list);
         C = new Connection(this);
         g = Global.getInstance();
         STARTTIME = g.CurrentTime24();

         TableName = "Household_Interview";
         lblHeading = (TextView)findViewById(R.id.lblHeading);

         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(Household_Interview_list.this);
                 adb.setTitle("Close");
                 adb.setMessage("Do you want to close this form[Yes/No]?");
                 adb.setNegativeButton("No", null);
                 adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                     public void onClick(DialogInterface dialog, int which) {
                         finish();
                     }});
                 adb.show();
             }});

         btnRefresh = (Button) findViewById(R.id.btnRefresh);
         btnRefresh.setOnClickListener(new View.OnClickListener() {

             public void onClick(View view) {
                   //write your code here
                   DataSearch(UNCODE, STRUCTURENO, HOUSEHOLDSL, VISITNO);

             }});

         btnAdd   = (Button) findViewById(R.id.btnAdd);
         btnAdd.setOnClickListener(new View.OnClickListener() {

             public void onClick(View view) {
                         Bundle IDbundle = new Bundle();
                         IDbundle.putString("UNCode", "");
                         IDbundle.putString("StructureNo", "");
                         IDbundle.putString("HouseholdSl", "");
                         IDbundle.putString("VisitNo", "");
                         Intent intent = new Intent(getApplicationContext(), Household_Interview.class);
                         intent.putExtras(IDbundle);
                         startActivityForResult(intent, 1);

             }});


        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        mAdapter = new DataAdapter(dataList);
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new Household_Interview_list.DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);


        DataSearch(UNCODE, STRUCTURENO, HOUSEHOLDSL, VISITNO);


     }
     catch(Exception  e)
     {
         Connection.MessageBox(Household_Interview_list.this, e.getMessage());
         return;
     }
 }
 
 @Override
 protected void onActivityResult(int requestCode, int resultCode, Intent data) {
     super.onActivityResult(requestCode, resultCode, data);
     if (resultCode == Activity.RESULT_CANCELED) {
         //Write your code if there's no result
     } else {
         DataSearch(UNCODE, STRUCTURENO, HOUSEHOLDSL, VISITNO);
     }
 }

 private void DataSearch(String UNCode, String StructureNo, String HouseholdSl, String VisitNo)
     {
       try
        {
     
           Household_Interview_DataModel d = new Household_Interview_DataModel();
             String SQL = "Select * from "+ TableName +"  Where UNCode='"+ UNCode +"' and StructureNo='"+ StructureNo +"' and HouseholdSl='"+ HouseholdSl +"' and VisitNo='"+ VisitNo +"'";
             List<Household_Interview_DataModel> data = d.SelectAll(this, SQL);
             dataList.clear();

             dataList.addAll(data);
             try {
                 mAdapter.notifyDataSetChanged();
             }catch ( Exception ex){
                 Connection.MessageBox(Household_Interview_list.this,ex.getMessage());
             }
        }
        catch(Exception  e)
        {
            Connection.MessageBox(Household_Interview_list.this, e.getMessage());
            return;
        }
     }


     public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> {
         private List<Household_Interview_DataModel> dataList;
         public class MyViewHolder extends RecyclerView.ViewHolder {
         LinearLayout secListRow;
         TextView UNCode;
         TextView StructureNo;
         TextView HouseholdSl;
         TextView VisitNo;
         TextView FHeadAvail;
         TextView RelWithFHead;
         TextView OthRelWithFHead;
         TextView FirstName;
         TextView EduLevelFHead;
         TextView EduLevelMHead;
         TextView liveHouseM;
         TextView liveHouseY;
         TextView LiveHH_Mon;
         TextView LiveHH_Year;
         TextView LiveCity_Mon;
         TextView LiveCity_Year;
         TextView Hlive12m;
         TextView ChangedHouse;
         TextView DistHome;
         TextView ChildHcare;
         TextView ChildHcareOth;
         TextView MotherEdu;
         TextView HeadOcp;
         TextView HeadOcpOth;
         TextView Room;
         TextView BedRoom;
         TextView Electricity;
         TextView Radio;
         TextView Television;
         TextView NonMobileTele;
         TextView Computer;
         TextView Refrigerator;
         TextView Watch;
         TextView MobilePhone;
         TextView Bicycle;
         TextView MotorcycleScooter;
         TextView AnimalDrawnCart;
         TextView CarOrTruck;
         TextView BankAccount;
         TextView HHOwner;
         TextView RentOfDwelling;
         TextView RentOfDwellDK;
         TextView ConsMatFloor;
         TextView ConsMatFloorOth;
         TextView ConsMatWall;
         TextView ConsMatWallOth;
         TextView ConsMatRoof;
         TextView ConsMatRoofOth;
         TextView Fuel;
         TextView FuelOth;
         TextView TypeOfToilet;
         TextView TypeOfToiletOth;
         TextView TypeOfChildToilet;
         TextView TypeOfChildToiletOth;
         TextView ToiletShare;
         TextView SOfDrinkingWater;
         TextView TimeToWalkInMin;
         TextView TimeToWalkInHours;
         TextView WeeklyWSupplyInHour;
         TextView WeeklyWSuppHouse;
         TextView TreatDKWater;
         TextView TreatMeth;
         TextView OpenSewers;
         TextView Handwash;
         TextView Water;
         public MyViewHolder(View convertView) {
             super(convertView);
             secListRow = (LinearLayout)convertView.findViewById(R.id.secListRow);
             UNCode = (TextView)convertView.findViewById(R.id.UNCode);
             StructureNo = (TextView)convertView.findViewById(R.id.StructureNo);
             HouseholdSl = (TextView)convertView.findViewById(R.id.HouseholdSl);
             VisitNo = (TextView)convertView.findViewById(R.id.VisitNo);
             FHeadAvail = (TextView)convertView.findViewById(R.id.FHeadAvail);
             RelWithFHead = (TextView)convertView.findViewById(R.id.RelWithFHead);
             OthRelWithFHead = (TextView)convertView.findViewById(R.id.OthRelWithFHead);
             FirstName = (TextView)convertView.findViewById(R.id.FirstName);
             EduLevelFHead = (TextView)convertView.findViewById(R.id.EduLevelFHead);
             EduLevelMHead = (TextView)convertView.findViewById(R.id.EduLevelMHead);
             liveHouseM = (TextView)convertView.findViewById(R.id.liveHouseM);
             liveHouseY = (TextView)convertView.findViewById(R.id.liveHouseY);
             LiveHH_Mon = (TextView)convertView.findViewById(R.id.LiveHH_Mon);
             LiveHH_Year = (TextView)convertView.findViewById(R.id.LiveHH_Year);
             LiveCity_Mon = (TextView)convertView.findViewById(R.id.LiveCity_Mon);
             LiveCity_Year = (TextView)convertView.findViewById(R.id.LiveCity_Year);
             Hlive12m = (TextView)convertView.findViewById(R.id.Hlive12m);
             ChangedHouse = (TextView)convertView.findViewById(R.id.ChangedHouse);
             DistHome = (TextView)convertView.findViewById(R.id.DistHome);
             ChildHcare = (TextView)convertView.findViewById(R.id.ChildHcare);
             ChildHcareOth = (TextView)convertView.findViewById(R.id.ChildHcareOth);
             MotherEdu = (TextView)convertView.findViewById(R.id.MotherEdu);
             HeadOcp = (TextView)convertView.findViewById(R.id.HeadOcp);
             HeadOcpOth = (TextView)convertView.findViewById(R.id.HeadOcpOth);
             Room = (TextView)convertView.findViewById(R.id.Room);
             BedRoom = (TextView)convertView.findViewById(R.id.BedRoom);
             Electricity = (TextView)convertView.findViewById(R.id.Electricity);
             Radio = (TextView)convertView.findViewById(R.id.Radio);
             Television = (TextView)convertView.findViewById(R.id.Television);
             NonMobileTele = (TextView)convertView.findViewById(R.id.NonMobileTele);
             Computer = (TextView)convertView.findViewById(R.id.Computer);
             Refrigerator = (TextView)convertView.findViewById(R.id.Refrigerator);
             Watch = (TextView)convertView.findViewById(R.id.Watch);
             MobilePhone = (TextView)convertView.findViewById(R.id.MobilePhone);
             Bicycle = (TextView)convertView.findViewById(R.id.Bicycle);
             MotorcycleScooter = (TextView)convertView.findViewById(R.id.MotorcycleScooter);
             AnimalDrawnCart = (TextView)convertView.findViewById(R.id.AnimalDrawnCart);
             CarOrTruck = (TextView)convertView.findViewById(R.id.CarOrTruck);
             BankAccount = (TextView)convertView.findViewById(R.id.BankAccount);
             HHOwner = (TextView)convertView.findViewById(R.id.HHOwner);
             RentOfDwelling = (TextView)convertView.findViewById(R.id.RentOfDwelling);
             RentOfDwellDK = (TextView)convertView.findViewById(R.id.RentOfDwellDK);
             ConsMatFloor = (TextView)convertView.findViewById(R.id.ConsMatFloor);
             ConsMatFloorOth = (TextView)convertView.findViewById(R.id.ConsMatFloorOth);
             ConsMatWall = (TextView)convertView.findViewById(R.id.ConsMatWall);
             ConsMatWallOth = (TextView)convertView.findViewById(R.id.ConsMatWallOth);
             ConsMatRoof = (TextView)convertView.findViewById(R.id.ConsMatRoof);
             ConsMatRoofOth = (TextView)convertView.findViewById(R.id.ConsMatRoofOth);
             Fuel = (TextView)convertView.findViewById(R.id.Fuel);
             FuelOth = (TextView)convertView.findViewById(R.id.FuelOth);
             TypeOfToilet = (TextView)convertView.findViewById(R.id.TypeOfToilet);
             TypeOfToiletOth = (TextView)convertView.findViewById(R.id.TypeOfToiletOth);
             TypeOfChildToilet = (TextView)convertView.findViewById(R.id.TypeOfChildToilet);
             TypeOfChildToiletOth = (TextView)convertView.findViewById(R.id.TypeOfChildToiletOth);
             ToiletShare = (TextView)convertView.findViewById(R.id.ToiletShare);
             SOfDrinkingWater = (TextView)convertView.findViewById(R.id.SOfDrinkingWater);
             TimeToWalkInMin = (TextView)convertView.findViewById(R.id.TimeToWalkInMin);
             TimeToWalkInHours = (TextView)convertView.findViewById(R.id.TimeToWalkInHours);
             WeeklyWSupplyInHour = (TextView)convertView.findViewById(R.id.WeeklyWSupplyInHour);
             WeeklyWSuppHouse = (TextView)convertView.findViewById(R.id.WeeklyWSuppHouse);
             TreatDKWater = (TextView)convertView.findViewById(R.id.TreatDKWater);
             TreatMeth = (TextView)convertView.findViewById(R.id.TreatMeth);
             OpenSewers = (TextView)convertView.findViewById(R.id.OpenSewers);
             Handwash = (TextView)convertView.findViewById(R.id.Handwash);
             Water = (TextView)convertView.findViewById(R.id.Water);
             }
         }
         public DataAdapter(List<Household_Interview_DataModel> datalist) {
             this.dataList = datalist;
         }
         @Override
         public Household_Interview_list.DataAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
             View itemView = LayoutInflater.from(parent.getContext())
                     .inflate(R.layout.household_interview_row, parent, false);
             return new Household_Interview_list.DataAdapter.MyViewHolder(itemView);
         }
         @Override
         public void onBindViewHolder(Household_Interview_list.DataAdapter.MyViewHolder holder, int position) {
             final Household_Interview_DataModel data = dataList.get(position);
             holder.UNCode.setText(data.getUNCode());
             holder.StructureNo.setText(data.getStructureNo());
             holder.HouseholdSl.setText(data.getHouseholdSl());
             holder.VisitNo.setText(data.getVisitNo());
             holder.FHeadAvail.setText(data.getFHeadAvail());
             holder.RelWithFHead.setText(data.getRelWithFHead());
             holder.OthRelWithFHead.setText(data.getOthRelWithFHead());
             holder.FirstName.setText(data.getFirstName());
             holder.EduLevelFHead.setText(data.getEduLevelFHead());
             holder.EduLevelMHead.setText(data.getEduLevelMHead());
             holder.liveHouseM.setText(data.getliveHouseM());
             holder.liveHouseY.setText(data.getliveHouseY());
             holder.LiveHH_Mon.setText(data.getLiveHH_Mon());
             holder.LiveHH_Year.setText(data.getLiveHH_Year());
             holder.LiveCity_Mon.setText(data.getLiveCity_Mon());
             holder.LiveCity_Year.setText(data.getLiveCity_Year());
             holder.Hlive12m.setText(data.getHlive12m());
             holder.ChangedHouse.setText(data.getChangedHouse());
             holder.DistHome.setText(data.getDistHome());
             holder.ChildHcare.setText(data.getChildHcare());
             holder.ChildHcareOth.setText(data.getChildHcareOth());
             holder.MotherEdu.setText(data.getMotherEdu());
             holder.HeadOcp.setText(data.getHeadOcp());
             holder.HeadOcpOth.setText(data.getHeadOcpOth());
             holder.Room.setText(data.getRoom());
             holder.BedRoom.setText(data.getBedRoom());
             holder.Electricity.setText(data.getElectricity());
             holder.Radio.setText(data.getRadio());
             holder.Television.setText(data.getTelevision());
             holder.NonMobileTele.setText(data.getNonMobileTele());
             holder.Computer.setText(data.getComputer());
             holder.Refrigerator.setText(data.getRefrigerator());
             holder.Watch.setText(data.getWatch());
             holder.MobilePhone.setText(data.getMobilePhone());
             holder.Bicycle.setText(data.getBicycle());
             holder.MotorcycleScooter.setText(data.getMotorcycleScooter());
             holder.AnimalDrawnCart.setText(data.getAnimalDrawnCart());
             holder.CarOrTruck.setText(data.getCarOrTruck());
             holder.BankAccount.setText(data.getBankAccount());
             holder.HHOwner.setText(data.getHHOwner());
             holder.RentOfDwelling.setText(data.getRentOfDwelling());
             holder.RentOfDwellDK.setText(data.getRentOfDwellDK());
             holder.ConsMatFloor.setText(data.getConsMatFloor());
             holder.ConsMatFloorOth.setText(data.getConsMatFloorOth());
             holder.ConsMatWall.setText(data.getConsMatWall());
             holder.ConsMatWallOth.setText(data.getConsMatWallOth());
             holder.ConsMatRoof.setText(data.getConsMatRoof());
             holder.ConsMatRoofOth.setText(data.getConsMatRoofOth());
             holder.Fuel.setText(data.getFuel());
             holder.FuelOth.setText(data.getFuelOth());
             holder.TypeOfToilet.setText(data.getTypeOfToilet());
             holder.TypeOfToiletOth.setText(data.getTypeOfToiletOth());
             holder.TypeOfChildToilet.setText(data.getTypeOfChildToilet());
             holder.TypeOfChildToiletOth.setText(data.getTypeOfChildToiletOth());
             holder.ToiletShare.setText(data.getToiletShare());
             holder.SOfDrinkingWater.setText(data.getSOfDrinkingWater());
             holder.TimeToWalkInMin.setText(data.getTimeToWalkInMin());
             holder.TimeToWalkInHours.setText(data.getTimeToWalkInHours());
             holder.WeeklyWSupplyInHour.setText(data.getWeeklyWSupplyInHour());
             holder.WeeklyWSuppHouse.setText(data.getWeeklyWSuppHouse());
             holder.TreatDKWater.setText(data.getTreatDKWater());
             holder.TreatMeth.setText(data.getTreatMeth());
             holder.OpenSewers.setText(data.getOpenSewers());
             holder.Handwash.setText(data.getHandwash());
             holder.Water.setText(data.getWater());
             holder.secListRow.setOnClickListener(new View.OnClickListener() {
                 public void onClick(View v) {
                     final ProgressDialog progDailog = ProgressDialog.show(Household_Interview_list.this, "", "Please Wait . . .", true);
                     new Thread() {
                         public void run() {
                             try {
                                 Bundle IDbundle = new Bundle();
                                 IDbundle.putString("UNCode", data.getUNCode());
                                 IDbundle.putString("StructureNo",""+ data.getStructureNo());
                                 IDbundle.putString("HouseholdSl", data.getHouseholdSl());
                                 IDbundle.putString("VisitNo", data.getVisitNo());
                                 Intent f1 = new Intent(getApplicationContext(), Household_Interview.class);
                                 f1.putExtras(IDbundle);
                                 startActivityForResult(f1,1);
                             } catch (Exception e) {
                             }
                             progDailog.dismiss();
                         }
                     }.start();
                 }
             });
         }
         @Override
         public int getItemCount() {
             return dataList.size();
         }
     }

     public class DividerItemDecoration extends RecyclerView.ItemDecoration {
             private final int[] ATTRS = new int[]{
                     android.R.attr.listDivider
             };
             public static final int HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL;
             public static final int VERTICAL_LIST = LinearLayoutManager.VERTICAL;
             private Drawable mDivider;
             private int mOrientation;
             public DividerItemDecoration(Context context, int orientation) {
                 final TypedArray a = context.obtainStyledAttributes(ATTRS);
                 mDivider = a.getDrawable(0);
                 a.recycle();
                 setOrientation(orientation);
             }
             public void setOrientation(int orientation) {
                 if (orientation != HORIZONTAL_LIST && orientation != VERTICAL_LIST) {
                     throw new IllegalArgumentException("invalid orientation");
                 }
                 mOrientation = orientation;
             }
             @Override
             public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
                 if (mOrientation == VERTICAL_LIST) {
                     drawVertical(c, parent);
                 } else {
                     drawHorizontal(c, parent);
                 }
             }
             public void drawVertical(Canvas c, RecyclerView parent) {
                 final int left = parent.getPaddingLeft();
                 final int right = parent.getWidth() - parent.getPaddingRight();

                 final int childCount = parent.getChildCount();
                 for (int i = 0; i < childCount; i++) {
                     final View child = parent.getChildAt(i);
                     final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                             .getLayoutParams();
                     final int top = child.getBottom() + params.bottomMargin;
                     final int bottom = top + mDivider.getIntrinsicHeight();
                     mDivider.setBounds(left, top, right, bottom);
                     mDivider.draw(c);
                 }
             }
             public void drawHorizontal(Canvas c, RecyclerView parent) {
                 final int top = parent.getPaddingTop();
                 final int bottom = parent.getHeight() - parent.getPaddingBottom();
                 final int childCount = parent.getChildCount();
                 for (int i = 0; i < childCount; i++) {
                     final View child = parent.getChildAt(i);
                     final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                             .getLayoutParams();
                     final int left = child.getRight() + params.rightMargin;
                     final int right = left + mDivider.getIntrinsicHeight();
                     mDivider.setBounds(left, top, right, bottom);
                     mDivider.draw(c);
                 }
             }
             @Override
             public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                 if (mOrientation == VERTICAL_LIST) {
                     outRect.set(0, 0, 0, mDivider.getIntrinsicHeight());
                 } else {
                     outRect.set(0, 0, mDivider.getIntrinsicWidth(), 0);
                 }
             }
     }

     public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {
             private GestureDetector gestureDetector;
             private Household_Interview_list.RecyclerTouchListener.ClickListener clickListener;
             public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final Household_Interview_list.RecyclerTouchListener.ClickListener clickListener) {
                 this.clickListener = clickListener;
                 gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                     @Override
                     public boolean onSingleTapUp(MotionEvent e) {
                         return true;
                     }
                     @Override
                     public void onLongPress(MotionEvent e) {
                         View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                         if (child != null && clickListener != null) {
                             clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                         }
                     }
                 });
             }
             @Override
             public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                 View child = rv.findChildViewUnder(e.getX(), e.getY());
                 if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                     clickListener.onClick(child, rv.getChildPosition(child));
                 }
                 return false;
             }
             @Override
             public void onTouchEvent(RecyclerView rv, MotionEvent e) {
             }
             @Override
             public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
             }
             interface ClickListener {
                 void onClick(View view, int position);
                 void onLongClick(View view, int position);
             }
     }


}