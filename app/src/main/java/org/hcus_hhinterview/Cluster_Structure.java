package org.hcus_hhinterview;


 //Android Manifest Code
 //<activity android:name=".Cluster_Structure" android:label="Cluster_Structure" />
 import java.text.ParseException;
 import java.text.SimpleDateFormat;
 import java.util.ArrayList;
 import java.util.Calendar;
 import java.util.Date;
 import java.util.HashMap;
 import java.util.List;
 import android.app.*;
 import android.app.AlertDialog;
 import android.app.DatePickerDialog;
 import android.app.Dialog;
 import android.app.TimePickerDialog;
 import android.content.Context;
 import android.content.DialogInterface;
 import android.content.Intent;
 import android.database.Cursor;
 import android.location.Location;
 import android.location.LocationListener;
 import android.location.LocationManager;
 import android.net.Uri;
 import android.provider.Settings;
 import android.text.TextUtils;
 import android.view.KeyEvent;
 import android.os.Bundle;
 import android.view.Menu;
 import android.view.MenuInflater;
 import android.view.MenuItem;
 import android.view.View;
 import android.view.MotionEvent;
 import android.view.View.OnFocusChangeListener;
 import android.view.ViewGroup;
 import android.view.LayoutInflater;
 import android.widget.AdapterView;
 import android.widget.Button;
 import android.widget.CheckBox;
 import android.widget.DatePicker;
 import android.widget.EditText;
 import android.widget.ImageButton;
 import android.widget.LinearLayout;
 import android.widget.NumberPicker;
 import android.widget.RadioButton;
 import android.widget.RadioGroup;
 import android.widget.ListView;
 import android.widget.SimpleAdapter;
 import android.widget.BaseAdapter;
 import android.widget.Spinner;
 import android.widget.TextView;
 import android.widget.TimePicker;
 import android.widget.ArrayAdapter;
 import android.widget.CompoundButton;
 import android.graphics.Color;
 import android.view.WindowManager;
 import Utility.*;
 import Common.*;
 import data_model.Cluster_Structure_DataModel;

 public class Cluster_Structure extends Activity {
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
    private int hour;
    private int minute;
     public int PREV;
     public int MAIN;

    private int mDay;
    private int mMonth;
    private int mYear;
    public int previous;
    static final int DATE_DIALOG = 1;
    static final int TIME_DIALOG = 2;

    Connection C;
    Global g;
    SimpleAdapter dataAdapter;
    ArrayList<HashMap<String, String>> dataList = new ArrayList<HashMap<String, String>>();
         TextView lblHeading;
         LinearLayout secUpazila;
         View lineUpazila;
         TextView VlblUpazila;
         EditText txtUpazila;
         LinearLayout secUNCode;
         View lineUNCode;
         TextView VlblUNCode;
         EditText txtUNCode;
         LinearLayout secCluster;
         View lineCluster;
         TextView VlblCluster;
         EditText txtCluster;
         LinearLayout secStructureNo;
         View lineStructureNo;
         TextView VlblStructureNo;
         EditText txtStructureNo;
         LinearLayout secVisitNo;
         View lineVisitNo;
         TextView VlblVisitNo;
         EditText txtVisitNo;
         LinearLayout secVisitOutcome;
         View lineVisitOutcome;
         TextView VlblVisitOutcome;
         Spinner spnVisitOutcome;
         LinearLayout secVisitOutcomeOth;
         View lineVisitOutcomeOth;
         TextView VlblVisitOutcomeOth;
         EditText txtVisitOutcomeOth;
         LinearLayout secReasonInVisit;
         View lineReasonInVisit;
         TextView VlblReasonInVisit;
         Spinner spnReasonInVisit;
         LinearLayout secReasonInVisitOth;
         View lineReasonInVisitOth;
         TextView VlblReasonInVisitOth;
         EditText txtReasonInVisitOth;
         LinearLayout secTotalHH;
         View lineTotalHH;
         TextView VlblTotalHH;
         EditText txtTotalHH;
     Button prev;
     Button next;

         TextView txtUpazila_Name,txtUnion_Name;

    static String TableName;

    static String STARTTIME = "";
    static String DEVICEID  = "";
    static String ENTRYUSER = "";
    MySharedPreferences sp;

    Bundle IDbundle;
    static String UPAZILA = "";
    static String UNCODE = "";
    static String CLUSTER = "";
    static String STRUCTURENO = "";
    static String VISITNO = "";


     static String UPAZILA_NAME = "";
     static String UNION_NAME = "";

 public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
   try
     {
         setContentView(R.layout.cluster_structure);
         getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

         C = new Connection(this);
         g = Global.getInstance();

         STARTTIME = g.CurrentTime24();
         DEVICEID  = sp.getValue(this, "deviceid");
         ENTRYUSER = sp.getValue(this, "userid");

         IDbundle = getIntent().getExtras();
         UPAZILA = IDbundle.getString("Upazila");
         UNCODE = IDbundle.getString("UNCode");
         CLUSTER = IDbundle.getString("Cluster");
         STRUCTURENO = IDbundle.getString("StructureNo");
         UPAZILA_NAME = IDbundle.getString("Upazila_Name");
         UNION_NAME = IDbundle.getString("Union_Name");
         VISITNO = IDbundle.getString("VisitNo");



         TableName = "Cluster_Structure";

//         if(TextUtils.isEmpty(VISITNO))
//         {
//              VISITNO=C.ReturnSingleValue("Select (ifnull(max(cast(VisitNo as int)),0)+1)VisitNo from Cluster_Structure where Upazila='"+UPAZILA+"' and UNCode='"+UNCODE+"' and Cluster='"+CLUSTER+"' and StructureNo='"+STRUCTURENO+"'");
// }

         //turnGPSOn();

         //GPS Location
         //FindLocation();
         // Double.toString(currentLatitude);
         // Double.toString(currentLongitude);
         lblHeading = (TextView)findViewById(R.id.lblHeading);

         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(Cluster_Structure.this);
                 adb.setTitle("Close");
                 adb.setMessage("Do you want to close this form[Yes/No]?");
                 adb.setNegativeButton("No", null);
                 adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                     public void onClick(DialogInterface dialog, int which) {
                         finish();
                     }});
                 adb.show();
             }});

         txtUpazila_Name=findViewById(R.id.txtUpazila_Name);
         txtUnion_Name=findViewById(R.id.txtUnion_Name);

         secUpazila=(LinearLayout)findViewById(R.id.secUpazila);
         lineUpazila=(View)findViewById(R.id.lineUpazila);
         VlblUpazila=(TextView) findViewById(R.id.VlblUpazila);
         txtUpazila=(EditText) findViewById(R.id.txtUpazila);
         secUNCode=(LinearLayout)findViewById(R.id.secUNCode);
         lineUNCode=(View)findViewById(R.id.lineUNCode);
         VlblUNCode=(TextView) findViewById(R.id.VlblUNCode);
         txtUNCode=(EditText) findViewById(R.id.txtUNCode);
         secCluster=(LinearLayout)findViewById(R.id.secCluster);
         lineCluster=(View)findViewById(R.id.lineCluster);
         VlblCluster=(TextView) findViewById(R.id.VlblCluster);
         txtCluster=(EditText) findViewById(R.id.txtCluster);
         secStructureNo=(LinearLayout)findViewById(R.id.secStructureNo);
         lineStructureNo=(View)findViewById(R.id.lineStructureNo);
         VlblStructureNo=(TextView) findViewById(R.id.VlblStructureNo);
         txtStructureNo=(EditText) findViewById(R.id.txtStructureNo);
         secVisitNo=(LinearLayout)findViewById(R.id.secVisitNo);
         lineVisitNo=(View)findViewById(R.id.lineVisitNo);
         VlblVisitNo=(TextView) findViewById(R.id.VlblVisitNo);
         txtVisitNo=(EditText) findViewById(R.id.txtVisitNo);
         secVisitOutcome=(LinearLayout)findViewById(R.id.secVisitOutcome);
         lineVisitOutcome=(View)findViewById(R.id.lineVisitOutcome);
         VlblVisitOutcome=(TextView) findViewById(R.id.VlblVisitOutcome);

         secVisitOutcomeOth=(LinearLayout)findViewById(R.id.secVisitOutcomeOth);
         lineVisitOutcomeOth=(View)findViewById(R.id.lineVisitOutcomeOth);
         VlblVisitOutcomeOth=(TextView) findViewById(R.id.VlblVisitOutcomeOth);
         txtVisitOutcomeOth=(EditText) findViewById(R.id.txtVisitOutcomeOth);
         secReasonInVisit=(LinearLayout)findViewById(R.id.secReasonInVisit);
         lineReasonInVisit=(View)findViewById(R.id.lineReasonInVisit);
         VlblReasonInVisit=(TextView) findViewById(R.id.VlblReasonInVisit);
         spnReasonInVisit=(Spinner) findViewById(R.id.spnReasonInVisit);

         secReasonInVisitOth=(LinearLayout)findViewById(R.id.secReasonInVisitOth);
         lineReasonInVisitOth=(View)findViewById(R.id.lineReasonInVisitOth);
         VlblReasonInVisitOth=(TextView) findViewById(R.id.VlblReasonInVisitOth);
         txtReasonInVisitOth=(EditText) findViewById(R.id.txtReasonInVisitOth);
         secTotalHH=(LinearLayout)findViewById(R.id.secTotalHH);
         lineTotalHH=(View)findViewById(R.id.lineTotalHH);
         VlblTotalHH=(TextView) findViewById(R.id.VlblTotalHH);
         txtTotalHH=(EditText) findViewById(R.id.txtTotalHH);
         spnVisitOutcome=(Spinner) findViewById(R.id.spnVisitOutcome);



         List<String> listVisitOutcome = new ArrayList<String>();
         
         listVisitOutcome.add("");
         listVisitOutcome.add("1-Complete");
         listVisitOutcome.add("2-Incomplete");
         listVisitOutcome.add("3-Complete Refusal");
         listVisitOutcome.add("4-Vacant");
