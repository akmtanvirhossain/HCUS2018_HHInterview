package org.hcus_hhinterview;
//Android Manifest Code
 //<activity android:name=".Typhoid_Extra_list" android:label="Typhoid_Extra: List" />
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
 import data_model.Typhoid_Extra_DataModel;

 import android.support.v7.widget.RecyclerView;
 import android.support.v7.app.AppCompatActivity;
 import android.content.res.TypedArray;
 import android.graphics.Canvas;
 import android.graphics.Rect;
 import android.graphics.drawable.Drawable;
 import android.support.v7.widget.LinearLayoutManager;
 import android.view.GestureDetector;
 import android.support.v7.widget.DefaultItemAnimator;
 import android.widget.EditText;

 public class Typhoid_Extra_list extends AppCompatActivity {
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
    private List<Typhoid_Extra_DataModel> dataList = new ArrayList<>();
    private RecyclerView recyclerView;
    private DataAdapter mAdapter;
    static String TableName;

    TextView lblHeading;
    Button btnAdd;
    Button btnRefresh;
    EditText txtSearch;

    static String STARTTIME = "";
     static String UPAZILA = "";
     static String CLUSTER = "";
     static String MOHOLLA = "";
    static String UNCODE = "";
    static String STRUCTURENO = "";
    static String HOUSEHOLDSL = "";
    static String VISITNO = "";
    static String MEMSL = "";

     static String UPAZILA_NAME = "";
     static String UNION_NAME = "";
     static String MOHOLLA_NAME = "";

     Spinner spnUpazila,spnUnion,spnMoholla,spnCluster;
     TextView txtTotal;

 public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
   try
     {
         setContentView(R.layout.typhoid_extra_list);
         C = new Connection(this);
         g = Global.getInstance();
         STARTTIME = g.CurrentTime24();

         TableName = "Typhoid_Extra";
         lblHeading = (TextView)findViewById(R.id.lblHeading);

         spnUpazila= (Spinner) findViewById(R.id.spnUpazila);
         spnUnion= (Spinner) findViewById(R.id.spnUnion);
         spnMoholla= (Spinner) findViewById(R.id.spnMoholla);
         spnCluster= (Spinner) findViewById(R.id.spnCluster);

         spnUpazila.setAdapter((C.getArrayAdapter("Select '' Union Select distinct Upazila ||'-'|| UpName from AreaDB")));

         spnUpazila.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                 if (spnUpazila.getSelectedItem().toString().length() == 0) return;
                 UPAZILA= Connection.SelectedSpinnerValue(spnUpazila.getSelectedItem().toString(),"-");
                 UPAZILA_NAME=C.ReturnSingleValue("select distinct UpName from AreaDB where Upazila='"+UPAZILA+"'");
                 spnUnion.setAdapter(C.getArrayAdapter("Select '  ' Union  Select distinct UNCode ||'-'|| Uname from AreaDB where Upazila='"+ Connection.SelectedSpinnerValue(spnUpazila.getSelectedItem().toString(),"-")+"'"));
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });

         spnUnion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                 if (spnUnion.getSelectedItem().toString().length() == 0) return;
                 spnMoholla.setAdapter(C.getArrayAdapter("Select '  ' Union  Select distinct VCode ||'-'|| Vname from AreaDB where Upazila='"+ Connection.SelectedSpinnerValue(spnUpazila.getSelectedItem().toString(),"-")+"' and UNCode='"+ Connection.SelectedSpinnerValue(spnUnion.getSelectedItem().toString(),"-")+"' Union Select '777-Other'"));
                 spnCluster.setAdapter(C.getArrayAdapter("Select '  ' Union  Select distinct Cluster from StructureDB where Upazila='"+ Connection.SelectedSpinnerValue(spnUpazila.getSelectedItem().toString(),"-")+"' and UNCode='"+ Connection.SelectedSpinnerValue(spnUnion.getSelectedItem().toString(),"-")+"'"));
                 UNCODE= Connection.SelectedSpinnerValue(spnUnion.getSelectedItem().toString(),"-");
                 UNION_NAME=C.ReturnSingleValue("select distinct Uname from AreaDB where UNCode='"+UNCODE+"'");
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });

         spnMoholla.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                 if (spnMoholla.getSelectedItem().toString().length() == 0) return;
                 MOHOLLA= Connection.SelectedSpinnerValue(spnMoholla.getSelectedItem().toString(),"-");
                 MOHOLLA_NAME=C.ReturnSingleValue("select distinct Vname from AreaDB where Upazila='"+UPAZILA+"' and UNCode='"+UNCODE+"' and VCode='"+MOHOLLA+"'");
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });

         spnCluster.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                 if (spnCluster.getSelectedItem().toString().length() == 0) return;
                 CLUSTER= Connection.SelectedSpinnerValue(spnCluster.getSelectedItem().toString(),"-");
