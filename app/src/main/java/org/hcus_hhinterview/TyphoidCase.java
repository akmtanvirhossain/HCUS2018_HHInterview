
 package org.hcus_hhinterview;


 //Android Manifest Code
 //<activity android:name=".TyphoidCase" android:label="TyphoidCase" />
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
 import android.view.ContextMenu;
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
 import data_model.TyphoidCase_DataModel;

 public class TyphoidCase extends Activity {
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
         LinearLayout secHaveFever;
         View lineHaveFever;
         TextView VlblHaveFever;
         RadioGroup rdogrpHaveFever;
         
         RadioButton rdoHaveFever1;
         RadioButton rdoHaveFever2;
         RadioButton rdoHaveFever3;
         LinearLayout secTsymptLabel;
         View lineTsymptLabel;
         LinearLayout secAbdomPain;
         View lineAbdomPain;
         TextView VlblAbdomPain;
         RadioGroup rdogrpAbdomPain;
         
         RadioButton rdoAbdomPain1;
         RadioButton rdoAbdomPain2;
         LinearLayout secConstipation;
         View lineConstipation;
         TextView VlblConstipation;
         RadioGroup rdogrpConstipation;
         
         RadioButton rdoConstipation1;
         RadioButton rdoConstipation2;
         LinearLayout secHeadache;
         View lineHeadache;
         TextView VlblHeadache;
         RadioGroup rdogrpHeadache;
         
         RadioButton rdoHeadache1;
         RadioButton rdoHeadache2;
         LinearLayout secRash;
         View lineRash;
         TextView VlblRash;
         RadioGroup rdogrpRash;
         
         RadioButton rdoRash1;
         RadioButton rdoRash2;
         LinearLayout secDiarrhoea;
         View lineDiarrhoea;
         TextView VlblDiarrhoea;
         RadioGroup rdogrpDiarrhoea;
         
         RadioButton rdoDiarrhoea1;
         RadioButton rdoDiarrhoea2;
         LinearLayout secAbdomDist;
         View lineAbdomDist;
         TextView VlblAbdomDist;
         RadioGroup rdogrpAbdomDist;
         
         RadioButton rdoAbdomDist1;
         RadioButton rdoAbdomDist2;
         LinearLayout secCoaTon;
         View lineCoaTon;
         TextView VlblCoaTon;
         RadioGroup rdogrpCoaTon;
         
         RadioButton rdoCoaTon1;
         RadioButton rdoCoaTon2;
         LinearLayout secCough;
         View lineCough;
         TextView VlblCough;
         RadioGroup rdogrpCough;
         
         RadioButton rdoCough1;
         RadioButton rdoCough2;
         LinearLayout secTnone;
         View lineTnone;
         TextView VlblTnone;
         RadioGroup rdogrpTnone;
         
         RadioButton rdoTnone1;
         RadioButton rdoTnone2;
         LinearLayout secOther;
         View lineOther;
         TextView VlblOther;
         RadioGroup rdogrpOther;
         
         RadioButton rdoOther1;
         RadioButton rdoOther2;
         LinearLayout secTsymptOthName;
         View lineTsymptOthName;
         TextView VlblTsymptOthName;
         EditText txtTsymptOthName;
         LinearLayout secTakenHCFacility;
         View lineTakenHCFacility;
         TextView VlblTakenHCFacility;
         RadioGroup rdogrpTakenHCFacility;
         
         RadioButton rdoTakenHCFacility1;
         RadioButton rdoTakenHCFacility2;
         RadioButton rdoTakenHCFacility3;
         LinearLayout secTHCarTypLabel;
         View lineTHCarTypLabel;
         LinearLayout secHC_PhyMBBS;
         View lineHC_PhyMBBS;
         TextView VlblHC_PhyMBBS;
         RadioGroup rdogrpHC_PhyMBBS;
         
         RadioButton rdoHC_PhyMBBS1;
         RadioButton rdoHC_PhyMBBS2;
         RadioButton rdoHC_PhyMBBS3;
         RadioButton rdoHC_PhyMBBS4;
         LinearLayout secHC_UnquaDoctor;
         View lineHC_UnquaDoctor;
         TextView VlblHC_UnquaDoctor;
         RadioGroup rdogrpHC_UnquaDoctor;
         
         RadioButton rdoHC_UnquaDoctor1;
         RadioButton rdoHC_UnquaDoctor2;
         RadioButton rdoHC_UnquaDoctor3;
         LinearLayout secHC_Para;
         View lineHC_Para;
         TextView VlblHC_Para;
         RadioGroup rdogrpHC_Para;
         
         RadioButton rdoHC_Para1;
         RadioButton rdoHC_Para2;
         RadioButton rdoHC_Para3;
         RadioButton rdoHC_Para4;
         LinearLayout secHC_Com;
         View lineHC_Com;
         TextView VlblHC_Com;
         RadioGroup rdogrpHC_Com;
         
         RadioButton rdoHC_Com1;
         RadioButton rdoHC_Com2;
         RadioButton rdoHC_Com3;
         RadioButton rdoHC_Com4;
         LinearLayout secHC_Pha;
         View lineHC_Pha;
         TextView VlblHC_Pha;
         RadioGroup rdogrpHC_Pha;
         
         RadioButton rdoHC_Pha1;
         RadioButton rdoHC_Pha2;
         RadioButton rdoHC_Pha3;
         RadioButton rdoHC_Pha4;
         LinearLayout secHC_Hompath;
         View lineHC_Hompath;
         TextView VlblHC_Hompath;
         RadioGroup rdogrpHC_Hompath;
         
         RadioButton rdoHC_Hompath1;
         RadioButton rdoHC_Hompath2;
         RadioButton rdoHC_Hompath3;
         LinearLayout secHC_TrHeal;
         View lineHC_TrHeal;
         TextView VlblHC_TrHeal;
         RadioGroup rdogrpHC_TrHeal;
         
         RadioButton rdoHC_TrHeal1;
         RadioButton rdoHC_TrHeal2;
         RadioButton rdoHC_TrHeal3;
         RadioButton rdoHC_TrHeal4;
         LinearLayout secHC_SpiHeal;
         View lineHC_SpiHeal;
         TextView VlblHC_SpiHeal;
         RadioGroup rdogrpHC_SpiHeal;
         
         RadioButton rdoHC_SpiHeal1;
         RadioButton rdoHC_SpiHeal2;
         RadioButton rdoHC_SpiHeal3;
         LinearLayout secTHC_Oth;
         View lineTHC_Oth;
         TextView VlblTHC_Oth;
         RadioGroup rdogrpTHC_Oth;
         
         RadioButton rdoTHC_Oth1;
         RadioButton rdoTHC_Oth2;
         RadioButton rdoTHC_Oth3;
         RadioButton rdoTHC_Oth4;
         LinearLayout secTHC_OthName;
         View lineTHC_OthName;
         TextView VlblTHC_OthName;
         EditText txtTHC_OthName;
         LinearLayout secHC_Hosp;
         View lineHC_Hosp;
         TextView VlblHC_Hosp;
         RadioGroup rdogrpHC_Hosp;
         
         RadioButton rdoHC_Hosp1;
         RadioButton rdoHC_Hosp2;
         RadioButton rdoHC_Hosp3;
         LinearLayout secHC_HospLabel;
         View lineHC_HospLabel;
         LinearLayout secHC_Hosp_a1;
         View lineHC_Hosp_a1;
         TextView VlblHC_Hosp_a1;
         Spinner spnHC_Hosp_a1;
         LinearLayout secHC_Hosp_a1_Oth;
         View lineHC_Hosp_a1_Oth;
         TextView VlblHC_Hosp_a1_Oth;
         EditText txtHC_Hosp_a1_Oth;
         LinearLayout secHC_Hosp_a2;
         View lineHC_Hosp_a2;
         TextView VlblHC_Hosp_a2;
         Spinner spnHC_Hosp_a2;
         LinearLayout secHC_Hosp_a2_Oth;
         View lineHC_Hosp_a2_Oth;
         TextView VlblHC_Hosp_a2_Oth;
         EditText txtHC_Hosp_a2_Oth;
         LinearLayout secHC_Hosp_a3;
         View lineHC_Hosp_a3;
         TextView VlblHC_Hosp_a3;
         Spinner spnHC_Hosp_a3;
         LinearLayout secHC_Hosp_a3_Oth;
         View lineHC_Hosp_a3_Oth;
         TextView VlblHC_Hosp_a3_Oth;
         EditText txtHC_Hosp_a3_Oth;
         LinearLayout secHC_Hosp_a4;
         View lineHC_Hosp_a4;
         TextView VlblHC_Hosp_a4;
         Spinner spnHC_Hosp_a4;
         LinearLayout secHC_Hosp_a4_Oth;
         View lineHC_Hosp_a4_Oth;
         TextView VlblHC_Hosp_a4_Oth;
         EditText txtHC_Hosp_a4_Oth;
         LinearLayout secHC_Hosp_a5;
         View lineHC_Hosp_a5;
         TextView VlblHC_Hosp_a5;
         Spinner spnHC_Hosp_a5;
         LinearLayout secHC_Hosp_a5_Oth;
         View lineHC_Hosp_a5_Oth;
         TextView VlblHC_Hosp_a5_Oth;
         EditText txtHC_Hosp_a5_Oth;
         LinearLayout secHC_Hosp_bLabel;
         View lineHC_Hosp_bLabel;
         LinearLayout secHC_Hosp_b;
         View lineHC_Hosp_b;
         TextView VlblHC_Hosp_b;
         RadioGroup rdogrpHC_Hosp_b;
         
         RadioButton rdoHC_Hosp_b1;
         RadioButton rdoHC_Hosp_b2;
         LinearLayout secHC_Hosp_b_i;
         View lineHC_Hosp_b_i;
         TextView VlblHC_Hosp_b_i;
         RadioGroup rdogrpHC_Hosp_b_i;
         
         RadioButton rdoHC_Hosp_b_i1;
         RadioButton rdoHC_Hosp_b_i2;
         LinearLayout secHC_Clin;
         View lineHC_Clin;
         TextView VlblHC_Clin;
         RadioGroup rdogrpHC_Clin;
         
         RadioButton rdoHC_Clin1;
         RadioButton rdoHC_Clin2;
         RadioButton rdoHC_Clin3;
         LinearLayout secHC_Phy;
         View lineHC_Phy;
         TextView VlblHC_Phy;
         RadioGroup rdogrpHC_Phy;
         
         RadioButton rdoHC_Phy1;
         RadioButton rdoHC_Phy2;
         RadioButton rdoHC_Phy3;
         LinearLayout secDaysOfSymp;
         View lineDaysOfSymp;
         TextView VlblDaysOfSymp;
         EditText txtDaysOfSymp;
         LinearLayout secDaysOfSympDK;
         View lineDaysOfSympDK;
         TextView VlblDaysOfSympDK;
         CheckBox chkDaysOfSympDK;
         LinearLayout secWorstHour;
         View lineWorstHour;
         TextView VlblWorstHour;
         EditText txtWorstHour;
         LinearLayout secWorstHourDK;
         View lineWorstHourDK;
         TextView VlblWorstHourDK;
         CheckBox chkWorstHourDK;
         LinearLayout secDaysOfUnable;
         View lineDaysOfUnable;
         TextView VlblDaysOfUnable;
         EditText txtDaysOfUnable;
         LinearLayout secDaysOfUnableDK;
         View lineDaysOfUnableDK;
         TextView VlblDaysOfUnableDK;
         CheckBox chkDaysOfUnableDK;
         LinearLayout secTAdmHos;
         View lineTAdmHos;
         TextView VlblTAdmHos;
         RadioGroup rdogrpTAdmHos;
         
         RadioButton rdoTAdmHos1;
         RadioButton rdoTAdmHos2;
         RadioButton rdoTAdmHos3;
         LinearLayout secTHosNamLabel;
         View lineTHosNamLabel;
         LinearLayout secTHosNam;
         View lineTHosNam;
         TextView VlblTHosNam;
         Spinner spnTHosNam;
         Spinner spnTHosNam2;
         LinearLayout secTHosNam_Oth;
         View lineTHosNam_Oth;
         TextView VlblTHosNam_Oth;
         EditText txtTHosNam_Oth;
         LinearLayout secTHosNam2;
         View lineTHosNam2;
         TextView VlblTHosNam2;
//         RadioGroup rdogrpTHosNam2;
         
         RadioButton rdoTHosNam21;
         RadioButton rdoTHosNam22;
         RadioButton rdoTHosNam23;
         RadioButton rdoTHosNam24;
         LinearLayout secTHosNam2_Oth;
         View lineTHosNam2_Oth;
         TextView VlblTHosNam2_Oth;
         EditText txtTHosNam2_Oth;
         LinearLayout secTHosNam3;
         View lineTHosNam3;
         TextView VlblTHosNam3;
         Spinner spnTHosNam3;
         LinearLayout secTHosNam3_Oth;
         View lineTHosNam3_Oth;
         TextView VlblTHosNam3_Oth;
         EditText txtTHosNam3_Oth;
         LinearLayout secTHosNamDK;
         View lineTHosNamDK;
         TextView VlblTHosNamDK;
         CheckBox chkTHosNamDK;
         LinearLayout secTDtAdmHos;
         View lineTDtAdmHos;
         TextView VlblTDtAdmHos;
         EditText dtpTDtAdmHos;
         LinearLayout secTAdmHosD;
         View lineTAdmHosD;
         TextView VlblTAdmHosD;
         EditText txtTAdmHosD;
         LinearLayout secTDurIlBeHos;
         View lineTDurIlBeHos;
         TextView VlblTDurIlBeHos;
         EditText txtTDurIlBeHos;
         LinearLayout secTDurIlBeHosDK;
         View lineTDurIlBeHosDK;
         TextView VlblTDurIlBeHosDK;
         CheckBox chkTDurIlBeHosDK;
         LinearLayout secTDisDr;
         View lineTDisDr;
         TextView VlblTDisDr;
         Spinner spnTDisDr;
         LinearLayout secTDisDrOth;
         View lineTDisDrOth;
         TextView VlblTDisDrOth;
         EditText txtTDisDrOth;
         LinearLayout secTReco;
         View lineTReco;
         TextView VlblTReco;
         RadioGroup rdogrpTReco;
         
         RadioButton rdoTReco1;
         RadioButton rdoTReco2;
         RadioButton rdoTReco3;
         LinearLayout secTDurReco;
         View lineTDurReco;
         TextView VlblTDurReco;
         EditText txtTDurReco;
         LinearLayout secTInRecoLabel;
         View lineTInRecoLabel;
         LinearLayout secTInReco;
         View lineTInReco;
         TextView VlblTInReco;
         Spinner spnTInReco;
         LinearLayout secTInRecoOth;
         View lineTInRecoOth;
         TextView VlblTInRecoOth;
         EditText txtTInRecoOth;
         LinearLayout secTInReco2;
         View lineTInReco2;
         TextView VlblTInReco2;
         Spinner spnTInReco2;
         LinearLayout secTInRecoOth2;
         View lineTInRecoOth2;
         TextView VlblTInRecoOth2;
         EditText txtTInRecoOth2;
         LinearLayout secHaveHosp;
         View lineHaveHosp;
         TextView VlblHaveHosp;
         RadioGroup rdogrpHaveHosp;
         
         RadioButton rdoHaveHosp1;
         RadioButton rdoHaveHosp2;
         RadioButton rdoHaveHosp3;
         LinearLayout secHospNameLabel;
         View lineHospNameLabel;
         LinearLayout secHospName;
         View lineHospName;
         TextView VlblHospName;
         Spinner spnHospName;
         LinearLayout secHospName_Oth;
         View lineHospName_Oth;
         TextView VlblHospName_Oth;
         EditText txtHospName_Oth;
         LinearLayout secHaveRecordsLabel;
         View lineHaveRecordsLabel;
         LinearLayout secHaveRecords;
         View lineHaveRecords;
         TextView VlblHaveRecords;
         RadioGroup rdogrpHaveRecords;
         
         RadioButton rdoHaveRecords1;
         RadioButton rdoHaveRecords2;
         LinearLayout secDidRecordMatch2;
         View lineDidRecordMatch2;
         TextView VlblDidRecordMatch2;
         RadioGroup rdogrpDidRecordMatch2;
         
         RadioButton rdoDidRecordMatch21;
         RadioButton rdoDidRecordMatch22;
         LinearLayout secDaysOfHosp;
         View lineDaysOfHosp;
         TextView VlblDaysOfHosp;
         EditText txtDaysOfHosp;
         LinearLayout secDaysOfHospDK;
         View lineDaysOfHospDK;
         TextView VlblDaysOfHospDK;
         CheckBox chkDaysOfHospDK;
         LinearLayout secTAboIll;
         View lineTAboIll;
         TextView VlblTAboIll;
         EditText txtTAboIll;

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
         setContentView(R.layout.typhoidcase);
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

         TableName = "TyphoidCase";

         //turnGPSOn();

         //GPS Location
         //FindLocation();
         // Double.toString(currentLatitude);
         // Double.toString(currentLongitude);
         lblHeading = (TextView)findViewById(R.id.lblHeading);

         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(TyphoidCase.this);
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
         secHaveFever=(LinearLayout)findViewById(R.id.secHaveFever);
         lineHaveFever=(View)findViewById(R.id.lineHaveFever);
         VlblHaveFever = (TextView) findViewById(R.id.VlblHaveFever);
         rdogrpHaveFever = (RadioGroup) findViewById(R.id.rdogrpHaveFever);


          txtUNCode.setText(UNCODE);
          txtStructureNo.setText(""+STRUCTURENO);
          txtHouseholdSl.setText(HOUSEHOLDSL);
          txtVisitNo.setText(VISITNO);
          txtMemSl.setText(MEMSL);
          txtMemName.setText(MEMNAME);


         
         rdoHaveFever1 = (RadioButton) findViewById(R.id.rdoHaveFever1);
         rdoHaveFever2 = (RadioButton) findViewById(R.id.rdoHaveFever2);
         rdoHaveFever3 = (RadioButton) findViewById(R.id.rdoHaveFever3);
         rdogrpHaveFever.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpHaveFever = new String[] {"1","2","8"};
             for (int i = 0; i < rdogrpHaveFever.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpHaveFever.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpHaveFever[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secTsymptLabel.setVisibility(View.GONE);
                    lineTsymptLabel.setVisibility(View.GONE);
                    secAbdomPain.setVisibility(View.GONE);
                    lineAbdomPain.setVisibility(View.GONE);
                    rdogrpAbdomPain.clearCheck();
                    secConstipation.setVisibility(View.GONE);
                    lineConstipation.setVisibility(View.GONE);
                    rdogrpConstipation.clearCheck();
                    secHeadache.setVisibility(View.GONE);
                    lineHeadache.setVisibility(View.GONE);
                    rdogrpHeadache.clearCheck();
                    secRash.setVisibility(View.GONE);
                    lineRash.setVisibility(View.GONE);
                    rdogrpRash.clearCheck();
                    secDiarrhoea.setVisibility(View.GONE);
                    lineDiarrhoea.setVisibility(View.GONE);
                    rdogrpDiarrhoea.clearCheck();
                    secAbdomDist.setVisibility(View.GONE);
                    lineAbdomDist.setVisibility(View.GONE);
                    rdogrpAbdomDist.clearCheck();
                    secCoaTon.setVisibility(View.GONE);
                    lineCoaTon.setVisibility(View.GONE);
                    rdogrpCoaTon.clearCheck();
                    secCough.setVisibility(View.GONE);
                    lineCough.setVisibility(View.GONE);
                    rdogrpCough.clearCheck();
                    secTnone.setVisibility(View.GONE);
                    lineTnone.setVisibility(View.GONE);
                    rdogrpTnone.clearCheck();
                    secOther.setVisibility(View.GONE);
                    lineOther.setVisibility(View.GONE);
                    rdogrpOther.clearCheck();
                    secTsymptOthName.setVisibility(View.GONE);
                    lineTsymptOthName.setVisibility(View.GONE);
                    secTakenHCFacility.setVisibility(View.GONE);
                    lineTakenHCFacility.setVisibility(View.GONE);
                    rdogrpTakenHCFacility.clearCheck();
                    secTHCarTypLabel.setVisibility(View.GONE);
                    lineTHCarTypLabel.setVisibility(View.GONE);
                    secHC_PhyMBBS.setVisibility(View.GONE);
                    lineHC_PhyMBBS.setVisibility(View.GONE);
                    rdogrpHC_PhyMBBS.clearCheck();
                    secHC_UnquaDoctor.setVisibility(View.GONE);
                    lineHC_UnquaDoctor.setVisibility(View.GONE);
                    rdogrpHC_UnquaDoctor.clearCheck();
                    secHC_Para.setVisibility(View.GONE);
                    lineHC_Para.setVisibility(View.GONE);
                    rdogrpHC_Para.clearCheck();
                    secHC_Com.setVisibility(View.GONE);
                    lineHC_Com.setVisibility(View.GONE);
                    rdogrpHC_Com.clearCheck();
                    secHC_Pha.setVisibility(View.GONE);
                    lineHC_Pha.setVisibility(View.GONE);
                    rdogrpHC_Pha.clearCheck();
                    secHC_Hompath.setVisibility(View.GONE);
                    lineHC_Hompath.setVisibility(View.GONE);
                    rdogrpHC_Hompath.clearCheck();
                    secHC_TrHeal.setVisibility(View.GONE);
                    lineHC_TrHeal.setVisibility(View.GONE);
                    rdogrpHC_TrHeal.clearCheck();
                    secHC_SpiHeal.setVisibility(View.GONE);
                    lineHC_SpiHeal.setVisibility(View.GONE);
                    rdogrpHC_SpiHeal.clearCheck();
                    secTHC_Oth.setVisibility(View.GONE);
                    lineTHC_Oth.setVisibility(View.GONE);
                    rdogrpTHC_Oth.clearCheck();
                    secTHC_OthName.setVisibility(View.GONE);
                    lineTHC_OthName.setVisibility(View.GONE);
                    txtTHC_OthName.setText("");
                    secHC_Hosp.setVisibility(View.GONE);
                    lineHC_Hosp.setVisibility(View.GONE);
                    rdogrpHC_Hosp.clearCheck();
                    secHC_HospLabel.setVisibility(View.GONE);
                    lineHC_HospLabel.setVisibility(View.GONE);
                    secHC_Hosp_a1.setVisibility(View.GONE);
                    lineHC_Hosp_a1.setVisibility(View.GONE);
                    spnHC_Hosp_a1.setSelection(0);
                    secHC_Hosp_a1_Oth.setVisibility(View.GONE);
                    lineHC_Hosp_a1_Oth.setVisibility(View.GONE);
                    txtHC_Hosp_a1_Oth.setText("");
                    secHC_Hosp_a2.setVisibility(View.GONE);
                    lineHC_Hosp_a2.setVisibility(View.GONE);
                    spnHC_Hosp_a2.setSelection(0);
                    secHC_Hosp_a2_Oth.setVisibility(View.GONE);
                    lineHC_Hosp_a2_Oth.setVisibility(View.GONE);
                    txtHC_Hosp_a2_Oth.setText("");
                    secHC_Hosp_a3.setVisibility(View.GONE);
                    lineHC_Hosp_a3.setVisibility(View.GONE);
                    spnHC_Hosp_a3.setSelection(0);
                    secHC_Hosp_a3_Oth.setVisibility(View.GONE);
                    lineHC_Hosp_a3_Oth.setVisibility(View.GONE);
                    txtHC_Hosp_a3_Oth.setText("");
                    secHC_Hosp_a4.setVisibility(View.GONE);
                    lineHC_Hosp_a4.setVisibility(View.GONE);
                    spnHC_Hosp_a4.setSelection(0);
                    secHC_Hosp_a4_Oth.setVisibility(View.GONE);
                    lineHC_Hosp_a4_Oth.setVisibility(View.GONE);
                    txtHC_Hosp_a4_Oth.setText("");
                    secHC_Hosp_a5.setVisibility(View.GONE);
                    lineHC_Hosp_a5.setVisibility(View.GONE);
                    spnHC_Hosp_a5.setSelection(0);
                    secHC_Hosp_a5_Oth.setVisibility(View.GONE);
                    lineHC_Hosp_a5_Oth.setVisibility(View.GONE);
                    txtHC_Hosp_a5_Oth.setText("");
                    secHC_Hosp_bLabel.setVisibility(View.GONE);
                    lineHC_Hosp_bLabel.setVisibility(View.GONE);
                    secHC_Hosp_b.setVisibility(View.GONE);
                    lineHC_Hosp_b.setVisibility(View.GONE);
                    rdogrpHC_Hosp_b.clearCheck();
                    secHC_Hosp_b_i.setVisibility(View.GONE);
                    lineHC_Hosp_b_i.setVisibility(View.GONE);
                    rdogrpHC_Hosp_b_i.clearCheck();
                    secHC_Clin.setVisibility(View.GONE);
                    lineHC_Clin.setVisibility(View.GONE);
                    rdogrpHC_Clin.clearCheck();
                    secHC_Phy.setVisibility(View.GONE);
                    lineHC_Phy.setVisibility(View.GONE);
                    rdogrpHC_Phy.clearCheck();
                    secDaysOfSymp.setVisibility(View.GONE);
                    lineDaysOfSymp.setVisibility(View.GONE);
                    txtDaysOfSymp.setText("");
                    secDaysOfSympDK.setVisibility(View.GONE);
                    lineDaysOfSympDK.setVisibility(View.GONE);
                    chkDaysOfSympDK.setChecked(false);
                    secWorstHour.setVisibility(View.GONE);
                    lineWorstHour.setVisibility(View.GONE);
                    txtWorstHour.setText("");
                    secWorstHourDK.setVisibility(View.GONE);
                    lineWorstHourDK.setVisibility(View.GONE);
                    chkWorstHourDK.setChecked(false);
                    secDaysOfUnable.setVisibility(View.GONE);
                    lineDaysOfUnable.setVisibility(View.GONE);
                    txtDaysOfUnable.setText("");
                    secDaysOfUnableDK.setVisibility(View.GONE);
                    lineDaysOfUnableDK.setVisibility(View.GONE);
                    chkDaysOfUnableDK.setChecked(false);
                    secTAdmHos.setVisibility(View.GONE);
                    lineTAdmHos.setVisibility(View.GONE);
                    rdogrpTAdmHos.clearCheck();
                    secTHosNamLabel.setVisibility(View.GONE);
                    lineTHosNamLabel.setVisibility(View.GONE);
                    secTHosNam.setVisibility(View.GONE);
                    lineTHosNam.setVisibility(View.GONE);
                    spnTHosNam.setSelection(0);
                    secTHosNam_Oth.setVisibility(View.GONE);
                    lineTHosNam_Oth.setVisibility(View.GONE);
                    txtTHosNam_Oth.setText("");
                    secTHosNam2.setVisibility(View.GONE);
                    lineTHosNam2.setVisibility(View.GONE);
                  spnTHosNam2.setSelection(0);
                    secTHosNam2_Oth.setVisibility(View.GONE);
                    lineTHosNam2_Oth.setVisibility(View.GONE);
                    txtTHosNam2_Oth.setText("");
                    secTHosNam3.setVisibility(View.GONE);
                    lineTHosNam3.setVisibility(View.GONE);
                    spnTHosNam3.setSelection(0);
                    secTHosNam3_Oth.setVisibility(View.GONE);
                    lineTHosNam3_Oth.setVisibility(View.GONE);
                    txtTHosNam3_Oth.setText("");
                    secTHosNamDK.setVisibility(View.GONE);
                    lineTHosNamDK.setVisibility(View.GONE);
                    chkTHosNamDK.setChecked(false);
                    secTDtAdmHos.setVisibility(View.GONE);
                    lineTDtAdmHos.setVisibility(View.GONE);
                    dtpTDtAdmHos.setText("");
                    secTAdmHosD.setVisibility(View.GONE);
                    lineTAdmHosD.setVisibility(View.GONE);
                    txtTAdmHosD.setText("");
                    secTDurIlBeHos.setVisibility(View.GONE);
                    lineTDurIlBeHos.setVisibility(View.GONE);
                    txtTDurIlBeHos.setText("");
                    secTDurIlBeHosDK.setVisibility(View.GONE);
                    lineTDurIlBeHosDK.setVisibility(View.GONE);
                    chkTDurIlBeHosDK.setChecked(false);
                    secTDisDr.setVisibility(View.GONE);
                    lineTDisDr.setVisibility(View.GONE);
                    spnTDisDr.setSelection(0);
                    secTDisDrOth.setVisibility(View.GONE);
                    lineTDisDrOth.setVisibility(View.GONE);
                    txtTDisDrOth.setText("");
                    secTReco.setVisibility(View.GONE);
                    lineTReco.setVisibility(View.GONE);
                    rdogrpTReco.clearCheck();
                    secTDurReco.setVisibility(View.GONE);
                    lineTDurReco.setVisibility(View.GONE);
                    txtTDurReco.setText("");
                    secTInRecoLabel.setVisibility(View.GONE);
                    lineTInRecoLabel.setVisibility(View.GONE);
                    secTInReco.setVisibility(View.GONE);
                    lineTInReco.setVisibility(View.GONE);
                    spnTInReco.setSelection(0);
                    secTInRecoOth.setVisibility(View.GONE);
                    lineTInRecoOth.setVisibility(View.GONE);
                    txtTInRecoOth.setText("");
                    secTInReco2.setVisibility(View.GONE);
                    lineTInReco2.setVisibility(View.GONE);
                    spnTInReco2.setSelection(0);
                    secTInRecoOth2.setVisibility(View.GONE);
                    lineTInRecoOth2.setVisibility(View.GONE);
                    txtTInRecoOth2.setText("");
                    secHaveHosp.setVisibility(View.GONE);
                    lineHaveHosp.setVisibility(View.GONE);
                    rdogrpHaveHosp.clearCheck();
                    secHospNameLabel.setVisibility(View.GONE);
                    lineHospNameLabel.setVisibility(View.GONE);
                    secHospName.setVisibility(View.GONE);
                    lineHospName.setVisibility(View.GONE);
//                    spnHospName.setSelection(0);
                    secHospName_Oth.setVisibility(View.GONE);
                    lineHospName_Oth.setVisibility(View.GONE);
                    txtHospName_Oth.setText("");
                    secHaveRecordsLabel.setVisibility(View.GONE);
                    lineHaveRecordsLabel.setVisibility(View.GONE);
                    secHaveRecords.setVisibility(View.GONE);
                    lineHaveRecords.setVisibility(View.GONE);
                    rdogrpHaveRecords.clearCheck();
                    secDidRecordMatch2.setVisibility(View.GONE);
                    lineDidRecordMatch2.setVisibility(View.GONE);
                    rdogrpDidRecordMatch2.clearCheck();
                    secDaysOfHosp.setVisibility(View.GONE);
                    lineDaysOfHosp.setVisibility(View.GONE);
                    txtDaysOfHosp.setText("");
                    secDaysOfHospDK.setVisibility(View.GONE);
                    lineDaysOfHospDK.setVisibility(View.GONE);
                    chkDaysOfHospDK.setChecked(false);
                    secTAboIll.setVisibility(View.GONE);
                    lineTAboIll.setVisibility(View.GONE);
                    txtTAboIll.setText("");
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secTsymptLabel.setVisibility(View.GONE);
                    lineTsymptLabel.setVisibility(View.GONE);
                    secAbdomPain.setVisibility(View.GONE);
                    lineAbdomPain.setVisibility(View.GONE);
                    rdogrpAbdomPain.clearCheck();
                    secConstipation.setVisibility(View.GONE);
                    lineConstipation.setVisibility(View.GONE);
                    rdogrpConstipation.clearCheck();
                    secHeadache.setVisibility(View.GONE);
                    lineHeadache.setVisibility(View.GONE);
                    rdogrpHeadache.clearCheck();
                    secRash.setVisibility(View.GONE);
                    lineRash.setVisibility(View.GONE);
                    rdogrpRash.clearCheck();
                    secDiarrhoea.setVisibility(View.GONE);
                    lineDiarrhoea.setVisibility(View.GONE);
                    rdogrpDiarrhoea.clearCheck();
                    secAbdomDist.setVisibility(View.GONE);
                    lineAbdomDist.setVisibility(View.GONE);
                    rdogrpAbdomDist.clearCheck();
                    secCoaTon.setVisibility(View.GONE);
                    lineCoaTon.setVisibility(View.GONE);
                    rdogrpCoaTon.clearCheck();
                    secCough.setVisibility(View.GONE);
                    lineCough.setVisibility(View.GONE);
                    rdogrpCough.clearCheck();
                    secTnone.setVisibility(View.GONE);
                    lineTnone.setVisibility(View.GONE);
                    rdogrpTnone.clearCheck();
                    secOther.setVisibility(View.GONE);
                    lineOther.setVisibility(View.GONE);
                    rdogrpOther.clearCheck();
                    secTsymptOthName.setVisibility(View.GONE);
                    lineTsymptOthName.setVisibility(View.GONE);
                    txtTsymptOthName.setText("");
                    secTakenHCFacility.setVisibility(View.GONE);
                    lineTakenHCFacility.setVisibility(View.GONE);
                    rdogrpTakenHCFacility.clearCheck();
                    secTHCarTypLabel.setVisibility(View.GONE);
                    lineTHCarTypLabel.setVisibility(View.GONE);
                    secHC_PhyMBBS.setVisibility(View.GONE);
                    lineHC_PhyMBBS.setVisibility(View.GONE);
                    rdogrpHC_PhyMBBS.clearCheck();
                    secHC_UnquaDoctor.setVisibility(View.GONE);
                    lineHC_UnquaDoctor.setVisibility(View.GONE);
                    rdogrpHC_UnquaDoctor.clearCheck();
                    secHC_Para.setVisibility(View.GONE);
                    lineHC_Para.setVisibility(View.GONE);
                    rdogrpHC_Para.clearCheck();
                    secHC_Com.setVisibility(View.GONE);
                    lineHC_Com.setVisibility(View.GONE);
                    rdogrpHC_Com.clearCheck();
                    secHC_Pha.setVisibility(View.GONE);
                    lineHC_Pha.setVisibility(View.GONE);
                    rdogrpHC_Pha.clearCheck();
                    secHC_Hompath.setVisibility(View.GONE);
                    lineHC_Hompath.setVisibility(View.GONE);
                    rdogrpHC_Hompath.clearCheck();
                    secHC_TrHeal.setVisibility(View.GONE);
                    lineHC_TrHeal.setVisibility(View.GONE);
                    rdogrpHC_TrHeal.clearCheck();
                    secHC_SpiHeal.setVisibility(View.GONE);
                    lineHC_SpiHeal.setVisibility(View.GONE);
                    rdogrpHC_SpiHeal.clearCheck();
                    secTHC_Oth.setVisibility(View.GONE);
                    lineTHC_Oth.setVisibility(View.GONE);
                    rdogrpTHC_Oth.clearCheck();
                    secTHC_OthName.setVisibility(View.GONE);
                    lineTHC_OthName.setVisibility(View.GONE);
                    txtTHC_OthName.setText("");
                    secHC_Hosp.setVisibility(View.GONE);
                    lineHC_Hosp.setVisibility(View.GONE);
                    rdogrpHC_Hosp.clearCheck();
                    secHC_HospLabel.setVisibility(View.GONE);
                    lineHC_HospLabel.setVisibility(View.GONE);
                    secHC_Hosp_a1.setVisibility(View.GONE);
                    lineHC_Hosp_a1.setVisibility(View.GONE);
                    spnHC_Hosp_a1.setSelection(0);
                    secHC_Hosp_a1_Oth.setVisibility(View.GONE);
                    lineHC_Hosp_a1_Oth.setVisibility(View.GONE);
                    txtHC_Hosp_a1_Oth.setText("");
                    secHC_Hosp_a2.setVisibility(View.GONE);
                    lineHC_Hosp_a2.setVisibility(View.GONE);
                    spnHC_Hosp_a2.setSelection(0);
                    secHC_Hosp_a2_Oth.setVisibility(View.GONE);
                    lineHC_Hosp_a2_Oth.setVisibility(View.GONE);
                    txtHC_Hosp_a2_Oth.setText("");
                    secHC_Hosp_a3.setVisibility(View.GONE);
                    lineHC_Hosp_a3.setVisibility(View.GONE);
                    spnHC_Hosp_a3.setSelection(0);
                    secHC_Hosp_a3_Oth.setVisibility(View.GONE);
                    lineHC_Hosp_a3_Oth.setVisibility(View.GONE);
                    txtHC_Hosp_a3_Oth.setText("");
                    secHC_Hosp_a4.setVisibility(View.GONE);
                    lineHC_Hosp_a4.setVisibility(View.GONE);
                    spnHC_Hosp_a4.setSelection(0);
                    secHC_Hosp_a4_Oth.setVisibility(View.GONE);
                    lineHC_Hosp_a4_Oth.setVisibility(View.GONE);
                    txtHC_Hosp_a4_Oth.setText("");
                    secHC_Hosp_a5.setVisibility(View.GONE);
                    lineHC_Hosp_a5.setVisibility(View.GONE);
                    spnHC_Hosp_a5.setSelection(0);
                    secHC_Hosp_a5_Oth.setVisibility(View.GONE);
                    lineHC_Hosp_a5_Oth.setVisibility(View.GONE);
                    txtHC_Hosp_a5_Oth.setText("");
                    secHC_Hosp_bLabel.setVisibility(View.GONE);
                    lineHC_Hosp_bLabel.setVisibility(View.GONE);
                    secHC_Hosp_b.setVisibility(View.GONE);
                    lineHC_Hosp_b.setVisibility(View.GONE);
                    rdogrpHC_Hosp_b.clearCheck();
                    secHC_Hosp_b_i.setVisibility(View.GONE);
                    lineHC_Hosp_b_i.setVisibility(View.GONE);
                    rdogrpHC_Hosp_b_i.clearCheck();
                    secHC_Clin.setVisibility(View.GONE);
                    lineHC_Clin.setVisibility(View.GONE);
                    rdogrpHC_Clin.clearCheck();
                    secHC_Phy.setVisibility(View.GONE);
                    lineHC_Phy.setVisibility(View.GONE);
                    rdogrpHC_Phy.clearCheck();
                    secDaysOfSymp.setVisibility(View.GONE);
                    lineDaysOfSymp.setVisibility(View.GONE);
                    txtDaysOfSymp.setText("");
                    secDaysOfSympDK.setVisibility(View.GONE);
                    lineDaysOfSympDK.setVisibility(View.GONE);
                    chkDaysOfSympDK.setChecked(false);
                    secWorstHour.setVisibility(View.GONE);
                    lineWorstHour.setVisibility(View.GONE);
                    txtWorstHour.setText("");
                    secWorstHourDK.setVisibility(View.GONE);
                    lineWorstHourDK.setVisibility(View.GONE);
                    chkWorstHourDK.setChecked(false);
                    secDaysOfUnable.setVisibility(View.GONE);
                    lineDaysOfUnable.setVisibility(View.GONE);
                    txtDaysOfUnable.setText("");
                    secDaysOfUnableDK.setVisibility(View.GONE);
                    lineDaysOfUnableDK.setVisibility(View.GONE);
                    chkDaysOfUnableDK.setChecked(false);
                    secTAdmHos.setVisibility(View.GONE);
                    lineTAdmHos.setVisibility(View.GONE);
                    rdogrpTAdmHos.clearCheck();
                    secTHosNamLabel.setVisibility(View.GONE);
                    lineTHosNamLabel.setVisibility(View.GONE);
                    secTHosNam.setVisibility(View.GONE);
                    lineTHosNam.setVisibility(View.GONE);
                    spnTHosNam.setSelection(0);
                    secTHosNam_Oth.setVisibility(View.GONE);
                    lineTHosNam_Oth.setVisibility(View.GONE);
                    txtTHosNam_Oth.setText("");
                    secTHosNam2.setVisibility(View.GONE);
                    lineTHosNam2.setVisibility(View.GONE);
                  spnTHosNam2.setSelection(0);
                    secTHosNam2_Oth.setVisibility(View.GONE);
                    lineTHosNam2_Oth.setVisibility(View.GONE);
                    txtTHosNam2_Oth.setText("");
                    secTHosNam3.setVisibility(View.GONE);
                    lineTHosNam3.setVisibility(View.GONE);
                    spnTHosNam3.setSelection(0);
                    secTHosNam3_Oth.setVisibility(View.GONE);
                    lineTHosNam3_Oth.setVisibility(View.GONE);
                    txtTHosNam3_Oth.setText("");
                    secTHosNamDK.setVisibility(View.GONE);
                    lineTHosNamDK.setVisibility(View.GONE);
                    chkTHosNamDK.setChecked(false);
                    secTDtAdmHos.setVisibility(View.GONE);
                    lineTDtAdmHos.setVisibility(View.GONE);
                    dtpTDtAdmHos.setText("");
                    secTAdmHosD.setVisibility(View.GONE);
                    lineTAdmHosD.setVisibility(View.GONE);
                    txtTAdmHosD.setText("");
                    secTDurIlBeHos.setVisibility(View.GONE);
                    lineTDurIlBeHos.setVisibility(View.GONE);
                    txtTDurIlBeHos.setText("");
                    secTDurIlBeHosDK.setVisibility(View.GONE);
                    lineTDurIlBeHosDK.setVisibility(View.GONE);
                    chkTDurIlBeHosDK.setChecked(false);
                    secTDisDr.setVisibility(View.GONE);
                    lineTDisDr.setVisibility(View.GONE);
                    spnTDisDr.setSelection(0);
                    secTDisDrOth.setVisibility(View.GONE);
                    lineTDisDrOth.setVisibility(View.GONE);
                    txtTDisDrOth.setText("");
                    secTReco.setVisibility(View.GONE);
                    lineTReco.setVisibility(View.GONE);
                    rdogrpTReco.clearCheck();
                    secTDurReco.setVisibility(View.GONE);
                    lineTDurReco.setVisibility(View.GONE);
                    txtTDurReco.setText("");
                    secTInRecoLabel.setVisibility(View.GONE);
                    lineTInRecoLabel.setVisibility(View.GONE);
                    secTInReco.setVisibility(View.GONE);
                    lineTInReco.setVisibility(View.GONE);
                    spnTInReco.setSelection(0);
                    secTInRecoOth.setVisibility(View.GONE);
                    lineTInRecoOth.setVisibility(View.GONE);
                    txtTInRecoOth.setText("");
                    secTInReco2.setVisibility(View.GONE);
                    lineTInReco2.setVisibility(View.GONE);
                    spnTInReco2.setSelection(0);
                    secTInRecoOth2.setVisibility(View.GONE);
                    lineTInRecoOth2.setVisibility(View.GONE);
                    txtTInRecoOth2.setText("");
                    secHaveHosp.setVisibility(View.GONE);
                    lineHaveHosp.setVisibility(View.GONE);
                    rdogrpHaveHosp.clearCheck();
                    secHospNameLabel.setVisibility(View.GONE);
                    lineHospNameLabel.setVisibility(View.GONE);
                    secHospName.setVisibility(View.GONE);
                    lineHospName.setVisibility(View.GONE);
//                    spnHospName.setSelection(0);
                    secHospName_Oth.setVisibility(View.GONE);
                    lineHospName_Oth.setVisibility(View.GONE);
                    txtHospName_Oth.setText("");
                    secHaveRecordsLabel.setVisibility(View.GONE);
                    lineHaveRecordsLabel.setVisibility(View.GONE);
                    secHaveRecords.setVisibility(View.GONE);
                    lineHaveRecords.setVisibility(View.GONE);
                    rdogrpHaveRecords.clearCheck();
                    secDidRecordMatch2.setVisibility(View.GONE);
                    lineDidRecordMatch2.setVisibility(View.GONE);
                    rdogrpDidRecordMatch2.clearCheck();
                    secDaysOfHosp.setVisibility(View.GONE);
                    lineDaysOfHosp.setVisibility(View.GONE);
                    txtDaysOfHosp.setText("");
                    secDaysOfHospDK.setVisibility(View.GONE);
                    lineDaysOfHospDK.setVisibility(View.GONE);
                    chkDaysOfHospDK.setChecked(false);
                    secTAboIll.setVisibility(View.GONE);
                    lineTAboIll.setVisibility(View.GONE);
                    txtTAboIll.setText("");
             }
             else if(rbData.equalsIgnoreCase("1"))
             {
                    secTsymptLabel.setVisibility(View.VISIBLE);
                    lineTsymptLabel.setVisibility(View.VISIBLE);
                    secAbdomPain.setVisibility(View.VISIBLE);
                    lineAbdomPain.setVisibility(View.VISIBLE);
                    secConstipation.setVisibility(View.VISIBLE);
                    lineConstipation.setVisibility(View.VISIBLE);
                    secHeadache.setVisibility(View.VISIBLE);
                    lineHeadache.setVisibility(View.VISIBLE);
                    secRash.setVisibility(View.VISIBLE);
                    lineRash.setVisibility(View.VISIBLE);
                    secDiarrhoea.setVisibility(View.VISIBLE);
                    lineDiarrhoea.setVisibility(View.VISIBLE);
                    secAbdomDist.setVisibility(View.VISIBLE);
                    lineAbdomDist.setVisibility(View.VISIBLE);
                    secCoaTon.setVisibility(View.VISIBLE);
                    lineCoaTon.setVisibility(View.VISIBLE);
                    secCough.setVisibility(View.VISIBLE);
                    lineCough.setVisibility(View.VISIBLE);
                    secTnone.setVisibility(View.VISIBLE);
                    lineTnone.setVisibility(View.VISIBLE);
                    secOther.setVisibility(View.VISIBLE);
                    lineOther.setVisibility(View.VISIBLE);
                    secTakenHCFacility.setVisibility(View.VISIBLE);
                    lineTakenHCFacility.setVisibility(View.VISIBLE);
//                    secHC_Hosp.setVisibility(View.VISIBLE);
//                    lineHC_Hosp.setVisibility(View.VISIBLE);
//                    secHC_Clin.setVisibility(View.VISIBLE);
//                    lineHC_Clin.setVisibility(View.VISIBLE);
//                    secHC_Phy.setVisibility(View.VISIBLE);
//                    lineHC_Phy.setVisibility(View.VISIBLE);
                    secDaysOfSymp.setVisibility(View.VISIBLE);
                    lineDaysOfSymp.setVisibility(View.VISIBLE);
                    secDaysOfSympDK.setVisibility(View.VISIBLE);
                    lineDaysOfSympDK.setVisibility(View.VISIBLE);
                    secWorstHour.setVisibility(View.VISIBLE);
                    lineWorstHour.setVisibility(View.VISIBLE);
                    secWorstHourDK.setVisibility(View.VISIBLE);
                    lineWorstHourDK.setVisibility(View.VISIBLE);
                    secDaysOfUnable.setVisibility(View.VISIBLE);
                    lineDaysOfUnable.setVisibility(View.VISIBLE);
                    secDaysOfUnableDK.setVisibility(View.VISIBLE);
                    lineDaysOfUnableDK.setVisibility(View.VISIBLE);
                    secTAdmHos.setVisibility(View.VISIBLE);
                    lineTAdmHos.setVisibility(View.VISIBLE);
                    secTHosNamLabel.setVisibility(View.VISIBLE);
                    lineTHosNamLabel.setVisibility(View.VISIBLE);
                    secTHosNam.setVisibility(View.VISIBLE);
                    lineTHosNam.setVisibility(View.VISIBLE);
                    secTHosNam_Oth.setVisibility(View.VISIBLE);
                    lineTHosNam_Oth.setVisibility(View.VISIBLE);
                    secTHosNam2.setVisibility(View.VISIBLE);
                    lineTHosNam2.setVisibility(View.VISIBLE);

                    secTHosNam3.setVisibility(View.VISIBLE);
                    lineTHosNam3.setVisibility(View.VISIBLE);
                    secTHosNam3_Oth.setVisibility(View.VISIBLE);
                    lineTHosNam3_Oth.setVisibility(View.VISIBLE);
                    secTHosNamDK.setVisibility(View.VISIBLE);
                    lineTHosNamDK.setVisibility(View.VISIBLE);
                    secTDtAdmHos.setVisibility(View.VISIBLE);
                    lineTDtAdmHos.setVisibility(View.VISIBLE);
                    secTAdmHosD.setVisibility(View.VISIBLE);
                    lineTAdmHosD.setVisibility(View.VISIBLE);
                    secTDurIlBeHos.setVisibility(View.VISIBLE);
                    lineTDurIlBeHos.setVisibility(View.VISIBLE);
//                    secTDurIlBeHosDK.setVisibility(View.VISIBLE);
//                    lineTDurIlBeHosDK.setVisibility(View.VISIBLE);
                    secTDisDr.setVisibility(View.VISIBLE);
                    lineTDisDr.setVisibility(View.VISIBLE);
                    secTDisDrOth.setVisibility(View.VISIBLE);
                    lineTDisDrOth.setVisibility(View.VISIBLE);
                    secTReco.setVisibility(View.VISIBLE);
                    lineTReco.setVisibility(View.VISIBLE);

                    secTInRecoLabel.setVisibility(View.VISIBLE);
                    lineTInRecoLabel.setVisibility(View.VISIBLE);
                    secTInReco.setVisibility(View.VISIBLE);
                    lineTInReco.setVisibility(View.VISIBLE);
                    secTInRecoOth.setVisibility(View.VISIBLE);
                    lineTInRecoOth.setVisibility(View.VISIBLE);
                    secTInReco2.setVisibility(View.VISIBLE);
                    lineTInReco2.setVisibility(View.VISIBLE);
                    secTInRecoOth2.setVisibility(View.VISIBLE);
                    lineTInRecoOth2.setVisibility(View.VISIBLE);
                    secHaveHosp.setVisibility(View.VISIBLE);
                    lineHaveHosp.setVisibility(View.VISIBLE);



                  secTAboIll.setVisibility(View.VISIBLE);
                  lineTAboIll.setVisibility(View.VISIBLE);
                  txtTAboIll.setText("");



             }
             else {
                  secTsymptLabel.setVisibility(View.GONE);
                  lineTsymptLabel.setVisibility(View.GONE);
                  secAbdomPain.setVisibility(View.GONE);
                  lineAbdomPain.setVisibility(View.GONE);
                  rdogrpAbdomPain.clearCheck();
                  secConstipation.setVisibility(View.GONE);
                  lineConstipation.setVisibility(View.GONE);
                  rdogrpConstipation.clearCheck();
                  secHeadache.setVisibility(View.GONE);
                  lineHeadache.setVisibility(View.GONE);
                  rdogrpHeadache.clearCheck();
                  secRash.setVisibility(View.GONE);
                  lineRash.setVisibility(View.GONE);
                  rdogrpRash.clearCheck();
                  secDiarrhoea.setVisibility(View.GONE);
                  lineDiarrhoea.setVisibility(View.GONE);
                  rdogrpDiarrhoea.clearCheck();
                  secAbdomDist.setVisibility(View.GONE);
                  lineAbdomDist.setVisibility(View.GONE);
                  rdogrpAbdomDist.clearCheck();
                  secCoaTon.setVisibility(View.GONE);
                  lineCoaTon.setVisibility(View.GONE);
                  rdogrpCoaTon.clearCheck();
                  secCough.setVisibility(View.GONE);
                  lineCough.setVisibility(View.GONE);
                  rdogrpCough.clearCheck();
                  secTnone.setVisibility(View.GONE);
                  lineTnone.setVisibility(View.GONE);
                  rdogrpTnone.clearCheck();
                  secOther.setVisibility(View.GONE);
                  lineOther.setVisibility(View.GONE);
                  rdogrpOther.clearCheck();
                  secTsymptOthName.setVisibility(View.GONE);
                  lineTsymptOthName.setVisibility(View.GONE);
                  txtTsymptOthName.setText("");
                  secTakenHCFacility.setVisibility(View.GONE);
                  lineTakenHCFacility.setVisibility(View.GONE);
                  rdogrpTakenHCFacility.clearCheck();
                  secTHCarTypLabel.setVisibility(View.GONE);
                  lineTHCarTypLabel.setVisibility(View.GONE);
                  secHC_PhyMBBS.setVisibility(View.GONE);
                  lineHC_PhyMBBS.setVisibility(View.GONE);
                  rdogrpHC_PhyMBBS.clearCheck();
                  secHC_UnquaDoctor.setVisibility(View.GONE);
                  lineHC_UnquaDoctor.setVisibility(View.GONE);
                  rdogrpHC_UnquaDoctor.clearCheck();
                  secHC_Para.setVisibility(View.GONE);
                  lineHC_Para.setVisibility(View.GONE);
                  rdogrpHC_Para.clearCheck();
                  secHC_Com.setVisibility(View.GONE);
                  lineHC_Com.setVisibility(View.GONE);
                  rdogrpHC_Com.clearCheck();
                  secHC_Pha.setVisibility(View.GONE);
                  lineHC_Pha.setVisibility(View.GONE);
                  rdogrpHC_Pha.clearCheck();
                  secHC_Hompath.setVisibility(View.GONE);
                  lineHC_Hompath.setVisibility(View.GONE);
                  rdogrpHC_Hompath.clearCheck();
                  secHC_TrHeal.setVisibility(View.GONE);
                  lineHC_TrHeal.setVisibility(View.GONE);
                  rdogrpHC_TrHeal.clearCheck();
                  secHC_SpiHeal.setVisibility(View.GONE);
                  lineHC_SpiHeal.setVisibility(View.GONE);
                  rdogrpHC_SpiHeal.clearCheck();
                  secTHC_Oth.setVisibility(View.GONE);
                  lineTHC_Oth.setVisibility(View.GONE);
                  rdogrpTHC_Oth.clearCheck();
                  secTHC_OthName.setVisibility(View.GONE);
                  lineTHC_OthName.setVisibility(View.GONE);
                  txtTHC_OthName.setText("");
                  secHC_Hosp.setVisibility(View.GONE);
                  lineHC_Hosp.setVisibility(View.GONE);
                  rdogrpHC_Hosp.clearCheck();
                  secHC_HospLabel.setVisibility(View.GONE);
                  lineHC_HospLabel.setVisibility(View.GONE);
                  secHC_Hosp_a1.setVisibility(View.GONE);
                  lineHC_Hosp_a1.setVisibility(View.GONE);
                  spnHC_Hosp_a1.setSelection(0);
                  secHC_Hosp_a1_Oth.setVisibility(View.GONE);
                  lineHC_Hosp_a1_Oth.setVisibility(View.GONE);
                  txtHC_Hosp_a1_Oth.setText("");
                  secHC_Hosp_a2.setVisibility(View.GONE);
                  lineHC_Hosp_a2.setVisibility(View.GONE);
                  spnHC_Hosp_a2.setSelection(0);
                  secHC_Hosp_a2_Oth.setVisibility(View.GONE);
                  lineHC_Hosp_a2_Oth.setVisibility(View.GONE);
                  txtHC_Hosp_a2_Oth.setText("");
                  secHC_Hosp_a3.setVisibility(View.GONE);
                  lineHC_Hosp_a3.setVisibility(View.GONE);
                  spnHC_Hosp_a3.setSelection(0);
                  secHC_Hosp_a3_Oth.setVisibility(View.GONE);
                  lineHC_Hosp_a3_Oth.setVisibility(View.GONE);
                  txtHC_Hosp_a3_Oth.setText("");
                  secHC_Hosp_a4.setVisibility(View.GONE);
                  lineHC_Hosp_a4.setVisibility(View.GONE);
                  spnHC_Hosp_a4.setSelection(0);
                  secHC_Hosp_a4_Oth.setVisibility(View.GONE);
                  lineHC_Hosp_a4_Oth.setVisibility(View.GONE);
                  txtHC_Hosp_a4_Oth.setText("");
                  secHC_Hosp_a5.setVisibility(View.GONE);
                  lineHC_Hosp_a5.setVisibility(View.GONE);
                  spnHC_Hosp_a5.setSelection(0);
                  secHC_Hosp_a5_Oth.setVisibility(View.GONE);
                  lineHC_Hosp_a5_Oth.setVisibility(View.GONE);
                  txtHC_Hosp_a5_Oth.setText("");
                  secHC_Hosp_bLabel.setVisibility(View.GONE);
                  lineHC_Hosp_bLabel.setVisibility(View.GONE);
                  secHC_Hosp_b.setVisibility(View.GONE);
                  lineHC_Hosp_b.setVisibility(View.GONE);
                  rdogrpHC_Hosp_b.clearCheck();
                  secHC_Hosp_b_i.setVisibility(View.GONE);
                  lineHC_Hosp_b_i.setVisibility(View.GONE);
                  rdogrpHC_Hosp_b_i.clearCheck();
                  secHC_Clin.setVisibility(View.GONE);
                  lineHC_Clin.setVisibility(View.GONE);
                  rdogrpHC_Clin.clearCheck();
                  secHC_Phy.setVisibility(View.GONE);
                  lineHC_Phy.setVisibility(View.GONE);
                  rdogrpHC_Phy.clearCheck();
                  secDaysOfSymp.setVisibility(View.GONE);
                  lineDaysOfSymp.setVisibility(View.GONE);
                  txtDaysOfSymp.setText("");
                  secDaysOfSympDK.setVisibility(View.GONE);
                  lineDaysOfSympDK.setVisibility(View.GONE);
                  chkDaysOfSympDK.setChecked(false);
                  secWorstHour.setVisibility(View.GONE);
                  lineWorstHour.setVisibility(View.GONE);
                  txtWorstHour.setText("");
                  secWorstHourDK.setVisibility(View.GONE);
                  lineWorstHourDK.setVisibility(View.GONE);
                  chkWorstHourDK.setChecked(false);
                  secDaysOfUnable.setVisibility(View.GONE);
                  lineDaysOfUnable.setVisibility(View.GONE);
                  txtDaysOfUnable.setText("");
                  secDaysOfUnableDK.setVisibility(View.GONE);
                  lineDaysOfUnableDK.setVisibility(View.GONE);
                  chkDaysOfUnableDK.setChecked(false);
                  secTAdmHos.setVisibility(View.GONE);
                  lineTAdmHos.setVisibility(View.GONE);
                  rdogrpTAdmHos.clearCheck();
                  secTHosNamLabel.setVisibility(View.GONE);
                  lineTHosNamLabel.setVisibility(View.GONE);
                  secTHosNam.setVisibility(View.GONE);
                  lineTHosNam.setVisibility(View.GONE);
                  spnTHosNam.setSelection(0);
                  secTHosNam_Oth.setVisibility(View.GONE);
                  lineTHosNam_Oth.setVisibility(View.GONE);
                  txtTHosNam_Oth.setText("");
                  secTHosNam2.setVisibility(View.GONE);
                  lineTHosNam2.setVisibility(View.GONE);
                  spnTHosNam2.setSelection(0);
                  secTHosNam2_Oth.setVisibility(View.GONE);
                  lineTHosNam2_Oth.setVisibility(View.GONE);
                  txtTHosNam2_Oth.setText("");
                  secTHosNam3.setVisibility(View.GONE);
                  lineTHosNam3.setVisibility(View.GONE);
                  spnTHosNam3.setSelection(0);
                  secTHosNam3_Oth.setVisibility(View.GONE);
                  lineTHosNam3_Oth.setVisibility(View.GONE);
                  txtTHosNam3_Oth.setText("");
                  secTHosNamDK.setVisibility(View.GONE);
                  lineTHosNamDK.setVisibility(View.GONE);
                  chkTHosNamDK.setChecked(false);
                  secTDtAdmHos.setVisibility(View.GONE);
                  lineTDtAdmHos.setVisibility(View.GONE);
                  dtpTDtAdmHos.setText("");
                  secTAdmHosD.setVisibility(View.GONE);
                  lineTAdmHosD.setVisibility(View.GONE);
                  txtTAdmHosD.setText("");
                  secTDurIlBeHos.setVisibility(View.GONE);
                  lineTDurIlBeHos.setVisibility(View.GONE);
                  txtTDurIlBeHos.setText("");
                  secTDurIlBeHosDK.setVisibility(View.GONE);
                  lineTDurIlBeHosDK.setVisibility(View.GONE);
                  chkTDurIlBeHosDK.setChecked(false);
                  secTDisDr.setVisibility(View.GONE);
                  lineTDisDr.setVisibility(View.GONE);
                  spnTDisDr.setSelection(0);
                  secTDisDrOth.setVisibility(View.GONE);
                  lineTDisDrOth.setVisibility(View.GONE);
                  txtTDisDrOth.setText("");
                  secTReco.setVisibility(View.GONE);
                  lineTReco.setVisibility(View.GONE);
                  rdogrpTReco.clearCheck();
                  secTDurReco.setVisibility(View.GONE);
                  lineTDurReco.setVisibility(View.GONE);
                  txtTDurReco.setText("");
                  secTInRecoLabel.setVisibility(View.GONE);
                  lineTInRecoLabel.setVisibility(View.GONE);
                  secTInReco.setVisibility(View.GONE);
                  lineTInReco.setVisibility(View.GONE);
                  spnTInReco.setSelection(0);
                  secTInRecoOth.setVisibility(View.GONE);
                  lineTInRecoOth.setVisibility(View.GONE);
                  txtTInRecoOth.setText("");
                  secTInReco2.setVisibility(View.GONE);
                  lineTInReco2.setVisibility(View.GONE);
                  spnTInReco2.setSelection(0);
                  secTInRecoOth2.setVisibility(View.GONE);
                  lineTInRecoOth2.setVisibility(View.GONE);
                  txtTInRecoOth2.setText("");
                  secHaveHosp.setVisibility(View.GONE);
                  lineHaveHosp.setVisibility(View.GONE);
                  rdogrpHaveHosp.clearCheck();
                  secHospNameLabel.setVisibility(View.GONE);
                  lineHospNameLabel.setVisibility(View.GONE);
                  secHospName.setVisibility(View.GONE);
                  lineHospName.setVisibility(View.GONE);
//                  spnHospName.setSelection(0);
                  secHospName_Oth.setVisibility(View.GONE);
                  lineHospName_Oth.setVisibility(View.GONE);
                  txtHospName_Oth.setText("");
                  secHaveRecordsLabel.setVisibility(View.GONE);
                  lineHaveRecordsLabel.setVisibility(View.GONE);
                  secHaveRecords.setVisibility(View.GONE);
                  lineHaveRecords.setVisibility(View.GONE);
                  rdogrpHaveRecords.clearCheck();
                  secDidRecordMatch2.setVisibility(View.GONE);
                  lineDidRecordMatch2.setVisibility(View.GONE);
                  rdogrpDidRecordMatch2.clearCheck();
                  secDaysOfHosp.setVisibility(View.GONE);
                  lineDaysOfHosp.setVisibility(View.GONE);
                  txtDaysOfHosp.setText("");
                  secDaysOfHospDK.setVisibility(View.GONE);
                  lineDaysOfHospDK.setVisibility(View.GONE);
                  chkDaysOfHospDK.setChecked(false);
                  secTAboIll.setVisibility(View.GONE);
                  lineTAboIll.setVisibility(View.GONE);
                  txtTAboIll.setText("");
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secTsymptLabel=(LinearLayout)findViewById(R.id.secTsymptLabel);
         lineTsymptLabel=(View)findViewById(R.id.lineTsymptLabel);
         secAbdomPain=(LinearLayout)findViewById(R.id.secAbdomPain);
         lineAbdomPain=(View)findViewById(R.id.lineAbdomPain);
         VlblAbdomPain = (TextView) findViewById(R.id.VlblAbdomPain);
         rdogrpAbdomPain = (RadioGroup) findViewById(R.id.rdogrpAbdomPain);
         rdoAbdomPain1 = (RadioButton) findViewById(R.id.rdoAbdomPain1);
         rdoAbdomPain2 = (RadioButton) findViewById(R.id.rdoAbdomPain2);
         secConstipation=(LinearLayout)findViewById(R.id.secConstipation);
         lineConstipation=(View)findViewById(R.id.lineConstipation);
         VlblConstipation = (TextView) findViewById(R.id.VlblConstipation);
         rdogrpConstipation = (RadioGroup) findViewById(R.id.rdogrpConstipation);
         
         rdoConstipation1 = (RadioButton) findViewById(R.id.rdoConstipation1);
         rdoConstipation2 = (RadioButton) findViewById(R.id.rdoConstipation2);
         secHeadache=(LinearLayout)findViewById(R.id.secHeadache);
         lineHeadache=(View)findViewById(R.id.lineHeadache);
         VlblHeadache = (TextView) findViewById(R.id.VlblHeadache);
         rdogrpHeadache = (RadioGroup) findViewById(R.id.rdogrpHeadache);
         
         rdoHeadache1 = (RadioButton) findViewById(R.id.rdoHeadache1);
         rdoHeadache2 = (RadioButton) findViewById(R.id.rdoHeadache2);
         secRash=(LinearLayout)findViewById(R.id.secRash);
         lineRash=(View)findViewById(R.id.lineRash);
         VlblRash = (TextView) findViewById(R.id.VlblRash);
         rdogrpRash = (RadioGroup) findViewById(R.id.rdogrpRash);
         
         rdoRash1 = (RadioButton) findViewById(R.id.rdoRash1);
         rdoRash2 = (RadioButton) findViewById(R.id.rdoRash2);
         secDiarrhoea=(LinearLayout)findViewById(R.id.secDiarrhoea);
         lineDiarrhoea=(View)findViewById(R.id.lineDiarrhoea);
         VlblDiarrhoea = (TextView) findViewById(R.id.VlblDiarrhoea);
         rdogrpDiarrhoea = (RadioGroup) findViewById(R.id.rdogrpDiarrhoea);
         
         rdoDiarrhoea1 = (RadioButton) findViewById(R.id.rdoDiarrhoea1);
         rdoDiarrhoea2 = (RadioButton) findViewById(R.id.rdoDiarrhoea2);
         secAbdomDist=(LinearLayout)findViewById(R.id.secAbdomDist);
         lineAbdomDist=(View)findViewById(R.id.lineAbdomDist);
         VlblAbdomDist = (TextView) findViewById(R.id.VlblAbdomDist);
         rdogrpAbdomDist = (RadioGroup) findViewById(R.id.rdogrpAbdomDist);
         
         rdoAbdomDist1 = (RadioButton) findViewById(R.id.rdoAbdomDist1);
         rdoAbdomDist2 = (RadioButton) findViewById(R.id.rdoAbdomDist2);
         secCoaTon=(LinearLayout)findViewById(R.id.secCoaTon);
         lineCoaTon=(View)findViewById(R.id.lineCoaTon);
         VlblCoaTon = (TextView) findViewById(R.id.VlblCoaTon);
         rdogrpCoaTon = (RadioGroup) findViewById(R.id.rdogrpCoaTon);
         
         rdoCoaTon1 = (RadioButton) findViewById(R.id.rdoCoaTon1);
         rdoCoaTon2 = (RadioButton) findViewById(R.id.rdoCoaTon2);
         secCough=(LinearLayout)findViewById(R.id.secCough);
         lineCough=(View)findViewById(R.id.lineCough);
         VlblCough = (TextView) findViewById(R.id.VlblCough);
         rdogrpCough = (RadioGroup) findViewById(R.id.rdogrpCough);
         
         rdoCough1 = (RadioButton) findViewById(R.id.rdoCough1);
         rdoCough2 = (RadioButton) findViewById(R.id.rdoCough2);
         secTnone=(LinearLayout)findViewById(R.id.secTnone);
         lineTnone=(View)findViewById(R.id.lineTnone);
         VlblTnone = (TextView) findViewById(R.id.VlblTnone);
         rdogrpTnone = (RadioGroup) findViewById(R.id.rdogrpTnone);
         
         rdoTnone1 = (RadioButton) findViewById(R.id.rdoTnone1);
         rdoTnone2 = (RadioButton) findViewById(R.id.rdoTnone2);
         secOther=(LinearLayout)findViewById(R.id.secOther);
         lineOther=(View)findViewById(R.id.lineOther);
         VlblOther = (TextView) findViewById(R.id.VlblOther);
         rdogrpOther = (RadioGroup) findViewById(R.id.rdogrpOther);
         
         rdoOther1 = (RadioButton) findViewById(R.id.rdoOther1);
         rdoOther2 = (RadioButton) findViewById(R.id.rdoOther2);
         rdogrpOther.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpOther = new String[] {"1","2"};
             for (int i = 0; i < rdogrpOther.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpOther.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpOther[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secTsymptOthName.setVisibility(View.GONE);
                    lineTsymptOthName.setVisibility(View.GONE);
                    txtTsymptOthName.setText("");
             }
             else
             {
                    secTsymptOthName.setVisibility(View.VISIBLE);
                    lineTsymptOthName.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secTsymptOthName=(LinearLayout)findViewById(R.id.secTsymptOthName);
         lineTsymptOthName=(View)findViewById(R.id.lineTsymptOthName);
         VlblTsymptOthName=(TextView) findViewById(R.id.VlblTsymptOthName);
         txtTsymptOthName=(EditText) findViewById(R.id.txtTsymptOthName);
         secTakenHCFacility=(LinearLayout)findViewById(R.id.secTakenHCFacility);
         lineTakenHCFacility=(View)findViewById(R.id.lineTakenHCFacility);
         VlblTakenHCFacility = (TextView) findViewById(R.id.VlblTakenHCFacility);
         rdogrpTakenHCFacility = (RadioGroup) findViewById(R.id.rdogrpTakenHCFacility);
         
         rdoTakenHCFacility1 = (RadioButton) findViewById(R.id.rdoTakenHCFacility1);
         rdoTakenHCFacility2 = (RadioButton) findViewById(R.id.rdoTakenHCFacility2);
         rdoTakenHCFacility3 = (RadioButton) findViewById(R.id.rdoTakenHCFacility3);
         rdogrpTakenHCFacility.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpTakenHCFacility = new String[] {"1","2","8"};
             for (int i = 0; i < rdogrpTakenHCFacility.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpTakenHCFacility.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpTakenHCFacility[i];
             }

//             if(rbData.equalsIgnoreCase("2"))
//             {
//                    secTHCarTypLabel.setVisibility(View.GONE);
//                    lineTHCarTypLabel.setVisibility(View.GONE);
//                    secHC_PhyMBBS.setVisibility(View.GONE);
//                    lineHC_PhyMBBS.setVisibility(View.GONE);
//                    rdogrpHC_PhyMBBS.clearCheck();
//                    secHC_UnquaDoctor.setVisibility(View.GONE);
//                    lineHC_UnquaDoctor.setVisibility(View.GONE);
//                    rdogrpHC_UnquaDoctor.clearCheck();
//                    secHC_Para.setVisibility(View.GONE);
//                    lineHC_Para.setVisibility(View.GONE);
//                    rdogrpHC_Para.clearCheck();
//                    secHC_Com.setVisibility(View.GONE);
//                    lineHC_Com.setVisibility(View.GONE);
//                    rdogrpHC_Com.clearCheck();
//                    secHC_Pha.setVisibility(View.GONE);
//                    lineHC_Pha.setVisibility(View.GONE);
//                    rdogrpHC_Pha.clearCheck();
//                    secHC_Hompath.setVisibility(View.GONE);
//                    lineHC_Hompath.setVisibility(View.GONE);
//                    rdogrpHC_Hompath.clearCheck();
//                    secHC_TrHeal.setVisibility(View.GONE);
//                    lineHC_TrHeal.setVisibility(View.GONE);
//                    rdogrpHC_TrHeal.clearCheck();
//                    secHC_SpiHeal.setVisibility(View.GONE);
//                    lineHC_SpiHeal.setVisibility(View.GONE);
//                    rdogrpHC_SpiHeal.clearCheck();
//                    secTHC_Oth.setVisibility(View.GONE);
//                    lineTHC_Oth.setVisibility(View.GONE);
//                    rdogrpTHC_Oth.clearCheck();
//                    secTHC_OthName.setVisibility(View.GONE);
//                    lineTHC_OthName.setVisibility(View.GONE);
//                    txtTHC_OthName.setText("");
//             }
//             else if(rbData.equalsIgnoreCase("8"))
//             {
//                    secTHCarTypLabel.setVisibility(View.GONE);
//                    lineTHCarTypLabel.setVisibility(View.GONE);
//                    secHC_PhyMBBS.setVisibility(View.GONE);
//                    lineHC_PhyMBBS.setVisibility(View.GONE);
//                    rdogrpHC_PhyMBBS.clearCheck();
//                    secHC_UnquaDoctor.setVisibility(View.GONE);
//                    lineHC_UnquaDoctor.setVisibility(View.GONE);
//                    rdogrpHC_UnquaDoctor.clearCheck();
//                    secHC_Para.setVisibility(View.GONE);
//                    lineHC_Para.setVisibility(View.GONE);
//                    rdogrpHC_Para.clearCheck();
//                    secHC_Com.setVisibility(View.GONE);
//                    lineHC_Com.setVisibility(View.GONE);
//                    rdogrpHC_Com.clearCheck();
//                    secHC_Pha.setVisibility(View.GONE);
//                    lineHC_Pha.setVisibility(View.GONE);
//                    rdogrpHC_Pha.clearCheck();
//                    secHC_Hompath.setVisibility(View.GONE);
//                    lineHC_Hompath.setVisibility(View.GONE);
//                    rdogrpHC_Hompath.clearCheck();
//                    secHC_TrHeal.setVisibility(View.GONE);
//                    lineHC_TrHeal.setVisibility(View.GONE);
//                    rdogrpHC_TrHeal.clearCheck();
//                    secHC_SpiHeal.setVisibility(View.GONE);
//                    lineHC_SpiHeal.setVisibility(View.GONE);
//                    rdogrpHC_SpiHeal.clearCheck();
//                    secTHC_Oth.setVisibility(View.GONE);
//                    lineTHC_Oth.setVisibility(View.GONE);
//                    rdogrpTHC_Oth.clearCheck();
//                    secTHC_OthName.setVisibility(View.GONE);
//                    lineTHC_OthName.setVisibility(View.GONE);
//                    txtTHC_OthName.setText("");
//             }
              if(rbData.equalsIgnoreCase("1"))
             {
                    secTHCarTypLabel.setVisibility(View.VISIBLE);
                    lineTHCarTypLabel.setVisibility(View.VISIBLE);
                    secHC_PhyMBBS.setVisibility(View.VISIBLE);
                    lineHC_PhyMBBS.setVisibility(View.VISIBLE);
                    secHC_UnquaDoctor.setVisibility(View.VISIBLE);
                    lineHC_UnquaDoctor.setVisibility(View.VISIBLE);
                    secHC_Para.setVisibility(View.VISIBLE);
                    lineHC_Para.setVisibility(View.VISIBLE);
                    secHC_Com.setVisibility(View.VISIBLE);
                    lineHC_Com.setVisibility(View.VISIBLE);
                    secHC_Pha.setVisibility(View.VISIBLE);
                    lineHC_Pha.setVisibility(View.VISIBLE);
                    secHC_Hompath.setVisibility(View.VISIBLE);
                    lineHC_Hompath.setVisibility(View.VISIBLE);
                    secHC_TrHeal.setVisibility(View.VISIBLE);
                    lineHC_TrHeal.setVisibility(View.VISIBLE);
                    secHC_SpiHeal.setVisibility(View.VISIBLE);
                    lineHC_SpiHeal.setVisibility(View.VISIBLE);
                  secHC_Hosp.setVisibility(View.GONE);
                  lineHC_Hosp.setVisibility(View.GONE);
//                    secTHC_Oth.setVisibility(View.VISIBLE);
//                    lineTHC_Oth.setVisibility(View.VISIBLE);
             }
             else
             {
                  secTHCarTypLabel.setVisibility(View.GONE);
                  lineTHCarTypLabel.setVisibility(View.GONE);
                  secHC_PhyMBBS.setVisibility(View.GONE);
                  lineHC_PhyMBBS.setVisibility(View.GONE);
                  rdogrpHC_PhyMBBS.clearCheck();
                  secHC_UnquaDoctor.setVisibility(View.GONE);
                  lineHC_UnquaDoctor.setVisibility(View.GONE);
                  rdogrpHC_UnquaDoctor.clearCheck();
                  secHC_Para.setVisibility(View.GONE);
                  lineHC_Para.setVisibility(View.GONE);
                  rdogrpHC_Para.clearCheck();
                  secHC_Com.setVisibility(View.GONE);
                  lineHC_Com.setVisibility(View.GONE);
                  rdogrpHC_Com.clearCheck();
                  secHC_Pha.setVisibility(View.GONE);
                  lineHC_Pha.setVisibility(View.GONE);
                  rdogrpHC_Pha.clearCheck();
                  secHC_Hompath.setVisibility(View.GONE);
                  lineHC_Hompath.setVisibility(View.GONE);
                  rdogrpHC_Hompath.clearCheck();
                  secTHosNam_Oth.setVisibility(View.GONE);
                  secTHosNam2_Oth.setVisibility(View.GONE);
                  secTHosNam3_Oth.setVisibility(View.GONE);
                  lineTHosNam_Oth.setVisibility(View.GONE);
                  lineTHosNam2_Oth.setVisibility(View.GONE);
                  lineTHosNam3_Oth.setVisibility(View.GONE);
                  secTDisDrOth.setVisibility(View.GONE);
                  lineTDisDrOth.setVisibility(View.GONE);
                  secHC_TrHeal.setVisibility(View.GONE);
                  lineHC_TrHeal.setVisibility(View.GONE);
                  rdogrpHC_TrHeal.clearCheck();
                  secHC_SpiHeal.setVisibility(View.GONE);
                  lineHC_SpiHeal.setVisibility(View.GONE);
                  rdogrpHC_SpiHeal.clearCheck();
                  secTHC_Oth.setVisibility(View.GONE);
                  lineTHC_Oth.setVisibility(View.GONE);
                  rdogrpTHC_Oth.clearCheck();
                  secTHC_OthName.setVisibility(View.GONE);
                  lineTHC_OthName.setVisibility(View.GONE);
                  txtTHC_OthName.setText("");
                  secHC_Hosp.setVisibility(View.VISIBLE);
                  lineHC_Hosp.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secTHCarTypLabel=(LinearLayout)findViewById(R.id.secTHCarTypLabel);
         lineTHCarTypLabel=(View)findViewById(R.id.lineTHCarTypLabel);
         secHC_PhyMBBS=(LinearLayout)findViewById(R.id.secHC_PhyMBBS);
         lineHC_PhyMBBS=(View)findViewById(R.id.lineHC_PhyMBBS);
         VlblHC_PhyMBBS = (TextView) findViewById(R.id.VlblHC_PhyMBBS);
         rdogrpHC_PhyMBBS = (RadioGroup) findViewById(R.id.rdogrpHC_PhyMBBS);


         
         rdoHC_PhyMBBS1 = (RadioButton) findViewById(R.id.rdoHC_PhyMBBS1);
         rdoHC_PhyMBBS2 = (RadioButton) findViewById(R.id.rdoHC_PhyMBBS2);
         rdoHC_PhyMBBS3 = (RadioButton) findViewById(R.id.rdoHC_PhyMBBS3);
//         rdoHC_PhyMBBS4 = (RadioButton) findViewById(R.id.rdoHC_PhyMBBS4);
         secHC_UnquaDoctor=(LinearLayout)findViewById(R.id.secHC_UnquaDoctor);
         lineHC_UnquaDoctor=(View)findViewById(R.id.lineHC_UnquaDoctor);
         VlblHC_UnquaDoctor = (TextView) findViewById(R.id.VlblHC_UnquaDoctor);
         rdogrpHC_UnquaDoctor = (RadioGroup) findViewById(R.id.rdogrpHC_UnquaDoctor);
         
         rdoHC_UnquaDoctor1 = (RadioButton) findViewById(R.id.rdoHC_UnquaDoctor1);
         rdoHC_UnquaDoctor2 = (RadioButton) findViewById(R.id.rdoHC_UnquaDoctor2);
         rdoHC_UnquaDoctor3 = (RadioButton) findViewById(R.id.rdoHC_UnquaDoctor3);
         secHC_Para=(LinearLayout)findViewById(R.id.secHC_Para);
         lineHC_Para=(View)findViewById(R.id.lineHC_Para);
         VlblHC_Para = (TextView) findViewById(R.id.VlblHC_Para);
         rdogrpHC_Para = (RadioGroup) findViewById(R.id.rdogrpHC_Para);
         
         rdoHC_Para1 = (RadioButton) findViewById(R.id.rdoHC_Para1);
         rdoHC_Para2 = (RadioButton) findViewById(R.id.rdoHC_Para2);
         rdoHC_Para3 = (RadioButton) findViewById(R.id.rdoHC_Para3);
//         rdoHC_Para4 = (RadioButton) findViewById(R.id.rdoHC_Para4);
         secHC_Com=(LinearLayout)findViewById(R.id.secHC_Com);
         lineHC_Com=(View)findViewById(R.id.lineHC_Com);
         VlblHC_Com = (TextView) findViewById(R.id.VlblHC_Com);
         rdogrpHC_Com = (RadioGroup) findViewById(R.id.rdogrpHC_Com);
         
         rdoHC_Com1 = (RadioButton) findViewById(R.id.rdoHC_Com1);
         rdoHC_Com2 = (RadioButton) findViewById(R.id.rdoHC_Com2);
         rdoHC_Com3 = (RadioButton) findViewById(R.id.rdoHC_Com3);
//         rdoHC_Com4 = (RadioButton) findViewById(R.id.rdoHC_Com4);
         secHC_Pha=(LinearLayout)findViewById(R.id.secHC_Pha);
         lineHC_Pha=(View)findViewById(R.id.lineHC_Pha);
         VlblHC_Pha = (TextView) findViewById(R.id.VlblHC_Pha);
         rdogrpHC_Pha = (RadioGroup) findViewById(R.id.rdogrpHC_Pha);
         
         rdoHC_Pha1 = (RadioButton) findViewById(R.id.rdoHC_Pha1);
         rdoHC_Pha2 = (RadioButton) findViewById(R.id.rdoHC_Pha2);
         rdoHC_Pha3 = (RadioButton) findViewById(R.id.rdoHC_Pha3);
//         rdoHC_Pha4 = (RadioButton) findViewById(R.id.rdoHC_Pha4);
         secHC_Hompath=(LinearLayout)findViewById(R.id.secHC_Hompath);
         lineHC_Hompath=(View)findViewById(R.id.lineHC_Hompath);
         VlblHC_Hompath = (TextView) findViewById(R.id.VlblHC_Hompath);
         rdogrpHC_Hompath = (RadioGroup) findViewById(R.id.rdogrpHC_Hompath);
         
         rdoHC_Hompath1 = (RadioButton) findViewById(R.id.rdoHC_Hompath1);
         rdoHC_Hompath2 = (RadioButton) findViewById(R.id.rdoHC_Hompath2);
         rdoHC_Hompath3 = (RadioButton) findViewById(R.id.rdoHC_Hompath3);
         secHC_TrHeal=(LinearLayout)findViewById(R.id.secHC_TrHeal);
         lineHC_TrHeal=(View)findViewById(R.id.lineHC_TrHeal);
         VlblHC_TrHeal = (TextView) findViewById(R.id.VlblHC_TrHeal);
         rdogrpHC_TrHeal = (RadioGroup) findViewById(R.id.rdogrpHC_TrHeal);
         
         rdoHC_TrHeal1 = (RadioButton) findViewById(R.id.rdoHC_TrHeal1);
         rdoHC_TrHeal2 = (RadioButton) findViewById(R.id.rdoHC_TrHeal2);
         rdoHC_TrHeal3 = (RadioButton) findViewById(R.id.rdoHC_TrHeal3);
//         rdoHC_TrHeal4 = (RadioButton) findViewById(R.id.rdoHC_TrHeal4);
         secHC_SpiHeal=(LinearLayout)findViewById(R.id.secHC_SpiHeal);
         lineHC_SpiHeal=(View)findViewById(R.id.lineHC_SpiHeal);
         VlblHC_SpiHeal = (TextView) findViewById(R.id.VlblHC_SpiHeal);
         rdogrpHC_SpiHeal = (RadioGroup) findViewById(R.id.rdogrpHC_SpiHeal);
         
         rdoHC_SpiHeal1 = (RadioButton) findViewById(R.id.rdoHC_SpiHeal1);
         rdoHC_SpiHeal2 = (RadioButton) findViewById(R.id.rdoHC_SpiHeal2);
         rdoHC_SpiHeal3 = (RadioButton) findViewById(R.id.rdoHC_SpiHeal3);
         secTHC_Oth=(LinearLayout)findViewById(R.id.secTHC_Oth);
         lineTHC_Oth=(View)findViewById(R.id.lineTHC_Oth);
         VlblTHC_Oth = (TextView) findViewById(R.id.VlblTHC_Oth);
         rdogrpTHC_Oth = (RadioGroup) findViewById(R.id.rdogrpTHC_Oth);
         
         rdoTHC_Oth1 = (RadioButton) findViewById(R.id.rdoTHC_Oth1);
         rdoTHC_Oth2 = (RadioButton) findViewById(R.id.rdoTHC_Oth2);
         rdoTHC_Oth3 = (RadioButton) findViewById(R.id.rdoTHC_Oth3);
//         rdoTHC_Oth4 = (RadioButton) findViewById(R.id.rdoTHC_Oth4);


          rdogrpHC_PhyMBBS.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(RadioGroup radioGroup, int radioButtonID) {
                    String rbData = "";
                    RadioButton rb;
                    String[] d_radioButtonID = new String[] {"1","2","8"};
                    for (int i = 0; i < rdogrpHC_PhyMBBS.getChildCount(); i++)
                    {
                         rb = (RadioButton)rdogrpHC_PhyMBBS.getChildAt(i);
                         if (rb.isChecked()) rbData = d_radioButtonID[i];

                    }

                    //************************************************************************************
                    //****************** Unqualified doctor/LMAF
                    String rbData1 = "";
                    RadioButton rb1;
                    String[] d_rdogrpHC_UnquaDoctor = new String[] {"1","2","8"};
                    for (int i = 0; i < rdogrpHC_UnquaDoctor.getChildCount(); i++)
                    {
                         rb1 = (RadioButton)rdogrpHC_UnquaDoctor.getChildAt(i);
                         if (rb1.isChecked()) rbData1 = d_rdogrpHC_UnquaDoctor[i];
                    }

                    //****************** Paramedics
                    String rbData2 = "";
                    RadioButton rb2;
                    String[] d_rdogrpHC_Para = new String[] {"1","2","8"};
                    for (int i = 0; i < rdogrpHC_Para.getChildCount(); i++)
                    {
                         rb2 = (RadioButton)rdogrpHC_Para.getChildAt(i);
                         if (rb2.isChecked()) rbData2 = d_rdogrpHC_Para[i];
                    }

                    //****************** Compounder
                    String rbData3 = "";
                    RadioButton rb3;
                    String[] d_rdogrpHC_Com = new String[] {"1","2","8"};
                    for (int i = 0; i < rdogrpHC_Com.getChildCount(); i++)
                    {
                         rb3 = (RadioButton)rdogrpHC_Com.getChildAt(i);
                         if (rb3.isChecked()) rbData3 = d_rdogrpHC_Com[i];
                    }
                    //**************************************************************************************


                    if(rbData.equalsIgnoreCase("1"))
                    {
                         secTHosNamLabel.setVisibility(View.GONE);
                         lineTHosNamLabel.setVisibility(View.GONE);
                         secTHosNam.setVisibility(View.GONE);
                         lineTHosNam.setVisibility(View.GONE);
                         spnTHosNam.setSelection(0);
                         secTHosNam_Oth.setVisibility(View.GONE);
                         lineTHosNam_Oth.setVisibility(View.GONE);
                         txtTHosNam_Oth.setText("");
                         secTHosNam2.setVisibility(View.GONE);
                         lineTHosNam2.setVisibility(View.GONE);
                         spnTHosNam2.setSelection(0);
                         secTHosNam2_Oth.setVisibility(View.GONE);
                         lineTHosNam2_Oth.setVisibility(View.GONE);
                         txtTHosNam2_Oth.setText("");
                         secTHosNam3.setVisibility(View.GONE);
                         lineTHosNam3.setVisibility(View.GONE);
                         spnTHosNam3.setSelection(0);
                         secTHosNam3_Oth.setVisibility(View.GONE);
                         lineTHosNam3_Oth.setVisibility(View.GONE);
                         txtTHosNam3_Oth.setText("");
                         secTHosNamDK.setVisibility(View.GONE);
                         lineTHosNamDK.setVisibility(View.GONE);
                         chkTHosNamDK.setChecked(false);
                         secTDtAdmHos.setVisibility(View.GONE);
                         lineTDtAdmHos.setVisibility(View.GONE);
                         dtpTDtAdmHos.setText("");
                         secTAdmHosD.setVisibility(View.GONE);
                         lineTAdmHosD.setVisibility(View.GONE);
                         txtTAdmHosD.setText("");
                         secTDurIlBeHos.setVisibility(View.GONE);
                         lineTDurIlBeHos.setVisibility(View.GONE);
                         txtTDurIlBeHos.setText("");
                         secTDurIlBeHosDK.setVisibility(View.GONE);
                         lineTDurIlBeHosDK.setVisibility(View.GONE);
                         chkTDurIlBeHosDK.setChecked(false);
                         secTDisDr.setVisibility(View.VISIBLE);
                         lineTDisDr.setVisibility(View.VISIBLE);
                         spnTDisDr.setSelection(0);


                         secHC_Hosp.setVisibility(View.VISIBLE);
                         lineHC_Hosp.setVisibility(View.VISIBLE);
                         rdogrpHC_Hosp.clearCheck();
                         rdogrpHC_Phy.clearCheck();
                         rdogrpHC_Clin.clearCheck();
                         secHC_Clin.setVisibility(View.VISIBLE);
                         lineHC_Clin.setVisibility(View.VISIBLE);

                         secHC_Phy.setVisibility(View.VISIBLE);
                         lineHC_Phy.setVisibility(View.VISIBLE);

                    }
                    else if(rbData.equalsIgnoreCase("2") | rbData.equalsIgnoreCase("8"))
                    {
                         secTHosNamLabel.setVisibility(View.GONE);
                         lineTHosNamLabel.setVisibility(View.GONE);
                         secTHosNam.setVisibility(View.GONE);
                         lineTHosNam.setVisibility(View.GONE);
                         spnTHosNam.setSelection(0);
                         secTHosNam_Oth.setVisibility(View.GONE);
                         lineTHosNam_Oth.setVisibility(View.GONE);
                         txtTHosNam_Oth.setText("");
                         secTHosNam2.setVisibility(View.GONE);
                         lineTHosNam2.setVisibility(View.GONE);
                         spnTHosNam2.setSelection(0);
                         secTHosNam2_Oth.setVisibility(View.GONE);
                         lineTHosNam2_Oth.setVisibility(View.GONE);
                         txtTHosNam2_Oth.setText("");
                         secTHosNam3.setVisibility(View.GONE);
                         lineTHosNam3.setVisibility(View.GONE);
                         spnTHosNam3.setSelection(0);
                         secTHosNam3_Oth.setVisibility(View.GONE);
                         lineTHosNam3_Oth.setVisibility(View.GONE);
                         txtTHosNam3_Oth.setText("");
                         secTHosNamDK.setVisibility(View.GONE);
                         lineTHosNamDK.setVisibility(View.GONE);
                         chkTHosNamDK.setChecked(false);
                         secTDtAdmHos.setVisibility(View.GONE);
                         lineTDtAdmHos.setVisibility(View.GONE);
                         dtpTDtAdmHos.setText("");
                         secTAdmHosD.setVisibility(View.GONE);
                         lineTAdmHosD.setVisibility(View.GONE);
                         txtTAdmHosD.setText("");
                         secTDurIlBeHos.setVisibility(View.GONE);
                         lineTDurIlBeHos.setVisibility(View.GONE);
                         txtTDurIlBeHos.setText("");
                         secTDurIlBeHosDK.setVisibility(View.GONE);
                         lineTDurIlBeHosDK.setVisibility(View.GONE);
                         chkTDurIlBeHosDK.setChecked(false);
                         secTDisDr.setVisibility(View.GONE);
                         lineTDisDr.setVisibility(View.GONE);
                         spnTDisDr.setSelection(0);
                         secTDisDrOth.setVisibility(View.GONE);
                         lineTDisDrOth.setVisibility(View.GONE);
                         txtTDisDrOth.setText("");


                         //***********************
                         if(rbData.equalsIgnoreCase("2") & rbData1.equalsIgnoreCase("2")& rbData2.equalsIgnoreCase("2")&rbData3.equalsIgnoreCase("2"))
                         {
                              secHC_Hosp.setVisibility(View.VISIBLE);
                              lineHC_Hosp.setVisibility(View.VISIBLE);
                              rdogrpHC_Hosp.check(R.id.rdoHC_Hosp2);

                              secHC_Phy.setVisibility(View.VISIBLE);
                              lineHC_Phy.setVisibility(View.VISIBLE);
                              rdogrpHC_Phy.check(R.id.rdoHC_Phy2);

                              secHC_Clin.setVisibility(View.VISIBLE);
                              lineHC_Clin.setVisibility(View.VISIBLE);
                              rdogrpHC_Clin.check(R.id.rdoHC_Clin2);
                         }
                    }
                    else
                    {
                         secTHosNamLabel.setVisibility(View.VISIBLE);
                         lineTHosNamLabel.setVisibility(View.VISIBLE);
                         secTHosNam.setVisibility(View.VISIBLE);
                         lineTHosNam.setVisibility(View.VISIBLE);
                         spnTHosNam.setSelection(0);
                         secTHosNam_Oth.setVisibility(View.VISIBLE);
                         lineTHosNam_Oth.setVisibility(View.VISIBLE);
                         txtTHosNam_Oth.setText("");
                         secTHosNam2.setVisibility(View.VISIBLE);
                         lineTHosNam2.setVisibility(View.VISIBLE);
                         spnTHosNam2.setSelection(0);
                         secTHosNam2_Oth.setVisibility(View.VISIBLE);
                         lineTHosNam2_Oth.setVisibility(View.VISIBLE);
                         txtTHosNam2_Oth.setText("");
                         secTHosNam3.setVisibility(View.VISIBLE);
                         lineTHosNam3.setVisibility(View.VISIBLE);
                         spnTHosNam3.setSelection(0);
                         secTHosNam3_Oth.setVisibility(View.VISIBLE);
                         lineTHosNam3_Oth.setVisibility(View.VISIBLE);
                         txtTHosNam3_Oth.setText("");
                         secTHosNamDK.setVisibility(View.VISIBLE);
                         lineTHosNamDK.setVisibility(View.VISIBLE);
                         chkTHosNamDK.setChecked(false);
                         secTDtAdmHos.setVisibility(View.VISIBLE);
                         lineTDtAdmHos.setVisibility(View.VISIBLE);
                         dtpTDtAdmHos.setText("");
                         secTAdmHosD.setVisibility(View.VISIBLE);
                         lineTAdmHosD.setVisibility(View.VISIBLE);
                         txtTAdmHosD.setText("");
                         secTDurIlBeHos.setVisibility(View.VISIBLE);
                         lineTDurIlBeHos.setVisibility(View.VISIBLE);
                         txtTDurIlBeHos.setText("");
                         secTDurIlBeHosDK.setVisibility(View.VISIBLE);
                         lineTDurIlBeHosDK.setVisibility(View.VISIBLE);
                         chkTDurIlBeHosDK.setChecked(false);
                         secTDisDr.setVisibility(View.VISIBLE);
                         lineTDisDr.setVisibility(View.VISIBLE);
                         spnTDisDr.setSelection(0);
                         secTDisDrOth.setVisibility(View.VISIBLE);
                         lineTDisDrOth.setVisibility(View.VISIBLE);
                         txtTDisDrOth.setText("");
                    }
               }
          });



          rdogrpHC_UnquaDoctor.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(RadioGroup radioGroup, int radioButtonID) {
                    String rbData = "";
                    RadioButton rb;
                    String[] d_rdogrpHC_UnquaDoctor = new String[]{"1", "2", "8"};
                    for (int i = 0; i < rdogrpHC_UnquaDoctor.getChildCount(); i++) {
                         rb = (RadioButton) rdogrpHC_UnquaDoctor.getChildAt(i);
                         if (rb.isChecked()) rbData = d_rdogrpHC_UnquaDoctor[i];

                    }

                    //************************************************************************************
                    //****************** MBBS
                    String rbData1 = "";
                    RadioButton rb1;
                    String[] d_rdogrpHC_PhyMBBS = new String[] {"1","2","8"};
                    for (int i = 0; i < rdogrpHC_PhyMBBS.getChildCount(); i++)
                    {
                         rb1 = (RadioButton)rdogrpHC_PhyMBBS.getChildAt(i);
                         if (rb1.isChecked()) rbData1 = d_rdogrpHC_PhyMBBS[i];
                    }

                    //****************** Paramedics
                    String rbData2 = "";
                    RadioButton rb2;
                    String[] d_rdogrpHC_Para = new String[] {"1","2","8"};
                    for (int i = 0; i < rdogrpHC_Para.getChildCount(); i++)
                    {
                         rb2 = (RadioButton)rdogrpHC_Para.getChildAt(i);
                         if (rb2.isChecked()) rbData2 = d_rdogrpHC_Para[i];
                    }

                    //****************** Compounder
                    String rbData3 = "";
                    RadioButton rb3;
                    String[] d_rdogrpHC_Com = new String[] {"1","2","8"};
                    for (int i = 0; i < rdogrpHC_Com.getChildCount(); i++)
                    {
                         rb3 = (RadioButton)rdogrpHC_Com.getChildAt(i);
                         if (rb3.isChecked()) rbData3 = d_rdogrpHC_Com[i];
                    }
                    //**************************************************************************************

                    if(rbData.equalsIgnoreCase("1"))
                    {
                         secHC_Hosp.setVisibility(View.VISIBLE);
                         lineHC_Hosp.setVisibility(View.VISIBLE);
                         rdogrpHC_Hosp.clearCheck();
                         rdogrpHC_Phy.clearCheck();
                         rdogrpHC_Clin.clearCheck();
                         secHC_Clin.setVisibility(View.VISIBLE);
                         lineHC_Clin.setVisibility(View.VISIBLE);
                         secHC_Phy.setVisibility(View.VISIBLE);
                         lineHC_Phy.setVisibility(View.VISIBLE);
                    }
                    if(rbData.equalsIgnoreCase("2") & rbData1.equalsIgnoreCase("2")& rbData2.equalsIgnoreCase("2")&rbData3.equalsIgnoreCase("2"))
                    {
                         secHC_Hosp.setVisibility(View.VISIBLE);
                         lineHC_Hosp.setVisibility(View.VISIBLE);
                         rdogrpHC_Hosp.check(R.id.rdoHC_Hosp2);
                         secHC_Phy.setVisibility(View.VISIBLE);
                         lineHC_Phy.setVisibility(View.VISIBLE);
                         rdogrpHC_Phy.check(R.id.rdoHC_Phy2);
                         secHC_Clin.setVisibility(View.VISIBLE);
                         lineHC_Clin.setVisibility(View.VISIBLE);
                         rdogrpHC_Clin.check(R.id.rdoHC_Clin2);
                    }

               }

          });

          rdogrpHC_Para.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(RadioGroup radioGroup, int radioButtonID) {
                    String rbData = "";
                    RadioButton rb;
                    String[] d_rdogrpHC_UnquaDoctor = new String[]{"1", "2", "8"};
                    for (int i = 0; i < rdogrpHC_UnquaDoctor.getChildCount(); i++) {
                         rb = (RadioButton) rdogrpHC_UnquaDoctor.getChildAt(i);
                         if (rb.isChecked()) rbData = d_rdogrpHC_UnquaDoctor[i];

                    }

                    //************************************************************************************
                    //****************** MBBS
                    String rbData1 = "";
                    RadioButton rb1;
                    String[] d_rdogrpHC_PhyMBBS = new String[] {"1","2","8"};
                    for (int i = 0; i < rdogrpHC_PhyMBBS.getChildCount(); i++)
                    {
                         rb1 = (RadioButton)rdogrpHC_PhyMBBS.getChildAt(i);
                         if (rb1.isChecked()) rbData1 = d_rdogrpHC_PhyMBBS[i];
                    }

                    //****************** Paramedics
                    String rbData2 = "";
                    RadioButton rb2;
                    String[] d_rdogrpHC_Para = new String[] {"1","2","8"};
                    for (int i = 0; i < rdogrpHC_Para.getChildCount(); i++)
                    {
                         rb2 = (RadioButton)rdogrpHC_Para.getChildAt(i);
                         if (rb2.isChecked()) rbData2 = d_rdogrpHC_Para[i];
                    }

                    //****************** Compounder
                    String rbData3 = "";
                    RadioButton rb3;
                    String[] d_rdogrpHC_Com = new String[] {"1","2","8"};
                    for (int i = 0; i < rdogrpHC_Com.getChildCount(); i++)
                    {
                         rb3 = (RadioButton)rdogrpHC_Com.getChildAt(i);
                         if (rb3.isChecked()) rbData3 = d_rdogrpHC_Com[i];
                    }
                    //**************************************************************************************

                    if(rbData2.equalsIgnoreCase("1"))
                    {
                         secHC_Hosp.setVisibility(View.VISIBLE);
                         lineHC_Hosp.setVisibility(View.VISIBLE);
                         rdogrpHC_Hosp.clearCheck();
                         rdogrpHC_Phy.clearCheck();
                         rdogrpHC_Clin.clearCheck();
                         secHC_Clin.setVisibility(View.VISIBLE);
                         lineHC_Clin.setVisibility(View.VISIBLE);
                         secHC_Phy.setVisibility(View.VISIBLE);
                         lineHC_Phy.setVisibility(View.VISIBLE);
                    }
                    if(rbData.equalsIgnoreCase("2") & rbData1.equalsIgnoreCase("2")& rbData2.equalsIgnoreCase("2")&rbData3.equalsIgnoreCase("2"))
                    {
                         secHC_Hosp.setVisibility(View.VISIBLE);
                         lineHC_Hosp.setVisibility(View.VISIBLE);
                         rdogrpHC_Hosp.check(R.id.rdoHC_Hosp2);

                         secHC_Phy.setVisibility(View.VISIBLE);
                         lineHC_Phy.setVisibility(View.VISIBLE);
                         rdogrpHC_Phy.check(R.id.rdoHC_Phy2);

                         secHC_Clin.setVisibility(View.VISIBLE);
                         lineHC_Clin.setVisibility(View.VISIBLE);
                         rdogrpHC_Clin.check(R.id.rdoHC_Clin2);
                    }

               }

          });

          rdogrpHC_Com.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(RadioGroup radioGroup, int radioButtonID) {
                    String rbData = "";
                    RadioButton rb;
                    String[] d_rdogrpHC_UnquaDoctor = new String[]{"1", "2", "8"};
                    for (int i = 0; i < rdogrpHC_UnquaDoctor.getChildCount(); i++) {
                         rb = (RadioButton) rdogrpHC_UnquaDoctor.getChildAt(i);
                         if (rb.isChecked()) rbData = d_rdogrpHC_UnquaDoctor[i];

                    }

                    //************************************************************************************
                    //****************** MBBS
                    String rbData1 = "";
                    RadioButton rb1;
                    String[] d_rdogrpHC_PhyMBBS = new String[] {"1","2","8"};
                    for (int i = 0; i < rdogrpHC_PhyMBBS.getChildCount(); i++)
                    {
                         rb1 = (RadioButton)rdogrpHC_PhyMBBS.getChildAt(i);
                         if (rb1.isChecked()) rbData1 = d_rdogrpHC_PhyMBBS[i];
                    }

                    //****************** Paramedics
                    String rbData2 = "";
                    RadioButton rb2;
                    String[] d_rdogrpHC_Para = new String[] {"1","2","8"};
                    for (int i = 0; i < rdogrpHC_Para.getChildCount(); i++)
                    {
                         rb2 = (RadioButton)rdogrpHC_Para.getChildAt(i);
                         if (rb2.isChecked()) rbData2 = d_rdogrpHC_Para[i];
                    }

                    //****************** Compounder
                    String rbData3 = "";
                    RadioButton rb3;
                    String[] d_rdogrpHC_Com = new String[] {"1","2","8"};
                    for (int i = 0; i < rdogrpHC_Com.getChildCount(); i++)
                    {
                         rb3 = (RadioButton)rdogrpHC_Com.getChildAt(i);
                         if (rb3.isChecked()) rbData3 = d_rdogrpHC_Com[i];
                    }
                    //**************************************************************************************

                    if(rbData3.equalsIgnoreCase("1"))
                    {
                         secHC_Hosp.setVisibility(View.VISIBLE);
                         lineHC_Hosp.setVisibility(View.VISIBLE);
                         rdogrpHC_Hosp.clearCheck();
                         rdogrpHC_Phy.clearCheck();
                         rdogrpHC_Clin.clearCheck();
                         secHC_Clin.setVisibility(View.VISIBLE);
                         lineHC_Clin.setVisibility(View.VISIBLE);
                         secHC_Phy.setVisibility(View.VISIBLE);
                         lineHC_Phy.setVisibility(View.VISIBLE);
                    }
                    if(rbData.equalsIgnoreCase("2") & rbData1.equalsIgnoreCase("2")& rbData2.equalsIgnoreCase("2")&rbData3.equalsIgnoreCase("2"))
                    {
                         secHC_Hosp.setVisibility(View.VISIBLE);
                         lineHC_Hosp.setVisibility(View.VISIBLE);
                         rdogrpHC_Hosp.check(R.id.rdoHC_Hosp2);

                         secHC_Phy.setVisibility(View.VISIBLE);
                         lineHC_Phy.setVisibility(View.VISIBLE);
                         rdogrpHC_Phy.check(R.id.rdoHC_Phy2);

                         secHC_Clin.setVisibility(View.VISIBLE);
                         lineHC_Clin.setVisibility(View.VISIBLE);
                         rdogrpHC_Clin.check(R.id.rdoHC_Clin2);
                    }

               }

          });



