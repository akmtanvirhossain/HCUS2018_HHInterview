package org.hcus_hhinterview;
//Android Manifest Code
 //<activity android:name=".Typhoid_Extra_Master_list" android:label="Typhoid_Extra_Master: List" />
 import java.util.ArrayList;
 import java.util.List;
 import android.app.*;
 import android.app.AlertDialog;
 import android.content.Context;
 import android.content.DialogInterface;
 import android.content.Intent;
 import android.graphics.Color;
 import android.location.Location;
 import android.text.Editable;
 import android.text.TextWatcher;
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
 import data_model.Typhoid_Extra_Master_DataModel;

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

 public class Typhoid_Extra_Master_list extends AppCompatActivity {
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
    private List<Typhoid_Extra_Master_DataModel> dataList = new ArrayList<>();
    private RecyclerView recyclerView;
    private DataAdapter mAdapter;
    static String TableName;

    TextView lblHeading;
    Button btnAdd;
    Button btnRefresh;
    EditText txtSearch;

    static String STARTTIME = "";
    static String UPAZILA = "";
    static String UNCODE = "";
     static String CLUSTER = "";
     static String MOHOLLA = "";
    static String STRUCTURENO = "";
    static String HOUSEHOLDSL = "";
    static String VISITNO = "";
    static String MEMSL = "";

     Spinner spnUpazila,spnUnion,spnMoholla,spnCluster;//,spnStructureNo;
     TextView txtTotal;

 public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
   try
     {
         setContentView(R.layout.typhoid_extra_master_list);
         C = new Connection(this);
         g = Global.getInstance();
         STARTTIME = g.CurrentTime24();

         TableName = "Typhoid_Extra_Master";
         lblHeading = (TextView)findViewById(R.id.lblHeading);


         spnUpazila= (Spinner) findViewById(R.id.spnUpazila);
         spnUnion= (Spinner) findViewById(R.id.spnUnion);
         spnMoholla= (Spinner) findViewById(R.id.spnMoholla);
         spnCluster= (Spinner) findViewById(R.id.spnCluster);
//         spnStructureNo= (Spinner) findViewById(R.id.spnStructureNo);

         txtTotal=findViewById(R.id.txtTotal);


         spnUpazila.setAdapter((C.getArrayAdapter("Select '' Union Select distinct Upazila ||'-'|| UpName from Typhoid_Extra_Master")));
         spnUpazila.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 if (spnUpazila.getSelectedItem().toString().length() == 0) return;
                 UPAZILA=Connection.SelectedSpinnerValue(spnUpazila.getSelectedItem().toString(),"-");
                 spnUnion.setAdapter((C.getArrayAdapter("Select '' Union Select distinct UNCode ||'-'|| Uname from Typhoid_Extra_Master where Upazila='"+UPAZILA+"'")));
             }

             @Override
             public void onNothingSelected(AdapterView<?> parent) {

             }
         });


         spnUnion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                 if (spnUnion.getSelectedItem().toString().length() == 0) return;
                 UNCODE= Connection.SelectedSpinnerValue(spnUnion.getSelectedItem().toString(),"-");
                 spnMoholla.setAdapter((C.getArrayAdapter("Select '' Union Select distinct VCode ||'-'|| Vname from Typhoid_Extra_Master where Upazila='"+UPAZILA+"' and UNCode='"+UNCODE+"'")));
                 spnCluster.setAdapter((C.getArrayAdapter("Select '' Union Select distinct Cluster from Typhoid_Extra_Master where Upazila='"+UPAZILA+"' and UNCode='"+UNCODE+"'")));

             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });

         spnMoholla.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 MOHOLLA=Connection.SelectedSpinnerValue(spnMoholla.getSelectedItem().toString(),"-");
             }

             @Override
             public void onNothingSelected(AdapterView<?> parent) {

             }
         });

         spnCluster.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 CLUSTER=Connection.SelectedSpinnerValue(spnCluster.getSelectedItem().toString(),"-");
