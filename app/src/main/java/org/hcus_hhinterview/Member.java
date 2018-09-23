
 package org.hcus_hhinterview;


 //Android Manifest Code
 //<activity android:name=".Member" android:label="Member" />
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
 import android.text.Editable;
 import android.text.TextWatcher;
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
 import data_model.Member_DataModel;

 public class Member extends Activity {
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
         LinearLayout secName;
         View lineName;
         TextView VlblName;
         EditText txtName;
         LinearLayout secSex;
         View lineSex;
         TextView VlblSex;
         RadioGroup rdogrpSex;
         
         RadioButton rdoSex1;
         RadioButton rdoSex2;
         LinearLayout secDOB;
         View lineDOB;
         TextView VlblDOB;
         EditText dtpDOB;
         LinearLayout secDOBDk;
         View lineDOBDk;
         TextView VlblDOBDk;
         CheckBox chkDOBDk;
         LinearLayout secAge;
         View lineAge;
         TextView VlblAge;
         EditText txtAge;
         LinearLayout secAgeU;
         View lineAgeU;
         TextView VlblAgeU;
         Spinner spnAgeU;
         LinearLayout secRelation;
         View lineRelation;
         TextView VlblRelation;
         Spinner spnRelation;
         LinearLayout secOthRelation;
         View lineOthRelation;
         TextView VlblOthRelation;
         EditText txtOthRelation;
         LinearLayout secPreStatus;
         View linePreStatus;
         TextView VlblPreStatus;
         RadioGroup rdogrpPreStatus;
         
         RadioButton rdoPreStatus1;
         RadioButton rdoPreStatus2;
         LinearLayout secDtofDeath;
         View lineDtofDeath;
         TextView VlblDtofDeath;
         EditText dtpDtofDeath;
         LinearLayout secDAge;
         View lineDAge;
         TextView VlblDAge;
         EditText txtDAge;
         LinearLayout secDAgeU;
         View lineDAgeU;
         TextView VlblDAgeU;
         Spinner spnDAgeU;
         LinearLayout secLiveInHouse;
         View lineLiveInHouse;
         TextView VlblLiveInHouse;
         EditText txtLiveInHouse;
     String birthdate="";
     String presentdate="";
     Integer ageInDays;
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

 public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
   try
     {
         setContentView(R.layout.member);
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

         TableName = "Member";

         //turnGPSOn();

         //GPS Location
         //FindLocation();
         // Double.toString(currentLatitude);
         // Double.toString(currentLongitude);
         lblHeading = (TextView)findViewById(R.id.lblHeading);

         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(Member.this);
                 adb.setTitle("Close");
                 adb.setMessage("Do you want to close this form[Yes/No]?");
                 adb.setNegativeButton("No", null);
                 adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                     public void onClick(DialogInterface dialog, int which) {
                         finish();
                     }});
                 adb.show();
             }});


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
         secName=(LinearLayout)findViewById(R.id.secName);
         lineName=(View)findViewById(R.id.lineName);
         VlblName=(TextView) findViewById(R.id.VlblName);
         txtName=(EditText) findViewById(R.id.txtName);
         secSex=(LinearLayout)findViewById(R.id.secSex);
         lineSex=(View)findViewById(R.id.lineSex);
         VlblSex = (TextView) findViewById(R.id.VlblSex);
         rdogrpSex = (RadioGroup) findViewById(R.id.rdogrpSex);
         
         rdoSex1 = (RadioButton) findViewById(R.id.rdoSex1);
         rdoSex2 = (RadioButton) findViewById(R.id.rdoSex2);
         secDOB=(LinearLayout)findViewById(R.id.secDOB);
         lineDOB=(View)findViewById(R.id.lineDOB);
         VlblDOB=(TextView) findViewById(R.id.VlblDOB);
         dtpDOB=(EditText) findViewById(R.id.dtpDOB);
         secDOBDk=(LinearLayout)findViewById(R.id.secDOBDk);
         lineDOBDk=(View)findViewById(R.id.lineDOBDk);
         VlblDOBDk=(TextView) findViewById(R.id.VlblDOBDk);
         chkDOBDk=(CheckBox) findViewById(R.id.chkDOBDk);
         secAge=(LinearLayout)findViewById(R.id.secAge);
         lineAge=(View)findViewById(R.id.lineAge);
         VlblAge=(TextView) findViewById(R.id.VlblAge);
         txtAge=(EditText) findViewById(R.id.txtAge);
         secAgeU=(LinearLayout)findViewById(R.id.secAgeU);
         lineAgeU=(View)findViewById(R.id.lineAgeU);
         VlblAgeU=(TextView) findViewById(R.id.VlblAgeU);
         spnAgeU=(Spinner) findViewById(R.id.spnAgeU);

         if(MEMSL.length()==0){
               MEMSL = C.ReturnSingleValue("Select (ifnull(max(cast(MemSl as int)),0)+1) from Member where UNCode='"+UNCODE+"'and StructureNo='"+ STRUCTURENO +"'and HouseholdSl='"+ HOUSEHOLDSL +"'and VisitNo='"+ VISITNO +"'"); //where ParticipantID='"+ ParticipantID +"'");

         }