//
         rdogrpTHC_Oth.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpTHC_Oth = new String[] {"1","2","8"};
             for (int i = 0; i < rdogrpTHC_Oth.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpTHC_Oth.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpTHC_Oth[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secTHC_OthName.setVisibility(View.GONE);
                    lineTHC_OthName.setVisibility(View.GONE);
                    txtTHC_OthName.setText("");
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secTHC_OthName.setVisibility(View.GONE);
                    lineTHC_OthName.setVisibility(View.GONE);
                    txtTHC_OthName.setText("");
             }
             else
             {
                    secTHC_OthName.setVisibility(View.VISIBLE);
                    lineTHC_OthName.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secTHC_OthName=(LinearLayout)findViewById(R.id.secTHC_OthName);
         lineTHC_OthName=(View)findViewById(R.id.lineTHC_OthName);
         VlblTHC_OthName=(TextView) findViewById(R.id.VlblTHC_OthName);
         txtTHC_OthName=(EditText) findViewById(R.id.txtTHC_OthName);
         secHC_Hosp=(LinearLayout)findViewById(R.id.secHC_Hosp);
         lineHC_Hosp=(View)findViewById(R.id.lineHC_Hosp);
         VlblHC_Hosp = (TextView) findViewById(R.id.VlblHC_Hosp);
         rdogrpHC_Hosp = (RadioGroup) findViewById(R.id.rdogrpHC_Hosp);
         
         rdoHC_Hosp1 = (RadioButton) findViewById(R.id.rdoHC_Hosp1);
         rdoHC_Hosp2 = (RadioButton) findViewById(R.id.rdoHC_Hosp2);
         rdoHC_Hosp3 = (RadioButton) findViewById(R.id.rdoHC_Hosp3);
         rdogrpHC_Hosp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpHC_Hosp = new String[] {"1","2","8"};
             for (int i = 0; i < rdogrpHC_Hosp.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpHC_Hosp.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpHC_Hosp[i];
             }

             if(rbData.equalsIgnoreCase("1"))
             {
                  secHC_HospLabel.setVisibility(View.VISIBLE);
                  lineHC_HospLabel.setVisibility(View.VISIBLE);
                  secHC_Hosp_a1.setVisibility(View.VISIBLE);
                  lineHC_Hosp_a1.setVisibility(View.VISIBLE);

                  secHC_Hosp_a2.setVisibility(View.VISIBLE);
                  lineHC_Hosp_a2.setVisibility(View.VISIBLE);

                  secHC_Hosp_a3.setVisibility(View.VISIBLE);
                  lineHC_Hosp_a3.setVisibility(View.VISIBLE);

                  secHC_Hosp_a4.setVisibility(View.VISIBLE);
                  lineHC_Hosp_a4.setVisibility(View.VISIBLE);

                  secHC_Hosp_a5.setVisibility(View.VISIBLE);
                  lineHC_Hosp_a5.setVisibility(View.VISIBLE);

                  secHC_Hosp_bLabel.setVisibility(View.VISIBLE);
                  lineHC_Hosp_bLabel.setVisibility(View.VISIBLE);
                  secHC_Hosp_b.setVisibility(View.VISIBLE);
                  lineHC_Hosp_b.setVisibility(View.VISIBLE);
                  secHC_Hosp_b_i.setVisibility(View.GONE);
                  lineHC_Hosp_b_i.setVisibility(View.GONE);
                  rdogrpHC_Hosp_b_i.clearCheck();
                  secHC_Clin.setVisibility(View.GONE);
                  lineHC_Clin.setVisibility(View.GONE);
             }
//             else if(rbData.equalsIgnoreCase("2"))
//             {
//                  secHC_HospLabel.setVisibility(View.GONE);
//                  lineHC_HospLabel.setVisibility(View.GONE);
//                  secHC_Hosp_a1.setVisibility(View.GONE);
//                  lineHC_Hosp_a1.setVisibility(View.GONE);
//                  spnHC_Hosp_a1.setSelection(0);
//                  secHC_Hosp_a1_Oth.setVisibility(View.GONE);
//                  lineHC_Hosp_a1_Oth.setVisibility(View.GONE);
//                  txtHC_Hosp_a1_Oth.setText("");
//                  secHC_Hosp_a2.setVisibility(View.GONE);
//                  lineHC_Hosp_a2.setVisibility(View.GONE);
//                  spnHC_Hosp_a2.setSelection(0);
//                  secHC_Hosp_a2_Oth.setVisibility(View.GONE);
//                  lineHC_Hosp_a2_Oth.setVisibility(View.GONE);
//                  txtHC_Hosp_a2_Oth.setText("");
//                  secHC_Hosp_a3.setVisibility(View.GONE);
//                  lineHC_Hosp_a3.setVisibility(View.GONE);
//                  spnHC_Hosp_a3.setSelection(0);
//                  secHC_Hosp_a3_Oth.setVisibility(View.GONE);
//                  lineHC_Hosp_a3_Oth.setVisibility(View.GONE);
//                  txtHC_Hosp_a3_Oth.setText("");
//                  secHC_Hosp_a4.setVisibility(View.GONE);
//                  lineHC_Hosp_a4.setVisibility(View.GONE);
//                  spnHC_Hosp_a4.setSelection(0);
//                  secHC_Hosp_a4_Oth.setVisibility(View.GONE);
//                  lineHC_Hosp_a4_Oth.setVisibility(View.GONE);
//                  txtHC_Hosp_a4_Oth.setText("");
//                  secHC_Hosp_a5.setVisibility(View.GONE);
//                  lineHC_Hosp_a5.setVisibility(View.GONE);
//                  spnHC_Hosp_a5.setSelection(0);
//                  secHC_Hosp_a5_Oth.setVisibility(View.GONE);
//                  lineHC_Hosp_a5_Oth.setVisibility(View.GONE);
//                  txtHC_Hosp_a5_Oth.setText("");
//                  secHC_Hosp_bLabel.setVisibility(View.GONE);
//                  lineHC_Hosp_bLabel.setVisibility(View.GONE);
//                  secHC_Hosp_b.setVisibility(View.GONE);
//                  lineHC_Hosp_b.setVisibility(View.GONE);
//                  rdogrpHC_Hosp_b.clearCheck();
//                  secHC_Hosp_b_i.setVisibility(View.GONE);
//                  lineHC_Hosp_b_i.setVisibility(View.GONE);
//                  rdogrpHC_Hosp_b_i.clearCheck();
//             }
//             else if(rbData.equalsIgnoreCase("8"))
//              {
//                   secHC_HospLabel.setVisibility(View.GONE);
//                   lineHC_HospLabel.setVisibility(View.GONE);
//                   secHC_Hosp_a1.setVisibility(View.GONE);
//                   lineHC_Hosp_a1.setVisibility(View.GONE);
//                   spnHC_Hosp_a1.setSelection(0);
//                   secHC_Hosp_a1_Oth.setVisibility(View.GONE);
//                   lineHC_Hosp_a1_Oth.setVisibility(View.GONE);
//                   txtHC_Hosp_a1_Oth.setText("");
//                   secHC_Hosp_a2.setVisibility(View.GONE);
//                   lineHC_Hosp_a2.setVisibility(View.GONE);
//                   spnHC_Hosp_a2.setSelection(0);
//                   secHC_Hosp_a2_Oth.setVisibility(View.GONE);
//                   lineHC_Hosp_a2_Oth.setVisibility(View.GONE);
//                   txtHC_Hosp_a2_Oth.setText("");
//                   secHC_Hosp_a3.setVisibility(View.GONE);
//                   lineHC_Hosp_a3.setVisibility(View.GONE);
//                   spnHC_Hosp_a3.setSelection(0);
//                   secHC_Hosp_a3_Oth.setVisibility(View.GONE);
//                   lineHC_Hosp_a3_Oth.setVisibility(View.GONE);
//                   txtHC_Hosp_a3_Oth.setText("");
//                   secHC_Hosp_a4.setVisibility(View.GONE);
//                   lineHC_Hosp_a4.setVisibility(View.GONE);
//                   spnHC_Hosp_a4.setSelection(0);
//                   secHC_Hosp_a4_Oth.setVisibility(View.GONE);
//                   lineHC_Hosp_a4_Oth.setVisibility(View.GONE);
//                   txtHC_Hosp_a4_Oth.setText("");
//                   secHC_Hosp_a5.setVisibility(View.GONE);
//                   lineHC_Hosp_a5.setVisibility(View.GONE);
//                   spnHC_Hosp_a5.setSelection(0);
//                   secHC_Hosp_a5_Oth.setVisibility(View.GONE);
//                   lineHC_Hosp_a5_Oth.setVisibility(View.GONE);
//                   txtHC_Hosp_a5_Oth.setText("");
//                   secHC_Hosp_bLabel.setVisibility(View.GONE);
//                   lineHC_Hosp_bLabel.setVisibility(View.GONE);
//                   secHC_Hosp_b.setVisibility(View.GONE);
//                   lineHC_Hosp_b.setVisibility(View.GONE);
//                   rdogrpHC_Hosp_b.clearCheck();
//                   secHC_Hosp_b_i.setVisibility(View.GONE);
//                   lineHC_Hosp_b_i.setVisibility(View.GONE);
//                   rdogrpHC_Hosp_b_i.clearCheck();
//              }
             else
             {
                    secHC_HospLabel.setVisibility(View.GONE);
                    lineHC_HospLabel.setVisibility(View.GONE);
                    secHC_Hosp_a1.setVisibility(View.GONE);
                    lineHC_Hosp_a1.setVisibility(View.GONE);
                    spnHC_Hosp_a1.setSelection(0);
                    secHC_Hosp_a1_Oth.setVisibility(View.GONE);
                    lineHC_Hosp_a1_Oth.setVisibility(View.GONE);
                    txtHC_Hosp_a1_Oth.setText("");
                    secHC_Hosp_a2.setVisibility(View.GONE);
                    lineHC_Hosp_a2.setVisibility(View.GONE);
                    spnHC_Hosp_a2.setSelection(0);
                    secHC_Hosp_a2_Oth.setVisibility(View.GONE);
                    lineHC_Hosp_a2_Oth.setVisibility(View.GONE);
                    txtHC_Hosp_a2_Oth.setText("");
                    secHC_Hosp_a3.setVisibility(View.GONE);
                    lineHC_Hosp_a3.setVisibility(View.GONE);
                    spnHC_Hosp_a3.setSelection(0);
                    secHC_Hosp_a3_Oth.setVisibility(View.GONE);
                    lineHC_Hosp_a3_Oth.setVisibility(View.GONE);
                    txtHC_Hosp_a3_Oth.setText("");
                    secHC_Hosp_a4.setVisibility(View.GONE);
                    lineHC_Hosp_a4.setVisibility(View.GONE);
                    spnHC_Hosp_a4.setSelection(0);
                    secHC_Hosp_a4_Oth.setVisibility(View.GONE);
                    lineHC_Hosp_a4_Oth.setVisibility(View.GONE);
                    txtHC_Hosp_a4_Oth.setText("");
                    secHC_Hosp_a5.setVisibility(View.GONE);
                    lineHC_Hosp_a5.setVisibility(View.GONE);
                    spnHC_Hosp_a5.setSelection(0);
                    secHC_Hosp_a5_Oth.setVisibility(View.GONE);
                    lineHC_Hosp_a5_Oth.setVisibility(View.GONE);
                    txtHC_Hosp_a5_Oth.setText("");
                    secHC_Hosp_bLabel.setVisibility(View.GONE);
                    lineHC_Hosp_bLabel.setVisibility(View.GONE);
                    secHC_Hosp_b.setVisibility(View.GONE);
                    lineHC_Hosp_b.setVisibility(View.GONE);
                    rdogrpHC_Hosp_b.clearCheck();
                    secHC_Hosp_b_i.setVisibility(View.GONE);
                    lineHC_Hosp_b_i.setVisibility(View.GONE);
                    rdogrpHC_Hosp_b_i.clearCheck();
                    secHC_Clin.setVisibility(View.VISIBLE);
                    lineHC_Clin.setVisibility(View.VISIBLE);
             }

            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secHC_HospLabel=(LinearLayout)findViewById(R.id.secHC_HospLabel);
         lineHC_HospLabel=(View)findViewById(R.id.lineHC_HospLabel);
         secHC_Hosp_a1=(LinearLayout)findViewById(R.id.secHC_Hosp_a1);
         lineHC_Hosp_a1=(View)findViewById(R.id.lineHC_Hosp_a1);
         VlblHC_Hosp_a1=(TextView) findViewById(R.id.VlblHC_Hosp_a1);
         spnHC_Hosp_a1=(Spinner) findViewById(R.id.spnHC_Hosp_a1);
         List<String> listHC_Hosp_a1 = new ArrayList<String>();
         
         listHC_Hosp_a1.add("");
         listHC_Hosp_a1.add("1-Dhaka Shishu Hospital");
         listHC_Hosp_a1.add("2-Dr. M. R. Khan Hospital");
         listHC_Hosp_a1.add("3-Popular Diagnostic Center Dhanmondi");
         listHC_Hosp_a1.add("4-Popular Diagnostic Center Mirpur");
         listHC_Hosp_a1.add("5-Popular Diagnostic Center Shyamoli");
         listHC_Hosp_a1.add("77-Other");
         ArrayAdapter<String> adptrHC_Hosp_a1= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listHC_Hosp_a1);
         spnHC_Hosp_a1.setAdapter(adptrHC_Hosp_a1);

         spnHC_Hosp_a1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnHC_Hosp_a1.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnHC_Hosp_a1.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("01"))
                 {
                    secHC_Hosp_a1_Oth.setVisibility(View.GONE);
                    lineHC_Hosp_a1_Oth.setVisibility(View.GONE);
                    txtHC_Hosp_a1_Oth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("02"))
                 {
                    secHC_Hosp_a1_Oth.setVisibility(View.GONE);
                    lineHC_Hosp_a1_Oth.setVisibility(View.GONE);
                    txtHC_Hosp_a1_Oth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("03"))
                 {
                    secHC_Hosp_a1_Oth.setVisibility(View.GONE);
                    lineHC_Hosp_a1_Oth.setVisibility(View.GONE);
                    txtHC_Hosp_a1_Oth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("04"))
                 {
                    secHC_Hosp_a1_Oth.setVisibility(View.GONE);
                    lineHC_Hosp_a1_Oth.setVisibility(View.GONE);
                    txtHC_Hosp_a1_Oth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("05"))
                 {
                    secHC_Hosp_a1_Oth.setVisibility(View.GONE);
                    lineHC_Hosp_a1_Oth.setVisibility(View.GONE);
                    txtHC_Hosp_a1_Oth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("77"))
                 {
                      secHC_Hosp_a1_Oth.setVisibility(View.VISIBLE);
                      lineHC_Hosp_a1_Oth.setVisibility(View.VISIBLE);
                      txtHC_Hosp_a1_Oth.setText("");
                 }
                 else
                 {
                    secHC_Hosp_a1_Oth.setVisibility(View.GONE);
                    lineHC_Hosp_a1_Oth.setVisibility(View.GONE);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secHC_Hosp_a1_Oth=(LinearLayout)findViewById(R.id.secHC_Hosp_a1_Oth);
         lineHC_Hosp_a1_Oth=(View)findViewById(R.id.lineHC_Hosp_a1_Oth);
         VlblHC_Hosp_a1_Oth=(TextView) findViewById(R.id.VlblHC_Hosp_a1_Oth);
         txtHC_Hosp_a1_Oth=(EditText) findViewById(R.id.txtHC_Hosp_a1_Oth);
         secHC_Hosp_a2=(LinearLayout)findViewById(R.id.secHC_Hosp_a2);
         lineHC_Hosp_a2=(View)findViewById(R.id.lineHC_Hosp_a2);
         VlblHC_Hosp_a2=(TextView) findViewById(R.id.VlblHC_Hosp_a2);
         spnHC_Hosp_a2=(Spinner) findViewById(R.id.spnHC_Hosp_a2);
         List<String> listHC_Hosp_a2 = new ArrayList<String>();
         
         listHC_Hosp_a2.add("");
         listHC_Hosp_a2.add("1-Dhaka Shishu Hospital");
         listHC_Hosp_a2.add("2-Dr. M. R. Khan Hospital");
         listHC_Hosp_a2.add("3-Popular Diagnostic Center Dhanmondi");
         listHC_Hosp_a2.add("4-Popular Diagnostic Center Mirpur");
         listHC_Hosp_a2.add("5-Popular Diagnostic Center Shyamoli");
         listHC_Hosp_a2.add("77-Other");
         ArrayAdapter<String> adptrHC_Hosp_a2= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listHC_Hosp_a2);
         spnHC_Hosp_a2.setAdapter(adptrHC_Hosp_a2);

         spnHC_Hosp_a2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnHC_Hosp_a2.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnHC_Hosp_a2.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("01"))
                 {
                    secHC_Hosp_a2_Oth.setVisibility(View.GONE);
                    lineHC_Hosp_a2_Oth.setVisibility(View.GONE);
                    txtHC_Hosp_a2_Oth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("02"))
                 {
                    secHC_Hosp_a2_Oth.setVisibility(View.GONE);
                    lineHC_Hosp_a2_Oth.setVisibility(View.GONE);
                    txtHC_Hosp_a2_Oth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("03"))
                 {
                    secHC_Hosp_a2_Oth.setVisibility(View.GONE);
                    lineHC_Hosp_a2_Oth.setVisibility(View.GONE);
                    txtHC_Hosp_a2_Oth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("04"))
                 {
                    secHC_Hosp_a2_Oth.setVisibility(View.GONE);
                    lineHC_Hosp_a2_Oth.setVisibility(View.GONE);
                    txtHC_Hosp_a2_Oth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("05"))
                 {
                    secHC_Hosp_a2_Oth.setVisibility(View.GONE);
                    lineHC_Hosp_a2_Oth.setVisibility(View.GONE);
                    txtHC_Hosp_a2_Oth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("77"))
                 {
                      secHC_Hosp_a2_Oth.setVisibility(View.VISIBLE);
                      lineHC_Hosp_a2_Oth.setVisibility(View.VISIBLE);
                      txtHC_Hosp_a2_Oth.setText("");
                 }
                 else
                 {
                      secHC_Hosp_a2_Oth.setVisibility(View.GONE);
                      lineHC_Hosp_a2_Oth.setVisibility(View.GONE);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secHC_Hosp_a2_Oth=(LinearLayout)findViewById(R.id.secHC_Hosp_a2_Oth);
         lineHC_Hosp_a2_Oth=(View)findViewById(R.id.lineHC_Hosp_a2_Oth);
         VlblHC_Hosp_a2_Oth=(TextView) findViewById(R.id.VlblHC_Hosp_a2_Oth);
         txtHC_Hosp_a2_Oth=(EditText) findViewById(R.id.txtHC_Hosp_a2_Oth);
         secHC_Hosp_a3=(LinearLayout)findViewById(R.id.secHC_Hosp_a3);
         lineHC_Hosp_a3=(View)findViewById(R.id.lineHC_Hosp_a3);
         VlblHC_Hosp_a3=(TextView) findViewById(R.id.VlblHC_Hosp_a3);
         spnHC_Hosp_a3=(Spinner) findViewById(R.id.spnHC_Hosp_a3);
         List<String> listHC_Hosp_a3 = new ArrayList<String>();
         
         listHC_Hosp_a3.add("");
         listHC_Hosp_a3.add("1-Dhaka Shishu Hospital");
         listHC_Hosp_a3.add("2-Dr. M. R. Khan Hospital");
         listHC_Hosp_a3.add("3-Popular Diagnostic Center-Dhanmondi");
         listHC_Hosp_a3.add("4-Popular Diagnostic Center-Mirpur");
         listHC_Hosp_a3.add("5-Popular Diagnostic Center-Shyamoli");
         listHC_Hosp_a3.add("77-Other");
         ArrayAdapter<String> adptrHC_Hosp_a3= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listHC_Hosp_a3);
         spnHC_Hosp_a3.setAdapter(adptrHC_Hosp_a3);

         spnHC_Hosp_a3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnHC_Hosp_a3.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnHC_Hosp_a3.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("01"))
                 {
                    secHC_Hosp_a3_Oth.setVisibility(View.GONE);
                    lineHC_Hosp_a3_Oth.setVisibility(View.GONE);
                    txtHC_Hosp_a3_Oth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("02"))
                 {
                    secHC_Hosp_a3_Oth.setVisibility(View.GONE);
                    lineHC_Hosp_a3_Oth.setVisibility(View.GONE);
                    txtHC_Hosp_a3_Oth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("03"))
                 {
                    secHC_Hosp_a3_Oth.setVisibility(View.GONE);
                    lineHC_Hosp_a3_Oth.setVisibility(View.GONE);
                    txtHC_Hosp_a3_Oth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("04"))
                 {
                    secHC_Hosp_a3_Oth.setVisibility(View.GONE);
                    lineHC_Hosp_a3_Oth.setVisibility(View.GONE);
                    txtHC_Hosp_a3_Oth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("05"))
                 {
                    secHC_Hosp_a3_Oth.setVisibility(View.GONE);
                    lineHC_Hosp_a3_Oth.setVisibility(View.GONE);
                    txtHC_Hosp_a3_Oth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("77"))
                 {
                      secHC_Hosp_a3_Oth.setVisibility(View.VISIBLE);
                      lineHC_Hosp_a3_Oth.setVisibility(View.VISIBLE);
                      txtHC_Hosp_a3_Oth.setText("");
                 }
                 else
                 {
                      secHC_Hosp_a3_Oth.setVisibility(View.GONE);
                      lineHC_Hosp_a3_Oth.setVisibility(View.GONE);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secHC_Hosp_a3_Oth=(LinearLayout)findViewById(R.id.secHC_Hosp_a3_Oth);
         lineHC_Hosp_a3_Oth=(View)findViewById(R.id.lineHC_Hosp_a3_Oth);
         VlblHC_Hosp_a3_Oth=(TextView) findViewById(R.id.VlblHC_Hosp_a3_Oth);
         txtHC_Hosp_a3_Oth=(EditText) findViewById(R.id.txtHC_Hosp_a3_Oth);
         secHC_Hosp_a4=(LinearLayout)findViewById(R.id.secHC_Hosp_a4);
         lineHC_Hosp_a4=(View)findViewById(R.id.lineHC_Hosp_a4);
         VlblHC_Hosp_a4=(TextView) findViewById(R.id.VlblHC_Hosp_a4);
         spnHC_Hosp_a4=(Spinner) findViewById(R.id.spnHC_Hosp_a4);
         List<String> listHC_Hosp_a4 = new ArrayList<String>();
         
         listHC_Hosp_a4.add("");
         listHC_Hosp_a4.add("1-Dhaka Shishu Hospital");
         listHC_Hosp_a4.add("2-Dr. M. R. Khan Hospital");
         listHC_Hosp_a4.add("3-Popular Diagnostic Center-Dhanmondi");
         listHC_Hosp_a4.add("4-Popular Diagnostic Center-Mirpur");
         listHC_Hosp_a4.add("5-Popular Diagnostic Center-Shyamoli");
         listHC_Hosp_a4.add("77-Other");
         ArrayAdapter<String> adptrHC_Hosp_a4= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listHC_Hosp_a4);
         spnHC_Hosp_a4.setAdapter(adptrHC_Hosp_a4);

         spnHC_Hosp_a4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnHC_Hosp_a4.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnHC_Hosp_a4.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("01"))
                 {
                    secHC_Hosp_a4_Oth.setVisibility(View.GONE);
                    lineHC_Hosp_a4_Oth.setVisibility(View.GONE);
                    txtHC_Hosp_a4_Oth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("02"))
                 {
                    secHC_Hosp_a4_Oth.setVisibility(View.GONE);
                    lineHC_Hosp_a4_Oth.setVisibility(View.GONE);
                    txtHC_Hosp_a4_Oth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("03"))
                 {
                    secHC_Hosp_a4_Oth.setVisibility(View.GONE);
                    lineHC_Hosp_a4_Oth.setVisibility(View.GONE);
                    txtHC_Hosp_a4_Oth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("04"))
                 {
                    secHC_Hosp_a4_Oth.setVisibility(View.GONE);
                    lineHC_Hosp_a4_Oth.setVisibility(View.GONE);
                    txtHC_Hosp_a4_Oth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("05"))
                 {
                    secHC_Hosp_a4_Oth.setVisibility(View.GONE);
                    lineHC_Hosp_a4_Oth.setVisibility(View.GONE);
                    txtHC_Hosp_a4_Oth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("77"))
                 {
                      secHC_Hosp_a4_Oth.setVisibility(View.VISIBLE);
                      lineHC_Hosp_a4_Oth.setVisibility(View.VISIBLE);
                      txtHC_Hosp_a4_Oth.setText("");
                 }
                 else
                 {
                      secHC_Hosp_a4_Oth.setVisibility(View.GONE);
                      lineHC_Hosp_a4_Oth.setVisibility(View.GONE);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secHC_Hosp_a4_Oth=(LinearLayout)findViewById(R.id.secHC_Hosp_a4_Oth);
         lineHC_Hosp_a4_Oth=(View)findViewById(R.id.lineHC_Hosp_a4_Oth);
         VlblHC_Hosp_a4_Oth=(TextView) findViewById(R.id.VlblHC_Hosp_a4_Oth);
         txtHC_Hosp_a4_Oth=(EditText) findViewById(R.id.txtHC_Hosp_a4_Oth);
         secHC_Hosp_a5=(LinearLayout)findViewById(R.id.secHC_Hosp_a5);
         lineHC_Hosp_a5=(View)findViewById(R.id.lineHC_Hosp_a5);
         VlblHC_Hosp_a5=(TextView) findViewById(R.id.VlblHC_Hosp_a5);
         spnHC_Hosp_a5=(Spinner) findViewById(R.id.spnHC_Hosp_a5);
         List<String> listHC_Hosp_a5 = new ArrayList<String>();
         
         listHC_Hosp_a5.add("");
         listHC_Hosp_a5.add("1-Dhaka Shishu Hospital");
         listHC_Hosp_a5.add("2-Dr. M. R. Khan Hospital");
         listHC_Hosp_a5.add("3-Popular Diagnostic Center-Dhanmondi");
         listHC_Hosp_a5.add("4-Popular Diagnostic Center-Mirpur");
         listHC_Hosp_a5.add("5-Popular Diagnostic Center-Shyamoli");
         listHC_Hosp_a5.add("77-Other");
         ArrayAdapter<String> adptrHC_Hosp_a5= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listHC_Hosp_a5);
         spnHC_Hosp_a5.setAdapter(adptrHC_Hosp_a5);

         spnHC_Hosp_a5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnHC_Hosp_a5.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnHC_Hosp_a5.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("01"))
                 {
                    secHC_Hosp_a5_Oth.setVisibility(View.GONE);
                    lineHC_Hosp_a5_Oth.setVisibility(View.GONE);
                    txtHC_Hosp_a5_Oth.setText("");
                    secHC_Hosp_bLabel.setVisibility(View.GONE);
                    lineHC_Hosp_bLabel.setVisibility(View.GONE);
                 }
                 else if(spnData.equalsIgnoreCase("02"))
                 {
                    secHC_Hosp_a5_Oth.setVisibility(View.GONE);
                    lineHC_Hosp_a5_Oth.setVisibility(View.GONE);
                    txtHC_Hosp_a5_Oth.setText("");
                    secHC_Hosp_bLabel.setVisibility(View.GONE);
                    lineHC_Hosp_bLabel.setVisibility(View.GONE);
                 }
                 else if(spnData.equalsIgnoreCase("03"))
                 {
                    secHC_Hosp_a5_Oth.setVisibility(View.GONE);
                    lineHC_Hosp_a5_Oth.setVisibility(View.GONE);
                    txtHC_Hosp_a5_Oth.setText("");
                    secHC_Hosp_bLabel.setVisibility(View.GONE);
                    lineHC_Hosp_bLabel.setVisibility(View.GONE);
                 }
                 else if(spnData.equalsIgnoreCase("04"))
                 {
                    secHC_Hosp_a5_Oth.setVisibility(View.GONE);
                    lineHC_Hosp_a5_Oth.setVisibility(View.GONE);
                    txtHC_Hosp_a5_Oth.setText("");
                    secHC_Hosp_bLabel.setVisibility(View.GONE);
                    lineHC_Hosp_bLabel.setVisibility(View.GONE);
                 }
                 else if(spnData.equalsIgnoreCase("05"))
                 {
                    secHC_Hosp_a5_Oth.setVisibility(View.GONE);
                    lineHC_Hosp_a5_Oth.setVisibility(View.GONE);
                    txtHC_Hosp_a5_Oth.setText("");
                    secHC_Hosp_bLabel.setVisibility(View.GONE);
                    lineHC_Hosp_bLabel.setVisibility(View.GONE);
                 }
                 else if(spnData.equalsIgnoreCase("77"))
                 {
                      secHC_Hosp_a5_Oth.setVisibility(View.VISIBLE);
                      lineHC_Hosp_a5_Oth.setVisibility(View.VISIBLE);
                      txtHC_Hosp_a5_Oth.setText("");
                 }
                 else
                 {
                      secHC_Hosp_a5_Oth.setVisibility(View.GONE);
                      lineHC_Hosp_a5_Oth.setVisibility(View.GONE);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secHC_Hosp_a5_Oth=(LinearLayout)findViewById(R.id.secHC_Hosp_a5_Oth);
         lineHC_Hosp_a5_Oth=(View)findViewById(R.id.lineHC_Hosp_a5_Oth);
         VlblHC_Hosp_a5_Oth=(TextView) findViewById(R.id.VlblHC_Hosp_a5_Oth);
         txtHC_Hosp_a5_Oth=(EditText) findViewById(R.id.txtHC_Hosp_a5_Oth);
         secHC_Hosp_bLabel=(LinearLayout)findViewById(R.id.secHC_Hosp_bLabel);
         lineHC_Hosp_bLabel=(View)findViewById(R.id.lineHC_Hosp_bLabel);
         secHC_Hosp_b=(LinearLayout)findViewById(R.id.secHC_Hosp_b);
         lineHC_Hosp_b=(View)findViewById(R.id.lineHC_Hosp_b);
         VlblHC_Hosp_b = (TextView) findViewById(R.id.VlblHC_Hosp_b);
         rdogrpHC_Hosp_b = (RadioGroup) findViewById(R.id.rdogrpHC_Hosp_b);
         
         rdoHC_Hosp_b1 = (RadioButton) findViewById(R.id.rdoHC_Hosp_b1);
         rdoHC_Hosp_b2 = (RadioButton) findViewById(R.id.rdoHC_Hosp_b2);
         rdogrpHC_Hosp_b.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpHC_Hosp_b = new String[] {"1","2"};
             for (int i = 0; i < rdogrpHC_Hosp_b.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpHC_Hosp_b.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpHC_Hosp_b[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secHC_Hosp_b_i.setVisibility(View.GONE);
                    lineHC_Hosp_b_i.setVisibility(View.GONE);
                  secHC_Clin.setVisibility(View.VISIBLE);
                  lineHC_Clin.setVisibility(View.VISIBLE);
                    rdogrpHC_Hosp_b_i.clearCheck();
             }
             else if(rbData.equalsIgnoreCase("1"))
             {
                    secHC_Hosp_b_i.setVisibility(View.VISIBLE);
                    lineHC_Hosp_b_i.setVisibility(View.VISIBLE);
                  secHC_Clin.setVisibility(View.GONE);
                  lineHC_Clin.setVisibility(View.GONE);
             }
             else{
                  secHC_Hosp_b_i.setVisibility(View.GONE);
                  lineHC_Hosp_b_i.setVisibility(View.GONE);
                  secHC_Clin.setVisibility(View.GONE);
                  lineHC_Clin.setVisibility(View.GONE);
//                  rdogrpHC_Hosp_b_i.clearCheck();
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secHC_Hosp_b_i=(LinearLayout)findViewById(R.id.secHC_Hosp_b_i);
         lineHC_Hosp_b_i=(View)findViewById(R.id.lineHC_Hosp_b_i);
         VlblHC_Hosp_b_i = (TextView) findViewById(R.id.VlblHC_Hosp_b_i);
         rdogrpHC_Hosp_b_i = (RadioGroup) findViewById(R.id.rdogrpHC_Hosp_b_i);
         
         rdoHC_Hosp_b_i1 = (RadioButton) findViewById(R.id.rdoHC_Hosp_b_i1);
         rdoHC_Hosp_b_i2 = (RadioButton) findViewById(R.id.rdoHC_Hosp_b_i2);
         secHC_Clin=(LinearLayout)findViewById(R.id.secHC_Clin);
         lineHC_Clin=(View)findViewById(R.id.lineHC_Clin);
         VlblHC_Clin = (TextView) findViewById(R.id.VlblHC_Clin);
         rdogrpHC_Clin = (RadioGroup) findViewById(R.id.rdogrpHC_Clin);
         
         rdoHC_Clin1 = (RadioButton) findViewById(R.id.rdoHC_Clin1);
         rdoHC_Clin2 = (RadioButton) findViewById(R.id.rdoHC_Clin2);
         rdoHC_Clin3 = (RadioButton) findViewById(R.id.rdoHC_Clin3);
         secHC_Phy=(LinearLayout)findViewById(R.id.secHC_Phy);
         lineHC_Phy=(View)findViewById(R.id.lineHC_Phy);
         VlblHC_Phy = (TextView) findViewById(R.id.VlblHC_Phy);
         rdogrpHC_Phy = (RadioGroup) findViewById(R.id.rdogrpHC_Phy);
         
         rdoHC_Phy1 = (RadioButton) findViewById(R.id.rdoHC_Phy1);
         rdoHC_Phy2 = (RadioButton) findViewById(R.id.rdoHC_Phy2);
         rdoHC_Phy3 = (RadioButton) findViewById(R.id.rdoHC_Phy3);
         secDaysOfSymp=(LinearLayout)findViewById(R.id.secDaysOfSymp);
         lineDaysOfSymp=(View)findViewById(R.id.lineDaysOfSymp);
         VlblDaysOfSymp=(TextView) findViewById(R.id.VlblDaysOfSymp);
         txtDaysOfSymp=(EditText) findViewById(R.id.txtDaysOfSymp);
         secDaysOfSympDK=(LinearLayout)findViewById(R.id.secDaysOfSympDK);
         lineDaysOfSympDK=(View)findViewById(R.id.lineDaysOfSympDK);
         VlblDaysOfSympDK=(TextView) findViewById(R.id.VlblDaysOfSympDK);
         chkDaysOfSympDK=(CheckBox) findViewById(R.id.chkDaysOfSympDK);
         secWorstHour=(LinearLayout)findViewById(R.id.secWorstHour);
         lineWorstHour=(View)findViewById(R.id.lineWorstHour);
         VlblWorstHour=(TextView) findViewById(R.id.VlblWorstHour);
         txtWorstHour=(EditText) findViewById(R.id.txtWorstHour);
         secWorstHourDK=(LinearLayout)findViewById(R.id.secWorstHourDK);
         lineWorstHourDK=(View)findViewById(R.id.lineWorstHourDK);
         VlblWorstHourDK=(TextView) findViewById(R.id.VlblWorstHourDK);
         chkWorstHourDK=(CheckBox) findViewById(R.id.chkWorstHourDK);
         secDaysOfUnable=(LinearLayout)findViewById(R.id.secDaysOfUnable);
         lineDaysOfUnable=(View)findViewById(R.id.lineDaysOfUnable);
         VlblDaysOfUnable=(TextView) findViewById(R.id.VlblDaysOfUnable);
         txtDaysOfUnable=(EditText) findViewById(R.id.txtDaysOfUnable);
         secDaysOfUnableDK=(LinearLayout)findViewById(R.id.secDaysOfUnableDK);
         lineDaysOfUnableDK=(View)findViewById(R.id.lineDaysOfUnableDK);
         VlblDaysOfUnableDK=(TextView) findViewById(R.id.VlblDaysOfUnableDK);
         chkDaysOfUnableDK=(CheckBox) findViewById(R.id.chkDaysOfUnableDK);
         secTAdmHos=(LinearLayout)findViewById(R.id.secTAdmHos);
         lineTAdmHos=(View)findViewById(R.id.lineTAdmHos);
         VlblTAdmHos = (TextView) findViewById(R.id.VlblTAdmHos);
         rdogrpTAdmHos = (RadioGroup) findViewById(R.id.rdogrpTAdmHos);


          txtDaysOfSymp.addTextChangedListener(new TextWatcher() {
               @Override
               public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

               }

               @Override
               public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(txtDaysOfSymp.getText().toString().length()>0){
                         chkDaysOfSympDK.setChecked(false);
                    }
               }

               @Override
               public void afterTextChanged(Editable editable) {

               }
          });

          txtWorstHour.addTextChangedListener(new TextWatcher() {
               @Override
               public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

               }

               @Override
               public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(txtWorstHour.getText().toString().length()>0){
                         chkWorstHourDK.setChecked(false);
                    }
               }

               @Override
               public void afterTextChanged(Editable editable) {

               }
          });

          txtDaysOfUnable.addTextChangedListener(new TextWatcher() {
               @Override
               public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

               }

               @Override
               public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(txtDaysOfUnable.getText().toString().length()>0){
                         chkDaysOfUnableDK.setChecked(false);
                    }
               }

               @Override
               public void afterTextChanged(Editable editable) {

               }
          });









          chkDaysOfSympDK.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if(b) {
                         txtDaysOfSymp.setText("");
                    }
               }
          });
          chkWorstHourDK.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                   if(b) {
                       txtWorstHour.setText("");
                   }
               }
          });
          chkDaysOfUnableDK.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                   if(b) {
                       txtDaysOfUnable.setText("");
                   }

               }
          });