//                 spnStructureNo.setAdapter((C.getArrayAdapter("Select '' Union Select distinct StructureNo from Typhoid_Extra_Master where Upazila='"+UPAZILA+"' and UNCode='"+UNCODE+"' and Cluster='"+CLUSTER+"'")));
                 DataSearch("");
             }

             @Override
             public void onNothingSelected(AdapterView<?> parent) {

             }
         });



//         spnStructureNo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//         @Override
//         public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//             STRUCTURENO=Connection.SelectedSpinnerValue(spnStructureNo.getSelectedItem().toString(),"-");
//
//
//             DataSearch(UNCODE,STRUCTURENO);
//         }
//
//         @Override
//         public void onNothingSelected(AdapterView<?> parent) {
//
//         }
//     });

         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(Typhoid_Extra_Master_list.this);
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
                 DataSearch("");

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
//                         Intent intent = new Intent(getApplicationContext(), Typhoid_Extra_Master.class);
//                         intent.putExtras(IDbundle);
//                         startActivityForResult(intent, 1);

             }});
        txtSearch = (EditText)findViewById(R.id.txtSearch);


        txtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                DataSearch(txtSearch.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


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


//        DataSearch(txtSearch.getText().toString());


     }
     catch(Exception  e)
     {
         Connection.MessageBox(Typhoid_Extra_Master_list.this, e.getMessage());
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
     
           Typhoid_Extra_Master_DataModel d = new Typhoid_Extra_Master_DataModel();
//             String SQL = "Select * from "+ TableName +"  Where UNCode like('"+ SearchText +"%') or StructureNo like('"+ SearchText +"%') or HouseholdSl like('"+ SearchText +"%') or VisitNo like('"+ SearchText +"%') or MemSl like('"+ SearchText +"%')";
//             String SQL = "Select * from "+ TableName +"  Where UNCode ='"+ uncode +"' and StructureNo ='"+ strno +"'";
            String SQL = "Select t.*,ifnull((t.UNCode+t1.StructureNo+t1.HouseholdSl+t1.VisitNo+t1.MemSl+t1.DeviceID),'') typhoid_extra from Typhoid_Extra_Master t \n" +
                    "left outer join Typhoid_Extra t1 on t1.UNCode=t.UNCode and t1.StructureNo=t.StructureNo and t1.HouseholdSl=t.HouseholdSl and t1.VisitNo=t.VisitNo\n" +
                    "and t1.MemSl=t.MemSl and t1.DeviceID=t.DeviceID\n" +
                    "  Where t.Upazila='"+UPAZILA+"' and t.UNCode='"+UNCODE+"' and t.Cluster='"+CLUSTER+"' and t.StructureNo like '"+SearchText+"%' order by t.StructureNo,t.DeviceID,t.HouseholdSl";
             List<Typhoid_Extra_Master_DataModel> data = d.SelectAll(this, SQL);
             dataList.clear();

             dataList.addAll(data);
             try {
                 mAdapter.notifyDataSetChanged();
                 txtTotal.setText("Total: "+ dataList.size());
             }catch ( Exception ex){
                 Connection.MessageBox(Typhoid_Extra_Master_list.this,ex.getMessage());
             }
        }
        catch(Exception  e)
        {
            Connection.MessageBox(Typhoid_Extra_Master_list.this, e.getMessage());
            return;
        }
     }


     public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> {
         private List<Typhoid_Extra_Master_DataModel> dataList;
         public class MyViewHolder extends RecyclerView.ViewHolder {
         LinearLayout secListRow;
//         TextView UNCode;
         TextView StructureNo;
         TextView HouseholdSl;
         TextView VisitNo;
         TextView MemSl;
         TextView HHHead;
         TextView childName;
         TextView Age;
         TextView Sex;
         TextView Member;
         TextView Holding;
         TextView Road;
         TextView Address;
         TextView Device;
         TextView VisitDate;
         public MyViewHolder(View convertView) {
             super(convertView);
             secListRow = (LinearLayout)convertView.findViewById(R.id.secListRow);
//             UNCode = (TextView)convertView.findViewById(R.id.UNCode);
             StructureNo = (TextView)convertView.findViewById(R.id.StructureNo);
             HouseholdSl = (TextView)convertView.findViewById(R.id.HouseholdSl);
             VisitNo = (TextView)convertView.findViewById(R.id.VisitNo);
             MemSl = (TextView)convertView.findViewById(R.id.MemSl);
             HHHead = (TextView)convertView.findViewById(R.id.HHHead);
             childName = (TextView)convertView.findViewById(R.id.childName);
             Age = (TextView)convertView.findViewById(R.id.Age);
             Sex = (TextView)convertView.findViewById(R.id.Sex);
             Member = (TextView)convertView.findViewById(R.id.Member);
             Holding = (TextView)convertView.findViewById(R.id.Holding);
             Road = (TextView)convertView.findViewById(R.id.Road);
             Address = (TextView)convertView.findViewById(R.id.Address);
             Device = (TextView)convertView.findViewById(R.id.Device);
             VisitDate = (TextView)convertView.findViewById(R.id.VisitDate);
             }
         }
         public DataAdapter(List<Typhoid_Extra_Master_DataModel> datalist) {
             this.dataList = datalist;
         }
         @Override
         public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
             View itemView = LayoutInflater.from(parent.getContext())
                     .inflate(R.layout.typhoid_extra_master_row, parent, false);
             return new MyViewHolder(itemView);
         }
         @Override
         public void onBindViewHolder(MyViewHolder holder, int position) {
             final Typhoid_Extra_Master_DataModel data = dataList.get(position);

//             holder.UNCode.setText(data.getUNCode());
             holder.StructureNo.setText(data.getStructureNo()+" HH#: "+ data.getHouseholdSl());
             holder.HouseholdSl.setText(data.getHouseholdSl());
             holder.VisitNo.setText(data.getVisitNo());
             holder.MemSl.setText(data.getMemSl());
             holder.HHHead.setText(data.getHHHead());
             holder.childName.setText(data.getchildName());
//             holder.Age.setText(data.getAge());

             if((int)Double.parseDouble(data.getAge())<=60)
             {
                 holder.Age.setText(""+ data.getAge() +" days");
             }
             else if((int)Double.parseDouble(data.getAge())>=61 & (int)Double.parseDouble(data.getAge())<1826 )
             {
                 int age=(int) (((int)Double.parseDouble(data.getAge()))/30.4);
                 holder.Age.setText(""+ age +" months");

             }
             else if((int)Double.parseDouble(data.getAge())>=1826 & (int)Double.parseDouble(data.getAge())<6574 )
             {
                 double age=(double) (((int)Double.parseDouble(data.getAge()))/365.25);
                 holder.Age.setText(""+Math.ceil(age)+" years");
             }

             if(data.getSex().equals("1")) {
                 holder.Sex.setText("Male");
             }else
             {
                 holder.Sex.setText("Female");
             }

             holder.Member.setText(data.getMember());
             holder.Holding.setText(data.getHolding());
             holder.Road.setText(data.getRoad());
             holder.Address.setText(data.getAddress());
             holder.Device.setText(data.get_DeviceID());
             holder.VisitDate.setText(Global.DateConvertDMY(Global.Left(data.getVisitDate(),10)));


             if(data.get_typhoid_extra().length()>0)
             {
                 holder.secListRow.setBackgroundColor(Color.GREEN);
             }else
             {
                 holder.secListRow.setBackgroundColor(Color.WHITE);
             }

             holder.secListRow.setOnClickListener(new View.OnClickListener() {
                 public void onClick(View v) {
                     final ProgressDialog progDailog = ProgressDialog.show(Typhoid_Extra_Master_list.this, "", "Please Wait . . .", true);
                     new Thread() {
                         public void run() {
                             try {
                                 Bundle IDbundle = new Bundle();
                                 IDbundle.putString("UNCode", data.getUNCode());
                                 IDbundle.putString("StructureNo", data.getStructureNo());
                                 IDbundle.putString("HouseholdSl", data.getHouseholdSl());
                                 IDbundle.putString("VisitNo", data.getVisitNo());
                                 IDbundle.putString("MemSl", data.getMemSl());
                                 IDbundle.putString("DeviceID", data.get_DeviceID());
                                 IDbundle.putString("ChildName", data.getchildName());
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