//                 DataSearch(UPAZILA, UNCODE,CLUSTER);
//                 txtTotal.setText("Total No: "+dataList.size());
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });

         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(Typhoid_Extra_list.this);
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
                   DataSearch(txtSearch.getText().toString());

             }});

         btnAdd   = (Button) findViewById(R.id.btnAdd);
         btnAdd.setOnClickListener(new View.OnClickListener() {

             public void onClick(View view) {
                         Bundle IDbundle = new Bundle();
                         IDbundle.putString("UNCode", "");
                         IDbundle.putString("StructureNo", "");
                         IDbundle.putString("HouseholdSl", "");
                         IDbundle.putString("VisitNo", "");
                         IDbundle.putString("MemSl", "");
                         Intent intent = new Intent(getApplicationContext(), Typhoid_Extra.class);
                         intent.putExtras(IDbundle);
                         startActivityForResult(intent, 1);

             }});
        txtSearch = (EditText)findViewById(R.id.txtSearch);


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


        DataSearch(txtSearch.getText().toString());


     }
     catch(Exception  e)
     {
         Connection.MessageBox(Typhoid_Extra_list.this, e.getMessage());
         return;
     }
 }
 
 @Override
 protected void onActivityResult(int requestCode, int resultCode, Intent data) {
     super.onActivityResult(requestCode, resultCode, data);
     if (resultCode == Activity.RESULT_CANCELED) {
         //Write your code if there's no result
     } else {
         DataSearch(txtSearch.getText().toString());
     }
 }

 private void DataSearch(String SearchText)
     {
       try
        {
     
           Typhoid_Extra_DataModel d = new Typhoid_Extra_DataModel();
             String SQL = "Select * from "+ TableName +"  Where UNCode like('"+ SearchText +"%') or StructureNo like('"+ SearchText +"%') or HouseholdSl like('"+ SearchText +"%') or VisitNo like('"+ SearchText +"%') or MemSl like('"+ SearchText +"%')";
             List<Typhoid_Extra_DataModel> data = d.SelectAll(this, SQL);
             dataList.clear();

             dataList.addAll(data);
             try {
                 mAdapter.notifyDataSetChanged();
             }catch ( Exception ex){
                 Connection.MessageBox(Typhoid_Extra_list.this,ex.getMessage());
             }
        }
        catch(Exception  e)
        {
            Connection.MessageBox(Typhoid_Extra_list.this, e.getMessage());
            return;
        }
     }


     public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> {
         private List<Typhoid_Extra_DataModel> dataList;
         public class MyViewHolder extends RecyclerView.ViewHolder {
         LinearLayout secListRow;
         TextView UNCode;
         TextView StructureNo;
         TextView HouseholdSl;
         TextView VisitNo;
         TextView MemSl;
         TextView HaveHosp;
         TextView HospName;
         TextView HospName_Oth;
         TextView HaveRecords;
         TextView DidRecordMatch2;
         TextView DaysOfHosp;
         TextView DaysOfHospDK;
         TextView TAboIll;
         public MyViewHolder(View convertView) {
             super(convertView);
             secListRow = (LinearLayout)convertView.findViewById(R.id.secListRow);
             UNCode = (TextView)convertView.findViewById(R.id.UNCode);
             StructureNo = (TextView)convertView.findViewById(R.id.StructureNo);
             HouseholdSl = (TextView)convertView.findViewById(R.id.HouseholdSl);
             VisitNo = (TextView)convertView.findViewById(R.id.VisitNo);
             MemSl = (TextView)convertView.findViewById(R.id.MemSl);
             HaveHosp = (TextView)convertView.findViewById(R.id.HaveHosp);
             HospName = (TextView)convertView.findViewById(R.id.HospName);
             HospName_Oth = (TextView)convertView.findViewById(R.id.HospName_Oth);
             HaveRecords = (TextView)convertView.findViewById(R.id.HaveRecords);
             DidRecordMatch2 = (TextView)convertView.findViewById(R.id.DidRecordMatch2);
             DaysOfHosp = (TextView)convertView.findViewById(R.id.DaysOfHosp);
             DaysOfHospDK = (TextView)convertView.findViewById(R.id.DaysOfHospDK);
             TAboIll = (TextView)convertView.findViewById(R.id.TAboIll);
             }
         }
         public DataAdapter(List<Typhoid_Extra_DataModel> datalist) {
             this.dataList = datalist;
         }
         @Override
         public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
             View itemView = LayoutInflater.from(parent.getContext())
                     .inflate(R.layout.typhoid_extra_row, parent, false);
             return new MyViewHolder(itemView);
         }
         @Override
         public void onBindViewHolder(MyViewHolder holder, int position) {
             final Typhoid_Extra_DataModel data = dataList.get(position);
             holder.UNCode.setText(data.getUNCode());
             holder.StructureNo.setText(data.getStructureNo());
             holder.HouseholdSl.setText(data.getHouseholdSl());
             holder.VisitNo.setText(data.getVisitNo());
             holder.MemSl.setText(data.getMemSl());
             holder.HaveHosp.setText(String.valueOf(data.getHaveHosp()));
             holder.HospName.setText(data.getHospName());
             holder.HospName_Oth.setText(data.getHospName_Oth());
             holder.HaveRecords.setText(String.valueOf(data.getHaveRecords()));
             holder.DidRecordMatch2.setText(String.valueOf(data.getDidRecordMatch2()));
             holder.DaysOfHosp.setText(String.valueOf(data.getDaysOfHosp()));
             holder.DaysOfHospDK.setText(String.valueOf(data.getDaysOfHospDK()));
             holder.TAboIll.setText(data.getTAboIll());
             holder.secListRow.setOnClickListener(new View.OnClickListener() {
                 public void onClick(View v) {
                     final ProgressDialog progDailog = ProgressDialog.show(Typhoid_Extra_list.this, "", "Please Wait . . .", true);
                     new Thread() {
                         public void run() {
                             try {
                                 Bundle IDbundle = new Bundle();
                                 IDbundle.putString("UNCode", data.getUNCode());
                                 IDbundle.putString("StructureNo", data.getStructureNo());
                                 IDbundle.putString("HouseholdSl", data.getHouseholdSl());
                                 IDbundle.putString("VisitNo", data.getVisitNo());
                                 IDbundle.putString("MemSl", data.getMemSl());
                                 Intent f1 = new Intent(getApplicationContext(), Typhoid_Extra.class);
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