//


         rdogrpTAdmHos.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
              @Override
              public void onCheckedChanged(RadioGroup radioGroup, int radioButtonID) {
                   String rbData = "";
                   RadioButton rb;
                   String[] d_rdogrpTAdmHos = new String[] {"1","2","7"};
                   for (int i = 0; i < rdogrpTAdmHos.getChildCount(); i++)
                   {
                        rb = (RadioButton)rdogrpTAdmHos.getChildAt(i);
                        if (rb.isChecked()) rbData = d_rdogrpTAdmHos[i];
                   }
                   if(rbData.equalsIgnoreCase("1")) {

                        secTHosNamLabel.setVisibility(View.VISIBLE);
                        lineTHosNamLabel.setVisibility(View.VISIBLE);
                        secTHosNam.setVisibility(View.VISIBLE);
                        lineTHosNam.setVisibility(View.VISIBLE);
                        spnTHosNam.setSelection(0);

                        secTHosNam2.setVisibility(View.VISIBLE);
                        lineTHosNam2.setVisibility(View.VISIBLE);
                        spnTHosNam2.setSelection(0);

                        secTHosNam3.setVisibility(View.VISIBLE);
                        lineTHosNam3.setVisibility(View.VISIBLE);
                        spnTHosNam3.setSelection(0);

                        secTHosNamDK.setVisibility(View.VISIBLE);
                        lineTHosNamDK.setVisibility(View.VISIBLE);
                        chkTHosNamDK.setChecked(false);
                        secTDtAdmHos.setVisibility(View.VISIBLE);
                        lineTDtAdmHos.setVisibility(View.VISIBLE);
                        dtpTDtAdmHos.setText("");
                        secTAdmHosD.setVisibility(View.VISIBLE);
                        lineTAdmHosD.setVisibility(View.VISIBLE);
                        txtTAdmHosD.setText("");
                        secTDurIlBeHos.setVisibility(View.VISIBLE);
                        lineTDurIlBeHos.setVisibility(View.VISIBLE);
                        txtTDurIlBeHos.setText("");
                        secTDurIlBeHosDK.setVisibility(View.VISIBLE);
                        lineTDurIlBeHosDK.setVisibility(View.VISIBLE);
                        chkTDurIlBeHosDK.setChecked(false);
                        secTDisDr.setVisibility(View.VISIBLE);
                        lineTDisDr.setVisibility(View.VISIBLE);
                        spnTDisDr.setSelection(0);

                        rdogrpHaveHosp.check(R.id.rdoHaveHosp1);

                   }
                   else if(rbData.equalsIgnoreCase("2")) {
                        rdogrpHaveHosp.clearCheck();
                       if(rdoHC_PhyMBBS1.isChecked())
                       {
                           secTHosNamLabel.setVisibility(View.GONE);
                           lineTHosNamLabel.setVisibility(View.GONE);
                           secTHosNam.setVisibility(View.GONE);
                           lineTHosNam.setVisibility(View.GONE);
                           spnTHosNam.setSelection(0);
                           secTHosNam_Oth.setVisibility(View.GONE);
                           lineTHosNam_Oth.setVisibility(View.GONE);
                           txtTHosNam_Oth.setText("");
                           secTHosNam2.setVisibility(View.GONE);
                           lineTHosNam2.setVisibility(View.GONE);
                            spnTHosNam2.setSelection(0);
                           secTHosNam2_Oth.setVisibility(View.GONE);
                           lineTHosNam2_Oth.setVisibility(View.GONE);
                           txtTHosNam2_Oth.setText("");
                           secTHosNam3.setVisibility(View.GONE);
                           lineTHosNam3.setVisibility(View.GONE);
                           spnTHosNam3.setSelection(0);
                           secTHosNam3_Oth.setVisibility(View.GONE);
                           lineTHosNam3_Oth.setVisibility(View.GONE);
                           txtTHosNam3_Oth.setText("");
                           secTHosNamDK.setVisibility(View.GONE);
                           lineTHosNamDK.setVisibility(View.GONE);
                           chkTHosNamDK.setChecked(false);
                           secTDtAdmHos.setVisibility(View.GONE);
                           lineTDtAdmHos.setVisibility(View.GONE);
                           dtpTDtAdmHos.setText("");
                           secTAdmHosD.setVisibility(View.GONE);
                           lineTAdmHosD.setVisibility(View.GONE);
                           txtTAdmHosD.setText("");
                           secTDurIlBeHos.setVisibility(View.GONE);
                           lineTDurIlBeHos.setVisibility(View.GONE);
                           txtTDurIlBeHos.setText("");
                           secTDurIlBeHosDK.setVisibility(View.GONE);
                           lineTDurIlBeHosDK.setVisibility(View.GONE);
                           chkTDurIlBeHosDK.setChecked(false);
                            secTDisDrOth.setVisibility(View.GONE);
                            lineTDisDrOth.setVisibility(View.GONE);
                            txtTDisDrOth.setText("");
                       }
                       else{
                           secTHosNamLabel.setVisibility(View.GONE);
                           lineTHosNamLabel.setVisibility(View.GONE);
                           secTHosNam.setVisibility(View.GONE);
                           lineTHosNam.setVisibility(View.GONE);
                           spnTHosNam.setSelection(0);
                           secTHosNam_Oth.setVisibility(View.GONE);
                           lineTHosNam_Oth.setVisibility(View.GONE);
                           txtTHosNam_Oth.setText("");
                           secTHosNam2.setVisibility(View.GONE);
                           lineTHosNam2.setVisibility(View.GONE);
                            spnTHosNam2.setSelection(0);
                           secTHosNam2_Oth.setVisibility(View.GONE);
                           lineTHosNam2_Oth.setVisibility(View.GONE);
                           txtTHosNam2_Oth.setText("");
                           secTHosNam3.setVisibility(View.GONE);
                           lineTHosNam3.setVisibility(View.GONE);
                           spnTHosNam3.setSelection(0);
                           secTHosNam3_Oth.setVisibility(View.GONE);
                           lineTHosNam3_Oth.setVisibility(View.GONE);
                           txtTHosNam3_Oth.setText("");
                           secTHosNamDK.setVisibility(View.GONE);
                           lineTHosNamDK.setVisibility(View.GONE);
                           chkTHosNamDK.setChecked(false);
                           secTDtAdmHos.setVisibility(View.GONE);
                           lineTDtAdmHos.setVisibility(View.GONE);
                           dtpTDtAdmHos.setText("");
                           secTAdmHosD.setVisibility(View.GONE);
                           lineTAdmHosD.setVisibility(View.GONE);
                           txtTAdmHosD.setText("");
                           secTDurIlBeHos.setVisibility(View.GONE);
                           lineTDurIlBeHos.setVisibility(View.GONE);
                           txtTDurIlBeHos.setText("");
                           secTDurIlBeHosDK.setVisibility(View.GONE);
                           lineTDurIlBeHosDK.setVisibility(View.GONE);
                           chkTDurIlBeHosDK.setChecked(false);
                           secTDisDr.setVisibility(View.GONE);
                           lineTDisDr.setVisibility(View.GONE);
                           spnTDisDr.setSelection(0);
                           secTDisDrOth.setVisibility(View.GONE);
                           lineTDisDrOth.setVisibility(View.GONE);
                           txtTDisDrOth.setText("");
                       }


                   }
                   else if(rbData.equalsIgnoreCase("7")) {
                        rdogrpHaveHosp.clearCheck();
                       if(rdoHC_PhyMBBS1.isChecked())
                       {
                           secTHosNamLabel.setVisibility(View.GONE);
                           lineTHosNamLabel.setVisibility(View.GONE);
                           secTHosNam.setVisibility(View.GONE);
                           lineTHosNam.setVisibility(View.GONE);
                           spnTHosNam.setSelection(0);
                           secTHosNam_Oth.setVisibility(View.GONE);
                           lineTHosNam_Oth.setVisibility(View.GONE);
                           txtTHosNam_Oth.setText("");
                           secTHosNam2.setVisibility(View.GONE);
                           lineTHosNam2.setVisibility(View.GONE);
                           spnTHosNam2.setSelection(0);
                           secTHosNam2_Oth.setVisibility(View.GONE);
                           lineTHosNam2_Oth.setVisibility(View.GONE);
                            spnTHosNam2.setSelection(0);
                           secTHosNam3.setVisibility(View.GONE);
                           lineTHosNam3.setVisibility(View.GONE);
                           spnTHosNam3.setSelection(0);
                           secTHosNam3_Oth.setVisibility(View.GONE);
                           lineTHosNam3_Oth.setVisibility(View.GONE);
                           txtTHosNam3_Oth.setText("");
                           secTHosNamDK.setVisibility(View.GONE);
                           lineTHosNamDK.setVisibility(View.GONE);
                           chkTHosNamDK.setChecked(false);
                           secTDtAdmHos.setVisibility(View.GONE);
                           lineTDtAdmHos.setVisibility(View.GONE);
                           dtpTDtAdmHos.setText("");
                           secTAdmHosD.setVisibility(View.GONE);
                           lineTAdmHosD.setVisibility(View.GONE);
                           txtTAdmHosD.setText("");
                           secTDurIlBeHos.setVisibility(View.GONE);
                           lineTDurIlBeHos.setVisibility(View.GONE);
                           txtTDurIlBeHos.setText("");
                           secTDurIlBeHosDK.setVisibility(View.GONE);
                           lineTDurIlBeHosDK.setVisibility(View.GONE);
                           chkTDurIlBeHosDK.setChecked(false);
                       }
                       else{
                           secTHosNamLabel.setVisibility(View.GONE);
                           lineTHosNamLabel.setVisibility(View.GONE);
                           secTHosNam.setVisibility(View.GONE);
                           lineTHosNam.setVisibility(View.GONE);
                           spnTHosNam.setSelection(0);
                           secTHosNam_Oth.setVisibility(View.GONE);
                           lineTHosNam_Oth.setVisibility(View.GONE);
                           txtTHosNam_Oth.setText("");
                           secTHosNam2.setVisibility(View.GONE);
                           lineTHosNam2.setVisibility(View.GONE);
                            spnTHosNam2.setSelection(0);
                           secTHosNam2_Oth.setVisibility(View.GONE);
                           lineTHosNam2_Oth.setVisibility(View.GONE);
                           txtTHosNam2_Oth.setText("");
                           secTHosNam3.setVisibility(View.GONE);
                           lineTHosNam3.setVisibility(View.GONE);
                           spnTHosNam3.setSelection(0);
                           secTHosNam3_Oth.setVisibility(View.GONE);
                           lineTHosNam3_Oth.setVisibility(View.GONE);
                           txtTHosNam3_Oth.setText("");
                           secTHosNamDK.setVisibility(View.GONE);
                           lineTHosNamDK.setVisibility(View.GONE);
                           chkTHosNamDK.setChecked(false);
                           secTDtAdmHos.setVisibility(View.GONE);
                           lineTDtAdmHos.setVisibility(View.GONE);
                           dtpTDtAdmHos.setText("");
                           secTAdmHosD.setVisibility(View.GONE);
                           lineTAdmHosD.setVisibility(View.GONE);
                           txtTAdmHosD.setText("");
                           secTDurIlBeHos.setVisibility(View.GONE);
                           lineTDurIlBeHos.setVisibility(View.GONE);
                           txtTDurIlBeHos.setText("");
                           secTDurIlBeHosDK.setVisibility(View.GONE);
                           lineTDurIlBeHosDK.setVisibility(View.GONE);
                           chkTDurIlBeHosDK.setChecked(false);
                           secTDisDr.setVisibility(View.GONE);
                           lineTDisDr.setVisibility(View.GONE);
                           spnTDisDr.setSelection(0);
                           secTDisDrOth.setVisibility(View.GONE);
                           lineTDisDrOth.setVisibility(View.GONE);
                           txtTDisDrOth.setText("");
                       }


                   }
                   }
         });

         
         rdoTAdmHos1 = (RadioButton) findViewById(R.id.rdoTAdmHos1);
         rdoTAdmHos2 = (RadioButton) findViewById(R.id.rdoTAdmHos2);
         rdoTAdmHos3 = (RadioButton) findViewById(R.id.rdoTAdmHos3);
         secTHosNamLabel=(LinearLayout)findViewById(R.id.secTHosNamLabel);
         lineTHosNamLabel=(View)findViewById(R.id.lineTHosNamLabel);
         secTHosNam=(LinearLayout)findViewById(R.id.secTHosNam);
         lineTHosNam=(View)findViewById(R.id.lineTHosNam);
         VlblTHosNam=(TextView) findViewById(R.id.VlblTHosNam);
         spnTHosNam=(Spinner) findViewById(R.id.spnTHosNam);



         List<String> listTHosNam = new ArrayList<String>();
         
         listTHosNam.add("");
         listTHosNam.add("1-ঢাকা শিশু হাসপাতাল (Dhaka Shishu Hospital)");
         listTHosNam.add("2-ডাঃ এম আর খান  শিশু হাসপাতাল (Dr. MR Khan Shishu Hospital)");
         listTHosNam.add("7-অন্যান্য (Other)");
         ArrayAdapter<String> adptrTHosNam= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listTHosNam);
         spnTHosNam.setAdapter(adptrTHosNam);

         spnTHosNam.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnTHosNam.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnTHosNam.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("1"))
                 {
                    secTHosNam_Oth.setVisibility(View.GONE);
                    lineTHosNam_Oth.setVisibility(View.GONE);
                    txtTHosNam_Oth.setText("");
                      chkTHosNamDK.setChecked(false);
                 }
                 else if(spnData.equalsIgnoreCase("2"))
                 {
                    secTHosNam_Oth.setVisibility(View.GONE);
                    lineTHosNam_Oth.setVisibility(View.GONE);
                    txtTHosNam_Oth.setText("");
                      chkTHosNamDK.setChecked(false);
                 }
                 else if(spnData.equalsIgnoreCase("7"))
                 {
                      secTHosNam_Oth.setVisibility(View.VISIBLE);
                      lineTHosNam_Oth.setVisibility(View.VISIBLE);
                      txtTHosNam_Oth.setText("");
                      chkTHosNamDK.setChecked(false);
                 }
                 else
                 {
                      secTHosNam_Oth.setVisibility(View.GONE);
                      lineTHosNam_Oth.setVisibility(View.GONE);

                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secTHosNam_Oth=(LinearLayout)findViewById(R.id.secTHosNam_Oth);
         lineTHosNam_Oth=(View)findViewById(R.id.lineTHosNam_Oth);
         VlblTHosNam_Oth=(TextView) findViewById(R.id.VlblTHosNam_Oth);
         txtTHosNam_Oth=(EditText) findViewById(R.id.txtTHosNam_Oth);
         secTHosNam2=(LinearLayout)findViewById(R.id.secTHosNam2);
         lineTHosNam2=(View)findViewById(R.id.lineTHosNam2);
         VlblTHosNam2 = (TextView) findViewById(R.id.VlblTHosNam2);
          spnTHosNam2=(Spinner) findViewById(R.id.spnTHosNam2);


          List<String> listTHosNam2 = new ArrayList<String>();

          listTHosNam2.add("");
          listTHosNam2.add("1-ঢাকা শিশু হাসপাতাল (Dhaka Shishu Hospital)");
          listTHosNam2.add("2-ডাঃ এম আর খান  শিশু হাসপাতাল (Dr. MR Khan Shishu Hospital)");
          listTHosNam2.add("7-অন্যান্য (Other)");

          ArrayAdapter<String> adptrTHosNam2= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listTHosNam2);
          spnTHosNam2.setAdapter(adptrTHosNam2);

          spnTHosNam2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
               @Override
               public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                    String spnData = "";
                    if (spnTHosNam2.getSelectedItem().toString().length() != 0)
                    {
                         spnData = Connection.SelectedSpinnerValue(spnTHosNam2.getSelectedItem().toString(), "-");
                    }
                    if(spnData.equalsIgnoreCase("1"))
                    {
                         secTHosNam2_Oth.setVisibility(View.GONE);
                         lineTHosNam2_Oth.setVisibility(View.GONE);
                         txtTHosNam2_Oth.setText("");

                         chkTHosNamDK.setChecked(false);
                    }
                    else if(spnData.equalsIgnoreCase("2"))
                    {
                         secTHosNam2_Oth.setVisibility(View.GONE);
                         lineTHosNam2_Oth.setVisibility(View.GONE);
                         txtTHosNam2_Oth.setText("");

                         chkTHosNamDK.setChecked(false);
                    }
                    else if(spnData.equalsIgnoreCase("7"))
                    {
                         secTHosNam2_Oth.setVisibility(View.VISIBLE);
                         lineTHosNam2_Oth.setVisibility(View.VISIBLE);

                         chkTHosNamDK.setChecked(false);
                    }
                    else
                    {
                         secTHosNam2_Oth.setVisibility(View.GONE);
                         lineTHosNam2_Oth.setVisibility(View.GONE);
                         txtTHosNam2_Oth.setText("");


                    }
               }
               @Override
               public void onNothingSelected(AdapterView<?> parentView) {
               }
          });


