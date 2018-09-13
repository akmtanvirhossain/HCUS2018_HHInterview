
 package org.hcus_hhinterview;


 //Android Manifest Code
 //<activity android:name=".Immunization_History" android:label="Immunization_History" />

 import android.app.Activity;
 import android.app.AlertDialog;
 import android.app.DatePickerDialog;
 import android.app.Dialog;
 import android.app.TimePickerDialog;
 import android.content.DialogInterface;
 import android.content.Intent;
 import android.location.Location;
 import android.os.Bundle;
 import android.text.Editable;
 import android.text.TextWatcher;
 import android.view.KeyEvent;
 import android.view.MotionEvent;
 import android.view.View;
 import android.view.WindowManager;
 import android.widget.Button;
 import android.widget.CheckBox;
 import android.widget.CompoundButton;
 import android.widget.DatePicker;
 import android.widget.EditText;
 import android.widget.ImageButton;
 import android.widget.LinearLayout;
 import android.widget.RadioButton;
 import android.widget.RadioGroup;
 import android.widget.SimpleAdapter;
 import android.widget.TextView;
 import android.widget.TimePicker;

 import java.util.ArrayList;
 import java.util.Calendar;
 import java.util.HashMap;
 import java.util.List;

 import Common.Connection;
 import Common.Global;
 import Utility.MySharedPreferences;
 import data_model.Immunization_History_DataModel;

 public class Immunization_History extends Activity {
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
         LinearLayout secVacc_Id;
         View lineVacc_Id;
         TextView VlblVacc_Id;
         EditText txtVacc_Id;
         LinearLayout secGiven;
         View lineGiven;
         TextView VlblGiven;
         RadioGroup rdogrpGiven;
         
         RadioButton rdoGiven1;
         RadioButton rdoGiven2;
         RadioButton rdoGiven3;
         LinearLayout secSource;
         View lineSource;
         TextView VlblSource;
         RadioGroup rdogrpSource;
         
         RadioButton rdoSource1;
         RadioButton rdoSource2;
         LinearLayout secVacc_Date;
         View lineVacc_Date;
         TextView VlblVacc_Date;
         EditText dtpVacc_Date;
         LinearLayout secDate_Missing;
         View lineDate_Missing;
         TextView VlblDate_Missing;
         CheckBox chkDate_Missing;

         TextView VlblVacc_Name;

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
    static String VACC_ID = "";
    static String VACC_Name = "";

 public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
   try
     {
         setContentView(R.layout.immunization_history);
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
         VACC_ID = IDbundle.getString("Vacc_Id");
         VACC_Name = IDbundle.getString("Vacc_Name");

         TableName = "Immunization_History";

         //turnGPSOn();

         //GPS Location
         //FindLocation();
         // Double.toString(currentLatitude);
         // Double.toString(currentLongitude);
         lblHeading = (TextView)findViewById(R.id.lblHeading);

         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(Immunization_History.this);
                 adb.setTitle("Close");
                 adb.setMessage("Do you want to close this form[Yes/No]?");
                 adb.setNegativeButton("No", null);
                 adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                     public void onClick(DialogInterface dialog, int which) {
                         finish();
                     }});
                 adb.show();
             }});

         VlblVacc_Name=findViewById(R.id.VlblVacc_Name);


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
         secVacc_Id=(LinearLayout)findViewById(R.id.secVacc_Id);
         lineVacc_Id=(View)findViewById(R.id.lineVacc_Id);
         VlblVacc_Id=(TextView) findViewById(R.id.VlblVacc_Id);
         txtVacc_Id=(EditText) findViewById(R.id.txtVacc_Id);
         secGiven=(LinearLayout)findViewById(R.id.secGiven);
         lineGiven=(View)findViewById(R.id.lineGiven);
         VlblGiven = (TextView) findViewById(R.id.VlblGiven);
         rdogrpGiven = (RadioGroup) findViewById(R.id.rdogrpGiven);

         rdogrpGiven.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(RadioGroup radioGroup, int radioButtonID) {
                 String rbData = "";
                 RadioButton rb;
                 String[] d_rdogrpSeriIlOnset = new String[] {"1","2","3"};
                 for (int i = 0; i < rdogrpGiven.getChildCount(); i++)
                 {
                     rb = (RadioButton)rdogrpGiven.getChildAt(i);
                     if (rb.isChecked()) rbData = d_rdogrpSeriIlOnset[i];
                 }

                 if(rbData.equalsIgnoreCase("1"))
                 {
                     secSource.setVisibility(View.VISIBLE);
                 }
                 else if(rbData.equalsIgnoreCase("2"))
                 {
                     secSource.setVisibility(View.GONE);
                 }
                 else if(rbData.equalsIgnoreCase("3"))
                 {
                     secSource.setVisibility(View.GONE);
                 }
                 else
                 {
                     secSource.setVisibility(View.GONE);
                 }
             }
         });
         
         rdoGiven1 = (RadioButton) findViewById(R.id.rdoGiven1);
         rdoGiven2 = (RadioButton) findViewById(R.id.rdoGiven2);
         rdoGiven3 = (RadioButton) findViewById(R.id.rdoGiven3);
         secSource=(LinearLayout)findViewById(R.id.secSource);
         lineSource=(View)findViewById(R.id.lineSource);
         VlblSource = (TextView) findViewById(R.id.VlblSource);
         rdogrpSource = (RadioGroup) findViewById(R.id.rdogrpSource);

         rdogrpSource.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(RadioGroup radioGroup, int radioButtonID) {
                 String rbData = "";
                 RadioButton rb;
                 String[] d_rdogrpSeriIlOnset = new String[] {"1","2"};
                 for (int i = 0; i < rdogrpSource.getChildCount(); i++)
                 {
                     rb = (RadioButton)rdogrpSource.getChildAt(i);
                     if (rb.isChecked()) rbData = d_rdogrpSeriIlOnset[i];
                 }

                 if(rbData.equalsIgnoreCase("1"))
                 {
                     secVacc_Date.setVisibility(View.VISIBLE);
                     secDate_Missing.setVisibility(View.VISIBLE);
                 }else
                 {
                     secVacc_Date.setVisibility(View.GONE);
                     dtpVacc_Date.setText("");
                     secDate_Missing.setVisibility(View.GONE);
                     chkDate_Missing.setChecked(false);
                 }
             }
         });
         
         rdoSource1 = (RadioButton) findViewById(R.id.rdoSource1);
         rdoSource2 = (RadioButton) findViewById(R.id.rdoSource2);
         secVacc_Date=(LinearLayout)findViewById(R.id.secVacc_Date);
         lineVacc_Date=(View)findViewById(R.id.lineVacc_Date);
         VlblVacc_Date=(TextView) findViewById(R.id.VlblVacc_Date);
         dtpVacc_Date=(EditText) findViewById(R.id.dtpVacc_Date);

         dtpVacc_Date.addTextChangedListener(new TextWatcher() {
             @Override
             public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

             }

             @Override
             public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                 if(dtpVacc_Date.getText().toString().length()>0) {
                     chkDate_Missing.setChecked(false);
                 }

             }

             @Override
             public void afterTextChanged(Editable editable) {

             }
         });
         secDate_Missing=(LinearLayout)findViewById(R.id.secDate_Missing);
         lineDate_Missing=(View)findViewById(R.id.lineDate_Missing);
         VlblDate_Missing=(TextView) findViewById(R.id.VlblDate_Missing);
         chkDate_Missing=(CheckBox) findViewById(R.id.chkDate_Missing);

         chkDate_Missing.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                 if(b)
                 {
                     dtpVacc_Date.setText("");
                 }
             }
         });


         dtpVacc_Date.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpVacc_Date.getRight() - dtpVacc_Date.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btnVacc_Date"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });



         //Hide all skip variables
         secVacc_Date.setVisibility(View.GONE);
         secSource.setVisibility(View.GONE);
         secDate_Missing.setVisibility(View.GONE);


         txtUNCode.setText(UNCODE);
         txtStructureNo.setText(""+STRUCTURENO);
         txtHouseholdSl.setText(HOUSEHOLDSL);
         txtVisitNo.setText(VISITNO);
         txtMemSl.setText(MEMSL);
         txtVacc_Id.setText(VACC_ID);
         VlblVacc_Name.setText(VACC_Name);

         DataSearch(UNCODE,STRUCTURENO,HOUSEHOLDSL,VISITNO,MEMSL,VACC_ID);


        Button cmdSave = (Button) findViewById(R.id.cmdSave);
        cmdSave.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) { 
            DataSave();
        }});
     }
     catch(Exception  e)
     {
         Connection.MessageBox(Immunization_History.this, e.getMessage());
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
             Connection.MessageBox(Immunization_History.this, "Required field: Ward No.");
             txtUNCode.requestFocus(); 
             return;	
           }
         else if(txtStructureNo.getText().toString().length()==0 & secStructureNo.isShown())
           {
             Connection.MessageBox(Immunization_History.this, "Required field: Structure No.");
             txtStructureNo.requestFocus(); 
             return;	
           }
         else if(txtHouseholdSl.getText().toString().length()==0 & secHouseholdSl.isShown())
           {
             Connection.MessageBox(Immunization_History.this, "Required field: Household Sl.");
             txtHouseholdSl.requestFocus(); 
             return;	
           }
         else if(txtVisitNo.getText().toString().length()==0 & secVisitNo.isShown())
           {
             Connection.MessageBox(Immunization_History.this, "Required field: Visit No.");
             txtVisitNo.requestFocus(); 
             return;	
           }
         else if(txtMemSl.getText().toString().length()==0 & secMemSl.isShown())
           {
             Connection.MessageBox(Immunization_History.this, "Required field: Member Serial.");
             txtMemSl.requestFocus(); 
             return;	
           }
         else if(txtVacc_Id.getText().toString().length()==0 & secVacc_Id.isShown())
           {
             Connection.MessageBox(Immunization_History.this, "Required field: Vaccination ID.");
             txtVacc_Id.requestFocus(); 
             return;	
           }
         
         else if(!rdoGiven1.isChecked() & !rdoGiven2.isChecked() & !rdoGiven3.isChecked() & secGiven.isShown())
           {
              Connection.MessageBox(Immunization_History.this, "Select anyone options from (Vaccination was given).");
              rdoGiven1.requestFocus();
              return;
           }
         
         else if(!rdoSource1.isChecked() & !rdoSource2.isChecked() & secSource.isShown())
           {
              Connection.MessageBox(Immunization_History.this, "Select anyone options from (Source of Verified).");
              rdoSource1.requestFocus();
              return;
           }
         DV = Global.DateValidate(dtpVacc_Date.getText().toString());
         if(DV.length()!=0 & secVacc_Date.isShown())
           {
               if(!chkDate_Missing.isChecked()) {
                   Connection.MessageBox(Immunization_History.this, DV);
                   dtpVacc_Date.requestFocus();
                   return;
               }

           }
 
         String SQL = "";
         RadioButton rb;

         Immunization_History_DataModel objSave = new Immunization_History_DataModel();
         objSave.setUNCode(txtUNCode.getText().toString());
         objSave.setStructureNo(txtStructureNo.getText().toString());
         objSave.setHouseholdSl(txtHouseholdSl.getText().toString());
         objSave.setVisitNo(txtVisitNo.getText().toString());
         objSave.setMemSl(txtMemSl.getText().toString());
         objSave.setVacc_Id(txtVacc_Id.getText().toString());
         String[] d_rdogrpGiven = new String[] {"1","2","3"};
         objSave.setGiven(0);
         for (int i = 0; i < rdogrpGiven.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpGiven.getChildAt(i);
             if (rb.isChecked()) objSave.setGiven(Integer.valueOf(d_rdogrpGiven[i]));
         }

         String[] d_rdogrpSource = new String[] {"1","2"};
         objSave.setSource(0);
         for (int i = 0; i < rdogrpSource.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpSource.getChildAt(i);
             if (rb.isChecked()) objSave.setSource(Integer.valueOf(d_rdogrpSource[i]));
         }

         objSave.setVacc_Date(dtpVacc_Date.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpVacc_Date.getText().toString()) : dtpVacc_Date.getText().toString());
         objSave.setDate_Missing(Integer.valueOf(chkDate_Missing.isChecked()?"1":(secDate_Missing.isShown()?"2":"0")));
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

             Connection.MessageBox(Immunization_History.this, "Saved Successfully");
         }
         else{
             Connection.MessageBox(Immunization_History.this, status);
             return;
         }
     }
     catch(Exception  e)
     {
         Connection.MessageBox(Immunization_History.this, e.getMessage());
         return;
     }
 }

 private void DataSearch(String UNCode, String StructureNo, String HouseholdSl, String VisitNo, String MemSl, String Vacc_Id)
     {
       try
        {
     
           RadioButton rb;
           Immunization_History_DataModel d = new Immunization_History_DataModel();
           String SQL = "Select * from "+ TableName +"  Where UNCode='"+ UNCode +"' and StructureNo='"+ StructureNo +"' and HouseholdSl='"+ HouseholdSl +"' and VisitNo='"+ VisitNo +"' and MemSl='"+ MemSl +"' and Vacc_Id='"+ Vacc_Id +"'";
           List<Immunization_History_DataModel> data = d.SelectAll(this, SQL);
           for(Immunization_History_DataModel item : data){
             txtUNCode.setText(item.getUNCode());
             txtStructureNo.setText(item.getStructureNo());
             txtHouseholdSl.setText(item.getHouseholdSl());
             txtVisitNo.setText(item.getVisitNo());
             txtMemSl.setText(item.getMemSl());
             txtVacc_Id.setText(item.getVacc_Id());
             String[] d_rdogrpGiven = new String[] {"1","2","3"};
             for (int i = 0; i < d_rdogrpGiven.length; i++)
             {
                 if (String.valueOf(item.getGiven()).equals(String.valueOf(d_rdogrpGiven[i])))
                 {
                     rb = (RadioButton)rdogrpGiven.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpSource = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpSource.length; i++)
             {
                 if (String.valueOf(item.getSource()).equals(String.valueOf(d_rdogrpSource[i])))
                 {
                     rb = (RadioButton)rdogrpSource.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             dtpVacc_Date.setText(item.getVacc_Date().toString().length()==0 ? "" : Global.DateConvertDMY(item.getVacc_Date()));
             if(String.valueOf(item.getDate_Missing()).equals("1"))
             {
                chkDate_Missing.setChecked(true);
             }
             else if(String.valueOf(item.getDate_Missing()).equals("2"))
             {
                chkDate_Missing.setChecked(false);
             }
           }
        }
        catch(Exception  e)
        {
            Connection.MessageBox(Immunization_History.this, e.getMessage());
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
      EditText dtpDate;


              dtpDate = (EditText)findViewById(R.id.dtpVacc_Date);
             if (VariableID.equals("btnVacc_Date"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpVacc_Date);
              }
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