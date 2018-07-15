package org.hcus;
//Android Manifest Code
 //<activity android:name=".StructureListing_list" android:label="StructureListing: List" />
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
 import android.widget.AdapterView;
 import android.widget.LinearLayout;
 import android.widget.Spinner;
 import android.widget.TextView;
 import android.widget.Button;
 import android.widget.ImageButton;
 import Common.*;
 import data_model.StructureDB_DataModel;

 import android.support.v7.widget.RecyclerView;
 import android.support.v7.app.AppCompatActivity;
 import android.content.res.TypedArray;
 import android.graphics.Canvas;
 import android.graphics.Rect;
 import android.graphics.drawable.Drawable;
 import android.support.v7.widget.LinearLayoutManager;
 import android.view.GestureDetector;
 import android.support.v7.widget.DefaultItemAnimator;

 public class StructureListing_list extends AppCompatActivity {
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
    private List<StructureDB_DataModel> dataList = new ArrayList<StructureDB_DataModel>();
    private RecyclerView recyclerView;
    private DataAdapter mAdapter;
    static String TableName;

    TextView lblHeading;
    Button btnAdd;
    Button btnRefresh;

    TextView tvUpazila,tvUnion,tvMoholla,tvCluster;
    Spinner spnUpazila,spnUnion,spnMoholla,spnCluster;

     TextView txtTotal;


    static String STARTTIME = "";
    static String UPAZILA = "";
    static String UNCODE = "";
    static String CLUSTER = "";
    static String MOHOLLA = "";

 public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
   try
     {
         setContentView(R.layout.structurelisting_list);
         C = new Connection(this);
         g = Global.getInstance();
         STARTTIME = g.CurrentTime24();

         TableName = "StructureListing";

         tvUpazila= (TextView) findViewById(R.id.tvUpazila);
         txtTotal= (TextView) findViewById(R.id.txtTotal);
         tvUnion= (TextView) findViewById(R.id.tvUnion);
         tvMoholla= (TextView) findViewById(R.id.tvMoholla);
         tvCluster= (TextView) findViewById(R.id.tvCluster);

         spnUpazila= (Spinner) findViewById(R.id.spnUpazila);
         spnUnion= (Spinner) findViewById(R.id.spnUnion);
         spnMoholla= (Spinner) findViewById(R.id.spnMoholla);
         spnCluster= (Spinner) findViewById(R.id.spnCluster);

         spnUpazila.setAdapter((C.getArrayAdapter("Select '' Union Select distinct Upazila ||'-'|| UpName from AreaDB")));

         spnUpazila.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                 if (spnUpazila.getSelectedItem().toString().length() == 0) return;
                 UPAZILA=Connection.SelectedSpinnerValue(spnUpazila.getSelectedItem().toString(),"-");
                 spnUnion.setAdapter(C.getArrayAdapter("Select '  ' Union  Select distinct UNCode ||'-'|| Uname from AreaDB where Upazila='"+ Connection.SelectedSpinnerValue(spnUpazila.getSelectedItem().toString(),"-")+"'"));

                 //spnVillage.setAdapter(C.getArrayAdapter("Select VName from Village where UnName='"+ Connection.SelectedSpinnerValue(spnUnion.getSelectedItem().toString(),"-")+"'  union Select '999-Others'"));
//                 if(Connection.SelectedSpinnerValue(spnUnion.getSelectedItem().toString(),"-").equals("999"))
//                     spnUnion.setSelection(Global.SpinnerItemPositionAnyLength(spnUnion,"999"));
//                 else
//                     spnUnion.setSelection(Global.SpinnerItemPositionAnyLength(spnUnion,""));
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });

         spnUnion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                 if (spnUnion.getSelectedItem().toString().length() == 0) return;
                 spnMoholla.setAdapter(C.getArrayAdapter("Select '  ' Union  Select distinct VCode ||'-'|| Vname from AreaDB where Upazila='"+ Connection.SelectedSpinnerValue(spnUpazila.getSelectedItem().toString(),"-")+"' and UNCode='"+Connection.SelectedSpinnerValue(spnUnion.getSelectedItem().toString(),"-")+"'"));
                 spnCluster.setAdapter(C.getArrayAdapter("Select '  ' Union  Select distinct Cluster from StructureDB where Upazila='"+ Connection.SelectedSpinnerValue(spnUpazila.getSelectedItem().toString(),"-")+"' and UNCode='"+Connection.SelectedSpinnerValue(spnUnion.getSelectedItem().toString(),"-")+"'"));
                 UNCODE=Connection.SelectedSpinnerValue(spnUnion.getSelectedItem().toString(),"-");

                 //spnVillage.setAdapter(C.getArrayAdapter("Select VName from Village where UnName='"+ Connection.SelectedSpinnerValue(spnUnion.getSelectedItem().toString(),"-")+"'  union Select '999-Others'"));