//         rdogrpTHosNam2 = (RadioGroup) findViewById(R.id.rdogrpTHosNam2);
//
//         rdoTHosNam21 = (RadioButton) findViewById(R.id.rdoTHosNam21);
//         rdoTHosNam22 = (RadioButton) findViewById(R.id.rdoTHosNam22);
//         rdoTHosNam23 = (RadioButton) findViewById(R.id.rdoTHosNam23);
////         rdoTHosNam24 = (RadioButton) findViewById(R.id.rdoTHosNam24);
//         rdogrpTHosNam2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
//         @Override
//         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
//             String rbData = "";
//             RadioButton rb;
//             String[] d_rdogrpTHosNam2 = new String[] {"1","2","7"};
//             for (int i = 0; i < rdogrpTHosNam2.getChildCount(); i++)
//             {
//               rb = (RadioButton)rdogrpTHosNam2.getChildAt(i);
//               if (rb.isChecked()) rbData = d_rdogrpTHosNam2[i];
//             }
//
//             if(rbData.equalsIgnoreCase("1"))
//             {
//                    secTHosNam2_Oth.setVisibility(View.GONE);
//                    lineTHosNam2_Oth.setVisibility(View.GONE);
//                    txtTHosNam2_Oth.setText("");
//                  chkTHosNamDK.setChecked(false);
//             }
//             else if(rbData.equalsIgnoreCase("2"))
//             {
//                    secTHosNam2_Oth.setVisibility(View.GONE);
//                    lineTHosNam2_Oth.setVisibility(View.GONE);
//                    txtTHosNam2_Oth.setText("");
//                  chkTHosNamDK.setChecked(false);
//             }
//             else if(rbData.equalsIgnoreCase("7"))
//             {
//                    secTHosNam2_Oth.setVisibility(View.VISIBLE);
//                    lineTHosNam2_Oth.setVisibility(View.VISIBLE);
//                  chkTHosNamDK.setChecked(false);
//             }
//             else
//             {
//                  secTHosNam2_Oth.setVisibility(View.GONE);
//                  lineTHosNam2_Oth.setVisibility(View.GONE);
//                  txtTHosNam2_Oth.setText("");
//
//             }
//            }
//         public void onNothingSelected(AdapterView<?> adapterView) {
//             return;
//            }
//         });


         secTHosNam2_Oth=(LinearLayout)findViewById(R.id.secTHosNam2_Oth);
         lineTHosNam2_Oth=(View)findViewById(R.id.lineTHosNam2_Oth);
         VlblTHosNam2_Oth=(TextView) findViewById(R.id.VlblTHosNam2_Oth);
         txtTHosNam2_Oth=(EditText) findViewById(R.id.txtTHosNam2_Oth);
         secTHosNam3=(LinearLayout)findViewById(R.id.secTHosNam3);
         lineTHosNam3=(View)findViewById(R.id.lineTHosNam3);
         VlblTHosNam3=(TextView) findViewById(R.id.VlblTHosNam3);
         spnTHosNam3=(Spinner) findViewById(R.id.spnTHosNam3);
         List<String> listTHosNam3 = new ArrayList<String>();
         
         listTHosNam3.add("");
         listTHosNam3.add("1-ঢাকা শিশু হাসপাতাল (Dhaka Shishu Hospital)");
         listTHosNam3.add("2-ডাঃ এম আর খান  শিশু হাসপাতাল (Dr. MR Khan Shishu Hospital)");
         listTHosNam3.add("7-অন্যান্য (Other)");

         ArrayAdapter<String> adptrTHosNam3= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listTHosNam3);
         spnTHosNam3.setAdapter(adptrTHosNam3);

         spnTHosNam3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnTHosNam3.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnTHosNam3.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("1"))
                 {
                    secTHosNam3_Oth.setVisibility(View.GONE);
                    lineTHosNam3_Oth.setVisibility(View.GONE);
                    txtTHosNam3_Oth.setText("");

                    chkTHosNamDK.setChecked(false);
                 }
                 else if(spnData.equalsIgnoreCase("2"))
                 {
                    secTHosNam3_Oth.setVisibility(View.GONE);
                    lineTHosNam3_Oth.setVisibility(View.GONE);
                    txtTHosNam3_Oth.setText("");

                    chkTHosNamDK.setChecked(false);
                 }
                 else if(spnData.equalsIgnoreCase("7"))
                 {
                    secTHosNam3_Oth.setVisibility(View.VISIBLE);
                    lineTHosNam3_Oth.setVisibility(View.VISIBLE);

                      chkTHosNamDK.setChecked(false);
                 }
                 else
                 {
                      secTHosNam3_Oth.setVisibility(View.GONE);
                      lineTHosNam3_Oth.setVisibility(View.GONE);
                      txtTHosNam3_Oth.setText("");


                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secTHosNam3_Oth=(LinearLayout)findViewById(R.id.secTHosNam3_Oth);
         lineTHosNam3_Oth=(View)findViewById(R.id.lineTHosNam3_Oth);
         VlblTHosNam3_Oth=(TextView) findViewById(R.id.VlblTHosNam3_Oth);
         txtTHosNam3_Oth=(EditText) findViewById(R.id.txtTHosNam3_Oth);
         secTHosNamDK=(LinearLayout)findViewById(R.id.secTHosNamDK);
         lineTHosNamDK=(View)findViewById(R.id.lineTHosNamDK);
         VlblTHosNamDK=(TextView) findViewById(R.id.VlblTHosNamDK);
         chkTHosNamDK=(CheckBox) findViewById(R.id.chkTHosNamDK);
         secTDtAdmHos=(LinearLayout)findViewById(R.id.secTDtAdmHos);
         lineTDtAdmHos=(View)findViewById(R.id.lineTDtAdmHos);
         VlblTDtAdmHos=(TextView) findViewById(R.id.VlblTDtAdmHos);
         dtpTDtAdmHos=(EditText) findViewById(R.id.dtpTDtAdmHos);
         secTAdmHosD=(LinearLayout)findViewById(R.id.secTAdmHosD);
         lineTAdmHosD=(View)findViewById(R.id.lineTAdmHosD);
         VlblTAdmHosD=(TextView) findViewById(R.id.VlblTAdmHosD);
         txtTAdmHosD=(EditText) findViewById(R.id.txtTAdmHosD);
         secTDurIlBeHos=(LinearLayout)findViewById(R.id.secTDurIlBeHos);
         lineTDurIlBeHos=(View)findViewById(R.id.lineTDurIlBeHos);
         VlblTDurIlBeHos=(TextView) findViewById(R.id.VlblTDurIlBeHos);
         txtTDurIlBeHos=(EditText) findViewById(R.id.txtTDurIlBeHos);

          txtTDurIlBeHos.addTextChangedListener(new TextWatcher() {
               @Override
               public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

               }

               @Override
               public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(txtTDurIlBeHos.getText().toString().length()>0){
                         chkTDurIlBeHosDK.setChecked(false);
                    }
               }

               @Override
               public void afterTextChanged(Editable editable) {

               }
          });

         secTDurIlBeHosDK=(LinearLayout)findViewById(R.id.secTDurIlBeHosDK);
         lineTDurIlBeHosDK=(View)findViewById(R.id.lineTDurIlBeHosDK);
         VlblTDurIlBeHosDK=(TextView) findViewById(R.id.VlblTDurIlBeHosDK);
         chkTDurIlBeHosDK=(CheckBox) findViewById(R.id.chkTDurIlBeHosDK);
         secTDisDr=(LinearLayout)findViewById(R.id.secTDisDr);
         lineTDisDr=(View)findViewById(R.id.lineTDisDr);
         VlblTDisDr=(TextView) findViewById(R.id.VlblTDisDr);
         spnTDisDr=(Spinner) findViewById(R.id.spnTDisDr);


          chkTHosNamDK.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (b){
                         spnTHosNam3.setSelection(0);
                         spnTHosNam.setSelection(0);
                         spnTHosNam2.setSelection(0);
                    }

               }
          });

         chkTDurIlBeHosDK.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 txtTDurIlBeHos.setText("");
             }
         });

          txtTAdmHosD.addTextChangedListener(new TextWatcher() {
               @Override
               public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

               }

               @Override
               public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                   if(!txtTAdmHosD.getText().toString().equals("0") & txtTAdmHosD.getText().toString().length()>0)
                   {
                       dtpTDtAdmHos.setText("");
                   }
               }

               @Override
               public void afterTextChanged(Editable editable) {

               }
          });






         List<String> listTDisDr = new ArrayList<String>();
         
         listTDisDr.add("");
         listTDisDr.add("1- নিউমোনিয়া (Pneumonia)   ");
         listTDisDr.add("2-টাইফয়েড (Typhoid fever)  ");
         listTDisDr.add("3-মেনিনজাইটিস বা মস্তিস্কে সংক্রমণ (Meningitis)   ");
         listTDisDr.add("4-ম্রিগি রোগ (Epilepsy)   ");
         listTDisDr.add("5- জ্বরসহ খিঁচুনি (Febrile convulsion)    ");
         listTDisDr.add("6-মস্তিস্কে প্রদাহ (Encephalitis)   ");
         listTDisDr.add("7-অন্যান্য (Other) ");
         listTDisDr.add("8-জানি না (Don’t know) ");
         listTDisDr.add("9-প্রযোজ্য নয় (NA)");
         ArrayAdapter<String> adptrTDisDr= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listTDisDr);
         spnTDisDr.setAdapter(adptrTDisDr);

         spnTDisDr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnTDisDr.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnTDisDr.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("1"))
                 {
                    secTDisDrOth.setVisibility(View.GONE);
                    lineTDisDrOth.setVisibility(View.GONE);
                    txtTDisDrOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("2"))
                 {
                    secTDisDrOth.setVisibility(View.GONE);
                    lineTDisDrOth.setVisibility(View.GONE);
                    txtTDisDrOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("3"))
                 {
                    secTDisDrOth.setVisibility(View.GONE);
                    lineTDisDrOth.setVisibility(View.GONE);
                    txtTDisDrOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("4"))
                 {
                    secTDisDrOth.setVisibility(View.GONE);
                    lineTDisDrOth.setVisibility(View.GONE);
                    txtTDisDrOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("5"))
                 {
                    secTDisDrOth.setVisibility(View.GONE);
                    lineTDisDrOth.setVisibility(View.GONE);
                    txtTDisDrOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("6"))
                 {
                    secTDisDrOth.setVisibility(View.GONE);
                    lineTDisDrOth.setVisibility(View.GONE);
                    txtTDisDrOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("7"))
                 {
                      secTDisDrOth.setVisibility(View.VISIBLE);
                      lineTDisDrOth.setVisibility(View.VISIBLE);
                 }
                 else if(spnData.equalsIgnoreCase("8"))
                 {
                    secTDisDrOth.setVisibility(View.GONE);
                    lineTDisDrOth.setVisibility(View.GONE);
                    txtTDisDrOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("9"))
                 {
                    secTDisDrOth.setVisibility(View.GONE);
                    lineTDisDrOth.setVisibility(View.GONE);
                    txtTDisDrOth.setText("");
                 }
                 else
                 {
                      secTDisDrOth.setVisibility(View.GONE);
                      lineTDisDrOth.setVisibility(View.GONE);
                      txtTDisDrOth.setText("");
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secTDisDrOth=(LinearLayout)findViewById(R.id.secTDisDrOth);
         lineTDisDrOth=(View)findViewById(R.id.lineTDisDrOth);
         VlblTDisDrOth=(TextView) findViewById(R.id.VlblTDisDrOth);
         txtTDisDrOth=(EditText) findViewById(R.id.txtTDisDrOth);
         secTReco=(LinearLayout)findViewById(R.id.secTReco);
         lineTReco=(View)findViewById(R.id.lineTReco);
         VlblTReco = (TextView) findViewById(R.id.VlblTReco);
         rdogrpTReco = (RadioGroup) findViewById(R.id.rdogrpTReco);
         
         rdoTReco1 = (RadioButton) findViewById(R.id.rdoTReco1);
         rdoTReco2 = (RadioButton) findViewById(R.id.rdoTReco2);
         rdoTReco3 = (RadioButton) findViewById(R.id.rdoTReco3);
         rdogrpTReco.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpTReco = new String[] {"1","2","8"};
             for (int i = 0; i < rdogrpTReco.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpTReco.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpTReco[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secTDurReco.setVisibility(View.GONE);
                    lineTDurReco.setVisibility(View.GONE);
                  secTInRecoLabel.setVisibility(View.VISIBLE);
                  lineTInRecoLabel.setVisibility(View.VISIBLE);
                  secTInReco.setVisibility(View.VISIBLE);
                  lineTInReco.setVisibility(View.VISIBLE);
                  secTInReco2.setVisibility(View.VISIBLE);
                  lineTInReco2.setVisibility(View.VISIBLE);



             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secTDurReco.setVisibility(View.GONE);
                    lineTDurReco.setVisibility(View.GONE);
                  secTInReco.setVisibility(View.VISIBLE);
                  lineTInReco.setVisibility(View.VISIBLE);
                  secTInReco2.setVisibility(View.VISIBLE);
                  lineTInReco2.setVisibility(View.VISIBLE);


             }
             else if(rbData.equalsIgnoreCase("1"))
             {
                    secTDurReco.setVisibility(View.VISIBLE);
                    lineTDurReco.setVisibility(View.VISIBLE);
                  secTInReco.setVisibility(View.VISIBLE);
                  lineTInReco.setVisibility(View.VISIBLE);
                  secTInReco2.setVisibility(View.VISIBLE);
                  lineTInReco2.setVisibility(View.VISIBLE);
             }
             else{
                  secTDurReco.setVisibility(View.GONE);
                  lineTDurReco.setVisibility(View.GONE);
                  secTInReco.setVisibility(View.VISIBLE);
                  lineTInReco.setVisibility(View.VISIBLE);
                  secTInReco2.setVisibility(View.VISIBLE);
                  lineTInReco2.setVisibility(View.VISIBLE);
                  txtTDurReco.setText("");

             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secTDurReco=(LinearLayout)findViewById(R.id.secTDurReco);
         lineTDurReco=(View)findViewById(R.id.lineTDurReco);
         VlblTDurReco=(TextView) findViewById(R.id.VlblTDurReco);
         txtTDurReco=(EditText) findViewById(R.id.txtTDurReco);

          txtTDurReco.addTextChangedListener(new TextWatcher() {
               @Override
               public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

               }

               @Override
               public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(txtTDurReco.getText().toString().length()>0)
                    {
                         secTInRecoLabel.setVisibility(View.GONE);
                         lineTInRecoLabel.setVisibility(View.GONE);
                         secTInReco.setVisibility(View.GONE);
                         lineTInReco.setVisibility(View.GONE);
                         secTInRecoOth.setVisibility(View.GONE);
                         lineTInRecoOth.setVisibility(View.GONE);
                         secTInReco2.setVisibility(View.GONE);
                         lineTInReco2.setVisibility(View.GONE);
                         secTInRecoOth2.setVisibility(View.GONE);
                         lineTInRecoOth2.setVisibility(View.GONE);
                    }else
                    {
                         secTInRecoLabel.setVisibility(View.VISIBLE);
                         lineTInRecoLabel.setVisibility(View.VISIBLE);
                         secTInReco.setVisibility(View.VISIBLE);
                         lineTInReco.setVisibility(View.VISIBLE);
                         secTInReco2.setVisibility(View.VISIBLE);
                         lineTInReco2.setVisibility(View.VISIBLE);
                    }
               }

               @Override
               public void afterTextChanged(Editable editable) {

               }
          });

         secTInRecoLabel=(LinearLayout)findViewById(R.id.secTInRecoLabel);
         lineTInRecoLabel=(View)findViewById(R.id.lineTInRecoLabel);
         secTInReco=(LinearLayout)findViewById(R.id.secTInReco);
         lineTInReco=(View)findViewById(R.id.lineTInReco);
         VlblTInReco=(TextView) findViewById(R.id.VlblTInReco);
         spnTInReco=(Spinner) findViewById(R.id.spnTInReco);
         List<String> listTInReco = new ArrayList<String>();
         
         listTInReco.add("");
         listTInReco.add("1-মৃত্যু (Death)   ");
         listTInReco.add("2- নাড়ী ছিদ্র হওয়া (Intestinal perforation)");
         listTInReco.add("3-অন্যান্য (Other)");
         ArrayAdapter<String> adptrTInReco= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listTInReco);
         spnTInReco.setAdapter(adptrTInReco);

         spnTInReco.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnTInReco.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnTInReco.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("1"))
                 {
                    secTInRecoOth.setVisibility(View.GONE);
                    lineTInRecoOth.setVisibility(View.GONE);
                      spnTInReco2.setEnabled(true);
                    txtTInRecoOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("2"))
                 {
                    secTInRecoOth.setVisibility(View.GONE);
                    lineTInRecoOth.setVisibility(View.GONE);
                      spnTInReco2.setEnabled(true);
                    txtTInRecoOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("3"))
                 {
                      secTInRecoOth.setVisibility(View.VISIBLE);
                      lineTInRecoOth.setVisibility(View.VISIBLE);
                      spnTInReco2.setEnabled(false);
                      spnTInReco2.setSelection(0);
                 }
                 else
                 {
                      secTInRecoOth.setVisibility(View.GONE);
                      lineTInRecoOth.setVisibility(View.GONE);
                      spnTInReco2.setEnabled(true);
                      txtTInRecoOth.setText("");
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secTInRecoOth=(LinearLayout)findViewById(R.id.secTInRecoOth);
         lineTInRecoOth=(View)findViewById(R.id.lineTInRecoOth);
         VlblTInRecoOth=(TextView) findViewById(R.id.VlblTInRecoOth);
         txtTInRecoOth=(EditText) findViewById(R.id.txtTInRecoOth);
         secTInReco2=(LinearLayout)findViewById(R.id.secTInReco2);
         lineTInReco2=(View)findViewById(R.id.lineTInReco2);
         VlblTInReco2=(TextView) findViewById(R.id.VlblTInReco2);
         spnTInReco2=(Spinner) findViewById(R.id.spnTInReco2);
         List<String> listTInReco2 = new ArrayList<String>();
         
         listTInReco2.add("");
         listTInReco2.add("1-মৃত্যু (Death)   ");
         listTInReco2.add("2- নাড়ী ছিদ্র হওয়া (Intestinal perforation)");
         listTInReco2.add("3-অন্যান্য (Other) ");
         ArrayAdapter<String> adptrTInReco2= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listTInReco2);
         spnTInReco2.setAdapter(adptrTInReco2);

         spnTInReco2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnTInReco2.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnTInReco2.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("1"))
                 {
                    secTInRecoOth2.setVisibility(View.GONE);
                    lineTInRecoOth2.setVisibility(View.GONE);
                    txtTInRecoOth2.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("2"))
                 {
                    secTInRecoOth2.setVisibility(View.GONE);
                    lineTInRecoOth2.setVisibility(View.GONE);
                    txtTInRecoOth2.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("3"))
                 {
                    secTInRecoOth2.setVisibility(View.VISIBLE);
                    lineTInRecoOth2.setVisibility(View.VISIBLE);
                 }
                 else
                 {
                      secTInRecoOth2.setVisibility(View.GONE);
                      lineTInRecoOth2.setVisibility(View.GONE);
                      txtTInRecoOth2.setText("");
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secTInRecoOth2=(LinearLayout)findViewById(R.id.secTInRecoOth2);
         lineTInRecoOth2=(View)findViewById(R.id.lineTInRecoOth2);
         VlblTInRecoOth2=(TextView) findViewById(R.id.VlblTInRecoOth2);
         txtTInRecoOth2=(EditText) findViewById(R.id.txtTInRecoOth2);
         secHaveHosp=(LinearLayout)findViewById(R.id.secHaveHosp);
         lineHaveHosp=(View)findViewById(R.id.lineHaveHosp);
         VlblHaveHosp = (TextView) findViewById(R.id.VlblHaveHosp);
         rdogrpHaveHosp = (RadioGroup) findViewById(R.id.rdogrpHaveHosp);
         
         rdoHaveHosp1 = (RadioButton) findViewById(R.id.rdoHaveHosp1);
         rdoHaveHosp2 = (RadioButton) findViewById(R.id.rdoHaveHosp2);
         rdoHaveHosp3 = (RadioButton) findViewById(R.id.rdoHaveHosp3);
         rdogrpHaveHosp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpHaveHosp = new String[] {"1","2","8"};
             for (int i = 0; i < rdogrpHaveHosp.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpHaveHosp.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpHaveHosp[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secHospNameLabel.setVisibility(View.GONE);
                    lineHospNameLabel.setVisibility(View.GONE);
                    secHospName.setVisibility(View.GONE);
                    lineHospName.setVisibility(View.GONE);
//                    spnHospName.setSelection(0);
                    secHospName_Oth.setVisibility(View.GONE);
                    lineHospName_Oth.setVisibility(View.GONE);
                    txtHospName_Oth.setText("");
                    secHaveRecordsLabel.setVisibility(View.GONE);
                    lineHaveRecordsLabel.setVisibility(View.GONE);
                    secHaveRecords.setVisibility(View.GONE);
                    lineHaveRecords.setVisibility(View.GONE);
                    rdogrpHaveRecords.clearCheck();
                    secDidRecordMatch2.setVisibility(View.GONE);
                    lineDidRecordMatch2.setVisibility(View.GONE);
                    rdogrpDidRecordMatch2.clearCheck();
                    secDaysOfHosp.setVisibility(View.GONE);
                    lineDaysOfHosp.setVisibility(View.GONE);
                    txtDaysOfHosp.setText("");
                    secDaysOfHospDK.setVisibility(View.GONE);
                    lineDaysOfHospDK.setVisibility(View.GONE);
                    chkDaysOfHospDK.setChecked(false);
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secHospNameLabel.setVisibility(View.GONE);
                    lineHospNameLabel.setVisibility(View.GONE);
                    secHospName.setVisibility(View.GONE);
                    lineHospName.setVisibility(View.GONE);
//                    spnHospName.setSelection(0);
                    secHospName_Oth.setVisibility(View.GONE);
                    lineHospName_Oth.setVisibility(View.GONE);
                    txtHospName_Oth.setText("");
                    secHaveRecordsLabel.setVisibility(View.GONE);
                    lineHaveRecordsLabel.setVisibility(View.GONE);
                    secHaveRecords.setVisibility(View.GONE);
                    lineHaveRecords.setVisibility(View.GONE);
                    rdogrpHaveRecords.clearCheck();
                    secDidRecordMatch2.setVisibility(View.GONE);
                    lineDidRecordMatch2.setVisibility(View.GONE);
                    rdogrpDidRecordMatch2.clearCheck();
                    secDaysOfHosp.setVisibility(View.GONE);
                    lineDaysOfHosp.setVisibility(View.GONE);
                    txtDaysOfHosp.setText("");
                    secDaysOfHospDK.setVisibility(View.GONE);
                    lineDaysOfHospDK.setVisibility(View.GONE);
                    chkDaysOfHospDK.setChecked(false);
             }
             else if(rbData.equalsIgnoreCase("1"))
             {
                    secHospNameLabel.setVisibility(View.VISIBLE);
                    lineHospNameLabel.setVisibility(View.VISIBLE);
                    secHospName.setVisibility(View.VISIBLE);
                    lineHospName.setVisibility(View.VISIBLE);

                    secHaveRecordsLabel.setVisibility(View.VISIBLE);
                    lineHaveRecordsLabel.setVisibility(View.VISIBLE);
                    secHaveRecords.setVisibility(View.VISIBLE);
                    lineHaveRecords.setVisibility(View.VISIBLE);
                    secDaysOfHosp.setVisibility(View.VISIBLE);
                    lineDaysOfHosp.setVisibility(View.VISIBLE);
                    secDaysOfHospDK.setVisibility(View.VISIBLE);
                    lineDaysOfHospDK.setVisibility(View.VISIBLE);
             }
             else
             {
                  secHospNameLabel.setVisibility(View.GONE);
                  lineHospNameLabel.setVisibility(View.GONE);
                  secHospName.setVisibility(View.GONE);
                  lineHospName.setVisibility(View.GONE);
//                  spnHospName.setSelection(0);
                  secHospName_Oth.setVisibility(View.GONE);
                  lineHospName_Oth.setVisibility(View.GONE);
                  txtHospName_Oth.setText("");
                  secHaveRecordsLabel.setVisibility(View.GONE);
                  lineHaveRecordsLabel.setVisibility(View.GONE);
                  secHaveRecords.setVisibility(View.GONE);
                  lineHaveRecords.setVisibility(View.GONE);
                  rdogrpHaveRecords.clearCheck();
                  secDidRecordMatch2.setVisibility(View.GONE);
                  lineDidRecordMatch2.setVisibility(View.GONE);
                  rdogrpDidRecordMatch2.clearCheck();
                  secDaysOfHosp.setVisibility(View.GONE);
                  lineDaysOfHosp.setVisibility(View.GONE);
                  txtDaysOfHosp.setText("");
                  secDaysOfHospDK.setVisibility(View.GONE);
                  lineDaysOfHospDK.setVisibility(View.GONE);
                  chkDaysOfHospDK.setChecked(false);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secHospNameLabel=(LinearLayout)findViewById(R.id.secHospNameLabel);
         lineHospNameLabel=(View)findViewById(R.id.lineHospNameLabel);
         secHospName=(LinearLayout)findViewById(R.id.secHospName);
         lineHospName=(View)findViewById(R.id.lineHospName);
         VlblHospName=(TextView) findViewById(R.id.VlblHospName);
         spnHospName=(Spinner) findViewById(R.id.spnHospName);
         List<String> listHospName = new ArrayList<String>();
         
         listHospName.add("");
         listHospName.add("1-Dhaka Shishu Hospital");
         listHospName.add("2-Dr. M. R. Khan Hospital");
         listHospName.add("3-Popular Diagnostic Center Dhanmondi");
         listHospName.add("4-Popular Diagnostic Center Mirpur");
         listHospName.add("5-Popular Diagnostic Center Shyamoli");
         listHospName.add("77-Other");
         ArrayAdapter<String> adptrHospName= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listHospName);
         spnHospName.setAdapter(adptrHospName);

         spnHospName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnHospName.getSelectedItem().toString().length()!= 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnHospName.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("01"))
                 {
                    secHospName_Oth.setVisibility(View.GONE);
                    lineHospName_Oth.setVisibility(View.GONE);
                    txtHospName_Oth.setText("");
//                    secHaveRecordsLabel.setVisibility(View.GONE);
//                    lineHaveRecordsLabel.setVisibility(View.GONE);
                 }
                 else if(spnData.equalsIgnoreCase("02"))
                 {
                    secHospName_Oth.setVisibility(View.GONE);
                    lineHospName_Oth.setVisibility(View.GONE);
                    txtHospName_Oth.setText("");
//                    secHaveRecordsLabel.setVisibility(View.GONE);
//                    lineHaveRecordsLabel.setVisibility(View.GONE);
                 }
                 else if(spnData.equalsIgnoreCase("03"))
                 {
                    secHospName_Oth.setVisibility(View.GONE);
                    lineHospName_Oth.setVisibility(View.GONE);
                    txtHospName_Oth.setText("");
//                    secHaveRecordsLabel.setVisibility(View.GONE);
//                    lineHaveRecordsLabel.setVisibility(View.GONE);
                 }
                 else if(spnData.equalsIgnoreCase("04"))
                 {
                    secHospName_Oth.setVisibility(View.GONE);
                    lineHospName_Oth.setVisibility(View.GONE);
                    txtHospName_Oth.setText("");
//                    secHaveRecordsLabel.setVisibility(View.GONE);
//                    lineHaveRecordsLabel.setVisibility(View.GONE);
                 }
                 else if(spnData.equalsIgnoreCase("05"))
                 {
                    secHospName_Oth.setVisibility(View.GONE);
                    lineHospName_Oth.setVisibility(View.GONE);
                    txtHospName_Oth.setText("");
//                    secHaveRecordsLabel.setVisibility(View.GONE);
//                    lineHaveRecordsLabel.setVisibility(View.GONE);
                 }
                 else if(spnData.equalsIgnoreCase("77"))
                 {
                    secHospName_Oth.setVisibility(View.VISIBLE);
                    lineHospName_Oth.setVisibility(View.VISIBLE);
//                    secHaveRecordsLabel.setVisibility(View.VISIBLE);
//                    lineHaveRecordsLabel.setVisibility(View.VISIBLE);
                 }
                 else{
                      secHospName_Oth.setVisibility(View.GONE);
                      lineHospName_Oth.setVisibility(View.GONE);
                      txtHospName_Oth.setText("");
//                      secHaveRecordsLabel.setVisibility(View.GONE);
//                      lineHaveRecordsLabel.setVisibility(View.GONE);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secHospName_Oth=(LinearLayout)findViewById(R.id.secHospName_Oth);
         lineHospName_Oth=(View)findViewById(R.id.lineHospName_Oth);
         VlblHospName_Oth=(TextView) findViewById(R.id.VlblHospName_Oth);
         txtHospName_Oth=(EditText) findViewById(R.id.txtHospName_Oth);
         secHaveRecordsLabel=(LinearLayout)findViewById(R.id.secHaveRecordsLabel);
         lineHaveRecordsLabel=(View)findViewById(R.id.lineHaveRecordsLabel);
         secHaveRecords=(LinearLayout)findViewById(R.id.secHaveRecords);
         lineHaveRecords=(View)findViewById(R.id.lineHaveRecords);
         VlblHaveRecords = (TextView) findViewById(R.id.VlblHaveRecords);
         rdogrpHaveRecords = (RadioGroup) findViewById(R.id.rdogrpHaveRecords);
         
         rdoHaveRecords1 = (RadioButton) findViewById(R.id.rdoHaveRecords1);
         rdoHaveRecords2 = (RadioButton) findViewById(R.id.rdoHaveRecords2);
         rdogrpHaveRecords.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpHaveRecords = new String[] {"1","2"};
             for (int i = 0; i < rdogrpHaveRecords.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpHaveRecords.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpHaveRecords[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secDidRecordMatch2.setVisibility(View.GONE);
                    lineDidRecordMatch2.setVisibility(View.GONE);
                    rdogrpDidRecordMatch2.clearCheck();
             }
             else
             {
                    secDidRecordMatch2.setVisibility(View.VISIBLE);
                    lineDidRecordMatch2.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secDidRecordMatch2=(LinearLayout)findViewById(R.id.secDidRecordMatch2);
         lineDidRecordMatch2=(View)findViewById(R.id.lineDidRecordMatch2);
         VlblDidRecordMatch2 = (TextView) findViewById(R.id.VlblDidRecordMatch2);
         rdogrpDidRecordMatch2 = (RadioGroup) findViewById(R.id.rdogrpDidRecordMatch2);
         
         rdoDidRecordMatch21 = (RadioButton) findViewById(R.id.rdoDidRecordMatch21);
         rdoDidRecordMatch22 = (RadioButton) findViewById(R.id.rdoDidRecordMatch22);
         secDaysOfHosp=(LinearLayout)findViewById(R.id.secDaysOfHosp);
         lineDaysOfHosp=(View)findViewById(R.id.lineDaysOfHosp);
         VlblDaysOfHosp=(TextView) findViewById(R.id.VlblDaysOfHosp);
         txtDaysOfHosp=(EditText) findViewById(R.id.txtDaysOfHosp);
         secDaysOfHospDK=(LinearLayout)findViewById(R.id.secDaysOfHospDK);
         lineDaysOfHospDK=(View)findViewById(R.id.lineDaysOfHospDK);
         VlblDaysOfHospDK=(TextView) findViewById(R.id.VlblDaysOfHospDK);
         chkDaysOfHospDK=(CheckBox) findViewById(R.id.chkDaysOfHospDK);
         secTAboIll=(LinearLayout)findViewById(R.id.secTAboIll);
         lineTAboIll=(View)findViewById(R.id.lineTAboIll);
         VlblTAboIll=(TextView) findViewById(R.id.VlblTAboIll);
         txtTAboIll=(EditText) findViewById(R.id.txtTAboIll);

          chkDaysOfHospDK.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                   if(b) {
                       txtDaysOfHosp.setText("");
                   }
               }
          });

          txtDaysOfHosp.addTextChangedListener(new TextWatcher() {
               @Override
               public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

               }

               @Override
               public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(txtDaysOfHosp.getText().toString().length()>0){
                         chkDaysOfHospDK.setChecked(false);
                    }
               }

               @Override
               public void afterTextChanged(Editable editable) {

               }
          });



         dtpTDtAdmHos.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpTDtAdmHos.getRight() - dtpTDtAdmHos.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btnTDtAdmHos"; showDialog(DATE_DIALOG);
                          txtTAdmHosD.setText("");
                      return true;
                     }
                 }
                 return false;
             }
         });



         //Hide all skip variables



         secTsymptLabel.setVisibility(View.GONE);
         lineTsymptLabel.setVisibility(View.GONE);
         secAbdomPain.setVisibility(View.GONE);
         lineAbdomPain.setVisibility(View.GONE);
         secConstipation.setVisibility(View.GONE);
         lineConstipation.setVisibility(View.GONE);
         secHeadache.setVisibility(View.GONE);
         lineHeadache.setVisibility(View.GONE);
         secRash.setVisibility(View.GONE);
         lineRash.setVisibility(View.GONE);
         secDiarrhoea.setVisibility(View.GONE);
         lineDiarrhoea.setVisibility(View.GONE);
         secAbdomDist.setVisibility(View.GONE);
         lineAbdomDist.setVisibility(View.GONE);
         secCoaTon.setVisibility(View.GONE);
         lineCoaTon.setVisibility(View.GONE);
         secCough.setVisibility(View.GONE);
         lineCough.setVisibility(View.GONE);
         secTnone.setVisibility(View.GONE);
         lineTnone.setVisibility(View.GONE);
         secOther.setVisibility(View.GONE);
         lineOther.setVisibility(View.GONE);

         secTakenHCFacility.setVisibility(View.GONE);
         lineTakenHCFacility.setVisibility(View.GONE);
         secTHCarTypLabel.setVisibility(View.GONE);
         lineTHCarTypLabel.setVisibility(View.GONE);
         secHC_PhyMBBS.setVisibility(View.GONE);
         lineHC_PhyMBBS.setVisibility(View.GONE);
         secHC_UnquaDoctor.setVisibility(View.GONE);
         lineHC_UnquaDoctor.setVisibility(View.GONE);
         secHC_Para.setVisibility(View.GONE);
         lineHC_Para.setVisibility(View.GONE);
         secHC_Com.setVisibility(View.GONE);
         lineHC_Com.setVisibility(View.GONE);
         secHC_Pha.setVisibility(View.GONE);
         lineHC_Pha.setVisibility(View.GONE);
         secHC_Hompath.setVisibility(View.GONE);
         lineHC_Hompath.setVisibility(View.GONE);
         secHC_TrHeal.setVisibility(View.GONE);
         lineHC_TrHeal.setVisibility(View.GONE);
         secHC_SpiHeal.setVisibility(View.GONE);
         lineHC_SpiHeal.setVisibility(View.GONE);
         secTHC_Oth.setVisibility(View.GONE);
         lineTHC_Oth.setVisibility(View.GONE);
         secTHC_OthName.setVisibility(View.GONE);
         lineTHC_OthName.setVisibility(View.GONE);
         secHC_Hosp.setVisibility(View.GONE);
         lineHC_Hosp.setVisibility(View.GONE);
         secHC_HospLabel.setVisibility(View.GONE);
         lineHC_HospLabel.setVisibility(View.GONE);
         secHC_Hosp_a1.setVisibility(View.GONE);
         lineHC_Hosp_a1.setVisibility(View.GONE);
         secHC_Hosp_a1_Oth.setVisibility(View.GONE);
         lineHC_Hosp_a1_Oth.setVisibility(View.GONE);
         secHC_Hosp_a2.setVisibility(View.GONE);
         lineHC_Hosp_a2.setVisibility(View.GONE);
         secHC_Hosp_a2_Oth.setVisibility(View.GONE);
         lineHC_Hosp_a2_Oth.setVisibility(View.GONE);
         secHC_Hosp_a3.setVisibility(View.GONE);
         lineHC_Hosp_a3.setVisibility(View.GONE);
         secHC_Hosp_a3_Oth.setVisibility(View.GONE);
         lineHC_Hosp_a3_Oth.setVisibility(View.GONE);
         secHC_Hosp_a4.setVisibility(View.GONE);
         lineHC_Hosp_a4.setVisibility(View.GONE);
         secHC_Hosp_a4_Oth.setVisibility(View.GONE);
         lineHC_Hosp_a4_Oth.setVisibility(View.GONE);
         secHC_Hosp_a5.setVisibility(View.GONE);
         lineHC_Hosp_a5.setVisibility(View.GONE);
         secHC_Hosp_a5_Oth.setVisibility(View.GONE);
         lineHC_Hosp_a5_Oth.setVisibility(View.GONE);
         secHC_Hosp_bLabel.setVisibility(View.GONE);
         lineHC_Hosp_bLabel.setVisibility(View.GONE);
         secHC_Hosp_b.setVisibility(View.GONE);
         lineHC_Hosp_b.setVisibility(View.GONE);
         secHC_Hosp_b_i.setVisibility(View.GONE);
         lineHC_Hosp_b_i.setVisibility(View.GONE);
         secHC_Clin.setVisibility(View.GONE);
         lineHC_Clin.setVisibility(View.GONE);
         secHC_Phy.setVisibility(View.GONE);
         lineHC_Phy.setVisibility(View.GONE);
         secDaysOfSymp.setVisibility(View.GONE);
         lineDaysOfSymp.setVisibility(View.GONE);
         secDaysOfSympDK.setVisibility(View.GONE);
         lineDaysOfSympDK.setVisibility(View.GONE);
         secWorstHour.setVisibility(View.GONE);
         lineWorstHour.setVisibility(View.GONE);
         secWorstHourDK.setVisibility(View.GONE);
         lineWorstHourDK.setVisibility(View.GONE);
         secDaysOfUnable.setVisibility(View.GONE);
         lineDaysOfUnable.setVisibility(View.GONE);
         secDaysOfUnableDK.setVisibility(View.GONE);
         lineDaysOfUnableDK.setVisibility(View.GONE);
         secTAdmHos.setVisibility(View.GONE);
         lineTAdmHos.setVisibility(View.GONE);
         secTHosNamLabel.setVisibility(View.GONE);
         lineTHosNamLabel.setVisibility(View.GONE);
         secTHosNam.setVisibility(View.GONE);
         lineTHosNam.setVisibility(View.GONE);
         secTHosNam_Oth.setVisibility(View.GONE);
         lineTHosNam_Oth.setVisibility(View.GONE);
         secTHosNam2.setVisibility(View.GONE);
         lineTHosNam2.setVisibility(View.GONE);
         secTHosNam2_Oth.setVisibility(View.GONE);
         lineTHosNam2_Oth.setVisibility(View.GONE);
         secTHosNam3.setVisibility(View.GONE);
         lineTHosNam3.setVisibility(View.GONE);
         secTHosNam3_Oth.setVisibility(View.GONE);
         lineTHosNam3_Oth.setVisibility(View.GONE);
         secTHosNamDK.setVisibility(View.GONE);
         lineTHosNamDK.setVisibility(View.GONE);
         secTDtAdmHos.setVisibility(View.GONE);
         lineTDtAdmHos.setVisibility(View.GONE);
         secTAdmHosD.setVisibility(View.GONE);
         lineTAdmHosD.setVisibility(View.GONE);
         secTDurIlBeHos.setVisibility(View.GONE);
         lineTDurIlBeHos.setVisibility(View.GONE);
