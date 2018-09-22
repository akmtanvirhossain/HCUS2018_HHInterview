
 package org.hcus_hhinterview;


 //Android Manifest Code
 //<activity android:name=".MeningitisCase" android:label="MeningitisCase" />
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
 import data_model.MeningitisCase_DataModel;

 public class MeningitisCase extends Activity {
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
     LinearLayout secMemName;
     View lineMemName;
     TextView VlblMemName;
     EditText txtMemName;
         LinearLayout secMeningitisCaseLabel;
         View lineMeningitisCaseLabel;
         LinearLayout secSeriIlOnset;
         View lineSeriIlOnset;
         TextView VlblSeriIlOnset;
         RadioGroup rdogrpSeriIlOnset;
         
         RadioButton rdoSeriIlOnset1;
         RadioButton rdoSeriIlOnset2;
         RadioButton rdoSeriIlOnset3;
         RadioButton rdoSeriIlOnset4;
         LinearLayout secSameIllSec2;
         View lineSameIllSec2;
         TextView VlblSameIllSec2;
         RadioGroup rdogrpSameIllSec2;
         
         RadioButton rdoSameIllSec21;
         RadioButton rdoSameIllSec22;
         LinearLayout secEpiSeriIlOnset;
         View lineEpiSeriIlOnset;
         TextView VlblEpiSeriIlOnset;
         EditText txtEpiSeriIlOnset;
         LinearLayout secIlnessFev;
         View lineIlnessFev;
         TextView VlblIlnessFev;
         EditText txtIlnessFev;
         LinearLayout secIlnessConv;
         View lineIlnessConv;
         TextView VlblIlnessConv;
         RadioGroup rdogrpIlnessConv;
         
         RadioButton rdoIlnessConv1;
         RadioButton rdoIlnessConv2;
         RadioButton rdoIlnessConv3;
         LinearLayout secUpRolEye;
         View lineUpRolEye;
         TextView VlblUpRolEye;
         RadioGroup rdogrpUpRolEye;
         
         RadioButton rdoUpRolEye1;
         RadioButton rdoUpRolEye2;
         RadioButton rdoUpRolEye3;
         LinearLayout secMRigJaw;
         View lineMRigJaw;
         TextView VlblMRigJaw;
         RadioGroup rdogrpMRigJaw;
         
         RadioButton rdoMRigJaw1;
         RadioButton rdoMRigJaw2;
         RadioButton rdoMRigJaw3;
         LinearLayout secMRigLimbs;
         View lineMRigLimbs;
         TextView VlblMRigLimbs;
         RadioGroup rdogrpMRigLimbs;
         
         RadioButton rdoMRigLimbs1;
         RadioButton rdoMRigLimbs2;
         RadioButton rdoMRigLimbs3;
         LinearLayout secMDurConv;
         View lineMDurConv;
         TextView VlblMDurConv;
         RadioGroup rdogrpMDurConv;
         
         RadioButton rdoMDurConv1;
         RadioButton rdoMDurConv2;
         RadioButton rdoMDurConv3;
         RadioButton rdoMDurConv4;
         RadioButton rdoMDurConv5;
         LinearLayout secMDrowsin;
         View lineMDrowsin;
         TextView VlblMDrowsin;
         RadioGroup rdogrpMDrowsin;
         
         RadioButton rdoMDrowsin1;
         RadioButton rdoMDrowsin2;
         RadioButton rdoMDrowsin3;
         LinearLayout secMDurDrowsin;
         View lineMDurDrowsin;
         TextView VlblMDurDrowsin;
         EditText txtMDurDrowsin;
         LinearLayout secMUntoFeed;
         View lineMUntoFeed;
         TextView VlblMUntoFeed;
         Spinner spnMUntoFeed;
         LinearLayout secMDurUntoFeed;
         View lineMDurUntoFeed;
         TextView VlblMDurUntoFeed;
         EditText txtMDurUntoFeed;
         LinearLayout secMCalNoRes;
         View lineMCalNoRes;
         TextView VlblMCalNoRes;
         Spinner spnMCalNoRes;
         LinearLayout secMDurCalNoRes;
         View lineMDurCalNoRes;
         TextView VlblMDurCalNoRes;
         EditText txtMDurCalNoRes;
         LinearLayout secMEverConf;
         View lineMEverConf;
         TextView VlblMEverConf;
         Spinner spnMEverConf;
         LinearLayout secMDurEverConf;
         View lineMDurEverConf;
         TextView VlblMDurEverConf;
         Spinner spnMDurEverConf;
         LinearLayout secMFlicker;
         View lineMFlicker;
         TextView VlblMFlicker;
         RadioGroup rdogrpMFlicker;
         
         RadioButton rdoMFlicker1;
         RadioButton rdoMFlicker2;
         RadioButton rdoMFlicker3;
         LinearLayout secMDurFliker;
         View lineMDurFliker;
         TextView VlblMDurFliker;
         Spinner spnMDurFliker;
         LinearLayout secMUnconsci;
         View lineMUnconsci;
         TextView VlblMUnconsci;
         RadioGroup rdogrpMUnconsci;
         
         RadioButton rdoMUnconsci1;
         RadioButton rdoMUnconsci2;
         RadioButton rdoMUnconsci3;
         LinearLayout secMDurUnconsci;
         View lineMDurUnconsci;
         TextView VlblMDurUnconsci;
         Spinner spnMDurUnconsci;
         LinearLayout secMIlCry;
         View lineMIlCry;
         TextView VlblMIlCry;
         RadioGroup rdogrpMIlCry;
         
         RadioButton rdoMIlCry1;
         RadioButton rdoMIlCry2;
         RadioButton rdoMIlCry3;
         LinearLayout secMDurIlCry;
         View lineMDurIlCry;
         TextView VlblMDurIlCry;
         Spinner spnMDurIlCry;
         LinearLayout secMUnCraWalk;
         View lineMUnCraWalk;
         TextView VlblMUnCraWalk;
         Spinner spnMUnCraWalk;
         LinearLayout secMDurUnCraWalk;
         View lineMDurUnCraWalk;
         TextView VlblMDurUnCraWalk;
         Spinner spnMDurUnCraWalk;
         LinearLayout secMDifBreath;
         View lineMDifBreath;
         TextView VlblMDifBreath;
         RadioGroup rdogrpMDifBreath;
         
         RadioButton rdoMDifBreath1;
         RadioButton rdoMDifBreath2;
         RadioButton rdoMDifBreath3;
         LinearLayout secMCough;
         View lineMCough;
         TextView VlblMCough;
         RadioGroup rdogrpMCough;
         
         RadioButton rdoMCough1;
         RadioButton rdoMCough2;
         RadioButton rdoMCough3;
         LinearLayout secMRash;
         View lineMRash;
         TextView VlblMRash;
         RadioGroup rdogrpMRash;
         
         RadioButton rdoMRash1;
         RadioButton rdoMRash2;
         RadioButton rdoMRash3;
         LinearLayout secMVomit;
         View lineMVomit;
         TextView VlblMVomit;
         RadioGroup rdogrpMVomit;
         
         RadioButton rdoMVomit1;
         RadioButton rdoMVomit2;
         RadioButton rdoMVomit3;
         LinearLayout secMDiarrhoea;
         View lineMDiarrhoea;
         TextView VlblMDiarrhoea;
         RadioGroup rdogrpMDiarrhoea;
         
         RadioButton rdoMDiarrhoea1;
         RadioButton rdoMDiarrhoea2;
         RadioButton rdoMDiarrhoea3;
         LinearLayout secMHCar;
         View lineMHCar;
         TextView VlblMHCar;
         RadioGroup rdogrpMHCar;
         
         RadioButton rdoMHCar1;
         RadioButton rdoMHCar2;
         RadioButton rdoMHCar3;
         LinearLayout secMHCarTypLabel;
         View lineMHCarTypLabel;
         LinearLayout secMHC_Phy;
         View lineMHC_Phy;
         TextView VlblMHC_Phy;
         RadioGroup rdogrpMHC_Phy;
         
         RadioButton rdoMHC_Phy1;
         RadioButton rdoMHC_Phy2;
         RadioButton rdoMHC_Phy3;
         LinearLayout secMHC_UnquaDoctor;
         View lineMHC_UnquaDoctor;
         TextView VlblMHC_UnquaDoctor;
         RadioGroup rdogrpMHC_UnquaDoctor;
         
         RadioButton rdoMHC_UnquaDoctor1;
         RadioButton rdoMHC_UnquaDoctor2;
         RadioButton rdoMHC_UnquaDoctor3;
         LinearLayout secMHC_Para;
         View lineMHC_Para;
         TextView VlblMHC_Para;
         RadioGroup rdogrpMHC_Para;
         
         RadioButton rdoMHC_Para1;
         RadioButton rdoMHC_Para2;
         RadioButton rdoMHC_Para3;
         LinearLayout secMHC_Com;
         View lineMHC_Com;
         TextView VlblMHC_Com;
         RadioGroup rdogrpMHC_Com;
         
         RadioButton rdoMHC_Com1;
         RadioButton rdoMHC_Com2;
         RadioButton rdoMHC_Com3;
         LinearLayout secMHC_Pha;
         View lineMHC_Pha;
         TextView VlblMHC_Pha;
         RadioGroup rdogrpMHC_Pha;
         
         RadioButton rdoMHC_Pha1;
         RadioButton rdoMHC_Pha2;
         RadioButton rdoMHC_Pha3;
         LinearLayout secMHC_Hompath;
         View lineMHC_Hompath;
         TextView VlblMHC_Hompath;
         RadioGroup rdogrpMHC_Hompath;
         
         RadioButton rdoMHC_Hompath1;
         RadioButton rdoMHC_Hompath2;
         RadioButton rdoMHC_Hompath3;
         LinearLayout secMHC_TrHeal;
         View lineMHC_TrHeal;
         TextView VlblMHC_TrHeal;
         RadioGroup rdogrpMHC_TrHeal;
         
         RadioButton rdoMHC_TrHeal1;
         RadioButton rdoMHC_TrHeal2;
         RadioButton rdoMHC_TrHeal3;
         LinearLayout secMHC_SpiHeal;
         View lineMHC_SpiHeal;
         TextView VlblMHC_SpiHeal;
         RadioGroup rdogrpMHC_SpiHeal;
         
         RadioButton rdoMHC_SpiHeal1;
         RadioButton rdoMHC_SpiHeal2;
         RadioButton rdoMHC_SpiHeal3;
         LinearLayout secMHC_Oth;
         View lineMHC_Oth;
         TextView VlblMHC_Oth;
         RadioGroup rdogrpMHC_Oth;
         
         RadioButton rdoMHC_Oth1;
         RadioButton rdoMHC_Oth2;
         RadioButton rdoMHC_Oth3;
         LinearLayout secMHC_OthName;
         View lineMHC_OthName;
         TextView VlblMHC_OthName;
         EditText txtMHC_OthName;
         LinearLayout secMDSHOPD;
         View lineMDSHOPD;
         TextView VlblMDSHOPD;
         RadioGroup rdogrpMDSHOPD;
         
         RadioButton rdoMDSHOPD1;
         RadioButton rdoMDSHOPD2;
         RadioButton rdoMDSHOPD3;
         LinearLayout secMSSFOPD;
         View lineMSSFOPD;
         TextView VlblMSSFOPD;
         RadioGroup rdogrpMSSFOPD;
         
         RadioButton rdoMSSFOPD1;
         RadioButton rdoMSSFOPD2;
         RadioButton rdoMSSFOPD3;
         LinearLayout secMHosAdm;
         View lineMHosAdm;
         TextView VlblMHosAdm;
         RadioGroup rdogrpMHosAdm;
         
         RadioButton rdoMHosAdm1;
         RadioButton rdoMHosAdm2;
         RadioButton rdoMHosAdm3;
         LinearLayout secMHosNamLabel;
         View lineMHosNamLabel;
         LinearLayout secMHC_Hosp_a1;
         View lineMHC_Hosp_a1;
         TextView VlblMHC_Hosp_a1;
         Spinner spnMHC_Hosp_a1;
         LinearLayout secMHC_Hosp_a1_Oth;
         View lineMHC_Hosp_a1_Oth;
         TextView VlblMHC_Hosp_a1_Oth;
         EditText txtMHC_Hosp_a1_Oth;
         LinearLayout secMHC_Hosp_a2;
         View lineMHC_Hosp_a2;
         TextView VlblMHC_Hosp_a2;
         Spinner spnMHC_Hosp_a2;
         LinearLayout secMHC_Hosp_a2_Oth;
         View lineMHC_Hosp_a2_Oth;
         TextView VlblMHC_Hosp_a2_Oth;
         EditText txtMHC_Hosp_a2_Oth;
         LinearLayout secMHC_Hosp_a3;
         View lineMHC_Hosp_a3;
         TextView VlblMHC_Hosp_a3;
         Spinner spnMHC_Hosp_a3;
         LinearLayout secMHC_Hosp_a3_Oth;
         View lineMHC_Hosp_a3_Oth;
         TextView VlblMHC_Hosp_a3_Oth;
         EditText txtMHC_Hosp_a3_Oth;
         LinearLayout secMDtHos;
         View lineMDtHos;
         TextView VlblMDtHos;
         EditText dtpMDtHos;
         LinearLayout secMHosM;
         View lineMHosM;
         TextView VlblMHosM;
         EditText txtMHosM;
         LinearLayout secMDurIlBeHos;
         View lineMDurIlBeHos;
         TextView VlblMDurIlBeHos;
         EditText txtMDurIlBeHos;
         LinearLayout secMChildIlDr;
         View lineMChildIlDr;
         TextView VlblMChildIlDr;
         Spinner spnMChildIlDr;
         LinearLayout secMChildIlDrOth;
         View lineMChildIlDrOth;
         TextView VlblMChildIlDrOth;
         EditText txtMChildIlDrOth;
         LinearLayout secMReco;
         View lineMReco;
         TextView VlblMReco;
         RadioGroup rdogrpMReco;
         
         RadioButton rdoMReco1;
         RadioButton rdoMReco2;
         RadioButton rdoMReco3;
         LinearLayout secMDurReco;
         View lineMDurReco;
         TextView VlblMDurReco;
         EditText txtMDurReco;
         LinearLayout secMInRecoLabel;
         View lineMInRecoLabel;
         LinearLayout secMInReco;
         View lineMInReco;
         TextView VlblMInReco;
         Spinner spnMInReco;
         LinearLayout secMInRecoOth;
         View lineMInRecoOth;
         TextView VlblMInRecoOth;
         EditText txtMInRecoOth;
         LinearLayout secMInReco2;
         View lineMInReco2;
         TextView VlblMInReco2;
         Spinner spnMInReco2;
         LinearLayout secMInRecoOth2;
         View lineMInRecoOth2;
         TextView VlblMInRecoOth2;
         EditText txtMInRecoOth2;
         LinearLayout secMInReco3;
         View lineMInReco3;
         TextView VlblMInReco3;
         Spinner spnMInReco3;
         LinearLayout secMInRecoOth3;
         View lineMInRecoOth3;
         TextView VlblMInRecoOth3;
         EditText txtMInRecoOth3;
         LinearLayout secAboSeriIlOnset;
         View lineAboSeriIlOnset;
         TextView VlblAboSeriIlOnset;
         EditText txtAboSeriIlOnset;

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
         setContentView(R.layout.meningitiscase);
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

         TableName = "MeningitisCase";

         //turnGPSOn();

         //GPS Location
         //FindLocation();
         // Double.toString(currentLatitude);
         // Double.toString(currentLongitude);
         lblHeading = (TextView)findViewById(R.id.lblHeading);

         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(MeningitisCase.this);
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
         secMemName=(LinearLayout)findViewById(R.id.secMemName);
         lineMemName=(View)findViewById(R.id.lineMemName);
         VlblMemName=(TextView) findViewById(R.id.VlblMemName);
         txtMemName=(EditText) findViewById(R.id.txtMemName);
         secMeningitisCaseLabel=(LinearLayout)findViewById(R.id.secMeningitisCaseLabel);
         lineMeningitisCaseLabel=(View)findViewById(R.id.lineMeningitisCaseLabel);
         secSeriIlOnset=(LinearLayout)findViewById(R.id.secSeriIlOnset);
         lineSeriIlOnset=(View)findViewById(R.id.lineSeriIlOnset);
         VlblSeriIlOnset = (TextView) findViewById(R.id.VlblSeriIlOnset);
         rdogrpSeriIlOnset = (RadioGroup) findViewById(R.id.rdogrpSeriIlOnset);

         txtUNCode.setText(UNCODE);
         txtStructureNo.setText(""+STRUCTURENO);
         txtHouseholdSl.setText(HOUSEHOLDSL);
         txtVisitNo.setText(VISITNO);
         txtMemSl.setText(MEMSL);
         txtMemName.setText(MEMNAME);

         rdoSeriIlOnset1 = (RadioButton) findViewById(R.id.rdoSeriIlOnset1);
         rdoSeriIlOnset2 = (RadioButton) findViewById(R.id.rdoSeriIlOnset2);
         rdoSeriIlOnset3 = (RadioButton) findViewById(R.id.rdoSeriIlOnset3);

         rdogrpSeriIlOnset.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpSeriIlOnset = new String[] {"1","2","8",""};
             for (int i = 0; i < rdogrpSeriIlOnset.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpSeriIlOnset.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpSeriIlOnset[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secSameIllSec2.setVisibility(View.GONE);
                    lineSameIllSec2.setVisibility(View.GONE);
                    rdogrpSameIllSec2.clearCheck();
                    secEpiSeriIlOnset.setVisibility(View.GONE);
                    lineEpiSeriIlOnset.setVisibility(View.GONE);
                    txtEpiSeriIlOnset.setText("");
                    secIlnessFev.setVisibility(View.GONE);
                    lineIlnessFev.setVisibility(View.GONE);
                    txtIlnessFev.setText("");
                    secIlnessConv.setVisibility(View.GONE);
                    lineIlnessConv.setVisibility(View.GONE);
                    rdogrpIlnessConv.clearCheck();
                    secUpRolEye.setVisibility(View.GONE);
                    lineUpRolEye.setVisibility(View.GONE);
                    rdogrpUpRolEye.clearCheck();
                    secMRigJaw.setVisibility(View.GONE);
                    lineMRigJaw.setVisibility(View.GONE);
                    rdogrpMRigJaw.clearCheck();
                    secMRigLimbs.setVisibility(View.GONE);
                    lineMRigLimbs.setVisibility(View.GONE);
                    rdogrpMRigLimbs.clearCheck();
                    secMDurConv.setVisibility(View.GONE);
                    lineMDurConv.setVisibility(View.GONE);
                    rdogrpMDurConv.clearCheck();
                    secMDrowsin.setVisibility(View.GONE);
                    lineMDrowsin.setVisibility(View.GONE);
                    rdogrpMDrowsin.clearCheck();
                    secMDurDrowsin.setVisibility(View.GONE);
                    lineMDurDrowsin.setVisibility(View.GONE);
                    txtMDurDrowsin.setText("");
                    secMUntoFeed.setVisibility(View.GONE);
                    lineMUntoFeed.setVisibility(View.GONE);
                    spnMUntoFeed.setSelection(0);
                    secMDurUntoFeed.setVisibility(View.GONE);
                    lineMDurUntoFeed.setVisibility(View.GONE);
                    txtMDurUntoFeed.setText("");
                    secMCalNoRes.setVisibility(View.GONE);
                    lineMCalNoRes.setVisibility(View.GONE);
                    spnMCalNoRes.setSelection(0);
                    secMDurCalNoRes.setVisibility(View.GONE);
                    lineMDurCalNoRes.setVisibility(View.GONE);
                    txtMDurCalNoRes.setText("");
                    secMEverConf.setVisibility(View.GONE);
                    lineMEverConf.setVisibility(View.GONE);
                    spnMEverConf.setSelection(0);
                    secMDurEverConf.setVisibility(View.GONE);
                    lineMDurEverConf.setVisibility(View.GONE);
                    spnMDurEverConf.setSelection(0);
                    secMFlicker.setVisibility(View.GONE);
                    lineMFlicker.setVisibility(View.GONE);
                    rdogrpMFlicker.clearCheck();
                    secMDurFliker.setVisibility(View.GONE);
                    lineMDurFliker.setVisibility(View.GONE);
                    spnMDurFliker.setSelection(0);
                    secMUnconsci.setVisibility(View.GONE);
                    lineMUnconsci.setVisibility(View.GONE);
                    rdogrpMUnconsci.clearCheck();
                    secMDurUnconsci.setVisibility(View.GONE);
                    lineMDurUnconsci.setVisibility(View.GONE);
                    spnMDurUnconsci.setSelection(0);
                    secMIlCry.setVisibility(View.GONE);
                    lineMIlCry.setVisibility(View.GONE);
                    rdogrpMIlCry.clearCheck();
                    secMDurIlCry.setVisibility(View.GONE);
                    lineMDurIlCry.setVisibility(View.GONE);
                    spnMDurIlCry.setSelection(0);
                    secMUnCraWalk.setVisibility(View.GONE);
                    lineMUnCraWalk.setVisibility(View.GONE);
                    spnMUnCraWalk.setSelection(0);
                    secMDurUnCraWalk.setVisibility(View.GONE);
                    lineMDurUnCraWalk.setVisibility(View.GONE);
                    spnMDurUnCraWalk.setSelection(0);
                    secMDifBreath.setVisibility(View.GONE);
                    lineMDifBreath.setVisibility(View.GONE);
                    rdogrpMDifBreath.clearCheck();
                    secMCough.setVisibility(View.GONE);
                    lineMCough.setVisibility(View.GONE);
                    rdogrpMCough.clearCheck();
                    secMRash.setVisibility(View.GONE);
                    lineMRash.setVisibility(View.GONE);
                    rdogrpMRash.clearCheck();
                    secMVomit.setVisibility(View.GONE);
                    lineMVomit.setVisibility(View.GONE);
                    rdogrpMVomit.clearCheck();
                    secMDiarrhoea.setVisibility(View.GONE);
                    lineMDiarrhoea.setVisibility(View.GONE);
                    rdogrpMDiarrhoea.clearCheck();
                    secMHCar.setVisibility(View.GONE);
                    lineMHCar.setVisibility(View.GONE);
                    rdogrpMHCar.clearCheck();
                    secMHCarTypLabel.setVisibility(View.GONE);
                    lineMHCarTypLabel.setVisibility(View.GONE);
                    secMHC_Phy.setVisibility(View.GONE);
                    lineMHC_Phy.setVisibility(View.GONE);
                    rdogrpMHC_Phy.clearCheck();
                    secMHC_UnquaDoctor.setVisibility(View.GONE);
                    lineMHC_UnquaDoctor.setVisibility(View.GONE);
                    rdogrpMHC_UnquaDoctor.clearCheck();
                    secMHC_Para.setVisibility(View.GONE);
                    lineMHC_Para.setVisibility(View.GONE);
                    rdogrpMHC_Para.clearCheck();
                    secMHC_Com.setVisibility(View.GONE);
                    lineMHC_Com.setVisibility(View.GONE);
                    rdogrpMHC_Com.clearCheck();
                    secMHC_Pha.setVisibility(View.GONE);
                    lineMHC_Pha.setVisibility(View.GONE);
                    rdogrpMHC_Pha.clearCheck();
                    secMHC_Hompath.setVisibility(View.GONE);
                    lineMHC_Hompath.setVisibility(View.GONE);
                    rdogrpMHC_Hompath.clearCheck();
                    secMHC_TrHeal.setVisibility(View.GONE);
                    lineMHC_TrHeal.setVisibility(View.GONE);
                    rdogrpMHC_TrHeal.clearCheck();
                    secMHC_SpiHeal.setVisibility(View.GONE);
                    lineMHC_SpiHeal.setVisibility(View.GONE);
                    rdogrpMHC_SpiHeal.clearCheck();
                    secMHC_Oth.setVisibility(View.GONE);
                    lineMHC_Oth.setVisibility(View.GONE);
                    rdogrpMHC_Oth.clearCheck();
                    secMHC_OthName.setVisibility(View.GONE);
                    lineMHC_OthName.setVisibility(View.GONE);
                    txtMHC_OthName.setText("");
                    secMDSHOPD.setVisibility(View.GONE);
                    lineMDSHOPD.setVisibility(View.GONE);
                    rdogrpMDSHOPD.clearCheck();
                    secMSSFOPD.setVisibility(View.GONE);
                    lineMSSFOPD.setVisibility(View.GONE);
                    rdogrpMSSFOPD.clearCheck();
                    secMHosAdm.setVisibility(View.GONE);
                    lineMHosAdm.setVisibility(View.GONE);
                    rdogrpMHosAdm.clearCheck();
                    secMHosNamLabel.setVisibility(View.GONE);
                    lineMHosNamLabel.setVisibility(View.GONE);
                    secMHC_Hosp_a1.setVisibility(View.GONE);
                    lineMHC_Hosp_a1.setVisibility(View.GONE);
                    spnMHC_Hosp_a1.setSelection(0);
                    secMHC_Hosp_a1_Oth.setVisibility(View.GONE);
                    lineMHC_Hosp_a1_Oth.setVisibility(View.GONE);
                    txtMHC_Hosp_a1_Oth.setText("");
                    secMHC_Hosp_a2.setVisibility(View.GONE);
                    lineMHC_Hosp_a2.setVisibility(View.GONE);
                    spnMHC_Hosp_a2.setSelection(0);
                    secMHC_Hosp_a2_Oth.setVisibility(View.GONE);
                    lineMHC_Hosp_a2_Oth.setVisibility(View.GONE);
                    txtMHC_Hosp_a2_Oth.setText("");
                    secMHC_Hosp_a3.setVisibility(View.GONE);
                    lineMHC_Hosp_a3.setVisibility(View.GONE);
                    spnMHC_Hosp_a3.setSelection(0);
                    secMHC_Hosp_a3_Oth.setVisibility(View.GONE);
                    lineMHC_Hosp_a3_Oth.setVisibility(View.GONE);
                    txtMHC_Hosp_a3_Oth.setText("");
                    secMDtHos.setVisibility(View.GONE);
                    lineMDtHos.setVisibility(View.GONE);
                    dtpMDtHos.setText("");
                    secMHosM.setVisibility(View.GONE);
                    lineMHosM.setVisibility(View.GONE);
                    txtMHosM.setText("");
                    secMDurIlBeHos.setVisibility(View.GONE);
                    lineMDurIlBeHos.setVisibility(View.GONE);
                    txtMDurIlBeHos.setText("");
                    secMChildIlDr.setVisibility(View.GONE);
                    lineMChildIlDr.setVisibility(View.GONE);
                    spnMChildIlDr.setSelection(0);
                    secMChildIlDrOth.setVisibility(View.GONE);
                    lineMChildIlDrOth.setVisibility(View.GONE);
                    txtMChildIlDrOth.setText("");
                    secMReco.setVisibility(View.GONE);
                    lineMReco.setVisibility(View.GONE);
                    rdogrpMReco.clearCheck();
                    secMDurReco.setVisibility(View.GONE);
                    lineMDurReco.setVisibility(View.GONE);
                    txtMDurReco.setText("");
                    secMInRecoLabel.setVisibility(View.GONE);
                    lineMInRecoLabel.setVisibility(View.GONE);
                    secMInReco.setVisibility(View.GONE);
                    lineMInReco.setVisibility(View.GONE);
                    spnMInReco.setSelection(0);
                    secMInRecoOth.setVisibility(View.GONE);
                    lineMInRecoOth.setVisibility(View.GONE);
                    txtMInRecoOth.setText("");
                    secMInReco2.setVisibility(View.GONE);
                    lineMInReco2.setVisibility(View.GONE);
                    spnMInReco2.setSelection(0);
                    secMInRecoOth2.setVisibility(View.GONE);
                    lineMInRecoOth2.setVisibility(View.GONE);
                    txtMInRecoOth2.setText("");
                    secMInReco3.setVisibility(View.GONE);
                    lineMInReco3.setVisibility(View.GONE);
                    spnMInReco3.setSelection(0);
                    secMInRecoOth3.setVisibility(View.GONE);
                    lineMInRecoOth3.setVisibility(View.GONE);
                    txtMInRecoOth3.setText("");
                    secAboSeriIlOnset.setVisibility(View.GONE);
                    lineAboSeriIlOnset.setVisibility(View.GONE);
                    txtAboSeriIlOnset.setText("");
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secSameIllSec2.setVisibility(View.GONE);
                    lineSameIllSec2.setVisibility(View.GONE);
                    rdogrpSameIllSec2.clearCheck();
                    secEpiSeriIlOnset.setVisibility(View.GONE);
                    lineEpiSeriIlOnset.setVisibility(View.GONE);
                    txtEpiSeriIlOnset.setText("");
                    secIlnessFev.setVisibility(View.GONE);
                    lineIlnessFev.setVisibility(View.GONE);
                    txtIlnessFev.setText("");
                    secIlnessConv.setVisibility(View.GONE);
                    lineIlnessConv.setVisibility(View.GONE);
                    rdogrpIlnessConv.clearCheck();
                    secUpRolEye.setVisibility(View.GONE);
                    lineUpRolEye.setVisibility(View.GONE);
                    rdogrpUpRolEye.clearCheck();
                    secMRigJaw.setVisibility(View.GONE);
                    lineMRigJaw.setVisibility(View.GONE);
                    rdogrpMRigJaw.clearCheck();
                    secMRigLimbs.setVisibility(View.GONE);
                    lineMRigLimbs.setVisibility(View.GONE);
                    rdogrpMRigLimbs.clearCheck();
                    secMDurConv.setVisibility(View.GONE);
                    lineMDurConv.setVisibility(View.GONE);
                    rdogrpMDurConv.clearCheck();
                    secMDrowsin.setVisibility(View.GONE);
                    lineMDrowsin.setVisibility(View.GONE);
                    rdogrpMDrowsin.clearCheck();
                    secMDurDrowsin.setVisibility(View.GONE);
                    lineMDurDrowsin.setVisibility(View.GONE);
                    txtMDurDrowsin.setText("");
                    secMUntoFeed.setVisibility(View.GONE);
                    lineMUntoFeed.setVisibility(View.GONE);
                    spnMUntoFeed.setSelection(0);
                    secMDurUntoFeed.setVisibility(View.GONE);
                    lineMDurUntoFeed.setVisibility(View.GONE);
                    txtMDurUntoFeed.setText("");
                    secMCalNoRes.setVisibility(View.GONE);
                    lineMCalNoRes.setVisibility(View.GONE);
                    spnMCalNoRes.setSelection(0);
                    secMDurCalNoRes.setVisibility(View.GONE);
                    lineMDurCalNoRes.setVisibility(View.GONE);
                    txtMDurCalNoRes.setText("");
                    secMEverConf.setVisibility(View.GONE);
                    lineMEverConf.setVisibility(View.GONE);
                    spnMEverConf.setSelection(0);
                    secMDurEverConf.setVisibility(View.GONE);
                    lineMDurEverConf.setVisibility(View.GONE);
                    spnMDurEverConf.setSelection(0);
                    secMFlicker.setVisibility(View.GONE);
                    lineMFlicker.setVisibility(View.GONE);
                    rdogrpMFlicker.clearCheck();
                    secMDurFliker.setVisibility(View.GONE);
                    lineMDurFliker.setVisibility(View.GONE);
                    spnMDurFliker.setSelection(0);
                    secMUnconsci.setVisibility(View.GONE);
                    lineMUnconsci.setVisibility(View.GONE);
                    rdogrpMUnconsci.clearCheck();
                    secMDurUnconsci.setVisibility(View.GONE);
                    lineMDurUnconsci.setVisibility(View.GONE);
                    spnMDurUnconsci.setSelection(0);
                    secMIlCry.setVisibility(View.GONE);
                    lineMIlCry.setVisibility(View.GONE);
                    rdogrpMIlCry.clearCheck();
                    secMDurIlCry.setVisibility(View.GONE);
                    lineMDurIlCry.setVisibility(View.GONE);
                    spnMDurIlCry.setSelection(0);
                    secMUnCraWalk.setVisibility(View.GONE);
                    lineMUnCraWalk.setVisibility(View.GONE);
                    spnMUnCraWalk.setSelection(0);
                    secMDurUnCraWalk.setVisibility(View.GONE);
                    lineMDurUnCraWalk.setVisibility(View.GONE);
                    spnMDurUnCraWalk.setSelection(0);
                    secMDifBreath.setVisibility(View.GONE);
                    lineMDifBreath.setVisibility(View.GONE);
                    rdogrpMDifBreath.clearCheck();
                    secMCough.setVisibility(View.GONE);
                    lineMCough.setVisibility(View.GONE);
                    rdogrpMCough.clearCheck();
                    secMRash.setVisibility(View.GONE);
                    lineMRash.setVisibility(View.GONE);
                    rdogrpMRash.clearCheck();
                    secMVomit.setVisibility(View.GONE);
                    lineMVomit.setVisibility(View.GONE);
                    rdogrpMVomit.clearCheck();
                    secMDiarrhoea.setVisibility(View.GONE);
                    lineMDiarrhoea.setVisibility(View.GONE);
                    rdogrpMDiarrhoea.clearCheck();
                    secMHCar.setVisibility(View.GONE);
                    lineMHCar.setVisibility(View.GONE);
                    rdogrpMHCar.clearCheck();
                    secMHCarTypLabel.setVisibility(View.GONE);
                    lineMHCarTypLabel.setVisibility(View.GONE);
                    secMHC_Phy.setVisibility(View.GONE);
                    lineMHC_Phy.setVisibility(View.GONE);
                    rdogrpMHC_Phy.clearCheck();
                    secMHC_UnquaDoctor.setVisibility(View.GONE);
                    lineMHC_UnquaDoctor.setVisibility(View.GONE);
                    rdogrpMHC_UnquaDoctor.clearCheck();
                    secMHC_Para.setVisibility(View.GONE);
                    lineMHC_Para.setVisibility(View.GONE);
                    rdogrpMHC_Para.clearCheck();
                    secMHC_Com.setVisibility(View.GONE);
                    lineMHC_Com.setVisibility(View.GONE);
                    rdogrpMHC_Com.clearCheck();
                    secMHC_Pha.setVisibility(View.GONE);
                    lineMHC_Pha.setVisibility(View.GONE);
                    rdogrpMHC_Pha.clearCheck();
                    secMHC_Hompath.setVisibility(View.GONE);
                    lineMHC_Hompath.setVisibility(View.GONE);
                    rdogrpMHC_Hompath.clearCheck();
                    secMHC_TrHeal.setVisibility(View.GONE);
                    lineMHC_TrHeal.setVisibility(View.GONE);
                    rdogrpMHC_TrHeal.clearCheck();
                    secMHC_SpiHeal.setVisibility(View.GONE);
                    lineMHC_SpiHeal.setVisibility(View.GONE);
                    rdogrpMHC_SpiHeal.clearCheck();
                    secMHC_Oth.setVisibility(View.GONE);
                    lineMHC_Oth.setVisibility(View.GONE);
                    rdogrpMHC_Oth.clearCheck();
                    secMHC_OthName.setVisibility(View.GONE);
                    lineMHC_OthName.setVisibility(View.GONE);
                    txtMHC_OthName.setText("");
                    secMDSHOPD.setVisibility(View.GONE);
                    lineMDSHOPD.setVisibility(View.GONE);
                    rdogrpMDSHOPD.clearCheck();
                    secMSSFOPD.setVisibility(View.GONE);
                    lineMSSFOPD.setVisibility(View.GONE);
                    rdogrpMSSFOPD.clearCheck();
                    secMHosAdm.setVisibility(View.GONE);
                    lineMHosAdm.setVisibility(View.GONE);
                    rdogrpMHosAdm.clearCheck();
                    secMHosNamLabel.setVisibility(View.GONE);
                    lineMHosNamLabel.setVisibility(View.GONE);
                    secMHC_Hosp_a1.setVisibility(View.GONE);
                    lineMHC_Hosp_a1.setVisibility(View.GONE);
                    spnMHC_Hosp_a1.setSelection(0);
                    secMHC_Hosp_a1_Oth.setVisibility(View.GONE);
                    lineMHC_Hosp_a1_Oth.setVisibility(View.GONE);
                    txtMHC_Hosp_a1_Oth.setText("");
                    secMHC_Hosp_a2.setVisibility(View.GONE);
                    lineMHC_Hosp_a2.setVisibility(View.GONE);
                    spnMHC_Hosp_a2.setSelection(0);
                    secMHC_Hosp_a2_Oth.setVisibility(View.GONE);
                    lineMHC_Hosp_a2_Oth.setVisibility(View.GONE);
                    txtMHC_Hosp_a2_Oth.setText("");
                    secMHC_Hosp_a3.setVisibility(View.GONE);
                    lineMHC_Hosp_a3.setVisibility(View.GONE);
                    spnMHC_Hosp_a3.setSelection(0);
                    secMHC_Hosp_a3_Oth.setVisibility(View.GONE);
                    lineMHC_Hosp_a3_Oth.setVisibility(View.GONE);
                    txtMHC_Hosp_a3_Oth.setText("");
                    secMDtHos.setVisibility(View.GONE);
                    lineMDtHos.setVisibility(View.GONE);
                    dtpMDtHos.setText("");
                    secMHosM.setVisibility(View.GONE);
                    lineMHosM.setVisibility(View.GONE);
                    txtMHosM.setText("");
                    secMDurIlBeHos.setVisibility(View.GONE);
                    lineMDurIlBeHos.setVisibility(View.GONE);
                    txtMDurIlBeHos.setText("");
                    secMChildIlDr.setVisibility(View.GONE);
                    lineMChildIlDr.setVisibility(View.GONE);
                    spnMChildIlDr.setSelection(0);
                    secMChildIlDrOth.setVisibility(View.GONE);
                    lineMChildIlDrOth.setVisibility(View.GONE);
                    txtMChildIlDrOth.setText("");
                    secMReco.setVisibility(View.GONE);
                    lineMReco.setVisibility(View.GONE);
                    rdogrpMReco.clearCheck();
                    secMDurReco.setVisibility(View.GONE);
                    lineMDurReco.setVisibility(View.GONE);
                    txtMDurReco.setText("");
                    secMInRecoLabel.setVisibility(View.GONE);
                    lineMInRecoLabel.setVisibility(View.GONE);
                    secMInReco.setVisibility(View.GONE);
                    lineMInReco.setVisibility(View.GONE);
                    spnMInReco.setSelection(0);
                    secMInRecoOth.setVisibility(View.GONE);
                    lineMInRecoOth.setVisibility(View.GONE);
                    txtMInRecoOth.setText("");
                    secMInReco2.setVisibility(View.GONE);
                    lineMInReco2.setVisibility(View.GONE);
                    spnMInReco2.setSelection(0);
                    secMInRecoOth2.setVisibility(View.GONE);
                    lineMInRecoOth2.setVisibility(View.GONE);
                    txtMInRecoOth2.setText("");
                    secMInReco3.setVisibility(View.GONE);
                    lineMInReco3.setVisibility(View.GONE);
                    spnMInReco3.setSelection(0);
                    secMInRecoOth3.setVisibility(View.GONE);
                    lineMInRecoOth3.setVisibility(View.GONE);
                    txtMInRecoOth3.setText("");
                    secAboSeriIlOnset.setVisibility(View.GONE);
                    lineAboSeriIlOnset.setVisibility(View.GONE);
                    txtAboSeriIlOnset.setText("");
             }
             else
             {
                    secSameIllSec2.setVisibility(View.VISIBLE);
                    lineSameIllSec2.setVisibility(View.VISIBLE);
                    secEpiSeriIlOnset.setVisibility(View.VISIBLE);
                    lineEpiSeriIlOnset.setVisibility(View.VISIBLE);
                    secIlnessFev.setVisibility(View.VISIBLE);
                    lineIlnessFev.setVisibility(View.VISIBLE);
                    secIlnessConv.setVisibility(View.VISIBLE);
                    lineIlnessConv.setVisibility(View.VISIBLE);



                    secMDrowsin.setVisibility(View.VISIBLE);
                    lineMDrowsin.setVisibility(View.VISIBLE);

                    secMUntoFeed.setVisibility(View.VISIBLE);
                    lineMUntoFeed.setVisibility(View.VISIBLE);
                    secMDurUntoFeed.setVisibility(View.VISIBLE);
                    lineMDurUntoFeed.setVisibility(View.VISIBLE);
                    secMCalNoRes.setVisibility(View.VISIBLE);
                    lineMCalNoRes.setVisibility(View.VISIBLE);
                    secMDurCalNoRes.setVisibility(View.VISIBLE);
                    lineMDurCalNoRes.setVisibility(View.VISIBLE);
                    secMEverConf.setVisibility(View.VISIBLE);
                    lineMEverConf.setVisibility(View.VISIBLE);
                    secMDurEverConf.setVisibility(View.VISIBLE);
                    lineMDurEverConf.setVisibility(View.VISIBLE);
                    secMFlicker.setVisibility(View.VISIBLE);
                    lineMFlicker.setVisibility(View.VISIBLE);

                    secMUnconsci.setVisibility(View.VISIBLE);
                    lineMUnconsci.setVisibility(View.VISIBLE);

                    secMIlCry.setVisibility(View.VISIBLE);
                    lineMIlCry.setVisibility(View.VISIBLE);

                    secMUnCraWalk.setVisibility(View.VISIBLE);
                    lineMUnCraWalk.setVisibility(View.VISIBLE);
                    secMDurUnCraWalk.setVisibility(View.VISIBLE);
                    lineMDurUnCraWalk.setVisibility(View.VISIBLE);
                    secMDifBreath.setVisibility(View.VISIBLE);
                    lineMDifBreath.setVisibility(View.VISIBLE);
                    secMCough.setVisibility(View.VISIBLE);
                    lineMCough.setVisibility(View.VISIBLE);
                    secMRash.setVisibility(View.VISIBLE);
                    lineMRash.setVisibility(View.VISIBLE);
                    secMVomit.setVisibility(View.VISIBLE);
                    lineMVomit.setVisibility(View.VISIBLE);
                    secMDiarrhoea.setVisibility(View.VISIBLE);
                    lineMDiarrhoea.setVisibility(View.VISIBLE);
                    secMHCar.setVisibility(View.VISIBLE);
                    lineMHCar.setVisibility(View.VISIBLE);


                    secMDSHOPD.setVisibility(View.VISIBLE);
                    lineMDSHOPD.setVisibility(View.VISIBLE);
                    secMSSFOPD.setVisibility(View.VISIBLE);
                    lineMSSFOPD.setVisibility(View.VISIBLE);
                    secMHosAdm.setVisibility(View.VISIBLE);
                    lineMHosAdm.setVisibility(View.VISIBLE);
                    secMHosNamLabel.setVisibility(View.VISIBLE);
                    lineMHosNamLabel.setVisibility(View.VISIBLE);
                    secMHC_Hosp_a1.setVisibility(View.VISIBLE);
                    lineMHC_Hosp_a1.setVisibility(View.VISIBLE);

                    secMHC_Hosp_a2.setVisibility(View.VISIBLE);
                    lineMHC_Hosp_a2.setVisibility(View.VISIBLE);

                    secMHC_Hosp_a3.setVisibility(View.VISIBLE);
                    lineMHC_Hosp_a3.setVisibility(View.VISIBLE);

                    secMDtHos.setVisibility(View.VISIBLE);
                    lineMDtHos.setVisibility(View.VISIBLE);
                    secMHosM.setVisibility(View.VISIBLE);
                    lineMHosM.setVisibility(View.VISIBLE);
                    secMDurIlBeHos.setVisibility(View.VISIBLE);
                    lineMDurIlBeHos.setVisibility(View.VISIBLE);
                    secMChildIlDr.setVisibility(View.VISIBLE);
                    lineMChildIlDr.setVisibility(View.VISIBLE);

                    secMReco.setVisibility(View.VISIBLE);
                    lineMReco.setVisibility(View.VISIBLE);

                 secMInRecoLabel.setVisibility(View.VISIBLE);
                 lineMInRecoLabel.setVisibility(View.VISIBLE);

                 secMInReco.setVisibility(View.VISIBLE);
                 lineMInReco.setVisibility(View.VISIBLE);
                 spnMInReco.setSelection(0);

                 secMInReco2.setVisibility(View.VISIBLE);
                 lineMInReco2.setVisibility(View.VISIBLE);
                 spnMInReco2.setSelection(0);

                 secMInReco3.setVisibility(View.VISIBLE);
                 lineMInReco3.setVisibility(View.VISIBLE);
                 spnMInReco3.setSelection(0);
                    secAboSeriIlOnset.setVisibility(View.VISIBLE);
                    lineAboSeriIlOnset.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secSameIllSec2=(LinearLayout)findViewById(R.id.secSameIllSec2);
         lineSameIllSec2=(View)findViewById(R.id.lineSameIllSec2);
         VlblSameIllSec2 = (TextView) findViewById(R.id.VlblSameIllSec2);
         rdogrpSameIllSec2 = (RadioGroup) findViewById(R.id.rdogrpSameIllSec2);
         
         rdoSameIllSec21 = (RadioButton) findViewById(R.id.rdoSameIllSec21);
         rdoSameIllSec22 = (RadioButton) findViewById(R.id.rdoSameIllSec22);
         secEpiSeriIlOnset=(LinearLayout)findViewById(R.id.secEpiSeriIlOnset);
         lineEpiSeriIlOnset=(View)findViewById(R.id.lineEpiSeriIlOnset);
         VlblEpiSeriIlOnset=(TextView) findViewById(R.id.VlblEpiSeriIlOnset);
         txtEpiSeriIlOnset=(EditText) findViewById(R.id.txtEpiSeriIlOnset);
         secIlnessFev=(LinearLayout)findViewById(R.id.secIlnessFev);
         lineIlnessFev=(View)findViewById(R.id.lineIlnessFev);
         VlblIlnessFev=(TextView) findViewById(R.id.VlblIlnessFev);
         txtIlnessFev=(EditText) findViewById(R.id.txtIlnessFev);
         secIlnessConv=(LinearLayout)findViewById(R.id.secIlnessConv);
         lineIlnessConv=(View)findViewById(R.id.lineIlnessConv);
         VlblIlnessConv = (TextView) findViewById(R.id.VlblIlnessConv);
         rdogrpIlnessConv = (RadioGroup) findViewById(R.id.rdogrpIlnessConv);
         
         rdoIlnessConv1 = (RadioButton) findViewById(R.id.rdoIlnessConv1);
         rdoIlnessConv2 = (RadioButton) findViewById(R.id.rdoIlnessConv2);
         rdoIlnessConv3 = (RadioButton) findViewById(R.id.rdoIlnessConv3);
         rdogrpIlnessConv.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpIlnessConv = new String[] {"1","2","8"};
             for (int i = 0; i < rdogrpIlnessConv.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpIlnessConv.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpIlnessConv[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secUpRolEye.setVisibility(View.GONE);
                    lineUpRolEye.setVisibility(View.GONE);
                    rdogrpUpRolEye.clearCheck();
                    secMRigJaw.setVisibility(View.GONE);
                    lineMRigJaw.setVisibility(View.GONE);
                    rdogrpMRigJaw.clearCheck();
                    secMRigLimbs.setVisibility(View.GONE);
                    lineMRigLimbs.setVisibility(View.GONE);
                    rdogrpMRigLimbs.clearCheck();
                    secMDurConv.setVisibility(View.GONE);
                    lineMDurConv.setVisibility(View.GONE);
                    rdogrpMDurConv.clearCheck();
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secUpRolEye.setVisibility(View.GONE);
                    lineUpRolEye.setVisibility(View.GONE);
                    rdogrpUpRolEye.clearCheck();
                    secMRigJaw.setVisibility(View.GONE);
                    lineMRigJaw.setVisibility(View.GONE);
                    rdogrpMRigJaw.clearCheck();
                    secMRigLimbs.setVisibility(View.GONE);
                    lineMRigLimbs.setVisibility(View.GONE);
                    rdogrpMRigLimbs.clearCheck();
                    secMDurConv.setVisibility(View.GONE);
                    lineMDurConv.setVisibility(View.GONE);
                    rdogrpMDurConv.clearCheck();
             }
             else if(rbData.equalsIgnoreCase("1"))
             {
                    secUpRolEye.setVisibility(View.VISIBLE);
                    lineUpRolEye.setVisibility(View.VISIBLE);
                    secMRigJaw.setVisibility(View.VISIBLE);
                    lineMRigJaw.setVisibility(View.VISIBLE);
                    secMRigLimbs.setVisibility(View.VISIBLE);
                    lineMRigLimbs.setVisibility(View.VISIBLE);
                    secMDurConv.setVisibility(View.VISIBLE);
                    lineMDurConv.setVisibility(View.VISIBLE);
             }
             else {
                 secUpRolEye.setVisibility(View.GONE);
                 lineUpRolEye.setVisibility(View.GONE);
                 rdogrpUpRolEye.clearCheck();
                 secMRigJaw.setVisibility(View.GONE);
                 lineMRigJaw.setVisibility(View.GONE);
                 rdogrpMRigJaw.clearCheck();
                 secMRigLimbs.setVisibility(View.GONE);
                 lineMRigLimbs.setVisibility(View.GONE);
                 rdogrpMRigLimbs.clearCheck();
                 secMDurConv.setVisibility(View.GONE);
                 lineMDurConv.setVisibility(View.GONE);
                 rdogrpMDurConv.clearCheck();
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secUpRolEye=(LinearLayout)findViewById(R.id.secUpRolEye);
         lineUpRolEye=(View)findViewById(R.id.lineUpRolEye);
         VlblUpRolEye = (TextView) findViewById(R.id.VlblUpRolEye);
         rdogrpUpRolEye = (RadioGroup) findViewById(R.id.rdogrpUpRolEye);
         
         rdoUpRolEye1 = (RadioButton) findViewById(R.id.rdoUpRolEye1);
         rdoUpRolEye2 = (RadioButton) findViewById(R.id.rdoUpRolEye2);
         rdoUpRolEye3 = (RadioButton) findViewById(R.id.rdoUpRolEye3);
         secMRigJaw=(LinearLayout)findViewById(R.id.secMRigJaw);
         lineMRigJaw=(View)findViewById(R.id.lineMRigJaw);
         VlblMRigJaw = (TextView) findViewById(R.id.VlblMRigJaw);
         rdogrpMRigJaw = (RadioGroup) findViewById(R.id.rdogrpMRigJaw);
         
         rdoMRigJaw1 = (RadioButton) findViewById(R.id.rdoMRigJaw1);
         rdoMRigJaw2 = (RadioButton) findViewById(R.id.rdoMRigJaw2);
         rdoMRigJaw3 = (RadioButton) findViewById(R.id.rdoMRigJaw3);
         secMRigLimbs=(LinearLayout)findViewById(R.id.secMRigLimbs);
         lineMRigLimbs=(View)findViewById(R.id.lineMRigLimbs);
         VlblMRigLimbs = (TextView) findViewById(R.id.VlblMRigLimbs);
         rdogrpMRigLimbs = (RadioGroup) findViewById(R.id.rdogrpMRigLimbs);
         
         rdoMRigLimbs1 = (RadioButton) findViewById(R.id.rdoMRigLimbs1);
         rdoMRigLimbs2 = (RadioButton) findViewById(R.id.rdoMRigLimbs2);
         rdoMRigLimbs3 = (RadioButton) findViewById(R.id.rdoMRigLimbs3);
         secMDurConv=(LinearLayout)findViewById(R.id.secMDurConv);
         lineMDurConv=(View)findViewById(R.id.lineMDurConv);
         VlblMDurConv = (TextView) findViewById(R.id.VlblMDurConv);
         rdogrpMDurConv = (RadioGroup) findViewById(R.id.rdogrpMDurConv);
         
         rdoMDurConv1 = (RadioButton) findViewById(R.id.rdoMDurConv1);
         rdoMDurConv2 = (RadioButton) findViewById(R.id.rdoMDurConv2);
         rdoMDurConv3 = (RadioButton) findViewById(R.id.rdoMDurConv3);
         rdoMDurConv4 = (RadioButton) findViewById(R.id.rdoMDurConv4);
         rdoMDurConv5 = (RadioButton) findViewById(R.id.rdoMDurConv5);
         secMDrowsin=(LinearLayout)findViewById(R.id.secMDrowsin);
         lineMDrowsin=(View)findViewById(R.id.lineMDrowsin);
         VlblMDrowsin = (TextView) findViewById(R.id.VlblMDrowsin);
         rdogrpMDrowsin = (RadioGroup) findViewById(R.id.rdogrpMDrowsin);
         
         rdoMDrowsin1 = (RadioButton) findViewById(R.id.rdoMDrowsin1);
         rdoMDrowsin2 = (RadioButton) findViewById(R.id.rdoMDrowsin2);
         rdoMDrowsin3 = (RadioButton) findViewById(R.id.rdoMDrowsin3);
         rdogrpMDrowsin.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpMDrowsin = new String[] {"1","2","8"};
             for (int i = 0; i < rdogrpMDrowsin.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpMDrowsin.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpMDrowsin[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secMDurDrowsin.setVisibility(View.GONE);
                    lineMDurDrowsin.setVisibility(View.GONE);
                    txtMDurDrowsin.setText("");
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secMDurDrowsin.setVisibility(View.GONE);
                    lineMDurDrowsin.setVisibility(View.GONE);
                    txtMDurDrowsin.setText("");
             }
             else if(rbData.equalsIgnoreCase("1"))
             {
                    secMDurDrowsin.setVisibility(View.VISIBLE);
                    lineMDurDrowsin.setVisibility(View.VISIBLE);
             }
             else
             {
                 secMDurDrowsin.setVisibility(View.GONE);
                 lineMDurDrowsin.setVisibility(View.GONE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secMDurDrowsin=(LinearLayout)findViewById(R.id.secMDurDrowsin);
         lineMDurDrowsin=(View)findViewById(R.id.lineMDurDrowsin);
         VlblMDurDrowsin=(TextView) findViewById(R.id.VlblMDurDrowsin);
         txtMDurDrowsin=(EditText) findViewById(R.id.txtMDurDrowsin);
         secMUntoFeed=(LinearLayout)findViewById(R.id.secMUntoFeed);
         lineMUntoFeed=(View)findViewById(R.id.lineMUntoFeed);
         VlblMUntoFeed=(TextView) findViewById(R.id.VlblMUntoFeed);
         spnMUntoFeed=(Spinner) findViewById(R.id.spnMUntoFeed);
         List<String> listMUntoFeed = new ArrayList<String>();
         
         listMUntoFeed.add("");
         listMUntoFeed.add("1-Yes");
         listMUntoFeed.add("2-No");
         listMUntoFeed.add("8-Don’t Know ");
         listMUntoFeed.add("9-NA");
         ArrayAdapter<String> adptrMUntoFeed= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listMUntoFeed);
         spnMUntoFeed.setAdapter(adptrMUntoFeed);

         spnMUntoFeed.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnMUntoFeed.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnMUntoFeed.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("2"))
                 {
                    secMDurUntoFeed.setVisibility(View.GONE);
                    lineMDurUntoFeed.setVisibility(View.GONE);
                    txtMDurUntoFeed.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("8"))
                 {
                    secMDurUntoFeed.setVisibility(View.GONE);
                    lineMDurUntoFeed.setVisibility(View.GONE);
                    txtMDurUntoFeed.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("9"))
                 {
                    secMDurUntoFeed.setVisibility(View.GONE);
                    lineMDurUntoFeed.setVisibility(View.GONE);
                    txtMDurUntoFeed.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("1"))
                 {
                    secMDurUntoFeed.setVisibility(View.VISIBLE);
                    lineMDurUntoFeed.setVisibility(View.VISIBLE);
                 }
                 else
                 {
                     secMDurUntoFeed.setVisibility(View.GONE);
                     lineMDurUntoFeed.setVisibility(View.GONE);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secMDurUntoFeed=(LinearLayout)findViewById(R.id.secMDurUntoFeed);
         lineMDurUntoFeed=(View)findViewById(R.id.lineMDurUntoFeed);
         VlblMDurUntoFeed=(TextView) findViewById(R.id.VlblMDurUntoFeed);
         txtMDurUntoFeed=(EditText) findViewById(R.id.txtMDurUntoFeed);
         secMCalNoRes=(LinearLayout)findViewById(R.id.secMCalNoRes);
         lineMCalNoRes=(View)findViewById(R.id.lineMCalNoRes);
         VlblMCalNoRes=(TextView) findViewById(R.id.VlblMCalNoRes);
         spnMCalNoRes=(Spinner) findViewById(R.id.spnMCalNoRes);
         List<String> listMCalNoRes = new ArrayList<String>();
         
         listMCalNoRes.add("");
         listMCalNoRes.add("1-Yes");
         listMCalNoRes.add("2-No");
         listMCalNoRes.add("8-Don’t Know   ");
         listMCalNoRes.add("9-NA");
         ArrayAdapter<String> adptrMCalNoRes= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listMCalNoRes);
         spnMCalNoRes.setAdapter(adptrMCalNoRes);

         spnMCalNoRes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnMCalNoRes.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnMCalNoRes.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("2"))
                 {
                    secMDurCalNoRes.setVisibility(View.GONE);
                    lineMDurCalNoRes.setVisibility(View.GONE);
                    txtMDurCalNoRes.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("8"))
                 {
                    secMDurCalNoRes.setVisibility(View.GONE);
                    lineMDurCalNoRes.setVisibility(View.GONE);
                    txtMDurCalNoRes.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("9"))
                 {
                    secMDurCalNoRes.setVisibility(View.GONE);
                    lineMDurCalNoRes.setVisibility(View.GONE);
                    txtMDurCalNoRes.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("1"))
                 {
                    secMDurCalNoRes.setVisibility(View.VISIBLE);
                    lineMDurCalNoRes.setVisibility(View.VISIBLE);
                 }
                 else{
                     secMDurCalNoRes.setVisibility(View.GONE);
                     lineMDurCalNoRes.setVisibility(View.GONE);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secMDurCalNoRes=(LinearLayout)findViewById(R.id.secMDurCalNoRes);
         lineMDurCalNoRes=(View)findViewById(R.id.lineMDurCalNoRes);
         VlblMDurCalNoRes=(TextView) findViewById(R.id.VlblMDurCalNoRes);
         txtMDurCalNoRes=(EditText) findViewById(R.id.txtMDurCalNoRes);
         secMEverConf=(LinearLayout)findViewById(R.id.secMEverConf);
         lineMEverConf=(View)findViewById(R.id.lineMEverConf);
         VlblMEverConf=(TextView) findViewById(R.id.VlblMEverConf);
         spnMEverConf=(Spinner) findViewById(R.id.spnMEverConf);
         List<String> listMEverConf = new ArrayList<String>();
         
         listMEverConf.add("");
         listMEverConf.add("1-Yes");
         listMEverConf.add("2-No");
         listMEverConf.add("8-Don’t Know  ");
         listMEverConf.add("9-NA");
         ArrayAdapter<String> adptrMEverConf= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listMEverConf);
         spnMEverConf.setAdapter(adptrMEverConf);

         spnMEverConf.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnMEverConf.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnMEverConf.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("2"))
                 {
                    secMDurEverConf.setVisibility(View.GONE);
                    lineMDurEverConf.setVisibility(View.GONE);
                    spnMDurEverConf.setSelection(0);
                 }
                 else if(spnData.equalsIgnoreCase("8"))
                 {
                    secMDurEverConf.setVisibility(View.GONE);
                    lineMDurEverConf.setVisibility(View.GONE);
                    spnMDurEverConf.setSelection(0);
                 }
                 else if(spnData.equalsIgnoreCase("9"))
                 {
                    secMDurEverConf.setVisibility(View.GONE);
                    lineMDurEverConf.setVisibility(View.GONE);
                    spnMDurEverConf.setSelection(0);
                 }
                 else if(spnData.equalsIgnoreCase("1"))
                 {
                    secMDurEverConf.setVisibility(View.VISIBLE);
                    lineMDurEverConf.setVisibility(View.VISIBLE);
                 }
                 else{
                     secMDurEverConf.setVisibility(View.GONE);
                     lineMDurEverConf.setVisibility(View.GONE);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secMDurEverConf=(LinearLayout)findViewById(R.id.secMDurEverConf);
         lineMDurEverConf=(View)findViewById(R.id.lineMDurEverConf);
         VlblMDurEverConf=(TextView) findViewById(R.id.VlblMDurEverConf);
         spnMDurEverConf=(Spinner) findViewById(R.id.spnMDurEverConf);
         List<String> listMDurEverConf = new ArrayList<String>();
         
         listMDurEverConf.add("");
         listMDurEverConf.add("1-(<1 hour)");
         listMDurEverConf.add("2-(1-6 hours)");
         listMDurEverConf.add("3-(7-24 hours)");
         listMDurEverConf.add("4-(>24 hours)");
         listMDurEverConf.add("8-Don’t Know");
         ArrayAdapter<String> adptrMDurEverConf= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listMDurEverConf);
         spnMDurEverConf.setAdapter(adptrMDurEverConf);

         secMFlicker=(LinearLayout)findViewById(R.id.secMFlicker);
         lineMFlicker=(View)findViewById(R.id.lineMFlicker);
         VlblMFlicker = (TextView) findViewById(R.id.VlblMFlicker);
         rdogrpMFlicker = (RadioGroup) findViewById(R.id.rdogrpMFlicker);
         
         rdoMFlicker1 = (RadioButton) findViewById(R.id.rdoMFlicker1);
         rdoMFlicker2 = (RadioButton) findViewById(R.id.rdoMFlicker2);
         rdoMFlicker3 = (RadioButton) findViewById(R.id.rdoMFlicker3);
         rdogrpMFlicker.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpMFlicker = new String[] {"1","2","8"};
             for (int i = 0; i < rdogrpMFlicker.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpMFlicker.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpMFlicker[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secMDurFliker.setVisibility(View.GONE);
                    lineMDurFliker.setVisibility(View.GONE);
                    spnMDurFliker.setSelection(0);
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secMDurFliker.setVisibility(View.GONE);
                    lineMDurFliker.setVisibility(View.GONE);
                    spnMDurFliker.setSelection(0);
             }
             else if(rbData.equalsIgnoreCase("1"))
             {
                    secMDurFliker.setVisibility(View.VISIBLE);
                    lineMDurFliker.setVisibility(View.VISIBLE);
             }
             else{
                 secMDurFliker.setVisibility(View.GONE);
                 lineMDurFliker.setVisibility(View.GONE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secMDurFliker=(LinearLayout)findViewById(R.id.secMDurFliker);
         lineMDurFliker=(View)findViewById(R.id.lineMDurFliker);
         VlblMDurFliker=(TextView) findViewById(R.id.VlblMDurFliker);
         spnMDurFliker=(Spinner) findViewById(R.id.spnMDurFliker);
         List<String> listMDurFliker = new ArrayList<String>();
         
         listMDurFliker.add("");
         listMDurFliker.add("1-<1 hour");
         listMDurFliker.add("2-1-6 hours");
         listMDurFliker.add("3-7-24 hours");
         listMDurFliker.add("4->24 hours");
         listMDurFliker.add("8-Don’t Know ");
         ArrayAdapter<String> adptrMDurFliker= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listMDurFliker);
         spnMDurFliker.setAdapter(adptrMDurFliker);

         secMUnconsci=(LinearLayout)findViewById(R.id.secMUnconsci);
         lineMUnconsci=(View)findViewById(R.id.lineMUnconsci);
         VlblMUnconsci = (TextView) findViewById(R.id.VlblMUnconsci);
         rdogrpMUnconsci = (RadioGroup) findViewById(R.id.rdogrpMUnconsci);
         
         rdoMUnconsci1 = (RadioButton) findViewById(R.id.rdoMUnconsci1);
         rdoMUnconsci2 = (RadioButton) findViewById(R.id.rdoMUnconsci2);
         rdoMUnconsci3 = (RadioButton) findViewById(R.id.rdoMUnconsci3);
         rdogrpMUnconsci.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpMUnconsci = new String[] {"1","2","8"};
             for (int i = 0; i < rdogrpMUnconsci.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpMUnconsci.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpMUnconsci[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secMDurUnconsci.setVisibility(View.GONE);
                    lineMDurUnconsci.setVisibility(View.GONE);
                    spnMDurUnconsci.setSelection(0);
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secMDurUnconsci.setVisibility(View.GONE);
                    lineMDurUnconsci.setVisibility(View.GONE);
                    spnMDurUnconsci.setSelection(0);
             }
             else if(rbData.equalsIgnoreCase("1"))
             {
                    secMDurUnconsci.setVisibility(View.VISIBLE);
                    lineMDurUnconsci.setVisibility(View.VISIBLE);
             }
             else{
                 secMDurUnconsci.setVisibility(View.GONE);
                 lineMDurUnconsci.setVisibility(View.GONE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secMDurUnconsci=(LinearLayout)findViewById(R.id.secMDurUnconsci);
         lineMDurUnconsci=(View)findViewById(R.id.lineMDurUnconsci);
         VlblMDurUnconsci=(TextView) findViewById(R.id.VlblMDurUnconsci);
         spnMDurUnconsci=(Spinner) findViewById(R.id.spnMDurUnconsci);
         List<String> listMDurUnconsci = new ArrayList<String>();
         
         listMDurUnconsci.add("");
         listMDurUnconsci.add("1-<1 hour");
         listMDurUnconsci.add("2-1-6 hours");
         listMDurUnconsci.add("3-7-24 hours");
         listMDurUnconsci.add("4-> 24 hours");
         listMDurUnconsci.add("8-Don’t Know ");
         ArrayAdapter<String> adptrMDurUnconsci= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listMDurUnconsci);
         spnMDurUnconsci.setAdapter(adptrMDurUnconsci);

         secMIlCry=(LinearLayout)findViewById(R.id.secMIlCry);
         lineMIlCry=(View)findViewById(R.id.lineMIlCry);
         VlblMIlCry = (TextView) findViewById(R.id.VlblMIlCry);
         rdogrpMIlCry = (RadioGroup) findViewById(R.id.rdogrpMIlCry);
         
         rdoMIlCry1 = (RadioButton) findViewById(R.id.rdoMIlCry1);
         rdoMIlCry2 = (RadioButton) findViewById(R.id.rdoMIlCry2);
         rdoMIlCry3 = (RadioButton) findViewById(R.id.rdoMIlCry3);
         rdogrpMIlCry.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpMIlCry = new String[] {"1","2","8"};
             for (int i = 0; i < rdogrpMIlCry.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpMIlCry.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpMIlCry[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secMDurIlCry.setVisibility(View.GONE);
                    lineMDurIlCry.setVisibility(View.GONE);
                    spnMDurIlCry.setSelection(0);
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secMDurIlCry.setVisibility(View.GONE);
                    lineMDurIlCry.setVisibility(View.GONE);
                    spnMDurIlCry.setSelection(0);
             }
             else if(rbData.equalsIgnoreCase("1"))
             {
                    secMDurIlCry.setVisibility(View.VISIBLE);
                    lineMDurIlCry.setVisibility(View.VISIBLE);
             }
             else{
                 secMDurIlCry.setVisibility(View.GONE);
                 lineMDurIlCry.setVisibility(View.GONE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secMDurIlCry=(LinearLayout)findViewById(R.id.secMDurIlCry);
         lineMDurIlCry=(View)findViewById(R.id.lineMDurIlCry);
         VlblMDurIlCry=(TextView) findViewById(R.id.VlblMDurIlCry);
         spnMDurIlCry=(Spinner) findViewById(R.id.spnMDurIlCry);
         List<String> listMDurIlCry = new ArrayList<String>();
         
         listMDurIlCry.add("");
         listMDurIlCry.add("1-<1 hour");
         listMDurIlCry.add("2-1-6 hours");
         listMDurIlCry.add("3-7-24 hours");
         listMDurIlCry.add("4->24 hours");
         listMDurIlCry.add("8-Don’t Know ");
         listMDurIlCry.add("9-NA ");
         ArrayAdapter<String> adptrMDurIlCry= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listMDurIlCry);
         spnMDurIlCry.setAdapter(adptrMDurIlCry);

         secMUnCraWalk=(LinearLayout)findViewById(R.id.secMUnCraWalk);
         lineMUnCraWalk=(View)findViewById(R.id.lineMUnCraWalk);
         VlblMUnCraWalk=(TextView) findViewById(R.id.VlblMUnCraWalk);
         spnMUnCraWalk=(Spinner) findViewById(R.id.spnMUnCraWalk);
         List<String> listMUnCraWalk = new ArrayList<String>();
         
         listMUnCraWalk.add("");
         listMUnCraWalk.add("1-Yes");
         listMUnCraWalk.add("2-No");
         listMUnCraWalk.add("8-Don’t Know");
         listMUnCraWalk.add("9-NA");
         ArrayAdapter<String> adptrMUnCraWalk= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listMUnCraWalk);
         spnMUnCraWalk.setAdapter(adptrMUnCraWalk);

         spnMUnCraWalk.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnMUnCraWalk.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnMUnCraWalk.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("2"))
                 {
                    secMDurUnCraWalk.setVisibility(View.GONE);
                    lineMDurUnCraWalk.setVisibility(View.GONE);
                    spnMDurUnCraWalk.setSelection(0);
                 }
                 else if(spnData.equalsIgnoreCase("8"))
                 {
                    secMDurUnCraWalk.setVisibility(View.GONE);
                    lineMDurUnCraWalk.setVisibility(View.GONE);
                    spnMDurUnCraWalk.setSelection(0);
                 }
                 else if(spnData.equalsIgnoreCase("9"))
                 {
                    secMDurUnCraWalk.setVisibility(View.GONE);
                    lineMDurUnCraWalk.setVisibility(View.GONE);
                    spnMDurUnCraWalk.setSelection(0);
                 }
                 else if(spnData.equalsIgnoreCase("1"))
                 {
                    secMDurUnCraWalk.setVisibility(View.VISIBLE);
                    lineMDurUnCraWalk.setVisibility(View.VISIBLE);
                 }
                 else{
                     secMDurUnCraWalk.setVisibility(View.GONE);
                     lineMDurUnCraWalk.setVisibility(View.GONE);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secMDurUnCraWalk=(LinearLayout)findViewById(R.id.secMDurUnCraWalk);
         lineMDurUnCraWalk=(View)findViewById(R.id.lineMDurUnCraWalk);
         VlblMDurUnCraWalk=(TextView) findViewById(R.id.VlblMDurUnCraWalk);
         spnMDurUnCraWalk=(Spinner) findViewById(R.id.spnMDurUnCraWalk);
         List<String> listMDurUnCraWalk = new ArrayList<String>();
         
         listMDurUnCraWalk.add("");
         listMDurUnCraWalk.add("1-<1 hour");
         listMDurUnCraWalk.add("2-1-6 hours");
         listMDurUnCraWalk.add("3-7-24 hours");
         listMDurUnCraWalk.add("4-> 24 hours");
         listMDurUnCraWalk.add("8-Don’t Know");
         ArrayAdapter<String> adptrMDurUnCraWalk= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listMDurUnCraWalk);
         spnMDurUnCraWalk.setAdapter(adptrMDurUnCraWalk);

         secMDifBreath=(LinearLayout)findViewById(R.id.secMDifBreath);
         lineMDifBreath=(View)findViewById(R.id.lineMDifBreath);
         VlblMDifBreath = (TextView) findViewById(R.id.VlblMDifBreath);
         rdogrpMDifBreath = (RadioGroup) findViewById(R.id.rdogrpMDifBreath);
         
         rdoMDifBreath1 = (RadioButton) findViewById(R.id.rdoMDifBreath1);
         rdoMDifBreath2 = (RadioButton) findViewById(R.id.rdoMDifBreath2);
         rdoMDifBreath3 = (RadioButton) findViewById(R.id.rdoMDifBreath3);
         secMCough=(LinearLayout)findViewById(R.id.secMCough);
         lineMCough=(View)findViewById(R.id.lineMCough);
         VlblMCough = (TextView) findViewById(R.id.VlblMCough);
         rdogrpMCough = (RadioGroup) findViewById(R.id.rdogrpMCough);
         
         rdoMCough1 = (RadioButton) findViewById(R.id.rdoMCough1);
         rdoMCough2 = (RadioButton) findViewById(R.id.rdoMCough2);
         rdoMCough3 = (RadioButton) findViewById(R.id.rdoMCough3);
         secMRash=(LinearLayout)findViewById(R.id.secMRash);
         lineMRash=(View)findViewById(R.id.lineMRash);
         VlblMRash = (TextView) findViewById(R.id.VlblMRash);
         rdogrpMRash = (RadioGroup) findViewById(R.id.rdogrpMRash);
         
         rdoMRash1 = (RadioButton) findViewById(R.id.rdoMRash1);
         rdoMRash2 = (RadioButton) findViewById(R.id.rdoMRash2);
         rdoMRash3 = (RadioButton) findViewById(R.id.rdoMRash3);
         secMVomit=(LinearLayout)findViewById(R.id.secMVomit);
         lineMVomit=(View)findViewById(R.id.lineMVomit);
         VlblMVomit = (TextView) findViewById(R.id.VlblMVomit);
         rdogrpMVomit = (RadioGroup) findViewById(R.id.rdogrpMVomit);
         
         rdoMVomit1 = (RadioButton) findViewById(R.id.rdoMVomit1);
         rdoMVomit2 = (RadioButton) findViewById(R.id.rdoMVomit2);
         rdoMVomit3 = (RadioButton) findViewById(R.id.rdoMVomit3);
         secMDiarrhoea=(LinearLayout)findViewById(R.id.secMDiarrhoea);
         lineMDiarrhoea=(View)findViewById(R.id.lineMDiarrhoea);
         VlblMDiarrhoea = (TextView) findViewById(R.id.VlblMDiarrhoea);
         rdogrpMDiarrhoea = (RadioGroup) findViewById(R.id.rdogrpMDiarrhoea);
         
         rdoMDiarrhoea1 = (RadioButton) findViewById(R.id.rdoMDiarrhoea1);
         rdoMDiarrhoea2 = (RadioButton) findViewById(R.id.rdoMDiarrhoea2);
         rdoMDiarrhoea3 = (RadioButton) findViewById(R.id.rdoMDiarrhoea3);
         secMHCar=(LinearLayout)findViewById(R.id.secMHCar);
         lineMHCar=(View)findViewById(R.id.lineMHCar);
         VlblMHCar = (TextView) findViewById(R.id.VlblMHCar);
         rdogrpMHCar = (RadioGroup) findViewById(R.id.rdogrpMHCar);
         
         rdoMHCar1 = (RadioButton) findViewById(R.id.rdoMHCar1);
         rdoMHCar2 = (RadioButton) findViewById(R.id.rdoMHCar2);
         rdoMHCar3 = (RadioButton) findViewById(R.id.rdoMHCar3);
         rdogrpMHCar.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpMHCar = new String[] {"1","2","8"};
             for (int i = 0; i < rdogrpMHCar.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpMHCar.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpMHCar[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secMHCarTypLabel.setVisibility(View.GONE);
                    lineMHCarTypLabel.setVisibility(View.GONE);
                    secMHC_Phy.setVisibility(View.GONE);
                    lineMHC_Phy.setVisibility(View.GONE);
                    rdogrpMHC_Phy.clearCheck();
                    secMHC_UnquaDoctor.setVisibility(View.GONE);
                    lineMHC_UnquaDoctor.setVisibility(View.GONE);
                    rdogrpMHC_UnquaDoctor.clearCheck();
                    secMHC_Para.setVisibility(View.GONE);
                    lineMHC_Para.setVisibility(View.GONE);
                    rdogrpMHC_Para.clearCheck();
                    secMHC_Com.setVisibility(View.GONE);
                    lineMHC_Com.setVisibility(View.GONE);
                    rdogrpMHC_Com.clearCheck();
                    secMHC_Pha.setVisibility(View.GONE);
                    lineMHC_Pha.setVisibility(View.GONE);
                    rdogrpMHC_Pha.clearCheck();
                    secMHC_Hompath.setVisibility(View.GONE);
                    lineMHC_Hompath.setVisibility(View.GONE);
                    rdogrpMHC_Hompath.clearCheck();
                    secMHC_TrHeal.setVisibility(View.GONE);
                    lineMHC_TrHeal.setVisibility(View.GONE);
                    rdogrpMHC_TrHeal.clearCheck();
                    secMHC_SpiHeal.setVisibility(View.GONE);
                    lineMHC_SpiHeal.setVisibility(View.GONE);
                    rdogrpMHC_SpiHeal.clearCheck();
                    secMHC_Oth.setVisibility(View.GONE);
                    lineMHC_Oth.setVisibility(View.GONE);
                    rdogrpMHC_Oth.clearCheck();
                    secMHC_OthName.setVisibility(View.GONE);
                    lineMHC_OthName.setVisibility(View.GONE);
                    txtMHC_OthName.setText("");
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secMHCarTypLabel.setVisibility(View.GONE);
                    lineMHCarTypLabel.setVisibility(View.GONE);
                    secMHC_Phy.setVisibility(View.GONE);
                    lineMHC_Phy.setVisibility(View.GONE);
                    rdogrpMHC_Phy.clearCheck();
                    secMHC_UnquaDoctor.setVisibility(View.GONE);
                    lineMHC_UnquaDoctor.setVisibility(View.GONE);
                    rdogrpMHC_UnquaDoctor.clearCheck();
                    secMHC_Para.setVisibility(View.GONE);
                    lineMHC_Para.setVisibility(View.GONE);
                    rdogrpMHC_Para.clearCheck();
                    secMHC_Com.setVisibility(View.GONE);
                    lineMHC_Com.setVisibility(View.GONE);
                    rdogrpMHC_Com.clearCheck();
                    secMHC_Pha.setVisibility(View.GONE);
                    lineMHC_Pha.setVisibility(View.GONE);
                    rdogrpMHC_Pha.clearCheck();
                    secMHC_Hompath.setVisibility(View.GONE);
                    lineMHC_Hompath.setVisibility(View.GONE);
                    rdogrpMHC_Hompath.clearCheck();
                    secMHC_TrHeal.setVisibility(View.GONE);
                    lineMHC_TrHeal.setVisibility(View.GONE);
                    rdogrpMHC_TrHeal.clearCheck();
                    secMHC_SpiHeal.setVisibility(View.GONE);
                    lineMHC_SpiHeal.setVisibility(View.GONE);
                    rdogrpMHC_SpiHeal.clearCheck();
                    secMHC_Oth.setVisibility(View.GONE);
                    lineMHC_Oth.setVisibility(View.GONE);
                    rdogrpMHC_Oth.clearCheck();
                    secMHC_OthName.setVisibility(View.GONE);
                    lineMHC_OthName.setVisibility(View.GONE);
                    txtMHC_OthName.setText("");
             }
             else if(rbData.equalsIgnoreCase("1"))
             {
                    secMHCarTypLabel.setVisibility(View.VISIBLE);
                    lineMHCarTypLabel.setVisibility(View.VISIBLE);
                    secMHC_Phy.setVisibility(View.VISIBLE);
                    lineMHC_Phy.setVisibility(View.VISIBLE);
                    secMHC_UnquaDoctor.setVisibility(View.VISIBLE);
                    lineMHC_UnquaDoctor.setVisibility(View.VISIBLE);
                    secMHC_Para.setVisibility(View.VISIBLE);
                    lineMHC_Para.setVisibility(View.VISIBLE);
                    secMHC_Com.setVisibility(View.VISIBLE);
                    lineMHC_Com.setVisibility(View.VISIBLE);
                    secMHC_Pha.setVisibility(View.VISIBLE);
                    lineMHC_Pha.setVisibility(View.VISIBLE);
                    secMHC_Hompath.setVisibility(View.VISIBLE);
                    lineMHC_Hompath.setVisibility(View.VISIBLE);
                    secMHC_TrHeal.setVisibility(View.VISIBLE);
                    lineMHC_TrHeal.setVisibility(View.VISIBLE);
                    secMHC_SpiHeal.setVisibility(View.VISIBLE);
                    lineMHC_SpiHeal.setVisibility(View.VISIBLE);
//                    secMHC_Oth.setVisibility(View.VISIBLE);
//                    lineMHC_Oth.setVisibility(View.VISIBLE);
             }
             else{
                 secMHCarTypLabel.setVisibility(View.GONE);
                 lineMHCarTypLabel.setVisibility(View.GONE);
                 secMHC_Phy.setVisibility(View.GONE);
                 lineMHC_Phy.setVisibility(View.GONE);
                 rdogrpMHC_Phy.clearCheck();
                 secMHC_UnquaDoctor.setVisibility(View.GONE);
                 lineMHC_UnquaDoctor.setVisibility(View.GONE);
                 rdogrpMHC_UnquaDoctor.clearCheck();
                 secMHC_Para.setVisibility(View.GONE);
                 lineMHC_Para.setVisibility(View.GONE);
                 rdogrpMHC_Para.clearCheck();
                 secMHC_Com.setVisibility(View.GONE);
                 lineMHC_Com.setVisibility(View.GONE);
                 rdogrpMHC_Com.clearCheck();
                 secMHC_Pha.setVisibility(View.GONE);
                 lineMHC_Pha.setVisibility(View.GONE);
                 rdogrpMHC_Pha.clearCheck();
                 secMHC_Hompath.setVisibility(View.GONE);
                 lineMHC_Hompath.setVisibility(View.GONE);
                 rdogrpMHC_Hompath.clearCheck();
                 secMHC_TrHeal.setVisibility(View.GONE);
                 lineMHC_TrHeal.setVisibility(View.GONE);
                 rdogrpMHC_TrHeal.clearCheck();
                 secMHC_SpiHeal.setVisibility(View.GONE);
                 lineMHC_SpiHeal.setVisibility(View.GONE);
                 rdogrpMHC_SpiHeal.clearCheck();
                 secMHC_Oth.setVisibility(View.GONE);
                 lineMHC_Oth.setVisibility(View.GONE);
                 rdogrpMHC_Oth.clearCheck();
                 secMHC_OthName.setVisibility(View.GONE);
                 lineMHC_OthName.setVisibility(View.GONE);
                 txtMHC_OthName.setText("");
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secMHCarTypLabel=(LinearLayout)findViewById(R.id.secMHCarTypLabel);
         lineMHCarTypLabel=(View)findViewById(R.id.lineMHCarTypLabel);
         secMHC_Phy=(LinearLayout)findViewById(R.id.secMHC_Phy);
         lineMHC_Phy=(View)findViewById(R.id.lineMHC_Phy);
         VlblMHC_Phy = (TextView) findViewById(R.id.VlblMHC_Phy);
         rdogrpMHC_Phy = (RadioGroup) findViewById(R.id.rdogrpMHC_Phy);
         
         rdoMHC_Phy1 = (RadioButton) findViewById(R.id.rdoMHC_Phy1);
         rdoMHC_Phy2 = (RadioButton) findViewById(R.id.rdoMHC_Phy2);
         rdoMHC_Phy3 = (RadioButton) findViewById(R.id.rdoMHC_Phy3);
         secMHC_UnquaDoctor=(LinearLayout)findViewById(R.id.secMHC_UnquaDoctor);
         lineMHC_UnquaDoctor=(View)findViewById(R.id.lineMHC_UnquaDoctor);
         VlblMHC_UnquaDoctor = (TextView) findViewById(R.id.VlblMHC_UnquaDoctor);
         rdogrpMHC_UnquaDoctor = (RadioGroup) findViewById(R.id.rdogrpMHC_UnquaDoctor);
         
         rdoMHC_UnquaDoctor1 = (RadioButton) findViewById(R.id.rdoMHC_UnquaDoctor1);
         rdoMHC_UnquaDoctor2 = (RadioButton) findViewById(R.id.rdoMHC_UnquaDoctor2);
         rdoMHC_UnquaDoctor3 = (RadioButton) findViewById(R.id.rdoMHC_UnquaDoctor3);
         secMHC_Para=(LinearLayout)findViewById(R.id.secMHC_Para);
         lineMHC_Para=(View)findViewById(R.id.lineMHC_Para);
         VlblMHC_Para = (TextView) findViewById(R.id.VlblMHC_Para);
         rdogrpMHC_Para = (RadioGroup) findViewById(R.id.rdogrpMHC_Para);
         
         rdoMHC_Para1 = (RadioButton) findViewById(R.id.rdoMHC_Para1);
         rdoMHC_Para2 = (RadioButton) findViewById(R.id.rdoMHC_Para2);
         rdoMHC_Para3 = (RadioButton) findViewById(R.id.rdoMHC_Para3);
         secMHC_Com=(LinearLayout)findViewById(R.id.secMHC_Com);
         lineMHC_Com=(View)findViewById(R.id.lineMHC_Com);
         VlblMHC_Com = (TextView) findViewById(R.id.VlblMHC_Com);
         rdogrpMHC_Com = (RadioGroup) findViewById(R.id.rdogrpMHC_Com);
         
         rdoMHC_Com1 = (RadioButton) findViewById(R.id.rdoMHC_Com1);
         rdoMHC_Com2 = (RadioButton) findViewById(R.id.rdoMHC_Com2);
         rdoMHC_Com3 = (RadioButton) findViewById(R.id.rdoMHC_Com3);
         secMHC_Pha=(LinearLayout)findViewById(R.id.secMHC_Pha);
         lineMHC_Pha=(View)findViewById(R.id.lineMHC_Pha);
         VlblMHC_Pha = (TextView) findViewById(R.id.VlblMHC_Pha);
         rdogrpMHC_Pha = (RadioGroup) findViewById(R.id.rdogrpMHC_Pha);
         
         rdoMHC_Pha1 = (RadioButton) findViewById(R.id.rdoMHC_Pha1);
         rdoMHC_Pha2 = (RadioButton) findViewById(R.id.rdoMHC_Pha2);
         rdoMHC_Pha3 = (RadioButton) findViewById(R.id.rdoMHC_Pha3);
         secMHC_Hompath=(LinearLayout)findViewById(R.id.secMHC_Hompath);
         lineMHC_Hompath=(View)findViewById(R.id.lineMHC_Hompath);
         VlblMHC_Hompath = (TextView) findViewById(R.id.VlblMHC_Hompath);
         rdogrpMHC_Hompath = (RadioGroup) findViewById(R.id.rdogrpMHC_Hompath);
         
         rdoMHC_Hompath1 = (RadioButton) findViewById(R.id.rdoMHC_Hompath1);
         rdoMHC_Hompath2 = (RadioButton) findViewById(R.id.rdoMHC_Hompath2);
         rdoMHC_Hompath3 = (RadioButton) findViewById(R.id.rdoMHC_Hompath3);
         secMHC_TrHeal=(LinearLayout)findViewById(R.id.secMHC_TrHeal);
         lineMHC_TrHeal=(View)findViewById(R.id.lineMHC_TrHeal);
         VlblMHC_TrHeal = (TextView) findViewById(R.id.VlblMHC_TrHeal);
         rdogrpMHC_TrHeal = (RadioGroup) findViewById(R.id.rdogrpMHC_TrHeal);
         
         rdoMHC_TrHeal1 = (RadioButton) findViewById(R.id.rdoMHC_TrHeal1);
         rdoMHC_TrHeal2 = (RadioButton) findViewById(R.id.rdoMHC_TrHeal2);
         rdoMHC_TrHeal3 = (RadioButton) findViewById(R.id.rdoMHC_TrHeal3);
         secMHC_SpiHeal=(LinearLayout)findViewById(R.id.secMHC_SpiHeal);
         lineMHC_SpiHeal=(View)findViewById(R.id.lineMHC_SpiHeal);
         VlblMHC_SpiHeal = (TextView) findViewById(R.id.VlblMHC_SpiHeal);
         rdogrpMHC_SpiHeal = (RadioGroup) findViewById(R.id.rdogrpMHC_SpiHeal);
         
         rdoMHC_SpiHeal1 = (RadioButton) findViewById(R.id.rdoMHC_SpiHeal1);
         rdoMHC_SpiHeal2 = (RadioButton) findViewById(R.id.rdoMHC_SpiHeal2);
         rdoMHC_SpiHeal3 = (RadioButton) findViewById(R.id.rdoMHC_SpiHeal3);
         secMHC_Oth=(LinearLayout)findViewById(R.id.secMHC_Oth);
         lineMHC_Oth=(View)findViewById(R.id.lineMHC_Oth);
         VlblMHC_Oth = (TextView) findViewById(R.id.VlblMHC_Oth);
         rdogrpMHC_Oth = (RadioGroup) findViewById(R.id.rdogrpMHC_Oth);


         rdogrpMHC_Phy.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
             @Override
             public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
                 String rbData = "";
                 RadioButton rb;
                 String[] d_rdogrpMHC_Phy = new String[]{"1", "2", "8"};
                 for (int i = 0; i < rdogrpMHC_Phy.getChildCount(); i++) {
                     rb = (RadioButton) rdogrpMHC_Phy.getChildAt(i);
                     if (rb.isChecked()) rbData = d_rdogrpMHC_Phy[i];
                 }
                 if (rbData.equalsIgnoreCase("1")) {
                     secMHosNamLabel.setVisibility(View.GONE);
                     lineMHosNamLabel.setVisibility(View.GONE);
                     secMHC_Hosp_a1.setVisibility(View.GONE);
                     lineMHC_Hosp_a1.setVisibility(View.GONE);
                     spnMHC_Hosp_a1.setSelection(0);
                     secMHC_Hosp_a1_Oth.setVisibility(View.GONE);
                     lineMHC_Hosp_a1_Oth.setVisibility(View.GONE);
                     txtMHC_Hosp_a1_Oth.setText("");
                     secMHC_Hosp_a2.setVisibility(View.GONE);
                     lineMHC_Hosp_a2.setVisibility(View.GONE);
                     spnMHC_Hosp_a2.setSelection(0);
                     secMHC_Hosp_a2_Oth.setVisibility(View.GONE);
                     lineMHC_Hosp_a2_Oth.setVisibility(View.GONE);
                     txtMHC_Hosp_a2_Oth.setText("");
                     secMHC_Hosp_a3.setVisibility(View.GONE);
                     lineMHC_Hosp_a3.setVisibility(View.GONE);
                     spnMHC_Hosp_a3.setSelection(0);
                     secMHC_Hosp_a3_Oth.setVisibility(View.GONE);
                     lineMHC_Hosp_a3_Oth.setVisibility(View.GONE);
                     txtMHC_Hosp_a3_Oth.setText("");
                     secMDtHos.setVisibility(View.GONE);
                     lineMDtHos.setVisibility(View.GONE);
                     dtpMDtHos.setText("");
                     secMHosM.setVisibility(View.GONE);
                     lineMHosM.setVisibility(View.GONE);
                     txtMHosM.setText("");
                     secMDurIlBeHos.setVisibility(View.GONE);
                     lineMDurIlBeHos.setVisibility(View.GONE);
                     txtMDurIlBeHos.setText("");

                 } else if (rbData.equalsIgnoreCase("2")) {
                     secMHosNamLabel.setVisibility(View.GONE);
                     lineMHosNamLabel.setVisibility(View.GONE);
                     secMHC_Hosp_a1.setVisibility(View.GONE);
                     lineMHC_Hosp_a1.setVisibility(View.GONE);
                     spnMHC_Hosp_a1.setSelection(0);
                     secMHC_Hosp_a1_Oth.setVisibility(View.GONE);
                     lineMHC_Hosp_a1_Oth.setVisibility(View.GONE);
                     txtMHC_Hosp_a1_Oth.setText("");
                     secMHC_Hosp_a2.setVisibility(View.GONE);
                     lineMHC_Hosp_a2.setVisibility(View.GONE);
                     spnMHC_Hosp_a2.setSelection(0);
                     secMHC_Hosp_a2_Oth.setVisibility(View.GONE);
                     lineMHC_Hosp_a2_Oth.setVisibility(View.GONE);
                     txtMHC_Hosp_a2_Oth.setText("");
                     secMHC_Hosp_a3.setVisibility(View.GONE);
                     lineMHC_Hosp_a3.setVisibility(View.GONE);
                     spnMHC_Hosp_a3.setSelection(0);
                     secMHC_Hosp_a3_Oth.setVisibility(View.GONE);
                     lineMHC_Hosp_a3_Oth.setVisibility(View.GONE);
                     txtMHC_Hosp_a3_Oth.setText("");
                     secMDtHos.setVisibility(View.GONE);
                     lineMDtHos.setVisibility(View.GONE);
                     dtpMDtHos.setText("");
                     secMHosM.setVisibility(View.GONE);
                     lineMHosM.setVisibility(View.GONE);
                     txtMHosM.setText("");
                     secMDurIlBeHos.setVisibility(View.GONE);
                     lineMDurIlBeHos.setVisibility(View.GONE);
                     txtMDurIlBeHos.setText("");
                     secMChildIlDr.setVisibility(View.GONE);
                     lineMChildIlDr.setVisibility(View.GONE);
                     secMChildIlDrOth.setVisibility(View.GONE);
                     lineMChildIlDrOth.setVisibility(View.GONE);

                 } else if (rbData.equalsIgnoreCase("8")) {
                     secMHosNamLabel.setVisibility(View.GONE);
                     lineMHosNamLabel.setVisibility(View.GONE);
                     secMHC_Hosp_a1.setVisibility(View.GONE);
                     lineMHC_Hosp_a1.setVisibility(View.GONE);
                     spnMHC_Hosp_a1.setSelection(0);
                     secMHC_Hosp_a1_Oth.setVisibility(View.GONE);
                     lineMHC_Hosp_a1_Oth.setVisibility(View.GONE);
                     txtMHC_Hosp_a1_Oth.setText("");
                     secMHC_Hosp_a2.setVisibility(View.GONE);
                     lineMHC_Hosp_a2.setVisibility(View.GONE);
                     spnMHC_Hosp_a2.setSelection(0);
                     secMHC_Hosp_a2_Oth.setVisibility(View.GONE);
                     lineMHC_Hosp_a2_Oth.setVisibility(View.GONE);
                     txtMHC_Hosp_a2_Oth.setText("");
                     secMHC_Hosp_a3.setVisibility(View.GONE);
                     lineMHC_Hosp_a3.setVisibility(View.GONE);
                     spnMHC_Hosp_a3.setSelection(0);
                     secMHC_Hosp_a3_Oth.setVisibility(View.GONE);
                     lineMHC_Hosp_a3_Oth.setVisibility(View.GONE);
                     txtMHC_Hosp_a3_Oth.setText("");
                     secMDtHos.setVisibility(View.GONE);
                     lineMDtHos.setVisibility(View.GONE);
                     dtpMDtHos.setText("");
                     secMHosM.setVisibility(View.GONE);
                     lineMHosM.setVisibility(View.GONE);
                     txtMHosM.setText("");
                     secMDurIlBeHos.setVisibility(View.GONE);
                     lineMDurIlBeHos.setVisibility(View.GONE);
                     txtMDurIlBeHos.setText("");
                     secMChildIlDr.setVisibility(View.GONE);
                     lineMChildIlDr.setVisibility(View.GONE);
                     secMChildIlDrOth.setVisibility(View.GONE);
                     lineMChildIlDrOth.setVisibility(View.GONE);


                 } else {
                     secMHosNamLabel.setVisibility(View.VISIBLE);
                     lineMHosNamLabel.setVisibility(View.VISIBLE);
                     secMHC_Hosp_a1.setVisibility(View.VISIBLE);
                     lineMHC_Hosp_a1.setVisibility(View.VISIBLE);
                     spnMHC_Hosp_a1.setSelection(0);
//                     secMHC_Hosp_a1_Oth.setVisibility(View.VISIBLE);
//                     lineMHC_Hosp_a1_Oth.setVisibility(View.VISIBLE);
//                     txtMHC_Hosp_a1_Oth.setText("");
                     secMHC_Hosp_a2.setVisibility(View.VISIBLE);
                     lineMHC_Hosp_a2.setVisibility(View.VISIBLE);
                     spnMHC_Hosp_a2.setSelection(0);
//                     secMHC_Hosp_a2_Oth.setVisibility(View.VISIBLE);
//                     lineMHC_Hosp_a2_Oth.setVisibility(View.VISIBLE);
//                     txtMHC_Hosp_a2_Oth.setText("");
                     secMHC_Hosp_a3.setVisibility(View.VISIBLE);
                     lineMHC_Hosp_a3.setVisibility(View.VISIBLE);
                     spnMHC_Hosp_a3.setSelection(0);
//                     secMHC_Hosp_a3_Oth.setVisibility(View.VISIBLE);
//                     lineMHC_Hosp_a3_Oth.setVisibility(View.VISIBLE);
//                     txtMHC_Hosp_a3_Oth.setText("");
                     secMDtHos.setVisibility(View.VISIBLE);
                     lineMDtHos.setVisibility(View.VISIBLE);
//                     dtpMDtHos.setText("");
                     secMHosM.setVisibility(View.VISIBLE);
                     lineMHosM.setVisibility(View.VISIBLE);
                     txtMHosM.setText("");
                     secMDurIlBeHos.setVisibility(View.VISIBLE);
                     lineMDurIlBeHos.setVisibility(View.VISIBLE);
                     txtMDurIlBeHos.setText("");
                     secMChildIlDr.setVisibility(View.VISIBLE);
                     lineMChildIlDr.setVisibility(View.VISIBLE);
//                     secMChildIlDrOth.setVisibility(View.VISIBLE);
//                     lineMChildIlDrOth.setVisibility(View.VISIBLE);


                 }
             }
             public void onNothingSelected(AdapterView<?> adapterView) {
                 return;
             }
         });




         rdoMHC_Oth1 = (RadioButton) findViewById(R.id.rdoMHC_Oth1);
         rdoMHC_Oth2 = (RadioButton) findViewById(R.id.rdoMHC_Oth2);
         rdoMHC_Oth3 = (RadioButton) findViewById(R.id.rdoMHC_Oth3);
         rdogrpMHC_Oth.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpMHC_Oth = new String[] {"1","2","8"};
             for (int i = 0; i < rdogrpMHC_Oth.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpMHC_Oth.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpMHC_Oth[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secMHC_OthName.setVisibility(View.GONE);
                    lineMHC_OthName.setVisibility(View.GONE);
                    txtMHC_OthName.setText("");
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secMHC_OthName.setVisibility(View.GONE);
                    lineMHC_OthName.setVisibility(View.GONE);
                    txtMHC_OthName.setText("");
             }
             else
             {
                    secMHC_OthName.setVisibility(View.VISIBLE);
                    lineMHC_OthName.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secMHC_OthName=(LinearLayout)findViewById(R.id.secMHC_OthName);
         lineMHC_OthName=(View)findViewById(R.id.lineMHC_OthName);
         VlblMHC_OthName=(TextView) findViewById(R.id.VlblMHC_OthName);
         txtMHC_OthName=(EditText) findViewById(R.id.txtMHC_OthName);
         secMDSHOPD=(LinearLayout)findViewById(R.id.secMDSHOPD);
         lineMDSHOPD=(View)findViewById(R.id.lineMDSHOPD);
         VlblMDSHOPD = (TextView) findViewById(R.id.VlblMDSHOPD);
         rdogrpMDSHOPD = (RadioGroup) findViewById(R.id.rdogrpMDSHOPD);
         
         rdoMDSHOPD1 = (RadioButton) findViewById(R.id.rdoMDSHOPD1);
         rdoMDSHOPD2 = (RadioButton) findViewById(R.id.rdoMDSHOPD2);
         rdoMDSHOPD3 = (RadioButton) findViewById(R.id.rdoMDSHOPD3);
         secMSSFOPD=(LinearLayout)findViewById(R.id.secMSSFOPD);
         lineMSSFOPD=(View)findViewById(R.id.lineMSSFOPD);
         VlblMSSFOPD = (TextView) findViewById(R.id.VlblMSSFOPD);
         rdogrpMSSFOPD = (RadioGroup) findViewById(R.id.rdogrpMSSFOPD);
         
         rdoMSSFOPD1 = (RadioButton) findViewById(R.id.rdoMSSFOPD1);
         rdoMSSFOPD2 = (RadioButton) findViewById(R.id.rdoMSSFOPD2);
         rdoMSSFOPD3 = (RadioButton) findViewById(R.id.rdoMSSFOPD3);
         secMHosAdm=(LinearLayout)findViewById(R.id.secMHosAdm);
         lineMHosAdm=(View)findViewById(R.id.lineMHosAdm);
         VlblMHosAdm = (TextView) findViewById(R.id.VlblMHosAdm);
         rdogrpMHosAdm = (RadioGroup) findViewById(R.id.rdogrpMHosAdm);
         
         rdoMHosAdm1 = (RadioButton) findViewById(R.id.rdoMHosAdm1);
         rdoMHosAdm2 = (RadioButton) findViewById(R.id.rdoMHosAdm2);
         rdoMHosAdm3 = (RadioButton) findViewById(R.id.rdoMHosAdm3);
         rdogrpMHosAdm.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpMHosAdm = new String[] {"1","2","8"};
             for (int i = 0; i < rdogrpMHosAdm.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpMHosAdm.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpMHosAdm[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                 if(rdoMHC_Phy1.isChecked()){
                     secMHosNamLabel.setVisibility(View.GONE);
                     lineMHosNamLabel.setVisibility(View.GONE);
                     secMHC_Hosp_a1.setVisibility(View.GONE);
                     lineMHC_Hosp_a1.setVisibility(View.GONE);
                     spnMHC_Hosp_a1.setSelection(0);
                     secMHC_Hosp_a1_Oth.setVisibility(View.GONE);
                     lineMHC_Hosp_a1_Oth.setVisibility(View.GONE);
                     txtMHC_Hosp_a1_Oth.setText("");
                     secMHC_Hosp_a2.setVisibility(View.GONE);
                     lineMHC_Hosp_a2.setVisibility(View.GONE);
                     spnMHC_Hosp_a2.setSelection(0);
                     secMHC_Hosp_a2_Oth.setVisibility(View.GONE);
                     lineMHC_Hosp_a2_Oth.setVisibility(View.GONE);
                     txtMHC_Hosp_a2_Oth.setText("");
                     secMHC_Hosp_a3.setVisibility(View.GONE);
                     lineMHC_Hosp_a3.setVisibility(View.GONE);
                     spnMHC_Hosp_a3.setSelection(0);
                     secMHC_Hosp_a3_Oth.setVisibility(View.GONE);
                     lineMHC_Hosp_a3_Oth.setVisibility(View.GONE);
                     txtMHC_Hosp_a3_Oth.setText("");
                     secMDtHos.setVisibility(View.GONE);
                     lineMDtHos.setVisibility(View.GONE);
                     dtpMDtHos.setText("");
                     secMHosM.setVisibility(View.GONE);
                     lineMHosM.setVisibility(View.GONE);
                     txtMHosM.setText("");
                     secMDurIlBeHos.setVisibility(View.GONE);
                     lineMDurIlBeHos.setVisibility(View.GONE);
                     txtMDurIlBeHos.setText("");
                 }
                 else{
                     secMHosNamLabel.setVisibility(View.GONE);
                     lineMHosNamLabel.setVisibility(View.GONE);
                     secMHC_Hosp_a1.setVisibility(View.GONE);
                     lineMHC_Hosp_a1.setVisibility(View.GONE);
                     spnMHC_Hosp_a1.setSelection(0);
                     secMHC_Hosp_a1_Oth.setVisibility(View.GONE);
                     lineMHC_Hosp_a1_Oth.setVisibility(View.GONE);
                     txtMHC_Hosp_a1_Oth.setText("");
                     secMHC_Hosp_a2.setVisibility(View.GONE);
                     lineMHC_Hosp_a2.setVisibility(View.GONE);
                     spnMHC_Hosp_a2.setSelection(0);
                     secMHC_Hosp_a2_Oth.setVisibility(View.GONE);
                     lineMHC_Hosp_a2_Oth.setVisibility(View.GONE);
                     txtMHC_Hosp_a2_Oth.setText("");
                     secMHC_Hosp_a3.setVisibility(View.GONE);
                     lineMHC_Hosp_a3.setVisibility(View.GONE);
                     spnMHC_Hosp_a3.setSelection(0);
                     secMHC_Hosp_a3_Oth.setVisibility(View.GONE);
                     lineMHC_Hosp_a3_Oth.setVisibility(View.GONE);
                     txtMHC_Hosp_a3_Oth.setText("");
                     secMDtHos.setVisibility(View.GONE);
                     lineMDtHos.setVisibility(View.GONE);
                     dtpMDtHos.setText("");
                     secMHosM.setVisibility(View.GONE);
                     lineMHosM.setVisibility(View.GONE);
                     txtMHosM.setText("");
                     secMDurIlBeHos.setVisibility(View.GONE);
                     lineMDurIlBeHos.setVisibility(View.GONE);
                     txtMDurIlBeHos.setText("");
                     secMChildIlDr.setVisibility(View.GONE);
                     lineMChildIlDr.setVisibility(View.GONE);
                     secMChildIlDrOth.setVisibility(View.GONE);
                     lineMChildIlDrOth.setVisibility(View.GONE);
                 }

             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                 if(rdoMHC_Phy1.isChecked()){
                     secMHosNamLabel.setVisibility(View.GONE);
                     lineMHosNamLabel.setVisibility(View.GONE);
                     secMHC_Hosp_a1.setVisibility(View.GONE);
                     lineMHC_Hosp_a1.setVisibility(View.GONE);
                     spnMHC_Hosp_a1.setSelection(0);
                     secMHC_Hosp_a1_Oth.setVisibility(View.GONE);
                     lineMHC_Hosp_a1_Oth.setVisibility(View.GONE);
                     txtMHC_Hosp_a1_Oth.setText("");
                     secMHC_Hosp_a2.setVisibility(View.GONE);
                     lineMHC_Hosp_a2.setVisibility(View.GONE);
                     spnMHC_Hosp_a2.setSelection(0);
                     secMHC_Hosp_a2_Oth.setVisibility(View.GONE);
                     lineMHC_Hosp_a2_Oth.setVisibility(View.GONE);
                     txtMHC_Hosp_a2_Oth.setText("");
                     secMHC_Hosp_a3.setVisibility(View.GONE);
                     lineMHC_Hosp_a3.setVisibility(View.GONE);
                     spnMHC_Hosp_a3.setSelection(0);
                     secMHC_Hosp_a3_Oth.setVisibility(View.GONE);
                     lineMHC_Hosp_a3_Oth.setVisibility(View.GONE);
                     txtMHC_Hosp_a3_Oth.setText("");
                     secMDtHos.setVisibility(View.GONE);
                     lineMDtHos.setVisibility(View.GONE);
                     dtpMDtHos.setText("");
                     secMHosM.setVisibility(View.GONE);
                     lineMHosM.setVisibility(View.GONE);
                     txtMHosM.setText("");
                     secMDurIlBeHos.setVisibility(View.GONE);
                     lineMDurIlBeHos.setVisibility(View.GONE);
                     txtMDurIlBeHos.setText("");
                 }
                 else{
                     secMHosNamLabel.setVisibility(View.GONE);
                     lineMHosNamLabel.setVisibility(View.GONE);
                     secMHC_Hosp_a1.setVisibility(View.GONE);
                     lineMHC_Hosp_a1.setVisibility(View.GONE);
                     spnMHC_Hosp_a1.setSelection(0);
                     secMHC_Hosp_a1_Oth.setVisibility(View.GONE);
                     lineMHC_Hosp_a1_Oth.setVisibility(View.GONE);
                     txtMHC_Hosp_a1_Oth.setText("");
                     secMHC_Hosp_a2.setVisibility(View.GONE);
                     lineMHC_Hosp_a2.setVisibility(View.GONE);
                     spnMHC_Hosp_a2.setSelection(0);
                     secMHC_Hosp_a2_Oth.setVisibility(View.GONE);
                     lineMHC_Hosp_a2_Oth.setVisibility(View.GONE);
                     txtMHC_Hosp_a2_Oth.setText("");
                     secMHC_Hosp_a3.setVisibility(View.GONE);
                     lineMHC_Hosp_a3.setVisibility(View.GONE);
                     spnMHC_Hosp_a3.setSelection(0);
                     secMHC_Hosp_a3_Oth.setVisibility(View.GONE);
                     lineMHC_Hosp_a3_Oth.setVisibility(View.GONE);
                     txtMHC_Hosp_a3_Oth.setText("");
                     secMDtHos.setVisibility(View.GONE);
                     lineMDtHos.setVisibility(View.GONE);
                     dtpMDtHos.setText("");
                     secMHosM.setVisibility(View.GONE);
                     lineMHosM.setVisibility(View.GONE);
                     txtMHosM.setText("");
                     secMDurIlBeHos.setVisibility(View.GONE);
                     lineMDurIlBeHos.setVisibility(View.GONE);
                     txtMDurIlBeHos.setText("");
                     secMChildIlDr.setVisibility(View.GONE);
                     lineMChildIlDr.setVisibility(View.GONE);
                     secMChildIlDrOth.setVisibility(View.GONE);
                     lineMChildIlDrOth.setVisibility(View.GONE);
                 }
             }
             else if(rbData.equalsIgnoreCase("1"))
             {
                    secMHosNamLabel.setVisibility(View.VISIBLE);
                    lineMHosNamLabel.setVisibility(View.VISIBLE);
                    secMHC_Hosp_a1.setVisibility(View.VISIBLE);
                    lineMHC_Hosp_a1.setVisibility(View.VISIBLE);

                    secMHC_Hosp_a2.setVisibility(View.VISIBLE);
                    lineMHC_Hosp_a2.setVisibility(View.VISIBLE);

                    secMHC_Hosp_a3.setVisibility(View.VISIBLE);
                    lineMHC_Hosp_a3.setVisibility(View.VISIBLE);
                    secMDtHos.setVisibility(View.VISIBLE);
                    lineMDtHos.setVisibility(View.VISIBLE);
                    secMHosM.setVisibility(View.VISIBLE);
                    lineMHosM.setVisibility(View.VISIBLE);
                    secMDurIlBeHos.setVisibility(View.VISIBLE);
                    lineMDurIlBeHos.setVisibility(View.VISIBLE);
                 secMChildIlDr.setVisibility(View.VISIBLE);
                 lineMChildIlDr.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secMHosNamLabel=(LinearLayout)findViewById(R.id.secMHosNamLabel);
         lineMHosNamLabel=(View)findViewById(R.id.lineMHosNamLabel);
         secMHC_Hosp_a1=(LinearLayout)findViewById(R.id.secMHC_Hosp_a1);
         lineMHC_Hosp_a1=(View)findViewById(R.id.lineMHC_Hosp_a1);
         VlblMHC_Hosp_a1=(TextView) findViewById(R.id.VlblMHC_Hosp_a1);
         spnMHC_Hosp_a1=(Spinner) findViewById(R.id.spnMHC_Hosp_a1);
         List<String> listMHC_Hosp_a1 = new ArrayList<String>();
         
         listMHC_Hosp_a1.add("");
         listMHC_Hosp_a1.add("1-Dhaka Shishu Hospital");
         listMHC_Hosp_a1.add("2-Dr. M. R. Khan Hospital");
         listMHC_Hosp_a1.add("7-Other");
         listMHC_Hosp_a1.add("8-Don’t know");
         ArrayAdapter<String> adptrMHC_Hosp_a1= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listMHC_Hosp_a1);
         spnMHC_Hosp_a1.setAdapter(adptrMHC_Hosp_a1);

         spnMHC_Hosp_a1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnMHC_Hosp_a1.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnMHC_Hosp_a1.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("1"))
                 {
                    secMHC_Hosp_a1_Oth.setVisibility(View.GONE);
                    lineMHC_Hosp_a1_Oth.setVisibility(View.GONE);
                    txtMHC_Hosp_a1_Oth.setText("");
                     spnMHC_Hosp_a2.setEnabled(true);
                     spnMHC_Hosp_a3.setEnabled(true);
                 }
                 else if(spnData.equalsIgnoreCase("2"))
                 {
                    secMHC_Hosp_a1_Oth.setVisibility(View.GONE);
                    lineMHC_Hosp_a1_Oth.setVisibility(View.GONE);
                    txtMHC_Hosp_a1_Oth.setText("");
                     spnMHC_Hosp_a2.setEnabled(true);
                     spnMHC_Hosp_a3.setEnabled(true);
                 }
                 else if(spnData.equalsIgnoreCase("8"))
                 {
                    secMHC_Hosp_a1_Oth.setVisibility(View.GONE);
                    lineMHC_Hosp_a1_Oth.setVisibility(View.GONE);
                    txtMHC_Hosp_a1_Oth.setText("");
                     spnMHC_Hosp_a2.setEnabled(true);
                     spnMHC_Hosp_a3.setEnabled(true);
                 }
                 else if(spnData.equalsIgnoreCase("7"))
                 {
                    secMHC_Hosp_a1_Oth.setVisibility(View.VISIBLE);
                    lineMHC_Hosp_a1_Oth.setVisibility(View.VISIBLE);
                     spnMHC_Hosp_a2.setSelection(0);
                     spnMHC_Hosp_a3.setSelection(0);
                     spnMHC_Hosp_a2.setEnabled(false);
                     spnMHC_Hosp_a3.setEnabled(false);
                 }
                 else{
                     secMHC_Hosp_a1_Oth.setVisibility(View.GONE);
                     lineMHC_Hosp_a1_Oth.setVisibility(View.GONE);
                     spnMHC_Hosp_a2.setEnabled(true);
                     spnMHC_Hosp_a3.setEnabled(true);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secMHC_Hosp_a1_Oth=(LinearLayout)findViewById(R.id.secMHC_Hosp_a1_Oth);
         lineMHC_Hosp_a1_Oth=(View)findViewById(R.id.lineMHC_Hosp_a1_Oth);
         VlblMHC_Hosp_a1_Oth=(TextView) findViewById(R.id.VlblMHC_Hosp_a1_Oth);
         txtMHC_Hosp_a1_Oth=(EditText) findViewById(R.id.txtMHC_Hosp_a1_Oth);
         secMHC_Hosp_a2=(LinearLayout)findViewById(R.id.secMHC_Hosp_a2);
         lineMHC_Hosp_a2=(View)findViewById(R.id.lineMHC_Hosp_a2);
         VlblMHC_Hosp_a2=(TextView) findViewById(R.id.VlblMHC_Hosp_a2);
         spnMHC_Hosp_a2=(Spinner) findViewById(R.id.spnMHC_Hosp_a2);
         List<String> listMHC_Hosp_a2 = new ArrayList<String>();
         
         listMHC_Hosp_a2.add("");
         listMHC_Hosp_a2.add("1-Dhaka Shishu Hospital");
         listMHC_Hosp_a2.add("2-Dr. M. R. Khan Hospital");
         listMHC_Hosp_a2.add("7-Other");
         listMHC_Hosp_a2.add("8-Don’t know");
         ArrayAdapter<String> adptrMHC_Hosp_a2= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listMHC_Hosp_a2);
         spnMHC_Hosp_a2.setAdapter(adptrMHC_Hosp_a2);

         spnMHC_Hosp_a2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnMHC_Hosp_a2.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnMHC_Hosp_a2.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("1"))
                 {
                    secMHC_Hosp_a2_Oth.setVisibility(View.GONE);
                    lineMHC_Hosp_a2_Oth.setVisibility(View.GONE);
                    txtMHC_Hosp_a2_Oth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("2"))
                 {
                    secMHC_Hosp_a2_Oth.setVisibility(View.GONE);
                    lineMHC_Hosp_a2_Oth.setVisibility(View.GONE);
                     spnMHC_Hosp_a3.setEnabled(true);
                    txtMHC_Hosp_a2_Oth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("8"))
                 {
                    secMHC_Hosp_a2_Oth.setVisibility(View.GONE);
                    lineMHC_Hosp_a2_Oth.setVisibility(View.GONE);
                     spnMHC_Hosp_a3.setEnabled(true);
                    txtMHC_Hosp_a2_Oth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("7"))
                 {
                    secMHC_Hosp_a2_Oth.setVisibility(View.VISIBLE);
                    lineMHC_Hosp_a2_Oth.setVisibility(View.VISIBLE);
                     spnMHC_Hosp_a3.setSelection(0);
                     spnMHC_Hosp_a3.setEnabled(false);

                 }
                 else{
                     secMHC_Hosp_a2_Oth.setVisibility(View.GONE);
                     lineMHC_Hosp_a2_Oth.setVisibility(View.GONE);
                     spnMHC_Hosp_a3.setEnabled(true);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secMHC_Hosp_a2_Oth=(LinearLayout)findViewById(R.id.secMHC_Hosp_a2_Oth);
         lineMHC_Hosp_a2_Oth=(View)findViewById(R.id.lineMHC_Hosp_a2_Oth);
         VlblMHC_Hosp_a2_Oth=(TextView) findViewById(R.id.VlblMHC_Hosp_a2_Oth);
         txtMHC_Hosp_a2_Oth=(EditText) findViewById(R.id.txtMHC_Hosp_a2_Oth);
         secMHC_Hosp_a3=(LinearLayout)findViewById(R.id.secMHC_Hosp_a3);
         lineMHC_Hosp_a3=(View)findViewById(R.id.lineMHC_Hosp_a3);
         VlblMHC_Hosp_a3=(TextView) findViewById(R.id.VlblMHC_Hosp_a3);
         spnMHC_Hosp_a3=(Spinner) findViewById(R.id.spnMHC_Hosp_a3);
         List<String> listMHC_Hosp_a3 = new ArrayList<String>();
         
         listMHC_Hosp_a3.add("");
         listMHC_Hosp_a3.add("1-Dhaka Shishu Hospital");
         listMHC_Hosp_a3.add("2-Dr. M. R. Khan Hospital");
         listMHC_Hosp_a3.add("7-Other");
         listMHC_Hosp_a3.add("8-Don’t know");
         ArrayAdapter<String> adptrMHC_Hosp_a3= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listMHC_Hosp_a3);
         spnMHC_Hosp_a3.setAdapter(adptrMHC_Hosp_a3);

         spnMHC_Hosp_a3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnMHC_Hosp_a3.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnMHC_Hosp_a3.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("1"))
                 {
                    secMHC_Hosp_a3_Oth.setVisibility(View.GONE);
                    lineMHC_Hosp_a3_Oth.setVisibility(View.GONE);
                    txtMHC_Hosp_a3_Oth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("2"))
                 {
                    secMHC_Hosp_a3_Oth.setVisibility(View.GONE);
                    lineMHC_Hosp_a3_Oth.setVisibility(View.GONE);
                    txtMHC_Hosp_a3_Oth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("8"))
                 {
                    secMHC_Hosp_a3_Oth.setVisibility(View.GONE);
                    lineMHC_Hosp_a3_Oth.setVisibility(View.GONE);
                    txtMHC_Hosp_a3_Oth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("7"))
                 {
                    secMHC_Hosp_a3_Oth.setVisibility(View.VISIBLE);
                    lineMHC_Hosp_a3_Oth.setVisibility(View.VISIBLE);
                 }
                 else{
                     secMHC_Hosp_a3_Oth.setVisibility(View.GONE);
                     lineMHC_Hosp_a3_Oth.setVisibility(View.GONE);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secMHC_Hosp_a3_Oth=(LinearLayout)findViewById(R.id.secMHC_Hosp_a3_Oth);
         lineMHC_Hosp_a3_Oth=(View)findViewById(R.id.lineMHC_Hosp_a3_Oth);
         VlblMHC_Hosp_a3_Oth=(TextView) findViewById(R.id.VlblMHC_Hosp_a3_Oth);
         txtMHC_Hosp_a3_Oth=(EditText) findViewById(R.id.txtMHC_Hosp_a3_Oth);
         secMDtHos=(LinearLayout)findViewById(R.id.secMDtHos);
         lineMDtHos=(View)findViewById(R.id.lineMDtHos);
         VlblMDtHos=(TextView) findViewById(R.id.VlblMDtHos);
         dtpMDtHos=(EditText) findViewById(R.id.dtpMDtHos);
         secMHosM=(LinearLayout)findViewById(R.id.secMHosM);
         lineMHosM=(View)findViewById(R.id.lineMHosM);
         VlblMHosM=(TextView) findViewById(R.id.VlblMHosM);
         txtMHosM=(EditText) findViewById(R.id.txtMHosM);
         secMDurIlBeHos=(LinearLayout)findViewById(R.id.secMDurIlBeHos);
         lineMDurIlBeHos=(View)findViewById(R.id.lineMDurIlBeHos);
         VlblMDurIlBeHos=(TextView) findViewById(R.id.VlblMDurIlBeHos);
         txtMDurIlBeHos=(EditText) findViewById(R.id.txtMDurIlBeHos);
         secMChildIlDr=(LinearLayout)findViewById(R.id.secMChildIlDr);
         lineMChildIlDr=(View)findViewById(R.id.lineMChildIlDr);
         VlblMChildIlDr=(TextView) findViewById(R.id.VlblMChildIlDr);
         spnMChildIlDr=(Spinner) findViewById(R.id.spnMChildIlDr);
         List<String> listMChildIlDr = new ArrayList<String>();
         
         listMChildIlDr.add("");
         listMChildIlDr.add("1-নিউমোনিয়া (Pneumonia)  ");
         listMChildIlDr.add("2-টাইফয়েড (Typhoid fever)   ");
         listMChildIlDr.add("3-মেনিনজাইটিস বা মস্তিস্কে সংক্রমণ (Meningitis)  ");
         listMChildIlDr.add("4-ম্রিগি রোগ (Epilepsy) ");
         listMChildIlDr.add("5-জ্বরসহ খিঁচুনি (Febrile convulsion) ");
         listMChildIlDr.add("6-মস্তিস্কে প্রদাহ (Encephalitis)    ");
         listMChildIlDr.add("7-অন্যান্য (Other)  ");
         listMChildIlDr.add("8-জানি না (Don’t know) ");
         listMChildIlDr.add("9-প্রযোজ্য নয় (NA)");
         ArrayAdapter<String> adptrMChildIlDr= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listMChildIlDr);
         spnMChildIlDr.setAdapter(adptrMChildIlDr);

         spnMChildIlDr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnMChildIlDr.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnMChildIlDr.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("1"))
                 {
                    secMChildIlDrOth.setVisibility(View.GONE);
                    lineMChildIlDrOth.setVisibility(View.GONE);
                    txtMChildIlDrOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("2"))
                 {
                    secMChildIlDrOth.setVisibility(View.GONE);
                    lineMChildIlDrOth.setVisibility(View.GONE);
                    txtMChildIlDrOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("3"))
                 {
                    secMChildIlDrOth.setVisibility(View.GONE);
                    lineMChildIlDrOth.setVisibility(View.GONE);
                    txtMChildIlDrOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("4"))
                 {
                    secMChildIlDrOth.setVisibility(View.GONE);
                    lineMChildIlDrOth.setVisibility(View.GONE);
                    txtMChildIlDrOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("5"))
                 {
                    secMChildIlDrOth.setVisibility(View.GONE);
                    lineMChildIlDrOth.setVisibility(View.GONE);
                    txtMChildIlDrOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("6"))
                 {
                    secMChildIlDrOth.setVisibility(View.GONE);
                    lineMChildIlDrOth.setVisibility(View.GONE);
                    txtMChildIlDrOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("8"))
                 {
                    secMChildIlDrOth.setVisibility(View.GONE);
                    lineMChildIlDrOth.setVisibility(View.GONE);
                    txtMChildIlDrOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("9"))
                 {
                    secMChildIlDrOth.setVisibility(View.GONE);
                    lineMChildIlDrOth.setVisibility(View.GONE);
                    txtMChildIlDrOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("7"))
                 {
                    secMChildIlDrOth.setVisibility(View.VISIBLE);
                    lineMChildIlDrOth.setVisibility(View.VISIBLE);
                 }
                 else{
                     secMChildIlDrOth.setVisibility(View.GONE);
                     lineMChildIlDrOth.setVisibility(View.GONE);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secMChildIlDrOth=(LinearLayout)findViewById(R.id.secMChildIlDrOth);
         lineMChildIlDrOth=(View)findViewById(R.id.lineMChildIlDrOth);
         VlblMChildIlDrOth=(TextView) findViewById(R.id.VlblMChildIlDrOth);
         txtMChildIlDrOth=(EditText) findViewById(R.id.txtMChildIlDrOth);
         secMReco=(LinearLayout)findViewById(R.id.secMReco);
         lineMReco=(View)findViewById(R.id.lineMReco);
         VlblMReco = (TextView) findViewById(R.id.VlblMReco);
         rdogrpMReco = (RadioGroup) findViewById(R.id.rdogrpMReco);
         
         rdoMReco1 = (RadioButton) findViewById(R.id.rdoMReco1);
         rdoMReco2 = (RadioButton) findViewById(R.id.rdoMReco2);
         rdoMReco3 = (RadioButton) findViewById(R.id.rdoMReco3);
         rdogrpMReco.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpMReco = new String[] {"1","2","8"};
             for (int i = 0; i < rdogrpMReco.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpMReco.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpMReco[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secMDurReco.setVisibility(View.GONE);
                    lineMDurReco.setVisibility(View.GONE);
                    txtMDurReco.setText("");
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secMDurReco.setVisibility(View.GONE);
                    lineMDurReco.setVisibility(View.GONE);
                    txtMDurReco.setText("");
             }
             else if(rbData.equalsIgnoreCase("1"))
             {
                    secMDurReco.setVisibility(View.VISIBLE);
                    lineMDurReco.setVisibility(View.VISIBLE);
             }
             else{
                 secMDurReco.setVisibility(View.GONE);
                 lineMDurReco.setVisibility(View.GONE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secMDurReco=(LinearLayout)findViewById(R.id.secMDurReco);
         lineMDurReco=(View)findViewById(R.id.lineMDurReco);
         VlblMDurReco=(TextView) findViewById(R.id.VlblMDurReco);
         txtMDurReco=(EditText) findViewById(R.id.txtMDurReco);
         secMInRecoLabel=(LinearLayout)findViewById(R.id.secMInRecoLabel);
         lineMInRecoLabel=(View)findViewById(R.id.lineMInRecoLabel);
         secMInReco=(LinearLayout)findViewById(R.id.secMInReco);
         lineMInReco=(View)findViewById(R.id.lineMInReco);
         VlblMInReco=(TextView) findViewById(R.id.VlblMInReco);
         spnMInReco=(Spinner) findViewById(R.id.spnMInReco);
         List<String> listMInReco = new ArrayList<String>();
         
         listMInReco.add("");
         listMInReco.add("1-কথা বলতে সমস্যা (Problems with speech)");
         listMInReco.add("2-শ্রবণশক্তি হারানো (Hearing loss) ");
         listMInReco.add("3-কোন কিছু নিয়ে চিন্তা করতে সমস্যা (Problems with thinking)");
         listMInReco.add("4-বারবার খিঁচুনি (Recurrent seizures) ");
         listMInReco.add("5-আচরনের পরিবর্তন (Personality change)");
         listMInReco.add("7-অন্যান্য (Other)");
         ArrayAdapter<String> adptrMInReco= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listMInReco);
         spnMInReco.setAdapter(adptrMInReco);

         spnMInReco.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnMInReco.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnMInReco.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("1"))
                 {
                    secMInRecoOth.setVisibility(View.GONE);
                    lineMInRecoOth.setVisibility(View.GONE);
                    txtMInRecoOth.setText("");
                     spnMInReco3.setEnabled(true);
                     spnMInReco2.setEnabled(true);
                 }
                 else if(spnData.equalsIgnoreCase("2"))
                 {
                    secMInRecoOth.setVisibility(View.GONE);
                    lineMInRecoOth.setVisibility(View.GONE);
                    spnMInReco3.setEnabled(true);
                     spnMInReco2.setEnabled(true);

                    txtMInRecoOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("3"))
                 {
                    secMInRecoOth.setVisibility(View.GONE);
                    lineMInRecoOth.setVisibility(View.GONE);
                     spnMInReco3.setEnabled(true);
                     spnMInReco2.setEnabled(true);
                    txtMInRecoOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("4"))
                 {
                    secMInRecoOth.setVisibility(View.GONE);
                    lineMInRecoOth.setVisibility(View.GONE);
                    spnMInReco3.setEnabled(true);
                     spnMInReco2.setEnabled(true);

                    txtMInRecoOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("5"))
                 {
                    secMInRecoOth.setVisibility(View.GONE);
                    lineMInRecoOth.setVisibility(View.GONE);
                     spnMInReco3.setEnabled(true);
                     spnMInReco2.setEnabled(true);
                    txtMInRecoOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("7"))
                 {
                    secMInRecoOth.setVisibility(View.VISIBLE);
                    lineMInRecoOth.setVisibility(View.VISIBLE);
                    spnMInReco2.setSelection(0);
                    spnMInReco3.setSelection(0);
                    spnMInReco3.setEnabled(false);
                    spnMInReco2.setEnabled(false);
                 }
                 else{
                     secMInRecoOth.setVisibility(View.GONE);
                     lineMInRecoOth.setVisibility(View.GONE);
                     spnMInReco3.setEnabled(true);
                     spnMInReco2.setEnabled(true);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secMInRecoOth=(LinearLayout)findViewById(R.id.secMInRecoOth);
         lineMInRecoOth=(View)findViewById(R.id.lineMInRecoOth);
         VlblMInRecoOth=(TextView) findViewById(R.id.VlblMInRecoOth);
         txtMInRecoOth=(EditText) findViewById(R.id.txtMInRecoOth);
         secMInReco2=(LinearLayout)findViewById(R.id.secMInReco2);
         lineMInReco2=(View)findViewById(R.id.lineMInReco2);
         VlblMInReco2=(TextView) findViewById(R.id.VlblMInReco2);
         spnMInReco2=(Spinner) findViewById(R.id.spnMInReco2);



         txtMDurReco.addTextChangedListener(new TextWatcher() {
             @Override
             public void beforeTextChanged(CharSequence s, int start, int count, int after) {

             }

             @Override
             public void onTextChanged(CharSequence s, int start, int before, int count) {

             if(txtMDurReco.getText().toString().length()>0)
                 {
                     secMInRecoLabel.setVisibility(View.GONE);
                     lineMInRecoLabel.setVisibility(View.GONE);
                     secMInReco.setVisibility(View.GONE);
                     lineMInReco.setVisibility(View.GONE);
                     spnMInReco.setSelection(0);
                     secMInRecoOth.setVisibility(View.GONE);
                     lineMInRecoOth.setVisibility(View.GONE);
                     txtMInRecoOth.setText("");
                     secMInReco2.setVisibility(View.GONE);
                     lineMInReco2.setVisibility(View.GONE);
                     spnMInReco2.setSelection(0);
                     secMInRecoOth2.setVisibility(View.GONE);
                     lineMInRecoOth2.setVisibility(View.GONE);
                     txtMInRecoOth2.setText("");
                     secMInReco3.setVisibility(View.GONE);
                     lineMInReco3.setVisibility(View.GONE);
                     spnMInReco3.setSelection(0);
                     secMInRecoOth3.setVisibility(View.GONE);
                     lineMInRecoOth3.setVisibility(View.GONE);
                     txtMInRecoOth3.setText("");
                 }
                 else{
                 secMInRecoLabel.setVisibility(View.VISIBLE);
                 lineMInRecoLabel.setVisibility(View.VISIBLE);
                 secMInReco.setVisibility(View.VISIBLE);
                 lineMInReco.setVisibility(View.VISIBLE);
                 spnMInReco.setSelection(0);

                 secMInReco2.setVisibility(View.VISIBLE);
                 lineMInReco2.setVisibility(View.VISIBLE);
                 spnMInReco2.setSelection(0);

                 secMInReco3.setVisibility(View.VISIBLE);
                 lineMInReco3.setVisibility(View.VISIBLE);
                 spnMInReco3.setSelection(0);

                 }


             }

             @Override
             public void afterTextChanged(Editable s) {

             }
         });



         List<String> listMInReco2 = new ArrayList<String>();
         
         listMInReco2.add("");
         listMInReco2.add("1-কথা বলতে সমস্যা (Problems with speech)");
         listMInReco2.add("2-শ্রবণশক্তি হারানো (Hearing loss) ");
         listMInReco2.add("3-কোন কিছু নিয়ে চিন্তা করতে সমস্যা (Problems with thinking)");
         listMInReco2.add("4-বারবার খিঁচুনি (Recurrent seizures) ");
         listMInReco2.add("5-আচরনের পরিবর্তন (Personality change)");
         listMInReco2.add("7-অন্যান্য (Other)");
         ArrayAdapter<String> adptrMInReco2= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listMInReco2);
         spnMInReco2.setAdapter(adptrMInReco2);

         spnMInReco2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnMInReco2.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnMInReco2.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("1"))
                 {
                    secMInRecoOth2.setVisibility(View.GONE);
                    lineMInRecoOth2.setVisibility(View.GONE);
                     spnMInReco3.setEnabled(true);
                    txtMInRecoOth2.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("2"))
                 {
                    secMInRecoOth2.setVisibility(View.GONE);
                    lineMInRecoOth2.setVisibility(View.GONE);
                     spnMInReco3.setEnabled(true);
                    txtMInRecoOth2.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("3"))
                 {
                    secMInRecoOth2.setVisibility(View.GONE);
                    lineMInRecoOth2.setVisibility(View.GONE);
                     spnMInReco3.setEnabled(true);
                    txtMInRecoOth2.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("4"))
                 {
                    secMInRecoOth2.setVisibility(View.GONE);
                    lineMInRecoOth2.setVisibility(View.GONE);
                     spnMInReco3.setEnabled(true);
                    txtMInRecoOth2.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("5"))
                 {
                    secMInRecoOth2.setVisibility(View.GONE);
                    lineMInRecoOth2.setVisibility(View.GONE);
                     spnMInReco3.setEnabled(true);
                    txtMInRecoOth2.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("7"))
                 {
                    secMInRecoOth2.setVisibility(View.VISIBLE);
                    lineMInRecoOth2.setVisibility(View.VISIBLE);
                     spnMInReco3.setSelection(0);
                     spnMInReco3.setEnabled(false);
                 }
                 else{
                     secMInRecoOth2.setVisibility(View.GONE);
                     lineMInRecoOth2.setVisibility(View.GONE);
                     spnMInReco3.setEnabled(true);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secMInRecoOth2=(LinearLayout)findViewById(R.id.secMInRecoOth2);
         lineMInRecoOth2=(View)findViewById(R.id.lineMInRecoOth2);
         VlblMInRecoOth2=(TextView) findViewById(R.id.VlblMInRecoOth2);
         txtMInRecoOth2=(EditText) findViewById(R.id.txtMInRecoOth2);
         secMInReco3=(LinearLayout)findViewById(R.id.secMInReco3);
         lineMInReco3=(View)findViewById(R.id.lineMInReco3);
         VlblMInReco3=(TextView) findViewById(R.id.VlblMInReco3);
         spnMInReco3=(Spinner) findViewById(R.id.spnMInReco3);
         List<String> listMInReco3 = new ArrayList<String>();
         
         listMInReco3.add("");
         listMInReco3.add("1-কথা বলতে সমস্যা (Problems with speech)");
         listMInReco3.add("2-শ্রবণশক্তি হারানো (Hearing loss) ");
         listMInReco3.add("3-কোন কিছু নিয়ে চিন্তা করতে সমস্যা (Problems with thinking)");
         listMInReco3.add("4-বারবার খিঁচুনি (Recurrent seizures) ");
         listMInReco3.add("5-আচরনের পরিবর্তন (Personality change)");
         listMInReco3.add("7-অন্যান্য (Other) ");
         ArrayAdapter<String> adptrMInReco3= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listMInReco3);
         spnMInReco3.setAdapter(adptrMInReco3);

         spnMInReco3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnMInReco3.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnMInReco3.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("1"))
                 {
                    secMInRecoOth3.setVisibility(View.GONE);
                    lineMInRecoOth3.setVisibility(View.GONE);
                    txtMInRecoOth3.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("2"))
                 {
                    secMInRecoOth3.setVisibility(View.GONE);
                    lineMInRecoOth3.setVisibility(View.GONE);
                    txtMInRecoOth3.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("3"))
                 {
                    secMInRecoOth3.setVisibility(View.GONE);
                    lineMInRecoOth3.setVisibility(View.GONE);
                    txtMInRecoOth3.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("4"))
                 {
                    secMInRecoOth3.setVisibility(View.GONE);
                    lineMInRecoOth3.setVisibility(View.GONE);
                    txtMInRecoOth3.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("5"))
                 {
                    secMInRecoOth3.setVisibility(View.GONE);
                    lineMInRecoOth3.setVisibility(View.GONE);
                    txtMInRecoOth3.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("7"))
                 {
                    secMInRecoOth3.setVisibility(View.VISIBLE);
                    lineMInRecoOth3.setVisibility(View.VISIBLE);
                 }
                 else{
                     secMInRecoOth3.setVisibility(View.GONE);
                     lineMInRecoOth3.setVisibility(View.GONE);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secMInRecoOth3=(LinearLayout)findViewById(R.id.secMInRecoOth3);
         lineMInRecoOth3=(View)findViewById(R.id.lineMInRecoOth3);
         VlblMInRecoOth3=(TextView) findViewById(R.id.VlblMInRecoOth3);
         txtMInRecoOth3=(EditText) findViewById(R.id.txtMInRecoOth3);
         secAboSeriIlOnset=(LinearLayout)findViewById(R.id.secAboSeriIlOnset);
         lineAboSeriIlOnset=(View)findViewById(R.id.lineAboSeriIlOnset);
         VlblAboSeriIlOnset=(TextView) findViewById(R.id.VlblAboSeriIlOnset);
         txtAboSeriIlOnset=(EditText) findViewById(R.id.txtAboSeriIlOnset);


         dtpMDtHos.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpMDtHos.getRight() - dtpMDtHos.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btnMDtHos"; showDialog(DATE_DIALOG);
                         txtMHosM.setText("");
                      return true;
                     }
                 }
                 return false;
             }
         });

         txtMHosM.addTextChangedListener(new TextWatcher() {
             @Override
             public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

             }

             @Override
             public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
if(!txtMHosM.getText().toString().equals("0") & txtMHosM.getText().toString().length()>0)
{
    dtpMDtHos.setText("");
}

             }

             @Override
             public void afterTextChanged(Editable editable) {

             }
         });


         //Hide all skip variables
         secSameIllSec2.setVisibility(View.GONE);
         lineSameIllSec2.setVisibility(View.GONE);
         secEpiSeriIlOnset.setVisibility(View.GONE);
         lineEpiSeriIlOnset.setVisibility(View.GONE);
         secIlnessFev.setVisibility(View.GONE);
         lineIlnessFev.setVisibility(View.GONE);
         secIlnessConv.setVisibility(View.GONE);
         lineIlnessConv.setVisibility(View.GONE);
         secUpRolEye.setVisibility(View.GONE);
         lineUpRolEye.setVisibility(View.GONE);
         secMRigJaw.setVisibility(View.GONE);
         lineMRigJaw.setVisibility(View.GONE);
         secMRigLimbs.setVisibility(View.GONE);
         lineMRigLimbs.setVisibility(View.GONE);
         secMDurConv.setVisibility(View.GONE);
         lineMDurConv.setVisibility(View.GONE);
         secMDrowsin.setVisibility(View.GONE);
         lineMDrowsin.setVisibility(View.GONE);
         secMDurDrowsin.setVisibility(View.GONE);
         lineMDurDrowsin.setVisibility(View.GONE);
         secMUntoFeed.setVisibility(View.GONE);
         lineMUntoFeed.setVisibility(View.GONE);
         secMDurUntoFeed.setVisibility(View.GONE);
         lineMDurUntoFeed.setVisibility(View.GONE);
         secMCalNoRes.setVisibility(View.GONE);
         lineMCalNoRes.setVisibility(View.GONE);
         secMDurCalNoRes.setVisibility(View.GONE);
         lineMDurCalNoRes.setVisibility(View.GONE);
         secMEverConf.setVisibility(View.GONE);
         lineMEverConf.setVisibility(View.GONE);
         secMDurEverConf.setVisibility(View.GONE);
         lineMDurEverConf.setVisibility(View.GONE);
         secMFlicker.setVisibility(View.GONE);
         lineMFlicker.setVisibility(View.GONE);
         secMDurFliker.setVisibility(View.GONE);
         lineMDurFliker.setVisibility(View.GONE);
         secMUnconsci.setVisibility(View.GONE);
         lineMUnconsci.setVisibility(View.GONE);
         secMDurUnconsci.setVisibility(View.GONE);
         lineMDurUnconsci.setVisibility(View.GONE);
         secMIlCry.setVisibility(View.GONE);
         lineMIlCry.setVisibility(View.GONE);
         secMDurIlCry.setVisibility(View.GONE);
         lineMDurIlCry.setVisibility(View.GONE);
         secMUnCraWalk.setVisibility(View.GONE);
         lineMUnCraWalk.setVisibility(View.GONE);
         secMDurUnCraWalk.setVisibility(View.GONE);
         lineMDurUnCraWalk.setVisibility(View.GONE);
         secMDifBreath.setVisibility(View.GONE);
         lineMDifBreath.setVisibility(View.GONE);
         secMCough.setVisibility(View.GONE);
         lineMCough.setVisibility(View.GONE);
         secMRash.setVisibility(View.GONE);
         lineMRash.setVisibility(View.GONE);
         secMVomit.setVisibility(View.GONE);
         lineMVomit.setVisibility(View.GONE);
         secMDiarrhoea.setVisibility(View.GONE);
         lineMDiarrhoea.setVisibility(View.GONE);
         secMHCar.setVisibility(View.GONE);
         lineMHCar.setVisibility(View.GONE);
         secMHCarTypLabel.setVisibility(View.GONE);
         lineMHCarTypLabel.setVisibility(View.GONE);
         secMHC_Phy.setVisibility(View.GONE);
         lineMHC_Phy.setVisibility(View.GONE);
         secMHC_UnquaDoctor.setVisibility(View.GONE);
         lineMHC_UnquaDoctor.setVisibility(View.GONE);
         secMHC_Para.setVisibility(View.GONE);
         lineMHC_Para.setVisibility(View.GONE);
         secMHC_Com.setVisibility(View.GONE);
         lineMHC_Com.setVisibility(View.GONE);
         secMHC_Pha.setVisibility(View.GONE);
         lineMHC_Pha.setVisibility(View.GONE);
         secMHC_Hompath.setVisibility(View.GONE);
         lineMHC_Hompath.setVisibility(View.GONE);
         secMHC_TrHeal.setVisibility(View.GONE);
         lineMHC_TrHeal.setVisibility(View.GONE);
         secMHC_SpiHeal.setVisibility(View.GONE);
         lineMHC_SpiHeal.setVisibility(View.GONE);
         secMHC_Oth.setVisibility(View.GONE);
         lineMHC_Oth.setVisibility(View.GONE);
         secMHC_OthName.setVisibility(View.GONE);
         lineMHC_OthName.setVisibility(View.GONE);
         secMDSHOPD.setVisibility(View.GONE);
         lineMDSHOPD.setVisibility(View.GONE);
         secMSSFOPD.setVisibility(View.GONE);
         lineMSSFOPD.setVisibility(View.GONE);
         secMHosAdm.setVisibility(View.GONE);
         lineMHosAdm.setVisibility(View.GONE);
         secMHosNamLabel.setVisibility(View.GONE);
         lineMHosNamLabel.setVisibility(View.GONE);
         secMHC_Hosp_a1.setVisibility(View.GONE);
         lineMHC_Hosp_a1.setVisibility(View.GONE);
         secMHC_Hosp_a1_Oth.setVisibility(View.GONE);
         lineMHC_Hosp_a1_Oth.setVisibility(View.GONE);
         secMHC_Hosp_a2.setVisibility(View.GONE);
         lineMHC_Hosp_a2.setVisibility(View.GONE);
         secMHC_Hosp_a2_Oth.setVisibility(View.GONE);
         lineMHC_Hosp_a2_Oth.setVisibility(View.GONE);
         secMHC_Hosp_a3.setVisibility(View.GONE);
         lineMHC_Hosp_a3.setVisibility(View.GONE);
         secMHC_Hosp_a3_Oth.setVisibility(View.GONE);
         lineMHC_Hosp_a3_Oth.setVisibility(View.GONE);
         secMDtHos.setVisibility(View.GONE);
         lineMDtHos.setVisibility(View.GONE);
         secMHosM.setVisibility(View.GONE);
         lineMHosM.setVisibility(View.GONE);
         secMDurIlBeHos.setVisibility(View.GONE);
         lineMDurIlBeHos.setVisibility(View.GONE);
         secMChildIlDr.setVisibility(View.GONE);
         lineMChildIlDr.setVisibility(View.GONE);
         secMChildIlDrOth.setVisibility(View.GONE);
         lineMChildIlDrOth.setVisibility(View.GONE);
         secMReco.setVisibility(View.GONE);
         lineMReco.setVisibility(View.GONE);
         secMDurReco.setVisibility(View.GONE);
         lineMDurReco.setVisibility(View.GONE);
         secMInRecoLabel.setVisibility(View.GONE);
         lineMInRecoLabel.setVisibility(View.GONE);
         secMInReco.setVisibility(View.GONE);
         lineMInReco.setVisibility(View.GONE);
         secMInRecoOth.setVisibility(View.GONE);
         lineMInRecoOth.setVisibility(View.GONE);
         secMInReco2.setVisibility(View.GONE);
         lineMInReco2.setVisibility(View.GONE);
         secMInRecoOth2.setVisibility(View.GONE);
         lineMInRecoOth2.setVisibility(View.GONE);
         secMInReco3.setVisibility(View.GONE);
         lineMInReco3.setVisibility(View.GONE);
         secMInRecoOth3.setVisibility(View.GONE);
         lineMInRecoOth3.setVisibility(View.GONE);
         secAboSeriIlOnset.setVisibility(View.GONE);
         lineAboSeriIlOnset.setVisibility(View.GONE);
         secSameIllSec2.setVisibility(View.GONE);
         lineSameIllSec2.setVisibility(View.GONE);
         secEpiSeriIlOnset.setVisibility(View.GONE);
         lineEpiSeriIlOnset.setVisibility(View.GONE);
         secIlnessFev.setVisibility(View.GONE);
         lineIlnessFev.setVisibility(View.GONE);
         secIlnessConv.setVisibility(View.GONE);
         lineIlnessConv.setVisibility(View.GONE);
         secUpRolEye.setVisibility(View.GONE);
         lineUpRolEye.setVisibility(View.GONE);
         secMRigJaw.setVisibility(View.GONE);
         lineMRigJaw.setVisibility(View.GONE);
         secMRigLimbs.setVisibility(View.GONE);
         lineMRigLimbs.setVisibility(View.GONE);
         secMDurConv.setVisibility(View.GONE);
         lineMDurConv.setVisibility(View.GONE);
         secMDrowsin.setVisibility(View.GONE);
         lineMDrowsin.setVisibility(View.GONE);
         secMDurDrowsin.setVisibility(View.GONE);
         lineMDurDrowsin.setVisibility(View.GONE);
         secMUntoFeed.setVisibility(View.GONE);
         lineMUntoFeed.setVisibility(View.GONE);
         secMDurUntoFeed.setVisibility(View.GONE);
         lineMDurUntoFeed.setVisibility(View.GONE);
         secMCalNoRes.setVisibility(View.GONE);
         lineMCalNoRes.setVisibility(View.GONE);
         secMDurCalNoRes.setVisibility(View.GONE);
         lineMDurCalNoRes.setVisibility(View.GONE);
         secMEverConf.setVisibility(View.GONE);
         lineMEverConf.setVisibility(View.GONE);
         secMDurEverConf.setVisibility(View.GONE);
         lineMDurEverConf.setVisibility(View.GONE);
         secMFlicker.setVisibility(View.GONE);
         lineMFlicker.setVisibility(View.GONE);
         secMDurFliker.setVisibility(View.GONE);
         lineMDurFliker.setVisibility(View.GONE);
         secMUnconsci.setVisibility(View.GONE);
         lineMUnconsci.setVisibility(View.GONE);
         secMDurUnconsci.setVisibility(View.GONE);
         lineMDurUnconsci.setVisibility(View.GONE);
         secMIlCry.setVisibility(View.GONE);
         lineMIlCry.setVisibility(View.GONE);
         secMDurIlCry.setVisibility(View.GONE);
         lineMDurIlCry.setVisibility(View.GONE);
         secMUnCraWalk.setVisibility(View.GONE);
         lineMUnCraWalk.setVisibility(View.GONE);
         secMDurUnCraWalk.setVisibility(View.GONE);
         lineMDurUnCraWalk.setVisibility(View.GONE);
         secMDifBreath.setVisibility(View.GONE);
         lineMDifBreath.setVisibility(View.GONE);
         secMCough.setVisibility(View.GONE);
         lineMCough.setVisibility(View.GONE);
         secMRash.setVisibility(View.GONE);
         lineMRash.setVisibility(View.GONE);
         secMVomit.setVisibility(View.GONE);
         lineMVomit.setVisibility(View.GONE);
         secMDiarrhoea.setVisibility(View.GONE);
         lineMDiarrhoea.setVisibility(View.GONE);
         secMHCar.setVisibility(View.GONE);
         lineMHCar.setVisibility(View.GONE);
         secMHCarTypLabel.setVisibility(View.GONE);
         lineMHCarTypLabel.setVisibility(View.GONE);
         secMHC_Phy.setVisibility(View.GONE);
         lineMHC_Phy.setVisibility(View.GONE);
         secMHC_UnquaDoctor.setVisibility(View.GONE);
         lineMHC_UnquaDoctor.setVisibility(View.GONE);
         secMHC_Para.setVisibility(View.GONE);
         lineMHC_Para.setVisibility(View.GONE);
         secMHC_Com.setVisibility(View.GONE);
         lineMHC_Com.setVisibility(View.GONE);
         secMHC_Pha.setVisibility(View.GONE);
         lineMHC_Pha.setVisibility(View.GONE);
         secMHC_Hompath.setVisibility(View.GONE);
         lineMHC_Hompath.setVisibility(View.GONE);
         secMHC_TrHeal.setVisibility(View.GONE);
         lineMHC_TrHeal.setVisibility(View.GONE);
         secMHC_SpiHeal.setVisibility(View.GONE);
         lineMHC_SpiHeal.setVisibility(View.GONE);
         secMHC_Oth.setVisibility(View.GONE);
         lineMHC_Oth.setVisibility(View.GONE);
         secMHC_OthName.setVisibility(View.GONE);
         lineMHC_OthName.setVisibility(View.GONE);
         secMDSHOPD.setVisibility(View.GONE);
         lineMDSHOPD.setVisibility(View.GONE);
         secMSSFOPD.setVisibility(View.GONE);
         lineMSSFOPD.setVisibility(View.GONE);
         secMHosAdm.setVisibility(View.GONE);
         lineMHosAdm.setVisibility(View.GONE);
         secMHosNamLabel.setVisibility(View.GONE);
         lineMHosNamLabel.setVisibility(View.GONE);
         secMHC_Hosp_a1.setVisibility(View.GONE);
         lineMHC_Hosp_a1.setVisibility(View.GONE);
         secMHC_Hosp_a1_Oth.setVisibility(View.GONE);
         lineMHC_Hosp_a1_Oth.setVisibility(View.GONE);
         secMHC_Hosp_a2.setVisibility(View.GONE);
         lineMHC_Hosp_a2.setVisibility(View.GONE);
         secMHC_Hosp_a2_Oth.setVisibility(View.GONE);
         lineMHC_Hosp_a2_Oth.setVisibility(View.GONE);
         secMHC_Hosp_a3.setVisibility(View.GONE);
         lineMHC_Hosp_a3.setVisibility(View.GONE);
         secMHC_Hosp_a3_Oth.setVisibility(View.GONE);
         lineMHC_Hosp_a3_Oth.setVisibility(View.GONE);
         secMDtHos.setVisibility(View.GONE);
         lineMDtHos.setVisibility(View.GONE);
         secMHosM.setVisibility(View.GONE);
         lineMHosM.setVisibility(View.GONE);
         secMDurIlBeHos.setVisibility(View.GONE);
         lineMDurIlBeHos.setVisibility(View.GONE);
         secMChildIlDr.setVisibility(View.GONE);
         lineMChildIlDr.setVisibility(View.GONE);
         secMChildIlDrOth.setVisibility(View.GONE);
         lineMChildIlDrOth.setVisibility(View.GONE);
         secMReco.setVisibility(View.GONE);
         lineMReco.setVisibility(View.GONE);
         secMDurReco.setVisibility(View.GONE);
         lineMDurReco.setVisibility(View.GONE);
         secMInRecoLabel.setVisibility(View.GONE);
         lineMInRecoLabel.setVisibility(View.GONE);
         secMInReco.setVisibility(View.GONE);
         lineMInReco.setVisibility(View.GONE);
         secMInRecoOth.setVisibility(View.GONE);
         lineMInRecoOth.setVisibility(View.GONE);
         secMInReco2.setVisibility(View.GONE);
         lineMInReco2.setVisibility(View.GONE);
         secMInRecoOth2.setVisibility(View.GONE);
         lineMInRecoOth2.setVisibility(View.GONE);
         secMInReco3.setVisibility(View.GONE);
         lineMInReco3.setVisibility(View.GONE);
         secMInRecoOth3.setVisibility(View.GONE);
         lineMInRecoOth3.setVisibility(View.GONE);
         secAboSeriIlOnset.setVisibility(View.GONE);
         lineAboSeriIlOnset.setVisibility(View.GONE);
         secUpRolEye.setVisibility(View.GONE);
         lineUpRolEye.setVisibility(View.GONE);
         secMRigJaw.setVisibility(View.GONE);
         lineMRigJaw.setVisibility(View.GONE);
         secMRigLimbs.setVisibility(View.GONE);
         lineMRigLimbs.setVisibility(View.GONE);
         secMDurConv.setVisibility(View.GONE);
         lineMDurConv.setVisibility(View.GONE);
         secUpRolEye.setVisibility(View.GONE);
         lineUpRolEye.setVisibility(View.GONE);
         secMRigJaw.setVisibility(View.GONE);
         lineMRigJaw.setVisibility(View.GONE);
         secMRigLimbs.setVisibility(View.GONE);
         lineMRigLimbs.setVisibility(View.GONE);
         secMDurConv.setVisibility(View.GONE);
         lineMDurConv.setVisibility(View.GONE);
         secMDurDrowsin.setVisibility(View.GONE);
         lineMDurDrowsin.setVisibility(View.GONE);
         secMDurDrowsin.setVisibility(View.GONE);
         lineMDurDrowsin.setVisibility(View.GONE);
         secMDurUntoFeed.setVisibility(View.GONE);
         lineMDurUntoFeed.setVisibility(View.GONE);
         secMDurUntoFeed.setVisibility(View.GONE);
         lineMDurUntoFeed.setVisibility(View.GONE);
         secMDurUntoFeed.setVisibility(View.GONE);
         lineMDurUntoFeed.setVisibility(View.GONE);
         secMDurCalNoRes.setVisibility(View.GONE);
         lineMDurCalNoRes.setVisibility(View.GONE);
         secMDurCalNoRes.setVisibility(View.GONE);
         lineMDurCalNoRes.setVisibility(View.GONE);
         secMDurCalNoRes.setVisibility(View.GONE);
         lineMDurCalNoRes.setVisibility(View.GONE);
         secMDurEverConf.setVisibility(View.GONE);
         lineMDurEverConf.setVisibility(View.GONE);
         secMDurEverConf.setVisibility(View.GONE);
         lineMDurEverConf.setVisibility(View.GONE);
         secMDurEverConf.setVisibility(View.GONE);
         lineMDurEverConf.setVisibility(View.GONE);
         secMDurFliker.setVisibility(View.GONE);
         lineMDurFliker.setVisibility(View.GONE);
         secMDurFliker.setVisibility(View.GONE);
         lineMDurFliker.setVisibility(View.GONE);
         secMDurUnconsci.setVisibility(View.GONE);
         lineMDurUnconsci.setVisibility(View.GONE);
         secMDurUnconsci.setVisibility(View.GONE);
         lineMDurUnconsci.setVisibility(View.GONE);
         secMDurIlCry.setVisibility(View.GONE);
         lineMDurIlCry.setVisibility(View.GONE);
         secMDurIlCry.setVisibility(View.GONE);
         lineMDurIlCry.setVisibility(View.GONE);
         secMDurUnCraWalk.setVisibility(View.GONE);
         lineMDurUnCraWalk.setVisibility(View.GONE);
         secMDurUnCraWalk.setVisibility(View.GONE);
         lineMDurUnCraWalk.setVisibility(View.GONE);
         secMDurUnCraWalk.setVisibility(View.GONE);
         lineMDurUnCraWalk.setVisibility(View.GONE);
         secMHCarTypLabel.setVisibility(View.GONE);
         lineMHCarTypLabel.setVisibility(View.GONE);
         secMHC_Phy.setVisibility(View.GONE);
         lineMHC_Phy.setVisibility(View.GONE);
         secMHC_UnquaDoctor.setVisibility(View.GONE);
         lineMHC_UnquaDoctor.setVisibility(View.GONE);
         secMHC_Para.setVisibility(View.GONE);
         lineMHC_Para.setVisibility(View.GONE);
         secMHC_Com.setVisibility(View.GONE);
         lineMHC_Com.setVisibility(View.GONE);
         secMHC_Pha.setVisibility(View.GONE);
         lineMHC_Pha.setVisibility(View.GONE);
         secMHC_Hompath.setVisibility(View.GONE);
         lineMHC_Hompath.setVisibility(View.GONE);
         secMHC_TrHeal.setVisibility(View.GONE);
         lineMHC_TrHeal.setVisibility(View.GONE);
         secMHC_SpiHeal.setVisibility(View.GONE);
         lineMHC_SpiHeal.setVisibility(View.GONE);
         secMHC_Oth.setVisibility(View.GONE);
         lineMHC_Oth.setVisibility(View.GONE);
         secMHC_OthName.setVisibility(View.GONE);
         lineMHC_OthName.setVisibility(View.GONE);
         secMHCarTypLabel.setVisibility(View.GONE);
         lineMHCarTypLabel.setVisibility(View.GONE);
         secMHC_Phy.setVisibility(View.GONE);
         lineMHC_Phy.setVisibility(View.GONE);
         secMHC_UnquaDoctor.setVisibility(View.GONE);
         lineMHC_UnquaDoctor.setVisibility(View.GONE);
         secMHC_Para.setVisibility(View.GONE);
         lineMHC_Para.setVisibility(View.GONE);
         secMHC_Com.setVisibility(View.GONE);
         lineMHC_Com.setVisibility(View.GONE);
         secMHC_Pha.setVisibility(View.GONE);
         lineMHC_Pha.setVisibility(View.GONE);
         secMHC_Hompath.setVisibility(View.GONE);
         lineMHC_Hompath.setVisibility(View.GONE);
         secMHC_TrHeal.setVisibility(View.GONE);
         lineMHC_TrHeal.setVisibility(View.GONE);
         secMHC_SpiHeal.setVisibility(View.GONE);
         lineMHC_SpiHeal.setVisibility(View.GONE);
         secMHC_Oth.setVisibility(View.GONE);
         lineMHC_Oth.setVisibility(View.GONE);
         secMHC_OthName.setVisibility(View.GONE);
         lineMHC_OthName.setVisibility(View.GONE);
         secMHC_OthName.setVisibility(View.GONE);
         lineMHC_OthName.setVisibility(View.GONE);
         secMHC_OthName.setVisibility(View.GONE);
         lineMHC_OthName.setVisibility(View.GONE);
         secMHosNamLabel.setVisibility(View.GONE);
         lineMHosNamLabel.setVisibility(View.GONE);
         secMHC_Hosp_a1.setVisibility(View.GONE);
         lineMHC_Hosp_a1.setVisibility(View.GONE);
         secMHC_Hosp_a1_Oth.setVisibility(View.GONE);
         lineMHC_Hosp_a1_Oth.setVisibility(View.GONE);
         secMHC_Hosp_a2.setVisibility(View.GONE);
         lineMHC_Hosp_a2.setVisibility(View.GONE);
         secMHC_Hosp_a2_Oth.setVisibility(View.GONE);
         lineMHC_Hosp_a2_Oth.setVisibility(View.GONE);
         secMHC_Hosp_a3.setVisibility(View.GONE);
         lineMHC_Hosp_a3.setVisibility(View.GONE);
         secMHC_Hosp_a3_Oth.setVisibility(View.GONE);
         lineMHC_Hosp_a3_Oth.setVisibility(View.GONE);
         secMDtHos.setVisibility(View.GONE);
         lineMDtHos.setVisibility(View.GONE);
         secMHosM.setVisibility(View.GONE);
         lineMHosM.setVisibility(View.GONE);
         secMDurIlBeHos.setVisibility(View.GONE);
         lineMDurIlBeHos.setVisibility(View.GONE);
         secMHosNamLabel.setVisibility(View.GONE);
         lineMHosNamLabel.setVisibility(View.GONE);
         secMHC_Hosp_a1.setVisibility(View.GONE);
         lineMHC_Hosp_a1.setVisibility(View.GONE);
         secMHC_Hosp_a1_Oth.setVisibility(View.GONE);
         lineMHC_Hosp_a1_Oth.setVisibility(View.GONE);
         secMHC_Hosp_a2.setVisibility(View.GONE);
         lineMHC_Hosp_a2.setVisibility(View.GONE);
         secMHC_Hosp_a2_Oth.setVisibility(View.GONE);
         lineMHC_Hosp_a2_Oth.setVisibility(View.GONE);
         secMHC_Hosp_a3.setVisibility(View.GONE);
         lineMHC_Hosp_a3.setVisibility(View.GONE);
         secMHC_Hosp_a3_Oth.setVisibility(View.GONE);
         lineMHC_Hosp_a3_Oth.setVisibility(View.GONE);
         secMDtHos.setVisibility(View.GONE);
         lineMDtHos.setVisibility(View.GONE);
         secMHosM.setVisibility(View.GONE);
         lineMHosM.setVisibility(View.GONE);
         secMDurIlBeHos.setVisibility(View.GONE);
         lineMDurIlBeHos.setVisibility(View.GONE);
         secMHC_Hosp_a1_Oth.setVisibility(View.GONE);
         lineMHC_Hosp_a1_Oth.setVisibility(View.GONE);
         secMHC_Hosp_a1_Oth.setVisibility(View.GONE);
         lineMHC_Hosp_a1_Oth.setVisibility(View.GONE);
         secMHC_Hosp_a1_Oth.setVisibility(View.GONE);
         lineMHC_Hosp_a1_Oth.setVisibility(View.GONE);
         secMHC_Hosp_a2_Oth.setVisibility(View.GONE);
         lineMHC_Hosp_a2_Oth.setVisibility(View.GONE);
         secMHC_Hosp_a2_Oth.setVisibility(View.GONE);
         lineMHC_Hosp_a2_Oth.setVisibility(View.GONE);
         secMHC_Hosp_a2_Oth.setVisibility(View.GONE);
         lineMHC_Hosp_a2_Oth.setVisibility(View.GONE);
         secMHC_Hosp_a3_Oth.setVisibility(View.GONE);
         lineMHC_Hosp_a3_Oth.setVisibility(View.GONE);
         secMHC_Hosp_a3_Oth.setVisibility(View.GONE);
         lineMHC_Hosp_a3_Oth.setVisibility(View.GONE);
         secMHC_Hosp_a3_Oth.setVisibility(View.GONE);
         lineMHC_Hosp_a3_Oth.setVisibility(View.GONE);
         secMChildIlDrOth.setVisibility(View.GONE);
         lineMChildIlDrOth.setVisibility(View.GONE);
         secMChildIlDrOth.setVisibility(View.GONE);
         lineMChildIlDrOth.setVisibility(View.GONE);
         secMChildIlDrOth.setVisibility(View.GONE);
         lineMChildIlDrOth.setVisibility(View.GONE);
         secMChildIlDrOth.setVisibility(View.GONE);
         lineMChildIlDrOth.setVisibility(View.GONE);
         secMChildIlDrOth.setVisibility(View.GONE);
         lineMChildIlDrOth.setVisibility(View.GONE);
         secMChildIlDrOth.setVisibility(View.GONE);
         lineMChildIlDrOth.setVisibility(View.GONE);
         secMChildIlDrOth.setVisibility(View.GONE);
         lineMChildIlDrOth.setVisibility(View.GONE);
         secMChildIlDrOth.setVisibility(View.GONE);
         lineMChildIlDrOth.setVisibility(View.GONE);
         secMDurReco.setVisibility(View.GONE);
         lineMDurReco.setVisibility(View.GONE);
         secMDurReco.setVisibility(View.GONE);
         lineMDurReco.setVisibility(View.GONE);
         secMInRecoOth.setVisibility(View.GONE);
         lineMInRecoOth.setVisibility(View.GONE);
         secMInRecoOth.setVisibility(View.GONE);
         lineMInRecoOth.setVisibility(View.GONE);
         secMInRecoOth.setVisibility(View.GONE);
         lineMInRecoOth.setVisibility(View.GONE);
         secMInRecoOth.setVisibility(View.GONE);
         lineMInRecoOth.setVisibility(View.GONE);
         secMInRecoOth.setVisibility(View.GONE);
         lineMInRecoOth.setVisibility(View.GONE);
         secMInRecoOth2.setVisibility(View.GONE);
         lineMInRecoOth2.setVisibility(View.GONE);
         secMInRecoOth2.setVisibility(View.GONE);
         lineMInRecoOth2.setVisibility(View.GONE);
         secMInRecoOth2.setVisibility(View.GONE);
         lineMInRecoOth2.setVisibility(View.GONE);
         secMInRecoOth2.setVisibility(View.GONE);
         lineMInRecoOth2.setVisibility(View.GONE);
         secMInRecoOth2.setVisibility(View.GONE);
         lineMInRecoOth2.setVisibility(View.GONE);
         secMInRecoOth3.setVisibility(View.GONE);
         lineMInRecoOth3.setVisibility(View.GONE);
         secMInRecoOth3.setVisibility(View.GONE);
         lineMInRecoOth3.setVisibility(View.GONE);
         secMInRecoOth3.setVisibility(View.GONE);
         lineMInRecoOth3.setVisibility(View.GONE);
         secMInRecoOth3.setVisibility(View.GONE);
         lineMInRecoOth3.setVisibility(View.GONE);
         secMInRecoOth3.setVisibility(View.GONE);
         lineMInRecoOth3.setVisibility(View.GONE);

         DataSearch(UNCODE,STRUCTURENO,HOUSEHOLDSL,VISITNO,MEMSL);


        Button cmdSave = (Button) findViewById(R.id.cmdSave);
        cmdSave.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) { 
            DataSave();
        }});
     }
     catch(Exception  e)
     {
         Connection.MessageBox(MeningitisCase.this, e.getMessage());
         return;
     }
 }

 private void DataSave()
 {
   try {

       String DV = "";

       if (txtUNCode.getText().toString().length() == 0 & secUNCode.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Required field: Ward No.");
           txtUNCode.requestFocus();
           return;
       } else if (txtStructureNo.getText().toString().length() == 0 & secStructureNo.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Required field: Structure No.");
           txtStructureNo.requestFocus();
           return;
       } else if (txtHouseholdSl.getText().toString().length() == 0 & secHouseholdSl.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Required field: Household Sl.");
           txtHouseholdSl.requestFocus();
           return;
       } else if (txtVisitNo.getText().toString().length() == 0 & secVisitNo.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Required field: Visit No.");
           txtVisitNo.requestFocus();
           return;
       } else if (txtMemSl.getText().toString().length() == 0 & secMemSl.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Required field: Member Serial.");
           txtMemSl.requestFocus();
           return;
       } else if (!rdoSeriIlOnset1.isChecked() & !rdoSeriIlOnset2.isChecked() & !rdoSeriIlOnset3.isChecked() & secSeriIlOnset.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Select anyone options from (গত ১২ মাসে এই শিশুটি কি এমন মারাত্মক অসুস্থ হয়েছিল যেখানে শিশুটির জ্বর এবং খিঁচুনি অথবা জ্বর এবং অজ্ঞান হয়ে যাওয়া অথবা জ্বর এবং ঝিমুনি/দ্বিধা/শিশুকে জাগাতে অনেক কষ্ট হয় এমন অবস্থা (স্বাভাবিক মানসিক অবস্থার পরিবর্তন) হয়েছিল? (Within the last 12 months did this child have a serious illness with new onset of fever and convulsions OR fever and unconsciousness OR fever and drowsiness/confusion/difficulty in keeping child awake (Altered mental status)?)).");
           rdoSeriIlOnset1.requestFocus();
           return;
       } else if (!rdoSameIllSec21.isChecked() & !rdoSameIllSec22.isChecked() & secSameIllSec2.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Select anyone options from (এটি কি একই অসুস্থতা যা আপনি সেকশন ২ এর জন্য র্বণনা করছেনে  (Is it the same illness that you described for section-2)).");
           rdoSameIllSec21.requestFocus();
           return;
       } else if (txtEpiSeriIlOnset.getText().toString().length() == 0 & secEpiSeriIlOnset.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Required field: গত ১২ মাসে এই শিশুটির কতবার এই ধরনের মারাত্মক অসুস্থতার সাথে জ্বর ছিল এমন অবস্থা হয়েছিল? (যদি একের অধিক এই অসুস্থতা হয়ে থাকে, তবে সর্বশেষ অসুস্থতা সম্পর্কে নিচের প্রশ্নগুলো করুন (Within the last 12 months how many episodes of this kind of serious illness with fever did the child have?).");
           txtEpiSeriIlOnset.requestFocus();
           return;
       } else if (Integer.valueOf(txtEpiSeriIlOnset.getText().toString().length() == 0 ? "01" : txtEpiSeriIlOnset.getText().toString()) < 01 || Integer.valueOf(txtEpiSeriIlOnset.getText().toString().length() == 0 ? "20" : txtEpiSeriIlOnset.getText().toString()) > 20) {
           Connection.MessageBox(MeningitisCase.this, "Value should be between 01 and 20(গত ১২ মাসে এই শিশুটির কতবার এই ধরনের মারাত্মক অসুস্থতার সাথে জ্বর ছিল এমন অবস্থা হয়েছিল? (যদি একের অধিক এই অসুস্থতা হয়ে থাকে, তবে সর্বশেষ অসুস্থতা সম্পর্কে নিচের প্রশ্নগুলো করুন (Within the last 12 months how many episodes of this kind of serious illness with fever did the child have?)).");
           txtEpiSeriIlOnset.requestFocus();
           return;
       } else if (txtIlnessFev.getText().toString().length() == 0 & secIlnessFev.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Required field: শিশুটি কতদিন জ্বরে ভুগেছিল? (যদি জানা না থাকে 98 বসান) (How long did the child have fever?).");
           txtIlnessFev.requestFocus();
           return;
       } else if (Integer.valueOf(txtIlnessFev.getText().toString().length() == 0 ? "01" : txtIlnessFev.getText().toString()) < 01 || Integer.valueOf(txtIlnessFev.getText().toString().length() == 0 ? "98" : txtIlnessFev.getText().toString()) > 98) {
           Connection.MessageBox(MeningitisCase.this, "Value should be between 01 and 98(শিশুটি কতদিন জ্বরে ভুগেছিল? (যদি জানা না থাকে 98 বসান) (How long did the child have fever?)).");
           txtIlnessFev.requestFocus();
           return;
       } else if (!rdoIlnessConv1.isChecked() & !rdoIlnessConv2.isChecked() & !rdoIlnessConv3.isChecked() & secIlnessConv.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Select anyone options from (সর্বশেষ অসুস্থতার সময় এই শিশুটির কি খিঁচুনি হয়েছিল? (During the last episode of illness, did the child have convulsions?)).");
           rdoIlnessConv1.requestFocus();
           return;
       } else if (!rdoUpRolEye1.isChecked() & !rdoUpRolEye2.isChecked() & !rdoUpRolEye3.isChecked() & secUpRolEye.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Select anyone options from (খিঁচুনির সময় কি চোখ উল্টে  গিয়েছিল? (Did the convulsions include  upward rolling of eyeball?)).");
           rdoUpRolEye1.requestFocus();
           return;
       } else if (!rdoMRigJaw1.isChecked() & !rdoMRigJaw2.isChecked() & !rdoMRigJaw3.isChecked() & secMRigJaw.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Select anyone options from (খিঁচুনির সময় কি চোয়ালের মাংসপেশি শক্ত হয়ে গিয়েছিল? (চোয়ালের মাংসপেশি শক্ত/ মুখ খুলতে/বন্ধ করতে না পারা) (Did the convulsions include rigid jaw muscles?(Stiffening/hardening of jaw muscles; cannot open /close his/her mouth)).");
           rdoMRigJaw1.requestFocus();
           return;
       } else if (!rdoMRigLimbs1.isChecked() & !rdoMRigLimbs2.isChecked() & !rdoMRigLimbs3.isChecked() & secMRigLimbs.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Select anyone options from (খিঁচুনির সময় কি হাত পা শক্ত হয়ে গিয়েছিল? , হাতের মুষ্টি খুলতে গেলে বা হাত পা সোজা করতে গেলে বাধা পাওয়া (Did the convulsions include rigid limbs?, There is resistance in trying to open the limbs or fist)).");
           rdoMRigLimbs1.requestFocus();
           return;
       } else if (!rdoMDurConv1.isChecked() & !rdoMDurConv2.isChecked() & !rdoMDurConv3.isChecked() & !rdoMDurConv4.isChecked() & !rdoMDurConv5.isChecked() & secMDurConv.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Select anyone options from (খিঁচুনি কতক্ষন ছিল? (What was the duration of convulsions?)).");
           rdoMDurConv1.requestFocus();
           return;
       } else if (!rdoMDrowsin1.isChecked() & !rdoMDrowsin2.isChecked() & !rdoMDrowsin3.isChecked() & secMDrowsin.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Select anyone options from (সর্বশেষ অসুস্থতার সময় এই শিশুটিকে ঘুম থেকে জাগানো বা জাগ্রত রাখা যাচ্ছে না (জাগালেও আবার ঘুমিয়ে যায় এমন) এমন অবস্থা হয়েছিল? (ঝিমুনি) (During the last episode of illness, was it difficult to awaken or keep awake (keep from going to sleep) the child? (Drowsiness) ).");
           rdoMDrowsin1.requestFocus();
           return;
       } else if (txtMDurDrowsin.getText().toString().length() == 0 & secMDurDrowsin.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Required field: যদি হ্যাঁ হয় তাহলে কতদিন? (যদি জানা না থাকে 98 বসান) (If yes, for how long?).");
           txtMDurDrowsin.requestFocus();
           return;
       } else if (Integer.valueOf(txtMDurDrowsin.getText().toString().length() == 0 ? "01" : txtMDurDrowsin.getText().toString()) < 01 || Integer.valueOf(txtMDurDrowsin.getText().toString().length() == 0 ? "98" : txtMDurDrowsin.getText().toString()) > 98) {
           Connection.MessageBox(MeningitisCase.this, "Value should be between 01 and 98(যদি হ্যাঁ হয় তাহলে কতদিন? (যদি জানা না থাকে 98 বসান) (If yes, for how long?)).");
           txtMDurDrowsin.requestFocus();
           return;
       } else if (spnMUntoFeed.getSelectedItemPosition() == 0 & secMUntoFeed.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Required field: ৬ মাসের কম বয়সী শিশুর ক্ষেত্রেঃ সর্বশেষ অসুস্থতার সময় এই শিশুটির কি পানি/বুকের দুধ পান করতে পারেনি এমন অবস্থা হয়েছিল? (For children <6 months of age at the time of illness: During the illness, did the child ever refuse or was unable to drink or breastfeed?).");
           spnMUntoFeed.requestFocus();
           return;
       } else if (txtMDurUntoFeed.getText().toString().length() == 0 & secMDurUntoFeed.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Required field: যদি হ্যাঁ হয় তাহলে কতদিন?  (যদি জানা না থাকে 98 বসান) (If yes, for how long?).");
           txtMDurUntoFeed.requestFocus();
           return;
       } else if (Integer.valueOf(txtMDurUntoFeed.getText().toString().length() == 0 ? "01" : txtMDurUntoFeed.getText().toString()) < 01 || Integer.valueOf(txtMDurUntoFeed.getText().toString().length() == 0 ? "98" : txtMDurUntoFeed.getText().toString()) > 98) {
           Connection.MessageBox(MeningitisCase.this, "Value should be between 01 and 98(যদি হ্যাঁ হয় তাহলে কতদিন?  (যদি জানা না থাকে 98 বসান) (If yes, for how long?)).");
           txtMDurUntoFeed.requestFocus();
           return;
       } else if (spnMCalNoRes.getSelectedItemPosition() == 0 & secMCalNoRes.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Required field: যদি শিশুটির বয়স ১২ মাসের বেশি  হয়ঃ এই অসুস্থতার সময় (শিশুটির নাম) মায়ের ডাকে সাড়া দেয়নি এমন অবস্থা হয়েছিল কি? (If child is >12 months old:During the illness did (child’s name) ever not respond to mother’s call?).");
           spnMCalNoRes.requestFocus();
           return;
       } else if (txtMDurCalNoRes.getText().toString().length() == 0 & secMDurCalNoRes.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Required field: যদি হ্যাঁ হয় তাহলে কতদিন? (যদি জানা না থাকে 98 বসান) (If yes, for how long?).");
           txtMDurCalNoRes.requestFocus();
           return;
       } else if (Integer.valueOf(txtMDurCalNoRes.getText().toString().length() == 0 ? "01" : txtMDurCalNoRes.getText().toString()) < 01 || Integer.valueOf(txtMDurCalNoRes.getText().toString().length() == 0 ? "98" : txtMDurCalNoRes.getText().toString()) > 98) {
           Connection.MessageBox(MeningitisCase.this, "Value should be between 01 and 98(যদি হ্যাঁ হয় তাহলে কতদিন? (যদি জানা না থাকে 98 বসান) (If yes, for how long?)).");
           txtMDurCalNoRes.requestFocus();
           return;
       } else if (spnMEverConf.getSelectedItemPosition() == 0 & secMEverConf.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Required field: *যদি শিশুটির বয়স এই অসুস্থতায় সময় ১৮ মাসের বেশি হয়ঃ শিশুটি কখনও  কি দ্বিধার মধ্যে পরেছিল (ব্যক্তি/স্থান/সময় সম্পর্কে অবগত না থাকা)? * শিশুটি কি তার মা/পরিবারের অন্য সদস্যদের চিনতে পারেনি এমন অবস্থা হয়েছিল? * শিশুটি কি দিন/রাতের মধ্যে তফাৎ করতে পারে নি এমন অবস্থা হয়েছিল? *শিশুটি  কোথায় আছে তা বলতে পারেনি এমন অবস্থা হয়েছিল? *Was he/she ever unable to recognize the mother/ other family members? *Was he/she ever unable to tell whether it was day/ night? *Was he/she ever unaware of where he/she was?.");
           spnMEverConf.requestFocus();
           return;
       } else if (spnMDurEverConf.getSelectedItemPosition() == 0 & secMDurEverConf.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Required field: যদি হ্যাঁ হয় তাহলে কতক্ষন ছিল? (If yes for how long?).");
           spnMDurEverConf.requestFocus();
           return;
       } else if (!rdoMFlicker1.isChecked() & !rdoMFlicker2.isChecked() & !rdoMFlicker3.isChecked() & secMFlicker.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Select anyone options from (এই অসুস্থতার সময় শিশুটি কখনও নড়াচড়া করে নি এমন অবস্থা হয়েছিল কিন্তু সামান্য নড়াচড়া করত যখনঃ *জোরে কথা বলা হত অথবা, *তাকে জাগানোর জন্য আঘাত দেয়া হত অথবা, *চিমটি দেয়া হত , *যদি হ্যাঁ হয় তাহলে কতক্ষন ছিল তা নিচের প্রশ্নে জিজ্ঞাসা করুন? (During the illness, was there ever a time when the child showed nothing but only a flicker of movement if you:*talked loudly to the child or, *physically shook the child to awaken him/her or, *pinched the child?(If the answer is “yes”, then ask for how long) ).");
           rdoMFlicker1.requestFocus();
           return;
       } else if (spnMDurFliker.getSelectedItemPosition() == 0 & secMDurFliker.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Required field: এমন অবস্থা কতক্ষন ছিল? (What was the duration?).");
           spnMDurFliker.requestFocus();
           return;
       } else if (!rdoMUnconsci1.isChecked() & !rdoMUnconsci2.isChecked() & !rdoMUnconsci3.isChecked() & secMUnconsci.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Select anyone options from (সর্বশেষ অসুস্থতার সময় এই শিশুটি যে কোন সময়ের জন্য অজ্ঞান হয়েছিল? (During the illness, was the child unconscious for any length of time?)).");
           rdoMUnconsci1.requestFocus();
           return;
       } else if (spnMDurUnconsci.getSelectedItemPosition() == 0 & secMDurUnconsci.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Required field: কতক্ষন অজ্ঞান ছিল? (What was the duration of unconsciousness?).");
           spnMDurUnconsci.requestFocus();
           return;
       } else if (!rdoMIlCry1.isChecked() & !rdoMIlCry2.isChecked() & !rdoMIlCry3.isChecked() & secMIlCry.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Select anyone options from (এই অসুস্থতার সময় শিশুটির কি আস্বাভাবিক কান্না/কান্না থামেইনা অথবা খুবই দুর্বল ভাবে কান্না করেছিল? (During the illness, did the child have a period of non-stop / inconsolable crying or making a very feeble cry?)).");
           rdoMIlCry1.requestFocus();
           return;
       } else if (spnMDurIlCry.getSelectedItemPosition() == 0 & secMDurIlCry.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Required field: কতক্ষন কান্না করেছিল? (What was the duration of this cry?).");
           spnMDurIlCry.requestFocus();
           return;
       } else if (spnMUnCraWalk.getSelectedItemPosition() == 0 & secMUnCraWalk.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Required field: যে শিশুরা এই অসুস্থতার পূর্বে বসতে পারত, হামাগুড়ি দিতে পারত বা হাটতে পারতঃ এই অসুস্থতার জন্য বসতে /হামাগুড়ি/হাটতে পারেনি এমন অবস্থা হয়েছিল? (For children who were able to sit, crawl or walk before the illness: was the child ever unable to sit up/ crawl/ walk?).");
           spnMUnCraWalk.requestFocus();
           return;
       } else if (spnMDurUnCraWalk.getSelectedItemPosition() == 0 & secMDurUnCraWalk.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Required field: (কতক্ষন বসতে /হামাগুড়ি/হাটতে পারেনি? (What was the duration of inability to sit up/ crawl/walk?).");
           spnMDurUnCraWalk.requestFocus();
           return;
       } else if (!rdoMDifBreath1.isChecked() & !rdoMDifBreath2.isChecked() & !rdoMDifBreath3.isChecked() & secMDifBreath.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Select anyone options from (এই  অসুস্থতার সময় এই শিশুটির কি শ্বাসকষ্ট ছিল? (During this illness, did the child have difficulty breathing?)).");
           rdoMDifBreath1.requestFocus();
           return;
       } else if (!rdoMCough1.isChecked() & !rdoMCough2.isChecked() & !rdoMCough3.isChecked() & secMCough.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Select anyone options from (এই  অসুস্থতার সময় এই শিশুটির কি কাশি ছিল? (During this illness, did the child have cough?) ).");
           rdoMCough1.requestFocus();
           return;
       } else if (!rdoMRash1.isChecked() & !rdoMRash2.isChecked() & !rdoMRash3.isChecked() & secMRash.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Select anyone options from (এই  অসুস্থতার সময় এই শিশুটির শরীরে কি লাল দানা উঠেছিল? (During this illness, did the child have a rash?)).");
           rdoMRash1.requestFocus();
           return;
       } else if (!rdoMVomit1.isChecked() & !rdoMVomit2.isChecked() & !rdoMVomit3.isChecked() & secMVomit.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Select anyone options from (এই  অসুস্থতার সময় এই শিশুটির কি বমি হয়েছিল? (During this illness, did the child have vomiting?)).");
           rdoMVomit1.requestFocus();
           return;
       } else if (!rdoMDiarrhoea1.isChecked() & !rdoMDiarrhoea2.isChecked() & !rdoMDiarrhoea3.isChecked() & secMDiarrhoea.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Select anyone options from ((এই  অসুস্থতার সময় এই শিশুটির কি পাতলা পায়খানা হয়েছিল? (During this illness, did the child have diarrhoea?)).");
           rdoMDiarrhoea1.requestFocus();
           return;
       } else if (!rdoMHCar1.isChecked() & !rdoMHCar2.isChecked() & !rdoMHCar3.isChecked() & secMHCar.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Select anyone options from (এই  অসুস্থতার সময়  এই শিশুটিকে কি কোন স্বাস্থ্যসেবা দানকারীর কাছে নিয়ে গিয়েছিলেন ? (During this episode of illness, did you bring your child to a health care provider?)).");
           rdoMHCar1.requestFocus();
           return;
       } else if (!rdoMHC_Phy1.isChecked() & !rdoMHC_Phy2.isChecked() & !rdoMHC_Phy3.isChecked() & secMHC_Phy.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Select anyone options from (1.MBBS বা এর উপর (MBBS and above) ).");
           rdoMHC_Phy1.requestFocus();
           return;
       } else if (!rdoMHC_UnquaDoctor1.isChecked() & !rdoMHC_UnquaDoctor2.isChecked() & !rdoMHC_UnquaDoctor3.isChecked() & secMHC_UnquaDoctor.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Select anyone options from (2.অদক্ষ ডাক্তার/ LMAF (Unqualified doctor/LMAF) ).");
           rdoMHC_UnquaDoctor1.requestFocus();
           return;
       } else if (!rdoMHC_Para1.isChecked() & !rdoMHC_Para2.isChecked() & !rdoMHC_Para3.isChecked() & secMHC_Para.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Select anyone options from (3.প্যারামেডিক (GoB/NGO) (Paramedics (GoB/NGO))  ).");
           rdoMHC_Para1.requestFocus();
           return;
       } else if (!rdoMHC_Com1.isChecked() & !rdoMHC_Com2.isChecked() & !rdoMHC_Com3.isChecked() & secMHC_Com.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Select anyone options from (4.কম্পাউণ্ডার (Compounder)  ).");
           rdoMHC_Com1.requestFocus();
           return;
       } else if (!rdoMHC_Pha1.isChecked() & !rdoMHC_Pha2.isChecked() & !rdoMHC_Pha3.isChecked() & secMHC_Pha.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Select anyone options from (5.ঔষধ বিক্রেতা/ফার্মেসি (Drug seller/Pharmacy)  ).");
           rdoMHC_Pha1.requestFocus();
           return;
       } else if (!rdoMHC_Hompath1.isChecked() & !rdoMHC_Hompath2.isChecked() & !rdoMHC_Hompath3.isChecked() & secMHC_Hompath.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Select anyone options from (6.হোমিওপ্যাঁথ (Homeopath)  ).");
           rdoMHC_Hompath1.requestFocus();
           return;
       } else if (!rdoMHC_TrHeal1.isChecked() & !rdoMHC_TrHeal2.isChecked() & !rdoMHC_TrHeal3.isChecked() & secMHC_TrHeal.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Select anyone options from (7.কবিরাজ (Traditional care provider)  ).");
           rdoMHC_TrHeal1.requestFocus();
           return;
       } else if (!rdoMHC_SpiHeal1.isChecked() & !rdoMHC_SpiHeal2.isChecked() & !rdoMHC_SpiHeal3.isChecked() & secMHC_SpiHeal.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Select anyone options from (8.আধ্যাত্মিক চিকিৎসক (Spiritual healer) ).");
           rdoMHC_SpiHeal1.requestFocus();
           return;
       } else if (!rdoMHC_Oth1.isChecked() & !rdoMHC_Oth2.isChecked() & !rdoMHC_Oth3.isChecked() & secMHC_Oth.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Select anyone options from (9.অন্যান্য  (Other)).");
           rdoMHC_Oth1.requestFocus();
           return;
       } else if (txtMHC_OthName.getText().toString().length() == 0 & secMHC_OthName.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Required field: 10.অন্যান্য উল্লেখ করুন (Others Specify).");
           txtMHC_OthName.requestFocus();
           return;
       } else if (!rdoMDSHOPD1.isChecked() & !rdoMDSHOPD2.isChecked() & !rdoMDSHOPD3.isChecked() & secMDSHOPD.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Select anyone options from (শিশুটিকে কি ঢাকা শিশু হাসপাতালের বহির্বিভাগে (OPD) নেয়া হয়েছিল? (Was the child seen at outdoor patient department (OPD) of Dhaka Shishu Hospital?)).");
           rdoMDSHOPD1.requestFocus();
           return;
       } else if (!rdoMSSFOPD1.isChecked() & !rdoMSSFOPD2.isChecked() & !rdoMSSFOPD3.isChecked() & secMSSFOPD.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Select anyone options from (শিশুটিকে কি মিরপুর শিশুস্বাস্থ্য ফাউন্ন্ডেশন এর  বহির্বিভাগে (OPD) নেয়া হয়েছিল ? (Was the child seen at outdoor patient department (OPD) of Shishu Shastha Foundation-Mirpur?)).");
           rdoMSSFOPD1.requestFocus();
           return;
       } else if (!rdoMHosAdm1.isChecked() & !rdoMHosAdm2.isChecked() & !rdoMHosAdm3.isChecked() & secMHosAdm.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Select anyone options from (এই অসুস্থতার জন্য শিশুটিকে কি হাসপাতালে ভর্তি করা হয়েছিল? (During this episode of illness, was your child hospitalized?) ).");
           rdoMHosAdm1.requestFocus();
           return;
       } else if (spnMHC_Hosp_a1.getSelectedItemPosition() == 0 & secMHC_Hosp_a1.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Required field: 1..");
           spnMHC_Hosp_a1.requestFocus();
           return;
       } else if (txtMHC_Hosp_a1_Oth.getText().toString().length() == 0 & secMHC_Hosp_a1_Oth.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Required field: Name of the hospital-1.");
           txtMHC_Hosp_a1_Oth.requestFocus();
           return;
       }
//       else if (spnMHC_Hosp_a2.getSelectedItemPosition() == 0 & secMHC_Hosp_a2.isShown()) {
//           Connection.MessageBox(MeningitisCase.this, "Required field: 2..");
//           spnMHC_Hosp_a2.requestFocus();
//           return;
//       }
 else if (txtMHC_Hosp_a2_Oth.getText().toString().length() == 0 & secMHC_Hosp_a2_Oth.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Required field: Name of the hospital-2.");
           txtMHC_Hosp_a2_Oth.requestFocus();
           return;
       }
// else if (spnMHC_Hosp_a3.getSelectedItemPosition() == 0 & secMHC_Hosp_a3.isShown()) {
//           Connection.MessageBox(MeningitisCase.this, "Required field: 3..");
//           spnMHC_Hosp_a3.requestFocus();
//           return;
//       }
 else if (txtMHC_Hosp_a3_Oth.getText().toString().length() == 0 & secMHC_Hosp_a3_Oth.isShown()) {
           Connection.MessageBox(MeningitisCase.this, "Required field: Name of the hospital-3.");
           txtMHC_Hosp_a3_Oth.requestFocus();
           return;
       }
//       DV = Global.DateValidate(dtpMDtHos.getText().toString());
//       if (DV.length() != 0 & secMDtHos.isShown()) {
//           if (txtMHosM.getText().toString().length() == 0) {
//               Connection.MessageBox(MeningitisCase.this, DV);
//               dtpMDtHos.requestFocus();
//               return;
//           }

//       }
       else if (txtMHosM.getText().toString().length() == 0 & dtpMDtHos.getText().toString().length() == 0 & secMHosM.isShown())
       {
               Connection.MessageBox(MeningitisCase.this, "Required field: যদি ভর্তির তারিখ জানা না থাকে,  কত মাস আগে  (How much ago).");
               txtMHosM.requestFocus();
               return;

           }
           else if (Integer.valueOf(txtMHosM.getText().toString().length() == 0 ? "01" : txtMHosM.getText().toString()) < 01 || Integer.valueOf(txtMHosM.getText().toString().length() == 0 ? "18" : txtMHosM.getText().toString()) > 18) {
               Connection.MessageBox(MeningitisCase.this, "Value should be between 01 and 18(যদি ভর্তির তারিখ জানা না থাকে,  কত মাস আগে  (How much ago)).");
               txtMHosM.requestFocus();
               return;
           }
           else if (txtMDurIlBeHos.getText().toString().length() == 0 & secMDurIlBeHos.isShown()) {
               Connection.MessageBox(MeningitisCase.this, "Required field: হাসপাতালে ভর্তির আগে শিশুটি কতদিন অসুস্থ ছিল? (যদি জানা না থাকে 98 বসান) (For how many days did the child appear ill before he/she was hospitalized?).");
               txtMDurIlBeHos.requestFocus();
               return;
           } else if (Integer.valueOf(txtMDurIlBeHos.getText().toString().length() == 0 ? "01" : txtMDurIlBeHos.getText().toString()) < 01 || Integer.valueOf(txtMDurIlBeHos.getText().toString().length() == 0 ? "98" : txtMDurIlBeHos.getText().toString()) > 98) {
               Connection.MessageBox(MeningitisCase.this, "Value should be between 01 and 98(হাসপাতালে ভর্তির আগে শিশুটি কতদিন অসুস্থ ছিল? (যদি জানা না থাকে 98 বসান) (For how many days did the child appear ill before he/she was hospitalized?)).");
               txtMDurIlBeHos.requestFocus();
               return;
           } else if (spnMChildIlDr.getSelectedItemPosition() == 0 & secMChildIlDr.isShown()) {
               Connection.MessageBox(MeningitisCase.this, "Required field:  চিকিৎসকরা শিশুটির কি রোগ ছিল বলে আপনাদের বলেছিলেন?  (3.28 এর উত্তর “1” অথবা   3.31 এর উত্তর “1” হলে প্রযোজ্য) What illness did the doctors tell you that your child had?.");
               spnMChildIlDr.requestFocus();
               return;
           } else if (txtMChildIlDrOth.getText().toString().length() == 0 & secMChildIlDrOth.isShown()) {
               Connection.MessageBox(MeningitisCase.this, "Required field: অন্যান্য উল্লেখ করুন (Others Specify).");
               txtMChildIlDrOth.requestFocus();
               return;
           } else if (!rdoMReco1.isChecked() & !rdoMReco2.isChecked() & !rdoMReco3.isChecked() & secMReco.isShown()) {
               Connection.MessageBox(MeningitisCase.this, "Select anyone options from (আপনার শিশু কি সম্পূর্ণ সুস্থ হয়ে গিয়েছিল ? (Did the child recover completely?)).");
               rdoMReco1.requestFocus();
               return;
           } else if (txtMDurReco.getText().toString().length() == 0 & secMDurReco.isShown()) {

               Connection.MessageBox(MeningitisCase.this, "Required field: শিশুটি সুস্থ হতে কতদিন লেগেছিল? (যদি  জানা না থাকে 98) (How long did it take for the child to completely recover?).");
               txtMDurReco.requestFocus();
               return;
           } else if (Integer.valueOf(txtMDurReco.getText().toString().length() == 0 ? "01" : txtMDurReco.getText().toString()) < 01 || Integer.valueOf(txtMDurReco.getText().toString().length() == 0 ? "98" : txtMDurReco.getText().toString()) > 98) {
               Connection.MessageBox(MeningitisCase.this, "Value should be between 01 and 98(শিশুটি সুস্থ হতে কতদিন লেগেছিল? (যদি  জানা না থাকে 98) (How long did it take for the child to completely recover?)).");
               txtMDurReco.requestFocus();
               return;
           } else if (spnMInReco.getSelectedItemPosition() == 0 & secMInReco.isShown()) {
               Connection.MessageBox(MeningitisCase.this, "Required field: 1..");
               spnMInReco.requestFocus();
               return;
           } else if (txtMInRecoOth.getText().toString().length() == 0 & secMInRecoOth.isShown()) {
               Connection.MessageBox(MeningitisCase.this, "Required field: অন্যান্য উল্লেখ করুন (Others Specify).");
               txtMInRecoOth.requestFocus();
               return;
           }
//           else if (spnMInReco2.getSelectedItemPosition() == 0 & secMInReco2.isShown()) {
//               Connection.MessageBox(MeningitisCase.this, "Required field: 2..");
//               spnMInReco2.requestFocus();
//               return;
//           }
 else if (txtMInRecoOth2.getText().toString().length() == 0 & secMInRecoOth2.isShown()) {
               Connection.MessageBox(MeningitisCase.this, "Required field: অন্যান্য উল্লেখ করুন (Others Specify).");
               txtMInRecoOth2.requestFocus();
               return;
           }
// else if (spnMInReco3.getSelectedItemPosition() == 0 & secMInReco3.isShown()) {
//               Connection.MessageBox(MeningitisCase.this, "Required field: 3..");
//               spnMInReco3.requestFocus();
//               return;
//           }
 else if (txtMInRecoOth3.getText().toString().length() == 0 & secMInRecoOth3.isShown()) {
               Connection.MessageBox(MeningitisCase.this, "Required field: অন্যান্য উল্লেখ করুন (Others Specify).");
               txtMInRecoOth3.requestFocus();
               return;
           }
// else if (txtAboSeriIlOnset.getText().toString().length() == 0 & secAboSeriIlOnset.isShown()) {
//               Connection.MessageBox(MeningitisCase.this, "Required field: মন্তব্যঃ মেনিনজাইটিস  (Remarks: Meningitis).");
//               txtAboSeriIlOnset.requestFocus();
//               return;
//           }

           String SQL = "";
           RadioButton rb;

           MeningitisCase_DataModel objSave = new MeningitisCase_DataModel();
           objSave.setUNCode(txtUNCode.getText().toString());
           objSave.setStructureNo(txtStructureNo.getText().toString());
           objSave.setHouseholdSl(txtHouseholdSl.getText().toString());
           objSave.setVisitNo(txtVisitNo.getText().toString());
           objSave.setMemSl(txtMemSl.getText().toString());
           String[] d_rdogrpSeriIlOnset = new String[]{"1", "2", "8"};
           objSave.setSeriIlOnset(0);
           for (int i = 0; i < rdogrpSeriIlOnset.getChildCount(); i++) {
               rb = (RadioButton) rdogrpSeriIlOnset.getChildAt(i);
               if (rb.isChecked()) objSave.setSeriIlOnset(Integer.valueOf(d_rdogrpSeriIlOnset[i]));
           }

           String[] d_rdogrpSameIllSec2 = new String[]{"1", "2"};
           objSave.setSameIllSec2(0);
           for (int i = 0; i < rdogrpSameIllSec2.getChildCount(); i++) {
               rb = (RadioButton) rdogrpSameIllSec2.getChildAt(i);
               if (rb.isChecked()) objSave.setSameIllSec2(Integer.valueOf(d_rdogrpSameIllSec2[i]));
           }

           objSave.setEpiSeriIlOnset(Integer.valueOf(txtEpiSeriIlOnset.getText().toString().length() == 0 ? "0" : txtEpiSeriIlOnset.getText().toString()));
           objSave.setIlnessFev(Integer.valueOf(txtIlnessFev.getText().toString().length() == 0 ? "0" : txtIlnessFev.getText().toString()));
           String[] d_rdogrpIlnessConv = new String[]{"1", "2", "8"};
           objSave.setIlnessConv(0);
           for (int i = 0; i < rdogrpIlnessConv.getChildCount(); i++) {
               rb = (RadioButton) rdogrpIlnessConv.getChildAt(i);
               if (rb.isChecked()) objSave.setIlnessConv(Integer.valueOf(d_rdogrpIlnessConv[i]));
           }

           String[] d_rdogrpUpRolEye = new String[]{"1", "2", "8"};
           objSave.setUpRolEye(0);
           for (int i = 0; i < rdogrpUpRolEye.getChildCount(); i++) {
               rb = (RadioButton) rdogrpUpRolEye.getChildAt(i);
               if (rb.isChecked()) objSave.setUpRolEye(Integer.valueOf(d_rdogrpUpRolEye[i]));
           }

           String[] d_rdogrpMRigJaw = new String[]{"1", "2", "8"};
           objSave.setMRigJaw(0);
           for (int i = 0; i < rdogrpMRigJaw.getChildCount(); i++) {
               rb = (RadioButton) rdogrpMRigJaw.getChildAt(i);
               if (rb.isChecked()) objSave.setMRigJaw(Integer.valueOf(d_rdogrpMRigJaw[i]));
           }

           String[] d_rdogrpMRigLimbs = new String[]{"1", "2", "8"};
           objSave.setMRigLimbs(0);
           for (int i = 0; i < rdogrpMRigLimbs.getChildCount(); i++) {
               rb = (RadioButton) rdogrpMRigLimbs.getChildAt(i);
               if (rb.isChecked()) objSave.setMRigLimbs(Integer.valueOf(d_rdogrpMRigLimbs[i]));
           }

           String[] d_rdogrpMDurConv = new String[]{"1", "2", "3", "4", "8"};
           objSave.setMDurConv(0);
           for (int i = 0; i < rdogrpMDurConv.getChildCount(); i++) {
               rb = (RadioButton) rdogrpMDurConv.getChildAt(i);
               if (rb.isChecked()) objSave.setMDurConv(Integer.valueOf(d_rdogrpMDurConv[i]));
           }

           String[] d_rdogrpMDrowsin = new String[]{"1", "2", "8"};
           objSave.setMDrowsin(0);
           for (int i = 0; i < rdogrpMDrowsin.getChildCount(); i++) {
               rb = (RadioButton) rdogrpMDrowsin.getChildAt(i);
               if (rb.isChecked()) objSave.setMDrowsin(Integer.valueOf(d_rdogrpMDrowsin[i]));
           }

           objSave.setMDurDrowsin(Integer.valueOf(txtMDurDrowsin.getText().toString().length() == 0 ? "0" : txtMDurDrowsin.getText().toString()));
           objSave.setMUntoFeed(Integer.valueOf(spnMUntoFeed.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnMUntoFeed.getSelectedItem().toString(), "-")));
           objSave.setMDurUntoFeed(Integer.valueOf(txtMDurUntoFeed.getText().toString().length() == 0 ? "0" : txtMDurUntoFeed.getText().toString()));
           objSave.setMCalNoRes(Integer.valueOf(spnMCalNoRes.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnMCalNoRes.getSelectedItem().toString(), "-")));
           objSave.setMDurCalNoRes(Integer.valueOf(txtMDurCalNoRes.getText().toString().length() == 0 ? "0" : txtMDurCalNoRes.getText().toString()));
           objSave.setMEverConf(Integer.valueOf(spnMEverConf.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnMEverConf.getSelectedItem().toString(), "-")));
           objSave.setMDurEverConf(Integer.valueOf(spnMDurEverConf.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnMDurEverConf.getSelectedItem().toString(), "-")));
           String[] d_rdogrpMFlicker = new String[]{"1", "2", "8"};
           objSave.setMFlicker(0);
           for (int i = 0; i < rdogrpMFlicker.getChildCount(); i++) {
               rb = (RadioButton) rdogrpMFlicker.getChildAt(i);
               if (rb.isChecked()) objSave.setMFlicker(Integer.valueOf(d_rdogrpMFlicker[i]));
           }

           objSave.setMDurFliker(Integer.valueOf(spnMDurFliker.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnMDurFliker.getSelectedItem().toString(), "-")));
           String[] d_rdogrpMUnconsci = new String[]{"1", "2", "8"};
           objSave.setMUnconsci(0);
           for (int i = 0; i < rdogrpMUnconsci.getChildCount(); i++) {
               rb = (RadioButton) rdogrpMUnconsci.getChildAt(i);
               if (rb.isChecked()) objSave.setMUnconsci(Integer.valueOf(d_rdogrpMUnconsci[i]));
           }

           objSave.setMDurUnconsci(Integer.valueOf(spnMDurUnconsci.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnMDurUnconsci.getSelectedItem().toString(), "-")));
           String[] d_rdogrpMIlCry = new String[]{"1", "2", "8"};
           objSave.setMIlCry(0);
           for (int i = 0; i < rdogrpMIlCry.getChildCount(); i++) {
               rb = (RadioButton) rdogrpMIlCry.getChildAt(i);
               if (rb.isChecked()) objSave.setMIlCry(Integer.valueOf(d_rdogrpMIlCry[i]));
           }

           objSave.setMDurIlCry(Integer.valueOf(spnMDurIlCry.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnMDurIlCry.getSelectedItem().toString(), "-")));
           objSave.setMUnCraWalk(Integer.valueOf(spnMUnCraWalk.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnMUnCraWalk.getSelectedItem().toString(), "-")));
           objSave.setMDurUnCraWalk(Integer.valueOf(spnMDurUnCraWalk.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnMDurUnCraWalk.getSelectedItem().toString(), "-")));
           String[] d_rdogrpMDifBreath = new String[]{"1", "2", "8"};
           objSave.setMDifBreath(0);
           for (int i = 0; i < rdogrpMDifBreath.getChildCount(); i++) {
               rb = (RadioButton) rdogrpMDifBreath.getChildAt(i);
               if (rb.isChecked()) objSave.setMDifBreath(Integer.valueOf(d_rdogrpMDifBreath[i]));
           }

           String[] d_rdogrpMCough = new String[]{"1", "2", "8"};
           objSave.setMCough(0);
           for (int i = 0; i < rdogrpMCough.getChildCount(); i++) {
               rb = (RadioButton) rdogrpMCough.getChildAt(i);
               if (rb.isChecked()) objSave.setMCough(Integer.valueOf(d_rdogrpMCough[i]));
           }

           String[] d_rdogrpMRash = new String[]{"1", "2", "8"};
           objSave.setMRash(0);
           for (int i = 0; i < rdogrpMRash.getChildCount(); i++) {
               rb = (RadioButton) rdogrpMRash.getChildAt(i);
               if (rb.isChecked()) objSave.setMRash(Integer.valueOf(d_rdogrpMRash[i]));
           }

           String[] d_rdogrpMVomit = new String[]{"1", "2", "8"};
           objSave.setMVomit(0);
           for (int i = 0; i < rdogrpMVomit.getChildCount(); i++) {
               rb = (RadioButton) rdogrpMVomit.getChildAt(i);
               if (rb.isChecked()) objSave.setMVomit(Integer.valueOf(d_rdogrpMVomit[i]));
           }

           String[] d_rdogrpMDiarrhoea = new String[]{"1", "2", "8"};
           objSave.setMDiarrhoea(0);
           for (int i = 0; i < rdogrpMDiarrhoea.getChildCount(); i++) {
               rb = (RadioButton) rdogrpMDiarrhoea.getChildAt(i);
               if (rb.isChecked()) objSave.setMDiarrhoea(Integer.valueOf(d_rdogrpMDiarrhoea[i]));
           }

           String[] d_rdogrpMHCar = new String[]{"1", "2", "8"};
           objSave.setMHCar(0);
           for (int i = 0; i < rdogrpMHCar.getChildCount(); i++) {
               rb = (RadioButton) rdogrpMHCar.getChildAt(i);
               if (rb.isChecked()) objSave.setMHCar(Integer.valueOf(d_rdogrpMHCar[i]));
           }

           String[] d_rdogrpMHC_Phy = new String[]{"1", "2", "8"};
           objSave.setMHC_Phy(0);
           for (int i = 0; i < rdogrpMHC_Phy.getChildCount(); i++) {
               rb = (RadioButton) rdogrpMHC_Phy.getChildAt(i);
               if (rb.isChecked()) objSave.setMHC_Phy(Integer.valueOf(d_rdogrpMHC_Phy[i]));
           }

           String[] d_rdogrpMHC_UnquaDoctor = new String[]{"1", "2", "8"};
           objSave.setMHC_UnquaDoctor(0);
           for (int i = 0; i < rdogrpMHC_UnquaDoctor.getChildCount(); i++) {
               rb = (RadioButton) rdogrpMHC_UnquaDoctor.getChildAt(i);
               if (rb.isChecked())
                   objSave.setMHC_UnquaDoctor(Integer.valueOf(d_rdogrpMHC_UnquaDoctor[i]));
           }

           String[] d_rdogrpMHC_Para = new String[]{"1", "2", "8"};
           objSave.setMHC_Para(0);
           for (int i = 0; i < rdogrpMHC_Para.getChildCount(); i++) {
               rb = (RadioButton) rdogrpMHC_Para.getChildAt(i);
               if (rb.isChecked()) objSave.setMHC_Para(Integer.valueOf(d_rdogrpMHC_Para[i]));
           }

           String[] d_rdogrpMHC_Com = new String[]{"1", "2", "8"};
           objSave.setMHC_Com(0);
           for (int i = 0; i < rdogrpMHC_Com.getChildCount(); i++) {
               rb = (RadioButton) rdogrpMHC_Com.getChildAt(i);
               if (rb.isChecked()) objSave.setMHC_Com(Integer.valueOf(d_rdogrpMHC_Com[i]));
           }

           String[] d_rdogrpMHC_Pha = new String[]{"1", "2", "8"};
           objSave.setMHC_Pha(0);
           for (int i = 0; i < rdogrpMHC_Pha.getChildCount(); i++) {
               rb = (RadioButton) rdogrpMHC_Pha.getChildAt(i);
               if (rb.isChecked()) objSave.setMHC_Pha(Integer.valueOf(d_rdogrpMHC_Pha[i]));
           }

           String[] d_rdogrpMHC_Hompath = new String[]{"1", "2", "8"};
           objSave.setMHC_Hompath(0);
           for (int i = 0; i < rdogrpMHC_Hompath.getChildCount(); i++) {
               rb = (RadioButton) rdogrpMHC_Hompath.getChildAt(i);
               if (rb.isChecked()) objSave.setMHC_Hompath(Integer.valueOf(d_rdogrpMHC_Hompath[i]));
           }

           String[] d_rdogrpMHC_TrHeal = new String[]{"1", "2", "8"};
           objSave.setMHC_TrHeal(0);
           for (int i = 0; i < rdogrpMHC_TrHeal.getChildCount(); i++) {
               rb = (RadioButton) rdogrpMHC_TrHeal.getChildAt(i);
               if (rb.isChecked()) objSave.setMHC_TrHeal(Integer.valueOf(d_rdogrpMHC_TrHeal[i]));
           }

           String[] d_rdogrpMHC_SpiHeal = new String[]{"1", "2", "8"};
           objSave.setMHC_SpiHeal(0);
           for (int i = 0; i < rdogrpMHC_SpiHeal.getChildCount(); i++) {
               rb = (RadioButton) rdogrpMHC_SpiHeal.getChildAt(i);
               if (rb.isChecked()) objSave.setMHC_SpiHeal(Integer.valueOf(d_rdogrpMHC_SpiHeal[i]));
           }

           String[] d_rdogrpMHC_Oth = new String[]{"1", "2", "8"};
           objSave.setMHC_Oth(0);
           for (int i = 0; i < rdogrpMHC_Oth.getChildCount(); i++) {
               rb = (RadioButton) rdogrpMHC_Oth.getChildAt(i);
               if (rb.isChecked()) objSave.setMHC_Oth(Integer.valueOf(d_rdogrpMHC_Oth[i]));
           }

           objSave.setMHC_OthName(txtMHC_OthName.getText().toString());
           String[] d_rdogrpMDSHOPD = new String[]{"1", "2", "8"};
           objSave.setMDSHOPD(0);
           for (int i = 0; i < rdogrpMDSHOPD.getChildCount(); i++) {
               rb = (RadioButton) rdogrpMDSHOPD.getChildAt(i);
               if (rb.isChecked()) objSave.setMDSHOPD(Integer.valueOf(d_rdogrpMDSHOPD[i]));
           }

           String[] d_rdogrpMSSFOPD = new String[]{"1", "2", "8"};
           objSave.setMSSFOPD(0);
           for (int i = 0; i < rdogrpMSSFOPD.getChildCount(); i++) {
               rb = (RadioButton) rdogrpMSSFOPD.getChildAt(i);
               if (rb.isChecked()) objSave.setMSSFOPD(Integer.valueOf(d_rdogrpMSSFOPD[i]));
           }

           String[] d_rdogrpMHosAdm = new String[]{"1", "2", "8"};
           objSave.setMHosAdm(0);
           for (int i = 0; i < rdogrpMHosAdm.getChildCount(); i++) {
               rb = (RadioButton) rdogrpMHosAdm.getChildAt(i);
               if (rb.isChecked()) objSave.setMHosAdm(Integer.valueOf(d_rdogrpMHosAdm[i]));
           }

           objSave.setMHC_Hosp_a1(Integer.valueOf(spnMHC_Hosp_a1.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnMHC_Hosp_a1.getSelectedItem().toString(), "-")));
           objSave.setMHC_Hosp_a1_Oth(txtMHC_Hosp_a1_Oth.getText().toString());
           objSave.setMHC_Hosp_a2(Integer.valueOf(spnMHC_Hosp_a2.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnMHC_Hosp_a2.getSelectedItem().toString(), "-")));
           objSave.setMHC_Hosp_a2_Oth(txtMHC_Hosp_a2_Oth.getText().toString());
           objSave.setMHC_Hosp_a3(Integer.valueOf(spnMHC_Hosp_a3.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnMHC_Hosp_a3.getSelectedItem().toString(), "-")));
           objSave.setMHC_Hosp_a3_Oth(txtMHC_Hosp_a3_Oth.getText().toString());
           objSave.setMDtHos(dtpMDtHos.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpMDtHos.getText().toString()) : dtpMDtHos.getText().toString());
           objSave.setMHosM(Integer.valueOf(txtMHosM.getText().toString().length() == 0 ? "0" : txtMHosM.getText().toString()));
           objSave.setMDurIlBeHos(Integer.valueOf(txtMDurIlBeHos.getText().toString().length() == 0 ? "0" : txtMDurIlBeHos.getText().toString()));
           objSave.setMChildIlDr(Integer.valueOf(spnMChildIlDr.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnMChildIlDr.getSelectedItem().toString(), "-")));
           objSave.setMChildIlDrOth(txtMChildIlDrOth.getText().toString());
           String[] d_rdogrpMReco = new String[]{"1", "2", "8"};
           objSave.setMReco(0);
           for (int i = 0; i < rdogrpMReco.getChildCount(); i++) {
               rb = (RadioButton) rdogrpMReco.getChildAt(i);
               if (rb.isChecked()) objSave.setMReco(Integer.valueOf(d_rdogrpMReco[i]));
           }

           objSave.setMDurReco(Integer.valueOf(txtMDurReco.getText().toString().length() == 0 ? "0" : txtMDurReco.getText().toString()));
           objSave.setMInReco(Integer.valueOf(spnMInReco.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnMInReco.getSelectedItem().toString(), "-")));
           objSave.setMInRecoOth(txtMInRecoOth.getText().toString());
           objSave.setMInReco2(Integer.valueOf(spnMInReco2.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnMInReco2.getSelectedItem().toString(), "-")));
           objSave.setMInRecoOth2(txtMInRecoOth2.getText().toString());
           objSave.setMInReco3(Integer.valueOf(spnMInReco3.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnMInReco3.getSelectedItem().toString(), "-")));
           objSave.setMInRecoOth3(txtMInRecoOth3.getText().toString());
           objSave.setAboSeriIlOnset(txtAboSeriIlOnset.getText().toString());
           objSave.setEnDt(Global.DateTimeNowYMDHMS());
           objSave.setStartTime(STARTTIME);
           objSave.setEndTime(g.CurrentTime24());
           objSave.setDeviceID(DEVICEID);
           objSave.setEntryUser(ENTRYUSER); //from data entry user list
           objSave.setmodifyDate(Global.DateTimeNowYMDHMS());
           //objSave.setLat(Double.toString(currentLatitude));
           //objSave.setLon(Double.toString(currentLongitude));

           String status = objSave.SaveUpdateData(this);
           if (status.length() == 0) {
               Intent returnIntent = new Intent();
               returnIntent.putExtra("res", "");
               setResult(Activity.RESULT_OK, returnIntent);

               Connection.MessageBox(MeningitisCase.this, "Saved Successfully");



           } else {
               Connection.MessageBox(MeningitisCase.this, status);
               return;
           }
       }

     catch(Exception e)
     {
         Connection.MessageBox(MeningitisCase.this, e.getMessage());
         return;
     }
 }

 private void DataSearch(String UNCode, String StructureNo, String HouseholdSl, String VisitNo, String MemSl)
     {
       try
        {
     
           RadioButton rb;
           MeningitisCase_DataModel d = new MeningitisCase_DataModel();
           String SQL = "Select * from "+ TableName +"  Where UNCode='"+ UNCode +"' and StructureNo='"+ StructureNo +"' and HouseholdSl='"+ HouseholdSl +"' and VisitNo='"+ VisitNo +"' and MemSl='"+ MemSl +"'";
           List<MeningitisCase_DataModel> data = d.SelectAll(this, SQL);
           for(MeningitisCase_DataModel item : data){
             txtUNCode.setText(item.getUNCode());
             txtStructureNo.setText(item.getStructureNo());
             txtHouseholdSl.setText(item.getHouseholdSl());
             txtVisitNo.setText(item.getVisitNo());
             txtMemSl.setText(item.getMemSl());
             String[] d_rdogrpSeriIlOnset = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpSeriIlOnset.length; i++)
             {
                 if (String.valueOf(item.getSeriIlOnset()).equals(String.valueOf(d_rdogrpSeriIlOnset[i])))
                 {
                     rb = (RadioButton)rdogrpSeriIlOnset.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpSameIllSec2 = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpSameIllSec2.length; i++)
             {
                 if (String.valueOf(item.getSameIllSec2()).equals(String.valueOf(d_rdogrpSameIllSec2[i])))
                 {
                     rb = (RadioButton)rdogrpSameIllSec2.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtEpiSeriIlOnset.setText(String.valueOf(item.getEpiSeriIlOnset()));
             txtIlnessFev.setText(String.valueOf(item.getIlnessFev()));
             String[] d_rdogrpIlnessConv = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpIlnessConv.length; i++)
             {
                 if (String.valueOf(item.getIlnessConv()).equals(String.valueOf(d_rdogrpIlnessConv[i])))
                 {
                     rb = (RadioButton)rdogrpIlnessConv.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpUpRolEye = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpUpRolEye.length; i++)
             {
                 if (String.valueOf(item.getUpRolEye()).equals(String.valueOf(d_rdogrpUpRolEye[i])))
                 {
                     rb = (RadioButton)rdogrpUpRolEye.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpMRigJaw = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpMRigJaw.length; i++)
             {
                 if (String.valueOf(item.getMRigJaw()).equals(String.valueOf(d_rdogrpMRigJaw[i])))
                 {
                     rb = (RadioButton)rdogrpMRigJaw.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpMRigLimbs = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpMRigLimbs.length; i++)
             {
                 if (String.valueOf(item.getMRigLimbs()).equals(String.valueOf(d_rdogrpMRigLimbs[i])))
                 {
                     rb = (RadioButton)rdogrpMRigLimbs.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpMDurConv = new String[] {"1","2","3","4","8"};
             for (int i = 0; i < d_rdogrpMDurConv.length; i++)
             {
                 if (String.valueOf(item.getMDurConv()).equals(String.valueOf(d_rdogrpMDurConv[i])))
                 {
                     rb = (RadioButton)rdogrpMDurConv.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpMDrowsin = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpMDrowsin.length; i++)
             {
                 if (String.valueOf(item.getMDrowsin()).equals(String.valueOf(d_rdogrpMDrowsin[i])))
                 {
                     rb = (RadioButton)rdogrpMDrowsin.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtMDurDrowsin.setText(String.valueOf(item.getMDurDrowsin()));
             spnMUntoFeed.setSelection(Global.SpinnerItemPositionAnyLength(spnMUntoFeed, String.valueOf(item.getMUntoFeed())));
             txtMDurUntoFeed.setText(String.valueOf(item.getMDurUntoFeed()));
             spnMCalNoRes.setSelection(Global.SpinnerItemPositionAnyLength(spnMCalNoRes, String.valueOf(item.getMCalNoRes())));
             txtMDurCalNoRes.setText(String.valueOf(item.getMDurCalNoRes()));
             spnMEverConf.setSelection(Global.SpinnerItemPositionAnyLength(spnMEverConf, String.valueOf(item.getMEverConf())));
             spnMDurEverConf.setSelection(Global.SpinnerItemPositionAnyLength(spnMDurEverConf, String.valueOf(item.getMDurEverConf())));
             String[] d_rdogrpMFlicker = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpMFlicker.length; i++)
             {
                 if (String.valueOf(item.getMFlicker()).equals(String.valueOf(d_rdogrpMFlicker[i])))
                 {
                     rb = (RadioButton)rdogrpMFlicker.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             spnMDurFliker.setSelection(Global.SpinnerItemPositionAnyLength(spnMDurFliker, String.valueOf(item.getMDurFliker())));
             String[] d_rdogrpMUnconsci = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpMUnconsci.length; i++)
             {
                 if (String.valueOf(item.getMUnconsci()).equals(String.valueOf(d_rdogrpMUnconsci[i])))
                 {
                     rb = (RadioButton)rdogrpMUnconsci.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             spnMDurUnconsci.setSelection(Global.SpinnerItemPositionAnyLength(spnMDurUnconsci, String.valueOf(item.getMDurUnconsci())));
             String[] d_rdogrpMIlCry = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpMIlCry.length; i++)
             {
                 if (String.valueOf(item.getMIlCry()).equals(String.valueOf(d_rdogrpMIlCry[i])))
                 {
                     rb = (RadioButton)rdogrpMIlCry.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             spnMDurIlCry.setSelection(Global.SpinnerItemPositionAnyLength(spnMDurIlCry, String.valueOf(item.getMDurIlCry())));
             spnMUnCraWalk.setSelection(Global.SpinnerItemPositionAnyLength(spnMUnCraWalk, String.valueOf(item.getMUnCraWalk())));
             spnMDurUnCraWalk.setSelection(Global.SpinnerItemPositionAnyLength(spnMDurUnCraWalk, String.valueOf(item.getMDurUnCraWalk())));
             String[] d_rdogrpMDifBreath = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpMDifBreath.length; i++)
             {
                 if (String.valueOf(item.getMDifBreath()).equals(String.valueOf(d_rdogrpMDifBreath[i])))
                 {
                     rb = (RadioButton)rdogrpMDifBreath.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpMCough = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpMCough.length; i++)
             {
                 if (String.valueOf(item.getMCough()).equals(String.valueOf(d_rdogrpMCough[i])))
                 {
                     rb = (RadioButton)rdogrpMCough.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpMRash = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpMRash.length; i++)
             {
                 if (String.valueOf(item.getMRash()).equals(String.valueOf(d_rdogrpMRash[i])))
                 {
                     rb = (RadioButton)rdogrpMRash.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpMVomit = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpMVomit.length; i++)
             {
                 if (String.valueOf(item.getMVomit()).equals(String.valueOf(d_rdogrpMVomit[i])))
                 {
                     rb = (RadioButton)rdogrpMVomit.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpMDiarrhoea = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpMDiarrhoea.length; i++)
             {
                 if (String.valueOf(item.getMDiarrhoea()).equals(String.valueOf(d_rdogrpMDiarrhoea[i])))
                 {
                     rb = (RadioButton)rdogrpMDiarrhoea.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpMHCar = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpMHCar.length; i++)
             {
                 if (String.valueOf(item.getMHCar()).equals(String.valueOf(d_rdogrpMHCar[i])))
                 {
                     rb = (RadioButton)rdogrpMHCar.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpMHC_Phy = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpMHC_Phy.length; i++)
             {
                 if (String.valueOf(item.getMHC_Phy()).equals(String.valueOf(d_rdogrpMHC_Phy[i])))
                 {
                     rb = (RadioButton)rdogrpMHC_Phy.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpMHC_UnquaDoctor = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpMHC_UnquaDoctor.length; i++)
             {
                 if (String.valueOf(item.getMHC_UnquaDoctor()).equals(String.valueOf(d_rdogrpMHC_UnquaDoctor[i])))
                 {
                     rb = (RadioButton)rdogrpMHC_UnquaDoctor.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpMHC_Para = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpMHC_Para.length; i++)
             {
                 if (String.valueOf(item.getMHC_Para()).equals(String.valueOf(d_rdogrpMHC_Para[i])))
                 {
                     rb = (RadioButton)rdogrpMHC_Para.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpMHC_Com = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpMHC_Com.length; i++)
             {
                 if (String.valueOf(item.getMHC_Com()).equals(String.valueOf(d_rdogrpMHC_Com[i])))
                 {
                     rb = (RadioButton)rdogrpMHC_Com.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpMHC_Pha = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpMHC_Pha.length; i++)
             {
                 if (String.valueOf(item.getMHC_Pha()).equals(String.valueOf(d_rdogrpMHC_Pha[i])))
                 {
                     rb = (RadioButton)rdogrpMHC_Pha.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpMHC_Hompath = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpMHC_Hompath.length; i++)
             {
                 if (String.valueOf(item.getMHC_Hompath()).equals(String.valueOf(d_rdogrpMHC_Hompath[i])))
                 {
                     rb = (RadioButton)rdogrpMHC_Hompath.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpMHC_TrHeal = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpMHC_TrHeal.length; i++)
             {
                 if (String.valueOf(item.getMHC_TrHeal()).equals(String.valueOf(d_rdogrpMHC_TrHeal[i])))
                 {
                     rb = (RadioButton)rdogrpMHC_TrHeal.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpMHC_SpiHeal = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpMHC_SpiHeal.length; i++)
             {
                 if (String.valueOf(item.getMHC_SpiHeal()).equals(String.valueOf(d_rdogrpMHC_SpiHeal[i])))
                 {
                     rb = (RadioButton)rdogrpMHC_SpiHeal.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpMHC_Oth = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpMHC_Oth.length; i++)
             {
                 if (String.valueOf(item.getMHC_Oth()).equals(String.valueOf(d_rdogrpMHC_Oth[i])))
                 {
                     rb = (RadioButton)rdogrpMHC_Oth.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtMHC_OthName.setText(item.getMHC_OthName());
             String[] d_rdogrpMDSHOPD = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpMDSHOPD.length; i++)
             {
                 if (String.valueOf(item.getMDSHOPD()).equals(String.valueOf(d_rdogrpMDSHOPD[i])))
                 {
                     rb = (RadioButton)rdogrpMDSHOPD.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpMSSFOPD = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpMSSFOPD.length; i++)
             {
                 if (String.valueOf(item.getMSSFOPD()).equals(String.valueOf(d_rdogrpMSSFOPD[i])))
                 {
                     rb = (RadioButton)rdogrpMSSFOPD.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpMHosAdm = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpMHosAdm.length; i++)
             {
                 if (String.valueOf(item.getMHosAdm()).equals(String.valueOf(d_rdogrpMHosAdm[i])))
                 {
                     rb = (RadioButton)rdogrpMHosAdm.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             spnMHC_Hosp_a1.setSelection(Global.SpinnerItemPositionAnyLength(spnMHC_Hosp_a1, String.valueOf(item.getMHC_Hosp_a1())));
             txtMHC_Hosp_a1_Oth.setText(item.getMHC_Hosp_a1_Oth());
             spnMHC_Hosp_a2.setSelection(Global.SpinnerItemPositionAnyLength(spnMHC_Hosp_a2, String.valueOf(item.getMHC_Hosp_a2())));
             txtMHC_Hosp_a2_Oth.setText(item.getMHC_Hosp_a2_Oth());
             spnMHC_Hosp_a3.setSelection(Global.SpinnerItemPositionAnyLength(spnMHC_Hosp_a3, String.valueOf(item.getMHC_Hosp_a3())));
             txtMHC_Hosp_a3_Oth.setText(item.getMHC_Hosp_a3_Oth());
             dtpMDtHos.setText(item.getMDtHos().toString().length()==0 ? "" : Global.DateConvertDMY(item.getMDtHos()));
             txtMHosM.setText(item.getMHosM()==0?"" : String.valueOf(item.getMHosM()));
             txtMDurIlBeHos.setText(String.valueOf(item.getMDurIlBeHos()));
             spnMChildIlDr.setSelection(Global.SpinnerItemPositionAnyLength(spnMChildIlDr, String.valueOf(item.getMChildIlDr())));
             txtMChildIlDrOth.setText(item.getMChildIlDrOth());
             String[] d_rdogrpMReco = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpMReco.length; i++)
             {
                 if (String.valueOf(item.getMReco()).equals(String.valueOf(d_rdogrpMReco[i])))
                 {
                     rb = (RadioButton)rdogrpMReco.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtMDurReco.setText(String.valueOf(item.getMDurReco()));
             spnMInReco.setSelection(Global.SpinnerItemPositionAnyLength(spnMInReco, String.valueOf(item.getMInReco())));
             txtMInRecoOth.setText(item.getMInRecoOth());
             spnMInReco2.setSelection(Global.SpinnerItemPositionAnyLength(spnMInReco2, String.valueOf(item.getMInReco2())));
             txtMInRecoOth2.setText(item.getMInRecoOth2());
             spnMInReco3.setSelection(Global.SpinnerItemPositionAnyLength(spnMInReco3, String.valueOf(item.getMInReco3())));
             txtMInRecoOth3.setText(item.getMInRecoOth3());
             txtAboSeriIlOnset.setText(item.getAboSeriIlOnset());
           }
        }
        catch(Exception  e)
        {
            Connection.MessageBox(MeningitisCase.this, e.getMessage());
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


              dtpDate = (EditText)findViewById(R.id.dtpMDtHos);
             if (VariableID.equals("btnMDtHos"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpMDtHos);
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