//         listVisitOutcome.add("5-Demolished");
         listVisitOutcome.add("6-Under construction");
         listVisitOutcome.add("7-Partial refusal");
//         listVisitOutcome.add("8-Merged with other structure");
//         listVisitOutcome.add("9-Does not exist");
         listVisitOutcome.add("10-Ongoing");
         listVisitOutcome.add("77-Other ");

         ArrayAdapter<String> adptrVisitOutcome= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listVisitOutcome);
         spnVisitOutcome.setAdapter(adptrVisitOutcome);

         spnVisitOutcome.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnVisitOutcome.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnVisitOutcome.getSelectedItem().toString(), "-");
             }

                 if(spnData.equalsIgnoreCase("2") )
                 {
                     secReasonInVisit.setVisibility(View.VISIBLE);
                     lineReasonInVisit.setVisibility(View.VISIBLE);
//                     spnReasonInVisit.setSelection(0);
                     secTotalHH.setVisibility(View.GONE);
                     lineTotalHH.setVisibility(View.GONE);
                     txtTotalHH.setText("");

                 }

                 else if(spnData.equalsIgnoreCase("77") )
                 {
                     secVisitOutcomeOth.setVisibility(View.VISIBLE);
                     lineVisitOutcomeOth.setVisibility(View.VISIBLE);
                     secTotalHH.setVisibility(View.GONE);
                     lineTotalHH.setVisibility(View.GONE);
                     txtTotalHH.setText("");

                 }
                 else if(spnData.equalsIgnoreCase("1") | spnData.equalsIgnoreCase("7") | spnData.equalsIgnoreCase("10"))
                 {
                    secVisitOutcomeOth.setVisibility(View.GONE);
                    lineVisitOutcomeOth.setVisibility(View.GONE);
                    txtVisitOutcomeOth.setText("");
                    secReasonInVisit.setVisibility(View.GONE);
                    lineReasonInVisit.setVisibility(View.GONE);
//                    spnReasonInVisit.setSelection(0);
                    secReasonInVisitOth.setVisibility(View.GONE);
                    lineReasonInVisitOth.setVisibility(View.GONE);
                    txtReasonInVisitOth.setText("");
                    secTotalHH.setVisibility(View.VISIBLE);
                    lineTotalHH.setVisibility(View.VISIBLE);


                 }


                 else
                 {
                    secVisitOutcomeOth.setVisibility(View.GONE);
                    lineVisitOutcomeOth.setVisibility(View.GONE);
                    secReasonInVisit.setVisibility(View.GONE);
                    lineReasonInVisit.setVisibility(View.GONE);
                    secReasonInVisitOth.setVisibility(View.GONE);
                    lineReasonInVisitOth.setVisibility(View.GONE);
                    secTotalHH.setVisibility(View.GONE);
                    lineTotalHH.setVisibility(View.GONE);
                    txtTotalHH.setText("");

                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });


         MAIN=Integer.parseInt(VISITNO);
         PREV=Integer.parseInt(VISITNO);