//         secTDurIlBeHosDK.setVisibility(View.GONE);
//         lineTDurIlBeHosDK.setVisibility(View.GONE);
         secTDisDr.setVisibility(View.GONE);
         lineTDisDr.setVisibility(View.GONE);
         secTDisDrOth.setVisibility(View.GONE);
         lineTDisDrOth.setVisibility(View.GONE);
         secTReco.setVisibility(View.GONE);
         lineTReco.setVisibility(View.GONE);
         secTDurReco.setVisibility(View.GONE);
         lineTDurReco.setVisibility(View.GONE);
         secTInReco.setVisibility(View.GONE);
         lineTInReco.setVisibility(View.GONE);
         secTInRecoOth.setVisibility(View.GONE);
         lineTInRecoOth.setVisibility(View.GONE);
         secTInReco2.setVisibility(View.GONE);
         lineTInReco2.setVisibility(View.GONE);
         secTInRecoOth2.setVisibility(View.GONE);
         lineTInRecoOth2.setVisibility(View.GONE);
         secHaveHosp.setVisibility(View.GONE);
         lineHaveHosp.setVisibility(View.GONE);
         secHospNameLabel.setVisibility(View.GONE);
         lineHospNameLabel.setVisibility(View.GONE);
         secHospName.setVisibility(View.GONE);
         lineHospName.setVisibility(View.GONE);
         secHospName_Oth.setVisibility(View.GONE);
         lineHospName_Oth.setVisibility(View.GONE);
         secHaveRecordsLabel.setVisibility(View.GONE);
         lineHaveRecordsLabel.setVisibility(View.GONE);
         secHaveRecords.setVisibility(View.GONE);
         lineHaveRecords.setVisibility(View.GONE);
         secDidRecordMatch2.setVisibility(View.GONE);
         lineDidRecordMatch2.setVisibility(View.GONE);
         secDaysOfHosp.setVisibility(View.GONE);
         lineDaysOfHosp.setVisibility(View.GONE);
         secDaysOfHospDK.setVisibility(View.GONE);
         lineDaysOfHospDK.setVisibility(View.GONE);
         secTAboIll.setVisibility(View.GONE);
         lineTAboIll.setVisibility(View.GONE);
         secTsymptLabel.setVisibility(View.GONE);
         lineTsymptLabel.setVisibility(View.GONE);
         secAbdomPain.setVisibility(View.GONE);
         lineAbdomPain.setVisibility(View.GONE);
         secConstipation.setVisibility(View.GONE);
         lineConstipation.setVisibility(View.GONE);
         secHeadache.setVisibility(View.GONE);
         lineHeadache.setVisibility(View.GONE);
         secRash.setVisibility(View.GONE);
         lineRash.setVisibility(View.GONE);
         secDiarrhoea.setVisibility(View.GONE);
         lineDiarrhoea.setVisibility(View.GONE);
         secAbdomDist.setVisibility(View.GONE);
         lineAbdomDist.setVisibility(View.GONE);
         secCoaTon.setVisibility(View.GONE);
         lineCoaTon.setVisibility(View.GONE);



         secTakenHCFacility.setVisibility(View.GONE);
         lineTakenHCFacility.setVisibility(View.GONE);
         secTHCarTypLabel.setVisibility(View.GONE);
         lineTHCarTypLabel.setVisibility(View.GONE);
         secHC_PhyMBBS.setVisibility(View.GONE);
         lineHC_PhyMBBS.setVisibility(View.GONE);
         secHC_UnquaDoctor.setVisibility(View.GONE);
         lineHC_UnquaDoctor.setVisibility(View.GONE);
         secHC_Para.setVisibility(View.GONE);
         lineHC_Para.setVisibility(View.GONE);
         secHC_Com.setVisibility(View.GONE);
         lineHC_Com.setVisibility(View.GONE);
         secHC_Pha.setVisibility(View.GONE);
         lineHC_Pha.setVisibility(View.GONE);
         secHC_Hompath.setVisibility(View.GONE);
         lineHC_Hompath.setVisibility(View.GONE);
         secHC_TrHeal.setVisibility(View.GONE);
         lineHC_TrHeal.setVisibility(View.GONE);
         secHC_SpiHeal.setVisibility(View.GONE);
         lineHC_SpiHeal.setVisibility(View.GONE);
         secTHC_Oth.setVisibility(View.GONE);
         lineTHC_Oth.setVisibility(View.GONE);
         secTHC_OthName.setVisibility(View.GONE);
         lineTHC_OthName.setVisibility(View.GONE);
         secHC_Hosp.setVisibility(View.GONE);
         lineHC_Hosp.setVisibility(View.GONE);
         secHC_HospLabel.setVisibility(View.GONE);
         lineHC_HospLabel.setVisibility(View.GONE);

         secHC_Hosp_bLabel.setVisibility(View.GONE);
         lineHC_Hosp_bLabel.setVisibility(View.GONE);
         secHC_Hosp_b.setVisibility(View.GONE);
         lineHC_Hosp_b.setVisibility(View.GONE);
         secHC_Hosp_b_i.setVisibility(View.GONE);
         lineHC_Hosp_b_i.setVisibility(View.GONE);
         secHC_Clin.setVisibility(View.GONE);
         lineHC_Clin.setVisibility(View.GONE);
         secHC_Phy.setVisibility(View.GONE);
         lineHC_Phy.setVisibility(View.GONE);
         secDaysOfSymp.setVisibility(View.GONE);
         lineDaysOfSymp.setVisibility(View.GONE);
         secDaysOfSympDK.setVisibility(View.GONE);
         lineDaysOfSympDK.setVisibility(View.GONE);
         secWorstHour.setVisibility(View.GONE);
         lineWorstHour.setVisibility(View.GONE);
         secWorstHourDK.setVisibility(View.GONE);
         lineWorstHourDK.setVisibility(View.GONE);

         secDaysOfUnable.setVisibility(View.GONE);
         lineDaysOfUnable.setVisibility(View.GONE);
         secDaysOfUnableDK.setVisibility(View.GONE);
         lineDaysOfUnableDK.setVisibility(View.GONE);
         secTAdmHos.setVisibility(View.GONE);
         lineTAdmHos.setVisibility(View.GONE);
         secTHosNamLabel.setVisibility(View.GONE);
         lineTHosNamLabel.setVisibility(View.GONE);
         secTHosNam.setVisibility(View.GONE);
         lineTHosNam.setVisibility(View.GONE);
         secTHosNam_Oth.setVisibility(View.GONE);
         lineTHosNam_Oth.setVisibility(View.GONE);
         secTHosNam2.setVisibility(View.GONE);
         lineTHosNam2.setVisibility(View.GONE);
         secTHosNam2_Oth.setVisibility(View.GONE);
         lineTHosNam2_Oth.setVisibility(View.GONE);
         secTHosNam3.setVisibility(View.GONE);
         lineTHosNam3.setVisibility(View.GONE);
         secTHosNam3_Oth.setVisibility(View.GONE);
         lineTHosNam3_Oth.setVisibility(View.GONE);
         secTHosNamDK.setVisibility(View.GONE);
         lineTHosNamDK.setVisibility(View.GONE);
         secTDtAdmHos.setVisibility(View.GONE);
         lineTDtAdmHos.setVisibility(View.GONE);
         secTAdmHosD.setVisibility(View.GONE);
         lineTAdmHosD.setVisibility(View.GONE);
         secTDurIlBeHos.setVisibility(View.GONE);
         lineTDurIlBeHos.setVisibility(View.GONE);
         secTDisDr.setVisibility(View.GONE);
         lineTDisDr.setVisibility(View.GONE);
         secTDisDrOth.setVisibility(View.GONE);
         lineTDisDrOth.setVisibility(View.GONE);
         secTReco.setVisibility(View.GONE);
         lineTReco.setVisibility(View.GONE);
         secTDurReco.setVisibility(View.GONE);
         lineTDurReco.setVisibility(View.GONE);
         secTInRecoLabel.setVisibility(View.GONE);
         lineTInRecoLabel.setVisibility(View.GONE);
         secTInReco.setVisibility(View.GONE);
         lineTInReco.setVisibility(View.GONE);
         secTInRecoOth.setVisibility(View.GONE);
         lineTInRecoOth.setVisibility(View.GONE);
         secTInReco2.setVisibility(View.GONE);
         lineTInReco2.setVisibility(View.GONE);
         secTInRecoOth2.setVisibility(View.GONE);
         lineTInRecoOth2.setVisibility(View.GONE);
         secHaveHosp.setVisibility(View.GONE);
         lineHaveHosp.setVisibility(View.GONE);
         secHospNameLabel.setVisibility(View.GONE);
         lineHospNameLabel.setVisibility(View.GONE);
         secHospName.setVisibility(View.GONE);
         lineHospName.setVisibility(View.GONE);
         secHospName_Oth.setVisibility(View.GONE);
         lineHospName_Oth.setVisibility(View.GONE);
         secHaveRecordsLabel.setVisibility(View.GONE);
         lineHaveRecordsLabel.setVisibility(View.GONE);
         secHaveRecords.setVisibility(View.GONE);
         lineHaveRecords.setVisibility(View.GONE);
         secDidRecordMatch2.setVisibility(View.GONE);
         lineDidRecordMatch2.setVisibility(View.GONE);
         secDaysOfHosp.setVisibility(View.GONE);
         lineDaysOfHosp.setVisibility(View.GONE);
         secDaysOfHospDK.setVisibility(View.GONE);
         lineDaysOfHospDK.setVisibility(View.GONE);
         secTAboIll.setVisibility(View.GONE);
         lineTAboIll.setVisibility(View.GONE);
         secTsymptOthName.setVisibility(View.GONE);
         lineTsymptOthName.setVisibility(View.GONE);
         secTHCarTypLabel.setVisibility(View.GONE);
         lineTHCarTypLabel.setVisibility(View.GONE);
         secHC_PhyMBBS.setVisibility(View.GONE);
         lineHC_PhyMBBS.setVisibility(View.GONE);
         secHC_UnquaDoctor.setVisibility(View.GONE);
         lineHC_UnquaDoctor.setVisibility(View.GONE);
         secHC_Para.setVisibility(View.GONE);
         lineHC_Para.setVisibility(View.GONE);
         secHC_Com.setVisibility(View.GONE);
         lineHC_Com.setVisibility(View.GONE);
         secHC_Pha.setVisibility(View.GONE);
         lineHC_Pha.setVisibility(View.GONE);
         secHC_Hompath.setVisibility(View.GONE);
         lineHC_Hompath.setVisibility(View.GONE);
         secHC_TrHeal.setVisibility(View.GONE);
         lineHC_TrHeal.setVisibility(View.GONE);
         secHC_SpiHeal.setVisibility(View.GONE);
         lineHC_SpiHeal.setVisibility(View.GONE);
         secTHC_Oth.setVisibility(View.GONE);
         lineTHC_Oth.setVisibility(View.GONE);
         secTHC_OthName.setVisibility(View.GONE);
         lineTHC_OthName.setVisibility(View.GONE);


         secHC_HospLabel.setVisibility(View.GONE);
         lineHC_HospLabel.setVisibility(View.GONE);


         secTHosNam_Oth.setVisibility(View.GONE);
         lineTHosNam_Oth.setVisibility(View.GONE);
         secTHosNam_Oth.setVisibility(View.GONE);
         lineTHosNam_Oth.setVisibility(View.GONE);
         secTHosNam2_Oth.setVisibility(View.GONE);
         lineTHosNam2_Oth.setVisibility(View.GONE);
         secTHosNam2_Oth.setVisibility(View.GONE);
         lineTHosNam2_Oth.setVisibility(View.GONE);
         secTHosNam3_Oth.setVisibility(View.GONE);
         lineTHosNam3_Oth.setVisibility(View.GONE);
         secTHosNamDK.setVisibility(View.GONE);
         lineTHosNamDK.setVisibility(View.GONE);
         secTHosNam3_Oth.setVisibility(View.GONE);
         lineTHosNam3_Oth.setVisibility(View.GONE);
         secTHosNamDK.setVisibility(View.GONE);
         lineTHosNamDK.setVisibility(View.GONE);
         secTDisDrOth.setVisibility(View.GONE);
         lineTDisDrOth.setVisibility(View.GONE);

         secTDurReco.setVisibility(View.GONE);
         lineTDurReco.setVisibility(View.GONE);
         secTInRecoLabel.setVisibility(View.GONE);
         lineTInRecoLabel.setVisibility(View.GONE);
        ;
         secTInRecoOth.setVisibility(View.GONE);
         lineTInRecoOth.setVisibility(View.GONE);

         secTInRecoOth2.setVisibility(View.GONE);
         lineTInRecoOth2.setVisibility(View.GONE);

         secHospNameLabel.setVisibility(View.GONE);
         lineHospNameLabel.setVisibility(View.GONE);
         secHospName.setVisibility(View.GONE);
         lineHospName.setVisibility(View.GONE);

         secHaveRecordsLabel.setVisibility(View.GONE);
         lineHaveRecordsLabel.setVisibility(View.GONE);
         secHaveRecords.setVisibility(View.GONE);
         lineHaveRecords.setVisibility(View.GONE);
         secDidRecordMatch2.setVisibility(View.GONE);
         lineDidRecordMatch2.setVisibility(View.GONE);
         secDaysOfHosp.setVisibility(View.GONE);
         lineDaysOfHosp.setVisibility(View.GONE);
         secDaysOfHospDK.setVisibility(View.GONE);
         lineDaysOfHospDK.setVisibility(View.GONE);
         secHospNameLabel.setVisibility(View.GONE);
         lineHospNameLabel.setVisibility(View.GONE);
         secHospName.setVisibility(View.GONE);
         lineHospName.setVisibility(View.GONE);
         secHospName_Oth.setVisibility(View.GONE);
         lineHospName_Oth.setVisibility(View.GONE);
         secTDurIlBeHosDK.setVisibility(View.GONE);
         lineTDurIlBeHosDK.setVisibility(View.GONE);





          DataSearch(UNCODE,STRUCTURENO,HOUSEHOLDSL,VISITNO,MEMSL);


        Button cmdSave = (Button) findViewById(R.id.cmdSave);
        cmdSave.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) { 
            DataSave();
        }});
     }
     catch(Exception  e)
     {
         Connection.MessageBox(TyphoidCase.this, e.getMessage());
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
             Connection.MessageBox(TyphoidCase.this, "Required field: Ward No.");
             txtUNCode.requestFocus(); 
             return;	
           }
         else if(txtStructureNo.getText().toString().length()==0 & secStructureNo.isShown())
           {
             Connection.MessageBox(TyphoidCase.this, "Required field: Structure No.");
             txtStructureNo.requestFocus(); 
             return;	
           }
         else if(txtHouseholdSl.getText().toString().length()==0 & secHouseholdSl.isShown())
           {
             Connection.MessageBox(TyphoidCase.this, "Required field: Household Sl.");
             txtHouseholdSl.requestFocus(); 
             return;	
           }
         else if(txtVisitNo.getText().toString().length()==0 & secVisitNo.isShown())
           {
             Connection.MessageBox(TyphoidCase.this, "Required field: Visit No.");
             txtVisitNo.requestFocus(); 
             return;	
           }
         else if(txtMemSl.getText().toString().length()==0 & secMemSl.isShown())
           {
             Connection.MessageBox(TyphoidCase.this, "Required field: Member Serial.");
             txtMemSl.requestFocus(); 
             return;	
           }
         
         else if(!rdoHaveFever1.isChecked() & !rdoHaveFever2.isChecked() & !rdoHaveFever3.isChecked() & secHaveFever.isShown())
           {
              Connection.MessageBox(TyphoidCase.this, "Select anyone options from (গত ২ মাসে আপনার শিশুর কি ৩ দিন বা তার বেশি  জ্বর ছিল? (Within the last 2 months did this child have an illness with fever for 3 days or more?) ).");
              rdoHaveFever1.requestFocus();
              return;
           }
         
         else if(!rdoAbdomPain1.isChecked() & !rdoAbdomPain2.isChecked() & secAbdomPain .isShown())
           {
              Connection.MessageBox(TyphoidCase.this, "Select anyone options from (a. পেট ব্যাথা (Abdominal pain) ).");
              rdoAbdomPain1.requestFocus();
              return;
           }
         
         else if(!rdoConstipation1.isChecked() & !rdoConstipation2.isChecked() & secConstipation.isShown())
           {
              Connection.MessageBox(TyphoidCase.this, "Select anyone options from ( b.কোস্ট কাঠিন্য (Constipation)).");
              rdoConstipation1.requestFocus();
              return;
           }
         
         else if(!rdoHeadache1.isChecked() & !rdoHeadache2.isChecked() & secHeadache.isShown())
           {
              Connection.MessageBox(TyphoidCase.this, "Select anyone options from (c. মাথা ব্যাথা (Headache)).");
              rdoHeadache1.requestFocus();
              return;
           }
         
         else if(!rdoRash1.isChecked() & !rdoRash2.isChecked() & secRash .isShown())
           {
              Connection.MessageBox(TyphoidCase.this, "Select anyone options from (d. শরীরে দানা  (Rash)).");
              rdoRash1.requestFocus();
              return;
           }
         
         else if(!rdoDiarrhoea1.isChecked() & !rdoDiarrhoea2.isChecked() & secDiarrhoea.isShown())
           {
              Connection.MessageBox(TyphoidCase.this, "Select anyone options from (e.পাতলা পায়খানা (Diarrhoea) ).");
              rdoDiarrhoea1.requestFocus();
              return;
           }
         
         else if(!rdoAbdomDist1.isChecked() & !rdoAbdomDist2.isChecked() & secAbdomDist.isShown())
           {
              Connection.MessageBox(TyphoidCase.this, "Select anyone options from (f.পেট ফুলে যাওয়া (Abdominal distension)).");
              rdoAbdomDist1.requestFocus();
              return;
           }
         
         else if(!rdoCoaTon1.isChecked() & !rdoCoaTon2.isChecked() & secCoaTon.isShown())
           {
              Connection.MessageBox(TyphoidCase.this, "Select anyone options from (g.জিহ্বায় সাদা আবরণ (Coated tongue) ).");
              rdoCoaTon1.requestFocus();
              return;
           }
         
         else if(!rdoCough1.isChecked() & !rdoCough2.isChecked() & secCough.isShown())
           {
              Connection.MessageBox(TyphoidCase.this, "Select anyone options from (h.কাশি (Cough)).");
              rdoCough1.requestFocus();
              return;
           }
         
         else if(!rdoTnone1.isChecked() & !rdoTnone2.isChecked() & secTnone.isShown())
           {
              Connection.MessageBox(TyphoidCase.this, "Select anyone options from (i.কিছু না (None) ).");
              rdoTnone1.requestFocus();
              return;
           }
         
         else if(!rdoOther1.isChecked() & !rdoOther2.isChecked() & secOther.isShown())
           {
              Connection.MessageBox(TyphoidCase.this, "Select anyone options from (j.অন্যান্য  (Other) ).");
              rdoOther1.requestFocus();
              return;
           }
         else if(txtTsymptOthName.getText().toString().length()==0 & secTsymptOthName.isShown())
           {
             Connection.MessageBox(TyphoidCase.this, "Required field: k.অন্যান্য উল্লেখ করুন  (Others Specify).");
             txtTsymptOthName.requestFocus(); 
             return;	
           }
         
         else if(!rdoTakenHCFacility1.isChecked() & !rdoTakenHCFacility2.isChecked() & !rdoTakenHCFacility3.isChecked() & secTakenHCFacility.isShown())
           {
              Connection.MessageBox(TyphoidCase.this, "Select anyone options from (এই অসুস্থতার সময় এই শিশুটিকে কি কোন স্বাস্থ্যসেবা দানকারীর কাছে নিয়ে গিয়েছিলেন ? (During this episode of illness, did you bring your child to a health care provider?)).");
              rdoTakenHCFacility1.requestFocus();
              return;
           }
         
         else if(!rdoHC_PhyMBBS1.isChecked() & !rdoHC_PhyMBBS2.isChecked() & !rdoHC_PhyMBBS3.isChecked() & secHC_PhyMBBS.isShown())
           {
              Connection.MessageBox(TyphoidCase.this, "Select anyone options from (1.পাশ করা ডাক্তার যেমন MBBS বা এর উপর (MBBS and above) ).");
              rdoHC_PhyMBBS1.requestFocus();
              return;
           }
         
         else if(!rdoHC_UnquaDoctor1.isChecked() & !rdoHC_UnquaDoctor2.isChecked() & secHC_UnquaDoctor.isShown())
           {
              Connection.MessageBox(TyphoidCase.this, "Select anyone options from (2.অদক্ষ ডাক্তার/ LMAF (Unqualified doctor/LMAF) ).");
              rdoHC_UnquaDoctor1.requestFocus();
              return;
           }
         
         else if(!rdoHC_Para1.isChecked() & !rdoHC_Para2.isChecked() & !rdoHC_Para3.isChecked() & secHC_Para.isShown())
           {
              Connection.MessageBox(TyphoidCase.this, "Select anyone options from (3.প্যারামেডিক (GoB/NGO) (Paramedics (GoB/NGO))  ).");
              rdoHC_Para1.requestFocus();
              return;
           }
         
         else if(!rdoHC_Com1.isChecked() & !rdoHC_Com2.isChecked() & !rdoHC_Com3.isChecked()  & secHC_Com.isShown())
           {
              Connection.MessageBox(TyphoidCase.this, "Select anyone options from (4.কম্পাউণ্ডার (Compounder)   ).");
              rdoHC_Com1.requestFocus();
              return;
           }
         
         else if(!rdoHC_Pha1.isChecked() & !rdoHC_Pha2.isChecked() & !rdoHC_Pha3.isChecked() &  secHC_Pha.isShown())
           {
              Connection.MessageBox(TyphoidCase.this, "Select anyone options from (5.ঔষধ বিক্রেতা/ফার্মেসি (Drug seller/Pharmacy)  ).");
              rdoHC_Pha1.requestFocus();
              return;
           }
         
         else if(!rdoHC_Hompath1.isChecked() & !rdoHC_Hompath2.isChecked() & !rdoHC_Hompath3.isChecked() & secHC_Hompath.isShown())
           {
              Connection.MessageBox(TyphoidCase.this, "Select anyone options from (6.হোমিওপ্যাঁথ (Homeopath)  ).");
              rdoHC_Hompath1.requestFocus();
              return;
           }
         
         else if(!rdoHC_TrHeal1.isChecked() & !rdoHC_TrHeal2.isChecked() & !rdoHC_TrHeal3.isChecked() & secHC_TrHeal.isShown())
           {
              Connection.MessageBox(TyphoidCase.this, "Select anyone options from (7.কবিরাজ (Traditional care provider)  ).");
              rdoHC_TrHeal1.requestFocus();
              return;
           }
         
         else if(!rdoHC_SpiHeal1.isChecked() & !rdoHC_SpiHeal2.isChecked() & !rdoHC_SpiHeal3.isChecked() & secHC_SpiHeal.isShown())
           {
              Connection.MessageBox(TyphoidCase.this, "Select anyone options from (8.আধ্যাত্মিক চিকিৎসক (Spiritual healer) ).");
              rdoHC_SpiHeal1.requestFocus();
              return;
           }
         
         else if(!rdoTHC_Oth1.isChecked() & !rdoTHC_Oth2.isChecked() & !rdoTHC_Oth3.isChecked() & secTHC_Oth.isShown())
           {
              Connection.MessageBox(TyphoidCase.this, "Select anyone options from (9.অন্যান্য  (Other)).");
              rdoTHC_Oth1.requestFocus();
              return;
           }
         else if(txtTHC_OthName.getText().toString().length()==0 & secTHC_OthName.isShown())
           {
             Connection.MessageBox(TyphoidCase.this, "Required field: 10.অন্যান্য উল্লেখ করুন (Others Specify).");
             txtTHC_OthName.requestFocus(); 
             return;	
           }
         
         else if(!rdoHC_Hosp1.isChecked() & !rdoHC_Hosp2.isChecked() & !rdoHC_Hosp3.isChecked() & secHC_Hosp.isShown())
           {
              Connection.MessageBox(TyphoidCase.this, "Select anyone options from (শিশুকে কি কোন হাসপাতালে নিয়ে গিয়েছিলেন? (What healthcare facility was he/she taken to? Hospital)).");
              rdoHC_Hosp1.requestFocus();
              return;
           }
         else if(spnHC_Hosp_a1.getSelectedItemPosition()==0  & secHC_Hosp_a1.isShown())
           {
             Connection.MessageBox(TyphoidCase.this, "Required field: 1..");
             spnHC_Hosp_a1.requestFocus(); 
             return;	
           }
         else if(txtHC_Hosp_a1_Oth.getText().toString().length()==0 & secHC_Hosp_a1_Oth.isShown())
           {
             Connection.MessageBox(TyphoidCase.this, "Required field: Name of the other hospital-1.");
             txtHC_Hosp_a1_Oth.requestFocus(); 
             return;	
           }
