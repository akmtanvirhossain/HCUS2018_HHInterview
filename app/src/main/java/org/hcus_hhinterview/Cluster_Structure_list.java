package org.hcus_hhinterview;

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
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Common.Connection;
import Common.Global;
import DataSync.Log;
import data_model.StructureDB_DataModel;
import data_model.StructureListing_DataModel;

/**
 * Created by tasrul on 01-Aug-18.
 */

public class Cluster_Structure_list extends Activity {

    Connection C;
    Global g;
    private List<StructureListing_DataModel> dataList = new ArrayList<StructureListing_DataModel>();
    private RecyclerView recyclerView;
    private DataAdapter mAdapter;
    static String TableName;

    TextView lblHeading;
    Button btnAdd;
    Button btnRefresh;

    TextView tvUpazila,tvUnion,tvMoholla,tvCluster;
    Spinner spnUpazila,spnUnion,spnMoholla,spnCluster;

    TextView txtTotal,txtSearch;


    static String STARTTIME = "";
    static String UPAZILA = "";
    static String UNCODE = "";
    static String CLUSTER = "";
    static String MOHOLLA = "";

    static String UPAZILA_NAME = "";
    static String UNION_NAME = "";
    static String MOHOLLA_NAME = "";
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
            txtSearch= (TextView) findViewById(R.id.txtSearch);
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
                    UPAZILA= Connection.SelectedSpinnerValue(spnUpazila.getSelectedItem().toString(),"-");
                    UPAZILA_NAME=C.ReturnSingleValue("select distinct UpName from AreaDB where Upazila='"+UPAZILA+"'");
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
                    spnMoholla.setAdapter(C.getArrayAdapter("Select '  ' Union  Select distinct VCode ||'-'|| Vname from AreaDB where Upazila='"+ Connection.SelectedSpinnerValue(spnUpazila.getSelectedItem().toString(),"-")+"' and UNCode='"+ Connection.SelectedSpinnerValue(spnUnion.getSelectedItem().toString(),"-")+"' Union Select '777-Other'"));
                    spnCluster.setAdapter(C.getArrayAdapter("Select '  ' Union  Select distinct Cluster from StructureDB where Upazila='"+ Connection.SelectedSpinnerValue(spnUpazila.getSelectedItem().toString(),"-")+"' and UNCode='"+ Connection.SelectedSpinnerValue(spnUnion.getSelectedItem().toString(),"-")+"'"));
                    UNCODE= Connection.SelectedSpinnerValue(spnUnion.getSelectedItem().toString(),"-");
                    UNION_NAME=C.ReturnSingleValue("select distinct Uname from AreaDB where UNCode='"+UNCODE+"'");

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
                    CLUSTER= Connection.SelectedSpinnerValue(spnCluster.getSelectedItem().toString(),"-");
                    DataSearch(UPAZILA, UNCODE,CLUSTER);
                    txtTotal.setText("Total No: "+dataList.size());


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

            lblHeading = (TextView)findViewById(R.id.lblHeading);

            ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
            cmdBack.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    AlertDialog.Builder adb = new AlertDialog.Builder(Cluster_Structure_list.this);
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

            txtSearch.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(txtSearch.getText().toString().length()>0) {
                        DataSearch(UPAZILA, UNCODE, CLUSTER);

                    }
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });

