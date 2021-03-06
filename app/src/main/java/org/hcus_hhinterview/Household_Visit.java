
 package org.hcus_hhinterview;


 //Android Manifest Code
 //<activity android:name=".Household_Visit" android:label="Household_Visit" />

 import android.app.Activity;
 import android.app.AlertDialog;
 import android.app.DatePickerDialog;
 import android.app.Dialog;
 import android.app.TimePickerDialog;
 import android.content.DialogInterface;
 import android.content.Intent;
 import android.location.Location;
 import android.os.Bundle;
 import android.view.KeyEvent;
 import android.view.MotionEvent;
 import android.view.View;
 import android.view.WindowManager;
 import android.widget.AdapterView;
 import android.widget.ArrayAdapter;
 import android.widget.Button;
 import android.widget.DatePicker;
 import android.widget.EditText;
 import android.widget.ImageButton;
 import android.widget.LinearLayout;
 import android.widget.RadioButton;
 import android.widget.RadioGroup;
 import android.widget.SimpleAdapter;
 import android.widget.Spinner;
 import android.widget.TextView;
 import android.widget.TimePicker;

 import java.util.ArrayList;
 import java.util.Calendar;
 import java.util.HashMap;
 import java.util.List;

 import Common.Connection;
 import Common.Global;
 import Utility.MySharedPreferences;
 import data_model.Household_Visit_DataModel;

 public class Household_Visit extends Activity {
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
         LinearLayout secHHVisited;
         View lineHHVisited;
         TextView VlblHHVisited;
         RadioGroup rdogrpHHVisited;
         
         RadioButton rdoHHVisited1;
         RadioButton rdoHHVisited2;
         LinearLayout secOutcome;
         View lineOutcome;
         TextView VlblOutcome;
         Spinner spnOutcome;
         LinearLayout secOutcomeOth;
         View lineOutcomeOth;
         TextView VlblOutcomeOth;
         EditText txtOutcomeOth;
         LinearLayout secHHMember;
         View lineHHMember;
         TextView VlblHHMember;
         EditText txtHHMember;
         LinearLayout secU18Yrs;
         View lineU18Yrs;
         TextView VlblU18Yrs;
         RadioGroup rdogrpU18Yrs;
         
         RadioButton rdoU18Yrs1;
         RadioButton rdoU18Yrs2;
         LinearLayout secU18Alive;
         View lineU18Alive;
         TextView VlblU18Alive;
         EditText txtU18Alive;
         LinearLayout secU18YrsDie;
         View lineU18YrsDie;
         TextView VlblU18YrsDie;
         RadioGroup rdogrpU18YrsDie;
         
         RadioButton rdoU18YrsDie1;
         RadioButton rdoU18YrsDie2;
         LinearLayout secU18Death;
         View lineU18Death;
         TextView VlblU18Death;
         EditText txtU18Death;
         LinearLayout secOfferedStudy;
         View lineOfferedStudy;
         TextView VlblOfferedStudy;
         RadioGroup rdogrpOfferedStudy;
         
         RadioButton rdoOfferedStudy1;
         RadioButton rdoOfferedStudy2;
         LinearLayout secNotOffered;
         View lineNotOffered;
         TextView VlblNotOffered;
         Spinner spnNotOffered;
         LinearLayout secNotOfferedOth;
         View lineNotOfferedOth;
         TextView VlblNotOfferedOth;
         EditText txtNotOfferedOth;
         LinearLayout secConsent;
         View lineConsent;
         TextView VlblConsent;
         RadioGroup rdogrpConsent;
         
         RadioButton rdoConsent1;
         RadioButton rdoConsent2;
         LinearLayout secRemarks;
         View lineRemarks;
         TextView VlblRemarks;
         EditText txtRemarks;
         LinearLayout secDataCollDate;
         View lineDataCollDate;
         TextView VlblDataCollDate;
         EditText dtpDataCollDate;
     Button btnAddVisit;
     Button cmdSave;

     //**********************************************
     LinearLayout secU5Yrs;
     View lineU5Yrs;
     TextView VlblU5Yrs;
     RadioGroup rdogrpU5Yrs;

     RadioButton rdoU5Yrs1;
     RadioButton rdoU5Yrs2;
     LinearLayout secU5YrsAlive;
     View lineU5YrsAlive;
     TextView VlblU5YrsAlive;
     EditText txtU5YrsAlive;
     LinearLayout secU5YrsDie;
     View lineU5YrsDie;
     TextView VlblU5YrsDie;
     RadioGroup rdogrpU5YrsDie;

     RadioButton rdoU5YrsDie1;
     RadioButton rdoU5YrsDie2;
     LinearLayout secU5YrsDeath;
     View lineU5YrsDeath;
     TextView VlblU5YrsDeath;
     EditText txtU5YrsDeath;
     //**********************************************

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


 public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
   try
     {
         setContentView(R.layout.household_visit);
         getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

         C = new Connection(this);
         g = Global.getInstance();

         STARTTIME = g.CurrentTime24();

         ENTRYUSER = sp.getValue(this, "userid");

         IDbundle = getIntent().getExtras();
         UNCODE = IDbundle.getString("UNCode");
         STRUCTURENO = IDbundle.getString("StructureNo");
         HOUSEHOLDSL = IDbundle.getString("HouseholdSl");
         DEVICEID = IDbundle.getString("DeviceId");

         VISITNO = IDbundle.getString("VisitNo");

         if(HOUSEHOLDSL.length()==0){
             HOUSEHOLDSL = C.ReturnSingleValue("Select (ifnull(max(cast(HouseholdSl as int)),0)+1) from Household_Visit where UNCode='"+UNCODE+"'and StructureNo='"+ STRUCTURENO +"'"); //where ParticipantID='"+ ParticipantID +"'");
              }
         if(VISITNO.length()==0){
             VISITNO = C.ReturnSingleValue("Select (ifnull(max(cast(VisitNo as int)),0)+1) from Household_Visit where UNCode='"+UNCODE+"'and StructureNo='"+ STRUCTURENO +"'and HouseholdSl='"+ HOUSEHOLDSL +"'"); //where ParticipantID='"+ ParticipantID +"'");

         }

         if(DEVICEID.length()==0)
         {
             DEVICEID  = sp.getValue(this, "deviceid");
         }



         TableName = "Household_Visit";

         //turnGPSOn();

         //GPS Location
         //FindLocation();
         // Double.toString(currentLatitude);
         // Double.toString(currentLongitude);
         lblHeading = (TextView)findViewById(R.id.lblHeading);

         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(Household_Visit.this);
                 adb.setTitle("Close");
                 adb.setMessage("Do you want to close this form[Yes/No]?");
                 adb.setNegativeButton("No", null);
                 adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                     public void onClick(DialogInterface dialog, int which) {
                         finish();
                     }});
                 adb.show();
             }});



         btnAddVisit   = (Button) findViewById(R.id.btnAddVisit);
         btnAddVisit.setOnClickListener(new View.OnClickListener() {

             public void onClick(View view) {
                 Bundle IDbundle = new Bundle();
                 IDbundle.putString("UNCode",UNCODE  );
                 IDbundle.putString("StructureNo",STRUCTURENO );
                 IDbundle.putString("HouseholdSl", HOUSEHOLDSL);
                 IDbundle.putString("VisitNo", "");
                 IDbundle.putString("DeviceId", "");

                 Intent intent = new Intent(getApplicationContext(), Household_Visit.class);
                 intent.putExtras(IDbundle);
                 startActivityForResult(intent, 1);

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
         secHHVisited=(LinearLayout)findViewById(R.id.secHHVisited);
         lineHHVisited=(View)findViewById(R.id.lineHHVisited);
         VlblHHVisited = (TextView) findViewById(R.id.VlblHHVisited);
         rdogrpHHVisited = (RadioGroup) findViewById(R.id.rdogrpHHVisited);
         
         rdoHHVisited1 = (RadioButton) findViewById(R.id.rdoHHVisited1);
         rdoHHVisited2 = (RadioButton) findViewById(R.id.rdoHHVisited2);
         secOutcome=(LinearLayout)findViewById(R.id.secOutcome);
         lineOutcome=(View)findViewById(R.id.lineOutcome);
         VlblOutcome=(TextView) findViewById(R.id.VlblOutcome);
         spnOutcome=(Spinner) findViewById(R.id.spnOutcome);
         cmdSave=(Button) findViewById(R.id.cmdSave);


         secOutcome.setVisibility(View.GONE);
         lineOutcome.setVisibility(View.GONE);




         rdogrpHHVisited.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(RadioGroup group, int radioButtonId) {

                 String rbData="";
                 RadioButton rb;
                 String[] d_rdogrpHHVisited=new String[]{"1","2"};
                 for(int i=0;i<rdogrpHHVisited.getChildCount();i++)
                 {
                     rb=(RadioButton) rdogrpHHVisited.getChildAt(i);
                     if (rb.isChecked()) rbData = d_rdogrpHHVisited[i];
                 }

                 if(rbData.equalsIgnoreCase("1"))
                 {
                     secOutcome.setVisibility(View.VISIBLE);
                     lineOutcome.setVisibility(View.VISIBLE);
                 }else
                 {
                     secOutcome.setVisibility(View.GONE);
                     lineOutcome.setVisibility(View.GONE);
                     spnOutcome.setSelection(0);

                     secHHMember.setVisibility(View.GONE);
                     lineHHMember.setVisibility(View.GONE);
                     txtHHMember.setText("");

                     secU18Yrs.setVisibility(View.GONE);
                     lineU18Yrs.setVisibility(View.GONE);
                     rdogrpU18Yrs.clearCheck();

                     secU18YrsDie.setVisibility(View.GONE);
                     lineU18YrsDie.setVisibility(View.GONE);
                     rdogrpU18YrsDie.clearCheck();

                     secU5Yrs.setVisibility(View.GONE);
                     lineU5Yrs.setVisibility(View.GONE);
                     rdogrpU5Yrs.clearCheck();

                     secU5YrsDie.setVisibility(View.GONE);
                     lineU5YrsDie.setVisibility(View.GONE);
                     rdogrpU5YrsDie.clearCheck();
                 }

             }
         });

         List<String> listOutcome = new ArrayList<String>();
         
         listOutcome.add("");
         listOutcome.add("1-Present");
         listOutcome.add("2-Absent");
         listOutcome.add("3-Vacant");
         listOutcome.add("4-Refusal");
         listOutcome.add("5-Lack of time");
         listOutcome.add("7-Other");
         ArrayAdapter<String> adptrOutcome= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listOutcome);
         spnOutcome.setAdapter(adptrOutcome);

         spnOutcome.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnOutcome.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnOutcome.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("1"))
                 {
                     secOutcomeOth.setVisibility(View.GONE);
                     lineOutcomeOth.setVisibility(View.GONE);
                     txtOutcomeOth.setText("");

                     secHHMember.setVisibility(View.VISIBLE);
                     lineHHMember.setVisibility(View.VISIBLE);

                     secU18Yrs.setVisibility(View.VISIBLE);
                     lineU18Yrs.setVisibility(View.VISIBLE);

                     secU18YrsDie.setVisibility(View.VISIBLE);
                     lineU18YrsDie.setVisibility(View.VISIBLE);

                     secU5Yrs.setVisibility(View.VISIBLE);
                     lineU5Yrs.setVisibility(View.VISIBLE);

                     secU5YrsDie.setVisibility(View.VISIBLE);
                     lineU5YrsDie.setVisibility(View.VISIBLE);

                 }
                  else if(spnData.equalsIgnoreCase("7"))
                 {
                    secOutcomeOth.setVisibility(View.VISIBLE);
                    lineOutcomeOth.setVisibility(View.VISIBLE);

                    secHHMember.setVisibility(View.GONE);
                    lineHHMember.setVisibility(View.GONE);
                    txtHHMember.setText("");

                    secU18Yrs.setVisibility(View.GONE);
                    lineU18Yrs.setVisibility(View.GONE);
                    rdogrpU18Yrs.clearCheck();

                    secU18YrsDie.setVisibility(View.GONE);
                    lineU18YrsDie.setVisibility(View.GONE);
                    rdogrpU18YrsDie.clearCheck();

                     secU5Yrs.setVisibility(View.GONE);
                     lineU5Yrs.setVisibility(View.GONE);
                     rdogrpU5Yrs.clearCheck();

                     secU5YrsDie.setVisibility(View.GONE);
                     lineU5YrsDie.setVisibility(View.GONE);
                     rdogrpU5YrsDie.clearCheck();
                 }
                 else
                 {
                    secOutcomeOth.setVisibility(View.GONE);
                    lineOutcomeOth.setVisibility(View.GONE);
                    txtOutcomeOth.setText("");

                    secHHMember.setVisibility(View.GONE);
                    lineHHMember.setVisibility(View.GONE);
                    txtHHMember.setText("");

                    secU18Yrs.setVisibility(View.GONE);
                    lineU18Yrs.setVisibility(View.GONE);
                    rdogrpU18Yrs.clearCheck();

                    secU18YrsDie.setVisibility(View.GONE);
                    lineU18YrsDie.setVisibility(View.GONE);
                    rdogrpU18YrsDie.clearCheck();

                    secU5Yrs.setVisibility(View.GONE);
                    lineU5Yrs.setVisibility(View.GONE);
                    rdogrpU5Yrs.clearCheck();

                    secU5YrsDie.setVisibility(View.GONE);
                    lineU5YrsDie.setVisibility(View.GONE);
                    rdogrpU5YrsDie.clearCheck();
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secOutcomeOth=(LinearLayout)findViewById(R.id.secOutcomeOth);
         lineOutcomeOth=(View)findViewById(R.id.lineOutcomeOth);
         VlblOutcomeOth=(TextView) findViewById(R.id.VlblOutcomeOth);
         txtOutcomeOth=(EditText) findViewById(R.id.txtOutcomeOth);
         secHHMember=(LinearLayout)findViewById(R.id.secHHMember);
         lineHHMember=(View)findViewById(R.id.lineHHMember);
         VlblHHMember=(TextView) findViewById(R.id.VlblHHMember);
         txtHHMember=(EditText) findViewById(R.id.txtHHMember);
         secU18Yrs=(LinearLayout)findViewById(R.id.secU18Yrs);
         lineU18Yrs=(View)findViewById(R.id.lineU18Yrs);
         VlblU18Yrs = (TextView) findViewById(R.id.VlblU18Yrs);
         rdogrpU18Yrs = (RadioGroup) findViewById(R.id.rdogrpU18Yrs);
         
         rdoU18Yrs1 = (RadioButton) findViewById(R.id.rdoU18Yrs1);
         rdoU18Yrs2 = (RadioButton) findViewById(R.id.rdoU18Yrs2);


         rdogrpU18Yrs.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpU18Yrs = new String[] {"1","2"};
             for (int i = 0; i < rdogrpU18Yrs.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpU18Yrs.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpU18Yrs[i];
             }

             if(rbData.equalsIgnoreCase("1"))
             {
                 secU18Alive.setVisibility(View.VISIBLE);
                 lineU18Alive.setVisibility(View.VISIBLE);
             }else
             {
                 secU18Alive.setVisibility(View.GONE);
                 lineU18Alive.setVisibility(View.GONE);
                 txtU18Alive.setText("");
             }
             //************************** check for offered study **************************
             yesCheck();
             //************************** check for offered study **************************

            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secU18Alive=(LinearLayout)findViewById(R.id.secU18Alive);
         lineU18Alive=(View)findViewById(R.id.lineU18Alive);
         VlblU18Alive=(TextView) findViewById(R.id.VlblU18Alive);
         txtU18Alive=(EditText) findViewById(R.id.txtU18Alive);
         secU18YrsDie=(LinearLayout)findViewById(R.id.secU18YrsDie);
         lineU18YrsDie=(View)findViewById(R.id.lineU18YrsDie);
         VlblU18YrsDie = (TextView) findViewById(R.id.VlblU18YrsDie);
         rdogrpU18YrsDie = (RadioGroup) findViewById(R.id.rdogrpU18YrsDie);
         
         rdoU18YrsDie1 = (RadioButton) findViewById(R.id.rdoU18YrsDie1);
         rdoU18YrsDie2 = (RadioButton) findViewById(R.id.rdoU18YrsDie2);
         rdogrpU18YrsDie.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpU18YrsDie = new String[] {"1","2"};
             for (int i = 0; i < rdogrpU18YrsDie.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpU18YrsDie.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpU18YrsDie[i];
             }

             if(rbData.equalsIgnoreCase("1"))
             {
                 secU18Death.setVisibility(View.VISIBLE);
                 lineU18Death.setVisibility(View.VISIBLE);
             }else
             {
                 secU18Death.setVisibility(View.GONE);
                 lineU18Death.setVisibility(View.GONE);
                 txtU5YrsDeath.setText("");
             }

             //************************** check for offered study **************************
             yesCheck();
             //************************** check for offered study **************************
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secU18Death=(LinearLayout)findViewById(R.id.secU18Death);
         lineU18Death=(View)findViewById(R.id.lineU18Death);
         VlblU18Death=(TextView) findViewById(R.id.VlblU18Death);
         txtU18Death=(EditText) findViewById(R.id.txtU18Death);
         secOfferedStudy=(LinearLayout)findViewById(R.id.secOfferedStudy);
         lineOfferedStudy=(View)findViewById(R.id.lineOfferedStudy);
         VlblOfferedStudy = (TextView) findViewById(R.id.VlblOfferedStudy);
         rdogrpOfferedStudy = (RadioGroup) findViewById(R.id.rdogrpOfferedStudy);
         
         rdoOfferedStudy1 = (RadioButton) findViewById(R.id.rdoOfferedStudy1);
         rdoOfferedStudy2 = (RadioButton) findViewById(R.id.rdoOfferedStudy2);
         rdogrpOfferedStudy.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpOfferedStudy = new String[] {"1","2"};
             for (int i = 0; i < rdogrpOfferedStudy.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpOfferedStudy.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpOfferedStudy[i];
             }

             if(rbData.equalsIgnoreCase("1"))
             {
                    secNotOffered.setVisibility(View.GONE);
                    lineNotOffered.setVisibility(View.GONE);
                    spnNotOffered.setSelection(0);
                    secNotOfferedOth.setVisibility(View.GONE);
                    lineNotOfferedOth.setVisibility(View.GONE);
//                    txtNotOfferedOth.setText("");
                 secConsent.setVisibility(View.VISIBLE);
                 lineConsent.setVisibility(View.VISIBLE);
//                 rdogrpConsent.clearCheck();
             }
             else  if(rbData.equalsIgnoreCase("2"))
             {

                    secNotOffered.setVisibility(View.VISIBLE);
                    lineNotOffered.setVisibility(View.VISIBLE);
                 secNotOfferedOth.setVisibility(View.GONE);
                 lineNotOfferedOth.setVisibility(View.GONE);
                 secConsent.setVisibility(View.GONE);
                 lineConsent.setVisibility(View.GONE);
//                 rdogrpConsent.clearCheck();

             }
             else{
                 secNotOffered.setVisibility(View.GONE);
                 lineNotOffered.setVisibility(View.GONE);
                 spnNotOffered.setSelection(0);
                 secNotOfferedOth.setVisibility(View.GONE);
                 lineNotOfferedOth.setVisibility(View.GONE);
                    txtNotOfferedOth.setText("");
                 secConsent.setVisibility(View.GONE);
                 lineConsent.setVisibility(View.GONE);
                 rdogrpConsent.clearCheck();
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secNotOffered=(LinearLayout)findViewById(R.id.secNotOffered);
         lineNotOffered=(View)findViewById(R.id.lineNotOffered);
         VlblNotOffered=(TextView) findViewById(R.id.VlblNotOffered);
         spnNotOffered=(Spinner) findViewById(R.id.spnNotOffered);
         List<String> listNotOffered = new ArrayList<String>();
         
         listNotOffered.add("");
         listNotOffered.add("1-Appropriate respondent was not available");
         listNotOffered.add("2-Lack of time");
         listNotOffered.add("7-Other");
         ArrayAdapter<String> adptrNotOffered= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listNotOffered);
         spnNotOffered.setAdapter(adptrNotOffered);

         spnNotOffered.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnNotOffered.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnNotOffered.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("1"))
                 {
                    secNotOfferedOth.setVisibility(View.GONE);
                    lineNotOfferedOth.setVisibility(View.GONE);
//                    txtNotOfferedOth.setText("");
                    secConsent.setVisibility(View.GONE);
                    lineConsent.setVisibility(View.GONE);
//                    rdogrpConsent.clearCheck();
                 }
                 else if(spnData.equalsIgnoreCase("2"))
                 {
                    secNotOfferedOth.setVisibility(View.GONE);
                    lineNotOfferedOth.setVisibility(View.GONE);
//                    txtNotOfferedOth.setText("");
                    secConsent.setVisibility(View.GONE);
                    lineConsent.setVisibility(View.GONE);
//                    rdogrpConsent.clearCheck();
                 }
                 else if(spnData.equalsIgnoreCase("7"))
                 {
                    secNotOfferedOth.setVisibility(View.VISIBLE);
                    lineNotOfferedOth.setVisibility(View.VISIBLE);
                     secConsent.setVisibility(View.GONE);
                     lineConsent.setVisibility(View.GONE);
//                     rdogrpConsent.clearCheck();
                 }
                 else
                     {
                         secNotOfferedOth.setVisibility(View.GONE);
                         lineNotOfferedOth.setVisibility(View.GONE);
//                         txtNotOfferedOth.setText("");
                         secConsent.setVisibility(View.GONE);
                         lineConsent.setVisibility(View.GONE);
//                         rdogrpConsent.clearCheck();
                     }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secNotOfferedOth=(LinearLayout)findViewById(R.id.secNotOfferedOth);
         lineNotOfferedOth=(View)findViewById(R.id.lineNotOfferedOth);
         VlblNotOfferedOth=(TextView) findViewById(R.id.VlblNotOfferedOth);
         txtNotOfferedOth=(EditText) findViewById(R.id.txtNotOfferedOth);
         secConsent=(LinearLayout)findViewById(R.id.secConsent);
         lineConsent=(View)findViewById(R.id.lineConsent);
         VlblConsent = (TextView) findViewById(R.id.VlblConsent);
         rdogrpConsent = (RadioGroup) findViewById(R.id.rdogrpConsent);
         
         rdoConsent1 = (RadioButton) findViewById(R.id.rdoConsent1);
         rdoConsent2 = (RadioButton) findViewById(R.id.rdoConsent2);
         rdogrpConsent.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpConsent = new String[] {"1","2"};
             for (int i = 0; i < rdogrpConsent.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpConsent.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpConsent[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
//                    sec.setVisibility(View.GONE);
//                    line.setVisibility(View.GONE);
             }
             else
             {
//                    sec.setVisibility(View.VISIBLE);
//                    line.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secRemarks=(LinearLayout)findViewById(R.id.secRemarks);
         lineRemarks=(View)findViewById(R.id.lineRemarks);
         VlblRemarks=(TextView) findViewById(R.id.VlblRemarks);
         txtRemarks=(EditText) findViewById(R.id.txtRemarks);
         secDataCollDate=(LinearLayout)findViewById(R.id.secDataCollDate);
         lineDataCollDate=(View)findViewById(R.id.lineDataCollDate);
         VlblDataCollDate=(TextView) findViewById(R.id.VlblDataCollDate);
         dtpDataCollDate=(EditText) findViewById(R.id.dtpDataCollDate);




         dtpDataCollDate.setText(Global.DateNowDMY());

         dtpDataCollDate.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpDataCollDate.getRight() - dtpDataCollDate.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btnDataCollDate"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });


         //*************************************
         secU5Yrs=(LinearLayout)findViewById(R.id.secU5Yrs);
         lineU5Yrs=(View)findViewById(R.id.lineU5Yrs);
         VlblU5Yrs = (TextView) findViewById(R.id.VlblU5Yrs);
         rdogrpU5Yrs = (RadioGroup) findViewById(R.id.rdogrpU5Yrs);

         rdoU5Yrs1 = (RadioButton) findViewById(R.id.rdoU5Yrs1);
         rdoU5Yrs2 = (RadioButton) findViewById(R.id.rdoU5Yrs2);
         rdogrpU5Yrs.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
             @Override
             public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
                 String rbData = "";
                 RadioButton rb;
                 String[] d_rdogrpU5Yrs = new String[] {"1","2"};
                 for (int i = 0; i < rdogrpU5Yrs.getChildCount(); i++)
                 {
                     rb = (RadioButton)rdogrpU5Yrs.getChildAt(i);
                     if (rb.isChecked()) rbData = d_rdogrpU5Yrs[i];
                 }

                 if(rbData.equalsIgnoreCase("1"))
                 {
                     secU5YrsAlive.setVisibility(View.VISIBLE);
                     lineU5YrsAlive.setVisibility(View.VISIBLE);
                 }
                 else
                 {
                     secU5YrsAlive.setVisibility(View.GONE);
                     lineU5YrsAlive.setVisibility(View.GONE);
                     txtU5YrsAlive.setText("");
                 }
                 //************************** check for offered study **************************
                 yesCheck();
                 //************************** check for offered study **************************
             }
             public void onNothingSelected(AdapterView<?> adapterView) {
                 return;
             }
         });
         secU5YrsAlive=(LinearLayout)findViewById(R.id.secU5YrsAlive);
         lineU5YrsAlive=(View)findViewById(R.id.lineU5YrsAlive);
         VlblU5YrsAlive=(TextView) findViewById(R.id.VlblU5YrsAlive);
         txtU5YrsAlive=(EditText) findViewById(R.id.txtU5YrsAlive);
         secU5YrsDie=(LinearLayout)findViewById(R.id.secU5YrsDie);
         lineU5YrsDie=(View)findViewById(R.id.lineU5YrsDie);
         VlblU5YrsDie = (TextView) findViewById(R.id.VlblU5YrsDie);
         rdogrpU5YrsDie = (RadioGroup) findViewById(R.id.rdogrpU5YrsDie);

         rdogrpU5YrsDie.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(RadioGroup radioGroup, int RadioButtonId) {
                 String rbData = "";
                 RadioButton rb;
                 String[] d_rdogrpU5YrsDie = new String[] {"1","2"};
                 for (int i = 0; i < rdogrpU5YrsDie.getChildCount(); i++)
                 {
                     rb = (RadioButton)rdogrpU5YrsDie.getChildAt(i);
                     if (rb.isChecked()) rbData = d_rdogrpU5YrsDie[i];
                 }
                 if(rbData.equalsIgnoreCase("1"))
                 {
                     secU5YrsDeath.setVisibility(View.VISIBLE);
                     lineU5YrsDeath.setVisibility(View.VISIBLE);

                 }else
                 {
                     secU5YrsDeath.setVisibility(View.GONE);
                     lineU5YrsDeath.setVisibility(View.GONE);
                     txtU5YrsDeath.setText("");
                 }
                 //************************** check for offered study **************************
                 yesCheck();
                 //************************** check for offered study **************************
             }
         });

         rdoU5YrsDie1 = (RadioButton) findViewById(R.id.rdoU5YrsDie1);
         rdoU5YrsDie2 = (RadioButton) findViewById(R.id.rdoU5YrsDie2);
         secU5YrsDeath=(LinearLayout)findViewById(R.id.secU5YrsDeath);
         lineU5YrsDeath=(View)findViewById(R.id.lineU5YrsDeath);
         VlblU5YrsDeath=(TextView) findViewById(R.id.VlblU5YrsDeath);
         txtU5YrsDeath=(EditText) findViewById(R.id.txtU5YrsDeath);
         //*************************************



         //Hide all skip variables
         secOutcomeOth.setVisibility(View.GONE);
         lineOutcomeOth.setVisibility(View.GONE);
         secHHMember.setVisibility(View.GONE);
         lineHHMember.setVisibility(View.GONE);
         secU18Yrs.setVisibility(View.GONE);
         lineU18Yrs.setVisibility(View.GONE);
         secU18Alive.setVisibility(View.GONE);
         lineU18Alive.setVisibility(View.GONE);
         secU18YrsDie.setVisibility(View.GONE);
         lineU18YrsDie.setVisibility(View.GONE);
         secU18Death.setVisibility(View.GONE);
         lineU18Death.setVisibility(View.GONE);