//
         txtUNCode.setText(UNCODE);
         txtStructureNo.setText(""+STRUCTURENO);
         txtHouseholdSl.setText(HOUSEHOLDSL);
         txtVisitNo.setText(VISITNO);
         txtMemSl.setText(MEMSL);


         dtpDOB.addTextChangedListener(new TextWatcher() {
             @Override
             public void beforeTextChanged(CharSequence s, int start, int count, int after) {

             }

             @Override
             public void onTextChanged(CharSequence s, int start, int before, int count) {
                 if(dtpDOB.getText().toString().length()>0){
                     chkDOBDk.setChecked(false);

                 }

             }

             @Override
             public void afterTextChanged(Editable s) {
                 birthdate=dtpDOB.getText().toString();
                 presentdate=Global.DateNowDMY();
                 ageInDays=Global.DateDifferenceDays(presentdate,birthdate);

                 if(ageInDays<364)
                 {
                     secLiveInHouse.setVisibility(View.VISIBLE);
                     lineLiveInHouse.setVisibility(View.VISIBLE);
                 }
                 else{
                     secLiveInHouse.setVisibility(View.GONE);
                     lineLiveInHouse.setVisibility(View.GONE);
                 }
             }
         });





         chkDOBDk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if (chkDOBDk.isChecked())
                 {
                     secAge.setVisibility(View.VISIBLE);
                     lineAge.setVisibility(View.VISIBLE);
                     secAgeU.setVisibility(View.VISIBLE);
                     lineAgeU.setVisibility(View.VISIBLE);
                     dtpDOB.setText("");
                 }
                 else{
                     secAge.setVisibility(View.GONE);
                     lineAge.setVisibility(View.GONE);
                     secAgeU.setVisibility(View.GONE);
                     lineAgeU.setVisibility(View.GONE);
                 }
             }
         });







         spnAgeU=(Spinner) findViewById(R.id.spnAgeU);
         List<String> listAgeU = new ArrayList<String>();
         
         listAgeU.add("");
         listAgeU.add("1-দিন (Days)");
         listAgeU.add("2-মাস (Months)");
         listAgeU.add("3-সন (Years)");
         ArrayAdapter<String> adptrAgeU= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listAgeU);
         spnAgeU.setAdapter(adptrAgeU);