//         DataSearch(UPAZILA,UNCODE,CLUSTER,STRUCTURENO,PREV-1);
//
         prev   = (Button) findViewById(R.id.prev);
         prev.setOnClickListener(new View.OnClickListener() {

             public void onClick(View view) {

                 if(PREV>1){
                     PREV=PREV-1;
                     txtVisitNo.setText(""+PREV);
                     DataSearch(UPAZILA,UNCODE,CLUSTER,STRUCTURENO,PREV);
                 }


             }});

         next   = (Button) findViewById(R.id.next);
         next.setOnClickListener(new View.OnClickListener() {

             public void onClick(View view) {

                 if(PREV<MAIN){
                     PREV=PREV+1;
                     txtVisitNo.setText(""+PREV);
                     DataSearch(UPAZILA,UNCODE,CLUSTER,STRUCTURENO,PREV);

                 }




             }});




         List<String> listReasonInVisit = new ArrayList<String>();
         
         listReasonInVisit.add("");
         listReasonInVisit.add("1-Could not enter into the structure");
         listReasonInVisit.add("2-Absent/Locked/Nobody was present");
         listReasonInVisit.add("3- Vacant");
         listReasonInVisit.add("4-Did not open gate/door");
         listReasonInVisit.add("5-Waiting for the permission for data collection at that house");
         listReasonInVisit.add("7-Other");

         ArrayAdapter<String> adptrReasonInVisit= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listReasonInVisit);
         spnReasonInVisit.setAdapter(adptrReasonInVisit);

         spnReasonInVisit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                 String spnData = "";
                 if (spnVisitOutcome.getSelectedItem().toString().length() != 0)
                 {
                     spnData = Connection.SelectedSpinnerValue(spnReasonInVisit.getSelectedItem().toString(), "-");
                 }

                 if(spnData.equalsIgnoreCase("7") )
                 {
                     secReasonInVisitOth.setVisibility(View.VISIBLE);
                     lineReasonInVisitOth.setVisibility(View.VISIBLE);
                 }
                 else
                 {
                     secReasonInVisitOth.setVisibility(View.GONE);
                     lineReasonInVisitOth.setVisibility(View.GONE);
                 }
             }

             @Override
             public void onNothingSelected(AdapterView<?> adapterView) {

             }
         });






         //Hide all skip variables
         secVisitOutcomeOth.setVisibility(View.GONE);
         lineVisitOutcomeOth.setVisibility(View.GONE);
         secReasonInVisit.setVisibility(View.GONE);
         lineReasonInVisit.setVisibility(View.GONE);
         secReasonInVisitOth.setVisibility(View.GONE);
         lineReasonInVisitOth.setVisibility(View.GONE);
         secVisitOutcomeOth.setVisibility(View.GONE);
         lineVisitOutcomeOth.setVisibility(View.GONE);
         secReasonInVisit.setVisibility(View.GONE);
         lineReasonInVisit.setVisibility(View.GONE);
         secReasonInVisitOth.setVisibility(View.GONE);
         lineReasonInVisitOth.setVisibility(View.GONE);
         secVisitOutcomeOth.setVisibility(View.GONE);
         lineVisitOutcomeOth.setVisibility(View.GONE);
         secReasonInVisit.setVisibility(View.GONE);
         lineReasonInVisit.setVisibility(View.GONE);
         secReasonInVisitOth.setVisibility(View.GONE);
         lineReasonInVisitOth.setVisibility(View.GONE);

         txtUpazila.setText(UPAZILA);
         txtUNCode.setText(UNCODE);
         txtCluster.setText(CLUSTER);
         txtStructureNo.setText(STRUCTURENO);
         txtVisitNo.setText(VISITNO);

         txtUpazila_Name.setText(UPAZILA_NAME);
         txtUnion_Name.setText(UNION_NAME);

         DataSearch(UPAZILA,UNCODE,CLUSTER,STRUCTURENO,PREV);

        Button cmdSave = (Button) findViewById(R.id.cmdSave);
        cmdSave.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) { 
            DataSave();
        }});
     }
     catch(Exception  e)
     {
         Connection.MessageBox(Cluster_Structure.this, e.getMessage());
         return;
     }
 }

