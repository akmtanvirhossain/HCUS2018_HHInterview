package org.hcus_hhinterview;
//Android Manifest Code
 //<activity android:name=".Household_Visit_list" android:label="Household_Visit: List" />
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
 import android.widget.EditText;
 import android.widget.LinearLayout;
 import android.widget.TextView;
 import android.widget.Button;
 import android.widget.ImageButton;
 import Common.*;
 import data_model.Household_Visit_DataModel;

 import android.support.v7.widget.RecyclerView;
 import android.support.v7.app.AppCompatActivity;
 import android.content.res.TypedArray;
 import android.graphics.Canvas;
 import android.graphics.Rect;
 import android.graphics.drawable.Drawable;
 import android.support.v7.widget.LinearLayoutManager;
 import android.view.GestureDetector;
 import android.support.v7.widget.DefaultItemAnimator;

 public class Household_Visit_list extends AppCompatActivity {
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

     LinearLayout secUNCode;
     View lineUNCode;
     TextView VlblUNCode;
     EditText txtUNCode;
     LinearLayout secStructureNo;
     View lineStructureNo;
     TextView VlblStructureNo;
     EditText txtStructureNo;
     TextView txtUnion_Name;

    private List<Household_Visit_DataModel> dataList = new ArrayList<>();
    private RecyclerView recyclerView;
    private DataAdapter mAdapter;
    static String TableName;

    TextView lblHeading;
    Button btnAdd;
    Button btnRefresh;


    static String STARTTIME = "";
    static String UNCODE = "";
    static String STRUCTURENO = "";
    static String HOUSEHOLDSL = "";
    static String VISITNO = "";

     Bundle IDbundle;

     static String UPAZILA_NAME = "";
     static String UNION_NAME = "";

 public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
   try
     {
         setContentView(R.layout.household_visit_list);
         C = new Connection(this);
         g = Global.getInstance();


         STARTTIME = g.CurrentTime24();

         IDbundle = getIntent().getExtras();
         UNCODE = IDbundle.getString("UNCode");
         STRUCTURENO = IDbundle.getString("StructureNo");


         UPAZILA_NAME = IDbundle.getString("Upazila_Name");
         UNION_NAME = IDbundle.getString("Union_Name");

         TableName = "Household_Visit";
         lblHeading = (TextView)findViewById(R.id.lblHeading);

         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(Household_Visit_list.this);
                 adb.setTitle("Close");
                 adb.setMessage("Do you want to close this form[Yes/No]?");
                 adb.setNegativeButton("No", null);
                 adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                     public void onClick(DialogInterface dialog, int which) {
                         finish();
                     }});
                 adb.show();
             }});
         txtUnion_Name=findViewById(R.id.txtUnion_Name);
         secUNCode=(LinearLayout)findViewById(R.id.secUNCode);
         lineUNCode=(View)findViewById(R.id.lineUNCode);
         VlblUNCode=(TextView) findViewById(R.id.VlblUNCode);
         txtUNCode=(EditText) findViewById(R.id.txtUNCode);
         secStructureNo=(LinearLayout)findViewById(R.id.secStructureNo);
         lineStructureNo=(View)findViewById(R.id.lineStructureNo);
         VlblStructureNo=(TextView) findViewById(R.id.VlblStructureNo);
         txtStructureNo=(EditText) findViewById(R.id.txtStructureNo);

         btnRefresh = (Button) findViewById(R.id.btnRefresh);
         final String SL = C.ReturnSingleValue("Select (ifnull(max(cast(HouseholdSl as int)),0)+1) from Household_Visit where UNCode='"+UNCODE+"'and StructureNo='"+ STRUCTURENO +"'"); //where ParticipantID='"+ ParticipantID +"'");

         final String SLNO = C.ReturnSingleValue("Select (ifnull(max(cast(VisitNo as int)),0)+1) from Household_Visit where UNCode='"+UNCODE+"'and StructureNo='"+ STRUCTURENO +"'and HouseholdSl='"+ HOUSEHOLDSL +"'"); //where ParticipantID='"+ ParticipantID +"'");



         btnRefresh.setOnClickListener(new View.OnClickListener() {

             public void onClick(View view) {
                   //write your code here
                   DataSearch(UNCODE, STRUCTURENO);

             }});

         btnAdd   = (Button) findViewById(R.id.btnAdd);
         btnAdd.setOnClickListener(new View.OnClickListener() {

             public void onClick(View view) {
                         Bundle IDbundle = new Bundle();
                         IDbundle.putString("UNCode",UNCODE  );
                         IDbundle.putString("StructureNo",STRUCTURENO );
                         IDbundle.putString("HouseholdSl", SL);
                         IDbundle.putString("VisitNo", SLNO);

                         Intent intent = new Intent(getApplicationContext(), Household_Visit.class);
                         intent.putExtras(IDbundle);
                         startActivityForResult(intent, 1);

             }});


         txtUNCode.setText(UNCODE);
         txtStructureNo.setText(STRUCTURENO);
         txtUnion_Name.setText(UNION_NAME);


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


        DataSearch(UNCODE, STRUCTURENO);


     }
     catch(Exception  e)
     {
         Connection.MessageBox(Household_Visit_list.this, e.getMessage());
         return;
     }
 }
 
 @Override
 protected void onActivityResult(int requestCode, int resultCode, Intent data) {
     super.onActivityResult(requestCode, resultCode, data);
     if (resultCode == Activity.RESULT_CANCELED) {
         //Write your code if there's no result
     } else {
         DataSearch(UNCODE, STRUCTURENO);



     }
 }

 private void DataSearch(String UNCode, String StructureNo)
     {
       try
        {
     
           Household_Visit_DataModel d = new Household_Visit_DataModel();
             String SQL = "Select * from "+ TableName +" Where UNCode='"+ UNCode +"' and StructureNo='"+ StructureNo +"'";
             List<Household_Visit_DataModel> data = d.SelectAll(this, SQL);
             dataList.clear();

             dataList.addAll(data);
             try {
                 mAdapter.notifyDataSetChanged();
             }catch ( Exception ex){
                 Connection.MessageBox(Household_Visit_list.this,ex.getMessage());
             }
        }
        catch(Exception  e)
        {
            Connection.MessageBox(Household_Visit_list.this, e.getMessage());
            return;
        }
     }


     public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> {
         private List<Household_Visit_DataModel> dataList;
         public class MyViewHolder extends RecyclerView.ViewHolder {
         LinearLayout secListRow;
         TextView UNCode;
         TextView StructureNo;
         TextView HouseholdSl;
         TextView VisitNo;
         TextView HHVisited;
         TextView Outcome;
         TextView OutcomeOth;
         TextView HHMember;
         TextView U18Yrs;
         TextView U18Alive;
         TextView U18YrsDie;
         TextView U18Death;
         TextView OfferedStudy;
         TextView NotOffered;
         TextView NotOfferedOth;
         TextView Consent;
         TextView Remarks;
         TextView DataCollDate;
         Button btnEdit;
         public MyViewHolder(View convertView) {
             super(convertView);
             secListRow = (LinearLayout)convertView.findViewById(R.id.secListRow);
             UNCode = (TextView)convertView.findViewById(R.id.UNCode);
             StructureNo = (TextView)convertView.findViewById(R.id.StructureNo);
             HouseholdSl = (TextView)convertView.findViewById(R.id.HouseholdSl);
//             VisitNo = (TextView)convertView.findViewById(R.id.VisitNo);
//             HHVisited = (TextView)convertView.findViewById(R.id.HHVisited);
//             Outcome = (TextView)convertView.findViewById(R.id.Outcome);
//             OutcomeOth = (TextView)convertView.findViewById(R.id.OutcomeOth);
//             HHMember = (TextView)convertView.findViewById(R.id.HHMember);
//             U18Yrs = (TextView)convertView.findViewById(R.id.U18Yrs);
//             U18Alive = (TextView)convertView.findViewById(R.id.U18Alive);
//             U18YrsDie = (TextView)convertView.findViewById(R.id.U18YrsDie);
//             U18Death = (TextView)convertView.findViewById(R.id.U18Death);
//             OfferedStudy = (TextView)convertView.findViewById(R.id.OfferedStudy);
//             NotOffered = (TextView)convertView.findViewById(R.id.NotOffered);
//             NotOfferedOth = (TextView)convertView.findViewById(R.id.NotOfferedOth);
//             Consent = (TextView)convertView.findViewById(R.id.Consent);
//             Remarks = (TextView)convertView.findViewById(R.id.Remarks);
//             DataCollDate = (TextView)convertView.findViewById(R.id.DataCollDate);
             }
         }
         public DataAdapter(List<Household_Visit_DataModel> datalist) {
             this.dataList = datalist;
         }
         @Override
         public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
             View itemView = LayoutInflater.from(parent.getContext())
                     .inflate(R.layout.household_visit_row, parent, false);
             return new MyViewHolder(itemView);
         }
         @Override
         public void onBindViewHolder(MyViewHolder holder, int position) {
             final Household_Visit_DataModel data = dataList.get(position);
             holder.UNCode.setText(data.getUNCode());
             holder.StructureNo.setText(data.getStructureNo());
             holder.HouseholdSl.setText(""+data.getHouseholdSl());
//             holder.VisitNo.setText(data.getVisitNo());
//             holder.HHVisited.setText(data.getHHVisited());
//             holder.Outcome.setText(data.getOutcome());
//             holder.OutcomeOth.setText(data.getOutcomeOth());
//             holder.HHMember.setText(data.getHHMember());
//             holder.U18Yrs.setText(data.getU18Yrs());
//             holder.U18Alive.setText(data.getU18Alive());
//             holder.U18YrsDie.setText(data.getU18YrsDie());
//             holder.U18Death.setText(data.getU18Death());
//             holder.OfferedStudy.setText(data.getOfferedStudy());
//             holder.NotOffered.setText(data.getNotOffered());
//             holder.NotOfferedOth.setText(data.getNotOfferedOth());
//             holder.Consent.setText(data.getConsent());
//             holder.Remarks.setText(data.getRemarks());
//             holder.DataCollDate.setText(data.getDataCollDate());
             holder.secListRow.setOnClickListener(new View.OnClickListener() {
                 public void onClick(View v) {
                     final ProgressDialog progDailog = ProgressDialog.show(Household_Visit_list.this, "", "Please Wait . . .", true);
                     new Thread() {
                         public void run() {
                             try {
                                 Bundle IDbundle = new Bundle();
                                 IDbundle.putString("UNCode", data.getUNCode());
                                 IDbundle.putString("StructureNo", data.getStructureNo());
                                 IDbundle.putString("HouseholdSl", ""+data.getHouseholdSl());
                                 IDbundle.putString("VisitNo", data.getVisitNo());
                                 Intent f1 = new Intent(getApplicationContext(), Household_Visit.class);
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