spnAgeU.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String spnData = "";
        if (spnAgeU.getSelectedItem().toString().length() != 0)
        {
            spnData = Connection.SelectedSpinnerValue(spnAgeU.getSelectedItem().toString(), "-");
        }
        if(spnData.equalsIgnoreCase("1") )
        {
            secLiveInHouse.setVisibility(View.VISIBLE);
            lineLiveInHouse.setVisibility(View.VISIBLE);
        }
        else if(spnData.equalsIgnoreCase("2") )
        {
            if(Integer.valueOf(txtAge.getText().toString())>=12)
            {
                secLiveInHouse.setVisibility(View.GONE);
                lineLiveInHouse.setVisibility(View.GONE);
            }
            else{
                secLiveInHouse.setVisibility(View.VISIBLE);
                lineLiveInHouse.setVisibility(View.VISIBLE);
            }

        }
        else  if(spnData.equalsIgnoreCase("3") )
        {
            secLiveInHouse.setVisibility(View.GONE);
            lineLiveInHouse.setVisibility(View.GONE);
        }
        else{
            secLiveInHouse.setVisibility(View.GONE);
            lineLiveInHouse.setVisibility(View.GONE);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
});


         secRelation=(LinearLayout)findViewById(R.id.secRelation);
         lineRelation=(View)findViewById(R.id.lineRelation);
         VlblRelation=(TextView) findViewById(R.id.VlblRelation);
         spnRelation=(Spinner) findViewById(R.id.spnRelation);
         List<String> listRelation = new ArrayList<String>();
         
         listRelation.add("");
         listRelation.add("1-খানা প্রধান (Household Head)               ");
         listRelation.add("2-খানা প্রধানের স্বামী/স্ত্রী (Husband/Wife of  Household Head)");
         listRelation.add("3-খানা প্রধানের ছেলে/মেয়ে (Son/Daughter of Houshold Head)");
         listRelation.add("4-খানা প্রধানের ভাই/বোন/দেবর/ ননদ/শালা/ শালী (Brother/Sister/Brother in law/Sister in law of Household Head)	");
         listRelation.add("5-খানা প্রধানের ছেলের বউ/মেয়ের স্বামী (Daughter in law/ Son in law of Household Head)");
         listRelation.add("6- খানা প্রধানের নাতী/নাতনী (Grand son/daughter of Household Head)");
         listRelation.add("Father/Mother of Household Head)");
         listRelation.add("7- ভাগ্নে/ভাগ্নী/ভাইস্তা/ভাইস্তি (Niece of Household Head)");
         listRelation.add("8- অন্যান্য (Others) ");
         ArrayAdapter<String> adptrRelation= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listRelation);
         spnRelation.setAdapter(adptrRelation);

         spnRelation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnRelation.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnRelation.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("1"))
                 {
                    secOthRelation.setVisibility(View.GONE);
                    lineOthRelation.setVisibility(View.GONE);
                    txtOthRelation.setText("");

                    //*********** check for another HH Head
                     boolean flag=C.Existence("select Relation from Member where UNCode='"+UNCODE+"' and StructureNo='"+STRUCTURENO+"' and HouseholdSl='"+HOUSEHOLDSL+"' and Relation='1'");
                     if(flag)
                     {
                         Connection.MessageBox(Member.this,"এই খানায় ইতিমধ্যে একজন খানা প্রধান বিদ্যমান.");
                         spnRelation.setSelection(0);
                         return;
                     }

                    //*********** check for another HH Head
                 }
                 else if(spnData.equalsIgnoreCase("2"))
                 {
                    secOthRelation.setVisibility(View.GONE);
                    lineOthRelation.setVisibility(View.GONE);
                    txtOthRelation.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("3"))
                 {
                    secOthRelation.setVisibility(View.GONE);
                    lineOthRelation.setVisibility(View.GONE);
                    txtOthRelation.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("4"))
                 {
                    secOthRelation.setVisibility(View.GONE);
                    lineOthRelation.setVisibility(View.GONE);
                    txtOthRelation.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("5"))
                 {
                    secOthRelation.setVisibility(View.GONE);
                    lineOthRelation.setVisibility(View.GONE);
                    txtOthRelation.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("6"))
                 {
                    secOthRelation.setVisibility(View.GONE);
                    lineOthRelation.setVisibility(View.GONE);
                    txtOthRelation.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("7"))
                 {
                    secOthRelation.setVisibility(View.GONE);
                    lineOthRelation.setVisibility(View.GONE);
                    txtOthRelation.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("8"))
                 {

                     secOthRelation.setVisibility(View.VISIBLE);
                     lineOthRelation.setVisibility(View.VISIBLE);

                 }
                 else
                 {
                     secOthRelation.setVisibility(View.GONE);
                     lineOthRelation.setVisibility(View.GONE);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secOthRelation=(LinearLayout)findViewById(R.id.secOthRelation);
         lineOthRelation=(View)findViewById(R.id.lineOthRelation);
         VlblOthRelation=(TextView) findViewById(R.id.VlblOthRelation);
         txtOthRelation=(EditText) findViewById(R.id.txtOthRelation);
         secPreStatus=(LinearLayout)findViewById(R.id.secPreStatus);
         linePreStatus=(View)findViewById(R.id.linePreStatus);
         VlblPreStatus = (TextView) findViewById(R.id.VlblPreStatus);
         rdogrpPreStatus = (RadioGroup) findViewById(R.id.rdogrpPreStatus);
         
         rdoPreStatus1 = (RadioButton) findViewById(R.id.rdoPreStatus1);
         rdoPreStatus2 = (RadioButton) findViewById(R.id.rdoPreStatus2);
         secDtofDeath=(LinearLayout)findViewById(R.id.secDtofDeath);
         lineDtofDeath=(View)findViewById(R.id.lineDtofDeath);
         VlblDtofDeath=(TextView) findViewById(R.id.VlblDtofDeath);
         dtpDtofDeath=(EditText) findViewById(R.id.dtpDtofDeath);
         secDAge=(LinearLayout)findViewById(R.id.secDAge);
         lineDAge=(View)findViewById(R.id.lineDAge);
         VlblDAge=(TextView) findViewById(R.id.VlblDAge);
         txtDAge=(EditText) findViewById(R.id.txtDAge);
         secDAgeU=(LinearLayout)findViewById(R.id.secDAgeU);
         lineDAgeU=(View)findViewById(R.id.lineDAgeU);
         VlblDAgeU=(TextView) findViewById(R.id.VlblDAgeU);
         spnDAgeU=(Spinner) findViewById(R.id.spnDAgeU);


         rdogrpPreStatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
             @Override
             public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
                 String rbData = "";
                 RadioButton rb;
                 String[] d_rdogrpPreStatus = new String[] {"1","2"};
                 for (int i = 0; i < rdogrpPreStatus.getChildCount(); i++)
                 {
                     rb = (RadioButton)rdogrpPreStatus.getChildAt(i);
                     if (rb.isChecked()) rbData = d_rdogrpPreStatus[i];
                 }

                 if(rbData.equalsIgnoreCase("1"))
                 {
                     secDtofDeath.setVisibility(View.GONE);
                     lineDtofDeath.setVisibility(View.GONE);
                     secDAge.setVisibility(View.GONE);
                     lineDAge.setVisibility(View.GONE);
                     secDAgeU.setVisibility(View.GONE);
                     lineDAgeU.setVisibility(View.GONE);
                 }
                 else if(rbData.equalsIgnoreCase("2"))
                 {
                     secDtofDeath.setVisibility(View.VISIBLE);
                     lineDtofDeath.setVisibility(View.VISIBLE);
                     secDAge.setVisibility(View.VISIBLE);
                     lineDAge.setVisibility(View.VISIBLE);
                     secDAgeU.setVisibility(View.VISIBLE);
                     lineDAgeU.setVisibility(View.VISIBLE);
                 }
                 else{
                     secDtofDeath.setVisibility(View.GONE);
                     lineDtofDeath.setVisibility(View.GONE);
                     secDAge.setVisibility(View.GONE);
                     lineDAge.setVisibility(View.GONE);
                     secDAgeU.setVisibility(View.GONE);
                     lineDAgeU.setVisibility(View.GONE);
                 }
             }
             public void onNothingSelected(AdapterView<?> adapterView) {
                 return;
             }
         });




         List<String> listDAgeU = new ArrayList<String>();
         
         listDAgeU.add("");
         listDAgeU.add("1-দিন (Days)");
         listDAgeU.add("2-মাস (Months)");
         listDAgeU.add("3-সন (Years)");
         ArrayAdapter<String> adptrDAgeU= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listDAgeU);
         spnDAgeU.setAdapter(adptrDAgeU);

         secLiveInHouse=(LinearLayout)findViewById(R.id.secLiveInHouse);
         lineLiveInHouse=(View)findViewById(R.id.lineLiveInHouse);
         VlblLiveInHouse=(TextView) findViewById(R.id.VlblLiveInHouse);
         txtLiveInHouse=(EditText) findViewById(R.id.txtLiveInHouse);



         dtpDOB.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpDOB.getRight() - dtpDOB.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btnDOB"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });
         dtpDtofDeath.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpDtofDeath.getRight() - dtpDtofDeath.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btnDtofDeath"; showDialog(DATE_DIALOG);
                         txtDAge.setText("");
                         secDAgeU.setVisibility(View.GONE);
                         lineDAgeU.setVisibility(View.GONE);
                         spnDAgeU.setSelection(0);
                      return true;
                     }
                 }
                 return false;
             }
         });

         txtDAge.addTextChangedListener(new TextWatcher() {
             @Override
             public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

             }

             @Override
             public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                 if(txtDAge.getText().toString().length()>0)
                 {
                     dtpDtofDeath.setText("");
                     secDAgeU.setVisibility(View.VISIBLE);
                     lineDAgeU.setVisibility(View.VISIBLE);
                 }

             }

             @Override
             public void afterTextChanged(Editable editable) {

             }
         });

         //Hide all skip variables
         secAge.setVisibility(View.GONE);
         lineAge.setVisibility(View.GONE);
         secAgeU.setVisibility(View.GONE);
         lineAgeU.setVisibility(View.GONE);
         secDtofDeath.setVisibility(View.GONE);
         lineDtofDeath.setVisibility(View.GONE);
         secDAge.setVisibility(View.GONE);
         lineDAge.setVisibility(View.GONE);
         secDAgeU.setVisibility(View.GONE);
         lineDAgeU.setVisibility(View.GONE);
         secOthRelation.setVisibility(View.GONE);
         lineOthRelation.setVisibility(View.GONE);
         secOthRelation.setVisibility(View.GONE);
         lineOthRelation.setVisibility(View.GONE);
         secOthRelation.setVisibility(View.GONE);
         lineOthRelation.setVisibility(View.GONE);
         secOthRelation.setVisibility(View.GONE);
         lineOthRelation.setVisibility(View.GONE);
         secOthRelation.setVisibility(View.GONE);
         lineOthRelation.setVisibility(View.GONE);
         secOthRelation.setVisibility(View.GONE);
         lineOthRelation.setVisibility(View.GONE);
         secOthRelation.setVisibility(View.GONE);
         lineOthRelation.setVisibility(View.GONE);
         secLiveInHouse.setVisibility(View.GONE);
         lineLiveInHouse.setVisibility(View.GONE);

         DataSearch(UNCODE,STRUCTURENO,HOUSEHOLDSL,VISITNO,MEMSL);
        Button cmdSave = (Button) findViewById(R.id.cmdSave);
        cmdSave.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) { 
            DataSave();
        }});
     }
     catch(Exception  e)
     {
         Connection.MessageBox(Member.this, e.getMessage());
         return;
     }
 }

 private void DataSave()
 {
   try
     {
 
         String DV="";
         String birthdate="";
         String presentdate="";
         Integer ageInDays;

         if(txtUNCode.getText().toString().length()==0 & secUNCode.isShown())
           {
             Connection.MessageBox(Member.this, "Required field: Ward No.");
             txtUNCode.requestFocus(); 
             return;	
           }
         else if(txtStructureNo.getText().toString().length()==0 & secStructureNo.isShown())
           {
             Connection.MessageBox(Member.this, "Required field: Structure No.");
             txtStructureNo.requestFocus(); 
             return;	
           }
         else if(txtHouseholdSl.getText().toString().length()==0 & secHouseholdSl.isShown())
           {
             Connection.MessageBox(Member.this, "Required field: Household Sl.");
             txtHouseholdSl.requestFocus(); 
             return;	
           }
         else if(txtVisitNo.getText().toString().length()==0 & secVisitNo.isShown())
           {
             Connection.MessageBox(Member.this, "Required field: Visit No.");
             txtVisitNo.requestFocus(); 
             return;	
           }
         else if(txtMemSl.getText().toString().length()==0 & secMemSl.isShown())
           {
             Connection.MessageBox(Member.this, "Required field: Member Serial.");
             txtMemSl.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtMemSl.getText().toString().length()==0 ? "1" : txtMemSl.getText().toString()) < 1 || Integer.valueOf(txtMemSl.getText().toString().length()==0 ? "30" : txtMemSl.getText().toString()) > 30)
           {
             Connection.MessageBox(Member.this, "Value should be between 1 and 30(Member Serial).");
             txtMemSl.requestFocus(); 
             return;	
           }
         else if(txtName.getText().toString().length()==0 & secName.isShown())
           {
             Connection.MessageBox(Member.this, "Required field: নাম (Name).");
             txtName.requestFocus(); 
             return;	
           }
         
         else if(!rdoSex1.isChecked() & !rdoSex2.isChecked() & secSex.isShown())
           {
              Connection.MessageBox(Member.this, "Select anyone options from (লিঙ্গ (Sex)).");
              rdoSex1.requestFocus();
              return;
           }

           else if(dtpDOB.getText().toString().length()==0 & !chkDOBDk.isChecked() & secDOB.isShown()) {

                 DV = Global.DateValidate(dtpDOB.getText().toString());
                 Connection.MessageBox(Member.this, DV);
                 dtpDOB.requestFocus();
                 return;
         }

         else if(txtAge.getText().toString().length()==0 & secAge.isShown())
           {

             Connection.MessageBox(Member.this, "Required field: বয়স,যদি জন্ম তারিখ জানা না থাকে (Age) if DOB is unknown.");
             txtAge.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtAge.getText().toString().length()==0 ? "00" : txtAge.getText().toString()) < 00 || Integer.valueOf(txtAge.getText().toString().length()==0 ? "99" : txtAge.getText().toString()) > 99)
           {
             Connection.MessageBox(Member.this, "Value should be between 00 and 99(বয়স,যদি জন্ম তারিখ জানা না থাকে (Age) if DOB is unknown).");
             txtAge.requestFocus(); 
             return;	
           }
         else if(spnAgeU.getSelectedItemPosition()==0  & secAgeU.isShown())
           {
             Connection.MessageBox(Member.this, "Required field: দিন/মাস/সন (Days/Months/Years).");
             spnAgeU.requestFocus(); 
             return;	
           }
         else if(spnRelation.getSelectedItemPosition()==0  & secRelation.isShown())
           {
             Connection.MessageBox(Member.this, "Required field: খানা প্রধানের সাথে সম্পর্ক (Relation with Household head).");

               spnRelation.requestFocus();
             return;	
           }
         else if(txtOthRelation.getText().toString().length()==0 & secOthRelation.isShown())
           {
             Connection.MessageBox(Member.this, "Required field: অন্যান্য (বর্ণনা লিখুন) (if Others, Please describe).");
             txtOthRelation.requestFocus(); 
             return;	
           }
         
         else if(!rdoPreStatus1.isChecked() & !rdoPreStatus2.isChecked() & secPreStatus.isShown())
           {
              Connection.MessageBox(Member.this, "Select anyone options from (বর্তমান অবস্থা (Present Status)).");
              rdoPreStatus1.requestFocus();
              return;
           }
         DV = Global.DateValidate(dtpDtofDeath.getText().toString());
         if(DV.length()!=0 & secDtofDeath.isShown()& txtDAge.getText().toString().length()==0)
           {
             Connection.MessageBox(Member.this, DV);
             dtpDtofDeath.requestFocus(); 
             return;	
           }
         else if(txtDAge.getText().toString().length()==0 & secDAge.isShown()& dtpDtofDeath.getText().toString().length()==0)
           {
             Connection.MessageBox(Member.this, "Required field: মৃত্যুর সময় বয়স, যদি জন্ম/মৃত্যুর তারিখ জানা না থাকে (Age at death, if date of birth/death is unknown).");
             txtDAge.requestFocus(); 
             return;	
           }
         else if(dtpDtofDeath.getText().toString().length()==0 &(Integer.valueOf(txtDAge.getText().toString().length()==0 ? "00" : txtDAge.getText().toString()) < 00 || Integer.valueOf(txtDAge.getText().toString().length()==0 ? "99" : txtDAge.getText().toString()) > 99))
           {
             Connection.MessageBox(Member.this, "Value should be between 00 and 99(মৃত্যুর সময় বয়স, যদি জন্ম/মৃত্যুর তারিখ জানা না থাকে (Age at death, if date of birth/death is unknown)).");
             txtDAge.requestFocus(); 
             return;	
           }
         else if(spnDAgeU.getSelectedItemPosition()==0  & secDAgeU.isShown()&dtpDtofDeath.getText().toString().length()>0)
           {
             Connection.MessageBox(Member.this, "Required field: দিন/মাস/সন (Days/Months/Years).");
             spnDAgeU.requestFocus(); 
             return;	
           }
