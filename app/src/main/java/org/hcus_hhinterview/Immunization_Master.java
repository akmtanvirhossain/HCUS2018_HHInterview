
 package org.hcus_hhinterview;


 //Android Manifest Code
 //<activity android:name=".Immunization_Master" android:label="Immunization_Master" />
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
 import data_model.Immunization_Master_DataModel;

 public class Immunization_Master extends Immunization_History_list {
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
         LinearLayout secRecVitA;
         View lineRecVitA;
         TextView VlblRecVitA;
         RadioGroup rdogrpRecVitA;
         
         RadioButton rdoRecVitA1;
         RadioButton rdoRecVitA2;
         RadioButton rdoRecVitA3;
         LinearLayout secReceive_Vacc;
         View lineReceive_Vacc;
         TextView VlblReceive_Vacc;
         RadioGroup rdogrpReceive_Vacc;
         
         RadioButton rdoReceive_Vacc1;
         RadioButton rdoReceive_Vacc2;
         RadioButton rdoReceive_Vacc3;
         LinearLayout secHCard;
         View lineHCard;
         TextView VlblHCard;
         RadioGroup rdogrpHCard;
         
         RadioButton rdoHCard1;
         RadioButton rdoHCard2;

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

    LinearLayout secImmunization;
    View linesecImmunization;

 public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
   try
     {
         setContentView(R.layout.immunization_master);
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

         TableName = "Immunization_Master";

         //turnGPSOn();

         //GPS Location
         //FindLocation();
         // Double.toString(currentLatitude);
         // Double.toString(currentLongitude);
         lblHeading = (TextView)findViewById(R.id.lblHeading);

         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(Immunization_Master.this);
                 adb.setTitle("Close");
                 adb.setMessage("Do you want to close this form[Yes/No]?");
                 adb.setNegativeButton("No", null);
                 adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                     public void onClick(DialogInterface dialog, int which) {
                         finish();
                     }});
                 adb.show();
             }});

         secImmunization=findViewById(R.id.secImmunization);
         linesecImmunization=findViewById(R.id.linesecImmunization);


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
         secRecVitA=(LinearLayout)findViewById(R.id.secRecVitA);
         lineRecVitA=(View)findViewById(R.id.lineRecVitA);
         VlblRecVitA = (TextView) findViewById(R.id.VlblRecVitA);
         rdogrpRecVitA = (RadioGroup) findViewById(R.id.rdogrpRecVitA);
         
         rdoRecVitA1 = (RadioButton) findViewById(R.id.rdoRecVitA1);
         rdoRecVitA2 = (RadioButton) findViewById(R.id.rdoRecVitA2);
         rdoRecVitA3 = (RadioButton) findViewById(R.id.rdoRecVitA3);
         secReceive_Vacc=(LinearLayout)findViewById(R.id.secReceive_Vacc);
         lineReceive_Vacc=(View)findViewById(R.id.lineReceive_Vacc);
         VlblReceive_Vacc = (TextView) findViewById(R.id.VlblReceive_Vacc);
         rdogrpReceive_Vacc = (RadioGroup) findViewById(R.id.rdogrpReceive_Vacc);

         rdogrpReceive_Vacc.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(RadioGroup radioGroup, int radioButtonIDi) {
                 String rbData = "";
                 RadioButton rb;
                 String[] d_rdogrpSeriIlOnset = new String[] {"1","2","8"};
                 for (int i = 0; i < rdogrpReceive_Vacc.getChildCount(); i++)
                 {
                     rb = (RadioButton)rdogrpReceive_Vacc.getChildAt(i);
                     if (rb.isChecked()) rbData = d_rdogrpSeriIlOnset[i];
                 }

                 if(rbData.equalsIgnoreCase("2"))
                 {
                     secImmunization.setVisibility(View.GONE);
                     linesecImmunization.setVisibility(View.GONE);

                 }else if(rbData.equalsIgnoreCase("8"))
                 {
                     secImmunization.setVisibility(View.GONE);
                     linesecImmunization.setVisibility(View.GONE);
                 }else
                 {
                     secImmunization.setVisibility(View.VISIBLE);
                     linesecImmunization.setVisibility(View.VISIBLE);
                 }
             }
         });
         
         rdoReceive_Vacc1 = (RadioButton) findViewById(R.id.rdoReceive_Vacc1);
         rdoReceive_Vacc2 = (RadioButton) findViewById(R.id.rdoReceive_Vacc2);
         rdoReceive_Vacc3 = (RadioButton) findViewById(R.id.rdoReceive_Vacc3);
         secHCard=(LinearLayout)findViewById(R.id.secHCard);
         lineHCard=(View)findViewById(R.id.lineHCard);
         VlblHCard = (TextView) findViewById(R.id.VlblHCard);
         rdogrpHCard = (RadioGroup) findViewById(R.id.rdogrpHCard);
         
         rdoHCard1 = (RadioButton) findViewById(R.id.rdoHCard1);
         rdoHCard2 = (RadioButton) findViewById(R.id.rdoHCard2);





         //Hide all skip variables


         txtUNCode.setText(UNCODE);
         txtStructureNo.setText(STRUCTURENO);
         txtHouseholdSl.setText(HOUSEHOLDSL);
         txtVisitNo.setText(VISITNO);
         txtMemSl.setText(MEMSL);

         DataSearch(UNCODE,STRUCTURENO,HOUSEHOLDSL,VISITNO,MEMSL);
         DataSearch_Imu_History_List(UNCODE,STRUCTURENO,HOUSEHOLDSL,VISITNO,MEMSL,"");


        Button cmdSave = (Button) findViewById(R.id.cmdSave);
        cmdSave.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) { 
            DataSave();
        }});
     }
     catch(Exception  e)
     {
         Connection.MessageBox(Immunization_Master.this, e.getMessage());
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
             Connection.MessageBox(Immunization_Master.this, "Required field: Ward No.");
             txtUNCode.requestFocus(); 
             return;	
           }
         else if(txtStructureNo.getText().toString().length()==0 & secStructureNo.isShown())
           {
             Connection.MessageBox(Immunization_Master.this, "Required field: Structure No.");
             txtStructureNo.requestFocus(); 
             return;	
           }
         else if(txtHouseholdSl.getText().toString().length()==0 & secHouseholdSl.isShown())
           {
             Connection.MessageBox(Immunization_Master.this, "Required field: Household Sl.");
             txtHouseholdSl.requestFocus(); 
             return;	
           }
         else if(txtVisitNo.getText().toString().length()==0 & secVisitNo.isShown())
           {
             Connection.MessageBox(Immunization_Master.this, "Required field: Visit No.");
             txtVisitNo.requestFocus(); 
             return;	
           }
         else if(txtMemSl.getText().toString().length()==0 & secMemSl.isShown())
           {
             Connection.MessageBox(Immunization_Master.this, "Required field: Member Serial.");
             txtMemSl.requestFocus(); 
             return;	
           }
         
         else if(!rdoRecVitA1.isChecked() & !rdoRecVitA2.isChecked() & !rdoRecVitA3.isChecked() & secRecVitA.isShown())
           {
              Connection.MessageBox(Immunization_Master.this, "Select anyone options from (শিশুটি (নাম) গত ৬ মাসে ভিটামিন A ক্যাপসুল খেয়েছিল?  (Did (NAME) receive a Vitamin A dose like this during the last 6 months? SHOW CAPSULE)).");
              rdoRecVitA1.requestFocus();
              return;
           }
         
         else if(!rdoReceive_Vacc1.isChecked() & !rdoReceive_Vacc2.isChecked() & !rdoReceive_Vacc3.isChecked() & secReceive_Vacc.isShown())
           {
              Connection.MessageBox(Immunization_Master.this, "Select anyone options from (শিশুটি (নাম) কি রোগ প্রতিরোধের জন্য কোন টিকা গ্রহন করেছে? (Did (NAME) ever receive any vaccinations to prevent him/her from getting disease?)).");
              rdoReceive_Vacc1.requestFocus();
              return;
           }
         
         else if(!rdoHCard1.isChecked() & !rdoHCard2.isChecked() & secHCard.isShown())
           {
              Connection.MessageBox(Immunization_Master.this, "Select anyone options from (আপনার কাছে কি এই শিশুর টিকার কার্ড আছে? যদি হ্যাঁ হয়, আমি কি দেখতে পারি? (Do you have a card where (NAME’S) vaccinations are written down? IF YES, May I see it please?)).");
              rdoHCard1.requestFocus();
              return;
           }
 
         String SQL = "";
         RadioButton rb;

         Immunization_Master_DataModel objSave = new Immunization_Master_DataModel();
         objSave.setUNCode(txtUNCode.getText().toString());
         objSave.setStructureNo(txtStructureNo.getText().toString());
         objSave.setHouseholdSl(txtHouseholdSl.getText().toString());
         objSave.setVisitNo(txtVisitNo.getText().toString());
         objSave.setMemSl(txtMemSl.getText().toString());
         String[] d_rdogrpRecVitA = new String[] {"1","2","8"};
         objSave.setRecVitA(0);
         for (int i = 0; i < rdogrpRecVitA.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpRecVitA.getChildAt(i);
             if (rb.isChecked()) objSave.setRecVitA(Integer.valueOf(d_rdogrpRecVitA[i]));
         }

         String[] d_rdogrpReceive_Vacc = new String[] {"1","2","8"};
         objSave.setReceive_Vacc(0);
         for (int i = 0; i < rdogrpReceive_Vacc.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpReceive_Vacc.getChildAt(i);
             if (rb.isChecked()) objSave.setReceive_Vacc(Integer.valueOf(d_rdogrpReceive_Vacc[i]));
         }

         String[] d_rdogrpHCard = new String[] {"1","2"};
         objSave.setHCard(0);
         for (int i = 0; i < rdogrpHCard.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpHCard.getChildAt(i);
             if (rb.isChecked()) objSave.setHCard(Integer.valueOf(d_rdogrpHCard[i]));
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

             Connection.MessageBox(Immunization_Master.this, "Saved Successfully");
         }
         else{
             Connection.MessageBox(Immunization_Master.this, status);
             return;
         }
     }
     catch(Exception  e)
     {
         Connection.MessageBox(Immunization_Master.this, e.getMessage());
         return;
     }
 }

 private void DataSearch(String UNCode, String StructureNo, String HouseholdSl, String VisitNo, String MemSl)
     {
       try
        {
     
           RadioButton rb;
           Immunization_Master_DataModel d = new Immunization_Master_DataModel();
           String SQL = "Select * from "+ TableName +"  Where UNCode='"+ UNCode +"' and StructureNo='"+ StructureNo +"' and HouseholdSl='"+ HouseholdSl +"' and VisitNo='"+ VisitNo +"' and MemSl='"+ MemSl +"'";
           List<Immunization_Master_DataModel> data = d.SelectAll(this, SQL);
           for(Immunization_Master_DataModel item : data){
             txtUNCode.setText(item.getUNCode());
             txtStructureNo.setText(item.getStructureNo());
             txtHouseholdSl.setText(item.getHouseholdSl());
             txtVisitNo.setText(item.getVisitNo());
             txtMemSl.setText(item.getMemSl());
             String[] d_rdogrpRecVitA = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpRecVitA.length; i++)
             {
                 if (String.valueOf(item.getRecVitA()).equals(String.valueOf(d_rdogrpRecVitA[i])))
                 {
                     rb = (RadioButton)rdogrpRecVitA.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpReceive_Vacc = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpReceive_Vacc.length; i++)
             {
                 if (String.valueOf(item.getReceive_Vacc()).equals(String.valueOf(d_rdogrpReceive_Vacc[i])))
                 {
                     rb = (RadioButton)rdogrpReceive_Vacc.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpHCard = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpHCard.length; i++)
             {
                 if (String.valueOf(item.getHCard()).equals(String.valueOf(d_rdogrpHCard[i])))
                 {
                     rb = (RadioButton)rdogrpHCard.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
           }
        }
        catch(Exception  e)
        {
            Connection.MessageBox(Immunization_Master.this, e.getMessage());
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