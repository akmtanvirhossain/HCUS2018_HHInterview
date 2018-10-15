package org.hcus_hhinterview;
//Android Manifest Code
 //<activity android:name=".Immunization_List_list" android:label="Immunization_List: List" />

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Common.Connection;
import Common.Global;
import Common.Utility;
import data_model.Immunization_History_DataModel;
import data_model.Immunization_List_DataModel;
import Utility.MySharedPreferences;

 public class Immunization_List_list extends AppCompatActivity {
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
    public List<Immunization_List_DataModel> dataList = new ArrayList<>();
     public RecyclerView recyclerView;
     public DataAdapter mAdapter;
    static String TableName;

    TextView lblHeading;
    Button btnAdd;
    Button btnRefresh;

    static String STARTTIME = "";
     static String DEVICEID  = "";
     static String ENTRYUSER = "";
     MySharedPreferences sp;


    static String VACC_ID = "";


     Bundle IDbundle;
     static String UNCODE = "";
     static String STRUCTURENO = "";
     static String HOUSEHOLDSL = "";
     static String VISITNO = "";
     static String MEMSL = "";

 public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
   try
     {
         setContentView(R.layout.immunization_list_list);
         C = new Connection(this);
         g = Global.getInstance();
         STARTTIME = g.CurrentTime24();
         DEVICEID  = sp.getValue(this, "deviceid");
         ENTRYUSER = sp.getValue(this, "userid");

         IDbundle = getIntent().getExtras();
         UNCODE = IDbundle.getString("UNCode");
         STRUCTURENO = IDbundle.getString("StructureNo");
         HOUSEHOLDSL = IDbundle.getString("HouseholdSl");
         VISITNO = IDbundle.getString("VisitNo");
         MEMSL = IDbundle.getString("MemSl");

         TableName = "Immunization_List";
         lblHeading = (TextView)findViewById(R.id.lblHeading);

         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(Immunization_List_list.this);
                 adb.setTitle("Close");
                 adb.setMessage("Do you want to close this form[Yes/No]?");
                 adb.setNegativeButton("No", null);
                 adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                     public void onClick(DialogInterface dialog, int which) {
                         finish();
                     }});
                 adb.show();
             }});