//         else if(spnHC_Hosp_a2.getSelectedItemPosition()==0  & secHC_Hosp_a2.isShown())
//           {
//             Connection.MessageBox(TyphoidCase.this, "Required field: 2..");
//             spnHC_Hosp_a2.requestFocus();
//             return;
//           }
         else if(txtHC_Hosp_a2_Oth.getText().toString().length()==0 & secHC_Hosp_a2_Oth.isShown())
           {
             Connection.MessageBox(TyphoidCase.this, "Required field: Name of the other hospital-2.");
             txtHC_Hosp_a2_Oth.requestFocus(); 
             return;	
           }
//         else if(spnHC_Hosp_a3.getSelectedItemPosition()==0  & secHC_Hosp_a3.isShown())
//           {
//             Connection.MessageBox(TyphoidCase.this, "Required field: 3..");
//             spnHC_Hosp_a3.requestFocus();
//             return;
//           }
         else if(txtHC_Hosp_a3_Oth.getText().toString().length()==0 & secHC_Hosp_a3_Oth.isShown())
           {
             Connection.MessageBox(TyphoidCase.this, "Required field: Name of the other hospial-3.");
             txtHC_Hosp_a3_Oth.requestFocus(); 
             return;	
           }
//         else if(spnHC_Hosp_a4.getSelectedItemPosition()==0  & secHC_Hosp_a4.isShown())
//           {
//             Connection.MessageBox(TyphoidCase.this, "Required field: 4..");
//             spnHC_Hosp_a4.requestFocus();
//             return;
//           }
         else if(txtHC_Hosp_a4_Oth.getText().toString().length()==0 & secHC_Hosp_a4_Oth.isShown())
           {
             Connection.MessageBox(TyphoidCase.this, "Required field: Name of the other hospital-4.");
             txtHC_Hosp_a4_Oth.requestFocus(); 
             return;	
           }