//         else if(txtLiveInHouse.getText().toString().length()==0 & secLiveInHouse.isShown())
//           {
//             Connection.MessageBox(Member.this, "Required field:  কত মাস ধরে এই পরিবারে বাস করছে (যদি < ১২ মাস হয় ) How many months have you been living  ( if <12 months).");
//             txtLiveInHouse.requestFocus();
//             return;
//           }
//         else if(Integer.valueOf(txtLiveInHouse.getText().toString().length()==0 ? "0" : txtLiveInHouse.getText().toString()) < 0 || Integer.valueOf(txtLiveInHouse.getText().toString().length()==0 ? "99" : txtLiveInHouse.getText().toString()) > 99)
//           {
//             Connection.MessageBox(Member.this, "Value should be between 0 and 99( কত মাস ধরে এই পরিবারে বাস করছে (যদি < ১২ মাস হয় ) How many months have you been living  ( if <12 months)).");
//             txtLiveInHouse.requestFocus();
//             return;
//           }



         String SQL = "";
         RadioButton rb;

         Member_DataModel objSave = new Member_DataModel();
         objSave.setUNCode(txtUNCode.getText().toString());
         objSave.setStructureNo(txtStructureNo.getText().toString());
         objSave.setHouseholdSl(txtHouseholdSl.getText().toString());
         objSave.setVisitNo(txtVisitNo.getText().toString());
         objSave.setMemSl(Integer.valueOf(txtMemSl.getText().toString().length()==0?"0":txtMemSl.getText().toString()));
         objSave.setName(txtName.getText().toString());
         String[] d_rdogrpSex = new String[] {"1","2"};
         objSave.setSex(0);
         for (int i = 0; i < rdogrpSex.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpSex.getChildAt(i);
             if (rb.isChecked()) objSave.setSex(Integer.valueOf(d_rdogrpSex[i]));
         }

         objSave.setDOB(dtpDOB.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpDOB.getText().toString()) : dtpDOB.getText().toString());
         objSave.setDOBDk(Integer.valueOf(chkDOBDk.isChecked()?"1":(secDOBDk.isShown()?"2":"0")));