//            btnAdd   = (Button) findViewById(R.id.btnAdd);
//            btnAdd.setOnClickListener(new View.OnClickListener() {
//
//                public void onClick(View view) {
//
//                    if(UPAZILA.equals("")||UNCODE.equals("")||MOHOLLA.equals("")||CLUSTER.equals("")) {
//                        Connection.MessageBox(Cluster_Structure_list.this,"You have to Select All the Option Above");
//                        return;
//                    }
//                    Bundle IDbundle = new Bundle();
//                    IDbundle.putString("Upazila", UPAZILA);
//                    IDbundle.putString("UNCode", UNCODE);
//                    IDbundle.putString("Moholla", MOHOLLA);
//                    IDbundle.putString("Cluster", CLUSTER);
//                    IDbundle.putString("StructureNo", "");
//                    IDbundle.putString("Upazila_Name", UPAZILA_NAME);
//                    IDbundle.putString("Union_Name", UNION_NAME);
//                    IDbundle.putString("Moholla_Name", MOHOLLA_NAME);
//                    IDbundle.putString("Mode", "New");
//                    Intent intent = new Intent(getApplicationContext(), StructureListing.class);
//                    intent.putExtras(IDbundle);
//                    startActivityForResult(intent, 1);
//
//                }});


            recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
            mAdapter = new Cluster_Structure_list.DataAdapter(dataList);
            recyclerView.setItemViewCacheSize(20);
            recyclerView.setDrawingCacheEnabled(true);
            recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
            recyclerView.setHasFixedSize(true);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.addItemDecoration(new Cluster_Structure_list.DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(mAdapter);


            DataSearch(UPAZILA, UNCODE,CLUSTER);


        }
        catch(Exception  e)
        {
            Connection.MessageBox(Cluster_Structure_list.this, e.getMessage());
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

            StructureListing_DataModel d = new StructureListing_DataModel();

            String SQL = "Select sd.* from StructureListing sd " +
                    "Where sd.Upazila='"+ Upazila +"' and sd.UNCode='"+ UNCode +"' and sd.Cluster='"+ Cluster +"' and sd.structureStatus=1";

            if(txtSearch.getText().toString().length()>0) {
                SQL += " and (";
                SQL += " sd.StructureNo like('"+ txtSearch.getText().toString() +"%')";
                SQL += " )";
            }

            List<StructureListing_DataModel> data = d.SelectAll(this, SQL);
            dataList.clear();

            dataList.addAll(data);
            try {
                mAdapter.notifyDataSetChanged();
                txtTotal.setText("Total Structure: " + dataList.size());
            }catch ( Exception ex){
                Connection.MessageBox(Cluster_Structure_list.this,ex.getMessage());
            }
        }
        catch(Exception  e)
        {
            Connection.MessageBox(Cluster_Structure_list.this, e.getMessage());
            return;
        }
    }


    public class DataAdapter extends RecyclerView.Adapter<Cluster_Structure_list.DataAdapter.MyViewHolder> {
        private List<StructureListing_DataModel> dataList;
        public class MyViewHolder extends RecyclerView.ViewHolder {
            LinearLayout secListRow;

            TextView SlNo;
            TextView StructureNo;
            Button btnVisit,btnHHInterview;

            public MyViewHolder(View convertView) {
                super(convertView);
                secListRow = (LinearLayout)convertView.findViewById(R.id.secListRow);

                StructureNo = (TextView)convertView.findViewById(R.id.StructureNo);
                SlNo = (TextView)convertView.findViewById(R.id.SlNo);

                btnVisit=convertView.findViewById(R.id.btnVisit);
                btnHHInterview=convertView.findViewById(R.id.btnHHInterview);

            }
        }
        public DataAdapter(List<StructureListing_DataModel> datalist) {
            this.dataList = datalist;
        }
        @Override
        public Cluster_Structure_list.DataAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.cluster_structure_list_row, parent, false);
            return new Cluster_Structure_list.DataAdapter.MyViewHolder(itemView);
        }
        @Override
        public void onBindViewHolder(Cluster_Structure_list.DataAdapter.MyViewHolder holder, int position) {
            final StructureListing_DataModel data = dataList.get(position);

            holder.StructureNo.setText(data.getStructureNo());
            holder.SlNo.setText(""+(position+1)+".");



            if(data.get_Visit_Status().equals("1"))
            {
                holder.btnVisit.setBackgroundResource(R.drawable.button_style_circle_green);
                holder.btnVisit.setTextColor(Color.WHITE);
            }

            holder.btnVisit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle IDbundle = new Bundle();

                    IDbundle.putString("Upazila", data.getUpazila());
                    IDbundle.putString("UNCode", data.getUNCode());
//                    IDbundle.putString("Moholla", MOHOLLA);
                    IDbundle.putString("Cluster", data.getCluster());
                    IDbundle.putString("StructureNo", data.getStructureNo());

                    IDbundle.putString("VisitNo", data.get_Visit_No());
                    IDbundle.putString("Upazila_Name", UPAZILA_NAME);
                    IDbundle.putString("Union_Name", UNION_NAME);
//                    IDbundle.putString("Moholla_Name", MOHOLLA_NAME);
//                    IDbundle.putString("Mode", "Edit");
                    Intent f1 = new Intent(getApplicationContext(), Cluster_Structure.class);
                    f1.putExtras(IDbundle);
                    startActivityForResult(f1,1);



                }
            });

            holder.btnHHInterview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle IDbundle = new Bundle();

                    IDbundle.putString("UNCode", data.getUNCode());
//                    IDbundle.putString("Cluster", data.getCluster());
                    IDbundle.putString("StructureNo", data.getStructureNo());
                    IDbundle.putString("Upazila_Name", UPAZILA_NAME);
                    IDbundle.putString("Union_Name", UNION_NAME);

                    Intent f1 = new Intent(getApplicationContext(), Household_Visit_list.class);
                    f1.putExtras(IDbundle);
                    startActivityForResult(f1,1);
                }
            });


//            holder.secListRow.setOnClickListener(new View.OnClickListener() {
//                public void onClick(View v) {
//                    final ProgressDialog progDailog = ProgressDialog.show(Cluster_Structure_list.this, "", "Please Wait . . .", true);
//                    new Thread() {
//                        public void run() {
//                            try {
//                                Bundle IDbundle = new Bundle();
//
//                                IDbundle.putString("Upazila", data.getUpazila());
//                                IDbundle.putString("UNCode", data.getUNCode());
//                                IDbundle.putString("Moholla", MOHOLLA);
//                                IDbundle.putString("Cluster", data.getCluster());
//                                IDbundle.putString("StructureNo", data.getStructureNo());
//                                IDbundle.putString("Upazila_Name", UPAZILA_NAME);
//                                IDbundle.putString("Union_Name", UNION_NAME);
//                                IDbundle.putString("Moholla_Name", MOHOLLA_NAME);
//                                IDbundle.putString("Mode", "Edit");
//                                Intent f1 = new Intent(getApplicationContext(), StructureListing.class);
//                                f1.putExtras(IDbundle);
//                                startActivityForResult(f1,1);
//                            } catch (Exception e) {
//                            }
//                            progDailog.dismiss();
//                        }
//                    }.start();
//                }
//            });
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
        private Cluster_Structure_list.RecyclerTouchListener.ClickListener clickListener;
        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final Cluster_Structure_list.RecyclerTouchListener.ClickListener clickListener) {
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
