package org.hcus_hhinterview;
 //Android Manifest Code
 //<activity android:name=".Member_list" android:label="Member: List" />
 import java.security.PrivateKey;
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
 import data_model.Member_DataModel;

 import android.support.v7.widget.RecyclerView;
 import android.support.v7.app.AppCompatActivity;
 import android.content.res.TypedArray;
 import android.graphics.Canvas;
 import android.graphics.Rect;
 import android.graphics.drawable.Drawable;
 import android.support.v7.widget.LinearLayoutManager;
 import android.view.GestureDetector;
 import android.support.v7.widget.DefaultItemAnimator;

 public class Member_list extends AppCompatActivity {
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
    public List<Member_DataModel> dataList = new ArrayList<>();
    private RecyclerView recyclerView;
    public DataAdapter_member mAdapter;
    static String TableName;

    TextView lblHeading;
    Button btnAdd;
    Button btnRefresh;
     Bundle IDbundle;

    static String STARTTIME = "";
    static String UNCODE = "";
    static String STRUCTURENO = "";
    static String HOUSEHOLDSL = "";
    static String VISITNO = "";
    static String MEMSL = "";

 public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
   try
     {
         setContentView(R.layout.member_list);
         C = new Connection(this);
         g = Global.getInstance();
         STARTTIME = g.CurrentTime24();

         IDbundle = getIntent().getExtras();
         UNCODE = IDbundle.getString("UNCode");
         STRUCTURENO = IDbundle.getString("StructureNo");
         HOUSEHOLDSL = IDbundle.getString("HouseholdSl");

         VISITNO = IDbundle.getString("VisitNo");

         TableName = "Member";
         lblHeading = (TextView)findViewById(R.id.lblHeading);

//         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
//         cmdBack.setOnClickListener(new View.OnClickListener() {
//             public void onClick(View v) {
//                 AlertDialog.Builder adb = new AlertDialog.Builder(Member_list.this);
//                 adb.setTitle("Close");
//                 adb.setMessage("Do you want to close this form[Yes/No]?");
//                 adb.setNegativeButton("No", null);
//                 adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
//                     public void onClick(DialogInterface dialog, int which) {
//                         finish();
//                     }});
//                 adb.show();
//             }});

//         btnRefresh = (Button) findViewById(R.id.btnRefresh);
//         btnRefresh.setOnClickListener(new View.OnClickListener() {
//
//             public void onClick(View view) {
//                   //write your code here
//                   DataSearch_member(UNCODE, STRUCTURENO, HOUSEHOLDSL, VISITNO);
//
//             }});

         btnAdd   = (Button) findViewById(R.id.btnAdd_member);
         btnAdd.setOnClickListener(new View.OnClickListener() {

             public void onClick(View view) {
                         Bundle IDbundle = new Bundle();
                         IDbundle.putString("UNCode", "");
                         IDbundle.putString("StructureNo", "");
                         IDbundle.putString("HouseholdSl", "");
                         IDbundle.putString("VisitNo", "");
                         IDbundle.putString("MemSl", "");
                         Intent intent = new Intent(getApplicationContext(), Member.class);
                         intent.putExtras(IDbundle);
                         startActivityForResult(intent, 1);

             }});


        recyclerView = (RecyclerView)findViewById(R.id.recycler_view_member);
        mAdapter = new DataAdapter_member(dataList);
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);


        DataSearch_member(UNCODE, STRUCTURENO, HOUSEHOLDSL, VISITNO);


     }
     catch(Exception  e)
     {
         Connection.MessageBox(Member_list.this, e.getMessage());
         return;
     }
 }
 
 @Override
 protected void onActivityResult(int requestCode, int resultCode, Intent data) {
     super.onActivityResult(requestCode, resultCode, data);
     if (resultCode == Activity.RESULT_CANCELED) {
         //Write your code if there's no result
     } else {
         DataSearch_member(UNCODE, STRUCTURENO, HOUSEHOLDSL, VISITNO);
     }
 }

 public void DataSearch_member(String UNCode, String StructureNo, String HouseholdSl, String VisitNo)
     {
       try
        {
     
           Member_DataModel d = new Member_DataModel();
//             String SQL = "Select * from "+ TableName +"  Where UNCode='"+ UNCode +"' and StructureNo='"+ StructureNo +"' and HouseholdSl='"+ HouseholdSl +"' and VisitNo='"+ VisitNo +"'";
             String SQL = "Select m.*,ifnull(cfs.status,'') status from member m\n" +
                     "left outer join Child_Final_Status cfs on m.uncode=cfs .uncode and m.StructureNo=cfs .StructureNo and m.HouseholdSl=cfs .HouseholdSl and m.HouseholdSl=cfs .HouseholdSl and m.VisitNo=cfs .VisitNo and m.MemSl=cfs .MemSl\n" +
                     "where m.uncode='"+UNCode+"' and m.StructureNo='"+STRUCTURENO+"' and m.HouseholdSl='"+HOUSEHOLDSL+"' and m.VisitNo='"+VISITNO+"'";
             List<Member_DataModel> data = d.SelectAll_List(this, SQL);
             dataList.clear();

             dataList.addAll(data);
             try {
                 mAdapter.notifyDataSetChanged();
             }catch ( Exception ex){
                 Connection.MessageBox(Member_list.this,ex.getMessage());
             }
        }
        catch(Exception  e)
        {
            Connection.MessageBox(Member_list.this, e.getMessage());
            return;
        }
     }


     public class DataAdapter_member extends RecyclerView.Adapter<DataAdapter_member.MyViewHolder> {
         public List<Member_DataModel> dataList;
         public class MyViewHolder extends RecyclerView.ViewHolder {
         LinearLayout secListRow;
         TextView UNCode;
         TextView StructureNo;
         TextView HouseholdSl;
         TextView VisitNo;
         TextView MemSl;
         TextView Name;
         TextView Sex;
         TextView DOB;
         TextView DOBDk;
         TextView Age;
         TextView AgeU;
         TextView Relation;
         TextView OthRelation;
         TextView PreStatus;
         TextView DtofDeath;
         TextView DAge;
         TextView DAgeU;
         TextView LiveInHouse;

         Button btnChildForm;
         public MyViewHolder(View convertView) {
             super(convertView);
             secListRow = (LinearLayout)convertView.findViewById(R.id.secListRow);
//             UNCode = (TextView)convertView.findViewById(R.id.UNCode);
//             StructureNo = (TextView)convertView.findViewById(R.id.StructureNo);
//             HouseholdSl = (TextView)convertView.findViewById(R.id.HouseholdSl);
//             VisitNo = (TextView)convertView.findViewById(R.id.VisitNo);
             MemSl = (TextView)convertView.findViewById(R.id.MemSl);
             Name = (TextView)convertView.findViewById(R.id.Name);
             Sex = (TextView)convertView.findViewById(R.id.Sex);
             DOB = (TextView)convertView.findViewById(R.id.DOB);
//             DOBDk = (TextView)convertView.findViewById(R.id.DOBDk);
             Age = (TextView)convertView.findViewById(R.id.Age);
             btnChildForm = (Button) convertView.findViewById(R.id.btnChildForm);
//             AgeU = (TextView)convertView.findViewById(R.id.AgeU);
//             Relation = (TextView)convertView.findViewById(R.id.Relation);
//             OthRelation = (TextView)convertView.findViewById(R.id.OthRelation);
//             PreStatus = (TextView)convertView.findViewById(R.id.PreStatus);
//             DtofDeath = (TextView)convertView.findViewById(R.id.DtofDeath);
//             DAge = (TextView)convertView.findViewById(R.id.DAge);
//             DAgeU = (TextView)convertView.findViewById(R.id.DAgeU);
//             LiveInHouse = (TextView)convertView.findViewById(R.id.LiveInHouse);
             }
         }
         public DataAdapter_member(List<Member_DataModel> datalist) {
             this.dataList = datalist;
         }
         @Override
         public DataAdapter_member.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
             View itemView = LayoutInflater.from(parent.getContext())
                     .inflate(R.layout.member_row, parent, false);
             return new DataAdapter_member.MyViewHolder(itemView);
         }
         @Override
         public void onBindViewHolder(DataAdapter_member.MyViewHolder holder, int position) {
             final Member_DataModel data = dataList.get(position);
//             holder.UNCode.setText(data.getUNCode());
//             holder.StructureNo.setText(data.getStructureNo());
//             holder.HouseholdSl.setText(data.getHouseholdSl());
//             holder.VisitNo.setText(data.getVisitNo());
             holder.MemSl.setText(""+data.getMemSl());
             holder.Name.setText(data.getName());
             holder.Sex.setText(""+data.getSex());
             holder.DOB.setText(Global.DateConvertDMY(data.getDOB()));
//             holder.DOBDk.setText(""+data.getDOBDk());
//             holder.Age.setText(""+data.getAge());
//             holder.AgeU.setText(""+data.getAgeU());
//             holder.Relation.setText(""+data.getRelation());
//             holder.OthRelation.setText(data.getOthRelation());
//             holder.PreStatus.setText(""+data.getPreStatus());
//             holder.DtofDeath.setText(data.getDtofDeath());
//             holder.DAge.setText(""+data.getDAge());
//             holder.DAgeU.setText(""+data.getDAgeU());
//             holder.LiveInHouse.setText(""+data.getLiveInHouse());

             if(data.getAge()<=60)
             {
                 holder.Age.setText(""+data.getAge()+" days");
                 holder.btnChildForm.setVisibility(View.VISIBLE);
             }
             else if(data.getAge()>=61 & data.getAge()<1826 )
             {
                 int age=(int) (data.getAge()/30.4);
                 holder.Age.setText(""+age+" months");
                 holder.btnChildForm.setVisibility(View.VISIBLE);
             }
             else if(data.getAge()>=1826 & data.getAge()<6574 )
             {
                 int age=(int) (data.getAge()/365.25);
                 holder.Age.setText(""+age+" years");
                 holder.btnChildForm.setVisibility(View.VISIBLE);
             }
             else{
                 int age=(int) (data.getAge()/365.25);
                 holder.Age.setText(""+age+" years");
                 holder.btnChildForm.setVisibility(View.INVISIBLE);
             }

             if(data.get_FinalStatus().equals("1"))
             {
                 holder.btnChildForm.setBackgroundResource(R.drawable.button_style_circle_green);
             }else if(data.get_FinalStatus().equals("2"))
             {
                 holder.btnChildForm.setBackgroundResource(R.drawable.button_style_circle_yellow);
             }else
             {
                 holder.btnChildForm.setBackgroundResource(R.drawable.button_style_circle_red);
             }

             holder.btnChildForm.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     final ProgressDialog progDailog = ProgressDialog.show(Member_list.this, "", "Please Wait . . .", true);
                     new Thread() {
                         public void run() {
                             try {
                                 Bundle IDbundle = new Bundle();
                                 IDbundle.putString("UNCode", data.getUNCode());
                                 IDbundle.putString("StructureNo", data.getStructureNo());
                                 IDbundle.putString("HouseholdSl", data.getHouseholdSl());
                                 IDbundle.putString("VisitNo", data.getVisitNo());
                                 IDbundle.putString("MemSl",""+data.getMemSl());
                                 IDbundle.putString("Age",""+data.getAge());
                                 IDbundle.putString("Name",""+data.getName());
                                 Intent f1 = new Intent(getApplicationContext(), ChildForm_Menu.class);
                                 f1.putExtras(IDbundle);
                                 startActivityForResult(f1,1);
                             }
                             catch (Exception e) {
                             }
                             progDailog.dismiss();
                         }
                     }.start();
                 }
             });

             holder.secListRow.setOnClickListener(new View.OnClickListener() {
                 public void onClick(View v) {
                     final ProgressDialog progDailog = ProgressDialog.show(Member_list.this, "", "Please Wait . . .", true);
                     new Thread() {
                         public void run() {
                             try {
                                 Bundle IDbundle = new Bundle();
                                 IDbundle.putString("UNCode", data.getUNCode());
                                 IDbundle.putString("StructureNo", data.getStructureNo());
                                 IDbundle.putString("HouseholdSl", data.getHouseholdSl());
                                 IDbundle.putString("VisitNo", data.getVisitNo());
                                 IDbundle.putString("MemSl",""+data.getMemSl());
                                 Intent f1 = new Intent(getApplicationContext(), Member.class);
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