//         secOfferedStudy.setVisibility(View.GONE);
//         lineOfferedStudy.setVisibility(View.GONE);
         secNotOffered.setVisibility(View.GONE);
         lineNotOffered.setVisibility(View.GONE);
         secNotOfferedOth.setVisibility(View.GONE);
         lineNotOfferedOth.setVisibility(View.GONE);
         secConsent.setVisibility(View.GONE);
         lineConsent.setVisibility(View.GONE);
         secOutcomeOth.setVisibility(View.GONE);
         lineOutcomeOth.setVisibility(View.GONE);
         secHHMember.setVisibility(View.GONE);
         lineHHMember.setVisibility(View.GONE);
         secU18Yrs.setVisibility(View.GONE);
         lineU18Yrs.setVisibility(View.GONE);
         secU18Alive.setVisibility(View.GONE);
         lineU18Alive.setVisibility(View.GONE);
         secU18YrsDie.setVisibility(View.GONE);
         lineU18YrsDie.setVisibility(View.GONE);
         secU18Death.setVisibility(View.GONE);
         lineU18Death.setVisibility(View.GONE);
//         secOfferedStudy.setVisibility(View.GONE);
//         lineOfferedStudy.setVisibility(View.GONE);
         secNotOffered.setVisibility(View.GONE);
         lineNotOffered.setVisibility(View.GONE);
         secNotOfferedOth.setVisibility(View.GONE);
         lineNotOfferedOth.setVisibility(View.GONE);
         secConsent.setVisibility(View.GONE);
         lineConsent.setVisibility(View.GONE);
         secOutcomeOth.setVisibility(View.GONE);
         lineOutcomeOth.setVisibility(View.GONE);
         secHHMember.setVisibility(View.GONE);
         lineHHMember.setVisibility(View.GONE);
         secU18Yrs.setVisibility(View.GONE);
         lineU18Yrs.setVisibility(View.GONE);
         secU18Alive.setVisibility(View.GONE);
         lineU18Alive.setVisibility(View.GONE);
         secU18YrsDie.setVisibility(View.GONE);
         lineU18YrsDie.setVisibility(View.GONE);
         secU18Death.setVisibility(View.GONE);
         lineU18Death.setVisibility(View.GONE);
