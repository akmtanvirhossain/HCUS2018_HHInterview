
 package org.hcus_hhinterview;


 //Android Manifest Code
 //<activity android:name=".DiarrhoeaCase " android:label="DiarrhoeaCase " />
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
 import data_model.DiarrhoeaCase_DataModel;

 public class DiarrhoeaCase  extends Activity {
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
         LinearLayout secDWatStool;
         View lineDWatStool;
         TextView VlblDWatStool;
         RadioGroup rdogrpDWatStool;
         
         RadioButton rdoDWatStool1;
         RadioButton rdoDWatStool2;
         RadioButton rdoDWatStool3;
         LinearLayout secDDisEpi;
         View lineDDisEpi;
         TextView VlblDDisEpi;
         EditText txtDDisEpi;
         LinearLayout secStoolBlood;
         View lineStoolBlood;
         TextView VlblStoolBlood;
         RadioGroup rdogrpStoolBlood;
         
         RadioButton rdoStoolBlood1;
         RadioButton rdoStoolBlood2;
         RadioButton rdoStoolBlood3;
         LinearLayout secFeedORS;
         View lineFeedORS;
         TextView VlblFeedORS;
         RadioGroup rdogrpFeedORS;
         
         RadioButton rdoFeedORS1;
         RadioButton rdoFeedORS2;
         RadioButton rdoFeedORS3;
         LinearLayout secDHCar;
         View lineDHCar;
         TextView VlblDHCar;
         RadioGroup rdogrpDHCar;
         
         RadioButton rdoDHCar1;
         RadioButton rdoDHCar2;
         RadioButton rdoDHCar3;
         LinearLayout secORSBefHCar;
         View lineORSBefHCar;
         TextView VlblORSBefHCar;
         RadioGroup rdogrpORSBefHCar;
         
         RadioButton rdoORSBefHCar1;
         RadioButton rdoORSBefHCar2;
         RadioButton rdoORSBefHCar3;
         LinearLayout secDHCarTypLabel;
         View lineDHCarTypLabel;
         LinearLayout secDHC_PhyMBBS;
         View lineDHC_PhyMBBS;
         TextView VlblDHC_PhyMBBS;
         RadioGroup rdogrpDHC_PhyMBBS;
         
         RadioButton rdoDHC_PhyMBBS1;
         RadioButton rdoDHC_PhyMBBS2;
         RadioButton rdoDHC_PhyMBBS3;
         LinearLayout secDHC_UnquaDoctor;
         View lineDHC_UnquaDoctor;
         TextView VlblDHC_UnquaDoctor;
         RadioGroup rdogrpDHC_UnquaDoctor;
         
         RadioButton rdoDHC_UnquaDoctor1;
         RadioButton rdoDHC_UnquaDoctor2;
         RadioButton rdoDHC_UnquaDoctor3;
         LinearLayout secDHC_Para;
         View lineDHC_Para;
         TextView VlblDHC_Para;
         RadioGroup rdogrpDHC_Para;
         
         RadioButton rdoDHC_Para1;
         RadioButton rdoDHC_Para2;
         RadioButton rdoDHC_Para3;
         LinearLayout secDHC_Com;
         View lineDHC_Com;
         TextView VlblDHC_Com;
         RadioGroup rdogrpDHC_Com;
         
         RadioButton rdoDHC_Com1;
         RadioButton rdoDHC_Com2;
         RadioButton rdoDHC_Com3;
         LinearLayout secDHC_Pha;
         View lineDHC_Pha;
         TextView VlblDHC_Pha;
         RadioGroup rdogrpDHC_Pha;
         
         RadioButton rdoDHC_Pha1;
         RadioButton rdoDHC_Pha2;
         RadioButton rdoDHC_Pha3;
         LinearLayout secDHC_Hompath;
         View lineDHC_Hompath;
         TextView VlblDHC_Hompath;
         RadioGroup rdogrpDHC_Hompath;
         
         RadioButton rdoDHC_Hompath1;
         RadioButton rdoDHC_Hompath2;
         RadioButton rdoDHC_Hompath3;
         LinearLayout secDHC_TrHeal;
         View lineDHC_TrHeal;
         TextView VlblDHC_TrHeal;
         RadioGroup rdogrpDHC_TrHeal;
         
         RadioButton rdoDHC_TrHeal1;
         RadioButton rdoDHC_TrHeal2;
         RadioButton rdoDHC_TrHeal3;
         LinearLayout secDHC_SpiHeal;
         View lineDHC_SpiHeal;
         TextView VlblDHC_SpiHeal;
         RadioGroup rdogrpDHC_SpiHeal;
         
         RadioButton rdoDHC_SpiHeal1;
         RadioButton rdoDHC_SpiHeal2;
         RadioButton rdoDHC_SpiHeal3;
         LinearLayout secDHC_Oth;
         View lineDHC_Oth;
         TextView VlblDHC_Oth;
         RadioGroup rdogrpDHC_Oth;
         
         RadioButton rdoDHC_Oth1;
         RadioButton rdoDHC_Oth2;
         RadioButton rdoDHC_Oth3;
         LinearLayout secDHC_OthName;
         View lineDHC_OthName;
         TextView VlblDHC_OthName;
         EditText txtDHC_OthName;
         LinearLayout secDDSHOPD;
         View lineDDSHOPD;
         TextView VlblDDSHOPD;
         RadioGroup rdogrpDDSHOPD;
         
         RadioButton rdoDDSHOPD1;
         RadioButton rdoDDSHOPD2;
         RadioButton rdoDDSHOPD3;
         LinearLayout secDSSFOPD;
         View lineDSSFOPD;
         TextView VlblDSSFOPD;
         RadioGroup rdogrpDSSFOPD;
         
         RadioButton rdoDSSFOPD1;
         RadioButton rdoDSSFOPD2;
         RadioButton rdoDSSFOPD3;
         LinearLayout secDAdmHos;
         View lineDAdmHos;
         TextView VlblDAdmHos;
         RadioGroup rdogrpDAdmHos;
         
         RadioButton rdoDAdmHos1;
         RadioButton rdoDAdmHos2;
         RadioButton rdoDAdmHos3;
         LinearLayout secDIlBeHosAdm;
         View lineDIlBeHosAdm;
         TextView VlblDIlBeHosAdm;
         EditText txtDIlBeHosAdm;
         LinearLayout secDHosNamLabel;
         View lineDHosNamLabel;
         LinearLayout secDHosNam;
         View lineDHosNam;
         TextView VlblDHosNam;
         Spinner spnDHosNam;
         LinearLayout secDHosNamOth;
         View lineDHosNamOth;
         TextView VlblDHosNamOth;
         EditText txtDHosNamOth;
         LinearLayout secDHosNam2;
         View lineDHosNam2;
         TextView VlblDHosNam2;
         Spinner spnDHosNam2;
         LinearLayout secDHosNamOth2;
         View lineDHosNamOth2;
         TextView VlblDHosNamOth2;
         EditText txtDHosNamOth2;
         LinearLayout secDHosNam3;
         View lineDHosNam3;
         TextView VlblDHosNam3;
         Spinner spnDHosNam3;
         LinearLayout secDHosNamOth3;
         View lineDHosNamOth3;
         TextView VlblDHosNamOth3;
         EditText txtDHosNamOth3;
         LinearLayout secDReco;
         View lineDReco;
         TextView VlblDReco;
         RadioGroup rdogrpDReco;
         
         RadioButton rdoDReco1;
         RadioButton rdoDReco2;
         RadioButton rdoDReco3;
         LinearLayout secDDurReco;
         View lineDDurReco;
         TextView VlblDDurReco;
         EditText txtDDurReco;
         LinearLayout secDInReco;
         View lineDInReco;
         TextView VlblDInReco;
         RadioGroup rdogrpDInReco;
         
         RadioButton rdoDInReco1;
         RadioButton rdoDInReco2;
         LinearLayout secDInRecoOth;
         View lineDInRecoOth;
         TextView VlblDInRecoOth;
         EditText txtDInRecoOth;
         LinearLayout secDAboIll;
         View lineDAboIll;
         TextView VlblDAboIll;
         EditText txtDAboIll;

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
         setContentView(R.layout.diarrhoeacase );
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

         TableName = "DiarrhoeaCase ";

         //turnGPSOn();

         //GPS Location
         //FindLocation();
         // Double.toString(currentLatitude);
         // Double.toString(currentLongitude);
         lblHeading = (TextView)findViewById(R.id.lblHeading);

         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(DiarrhoeaCase .this);
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
         secDWatStool=(LinearLayout)findViewById(R.id.secDWatStool);
         lineDWatStool=(View)findViewById(R.id.lineDWatStool);
         VlblDWatStool = (TextView) findViewById(R.id.VlblDWatStool);
         rdogrpDWatStool = (RadioGroup) findViewById(R.id.rdogrpDWatStool);

         txtUNCode.setText(UNCODE);
         txtStructureNo.setText(""+STRUCTURENO);
         txtHouseholdSl.setText(HOUSEHOLDSL);
         txtVisitNo.setText(VISITNO);
         txtMemSl.setText(MEMSL);


         rdoDWatStool1 = (RadioButton) findViewById(R.id.rdoDWatStool1);
         rdoDWatStool2 = (RadioButton) findViewById(R.id.rdoDWatStool2);
         rdoDWatStool3 = (RadioButton) findViewById(R.id.rdoDWatStool3);
         rdogrpDWatStool.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpDWatStool = new String[] {"1","2","8"};
             for (int i = 0; i < rdogrpDWatStool.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpDWatStool.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpDWatStool[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secDDisEpi.setVisibility(View.GONE);
                    lineDDisEpi.setVisibility(View.GONE);
                    txtDDisEpi.setText("");
                    secStoolBlood.setVisibility(View.GONE);
                    lineStoolBlood.setVisibility(View.GONE);
                    rdogrpStoolBlood.clearCheck();
                    secFeedORS.setVisibility(View.GONE);
                    lineFeedORS.setVisibility(View.GONE);
                    rdogrpFeedORS.clearCheck();
                    secDHCar.setVisibility(View.GONE);
                    lineDHCar.setVisibility(View.GONE);
                    rdogrpDHCar.clearCheck();
                    secORSBefHCar.setVisibility(View.GONE);
                    lineORSBefHCar.setVisibility(View.GONE);
                    rdogrpORSBefHCar.clearCheck();
                    secDHCarTypLabel.setVisibility(View.GONE);
                    lineDHCarTypLabel.setVisibility(View.GONE);
                    secDHC_PhyMBBS.setVisibility(View.GONE);
                    lineDHC_PhyMBBS.setVisibility(View.GONE);
                    rdogrpDHC_PhyMBBS.clearCheck();
                    secDHC_UnquaDoctor.setVisibility(View.GONE);
                    lineDHC_UnquaDoctor.setVisibility(View.GONE);
                    rdogrpDHC_UnquaDoctor.clearCheck();
                    secDHC_Para.setVisibility(View.GONE);
                    lineDHC_Para.setVisibility(View.GONE);
                    rdogrpDHC_Para.clearCheck();
                    secDHC_Com.setVisibility(View.GONE);
                    lineDHC_Com.setVisibility(View.GONE);
                    rdogrpDHC_Com.clearCheck();
                    secDHC_Pha.setVisibility(View.GONE);
                    lineDHC_Pha.setVisibility(View.GONE);
                    rdogrpDHC_Pha.clearCheck();
                    secDHC_Hompath.setVisibility(View.GONE);
                    lineDHC_Hompath.setVisibility(View.GONE);
                    rdogrpDHC_Hompath.clearCheck();
                    secDHC_TrHeal.setVisibility(View.GONE);
                    lineDHC_TrHeal.setVisibility(View.GONE);
                    rdogrpDHC_TrHeal.clearCheck();
                    secDHC_SpiHeal.setVisibility(View.GONE);
                    lineDHC_SpiHeal.setVisibility(View.GONE);
                    rdogrpDHC_SpiHeal.clearCheck();
                    secDHC_Oth.setVisibility(View.GONE);
                    lineDHC_Oth.setVisibility(View.GONE);
                    rdogrpDHC_Oth.clearCheck();
                    secDHC_OthName.setVisibility(View.GONE);
                    lineDHC_OthName.setVisibility(View.GONE);
                    txtDHC_OthName.setText("");
                    secDDSHOPD.setVisibility(View.GONE);
                    lineDDSHOPD.setVisibility(View.GONE);
                    rdogrpDDSHOPD.clearCheck();
                    secDSSFOPD.setVisibility(View.GONE);
                    lineDSSFOPD.setVisibility(View.GONE);
                    rdogrpDSSFOPD.clearCheck();
                    secDAdmHos.setVisibility(View.GONE);
                    lineDAdmHos.setVisibility(View.GONE);
                    rdogrpDAdmHos.clearCheck();
                    secDIlBeHosAdm.setVisibility(View.GONE);
                    lineDIlBeHosAdm.setVisibility(View.GONE);
                    txtDIlBeHosAdm.setText("");
                    secDHosNamLabel.setVisibility(View.GONE);
                    lineDHosNamLabel.setVisibility(View.GONE);
                    secDHosNam.setVisibility(View.GONE);
                    lineDHosNam.setVisibility(View.GONE);
                    spnDHosNam.setSelection(0);
                    secDHosNamOth.setVisibility(View.GONE);
                    lineDHosNamOth.setVisibility(View.GONE);
                    txtDHosNamOth.setText("");
                    secDHosNam2.setVisibility(View.GONE);
                    lineDHosNam2.setVisibility(View.GONE);
                    spnDHosNam2.setSelection(0);
                    secDHosNamOth2.setVisibility(View.GONE);
                    lineDHosNamOth2.setVisibility(View.GONE);
                    txtDHosNamOth2.setText("");
                    secDHosNam3.setVisibility(View.GONE);
                    lineDHosNam3.setVisibility(View.GONE);
                    spnDHosNam3.setSelection(0);
                    secDHosNamOth3.setVisibility(View.GONE);
                    lineDHosNamOth3.setVisibility(View.GONE);
                    txtDHosNamOth3.setText("");
                    secDReco.setVisibility(View.GONE);
                    lineDReco.setVisibility(View.GONE);
                    rdogrpDReco.clearCheck();
                    secDDurReco.setVisibility(View.GONE);
                    lineDDurReco.setVisibility(View.GONE);
                    txtDDurReco.setText("");
                    secDInReco.setVisibility(View.GONE);
                    lineDInReco.setVisibility(View.GONE);
                    rdogrpDInReco.clearCheck();
                    secDInRecoOth.setVisibility(View.GONE);
                    lineDInRecoOth.setVisibility(View.GONE);
                    txtDInRecoOth.setText("");
                    secDAboIll.setVisibility(View.GONE);
                    lineDAboIll.setVisibility(View.GONE);
                    txtDAboIll.setText("");
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secDDisEpi.setVisibility(View.GONE);
                    lineDDisEpi.setVisibility(View.GONE);
                    txtDDisEpi.setText("");
                    secStoolBlood.setVisibility(View.GONE);
                    lineStoolBlood.setVisibility(View.GONE);
                    rdogrpStoolBlood.clearCheck();
                    secFeedORS.setVisibility(View.GONE);
                    lineFeedORS.setVisibility(View.GONE);
                    rdogrpFeedORS.clearCheck();
                    secDHCar.setVisibility(View.GONE);
                    lineDHCar.setVisibility(View.GONE);
                    rdogrpDHCar.clearCheck();
                    secORSBefHCar.setVisibility(View.GONE);
                    lineORSBefHCar.setVisibility(View.GONE);
                    rdogrpORSBefHCar.clearCheck();
                    secDHCarTypLabel.setVisibility(View.GONE);
                    lineDHCarTypLabel.setVisibility(View.GONE);
                    secDHC_PhyMBBS.setVisibility(View.GONE);
                    lineDHC_PhyMBBS.setVisibility(View.GONE);
                    rdogrpDHC_PhyMBBS.clearCheck();
                    secDHC_UnquaDoctor.setVisibility(View.GONE);
                    lineDHC_UnquaDoctor.setVisibility(View.GONE);
                    rdogrpDHC_UnquaDoctor.clearCheck();
                    secDHC_Para.setVisibility(View.GONE);
                    lineDHC_Para.setVisibility(View.GONE);
                    rdogrpDHC_Para.clearCheck();
                    secDHC_Com.setVisibility(View.GONE);
                    lineDHC_Com.setVisibility(View.GONE);
                    rdogrpDHC_Com.clearCheck();
                    secDHC_Pha.setVisibility(View.GONE);
                    lineDHC_Pha.setVisibility(View.GONE);
                    rdogrpDHC_Pha.clearCheck();
                    secDHC_Hompath.setVisibility(View.GONE);
                    lineDHC_Hompath.setVisibility(View.GONE);
                    rdogrpDHC_Hompath.clearCheck();
                    secDHC_TrHeal.setVisibility(View.GONE);
                    lineDHC_TrHeal.setVisibility(View.GONE);
                    rdogrpDHC_TrHeal.clearCheck();
                    secDHC_SpiHeal.setVisibility(View.GONE);
                    lineDHC_SpiHeal.setVisibility(View.GONE);
                    rdogrpDHC_SpiHeal.clearCheck();
                    secDHC_Oth.setVisibility(View.GONE);
                    lineDHC_Oth.setVisibility(View.GONE);
                    rdogrpDHC_Oth.clearCheck();
                    secDHC_OthName.setVisibility(View.GONE);
                    lineDHC_OthName.setVisibility(View.GONE);
                    txtDHC_OthName.setText("");
                    secDDSHOPD.setVisibility(View.GONE);
                    lineDDSHOPD.setVisibility(View.GONE);
                    rdogrpDDSHOPD.clearCheck();
                    secDSSFOPD.setVisibility(View.GONE);
                    lineDSSFOPD.setVisibility(View.GONE);
                    rdogrpDSSFOPD.clearCheck();
                    secDAdmHos.setVisibility(View.GONE);
                    lineDAdmHos.setVisibility(View.GONE);
                    rdogrpDAdmHos.clearCheck();
                    secDIlBeHosAdm.setVisibility(View.GONE);
                    lineDIlBeHosAdm.setVisibility(View.GONE);
                    txtDIlBeHosAdm.setText("");
                    secDHosNamLabel.setVisibility(View.GONE);
                    lineDHosNamLabel.setVisibility(View.GONE);
                    secDHosNam.setVisibility(View.GONE);
                    lineDHosNam.setVisibility(View.GONE);
                    spnDHosNam.setSelection(0);
                    secDHosNamOth.setVisibility(View.GONE);
                    lineDHosNamOth.setVisibility(View.GONE);
                    txtDHosNamOth.setText("");
                    secDHosNam2.setVisibility(View.GONE);
                    lineDHosNam2.setVisibility(View.GONE);
                    spnDHosNam2.setSelection(0);
                    secDHosNamOth2.setVisibility(View.GONE);
                    lineDHosNamOth2.setVisibility(View.GONE);
                    txtDHosNamOth2.setText("");
                    secDHosNam3.setVisibility(View.GONE);
                    lineDHosNam3.setVisibility(View.GONE);
                    spnDHosNam3.setSelection(0);
                    secDHosNamOth3.setVisibility(View.GONE);
                    lineDHosNamOth3.setVisibility(View.GONE);
                    txtDHosNamOth3.setText("");
                    secDReco.setVisibility(View.GONE);
                    lineDReco.setVisibility(View.GONE);
                    rdogrpDReco.clearCheck();
                    secDDurReco.setVisibility(View.GONE);
                    lineDDurReco.setVisibility(View.GONE);
                    txtDDurReco.setText("");
                    secDInReco.setVisibility(View.GONE);
                    lineDInReco.setVisibility(View.GONE);
                    rdogrpDInReco.clearCheck();
                    secDInRecoOth.setVisibility(View.GONE);
                    lineDInRecoOth.setVisibility(View.GONE);
                    txtDInRecoOth.setText("");
                    secDAboIll.setVisibility(View.GONE);
                    lineDAboIll.setVisibility(View.GONE);
                    txtDAboIll.setText("");
             }
             else
             {
                    secDDisEpi.setVisibility(View.VISIBLE);
                    lineDDisEpi.setVisibility(View.VISIBLE);
                    secStoolBlood.setVisibility(View.VISIBLE);
                    lineStoolBlood.setVisibility(View.VISIBLE);
                    secFeedORS.setVisibility(View.VISIBLE);
                    lineFeedORS.setVisibility(View.VISIBLE);
                    secDHCar.setVisibility(View.VISIBLE);
                    lineDHCar.setVisibility(View.VISIBLE);

                 secDSSFOPD.setVisibility(View.VISIBLE);
                 lineDSSFOPD.setVisibility(View.VISIBLE);
                    secDDSHOPD.setVisibility(View.VISIBLE);
                    lineDDSHOPD.setVisibility(View.VISIBLE);

                    secDAdmHos.setVisibility(View.VISIBLE);
                    lineDAdmHos.setVisibility(View.VISIBLE);



                    secDReco.setVisibility(View.VISIBLE);
                    lineDReco.setVisibility(View.VISIBLE);

                    secDInReco.setVisibility(View.VISIBLE);
                    lineDInReco.setVisibility(View.VISIBLE);
                    secDAboIll.setVisibility(View.VISIBLE);
                    lineDAboIll.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secDDisEpi=(LinearLayout)findViewById(R.id.secDDisEpi);
         lineDDisEpi=(View)findViewById(R.id.lineDDisEpi);
         VlblDDisEpi=(TextView) findViewById(R.id.VlblDDisEpi);
         txtDDisEpi=(EditText) findViewById(R.id.txtDDisEpi);
         secStoolBlood=(LinearLayout)findViewById(R.id.secStoolBlood);
         lineStoolBlood=(View)findViewById(R.id.lineStoolBlood);
         VlblStoolBlood = (TextView) findViewById(R.id.VlblStoolBlood);
         rdogrpStoolBlood = (RadioGroup) findViewById(R.id.rdogrpStoolBlood);
         
         rdoStoolBlood1 = (RadioButton) findViewById(R.id.rdoStoolBlood1);
         rdoStoolBlood2 = (RadioButton) findViewById(R.id.rdoStoolBlood2);
         rdoStoolBlood3 = (RadioButton) findViewById(R.id.rdoStoolBlood3);
         secFeedORS=(LinearLayout)findViewById(R.id.secFeedORS);
         lineFeedORS=(View)findViewById(R.id.lineFeedORS);
         VlblFeedORS = (TextView) findViewById(R.id.VlblFeedORS);
         rdogrpFeedORS = (RadioGroup) findViewById(R.id.rdogrpFeedORS);
         
         rdoFeedORS1 = (RadioButton) findViewById(R.id.rdoFeedORS1);
         rdoFeedORS2 = (RadioButton) findViewById(R.id.rdoFeedORS2);
         rdoFeedORS3 = (RadioButton) findViewById(R.id.rdoFeedORS3);
         secDHCar=(LinearLayout)findViewById(R.id.secDHCar);
         lineDHCar=(View)findViewById(R.id.lineDHCar);
         VlblDHCar = (TextView) findViewById(R.id.VlblDHCar);
         rdogrpDHCar = (RadioGroup) findViewById(R.id.rdogrpDHCar);
         
         rdoDHCar1 = (RadioButton) findViewById(R.id.rdoDHCar1);
         rdoDHCar2 = (RadioButton) findViewById(R.id.rdoDHCar2);
         rdoDHCar3 = (RadioButton) findViewById(R.id.rdoDHCar3);
         rdogrpDHCar.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpDHCar = new String[] {"1","2","8"};
             for (int i = 0; i < rdogrpDHCar.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpDHCar.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpDHCar[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secORSBefHCar.setVisibility(View.GONE);
                    lineORSBefHCar.setVisibility(View.GONE);
                    rdogrpORSBefHCar.clearCheck();
                    secDHCarTypLabel.setVisibility(View.GONE);
                    lineDHCarTypLabel.setVisibility(View.GONE);
                    secDHC_PhyMBBS.setVisibility(View.GONE);
                    lineDHC_PhyMBBS.setVisibility(View.GONE);
                    rdogrpDHC_PhyMBBS.clearCheck();
                    secDHC_UnquaDoctor.setVisibility(View.GONE);
                    lineDHC_UnquaDoctor.setVisibility(View.GONE);
                    rdogrpDHC_UnquaDoctor.clearCheck();
                    secDHC_Para.setVisibility(View.GONE);
                    lineDHC_Para.setVisibility(View.GONE);
                    rdogrpDHC_Para.clearCheck();
                    secDHC_Com.setVisibility(View.GONE);
                    lineDHC_Com.setVisibility(View.GONE);
                    rdogrpDHC_Com.clearCheck();
                    secDHC_Pha.setVisibility(View.GONE);
                    lineDHC_Pha.setVisibility(View.GONE);
                    rdogrpDHC_Pha.clearCheck();
                    secDHC_Hompath.setVisibility(View.GONE);
                    lineDHC_Hompath.setVisibility(View.GONE);
                    rdogrpDHC_Hompath.clearCheck();
                    secDHC_TrHeal.setVisibility(View.GONE);
                    lineDHC_TrHeal.setVisibility(View.GONE);
                    rdogrpDHC_TrHeal.clearCheck();
                    secDHC_SpiHeal.setVisibility(View.GONE);
                    lineDHC_SpiHeal.setVisibility(View.GONE);
                    rdogrpDHC_SpiHeal.clearCheck();
                    secDHC_Oth.setVisibility(View.GONE);
                    lineDHC_Oth.setVisibility(View.GONE);
                    rdogrpDHC_Oth.clearCheck();
                    secDHC_OthName.setVisibility(View.GONE);
                    lineDHC_OthName.setVisibility(View.GONE);
                    txtDHC_OthName.setText("");
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secORSBefHCar.setVisibility(View.GONE);
                    lineORSBefHCar.setVisibility(View.GONE);
                    rdogrpORSBefHCar.clearCheck();
                    secDHCarTypLabel.setVisibility(View.GONE);
                    lineDHCarTypLabel.setVisibility(View.GONE);
                    secDHC_PhyMBBS.setVisibility(View.GONE);
                    lineDHC_PhyMBBS.setVisibility(View.GONE);
                    rdogrpDHC_PhyMBBS.clearCheck();
                    secDHC_UnquaDoctor.setVisibility(View.GONE);
                    lineDHC_UnquaDoctor.setVisibility(View.GONE);
                    rdogrpDHC_UnquaDoctor.clearCheck();
                    secDHC_Para.setVisibility(View.GONE);
                    lineDHC_Para.setVisibility(View.GONE);
                    rdogrpDHC_Para.clearCheck();
                    secDHC_Com.setVisibility(View.GONE);
                    lineDHC_Com.setVisibility(View.GONE);
                    rdogrpDHC_Com.clearCheck();
                    secDHC_Pha.setVisibility(View.GONE);
                    lineDHC_Pha.setVisibility(View.GONE);
                    rdogrpDHC_Pha.clearCheck();
                    secDHC_Hompath.setVisibility(View.GONE);
                    lineDHC_Hompath.setVisibility(View.GONE);
                    rdogrpDHC_Hompath.clearCheck();
                    secDHC_TrHeal.setVisibility(View.GONE);
                    lineDHC_TrHeal.setVisibility(View.GONE);
                    rdogrpDHC_TrHeal.clearCheck();
                    secDHC_SpiHeal.setVisibility(View.GONE);
                    lineDHC_SpiHeal.setVisibility(View.GONE);
                    rdogrpDHC_SpiHeal.clearCheck();
                    secDHC_Oth.setVisibility(View.GONE);
                    lineDHC_Oth.setVisibility(View.GONE);
                    rdogrpDHC_Oth.clearCheck();
                    secDHC_OthName.setVisibility(View.GONE);
                    lineDHC_OthName.setVisibility(View.GONE);
                    txtDHC_OthName.setText("");
             }
             else
             {
                    secORSBefHCar.setVisibility(View.VISIBLE);
                    lineORSBefHCar.setVisibility(View.VISIBLE);
                    secDHCarTypLabel.setVisibility(View.VISIBLE);
                    lineDHCarTypLabel.setVisibility(View.VISIBLE);
                    secDHC_PhyMBBS.setVisibility(View.VISIBLE);
                    lineDHC_PhyMBBS.setVisibility(View.VISIBLE);
                    secDHC_UnquaDoctor.setVisibility(View.VISIBLE);
                    lineDHC_UnquaDoctor.setVisibility(View.VISIBLE);
                    secDHC_Para.setVisibility(View.VISIBLE);
                    lineDHC_Para.setVisibility(View.VISIBLE);
                    secDHC_Com.setVisibility(View.VISIBLE);
                    lineDHC_Com.setVisibility(View.VISIBLE);
                    secDHC_Pha.setVisibility(View.VISIBLE);
                    lineDHC_Pha.setVisibility(View.VISIBLE);
                    secDHC_Hompath.setVisibility(View.VISIBLE);
                    lineDHC_Hompath.setVisibility(View.VISIBLE);
                    secDHC_TrHeal.setVisibility(View.VISIBLE);
                    lineDHC_TrHeal.setVisibility(View.VISIBLE);
                    secDHC_SpiHeal.setVisibility(View.VISIBLE);
                    lineDHC_SpiHeal.setVisibility(View.VISIBLE);
                    secDHC_Oth.setVisibility(View.VISIBLE);
                    lineDHC_Oth.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secORSBefHCar=(LinearLayout)findViewById(R.id.secORSBefHCar);
         lineORSBefHCar=(View)findViewById(R.id.lineORSBefHCar);
         VlblORSBefHCar = (TextView) findViewById(R.id.VlblORSBefHCar);
         rdogrpORSBefHCar = (RadioGroup) findViewById(R.id.rdogrpORSBefHCar);
         
         rdoORSBefHCar1 = (RadioButton) findViewById(R.id.rdoORSBefHCar1);
         rdoORSBefHCar2 = (RadioButton) findViewById(R.id.rdoORSBefHCar2);
         rdoORSBefHCar3 = (RadioButton) findViewById(R.id.rdoORSBefHCar3);
         secDHCarTypLabel=(LinearLayout)findViewById(R.id.secDHCarTypLabel);
         lineDHCarTypLabel=(View)findViewById(R.id.lineDHCarTypLabel);
         secDHC_PhyMBBS=(LinearLayout)findViewById(R.id.secDHC_PhyMBBS);
         lineDHC_PhyMBBS=(View)findViewById(R.id.lineDHC_PhyMBBS);
         VlblDHC_PhyMBBS = (TextView) findViewById(R.id.VlblDHC_PhyMBBS);
         rdogrpDHC_PhyMBBS = (RadioGroup) findViewById(R.id.rdogrpDHC_PhyMBBS);
         
         rdoDHC_PhyMBBS1 = (RadioButton) findViewById(R.id.rdoDHC_PhyMBBS1);
         rdoDHC_PhyMBBS2 = (RadioButton) findViewById(R.id.rdoDHC_PhyMBBS2);
         rdoDHC_PhyMBBS3 = (RadioButton) findViewById(R.id.rdoDHC_PhyMBBS3);
         secDHC_UnquaDoctor=(LinearLayout)findViewById(R.id.secDHC_UnquaDoctor);
         lineDHC_UnquaDoctor=(View)findViewById(R.id.lineDHC_UnquaDoctor);
         VlblDHC_UnquaDoctor = (TextView) findViewById(R.id.VlblDHC_UnquaDoctor);
         rdogrpDHC_UnquaDoctor = (RadioGroup) findViewById(R.id.rdogrpDHC_UnquaDoctor);
         
         rdoDHC_UnquaDoctor1 = (RadioButton) findViewById(R.id.rdoDHC_UnquaDoctor1);
         rdoDHC_UnquaDoctor2 = (RadioButton) findViewById(R.id.rdoDHC_UnquaDoctor2);
         rdoDHC_UnquaDoctor3 = (RadioButton) findViewById(R.id.rdoDHC_UnquaDoctor3);
         secDHC_Para=(LinearLayout)findViewById(R.id.secDHC_Para);
         lineDHC_Para=(View)findViewById(R.id.lineDHC_Para);
         VlblDHC_Para = (TextView) findViewById(R.id.VlblDHC_Para);
         rdogrpDHC_Para = (RadioGroup) findViewById(R.id.rdogrpDHC_Para);
         
         rdoDHC_Para1 = (RadioButton) findViewById(R.id.rdoDHC_Para1);
         rdoDHC_Para2 = (RadioButton) findViewById(R.id.rdoDHC_Para2);
         rdoDHC_Para3 = (RadioButton) findViewById(R.id.rdoDHC_Para3);
         secDHC_Com=(LinearLayout)findViewById(R.id.secDHC_Com);
         lineDHC_Com=(View)findViewById(R.id.lineDHC_Com);
         VlblDHC_Com = (TextView) findViewById(R.id.VlblDHC_Com);
         rdogrpDHC_Com = (RadioGroup) findViewById(R.id.rdogrpDHC_Com);
         
         rdoDHC_Com1 = (RadioButton) findViewById(R.id.rdoDHC_Com1);
         rdoDHC_Com2 = (RadioButton) findViewById(R.id.rdoDHC_Com2);
         rdoDHC_Com3 = (RadioButton) findViewById(R.id.rdoDHC_Com3);
         secDHC_Pha=(LinearLayout)findViewById(R.id.secDHC_Pha);
         lineDHC_Pha=(View)findViewById(R.id.lineDHC_Pha);
         VlblDHC_Pha = (TextView) findViewById(R.id.VlblDHC_Pha);
         rdogrpDHC_Pha = (RadioGroup) findViewById(R.id.rdogrpDHC_Pha);
         
         rdoDHC_Pha1 = (RadioButton) findViewById(R.id.rdoDHC_Pha1);
         rdoDHC_Pha2 = (RadioButton) findViewById(R.id.rdoDHC_Pha2);
         rdoDHC_Pha3 = (RadioButton) findViewById(R.id.rdoDHC_Pha3);
         secDHC_Hompath=(LinearLayout)findViewById(R.id.secDHC_Hompath);
         lineDHC_Hompath=(View)findViewById(R.id.lineDHC_Hompath);
         VlblDHC_Hompath = (TextView) findViewById(R.id.VlblDHC_Hompath);
         rdogrpDHC_Hompath = (RadioGroup) findViewById(R.id.rdogrpDHC_Hompath);
         
         rdoDHC_Hompath1 = (RadioButton) findViewById(R.id.rdoDHC_Hompath1);
         rdoDHC_Hompath2 = (RadioButton) findViewById(R.id.rdoDHC_Hompath2);
         rdoDHC_Hompath3 = (RadioButton) findViewById(R.id.rdoDHC_Hompath3);
         secDHC_TrHeal=(LinearLayout)findViewById(R.id.secDHC_TrHeal);
         lineDHC_TrHeal=(View)findViewById(R.id.lineDHC_TrHeal);
         VlblDHC_TrHeal = (TextView) findViewById(R.id.VlblDHC_TrHeal);
         rdogrpDHC_TrHeal = (RadioGroup) findViewById(R.id.rdogrpDHC_TrHeal);
         
         rdoDHC_TrHeal1 = (RadioButton) findViewById(R.id.rdoDHC_TrHeal1);
         rdoDHC_TrHeal2 = (RadioButton) findViewById(R.id.rdoDHC_TrHeal2);
         rdoDHC_TrHeal3 = (RadioButton) findViewById(R.id.rdoDHC_TrHeal3);
         secDHC_SpiHeal=(LinearLayout)findViewById(R.id.secDHC_SpiHeal);
         lineDHC_SpiHeal=(View)findViewById(R.id.lineDHC_SpiHeal);
         VlblDHC_SpiHeal = (TextView) findViewById(R.id.VlblDHC_SpiHeal);
         rdogrpDHC_SpiHeal = (RadioGroup) findViewById(R.id.rdogrpDHC_SpiHeal);
         
         rdoDHC_SpiHeal1 = (RadioButton) findViewById(R.id.rdoDHC_SpiHeal1);
         rdoDHC_SpiHeal2 = (RadioButton) findViewById(R.id.rdoDHC_SpiHeal2);
         rdoDHC_SpiHeal3 = (RadioButton) findViewById(R.id.rdoDHC_SpiHeal3);
         secDHC_Oth=(LinearLayout)findViewById(R.id.secDHC_Oth);
         lineDHC_Oth=(View)findViewById(R.id.lineDHC_Oth);
         VlblDHC_Oth = (TextView) findViewById(R.id.VlblDHC_Oth);
         rdogrpDHC_Oth = (RadioGroup) findViewById(R.id.rdogrpDHC_Oth);
         
         rdoDHC_Oth1 = (RadioButton) findViewById(R.id.rdoDHC_Oth1);
         rdoDHC_Oth2 = (RadioButton) findViewById(R.id.rdoDHC_Oth2);
         rdoDHC_Oth3 = (RadioButton) findViewById(R.id.rdoDHC_Oth3);
         rdogrpDHC_Oth.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpDHC_Oth = new String[] {"1","2","8"};
             for (int i = 0; i < rdogrpDHC_Oth.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpDHC_Oth.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpDHC_Oth[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secDHC_OthName.setVisibility(View.GONE);
                    lineDHC_OthName.setVisibility(View.GONE);
                    txtDHC_OthName.setText("");
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secDHC_OthName.setVisibility(View.GONE);
                    lineDHC_OthName.setVisibility(View.GONE);
                    txtDHC_OthName.setText("");
             }
             else if(rbData.equalsIgnoreCase("1"))
             {
                    secDHC_OthName.setVisibility(View.VISIBLE);
                    lineDHC_OthName.setVisibility(View.VISIBLE);
             }
             else{
                 secDHC_OthName.setVisibility(View.GONE);
                 lineDHC_OthName.setVisibility(View.GONE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secDHC_OthName=(LinearLayout)findViewById(R.id.secDHC_OthName);
         lineDHC_OthName=(View)findViewById(R.id.lineDHC_OthName);
         VlblDHC_OthName=(TextView) findViewById(R.id.VlblDHC_OthName);
         txtDHC_OthName=(EditText) findViewById(R.id.txtDHC_OthName);
         secDDSHOPD=(LinearLayout)findViewById(R.id.secDDSHOPD);
         lineDDSHOPD=(View)findViewById(R.id.lineDDSHOPD);
         VlblDDSHOPD = (TextView) findViewById(R.id.VlblDDSHOPD);
         rdogrpDDSHOPD = (RadioGroup) findViewById(R.id.rdogrpDDSHOPD);
         
         rdoDDSHOPD1 = (RadioButton) findViewById(R.id.rdoDDSHOPD1);
         rdoDDSHOPD2 = (RadioButton) findViewById(R.id.rdoDDSHOPD2);
         rdoDDSHOPD3 = (RadioButton) findViewById(R.id.rdoDDSHOPD3);
         secDSSFOPD=(LinearLayout)findViewById(R.id.secDSSFOPD);
         lineDSSFOPD=(View)findViewById(R.id.lineDSSFOPD);
         VlblDSSFOPD = (TextView) findViewById(R.id.VlblDSSFOPD);
         rdogrpDSSFOPD = (RadioGroup) findViewById(R.id.rdogrpDSSFOPD);
         
         rdoDSSFOPD1 = (RadioButton) findViewById(R.id.rdoDSSFOPD1);
         rdoDSSFOPD2 = (RadioButton) findViewById(R.id.rdoDSSFOPD2);
         rdoDSSFOPD3 = (RadioButton) findViewById(R.id.rdoDSSFOPD3);
         secDAdmHos=(LinearLayout)findViewById(R.id.secDAdmHos);
         lineDAdmHos=(View)findViewById(R.id.lineDAdmHos);
         VlblDAdmHos = (TextView) findViewById(R.id.VlblDAdmHos);
         rdogrpDAdmHos = (RadioGroup) findViewById(R.id.rdogrpDAdmHos);
         
         rdoDAdmHos1 = (RadioButton) findViewById(R.id.rdoDAdmHos1);
         rdoDAdmHos2 = (RadioButton) findViewById(R.id.rdoDAdmHos2);
         rdoDAdmHos3 = (RadioButton) findViewById(R.id.rdoDAdmHos3);
         rdogrpDAdmHos.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpDAdmHos = new String[] {"1","2","8"};
             for (int i = 0; i < rdogrpDAdmHos.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpDAdmHos.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpDAdmHos[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secDIlBeHosAdm.setVisibility(View.GONE);
                    lineDIlBeHosAdm.setVisibility(View.GONE);
                    txtDIlBeHosAdm.setText("");
                    secDHosNamLabel.setVisibility(View.GONE);
                    lineDHosNamLabel.setVisibility(View.GONE);
                    secDHosNam.setVisibility(View.GONE);
                    lineDHosNam.setVisibility(View.GONE);
                    spnDHosNam.setSelection(0);
                    secDHosNamOth.setVisibility(View.GONE);
                    lineDHosNamOth.setVisibility(View.GONE);
                    txtDHosNamOth.setText("");
                    secDHosNam2.setVisibility(View.GONE);
                    lineDHosNam2.setVisibility(View.GONE);
                    spnDHosNam2.setSelection(0);
                    secDHosNamOth2.setVisibility(View.GONE);
                    lineDHosNamOth2.setVisibility(View.GONE);
                    txtDHosNamOth2.setText("");
                    secDHosNam3.setVisibility(View.GONE);
                    lineDHosNam3.setVisibility(View.GONE);
                    spnDHosNam3.setSelection(0);
                    secDHosNamOth3.setVisibility(View.GONE);
                    lineDHosNamOth3.setVisibility(View.GONE);
                    txtDHosNamOth3.setText("");
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secDIlBeHosAdm.setVisibility(View.GONE);
                    lineDIlBeHosAdm.setVisibility(View.GONE);
                    txtDIlBeHosAdm.setText("");
                    secDHosNamLabel.setVisibility(View.GONE);
                    lineDHosNamLabel.setVisibility(View.GONE);
                    secDHosNam.setVisibility(View.GONE);
                    lineDHosNam.setVisibility(View.GONE);
                    spnDHosNam.setSelection(0);
                    secDHosNamOth.setVisibility(View.GONE);
                    lineDHosNamOth.setVisibility(View.GONE);
                    txtDHosNamOth.setText("");
                    secDHosNam2.setVisibility(View.GONE);
                    lineDHosNam2.setVisibility(View.GONE);
                    spnDHosNam2.setSelection(0);
                    secDHosNamOth2.setVisibility(View.GONE);
                    lineDHosNamOth2.setVisibility(View.GONE);
                    txtDHosNamOth2.setText("");
                    secDHosNam3.setVisibility(View.GONE);
                    lineDHosNam3.setVisibility(View.GONE);
                    spnDHosNam3.setSelection(0);
                    secDHosNamOth3.setVisibility(View.GONE);
                    lineDHosNamOth3.setVisibility(View.GONE);
                    txtDHosNamOth3.setText("");
             }
             else if(rbData.equalsIgnoreCase("1"))
             {
                    secDIlBeHosAdm.setVisibility(View.VISIBLE);
                    lineDIlBeHosAdm.setVisibility(View.VISIBLE);
                    secDHosNamLabel.setVisibility(View.VISIBLE);
                    lineDHosNamLabel.setVisibility(View.VISIBLE);
                    secDHosNam.setVisibility(View.VISIBLE);
                    lineDHosNam.setVisibility(View.VISIBLE);

                    secDHosNam2.setVisibility(View.VISIBLE);
                    lineDHosNam2.setVisibility(View.VISIBLE);

                    secDHosNam3.setVisibility(View.VISIBLE);
                    lineDHosNam3.setVisibility(View.VISIBLE);
             }
             else{
                 secDIlBeHosAdm.setVisibility(View.GONE);
                 lineDIlBeHosAdm.setVisibility(View.GONE);
                 txtDIlBeHosAdm.setText("");
                 secDHosNamLabel.setVisibility(View.GONE);
                 lineDHosNamLabel.setVisibility(View.GONE);
                 secDHosNam.setVisibility(View.GONE);
                 lineDHosNam.setVisibility(View.GONE);
                 spnDHosNam.setSelection(0);
                 secDHosNamOth.setVisibility(View.GONE);
                 lineDHosNamOth.setVisibility(View.GONE);
                 txtDHosNamOth.setText("");
                 secDHosNam2.setVisibility(View.GONE);
                 lineDHosNam2.setVisibility(View.GONE);
                 spnDHosNam2.setSelection(0);
                 secDHosNamOth2.setVisibility(View.GONE);
                 lineDHosNamOth2.setVisibility(View.GONE);
                 txtDHosNamOth2.setText("");
                 secDHosNam3.setVisibility(View.GONE);
                 lineDHosNam3.setVisibility(View.GONE);
                 spnDHosNam3.setSelection(0);
                 secDHosNamOth3.setVisibility(View.GONE);
                 lineDHosNamOth3.setVisibility(View.GONE);
                 txtDHosNamOth3.setText("");
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secDIlBeHosAdm=(LinearLayout)findViewById(R.id.secDIlBeHosAdm);
         lineDIlBeHosAdm=(View)findViewById(R.id.lineDIlBeHosAdm);
         VlblDIlBeHosAdm=(TextView) findViewById(R.id.VlblDIlBeHosAdm);
         txtDIlBeHosAdm=(EditText) findViewById(R.id.txtDIlBeHosAdm);
         secDHosNamLabel=(LinearLayout)findViewById(R.id.secDHosNamLabel);
         lineDHosNamLabel=(View)findViewById(R.id.lineDHosNamLabel);
         secDHosNam=(LinearLayout)findViewById(R.id.secDHosNam);
         lineDHosNam=(View)findViewById(R.id.lineDHosNam);
         VlblDHosNam=(TextView) findViewById(R.id.VlblDHosNam);
         spnDHosNam=(Spinner) findViewById(R.id.spnDHosNam);
         List<String> listDHosNam = new ArrayList<String>();
         
         listDHosNam.add("");
         listDHosNam.add("1-ঢাকা শিশু হাসপাতাল (Dhaka Shishu Hospital)");
         listDHosNam.add("2-ডাঃ এম আর খান  শিশু হাসপাতাল (Dr. MR Khan Shishu Hospital)");
         listDHosNam.add("3-কলেরা হাসপাতাল (ICDDR, B)");
         listDHosNam.add("7-অন্যান্য (Other)");
         listDHosNam.add("8-জানি না (Do not know)");
         ArrayAdapter<String> adptrDHosNam= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listDHosNam);
         spnDHosNam.setAdapter(adptrDHosNam);

         spnDHosNam.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnDHosNam.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnDHosNam.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("1"))
                 {
                    secDHosNamOth.setVisibility(View.GONE);
                    lineDHosNamOth.setVisibility(View.GONE);
                    txtDHosNamOth.setText("");
                     spnDHosNam2.setEnabled(true);
                     spnDHosNam3.setEnabled(true);
                 }
                 else if(spnData.equalsIgnoreCase("2"))
                 {
                    secDHosNamOth.setVisibility(View.GONE);
                    lineDHosNamOth.setVisibility(View.GONE);
                    txtDHosNamOth.setText("");
                     spnDHosNam2.setEnabled(true);
                     spnDHosNam3.setEnabled(true);
                 }
                 else if(spnData.equalsIgnoreCase("3"))
                 {
                    secDHosNamOth.setVisibility(View.GONE);
                    lineDHosNamOth.setVisibility(View.GONE);
                    txtDHosNamOth.setText("");
                     spnDHosNam2.setEnabled(true);
                     spnDHosNam3.setEnabled(true);
                 }
                 else if(spnData.equalsIgnoreCase("8"))
                 {
                    secDHosNamOth.setVisibility(View.GONE);
                    lineDHosNamOth.setVisibility(View.GONE);
                    txtDHosNamOth.setText("");
                     spnDHosNam2.setEnabled(true);
                     spnDHosNam3.setEnabled(true);
                 }
                 else if(spnData.equalsIgnoreCase("7"))
                 {
                    secDHosNamOth.setVisibility(View.VISIBLE);
                    lineDHosNamOth.setVisibility(View.VISIBLE);
                     spnDHosNam2.setSelection(0);
                     spnDHosNam3.setSelection(0);
                     spnDHosNam2.setEnabled(false);
                     spnDHosNam3.setEnabled(false);
                 }
                 else{
                     secDHosNamOth.setVisibility(View.GONE);
                     lineDHosNamOth.setVisibility(View.GONE);
                     spnDHosNam2.setEnabled(true);
                     spnDHosNam3.setEnabled(true);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secDHosNamOth=(LinearLayout)findViewById(R.id.secDHosNamOth);
         lineDHosNamOth=(View)findViewById(R.id.lineDHosNamOth);
         VlblDHosNamOth=(TextView) findViewById(R.id.VlblDHosNamOth);
         txtDHosNamOth=(EditText) findViewById(R.id.txtDHosNamOth);
         secDHosNam2=(LinearLayout)findViewById(R.id.secDHosNam2);
         lineDHosNam2=(View)findViewById(R.id.lineDHosNam2);
         VlblDHosNam2=(TextView) findViewById(R.id.VlblDHosNam2);
         spnDHosNam2=(Spinner) findViewById(R.id.spnDHosNam2);
         List<String> listDHosNam2 = new ArrayList<String>();
         
         listDHosNam2.add("");
         listDHosNam2.add("1-ঢাকা শিশু হাসপাতাল (Dhaka Shishu Hospital)");
         listDHosNam2.add("2-ডাঃ এম আর খান  শিশু হাসপাতাল (Dr. MR Khan Shishu Hospital)");
         listDHosNam2.add("3-কলেরা হাসপাতাল (ICDDR, B)");
         listDHosNam2.add("7-অন্যান্য (Other)");
         listDHosNam2.add("8-জানি না (Do not know)");
         ArrayAdapter<String> adptrDHosNam2= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listDHosNam2);
         spnDHosNam2.setAdapter(adptrDHosNam2);

         spnDHosNam2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnDHosNam2.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnDHosNam2.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("1"))
                 {
                    secDHosNamOth2.setVisibility(View.GONE);
                    lineDHosNamOth2.setVisibility(View.GONE);
                    txtDHosNamOth2.setText("");
                     spnDHosNam3.setEnabled(true);
                 }
                 else if(spnData.equalsIgnoreCase("2"))
                 {
                    secDHosNamOth2.setVisibility(View.GONE);
                    lineDHosNamOth2.setVisibility(View.GONE);
                    txtDHosNamOth2.setText("");
                     spnDHosNam3.setEnabled(true);
                 }
                 else if(spnData.equalsIgnoreCase("3"))
                 {
                    secDHosNamOth2.setVisibility(View.GONE);
                    lineDHosNamOth2.setVisibility(View.GONE);
                    txtDHosNamOth2.setText("");
                     spnDHosNam3.setEnabled(true);
                 }
                 else if(spnData.equalsIgnoreCase("8"))
                 {
                    secDHosNamOth2.setVisibility(View.GONE);
                    lineDHosNamOth2.setVisibility(View.GONE);
                    txtDHosNamOth2.setText("");
                     spnDHosNam3.setEnabled(true);
                 }
                 else if(spnData.equalsIgnoreCase("7"))
                 {
                    secDHosNamOth2.setVisibility(View.VISIBLE);
                    lineDHosNamOth2.setVisibility(View.VISIBLE);
                     spnDHosNam3.setEnabled(false);
                     spnDHosNam3.setEnabled(false);
                 }
                 else{
                     secDHosNamOth2.setVisibility(View.GONE);
                     lineDHosNamOth2.setVisibility(View.GONE);
                     spnDHosNam3.setEnabled(true);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secDHosNamOth2=(LinearLayout)findViewById(R.id.secDHosNamOth2);
         lineDHosNamOth2=(View)findViewById(R.id.lineDHosNamOth2);
         VlblDHosNamOth2=(TextView) findViewById(R.id.VlblDHosNamOth2);
         txtDHosNamOth2=(EditText) findViewById(R.id.txtDHosNamOth2);
         secDHosNam3=(LinearLayout)findViewById(R.id.secDHosNam3);
         lineDHosNam3=(View)findViewById(R.id.lineDHosNam3);
         VlblDHosNam3=(TextView) findViewById(R.id.VlblDHosNam3);
         spnDHosNam3=(Spinner) findViewById(R.id.spnDHosNam3);
         List<String> listDHosNam3 = new ArrayList<String>();
         
         listDHosNam3.add("");
         listDHosNam3.add("1-ঢাকা শিশু হাসপাতাল (Dhaka Shishu Hospital)");
         listDHosNam3.add("2-ডাঃ এম আর খান  শিশু হাসপাতাল (Dr. MR Khan Shishu Hospital)");
         listDHosNam3.add("3-কলেরা হাসপাতাল (ICDDR, B)");
         listDHosNam3.add("7-অন্যান্য (Other)");
         listDHosNam3.add("8-জানি না (Do not know)");
         ArrayAdapter<String> adptrDHosNam3= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listDHosNam3);
         spnDHosNam3.setAdapter(adptrDHosNam3);

         spnDHosNam3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnDHosNam3.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnDHosNam3.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("1"))
                 {
                    secDHosNamOth3.setVisibility(View.GONE);
                    lineDHosNamOth3.setVisibility(View.GONE);
                    txtDHosNamOth3.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("2"))
                 {
                    secDHosNamOth3.setVisibility(View.GONE);
                    lineDHosNamOth3.setVisibility(View.GONE);
                    txtDHosNamOth3.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("3"))
                 {
                    secDHosNamOth3.setVisibility(View.GONE);
                    lineDHosNamOth3.setVisibility(View.GONE);
                    txtDHosNamOth3.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("8"))
                 {
                    secDHosNamOth3.setVisibility(View.GONE);
                    lineDHosNamOth3.setVisibility(View.GONE);
                    txtDHosNamOth3.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("7"))
                 {
                    secDHosNamOth3.setVisibility(View.VISIBLE);
                    lineDHosNamOth3.setVisibility(View.VISIBLE);
                 }
                 else{
                     secDHosNamOth3.setVisibility(View.GONE);
                     lineDHosNamOth3.setVisibility(View.GONE);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secDHosNamOth3=(LinearLayout)findViewById(R.id.secDHosNamOth3);
         lineDHosNamOth3=(View)findViewById(R.id.lineDHosNamOth3);
         VlblDHosNamOth3=(TextView) findViewById(R.id.VlblDHosNamOth3);
         txtDHosNamOth3=(EditText) findViewById(R.id.txtDHosNamOth3);
         secDReco=(LinearLayout)findViewById(R.id.secDReco);
         lineDReco=(View)findViewById(R.id.lineDReco);
         VlblDReco = (TextView) findViewById(R.id.VlblDReco);
         rdogrpDReco = (RadioGroup) findViewById(R.id.rdogrpDReco);
         
         rdoDReco1 = (RadioButton) findViewById(R.id.rdoDReco1);
         rdoDReco2 = (RadioButton) findViewById(R.id.rdoDReco2);
         rdoDReco3 = (RadioButton) findViewById(R.id.rdoDReco3);
         rdogrpDReco.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpDReco = new String[] {"1","2","8"};
             for (int i = 0; i < rdogrpDReco.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpDReco.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpDReco[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secDDurReco.setVisibility(View.GONE);
                    lineDDurReco.setVisibility(View.GONE);
                 secDInReco.setVisibility(View.VISIBLE);
                 lineDInReco.setVisibility(View.VISIBLE);

             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secDDurReco.setVisibility(View.GONE);
                    lineDDurReco.setVisibility(View.GONE);
                 secDInReco.setVisibility(View.VISIBLE);
                 lineDInReco.setVisibility(View.VISIBLE);

             }
             else if(rbData.equalsIgnoreCase("1"))
             {
                    secDDurReco.setVisibility(View.VISIBLE);
                    lineDDurReco.setVisibility(View.VISIBLE);
                 secDInReco.setVisibility(View.VISIBLE);
                 lineDInReco.setVisibility(View.VISIBLE);
             }
             else{
                 secDDurReco.setVisibility(View.GONE);
                 lineDDurReco.setVisibility(View.GONE);
                 secDInReco.setVisibility(View.VISIBLE);
                 lineDInReco.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secDDurReco=(LinearLayout)findViewById(R.id.secDDurReco);
         lineDDurReco=(View)findViewById(R.id.lineDDurReco);
         VlblDDurReco=(TextView) findViewById(R.id.VlblDDurReco);
         txtDDurReco=(EditText) findViewById(R.id.txtDDurReco);
         secDInReco=(LinearLayout)findViewById(R.id.secDInReco);
         lineDInReco=(View)findViewById(R.id.lineDInReco);
         VlblDInReco = (TextView) findViewById(R.id.VlblDInReco);
         rdogrpDInReco = (RadioGroup) findViewById(R.id.rdogrpDInReco);
         
         rdoDInReco1 = (RadioButton) findViewById(R.id.rdoDInReco1);
         rdoDInReco2 = (RadioButton) findViewById(R.id.rdoDInReco2);
         rdogrpDInReco.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpDInReco = new String[] {"1","2"};
             for (int i = 0; i < rdogrpDInReco.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpDInReco.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpDInReco[i];
             }

             if(rbData.equalsIgnoreCase("1"))
             {
                    secDInRecoOth.setVisibility(View.GONE);
                    lineDInRecoOth.setVisibility(View.GONE);
                    txtDInRecoOth.setText("");
             }
             else
             {
                    secDInRecoOth.setVisibility(View.VISIBLE);
                    lineDInRecoOth.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secDInRecoOth=(LinearLayout)findViewById(R.id.secDInRecoOth);
         lineDInRecoOth=(View)findViewById(R.id.lineDInRecoOth);
         VlblDInRecoOth=(TextView) findViewById(R.id.VlblDInRecoOth);
         txtDInRecoOth=(EditText) findViewById(R.id.txtDInRecoOth);
         secDAboIll=(LinearLayout)findViewById(R.id.secDAboIll);
         lineDAboIll=(View)findViewById(R.id.lineDAboIll);
         VlblDAboIll=(TextView) findViewById(R.id.VlblDAboIll);
         txtDAboIll=(EditText) findViewById(R.id.txtDAboIll);

txtDDurReco.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if(txtDDurReco.getText().toString().length()>0){
            secDInReco.setVisibility(View.GONE);
            lineDInReco.setVisibility(View.GONE);
        }
        else{
            secDInReco.setVisibility(View.VISIBLE);
            lineDInReco.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
});



         //Hide all skip variables
         secDDisEpi.setVisibility(View.GONE);
         lineDDisEpi.setVisibility(View.GONE);
         secStoolBlood.setVisibility(View.GONE);
         lineStoolBlood.setVisibility(View.GONE);
         secFeedORS.setVisibility(View.GONE);
         lineFeedORS.setVisibility(View.GONE);
         secDHCar.setVisibility(View.GONE);
         lineDHCar.setVisibility(View.GONE);
         secORSBefHCar.setVisibility(View.GONE);
         lineORSBefHCar.setVisibility(View.GONE);
         secDHCarTypLabel.setVisibility(View.GONE);
         lineDHCarTypLabel.setVisibility(View.GONE);
         secDHC_PhyMBBS.setVisibility(View.GONE);
         lineDHC_PhyMBBS.setVisibility(View.GONE);
         secDHC_UnquaDoctor.setVisibility(View.GONE);
         lineDHC_UnquaDoctor.setVisibility(View.GONE);
         secDHC_Para.setVisibility(View.GONE);
         lineDHC_Para.setVisibility(View.GONE);
         secDHC_Com.setVisibility(View.GONE);
         lineDHC_Com.setVisibility(View.GONE);
         secDHC_Pha.setVisibility(View.GONE);
         lineDHC_Pha.setVisibility(View.GONE);
         secDHC_Hompath.setVisibility(View.GONE);
         lineDHC_Hompath.setVisibility(View.GONE);
         secDHC_TrHeal.setVisibility(View.GONE);
         lineDHC_TrHeal.setVisibility(View.GONE);
         secDHC_SpiHeal.setVisibility(View.GONE);
         lineDHC_SpiHeal.setVisibility(View.GONE);
         secDHC_Oth.setVisibility(View.GONE);
         lineDHC_Oth.setVisibility(View.GONE);
         secDHC_OthName.setVisibility(View.GONE);
         lineDHC_OthName.setVisibility(View.GONE);
         secDDSHOPD.setVisibility(View.GONE);
         lineDDSHOPD.setVisibility(View.GONE);
         secDSSFOPD.setVisibility(View.GONE);
         lineDSSFOPD.setVisibility(View.GONE);
         secDAdmHos.setVisibility(View.GONE);
         lineDAdmHos.setVisibility(View.GONE);
         secDIlBeHosAdm.setVisibility(View.GONE);
         lineDIlBeHosAdm.setVisibility(View.GONE);
         secDHosNamLabel.setVisibility(View.GONE);
         lineDHosNamLabel.setVisibility(View.GONE);
         secDHosNam.setVisibility(View.GONE);
         lineDHosNam.setVisibility(View.GONE);
         secDHosNamOth.setVisibility(View.GONE);
         lineDHosNamOth.setVisibility(View.GONE);
         secDHosNam2.setVisibility(View.GONE);
         lineDHosNam2.setVisibility(View.GONE);
         secDHosNamOth2.setVisibility(View.GONE);
         lineDHosNamOth2.setVisibility(View.GONE);
         secDHosNam3.setVisibility(View.GONE);
         lineDHosNam3.setVisibility(View.GONE);
         secDHosNamOth3.setVisibility(View.GONE);
         lineDHosNamOth3.setVisibility(View.GONE);
         secDReco.setVisibility(View.GONE);
         lineDReco.setVisibility(View.GONE);
         secDDurReco.setVisibility(View.GONE);
         lineDDurReco.setVisibility(View.GONE);
         secDInReco.setVisibility(View.GONE);
         lineDInReco.setVisibility(View.GONE);
         secDInRecoOth.setVisibility(View.GONE);
         lineDInRecoOth.setVisibility(View.GONE);
         secDAboIll.setVisibility(View.GONE);
         lineDAboIll.setVisibility(View.GONE);
         secDDisEpi.setVisibility(View.GONE);
         lineDDisEpi.setVisibility(View.GONE);
         secStoolBlood.setVisibility(View.GONE);
         lineStoolBlood.setVisibility(View.GONE);
         secFeedORS.setVisibility(View.GONE);
         lineFeedORS.setVisibility(View.GONE);
         secDHCar.setVisibility(View.GONE);
         lineDHCar.setVisibility(View.GONE);
         secORSBefHCar.setVisibility(View.GONE);
         lineORSBefHCar.setVisibility(View.GONE);
         secDHCarTypLabel.setVisibility(View.GONE);
         lineDHCarTypLabel.setVisibility(View.GONE);
         secDHC_PhyMBBS.setVisibility(View.GONE);
         lineDHC_PhyMBBS.setVisibility(View.GONE);
         secDHC_UnquaDoctor.setVisibility(View.GONE);
         lineDHC_UnquaDoctor.setVisibility(View.GONE);
         secDHC_Para.setVisibility(View.GONE);
         lineDHC_Para.setVisibility(View.GONE);
         secDHC_Com.setVisibility(View.GONE);
         lineDHC_Com.setVisibility(View.GONE);
         secDHC_Pha.setVisibility(View.GONE);
         lineDHC_Pha.setVisibility(View.GONE);
         secDHC_Hompath.setVisibility(View.GONE);
         lineDHC_Hompath.setVisibility(View.GONE);
         secDHC_TrHeal.setVisibility(View.GONE);
         lineDHC_TrHeal.setVisibility(View.GONE);
         secDHC_SpiHeal.setVisibility(View.GONE);
         lineDHC_SpiHeal.setVisibility(View.GONE);
         secDHC_Oth.setVisibility(View.GONE);
         lineDHC_Oth.setVisibility(View.GONE);
         secDHC_OthName.setVisibility(View.GONE);
         lineDHC_OthName.setVisibility(View.GONE);
         secDDSHOPD.setVisibility(View.GONE);
         lineDDSHOPD.setVisibility(View.GONE);
         secDSSFOPD.setVisibility(View.GONE);
         lineDSSFOPD.setVisibility(View.GONE);
         secDAdmHos.setVisibility(View.GONE);
         lineDAdmHos.setVisibility(View.GONE);
         secDIlBeHosAdm.setVisibility(View.GONE);
         lineDIlBeHosAdm.setVisibility(View.GONE);
         secDHosNamLabel.setVisibility(View.GONE);
         lineDHosNamLabel.setVisibility(View.GONE);
         secDHosNam.setVisibility(View.GONE);
         lineDHosNam.setVisibility(View.GONE);
         secDHosNamOth.setVisibility(View.GONE);
         lineDHosNamOth.setVisibility(View.GONE);
         secDHosNam2.setVisibility(View.GONE);
         lineDHosNam2.setVisibility(View.GONE);
         secDHosNamOth2.setVisibility(View.GONE);
         lineDHosNamOth2.setVisibility(View.GONE);
         secDHosNam3.setVisibility(View.GONE);
         lineDHosNam3.setVisibility(View.GONE);
         secDHosNamOth3.setVisibility(View.GONE);
         lineDHosNamOth3.setVisibility(View.GONE);
         secDReco.setVisibility(View.GONE);
         lineDReco.setVisibility(View.GONE);
         secDDurReco.setVisibility(View.GONE);
         lineDDurReco.setVisibility(View.GONE);
         secDInReco.setVisibility(View.GONE);
         lineDInReco.setVisibility(View.GONE);
         secDInRecoOth.setVisibility(View.GONE);
         lineDInRecoOth.setVisibility(View.GONE);
         secDAboIll.setVisibility(View.GONE);
         lineDAboIll.setVisibility(View.GONE);
         secORSBefHCar.setVisibility(View.GONE);
         lineORSBefHCar.setVisibility(View.GONE);
         secDHCarTypLabel.setVisibility(View.GONE);
         lineDHCarTypLabel.setVisibility(View.GONE);
         secDHC_PhyMBBS.setVisibility(View.GONE);
         lineDHC_PhyMBBS.setVisibility(View.GONE);
         secDHC_UnquaDoctor.setVisibility(View.GONE);
         lineDHC_UnquaDoctor.setVisibility(View.GONE);
         secDHC_Para.setVisibility(View.GONE);
         lineDHC_Para.setVisibility(View.GONE);
         secDHC_Com.setVisibility(View.GONE);
         lineDHC_Com.setVisibility(View.GONE);
         secDHC_Pha.setVisibility(View.GONE);
         lineDHC_Pha.setVisibility(View.GONE);
         secDHC_Hompath.setVisibility(View.GONE);
         lineDHC_Hompath.setVisibility(View.GONE);
         secDHC_TrHeal.setVisibility(View.GONE);
         lineDHC_TrHeal.setVisibility(View.GONE);
         secDHC_SpiHeal.setVisibility(View.GONE);
         lineDHC_SpiHeal.setVisibility(View.GONE);
         secDHC_Oth.setVisibility(View.GONE);
         lineDHC_Oth.setVisibility(View.GONE);
         secDHC_OthName.setVisibility(View.GONE);
         lineDHC_OthName.setVisibility(View.GONE);
         secORSBefHCar.setVisibility(View.GONE);
         lineORSBefHCar.setVisibility(View.GONE);
         secDHCarTypLabel.setVisibility(View.GONE);
         lineDHCarTypLabel.setVisibility(View.GONE);
         secDHC_PhyMBBS.setVisibility(View.GONE);
         lineDHC_PhyMBBS.setVisibility(View.GONE);
         secDHC_UnquaDoctor.setVisibility(View.GONE);
         lineDHC_UnquaDoctor.setVisibility(View.GONE);
         secDHC_Para.setVisibility(View.GONE);
         lineDHC_Para.setVisibility(View.GONE);
         secDHC_Com.setVisibility(View.GONE);
         lineDHC_Com.setVisibility(View.GONE);
         secDHC_Pha.setVisibility(View.GONE);
         lineDHC_Pha.setVisibility(View.GONE);
         secDHC_Hompath.setVisibility(View.GONE);
         lineDHC_Hompath.setVisibility(View.GONE);
         secDHC_TrHeal.setVisibility(View.GONE);
         lineDHC_TrHeal.setVisibility(View.GONE);
         secDHC_SpiHeal.setVisibility(View.GONE);
         lineDHC_SpiHeal.setVisibility(View.GONE);
         secDHC_Oth.setVisibility(View.GONE);
         lineDHC_Oth.setVisibility(View.GONE);
         secDHC_OthName.setVisibility(View.GONE);
         lineDHC_OthName.setVisibility(View.GONE);
         secDHC_OthName.setVisibility(View.GONE);
         lineDHC_OthName.setVisibility(View.GONE);
         secDHC_OthName.setVisibility(View.GONE);
         lineDHC_OthName.setVisibility(View.GONE);
         secDIlBeHosAdm.setVisibility(View.GONE);
         lineDIlBeHosAdm.setVisibility(View.GONE);
         secDHosNamLabel.setVisibility(View.GONE);
         lineDHosNamLabel.setVisibility(View.GONE);
         secDHosNam.setVisibility(View.GONE);
         lineDHosNam.setVisibility(View.GONE);
         secDHosNamOth.setVisibility(View.GONE);
         lineDHosNamOth.setVisibility(View.GONE);
         secDHosNam2.setVisibility(View.GONE);
         lineDHosNam2.setVisibility(View.GONE);
         secDHosNamOth2.setVisibility(View.GONE);
         lineDHosNamOth2.setVisibility(View.GONE);
         secDHosNam3.setVisibility(View.GONE);
         lineDHosNam3.setVisibility(View.GONE);
         secDHosNamOth3.setVisibility(View.GONE);
         lineDHosNamOth3.setVisibility(View.GONE);
         secDIlBeHosAdm.setVisibility(View.GONE);
         lineDIlBeHosAdm.setVisibility(View.GONE);
         secDHosNamLabel.setVisibility(View.GONE);
         lineDHosNamLabel.setVisibility(View.GONE);
         secDHosNam.setVisibility(View.GONE);
         lineDHosNam.setVisibility(View.GONE);
         secDHosNamOth.setVisibility(View.GONE);
         lineDHosNamOth.setVisibility(View.GONE);
         secDHosNam2.setVisibility(View.GONE);
         lineDHosNam2.setVisibility(View.GONE);
         secDHosNamOth2.setVisibility(View.GONE);
         lineDHosNamOth2.setVisibility(View.GONE);
         secDHosNam3.setVisibility(View.GONE);
         lineDHosNam3.setVisibility(View.GONE);
         secDHosNamOth3.setVisibility(View.GONE);
         lineDHosNamOth3.setVisibility(View.GONE);
         secDHosNamOth.setVisibility(View.GONE);
         lineDHosNamOth.setVisibility(View.GONE);
         secDHosNamOth.setVisibility(View.GONE);
         lineDHosNamOth.setVisibility(View.GONE);
         secDHosNamOth.setVisibility(View.GONE);
         lineDHosNamOth.setVisibility(View.GONE);
         secDHosNamOth.setVisibility(View.GONE);
         lineDHosNamOth.setVisibility(View.GONE);
         secDHosNamOth2.setVisibility(View.GONE);
         lineDHosNamOth2.setVisibility(View.GONE);
         secDHosNamOth2.setVisibility(View.GONE);
         lineDHosNamOth2.setVisibility(View.GONE);
         secDHosNamOth2.setVisibility(View.GONE);
         lineDHosNamOth2.setVisibility(View.GONE);
         secDHosNamOth2.setVisibility(View.GONE);
         lineDHosNamOth2.setVisibility(View.GONE);
         secDHosNamOth3.setVisibility(View.GONE);
         lineDHosNamOth3.setVisibility(View.GONE);
         secDHosNamOth3.setVisibility(View.GONE);
         lineDHosNamOth3.setVisibility(View.GONE);
         secDHosNamOth3.setVisibility(View.GONE);
         lineDHosNamOth3.setVisibility(View.GONE);
         secDHosNamOth3.setVisibility(View.GONE);
         lineDHosNamOth3.setVisibility(View.GONE);
         secDDurReco.setVisibility(View.GONE);
         lineDDurReco.setVisibility(View.GONE);
         secDDurReco.setVisibility(View.GONE);
         lineDDurReco.setVisibility(View.GONE);
         secDInRecoOth.setVisibility(View.GONE);
         lineDInRecoOth.setVisibility(View.GONE);

         DataSearch(UNCODE,STRUCTURENO,HOUSEHOLDSL,VISITNO,MEMSL);


        Button cmdSave = (Button) findViewById(R.id.cmdSave);
        cmdSave.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) { 
            DataSave();
        }});
     }
     catch(Exception  e)
     {
         Connection.MessageBox(DiarrhoeaCase .this, e.getMessage());
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
             Connection.MessageBox(DiarrhoeaCase .this, "Required field: Ward No.");
             txtUNCode.requestFocus(); 
             return;	
           }
         else if(txtStructureNo.getText().toString().length()==0 & secStructureNo.isShown())
           {
             Connection.MessageBox(DiarrhoeaCase .this, "Required field: Structure No.");
             txtStructureNo.requestFocus(); 
             return;	
           }
         else if(txtHouseholdSl.getText().toString().length()==0 & secHouseholdSl.isShown())
           {
             Connection.MessageBox(DiarrhoeaCase .this, "Required field: Household Sl.");
             txtHouseholdSl.requestFocus(); 
             return;	
           }
         else if(txtVisitNo.getText().toString().length()==0 & secVisitNo.isShown())
           {
             Connection.MessageBox(DiarrhoeaCase .this, "Required field: Visit No.");
             txtVisitNo.requestFocus(); 
             return;	
           }
         else if(txtMemSl.getText().toString().length()==0 & secMemSl.isShown())
           {
             Connection.MessageBox(DiarrhoeaCase .this, "Required field: Member Serial.");
             txtMemSl.requestFocus(); 
             return;	
           }
         
         else if(!rdoDWatStool1.isChecked() & !rdoDWatStool2.isChecked() & !rdoDWatStool3.isChecked() & secDWatStool.isShown())
           {
              Connection.MessageBox(DiarrhoeaCase .this, "Select anyone options from (গত ২ সপ্তাহে এই  শিশুটির কি এমন অসুস্থতা হয়েছিল যে ২8 ঘন্টার মধ্যে ৩ বা অধিক বার পাতলা পায়খানা হয়েছিল (পূর্বের বর্ণনা করা অসুস্থতা ছাড়া)? (Within  the last 2 weeks did this child have an illness with 3 or more loose watery stools in 24 hours?)).");
              rdoDWatStool1.requestFocus();
              return;
           }
         else if(txtDDisEpi.getText().toString().length()==0 & secDDisEpi.isShown())
           {
             Connection.MessageBox(DiarrhoeaCase .this, "Required field: গত ২ সপ্তাহে এই শিশুর কতবার এই ধরনের অসুস্থতা হয়েছিল? (যদি একের অধিক এই অসুস্থতা হয়ে থাকে তবে অতিসম্প্রতি অসুস্থতা সম্পর্কে নিচের প্রশ্নগুলো করুন) (Within the last 2 weeks how many episodes of such an illness did this child have?).");
             txtDDisEpi.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtDDisEpi.getText().toString().length()==0 ? "1" : txtDDisEpi.getText().toString()) < 1 || Integer.valueOf(txtDDisEpi.getText().toString().length()==0 ? "20" : txtDDisEpi.getText().toString()) > 20)
           {
             Connection.MessageBox(DiarrhoeaCase .this, "Value should be between 1 and 20(গত ২ সপ্তাহে এই শিশুর কতবার এই ধরনের অসুস্থতা হয়েছিল? (যদি একের অধিক এই অসুস্থতা হয়ে থাকে তবে অতিসম্প্রতি অসুস্থতা সম্পর্কে নিচের প্রশ্নগুলো করুন) (Within the last 2 weeks how many episodes of such an illness did this child have?)).");
             txtDDisEpi.requestFocus(); 
             return;	
           }
         
         else if(!rdoStoolBlood1.isChecked() & !rdoStoolBlood2.isChecked() & !rdoStoolBlood3.isChecked() & secStoolBlood.isShown())
           {
              Connection.MessageBox(DiarrhoeaCase .this, "Select anyone options from (আপনি কি শিশুর মলে কোন রক্ত দেখেছিলেন? (Did you observe any blood in the stool?)).");
              rdoStoolBlood1.requestFocus();
              return;
           }
         
         else if(!rdoFeedORS1.isChecked() & !rdoFeedORS2.isChecked() & !rdoFeedORS3.isChecked() & secFeedORS.isShown())
           {
              Connection.MessageBox(DiarrhoeaCase .this, "Select anyone options from (এই অসুস্থতার সময় শিশুটি কি ওরস্যালাইন খেয়েছিল? Did the child receive ORS (saline) during the episode?).");
              rdoFeedORS1.requestFocus();
              return;
           }
         
         else if(!rdoDHCar1.isChecked() & !rdoDHCar2.isChecked() & !rdoDHCar3.isChecked() & secDHCar.isShown())
           {
              Connection.MessageBox(DiarrhoeaCase .this, "Select anyone options from (এই অসুস্থতার সময় এই শিশুটিকে কি কোন স্বাস্থ্যসেবা দানকারীর কাছে নিয়ে গিয়েছিলেন ? (During this episode of illness, did you bring your child to a health care provider?)).");
              rdoDHCar1.requestFocus();
              return;
           }
         
         else if(!rdoORSBefHCar1.isChecked() & !rdoORSBefHCar2.isChecked() & !rdoORSBefHCar3.isChecked() & secORSBefHCar.isShown())
           {
              Connection.MessageBox(DiarrhoeaCase .this, "Select anyone options from ( এই অসুস্থতার সময় স্বাস্থ্যসেবা দানকারীর কাছে নিয়ে যাওয়ার আগে শিশুটি কি ওরস্যালাইন খেয়েছিল? (During the episode, did the child receive ORS before the child was seen by health care practitioners if any?)  ).");
              rdoORSBefHCar1.requestFocus();
              return;
           }
         
         else if(!rdoDHC_PhyMBBS1.isChecked() & !rdoDHC_PhyMBBS2.isChecked() & !rdoDHC_PhyMBBS3.isChecked() & secDHC_PhyMBBS.isShown())
           {
              Connection.MessageBox(DiarrhoeaCase .this, "Select anyone options from (1.পাশ করা ডাক্তার যেমন MBBS বা এর উপর (MBBS and above) ).");
              rdoDHC_PhyMBBS1.requestFocus();
              return;
           }
         
         else if(!rdoDHC_UnquaDoctor1.isChecked() & !rdoDHC_UnquaDoctor2.isChecked() & !rdoDHC_UnquaDoctor3.isChecked() & secDHC_UnquaDoctor.isShown())
           {
              Connection.MessageBox(DiarrhoeaCase .this, "Select anyone options from (2.অদক্ষ ডাক্তার/ LMAF (Unqualified doctor/LMAF) ).");
              rdoDHC_UnquaDoctor1.requestFocus();
              return;
           }
         
         else if(!rdoDHC_Para1.isChecked() & !rdoDHC_Para2.isChecked() & !rdoDHC_Para3.isChecked() & secDHC_Para.isShown())
           {
              Connection.MessageBox(DiarrhoeaCase .this, "Select anyone options from (3.প্যারামেডিক (GoB/NGO) (Paramedics (GoB/NGO))  ).");
              rdoDHC_Para1.requestFocus();
              return;
           }
         
         else if(!rdoDHC_Com1.isChecked() & !rdoDHC_Com2.isChecked() & !rdoDHC_Com3.isChecked() & secDHC_Com.isShown())
           {
              Connection.MessageBox(DiarrhoeaCase .this, "Select anyone options from (4.কম্পাউণ্ডার (Compounder)).");
              rdoDHC_Com1.requestFocus();
              return;
           }
         
         else if(!rdoDHC_Pha1.isChecked() & !rdoDHC_Pha2.isChecked() & !rdoDHC_Pha3.isChecked() & secDHC_Pha.isShown())
           {
              Connection.MessageBox(DiarrhoeaCase .this, "Select anyone options from (5.ঔষধ বিক্রেতা/ফার্মেসি (Drug seller/Pharmacy)  ).");
              rdoDHC_Pha1.requestFocus();
              return;
           }
         
         else if(!rdoDHC_Hompath1.isChecked() & !rdoDHC_Hompath2.isChecked() & !rdoDHC_Hompath3.isChecked() & secDHC_Hompath.isShown())
           {
              Connection.MessageBox(DiarrhoeaCase .this, "Select anyone options from (6.হোমিওপ্যাঁথ (Homeopath)  ).");
              rdoDHC_Hompath1.requestFocus();
              return;
           }
         
         else if(!rdoDHC_TrHeal1.isChecked() & !rdoDHC_TrHeal2.isChecked() & !rdoDHC_TrHeal3.isChecked() & secDHC_TrHeal.isShown())
           {
              Connection.MessageBox(DiarrhoeaCase .this, "Select anyone options from (7.কবিরাজ (Traditional care provider)  ).");
              rdoDHC_TrHeal1.requestFocus();
              return;
           }
         
         else if(!rdoDHC_SpiHeal1.isChecked() & !rdoDHC_SpiHeal2.isChecked() & !rdoDHC_SpiHeal3.isChecked() & secDHC_SpiHeal.isShown())
           {
              Connection.MessageBox(DiarrhoeaCase .this, "Select anyone options from (8.আধ্যাত্মিক চিকিৎসক (Spiritual healer) ).");
              rdoDHC_SpiHeal1.requestFocus();
              return;
           }
         
         else if(!rdoDHC_Oth1.isChecked() & !rdoDHC_Oth2.isChecked() & !rdoDHC_Oth3.isChecked() & secDHC_Oth.isShown())
           {
              Connection.MessageBox(DiarrhoeaCase .this, "Select anyone options from (9.অন্যান্য  (Other)).");
              rdoDHC_Oth1.requestFocus();
              return;
           }
         else if(txtDHC_OthName.getText().toString().length()==0 & secDHC_OthName.isShown())
           {
             Connection.MessageBox(DiarrhoeaCase .this, "Required field: 10.অন্যান্য উল্লেখ করুন (Others Specify).");
             txtDHC_OthName.requestFocus(); 
             return;	
           }
         
         else if(!rdoDDSHOPD1.isChecked() & !rdoDDSHOPD2.isChecked() & !rdoDDSHOPD3.isChecked() & secDDSHOPD.isShown())
           {
              Connection.MessageBox(DiarrhoeaCase .this, "Select anyone options from (শিশুটিকে কি ঢাকা শিশু হাসপাতালের বহির্বিভাগে নেয়া হয়েছিল? ( Was the child seen at outdoor patient at Dhaka Shishu Hospital?)).");
              rdoDDSHOPD1.requestFocus();
              return;
           }
         
         else if(!rdoDSSFOPD1.isChecked() & !rdoDSSFOPD2.isChecked() & !rdoDSSFOPD3.isChecked() & secDSSFOPD.isShown())
           {
              Connection.MessageBox(DiarrhoeaCase .this, "Select anyone options from (শিশুটিকে কি মিরপুর ডাঃ এম আর খান  শিশু হাসপাতাল  এর  বহির্বিভাগে নেয়া হয়েছিল ? (Was the child seen as an outdoor patient at Mirpur Dr. MR Khan Shishu Hospital?)).");
              rdoDSSFOPD1.requestFocus();
              return;
           }
         
         else if(!rdoDAdmHos1.isChecked() & !rdoDAdmHos2.isChecked() & !rdoDAdmHos3.isChecked() & secDAdmHos.isShown())
           {
              Connection.MessageBox(DiarrhoeaCase .this, "Select anyone options from (এই অসুস্থতার জন্য শিশুটিকে কি হাসপাতালে ভর্তি করা হয়েছিল?  (During this episode of illness, was your child hospitalized?)).");
              rdoDAdmHos1.requestFocus();
              return;
           }
         else if(txtDIlBeHosAdm.getText().toString().length()==0 & secDIlBeHosAdm.isShown())
           {
             Connection.MessageBox(DiarrhoeaCase .this, "Required field: হাসপাতালে ভর্তির আগে শিশুটি কতদিন অসুস্থ ছিল? (যদি জানা না থাকে 98 বসান) (For how many days did the child appear ill before he/she was hospitalized?).");
             txtDIlBeHosAdm.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtDIlBeHosAdm.getText().toString().length()==0 ? "1" : txtDIlBeHosAdm.getText().toString()) < 1 || Integer.valueOf(txtDIlBeHosAdm.getText().toString().length()==0 ? "98" : txtDIlBeHosAdm.getText().toString()) > 98)
           {
             Connection.MessageBox(DiarrhoeaCase .this, "Value should be between 1 and 98(হাসপাতালে ভর্তির আগে শিশুটি কতদিন অসুস্থ ছিল? (যদি জানা না থাকে 98 বসান) (For how many days did the child appear ill before he/she was hospitalized?)).");
             txtDIlBeHosAdm.requestFocus(); 
             return;	
           }
         else if(spnDHosNam.getSelectedItemPosition()==0  & secDHosNam.isShown())
           {
             Connection.MessageBox(DiarrhoeaCase .this, "Required field: 1..");
             spnDHosNam.requestFocus(); 
             return;	
           }
         else if(txtDHosNamOth.getText().toString().length()==0 & secDHosNamOth.isShown())
           {
             Connection.MessageBox(DiarrhoeaCase .this, "Required field: Name of the other hospital-1.");
             txtDHosNamOth.requestFocus(); 
             return;	
           }
//         else if(spnDHosNam2.getSelectedItemPosition()==0  & secDHosNam2.isShown())
//           {
//             Connection.MessageBox(DiarrhoeaCase .this, "Required field: 2..");
//             spnDHosNam2.requestFocus();
//             return;
//           }
//         else if(txtDHosNamOth2.getText().toString().length()==0 & secDHosNamOth2.isShown())
//           {
//             Connection.MessageBox(DiarrhoeaCase .this, "Required field: Name of the other hospital-2.");
//             txtDHosNamOth2.requestFocus();
//             return;
//           }
//         else if(spnDHosNam3.getSelectedItemPosition()==0  & secDHosNam3.isShown())
//           {
//             Connection.MessageBox(DiarrhoeaCase .this, "Required field: 3..");
//             spnDHosNam3.requestFocus();
//             return;
//           }
//         else if(txtDHosNamOth3.getText().toString().length()==0 & secDHosNamOth3.isShown())
//           {
//             Connection.MessageBox(DiarrhoeaCase .this, "Required field: Name of the other hospital-3.");
//             txtDHosNamOth3.requestFocus();
//             return;
//           }
         
         else if(!rdoDReco1.isChecked() & !rdoDReco2.isChecked() & !rdoDReco3.isChecked() & secDReco.isShown())
           {
              Connection.MessageBox(DiarrhoeaCase .this, "Select anyone options from (শিশুটি কি সম্পূর্ণ সুস্থ হয়ে গিয়েছিল? (Did the child recover completely?)).");
              rdoDReco1.requestFocus();
              return;
           }
         else if(txtDDurReco.getText().toString().length()==0 & secDDurReco.isShown())
           {
             Connection.MessageBox(DiarrhoeaCase .this, "Required field: শিশুটি সুস্থ হতে কতদিন লেগেছিল? (যদি  জানা না থাকে 98) (How long did it take for the child to completely recover?).");
             txtDDurReco.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtDDurReco.getText().toString().length()==0 ? "1" : txtDDurReco.getText().toString()) < 1 || Integer.valueOf(txtDDurReco.getText().toString().length()==0 ? "98" : txtDDurReco.getText().toString()) > 98)
           {
             Connection.MessageBox(DiarrhoeaCase .this, "Value should be between 1 and 98(শিশুটি সুস্থ হতে কতদিন লেগেছিল? (যদি  জানা না থাকে 98) (How long did it take for the child to completely recover?)).");
             txtDDurReco.requestFocus(); 
             return;	
           }
         
         else if(!rdoDInReco1.isChecked() & !rdoDInReco2.isChecked() & secDInReco.isShown())
           {
              Connection.MessageBox(DiarrhoeaCase .this, "Select anyone options from (শিশুটি যদি পুরোপুরি সুস্থ না হয়ে থাকে তাহলে কি হয়েছিল?  (In what way has the child’s recovery been incomplete?)).");
              rdoDInReco1.requestFocus();
              return;
           }
         else if(txtDInRecoOth.getText().toString().length()==0 & secDInRecoOth.isShown())
           {
             Connection.MessageBox(DiarrhoeaCase .this, "Required field: অন্যান্য উল্লেখ করুন (Others Specify).");
             txtDInRecoOth.requestFocus(); 
             return;	
           }
//         else if(txtDAboIll.getText().toString().length()==0 & secDAboIll.isShown())
//           {
//             Connection.MessageBox(DiarrhoeaCase .this, "Required field: মন্তব্যঃ ডায়রিয়া Remarks: Diarrhoea.");
//             txtDAboIll.requestFocus();
//             return;
//           }
 
         String SQL = "";
         RadioButton rb;

         DiarrhoeaCase_DataModel objSave = new DiarrhoeaCase_DataModel();
         objSave.setUNCode(txtUNCode.getText().toString());
         objSave.setStructureNo(txtStructureNo.getText().toString());
         objSave.setHouseholdSl(txtHouseholdSl.getText().toString());
         objSave.setVisitNo(txtVisitNo.getText().toString());
         objSave.setMemSl(txtMemSl.getText().toString());
         String[] d_rdogrpDWatStool = new String[] {"1","2","8"};
         objSave.setDWatStool(0);
         for (int i = 0; i < rdogrpDWatStool.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpDWatStool.getChildAt(i);
             if (rb.isChecked()) objSave.setDWatStool(Integer.valueOf(d_rdogrpDWatStool[i]));
         }

         objSave.setDDisEpi(Integer.valueOf(txtDDisEpi.getText().toString().length()==0?"0":txtDDisEpi.getText().toString()));
         String[] d_rdogrpStoolBlood = new String[] {"1","2","8"};
         objSave.setStoolBlood(0);
         for (int i = 0; i < rdogrpStoolBlood.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpStoolBlood.getChildAt(i);
             if (rb.isChecked()) objSave.setStoolBlood(Integer.valueOf(d_rdogrpStoolBlood[i]));
         }

         String[] d_rdogrpFeedORS = new String[] {"1","2","8"};
         objSave.setFeedORS(0);
         for (int i = 0; i < rdogrpFeedORS.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpFeedORS.getChildAt(i);
             if (rb.isChecked()) objSave.setFeedORS(Integer.valueOf(d_rdogrpFeedORS[i]));
         }

         String[] d_rdogrpDHCar = new String[] {"1","2","8"};
         objSave.setDHCar(0);
         for (int i = 0; i < rdogrpDHCar.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpDHCar.getChildAt(i);
             if (rb.isChecked()) objSave.setDHCar(Integer.valueOf(d_rdogrpDHCar[i]));
         }

         String[] d_rdogrpORSBefHCar = new String[] {"1","2","8"};
         objSave.setORSBefHCar(0);
         for (int i = 0; i < rdogrpORSBefHCar.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpORSBefHCar.getChildAt(i);
             if (rb.isChecked()) objSave.setORSBefHCar(Integer.valueOf(d_rdogrpORSBefHCar[i]));
         }

         String[] d_rdogrpDHC_PhyMBBS = new String[] {"1","2","8"};
         objSave.setDHC_PhyMBBS(0);
         for (int i = 0; i < rdogrpDHC_PhyMBBS.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpDHC_PhyMBBS.getChildAt(i);
             if (rb.isChecked()) objSave.setDHC_PhyMBBS(Integer.valueOf(d_rdogrpDHC_PhyMBBS[i]));
         }

         String[] d_rdogrpDHC_UnquaDoctor = new String[] {"1","2","8"};
         objSave.setDHC_UnquaDoctor(0);
         for (int i = 0; i < rdogrpDHC_UnquaDoctor.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpDHC_UnquaDoctor.getChildAt(i);
             if (rb.isChecked()) objSave.setDHC_UnquaDoctor(Integer.valueOf(d_rdogrpDHC_UnquaDoctor[i]));
         }

         String[] d_rdogrpDHC_Para = new String[] {"1","2","8"};
         objSave.setDHC_Para(0);
         for (int i = 0; i < rdogrpDHC_Para.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpDHC_Para.getChildAt(i);
             if (rb.isChecked()) objSave.setDHC_Para(Integer.valueOf(d_rdogrpDHC_Para[i]));
         }

         String[] d_rdogrpDHC_Com = new String[] {"1","2","8"};
         objSave.setDHC_Com(0);
         for (int i = 0; i < rdogrpDHC_Com.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpDHC_Com.getChildAt(i);
             if (rb.isChecked()) objSave.setDHC_Com(Integer.valueOf(d_rdogrpDHC_Com[i]));
         }

         String[] d_rdogrpDHC_Pha = new String[] {"1","2","8"};
         objSave.setDHC_Pha(0);
         for (int i = 0; i < rdogrpDHC_Pha.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpDHC_Pha.getChildAt(i);
             if (rb.isChecked()) objSave.setDHC_Pha(Integer.valueOf(d_rdogrpDHC_Pha[i]));
         }

         String[] d_rdogrpDHC_Hompath = new String[] {"1","2","8"};
         objSave.setDHC_Hompath(0);
         for (int i = 0; i < rdogrpDHC_Hompath.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpDHC_Hompath.getChildAt(i);
             if (rb.isChecked()) objSave.setDHC_Hompath(Integer.valueOf(d_rdogrpDHC_Hompath[i]));
         }

         String[] d_rdogrpDHC_TrHeal = new String[] {"1","2","8"};
         objSave.setDHC_TrHeal(0);
         for (int i = 0; i < rdogrpDHC_TrHeal.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpDHC_TrHeal.getChildAt(i);
             if (rb.isChecked()) objSave.setDHC_TrHeal(Integer.valueOf(d_rdogrpDHC_TrHeal[i]));
         }

         String[] d_rdogrpDHC_SpiHeal = new String[] {"1","2","8"};
         objSave.setDHC_SpiHeal(0);
         for (int i = 0; i < rdogrpDHC_SpiHeal.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpDHC_SpiHeal.getChildAt(i);
             if (rb.isChecked()) objSave.setDHC_SpiHeal(Integer.valueOf(d_rdogrpDHC_SpiHeal[i]));
         }

         String[] d_rdogrpDHC_Oth = new String[] {"1","2","8"};
         objSave.setDHC_Oth(0);
         for (int i = 0; i < rdogrpDHC_Oth.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpDHC_Oth.getChildAt(i);
             if (rb.isChecked()) objSave.setDHC_Oth(Integer.valueOf(d_rdogrpDHC_Oth[i]));
         }

         objSave.setDHC_OthName(txtDHC_OthName.getText().toString());
         String[] d_rdogrpDDSHOPD = new String[] {"1","2","8"};
         objSave.setDDSHOPD(0);
         for (int i = 0; i < rdogrpDDSHOPD.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpDDSHOPD.getChildAt(i);
             if (rb.isChecked()) objSave.setDDSHOPD(Integer.valueOf(d_rdogrpDDSHOPD[i]));
         }

         String[] d_rdogrpDSSFOPD = new String[] {"1","2","8"};
         objSave.setDSSFOPD(0);
         for (int i = 0; i < rdogrpDSSFOPD.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpDSSFOPD.getChildAt(i);
             if (rb.isChecked()) objSave.setDSSFOPD(Integer.valueOf(d_rdogrpDSSFOPD[i]));
         }

         String[] d_rdogrpDAdmHos = new String[] {"1","2","8"};
         objSave.setDAdmHos(0);
         for (int i = 0; i < rdogrpDAdmHos.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpDAdmHos.getChildAt(i);
             if (rb.isChecked()) objSave.setDAdmHos(Integer.valueOf(d_rdogrpDAdmHos[i]));
         }

         objSave.setDIlBeHosAdm(Integer.valueOf(txtDIlBeHosAdm.getText().toString().length()==0?"0":txtDIlBeHosAdm.getText().toString()));
         objSave.setDHosNam(Integer.valueOf(spnDHosNam.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnDHosNam.getSelectedItem().toString(), "-")));
         objSave.setDHosNamOth(txtDHosNamOth.getText().toString());
         objSave.setDHosNam2(Integer.valueOf(spnDHosNam2.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnDHosNam2.getSelectedItem().toString(), "-")));
         objSave.setDHosNamOth2(txtDHosNamOth2.getText().toString());
         objSave.setDHosNam3(Integer.valueOf(spnDHosNam3.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnDHosNam3.getSelectedItem().toString(), "-")));
         objSave.setDHosNamOth3(txtDHosNamOth3.getText().toString());
         String[] d_rdogrpDReco = new String[] {"1","2","8"};
         objSave.setDReco(0);
         for (int i = 0; i < rdogrpDReco.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpDReco.getChildAt(i);
             if (rb.isChecked()) objSave.setDReco(Integer.valueOf(d_rdogrpDReco[i]));
         }

         objSave.setDDurReco(Integer.valueOf(txtDDurReco.getText().toString().length()==0?"0":txtDDurReco.getText().toString()));
         String[] d_rdogrpDInReco = new String[] {"1","2"};
         objSave.setDInReco(0);
         for (int i = 0; i < rdogrpDInReco.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpDInReco.getChildAt(i);
             if (rb.isChecked()) objSave.setDInReco(Integer.valueOf(d_rdogrpDInReco[i]));
         }

         objSave.setDInRecoOth(txtDInRecoOth.getText().toString());
         objSave.setDAboIll(txtDAboIll.getText().toString());
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

             Connection.MessageBox(DiarrhoeaCase .this, "Saved Successfully");
         }
         else{
             Connection.MessageBox(DiarrhoeaCase .this, status);
             return;
         }
     }
     catch(Exception  e)
     {
         Connection.MessageBox(DiarrhoeaCase .this, e.getMessage());
         return;
     }
 }

 private void DataSearch(String UNCode, String StructureNo, String HouseholdSl, String VisitNo, String MemSl)
     {
       try
        {
     
           RadioButton rb;
           DiarrhoeaCase_DataModel d = new DiarrhoeaCase_DataModel();
           String SQL = "Select * from "+ TableName +"  Where UNCode='"+ UNCode +"' and StructureNo='"+ StructureNo +"' and HouseholdSl='"+ HouseholdSl +"' and VisitNo='"+ VisitNo +"' and MemSl='"+ MemSl +"'";
           List<DiarrhoeaCase_DataModel> data = d.SelectAll(this, SQL);
           for(DiarrhoeaCase_DataModel item : data){
             txtUNCode.setText(item.getUNCode());
             txtStructureNo.setText(item.getStructureNo());
             txtHouseholdSl.setText(item.getHouseholdSl());
             txtVisitNo.setText(item.getVisitNo());
             txtMemSl.setText(item.getMemSl());
             String[] d_rdogrpDWatStool = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpDWatStool.length; i++)
             {
                 if (String.valueOf(item.getDWatStool()).equals(String.valueOf(d_rdogrpDWatStool[i])))
                 {
                     rb = (RadioButton)rdogrpDWatStool.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtDDisEpi.setText(String.valueOf(item.getDDisEpi()));
             String[] d_rdogrpStoolBlood = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpStoolBlood.length; i++)
             {
                 if (String.valueOf(item.getStoolBlood()).equals(String.valueOf(d_rdogrpStoolBlood[i])))
                 {
                     rb = (RadioButton)rdogrpStoolBlood.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpFeedORS = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpFeedORS.length; i++)
             {
                 if (String.valueOf(item.getFeedORS()).equals(String.valueOf(d_rdogrpFeedORS[i])))
                 {
                     rb = (RadioButton)rdogrpFeedORS.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpDHCar = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpDHCar.length; i++)
             {
                 if (String.valueOf(item.getDHCar()).equals(String.valueOf(d_rdogrpDHCar[i])))
                 {
                     rb = (RadioButton)rdogrpDHCar.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpORSBefHCar = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpORSBefHCar.length; i++)
             {
                 if (String.valueOf(item.getORSBefHCar()).equals(String.valueOf(d_rdogrpORSBefHCar[i])))
                 {
                     rb = (RadioButton)rdogrpORSBefHCar.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpDHC_PhyMBBS = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpDHC_PhyMBBS.length; i++)
             {
                 if (String.valueOf(item.getDHC_PhyMBBS()).equals(String.valueOf(d_rdogrpDHC_PhyMBBS[i])))
                 {
                     rb = (RadioButton)rdogrpDHC_PhyMBBS.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpDHC_UnquaDoctor = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpDHC_UnquaDoctor.length; i++)
             {
                 if (String.valueOf(item.getDHC_UnquaDoctor()).equals(String.valueOf(d_rdogrpDHC_UnquaDoctor[i])))
                 {
                     rb = (RadioButton)rdogrpDHC_UnquaDoctor.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpDHC_Para = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpDHC_Para.length; i++)
             {
                 if (String.valueOf(item.getDHC_Para()).equals(String.valueOf(d_rdogrpDHC_Para[i])))
                 {
                     rb = (RadioButton)rdogrpDHC_Para.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpDHC_Com = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpDHC_Com.length; i++)
             {
                 if (String.valueOf(item.getDHC_Com()).equals(String.valueOf(d_rdogrpDHC_Com[i])))
                 {
                     rb = (RadioButton)rdogrpDHC_Com.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpDHC_Pha = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpDHC_Pha.length; i++)
             {
                 if (String.valueOf(item.getDHC_Pha()).equals(String.valueOf(d_rdogrpDHC_Pha[i])))
                 {
                     rb = (RadioButton)rdogrpDHC_Pha.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpDHC_Hompath = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpDHC_Hompath.length; i++)
             {
                 if (String.valueOf(item.getDHC_Hompath()).equals(String.valueOf(d_rdogrpDHC_Hompath[i])))
                 {
                     rb = (RadioButton)rdogrpDHC_Hompath.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpDHC_TrHeal = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpDHC_TrHeal.length; i++)
             {
                 if (String.valueOf(item.getDHC_TrHeal()).equals(String.valueOf(d_rdogrpDHC_TrHeal[i])))
                 {
                     rb = (RadioButton)rdogrpDHC_TrHeal.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpDHC_SpiHeal = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpDHC_SpiHeal.length; i++)
             {
                 if (String.valueOf(item.getDHC_SpiHeal()).equals(String.valueOf(d_rdogrpDHC_SpiHeal[i])))
                 {
                     rb = (RadioButton)rdogrpDHC_SpiHeal.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpDHC_Oth = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpDHC_Oth.length; i++)
             {
                 if (String.valueOf(item.getDHC_Oth()).equals(String.valueOf(d_rdogrpDHC_Oth[i])))
                 {
                     rb = (RadioButton)rdogrpDHC_Oth.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtDHC_OthName.setText(item.getDHC_OthName());
             String[] d_rdogrpDDSHOPD = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpDDSHOPD.length; i++)
             {
                 if (String.valueOf(item.getDDSHOPD()).equals(String.valueOf(d_rdogrpDDSHOPD[i])))
                 {
                     rb = (RadioButton)rdogrpDDSHOPD.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpDSSFOPD = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpDSSFOPD.length; i++)
             {
                 if (String.valueOf(item.getDSSFOPD()).equals(String.valueOf(d_rdogrpDSSFOPD[i])))
                 {
                     rb = (RadioButton)rdogrpDSSFOPD.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpDAdmHos = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpDAdmHos.length; i++)
             {
                 if (String.valueOf(item.getDAdmHos()).equals(String.valueOf(d_rdogrpDAdmHos[i])))
                 {
                     rb = (RadioButton)rdogrpDAdmHos.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtDIlBeHosAdm.setText(String.valueOf(item.getDIlBeHosAdm()));
             spnDHosNam.setSelection(Global.SpinnerItemPositionAnyLength(spnDHosNam, String.valueOf(item.getDHosNam())));
             txtDHosNamOth.setText(item.getDHosNamOth());
             spnDHosNam2.setSelection(Global.SpinnerItemPositionAnyLength(spnDHosNam2, String.valueOf(item.getDHosNam2())));
             txtDHosNamOth2.setText(item.getDHosNamOth2());
             spnDHosNam3.setSelection(Global.SpinnerItemPositionAnyLength(spnDHosNam3, String.valueOf(item.getDHosNam3())));
             txtDHosNamOth3.setText(item.getDHosNamOth3());
             String[] d_rdogrpDReco = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpDReco.length; i++)
             {
                 if (String.valueOf(item.getDReco()).equals(String.valueOf(d_rdogrpDReco[i])))
                 {
                     rb = (RadioButton)rdogrpDReco.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtDDurReco.setText(String.valueOf(item.getDDurReco()));
             String[] d_rdogrpDInReco = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpDInReco.length; i++)
             {
                 if (String.valueOf(item.getDInReco()).equals(String.valueOf(d_rdogrpDInReco[i])))
                 {
                     rb = (RadioButton)rdogrpDInReco.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtDInRecoOth.setText(item.getDInRecoOth());
             txtDAboIll.setText(item.getDAboIll());
           }
        }
        catch(Exception  e)
        {
            Connection.MessageBox(DiarrhoeaCase .this, e.getMessage());
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