
 package org.hcus_hhinterview;


 //Android Manifest Code
 //<activity android:name=".Admission_Refusal" android:label="Admission_Refusal" />
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
 import data_model.Admission_Refusal_DataModel;

 public class Admission_Refusal extends Activity {
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
    private int mDay;
    private int mMonth;
    private int mYear;
    static final int DATE_DIALOG = 1;
    static final int TIME_DIALOG = 2;

    Connection C;
    Global g;
    SimpleAdapter dataAdapter;
    ArrayList<HashMap<String, String>> dataList = new ArrayList<HashMap<String, String>>();
         TextView lblHeading;
         LinearLayout secUNCode;
         View lineUNCode;
         TextView VlblUNCode;
         EditText txtUNCode;
         LinearLayout secStructureNo;
         View lineStructureNo;
         TextView VlblStructureNo;
         EditText txtStructureNo;
         LinearLayout secHouseholdSl;
         View lineHouseholdSl;
         TextView VlblHouseholdSl;
         EditText txtHouseholdSl;
         LinearLayout secVisitNo;
         View lineVisitNo;
         TextView VlblVisitNo;
         EditText txtVisitNo;
         LinearLayout secMemSl;
         View lineMemSl;
         TextView VlblMemSl;
         EditText txtMemSl;
         LinearLayout secAdmRefDSH;
         View lineAdmRefDSH;
         TextView VlblAdmRefDSH;
         RadioGroup rdogrpAdmRefDSH;
         
         RadioButton rdoAdmRefDSH1;
         RadioButton rdoAdmRefDSH2;
         RadioButton rdoAdmRefDSH3;
         LinearLayout secAdmRefWhyDSH;
         View lineAdmRefWhyDSH;
         TextView VlblAdmRefWhyDSH;
         EditText txtAdmRefWhyDSH;
         LinearLayout secNotGetAdm;
         View lineNotGetAdm;
         TextView VlblNotGetAdm;
         RadioGroup rdogrpNotGetAdm;
         
         RadioButton rdoNotGetAdm1;
         RadioButton rdoNotGetAdm2;
         RadioButton rdoNotGetAdm3;

         TextView txtMemName;

    static String TableName;

    static String STARTTIME = "";
    static String DEVICEID  = "";
    static String ENTRYUSER = "";
    MySharedPreferences sp;

    Bundle IDbundle;
    static String UNCODE = "";
    static String STRUCTURENO = "";
    static String HOUSEHOLDSL = "";
    static String VISITNO = "";
    static String MEMSL = "";
    static String MEMNAME = "";

 public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
   try
     {
         setContentView(R.layout.admission_refusal);
         getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

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
         MEMNAME = IDbundle.getString("Name");



         TableName = "Admission_Refusal";

         //turnGPSOn();

         //GPS Location
         //FindLocation();
         // Double.toString(currentLatitude);
         // Double.toString(currentLongitude);
         lblHeading = (TextView)findViewById(R.id.lblHeading);

         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(Admission_Refusal.this);
                 adb.setTitle("Close");
                 adb.setMessage("Do you want to close this form[Yes/No]?");
                 adb.setNegativeButton("No", null);
                 adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                     public void onClick(DialogInterface dialog, int which) {
                         finish();
                     }});
                 adb.show();
             }});

         txtMemName=findViewById(R.id.txtMemName);

         secUNCode=(LinearLayout)findViewById(R.id.secUNCode);
         lineUNCode=(View)findViewById(R.id.lineUNCode);
         VlblUNCode=(TextView) findViewById(R.id.VlblUNCode);
         txtUNCode=(EditText) findViewById(R.id.txtUNCode);
         secStructureNo=(LinearLayout)findViewById(R.id.secStructureNo);
         lineStructureNo=(View)findViewById(R.id.lineStructureNo);
         VlblStructureNo=(TextView) findViewById(R.id.VlblStructureNo);
         txtStructureNo=(EditText) findViewById(R.id.txtStructureNo);
         secHouseholdSl=(LinearLayout)findViewById(R.id.secHouseholdSl);
         lineHouseholdSl=(View)findViewById(R.id.lineHouseholdSl);
         VlblHouseholdSl=(TextView) findViewById(R.id.VlblHouseholdSl);
         txtHouseholdSl=(EditText) findViewById(R.id.txtHouseholdSl);
         secVisitNo=(LinearLayout)findViewById(R.id.secVisitNo);
         lineVisitNo=(View)findViewById(R.id.lineVisitNo);
         VlblVisitNo=(TextView) findViewById(R.id.VlblVisitNo);
         txtVisitNo=(EditText) findViewById(R.id.txtVisitNo);
         secMemSl=(LinearLayout)findViewById(R.id.secMemSl);
         lineMemSl=(View)findViewById(R.id.lineMemSl);
         VlblMemSl=(TextView) findViewById(R.id.VlblMemSl);
         txtMemSl=(EditText) findViewById(R.id.txtMemSl);
         secAdmRefDSH=(LinearLayout)findViewById(R.id.secAdmRefDSH);
         lineAdmRefDSH=(View)findViewById(R.id.lineAdmRefDSH);
         VlblAdmRefDSH = (TextView) findViewById(R.id.VlblAdmRefDSH);
         rdogrpAdmRefDSH = (RadioGroup) findViewById(R.id.rdogrpAdmRefDSH);
         
         rdoAdmRefDSH1 = (RadioButton) findViewById(R.id.rdoAdmRefDSH1);
         rdoAdmRefDSH2 = (RadioButton) findViewById(R.id.rdoAdmRefDSH2);
         rdoAdmRefDSH3 = (RadioButton) findViewById(R.id.rdoAdmRefDSH3);
         rdogrpAdmRefDSH.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpAdmRefDSH = new String[] {"1","2","8"};
             for (int i = 0; i < rdogrpAdmRefDSH.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpAdmRefDSH.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpAdmRefDSH[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secAdmRefWhyDSH.setVisibility(View.GONE);
                    lineAdmRefWhyDSH.setVisibility(View.GONE);
                    txtAdmRefWhyDSH.setText("");
                    secNotGetAdm.setVisibility(View.GONE);
                    lineNotGetAdm.setVisibility(View.GONE);
                    rdogrpNotGetAdm.clearCheck();
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secAdmRefWhyDSH.setVisibility(View.GONE);
                    lineAdmRefWhyDSH.setVisibility(View.GONE);
                    txtAdmRefWhyDSH.setText("");
                    secNotGetAdm.setVisibility(View.GONE);
                    lineNotGetAdm.setVisibility(View.GONE);
                    rdogrpNotGetAdm.clearCheck();
             }
             else
             {
                    secAdmRefWhyDSH.setVisibility(View.VISIBLE);
                    lineAdmRefWhyDSH.setVisibility(View.VISIBLE);
                    secNotGetAdm.setVisibility(View.VISIBLE);
                    lineNotGetAdm.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secAdmRefWhyDSH=(LinearLayout)findViewById(R.id.secAdmRefWhyDSH);
         lineAdmRefWhyDSH=(View)findViewById(R.id.lineAdmRefWhyDSH);
         VlblAdmRefWhyDSH=(TextView) findViewById(R.id.VlblAdmRefWhyDSH);
         txtAdmRefWhyDSH=(EditText) findViewById(R.id.txtAdmRefWhyDSH);
         secNotGetAdm=(LinearLayout)findViewById(R.id.secNotGetAdm);
         lineNotGetAdm=(View)findViewById(R.id.lineNotGetAdm);
         VlblNotGetAdm = (TextView) findViewById(R.id.VlblNotGetAdm);
         rdogrpNotGetAdm = (RadioGroup) findViewById(R.id.rdogrpNotGetAdm);
         
         rdoNotGetAdm1 = (RadioButton) findViewById(R.id.rdoNotGetAdm1);
         rdoNotGetAdm2 = (RadioButton) findViewById(R.id.rdoNotGetAdm2);
         rdoNotGetAdm3 = (RadioButton) findViewById(R.id.rdoNotGetAdm3);





         //Hide all skip variables
         secAdmRefWhyDSH.setVisibility(View.GONE);
         lineAdmRefWhyDSH.setVisibility(View.GONE);
         secNotGetAdm.setVisibility(View.GONE);
         lineNotGetAdm.setVisibility(View.GONE);
         secAdmRefWhyDSH.setVisibility(View.GONE);
         lineAdmRefWhyDSH.setVisibility(View.GONE);
         secNotGetAdm.setVisibility(View.GONE);
         lineNotGetAdm.setVisibility(View.GONE);

         txtUNCode.setText(UNCODE);
         txtStructureNo.setText(STRUCTURENO);
         txtHouseholdSl.setText(HOUSEHOLDSL);
         txtVisitNo.setText(VISITNO);
         txtMemSl.setText(MEMSL);
         txtMemName.setText(MEMNAME);

         DataSearch(UNCODE,STRUCTURENO,HOUSEHOLDSL,VISITNO,MEMSL);


        Button cmdSave = (Button) findViewById(R.id.cmdSave);
        cmdSave.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) { 
            DataSave();
        }});
     }
     catch(Exception  e)
     {
         Connection.MessageBox(Admission_Refusal.this, e.getMessage());
         return;
     }
 }

 private void DataSave()
 {
   try
     {
 
         String DV="";

         if(txtUNCode.getText().toString().length()==0 & secUNCode.isShown())
           {
             Connection.MessageBox(Admission_Refusal.this, "Required field: Ward No.");
             txtUNCode.requestFocus(); 
             return;	
           }
         else if(txtStructureNo.getText().toString().length()==0 & secStructureNo.isShown())
           {
             Connection.MessageBox(Admission_Refusal.this, "Required field: Structure No.");
             txtStructureNo.requestFocus(); 
             return;	
           }
         else if(txtHouseholdSl.getText().toString().length()==0 & secHouseholdSl.isShown())
           {
             Connection.MessageBox(Admission_Refusal.this, "Required field: Household Sl.");
             txtHouseholdSl.requestFocus(); 
             return;	
           }
         else if(txtVisitNo.getText().toString().length()==0 & secVisitNo.isShown())
           {
             Connection.MessageBox(Admission_Refusal.this, "Required field: Visit No.");
             txtVisitNo.requestFocus(); 
             return;	
           }
         else if(txtMemSl.getText().toString().length()==0 & secMemSl.isShown())
           {
             Connection.MessageBox(Admission_Refusal.this, "Required field: Member Serial.");
             txtMemSl.requestFocus(); 
             return;	
           }
         
         else if(!rdoAdmRefDSH1.isChecked() & !rdoAdmRefDSH2.isChecked() & !rdoAdmRefDSH3.isChecked() & secAdmRefDSH.isShown())
           {
              Connection.MessageBox(Admission_Refusal.this, "Select anyone options from (গত ১২ মাসে এমন কি হয়েছিল যে, আপনার শিশুকে ঢাকা শিশু হাসপাতালে ভর্তি করানোর দরকার ছিল কিন্তু ভর্তি করাতে পারেননি বা ভর্তি করাননি?(In the last 12 months, did your child need admission at DSH but was not admitted?)).");
              rdoAdmRefDSH1.requestFocus();
              return;
           }
         else if(txtAdmRefWhyDSH.getText().toString().length()==0 & secAdmRefWhyDSH.isShown())
           {
             Connection.MessageBox(Admission_Refusal.this, "Required field: আপনার শিশুকে কেন ঢাকা শিশু হাসপাতালে নিয়ে গিয়েছিলেন? (Why did you seek care at DSH?).");
             txtAdmRefWhyDSH.requestFocus(); 
             return;	
           }
         
         else if(!rdoNotGetAdm1.isChecked() & !rdoNotGetAdm2.isChecked() & !rdoNotGetAdm3.isChecked() & secNotGetAdm.isShown())
           {
              Connection.MessageBox(Admission_Refusal.this, "Select anyone options from (আপনার শিশুকে কেন ভর্তি করাতে পারেন নি ?(Why did the child not get admitted?)).");
              rdoNotGetAdm1.requestFocus();
              return;
           }
 
         String SQL = "";
         RadioButton rb;

         Admission_Refusal_DataModel objSave = new Admission_Refusal_DataModel();
         objSave.setUNCode(txtUNCode.getText().toString());
         objSave.setStructureNo(txtStructureNo.getText().toString());
         objSave.setHouseholdSl(txtHouseholdSl.getText().toString());
         objSave.setVisitNo(txtVisitNo.getText().toString());
         objSave.setMemSl(txtMemSl.getText().toString());
         String[] d_rdogrpAdmRefDSH = new String[] {"1","2","8"};
         objSave.setAdmRefDSH(0);
         for (int i = 0; i < rdogrpAdmRefDSH.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpAdmRefDSH.getChildAt(i);
             if (rb.isChecked()) objSave.setAdmRefDSH(Integer.valueOf(d_rdogrpAdmRefDSH[i]));
         }

         objSave.setAdmRefWhyDSH(txtAdmRefWhyDSH.getText().toString());
         String[] d_rdogrpNotGetAdm = new String[] {"1","2","3"};
         objSave.setNotGetAdm(0);
         for (int i = 0; i < rdogrpNotGetAdm.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpNotGetAdm.getChildAt(i);
             if (rb.isChecked()) objSave.setNotGetAdm(Integer.valueOf(d_rdogrpNotGetAdm[i]));
         }

         objSave.setEnDt(Global.DateTimeNowYMDHMS());
         objSave.setStartTime(STARTTIME);
         objSave.setEndTime(g.CurrentTime24());
         objSave.setDeviceID(DEVICEID);
         objSave.setEntryUser(ENTRYUSER); //from data entry user list
         objSave.setmodifyDate(Global.DateTimeNowYMDHMS());
         //objSave.setLat(Double.toString(currentLatitude));
         //objSave.setLon(Double.toString(currentLongitude));

         String status = objSave.SaveUpdateData(this);
         if(status.length()==0) {
             Intent returnIntent = new Intent();
             returnIntent.putExtra("res", "");
             setResult(Activity.RESULT_OK, returnIntent);

             Connection.MessageBox(Admission_Refusal.this, "Saved Successfully");
         }
         else{
             Connection.MessageBox(Admission_Refusal.this, status);
             return;
         }
     }
     catch(Exception  e)
     {
         Connection.MessageBox(Admission_Refusal.this, e.getMessage());
         return;
     }
 }

 private void DataSearch(String UNCode, String StructureNo, String HouseholdSl, String VisitNo, String MemSl)
     {
       try
        {
     
           RadioButton rb;
           Admission_Refusal_DataModel d = new Admission_Refusal_DataModel();
           String SQL = "Select * from "+ TableName +"  Where UNCode='"+ UNCode +"' and StructureNo='"+ StructureNo +"' and HouseholdSl='"+ HouseholdSl +"' and VisitNo='"+ VisitNo +"' and MemSl='"+ MemSl +"'";
           List<Admission_Refusal_DataModel> data = d.SelectAll(this, SQL);
           for(Admission_Refusal_DataModel item : data){
             txtUNCode.setText(item.getUNCode());
             txtStructureNo.setText(item.getStructureNo());
             txtHouseholdSl.setText(item.getHouseholdSl());
             txtVisitNo.setText(item.getVisitNo());
             txtMemSl.setText(item.getMemSl());
             String[] d_rdogrpAdmRefDSH = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpAdmRefDSH.length; i++)
             {
                 if (String.valueOf(item.getAdmRefDSH()).equals(String.valueOf(d_rdogrpAdmRefDSH[i])))
                 {
                     rb = (RadioButton)rdogrpAdmRefDSH.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtAdmRefWhyDSH.setText(item.getAdmRefWhyDSH());
             String[] d_rdogrpNotGetAdm = new String[] {"1","2","3"};
             for (int i = 0; i < d_rdogrpNotGetAdm.length; i++)
             {
                 if (String.valueOf(item.getNotGetAdm()).equals(String.valueOf(d_rdogrpNotGetAdm[i])))
                 {
                     rb = (RadioButton)rdogrpNotGetAdm.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
           }
        }
        catch(Exception  e)
        {
            Connection.MessageBox(Admission_Refusal.this, e.getMessage());
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