//      **************************************************

         birthdate=dtpDOB.getText().toString();
         presentdate=Global.DateNowDMY();
         ageInDays=Global.DateDifferenceDays(presentdate,birthdate);
         objSave.setAge( ageInDays);

//      *************************************************




        if(spnAgeU.getSelectedItemPosition() == 1)
        {
            objSave.setAge(Integer.valueOf(txtAge.getText().toString()));

        }
         else if(spnAgeU.getSelectedItemPosition() == 2)
         {
             int age=Integer.valueOf(txtAge.getText().toString());
             age=(int)(age*30.4);
             objSave.setAge(age);
         }
        else if(spnAgeU.getSelectedItemPosition() == 3)
        {
            int age=Integer.valueOf(txtAge.getText().toString());
            age=(int)(age*365.25);
            objSave.setAge(age);
        }

         objSave.setAgeU(Integer.valueOf(spnAgeU.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnAgeU.getSelectedItem().toString(), "-")));

         objSave.setRelation(Integer.valueOf(spnRelation.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnRelation.getSelectedItem().toString(), "-")));
         objSave.setOthRelation(txtOthRelation.getText().toString());
         String[] d_rdogrpPreStatus = new String[] {"1","2"};
         objSave.setPreStatus(0);
         for (int i = 0; i < rdogrpPreStatus.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpPreStatus.getChildAt(i);
             if (rb.isChecked()) objSave.setPreStatus(Integer.valueOf(d_rdogrpPreStatus[i]));
         }

         objSave.setDtofDeath(dtpDtofDeath.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpDtofDeath.getText().toString()) : dtpDtofDeath.getText().toString());
         objSave.setDAge(Integer.valueOf(txtDAge.getText().toString().length()==0?"0":txtDAge.getText().toString()));
         objSave.setDAgeU(Integer.valueOf(spnDAgeU.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnDAgeU.getSelectedItem().toString(), "-")));
         objSave.setLiveInHouse(Integer.valueOf(txtLiveInHouse.getText().toString().length()==0?"0":txtLiveInHouse.getText().toString()));
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

             Connection.MessageBox(Member.this, "Saved Successfully");
         }
         else{
             Connection.MessageBox(Member.this, status);
             return;
         }
     }
     catch(Exception  e)
     {
         Connection.MessageBox(Member.this, e.getMessage());
         return;
     }
 }

 private void DataSearch(String UNCode, String StructureNo, String HouseholdSl, String VisitNo, String MemSl)
     {
       try
        {
     
           RadioButton rb;
           Member_DataModel d = new Member_DataModel();
           String SQL = "Select * from "+ TableName +"  Where UNCode='"+ UNCode +"' and StructureNo='"+ StructureNo +"' and HouseholdSl='"+ HouseholdSl +"' and VisitNo='"+ VisitNo +"' and MemSl='"+ MemSl +"'";
           List<Member_DataModel> data = d.SelectAll(this, SQL);
           for(Member_DataModel item : data){
             txtUNCode.setText(item.getUNCode());
             txtStructureNo.setText(item.getStructureNo());
             txtHouseholdSl.setText(item.getHouseholdSl());
             txtVisitNo.setText(item.getVisitNo());
             txtMemSl.setText(String.valueOf(item.getMemSl()));
             txtName.setText(item.getName());
             String[] d_rdogrpSex = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpSex.length; i++)
             {
                 if (String.valueOf(item.getSex()).equals(String.valueOf(d_rdogrpSex[i])))
                 {
                     rb = (RadioButton)rdogrpSex.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             dtpDOB.setText(item.getDOB().toString().length()==0 ? "" : Global.DateConvertDMY(item.getDOB()));
             if(String.valueOf(item.getDOBDk()).equals("1"))
             {
                chkDOBDk.setChecked(true);
             }
             else if(String.valueOf(item.getDOBDk()).equals("2"))
             {
                chkDOBDk.setChecked(false);
             }

             if(String.valueOf(item.getAgeU()).equals("2"))
             {
                 int age=(int)(item.getAge()/30.4);
                 txtAge.setText(""+age);
             }
             else if(String.valueOf(item.getAgeU()).equals("3"))
             {
                 int age=(int)(item.getAge()/365.25);
                 txtAge.setText(""+age);
             }
             else{
                 txtAge.setText(String.valueOf(item.getAge()));
             }


//             txtAge.setText(String.valueOf(item.getAge()));
             spnAgeU.setSelection(Global.SpinnerItemPositionAnyLength(spnAgeU, String.valueOf(item.getAgeU())));
             spnRelation.setSelection(Global.SpinnerItemPositionAnyLength(spnRelation, String.valueOf(item.getRelation())));
             txtOthRelation.setText(item.getOthRelation());
             String[] d_rdogrpPreStatus = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpPreStatus.length; i++)
             {
                 if (String.valueOf(item.getPreStatus()).equals(String.valueOf(d_rdogrpPreStatus[i])))
                 {
                     rb = (RadioButton)rdogrpPreStatus.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             dtpDtofDeath.setText(item.getDtofDeath().toString().length()==0 ? "" : Global.DateConvertDMY(item.getDtofDeath()));
             txtDAge.setText(String.valueOf(item.getDAge()));
             spnDAgeU.setSelection(Global.SpinnerItemPositionAnyLength(spnDAgeU, String.valueOf(item.getDAgeU())));
             txtLiveInHouse.setText(String.valueOf(item.getLiveInHouse()));
           }
        }
        catch(Exception  e)
        {
            Connection.MessageBox(Member.this, e.getMessage());
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


              dtpDate = (EditText)findViewById(R.id.dtpDOB);
             if (VariableID.equals("btnDOB"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpDOB);
              }
             else if (VariableID.equals("btnDtofDeath"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpDtofDeath);
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
       EditText tpTime=null;


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