//         else if(spnHC_Hosp_a5.getSelectedItemPosition()==0  & secHC_Hosp_a5.isShown())
//           {
//             Connection.MessageBox(TyphoidCase.this, "Required field: 5..");
//             spnHC_Hosp_a5.requestFocus();
//             return;
//           }
         else if(txtHC_Hosp_a5_Oth.getText().toString().length()==0 & secHC_Hosp_a5_Oth.isShown())
           {
             Connection.MessageBox(TyphoidCase.this, "Required field: Name of the other hospital-5.");
             txtHC_Hosp_a5_Oth.requestFocus(); 
             return;	
           }
         
         else if(!rdoHC_Hosp_b1.isChecked() & !rdoHC_Hosp_b2.isChecked() & secHC_Hosp_b.isShown())
           {
              Connection.MessageBox(TyphoidCase.this, "Select anyone options from (উত্তরদাতা কি হাসপাতালের প্রেসক্রিপশন অথবা অন্য কোন প্রমানাদি/কাগজপত্র দেখাতে পেরেছেন? (Was the respondent able to produce records of this visit?)).");
              rdoHC_Hosp_b1.requestFocus();
              return;
           }
         
         else if(!rdoHC_Hosp_b_i1.isChecked() & !rdoHC_Hosp_b_i2.isChecked() & secHC_Hosp_b_i.isShown())
           {
              Connection.MessageBox(TyphoidCase.this, "Select anyone options from (হাসপাতালের প্রেসক্রিপশন অথবা প্রমানাদি/কাগজপত্র কি শিশু যে হাসপাতাল ভিজিট করেছে সেই হাসপাতালের? (Did the records match the healthcare facility they stated the person was taken to?)).");
              rdoHC_Hosp_b_i1.requestFocus();
              return;
           }
         
         else if(!rdoHC_Clin1.isChecked() & !rdoHC_Clin2.isChecked() & !rdoHC_Clin3.isChecked() & secHC_Clin.isShown())
           {
              Connection.MessageBox(TyphoidCase.this, "Select anyone options from (শিশুকে কি কোন ক্লিনিকে নিয়ে গিয়েছিলেন? ( Was he/she taken to Clinic) ).");
              rdoHC_Clin1.requestFocus();
              return;
           }
         
         else if(!rdoHC_Phy1.isChecked() & !rdoHC_Phy2.isChecked() & !rdoHC_Phy3.isChecked() & secHC_Phy.isShown())
           {
              Connection.MessageBox(TyphoidCase.this, "Select anyone options from (শিশুকে কি কোন প্রাইভেট ডাক্তারের চেম্বারে নিয়ে গিয়েছিলেন? (Was he/she taken to Private practitioner)).");
              rdoHC_Phy1.requestFocus();
              return;
           }
         else if(txtDaysOfSymp.getText().toString().length()==0 & !chkDaysOfSympDK.isChecked() & secDaysOfSymp.isShown())
           {
                     Connection.MessageBox(TyphoidCase.this, "Required field: শিশুটি কত দিন জ্বরে ভুগেছিল? (How many days did the person have symptoms of fever?).");
                     txtDaysOfSymp.requestFocus();
                     return;

           }
         else if(secDaysOfSymp.isShown()&Integer.valueOf(txtDaysOfSymp.getText().toString().length()==0 ? "1" : txtDaysOfSymp.getText().toString()) < 1 || Integer.valueOf(txtDaysOfSymp.getText().toString().length()==0 ? "99" : txtDaysOfSymp.getText().toString()) > 99)
           {
             Connection.MessageBox(TyphoidCase.this, "Value should be between 1 and 99(শিশুটি কত দিন জ্বরে ভুগেছিল? (How many days did the person have symptoms of fever?)).");
             txtDaysOfSymp.requestFocus(); 
             return;	
           }
         else if(txtWorstHour.getText().toString().length()==0  & !chkWorstHourDK.isChecked() & secWorstHour.isShown())
           {
             Connection.MessageBox(TyphoidCase.this, "Required field: যেদিন সবচেয়ে বেশি জর ছিল সেদিন কত ঘণ্টা শিশুটি বিছানা থেকে উঠতে পারেনি? (During the worst day of fever, how many hours did the person with fever spend in bed?).");
             txtWorstHour.requestFocus(); 
             return;	
           }
         else if(secWorstHour.isShown()&Integer.valueOf(txtWorstHour.getText().toString().length()==0 ? "1" : txtWorstHour.getText().toString()) < 0 || Integer.valueOf(txtWorstHour.getText().toString().length()==0 ? "99" : txtWorstHour.getText().toString()) > 99)
           {
             Connection.MessageBox(TyphoidCase.this, "Value should be between 1 and 99(যেদিন সবচেয়ে বেশি জর ছিল সেদিন কত ঘণ্টা শিশুটি বিছানা থেকে উঠতে পারেনি? (During the worst day of fever, how many hours did the person with fever spend in bed?)).");
             txtWorstHour.requestFocus(); 
             return;	
           }
         else if(txtDaysOfUnable.getText().toString().length()==0 & !chkDaysOfUnableDK.isChecked() & secDaysOfUnable.isShown())
           {
             Connection.MessageBox(TyphoidCase.this, "Required field: এই অসুস্থতার সময় শিশুটি কত দিন স্বাভাবিক কাজকর্ম করতে পারেনি? (During this febrile illness, for how many days was the person unable to conduct their usual activities?).");
             txtDaysOfUnable.requestFocus(); 
             return;	
           }
         else if(secDaysOfUnable.isShown()&Integer.valueOf(txtDaysOfUnable.getText().toString().length()==0 ? "1" : txtDaysOfUnable.getText().toString()) < 0 || Integer.valueOf(txtDaysOfUnable.getText().toString().length()==0 ? "99" : txtDaysOfUnable.getText().toString()) > 99)
           {
             Connection.MessageBox(TyphoidCase.this, "Value should be between 1 and 99(এই অসুস্থতার সময় শিশুটি কত দিন স্বাভাবিক কাজকর্ম করতে পারেনি? (During this febrile illness, for how many days was the person unable to conduct their usual activities?)).");
             txtDaysOfUnable.requestFocus(); 
             return;	
           }
         
         else if(!rdoTAdmHos1.isChecked() & !rdoTAdmHos2.isChecked() & !rdoTAdmHos3.isChecked() & secTAdmHos.isShown())
           {
              Connection.MessageBox(TyphoidCase.this, "Select anyone options from (এই অসুস্থতার জন্য শিশুটিকে কি হাসপাতালে ভর্তি করা হয়েছিল? (During this episode of illness, was your child hospitalized?)).");
              rdoTAdmHos1.requestFocus();
              return;
           }
         else if(spnTHosNam.getSelectedItemPosition()==0  & !chkTHosNamDK.isChecked() & secTHosNam.isShown() )
           {
             Connection.MessageBox(TyphoidCase.this, "Required field: 1..");
             spnTHosNam.requestFocus(); 
             return;	
           }
         else if(txtTHosNam_Oth.getText().toString().length()==0 & secTHosNam_Oth.isShown())
           {
             Connection.MessageBox(TyphoidCase.this, "Required field: Name of the other hospital-1.");
             txtTHosNam_Oth.requestFocus(); 
             return;	
           }
         
//         else if(!rdoTHosNam21.isChecked() & !rdoTHosNam22.isChecked() & !rdoTHosNam23.isChecked() & secTHosNam2.isShown())
//           {
//              Connection.MessageBox(TyphoidCase.this, "Select anyone options from (2.).");
//              rdoTHosNam21.requestFocus();
//              return;
//           }
         else if(txtTHosNam2_Oth.getText().toString().length()==0 & secTHosNam2_Oth.isShown())
           {
             Connection.MessageBox(TyphoidCase.this, "Required field: Name of the other hospital-2.");
             txtTHosNam2_Oth.requestFocus();
             return;
           }
//         else if(spnTHosNam3.getSelectedItemPosition()==0  & secTHosNam3.isShown())
//           {
//             Connection.MessageBox(TyphoidCase.this, "Required field: 3..");
//             spnTHosNam3.requestFocus();
//             return;
//           }
         else if(txtTHosNam3_Oth.getText().toString().length()==0 & secTHosNam3_Oth.isShown())
           {
             Connection.MessageBox(TyphoidCase.this, "Required field: Name of the other hospital-3.");
             txtTHosNam3_Oth.requestFocus();
             return;
           }
//         DV = Global.DateValidate(dtpTDtAdmHos.getText().toString());
//         if(DV.length()!=0 & secTDtAdmHos.isShown())
//           {
//                if(txtTAdmHosD.getText().toString().length()==0){
//                     Connection.MessageBox(TyphoidCase.this, DV);
//                     dtpTDtAdmHos.requestFocus();
//                     return;
//                }
//
//           }
         else if(txtTAdmHosD.getText().toString().length()==0 & dtpTDtAdmHos.getText().toString().length() == 0 & secTAdmHosD.isShown())
           {
                     Connection.MessageBox(TyphoidCase.this, "Required field: যদি ভর্তির তারিখ জানা না থাকে,  কত দিন আগে (How day ago).");
                     txtTAdmHosD.requestFocus();
                     return;

           }
         else if( secTAdmHosD.isShown()& Integer.valueOf(txtTAdmHosD.getText().toString().length()==0 ? "1" : txtTAdmHosD.getText().toString()) < 1 || Integer.valueOf(txtTAdmHosD.getText().toString().length()==0 ? "99" : txtTAdmHosD.getText().toString()) > 99)
           {
             Connection.MessageBox(TyphoidCase.this, "Value should be between 1 and 99(যদি ভর্তির তারিখ জানা না থাকে,  কত দিন আগে (How day ago)).");
             txtTAdmHosD.requestFocus(); 
             return;	
           }
         else if(txtTDurIlBeHos.getText().toString().length()==0 & !chkTDurIlBeHosDK.isChecked() & secTDurIlBeHos.isShown())
           {
                     Connection.MessageBox(TyphoidCase.this, "Required field:  হাসপাতালে ভর্তির আগে শিশুটি কতদিন অসুস্থ ছিল? (যদি জানা না থাকে 98 বসান) (For how many days did the child appear ill before he/she was hospitalized?).");
                     txtTDurIlBeHos.requestFocus();
                     return;

           }
         else if(secTDurIlBeHos.isShown()& Integer.valueOf(txtTDurIlBeHos.getText().toString().length()==0 ? "1" : txtTDurIlBeHos.getText().toString()) < 0 || Integer.valueOf(txtTDurIlBeHos.getText().toString().length()==0 ? "98" : txtTDurIlBeHos.getText().toString()) > 98)
           {
             Connection.MessageBox(TyphoidCase.this, "Value should be between 1 and 98( হাসপাতালে ভর্তির আগে শিশুটি কতদিন অসুস্থ ছিল? (যদি জানা না থাকে 98 বসান) (For how many days did the child appear ill before he/she was hospitalized?)).");
             txtTDurIlBeHos.requestFocus(); 
             return;	
           }
         else if(spnTDisDr.getSelectedItemPosition()==0  & secTDisDr.isShown())
           {
             Connection.MessageBox(TyphoidCase.this, "Required field: চিকিৎসকরা শিশুটির কি রোগ ছিল বলে আপনাদের বলেছিলেন?  What illness did the doctors tell you that your child had?.");
             spnTDisDr.requestFocus(); 
             return;	
           }
         else if(txtTDisDrOth.getText().toString().length()==0 & secTDisDrOth.isShown())
           {
             Connection.MessageBox(TyphoidCase.this, "Required field: অন্যান্য উল্লেখ করুন (Others Specify).");
             txtTDisDrOth.requestFocus(); 
             return;	
           }
         
         else if(!rdoTReco1.isChecked() & !rdoTReco2.isChecked() & !rdoTReco3.isChecked() & secTReco.isShown())
           {
              Connection.MessageBox(TyphoidCase.this, "Select anyone options from (শিশুটি কি সম্পূর্ণ সুস্থ হয়ে গিয়েছিল? (Did the child recover completely?)).");
              rdoTReco1.requestFocus();
              return;
           }
         else if(txtTDurReco.getText().toString().length()==0 & secTDurReco.isShown())
           {
             Connection.MessageBox(TyphoidCase.this, "Required field: শিশুটি সুস্থ হতে কতদিন লেগেছিল? (যদি জানা না থাকে 98 বসান) (How many days were required before the child recovered?).");
             txtTDurReco.requestFocus(); 
             return;	
           }
         else if(secTDurReco.isShown() & Integer.valueOf(txtTDurReco.getText().toString().length()==0 ? "1" : txtTDurReco.getText().toString()) < 1 || Integer.valueOf(txtTDurReco.getText().toString().length()==0 ? "98" : txtTDurReco.getText().toString()) > 98)
           {
             Connection.MessageBox(TyphoidCase.this, "Value should be between 1 and 98(শিশুটি সুস্থ হতে কতদিন লেগেছিল? (যদি জানা না থাকে 98 বসান) (How many days were required before the child recovered?)).");
             txtTDurReco.requestFocus(); 
             return;	
           }
         else if(spnTInReco.getSelectedItemPosition()==0  & secTInReco.isShown())
           {
             Connection.MessageBox(TyphoidCase.this, "Required field: 1..");
             spnTInReco.requestFocus(); 
             return;	
           }
         else if(txtTInRecoOth.getText().toString().length()==0 & secTInRecoOth.isShown())
           {
             Connection.MessageBox(TyphoidCase.this, "Required field: অন্যান্য উল্লেখ করুন (Others Specify).");
             txtTInRecoOth.requestFocus(); 
             return;	
           }
//         else if(spnTInReco2.getSelectedItemPosition()==0  & secTInReco2.isShown())
//           {
//             Connection.MessageBox(TyphoidCase.this, "Required field: 2..");
//             spnTInReco2.requestFocus();
//             return;
//           }
//         else if(txtTInRecoOth2.getText().toString().length()==0 & secTInRecoOth2.isShown())
//           {
//             Connection.MessageBox(TyphoidCase.this, "Required field: অন্যান্য উল্লেখ করুন (Others Specify).");
//             txtTInRecoOth2.requestFocus();
//             return;
//           }
         
         else if(!rdoHaveHosp1.isChecked() & !rdoHaveHosp2.isChecked() & !rdoHaveHosp3.isChecked() & secHaveHosp.isShown())
           {
              Connection.MessageBox(TyphoidCase.this, "Select anyone options from (গত এক বছরে জ্বর জনিত কোন অসুস্থতার কারনে শিশুটি হাসপাতালে ভর্তি হয়েছিল? (Did he/she have any cases of febrile illness that led to hospitalization in the past year?) ).");
              rdoHaveHosp1.requestFocus();
              return;
           }
         else if(spnHospName.getSelectedItemPosition()==0  & secHospName.isShown())
           {
             Connection.MessageBox(TyphoidCase.this, "Required field: শিশুকে কোন হাসপাতালে ভর্তি করেছিলেন? (What hospital was he/she taken to?).");
             spnHospName.requestFocus(); 
             return;	
           }
         else if(txtHospName_Oth.getText().toString().length()==0 & secHospName_Oth.isShown())
           {
             Connection.MessageBox(TyphoidCase.this, "Required field: Name of the other hospital.");
             txtHospName_Oth.requestFocus(); 
             return;	
           }
         
         else if(!rdoHaveRecords1.isChecked() & !rdoHaveRecords2.isChecked() & secHaveRecords.isShown())
           {
              Connection.MessageBox(TyphoidCase.this, "Select anyone options from (উত্তরদাতা কি হাসপাতালের প্রেসক্রিপশন অথবা অন্য কোন প্রমানাদি/কাগজপত্র দেখাতে পেরেছেন? (Was the respondent able to produce records of this visit?) ).");
              rdoHaveRecords1.requestFocus();
              return;
           }
         
         else if(!rdoDidRecordMatch21.isChecked() & !rdoDidRecordMatch22.isChecked() & secDidRecordMatch2.isShown())
           {
              Connection.MessageBox(TyphoidCase.this, "Select anyone options from (হাসপাতালের প্রেসক্রিপশন অথবা প্রমানাদি/কাগজপত্র কি শিশু যে হাসপাতাল ভর্তি ছিল সেই হাসপাতালের?  (Did the records match the healthcare facility they stated the person was taken to?)).");
              rdoDidRecordMatch21.requestFocus();
              return;
           }
         else if(txtDaysOfHosp.getText().toString().length()==0 & secDaysOfHosp.isShown())
           {
                if(!chkDaysOfHospDK.isChecked()){
                     Connection.MessageBox(TyphoidCase.this, "Required field: শিশুটি কত দিন হাসপাতালে ভর্তি ছিল? (How many days was he/she hospitalized?).");
                     txtDaysOfHosp.requestFocus();
                     return;
                }

           }
         else if(secDaysOfHosp.isShown() & Integer.valueOf(txtDaysOfHosp.getText().toString().length()==0 ? "1" : txtDaysOfHosp.getText().toString()) < 1 || Integer.valueOf(txtDaysOfHosp.getText().toString().length()==0 ? "99" : txtDaysOfHosp.getText().toString()) > 99)
           {
             Connection.MessageBox(TyphoidCase.this, "Value should be between 1 and 99(শিশুটি কত দিন হাসপাতালে ভর্তি ছিল? (How many days was he/she hospitalized?)).");
             txtDaysOfHosp.requestFocus(); 
             return;	
           }