//                 if(Connection.SelectedSpinnerValue(spnUnion.getSelectedItem().toString(),"-").equals("999"))
//                     spnUnion.setSelection(Global.SpinnerItemPositionAnyLength(spnUnion,"999"));
//                 else
//                     spnUnion.setSelection(Global.SpinnerItemPositionAnyLength(spnUnion,""));


             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });

         spnCluster.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                 if (spnCluster.getSelectedItem().toString().length() == 0) return;
                 CLUSTER=Connection.SelectedSpinnerValue(spnCluster.getSelectedItem().toString(),"-");


             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });

         spnMoholla.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                 if (spnMoholla.getSelectedItem().toString().length() == 0) return;
                 MOHOLLA=Connection.SelectedSpinnerValue(spnMoholla.getSelectedItem().toString(),"-");


             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });

         lblHeading = (TextView)findViewById(R.id.lblHeading);

         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(StructureListing_list.this);
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
                   DataSearch(UPAZILA, UNCODE,CLUSTER);
                   txtTotal.setText("Total No: "+dataList.size());


             }});

         btnAdd   = (Button) findViewById(R.id.btnAdd);
         btnAdd.setOnClickListener(new View.OnClickListener() {

             public void onClick(View view) {
                         Bundle IDbundle = new Bundle();
                         IDbundle.putString("Upazila", UPAZILA);
                         IDbundle.putString("UNCode", UNCODE);
                         IDbundle.putString("Moholla", MOHOLLA);
                         IDbundle.putString("Cluster", CLUSTER);
                         IDbundle.putString("StructureNo", "");
                         Intent intent = new Intent(getApplicationContext(), StructureListing.class);
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
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);


        DataSearch(UPAZILA, UNCODE,CLUSTER);


     }
     catch(Exception  e)
     {
         Connection.MessageBox(StructureListing_list.this, e.getMessage());
         return;
     }
 }
 
 @Override
 protected void onActivityResult(int requestCode, int resultCode, Intent data) {
     super.onActivityResult(requestCode, resultCode, data);
     if (resultCode == Activity.RESULT_CANCELED) {
         //Write your code if there's no result
     } else {
         DataSearch(UPAZILA, UNCODE,CLUSTER);
     }
 }

     private void DataSearch(String Upazila, String UNCode, String Cluster)
     {
         try
         {

             StructureDB_DataModel d = new StructureDB_DataModel();
//             String SQL = "Select * from "+ TableName +"  Where Upazila='"+ Upazila +"' and UNCode='"+ UNCode +"' and Cluster='"+ Cluster +"'";
             String SQL = "Select * from structureDB  Where Upazila='"+ Upazila +"' and UNCode='"+ UNCode +"' and Cluster='"+ Cluster +"'";
             List<StructureDB_DataModel> data = d.SelectAll(this, SQL);
             dataList.clear();

             dataList.addAll(data);
             try {
                 mAdapter.notifyDataSetChanged();
             }catch ( Exception ex){
                 Connection.MessageBox(StructureListing_list.this,ex.getMessage());
             }
         }
         catch(Exception  e)
         {
             Connection.MessageBox(StructureListing_list.this, e.getMessage());
             return;
         }
     }


     public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> {
         private List<StructureDB_DataModel> dataList;
         public class MyViewHolder extends RecyclerView.ViewHolder {
             LinearLayout secListRow;
//             TextView Division;
//             TextView DivName;
//             TextView Zila;
//             TextView ZilaName;
//             TextView Upazila;
//             TextView UpName;
//             TextView UNCode;
//             TextView Uname;
//             TextView Cluster;
             TextView SlNo;
             TextView StructureNo;
             public MyViewHolder(View convertView) {
                 super(convertView);
                 secListRow = (LinearLayout)convertView.findViewById(R.id.secListRow);
//                 Division = (TextView)convertView.findViewById(R.id.Division);
//                 DivName = (TextView)convertView.findViewById(R.id.DivName);
//                 Zila = (TextView)convertView.findViewById(R.id.Zila);
//                 ZilaName = (TextView)convertView.findViewById(R.id.ZilaName);
//                 Upazila = (TextView)convertView.findViewById(R.id.Upazila);
//                 UpName = (TextView)convertView.findViewById(R.id.UpName);
//                 UNCode = (TextView)convertView.findViewById(R.id.UNCode);
//                 Uname = (TextView)convertView.findViewById(R.id.Uname);
//                 Cluster = (TextView)convertView.findViewById(R.id.Cluster);
                 StructureNo = (TextView)convertView.findViewById(R.id.StructureNo);
                 SlNo = (TextView)convertView.findViewById(R.id.SlNo);
             }
         }
         public DataAdapter(List<StructureDB_DataModel> datalist) {
             this.dataList = datalist;
         }
         @Override
         public DataAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
             View itemView = LayoutInflater.from(parent.getContext())
                     .inflate(R.layout.structuredb_row, parent, false);
             return new DataAdapter.MyViewHolder(itemView);
         }
         @Override
         public void onBindViewHolder(DataAdapter.MyViewHolder holder, int position) {
             final StructureDB_DataModel data = dataList.get(position);
//             holder.Division.setText(data.getDivision());
//             holder.DivName.setText(data.getDivName());
//             holder.Zila.setText(data.getZila());
//             holder.ZilaName.setText(data.getZilaName());
//             holder.Upazila.setText(data.getUpazila());
//             holder.UpName.setText(data.getUpName());
//             holder.UNCode.setText(data.getUNCode());
//             holder.Uname.setText(data.getUname());
//             holder.Cluster.setText(data.getCluster());
             holder.StructureNo.setText(data.getStructureNo());
             holder.SlNo.setText(""+(position+1)+".");

             holder.secListRow.setOnClickListener(new View.OnClickListener() {
                 public void onClick(View v) {
                     final ProgressDialog progDailog = ProgressDialog.show(StructureListing_list.this, "", "Please Wait . . .", true);
                     new Thread() {
                         public void run() {
                             try {
                                 Bundle IDbundle = new Bundle();

                                 IDbundle.putString("Upazila", data.getUpazila());
                                 IDbundle.putString("UNCode", data.getUNCode());
                                 IDbundle.putString("Moholla", MOHOLLA);
                                 IDbundle.putString("Cluster", data.getCluster());
                                 IDbundle.putString("StructureNo", data.getStructureNo());
                                 Intent f1 = new Intent(getApplicationContext(), StructureListing.class);
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

// private void DataSearch(String Upazila, String UNCode,String cluster)
//     {
//       try
//        {
//
//           StructureListing_DataModel d = new StructureListing_DataModel();
////             String SQL = "Select * from "+ TableName +"  Where Upazila='"+ Upazila +"' and UNCode='"+ UNCode +"'";
//             String SQL = "Select * from structuredb  Where Upazila='"+ Upazila +"' and UNCode='"+ UNCode +"' and cluster='"+ cluster +"'";
//             List<StructureListing_DataModel> data = d.SelectAll(this, SQL);
//             dataList.clear();
//
//             dataList.addAll(data);
//             try {
//                 mAdapter.notifyDataSetChanged();
//             }catch ( Exception ex){
//                 Connection.MessageBox(StructureListing_list.this,ex.getMessage());
//             }
//        }
//        catch(Exception  e)
//        {
//            Connection.MessageBox(StructureListing_list.this, e.getMessage());
//            return;
//        }
//     }
//
//
//     public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> {
//         private List<StructureListing_DataModel> dataList;
//         public class MyViewHolder extends RecyclerView.ViewHolder {
//         LinearLayout secListRow;
//         TextView Upazila;
//         TextView UNCode;
//         TextView VCode;
//         TextView Cluster;
//         TextView StructureNo;
//         TextView ColDate;
//         TextView ColTime;
//         TextView StructureStatus;
//         TextView Holding;
//         TextView Address;
//         TextView BuildingType;
//         TextView BuildingTypeOth;
//         TextView Srtoried;
//         TextView Landmark1;
//         TextView Landmark1Code;
//         TextView LandmarkOth1;
//         TextView LandmarkName1;
//         TextView Landmark2;
//         TextView Landmark2Code;
//         TextView LandmarkOth2;
//         TextView Landmark2Name;
//         TextView Landmark3;
//         TextView Landmark3Code;
//         TextView LandmarkOth3;
//         TextView Landmark3Name;
//         TextView Landmark4;
//         TextView Landmark4Code;
//         TextView LandmarkOth4;
//         TextView Landmark4Name;
//         TextView OwnerName;
//         TextView OccupantName;
//         TextView TotHH;
//         TextView Slum;
//         TextView Waypoint;
//         TextView LatDeg;
//         TextView LatMin;
//         TextView LatSec;
//         TextView LonDeg;
//         TextView LonMin;
//         TextView LonSec;
//         TextView Remarks;
//         public MyViewHolder(View convertView) {
//             super(convertView);
//             secListRow = (LinearLayout)convertView.findViewById(R.id.secListRow);
//             Upazila = (TextView)convertView.findViewById(R.id.Upazila);
//             UNCode = (TextView)convertView.findViewById(R.id.UNCode);
//             VCode = (TextView)convertView.findViewById(R.id.VCode);
//             Cluster = (TextView)convertView.findViewById(R.id.Cluster);
//             StructureNo = (TextView)convertView.findViewById(R.id.StructureNo);
//             ColDate = (TextView)convertView.findViewById(R.id.ColDate);
//             ColTime = (TextView)convertView.findViewById(R.id.ColTime);
//             StructureStatus = (TextView)convertView.findViewById(R.id.StructureStatus);
//             Holding = (TextView)convertView.findViewById(R.id.Holding);
//             Address = (TextView)convertView.findViewById(R.id.Address);
//             BuildingType = (TextView)convertView.findViewById(R.id.BuildingType);
//             BuildingTypeOth = (TextView)convertView.findViewById(R.id.BuildingTypeOth);
//             Srtoried = (TextView)convertView.findViewById(R.id.Srtoried);
//             Landmark1 = (TextView)convertView.findViewById(R.id.Landmark1);
//             Landmark1Code = (TextView)convertView.findViewById(R.id.Landmark1Code);
//             LandmarkOth1 = (TextView)convertView.findViewById(R.id.LandmarkOth1);
//             LandmarkName1 = (TextView)convertView.findViewById(R.id.LandmarkName1);
//             Landmark2 = (TextView)convertView.findViewById(R.id.Landmark2);
//             Landmark2Code = (TextView)convertView.findViewById(R.id.Landmark2Code);
//             LandmarkOth2 = (TextView)convertView.findViewById(R.id.LandmarkOth2);
//             Landmark2Name = (TextView)convertView.findViewById(R.id.Landmark2Name);
//             Landmark3 = (TextView)convertView.findViewById(R.id.Landmark3);
//             Landmark3Code = (TextView)convertView.findViewById(R.id.Landmark3Code);
//             LandmarkOth3 = (TextView)convertView.findViewById(R.id.LandmarkOth3);
//             Landmark3Name = (TextView)convertView.findViewById(R.id.Landmark3Name);
//             Landmark4 = (TextView)convertView.findViewById(R.id.Landmark4);
//             Landmark4Code = (TextView)convertView.findViewById(R.id.Landmark4Code);
//             LandmarkOth4 = (TextView)convertView.findViewById(R.id.LandmarkOth4);
//             Landmark4Name = (TextView)convertView.findViewById(R.id.Landmark4Name);
//             OwnerName = (TextView)convertView.findViewById(R.id.OwnerName);
//             OccupantName = (TextView)convertView.findViewById(R.id.OccupantName);
//             TotHH = (TextView)convertView.findViewById(R.id.TotHH);
//             Slum = (TextView)convertView.findViewById(R.id.Slum);
//             Waypoint = (TextView)convertView.findViewById(R.id.Waypoint);
//             LatDeg = (TextView)convertView.findViewById(R.id.LatDeg);
//             LatMin = (TextView)convertView.findViewById(R.id.LatMin);
//             LatSec = (TextView)convertView.findViewById(R.id.LatSec);
//             LonDeg = (TextView)convertView.findViewById(R.id.LonDeg);
//             LonMin = (TextView)convertView.findViewById(R.id.LonMin);
//             LonSec = (TextView)convertView.findViewById(R.id.LonSec);
//             Remarks = (TextView)convertView.findViewById(R.id.Remarks);
//             }
//         }
//         public DataAdapter(List<StructureListing_DataModel> datalist) {
//             this.dataList = datalist;
//         }
//         @Override
//         public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//             View itemView = LayoutInflater.from(parent.getContext())
//                     .inflate(R.layout.structurelisting_row, parent, false);
//             return new MyViewHolder(itemView);
//         }
//         @Override
//         public void onBindViewHolder(MyViewHolder holder, int position) {
//             final StructureListing_DataModel data = dataList.get(position);
//             holder.Upazila.setText(data.getUpazila());
//             holder.UNCode.setText(data.getUNCode());
//             holder.VCode.setText(data.getVCode());
//             holder.Cluster.setText(data.getCluster());
//             holder.StructureNo.setText(data.getStructureNo());
//             holder.ColDate.setText(data.getColDate());
//             holder.ColTime.setText(data.getColTime());
//             holder.StructureStatus.setText(data.getStructureStatus());
//             holder.Holding.setText(data.getHolding());
//             holder.Address.setText(data.getAddress());
//             holder.BuildingType.setText(data.getBuildingType());
//             holder.BuildingTypeOth.setText(data.getBuildingTypeOth());
//             holder.Srtoried.setText(data.getSrtoried());
//             holder.Landmark1.setText(data.getLandmark1());
//             holder.Landmark1Code.setText(data.getLandmark1Code());
//             holder.LandmarkOth1.setText(data.getLandmarkOth1());
//             holder.LandmarkName1.setText(data.getLandmarkName1());
//             holder.Landmark2.setText(data.getLandmark2());
//             holder.Landmark2Code.setText(data.getLandmark2Code());
//             holder.LandmarkOth2.setText(data.getLandmarkOth2());
//             holder.Landmark2Name.setText(data.getLandmark2Name());
//             holder.Landmark3.setText(data.getLandmark3());
//             holder.Landmark3Code.setText(data.getLandmark3Code());
//             holder.LandmarkOth3.setText(data.getLandmarkOth3());
//             holder.Landmark3Name.setText(data.getLandmark3Name());
//             holder.Landmark4.setText(data.getLandmark4());
//             holder.Landmark4Code.setText(data.getLandmark4Code());
//             holder.LandmarkOth4.setText(data.getLandmarkOth4());
//             holder.Landmark4Name.setText(data.getLandmark4Name());
//             holder.OwnerName.setText(data.getOwnerName());
//             holder.OccupantName.setText(data.getOccupantName());
//             holder.TotHH.setText(data.getTotHH());
//             holder.Slum.setText(data.getSlum());
//             holder.Waypoint.setText(data.getWaypoint());
//             holder.LatDeg.setText(data.getLatDeg());
//             holder.LatMin.setText(data.getLatMin());
//             holder.LatSec.setText(data.getLatSec());
//             holder.LonDeg.setText(data.getLonDeg());
//             holder.LonMin.setText(data.getLonMin());
//             holder.LonSec.setText(data.getLonSec());
//             holder.Remarks.setText(data.getRemarks());
//             holder.secListRow.setOnClickListener(new View.OnClickListener() {
//                 public void onClick(View v) {
//                     final ProgressDialog progDailog = ProgressDialog.show(StructureListing_list.this, "", "Please Wait . . .", true);
//                     new Thread() {
//                         public void run() {
//                             try {
//                                 Bundle IDbundle = new Bundle();
//                                 IDbundle.putString("Upazila", data.getUpazila());
//                                 IDbundle.putString("UNCode", data.getUNCode());
//                                 Intent f1 = new Intent(getApplicationContext(), StructureListing.class);
//                                 f1.putExtras(IDbundle);
//                                 startActivityForResult(f1,1);
//                             } catch (Exception e) {
//                             }
//                             progDailog.dismiss();
//                         }
//                     }.start();
//                 }
//             });
//         }
//         @Override
//         public int getItemCount() {
//             return dataList.size();
//         }
//     }

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
             private ClickListener clickListener;
             public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
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