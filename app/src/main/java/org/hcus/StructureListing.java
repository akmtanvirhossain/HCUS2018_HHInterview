 package org.hcus;


 //Android Manifest Code
 //<activity android:name=".StructureListing" android:label="StructureListing" />

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
 import data_model.StructureListing_DataModel;

 public class StructureListing extends Activity {
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
         LinearLayout secUpazila;
         View lineUpazila;
         TextView VlblUpazila;
         EditText txtUpazila;
         LinearLayout secUNCode;
         View lineUNCode;
         TextView VlblUNCode;
         EditText txtUNCode;
         LinearLayout secVCode;
         View lineVCode;
         TextView VlblVCode;
         EditText txtVCode;
         LinearLayout secCluster;
         View lineCluster;
         TextView VlblCluster;
         EditText txtCluster;
         LinearLayout secStructureNo;
         View lineStructureNo;
         TextView VlblStructureNo;
         EditText txtStructureNo;
         LinearLayout secColDate;
         View lineColDate;
         TextView VlblColDate;
         EditText dtpColDate;
         LinearLayout secColTime;
         View lineColTime;
         TextView VlblColTime;
         EditText txtColTime;
         LinearLayout secStructureStatus;
         View lineStructureStatus;
         TextView VlblStructureStatus;
         Spinner spnStructureStatus;
         LinearLayout secHolding;
         View lineHolding;
         TextView VlblHolding;
         EditText txtHolding;
         LinearLayout secAddress;
         View lineAddress;
         TextView VlblAddress;
         EditText txtAddress;
         LinearLayout secBuildingType;
         View lineBuildingType;
         TextView VlblBuildingType;
         RadioGroup rdogrpBuildingType;
         
         RadioButton rdoBuildingType1;
         RadioButton rdoBuildingType2;
         RadioButton rdoBuildingType3;
         RadioButton rdoBuildingType4;
         LinearLayout secBuildingTypeOth;
         View lineBuildingTypeOth;
         TextView VlblBuildingTypeOth;
         EditText txtBuildingTypeOth;
         LinearLayout secSrtoried;
         View lineSrtoried;
         TextView VlblSrtoried;
         Spinner spnSrtoried;
         LinearLayout secLandmark1;
         View lineLandmark1;
         TextView VlblLandmark1;
         RadioGroup rdogrpLandmark1;
         
         RadioButton rdoLandmark11;
         RadioButton rdoLandmark12;
         LinearLayout secLandmark1Code;
         View lineLandmark1Code;
         TextView VlblLandmark1Code;
         Spinner spnLandmark1Code;
         LinearLayout secLandmarkOth1;
         View lineLandmarkOth1;
         TextView VlblLandmarkOth1;
         EditText txtLandmarkOth1;
         LinearLayout secLandmarkName1;
         View lineLandmarkName1;
         TextView VlblLandmarkName1;
         EditText txtLandmarkName1;
         LinearLayout secLandmark2;
         View lineLandmark2;
         TextView VlblLandmark2;
         RadioGroup rdogrpLandmark2;
         
         RadioButton rdoLandmark21;
         RadioButton rdoLandmark22;
         LinearLayout secLandmark2Code;
         View lineLandmark2Code;
         TextView VlblLandmark2Code;
         Spinner spnLandmark2Code;
         LinearLayout secLandmarkOth2;
         View lineLandmarkOth2;
         TextView VlblLandmarkOth2;
         EditText txtLandmarkOth2;
         LinearLayout secLandmark2Name;
         View lineLandmark2Name;
         TextView VlblLandmark2Name;
         EditText txtLandmark2Name;
         LinearLayout secLandmark3;
         View lineLandmark3;
         TextView VlblLandmark3;
         RadioGroup rdogrpLandmark3;
         
         RadioButton rdoLandmark31;
         RadioButton rdoLandmark32;
         LinearLayout secLandmark3Code;
         View lineLandmark3Code;
         TextView VlblLandmark3Code;
         Spinner spnLandmark3Code;
         LinearLayout secLandmarkOth3;
         View lineLandmarkOth3;
         TextView VlblLandmarkOth3;
         EditText txtLandmarkOth3;
         LinearLayout secLandmark3Name;
         View lineLandmark3Name;
         TextView VlblLandmark3Name;
         EditText txtLandmark3Name;
         LinearLayout secLandmark4;
         View lineLandmark4;
         TextView VlblLandmark4;
         RadioGroup rdogrpLandmark4;
         
         RadioButton rdoLandmark41;
         RadioButton rdoLandmark42;
         LinearLayout secLandmark4Code;
         View lineLandmark4Code;
         TextView VlblLandmark4Code;
         Spinner spnLandmark4Code;
         LinearLayout secLandmarkOth4;
         View lineLandmarkOth4;
         TextView VlblLandmarkOth4;
         EditText txtLandmarkOth4;
         LinearLayout secLandmark4Name;
         View lineLandmark4Name;
         TextView VlblLandmark4Name;
         EditText txtLandmark4Name;
         LinearLayout secOwnerName;
         View lineOwnerName;
         TextView VlblOwnerName;
         EditText txtOwnerName;
         LinearLayout secOccupantName;
         View lineOccupantName;
         TextView VlblOccupantName;
         EditText txtOccupantName;
         LinearLayout secTotHH;
         View lineTotHH;
         TextView VlblTotHH;
         EditText txtTotHH;
         LinearLayout secSlum;
         View lineSlum;
         TextView VlblSlum;
         RadioGroup rdogrpSlum;
         
         RadioButton rdoSlum1;
         RadioButton rdoSlum2;
         LinearLayout secWaypoint;
         View lineWaypoint;
         TextView VlblWaypoint;
         EditText txtWaypoint;
         LinearLayout secLatDeg;
         View lineLatDeg;
         TextView VlblLatDeg;
         EditText txtLatDeg;
         LinearLayout secLatMin;
         View lineLatMin;
         TextView VlblLatMin;
         EditText txtLatMin;
         LinearLayout secLatSec;
         View lineLatSec;
         TextView VlblLatSec;
         EditText txtLatSec;
         LinearLayout secLonDeg;
         View lineLonDeg;
         TextView VlblLonDeg;
         EditText txtLonDeg;
         LinearLayout secLonMin;
         View lineLonMin;
         TextView VlblLonMin;
         EditText txtLonMin;
         LinearLayout secLonSec;
         View lineLonSec;
         TextView VlblLonSec;
         EditText txtLonSec;
         LinearLayout secRemarks;
         View lineRemarks;
         TextView VlblRemarks;
         EditText txtRemarks;



    static String TableName;

    static String STARTTIME = "";
    static String DEVICEID  = "";
    static String ENTRYUSER = "";
    MySharedPreferences sp;

    Bundle IDbundle;
    static String UPAZILA = "";
    static String UNCODE = "";
     static String CLUSTER = "";
     static String MOHOLLA = "";
     static String STRUCTURENO = "";

 public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
   try
     {
         setContentView(R.layout.structurelisting);
         getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

         C = new Connection(this);
         g = Global.getInstance();

         STARTTIME = g.CurrentTime24();
         DEVICEID  = sp.getValue(this, "deviceid");
         ENTRYUSER = sp.getValue(this, "userid");

         IDbundle = getIntent().getExtras();
         UPAZILA = IDbundle.getString("Upazila");
         UNCODE = IDbundle.getString("UNCode");
         MOHOLLA = IDbundle.getString("Moholla");
         CLUSTER = IDbundle.getString("Cluster");
         STRUCTURENO = IDbundle.getString("StructureNo");

         TableName = "StructureListing";

         if(STRUCTURENO.equals(""))
         {
             STRUCTURENO=StructureNoSerial();
         }

         //turnGPSOn();

         //GPS Location
         //FindLocation();
         // Double.toString(currentLatitude);
         // Double.toString(currentLongitude);
         lblHeading = (TextView)findViewById(R.id.lblHeading);

         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(StructureListing.this);
                 adb.setTitle("Close");
                 adb.setMessage("Do you want to close this form[Yes/No]?");
                 adb.setNegativeButton("No", null);
                 adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                     public void onClick(DialogInterface dialog, int which) {
                         finish();
                     }});
                 adb.show();
             }});


         secUpazila=(LinearLayout)findViewById(R.id.secUpazila);
         lineUpazila=(View)findViewById(R.id.lineUpazila);
         VlblUpazila=(TextView) findViewById(R.id.VlblUpazila);
         txtUpazila=(EditText) findViewById(R.id.txtUpazila);
         secUNCode=(LinearLayout)findViewById(R.id.secUNCode);
         lineUNCode=(View)findViewById(R.id.lineUNCode);
         VlblUNCode=(TextView) findViewById(R.id.VlblUNCode);
         txtUNCode=(EditText) findViewById(R.id.txtUNCode);
         secVCode=(LinearLayout)findViewById(R.id.secVCode);
         lineVCode=(View)findViewById(R.id.lineVCode);
         VlblVCode=(TextView) findViewById(R.id.VlblVCode);
         txtVCode=(EditText) findViewById(R.id.txtVCode);
         secCluster=(LinearLayout)findViewById(R.id.secCluster);
         lineCluster=(View)findViewById(R.id.lineCluster);
         VlblCluster=(TextView) findViewById(R.id.VlblCluster);
         txtCluster=(EditText) findViewById(R.id.txtCluster);
         secStructureNo=(LinearLayout)findViewById(R.id.secStructureNo);
         lineStructureNo=(View)findViewById(R.id.lineStructureNo);
         VlblStructureNo=(TextView) findViewById(R.id.VlblStructureNo);
         txtStructureNo=(EditText) findViewById(R.id.txtStructureNo);
         secColDate=(LinearLayout)findViewById(R.id.secColDate);
         lineColDate=(View)findViewById(R.id.lineColDate);
         VlblColDate=(TextView) findViewById(R.id.VlblColDate);
         dtpColDate=(EditText) findViewById(R.id.dtpColDate);
         secColTime=(LinearLayout)findViewById(R.id.secColTime);
         lineColTime=(View)findViewById(R.id.lineColTime);
         VlblColTime=(TextView) findViewById(R.id.VlblColTime);
         txtColTime=(EditText) findViewById(R.id.txtColTime);
         secStructureStatus=(LinearLayout)findViewById(R.id.secStructureStatus);
         lineStructureStatus=(View)findViewById(R.id.lineStructureStatus);
         VlblStructureStatus=(TextView) findViewById(R.id.VlblStructureStatus);
         spnStructureStatus=(Spinner) findViewById(R.id.spnStructureStatus);
         List<String> listStructureStatus = new ArrayList<String>();
         
         listStructureStatus.add("");
         listStructureStatus.add("1-Inside cluster");
         listStructureStatus.add("2-Outside cluster");
         listStructureStatus.add("3-Demolished/does not exist");
         ArrayAdapter<String> adptrStructureStatus= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listStructureStatus);
         spnStructureStatus.setAdapter(adptrStructureStatus);

         spnStructureStatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnStructureStatus.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnStructureStatus.getSelectedItem().toString(), "-");
             }

                 if (spnData.equalsIgnoreCase("1"))
                 {
                     secHolding.setVisibility(View.VISIBLE);
                     lineHolding.setVisibility(View.VISIBLE);
                     secAddress.setVisibility(View.VISIBLE);
                     lineAddress.setVisibility(View.VISIBLE);
                     secBuildingType.setVisibility(View.VISIBLE);
                     lineBuildingType.setVisibility(View.VISIBLE);
//                     secBuildingTypeOth.setVisibility(View.VISIBLE);
//                     lineBuildingTypeOth.setVisibility(View.VISIBLE);
                     secSrtoried.setVisibility(View.VISIBLE);
                     lineSrtoried.setVisibility(View.VISIBLE);
                     secLandmark1.setVisibility(View.VISIBLE);
                     lineLandmark1.setVisibility(View.VISIBLE);
//                     secLandmark1Code.setVisibility(View.VISIBLE);
//                     lineLandmark1Code.setVisibility(View.VISIBLE);
//                     secLandmarkOth1.setVisibility(View.VISIBLE);
//                     lineLandmarkOth1.setVisibility(View.VISIBLE);
//                     secLandmarkName1.setVisibility(View.VISIBLE);
//                     lineLandmarkName1.setVisibility(View.VISIBLE);
//                     secLandmark2.setVisibility(View.VISIBLE);
//                     lineLandmark2.setVisibility(View.VISIBLE);
//                     secLandmark2Code.setVisibility(View.VISIBLE);
//                     lineLandmark2Code.setVisibility(View.VISIBLE);
//                     secLandmarkOth2.setVisibility(View.VISIBLE);
//                     lineLandmarkOth2.setVisibility(View.VISIBLE);
//                     secLandmark2Name.setVisibility(View.VISIBLE);
//                     lineLandmark2Name.setVisibility(View.VISIBLE);
//                     secLandmark3.setVisibility(View.VISIBLE);
//                     lineLandmark3.setVisibility(View.VISIBLE);
//                     secLandmark3Code.setVisibility(View.VISIBLE);
//                     lineLandmark3Code.setVisibility(View.VISIBLE);
//                     secLandmarkOth3.setVisibility(View.VISIBLE);
//                     lineLandmarkOth3.setVisibility(View.VISIBLE);
//                     secLandmark3Name.setVisibility(View.VISIBLE);
//                     lineLandmark3Name.setVisibility(View.VISIBLE);
//                     secLandmark4.setVisibility(View.VISIBLE);
//                     lineLandmark4.setVisibility(View.VISIBLE);
//                     secLandmark4Code.setVisibility(View.VISIBLE);
//                     lineLandmark4Code.setVisibility(View.VISIBLE);
//                     secLandmark4Name.setVisibility(View.VISIBLE);
//                     lineLandmark4Name.setVisibility(View.VISIBLE);
                     secOwnerName.setVisibility(View.VISIBLE);
                     lineOwnerName.setVisibility(View.VISIBLE);
                     secOccupantName.setVisibility(View.VISIBLE);
                     lineOccupantName.setVisibility(View.VISIBLE);
                     secTotHH.setVisibility(View.VISIBLE);
                     lineTotHH.setVisibility(View.VISIBLE);
                     secSlum.setVisibility(View.VISIBLE);
                     lineSlum.setVisibility(View.VISIBLE);
                     secWaypoint.setVisibility(View.VISIBLE);
                     lineWaypoint.setVisibility(View.VISIBLE);
                     secLatDeg.setVisibility(View.VISIBLE);
                     lineLatDeg.setVisibility(View.VISIBLE);
                     secLatMin.setVisibility(View.VISIBLE);
                     lineLatMin.setVisibility(View.VISIBLE);
                     secLatSec.setVisibility(View.VISIBLE);
                     lineLatSec.setVisibility(View.VISIBLE);
                     secLonDeg.setVisibility(View.VISIBLE);
                     lineLonDeg.setVisibility(View.VISIBLE);
                     secLonMin.setVisibility(View.VISIBLE);
                     lineLonMin.setVisibility(View.VISIBLE);
                     secLonSec.setVisibility(View.VISIBLE);
                     lineLonSec.setVisibility(View.VISIBLE);
                     secRemarks.setVisibility(View.VISIBLE);
                     lineRemarks.setVisibility(View.VISIBLE);
                 }

                 //********************Sharif Start********

                 else if (spnData.equalsIgnoreCase("2"))
                 {
                     secHolding.setVisibility(View.VISIBLE);
                     lineHolding.setVisibility(View.VISIBLE);

                     secAddress.setVisibility(View.VISIBLE);
                     lineAddress.setVisibility(View.VISIBLE);

                     secBuildingType.setVisibility(View.GONE);
                     lineBuildingType.setVisibility(View.GONE);
                     rdogrpBuildingType.clearCheck();
                     secBuildingTypeOth.setVisibility(View.GONE);
                     lineBuildingTypeOth.setVisibility(View.GONE);
                     txtBuildingTypeOth.setText("");
                     secSrtoried.setVisibility(View.GONE);
                     lineSrtoried.setVisibility(View.GONE);
                     spnSrtoried.setSelection(0);
                     secLandmark1.setVisibility(View.GONE);
                     lineLandmark1.setVisibility(View.GONE);
                     rdogrpLandmark1.clearCheck();
                     secLandmark1Code.setVisibility(View.GONE);
                     lineLandmark1Code.setVisibility(View.GONE);
                     spnLandmark1Code.setSelection(0);
                     secLandmarkOth1.setVisibility(View.GONE);
                     lineLandmarkOth1.setVisibility(View.GONE);
                     txtLandmarkOth1.setText("");
                     secLandmarkName1.setVisibility(View.GONE);
                     lineLandmarkName1.setVisibility(View.GONE);
                     txtLandmarkName1.setText("");
                     secLandmark2.setVisibility(View.GONE);
                     lineLandmark2.setVisibility(View.GONE);
                     rdogrpLandmark2.clearCheck();
                     secLandmark2Code.setVisibility(View.GONE);
                     lineLandmark2Code.setVisibility(View.GONE);
                     spnLandmark2Code.setSelection(0);
                     secLandmarkOth2.setVisibility(View.GONE);
                     lineLandmarkOth2.setVisibility(View.GONE);
                     txtLandmarkOth2.setText("");
                     secLandmark2Name.setVisibility(View.GONE);
                     lineLandmark2Name.setVisibility(View.GONE);
                     txtLandmark2Name.setText("");
                     secLandmark3.setVisibility(View.GONE);
                     lineLandmark3.setVisibility(View.GONE);
                     rdogrpLandmark3.clearCheck();
                     secLandmark3Code.setVisibility(View.GONE);
                     lineLandmark3Code.setVisibility(View.GONE);
                     spnLandmark3Code.setSelection(0);
                     secLandmarkOth3.setVisibility(View.GONE);
                     lineLandmarkOth3.setVisibility(View.GONE);
                     txtLandmarkOth3.setText("");
                     secLandmark3Name.setVisibility(View.GONE);
                     lineLandmark3Name.setVisibility(View.GONE);
                     txtLandmark3Name.setText("");
                     secLandmark4.setVisibility(View.GONE);
                     lineLandmark4.setVisibility(View.GONE);
                     rdogrpLandmark4.clearCheck();
                     secLandmark4Code.setVisibility(View.GONE);
                     lineLandmark4Code.setVisibility(View.GONE);
                     spnLandmark4Code.setSelection(0);
                     secLandmarkOth4.setVisibility(View.GONE);
                     lineLandmarkOth4.setVisibility(View.GONE);
                     txtLandmarkOth4.setText("");
                     secLandmark4Name.setVisibility(View.GONE);
                     lineLandmark4Name.setVisibility(View.GONE);
                     txtLandmark4Name.setText("");
                     secOwnerName.setVisibility(View.GONE);
                     lineOwnerName.setVisibility(View.GONE);
                     txtOwnerName.setText("");
                     secOccupantName.setVisibility(View.GONE);
                     lineOccupantName.setVisibility(View.GONE);
                     txtOccupantName.setText("");
                     secTotHH.setVisibility(View.GONE);
                     lineTotHH.setVisibility(View.GONE);
                     txtTotHH.setText("");
                     secSlum.setVisibility(View.GONE);
                     lineSlum.setVisibility(View.GONE);
                     rdogrpSlum.clearCheck();
                     secWaypoint.setVisibility(View.GONE);
                     lineWaypoint.setVisibility(View.GONE);
                     txtWaypoint.setText("");
                     secLatDeg.setVisibility(View.GONE);
                     lineLatDeg.setVisibility(View.GONE);
                     txtLatDeg.setText("");
                     secLatMin.setVisibility(View.GONE);
                     lineLatMin.setVisibility(View.GONE);
                     txtLatMin.setText("");
                     secLatSec.setVisibility(View.GONE);
                     lineLatSec.setVisibility(View.GONE);
                     txtLatSec.setText("");
                     secLonDeg.setVisibility(View.GONE);
                     lineLonDeg.setVisibility(View.GONE);
                     txtLonDeg.setText("");
                     secLonMin.setVisibility(View.GONE);
                     lineLonMin.setVisibility(View.GONE);
                     txtLonMin.setText("");
                     secLonSec.setVisibility(View.GONE);
                     lineLonSec.setVisibility(View.GONE);
                     txtLonSec.setText("");

                 }
                 else
                 {
                     secHolding.setVisibility(View.GONE);
                     lineHolding.setVisibility(View.GONE);
                     txtHolding.setText("");
                     secAddress.setVisibility(View.GONE);
                     lineAddress.setVisibility(View.GONE);
                     txtAddress.setText("");
                     secBuildingType.setVisibility(View.GONE);
                     lineBuildingType.setVisibility(View.GONE);
                     rdogrpBuildingType.clearCheck();
                     secBuildingTypeOth.setVisibility(View.GONE);
                     lineBuildingTypeOth.setVisibility(View.GONE);
                     txtBuildingTypeOth.setText("");
                     secSrtoried.setVisibility(View.GONE);
                     lineSrtoried.setVisibility(View.GONE);
                     spnSrtoried.setSelection(0);
                     secLandmark1.setVisibility(View.GONE);
                     lineLandmark1.setVisibility(View.GONE);
                     rdogrpLandmark1.clearCheck();
                     secLandmark1Code.setVisibility(View.GONE);
                     lineLandmark1Code.setVisibility(View.GONE);
                     spnLandmark1Code.setSelection(0);
                     secLandmarkOth1.setVisibility(View.GONE);
                     lineLandmarkOth1.setVisibility(View.GONE);
                     txtLandmarkOth1.setText("");
                     secLandmarkName1.setVisibility(View.GONE);
                     lineLandmarkName1.setVisibility(View.GONE);
                     txtLandmarkName1.setText("");
                     secLandmark2.setVisibility(View.GONE);
                     lineLandmark2.setVisibility(View.GONE);
                     rdogrpLandmark2.clearCheck();
                     secLandmark2Code.setVisibility(View.GONE);
                     lineLandmark2Code.setVisibility(View.GONE);
                     spnLandmark2Code.setSelection(0);
                     secLandmarkOth2.setVisibility(View.GONE);
                     lineLandmarkOth2.setVisibility(View.GONE);
                     txtLandmarkOth2.setText("");
                     secLandmark2Name.setVisibility(View.GONE);
                     lineLandmark2Name.setVisibility(View.GONE);
                     txtLandmark2Name.setText("");
                     secLandmark3.setVisibility(View.GONE);
                     lineLandmark3.setVisibility(View.GONE);
                     rdogrpLandmark3.clearCheck();
                     secLandmark3Code.setVisibility(View.GONE);
                     lineLandmark3Code.setVisibility(View.GONE);
                     spnLandmark3Code.setSelection(0);
                     secLandmarkOth3.setVisibility(View.GONE);
                     lineLandmarkOth3.setVisibility(View.GONE);
                     txtLandmarkOth3.setText("");
                     secLandmark3Name.setVisibility(View.GONE);
                     lineLandmark3Name.setVisibility(View.GONE);
                     txtLandmark3Name.setText("");
                     secLandmark4.setVisibility(View.GONE);
                     lineLandmark4.setVisibility(View.GONE);
                     rdogrpLandmark4.clearCheck();
                     secLandmark4Code.setVisibility(View.GONE);
                     lineLandmark4Code.setVisibility(View.GONE);
                     spnLandmark4Code.setSelection(0);
                     secLandmarkOth4.setVisibility(View.GONE);
                     lineLandmarkOth4.setVisibility(View.GONE);
                     txtLandmarkOth4.setText("");
                     secLandmark4Name.setVisibility(View.GONE);
                     lineLandmark4Name.setVisibility(View.GONE);
                     txtLandmark4Name.setText("");
                     secOwnerName.setVisibility(View.GONE);
                     lineOwnerName.setVisibility(View.GONE);
                     txtOwnerName.setText("");
                     secOccupantName.setVisibility(View.GONE);
                     lineOccupantName.setVisibility(View.GONE);
                     txtOccupantName.setText("");
                     secTotHH.setVisibility(View.GONE);
                     lineTotHH.setVisibility(View.GONE);
                     txtTotHH.setText("");
                     secSlum.setVisibility(View.GONE);
                     lineSlum.setVisibility(View.GONE);
                     rdogrpSlum.clearCheck();
                     secWaypoint.setVisibility(View.GONE);
                     lineWaypoint.setVisibility(View.GONE);
                     txtWaypoint.setText("");
                     secLatDeg.setVisibility(View.GONE);
                     lineLatDeg.setVisibility(View.GONE);
                     txtLatDeg.setText("");
                     secLatMin.setVisibility(View.GONE);
                     lineLatMin.setVisibility(View.GONE);
                     txtLatMin.setText("");
                     secLatSec.setVisibility(View.GONE);
                     lineLatSec.setVisibility(View.GONE);
                     txtLatSec.setText("");
                     secLonDeg.setVisibility(View.GONE);
                     lineLonDeg.setVisibility(View.GONE);
                     txtLonDeg.setText("");
                     secLonMin.setVisibility(View.GONE);
                     lineLonMin.setVisibility(View.GONE);
                     txtLonMin.setText("");
                     secLonSec.setVisibility(View.GONE);
                     lineLonSec.setVisibility(View.GONE);
                     txtLonSec.setText("");
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secHolding=(LinearLayout)findViewById(R.id.secHolding);
         lineHolding=(View)findViewById(R.id.lineHolding);
         VlblHolding=(TextView) findViewById(R.id.VlblHolding);
         txtHolding=(EditText) findViewById(R.id.txtHolding);
         secAddress=(LinearLayout)findViewById(R.id.secAddress);
         lineAddress=(View)findViewById(R.id.lineAddress);
         VlblAddress=(TextView) findViewById(R.id.VlblAddress);
         txtAddress=(EditText) findViewById(R.id.txtAddress);
         secBuildingType=(LinearLayout)findViewById(R.id.secBuildingType);
         lineBuildingType=(View)findViewById(R.id.lineBuildingType);
         VlblBuildingType = (TextView) findViewById(R.id.VlblBuildingType);
         rdogrpBuildingType = (RadioGroup) findViewById(R.id.rdogrpBuildingType);
         
         rdoBuildingType1 = (RadioButton) findViewById(R.id.rdoBuildingType1);
         rdoBuildingType2 = (RadioButton) findViewById(R.id.rdoBuildingType2);
         rdoBuildingType3 = (RadioButton) findViewById(R.id.rdoBuildingType3);
         rdoBuildingType4 = (RadioButton) findViewById(R.id.rdoBuildingType4);
         rdogrpBuildingType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpBuildingType = new String[] {"1","2","3","7"};
             for (int i = 0; i < rdogrpBuildingType.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpBuildingType.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpBuildingType[i];
             }

             if(rbData.equalsIgnoreCase("1"))
             {
                    secBuildingTypeOth.setVisibility(View.GONE);
                    lineBuildingTypeOth.setVisibility(View.GONE);
                    txtBuildingTypeOth.setText("");
             }
             else if(rbData.equalsIgnoreCase("2"))
             {
                    secBuildingTypeOth.setVisibility(View.GONE);
                    lineBuildingTypeOth.setVisibility(View.GONE);
                    txtBuildingTypeOth.setText("");
             }
             else if(rbData.equalsIgnoreCase("3"))
             {
                    secBuildingTypeOth.setVisibility(View.GONE);
                    lineBuildingTypeOth.setVisibility(View.GONE);
                    txtBuildingTypeOth.setText("");
             }
             else
             {
                    secBuildingTypeOth.setVisibility(View.VISIBLE);
                    lineBuildingTypeOth.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secBuildingTypeOth=(LinearLayout)findViewById(R.id.secBuildingTypeOth);
         lineBuildingTypeOth=(View)findViewById(R.id.lineBuildingTypeOth);
         VlblBuildingTypeOth=(TextView) findViewById(R.id.VlblBuildingTypeOth);
         txtBuildingTypeOth=(EditText) findViewById(R.id.txtBuildingTypeOth);
         secSrtoried=(LinearLayout)findViewById(R.id.secSrtoried);
         lineSrtoried=(View)findViewById(R.id.lineSrtoried);
         VlblSrtoried=(TextView) findViewById(R.id.VlblSrtoried);
         spnSrtoried=(Spinner) findViewById(R.id.spnSrtoried);
         List<String> listSrtoried = new ArrayList<String>();
         
         listSrtoried.add("");
         listSrtoried.add("1");
         listSrtoried.add("2");
         listSrtoried.add("3");
         listSrtoried.add("4");
         listSrtoried.add("5");
         listSrtoried.add("6");
         listSrtoried.add("7");
         listSrtoried.add("8");
         listSrtoried.add("9");
         listSrtoried.add("10");
         listSrtoried.add("11");
         listSrtoried.add("12");
         listSrtoried.add("13");
         listSrtoried.add("14");
         listSrtoried.add("15");
         listSrtoried.add("16");
         listSrtoried.add("17");
         listSrtoried.add("18");
         listSrtoried.add("19");
         listSrtoried.add("20");
         ArrayAdapter<String> adptrSrtoried= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listSrtoried);
         spnSrtoried.setAdapter(adptrSrtoried);

         secLandmark1=(LinearLayout)findViewById(R.id.secLandmark1);
         lineLandmark1=(View)findViewById(R.id.lineLandmark1);
         VlblLandmark1 = (TextView) findViewById(R.id.VlblLandmark1);
         rdogrpLandmark1 = (RadioGroup) findViewById(R.id.rdogrpLandmark1);
         
         rdoLandmark11 = (RadioButton) findViewById(R.id.rdoLandmark11);
         rdoLandmark12 = (RadioButton) findViewById(R.id.rdoLandmark12);
         rdogrpLandmark1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpLandmark1 = new String[] {"1","2"};
             for (int i = 0; i < rdogrpLandmark1.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpLandmark1.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpLandmark1[i];
             }

             //****Sharif******
             if(rbData.equalsIgnoreCase("1"))
             {

                 secLandmark1Code.setVisibility(View.VISIBLE);
                 lineLandmark1Code.setVisibility(View.VISIBLE);
                 secLandmarkName1.setVisibility(View.VISIBLE);
                 lineLandmarkName1.setVisibility(View.VISIBLE);
                 secLandmark2.setVisibility(View.VISIBLE);
                 lineLandmark2.setVisibility(View.VISIBLE);

//                 secLandmark1Code.setVisibility(View.GONE);
//                 lineLandmark1Code.setVisibility(View.GONE);
//                 spnLandmark1Code.setSelection(0);
                 secLandmarkOth1.setVisibility(View.GONE);
                 lineLandmarkOth1.setVisibility(View.GONE);
                 txtLandmarkOth1.setText("");
//                 secLandmarkName1.setVisibility(View.GONE);
//                 lineLandmarkName1.setVisibility(View.GONE);
//                 txtLandmarkName1.setText("");
//                 secLandmark2.setVisibility(View.GONE);
//                 lineLandmark2.setVisibility(View.GONE);
//                 rdogrpLandmark2.clearCheck();
                 secLandmark2Code.setVisibility(View.GONE);
                 lineLandmark2Code.setVisibility(View.GONE);
                 spnLandmark2Code.setSelection(0);
                 secLandmarkOth2.setVisibility(View.GONE);
                 lineLandmarkOth2.setVisibility(View.GONE);
                 txtLandmarkOth2.setText("");
                 secLandmark2Name.setVisibility(View.GONE);
                 lineLandmark2Name.setVisibility(View.GONE);
                 txtLandmark2Name.setText("");
                 secLandmark3.setVisibility(View.GONE);
                 lineLandmark3.setVisibility(View.GONE);
                 rdogrpLandmark3.clearCheck();
                 secLandmark3Code.setVisibility(View.GONE);
                 lineLandmark3Code.setVisibility(View.GONE);
                 spnLandmark3Code.setSelection(0);
                 secLandmarkOth3.setVisibility(View.GONE);
                 lineLandmarkOth3.setVisibility(View.GONE);
                 txtLandmarkOth3.setText("");
                 secLandmark3Name.setVisibility(View.GONE);
                 lineLandmark3Name.setVisibility(View.GONE);
                 txtLandmark3Name.setText("");
                 secLandmark4.setVisibility(View.GONE);
                 lineLandmark4.setVisibility(View.GONE);
                 rdogrpLandmark4.clearCheck();
                 secLandmark4Code.setVisibility(View.GONE);
                 lineLandmark4Code.setVisibility(View.GONE);
                 spnLandmark4Code.setSelection(0);
                 secLandmarkOth4.setVisibility(View.GONE);
                 lineLandmarkOth4.setVisibility(View.GONE);
                 txtLandmarkOth4.setText("");
                 secLandmark4Name.setVisibility(View.GONE);
                 lineLandmark4Name.setVisibility(View.GONE);
                 txtLandmark4Name.setText("");
             }

             ///****sharif******

             else
             {
                    secLandmark1Code.setVisibility(View.GONE);
                    lineLandmark1Code.setVisibility(View.GONE);
                    spnLandmark1Code.setSelection(0);
                    secLandmarkOth1.setVisibility(View.GONE);
                    lineLandmarkOth1.setVisibility(View.GONE);
                    txtLandmarkOth1.setText("");
                    secLandmarkName1.setVisibility(View.GONE);
                    lineLandmarkName1.setVisibility(View.GONE);
                    txtLandmarkName1.setText("");
                    secLandmark2.setVisibility(View.GONE);
                    lineLandmark2.setVisibility(View.GONE);
                    rdogrpLandmark2.clearCheck();
                    secLandmark2Code.setVisibility(View.GONE);
                    lineLandmark2Code.setVisibility(View.GONE);
                    spnLandmark2Code.setSelection(0);
                    secLandmarkOth2.setVisibility(View.GONE);
                    lineLandmarkOth2.setVisibility(View.GONE);
                    txtLandmarkOth2.setText("");
                    secLandmark2Name.setVisibility(View.GONE);
                    lineLandmark2Name.setVisibility(View.GONE);
                    txtLandmark2Name.setText("");
                    secLandmark3.setVisibility(View.GONE);
                    lineLandmark3.setVisibility(View.GONE);
                    rdogrpLandmark3.clearCheck();
                    secLandmark3Code.setVisibility(View.GONE);
                    lineLandmark3Code.setVisibility(View.GONE);
                    spnLandmark3Code.setSelection(0);
                    secLandmarkOth3.setVisibility(View.GONE);
                    lineLandmarkOth3.setVisibility(View.GONE);
                    txtLandmarkOth3.setText("");
                    secLandmark3Name.setVisibility(View.GONE);
                    lineLandmark3Name.setVisibility(View.GONE);
                    txtLandmark3Name.setText("");
                    secLandmark4.setVisibility(View.GONE);
                    lineLandmark4.setVisibility(View.GONE);
                    rdogrpLandmark4.clearCheck();
                    secLandmark4Code.setVisibility(View.GONE);
                    lineLandmark4Code.setVisibility(View.GONE);
                    spnLandmark4Code.setSelection(0);
                    secLandmarkOth4.setVisibility(View.GONE);
                    lineLandmarkOth4.setVisibility(View.GONE);
                    txtLandmarkOth4.setText("");
                    secLandmark4Name.setVisibility(View.GONE);
                    lineLandmark4Name.setVisibility(View.GONE);
                    txtLandmark4Name.setText("");
             }
//             else
//             {
//                    secLandmark1Code.setVisibility(View.VISIBLE);
//                    lineLandmark1Code.setVisibility(View.VISIBLE);
//                    secLandmarkOth1.setVisibility(View.VISIBLE);
//                    lineLandmarkOth1.setVisibility(View.VISIBLE);
//                    secLandmarkName1.setVisibility(View.VISIBLE);
//                    lineLandmarkName1.setVisibility(View.VISIBLE);
//                    secLandmark2.setVisibility(View.VISIBLE);
//                    lineLandmark2.setVisibility(View.VISIBLE);
//                    secLandmark2Code.setVisibility(View.VISIBLE);
//                    lineLandmark2Code.setVisibility(View.VISIBLE);
//                    secLandmarkOth2.setVisibility(View.VISIBLE);
//                    lineLandmarkOth2.setVisibility(View.VISIBLE);
//                    secLandmark2Name.setVisibility(View.VISIBLE);
//                    lineLandmark2Name.setVisibility(View.VISIBLE);
//                    secLandmark3.setVisibility(View.VISIBLE);
//                    lineLandmark3.setVisibility(View.VISIBLE);
//                    secLandmark3Code.setVisibility(View.VISIBLE);
//                    lineLandmark3Code.setVisibility(View.VISIBLE);
//                    secLandmarkOth3.setVisibility(View.VISIBLE);
//                    lineLandmarkOth3.setVisibility(View.VISIBLE);
//                    secLandmark3Name.setVisibility(View.VISIBLE);
//                    lineLandmark3Name.setVisibility(View.VISIBLE);
//                    secLandmark4.setVisibility(View.VISIBLE);
//                    lineLandmark4.setVisibility(View.VISIBLE);
//                    secLandmark4Code.setVisibility(View.VISIBLE);
//                    lineLandmark4Code.setVisibility(View.VISIBLE);
//                    secLandmark4Name.setVisibility(View.VISIBLE);
//                    lineLandmark4Name.setVisibility(View.VISIBLE);
//             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secLandmark1Code=(LinearLayout)findViewById(R.id.secLandmark1Code);
         lineLandmark1Code=(View)findViewById(R.id.lineLandmark1Code);
         VlblLandmark1Code=(TextView) findViewById(R.id.VlblLandmark1Code);
         spnLandmark1Code=(Spinner) findViewById(R.id.spnLandmark1Code);
         List<String> listLandmark1Code = new ArrayList<String>();
         
         listLandmark1Code.add("");
         listLandmark1Code.add("2-School");
         listLandmark1Code.add("3-College");
         listLandmark1Code.add("4-Hospital/Clinic");
         listLandmark1Code.add("5-Mosque");
         listLandmark1Code.add("6-Pharmacy");
         listLandmark1Code.add("7-Diagnostic center");
         listLandmark1Code.add("8-Shopping mall/Market");
         listLandmark1Code.add("9-General store/Super shop");
         listLandmark1Code.add("10-Bank");
         listLandmark1Code.add("11-Office");
         listLandmark1Code.add("77-Other");
         listLandmark1Code.add("");
         ArrayAdapter<String> adptrLandmark1Code= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listLandmark1Code);
         spnLandmark1Code.setAdapter(adptrLandmark1Code);

         spnLandmark1Code.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnLandmark1Code.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnLandmark1Code.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("77"))
                 {
                     secLandmarkOth1.setVisibility(View.VISIBLE);
                     lineLandmarkOth1.setVisibility(View.VISIBLE);
                 }

                 else
                 {
                    secLandmarkOth1.setVisibility(View.GONE);
                    lineLandmarkOth1.setVisibility(View.GONE);
                    txtLandmarkOth1.setText("");
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secLandmarkOth1=(LinearLayout)findViewById(R.id.secLandmarkOth1);
         lineLandmarkOth1=(View)findViewById(R.id.lineLandmarkOth1);
         VlblLandmarkOth1=(TextView) findViewById(R.id.VlblLandmarkOth1);
         txtLandmarkOth1=(EditText) findViewById(R.id.txtLandmarkOth1);
         secLandmarkName1=(LinearLayout)findViewById(R.id.secLandmarkName1);
         lineLandmarkName1=(View)findViewById(R.id.lineLandmarkName1);
         VlblLandmarkName1=(TextView) findViewById(R.id.VlblLandmarkName1);
         txtLandmarkName1=(EditText) findViewById(R.id.txtLandmarkName1);
         secLandmark2=(LinearLayout)findViewById(R.id.secLandmark2);
         lineLandmark2=(View)findViewById(R.id.lineLandmark2);
         VlblLandmark2 = (TextView) findViewById(R.id.VlblLandmark2);
         rdogrpLandmark2 = (RadioGroup) findViewById(R.id.rdogrpLandmark2);
         
         rdoLandmark21 = (RadioButton) findViewById(R.id.rdoLandmark21);
         rdoLandmark22 = (RadioButton) findViewById(R.id.rdoLandmark22);
         rdogrpLandmark2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpLandmark2 = new String[] {"1","2"};
             for (int i = 0; i < rdogrpLandmark2.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpLandmark2.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpLandmark2[i];
             }

             if(rbData.equalsIgnoreCase("1"))
             {
                 secLandmark2Code.setVisibility(View.VISIBLE);
                 lineLandmark2Code.setVisibility(View.VISIBLE);
                 secLandmark2Name.setVisibility(View.VISIBLE);
                 lineLandmark2Name.setVisibility(View.VISIBLE);
                 secLandmark3.setVisibility(View.VISIBLE);
                 lineLandmark3.setVisibility(View.VISIBLE);

//                    secLandmark2Code.setVisibility(View.GONE);
//                    lineLandmark2Code.setVisibility(View.GONE);
//                    spnLandmark2Code.setSelection(0);
                    secLandmarkOth2.setVisibility(View.GONE);
                    lineLandmarkOth2.setVisibility(View.GONE);
                    txtLandmarkOth2.setText("");
//                    secLandmark2Name.setVisibility(View.GONE);
//                    lineLandmark2Name.setVisibility(View.GONE);
//                    txtLandmark2Name.setText("");
//                    secLandmark3.setVisibility(View.GONE);
//                    lineLandmark3.setVisibility(View.GONE);
//                    rdogrpLandmark3.clearCheck();
                    secLandmark3Code.setVisibility(View.GONE);
                    lineLandmark3Code.setVisibility(View.GONE);
                    spnLandmark3Code.setSelection(0);
                    secLandmarkOth3.setVisibility(View.GONE);
                    lineLandmarkOth3.setVisibility(View.GONE);
                    txtLandmarkOth3.setText("");
                    secLandmark3Name.setVisibility(View.GONE);
                    lineLandmark3Name.setVisibility(View.GONE);
                    txtLandmark3Name.setText("");
                    secLandmark4.setVisibility(View.GONE);
                    lineLandmark4.setVisibility(View.GONE);
                    rdogrpLandmark4.clearCheck();
                    secLandmark4Code.setVisibility(View.GONE);
                    lineLandmark4Code.setVisibility(View.GONE);
                    spnLandmark4Code.setSelection(0);
                    secLandmarkOth4.setVisibility(View.GONE);
                    lineLandmarkOth4.setVisibility(View.GONE);
                    txtLandmarkOth4.setText("");
                    secLandmark4Name.setVisibility(View.GONE);
                    lineLandmark4Name.setVisibility(View.GONE);
                    txtLandmark4Name.setText("");
             }
             else
             {
                 secLandmark2Code.setVisibility(View.GONE);
                 lineLandmark2Code.setVisibility(View.GONE);
                 spnLandmark2Code.setSelection(0);
                 secLandmarkOth2.setVisibility(View.GONE);
                 lineLandmarkOth2.setVisibility(View.GONE);
                 txtLandmarkOth2.setText("");
                 secLandmark2Name.setVisibility(View.GONE);
                 lineLandmark2Name.setVisibility(View.GONE);
                 txtLandmark2Name.setText("");
                 secLandmark3.setVisibility(View.GONE);
                 lineLandmark3.setVisibility(View.GONE);
                 rdogrpLandmark3.clearCheck();
                 secLandmark3Code.setVisibility(View.GONE);
                 lineLandmark3Code.setVisibility(View.GONE);
                 spnLandmark3Code.setSelection(0);
                 secLandmarkOth3.setVisibility(View.GONE);
                 lineLandmarkOth3.setVisibility(View.GONE);
                 txtLandmarkOth3.setText("");
                 secLandmark3Name.setVisibility(View.GONE);
                 lineLandmark3Name.setVisibility(View.GONE);
                 txtLandmark3Name.setText("");
                 secLandmark4.setVisibility(View.GONE);
                 lineLandmark4.setVisibility(View.GONE);
                 rdogrpLandmark4.clearCheck();
                 secLandmark4Code.setVisibility(View.GONE);
                 lineLandmark4Code.setVisibility(View.GONE);
                 spnLandmark4Code.setSelection(0);
                 secLandmarkOth4.setVisibility(View.GONE);
                 lineLandmarkOth4.setVisibility(View.GONE);
                 txtLandmarkOth4.setText("");
                 secLandmark4Name.setVisibility(View.GONE);
                 lineLandmark4Name.setVisibility(View.GONE);
                 txtLandmark4Name.setText("");
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secLandmark2Code=(LinearLayout)findViewById(R.id.secLandmark2Code);
         lineLandmark2Code=(View)findViewById(R.id.lineLandmark2Code);
         VlblLandmark2Code=(TextView) findViewById(R.id.VlblLandmark2Code);
         spnLandmark2Code=(Spinner) findViewById(R.id.spnLandmark2Code);
         List<String> listLandmark2Code = new ArrayList<String>();
         
         listLandmark2Code.add("");
         listLandmark2Code.add("2-School");
         listLandmark2Code.add("3-College");
         listLandmark2Code.add("4-Hospital/Clinic");
         listLandmark2Code.add("5-Mosque");
         listLandmark2Code.add("6-Pharmacy");
         listLandmark2Code.add("7-Diagnostic center");
         listLandmark2Code.add("8-Shopping mall/Market");
         listLandmark2Code.add("9-General store/Super shop");
         listLandmark2Code.add("10-Bank");
         listLandmark2Code.add("11-Office");
         listLandmark2Code.add("77-Other");
         listLandmark2Code.add("");
         ArrayAdapter<String> adptrLandmark2Code= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listLandmark2Code);
         spnLandmark2Code.setAdapter(adptrLandmark2Code);

         spnLandmark2Code.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnLandmark2Code.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnLandmark2Code.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("77"))
                 {
                     secLandmarkOth2.setVisibility(View.VISIBLE);
                     lineLandmarkOth2.setVisibility(View.VISIBLE);
                 }
                 else
                 {
                    secLandmarkOth2.setVisibility(View.GONE);
                    lineLandmarkOth2.setVisibility(View.GONE);
                    txtLandmarkOth2.setText("");
                 }

             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secLandmarkOth2=(LinearLayout)findViewById(R.id.secLandmarkOth2);
         lineLandmarkOth2=(View)findViewById(R.id.lineLandmarkOth2);
         VlblLandmarkOth2=(TextView) findViewById(R.id.VlblLandmarkOth2);
         txtLandmarkOth2=(EditText) findViewById(R.id.txtLandmarkOth2);
         secLandmark2Name=(LinearLayout)findViewById(R.id.secLandmark2Name);
         lineLandmark2Name=(View)findViewById(R.id.lineLandmark2Name);
         VlblLandmark2Name=(TextView) findViewById(R.id.VlblLandmark2Name);
         txtLandmark2Name=(EditText) findViewById(R.id.txtLandmark2Name);
         secLandmark3=(LinearLayout)findViewById(R.id.secLandmark3);
         lineLandmark3=(View)findViewById(R.id.lineLandmark3);
         VlblLandmark3 = (TextView) findViewById(R.id.VlblLandmark3);
         rdogrpLandmark3 = (RadioGroup) findViewById(R.id.rdogrpLandmark3);
         
         rdoLandmark31 = (RadioButton) findViewById(R.id.rdoLandmark31);
         rdoLandmark32 = (RadioButton) findViewById(R.id.rdoLandmark32);
         rdogrpLandmark3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpLandmark3 = new String[] {"1","2"};
             for (int i = 0; i < rdogrpLandmark3.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpLandmark3.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpLandmark3[i];
             }

             if(rbData.equalsIgnoreCase("1"))
             {
                 secLandmark3Code.setVisibility(View.VISIBLE);
                 lineLandmark3Code.setVisibility(View.VISIBLE);
                 secLandmark3Name.setVisibility(View.VISIBLE);
                 lineLandmark3Name.setVisibility(View.VISIBLE);
                 secLandmark4.setVisibility(View.VISIBLE);
                 lineLandmark4.setVisibility(View.VISIBLE);

//                    secLandmark3Code.setVisibility(View.GONE);
//                    lineLandmark3Code.setVisibility(View.GONE);
//                    spnLandmark3Code.setSelection(0);
                    secLandmarkOth3.setVisibility(View.GONE);
                    lineLandmarkOth3.setVisibility(View.GONE);
                    txtLandmarkOth3.setText("");
//                    secLandmark3Name.setVisibility(View.GONE);
//                    lineLandmark3Name.setVisibility(View.GONE);
//                    txtLandmark3Name.setText("");
//                    secLandmark4.setVisibility(View.GONE);
//                    lineLandmark4.setVisibility(View.GONE);
//                    rdogrpLandmark4.clearCheck();
                    secLandmark4Code.setVisibility(View.GONE);
                    lineLandmark4Code.setVisibility(View.GONE);
                    spnLandmark4Code.setSelection(0);
                    secLandmarkOth4.setVisibility(View.GONE);
                    lineLandmarkOth4.setVisibility(View.GONE);
                    txtLandmarkOth4.setText("");
                    secLandmark4Name.setVisibility(View.GONE);
                    lineLandmark4Name.setVisibility(View.GONE);
                    txtLandmark4Name.setText("");
             }
             else
             {
                 secLandmark3Code.setVisibility(View.GONE);
                 lineLandmark3Code.setVisibility(View.GONE);
                 spnLandmark3Code.setSelection(0);
                 secLandmarkOth3.setVisibility(View.GONE);
                 lineLandmarkOth3.setVisibility(View.GONE);
                 txtLandmarkOth3.setText("");
                 secLandmark3Name.setVisibility(View.GONE);
                 lineLandmark3Name.setVisibility(View.GONE);
                 txtLandmark3Name.setText("");
                 secLandmark4.setVisibility(View.GONE);
                 lineLandmark4.setVisibility(View.GONE);
                 rdogrpLandmark4.clearCheck();
                 secLandmark4Code.setVisibility(View.GONE);
                 lineLandmark4Code.setVisibility(View.GONE);
                 spnLandmark4Code.setSelection(0);
                 secLandmarkOth4.setVisibility(View.GONE);
                 lineLandmarkOth4.setVisibility(View.GONE);
                 txtLandmarkOth4.setText("");
                 secLandmark4Name.setVisibility(View.GONE);
                 lineLandmark4Name.setVisibility(View.GONE);
                 txtLandmark4Name.setText("");
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secLandmark3Code=(LinearLayout)findViewById(R.id.secLandmark3Code);
         lineLandmark3Code=(View)findViewById(R.id.lineLandmark3Code);
         VlblLandmark3Code=(TextView) findViewById(R.id.VlblLandmark3Code);
         spnLandmark3Code=(Spinner) findViewById(R.id.spnLandmark3Code);
         List<String> listLandmark3Code = new ArrayList<String>();
         
         listLandmark3Code.add("");
         listLandmark3Code.add("2-School");
         listLandmark3Code.add("3-College");
         listLandmark3Code.add("4-Hospital/Clinic");
         listLandmark3Code.add("5-Mosque");
         listLandmark3Code.add("6-Pharmacy");
         listLandmark3Code.add("7-Diagnostic center");
         listLandmark3Code.add("8-Shopping mall/Market");
         listLandmark3Code.add("9-General store/Super shop");
         listLandmark3Code.add("10-Bank");
         listLandmark3Code.add("11-Office");
         listLandmark3Code.add("77-Other");
         listLandmark3Code.add("");
         ArrayAdapter<String> adptrLandmark3Code= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listLandmark3Code);
         spnLandmark3Code.setAdapter(adptrLandmark3Code);

         spnLandmark3Code.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnLandmark3Code.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnLandmark3Code.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("77"))
                 {
                     secLandmarkOth3.setVisibility(View.VISIBLE);
                     lineLandmarkOth3.setVisibility(View.VISIBLE);
                 }
                 else
                 {
                    secLandmarkOth3.setVisibility(View.GONE);
                    lineLandmarkOth3.setVisibility(View.GONE);
                    txtLandmarkOth3.setText("");
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secLandmarkOth3=(LinearLayout)findViewById(R.id.secLandmarkOth3);
         lineLandmarkOth3=(View)findViewById(R.id.lineLandmarkOth3);
         VlblLandmarkOth3=(TextView) findViewById(R.id.VlblLandmarkOth3);
         txtLandmarkOth3=(EditText) findViewById(R.id.txtLandmarkOth3);
         secLandmark3Name=(LinearLayout)findViewById(R.id.secLandmark3Name);
         lineLandmark3Name=(View)findViewById(R.id.lineLandmark3Name);
         VlblLandmark3Name=(TextView) findViewById(R.id.VlblLandmark3Name);
         txtLandmark3Name=(EditText) findViewById(R.id.txtLandmark3Name);
         secLandmark4=(LinearLayout)findViewById(R.id.secLandmark4);
         lineLandmark4=(View)findViewById(R.id.lineLandmark4);
         VlblLandmark4 = (TextView) findViewById(R.id.VlblLandmark4);
         rdogrpLandmark4 = (RadioGroup) findViewById(R.id.rdogrpLandmark4);

         rdogrpLandmark4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(RadioGroup radioGroup, int radioButtonID) {
                 String rbData = "";
                 RadioButton rb;
                 String[] d_rdogrpLandmark3 = new String[] {"1","2"};
                 for (int i = 0; i < rdogrpLandmark4.getChildCount(); i++)
                 {
                     rb = (RadioButton)rdogrpLandmark4.getChildAt(i);
                     if (rb.isChecked()) rbData = d_rdogrpLandmark3[i];
                 }
                 if(rbData.equalsIgnoreCase("1"))
                 {
                     secLandmark4Code.setVisibility(View.VISIBLE);
                     lineLandmark4Code.setVisibility(View.VISIBLE);
                     secLandmark4Name.setVisibility(View.VISIBLE);
                     lineLandmark4Name.setVisibility(View.VISIBLE);
                 }else
                 {
                     secLandmark4Code.setVisibility(View.GONE);
                     lineLandmark4Code.setVisibility(View.GONE);
                     spnLandmark4Code.setSelection(0);
                     secLandmarkOth4.setVisibility(View.GONE);
                     lineLandmarkOth4.setVisibility(View.GONE);
                     txtLandmarkOth4.setText("");
                     secLandmark4Name.setVisibility(View.GONE);
                     lineLandmark4Name.setVisibility(View.GONE);
                     txtLandmark4Name.setText("");
                 }

             }
         });
         
         rdoLandmark41 = (RadioButton) findViewById(R.id.rdoLandmark41);
         rdoLandmark42 = (RadioButton) findViewById(R.id.rdoLandmark42);
         secLandmark4Code=(LinearLayout)findViewById(R.id.secLandmark4Code);
         lineLandmark4Code=(View)findViewById(R.id.lineLandmark4Code);
         VlblLandmark4Code=(TextView) findViewById(R.id.VlblLandmark4Code);
         spnLandmark4Code=(Spinner) findViewById(R.id.spnLandmark4Code);
         List<String> listLandmark4Code = new ArrayList<String>();
         
         listLandmark4Code.add("");
         listLandmark4Code.add("2-School");
         listLandmark4Code.add("3-College");
         listLandmark4Code.add("4-Hospital/Clinic");
         listLandmark4Code.add("5-Mosque");
         listLandmark4Code.add("6-Pharmacy");
         listLandmark4Code.add("7-Diagnostic center");
         listLandmark4Code.add("8-Shopping mall/Market");
         listLandmark4Code.add("9-General store/Super shop");
         listLandmark4Code.add("10-Bank");
         listLandmark4Code.add("11-Office");
         listLandmark4Code.add("77-Other");
         listLandmark4Code.add("");
         ArrayAdapter<String> adptrLandmark4Code= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listLandmark4Code);
         spnLandmark4Code.setAdapter(adptrLandmark4Code);

         spnLandmark4Code.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnLandmark4Code.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnLandmark4Code.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("77"))
                 {
                     secLandmarkOth4.setVisibility(View.VISIBLE);
                     lineLandmarkOth4.setVisibility(View.VISIBLE);
                 }
                 else
                 {
                    secLandmarkOth4.setVisibility(View.GONE);
                    lineLandmarkOth4.setVisibility(View.GONE);
                    txtLandmarkOth4.setText("");
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secLandmarkOth4=(LinearLayout)findViewById(R.id.secLandmarkOth4);
         lineLandmarkOth4=(View)findViewById(R.id.lineLandmarkOth4);
         VlblLandmarkOth4=(TextView) findViewById(R.id.VlblLandmarkOth4);
         txtLandmarkOth4=(EditText) findViewById(R.id.txtLandmarkOth4);
         secLandmark4Name=(LinearLayout)findViewById(R.id.secLandmark4Name);
         lineLandmark4Name=(View)findViewById(R.id.lineLandmark4Name);
         VlblLandmark4Name=(TextView) findViewById(R.id.VlblLandmark4Name);
         txtLandmark4Name=(EditText) findViewById(R.id.txtLandmark4Name);
         secOwnerName=(LinearLayout)findViewById(R.id.secOwnerName);
         lineOwnerName=(View)findViewById(R.id.lineOwnerName);
         VlblOwnerName=(TextView) findViewById(R.id.VlblOwnerName);
         txtOwnerName=(EditText) findViewById(R.id.txtOwnerName);
         secOccupantName=(LinearLayout)findViewById(R.id.secOccupantName);
         lineOccupantName=(View)findViewById(R.id.lineOccupantName);
         VlblOccupantName=(TextView) findViewById(R.id.VlblOccupantName);
         txtOccupantName=(EditText) findViewById(R.id.txtOccupantName);
         secTotHH=(LinearLayout)findViewById(R.id.secTotHH);
         lineTotHH=(View)findViewById(R.id.lineTotHH);
         VlblTotHH=(TextView) findViewById(R.id.VlblTotHH);
         txtTotHH=(EditText) findViewById(R.id.txtTotHH);
         secSlum=(LinearLayout)findViewById(R.id.secSlum);
         lineSlum=(View)findViewById(R.id.lineSlum);
         VlblSlum = (TextView) findViewById(R.id.VlblSlum);
         rdogrpSlum = (RadioGroup) findViewById(R.id.rdogrpSlum);
         
         rdoSlum1 = (RadioButton) findViewById(R.id.rdoSlum1);
         rdoSlum2 = (RadioButton) findViewById(R.id.rdoSlum2);
         secWaypoint=(LinearLayout)findViewById(R.id.secWaypoint);
         lineWaypoint=(View)findViewById(R.id.lineWaypoint);
         VlblWaypoint=(TextView) findViewById(R.id.VlblWaypoint);
         txtWaypoint=(EditText) findViewById(R.id.txtWaypoint);
         secLatDeg=(LinearLayout)findViewById(R.id.secLatDeg);
         lineLatDeg=(View)findViewById(R.id.lineLatDeg);
         VlblLatDeg=(TextView) findViewById(R.id.VlblLatDeg);
         txtLatDeg=(EditText) findViewById(R.id.txtLatDeg);
         secLatMin=(LinearLayout)findViewById(R.id.secLatMin);
         lineLatMin=(View)findViewById(R.id.lineLatMin);
         VlblLatMin=(TextView) findViewById(R.id.VlblLatMin);
         txtLatMin=(EditText) findViewById(R.id.txtLatMin);
         secLatSec=(LinearLayout)findViewById(R.id.secLatSec);
         lineLatSec=(View)findViewById(R.id.lineLatSec);
         VlblLatSec=(TextView) findViewById(R.id.VlblLatSec);
         txtLatSec=(EditText) findViewById(R.id.txtLatSec);
         secLonDeg=(LinearLayout)findViewById(R.id.secLonDeg);
         lineLonDeg=(View)findViewById(R.id.lineLonDeg);
         VlblLonDeg=(TextView) findViewById(R.id.VlblLonDeg);
         txtLonDeg=(EditText) findViewById(R.id.txtLonDeg);
         secLonMin=(LinearLayout)findViewById(R.id.secLonMin);
         lineLonMin=(View)findViewById(R.id.lineLonMin);
         VlblLonMin=(TextView) findViewById(R.id.VlblLonMin);
         txtLonMin=(EditText) findViewById(R.id.txtLonMin);
         secLonSec=(LinearLayout)findViewById(R.id.secLonSec);
         lineLonSec=(View)findViewById(R.id.lineLonSec);
         VlblLonSec=(TextView) findViewById(R.id.VlblLonSec);
         txtLonSec=(EditText) findViewById(R.id.txtLonSec);
         secRemarks=(LinearLayout)findViewById(R.id.secRemarks);
         lineRemarks=(View)findViewById(R.id.lineRemarks);
         VlblRemarks=(TextView) findViewById(R.id.VlblRemarks);
         txtRemarks=(EditText) findViewById(R.id.txtRemarks);


         dtpColDate.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpColDate.getRight() - dtpColDate.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btnColDate"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });


         txtColTime.setOnTouchListener(new View.OnTouchListener() {
         @Override
         public boolean onTouch(View v, MotionEvent event) {
             final int DRAWABLE_RIGHT = 2;
             if(event.getAction() == MotionEvent.ACTION_UP) {
                 if(event.getRawX() >= (txtColTime.getRight() - txtColTime.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                     VariableID = "btnColTime"; showDialog(TIME_DIALOG);
                  return true;
                 }
             }
             return false;
           }
         });

         //Hide all skip variables
         secHolding.setVisibility(View.GONE);
         lineHolding.setVisibility(View.GONE);
         secAddress.setVisibility(View.GONE);
         lineAddress.setVisibility(View.GONE);
         secBuildingType.setVisibility(View.GONE);
         lineBuildingType.setVisibility(View.GONE);
         secBuildingTypeOth.setVisibility(View.GONE);
         lineBuildingTypeOth.setVisibility(View.GONE);
         secSrtoried.setVisibility(View.GONE);
         lineSrtoried.setVisibility(View.GONE);
         secLandmark1.setVisibility(View.GONE);
         lineLandmark1.setVisibility(View.GONE);
         secLandmark1Code.setVisibility(View.GONE);
         lineLandmark1Code.setVisibility(View.GONE);
         secLandmarkOth1.setVisibility(View.GONE);
         lineLandmarkOth1.setVisibility(View.GONE);
         secLandmarkName1.setVisibility(View.GONE);
         lineLandmarkName1.setVisibility(View.GONE);
         secLandmark2.setVisibility(View.GONE);
         lineLandmark2.setVisibility(View.GONE);
         secLandmark2Code.setVisibility(View.GONE);
         lineLandmark2Code.setVisibility(View.GONE);
         secLandmarkOth2.setVisibility(View.GONE);
         lineLandmarkOth2.setVisibility(View.GONE);
         secLandmark2Name.setVisibility(View.GONE);
         lineLandmark2Name.setVisibility(View.GONE);
         secLandmark3.setVisibility(View.GONE);
         lineLandmark3.setVisibility(View.GONE);
         secLandmark3Code.setVisibility(View.GONE);
         lineLandmark3Code.setVisibility(View.GONE);
         secLandmarkOth3.setVisibility(View.GONE);
         lineLandmarkOth3.setVisibility(View.GONE);
         secLandmark3Name.setVisibility(View.GONE);
         lineLandmark3Name.setVisibility(View.GONE);
         secLandmark4.setVisibility(View.GONE);
         lineLandmark4.setVisibility(View.GONE);
         secLandmark4Code.setVisibility(View.GONE);
         lineLandmark4Code.setVisibility(View.GONE);
         secLandmarkOth4.setVisibility(View.GONE);
         lineLandmarkOth4.setVisibility(View.GONE);
         secLandmark4Name.setVisibility(View.GONE);
         lineLandmark4Name.setVisibility(View.GONE);
         secOwnerName.setVisibility(View.GONE);
         lineOwnerName.setVisibility(View.GONE);
         secOccupantName.setVisibility(View.GONE);
         lineOccupantName.setVisibility(View.GONE);
         secTotHH.setVisibility(View.GONE);
         lineTotHH.setVisibility(View.GONE);
         secSlum.setVisibility(View.GONE);
         lineSlum.setVisibility(View.GONE);
         secWaypoint.setVisibility(View.GONE);
         lineWaypoint.setVisibility(View.GONE);
         secLatDeg.setVisibility(View.GONE);
         lineLatDeg.setVisibility(View.GONE);
         secLatMin.setVisibility(View.GONE);
         lineLatMin.setVisibility(View.GONE);
         secLatSec.setVisibility(View.GONE);
         lineLatSec.setVisibility(View.GONE);
         secLonDeg.setVisibility(View.GONE);
         lineLonDeg.setVisibility(View.GONE);
         secLonMin.setVisibility(View.GONE);
         lineLonMin.setVisibility(View.GONE);
         secLonSec.setVisibility(View.GONE);
         lineLonSec.setVisibility(View.GONE);
         secRemarks.setVisibility(View.GONE);
         lineRemarks.setVisibility(View.GONE);
         secBuildingTypeOth.setVisibility(View.GONE);
         lineBuildingTypeOth.setVisibility(View.GONE);
         secBuildingTypeOth.setVisibility(View.GONE);
         lineBuildingTypeOth.setVisibility(View.GONE);
         secBuildingTypeOth.setVisibility(View.GONE);
         lineBuildingTypeOth.setVisibility(View.GONE);
         secLandmark1Code.setVisibility(View.GONE);
         lineLandmark1Code.setVisibility(View.GONE);
         secLandmarkOth1.setVisibility(View.GONE);
         lineLandmarkOth1.setVisibility(View.GONE);
         secLandmarkName1.setVisibility(View.GONE);
         lineLandmarkName1.setVisibility(View.GONE);
         secLandmark2.setVisibility(View.GONE);
         lineLandmark2.setVisibility(View.GONE);
         secLandmark2Code.setVisibility(View.GONE);
         lineLandmark2Code.setVisibility(View.GONE);
         secLandmarkOth2.setVisibility(View.GONE);
         lineLandmarkOth2.setVisibility(View.GONE);
         secLandmark2Name.setVisibility(View.GONE);
         lineLandmark2Name.setVisibility(View.GONE);
         secLandmark3.setVisibility(View.GONE);
         lineLandmark3.setVisibility(View.GONE);
         secLandmark3Code.setVisibility(View.GONE);
         lineLandmark3Code.setVisibility(View.GONE);
         secLandmarkOth3.setVisibility(View.GONE);
         lineLandmarkOth3.setVisibility(View.GONE);
         secLandmark3Name.setVisibility(View.GONE);
         lineLandmark3Name.setVisibility(View.GONE);
         secLandmark4.setVisibility(View.GONE);
         lineLandmark4.setVisibility(View.GONE);
         secLandmark4Code.setVisibility(View.GONE);
         lineLandmark4Code.setVisibility(View.GONE);
         secLandmarkOth4.setVisibility(View.GONE);
         lineLandmarkOth4.setVisibility(View.GONE);
         secLandmark4Name.setVisibility(View.GONE);
         lineLandmark4Name.setVisibility(View.GONE);
         secLandmarkOth1.setVisibility(View.GONE);
         lineLandmarkOth1.setVisibility(View.GONE);
         secLandmarkOth1.setVisibility(View.GONE);
         lineLandmarkOth1.setVisibility(View.GONE);
         secLandmarkOth1.setVisibility(View.GONE);
         lineLandmarkOth1.setVisibility(View.GONE);
         secLandmarkOth1.setVisibility(View.GONE);
         lineLandmarkOth1.setVisibility(View.GONE);
         secLandmarkOth1.setVisibility(View.GONE);
         lineLandmarkOth1.setVisibility(View.GONE);
         secLandmarkOth1.setVisibility(View.GONE);
         lineLandmarkOth1.setVisibility(View.GONE);
         secLandmarkOth1.setVisibility(View.GONE);
         lineLandmarkOth1.setVisibility(View.GONE);
         secLandmarkOth1.setVisibility(View.GONE);
         lineLandmarkOth1.setVisibility(View.GONE);
         secLandmarkOth1.setVisibility(View.GONE);
         lineLandmarkOth1.setVisibility(View.GONE);
         secLandmarkOth1.setVisibility(View.GONE);
         lineLandmarkOth1.setVisibility(View.GONE);
         secLandmark2Code.setVisibility(View.GONE);
         lineLandmark2Code.setVisibility(View.GONE);
         secLandmarkOth2.setVisibility(View.GONE);
         lineLandmarkOth2.setVisibility(View.GONE);
         secLandmark2Name.setVisibility(View.GONE);
         lineLandmark2Name.setVisibility(View.GONE);
         secLandmark3.setVisibility(View.GONE);
         lineLandmark3.setVisibility(View.GONE);
         secLandmark3Code.setVisibility(View.GONE);
         lineLandmark3Code.setVisibility(View.GONE);
         secLandmarkOth3.setVisibility(View.GONE);
         lineLandmarkOth3.setVisibility(View.GONE);
         secLandmark3Name.setVisibility(View.GONE);
         lineLandmark3Name.setVisibility(View.GONE);
         secLandmark4.setVisibility(View.GONE);
         lineLandmark4.setVisibility(View.GONE);
         secLandmark4Code.setVisibility(View.GONE);
         lineLandmark4Code.setVisibility(View.GONE);
         secLandmarkOth4.setVisibility(View.GONE);
         lineLandmarkOth4.setVisibility(View.GONE);
         secLandmark4Name.setVisibility(View.GONE);
         lineLandmark4Name.setVisibility(View.GONE);
         secLandmarkOth2.setVisibility(View.GONE);
         lineLandmarkOth2.setVisibility(View.GONE);
         secLandmarkOth2.setVisibility(View.GONE);
         lineLandmarkOth2.setVisibility(View.GONE);
         secLandmarkOth2.setVisibility(View.GONE);
         lineLandmarkOth2.setVisibility(View.GONE);
         secLandmarkOth2.setVisibility(View.GONE);
         lineLandmarkOth2.setVisibility(View.GONE);
         secLandmarkOth2.setVisibility(View.GONE);
         lineLandmarkOth2.setVisibility(View.GONE);
         secLandmarkOth2.setVisibility(View.GONE);
         lineLandmarkOth2.setVisibility(View.GONE);
         secLandmarkOth2.setVisibility(View.GONE);
         lineLandmarkOth2.setVisibility(View.GONE);
         secLandmarkOth2.setVisibility(View.GONE);
         lineLandmarkOth2.setVisibility(View.GONE);
         secLandmarkOth2.setVisibility(View.GONE);
         lineLandmarkOth2.setVisibility(View.GONE);
         secLandmarkOth2.setVisibility(View.GONE);
         lineLandmarkOth2.setVisibility(View.GONE);
         secLandmark3Code.setVisibility(View.GONE);
         lineLandmark3Code.setVisibility(View.GONE);
         secLandmarkOth3.setVisibility(View.GONE);
         lineLandmarkOth3.setVisibility(View.GONE);
         secLandmark3Name.setVisibility(View.GONE);
         lineLandmark3Name.setVisibility(View.GONE);
         secLandmark4.setVisibility(View.GONE);
         lineLandmark4.setVisibility(View.GONE);
         secLandmark4Code.setVisibility(View.GONE);
         lineLandmark4Code.setVisibility(View.GONE);
         secLandmarkOth4.setVisibility(View.GONE);
         lineLandmarkOth4.setVisibility(View.GONE);
         secLandmark4Name.setVisibility(View.GONE);
         lineLandmark4Name.setVisibility(View.GONE);
         secLandmarkOth3.setVisibility(View.GONE);
         lineLandmarkOth3.setVisibility(View.GONE);
         secLandmarkOth3.setVisibility(View.GONE);
         lineLandmarkOth3.setVisibility(View.GONE);
         secLandmarkOth3.setVisibility(View.GONE);
         lineLandmarkOth3.setVisibility(View.GONE);
         secLandmarkOth3.setVisibility(View.GONE);
         lineLandmarkOth3.setVisibility(View.GONE);
         secLandmarkOth3.setVisibility(View.GONE);
         lineLandmarkOth3.setVisibility(View.GONE);
         secLandmarkOth3.setVisibility(View.GONE);
         lineLandmarkOth3.setVisibility(View.GONE);
         secLandmarkOth3.setVisibility(View.GONE);
         lineLandmarkOth3.setVisibility(View.GONE);
         secLandmarkOth3.setVisibility(View.GONE);
         lineLandmarkOth3.setVisibility(View.GONE);
         secLandmarkOth3.setVisibility(View.GONE);
         lineLandmarkOth3.setVisibility(View.GONE);
         secLandmarkOth3.setVisibility(View.GONE);
         lineLandmarkOth3.setVisibility(View.GONE);
         secLandmarkOth4.setVisibility(View.GONE);
         lineLandmarkOth4.setVisibility(View.GONE);
         secLandmarkOth4.setVisibility(View.GONE);
         lineLandmarkOth4.setVisibility(View.GONE);
         secLandmarkOth4.setVisibility(View.GONE);
         lineLandmarkOth4.setVisibility(View.GONE);
         secLandmarkOth4.setVisibility(View.GONE);
         lineLandmarkOth4.setVisibility(View.GONE);
         secLandmarkOth4.setVisibility(View.GONE);
         lineLandmarkOth4.setVisibility(View.GONE);
         secLandmarkOth4.setVisibility(View.GONE);
         lineLandmarkOth4.setVisibility(View.GONE);
         secLandmarkOth4.setVisibility(View.GONE);
         lineLandmarkOth4.setVisibility(View.GONE);
         secLandmarkOth4.setVisibility(View.GONE);
         lineLandmarkOth4.setVisibility(View.GONE);
         secLandmarkOth4.setVisibility(View.GONE);
         lineLandmarkOth4.setVisibility(View.GONE);
         secLandmarkOth4.setVisibility(View.GONE);
         lineLandmarkOth4.setVisibility(View.GONE);


         //********************* Sharif start **********************
         secHolding.setVisibility(View.GONE);
         lineHolding.setVisibility(View.GONE);
         secAddress.setVisibility(View.GONE);
         lineAddress.setVisibility(View.GONE);
         secBuildingType.setVisibility(View.GONE);
         lineBuildingType.setVisibility(View.GONE);
         secBuildingTypeOth.setVisibility(View.GONE);
         lineBuildingTypeOth.setVisibility(View.GONE);
         secSrtoried.setVisibility(View.GONE);
         lineSrtoried.setVisibility(View.GONE);
         secLandmark1.setVisibility(View.GONE);
         lineLandmark1.setVisibility(View.GONE);
         secLandmark1Code.setVisibility(View.GONE);
         lineLandmark1Code.setVisibility(View.GONE);
         secLandmarkOth1.setVisibility(View.GONE);
         lineLandmarkOth1.setVisibility(View.GONE);
         secLandmarkName1.setVisibility(View.GONE);
         lineLandmarkName1.setVisibility(View.GONE);
         secLandmark2.setVisibility(View.GONE);
         lineLandmark2.setVisibility(View.GONE);
         secLandmark2Code.setVisibility(View.GONE);
         lineLandmark2Code.setVisibility(View.GONE);
         secLandmarkOth2.setVisibility(View.GONE);
         lineLandmarkOth2.setVisibility(View.GONE);
         secLandmark2Name.setVisibility(View.GONE);
         lineLandmark2Name.setVisibility(View.GONE);
         secLandmark3.setVisibility(View.GONE);
         lineLandmark3.setVisibility(View.GONE);
         secLandmark3Code.setVisibility(View.GONE);
         lineLandmark3Code.setVisibility(View.GONE);
         secLandmarkOth3.setVisibility(View.GONE);
         lineLandmarkOth3.setVisibility(View.GONE);
         secLandmark3Name.setVisibility(View.GONE);
         lineLandmark3Name.setVisibility(View.GONE);
         secLandmark4.setVisibility(View.GONE);
         lineLandmark4.setVisibility(View.GONE);
         secLandmark4Code.setVisibility(View.GONE);
         lineLandmark4Code.setVisibility(View.GONE);
         secLandmarkOth4.setVisibility(View.GONE);
         lineLandmarkOth4.setVisibility(View.GONE);
         secLandmark4Name.setVisibility(View.GONE);
         lineLandmark4Name.setVisibility(View.GONE);
         secOwnerName.setVisibility(View.GONE);
         lineOwnerName.setVisibility(View.GONE);
         secOccupantName.setVisibility(View.GONE);
         lineOccupantName.setVisibility(View.GONE);
         secTotHH.setVisibility(View.GONE);
         lineTotHH.setVisibility(View.GONE);
         secSlum.setVisibility(View.GONE);
         lineSlum.setVisibility(View.GONE);
         secWaypoint.setVisibility(View.GONE);
         lineWaypoint.setVisibility(View.GONE);
         secLatDeg.setVisibility(View.GONE);
         lineLatDeg.setVisibility(View.GONE);
         secLatMin.setVisibility(View.GONE);
         lineLatMin.setVisibility(View.GONE);
         secLatSec.setVisibility(View.GONE);
         lineLatSec.setVisibility(View.GONE);
         secLonDeg.setVisibility(View.GONE);
         lineLonDeg.setVisibility(View.GONE);
         secLonMin.setVisibility(View.GONE);
         lineLonMin.setVisibility(View.GONE);
         secLonSec.setVisibility(View.GONE);
         lineLonSec.setVisibility(View.GONE);
         secRemarks.setVisibility(View.GONE);
         lineRemarks.setVisibility(View.GONE);



         //********************* Sharif end **********************



         txtUpazila.setText(UPAZILA);
         txtUNCode.setText(UNCODE);
         txtVCode.setText(MOHOLLA);
         txtCluster.setText(CLUSTER);
         txtStructureNo.setText(STRUCTURENO);


        Button cmdSave = (Button) findViewById(R.id.cmdSave);
        cmdSave.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) { 
            DataSave();
        }});
     }
     catch(Exception  e)
     {
         Connection.MessageBox(StructureListing.this, e.getMessage());
         return;
     }
 }

     private String StructureNoSerial()
     {
         String SL = C.ReturnSingleValue("Select (ifnull(max(cast(StructureNo as int)),0)+1)SL from structureDB Where Upazila='"+ UPAZILA +
                 "' and UNCode='"+ UNCODE +"' and Cluster='"+ CLUSTER +"'");

         int length=SL.length();
         String s = "";
         for(int i=0;i<5-length;i++)
         {
             s+="0";
         }
         SL=s+SL;


         return SL;
     }

 private void DataSave()
 {
   try
     {
 
         String DV="";

         if(txtUpazila.getText().toString().length()==0 & secUpazila.isShown())
           {
             Connection.MessageBox(StructureListing.this, "Required field: Upazila/Thana.");
             txtUpazila.requestFocus(); 
             return;	
           }
         else if(txtUNCode.getText().toString().length()==0 & secUNCode.isShown())
           {
             Connection.MessageBox(StructureListing.this, "Required field: Union/Ward No.");
             txtUNCode.requestFocus(); 
             return;	
           }
         else if(txtVCode.getText().toString().length()==0 & secVCode.isShown())
           {
             Connection.MessageBox(StructureListing.this, "Required field: Village/Moholla Code.");
             txtVCode.requestFocus(); 
             return;	
           }
         else if(txtCluster.getText().toString().length()==0 & secCluster.isShown())
           {
             Connection.MessageBox(StructureListing.this, "Required field: Cluster No..");
             txtCluster.requestFocus(); 
             return;	
           }
         else if(txtStructureNo.getText().toString().length()==0 & secStructureNo.isShown())
           {
             Connection.MessageBox(StructureListing.this, "Required field: Structure No.");
             txtStructureNo.requestFocus(); 
             return;	
           }
         DV = Global.DateValidate(dtpColDate.getText().toString());
         if(DV.length()!=0 & secColDate.isShown())
           {
             Connection.MessageBox(StructureListing.this, DV);
             dtpColDate.requestFocus(); 
             return;	
           }
         else if(txtColTime.getText().length()==0 & secColTime.isShown())
           {
             Connection.MessageBox(StructureListing.this, "Required field: Data Collection Time.");
             txtColTime.requestFocus(); 
             return;	
           }
         else if(spnStructureStatus.getSelectedItemPosition()==0  & secStructureStatus.isShown())
           {
             Connection.MessageBox(StructureListing.this, "Required field: Structure Status.");
             spnStructureStatus.requestFocus(); 
             return;	
           }
         else if(txtHolding.getText().toString().length()==0 & secHolding.isShown())
           {
             Connection.MessageBox(StructureListing.this, "Required field: Holding.");
             txtHolding.requestFocus(); 
             return;	
           }
         else if(txtAddress.getText().toString().length()==0 & secAddress.isShown())
           {
             Connection.MessageBox(StructureListing.this, "Required field: Details Address.");
             txtAddress.requestFocus(); 
             return;	
           }
         
         else if(!rdoBuildingType1.isChecked() & !rdoBuildingType2.isChecked() & !rdoBuildingType3.isChecked() & !rdoBuildingType4.isChecked() & secBuildingType.isShown())
           {
              Connection.MessageBox(StructureListing.this, "Select anyone options from (Building Type).");
              rdoBuildingType1.requestFocus();
              return;
           }
         else if(txtBuildingTypeOth.getText().toString().length()==0 & secBuildingTypeOth.isShown())
           {
             Connection.MessageBox(StructureListing.this, "Required field: Building Type Other specfiy.");
             txtBuildingTypeOth.requestFocus(); 
             return;	
           }
         else if(spnSrtoried.getSelectedItemPosition()==0  & secSrtoried.isShown())
           {
             Connection.MessageBox(StructureListing.this, "Required field: Srtoried.");
             spnSrtoried.requestFocus(); 
             return;	
           }
         
         else if(!rdoLandmark11.isChecked() & !rdoLandmark12.isChecked() & secLandmark1.isShown())
           {
              Connection.MessageBox(StructureListing.this, "Select anyone options from (Lanmark One).");
              rdoLandmark11.requestFocus();
              return;
           }
         else if(spnLandmark1Code.getSelectedItemPosition()==0  & secLandmark1Code.isShown())
           {
             Connection.MessageBox(StructureListing.this, "Required field: Landmark One Code.");
             spnLandmark1Code.requestFocus(); 
             return;	
           }
         else if(txtLandmarkOth1.getText().toString().length()==0 & secLandmarkOth1.isShown())
           {
             Connection.MessageBox(StructureListing.this, "Required field: Specify.");
             txtLandmarkOth1.requestFocus(); 
             return;	
           }
         else if(txtLandmarkName1.getText().toString().length()==0 & secLandmarkName1.isShown())
           {
             Connection.MessageBox(StructureListing.this, "Required field: Landmark Name One.");
             txtLandmarkName1.requestFocus(); 
             return;	
           }
         
         else if(!rdoLandmark21.isChecked() & !rdoLandmark22.isChecked() & secLandmark2.isShown())
           {
              Connection.MessageBox(StructureListing.this, "Select anyone options from (Landmark Two).");
              rdoLandmark21.requestFocus();
              return;
           }
         else if(spnLandmark2Code.getSelectedItemPosition()==0  & secLandmark2Code.isShown())
           {
             Connection.MessageBox(StructureListing.this, "Required field: Landmark Two Code.");
             spnLandmark2Code.requestFocus(); 
             return;	
           }
         else if(txtLandmarkOth2.getText().toString().length()==0 & secLandmarkOth2.isShown())
           {
             Connection.MessageBox(StructureListing.this, "Required field: Specify.");
             txtLandmarkOth2.requestFocus(); 
             return;	
           }
         else if(txtLandmark2Name.getText().toString().length()==0 & secLandmark2Name.isShown())
           {
             Connection.MessageBox(StructureListing.this, "Required field: Landmark Two Name.");
             txtLandmark2Name.requestFocus(); 
             return;	
           }
         
         else if(!rdoLandmark31.isChecked() & !rdoLandmark32.isChecked() & secLandmark3.isShown())
           {
              Connection.MessageBox(StructureListing.this, "Select anyone options from (Landmark Three).");
              rdoLandmark31.requestFocus();
              return;
           }
         else if(spnLandmark3Code.getSelectedItemPosition()==0  & secLandmark3Code.isShown())
           {
             Connection.MessageBox(StructureListing.this, "Required field: Landmark Three Code.");
             spnLandmark3Code.requestFocus(); 
             return;	
           }
         else if(txtLandmarkOth3.getText().toString().length()==0 & secLandmarkOth3.isShown())
           {
             Connection.MessageBox(StructureListing.this, "Required field: Specify.");
             txtLandmarkOth3.requestFocus(); 
             return;	
           }
         else if(txtLandmark3Name.getText().toString().length()==0 & secLandmark3Name.isShown())
           {
             Connection.MessageBox(StructureListing.this, "Required field: Landmark Three Name.");
             txtLandmark3Name.requestFocus(); 
             return;	
           }
         
         else if(!rdoLandmark41.isChecked() & !rdoLandmark42.isChecked() & secLandmark4.isShown())
           {
              Connection.MessageBox(StructureListing.this, "Select anyone options from (Landmark Four).");
              rdoLandmark41.requestFocus();
              return;
           }
         else if(spnLandmark4Code.getSelectedItemPosition()==0  & secLandmark4Code.isShown())
           {
             Connection.MessageBox(StructureListing.this, "Required field: Landmark Four Code.");
             spnLandmark4Code.requestFocus(); 
             return;	
           }
         else if(txtLandmarkOth4.getText().toString().length()==0 & secLandmarkOth4.isShown())
           {
             Connection.MessageBox(StructureListing.this, "Required field: Specify.");
             txtLandmarkOth4.requestFocus(); 
             return;	
           }
         else if(txtLandmark4Name.getText().toString().length()==0 & secLandmark4Name.isShown())
           {
             Connection.MessageBox(StructureListing.this, "Required field: Landmark Four Name.");
             txtLandmark4Name.requestFocus(); 
             return;	
           }
           ///*******************Sharif Start*******************************////
//         else if(txtOwnerName.getText().toString().length()==0 & secOwnerName.isShown())
//           {
//             Connection.MessageBox(StructureListing.this, "Required field: Owner Name.");
//             txtOwnerName.requestFocus();
//             return;
//           }
         ///*******************Sharif End*******************************////
//         else if(txtOccupantName.getText().toString().length()==0 & secOccupantName.isShown())
//           {
//             Connection.MessageBox(StructureListing.this, "Required field: Occupant Name.");
//             txtOccupantName.requestFocus();
//             return;
//           }
//         else if(txtTotHH.getText().toString().length()==0 & secTotHH.isShown())
//           {
//             Connection.MessageBox(StructureListing.this, "Required field: Total # of HH.");
//             txtTotHH.requestFocus();
//             return;
//           }
         else if(Integer.valueOf(txtTotHH.getText().toString().length()==0 ? "1" : txtTotHH.getText().toString()) < 1 || Integer.valueOf(txtTotHH.getText().toString().length()==0 ? "150" : txtTotHH.getText().toString()) > 150)
           {
             Connection.MessageBox(StructureListing.this, "Value should be between 1 and 150(Total # of HH).");
             txtTotHH.requestFocus(); 
             return;	
           }
         
         else if(!rdoSlum1.isChecked() & !rdoSlum2.isChecked() & secSlum.isShown())
           {
              Connection.MessageBox(StructureListing.this, "Select anyone options from (Slum (Slum if >1 HH share one toilet)).");
              rdoSlum1.requestFocus();
              return;
           }
//         else if(txtWaypoint.getText().toString().length()==0 & secWaypoint.isShown())
//           {
//             Connection.MessageBox(StructureListing.this, "Required field: Waypoint.");
//             txtWaypoint.requestFocus();
//             return;
//           }
         else if(Integer.valueOf(txtWaypoint.getText().toString().length()==0 ? "1" : txtWaypoint.getText().toString()) < 1 || Integer.valueOf(txtWaypoint.getText().toString().length()==0 ? "999" : txtWaypoint.getText().toString()) > 999)
           {
             Connection.MessageBox(StructureListing.this, "Value should be between 1 and 999(Waypoint).");
             txtWaypoint.requestFocus(); 
             return;	
           }
//         else if(txtLatDeg.getText().toString().length()==0 & secLatDeg.isShown())
//           {
//             Connection.MessageBox(StructureListing.this, "Required field: Latitude Degree.");
//             txtLatDeg.requestFocus();
//             return;
//           }
         else if(Integer.valueOf(txtLatDeg.getText().toString().length()==0 ? "1" : txtLatDeg.getText().toString()) < 1 || Integer.valueOf(txtLatDeg.getText().toString().length()==0 ? "99" : txtLatDeg.getText().toString()) > 99)
           {
             Connection.MessageBox(StructureListing.this, "Value should be between 1 and 99(Latitude Degree).");
             txtLatDeg.requestFocus(); 
             return;	
           }
//         else if(txtLatMin.getText().toString().length()==0 & secLatMin.isShown())
//           {
//             Connection.MessageBox(StructureListing.this, "Required field: Latitude Minutes.");
//             txtLatMin.requestFocus();
//             return;
//           }
         else if(Integer.valueOf(txtLatMin.getText().toString().length()==0 ? "1" : txtLatMin.getText().toString()) < 1 || Integer.valueOf(txtLatMin.getText().toString().length()==0 ? "99" : txtLatMin.getText().toString()) > 99)
           {
             Connection.MessageBox(StructureListing.this, "Value should be between 1 and 99(Latitude Minutes).");
             txtLatMin.requestFocus(); 
             return;	
           }
//         else if(txtLatSec.getText().toString().length()==0 & secLatSec.isShown())
//           {
//             Connection.MessageBox(StructureListing.this, "Required field: Latitude Seconds.");
//             txtLatSec.requestFocus();
//             return;
//           }
         else if(Integer.valueOf(txtLatSec.getText().toString().length()==0 ? "1" : txtLatSec.getText().toString()) < 1 || Integer.valueOf(txtLatSec.getText().toString().length()==0 ? "99" : txtLatSec.getText().toString()) > 99)
           {
             Connection.MessageBox(StructureListing.this, "Value should be between 1 and 99(Latitude Seconds).");
             txtLatSec.requestFocus(); 
             return;	
           }
//         else if(txtLonDeg.getText().toString().length()==0 & secLonDeg.isShown())
//           {
//             Connection.MessageBox(StructureListing.this, "Required field: Longitude degrees.");
//             txtLonDeg.requestFocus();
//             return;
//           }
         else if(Integer.valueOf(txtLonDeg.getText().toString().length()==0 ? "1" : txtLonDeg.getText().toString()) < 1 || Integer.valueOf(txtLonDeg.getText().toString().length()==0 ? "99" : txtLonDeg.getText().toString()) > 99)
           {
             Connection.MessageBox(StructureListing.this, "Value should be between 1 and 99(Longitude degrees).");
             txtLonDeg.requestFocus(); 
             return;	
           }
//         else if(txtLonMin.getText().toString().length()==0 & secLonMin.isShown())
//           {
//             Connection.MessageBox(StructureListing.this, "Required field: Longitude degrees.");
//             txtLonMin.requestFocus();
//             return;
//           }
         else if(Integer.valueOf(txtLonMin.getText().toString().length()==0 ? "1" : txtLonMin.getText().toString()) < 1 || Integer.valueOf(txtLonMin.getText().toString().length()==0 ? "99" : txtLonMin.getText().toString()) > 99)
           {
             Connection.MessageBox(StructureListing.this, "Value should be between 1 and 99(Longitude degrees).");
             txtLonMin.requestFocus(); 
             return;	
           }
//         else if(txtLonSec.getText().toString().length()==0 & secLonSec.isShown())
//           {
//             Connection.MessageBox(StructureListing.this, "Required field: Longitude seconds.");
//             txtLonSec.requestFocus();
//             return;
//           }
         else if(Integer.valueOf(txtLonSec.getText().toString().length()==0 ? "1" : txtLonSec.getText().toString()) < 1 || Integer.valueOf(txtLonSec.getText().toString().length()==0 ? "99" : txtLonSec.getText().toString()) > 99)
           {
             Connection.MessageBox(StructureListing.this, "Value should be between 1 and 99(Longitude seconds).");
             txtLonSec.requestFocus(); 
             return;	
           }
           ///*****************Sharif start***********************///
//         else if(txtRemarks.getText().toString().length()==0 & secRemarks.isShown())
//           {
//             Connection.MessageBox(StructureListing.this, "Required field: Remarks.");
//             txtRemarks.requestFocus();
//             return;
//           }
         ///*****************Sharif end***********************///
         String SQL = "";
         RadioButton rb;

         StructureListing_DataModel objSave = new StructureListing_DataModel();
         objSave.setUpazila(txtUpazila.getText().toString());
         objSave.setUNCode(txtUNCode.getText().toString());
         objSave.setVCode(txtVCode.getText().toString());
         objSave.setCluster(txtCluster.getText().toString());
         objSave.setStructureNo(txtStructureNo.getText().toString());
         objSave.setColDate(dtpColDate.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpColDate.getText().toString()) : dtpColDate.getText().toString());
         objSave.setColTime(txtColTime.getText().toString());
         objSave.setStructureStatus(Integer.valueOf(spnStructureStatus.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnStructureStatus.getSelectedItem().toString(), "-")));
         objSave.setHolding(txtHolding.getText().toString());
         objSave.setAddress(txtAddress.getText().toString());
         String[] d_rdogrpBuildingType = new String[] {"1","2","3","7"};
         objSave.setBuildingType(0);
         for (int i = 0; i < rdogrpBuildingType.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpBuildingType.getChildAt(i);
             if (rb.isChecked()) objSave.setBuildingType(Integer.valueOf(d_rdogrpBuildingType[i]));
         }

         objSave.setBuildingTypeOth(txtBuildingTypeOth.getText().toString());
         objSave.setSrtoried(Integer.valueOf(spnSrtoried.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnSrtoried.getSelectedItem().toString(), "-")));
         String[] d_rdogrpLandmark1 = new String[] {"1","2"};
         objSave.setLandmark1(0);
         for (int i = 0; i < rdogrpLandmark1.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpLandmark1.getChildAt(i);
             if (rb.isChecked()) objSave.setLandmark1(Integer.valueOf(d_rdogrpLandmark1[i]));
         }

         objSave.setLandmark1Code(Integer.valueOf(spnLandmark1Code.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnLandmark1Code.getSelectedItem().toString(), "-")));
         objSave.setLandmarkOth1(txtLandmarkOth1.getText().toString());
         objSave.setLandmarkName1(txtLandmarkName1.getText().toString());
         String[] d_rdogrpLandmark2 = new String[] {"1","2"};
         objSave.setLandmark2(0);
         for (int i = 0; i < rdogrpLandmark2.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpLandmark2.getChildAt(i);
             if (rb.isChecked()) objSave.setLandmark2(Integer.valueOf(d_rdogrpLandmark2[i]));
         }

         objSave.setLandmark2Code(Integer.valueOf(spnLandmark2Code.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnLandmark2Code.getSelectedItem().toString(), "-")));
         objSave.setLandmarkOth2(txtLandmarkOth2.getText().toString());
         objSave.setLandmark2Name(txtLandmark2Name.getText().toString());
         String[] d_rdogrpLandmark3 = new String[] {"1","2"};
         objSave.setLandmark3(0);
         for (int i = 0; i < rdogrpLandmark3.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpLandmark3.getChildAt(i);
             if (rb.isChecked()) objSave.setLandmark3(Integer.valueOf(d_rdogrpLandmark3[i]));
         }

         objSave.setLandmark3Code(Integer.valueOf(spnLandmark3Code.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnLandmark3Code.getSelectedItem().toString(), "-")));
         objSave.setLandmarkOth3(txtLandmarkOth3.getText().toString());
         objSave.setLandmark3Name(txtLandmark3Name.getText().toString());
         String[] d_rdogrpLandmark4 = new String[] {"1","2"};
         objSave.setLandmark4(0);
         for (int i = 0; i < rdogrpLandmark4.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpLandmark4.getChildAt(i);
             if (rb.isChecked()) objSave.setLandmark4(Integer.valueOf(d_rdogrpLandmark4[i]));
         }

         objSave.setLandmark4Code(Integer.valueOf(spnLandmark4Code.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnLandmark4Code.getSelectedItem().toString(), "-")));
         objSave.setLandmarkOth4(txtLandmarkOth4.getText().toString());
         objSave.setLandmark4Name(txtLandmark4Name.getText().toString());
         objSave.setOwnerName(txtOwnerName.getText().toString());
         objSave.setOccupantName(txtOccupantName.getText().toString());
         objSave.setTotHH(Integer.valueOf(txtTotHH.getText().toString().length()==0?"0":txtTotHH.getText().toString()));
         String[] d_rdogrpSlum = new String[] {"1","2"};
         objSave.setSlum(0);
         for (int i = 0; i < rdogrpSlum.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpSlum.getChildAt(i);
             if (rb.isChecked()) objSave.setSlum(Integer.valueOf(d_rdogrpSlum[i]));
         }

         objSave.setWaypoint(Integer.valueOf(txtWaypoint.getText().toString().length()==0?"0":txtWaypoint.getText().toString()));
         objSave.setLatDeg(Integer.valueOf(txtLatDeg.getText().toString().length()==0?"0":txtLatDeg.getText().toString()));
         objSave.setLatMin(Integer.valueOf(txtLatMin.getText().toString().length()==0?"0":txtLatMin.getText().toString()));
         objSave.setLatSec(Integer.valueOf(txtLatSec.getText().toString().length()==0?"0":txtLatSec.getText().toString()));
         objSave.setLonDeg(Integer.valueOf(txtLonDeg.getText().toString().length()==0?"0":txtLonDeg.getText().toString()));
         objSave.setLonMin(Integer.valueOf(txtLonMin.getText().toString().length()==0?"0":txtLonMin.getText().toString()));
         objSave.setLonSec(Integer.valueOf(txtLonSec.getText().toString().length()==0?"0":txtLonSec.getText().toString()));
         objSave.setRemarks(txtRemarks.getText().toString());
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

             Connection.MessageBox(StructureListing.this, "Saved Successfully");
         }
         else{
             Connection.MessageBox(StructureListing.this, status);
             return;
         }
     }
     catch(Exception  e)
     {
         Connection.MessageBox(StructureListing.this, e.getMessage());
         return;
     }
 }

 private void DataSearch(String Upazila, String UNCode)
     {
       try
        {
     
           RadioButton rb;
           StructureListing_DataModel d = new StructureListing_DataModel();
           String SQL = "Select * from "+ TableName +"  Where Upazila='"+ Upazila +"' and UNCode='"+ UNCode +"'";
           List<StructureListing_DataModel> data = d.SelectAll(this, SQL);
           for(StructureListing_DataModel item : data){
             txtUpazila.setText(item.getUpazila());
             txtUNCode.setText(item.getUNCode());
             txtVCode.setText(item.getVCode());
             txtCluster.setText(item.getCluster());
             txtStructureNo.setText(item.getStructureNo());
             dtpColDate.setText(item.getColDate().toString().length()==0 ? "" : Global.DateConvertDMY(item.getColDate()));
             txtColTime.setText(item.getColTime());
             spnStructureStatus.setSelection(Global.SpinnerItemPositionAnyLength(spnStructureStatus, String.valueOf(item.getStructureStatus())));
             txtHolding.setText(item.getHolding());
             txtAddress.setText(item.getAddress());
             String[] d_rdogrpBuildingType = new String[] {"1","2","3","7"};
             for (int i = 0; i < d_rdogrpBuildingType.length; i++)
             {
                 if (String.valueOf(item.getBuildingType()).equals(String.valueOf(d_rdogrpBuildingType[i])))
                 {
                     rb = (RadioButton)rdogrpBuildingType.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtBuildingTypeOth.setText(item.getBuildingTypeOth());
             spnSrtoried.setSelection(Global.SpinnerItemPositionAnyLength(spnSrtoried, String.valueOf(item.getSrtoried())));
             String[] d_rdogrpLandmark1 = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpLandmark1.length; i++)
             {
                 if (String.valueOf(item.getLandmark1()).equals(String.valueOf(d_rdogrpLandmark1[i])))
                 {
                     rb = (RadioButton)rdogrpLandmark1.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             spnLandmark1Code.setSelection(Global.SpinnerItemPositionAnyLength(spnLandmark1Code, String.valueOf(item.getLandmark1Code())));
             txtLandmarkOth1.setText(item.getLandmarkOth1());
             txtLandmarkName1.setText(item.getLandmarkName1());
             String[] d_rdogrpLandmark2 = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpLandmark2.length; i++)
             {
                 if (String.valueOf(item.getLandmark2()).equals(String.valueOf(d_rdogrpLandmark2[i])))
                 {
                     rb = (RadioButton)rdogrpLandmark2.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             spnLandmark2Code.setSelection(Global.SpinnerItemPositionAnyLength(spnLandmark2Code, String.valueOf(item.getLandmark2Code())));
             txtLandmarkOth2.setText(item.getLandmarkOth2());
             txtLandmark2Name.setText(item.getLandmark2Name());
             String[] d_rdogrpLandmark3 = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpLandmark3.length; i++)
             {
                 if (String.valueOf(item.getLandmark3()).equals(String.valueOf(d_rdogrpLandmark3[i])))
                 {
                     rb = (RadioButton)rdogrpLandmark3.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             spnLandmark3Code.setSelection(Global.SpinnerItemPositionAnyLength(spnLandmark3Code, String.valueOf(item.getLandmark3Code())));
             txtLandmarkOth3.setText(item.getLandmarkOth3());
             txtLandmark3Name.setText(item.getLandmark3Name());
             String[] d_rdogrpLandmark4 = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpLandmark4.length; i++)
             {
                 if (String.valueOf(item.getLandmark4()).equals(String.valueOf(d_rdogrpLandmark4[i])))
                 {
                     rb = (RadioButton)rdogrpLandmark4.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             spnLandmark4Code.setSelection(Global.SpinnerItemPositionAnyLength(spnLandmark4Code, String.valueOf(item.getLandmark4Code())));
             txtLandmarkOth4.setText(item.getLandmarkOth4());
             txtLandmark4Name.setText(item.getLandmark4Name());
             txtOwnerName.setText(item.getOwnerName());
             txtOccupantName.setText(item.getOccupantName());
             txtTotHH.setText(String.valueOf(item.getTotHH()));
             String[] d_rdogrpSlum = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpSlum.length; i++)
             {
                 if (String.valueOf(item.getSlum()).equals(String.valueOf(d_rdogrpSlum[i])))
                 {
                     rb = (RadioButton)rdogrpSlum.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtWaypoint.setText(String.valueOf(item.getWaypoint()));
             txtLatDeg.setText(String.valueOf(item.getLatDeg()));
             txtLatMin.setText(String.valueOf(item.getLatMin()));
             txtLatSec.setText(String.valueOf(item.getLatSec()));
             txtLonDeg.setText(String.valueOf(item.getLonDeg()));
             txtLonMin.setText(String.valueOf(item.getLonMin()));
             txtLonSec.setText(String.valueOf(item.getLonSec()));
             txtRemarks.setText(item.getRemarks());
           }
        }
        catch(Exception  e)
        {
            Connection.MessageBox(StructureListing.this, e.getMessage());
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


              dtpDate = (EditText)findViewById(R.id.dtpColDate);
             if (VariableID.equals("btnColDate"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpColDate);
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
       EditText tpTime;


              tpTime = (EditText)findViewById(R.id.txtColTime);
             if (VariableID.equals("btnColTime"))
              {
                  tpTime = (EditText)findViewById(R.id.txtColTime);
              }
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