//     private String VisitNo()
//     {
//         String visit = C.ReturnSingleValue("Select (ifnull(max(cast(VisitNo as int)),0)+1)VisitNo from Cluster_Structure where Upazila='"+UPAZILA+"' and UNCode='"+UNCODE+"' and Cluster='"+CLUSTER+"' and StructureNo='"+STRUCTURENO+"'");
//
//         return visit;
//     }





 private void DataSave()
 {
   try
     {
 
         String DV="";

         if(txtUpazila.getText().toString().length()==0 & secUpazila.isShown())
           {
             Connection.MessageBox(Cluster_Structure.this, "Required field: Upazila.");
             txtUpazila.requestFocus(); 
             return;	
           }
         else if(txtUNCode.getText().toString().length()==0 & secUNCode.isShown())
           {
             Connection.MessageBox(Cluster_Structure.this, "Required field: Ward No.");
             txtUNCode.requestFocus(); 
             return;	
           }
         else if(txtCluster.getText().toString().length()==0 & secCluster.isShown())
           {
             Connection.MessageBox(Cluster_Structure.this, "Required field: Cluster.");
             txtCluster.requestFocus(); 
             return;	
           }
         else if(txtStructureNo.getText().toString().length()==0 & secStructureNo.isShown())
           {
             Connection.MessageBox(Cluster_Structure.this, "Required field: Structure No.");
             txtStructureNo.requestFocus(); 
             return;	
           }
         else if(txtVisitNo.getText().toString().length()==0 & secVisitNo.isShown())
           {
             Connection.MessageBox(Cluster_Structure.this, "Required field: Structure Visit No.");
             txtVisitNo.requestFocus(); 
             return;	
           }
         else if(spnVisitOutcome.getSelectedItemPosition()==0  & secVisitOutcome.isShown())
           {
             Connection.MessageBox(Cluster_Structure.this, "Required field: Outcome of Structure Visit.");
             spnVisitOutcome.requestFocus(); 
             return;	
           }
         else if(txtVisitOutcomeOth.getText().toString().length()==0 & secVisitOutcomeOth.isShown())
           {
             Connection.MessageBox(Cluster_Structure.this, "Required field: Other specify.");
             txtVisitOutcomeOth.requestFocus(); 
             return;	
           }
         else if(spnReasonInVisit.getSelectedItemPosition()==0  & secReasonInVisit.isShown())
           {
             Connection.MessageBox(Cluster_Structure.this, "Required field: Reason of incomplete structure visit.");
             spnReasonInVisit.requestFocus(); 
             return;	
           }
         else if(txtReasonInVisitOth.getText().toString().length()==0 & secReasonInVisitOth.isShown())
           {
             Connection.MessageBox(Cluster_Structure.this, "Required field: Other Specify.");
             txtReasonInVisitOth.requestFocus(); 
             return;	
           }
         else if(txtTotalHH.getText().toString().length()==0 & secTotalHH.isShown())
           {
             Connection.MessageBox(Cluster_Structure.this, "Required field: Total Number of Household.");
             txtTotalHH.requestFocus(); 
             return;	
           }
 
         String SQL = "";
         RadioButton rb;

         Cluster_Structure_DataModel objSave = new Cluster_Structure_DataModel();
         objSave.setUpazila(txtUpazila.getText().toString());
         objSave.setUNCode(txtUNCode.getText().toString());
         objSave.setCluster(txtCluster.getText().toString());
         objSave.setStructureNo(txtStructureNo.getText().toString());
         objSave.setVisitNo(txtVisitNo.getText().toString());
         objSave.setVisitOutcome(Integer.valueOf(spnVisitOutcome.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnVisitOutcome.getSelectedItem().toString(), "-")));
         objSave.setVisitOutcomeOth(txtVisitOutcomeOth.getText().toString());
         objSave.setReasonInVisit(Integer.valueOf(spnReasonInVisit.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnReasonInVisit.getSelectedItem().toString(), "-")));
         objSave.setReasonInVisitOth(txtReasonInVisitOth.getText().toString());
         objSave.setTotalHH(txtTotalHH.getText().toString());
         objSave.setEnDt(Global.DateTimeNowYMDHMS());
         objSave.setStartTime(STARTTIME);
         objSave.setEndTime(g.CurrentTime24());
         objSave.setDeviceID(DEVICEID);
         objSave.setEntryUser(ENTRYUSER); //from data entry user list
         objSave.setmodifyDate(Global.DateTimeNowYMDHMS());
         //objSave.setLat(Double.toString(currentLatitude));
         //objSave.setLon(Double.toString(currentLongitude));

         String status = objSave.SaveUpdateData(this);

         //********** Update Structure Listing *************

         int visit=Integer.valueOf(spnVisitOutcome.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnVisitOutcome.getSelectedItem().toString(), "-"));

         String response=C.SaveData("Update StructureListing set Visit_Status='"+visit+"' , Visit_No='"+txtVisitNo.getText().toString()+"' where Upazila='"+txtUpazila.getText().toString()+"'" +
                 " and UNCode='"+txtUNCode.getText().toString()+"' and Cluster='"+txtCluster.getText().toString()+"' and StructureNo='"+txtStructureNo.getText().toString()+"'");




         if(status.length()==0) {
             Intent returnIntent = new Intent();
             returnIntent.putExtra("res", "");
             setResult(Activity.RESULT_OK, returnIntent);

             Connection.MessageBox(Cluster_Structure.this, "Saved Successfully");
         }
         else{
             Connection.MessageBox(Cluster_Structure.this, status);
             return;
         }
     }
     catch(Exception  e)
     {
         Connection.MessageBox(Cluster_Structure.this, e.getMessage());
         return;
     }
 }

 private void DataSearch(String Upazila, String UNCode, String Cluster, String StructureNo, Integer PREV)
     {
       try
        {
           RadioButton rb;
           Cluster_Structure_DataModel d = new Cluster_Structure_DataModel();
           String SQL = "Select * from "+ TableName +"  Where Upazila='"+ Upazila +"' and UNCode='"+ UNCode +"' and Cluster='"+ Cluster +"' and StructureNo='"+ StructureNo +"' and VisitNo='"+ PREV +"'";
           List<Cluster_Structure_DataModel> data = d.SelectAll(this, SQL);

           if(data.size()==0)
           {
               txtUpazila.setText(Upazila);
               txtUNCode.setText(UNCode);
               txtCluster.setText(Cluster);
               txtStructureNo.setText(StructureNo);
               txtVisitNo.setText(""+PREV);
               spnVisitOutcome.setClickable(true);
               spnVisitOutcome.setSelection(0);
               txtVisitOutcomeOth.setText("");
               spnReasonInVisit.setSelection(0);
               txtReasonInVisitOth.setText("");
               txtTotalHH.setText("");
           }
           else
           {
               for(Cluster_Structure_DataModel item : data) {
                   txtUpazila.setText(Upazila);
                   txtUNCode.setText(UNCode);
                   txtCluster.setText(Cluster);
                   txtStructureNo.setText(StructureNo);
                   txtVisitNo.setText(""+PREV);
                   spnVisitOutcome.setSelection(Global.SpinnerItemPositionAnyLength(spnVisitOutcome, String.valueOf(item.getVisitOutcome())));
                          spnVisitOutcome.setClickable(false);
                   txtVisitOutcomeOth.setText(item.getVisitOutcomeOth());
                           txtVisitOutcomeOth.setEnabled(false);
                   spnReasonInVisit.setSelection(Global.SpinnerItemPositionAnyLength(spnReasonInVisit, String.valueOf(item.getReasonInVisit())));
                           spnReasonInVisit.setClickable(false);
                   txtReasonInVisitOth.setText(item.getReasonInVisitOth());
                           txtReasonInVisitOth.setEnabled(false);
                   txtTotalHH.setText(item.getTotalHH());
//                           txtTotalHH.setEnabled(false);
               }
           }
        }
        catch(Exception  e)
        {
            Connection.MessageBox(Cluster_Structure.this, e.getMessage());
            return;
        }
     }



 protected Dialog onCreateDialog(int id) {
   final Calendar c = Calendar.getInstance();
   hour = c.get(Calendar.HOUR_OF_DAY);
   minute = c.get(Calendar.MINUTE);
   switch (id) {
       case DATE_DIALOG:
           return new DatePickerDialog(this, mDateSetListener,g.mYear,g.mMonth-1,g.mDay);
       case TIME_DIALOG:
           return new TimePickerDialog(this, timePickerListener, hour, minute,false);
       }
     return null;
 }

 private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
      mYear = year; mMonth = monthOfYear+1; mDay = dayOfMonth;
      EditText dtpDate = null;


      dtpDate.setText(new StringBuilder()
      .append(Global.Right("00"+mDay,2)).append("/")
      .append(Global.Right("00"+mMonth,2)).append("/")
      .append(mYear));
      }
  };

 private TimePickerDialog.OnTimeSetListener timePickerListener = new TimePickerDialog.OnTimeSetListener() {
    public void onTimeSet(TimePicker view, int selectedHour, int selectedMinute) {
       hour = selectedHour; minute = selectedMinute;
       EditText tpTime = null;


          tpTime.setText(new StringBuilder().append(Global.Right("00"+hour,2)).append(":").append(Global.Right("00"+minute,2)));

    }
  };


 
 // turning off the GPS if its in on state. to avoid the battery drain.
 @Override
 protected void onDestroy() {
     // TODO Auto-generated method stub
     super.onDestroy();
 }
}