//         else if(txtTAboIll.getText().toString().length()==0 & secTAboIll.isShown())
//           {
//             Connection.MessageBox(TyphoidCase.this, "Required field: মন্তব্যঃ টাইফয়েড (Remarks:Typhoid).");
//             txtTAboIll.requestFocus();
//             return;
//           }
 
         String SQL = "";
         RadioButton rb;

         TyphoidCase_DataModel objSave = new TyphoidCase_DataModel();
         objSave.setUNCode(txtUNCode.getText().toString());
         objSave.setStructureNo(txtStructureNo.getText().toString());
         objSave.setHouseholdSl(txtHouseholdSl.getText().toString());
         objSave.setVisitNo(txtVisitNo.getText().toString());
         objSave.setMemSl(txtMemSl.getText().toString());
         String[] d_rdogrpHaveFever = new String[] {"1","2","8"};
         objSave.setHaveFever(0);
         for (int i = 0; i < rdogrpHaveFever.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpHaveFever.getChildAt(i);
             if (rb.isChecked()) objSave.setHaveFever(Integer.valueOf(d_rdogrpHaveFever[i]));
         }

         String[] d_rdogrpAbdomPain = new String[] {"1","2"};
         objSave.setAbdomPain(0);
         for (int i = 0; i < rdogrpAbdomPain.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpAbdomPain.getChildAt(i);
             if (rb.isChecked()) objSave.setAbdomPain(Integer.valueOf(d_rdogrpAbdomPain[i]));
         }

         String[] d_rdogrpConstipation = new String[] {"1","2"};
         objSave.setConstipation(0);
         for (int i = 0; i < rdogrpConstipation.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpConstipation.getChildAt(i);
             if (rb.isChecked()) objSave.setConstipation(Integer.valueOf(d_rdogrpConstipation[i]));
         }

         String[] d_rdogrpHeadache = new String[] {"1","2"};
         objSave.setHeadache(0);
         for (int i = 0; i < rdogrpHeadache.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpHeadache.getChildAt(i);
             if (rb.isChecked()) objSave.setHeadache(Integer.valueOf(d_rdogrpHeadache[i]));
         }

         String[] d_rdogrpRash = new String[] {"1","2"};
         objSave.setRash(0);
         for (int i = 0; i < rdogrpRash.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpRash.getChildAt(i);
             if (rb.isChecked()) objSave.setRash(Integer.valueOf(d_rdogrpRash[i]));
         }

         String[] d_rdogrpDiarrhoea = new String[] {"1","2"};
         objSave.setDiarrhoea(0);
         for (int i = 0; i < rdogrpDiarrhoea.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpDiarrhoea.getChildAt(i);
             if (rb.isChecked()) objSave.setDiarrhoea(Integer.valueOf(d_rdogrpDiarrhoea[i]));
         }

         String[] d_rdogrpAbdomDist = new String[] {"1","2"};
         objSave.setAbdomDist(0);
         for (int i = 0; i < rdogrpAbdomDist.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpAbdomDist.getChildAt(i);
             if (rb.isChecked()) objSave.setAbdomDist(Integer.valueOf(d_rdogrpAbdomDist[i]));
         }

         String[] d_rdogrpCoaTon = new String[] {"1","2"};
         objSave.setCoaTon(0);
         for (int i = 0; i < rdogrpCoaTon.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpCoaTon.getChildAt(i);
             if (rb.isChecked()) objSave.setCoaTon(Integer.valueOf(d_rdogrpCoaTon[i]));
         }

         String[] d_rdogrpCough = new String[] {"1","2"};
         objSave.setCough(0);
         for (int i = 0; i < rdogrpCough.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpCough.getChildAt(i);
             if (rb.isChecked()) objSave.setCough(Integer.valueOf(d_rdogrpCough[i]));
         }

         String[] d_rdogrpTnone = new String[] {"1","2"};
         objSave.setTnone(0);
         for (int i = 0; i < rdogrpTnone.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpTnone.getChildAt(i);
             if (rb.isChecked()) objSave.setTnone(Integer.valueOf(d_rdogrpTnone[i]));
         }

         String[] d_rdogrpOther = new String[] {"1","2"};
         objSave.setOther(0);
         for (int i = 0; i < rdogrpOther.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpOther.getChildAt(i);
             if (rb.isChecked()) objSave.setOther(Integer.valueOf(d_rdogrpOther[i]));
         }

         objSave.setTsymptOthName(txtTsymptOthName.getText().toString());
         String[] d_rdogrpTakenHCFacility = new String[] {"1","2","8"};
         objSave.setTakenHCFacility(0);
         for (int i = 0; i < rdogrpTakenHCFacility.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpTakenHCFacility.getChildAt(i);
             if (rb.isChecked()) objSave.setTakenHCFacility(Integer.valueOf(d_rdogrpTakenHCFacility[i]));
         }

         String[] d_rdogrpHC_PhyMBBS = new String[] {"1","2","8"};
         objSave.setHC_PhyMBBS(0);
         for (int i = 0; i < rdogrpHC_PhyMBBS.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpHC_PhyMBBS.getChildAt(i);
             if (rb.isChecked()) objSave.setHC_PhyMBBS(Integer.valueOf(d_rdogrpHC_PhyMBBS[i]));
         }

         String[] d_rdogrpHC_UnquaDoctor = new String[] {"1","2","8"};
         objSave.setHC_UnquaDoctor(0);
         for (int i = 0; i < rdogrpHC_UnquaDoctor.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpHC_UnquaDoctor.getChildAt(i);
             if (rb.isChecked()) objSave.setHC_UnquaDoctor(Integer.valueOf(d_rdogrpHC_UnquaDoctor[i]));
         }

         String[] d_rdogrpHC_Para = new String[] {"1","2","8"};
         objSave.setHC_Para(0);
         for (int i = 0; i < rdogrpHC_Para.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpHC_Para.getChildAt(i);
             if (rb.isChecked()) objSave.setHC_Para(Integer.valueOf(d_rdogrpHC_Para[i]));
         }

         String[] d_rdogrpHC_Com = new String[] {"1","2","8"};
         objSave.setHC_Com(0);
         for (int i = 0; i < rdogrpHC_Com.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpHC_Com.getChildAt(i);
             if (rb.isChecked()) objSave.setHC_Com(Integer.valueOf(d_rdogrpHC_Com[i]));
         }

         String[] d_rdogrpHC_Pha = new String[] {"1","2","8"};
         objSave.setHC_Pha(0);
         for (int i = 0; i < rdogrpHC_Pha.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpHC_Pha.getChildAt(i);
             if (rb.isChecked()) objSave.setHC_Pha(Integer.valueOf(d_rdogrpHC_Pha[i]));
         }

         String[] d_rdogrpHC_Hompath = new String[] {"1","2","8"};
         objSave.setHC_Hompath(0);
         for (int i = 0; i < rdogrpHC_Hompath.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpHC_Hompath.getChildAt(i);
             if (rb.isChecked()) objSave.setHC_Hompath(Integer.valueOf(d_rdogrpHC_Hompath[i]));
         }

         String[] d_rdogrpHC_TrHeal = new String[] {"1","2","8"};
         objSave.setHC_TrHeal(0);
         for (int i = 0; i < rdogrpHC_TrHeal.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpHC_TrHeal.getChildAt(i);
             if (rb.isChecked()) objSave.setHC_TrHeal(Integer.valueOf(d_rdogrpHC_TrHeal[i]));
         }

         String[] d_rdogrpHC_SpiHeal = new String[] {"1","2","8"};
         objSave.setHC_SpiHeal(0);
         for (int i = 0; i < rdogrpHC_SpiHeal.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpHC_SpiHeal.getChildAt(i);
             if (rb.isChecked()) objSave.setHC_SpiHeal(Integer.valueOf(d_rdogrpHC_SpiHeal[i]));
         }

         String[] d_rdogrpTHC_Oth = new String[] {"1","2","8"};
         objSave.setTHC_Oth(0);
         for (int i = 0; i < rdogrpTHC_Oth.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpTHC_Oth.getChildAt(i);
             if (rb.isChecked()) objSave.setTHC_Oth(Integer.valueOf(d_rdogrpTHC_Oth[i]));
         }

         objSave.setTHC_OthName(txtTHC_OthName.getText().toString());
         String[] d_rdogrpHC_Hosp = new String[] {"1","2","8"};
         objSave.setHC_Hosp(0);
         for (int i = 0; i < rdogrpHC_Hosp.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpHC_Hosp.getChildAt(i);
             if (rb.isChecked()) objSave.setHC_Hosp(Integer.valueOf(d_rdogrpHC_Hosp[i]));
         }

         objSave.setHC_Hosp_a1(Integer.valueOf(spnHC_Hosp_a1.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnHC_Hosp_a1.getSelectedItem().toString(), "-")));
         objSave.setHC_Hosp_a1_Oth(txtHC_Hosp_a1_Oth.getText().toString());
         objSave.setHC_Hosp_a2(Integer.valueOf(spnHC_Hosp_a2.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnHC_Hosp_a2.getSelectedItem().toString(), "-")));
         objSave.setHC_Hosp_a2_Oth(txtHC_Hosp_a2_Oth.getText().toString());
         objSave.setHC_Hosp_a3(Integer.valueOf(spnHC_Hosp_a3.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnHC_Hosp_a3.getSelectedItem().toString(), "-")));
         objSave.setHC_Hosp_a3_Oth(txtHC_Hosp_a3_Oth.getText().toString());
         objSave.setHC_Hosp_a4(Integer.valueOf(spnHC_Hosp_a4.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnHC_Hosp_a4.getSelectedItem().toString(), "-")));
         objSave.setHC_Hosp_a4_Oth(txtHC_Hosp_a4_Oth.getText().toString());
         objSave.setHC_Hosp_a5(Integer.valueOf(spnHC_Hosp_a5.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnHC_Hosp_a5.getSelectedItem().toString(), "-")));
         objSave.setHC_Hosp_a5_Oth(txtHC_Hosp_a5_Oth.getText().toString());
         String[] d_rdogrpHC_Hosp_b = new String[] {"1","2"};
         objSave.setHC_Hosp_b(0);
         for (int i = 0; i < rdogrpHC_Hosp_b.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpHC_Hosp_b.getChildAt(i);
             if (rb.isChecked()) objSave.setHC_Hosp_b(Integer.valueOf(d_rdogrpHC_Hosp_b[i]));
         }

         String[] d_rdogrpHC_Hosp_b_i = new String[] {"1","2"};
         objSave.setHC_Hosp_b_i(0);
         for (int i = 0; i < rdogrpHC_Hosp_b_i.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpHC_Hosp_b_i.getChildAt(i);
             if (rb.isChecked()) objSave.setHC_Hosp_b_i(Integer.valueOf(d_rdogrpHC_Hosp_b_i[i]));
         }

         String[] d_rdogrpHC_Clin = new String[] {"1","2","8"};
         objSave.setHC_Clin(0);
         for (int i = 0; i < rdogrpHC_Clin.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpHC_Clin.getChildAt(i);
             if (rb.isChecked()) objSave.setHC_Clin(Integer.valueOf(d_rdogrpHC_Clin[i]));
         }

         String[] d_rdogrpHC_Phy = new String[] {"1","2","8"};
         objSave.setHC_Phy(0);
         for (int i = 0; i < rdogrpHC_Phy.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpHC_Phy.getChildAt(i);
             if (rb.isChecked()) objSave.setHC_Phy(Integer.valueOf(d_rdogrpHC_Phy[i]));
         }

         objSave.setDaysOfSymp(Integer.valueOf(txtDaysOfSymp.getText().toString().length()==0?"0":txtDaysOfSymp.getText().toString()));
         objSave.setDaysOfSympDK(Integer.valueOf(chkDaysOfSympDK.isChecked()?"1":secDaysOfSympDK.isShown()?"2":"0"));
         objSave.setWorstHour(Integer.valueOf(txtWorstHour.getText().toString().length()==0?"0":txtWorstHour.getText().toString()));
         objSave.setWorstHourDK(Integer.valueOf(chkWorstHourDK.isChecked()?"1":(secWorstHourDK.isShown()?"2":"0")));
         objSave.setDaysOfUnable(Integer.valueOf(txtDaysOfUnable.getText().toString().length()==0?"0":txtDaysOfUnable.getText().toString()));
         objSave.setDaysOfUnableDK(Integer.valueOf(chkDaysOfUnableDK.isChecked()?"1":(secDaysOfUnableDK.isShown()?"2":"0")));
         String[] d_rdogrpTAdmHos = new String[] {"1","2","8"};
         objSave.setTAdmHos(0);
         for (int i = 0; i < rdogrpTAdmHos.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpTAdmHos.getChildAt(i);
             if (rb.isChecked()) objSave.setTAdmHos(Integer.valueOf(d_rdogrpTAdmHos[i]));
         }

         objSave.setTHosNam(Integer.valueOf(spnTHosNam.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnTHosNam.getSelectedItem().toString(), "-")));
         objSave.setTHosNam_Oth(txtTHosNam_Oth.getText().toString());
//         String[] d_rdogrpTHosNam2 = new String[] {"1","2","7"};
//         objSave.setTHosNam2(0);
//         for (int i = 0; i < rdogrpTHosNam2.getChildCount(); i++)
//         {
//             rb = (RadioButton)rdogrpTHosNam2.getChildAt(i);
//             if (rb.isChecked()) objSave.setTHosNam2(Integer.valueOf(d_rdogrpTHosNam2[i]));
//         }

          objSave.setTHosNam2(Integer.valueOf(spnTHosNam2.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnTHosNam2.getSelectedItem().toString(), "-")));
          objSave.setTHosNam2_Oth(txtTHosNam2_Oth.getText().toString());

         objSave.setTHosNam2_Oth(txtTHosNam2_Oth.getText().toString());
         objSave.setTHosNam3(Integer.valueOf(spnTHosNam3.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnTHosNam3.getSelectedItem().toString(), "-")));
         objSave.setTHosNam3_Oth(txtTHosNam3_Oth.getText().toString());
         objSave.setTHosNamDK(Integer.valueOf(chkTHosNamDK.isChecked()?"1":(secTHosNamDK.isShown()?"2":"0")));
         objSave.setTDtAdmHos(dtpTDtAdmHos.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpTDtAdmHos.getText().toString()) : dtpTDtAdmHos.getText().toString());
         objSave.setTAdmHosD(Integer.valueOf(txtTAdmHosD.getText().toString().length()==0?"0":txtTAdmHosD.getText().toString())  );
         objSave.setTDurIlBeHos(Integer.valueOf(txtTDurIlBeHos.getText().toString().length()==0?"0":txtTDurIlBeHos.getText().toString()));
         objSave.setTDurIlBeHosDK(Integer.valueOf(chkTDurIlBeHosDK.isChecked()?"1":(secTDurIlBeHosDK.isShown()?"2":"0")));
         objSave.setTDisDr(Integer.valueOf(spnTDisDr.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnTDisDr.getSelectedItem().toString(), "-")));
         objSave.setTDisDrOth(txtTDisDrOth.getText().toString());
         String[] d_rdogrpTReco = new String[] {"1","2","8"};
         objSave.setTReco(0);
         for (int i = 0; i < rdogrpTReco.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpTReco.getChildAt(i);
             if (rb.isChecked()) objSave.setTReco(Integer.valueOf(d_rdogrpTReco[i]));
         }

         objSave.setTDurReco(Integer.valueOf(txtTDurReco.getText().toString().length()==0?"0":txtTDurReco.getText().toString()));
         objSave.setTInReco(Integer.valueOf(spnTInReco.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnTInReco.getSelectedItem().toString(), "-")));
         objSave.setTInRecoOth(txtTInRecoOth.getText().toString());
         objSave.setTInReco2(Integer.valueOf(spnTInReco2.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnTInReco2.getSelectedItem().toString(), "-")));
         objSave.setTInRecoOth2(txtTInRecoOth2.getText().toString());
         String[] d_rdogrpHaveHosp = new String[] {"1","2","8"};
         objSave.setHaveHosp(0);
         for (int i = 0; i < rdogrpHaveHosp.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpHaveHosp.getChildAt(i);
             if (rb.isChecked()) objSave.setHaveHosp(Integer.valueOf(d_rdogrpHaveHosp[i]));
         }

         objSave.setHospName(Integer.valueOf(spnHospName.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnHospName.getSelectedItem().toString(), "-")));
         objSave.setHospName_Oth(txtHospName_Oth.getText().toString());
         String[] d_rdogrpHaveRecords = new String[] {"1","2"};
         objSave.setHaveRecords(0);
         for (int i = 0; i < rdogrpHaveRecords.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpHaveRecords.getChildAt(i);
             if (rb.isChecked()) objSave.setHaveRecords(Integer.valueOf(d_rdogrpHaveRecords[i]));
         }

         String[] d_rdogrpDidRecordMatch2 = new String[] {"1","2"};
         objSave.setDidRecordMatch2(0);
         for (int i = 0; i < rdogrpDidRecordMatch2.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpDidRecordMatch2.getChildAt(i);
             if (rb.isChecked()) objSave.setDidRecordMatch2(Integer.valueOf(d_rdogrpDidRecordMatch2[i]));
         }

         objSave.setDaysOfHosp(Integer.valueOf(txtDaysOfHosp.getText().toString().length()==0?"0":txtDaysOfHosp.getText().toString()));
         objSave.setDaysOfHospDK(Integer.valueOf(chkDaysOfHospDK.isChecked()?"1":(secDaysOfHospDK.isShown()?"2":"0")));
         objSave.setTAboIll(txtTAboIll.getText().toString());
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

              Connection.MessageBox(TyphoidCase.this, "Saved Successfully");

         }
         else{
             Connection.MessageBox(TyphoidCase.this, status);
             return;
         }
     }
     catch(Exception  e)
     {
         Connection.MessageBox(TyphoidCase.this, e.getMessage());
         return;
     }
 }

 private void DataSearch(String UNCode, String StructureNo, String HouseholdSl, String VisitNo, String MemSl)
     {
       try
        {
     
           RadioButton rb;
           TyphoidCase_DataModel d = new TyphoidCase_DataModel();
           String SQL = "Select * from "+ TableName +"  Where UNCode='"+ UNCode +"' and StructureNo='"+ StructureNo +"' and HouseholdSl='"+ HouseholdSl +"' and VisitNo='"+ VisitNo +"' and MemSl='"+ MemSl +"'";
           List<TyphoidCase_DataModel> data = d.SelectAll(this, SQL);
           for(TyphoidCase_DataModel item : data){
             txtUNCode.setText(item.getUNCode());
             txtStructureNo.setText(item.getStructureNo());
             txtHouseholdSl.setText(item.getHouseholdSl());
             txtVisitNo.setText(item.getVisitNo());
             txtMemSl.setText(item.getMemSl());
             String[] d_rdogrpHaveFever = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpHaveFever.length; i++)
             {
                 if (String.valueOf(item.getHaveFever()).equals(String.valueOf(d_rdogrpHaveFever[i])))
                 {
                     rb = (RadioButton)rdogrpHaveFever.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpAbdomPain = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpAbdomPain.length; i++)
             {
                 if (String.valueOf(item.getAbdomPain()).equals(String.valueOf(d_rdogrpAbdomPain[i])))
                 {
                     rb = (RadioButton)rdogrpAbdomPain.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpConstipation = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpConstipation.length; i++)
             {
                 if (String.valueOf(item.getConstipation()).equals(String.valueOf(d_rdogrpConstipation[i])))
                 {
                     rb = (RadioButton)rdogrpConstipation.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpHeadache = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpHeadache.length; i++)
             {
                 if (String.valueOf(item.getHeadache()).equals(String.valueOf(d_rdogrpHeadache[i])))
                 {
                     rb = (RadioButton)rdogrpHeadache.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpRash = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpRash.length; i++)
             {
                 if (String.valueOf(item.getRash()).equals(String.valueOf(d_rdogrpRash[i])))
                 {
                     rb = (RadioButton)rdogrpRash.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpDiarrhoea = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpDiarrhoea.length; i++)
             {
                 if (String.valueOf(item.getDiarrhoea()).equals(String.valueOf(d_rdogrpDiarrhoea[i])))
                 {
                     rb = (RadioButton)rdogrpDiarrhoea.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpAbdomDist = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpAbdomDist.length; i++)
             {
                 if (String.valueOf(item.getAbdomDist()).equals(String.valueOf(d_rdogrpAbdomDist[i])))
                 {
                     rb = (RadioButton)rdogrpAbdomDist.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpCoaTon = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpCoaTon.length; i++)
             {
                 if (String.valueOf(item.getCoaTon()).equals(String.valueOf(d_rdogrpCoaTon[i])))
                 {
                     rb = (RadioButton)rdogrpCoaTon.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpCough = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpCough.length; i++)
             {
                 if (String.valueOf(item.getCough()).equals(String.valueOf(d_rdogrpCough[i])))
                 {
                     rb = (RadioButton)rdogrpCough.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpTnone = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpTnone.length; i++)
             {
                 if (String.valueOf(item.getTnone()).equals(String.valueOf(d_rdogrpTnone[i])))
                 {
                     rb = (RadioButton)rdogrpTnone.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpOther = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpOther.length; i++)
             {
                 if (String.valueOf(item.getOther()).equals(String.valueOf(d_rdogrpOther[i])))
                 {
                     rb = (RadioButton)rdogrpOther.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtTsymptOthName.setText(item.getTsymptOthName());
             String[] d_rdogrpTakenHCFacility = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpTakenHCFacility.length; i++)
             {
                 if (String.valueOf(item.getTakenHCFacility()).equals(String.valueOf(d_rdogrpTakenHCFacility[i])))
                 {
                     rb = (RadioButton)rdogrpTakenHCFacility.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpHC_PhyMBBS = new String[] {"1","2","8",""};
             for (int i = 0; i < d_rdogrpHC_PhyMBBS.length; i++)
             {
                 if (String.valueOf(item.getHC_PhyMBBS()).equals(String.valueOf(d_rdogrpHC_PhyMBBS[i])))
                 {
                     rb = (RadioButton)rdogrpHC_PhyMBBS.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpHC_UnquaDoctor = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpHC_UnquaDoctor.length; i++)
             {
                 if (String.valueOf(item.getHC_UnquaDoctor()).equals(String.valueOf(d_rdogrpHC_UnquaDoctor[i])))
                 {
                     rb = (RadioButton)rdogrpHC_UnquaDoctor.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpHC_Para = new String[] {"1","2","8",""};
             for (int i = 0; i < d_rdogrpHC_Para.length; i++)
             {
                 if (String.valueOf(item.getHC_Para()).equals(String.valueOf(d_rdogrpHC_Para[i])))
                 {
                     rb = (RadioButton)rdogrpHC_Para.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpHC_Com = new String[] {"1","2","8",""};
             for (int i = 0; i < d_rdogrpHC_Com.length; i++)
             {
                 if (String.valueOf(item.getHC_Com()).equals(String.valueOf(d_rdogrpHC_Com[i])))
                 {
                     rb = (RadioButton)rdogrpHC_Com.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpHC_Pha = new String[] {"1","2","8",""};
             for (int i = 0; i < d_rdogrpHC_Pha.length; i++)
             {
                 if (String.valueOf(item.getHC_Pha()).equals(String.valueOf(d_rdogrpHC_Pha[i])))
                 {
                     rb = (RadioButton)rdogrpHC_Pha.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpHC_Hompath = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpHC_Hompath.length; i++)
             {
                 if (String.valueOf(item.getHC_Hompath()).equals(String.valueOf(d_rdogrpHC_Hompath[i])))
                 {
                     rb = (RadioButton)rdogrpHC_Hompath.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpHC_TrHeal = new String[] {"1","2","8",""};
             for (int i = 0; i < d_rdogrpHC_TrHeal.length; i++)
             {
                 if (String.valueOf(item.getHC_TrHeal()).equals(String.valueOf(d_rdogrpHC_TrHeal[i])))
                 {
                     rb = (RadioButton)rdogrpHC_TrHeal.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpHC_SpiHeal = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpHC_SpiHeal.length; i++)
             {
                 if (String.valueOf(item.getHC_SpiHeal()).equals(String.valueOf(d_rdogrpHC_SpiHeal[i])))
                 {
                     rb = (RadioButton)rdogrpHC_SpiHeal.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpTHC_Oth = new String[] {"1","2","8",""};
             for (int i = 0; i < d_rdogrpTHC_Oth.length; i++)
             {
                 if (String.valueOf(item.getTHC_Oth()).equals(String.valueOf(d_rdogrpTHC_Oth[i])))
                 {
                     rb = (RadioButton)rdogrpTHC_Oth.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtTHC_OthName.setText(item.getTHC_OthName());
             String[] d_rdogrpHC_Hosp = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpHC_Hosp.length; i++)
             {
                 if (String.valueOf(item.getHC_Hosp()).equals(String.valueOf(d_rdogrpHC_Hosp[i])))
                 {
                     rb = (RadioButton)rdogrpHC_Hosp.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             spnHC_Hosp_a1.setSelection(Global.SpinnerItemPositionAnyLength(spnHC_Hosp_a1, String.valueOf(item.getHC_Hosp_a1())));
             txtHC_Hosp_a1_Oth.setText(item.getHC_Hosp_a1_Oth());
             spnHC_Hosp_a2.setSelection(Global.SpinnerItemPositionAnyLength(spnHC_Hosp_a2, String.valueOf(item.getHC_Hosp_a2())));
             txtHC_Hosp_a2_Oth.setText(item.getHC_Hosp_a2_Oth());
             spnHC_Hosp_a3.setSelection(Global.SpinnerItemPositionAnyLength(spnHC_Hosp_a3, String.valueOf(item.getHC_Hosp_a3())));
             txtHC_Hosp_a3_Oth.setText(item.getHC_Hosp_a3_Oth());
             spnHC_Hosp_a4.setSelection(Global.SpinnerItemPositionAnyLength(spnHC_Hosp_a4, String.valueOf(item.getHC_Hosp_a4())));
             txtHC_Hosp_a4_Oth.setText(item.getHC_Hosp_a4_Oth());
             spnHC_Hosp_a5.setSelection(Global.SpinnerItemPositionAnyLength(spnHC_Hosp_a5, String.valueOf(item.getHC_Hosp_a5())));
             txtHC_Hosp_a5_Oth.setText(item.getHC_Hosp_a5_Oth());
             String[] d_rdogrpHC_Hosp_b = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpHC_Hosp_b.length; i++)
             {
                 if (String.valueOf(item.getHC_Hosp_b()).equals(String.valueOf(d_rdogrpHC_Hosp_b[i])))
                 {
                     rb = (RadioButton)rdogrpHC_Hosp_b.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpHC_Hosp_b_i = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpHC_Hosp_b_i.length; i++)
             {
                 if (String.valueOf(item.getHC_Hosp_b_i()).equals(String.valueOf(d_rdogrpHC_Hosp_b_i[i])))
                 {
                     rb = (RadioButton)rdogrpHC_Hosp_b_i.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpHC_Clin = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpHC_Clin.length; i++)
             {
                 if (String.valueOf(item.getHC_Clin()).equals(String.valueOf(d_rdogrpHC_Clin[i])))
                 {
                     rb = (RadioButton)rdogrpHC_Clin.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpHC_Phy = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpHC_Phy.length; i++)
             {
                 if (String.valueOf(item.getHC_Phy()).equals(String.valueOf(d_rdogrpHC_Phy[i])))
                 {
                     rb = (RadioButton)rdogrpHC_Phy.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtDaysOfSymp.setText(String.valueOf(item.getDaysOfSymp()));
             if(String.valueOf(item.getDaysOfSympDK()).equals("1"))
             {
                chkDaysOfSympDK.setChecked(true);
             }
             else if(String.valueOf(item.getDaysOfSympDK()).equals("2"))
             {
                chkDaysOfSympDK.setChecked(false);
             }
             txtWorstHour.setText(String.valueOf(item.getWorstHour()));
             if(String.valueOf(item.getWorstHourDK()).equals("1"))
             {
                chkWorstHourDK.setChecked(true);
             }
             else if(String.valueOf(item.getWorstHourDK()).equals("2"))
             {
                chkWorstHourDK.setChecked(false);
             }
             txtDaysOfUnable.setText(String.valueOf(item.getDaysOfUnable()));
             if(String.valueOf(item.getDaysOfUnableDK()).equals("1"))
             {
                chkDaysOfUnableDK.setChecked(true);
             }
             else if(String.valueOf(item.getDaysOfUnableDK()).equals("2"))
             {
                chkDaysOfUnableDK.setChecked(false);
             }
             String[] d_rdogrpTAdmHos = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpTAdmHos.length; i++)
             {
                 if (String.valueOf(item.getTAdmHos()).equals(String.valueOf(d_rdogrpTAdmHos[i])))
                 {
                     rb = (RadioButton)rdogrpTAdmHos.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             spnTHosNam.setSelection(Global.SpinnerItemPositionAnyLength(spnTHosNam, String.valueOf(item.getTHosNam())));
             txtTHosNam_Oth.setText(item.getTHosNam_Oth());
//             String[] d_rdogrpTHosNam2 = new String[] {"1","2","7"};
//             for (int i = 0; i < d_rdogrpTHosNam2.length; i++)
//             {
//                 if (String.valueOf(item.getTHosNam2()).equals(String.valueOf(d_rdogrpTHosNam2[i])))
//                 {
//                     rb = (RadioButton)rdogrpTHosNam2.getChildAt(i);
//                     rb.setChecked(true);
//                 }
//             }
                spnTHosNam2.setSelection(Global.SpinnerItemPositionAnyLength(spnTHosNam2, String.valueOf(item.getTHosNam2())));
                txtTHosNam2_Oth.setText(item.getTHosNam2_Oth());
             spnTHosNam3.setSelection(Global.SpinnerItemPositionAnyLength(spnTHosNam3, String.valueOf(item.getTHosNam3())));
             txtTHosNam3_Oth.setText(item.getTHosNam3_Oth());
             if(String.valueOf(item.getTHosNamDK()).equals("1"))
             {
                chkTHosNamDK.setChecked(true);
             }
             else if(String.valueOf(item.getTHosNamDK()).equals("2"))
             {
                chkTHosNamDK.setChecked(false);
             }
             dtpTDtAdmHos.setText(item.getTDtAdmHos().toString().length()==0 ? "" : Global.DateConvertDMY(item.getTDtAdmHos()));
             txtTAdmHosD.setText(item.getTAdmHosD()==0 ? "":String.valueOf(item.getTAdmHosD()));
             txtTDurIlBeHos.setText(String.valueOf(item.getTDurIlBeHos()));
             if(String.valueOf(item.getTDurIlBeHosDK()).equals("1"))
             {
                chkTDurIlBeHosDK.setChecked(true);
             }
             else if(String.valueOf(item.getTDurIlBeHosDK()).equals("2"))
             {
                chkTDurIlBeHosDK.setChecked(false);
             }
             spnTDisDr.setSelection(Global.SpinnerItemPositionAnyLength(spnTDisDr, String.valueOf(item.getTDisDr())));
             txtTDisDrOth.setText(item.getTDisDrOth());
             String[] d_rdogrpTReco = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpTReco.length; i++)
             {
                 if (String.valueOf(item.getTReco()).equals(String.valueOf(d_rdogrpTReco[i])))
                 {
                     rb = (RadioButton)rdogrpTReco.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtTDurReco.setText(String.valueOf(item.getTDurReco()));
             spnTInReco.setSelection(Global.SpinnerItemPositionAnyLength(spnTInReco, String.valueOf(item.getTInReco())));
             txtTInRecoOth.setText(item.getTInRecoOth());
             spnTInReco2.setSelection(Global.SpinnerItemPositionAnyLength(spnTInReco2, String.valueOf(item.getTInReco2())));
             txtTInRecoOth2.setText(item.getTInRecoOth2());
             String[] d_rdogrpHaveHosp = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpHaveHosp.length; i++)
             {
                 if (String.valueOf(item.getHaveHosp()).equals(String.valueOf(d_rdogrpHaveHosp[i])))
                 {
                     rb = (RadioButton)rdogrpHaveHosp.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             spnHospName.setSelection(Global.SpinnerItemPositionAnyLength(spnHospName, String.valueOf(item.getHospName())));
             txtHospName_Oth.setText(item.getHospName_Oth());
             String[] d_rdogrpHaveRecords = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpHaveRecords.length; i++)
             {
                 if (String.valueOf(item.getHaveRecords()).equals(String.valueOf(d_rdogrpHaveRecords[i])))
                 {
                     rb = (RadioButton)rdogrpHaveRecords.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpDidRecordMatch2 = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpDidRecordMatch2.length; i++)
             {
                 if (String.valueOf(item.getDidRecordMatch2()).equals(String.valueOf(d_rdogrpDidRecordMatch2[i])))
                 {
                     rb = (RadioButton)rdogrpDidRecordMatch2.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtDaysOfHosp.setText(String.valueOf(item.getDaysOfHosp()));
             if(String.valueOf(item.getDaysOfHospDK()).equals("1"))
             {
                chkDaysOfHospDK.setChecked(true);
             }
             else if(String.valueOf(item.getDaysOfHospDK()).equals("2"))
             {
                chkDaysOfHospDK.setChecked(false);
             }
             txtTAboIll.setText(item.getTAboIll());
           }
        }
        catch(Exception  e)
        {
            Connection.MessageBox(TyphoidCase.this, e.getMessage());
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


              dtpDate = (EditText)findViewById(R.id.dtpTDtAdmHos);
             if (VariableID.equals("btnTDtAdmHos"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpTDtAdmHos);
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