//         secOfferedStudy.setVisibility(View.GONE);
//         lineOfferedStudy.setVisibility(View.GONE);
         secNotOffered.setVisibility(View.GONE);
         lineNotOffered.setVisibility(View.GONE);
         secNotOfferedOth.setVisibility(View.GONE);
         lineNotOfferedOth.setVisibility(View.GONE);
         secConsent.setVisibility(View.GONE);
         lineConsent.setVisibility(View.GONE);
         secOutcomeOth.setVisibility(View.GONE);
         lineOutcomeOth.setVisibility(View.GONE);
         secHHMember.setVisibility(View.GONE);
         lineHHMember.setVisibility(View.GONE);
         secU18Yrs.setVisibility(View.GONE);
         lineU18Yrs.setVisibility(View.GONE);
         secU18Alive.setVisibility(View.GONE);
         lineU18Alive.setVisibility(View.GONE);
         secU18YrsDie.setVisibility(View.GONE);
         lineU18YrsDie.setVisibility(View.GONE);
         secU18Death.setVisibility(View.GONE);
         lineU18Death.setVisibility(View.GONE);
         secOfferedStudy.setVisibility(View.GONE);
         lineOfferedStudy.setVisibility(View.GONE);
         secNotOffered.setVisibility(View.GONE);
         lineNotOffered.setVisibility(View.GONE);
         secNotOfferedOth.setVisibility(View.GONE);
         lineNotOfferedOth.setVisibility(View.GONE);
         secConsent.setVisibility(View.GONE);
         lineConsent.setVisibility(View.GONE);
         secU18Alive.setVisibility(View.GONE);
         lineU18Alive.setVisibility(View.GONE);
         secU18YrsDie.setVisibility(View.GONE);
         lineU18YrsDie.setVisibility(View.GONE);
         secU18Death.setVisibility(View.GONE);
         lineU18Death.setVisibility(View.GONE);
         secNotOffered.setVisibility(View.GONE);
         lineNotOffered.setVisibility(View.GONE);
         secNotOfferedOth.setVisibility(View.GONE);
         lineNotOfferedOth.setVisibility(View.GONE);
         secNotOfferedOth.setVisibility(View.GONE);
         lineNotOfferedOth.setVisibility(View.GONE);
         secConsent.setVisibility(View.GONE);
         lineConsent.setVisibility(View.GONE);
         secNotOfferedOth.setVisibility(View.GONE);
         lineNotOfferedOth.setVisibility(View.GONE);
         secConsent.setVisibility(View.GONE);
         lineConsent.setVisibility(View.GONE);

         btnAddVisit.setVisibility(View.GONE);

         //***************************************
         secU5Yrs.setVisibility(View.GONE);
         lineU5Yrs.setVisibility(View.GONE);
         secU5YrsAlive.setVisibility(View.GONE);
         lineU5YrsAlive.setVisibility(View.GONE);
         secU5YrsDie.setVisibility(View.GONE);
         lineU5YrsDie.setVisibility(View.GONE);
         secU5YrsDeath.setVisibility(View.GONE);
         lineU5YrsDeath.setVisibility(View.GONE);

         //***************************************


         txtUNCode.setText(UNCODE);
         txtStructureNo.setText(STRUCTURENO);
         txtHouseholdSl.setText(HOUSEHOLDSL);
         txtVisitNo.setText(VISITNO);



         DataSearch(UNCODE,STRUCTURENO,HOUSEHOLDSL,VISITNO);



       Button cmdSave = (Button) findViewById(R.id.cmdSave);
        cmdSave.setOnClickListener(
                new View.OnClickListener() {
        public void onClick(View view) {


            DataSave();
        }});

     }
     catch(Exception  e)
     {
         Connection.MessageBox(Household_Visit.this, e.getMessage());
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
             Connection.MessageBox(Household_Visit.this, "Required field: Ward No.");
             txtUNCode.requestFocus(); 
             return;	
           }
         else if(txtStructureNo.getText().toString().length()==0 & secStructureNo.isShown())
           {
             Connection.MessageBox(Household_Visit.this, "Required field: Structure No.");
             txtStructureNo.requestFocus(); 
             return;	
           }
         else if(txtHouseholdSl.getText().toString().length()==0 & secHouseholdSl.isShown())
           {
             Connection.MessageBox(Household_Visit.this, "Required field: Household Sl.");
             txtHouseholdSl.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtHouseholdSl.getText().toString().length()==0 ? "01" : txtHouseholdSl.getText().toString()) < 01 || Integer.valueOf(txtHouseholdSl.getText().toString().length()==0 ? "97" : txtHouseholdSl.getText().toString()) > 97)
           {
             Connection.MessageBox(Household_Visit.this, "Value should be between 01 and 97(Household Sl).");
             txtHouseholdSl.requestFocus(); 
             return;	
           }
         else if(txtVisitNo.getText().toString().length()==0 & secVisitNo.isShown())
           {
             Connection.MessageBox(Household_Visit.this, "Required field: Visit Number of Household.");
             txtVisitNo.requestFocus(); 
             return;	
           }
         
         else if(!rdoHHVisited1.isChecked() & !rdoHHVisited2.isChecked()  & secHHVisited.isShown())
           {
              Connection.MessageBox(Household_Visit.this, "Select anyone options from (Household Visited ).");
              rdoHHVisited1.requestFocus();
              return;
           }
         else if(spnOutcome.getSelectedItemPosition()==0  & secOutcome.isShown())
           {
             Connection.MessageBox(Household_Visit.this, "Required field: Household visit outcome.");
             spnOutcome.requestFocus(); 
             return;	
           }
         else if(txtOutcomeOth.getText().toString().length()==0 & secOutcomeOth.isShown())
           {
             Connection.MessageBox(Household_Visit.this, "Required field: Other Specify.");
             txtOutcomeOth.requestFocus(); 
             return;	
           }
         else if(txtHHMember.getText().toString().length()==0 & secHHMember.isShown())
           {
             Connection.MessageBox(Household_Visit.this, "Required field: Number of Household Members.");
             txtHHMember.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtHHMember.getText().toString().length()==0 ? "00" : txtHHMember.getText().toString()) < 00 || Integer.valueOf(txtHHMember.getText().toString().length()==0 ? "25" : txtHHMember.getText().toString()) > 25)
           {
             Connection.MessageBox(Household_Visit.this, "Value should be between 00 and 25(Number of Household Members).");
             txtHHMember.requestFocus(); 
             return;	
           }
         
         else if(!rdoU18Yrs1.isChecked() & !rdoU18Yrs2.isChecked() & secU18Yrs.isShown())
           {
              Connection.MessageBox(Household_Visit.this, "Select anyone options from (Does this household has any member <18 Years).");
              rdoU18Yrs1.requestFocus();
              return;
           }
         else if(txtU18Alive.getText().toString().length()==0 & secU18Alive.isShown())
           {
             Connection.MessageBox(Household_Visit.this, "Required field: Number of <18 years old alive.");
             txtU18Alive.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtU18Alive.getText().toString().length()==0 ? "0" : txtU18Alive.getText().toString()) < 0 || Integer.valueOf(txtU18Alive.getText().toString().length()==0 ? "10" : txtU18Alive.getText().toString()) > 10)
           {
             Connection.MessageBox(Household_Visit.this, "Value should be between 0 and 10(Number of <18 years old alive).");
             txtU18Alive.requestFocus(); 
             return;	
           }
           else if(secU18Alive.isShown())
         {
             if( txtHHMember.getText().toString().length()>0& txtU18Alive.getText().toString().length()>0 &(Integer.valueOf(txtU18Alive.getText().toString())>Integer.valueOf(txtHHMember.getText().toString()))  )
             {
                 Connection.MessageBox(Household_Visit.this, "Number of under 18 years old alive should not be greater than total household member");
                 txtU18Alive.requestFocus();
                 return;
             }
         }

         
          if(!rdoU18YrsDie1.isChecked() & !rdoU18YrsDie2.isChecked() & secU18YrsDie.isShown())
           {
              Connection.MessageBox(Household_Visit.this, "Select anyone options from (Did any <18 years old Household member die in this Household).");
              rdoU18YrsDie1.requestFocus();
              return;
           }
         else if(txtU18Death.getText().toString().length()==0 & secU18Death.isShown())
           {
             Connection.MessageBox(Household_Visit.this, "Required field: Number of <18 years deaths in last 12 months.");
             txtU18Death.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtU18Death.getText().toString().length()==0 ? "1" : txtU18Death.getText().toString()) < 0 || Integer.valueOf(txtU18Death.getText().toString().length()==0 ? "9" : txtU18Death.getText().toString()) > 9)
           {
             Connection.MessageBox(Household_Visit.this, "Value should be between 1 and 9(Number of <18 years deaths in last 12 months).");
             txtU18Death.requestFocus(); 
             return;	
           }

           //**********************************************
         else if(!rdoU5Yrs1.isChecked() & !rdoU5Yrs2.isChecked() & secU5Yrs.isShown())
         {
             Connection.MessageBox(Household_Visit.this, "Select anyone options from (Does this household has any member under 5 Years ).");
             rdoU5Yrs1.requestFocus();
             return;
         }
         else if(txtU5YrsAlive.getText().toString().length()==0 & secU5YrsAlive.isShown())
         {
             Connection.MessageBox(Household_Visit.this, "Required field: Number of under 5 years old alive.");
             txtU5YrsAlive.requestFocus();
             return;
         }
         else if(secU5YrsAlive.isShown() &(Integer.valueOf(txtU5YrsAlive.getText().toString().length()==0 ? "1" : txtU5YrsAlive.getText().toString()) < 1 || Integer.valueOf(txtU5YrsAlive.getText().toString().length()==0 ? "99" : txtU5YrsAlive.getText().toString()) > 99))
         {
             Connection.MessageBox(Household_Visit.this, "Value should be between 1 and 99(Number of under 5 years old alive).");
             txtU5YrsAlive.requestFocus();
             return;
         }

         else if(!rdoU5YrsDie1.isChecked() & !rdoU5YrsDie2.isChecked() & secU5YrsDie.isShown())
         {
             Connection.MessageBox(Household_Visit.this, "Select anyone options from (Did any under 5 years old household member die in this household).");
             rdoU5YrsDie1.requestFocus();
             return;
         }
         else if(txtU5YrsDeath.getText().toString().length()==0 & secU5YrsDeath.isShown())
         {
             Connection.MessageBox(Household_Visit.this, "Required field: Number of 5 years deaths in last 12 months.");
             txtU5YrsDeath.requestFocus();
             return;
         }
         else if(secU5YrsDeath.isShown()&(Integer.valueOf(txtU5YrsDeath.getText().toString().length()==0 ? "1" : txtU5YrsDeath.getText().toString()) < 1 || Integer.valueOf(txtU5YrsDeath.getText().toString().length()==0 ? "99" : txtU5YrsDeath.getText().toString()) > 99))
         {
             Connection.MessageBox(Household_Visit.this, "Value should be between 1 and 99(Number of 5 years deaths in last 12 months).");
             txtU5YrsDeath.requestFocus();
             return;
         }
           //**********************************************

         else if(!rdoOfferedStudy1.isChecked() & !rdoOfferedStudy2.isChecked() & secOfferedStudy.isShown())
           {
              Connection.MessageBox(Household_Visit.this, "Select anyone options from (Offered Study).");
              rdoOfferedStudy1.requestFocus();
              return;
           }
         else if(spnNotOffered.getSelectedItemPosition()==0  & secNotOffered.isShown())
           {
             Connection.MessageBox(Household_Visit.this, "Required field: Reason of Not Offering Study.");
             spnNotOffered.requestFocus(); 
             return;	
           }
         else if(txtNotOfferedOth.getText().toString().length()==0 & secNotOfferedOth.isShown())
           {
             Connection.MessageBox(Household_Visit.this, "Required field: Other Specify.");
             txtNotOfferedOth.requestFocus(); 
             return;	
           }
         
         else if(!rdoConsent1.isChecked() & !rdoConsent2.isChecked() & secConsent.isShown())
           {
              Connection.MessageBox(Household_Visit.this, "Select anyone options from (Consent obtained).");
              rdoConsent1.requestFocus();
              return;
           }