//         btnRefresh = (Button) findViewById(R.id.btnRefresh);
//         btnRefresh.setOnClickListener(new View.OnClickListener() {
//
//             public void onClick(View view) {
//                   //write your code here
//                   DataSearch(VACC_ID);
//
//             }});
//
//         btnAdd   = (Button) findViewById(R.id.btnAdd);
//         btnAdd.setOnClickListener(new View.OnClickListener() {
//
//             public void onClick(View view) {
//                         Bundle IDbundle = new Bundle();
//                         IDbundle.putString("Vacc_Id", "");
//                         Intent intent = new Intent(getApplicationContext(), Immunization_List.class);
//                         intent.putExtras(IDbundle);
//                         startActivityForResult(intent, 1);
//
//             }});


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


         DataSearch_Immunization("","");


     }
     catch(Exception  e)
     {
         Connection.MessageBox(Immunization_List_list.this, e.getMessage());
         return;
     }
 }
 
 @Override
 protected void onActivityResult(int requestCode, int resultCode, Intent data) {
     super.onActivityResult(requestCode, resultCode, data);
     if (resultCode == Activity.RESULT_CANCELED) {
         //Write your code if there's no result
     } else {
         DataSearch_Immunization(VACC_ID,"");
     }
 }

 public void DataSearch_Immunization(String Vacc_Id,String DeviceID)
     {
       try
        {
     
           Immunization_List_DataModel d = new Immunization_List_DataModel();
//             String SQL = "Select * from "+ TableName ;//+"  Where Vacc_Id='"+ Vacc_Id +"'";
            String SQL = "Select IH.[DeviceID],IL.[Vacc_Id],IL.[Vacc_Name],ifnull(IH.Given,'') Given,ifnull(IH.Source,'') Source FROM [Immunization_List] IL left outer join Immunization_History IH on IL.Vacc_Id=IH.Vacc_Id Where IH.Uncode='"+UNCODE+"' and IH.structureno='"+STRUCTURENO+"' and IH.householdsl='"+HOUSEHOLDSL+"' and IH.visitno='"+VISITNO+"' and IH.memsl='"+MEMSL+"' and IH.DeviceID='"+DeviceID+"' order by IL.[Vacc_Id]";
             List<Immunization_List_DataModel> data = d.SelectAll_WithHistory(this, SQL);
             dataList.clear();

             dataList.addAll(data);
             
             //************* insert into immunization history **************

//            for (Immunization_List_DataModel item:dataList) {
//
//                if(C.Existence("Select * from Immunization_History Where UNCode='"+ UNCODE +"' and StructureNo='"+ STRUCTURENO +"' and HouseholdSl='"+ HOUSEHOLDSL +"' and VisitNo='"+ VISITNO +"' and MemSl='"+ MEMSL +"' and Vacc_Id='"+ item.getVacc_Id() +"' "))
//                {
//
//                }
//                else
//                {
//                    Immunization_History_DataModel objSave = new Immunization_History_DataModel();
//                    objSave.setUNCode(UNCODE);
//                    objSave.setStructureNo(STRUCTURENO);
//                    objSave.setHouseholdSl(HOUSEHOLDSL);
//                    objSave.setVisitNo(VISITNO);
//                    objSave.setMemSl(MEMSL);
//                    objSave.setVacc_Id(item.getVacc_Id());
//                    objSave.setGiven(0);
//                    objSave.setSource(0);
//                    objSave.setVacc_Date("");
//                    objSave.setDate_Missing(2);
//                    objSave.setEnDt(Global.DateTimeNowYMDHMS());
//                    objSave.setStartTime(STARTTIME);
//                    objSave.setEndTime(g.CurrentTime24());
//                    objSave.setDeviceID(DEVICEID);
//                    objSave.setEntryUser(ENTRYUSER); //from data entry user list
//                    objSave.setmodifyDate(Global.DateTimeNowYMDHMS());
//                    objSave.SaveUpdateData(this);
//                }
//            }
             
             try {
                 mAdapter.notifyDataSetChanged();
             }catch ( Exception ex){
                 Connection.MessageBox(Immunization_List_list.this,ex.getMessage());
             }
        }
        catch(Exception  e)
        {
            Connection.MessageBox(Immunization_List_list.this, e.getMessage());
            return;
        }
     }


     public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> {
         private List<Immunization_List_DataModel> dataList;
         public class MyViewHolder extends RecyclerView.ViewHolder {
         LinearLayout secListRow;
//         TextView Vacc_Id;
         TextView Vacc_Name;
         TextView Given;
         TextView Source;
         public MyViewHolder(View convertView) {
             super(convertView);
             secListRow = (LinearLayout)convertView.findViewById(R.id.secListRow);
//             Vacc_Id = (TextView)convertView.findViewById(R.id.Vacc_Id);
             Vacc_Name = (TextView)convertView.findViewById(R.id.Vacc_Name);
             Given = (TextView)convertView.findViewById(R.id.Given);
             Source = (TextView)convertView.findViewById(R.id.Source);
             }
         }
         public DataAdapter(List<Immunization_List_DataModel> datalist) {
             this.dataList = datalist;
         }
         @Override
         public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
             View itemView = LayoutInflater.from(parent.getContext())
                     .inflate(R.layout.immunization_list_row, parent, false);
             return new MyViewHolder(itemView);
         }
         @Override
         public void onBindViewHolder(MyViewHolder holder, int position) {
             final Immunization_List_DataModel data = dataList.get(position);
//             holder.Vacc_Id.setText(data.getVacc_Id());
             holder.Vacc_Name.setText(data.getVacc_Name());

             if(data.get_Given().equals("1")) {
                 holder.Given.setText("Yes");
             }

             if(data.get_Source().equals("1"))
             {
                 holder.Source.setText("Card Verified");
             }
             else if(data.get_Source().equals("2"))
             {
                 holder.Source.setText("Verbal Report");
             }


             if(data.get_Given().equals("1"))
             {
                 holder.secListRow.setBackgroundColor(Color.GREEN);
             }

             holder.secListRow.setOnClickListener(new View.OnClickListener() {
                 public void onClick(View v) {
                     final ProgressDialog progDailog = ProgressDialog.show(Immunization_List_list.this, "", "Please Wait . . .", true);
                     new Thread() {
                         public void run() {
                             try {
                                 IDbundle.putString("UNCode", UNCODE);
                                 IDbundle.putString("StructureNo", STRUCTURENO);
                                 IDbundle.putString("HouseholdSl", HOUSEHOLDSL);
                                 IDbundle.putString("VisitNo", VISITNO);
                                 IDbundle.putString("MemSl",""+MEMSL);
                                 IDbundle.putString("Vacc_Id",""+data.getVacc_Id());
                                 IDbundle.putString("Vacc_Name",""+data.getVacc_Name());
                                 IDbundle.putString("DeviceId", data.get_DeviceID());
//                            IDbundle.putString("Age",""+AGE);
                                 Intent f1 = new Intent(getApplicationContext(), Immunization_History.class);
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