//         else if(txtRemarks.getText().toString().length()==0 & secRemarks.isShown())
//           {
////             Connection.MessageBox(Household_Visit.this, "Required field: Remarks.");
//             txtRemarks.requestFocus();
//             return;
//           }
         DV = Global.DateValidate(dtpDataCollDate.getText().toString());
         if(DV.length()!=0 & secDataCollDate.isShown())
           {
             Connection.MessageBox(Household_Visit.this, DV);
             dtpDataCollDate.requestFocus(); 
             return;	
           }
 
         String SQL = "";
         RadioButton rb;

         Household_Visit_DataModel objSave = new Household_Visit_DataModel();
         objSave.setUNCode(txtUNCode.getText().toString());
         objSave.setStructureNo(txtStructureNo.getText().toString());
         objSave.setHouseholdSl(Integer.valueOf(txtHouseholdSl.getText().toString().length()==0?"0":txtHouseholdSl.getText().toString()));
         objSave.setVisitNo(txtVisitNo.getText().toString());
         String[] d_rdogrpHHVisited = new String[] {"1","2"};
         objSave.setHHVisited(0);
         for (int i = 0; i < rdogrpHHVisited.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpHHVisited.getChildAt(i);
             if (rb.isChecked()) objSave.setHHVisited(Integer.valueOf(d_rdogrpHHVisited[i]));
         }

         objSave.setOutcome(Integer.valueOf(spnOutcome.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnOutcome.getSelectedItem().toString(), "-")));
         objSave.setOutcomeOth(txtOutcomeOth.getText().toString());
         objSave.setHHMember(Integer.valueOf(txtHHMember.getText().toString().length()==0?"0":txtHHMember.getText().toString()));
         String[] d_rdogrpU18Yrs = new String[] {"1","2"};
         objSave.setU18Yrs(0);
         for (int i = 0; i < rdogrpU18Yrs.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpU18Yrs.getChildAt(i);
             if (rb.isChecked()) objSave.setU18Yrs(Integer.valueOf(d_rdogrpU18Yrs[i]));
         }

         objSave.setU18Alive(Integer.valueOf(txtU18Alive.getText().toString().length()==0?"0":txtU18Alive.getText().toString()));
         String[] d_rdogrpU18YrsDie = new String[] {"1","2"};
         objSave.setU18YrsDie(0);
         for (int i = 0; i < rdogrpU18YrsDie.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpU18YrsDie.getChildAt(i);
             if (rb.isChecked()) objSave.setU18YrsDie(Integer.valueOf(d_rdogrpU18YrsDie[i]));
         }

         objSave.setU18Death(Integer.valueOf(txtU18Death.getText().toString().length()==0?"0":txtU18Death.getText().toString()));

         //*************************************
         String[] d_rdogrpU5Yrs = new String[] {"1","2"};
         objSave.setU5Yrs(0);
         for (int i = 0; i < rdogrpU5Yrs.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpU5Yrs.getChildAt(i);
             if (rb.isChecked()) objSave.setU5Yrs(Integer.valueOf(d_rdogrpU5Yrs[i]));
         }

         objSave.setU5YrsAlive(Integer.valueOf(txtU5YrsAlive.getText().toString().length()==0?"0":txtU5YrsAlive.getText().toString()));
         String[] d_rdogrpU5YrsDie = new String[] {"1","2"};
         objSave.setU5YrsDie(0);
         for (int i = 0; i < rdogrpU5YrsDie.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpU5YrsDie.getChildAt(i);
             if (rb.isChecked()) objSave.setU5YrsDie(Integer.valueOf(d_rdogrpU5YrsDie[i]));
         }

         objSave.setU5YrsDeath(Integer.valueOf(txtU5YrsDeath.getText().toString().length()==0?"0":txtU5YrsDeath.getText().toString()));
         //*************************************

         String[] d_rdogrpOfferedStudy = new String[] {"1","2"};
         objSave.setOfferedStudy(0);
         for (int i = 0; i < rdogrpOfferedStudy.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpOfferedStudy.getChildAt(i);
             if (rb.isChecked()) objSave.setOfferedStudy(Integer.valueOf(d_rdogrpOfferedStudy[i]));
         }

         objSave.setNotOffered(Integer.valueOf(spnNotOffered.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnNotOffered.getSelectedItem().toString(), "-")));
         objSave.setNotOfferedOth(txtNotOfferedOth.getText().toString());
         String[] d_rdogrpConsent = new String[] {"1","2"};
         objSave.setConsent(0);
         for (int i = 0; i < rdogrpConsent.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpConsent.getChildAt(i);
             if (rb.isChecked()) objSave.setConsent(Integer.valueOf(d_rdogrpConsent[i]));
         }

         objSave.setRemarks(txtRemarks.getText().toString());
         objSave.setDataCollDate(dtpDataCollDate.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpDataCollDate.getText().toString()) : dtpDataCollDate.getText().toString());
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

             AlertDialog.Builder alert=new AlertDialog.Builder(this);
             alert.setMessage("Saved Successfully");
             alert.setTitle("Message");
             alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialog, int which) {
                     String rbData = "";
                     RadioButton rb;
                     String[] d_rdogrpConsent = new String[] {"1","2"};
                     for (int i = 0; i < rdogrpConsent.getChildCount(); i++)
                     {
                         rb = (RadioButton)rdogrpConsent.getChildAt(i);
                         if (rb.isChecked()) rbData = d_rdogrpConsent[i];
                     }

                     if(rbData.equalsIgnoreCase("1"))
                     {
                         Bundle IDbundle = new Bundle();
                         IDbundle.putString("UNCode",UNCODE  );
                         IDbundle.putString("StructureNo",STRUCTURENO );
                         IDbundle.putString("HouseholdSl", HOUSEHOLDSL);
                         IDbundle.putString("VisitNo", VISITNO);
                         IDbundle.putString("DeviceId", DEVICEID);

                         Intent intent = new Intent(getApplicationContext(), Household_Interview.class);
                         intent.putExtras(IDbundle);
                         startActivityForResult(intent, 1);
                     }else
                     {
//                         Intent returnIntent = new Intent();
//                         returnIntent.putExtra("res", "");
//                         setResult(Activity.RESULT_OK, returnIntent);

                         Connection.MessageBox(Household_Visit.this,"এই খানার ইন্টারভিউ এখানেই শেষ. ধন্যবাদ ");

                         finish();


                     }
//                     if(spnData.equalsIgnoreCase("1"))
//                     {
//                         Bundle IDbundle = new Bundle();
//                         IDbundle.putString("UNCode",UNCODE  );
//                         IDbundle.putString("StructureNo",STRUCTURENO );
//                         IDbundle.putString("HouseholdSl", HOUSEHOLDSL);
//                         IDbundle.putString("VisitNo", VISITNO);
//
//                         Intent intent = new Intent(getApplicationContext(), Household_Interview.class);
//                         intent.putExtras(IDbundle);
//                         startActivityForResult(intent, 1);
//                     }




                 }
             });
             alert.show();


         }
         else{
             Connection.MessageBox(Household_Visit.this, status);
             return;
         }
     }
     catch(Exception  e)
     {
         Connection.MessageBox(Household_Visit.this, e.getMessage());
         return;
     }
 }

 private void DataSearch(String UNCode, String StructureNo, String HouseholdSl, String VisitNo)
     {
       try
        {
     
           RadioButton rb;
           Household_Visit_DataModel d = new Household_Visit_DataModel();
           String SQL = "Select * from "+ TableName +"  Where UNCode='"+ UNCode +"' and StructureNo='"+ StructureNo +"' and HouseholdSl='"+ HouseholdSl +"' and VisitNo='"+ VisitNo +"' and DeviceID='"+DEVICEID+"'";
           List<Household_Visit_DataModel> data = d.SelectAll(this, SQL);
           for(Household_Visit_DataModel item : data){
             txtUNCode.setText(item.getUNCode());
             txtStructureNo.setText(item.getStructureNo());
             txtHouseholdSl.setText(String.valueOf(item.getHouseholdSl()));
             txtVisitNo.setText(item.getVisitNo());

               String[] d_rdogrpHHVisited = new String[] {"1","2"};
                for (int i = 0; i < d_rdogrpHHVisited.length; i++)
               {
                   if (String.valueOf(item.getHHVisited()).equals(String.valueOf(d_rdogrpHHVisited[i])))
                   {
                       if(i==0)
                       {
                           btnAddVisit.setVisibility(View.VISIBLE);
                       }
                       rb = (RadioButton)rdogrpHHVisited.getChildAt(i);
                       rb.setChecked(true);
                   }
               }
               spnOutcome.setSelection(Global.SpinnerItemPositionAnyLength(spnOutcome, String.valueOf(item.getOutcome())));

               String spnData = "";
               if (spnOutcome.getSelectedItem().toString().length() != 0)
               {
                   spnData = Connection.SelectedSpinnerValue(spnOutcome.getSelectedItem().toString(), "-");
               }
               if(spnData.equalsIgnoreCase("1")) {

                   btnAddVisit.setVisibility(View.GONE);
               }
               else{
                   btnAddVisit.setVisibility(View.VISIBLE);
               }

               String check = C.ReturnSingleValue("Select (ifnull(max(cast(VisitNo as int)),0)+1) from Household_Visit where UNCode='"+UNCODE+"'and StructureNo='"+ STRUCTURENO +"'and HouseholdSl='"+ HOUSEHOLDSL +"'"); //where ParticipantID='"+ ParticipantID +"'");

               if(Integer.valueOf(check)>3)
               {
                   btnAddVisit.setVisibility(View.GONE);
               }


             txtOutcomeOth.setText(item.getOutcomeOth());
             txtHHMember.setText(String.valueOf(item.getHHMember()));
             String[] d_rdogrpU18Yrs = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpU18Yrs.length; i++)
             {
                 if (String.valueOf(item.getU18Yrs()).equals(String.valueOf(d_rdogrpU18Yrs[i])))
                 {
                     rb = (RadioButton)rdogrpU18Yrs.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtU18Alive.setText(String.valueOf(item.getU18Alive()));
             String[] d_rdogrpU18YrsDie = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpU18YrsDie.length; i++)
             {
                 if (String.valueOf(item.getU18YrsDie()).equals(String.valueOf(d_rdogrpU18YrsDie[i])))
                 {
                     rb = (RadioButton)rdogrpU18YrsDie.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtU18Death.setText(String.valueOf(item.getU18Death()));


             //*************************************
               String[] d_rdogrpU5Yrs = new String[] {"1","2"};
               for (int i = 0; i < d_rdogrpU5Yrs.length; i++)
               {
                   if (String.valueOf(item.getU5Yrs()).equals(String.valueOf(d_rdogrpU5Yrs[i])))
                   {
                       rb = (RadioButton)rdogrpU5Yrs.getChildAt(i);
                       rb.setChecked(true);
                   }
               }
               txtU5YrsAlive.setText(String.valueOf(item.getU5YrsAlive()));
               String[] d_rdogrpU5YrsDie = new String[] {"1","2"};
               for (int i = 0; i < d_rdogrpU5YrsDie.length; i++)
               {
                   if (String.valueOf(item.getU5YrsDie()).equals(String.valueOf(d_rdogrpU5YrsDie[i])))
                   {
                       rb = (RadioButton)rdogrpU5YrsDie.getChildAt(i);
                       rb.setChecked(true);
                   }
               }
               txtU5YrsDeath.setText(String.valueOf(item.getU5YrsDeath()));
             //*************************************

             String[] d_rdogrpOfferedStudy = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpOfferedStudy.length; i++)
             {
                 if (String.valueOf(item.getOfferedStudy()).equals(String.valueOf(d_rdogrpOfferedStudy[i])))
                 {
                     rb = (RadioButton)rdogrpOfferedStudy.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             spnNotOffered.setSelection(Global.SpinnerItemPositionAnyLength(spnNotOffered, String.valueOf(item.getNotOffered())));
             txtNotOfferedOth.setText(item.getNotOfferedOth());
             String[] d_rdogrpConsent = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpConsent.length; i++)
             {
                 if (String.valueOf(item.getConsent()).equals(String.valueOf(d_rdogrpConsent[i])))
                 {
                     rb = (RadioButton)rdogrpConsent.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtRemarks.setText(item.getRemarks());
             dtpDataCollDate.setText(item.getDataCollDate().toString().length()==0 ? "" : Global.DateConvertDMY(item.getDataCollDate()));

//           cmdSave.setVisibility(View.GONE);

           }
        }
        catch(Exception  e)
        {
            Connection.MessageBox(Household_Visit.this, e.getMessage());
            return;
        }
     }


    public void yesCheck()
    {
        String rbData = "";
        RadioButton rb;
        String[] d_rdogrpU18Yrs = new String[] {"1","2"};
        for (int i = 0; i < rdogrpU18Yrs.getChildCount(); i++)
        {
            rb = (RadioButton)rdogrpU18Yrs.getChildAt(i);
            if (rb.isChecked()) rbData = d_rdogrpU18Yrs[i];
        }

        String rbData2 = "";
        RadioButton rb2;
        String[] d_rdogrpU18YrsDie = new String[] {"1","2"};
        for (int i = 0; i < rdogrpU18YrsDie.getChildCount(); i++)
        {
            rb2 = (RadioButton)rdogrpU18YrsDie.getChildAt(i);
            if (rb2.isChecked()) rbData2 = d_rdogrpU18YrsDie[i];
        }

        String rbData3 = "";
        RadioButton rb3;
        String[] d_rdogrpU5Yrs = new String[] {"1","2"};
        for (int i = 0; i < rdogrpU5Yrs.getChildCount(); i++)
        {
            rb3 = (RadioButton)rdogrpU5Yrs.getChildAt(i);
            if (rb3.isChecked()) rbData3 = d_rdogrpU5Yrs[i];
        }

        String rbData4 = "";
        RadioButton rb4;
        String[] d_rdogrpU5YrsDie = new String[] {"1","2"};
        for (int i = 0; i < rdogrpU5YrsDie.getChildCount(); i++)
        {
            rb4 = (RadioButton)rdogrpU5YrsDie.getChildAt(i);
            if (rb4.isChecked()) rbData4 = d_rdogrpU5YrsDie[i];
        }


        if(rbData.equalsIgnoreCase("1")||rbData2.equalsIgnoreCase("1")||rbData3.equalsIgnoreCase("1")||rbData4.equalsIgnoreCase("1"))
        {
            secOfferedStudy.setVisibility(View.VISIBLE);
            lineOfferedStudy.setVisibility(View.VISIBLE);

        }
        else
        {
            secOfferedStudy.setVisibility(View.GONE);
            lineOfferedStudy.setVisibility(View.GONE);
            rdogrpOfferedStudy.clearCheck();
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


              dtpDate = (EditText)findViewById(R.id.dtpDataCollDate);
             if (VariableID.equals("btnDataCollDate"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpDataCollDate);
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