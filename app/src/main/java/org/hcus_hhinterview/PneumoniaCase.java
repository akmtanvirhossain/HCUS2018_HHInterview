
 package org.hcus_hhinterview;


 //Android Manifest Code
 //<activity android:name=".PneumoniaCase" android:label="PneumoniaCase" />
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
 import data_model.PneumoniaCase_DataModel;

 public class PneumoniaCase extends Activity {
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
         LinearLayout secPneumoniaCaseLabel;
         View linePneumoniaCaseLabel;
         LinearLayout secPDSign;
         View linePDSign;
         TextView VlblPDSign;
         RadioGroup rdogrpPDSign;
         
         RadioButton rdoPDSign1;
         RadioButton rdoPDSign2;
         RadioButton rdoPDSign3;
         LinearLayout secPEpiIlness;
         View linePEpiIlness;
         TextView VlblPEpiIlness;
         EditText txtPEpiIlness;
         LinearLayout secPFever;
         View linePFever;
         TextView VlblPFever;
         RadioGroup rdogrpPFever;
         
         RadioButton rdoPFever1;
         RadioButton rdoPFever2;
         RadioButton rdoPFever3;
         LinearLayout secPDurFever;
         View linePDurFever;
         TextView VlblPDurFever;
         EditText txtPDurFever;
         LinearLayout secPCough;
         View linePCough;
         TextView VlblPCough;
         RadioGroup rdogrpPCough;
         
         RadioButton rdoPCough1;
         RadioButton rdoPCough2;
         RadioButton rdoPCough3;
         LinearLayout secPDurCough;
         View linePDurCough;
         TextView VlblPDurCough;
         EditText txtPDurCough;
         LinearLayout secPDifBrea;
         View linePDifBrea;
         TextView VlblPDifBrea;
         RadioGroup rdogrpPDifBrea;
         
         RadioButton rdoPDifBrea1;
         RadioButton rdoPDifBrea2;
         RadioButton rdoPDifBrea3;
         LinearLayout secPDurDifBrea;
         View linePDurDifBrea;
         TextView VlblPDurDifBrea;
         EditText txtPDurDifBrea;
         LinearLayout secPTurnBlue;
         View linePTurnBlue;
         TextView VlblPTurnBlue;
         RadioGroup rdogrpPTurnBlue;
         
         RadioButton rdoPTurnBlue1;
         RadioButton rdoPTurnBlue2;
         RadioButton rdoPTurnBlue3;
         LinearLayout secPDurTurnBlue;
         View linePDurTurnBlue;
         TextView VlblPDurTurnBlue;
         EditText txtPDurTurnBlue;
         LinearLayout secPBreatNois;
         View linePBreatNois;
         TextView VlblPBreatNois;
         RadioGroup rdogrpPBreatNois;
         
         RadioButton rdoPBreatNois1;
         RadioButton rdoPBreatNois2;
         RadioButton rdoPBreatNois3;
         LinearLayout secPDurBreatNois;
         View linePDurBreatNois;
         TextView VlblPDurBreatNois;
         EditText txtPDurBreatNois;
         LinearLayout secPLethargy;
         View linePLethargy;
         TextView VlblPLethargy;
         Spinner spnPLethargy;
         LinearLayout secPDurLethargy;
         View linePDurLethargy;
         TextView VlblPDurLethargy;
         EditText txtPDurLethargy;
         LinearLayout secPUnDriBfeed;
         View linePUnDriBfeed;
         TextView VlblPUnDriBfeed;
         Spinner spnPUnDriBfeed;
         LinearLayout secPDurUnDriBfeed;
         View linePDurUnDriBfeed;
         TextView VlblPDurUnDriBfeed;
         EditText txtPDurUnDriBfeed;
         LinearLayout secPVomit;
         View linePVomit;
         TextView VlblPVomit;
         RadioGroup rdogrpPVomit;
         
         RadioButton rdoPVomit1;
         RadioButton rdoPVomit2;
         RadioButton rdoPVomit3;
         LinearLayout secPConv;
         View linePConv;
         TextView VlblPConv;
         RadioGroup rdogrpPConv;
         
         RadioButton rdoPConv1;
         RadioButton rdoPConv2;
         RadioButton rdoPConv3;
         LinearLayout secPUpRolEye;
         View linePUpRolEye;
         TextView VlblPUpRolEye;
         RadioGroup rdogrpPUpRolEye;
         
         RadioButton rdoPUpRolEye1;
         RadioButton rdoPUpRolEye2;
         RadioButton rdoPUpRolEye3;
         LinearLayout secPRigJaw;
         View linePRigJaw;
         TextView VlblPRigJaw;
         RadioGroup rdogrpPRigJaw;
         
         RadioButton rdoPRigJaw1;
         RadioButton rdoPRigJaw2;
         RadioButton rdoPRigJaw3;
         LinearLayout secPRigLim;
         View linePRigLim;
         TextView VlblPRigLim;
         RadioGroup rdogrpPRigLim;
         
         RadioButton rdoPRigLim1;
         RadioButton rdoPRigLim2;
         RadioButton rdoPRigLim3;
         LinearLayout secPDurConv;
         View linePDurConv;
         TextView VlblPDurConv;
         Spinner spnPDurConv;
         LinearLayout secPUncons;
         View linePUncons;
         TextView VlblPUncons;
         RadioGroup rdogrpPUncons;
         
         RadioButton rdoPUncons1;
         RadioButton rdoPUncons2;
         RadioButton rdoPUncons3;
         LinearLayout secPDurUncons;
         View linePDurUncons;
         TextView VlblPDurUncons;
         Spinner spnPDurUncons;
         LinearLayout secPIlHCar;
         View linePIlHCar;
         TextView VlblPIlHCar;
         RadioGroup rdogrpPIlHCar;
         
         RadioButton rdoPIlHCar1;
         RadioButton rdoPIlHCar2;
         RadioButton rdoPIlHCar3;
         LinearLayout secPHCarTypLabel;
         View linePHCarTypLabel;
         LinearLayout secPHC_PhyMBBS;
         View linePHC_PhyMBBS;
         TextView VlblPHC_PhyMBBS;
         RadioGroup rdogrpPHC_PhyMBBS;
         
         RadioButton rdoPHC_PhyMBBS1;
         RadioButton rdoPHC_PhyMBBS2;
         RadioButton rdoPHC_PhyMBBS3;
         LinearLayout secPHC_UnquaDoctor;
         View linePHC_UnquaDoctor;
         TextView VlblPHC_UnquaDoctor;
         RadioGroup rdogrpPHC_UnquaDoctor;
         
         RadioButton rdoPHC_UnquaDoctor1;
         RadioButton rdoPHC_UnquaDoctor2;
         RadioButton rdoPHC_UnquaDoctor3;
         LinearLayout secPHC_Para;
         View linePHC_Para;
         TextView VlblPHC_Para;
         RadioGroup rdogrpPHC_Para;
         
         RadioButton rdoPHC_Para1;
         RadioButton rdoPHC_Para2;
         RadioButton rdoPHC_Para3;
         LinearLayout secPHC_Com;
         View linePHC_Com;
         TextView VlblPHC_Com;
         RadioGroup rdogrpPHC_Com;
         
         RadioButton rdoPHC_Com1;
         RadioButton rdoPHC_Com2;
         RadioButton rdoPHC_Com3;
         LinearLayout secPHC_Pha;
         View linePHC_Pha;
         TextView VlblPHC_Pha;
         RadioGroup rdogrpPHC_Pha;
         
         RadioButton rdoPHC_Pha1;
         RadioButton rdoPHC_Pha2;
         RadioButton rdoPHC_Pha3;
         LinearLayout secHC_Hompath;
         View lineHC_Hompath;
         TextView VlblHC_Hompath;
         RadioGroup rdogrpHC_Hompath;
         
         RadioButton rdoHC_Hompath1;
         RadioButton rdoHC_Hompath2;
         RadioButton rdoHC_Hompath3;
         LinearLayout secPHC_TrHeal;
         View linePHC_TrHeal;
         TextView VlblPHC_TrHeal;
         RadioGroup rdogrpPHC_TrHeal;
         
         RadioButton rdoPHC_TrHeal1;
         RadioButton rdoPHC_TrHeal2;
         RadioButton rdoPHC_TrHeal3;
         LinearLayout secPHC_SpiHeal;
         View linePHC_SpiHeal;
         TextView VlblPHC_SpiHeal;
         RadioGroup rdogrpPHC_SpiHeal;
         
         RadioButton rdoPHC_SpiHeal1;
         RadioButton rdoPHC_SpiHeal2;
         RadioButton rdoPHC_SpiHeal3;
         LinearLayout secPHC_Oth;
         View linePHC_Oth;
         TextView VlblPHC_Oth;
         RadioGroup rdogrpPHC_Oth;
         
         RadioButton rdoPHC_Oth1;
         RadioButton rdoPHC_Oth2;
         RadioButton rdoPHC_Oth3;
         LinearLayout secPHC_OthName;
         View linePHC_OthName;
         TextView VlblPHC_OthName;
         EditText txtPHC_OthName;
         LinearLayout secPDSHOPD;
         View linePDSHOPD;
         TextView VlblPDSHOPD;
         RadioGroup rdogrpPDSHOPD;
         
         RadioButton rdoPDSHOPD1;
         RadioButton rdoPDSHOPD2;
         RadioButton rdoPDSHOPD3;
         LinearLayout secPSSFOPD;
         View linePSSFOPD;
         TextView VlblPSSFOPD;
         RadioGroup rdogrpPSSFOPD;
         
         RadioButton rdoPSSFOPD1;
         RadioButton rdoPSSFOPD2;
         RadioButton rdoPSSFOPD3;
         LinearLayout secPAdmHos;
         View linePAdmHos;
         TextView VlblPAdmHos;
         RadioGroup rdogrpPAdmHos;
         
         RadioButton rdoPAdmHos1;
         RadioButton rdoPAdmHos2;
         RadioButton rdoPAdmHos3;
         LinearLayout secPHosNamLabel;
         View linePHosNamLabel;
         LinearLayout secPHosNam;
         View linePHosNam;
         TextView VlblPHosNam;
         Spinner spnPHosNam;
         LinearLayout secPHosNamOth;
         View linePHosNamOth;
         TextView VlblPHosNamOth;
         EditText txtPHosNamOth;
         LinearLayout secPHosNam2;
         View linePHosNam2;
         TextView VlblPHosNam2;
         Spinner spnPHosNam2;
         LinearLayout secPHosNamOth2;
         View linePHosNamOth2;
         TextView VlblPHosNamOth2;
         EditText txtPHosNamOth2;
         LinearLayout secPHosNam3;
         View linePHosNam3;
         TextView VlblPHosNam3;
         Spinner spnPHosNam3;
         LinearLayout secPHosNamOth3;
         View linePHosNamOth3;
         TextView VlblPHosNamOth3;
         EditText txtPHosNamOth3;
         LinearLayout secPDtAdmHos;
         View linePDtAdmHos;
         TextView VlblPDtAdmHos;
         EditText dtpPDtAdmHos;
         LinearLayout secPAdmHosM;
         View linePAdmHosM;
         TextView VlblPAdmHosM;
         EditText txtPAdmHosM;
         LinearLayout secPDurIlBeHos;
         View linePDurIlBeHos;
         TextView VlblPDurIlBeHos;
         EditText txtPDurIlBeHos;
         LinearLayout secPDisDr;
         View linePDisDr;
         TextView VlblPDisDr;
         Spinner spnPDisDr;
         LinearLayout secPDisDrOth;
         View linePDisDrOth;
         TextView VlblPDisDrOth;
         EditText txtPDisDrOth;
         LinearLayout secPReco;
         View linePReco;
         TextView VlblPReco;
         RadioGroup rdogrpPReco;
         
         RadioButton rdoPReco1;
         RadioButton rdoPReco2;
         RadioButton rdoPReco3;
         LinearLayout secPDurReco;
         View linePDurReco;
         TextView VlblPDurReco;
         EditText txtPDurReco;
         LinearLayout secPAboIll;
         View linePAboIll;
         TextView VlblPAboIll;
         EditText txtPAboIll;

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
         setContentView(R.layout.pneumoniacase);
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

         TableName = "PneumoniaCase";

         //turnGPSOn();

         //GPS Location
         //FindLocation();
         // Double.toString(currentLatitude);
         // Double.toString(currentLongitude);
         lblHeading = (TextView)findViewById(R.id.lblHeading);

         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(PneumoniaCase.this);
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
         secPneumoniaCaseLabel=(LinearLayout)findViewById(R.id.secPneumoniaCaseLabel);
         linePneumoniaCaseLabel=(View)findViewById(R.id.linePneumoniaCaseLabel);
         secPDSign=(LinearLayout)findViewById(R.id.secPDSign);
         linePDSign=(View)findViewById(R.id.linePDSign);
         VlblPDSign = (TextView) findViewById(R.id.VlblPDSign);
         rdogrpPDSign = (RadioGroup) findViewById(R.id.rdogrpPDSign);


         txtUNCode.setText(UNCODE);
         txtStructureNo.setText(""+STRUCTURENO);
         txtHouseholdSl.setText(HOUSEHOLDSL);
         txtVisitNo.setText(VISITNO);
         txtMemSl.setText(MEMSL);


         rdoPDSign1 = (RadioButton) findViewById(R.id.rdoPDSign1);
         rdoPDSign2 = (RadioButton) findViewById(R.id.rdoPDSign2);
         rdoPDSign3 = (RadioButton) findViewById(R.id.rdoPDSign3);
         rdogrpPDSign.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpPDSign = new String[] {"1","2","8"};
             for (int i = 0; i < rdogrpPDSign.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpPDSign.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpPDSign[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secPEpiIlness.setVisibility(View.GONE);
                    linePEpiIlness.setVisibility(View.GONE);
                    txtPEpiIlness.setText("");
                    secPFever.setVisibility(View.GONE);
                    linePFever.setVisibility(View.GONE);
                    rdogrpPFever.clearCheck();
                    secPDurFever.setVisibility(View.GONE);
                    linePDurFever.setVisibility(View.GONE);
                    txtPDurFever.setText("");
                    secPCough.setVisibility(View.GONE);
                    linePCough.setVisibility(View.GONE);
                    rdogrpPCough.clearCheck();
                    secPDurCough.setVisibility(View.GONE);
                    linePDurCough.setVisibility(View.GONE);
                    txtPDurCough.setText("");
                    secPDifBrea.setVisibility(View.GONE);
                    linePDifBrea.setVisibility(View.GONE);
                    rdogrpPDifBrea.clearCheck();
                    secPDurDifBrea.setVisibility(View.GONE);
                    linePDurDifBrea.setVisibility(View.GONE);
                    txtPDurDifBrea.setText("");
                    secPTurnBlue.setVisibility(View.GONE);
                    linePTurnBlue.setVisibility(View.GONE);
                    rdogrpPTurnBlue.clearCheck();
                    secPDurTurnBlue.setVisibility(View.GONE);
                    linePDurTurnBlue.setVisibility(View.GONE);
                    txtPDurTurnBlue.setText("");
                    secPBreatNois.setVisibility(View.GONE);
                    linePBreatNois.setVisibility(View.GONE);
                    rdogrpPBreatNois.clearCheck();
                    secPDurBreatNois.setVisibility(View.GONE);
                    linePDurBreatNois.setVisibility(View.GONE);
                    txtPDurBreatNois.setText("");
                    secPLethargy.setVisibility(View.GONE);
                    linePLethargy.setVisibility(View.GONE);
                    spnPLethargy.setSelection(0);
                    secPDurLethargy.setVisibility(View.GONE);
                    linePDurLethargy.setVisibility(View.GONE);
                    txtPDurLethargy.setText("");
                    secPUnDriBfeed.setVisibility(View.GONE);
                    linePUnDriBfeed.setVisibility(View.GONE);
                    spnPUnDriBfeed.setSelection(0);
                    secPDurUnDriBfeed.setVisibility(View.GONE);
                    linePDurUnDriBfeed.setVisibility(View.GONE);
                    txtPDurUnDriBfeed.setText("");
                    secPVomit.setVisibility(View.GONE);
                    linePVomit.setVisibility(View.GONE);
                    rdogrpPVomit.clearCheck();
                    secPConv.setVisibility(View.GONE);
                    linePConv.setVisibility(View.GONE);
                    rdogrpPConv.clearCheck();
                    secPUpRolEye.setVisibility(View.GONE);
                    linePUpRolEye.setVisibility(View.GONE);
                    rdogrpPUpRolEye.clearCheck();
                    secPRigJaw.setVisibility(View.GONE);
                    linePRigJaw.setVisibility(View.GONE);
                    rdogrpPRigJaw.clearCheck();
                    secPRigLim.setVisibility(View.GONE);
                    linePRigLim.setVisibility(View.GONE);
                    rdogrpPRigLim.clearCheck();
                    secPDurConv.setVisibility(View.GONE);
                    linePDurConv.setVisibility(View.GONE);
                    spnPDurConv.setSelection(0);
                    secPUncons.setVisibility(View.GONE);
                    linePUncons.setVisibility(View.GONE);
                    rdogrpPUncons.clearCheck();
                    secPDurUncons.setVisibility(View.GONE);
                    linePDurUncons.setVisibility(View.GONE);
                    spnPDurUncons.setSelection(0);
                    secPIlHCar.setVisibility(View.GONE);
                    linePIlHCar.setVisibility(View.GONE);
                    rdogrpPIlHCar.clearCheck();
                    secPHCarTypLabel.setVisibility(View.GONE);
                    linePHCarTypLabel.setVisibility(View.GONE);
                    secPHC_PhyMBBS.setVisibility(View.GONE);
                    linePHC_PhyMBBS.setVisibility(View.GONE);
                    rdogrpPHC_PhyMBBS.clearCheck();
                    secPHC_UnquaDoctor.setVisibility(View.GONE);
                    linePHC_UnquaDoctor.setVisibility(View.GONE);
                    rdogrpPHC_UnquaDoctor.clearCheck();
                    secPHC_Para.setVisibility(View.GONE);
                    linePHC_Para.setVisibility(View.GONE);
                    rdogrpPHC_Para.clearCheck();
                    secPHC_Com.setVisibility(View.GONE);
                    linePHC_Com.setVisibility(View.GONE);
                    rdogrpPHC_Com.clearCheck();
                    secPHC_Pha.setVisibility(View.GONE);
                    linePHC_Pha.setVisibility(View.GONE);
                    rdogrpPHC_Pha.clearCheck();
                    secHC_Hompath.setVisibility(View.GONE);
                    lineHC_Hompath.setVisibility(View.GONE);
                    rdogrpHC_Hompath.clearCheck();
                    secPHC_TrHeal.setVisibility(View.GONE);
                    linePHC_TrHeal.setVisibility(View.GONE);
                    rdogrpPHC_TrHeal.clearCheck();
                    secPHC_SpiHeal.setVisibility(View.GONE);
                    linePHC_SpiHeal.setVisibility(View.GONE);
                    rdogrpPHC_SpiHeal.clearCheck();
                    secPHC_Oth.setVisibility(View.GONE);
                    linePHC_Oth.setVisibility(View.GONE);
                    rdogrpPHC_Oth.clearCheck();
                    secPHC_OthName.setVisibility(View.GONE);
                    linePHC_OthName.setVisibility(View.GONE);
                    txtPHC_OthName.setText("");
                    secPDSHOPD.setVisibility(View.GONE);
                    linePDSHOPD.setVisibility(View.GONE);
                    rdogrpPDSHOPD.clearCheck();
                    secPSSFOPD.setVisibility(View.GONE);
                    linePSSFOPD.setVisibility(View.GONE);
                    rdogrpPSSFOPD.clearCheck();
                    secPAdmHos.setVisibility(View.GONE);
                    linePAdmHos.setVisibility(View.GONE);
                    rdogrpPAdmHos.clearCheck();
                    secPHosNamLabel.setVisibility(View.GONE);
                    linePHosNamLabel.setVisibility(View.GONE);
                    secPHosNam.setVisibility(View.GONE);
                    linePHosNam.setVisibility(View.GONE);
                    spnPHosNam.setSelection(0);
                    secPHosNamOth.setVisibility(View.GONE);
                    linePHosNamOth.setVisibility(View.GONE);
                    txtPHosNamOth.setText("");
                    secPHosNam2.setVisibility(View.GONE);
                    linePHosNam2.setVisibility(View.GONE);
                    spnPHosNam2.setSelection(0);
                    secPHosNamOth2.setVisibility(View.GONE);
                    linePHosNamOth2.setVisibility(View.GONE);
                    txtPHosNamOth2.setText("");
                    secPHosNam3.setVisibility(View.GONE);
                    linePHosNam3.setVisibility(View.GONE);
                    spnPHosNam3.setSelection(0);
                    secPHosNamOth3.setVisibility(View.GONE);
                    linePHosNamOth3.setVisibility(View.GONE);
                    txtPHosNamOth3.setText("");
                    secPDtAdmHos.setVisibility(View.GONE);
                    linePDtAdmHos.setVisibility(View.GONE);
                    dtpPDtAdmHos.setText("");
                    secPAdmHosM.setVisibility(View.GONE);
                    linePAdmHosM.setVisibility(View.GONE);
                    txtPAdmHosM.setText("");
                    secPDurIlBeHos.setVisibility(View.GONE);
                    linePDurIlBeHos.setVisibility(View.GONE);
                    txtPDurIlBeHos.setText("");
                    secPDisDr.setVisibility(View.GONE);
                    linePDisDr.setVisibility(View.GONE);
                    spnPDisDr.setSelection(0);
                    secPDisDrOth.setVisibility(View.GONE);
                    linePDisDrOth.setVisibility(View.GONE);
                    txtPDisDrOth.setText("");
                    secPReco.setVisibility(View.GONE);
                    linePReco.setVisibility(View.GONE);
                    rdogrpPReco.clearCheck();
                    secPDurReco.setVisibility(View.GONE);
                    linePDurReco.setVisibility(View.GONE);
                    txtPDurReco.setText("");
                    secPAboIll.setVisibility(View.GONE);
                    linePAboIll.setVisibility(View.GONE);
                    txtPAboIll.setText("");
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secPEpiIlness.setVisibility(View.GONE);
                    linePEpiIlness.setVisibility(View.GONE);
                    txtPEpiIlness.setText("");
                    secPFever.setVisibility(View.GONE);
                    linePFever.setVisibility(View.GONE);
                    rdogrpPFever.clearCheck();
                    secPDurFever.setVisibility(View.GONE);
                    linePDurFever.setVisibility(View.GONE);
                    txtPDurFever.setText("");
                    secPCough.setVisibility(View.GONE);
                    linePCough.setVisibility(View.GONE);
                    rdogrpPCough.clearCheck();
                    secPDurCough.setVisibility(View.GONE);
                    linePDurCough.setVisibility(View.GONE);
                    txtPDurCough.setText("");
                    secPDifBrea.setVisibility(View.GONE);
                    linePDifBrea.setVisibility(View.GONE);
                    rdogrpPDifBrea.clearCheck();
                    secPDurDifBrea.setVisibility(View.GONE);
                    linePDurDifBrea.setVisibility(View.GONE);
                    txtPDurDifBrea.setText("");
                    secPTurnBlue.setVisibility(View.GONE);
                    linePTurnBlue.setVisibility(View.GONE);
                    rdogrpPTurnBlue.clearCheck();
                    secPDurTurnBlue.setVisibility(View.GONE);
                    linePDurTurnBlue.setVisibility(View.GONE);
                    txtPDurTurnBlue.setText("");
                    secPBreatNois.setVisibility(View.GONE);
                    linePBreatNois.setVisibility(View.GONE);
                    rdogrpPBreatNois.clearCheck();
                    secPDurBreatNois.setVisibility(View.GONE);
                    linePDurBreatNois.setVisibility(View.GONE);
                    txtPDurBreatNois.setText("");
                    secPLethargy.setVisibility(View.GONE);
                    linePLethargy.setVisibility(View.GONE);
                    spnPLethargy.setSelection(0);
                    secPDurLethargy.setVisibility(View.GONE);
                    linePDurLethargy.setVisibility(View.GONE);
                    txtPDurLethargy.setText("");
                    secPUnDriBfeed.setVisibility(View.GONE);
                    linePUnDriBfeed.setVisibility(View.GONE);
                    spnPUnDriBfeed.setSelection(0);
                    secPDurUnDriBfeed.setVisibility(View.GONE);
                    linePDurUnDriBfeed.setVisibility(View.GONE);
                    txtPDurUnDriBfeed.setText("");
                    secPVomit.setVisibility(View.GONE);
                    linePVomit.setVisibility(View.GONE);
                    rdogrpPVomit.clearCheck();
                    secPConv.setVisibility(View.GONE);
                    linePConv.setVisibility(View.GONE);
                    rdogrpPConv.clearCheck();
                    secPUpRolEye.setVisibility(View.GONE);
                    linePUpRolEye.setVisibility(View.GONE);
                    rdogrpPUpRolEye.clearCheck();
                    secPRigJaw.setVisibility(View.GONE);
                    linePRigJaw.setVisibility(View.GONE);
                    rdogrpPRigJaw.clearCheck();
                    secPRigLim.setVisibility(View.GONE);
                    linePRigLim.setVisibility(View.GONE);
                    rdogrpPRigLim.clearCheck();
                    secPDurConv.setVisibility(View.GONE);
                    linePDurConv.setVisibility(View.GONE);
                    spnPDurConv.setSelection(0);
                    secPUncons.setVisibility(View.GONE);
                    linePUncons.setVisibility(View.GONE);
                    rdogrpPUncons.clearCheck();
                    secPDurUncons.setVisibility(View.GONE);
                    linePDurUncons.setVisibility(View.GONE);
                    spnPDurUncons.setSelection(0);
                    secPIlHCar.setVisibility(View.GONE);
                    linePIlHCar.setVisibility(View.GONE);
                    rdogrpPIlHCar.clearCheck();
                    secPHCarTypLabel.setVisibility(View.GONE);
                    linePHCarTypLabel.setVisibility(View.GONE);
                    secPHC_PhyMBBS.setVisibility(View.GONE);
                    linePHC_PhyMBBS.setVisibility(View.GONE);
                    rdogrpPHC_PhyMBBS.clearCheck();
                    secPHC_UnquaDoctor.setVisibility(View.GONE);
                    linePHC_UnquaDoctor.setVisibility(View.GONE);
                    rdogrpPHC_UnquaDoctor.clearCheck();
                    secPHC_Para.setVisibility(View.GONE);
                    linePHC_Para.setVisibility(View.GONE);
                    rdogrpPHC_Para.clearCheck();
                    secPHC_Com.setVisibility(View.GONE);
                    linePHC_Com.setVisibility(View.GONE);
                    rdogrpPHC_Com.clearCheck();
                    secPHC_Pha.setVisibility(View.GONE);
                    linePHC_Pha.setVisibility(View.GONE);
                    rdogrpPHC_Pha.clearCheck();
                    secHC_Hompath.setVisibility(View.GONE);
                    lineHC_Hompath.setVisibility(View.GONE);
                    rdogrpHC_Hompath.clearCheck();
                    secPHC_TrHeal.setVisibility(View.GONE);
                    linePHC_TrHeal.setVisibility(View.GONE);
                    rdogrpPHC_TrHeal.clearCheck();
                    secPHC_SpiHeal.setVisibility(View.GONE);
                    linePHC_SpiHeal.setVisibility(View.GONE);
                    rdogrpPHC_SpiHeal.clearCheck();
                    secPHC_Oth.setVisibility(View.GONE);
                    linePHC_Oth.setVisibility(View.GONE);
                    rdogrpPHC_Oth.clearCheck();
                    secPHC_OthName.setVisibility(View.GONE);
                    linePHC_OthName.setVisibility(View.GONE);
                    txtPHC_OthName.setText("");
                    secPDSHOPD.setVisibility(View.GONE);
                    linePDSHOPD.setVisibility(View.GONE);
                    rdogrpPDSHOPD.clearCheck();
                    secPSSFOPD.setVisibility(View.GONE);
                    linePSSFOPD.setVisibility(View.GONE);
                    rdogrpPSSFOPD.clearCheck();
                    secPAdmHos.setVisibility(View.GONE);
                    linePAdmHos.setVisibility(View.GONE);
                    rdogrpPAdmHos.clearCheck();
                    secPHosNamLabel.setVisibility(View.GONE);
                    linePHosNamLabel.setVisibility(View.GONE);
                    secPHosNam.setVisibility(View.GONE);
                    linePHosNam.setVisibility(View.GONE);
                    spnPHosNam.setSelection(0);
                    secPHosNamOth.setVisibility(View.GONE);
                    linePHosNamOth.setVisibility(View.GONE);
                    txtPHosNamOth.setText("");
                    secPHosNam2.setVisibility(View.GONE);
                    linePHosNam2.setVisibility(View.GONE);
                    spnPHosNam2.setSelection(0);
                    secPHosNamOth2.setVisibility(View.GONE);
                    linePHosNamOth2.setVisibility(View.GONE);
                    txtPHosNamOth2.setText("");
                    secPHosNam3.setVisibility(View.GONE);
                    linePHosNam3.setVisibility(View.GONE);
                    spnPHosNam3.setSelection(0);
                    secPHosNamOth3.setVisibility(View.GONE);
                    linePHosNamOth3.setVisibility(View.GONE);
                    txtPHosNamOth3.setText("");
                    secPDtAdmHos.setVisibility(View.GONE);
                    linePDtAdmHos.setVisibility(View.GONE);
                    dtpPDtAdmHos.setText("");
                    secPAdmHosM.setVisibility(View.GONE);
                    linePAdmHosM.setVisibility(View.GONE);
                    txtPAdmHosM.setText("");
                    secPDurIlBeHos.setVisibility(View.GONE);
                    linePDurIlBeHos.setVisibility(View.GONE);
                    txtPDurIlBeHos.setText("");
                    secPDisDr.setVisibility(View.GONE);
                    linePDisDr.setVisibility(View.GONE);
                    spnPDisDr.setSelection(0);
                    secPDisDrOth.setVisibility(View.GONE);
                    linePDisDrOth.setVisibility(View.GONE);
                    txtPDisDrOth.setText("");
                    secPReco.setVisibility(View.GONE);
                    linePReco.setVisibility(View.GONE);
                    rdogrpPReco.clearCheck();
                    secPDurReco.setVisibility(View.GONE);
                    linePDurReco.setVisibility(View.GONE);
                    txtPDurReco.setText("");
                    secPAboIll.setVisibility(View.GONE);
                    linePAboIll.setVisibility(View.GONE);
                    txtPAboIll.setText("");
             }
             else
             {
                    secPEpiIlness.setVisibility(View.VISIBLE);
                    linePEpiIlness.setVisibility(View.VISIBLE);
                    secPFever.setVisibility(View.VISIBLE);
                    linePFever.setVisibility(View.VISIBLE);

                    secPCough.setVisibility(View.VISIBLE);
                    linePCough.setVisibility(View.VISIBLE);

                    secPDifBrea.setVisibility(View.VISIBLE);
                    linePDifBrea.setVisibility(View.VISIBLE);

                    secPTurnBlue.setVisibility(View.VISIBLE);
                    linePTurnBlue.setVisibility(View.VISIBLE);

                    secPBreatNois.setVisibility(View.VISIBLE);
                    linePBreatNois.setVisibility(View.VISIBLE);

                    secPLethargy.setVisibility(View.VISIBLE);
                    linePLethargy.setVisibility(View.VISIBLE);

                    secPUnDriBfeed.setVisibility(View.VISIBLE);
                    linePUnDriBfeed.setVisibility(View.VISIBLE);

                    secPVomit.setVisibility(View.VISIBLE);
                    linePVomit.setVisibility(View.VISIBLE);
                    secPConv.setVisibility(View.VISIBLE);
                    linePConv.setVisibility(View.VISIBLE);


                    secPUncons.setVisibility(View.VISIBLE);
                    linePUncons.setVisibility(View.VISIBLE);

                    secPIlHCar.setVisibility(View.VISIBLE);
                    linePIlHCar.setVisibility(View.VISIBLE);



                    secPDSHOPD.setVisibility(View.VISIBLE);
                    linePDSHOPD.setVisibility(View.VISIBLE);
                    secPSSFOPD.setVisibility(View.VISIBLE);
                    linePSSFOPD.setVisibility(View.VISIBLE);
                    secPAdmHos.setVisibility(View.VISIBLE);
                    linePAdmHos.setVisibility(View.VISIBLE);
                    secPHosNamLabel.setVisibility(View.VISIBLE);
                    linePHosNamLabel.setVisibility(View.VISIBLE);
                    secPHosNam.setVisibility(View.VISIBLE);
                    linePHosNam.setVisibility(View.VISIBLE);

                    secPHosNam2.setVisibility(View.VISIBLE);
                    linePHosNam2.setVisibility(View.VISIBLE);

                    secPHosNam3.setVisibility(View.VISIBLE);
                    linePHosNam3.setVisibility(View.VISIBLE);

                    secPDtAdmHos.setVisibility(View.VISIBLE);
                    linePDtAdmHos.setVisibility(View.VISIBLE);
                    secPAdmHosM.setVisibility(View.VISIBLE);
                    linePAdmHosM.setVisibility(View.VISIBLE);
                    secPDurIlBeHos.setVisibility(View.VISIBLE);
                    linePDurIlBeHos.setVisibility(View.VISIBLE);
                    secPDisDr.setVisibility(View.VISIBLE);
                    linePDisDr.setVisibility(View.VISIBLE);

                    secPReco.setVisibility(View.VISIBLE);
                    linePReco.setVisibility(View.VISIBLE);
                    secPAboIll.setVisibility(View.VISIBLE);
                    linePAboIll.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secPEpiIlness=(LinearLayout)findViewById(R.id.secPEpiIlness);
         linePEpiIlness=(View)findViewById(R.id.linePEpiIlness);
         VlblPEpiIlness=(TextView) findViewById(R.id.VlblPEpiIlness);
         txtPEpiIlness=(EditText) findViewById(R.id.txtPEpiIlness);
         secPFever=(LinearLayout)findViewById(R.id.secPFever);
         linePFever=(View)findViewById(R.id.linePFever);
         VlblPFever = (TextView) findViewById(R.id.VlblPFever);
         rdogrpPFever = (RadioGroup) findViewById(R.id.rdogrpPFever);
         
         rdoPFever1 = (RadioButton) findViewById(R.id.rdoPFever1);
         rdoPFever2 = (RadioButton) findViewById(R.id.rdoPFever2);
         rdoPFever3 = (RadioButton) findViewById(R.id.rdoPFever3);
         rdogrpPFever.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpPFever = new String[] {"1","2","8"};
             for (int i = 0; i < rdogrpPFever.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpPFever.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpPFever[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secPDurFever.setVisibility(View.GONE);
                    linePDurFever.setVisibility(View.GONE);
                    txtPDurFever.setText("");
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secPDurFever.setVisibility(View.GONE);
                    linePDurFever.setVisibility(View.GONE);
                    txtPDurFever.setText("");
             }
             else if(rbData.equalsIgnoreCase("1"))
             {
                    secPDurFever.setVisibility(View.VISIBLE);
                    linePDurFever.setVisibility(View.VISIBLE);
             }
             else{
                 secPDurFever.setVisibility(View.GONE);
                 linePDurFever.setVisibility(View.GONE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secPDurFever=(LinearLayout)findViewById(R.id.secPDurFever);
         linePDurFever=(View)findViewById(R.id.linePDurFever);
         VlblPDurFever=(TextView) findViewById(R.id.VlblPDurFever);
         txtPDurFever=(EditText) findViewById(R.id.txtPDurFever);
         secPCough=(LinearLayout)findViewById(R.id.secPCough);
         linePCough=(View)findViewById(R.id.linePCough);
         VlblPCough = (TextView) findViewById(R.id.VlblPCough);
         rdogrpPCough = (RadioGroup) findViewById(R.id.rdogrpPCough);
         
         rdoPCough1 = (RadioButton) findViewById(R.id.rdoPCough1);
         rdoPCough2 = (RadioButton) findViewById(R.id.rdoPCough2);
         rdoPCough3 = (RadioButton) findViewById(R.id.rdoPCough3);
         rdogrpPCough.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpPCough = new String[] {"1","2","8"};
             for (int i = 0; i < rdogrpPCough.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpPCough.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpPCough[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secPDurCough.setVisibility(View.GONE);
                    linePDurCough.setVisibility(View.GONE);
                    txtPDurCough.setText("");
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secPDurCough.setVisibility(View.GONE);
                    linePDurCough.setVisibility(View.GONE);
                    txtPDurCough.setText("");
             }
             else if(rbData.equalsIgnoreCase("1"))
             {
                    secPDurCough.setVisibility(View.VISIBLE);
                    linePDurCough.setVisibility(View.VISIBLE);
             }
             else{
                 secPDurCough.setVisibility(View.GONE);
                 linePDurCough.setVisibility(View.GONE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secPDurCough=(LinearLayout)findViewById(R.id.secPDurCough);
         linePDurCough=(View)findViewById(R.id.linePDurCough);
         VlblPDurCough=(TextView) findViewById(R.id.VlblPDurCough);
         txtPDurCough=(EditText) findViewById(R.id.txtPDurCough);
         secPDifBrea=(LinearLayout)findViewById(R.id.secPDifBrea);
         linePDifBrea=(View)findViewById(R.id.linePDifBrea);
         VlblPDifBrea = (TextView) findViewById(R.id.VlblPDifBrea);
         rdogrpPDifBrea = (RadioGroup) findViewById(R.id.rdogrpPDifBrea);
         
         rdoPDifBrea1 = (RadioButton) findViewById(R.id.rdoPDifBrea1);
         rdoPDifBrea2 = (RadioButton) findViewById(R.id.rdoPDifBrea2);
         rdoPDifBrea3 = (RadioButton) findViewById(R.id.rdoPDifBrea3);
         rdogrpPDifBrea.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpPDifBrea = new String[] {"1","2","8"};
             for (int i = 0; i < rdogrpPDifBrea.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpPDifBrea.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpPDifBrea[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secPDurDifBrea.setVisibility(View.GONE);
                    linePDurDifBrea.setVisibility(View.GONE);
                    txtPDurDifBrea.setText("");
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secPDurDifBrea.setVisibility(View.GONE);
                    linePDurDifBrea.setVisibility(View.GONE);
                    txtPDurDifBrea.setText("");
             }
             else if(rbData.equalsIgnoreCase("1"))
             {
                    secPDurDifBrea.setVisibility(View.VISIBLE);
                    linePDurDifBrea.setVisibility(View.VISIBLE);
             }
             else{
                 secPDurDifBrea.setVisibility(View.GONE);
                 linePDurDifBrea.setVisibility(View.GONE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secPDurDifBrea=(LinearLayout)findViewById(R.id.secPDurDifBrea);
         linePDurDifBrea=(View)findViewById(R.id.linePDurDifBrea);
         VlblPDurDifBrea=(TextView) findViewById(R.id.VlblPDurDifBrea);
         txtPDurDifBrea=(EditText) findViewById(R.id.txtPDurDifBrea);
         secPTurnBlue=(LinearLayout)findViewById(R.id.secPTurnBlue);
         linePTurnBlue=(View)findViewById(R.id.linePTurnBlue);
         VlblPTurnBlue = (TextView) findViewById(R.id.VlblPTurnBlue);
         rdogrpPTurnBlue = (RadioGroup) findViewById(R.id.rdogrpPTurnBlue);
         
         rdoPTurnBlue1 = (RadioButton) findViewById(R.id.rdoPTurnBlue1);
         rdoPTurnBlue2 = (RadioButton) findViewById(R.id.rdoPTurnBlue2);
         rdoPTurnBlue3 = (RadioButton) findViewById(R.id.rdoPTurnBlue3);
         rdogrpPTurnBlue.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpPTurnBlue = new String[] {"1","2","8"};
             for (int i = 0; i < rdogrpPTurnBlue.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpPTurnBlue.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpPTurnBlue[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secPDurTurnBlue.setVisibility(View.GONE);
                    linePDurTurnBlue.setVisibility(View.GONE);
                    txtPDurTurnBlue.setText("");
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secPDurTurnBlue.setVisibility(View.GONE);
                    linePDurTurnBlue.setVisibility(View.GONE);
                    txtPDurTurnBlue.setText("");
             }
             else if(rbData.equalsIgnoreCase("1"))
             {
                    secPDurTurnBlue.setVisibility(View.VISIBLE);
                    linePDurTurnBlue.setVisibility(View.VISIBLE);
             }
             else{
                 secPDurTurnBlue.setVisibility(View.GONE);
                 linePDurTurnBlue.setVisibility(View.GONE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secPDurTurnBlue=(LinearLayout)findViewById(R.id.secPDurTurnBlue);
         linePDurTurnBlue=(View)findViewById(R.id.linePDurTurnBlue);
         VlblPDurTurnBlue=(TextView) findViewById(R.id.VlblPDurTurnBlue);
         txtPDurTurnBlue=(EditText) findViewById(R.id.txtPDurTurnBlue);
         secPBreatNois=(LinearLayout)findViewById(R.id.secPBreatNois);
         linePBreatNois=(View)findViewById(R.id.linePBreatNois);
         VlblPBreatNois = (TextView) findViewById(R.id.VlblPBreatNois);
         rdogrpPBreatNois = (RadioGroup) findViewById(R.id.rdogrpPBreatNois);
         
         rdoPBreatNois1 = (RadioButton) findViewById(R.id.rdoPBreatNois1);
         rdoPBreatNois2 = (RadioButton) findViewById(R.id.rdoPBreatNois2);
         rdoPBreatNois3 = (RadioButton) findViewById(R.id.rdoPBreatNois3);
         rdogrpPBreatNois.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpPBreatNois = new String[] {"1","2","8"};
             for (int i = 0; i < rdogrpPBreatNois.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpPBreatNois.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpPBreatNois[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secPDurBreatNois.setVisibility(View.GONE);
                    linePDurBreatNois.setVisibility(View.GONE);
                    txtPDurBreatNois.setText("");
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secPDurBreatNois.setVisibility(View.GONE);
                    linePDurBreatNois.setVisibility(View.GONE);
                    txtPDurBreatNois.setText("");
             }
             else if(rbData.equalsIgnoreCase("1"))
             {
                    secPDurBreatNois.setVisibility(View.VISIBLE);
                    linePDurBreatNois.setVisibility(View.VISIBLE);
             }
             else{
                 secPDurBreatNois.setVisibility(View.GONE);
                 linePDurBreatNois.setVisibility(View.GONE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secPDurBreatNois=(LinearLayout)findViewById(R.id.secPDurBreatNois);
         linePDurBreatNois=(View)findViewById(R.id.linePDurBreatNois);
         VlblPDurBreatNois=(TextView) findViewById(R.id.VlblPDurBreatNois);
         txtPDurBreatNois=(EditText) findViewById(R.id.txtPDurBreatNois);
         secPLethargy=(LinearLayout)findViewById(R.id.secPLethargy);
         linePLethargy=(View)findViewById(R.id.linePLethargy);
         VlblPLethargy=(TextView) findViewById(R.id.VlblPLethargy);
         spnPLethargy=(Spinner) findViewById(R.id.spnPLethargy);
         List<String> listPLethargy = new ArrayList<String>();
         
         listPLethargy.add("");
         listPLethargy.add("1-Yes");
         listPLethargy.add("2-No");
         listPLethargy.add("8-Don’t know");
         ArrayAdapter<String> adptrPLethargy= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listPLethargy);
         spnPLethargy.setAdapter(adptrPLethargy);

         spnPLethargy.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnPLethargy.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnPLethargy.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("2"))
                 {
                    secPDurLethargy.setVisibility(View.GONE);
                    linePDurLethargy.setVisibility(View.GONE);
                    txtPDurLethargy.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("8"))
                 {
                    secPDurLethargy.setVisibility(View.GONE);
                    linePDurLethargy.setVisibility(View.GONE);
                    txtPDurLethargy.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("1"))
                 {
                    secPDurLethargy.setVisibility(View.VISIBLE);
                    linePDurLethargy.setVisibility(View.VISIBLE);
                 }
                 else{
                     secPDurLethargy.setVisibility(View.GONE);
                     linePDurLethargy.setVisibility(View.GONE);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secPDurLethargy=(LinearLayout)findViewById(R.id.secPDurLethargy);
         linePDurLethargy=(View)findViewById(R.id.linePDurLethargy);
         VlblPDurLethargy=(TextView) findViewById(R.id.VlblPDurLethargy);
         txtPDurLethargy=(EditText) findViewById(R.id.txtPDurLethargy);
         secPUnDriBfeed=(LinearLayout)findViewById(R.id.secPUnDriBfeed);
         linePUnDriBfeed=(View)findViewById(R.id.linePUnDriBfeed);
         VlblPUnDriBfeed=(TextView) findViewById(R.id.VlblPUnDriBfeed);
         spnPUnDriBfeed=(Spinner) findViewById(R.id.spnPUnDriBfeed);
         List<String> listPUnDriBfeed = new ArrayList<String>();
         
         listPUnDriBfeed.add("");
         listPUnDriBfeed.add("1-Yes");
         listPUnDriBfeed.add("2-No");
         listPUnDriBfeed.add("8-Don’t know");
         listPUnDriBfeed.add("9-NA");

         ArrayAdapter<String> adptrPUnDriBfeed= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listPUnDriBfeed);
         spnPUnDriBfeed.setAdapter(adptrPUnDriBfeed);

         spnPUnDriBfeed.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnPUnDriBfeed.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnPUnDriBfeed.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("2"))
                 {
                    secPDurUnDriBfeed.setVisibility(View.GONE);
                    linePDurUnDriBfeed.setVisibility(View.GONE);
                    txtPDurUnDriBfeed.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("8"))
                 {
                    secPDurUnDriBfeed.setVisibility(View.GONE);
                    linePDurUnDriBfeed.setVisibility(View.GONE);
                    txtPDurUnDriBfeed.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("9"))
                 {
                    secPDurUnDriBfeed.setVisibility(View.GONE);
                    linePDurUnDriBfeed.setVisibility(View.GONE);
                    txtPDurUnDriBfeed.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("1"))
                 {
                    secPDurUnDriBfeed.setVisibility(View.VISIBLE);
                    linePDurUnDriBfeed.setVisibility(View.VISIBLE);
                 }
                 else{
                     secPDurUnDriBfeed.setVisibility(View.GONE);
                     linePDurUnDriBfeed.setVisibility(View.GONE);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secPDurUnDriBfeed=(LinearLayout)findViewById(R.id.secPDurUnDriBfeed);
         linePDurUnDriBfeed=(View)findViewById(R.id.linePDurUnDriBfeed);
         VlblPDurUnDriBfeed=(TextView) findViewById(R.id.VlblPDurUnDriBfeed);
         txtPDurUnDriBfeed=(EditText) findViewById(R.id.txtPDurUnDriBfeed);
         secPVomit=(LinearLayout)findViewById(R.id.secPVomit);
         linePVomit=(View)findViewById(R.id.linePVomit);
         VlblPVomit = (TextView) findViewById(R.id.VlblPVomit);
         rdogrpPVomit = (RadioGroup) findViewById(R.id.rdogrpPVomit);
         
         rdoPVomit1 = (RadioButton) findViewById(R.id.rdoPVomit1);
         rdoPVomit2 = (RadioButton) findViewById(R.id.rdoPVomit2);
         rdoPVomit3 = (RadioButton) findViewById(R.id.rdoPVomit3);
         secPConv=(LinearLayout)findViewById(R.id.secPConv);
         linePConv=(View)findViewById(R.id.linePConv);
         VlblPConv = (TextView) findViewById(R.id.VlblPConv);
         rdogrpPConv = (RadioGroup) findViewById(R.id.rdogrpPConv);
         
         rdoPConv1 = (RadioButton) findViewById(R.id.rdoPConv1);
         rdoPConv2 = (RadioButton) findViewById(R.id.rdoPConv2);
         rdoPConv3 = (RadioButton) findViewById(R.id.rdoPConv3);
         rdogrpPConv.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpPConv = new String[] {"1","2","8"};
             for (int i = 0; i < rdogrpPConv.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpPConv.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpPConv[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secPUpRolEye.setVisibility(View.GONE);
                    linePUpRolEye.setVisibility(View.GONE);
                    rdogrpPUpRolEye.clearCheck();
                    secPRigJaw.setVisibility(View.GONE);
                    linePRigJaw.setVisibility(View.GONE);
                    rdogrpPRigJaw.clearCheck();
                    secPRigLim.setVisibility(View.GONE);
                    linePRigLim.setVisibility(View.GONE);
                    rdogrpPRigLim.clearCheck();
                    secPDurConv.setVisibility(View.GONE);
                    linePDurConv.setVisibility(View.GONE);
                    spnPDurConv.setSelection(0);
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secPUpRolEye.setVisibility(View.GONE);
                    linePUpRolEye.setVisibility(View.GONE);
                    rdogrpPUpRolEye.clearCheck();
                    secPRigJaw.setVisibility(View.GONE);
                    linePRigJaw.setVisibility(View.GONE);
                    rdogrpPRigJaw.clearCheck();
                    secPRigLim.setVisibility(View.GONE);
                    linePRigLim.setVisibility(View.GONE);
                    rdogrpPRigLim.clearCheck();
                    secPDurConv.setVisibility(View.GONE);
                    linePDurConv.setVisibility(View.GONE);
                    spnPDurConv.setSelection(0);
             }
             else if(rbData.equalsIgnoreCase("1"))
             {
                    secPUpRolEye.setVisibility(View.VISIBLE);
                    linePUpRolEye.setVisibility(View.VISIBLE);
                    secPRigJaw.setVisibility(View.VISIBLE);
                    linePRigJaw.setVisibility(View.VISIBLE);
                    secPRigLim.setVisibility(View.VISIBLE);
                    linePRigLim.setVisibility(View.VISIBLE);
                    secPDurConv.setVisibility(View.VISIBLE);
                    linePDurConv.setVisibility(View.VISIBLE);
             }
             else{
                 secPUpRolEye.setVisibility(View.GONE);
                 linePUpRolEye.setVisibility(View.GONE);
                 rdogrpPUpRolEye.clearCheck();
                 secPRigJaw.setVisibility(View.GONE);
                 linePRigJaw.setVisibility(View.GONE);
                 rdogrpPRigJaw.clearCheck();
                 secPRigLim.setVisibility(View.GONE);
                 linePRigLim.setVisibility(View.GONE);
                 rdogrpPRigLim.clearCheck();
                 secPDurConv.setVisibility(View.GONE);
                 linePDurConv.setVisibility(View.GONE);
                 spnPDurConv.setSelection(0);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secPUpRolEye=(LinearLayout)findViewById(R.id.secPUpRolEye);
         linePUpRolEye=(View)findViewById(R.id.linePUpRolEye);
         VlblPUpRolEye = (TextView) findViewById(R.id.VlblPUpRolEye);
         rdogrpPUpRolEye = (RadioGroup) findViewById(R.id.rdogrpPUpRolEye);
         
         rdoPUpRolEye1 = (RadioButton) findViewById(R.id.rdoPUpRolEye1);
         rdoPUpRolEye2 = (RadioButton) findViewById(R.id.rdoPUpRolEye2);
         rdoPUpRolEye3 = (RadioButton) findViewById(R.id.rdoPUpRolEye3);
         secPRigJaw=(LinearLayout)findViewById(R.id.secPRigJaw);
         linePRigJaw=(View)findViewById(R.id.linePRigJaw);
         VlblPRigJaw = (TextView) findViewById(R.id.VlblPRigJaw);
         rdogrpPRigJaw = (RadioGroup) findViewById(R.id.rdogrpPRigJaw);
         
         rdoPRigJaw1 = (RadioButton) findViewById(R.id.rdoPRigJaw1);
         rdoPRigJaw2 = (RadioButton) findViewById(R.id.rdoPRigJaw2);
         rdoPRigJaw3 = (RadioButton) findViewById(R.id.rdoPRigJaw3);
         secPRigLim=(LinearLayout)findViewById(R.id.secPRigLim);
         linePRigLim=(View)findViewById(R.id.linePRigLim);
         VlblPRigLim = (TextView) findViewById(R.id.VlblPRigLim);
         rdogrpPRigLim = (RadioGroup) findViewById(R.id.rdogrpPRigLim);
         
         rdoPRigLim1 = (RadioButton) findViewById(R.id.rdoPRigLim1);
         rdoPRigLim2 = (RadioButton) findViewById(R.id.rdoPRigLim2);
         rdoPRigLim3 = (RadioButton) findViewById(R.id.rdoPRigLim3);
         secPDurConv=(LinearLayout)findViewById(R.id.secPDurConv);
         linePDurConv=(View)findViewById(R.id.linePDurConv);
         VlblPDurConv=(TextView) findViewById(R.id.VlblPDurConv);
         spnPDurConv=(Spinner) findViewById(R.id.spnPDurConv);
         List<String> listPDurConv = new ArrayList<String>();
         
         listPDurConv.add("");
         listPDurConv.add("1-(<5 minutes)");
         listPDurConv.add("2-(5-15 minutes)");
         listPDurConv.add("3-(15-30 minutes)");
         listPDurConv.add("4-(>30 minutes)");
         listPDurConv.add("8-Don’t know");
         listPDurConv.add("9-NA");
         ArrayAdapter<String> adptrPDurConv= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listPDurConv);
         spnPDurConv.setAdapter(adptrPDurConv);

         secPUncons=(LinearLayout)findViewById(R.id.secPUncons);
         linePUncons=(View)findViewById(R.id.linePUncons);
         VlblPUncons = (TextView) findViewById(R.id.VlblPUncons);
         rdogrpPUncons = (RadioGroup) findViewById(R.id.rdogrpPUncons);
         
         rdoPUncons1 = (RadioButton) findViewById(R.id.rdoPUncons1);
         rdoPUncons2 = (RadioButton) findViewById(R.id.rdoPUncons2);
         rdoPUncons3 = (RadioButton) findViewById(R.id.rdoPUncons3);
         rdogrpPUncons.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpPUncons = new String[] {"1","2","8"};
             for (int i = 0; i < rdogrpPUncons.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpPUncons.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpPUncons[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secPDurUncons.setVisibility(View.GONE);
                    linePDurUncons.setVisibility(View.GONE);
                    spnPDurUncons.setSelection(0);
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secPDurUncons.setVisibility(View.GONE);
                    linePDurUncons.setVisibility(View.GONE);
                    spnPDurUncons.setSelection(0);
             }
             else if(rbData.equalsIgnoreCase("1"))
             {
                    secPDurUncons.setVisibility(View.VISIBLE);
                    linePDurUncons.setVisibility(View.VISIBLE);
             }
             else{
                 secPDurUncons.setVisibility(View.GONE);
                 linePDurUncons.setVisibility(View.GONE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secPDurUncons=(LinearLayout)findViewById(R.id.secPDurUncons);
         linePDurUncons=(View)findViewById(R.id.linePDurUncons);
         VlblPDurUncons=(TextView) findViewById(R.id.VlblPDurUncons);
         spnPDurUncons=(Spinner) findViewById(R.id.spnPDurUncons);
         List<String> listPDurUncons = new ArrayList<String>();
         
         listPDurUncons.add("");
         listPDurUncons.add("1-(< than 1 hour)");
         listPDurUncons.add("2-(1-6 hours)");
         listPDurUncons.add("3-(7-24 hours)");
         listPDurUncons.add("4-More than 24 hours");
         listPDurUncons.add("8-Don’t know");
         listPDurUncons.add("9-NA");
         ArrayAdapter<String> adptrPDurUncons= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listPDurUncons);
         spnPDurUncons.setAdapter(adptrPDurUncons);

         secPIlHCar=(LinearLayout)findViewById(R.id.secPIlHCar);
         linePIlHCar=(View)findViewById(R.id.linePIlHCar);
         VlblPIlHCar = (TextView) findViewById(R.id.VlblPIlHCar);
         rdogrpPIlHCar = (RadioGroup) findViewById(R.id.rdogrpPIlHCar);
         
         rdoPIlHCar1 = (RadioButton) findViewById(R.id.rdoPIlHCar1);
         rdoPIlHCar2 = (RadioButton) findViewById(R.id.rdoPIlHCar2);
         rdoPIlHCar3 = (RadioButton) findViewById(R.id.rdoPIlHCar3);
         rdogrpPIlHCar.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpPIlHCar = new String[] {"1","2","8"};
             for (int i = 0; i < rdogrpPIlHCar.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpPIlHCar.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpPIlHCar[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secPHCarTypLabel.setVisibility(View.GONE);
                    linePHCarTypLabel.setVisibility(View.GONE);
                    secPHC_PhyMBBS.setVisibility(View.GONE);
                    linePHC_PhyMBBS.setVisibility(View.GONE);
                    rdogrpPHC_PhyMBBS.clearCheck();
                    secPHC_UnquaDoctor.setVisibility(View.GONE);
                    linePHC_UnquaDoctor.setVisibility(View.GONE);
                    rdogrpPHC_UnquaDoctor.clearCheck();
                    secPHC_Para.setVisibility(View.GONE);
                    linePHC_Para.setVisibility(View.GONE);
                    rdogrpPHC_Para.clearCheck();
                    secPHC_Com.setVisibility(View.GONE);
                    linePHC_Com.setVisibility(View.GONE);
                    rdogrpPHC_Com.clearCheck();
                    secPHC_Pha.setVisibility(View.GONE);
                    linePHC_Pha.setVisibility(View.GONE);
                    rdogrpPHC_Pha.clearCheck();
                    secHC_Hompath.setVisibility(View.GONE);
                    lineHC_Hompath.setVisibility(View.GONE);
                    rdogrpHC_Hompath.clearCheck();
                    secPHC_TrHeal.setVisibility(View.GONE);
                    linePHC_TrHeal.setVisibility(View.GONE);
                    rdogrpPHC_TrHeal.clearCheck();
                    secPHC_SpiHeal.setVisibility(View.GONE);
                    linePHC_SpiHeal.setVisibility(View.GONE);
                    rdogrpPHC_SpiHeal.clearCheck();
                    secPHC_Oth.setVisibility(View.GONE);
                    linePHC_Oth.setVisibility(View.GONE);
                    rdogrpPHC_Oth.clearCheck();
                    secPHC_OthName.setVisibility(View.GONE);
                    linePHC_OthName.setVisibility(View.GONE);
                    txtPHC_OthName.setText("");
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secPHCarTypLabel.setVisibility(View.GONE);
                    linePHCarTypLabel.setVisibility(View.GONE);
                    secPHC_PhyMBBS.setVisibility(View.GONE);
                    linePHC_PhyMBBS.setVisibility(View.GONE);
                    rdogrpPHC_PhyMBBS.clearCheck();
                    secPHC_UnquaDoctor.setVisibility(View.GONE);
                    linePHC_UnquaDoctor.setVisibility(View.GONE);
                    rdogrpPHC_UnquaDoctor.clearCheck();
                    secPHC_Para.setVisibility(View.GONE);
                    linePHC_Para.setVisibility(View.GONE);
                    rdogrpPHC_Para.clearCheck();
                    secPHC_Com.setVisibility(View.GONE);
                    linePHC_Com.setVisibility(View.GONE);
                    rdogrpPHC_Com.clearCheck();
                    secPHC_Pha.setVisibility(View.GONE);
                    linePHC_Pha.setVisibility(View.GONE);
                    rdogrpPHC_Pha.clearCheck();
                    secHC_Hompath.setVisibility(View.GONE);
                    lineHC_Hompath.setVisibility(View.GONE);
                    rdogrpHC_Hompath.clearCheck();
                    secPHC_TrHeal.setVisibility(View.GONE);
                    linePHC_TrHeal.setVisibility(View.GONE);
                    rdogrpPHC_TrHeal.clearCheck();
                    secPHC_SpiHeal.setVisibility(View.GONE);
                    linePHC_SpiHeal.setVisibility(View.GONE);
                    rdogrpPHC_SpiHeal.clearCheck();
                    secPHC_Oth.setVisibility(View.GONE);
                    linePHC_Oth.setVisibility(View.GONE);
                    rdogrpPHC_Oth.clearCheck();
                    secPHC_OthName.setVisibility(View.GONE);
                    linePHC_OthName.setVisibility(View.GONE);
                    txtPHC_OthName.setText("");
             }
             else if(rbData.equalsIgnoreCase("1"))
             {
                    secPHCarTypLabel.setVisibility(View.VISIBLE);
                    linePHCarTypLabel.setVisibility(View.VISIBLE);
                    secPHC_PhyMBBS.setVisibility(View.VISIBLE);
                    linePHC_PhyMBBS.setVisibility(View.VISIBLE);
                    secPHC_UnquaDoctor.setVisibility(View.VISIBLE);
                    linePHC_UnquaDoctor.setVisibility(View.VISIBLE);
                    secPHC_Para.setVisibility(View.VISIBLE);
                    linePHC_Para.setVisibility(View.VISIBLE);
                    secPHC_Com.setVisibility(View.VISIBLE);
                    linePHC_Com.setVisibility(View.VISIBLE);
                    secPHC_Pha.setVisibility(View.VISIBLE);
                    linePHC_Pha.setVisibility(View.VISIBLE);
                    secHC_Hompath.setVisibility(View.VISIBLE);
                    lineHC_Hompath.setVisibility(View.VISIBLE);
                    secPHC_TrHeal.setVisibility(View.VISIBLE);
                    linePHC_TrHeal.setVisibility(View.VISIBLE);
                    secPHC_SpiHeal.setVisibility(View.VISIBLE);
                    linePHC_SpiHeal.setVisibility(View.VISIBLE);
                    secPHC_Oth.setVisibility(View.VISIBLE);
                    linePHC_Oth.setVisibility(View.VISIBLE);
             }
             else{
                 secPHCarTypLabel.setVisibility(View.GONE);
                 linePHCarTypLabel.setVisibility(View.GONE);
                 secPHC_PhyMBBS.setVisibility(View.GONE);
                 linePHC_PhyMBBS.setVisibility(View.GONE);
                 rdogrpPHC_PhyMBBS.clearCheck();
                 secPHC_UnquaDoctor.setVisibility(View.GONE);
                 linePHC_UnquaDoctor.setVisibility(View.GONE);
                 rdogrpPHC_UnquaDoctor.clearCheck();
                 secPHC_Para.setVisibility(View.GONE);
                 linePHC_Para.setVisibility(View.GONE);
                 rdogrpPHC_Para.clearCheck();
                 secPHC_Com.setVisibility(View.GONE);
                 linePHC_Com.setVisibility(View.GONE);
                 rdogrpPHC_Com.clearCheck();
                 secPHC_Pha.setVisibility(View.GONE);
                 linePHC_Pha.setVisibility(View.GONE);
                 rdogrpPHC_Pha.clearCheck();
                 secHC_Hompath.setVisibility(View.GONE);
                 lineHC_Hompath.setVisibility(View.GONE);
                 rdogrpHC_Hompath.clearCheck();
                 secPHC_TrHeal.setVisibility(View.GONE);
                 linePHC_TrHeal.setVisibility(View.GONE);
                 rdogrpPHC_TrHeal.clearCheck();
                 secPHC_SpiHeal.setVisibility(View.GONE);
                 linePHC_SpiHeal.setVisibility(View.GONE);
                 rdogrpPHC_SpiHeal.clearCheck();
                 secPHC_Oth.setVisibility(View.GONE);
                 linePHC_Oth.setVisibility(View.GONE);
                 rdogrpPHC_Oth.clearCheck();
                 secPHC_OthName.setVisibility(View.GONE);
                 linePHC_OthName.setVisibility(View.GONE);
                 txtPHC_OthName.setText("");
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secPHCarTypLabel=(LinearLayout)findViewById(R.id.secPHCarTypLabel);
         linePHCarTypLabel=(View)findViewById(R.id.linePHCarTypLabel);
         secPHC_PhyMBBS=(LinearLayout)findViewById(R.id.secPHC_PhyMBBS);
         linePHC_PhyMBBS=(View)findViewById(R.id.linePHC_PhyMBBS);
         VlblPHC_PhyMBBS = (TextView) findViewById(R.id.VlblPHC_PhyMBBS);
         rdogrpPHC_PhyMBBS = (RadioGroup) findViewById(R.id.rdogrpPHC_PhyMBBS);
         
         rdoPHC_PhyMBBS1 = (RadioButton) findViewById(R.id.rdoPHC_PhyMBBS1);
         rdoPHC_PhyMBBS2 = (RadioButton) findViewById(R.id.rdoPHC_PhyMBBS2);
         rdoPHC_PhyMBBS3 = (RadioButton) findViewById(R.id.rdoPHC_PhyMBBS3);
         secPHC_UnquaDoctor=(LinearLayout)findViewById(R.id.secPHC_UnquaDoctor);
         linePHC_UnquaDoctor=(View)findViewById(R.id.linePHC_UnquaDoctor);
         VlblPHC_UnquaDoctor = (TextView) findViewById(R.id.VlblPHC_UnquaDoctor);
         rdogrpPHC_UnquaDoctor = (RadioGroup) findViewById(R.id.rdogrpPHC_UnquaDoctor);
         
         rdoPHC_UnquaDoctor1 = (RadioButton) findViewById(R.id.rdoPHC_UnquaDoctor1);
         rdoPHC_UnquaDoctor2 = (RadioButton) findViewById(R.id.rdoPHC_UnquaDoctor2);
         rdoPHC_UnquaDoctor3 = (RadioButton) findViewById(R.id.rdoPHC_UnquaDoctor3);
         secPHC_Para=(LinearLayout)findViewById(R.id.secPHC_Para);
         linePHC_Para=(View)findViewById(R.id.linePHC_Para);
         VlblPHC_Para = (TextView) findViewById(R.id.VlblPHC_Para);
         rdogrpPHC_Para = (RadioGroup) findViewById(R.id.rdogrpPHC_Para);
         
         rdoPHC_Para1 = (RadioButton) findViewById(R.id.rdoPHC_Para1);
         rdoPHC_Para2 = (RadioButton) findViewById(R.id.rdoPHC_Para2);
         rdoPHC_Para3 = (RadioButton) findViewById(R.id.rdoPHC_Para3);
         secPHC_Com=(LinearLayout)findViewById(R.id.secPHC_Com);
         linePHC_Com=(View)findViewById(R.id.linePHC_Com);
         VlblPHC_Com = (TextView) findViewById(R.id.VlblPHC_Com);
         rdogrpPHC_Com = (RadioGroup) findViewById(R.id.rdogrpPHC_Com);
         
         rdoPHC_Com1 = (RadioButton) findViewById(R.id.rdoPHC_Com1);
         rdoPHC_Com2 = (RadioButton) findViewById(R.id.rdoPHC_Com2);
         rdoPHC_Com3 = (RadioButton) findViewById(R.id.rdoPHC_Com3);
         secPHC_Pha=(LinearLayout)findViewById(R.id.secPHC_Pha);
         linePHC_Pha=(View)findViewById(R.id.linePHC_Pha);
         VlblPHC_Pha = (TextView) findViewById(R.id.VlblPHC_Pha);
         rdogrpPHC_Pha = (RadioGroup) findViewById(R.id.rdogrpPHC_Pha);
         
         rdoPHC_Pha1 = (RadioButton) findViewById(R.id.rdoPHC_Pha1);
         rdoPHC_Pha2 = (RadioButton) findViewById(R.id.rdoPHC_Pha2);
         rdoPHC_Pha3 = (RadioButton) findViewById(R.id.rdoPHC_Pha3);
         secHC_Hompath=(LinearLayout)findViewById(R.id.secHC_Hompath);
         lineHC_Hompath=(View)findViewById(R.id.lineHC_Hompath);
         VlblHC_Hompath = (TextView) findViewById(R.id.VlblHC_Hompath);
         rdogrpHC_Hompath = (RadioGroup) findViewById(R.id.rdogrpHC_Hompath);
         
         rdoHC_Hompath1 = (RadioButton) findViewById(R.id.rdoHC_Hompath1);
         rdoHC_Hompath2 = (RadioButton) findViewById(R.id.rdoHC_Hompath2);
         rdoHC_Hompath3 = (RadioButton) findViewById(R.id.rdoHC_Hompath3);
         secPHC_TrHeal=(LinearLayout)findViewById(R.id.secPHC_TrHeal);
         linePHC_TrHeal=(View)findViewById(R.id.linePHC_TrHeal);
         VlblPHC_TrHeal = (TextView) findViewById(R.id.VlblPHC_TrHeal);
         rdogrpPHC_TrHeal = (RadioGroup) findViewById(R.id.rdogrpPHC_TrHeal);
         
         rdoPHC_TrHeal1 = (RadioButton) findViewById(R.id.rdoPHC_TrHeal1);
         rdoPHC_TrHeal2 = (RadioButton) findViewById(R.id.rdoPHC_TrHeal2);
         rdoPHC_TrHeal3 = (RadioButton) findViewById(R.id.rdoPHC_TrHeal3);
         secPHC_SpiHeal=(LinearLayout)findViewById(R.id.secPHC_SpiHeal);
         linePHC_SpiHeal=(View)findViewById(R.id.linePHC_SpiHeal);
         VlblPHC_SpiHeal = (TextView) findViewById(R.id.VlblPHC_SpiHeal);
         rdogrpPHC_SpiHeal = (RadioGroup) findViewById(R.id.rdogrpPHC_SpiHeal);
         
         rdoPHC_SpiHeal1 = (RadioButton) findViewById(R.id.rdoPHC_SpiHeal1);
         rdoPHC_SpiHeal2 = (RadioButton) findViewById(R.id.rdoPHC_SpiHeal2);
         rdoPHC_SpiHeal3 = (RadioButton) findViewById(R.id.rdoPHC_SpiHeal3);
         secPHC_Oth=(LinearLayout)findViewById(R.id.secPHC_Oth);
         linePHC_Oth=(View)findViewById(R.id.linePHC_Oth);
         VlblPHC_Oth = (TextView) findViewById(R.id.VlblPHC_Oth);
         rdogrpPHC_Oth = (RadioGroup) findViewById(R.id.rdogrpPHC_Oth);


         rdogrpPHC_PhyMBBS.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
             @Override
             public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
                 String rbData = "";
                 RadioButton rb;
                 String[] d_rdogrpPHC_PhyMBBS = new String[] {"1","2","8"};
                 for (int i = 0; i < rdogrpPHC_PhyMBBS.getChildCount(); i++)
                 {
                     rb = (RadioButton)rdogrpPHC_PhyMBBS.getChildAt(i);
                     if (rb.isChecked()) rbData = d_rdogrpPHC_PhyMBBS[i];
                 }

                 if(rbData.equalsIgnoreCase("1")){
                     secPHosNamLabel.setVisibility(View.GONE);
                     linePHosNamLabel.setVisibility(View.GONE);
                     secPHosNam.setVisibility(View.GONE);
                     linePHosNam.setVisibility(View.GONE);
                     spnPHosNam.setSelection(0);
                     secPHosNamOth.setVisibility(View.GONE);
                     linePHosNamOth.setVisibility(View.GONE);
                     txtPHosNamOth.setText("");
                     secPHosNam2.setVisibility(View.GONE);
                     linePHosNam2.setVisibility(View.GONE);
                     spnPHosNam2.setSelection(0);
                     secPHosNamOth2.setVisibility(View.GONE);
                     linePHosNamOth2.setVisibility(View.GONE);
                     txtPHosNamOth2.setText("");
                     secPHosNam3.setVisibility(View.GONE);
                     linePHosNam3.setVisibility(View.GONE);
                     spnPHosNam3.setSelection(0);
                     secPHosNamOth3.setVisibility(View.GONE);
                     linePHosNamOth3.setVisibility(View.GONE);
                     txtPHosNamOth3.setText("");
                     secPDtAdmHos.setVisibility(View.GONE);
                     linePDtAdmHos.setVisibility(View.GONE);
                     dtpPDtAdmHos.setText("");
                     secPAdmHosM.setVisibility(View.GONE);
                     linePAdmHosM.setVisibility(View.GONE);
                     txtPAdmHosM.setText("");
                     secPDurIlBeHos.setVisibility(View.GONE);
                     linePDurIlBeHos.setVisibility(View.GONE);
                     txtPDurIlBeHos.setText("");
                 }
                 else if(rbData.equalsIgnoreCase("2"))
                 {
                     secPHosNamLabel.setVisibility(View.GONE);
                     linePHosNamLabel.setVisibility(View.GONE);
                     secPHosNam.setVisibility(View.GONE);
                     linePHosNam.setVisibility(View.GONE);
                     spnPHosNam.setSelection(0);
                     secPHosNamOth.setVisibility(View.GONE);
                     linePHosNamOth.setVisibility(View.GONE);
                     txtPHosNamOth.setText("");
                     secPHosNam2.setVisibility(View.GONE);
                     linePHosNam2.setVisibility(View.GONE);
                     spnPHosNam2.setSelection(0);
                     secPHosNamOth2.setVisibility(View.GONE);
                     linePHosNamOth2.setVisibility(View.GONE);
                     txtPHosNamOth2.setText("");
                     secPHosNam3.setVisibility(View.GONE);
                     linePHosNam3.setVisibility(View.GONE);
                     spnPHosNam3.setSelection(0);
                     secPHosNamOth3.setVisibility(View.GONE);
                     linePHosNamOth3.setVisibility(View.GONE);
                     txtPHosNamOth3.setText("");
                     secPDtAdmHos.setVisibility(View.GONE);
                     linePDtAdmHos.setVisibility(View.GONE);
                     dtpPDtAdmHos.setText("");
                     secPAdmHosM.setVisibility(View.GONE);
                     linePAdmHosM.setVisibility(View.GONE);
                     txtPAdmHosM.setText("");
                     secPDurIlBeHos.setVisibility(View.GONE);
                     linePDurIlBeHos.setVisibility(View.GONE);
                     txtPDurIlBeHos.setText("");
                     secPDisDr.setVisibility(View.GONE);
                     linePDisDr.setVisibility(View.GONE);
                 }

                 else if(rbData.equalsIgnoreCase("8"))
                 {
                     secPHosNamLabel.setVisibility(View.GONE);
                     linePHosNamLabel.setVisibility(View.GONE);
                     secPHosNam.setVisibility(View.GONE);
                     linePHosNam.setVisibility(View.GONE);
                     spnPHosNam.setSelection(0);
                     secPHosNamOth.setVisibility(View.GONE);
                     linePHosNamOth.setVisibility(View.GONE);
                     txtPHosNamOth.setText("");
                     secPHosNam2.setVisibility(View.GONE);
                     linePHosNam2.setVisibility(View.GONE);
                     spnPHosNam2.setSelection(0);
                     secPHosNamOth2.setVisibility(View.GONE);
                     linePHosNamOth2.setVisibility(View.GONE);
                     txtPHosNamOth2.setText("");
                     secPHosNam3.setVisibility(View.GONE);
                     linePHosNam3.setVisibility(View.GONE);
                     spnPHosNam3.setSelection(0);
                     secPHosNamOth3.setVisibility(View.GONE);
                     linePHosNamOth3.setVisibility(View.GONE);
                     txtPHosNamOth3.setText("");
                     secPDtAdmHos.setVisibility(View.GONE);
                     linePDtAdmHos.setVisibility(View.GONE);
                     dtpPDtAdmHos.setText("");
                     secPAdmHosM.setVisibility(View.GONE);
                     linePAdmHosM.setVisibility(View.GONE);
                     txtPAdmHosM.setText("");
                     secPDurIlBeHos.setVisibility(View.GONE);
                     linePDurIlBeHos.setVisibility(View.GONE);
                     txtPDurIlBeHos.setText("");
                     secPDisDr.setVisibility(View.GONE);
                     linePDisDr.setVisibility(View.GONE);
                 }
                 else{
                     secPHosNamLabel.setVisibility(View.VISIBLE);
                     linePHosNamLabel.setVisibility(View.VISIBLE);
                     secPHosNam.setVisibility(View.VISIBLE);
                     linePHosNam.setVisibility(View.VISIBLE);
                     spnPHosNam.setSelection(0);

                     secPHosNam2.setVisibility(View.VISIBLE);
                     linePHosNam2.setVisibility(View.VISIBLE);
                     spnPHosNam2.setSelection(0);

                     secPHosNam3.setVisibility(View.VISIBLE);
                     linePHosNam3.setVisibility(View.VISIBLE);
                     spnPHosNam3.setSelection(0);

                     secPDtAdmHos.setVisibility(View.VISIBLE);
                     linePDtAdmHos.setVisibility(View.VISIBLE);
                     dtpPDtAdmHos.setText("");
                     secPAdmHosM.setVisibility(View.VISIBLE);
                     linePAdmHosM.setVisibility(View.VISIBLE);
                     txtPAdmHosM.setText("");
                     secPDurIlBeHos.setVisibility(View.VISIBLE);
                     linePDurIlBeHos.setVisibility(View.VISIBLE);
                     txtPDurIlBeHos.setText("");
                     secPDisDr.setVisibility(View.VISIBLE);
                     linePDisDr.setVisibility(View.VISIBLE);
                 }


             }
             public void onNothingSelected(AdapterView<?> adapterView) {
                 return;
             }
         });

         rdoPHC_Oth1 = (RadioButton) findViewById(R.id.rdoPHC_Oth1);
         rdoPHC_Oth2 = (RadioButton) findViewById(R.id.rdoPHC_Oth2);
         rdoPHC_Oth3 = (RadioButton) findViewById(R.id.rdoPHC_Oth3);
         rdogrpPHC_Oth.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpPHC_Oth = new String[] {"1","2","8"};
             for (int i = 0; i < rdogrpPHC_Oth.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpPHC_Oth.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpPHC_Oth[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secPHC_OthName.setVisibility(View.GONE);
                    linePHC_OthName.setVisibility(View.GONE);
                    txtPHC_OthName.setText("");
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secPHC_OthName.setVisibility(View.GONE);
                    linePHC_OthName.setVisibility(View.GONE);
                    txtPHC_OthName.setText("");
             }
             else if(rbData.equalsIgnoreCase("1"))
             {
                    secPHC_OthName.setVisibility(View.VISIBLE);
                    linePHC_OthName.setVisibility(View.VISIBLE);
             }
             else{
                 secPHC_OthName.setVisibility(View.GONE);
                 linePHC_OthName.setVisibility(View.GONE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secPHC_OthName=(LinearLayout)findViewById(R.id.secPHC_OthName);
         linePHC_OthName=(View)findViewById(R.id.linePHC_OthName);
         VlblPHC_OthName=(TextView) findViewById(R.id.VlblPHC_OthName);
         txtPHC_OthName=(EditText) findViewById(R.id.txtPHC_OthName);
         secPDSHOPD=(LinearLayout)findViewById(R.id.secPDSHOPD);
         linePDSHOPD=(View)findViewById(R.id.linePDSHOPD);
         VlblPDSHOPD = (TextView) findViewById(R.id.VlblPDSHOPD);
         rdogrpPDSHOPD = (RadioGroup) findViewById(R.id.rdogrpPDSHOPD);
         
         rdoPDSHOPD1 = (RadioButton) findViewById(R.id.rdoPDSHOPD1);
         rdoPDSHOPD2 = (RadioButton) findViewById(R.id.rdoPDSHOPD2);
         rdoPDSHOPD3 = (RadioButton) findViewById(R.id.rdoPDSHOPD3);
         secPSSFOPD=(LinearLayout)findViewById(R.id.secPSSFOPD);
         linePSSFOPD=(View)findViewById(R.id.linePSSFOPD);
         VlblPSSFOPD = (TextView) findViewById(R.id.VlblPSSFOPD);
         rdogrpPSSFOPD = (RadioGroup) findViewById(R.id.rdogrpPSSFOPD);
         
         rdoPSSFOPD1 = (RadioButton) findViewById(R.id.rdoPSSFOPD1);
         rdoPSSFOPD2 = (RadioButton) findViewById(R.id.rdoPSSFOPD2);
         rdoPSSFOPD3 = (RadioButton) findViewById(R.id.rdoPSSFOPD3);
         secPAdmHos=(LinearLayout)findViewById(R.id.secPAdmHos);
         linePAdmHos=(View)findViewById(R.id.linePAdmHos);
         VlblPAdmHos = (TextView) findViewById(R.id.VlblPAdmHos);
         rdogrpPAdmHos = (RadioGroup) findViewById(R.id.rdogrpPAdmHos);


         rdogrpPAdmHos.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(RadioGroup radioGroup, int radioButtonID) {
                 String rbData = "";
                 RadioButton rb;
                 String[] d_rdogrpPAdmHos = new String[] {"1","2","8"};
                 for (int i = 0; i < rdogrpPAdmHos.getChildCount(); i++)
                 {
                     rb = (RadioButton)rdogrpPAdmHos.getChildAt(i);
                     if (rb.isChecked()) rbData = d_rdogrpPAdmHos[i];
                 }

                 if(rbData.equalsIgnoreCase("2"))
                 {
                     if(rdoPHC_PhyMBBS1.isChecked()){
                         secPHosNamLabel.setVisibility(View.GONE);
                         linePHosNamLabel.setVisibility(View.GONE);
                         secPHosNam.setVisibility(View.GONE);
                         linePHosNam.setVisibility(View.GONE);
                         spnPHosNam.setSelection(0);
                         secPHosNamOth.setVisibility(View.GONE);
                         linePHosNamOth.setVisibility(View.GONE);
                         txtPHosNamOth.setText("");
                         secPHosNam2.setVisibility(View.GONE);
                         linePHosNam2.setVisibility(View.GONE);
                         spnPHosNam2.setSelection(0);
                         secPHosNamOth2.setVisibility(View.GONE);
                         linePHosNamOth2.setVisibility(View.GONE);
                         txtPHosNamOth2.setText("");
                         secPHosNam3.setVisibility(View.GONE);
                         linePHosNam3.setVisibility(View.GONE);
                         spnPHosNam3.setSelection(0);
                         secPHosNamOth3.setVisibility(View.GONE);
                         linePHosNamOth3.setVisibility(View.GONE);
                         txtPHosNamOth3.setText("");
                         secPDtAdmHos.setVisibility(View.GONE);
                         linePDtAdmHos.setVisibility(View.GONE);
                         dtpPDtAdmHos.setText("");
                         secPAdmHosM.setVisibility(View.GONE);
                         linePAdmHosM.setVisibility(View.GONE);
                         txtPAdmHosM.setText("");
                         secPDurIlBeHos.setVisibility(View.GONE);
                         linePDurIlBeHos.setVisibility(View.GONE);
                         txtPDurIlBeHos.setText("");
                     }
                     else{
                         secPHosNamLabel.setVisibility(View.GONE);
                         linePHosNamLabel.setVisibility(View.GONE);
                         secPHosNam.setVisibility(View.GONE);
                         linePHosNam.setVisibility(View.GONE);
                         spnPHosNam.setSelection(0);
                         secPHosNamOth.setVisibility(View.GONE);
                         linePHosNamOth.setVisibility(View.GONE);
                         txtPHosNamOth.setText("");
                         secPHosNam2.setVisibility(View.GONE);
                         linePHosNam2.setVisibility(View.GONE);
                         spnPHosNam2.setSelection(0);
                         secPHosNamOth2.setVisibility(View.GONE);
                         linePHosNamOth2.setVisibility(View.GONE);
                         txtPHosNamOth2.setText("");
                         secPHosNam3.setVisibility(View.GONE);
                         linePHosNam3.setVisibility(View.GONE);
                         spnPHosNam3.setSelection(0);
                         secPHosNamOth3.setVisibility(View.GONE);
                         linePHosNamOth3.setVisibility(View.GONE);
                         txtPHosNamOth3.setText("");
                         secPDtAdmHos.setVisibility(View.GONE);
                         linePDtAdmHos.setVisibility(View.GONE);
                         dtpPDtAdmHos.setText("");
                         secPAdmHosM.setVisibility(View.GONE);
                         linePAdmHosM.setVisibility(View.GONE);
                         txtPAdmHosM.setText("");
                         secPDurIlBeHos.setVisibility(View.GONE);
                         linePDurIlBeHos.setVisibility(View.GONE);
                         txtPDurIlBeHos.setText("");
                         secPDisDr.setVisibility(View.GONE);
                         linePDisDr.setVisibility(View.GONE);
                         spnPDisDr.setSelection(0);
                         secPDisDrOth.setVisibility(View.GONE);
                         linePDisDrOth.setVisibility(View.GONE);
                         txtPDisDrOth.setText("");
                     }

                 }
                 else if(rbData.equalsIgnoreCase("8"))
                 {
                     if(rdoPHC_PhyMBBS1.isChecked()){
                         secPHosNamLabel.setVisibility(View.GONE);
                         linePHosNamLabel.setVisibility(View.GONE);
                         secPHosNam.setVisibility(View.GONE);
                         linePHosNam.setVisibility(View.GONE);
                         spnPHosNam.setSelection(0);
                         secPHosNamOth.setVisibility(View.GONE);
                         linePHosNamOth.setVisibility(View.GONE);
                         txtPHosNamOth.setText("");
                         secPHosNam2.setVisibility(View.GONE);
                         linePHosNam2.setVisibility(View.GONE);
                         spnPHosNam2.setSelection(0);
                         secPHosNamOth2.setVisibility(View.GONE);
                         linePHosNamOth2.setVisibility(View.GONE);
                         txtPHosNamOth2.setText("");
                         secPHosNam3.setVisibility(View.GONE);
                         linePHosNam3.setVisibility(View.GONE);
                         spnPHosNam3.setSelection(0);
                         secPHosNamOth3.setVisibility(View.GONE);
                         linePHosNamOth3.setVisibility(View.GONE);
                         txtPHosNamOth3.setText("");
                         secPDtAdmHos.setVisibility(View.GONE);
                         linePDtAdmHos.setVisibility(View.GONE);
                         dtpPDtAdmHos.setText("");
                         secPAdmHosM.setVisibility(View.GONE);
                         linePAdmHosM.setVisibility(View.GONE);
                         txtPAdmHosM.setText("");
                         secPDurIlBeHos.setVisibility(View.GONE);
                         linePDurIlBeHos.setVisibility(View.GONE);
                         txtPDurIlBeHos.setText("");
                     }
                     else{
                         secPHosNamLabel.setVisibility(View.GONE);
                         linePHosNamLabel.setVisibility(View.GONE);
                         secPHosNam.setVisibility(View.GONE);
                         linePHosNam.setVisibility(View.GONE);
                         spnPHosNam.setSelection(0);
                         secPHosNamOth.setVisibility(View.GONE);
                         linePHosNamOth.setVisibility(View.GONE);
                         txtPHosNamOth.setText("");
                         secPHosNam2.setVisibility(View.GONE);
                         linePHosNam2.setVisibility(View.GONE);
                         spnPHosNam2.setSelection(0);
                         secPHosNamOth2.setVisibility(View.GONE);
                         linePHosNamOth2.setVisibility(View.GONE);
                         txtPHosNamOth2.setText("");
                         secPHosNam3.setVisibility(View.GONE);
                         linePHosNam3.setVisibility(View.GONE);
                         spnPHosNam3.setSelection(0);
                         secPHosNamOth3.setVisibility(View.GONE);
                         linePHosNamOth3.setVisibility(View.GONE);
                         txtPHosNamOth3.setText("");
                         secPDtAdmHos.setVisibility(View.GONE);
                         linePDtAdmHos.setVisibility(View.GONE);
                         dtpPDtAdmHos.setText("");
                         secPAdmHosM.setVisibility(View.GONE);
                         linePAdmHosM.setVisibility(View.GONE);
                         txtPAdmHosM.setText("");
                         secPDurIlBeHos.setVisibility(View.GONE);
                         linePDurIlBeHos.setVisibility(View.GONE);
                         txtPDurIlBeHos.setText("");
                         secPDisDr.setVisibility(View.GONE);
                         linePDisDr.setVisibility(View.GONE);
                         spnPDisDr.setSelection(0);
                         secPDisDrOth.setVisibility(View.GONE);
                         linePDisDrOth.setVisibility(View.GONE);
                         txtPDisDrOth.setText("");
                     }

                 }
                 else if(rbData.equalsIgnoreCase("1"))
                 {
                     secPHosNamLabel.setVisibility(View.VISIBLE);
                     linePHosNamLabel.setVisibility(View.VISIBLE);
                     secPHosNam.setVisibility(View.VISIBLE);
                     linePHosNam.setVisibility(View.VISIBLE);

                     secPHosNam2.setVisibility(View.VISIBLE);
                     linePHosNam2.setVisibility(View.VISIBLE);

                     secPHosNam3.setVisibility(View.VISIBLE);
                     linePHosNam3.setVisibility(View.VISIBLE);

                     secPDtAdmHos.setVisibility(View.VISIBLE);
                     linePDtAdmHos.setVisibility(View.VISIBLE);
                     secPAdmHosM.setVisibility(View.VISIBLE);
                     linePAdmHosM.setVisibility(View.VISIBLE);
                     secPDurIlBeHos.setVisibility(View.VISIBLE);
                     linePDurIlBeHos.setVisibility(View.VISIBLE);
                     secPDisDr.setVisibility(View.VISIBLE);
                     linePDisDr.setVisibility(View.VISIBLE);
                 }
                 else{
                     secPHosNamLabel.setVisibility(View.VISIBLE);
                     linePHosNamLabel.setVisibility(View.VISIBLE);
                     secPHosNam.setVisibility(View.VISIBLE);
                     linePHosNam.setVisibility(View.VISIBLE);

                     secPHosNam2.setVisibility(View.VISIBLE);
                     linePHosNam2.setVisibility(View.VISIBLE);

                     secPHosNam3.setVisibility(View.VISIBLE);
                     linePHosNam3.setVisibility(View.VISIBLE);

                     secPDtAdmHos.setVisibility(View.VISIBLE);
                     linePDtAdmHos.setVisibility(View.VISIBLE);
                     secPAdmHosM.setVisibility(View.VISIBLE);
                     linePAdmHosM.setVisibility(View.VISIBLE);
                     secPDurIlBeHos.setVisibility(View.VISIBLE);
                     linePDurIlBeHos.setVisibility(View.VISIBLE);
                     secPDisDr.setVisibility(View.VISIBLE);
                     linePDisDr.setVisibility(View.VISIBLE);
                 }
             }
         });
         
         rdoPAdmHos1 = (RadioButton) findViewById(R.id.rdoPAdmHos1);
         rdoPAdmHos2 = (RadioButton) findViewById(R.id.rdoPAdmHos2);
         rdoPAdmHos3 = (RadioButton) findViewById(R.id.rdoPAdmHos3);
         secPHosNamLabel=(LinearLayout)findViewById(R.id.secPHosNamLabel);
         linePHosNamLabel=(View)findViewById(R.id.linePHosNamLabel);
         secPHosNam=(LinearLayout)findViewById(R.id.secPHosNam);
         linePHosNam=(View)findViewById(R.id.linePHosNam);
         VlblPHosNam=(TextView) findViewById(R.id.VlblPHosNam);
         spnPHosNam=(Spinner) findViewById(R.id.spnPHosNam);
         List<String> listPHosNam = new ArrayList<String>();
         
         listPHosNam.add("");
         listPHosNam.add("1-ঢাকা শিশু হাসপাতাল (Dhaka Shishu Hospital)");
         listPHosNam.add("2-ডাঃ এম আর খান  শিশু হাসপাতাল (Dr. MR Khan Shishu Hospital)");
         listPHosNam.add("7-অন্যান্য (Other)");
         listPHosNam.add("8-জানি না (Do not know)");
         ArrayAdapter<String> adptrPHosNam= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listPHosNam);
         spnPHosNam.setAdapter(adptrPHosNam);

         spnPHosNam.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnPHosNam.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnPHosNam.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("1"))
                 {
                    secPHosNamOth.setVisibility(View.GONE);
                    linePHosNamOth.setVisibility(View.GONE);
                     spnPHosNam2.setEnabled(true);
                     spnPHosNam3.setEnabled(true);
                    txtPHosNamOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("2"))
                 {
                    secPHosNamOth.setVisibility(View.GONE);
                    linePHosNamOth.setVisibility(View.GONE);
                    txtPHosNamOth.setText("");
                     spnPHosNam2.setEnabled(true);
                     spnPHosNam3.setEnabled(true);
                 }
                 else if(spnData.equalsIgnoreCase("8"))
                 {
                    secPHosNamOth.setVisibility(View.GONE);
                    linePHosNamOth.setVisibility(View.GONE);
                     spnPHosNam2.setEnabled(true);
                     spnPHosNam3.setEnabled(true);
                    txtPHosNamOth.setText("");

                 }
                 else if(spnData.equalsIgnoreCase("7"))
                 {
                    secPHosNamOth.setVisibility(View.VISIBLE);
                    linePHosNamOth.setVisibility(View.VISIBLE);
                     spnPHosNam2.setSelection(0);
                     spnPHosNam3.setSelection(0);
                     spnPHosNam2.setEnabled(false);
                     spnPHosNam3.setEnabled(false);
                 }
                 else{
                     secPHosNamOth.setVisibility(View.GONE);
                     linePHosNamOth.setVisibility(View.GONE);
                     spnPHosNam2.setEnabled(true);
                     spnPHosNam3.setEnabled(true);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secPHosNamOth=(LinearLayout)findViewById(R.id.secPHosNamOth);
         linePHosNamOth=(View)findViewById(R.id.linePHosNamOth);
         VlblPHosNamOth=(TextView) findViewById(R.id.VlblPHosNamOth);
         txtPHosNamOth=(EditText) findViewById(R.id.txtPHosNamOth);
         secPHosNam2=(LinearLayout)findViewById(R.id.secPHosNam2);
         linePHosNam2=(View)findViewById(R.id.linePHosNam2);
         VlblPHosNam2=(TextView) findViewById(R.id.VlblPHosNam2);
         spnPHosNam2=(Spinner) findViewById(R.id.spnPHosNam2);
         List<String> listPHosNam2 = new ArrayList<String>();
         
         listPHosNam2.add("");
         listPHosNam2.add("1-ঢাকা শিশু হাসপাতাল (Dhaka Shishu Hospital)");
         listPHosNam2.add("2-ডাঃ এম আর খান  শিশু হাসপাতাল (Dr. MR Khan Shishu Hospital)");
         listPHosNam2.add("7-অন্যান্য (Other)");
         listPHosNam2.add("8-জানি না (Do not know)");
         ArrayAdapter<String> adptrPHosNam2= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listPHosNam2);
         spnPHosNam2.setAdapter(adptrPHosNam2);

         spnPHosNam2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnPHosNam2.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnPHosNam2.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("1"))
                 {
                    secPHosNamOth2.setVisibility(View.GONE);
                    linePHosNamOth2.setVisibility(View.GONE);
                    txtPHosNamOth2.setText("");
                     spnPHosNam3.setEnabled(true);
                 }
                 else if(spnData.equalsIgnoreCase("2"))
                 {
                    secPHosNamOth2.setVisibility(View.GONE);
                    linePHosNamOth2.setVisibility(View.GONE);
                    txtPHosNamOth2.setText("");
                     spnPHosNam3.setEnabled(true);
                 }
                 else if(spnData.equalsIgnoreCase("8"))
                 {
                    secPHosNamOth2.setVisibility(View.GONE);
                    linePHosNamOth2.setVisibility(View.GONE);
                    txtPHosNamOth2.setText("");
                     spnPHosNam3.setEnabled(true);
                 }
                 else if(spnData.equalsIgnoreCase("7"))
                 {
                    secPHosNamOth2.setVisibility(View.VISIBLE);
                    linePHosNamOth2.setVisibility(View.VISIBLE);
                     spnPHosNam3.setSelection(0);
                     spnPHosNam3.setEnabled(false);
                 }
                 else{
                     secPHosNamOth2.setVisibility(View.GONE);
                     linePHosNamOth2.setVisibility(View.GONE);
                     spnPHosNam3.setEnabled(true);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secPHosNamOth2=(LinearLayout)findViewById(R.id.secPHosNamOth2);
         linePHosNamOth2=(View)findViewById(R.id.linePHosNamOth2);
         VlblPHosNamOth2=(TextView) findViewById(R.id.VlblPHosNamOth2);
         txtPHosNamOth2=(EditText) findViewById(R.id.txtPHosNamOth2);
         secPHosNam3=(LinearLayout)findViewById(R.id.secPHosNam3);
         linePHosNam3=(View)findViewById(R.id.linePHosNam3);
         VlblPHosNam3=(TextView) findViewById(R.id.VlblPHosNam3);
         spnPHosNam3=(Spinner) findViewById(R.id.spnPHosNam3);
         List<String> listPHosNam3 = new ArrayList<String>();
         
         listPHosNam3.add("");
         listPHosNam3.add("1-ঢাকা শিশু হাসপাতাল (Dhaka Shishu Hospital)");
         listPHosNam3.add("2-ডাঃ এম আর খান  শিশু হাসপাতাল (Dr. MR Khan Shishu Hospital)");
         listPHosNam3.add("7-অন্যান্য (Other)");
         listPHosNam3.add("8-জানি না (Do not know)");
         ArrayAdapter<String> adptrPHosNam3= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listPHosNam3);
         spnPHosNam3.setAdapter(adptrPHosNam3);

         spnPHosNam3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnPHosNam3.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnPHosNam3.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("1"))
                 {
                    secPHosNamOth3.setVisibility(View.GONE);
                    linePHosNamOth3.setVisibility(View.GONE);
                    txtPHosNamOth3.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("2"))
                 {
                    secPHosNamOth3.setVisibility(View.GONE);
                    linePHosNamOth3.setVisibility(View.GONE);
                    txtPHosNamOth3.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("8"))
                 {
                    secPHosNamOth3.setVisibility(View.GONE);
                    linePHosNamOth3.setVisibility(View.GONE);
                    txtPHosNamOth3.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("7"))
                 {
                    secPHosNamOth3.setVisibility(View.VISIBLE);
                    linePHosNamOth3.setVisibility(View.VISIBLE);
                 }
                 else{
                     secPHosNamOth3.setVisibility(View.GONE);
                     linePHosNamOth3.setVisibility(View.GONE);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secPHosNamOth3=(LinearLayout)findViewById(R.id.secPHosNamOth3);
         linePHosNamOth3=(View)findViewById(R.id.linePHosNamOth3);
         VlblPHosNamOth3=(TextView) findViewById(R.id.VlblPHosNamOth3);
         txtPHosNamOth3=(EditText) findViewById(R.id.txtPHosNamOth3);
         secPDtAdmHos=(LinearLayout)findViewById(R.id.secPDtAdmHos);
         linePDtAdmHos=(View)findViewById(R.id.linePDtAdmHos);
         VlblPDtAdmHos=(TextView) findViewById(R.id.VlblPDtAdmHos);
         dtpPDtAdmHos=(EditText) findViewById(R.id.dtpPDtAdmHos);
         secPAdmHosM=(LinearLayout)findViewById(R.id.secPAdmHosM);
         linePAdmHosM=(View)findViewById(R.id.linePAdmHosM);
         VlblPAdmHosM=(TextView) findViewById(R.id.VlblPAdmHosM);
         txtPAdmHosM=(EditText) findViewById(R.id.txtPAdmHosM);
         secPDurIlBeHos=(LinearLayout)findViewById(R.id.secPDurIlBeHos);
         linePDurIlBeHos=(View)findViewById(R.id.linePDurIlBeHos);
         VlblPDurIlBeHos=(TextView) findViewById(R.id.VlblPDurIlBeHos);
         txtPDurIlBeHos=(EditText) findViewById(R.id.txtPDurIlBeHos);
         secPDisDr=(LinearLayout)findViewById(R.id.secPDisDr);
         linePDisDr=(View)findViewById(R.id.linePDisDr);
         VlblPDisDr=(TextView) findViewById(R.id.VlblPDisDr);
         spnPDisDr=(Spinner) findViewById(R.id.spnPDisDr);

         txtPAdmHosM.addTextChangedListener(new TextWatcher() {
             @Override
             public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

             }

             @Override
             public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                 if(!txtPAdmHosM.getText().toString().equals("0") & txtPAdmHosM.getText().toString().length()>0)
                 {
                     dtpPDtAdmHos.setText("");
                 }

             }

             @Override
             public void afterTextChanged(Editable editable) {

             }
         });

         List<String> listPDisDr = new ArrayList<String>();
         
         listPDisDr.add("");
         listPDisDr.add("1- নিউমোনিয়া (Pneumonia)   ");
         listPDisDr.add("2-টাইফয়েড (Typhoid fever)  ");
         listPDisDr.add("3-মেনিনজাইটিস বা মস্তিস্কে সংক্রমণ (Meningitis)   ");
         listPDisDr.add("4-ম্রিগি রোগ (Epilepsy)   ");
         listPDisDr.add("5- জ্বরসহ খিঁচুনি (Febrile convulsion)    ");
         listPDisDr.add("6-মস্তিস্কে প্রদাহ (Encephalitis)   ");
         listPDisDr.add("7-অন্যান্য (Other) ");
         listPDisDr.add("8-জানি না (Don’t know) ");
         listPDisDr.add("9-প্রযোজ্য নয় (NA)");
         ArrayAdapter<String> adptrPDisDr= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listPDisDr);
         spnPDisDr.setAdapter(adptrPDisDr);

         spnPDisDr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnPDisDr.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnPDisDr.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("1"))
                 {
                    secPDisDrOth.setVisibility(View.GONE);
                    linePDisDrOth.setVisibility(View.GONE);
                    txtPDisDrOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("2"))
                 {
                    secPDisDrOth.setVisibility(View.GONE);
                    linePDisDrOth.setVisibility(View.GONE);
                    txtPDisDrOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("3"))
                 {
                    secPDisDrOth.setVisibility(View.GONE);
                    linePDisDrOth.setVisibility(View.GONE);
                    txtPDisDrOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("4"))
                 {
                    secPDisDrOth.setVisibility(View.GONE);
                    linePDisDrOth.setVisibility(View.GONE);
                    txtPDisDrOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("5"))
                 {
                    secPDisDrOth.setVisibility(View.GONE);
                    linePDisDrOth.setVisibility(View.GONE);
                    txtPDisDrOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("6"))
                 {
                    secPDisDrOth.setVisibility(View.GONE);
                    linePDisDrOth.setVisibility(View.GONE);
                    txtPDisDrOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("8"))
                 {
                    secPDisDrOth.setVisibility(View.GONE);
                    linePDisDrOth.setVisibility(View.GONE);
                    txtPDisDrOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("9"))
                 {
                    secPDisDrOth.setVisibility(View.GONE);
                    linePDisDrOth.setVisibility(View.GONE);
                    txtPDisDrOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("7"))
                 {
                    secPDisDrOth.setVisibility(View.VISIBLE);
                    linePDisDrOth.setVisibility(View.VISIBLE);
                 }
                 else{
                     secPDisDrOth.setVisibility(View.GONE);
                     linePDisDrOth.setVisibility(View.GONE);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secPDisDrOth=(LinearLayout)findViewById(R.id.secPDisDrOth);
         linePDisDrOth=(View)findViewById(R.id.linePDisDrOth);
         VlblPDisDrOth=(TextView) findViewById(R.id.VlblPDisDrOth);
         txtPDisDrOth=(EditText) findViewById(R.id.txtPDisDrOth);
         secPReco=(LinearLayout)findViewById(R.id.secPReco);
         linePReco=(View)findViewById(R.id.linePReco);
         VlblPReco = (TextView) findViewById(R.id.VlblPReco);
         rdogrpPReco = (RadioGroup) findViewById(R.id.rdogrpPReco);
         
         rdoPReco1 = (RadioButton) findViewById(R.id.rdoPReco1);
         rdoPReco2 = (RadioButton) findViewById(R.id.rdoPReco2);
         rdoPReco3 = (RadioButton) findViewById(R.id.rdoPReco3);
         rdogrpPReco.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpPReco = new String[] {"1","2","8"};
             for (int i = 0; i < rdogrpPReco.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpPReco.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpPReco[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secPDurReco.setVisibility(View.GONE);
                    linePDurReco.setVisibility(View.GONE);
                    txtPDurReco.setText("");
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secPDurReco.setVisibility(View.GONE);
                    linePDurReco.setVisibility(View.GONE);
                    txtPDurReco.setText("");
             }
             else if(rbData.equalsIgnoreCase("1"))
             {
                    secPDurReco.setVisibility(View.VISIBLE);
                    linePDurReco.setVisibility(View.VISIBLE);
             }
             else{
                 secPDurReco.setVisibility(View.GONE);
                 linePDurReco.setVisibility(View.GONE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secPDurReco=(LinearLayout)findViewById(R.id.secPDurReco);
         linePDurReco=(View)findViewById(R.id.linePDurReco);
         VlblPDurReco=(TextView) findViewById(R.id.VlblPDurReco);
         txtPDurReco=(EditText) findViewById(R.id.txtPDurReco);
         secPAboIll=(LinearLayout)findViewById(R.id.secPAboIll);
         linePAboIll=(View)findViewById(R.id.linePAboIll);
         VlblPAboIll=(TextView) findViewById(R.id.VlblPAboIll);
         txtPAboIll=(EditText) findViewById(R.id.txtPAboIll);


         dtpPDtAdmHos.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpPDtAdmHos.getRight() - dtpPDtAdmHos.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btnPDtAdmHos"; showDialog(DATE_DIALOG);
                         txtPAdmHosM.setText("");
                      return true;
                     }
                 }
                 return false;
             }
         });



         //Hide all skip variables
         secPEpiIlness.setVisibility(View.GONE);
         linePEpiIlness.setVisibility(View.GONE);
         secPFever.setVisibility(View.GONE);
         linePFever.setVisibility(View.GONE);
         secPDurFever.setVisibility(View.GONE);
         linePDurFever.setVisibility(View.GONE);
         secPCough.setVisibility(View.GONE);
         linePCough.setVisibility(View.GONE);
         secPDurCough.setVisibility(View.GONE);
         linePDurCough.setVisibility(View.GONE);
         secPDifBrea.setVisibility(View.GONE);
         linePDifBrea.setVisibility(View.GONE);
         secPDurDifBrea.setVisibility(View.GONE);
         linePDurDifBrea.setVisibility(View.GONE);
         secPTurnBlue.setVisibility(View.GONE);
         linePTurnBlue.setVisibility(View.GONE);
         secPDurTurnBlue.setVisibility(View.GONE);
         linePDurTurnBlue.setVisibility(View.GONE);
         secPBreatNois.setVisibility(View.GONE);
         linePBreatNois.setVisibility(View.GONE);
         secPDurBreatNois.setVisibility(View.GONE);
         linePDurBreatNois.setVisibility(View.GONE);
         secPLethargy.setVisibility(View.GONE);
         linePLethargy.setVisibility(View.GONE);
         secPDurLethargy.setVisibility(View.GONE);
         linePDurLethargy.setVisibility(View.GONE);
         secPUnDriBfeed.setVisibility(View.GONE);
         linePUnDriBfeed.setVisibility(View.GONE);
         secPDurUnDriBfeed.setVisibility(View.GONE);
         linePDurUnDriBfeed.setVisibility(View.GONE);
         secPVomit.setVisibility(View.GONE);
         linePVomit.setVisibility(View.GONE);
         secPConv.setVisibility(View.GONE);
         linePConv.setVisibility(View.GONE);
         secPUpRolEye.setVisibility(View.GONE);
         linePUpRolEye.setVisibility(View.GONE);
         secPRigJaw.setVisibility(View.GONE);
         linePRigJaw.setVisibility(View.GONE);
         secPRigLim.setVisibility(View.GONE);
         linePRigLim.setVisibility(View.GONE);
         secPDurConv.setVisibility(View.GONE);
         linePDurConv.setVisibility(View.GONE);
         secPUncons.setVisibility(View.GONE);
         linePUncons.setVisibility(View.GONE);
         secPDurUncons.setVisibility(View.GONE);
         linePDurUncons.setVisibility(View.GONE);
         secPIlHCar.setVisibility(View.GONE);
         linePIlHCar.setVisibility(View.GONE);
         secPHCarTypLabel.setVisibility(View.GONE);
         linePHCarTypLabel.setVisibility(View.GONE);
         secPHC_PhyMBBS.setVisibility(View.GONE);
         linePHC_PhyMBBS.setVisibility(View.GONE);
         secPHC_UnquaDoctor.setVisibility(View.GONE);
         linePHC_UnquaDoctor.setVisibility(View.GONE);
         secPHC_Para.setVisibility(View.GONE);
         linePHC_Para.setVisibility(View.GONE);
         secPHC_Com.setVisibility(View.GONE);
         linePHC_Com.setVisibility(View.GONE);
         secPHC_Pha.setVisibility(View.GONE);
         linePHC_Pha.setVisibility(View.GONE);
         secHC_Hompath.setVisibility(View.GONE);
         lineHC_Hompath.setVisibility(View.GONE);
         secPHC_TrHeal.setVisibility(View.GONE);
         linePHC_TrHeal.setVisibility(View.GONE);
         secPHC_SpiHeal.setVisibility(View.GONE);
         linePHC_SpiHeal.setVisibility(View.GONE);
         secPHC_Oth.setVisibility(View.GONE);
         linePHC_Oth.setVisibility(View.GONE);
         secPHC_OthName.setVisibility(View.GONE);
         linePHC_OthName.setVisibility(View.GONE);
         secPDSHOPD.setVisibility(View.GONE);
         linePDSHOPD.setVisibility(View.GONE);
         secPSSFOPD.setVisibility(View.GONE);
         linePSSFOPD.setVisibility(View.GONE);
         secPAdmHos.setVisibility(View.GONE);
         linePAdmHos.setVisibility(View.GONE);
         secPHosNamLabel.setVisibility(View.GONE);
         linePHosNamLabel.setVisibility(View.GONE);
         secPHosNam.setVisibility(View.GONE);
         linePHosNam.setVisibility(View.GONE);
         secPHosNamOth.setVisibility(View.GONE);
         linePHosNamOth.setVisibility(View.GONE);
         secPHosNam2.setVisibility(View.GONE);
         linePHosNam2.setVisibility(View.GONE);
         secPHosNamOth2.setVisibility(View.GONE);
         linePHosNamOth2.setVisibility(View.GONE);
         secPHosNam3.setVisibility(View.GONE);
         linePHosNam3.setVisibility(View.GONE);
         secPHosNamOth3.setVisibility(View.GONE);
         linePHosNamOth3.setVisibility(View.GONE);
         secPDtAdmHos.setVisibility(View.GONE);
         linePDtAdmHos.setVisibility(View.GONE);
         secPAdmHosM.setVisibility(View.GONE);
         linePAdmHosM.setVisibility(View.GONE);
         secPDurIlBeHos.setVisibility(View.GONE);
         linePDurIlBeHos.setVisibility(View.GONE);
         secPDisDr.setVisibility(View.GONE);
         linePDisDr.setVisibility(View.GONE);
         secPDisDrOth.setVisibility(View.GONE);
         linePDisDrOth.setVisibility(View.GONE);
         secPReco.setVisibility(View.GONE);
         linePReco.setVisibility(View.GONE);
         secPDurReco.setVisibility(View.GONE);
         linePDurReco.setVisibility(View.GONE);
         secPAboIll.setVisibility(View.GONE);
         linePAboIll.setVisibility(View.GONE);
         secPEpiIlness.setVisibility(View.GONE);
         linePEpiIlness.setVisibility(View.GONE);
         secPFever.setVisibility(View.GONE);
         linePFever.setVisibility(View.GONE);
         secPDurFever.setVisibility(View.GONE);
         linePDurFever.setVisibility(View.GONE);
         secPCough.setVisibility(View.GONE);
         linePCough.setVisibility(View.GONE);
         secPDurCough.setVisibility(View.GONE);
         linePDurCough.setVisibility(View.GONE);
         secPDifBrea.setVisibility(View.GONE);
         linePDifBrea.setVisibility(View.GONE);
         secPDurDifBrea.setVisibility(View.GONE);
         linePDurDifBrea.setVisibility(View.GONE);
         secPTurnBlue.setVisibility(View.GONE);
         linePTurnBlue.setVisibility(View.GONE);
         secPDurTurnBlue.setVisibility(View.GONE);
         linePDurTurnBlue.setVisibility(View.GONE);
         secPBreatNois.setVisibility(View.GONE);
         linePBreatNois.setVisibility(View.GONE);
         secPDurBreatNois.setVisibility(View.GONE);
         linePDurBreatNois.setVisibility(View.GONE);
         secPLethargy.setVisibility(View.GONE);
         linePLethargy.setVisibility(View.GONE);
         secPDurLethargy.setVisibility(View.GONE);
         linePDurLethargy.setVisibility(View.GONE);
         secPUnDriBfeed.setVisibility(View.GONE);
         linePUnDriBfeed.setVisibility(View.GONE);
         secPDurUnDriBfeed.setVisibility(View.GONE);
         linePDurUnDriBfeed.setVisibility(View.GONE);
         secPVomit.setVisibility(View.GONE);
         linePVomit.setVisibility(View.GONE);
         secPConv.setVisibility(View.GONE);
         linePConv.setVisibility(View.GONE);
         secPUpRolEye.setVisibility(View.GONE);
         linePUpRolEye.setVisibility(View.GONE);
         secPRigJaw.setVisibility(View.GONE);
         linePRigJaw.setVisibility(View.GONE);
         secPRigLim.setVisibility(View.GONE);
         linePRigLim.setVisibility(View.GONE);
         secPDurConv.setVisibility(View.GONE);
         linePDurConv.setVisibility(View.GONE);
         secPUncons.setVisibility(View.GONE);
         linePUncons.setVisibility(View.GONE);
         secPDurUncons.setVisibility(View.GONE);
         linePDurUncons.setVisibility(View.GONE);
         secPIlHCar.setVisibility(View.GONE);
         linePIlHCar.setVisibility(View.GONE);
         secPHCarTypLabel.setVisibility(View.GONE);
         linePHCarTypLabel.setVisibility(View.GONE);
         secPHC_PhyMBBS.setVisibility(View.GONE);
         linePHC_PhyMBBS.setVisibility(View.GONE);
         secPHC_UnquaDoctor.setVisibility(View.GONE);
         linePHC_UnquaDoctor.setVisibility(View.GONE);
         secPHC_Para.setVisibility(View.GONE);
         linePHC_Para.setVisibility(View.GONE);
         secPHC_Com.setVisibility(View.GONE);
         linePHC_Com.setVisibility(View.GONE);
         secPHC_Pha.setVisibility(View.GONE);
         linePHC_Pha.setVisibility(View.GONE);
         secHC_Hompath.setVisibility(View.GONE);
         lineHC_Hompath.setVisibility(View.GONE);
         secPHC_TrHeal.setVisibility(View.GONE);
         linePHC_TrHeal.setVisibility(View.GONE);
         secPHC_SpiHeal.setVisibility(View.GONE);
         linePHC_SpiHeal.setVisibility(View.GONE);
         secPHC_Oth.setVisibility(View.GONE);
         linePHC_Oth.setVisibility(View.GONE);
         secPHC_OthName.setVisibility(View.GONE);
         linePHC_OthName.setVisibility(View.GONE);
         secPDSHOPD.setVisibility(View.GONE);
         linePDSHOPD.setVisibility(View.GONE);
         secPSSFOPD.setVisibility(View.GONE);
         linePSSFOPD.setVisibility(View.GONE);
         secPAdmHos.setVisibility(View.GONE);
         linePAdmHos.setVisibility(View.GONE);
         secPHosNamLabel.setVisibility(View.GONE);
         linePHosNamLabel.setVisibility(View.GONE);
         secPHosNam.setVisibility(View.GONE);
         linePHosNam.setVisibility(View.GONE);
         secPHosNamOth.setVisibility(View.GONE);
         linePHosNamOth.setVisibility(View.GONE);
         secPHosNam2.setVisibility(View.GONE);
         linePHosNam2.setVisibility(View.GONE);
         secPHosNamOth2.setVisibility(View.GONE);
         linePHosNamOth2.setVisibility(View.GONE);
         secPHosNam3.setVisibility(View.GONE);
         linePHosNam3.setVisibility(View.GONE);
         secPHosNamOth3.setVisibility(View.GONE);
         linePHosNamOth3.setVisibility(View.GONE);
         secPDtAdmHos.setVisibility(View.GONE);
         linePDtAdmHos.setVisibility(View.GONE);
         secPAdmHosM.setVisibility(View.GONE);
         linePAdmHosM.setVisibility(View.GONE);
         secPDurIlBeHos.setVisibility(View.GONE);
         linePDurIlBeHos.setVisibility(View.GONE);
         secPDisDr.setVisibility(View.GONE);
         linePDisDr.setVisibility(View.GONE);
         secPDisDrOth.setVisibility(View.GONE);
         linePDisDrOth.setVisibility(View.GONE);
         secPReco.setVisibility(View.GONE);
         linePReco.setVisibility(View.GONE);
         secPDurReco.setVisibility(View.GONE);
         linePDurReco.setVisibility(View.GONE);
         secPAboIll.setVisibility(View.GONE);
         linePAboIll.setVisibility(View.GONE);
         secPDurFever.setVisibility(View.GONE);
         linePDurFever.setVisibility(View.GONE);
         secPDurFever.setVisibility(View.GONE);
         linePDurFever.setVisibility(View.GONE);
         secPDurCough.setVisibility(View.GONE);
         linePDurCough.setVisibility(View.GONE);
         secPDurCough.setVisibility(View.GONE);
         linePDurCough.setVisibility(View.GONE);
         secPDurDifBrea.setVisibility(View.GONE);
         linePDurDifBrea.setVisibility(View.GONE);
         secPDurDifBrea.setVisibility(View.GONE);
         linePDurDifBrea.setVisibility(View.GONE);
         secPDurTurnBlue.setVisibility(View.GONE);
         linePDurTurnBlue.setVisibility(View.GONE);
         secPDurTurnBlue.setVisibility(View.GONE);
         linePDurTurnBlue.setVisibility(View.GONE);
         secPDurBreatNois.setVisibility(View.GONE);
         linePDurBreatNois.setVisibility(View.GONE);
         secPDurBreatNois.setVisibility(View.GONE);
         linePDurBreatNois.setVisibility(View.GONE);
         secPDurLethargy.setVisibility(View.GONE);
         linePDurLethargy.setVisibility(View.GONE);
         secPDurLethargy.setVisibility(View.GONE);
         linePDurLethargy.setVisibility(View.GONE);
         secPDurUnDriBfeed.setVisibility(View.GONE);
         linePDurUnDriBfeed.setVisibility(View.GONE);
         secPDurUnDriBfeed.setVisibility(View.GONE);
         linePDurUnDriBfeed.setVisibility(View.GONE);
         secPDurUnDriBfeed.setVisibility(View.GONE);
         linePDurUnDriBfeed.setVisibility(View.GONE);
         secPUpRolEye.setVisibility(View.GONE);
         linePUpRolEye.setVisibility(View.GONE);
         secPRigJaw.setVisibility(View.GONE);
         linePRigJaw.setVisibility(View.GONE);
         secPRigLim.setVisibility(View.GONE);
         linePRigLim.setVisibility(View.GONE);
         secPDurConv.setVisibility(View.GONE);
         linePDurConv.setVisibility(View.GONE);
         secPUpRolEye.setVisibility(View.GONE);
         linePUpRolEye.setVisibility(View.GONE);
         secPRigJaw.setVisibility(View.GONE);
         linePRigJaw.setVisibility(View.GONE);
         secPRigLim.setVisibility(View.GONE);
         linePRigLim.setVisibility(View.GONE);
         secPDurConv.setVisibility(View.GONE);
         linePDurConv.setVisibility(View.GONE);
         secPDurUncons.setVisibility(View.GONE);
         linePDurUncons.setVisibility(View.GONE);
         secPDurUncons.setVisibility(View.GONE);
         linePDurUncons.setVisibility(View.GONE);
         secPHCarTypLabel.setVisibility(View.GONE);
         linePHCarTypLabel.setVisibility(View.GONE);
         secPHC_PhyMBBS.setVisibility(View.GONE);
         linePHC_PhyMBBS.setVisibility(View.GONE);
         secPHC_UnquaDoctor.setVisibility(View.GONE);
         linePHC_UnquaDoctor.setVisibility(View.GONE);
         secPHC_Para.setVisibility(View.GONE);
         linePHC_Para.setVisibility(View.GONE);
         secPHC_Com.setVisibility(View.GONE);
         linePHC_Com.setVisibility(View.GONE);
         secPHC_Pha.setVisibility(View.GONE);
         linePHC_Pha.setVisibility(View.GONE);
         secHC_Hompath.setVisibility(View.GONE);
         lineHC_Hompath.setVisibility(View.GONE);
         secPHC_TrHeal.setVisibility(View.GONE);
         linePHC_TrHeal.setVisibility(View.GONE);
         secPHC_SpiHeal.setVisibility(View.GONE);
         linePHC_SpiHeal.setVisibility(View.GONE);
         secPHC_Oth.setVisibility(View.GONE);
         linePHC_Oth.setVisibility(View.GONE);
         secPHC_OthName.setVisibility(View.GONE);
         linePHC_OthName.setVisibility(View.GONE);
         secPHCarTypLabel.setVisibility(View.GONE);
         linePHCarTypLabel.setVisibility(View.GONE);
         secPHC_PhyMBBS.setVisibility(View.GONE);
         linePHC_PhyMBBS.setVisibility(View.GONE);
         secPHC_UnquaDoctor.setVisibility(View.GONE);
         linePHC_UnquaDoctor.setVisibility(View.GONE);
         secPHC_Para.setVisibility(View.GONE);
         linePHC_Para.setVisibility(View.GONE);
         secPHC_Com.setVisibility(View.GONE);
         linePHC_Com.setVisibility(View.GONE);
         secPHC_Pha.setVisibility(View.GONE);
         linePHC_Pha.setVisibility(View.GONE);
         secHC_Hompath.setVisibility(View.GONE);
         lineHC_Hompath.setVisibility(View.GONE);
         secPHC_TrHeal.setVisibility(View.GONE);
         linePHC_TrHeal.setVisibility(View.GONE);
         secPHC_SpiHeal.setVisibility(View.GONE);
         linePHC_SpiHeal.setVisibility(View.GONE);
         secPHC_Oth.setVisibility(View.GONE);
         linePHC_Oth.setVisibility(View.GONE);
         secPHC_OthName.setVisibility(View.GONE);
         linePHC_OthName.setVisibility(View.GONE);
         secPHC_OthName.setVisibility(View.GONE);
         linePHC_OthName.setVisibility(View.GONE);
         secPHC_OthName.setVisibility(View.GONE);
         linePHC_OthName.setVisibility(View.GONE);
         secPHosNamOth.setVisibility(View.GONE);
         linePHosNamOth.setVisibility(View.GONE);
         secPHosNamOth.setVisibility(View.GONE);
         linePHosNamOth.setVisibility(View.GONE);
         secPHosNamOth.setVisibility(View.GONE);
         linePHosNamOth.setVisibility(View.GONE);
         secPHosNamOth2.setVisibility(View.GONE);
         linePHosNamOth2.setVisibility(View.GONE);
         secPHosNamOth2.setVisibility(View.GONE);
         linePHosNamOth2.setVisibility(View.GONE);
         secPHosNamOth2.setVisibility(View.GONE);
         linePHosNamOth2.setVisibility(View.GONE);
         secPHosNamOth3.setVisibility(View.GONE);
         linePHosNamOth3.setVisibility(View.GONE);
         secPHosNamOth3.setVisibility(View.GONE);
         linePHosNamOth3.setVisibility(View.GONE);
         secPHosNamOth3.setVisibility(View.GONE);
         linePHosNamOth3.setVisibility(View.GONE);
         secPDisDrOth.setVisibility(View.GONE);
         linePDisDrOth.setVisibility(View.GONE);
         secPDisDrOth.setVisibility(View.GONE);
         linePDisDrOth.setVisibility(View.GONE);
         secPDisDrOth.setVisibility(View.GONE);
         linePDisDrOth.setVisibility(View.GONE);
         secPDisDrOth.setVisibility(View.GONE);
         linePDisDrOth.setVisibility(View.GONE);
         secPDisDrOth.setVisibility(View.GONE);
         linePDisDrOth.setVisibility(View.GONE);
         secPDisDrOth.setVisibility(View.GONE);
         linePDisDrOth.setVisibility(View.GONE);
         secPDisDrOth.setVisibility(View.GONE);
         linePDisDrOth.setVisibility(View.GONE);
         secPDisDrOth.setVisibility(View.GONE);
         linePDisDrOth.setVisibility(View.GONE);
         secPDurReco.setVisibility(View.GONE);
         linePDurReco.setVisibility(View.GONE);
         secPDurReco.setVisibility(View.GONE);
         linePDurReco.setVisibility(View.GONE);


         DataSearch(UNCODE,STRUCTURENO,HOUSEHOLDSL,VISITNO,MEMSL);

        Button cmdSave = (Button) findViewById(R.id.cmdSave);
        cmdSave.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) { 
            DataSave();
        }});
     }
     catch(Exception  e)
     {
         Connection.MessageBox(PneumoniaCase.this, e.getMessage());
         return;
     }
 }

 private void DataSave()
 {
   try
     {


         String DV="";
         DV = Global.DateValidate(dtpPDtAdmHos.getText().toString());

         if(txtUNCode.getText().toString().length()==0 & secUNCode.isShown())
           {
             Connection.MessageBox(PneumoniaCase.this, "Required field: Ward No.");
             txtUNCode.requestFocus(); 
             return;	
           }
         else if(txtStructureNo.getText().toString().length()==0 & secStructureNo.isShown())
           {
             Connection.MessageBox(PneumoniaCase.this, "Required field: Structure No.");
             txtStructureNo.requestFocus(); 
             return;	
           }
         else if(txtHouseholdSl.getText().toString().length()==0 & secHouseholdSl.isShown())
           {
             Connection.MessageBox(PneumoniaCase.this, "Required field: Household Sl.");
             txtHouseholdSl.requestFocus(); 
             return;	
           }
         else if(txtVisitNo.getText().toString().length()==0 & secVisitNo.isShown())
           {
             Connection.MessageBox(PneumoniaCase.this, "Required field: Visit No.");
             txtVisitNo.requestFocus(); 
             return;	
           }
         else if(txtMemSl.getText().toString().length()==0 & secMemSl.isShown())
           {
             Connection.MessageBox(PneumoniaCase.this, "Required field: Member Serial.");
             txtMemSl.requestFocus(); 
             return;	
           }
         
         else if(!rdoPDSign1.isChecked() & !rdoPDSign2.isChecked() & !rdoPDSign3.isChecked() & secPDSign.isShown())
           {
              Connection.MessageBox(PneumoniaCase.this, "Select anyone options from (গত ১২ মাসে আপনার শিশুর কি কাশি অথবা শ্বাসকষ্ট এবং উপর লিখিত সাধারন বিপদজনক লক্ষণ গুলো ছিল কি? (পূর্বের বর্ণনা করা অসুস্থতা ছাড়া (Within the last 12 months did this child have an illness (Besides what was described for question 3) with cough or difficulty breathing AND any of the following danger signs?) ).");
              rdoPDSign1.requestFocus();
              return;
           }
         else if(txtPEpiIlness.getText().toString().length()==0 & secPEpiIlness.isShown())
           {
             Connection.MessageBox(PneumoniaCase.this, "Required field: গত ১২ মাসে এই শিশুর কতবার এই ধরনের অসুস্থতা হয়েছিল? (যদি একের অধিক এই অসুস্থতা হয়ে থাকে তবে অতিসম্প্রতি অসুস্থতা সম্পর্কে নিচের প্রশ্নগুলো করুন (Within the last 12 months how many episodes of such an illness did this child have? If >1 episodes, ask about the following questions on the most recent episode).");
             txtPEpiIlness.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtPEpiIlness.getText().toString().length()==0 ? "01" : txtPEpiIlness.getText().toString()) < 01 || Integer.valueOf(txtPEpiIlness.getText().toString().length()==0 ? "20" : txtPEpiIlness.getText().toString()) > 20 & secPEpiIlness.isShown())
           {
             Connection.MessageBox(PneumoniaCase.this, "Value should be between 01 and 20(গত ১২ মাসে এই শিশুর কতবার এই ধরনের অসুস্থতা হয়েছিল? (যদি একের অধিক এই অসুস্থতা হয়ে থাকে তবে অতিসম্প্রতি অসুস্থতা সম্পর্কে নিচের প্রশ্নগুলো করুন (Within the last 12 months how many episodes of such an illness did this child have? If >1 episodes, ask about the following questions on the most recent episode)).");
             txtPEpiIlness.requestFocus(); 
             return;	
           }
         
         else if(!rdoPFever1.isChecked() & !rdoPFever2.isChecked() & !rdoPFever3.isChecked() & secPFever.isShown())
           {
              Connection.MessageBox(PneumoniaCase.this, "Select anyone options from (সর্বশেষ অসুস্থতার সময় এই শিশুটির কি জ্বর হয়েছিল? (During the last episode of illness did the child have fever?)).");
              rdoPFever1.requestFocus();
              return;
           }
         else if(txtPDurFever.getText().toString().length()==0 & secPDurFever.isShown())
           {
             Connection.MessageBox(PneumoniaCase.this, "Required field: যদি হ্যাঁ হয়, শিশুটি কতদিন জ্বরে ভুগেছিল? (যদি জানা না থাকে 98 বসান) (If yes, how long did the child have fever?).");
             txtPDurFever.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtPDurFever.getText().toString().length()==0 ? "02" : txtPDurFever.getText().toString()) < 02 || Integer.valueOf(txtPDurFever.getText().toString().length()==0 ? "98" : txtPDurFever.getText().toString()) > 98& secPDurFever.isShown())
           {
             Connection.MessageBox(PneumoniaCase.this, "Value should be between 02 and 98(যদি হ্যাঁ হয়, শিশুটি কতদিন জ্বরে ভুগেছিল? (যদি জানা না থাকে 98 বসান) (If yes, how long did the child have fever?)).");
             txtPDurFever.requestFocus(); 
             return;	
           }
         
         else if(!rdoPCough1.isChecked() & !rdoPCough2.isChecked() & !rdoPCough3.isChecked() & secPCough.isShown())
           {
              Connection.MessageBox(PneumoniaCase.this, "Select anyone options from (সর্বশেষ অসুস্থতার সময় এই শিশুটির কি কাশি ছিল? (During the last episode of illness did the child have a cough?)).");
              rdoPCough1.requestFocus();
              return;
           }
         else if(txtPDurCough.getText().toString().length()==0 & secPDurCough.isShown())
           {
             Connection.MessageBox(PneumoniaCase.this, "Required field: যদি হ্যাঁ হয়, তবে কতদিন কাশি ছিল? (যদি জানা না থাকে 98 বসান) (If yes, for how long?).");
             txtPDurCough.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtPDurCough.getText().toString().length()==0 ? "01" : txtPDurCough.getText().toString()) < 01 || Integer.valueOf(txtPDurCough.getText().toString().length()==0 ? "98" : txtPDurCough.getText().toString()) > 98& secPDurCough.isShown())
           {
             Connection.MessageBox(PneumoniaCase.this, "Value should be between 01 and 98(যদি হ্যাঁ হয়, তবে কতদিন কাশি ছিল? (যদি জানা না থাকে 98 বসান) (If yes, for how long?)).");
             txtPDurCough.requestFocus(); 
             return;	
           }
         
         else if(!rdoPDifBrea1.isChecked() & !rdoPDifBrea2.isChecked() & !rdoPDifBrea3.isChecked() & secPDifBrea.isShown())
           {
              Connection.MessageBox(PneumoniaCase.this, "Select anyone options from (সর্বশেষ অসুস্থতার সময় এই শিশুটির কি শ্বাসকষ্ট ছিল? (During the last episode of illness did the child have difficulty breathing?)).");
              rdoPDifBrea1.requestFocus();
              return;
           }
         else if(txtPDurDifBrea.getText().toString().length()==0 & secPDurDifBrea.isShown())
           {
             Connection.MessageBox(PneumoniaCase.this, "Required field: যদি হ্যাঁ হয়, তবে কতদিন শ্বাসকষ্ট ছিল?(যদি জানা না থাকে 98 বসান) (If yes, for how long?).");
             txtPDurDifBrea.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtPDurDifBrea.getText().toString().length()==0 ? "01" : txtPDurDifBrea.getText().toString()) < 01 || Integer.valueOf(txtPDurDifBrea.getText().toString().length()==0 ? "98" : txtPDurDifBrea.getText().toString()) > 98& secPDurDifBrea.isShown())
           {
             Connection.MessageBox(PneumoniaCase.this, "Value should be between 01 and 98(যদি হ্যাঁ হয়, তবে কতদিন শ্বাসকষ্ট ছিল?(যদি জানা না থাকে 98 বসান) (If yes, for how long?)).");
             txtPDurDifBrea.requestFocus(); 
             return;	
           }
         
         else if(!rdoPTurnBlue1.isChecked() & !rdoPTurnBlue2.isChecked() & !rdoPTurnBlue3.isChecked() & secPTurnBlue.isShown())
           {
              Connection.MessageBox(PneumoniaCase.this, "Select anyone options from (সর্বশেষ অসুস্থতার সময় এই শিশুটির কি নীল হয়ে গিয়েছিল ? (During the last episode of illness did the child turn blue?)).");
              rdoPTurnBlue1.requestFocus();
              return;
           }
         else if(txtPDurTurnBlue.getText().toString().length()==0 & secPDurTurnBlue.isShown())
           {
             Connection.MessageBox(PneumoniaCase.this, "Required field: যদি হ্যাঁ হয়, তবে কতদিন নীল হয়ে ছিল? (যদি জানা না থাকে 98 বসান) (If yes, for how long?).");
             txtPDurTurnBlue.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtPDurTurnBlue.getText().toString().length()==0 ? "01" : txtPDurTurnBlue.getText().toString()) < 01 || Integer.valueOf(txtPDurTurnBlue.getText().toString().length()==0 ? "98" : txtPDurTurnBlue.getText().toString()) > 98 & secPDurTurnBlue.isShown())
           {
             Connection.MessageBox(PneumoniaCase.this, "Value should be between 01 and 98(যদি হ্যাঁ হয়, তবে কতদিন নীল হয়ে ছিল? (যদি জানা না থাকে 98 বসান) (If yes, for how long?)).");
             txtPDurTurnBlue.requestFocus(); 
             return;	
           }
         
         else if(!rdoPBreatNois1.isChecked() & !rdoPBreatNois2.isChecked() & !rdoPBreatNois3.isChecked() & secPBreatNois.isShown())
           {
              Connection.MessageBox(PneumoniaCase.this, "Select anyone options from (সর্বশেষ অসুস্থতার সময় এই শিশুটির কি শ্বাস নেবার সময় ঘরঘর শব্দ হত ? (During the last episode of illness did the child breathe noisily?)).");
              rdoPBreatNois1.requestFocus();
              return;
           }
         else if(txtPDurBreatNois.getText().toString().length()==0 & secPDurBreatNois.isShown())
           {
             Connection.MessageBox(PneumoniaCase.this, "Required field: যদি হ্যাঁ হয়, তবে কতদিন ঘরঘর শব্দ হয়েছিল? (যদি জানা না থাকে 98 বসান) (If yes, for how long?).");
             txtPDurBreatNois.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtPDurBreatNois.getText().toString().length()==0 ? "01" : txtPDurBreatNois.getText().toString()) < 01 || Integer.valueOf(txtPDurBreatNois.getText().toString().length()==0 ? "98" : txtPDurBreatNois.getText().toString()) > 98& secPDurBreatNois.isShown())
           {
             Connection.MessageBox(PneumoniaCase.this, "Value should be between 01 and 98(যদি হ্যাঁ হয়, তবে কতদিন ঘরঘর শব্দ হয়েছিল? (যদি জানা না থাকে 98 বসান) (If yes, for how long?)).");
             txtPDurBreatNois.requestFocus(); 
             return;	
           }
         else if(spnPLethargy.getSelectedItemPosition()==0  & secPLethargy.isShown())
           {
             Connection.MessageBox(PneumoniaCase.this, "Required field: সর্বশেষ অসুস্থতার সময় এই শিশুটিকে ঘুম থেকে জাগানো বা জাগ্রত রাখা যাচ্ছে না (জাগালেও আবার ঘুমিয়ে যায় এমন) এমন অবস্থা হয়েছিল (ঝিমুনি)? (During the last episode of illness was it difficult to awaken the child/ keep the child awake/ keep from going to sleep?).");
             spnPLethargy.requestFocus(); 
             return;	
           }
         else if(txtPDurLethargy.getText().toString().length()==0 & secPDurLethargy.isShown())
           {
             Connection.MessageBox(PneumoniaCase.this, "Required field: যদি হ্যাঁ হয়, তবে কতদিন এমন অবস্থা হয়েছিল?(যদি জানা না থাকে 98 বসান) (If yes, for how long?).");
             txtPDurLethargy.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtPDurLethargy.getText().toString().length()==0 ? "01" : txtPDurLethargy.getText().toString()) < 01 || Integer.valueOf(txtPDurLethargy.getText().toString().length()==0 ? "98" : txtPDurLethargy.getText().toString()) > 98  & secPDurLethargy.isShown())
           {
             Connection.MessageBox(PneumoniaCase.this, "Value should be between 01 and 98(যদি হ্যাঁ হয়, তবে কতদিন এমন অবস্থা হয়েছিল?(যদি জানা না থাকে 98 বসান) (If yes, for how long?)).");
             txtPDurLethargy.requestFocus(); 
             return;	
           }
         else if(spnPUnDriBfeed.getSelectedItemPosition()==0  & secPUnDriBfeed.isShown())
           {
             Connection.MessageBox(PneumoniaCase.this, "Required field: ৬ মাসের কম বয়সী শিশুর ক্ষেত্রেঃ সর্বশেষ অসুস্থতার সময় এই শিশুটির কি পানি/বুকের দুধ পান করতে পারেনি এমন অবস্থা হয়েছিল  ?For children <6 months of age: During the last episode of illness, was the child ever unable to drink/ breastfeed?.");
             spnPUnDriBfeed.requestFocus(); 
             return;	
           }
         else if(txtPDurUnDriBfeed.getText().toString().length()==0 & secPDurUnDriBfeed.isShown())
           {
             Connection.MessageBox(PneumoniaCase.this, "Required field: যদি হ্যাঁ হয়, তবে কতদিন এমন অবস্থা হয়েছিল?(যদি জানা না থাকে 98 বসান) (If yes, for how long?).");
             txtPDurUnDriBfeed.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtPDurUnDriBfeed.getText().toString().length()==0 ? "01" : txtPDurUnDriBfeed.getText().toString()) < 01 || Integer.valueOf(txtPDurUnDriBfeed.getText().toString().length()==0 ? "98" : txtPDurUnDriBfeed.getText().toString()) > 98& secPDurUnDriBfeed.isShown())
           {
             Connection.MessageBox(PneumoniaCase.this, "Value should be between 01 and 98(যদি হ্যাঁ হয়, তবে কতদিন এমন অবস্থা হয়েছিল?(যদি জানা না থাকে 98 বসান) (If yes, for how long?)).");
             txtPDurUnDriBfeed.requestFocus(); 
             return;	
           }
         
         else if(!rdoPVomit1.isChecked() & !rdoPVomit2.isChecked() & !rdoPVomit3.isChecked() & secPVomit.isShown())
           {
              Connection.MessageBox(PneumoniaCase.this, "Select anyone options from ( সর্বশেষ অসুস্থতার সময় এই শিশুটির কি যা খেত বা পান করত সবই বমি করে দিত এমন অবস্থা হয়েছিল? (During the last episode of illness did the child ever vomit everything they ate and drank?)).");
              rdoPVomit1.requestFocus();
              return;
           }
         
         else if(!rdoPConv1.isChecked() & !rdoPConv2.isChecked() & !rdoPConv3.isChecked() & secPConv.isShown())
           {
              Connection.MessageBox(PneumoniaCase.this, "Select anyone options from (সর্বশেষ অসুস্থতার সময় এই শিশুটির কি খিঁচুনি হয়েছিল  ? (During the last episode of illness did the child have convulsions?)).");
              rdoPConv1.requestFocus();
              return;
           }
         
         else if(!rdoPUpRolEye1.isChecked() & !rdoPUpRolEye2.isChecked() & !rdoPUpRolEye3.isChecked() & secPUpRolEye.isShown())
           {
              Connection.MessageBox(PneumoniaCase.this, "Select anyone options from ( খিঁচুনির সময় কি চোখ উল্টে  গিয়েছিল? (Did the convulsions include upward rolling of eyeball?)).");
              rdoPUpRolEye1.requestFocus();
              return;
           }
         
         else if(!rdoPRigJaw1.isChecked() & !rdoPRigJaw2.isChecked() & !rdoPRigJaw3.isChecked() & secPRigJaw.isShown())
           {
              Connection.MessageBox(PneumoniaCase.this, "Select anyone options from ( খিঁচুনির সময় কি চোয়ালের মাংসপেশি শক্ত হয়ে গিয়েছিল?, চোয়ালের মাংসপেশি শক্ত/ মুখ খুলতে/ বন্ধ করতে না পারা( Did the convulsions include rigid jaw muscles?,Stiffening/hardening of jaw muscles; cannot open /close his/her mouth)).");
              rdoPRigJaw1.requestFocus();
              return;
           }
         
         else if(!rdoPRigLim1.isChecked() & !rdoPRigLim2.isChecked() & !rdoPRigLim3.isChecked() & secPRigLim.isShown())
           {
              Connection.MessageBox(PneumoniaCase.this, "Select anyone options from (খিঁচুনির সময় কি হাত পা শক্ত হয়ে গিয়েছিল?,  হাতের মুষ্টি খুলতে গেলে বা হাত পা সোজা করতে গেলে বাধা পাওয়া  (Did the convulsions include rigid limbs?, There is resistance on trying to open the limbs or fist)).");
              rdoPRigLim1.requestFocus();
              return;
           }
         else if(spnPDurConv.getSelectedItemPosition()==0  & secPDurConv.isShown())
           {
             Connection.MessageBox(PneumoniaCase.this, "Required field:  খিঁচুনি কতক্ষন ছিল? (What was the duration of convulsions?).");
             spnPDurConv.requestFocus(); 
             return;	
           }
         
         else if(!rdoPUncons1.isChecked() & !rdoPUncons2.isChecked() & !rdoPUncons3.isChecked() & secPUncons.isShown())
           {
              Connection.MessageBox(PneumoniaCase.this, "Select anyone options from ( সর্বশেষ অসুস্থতার সময় এই শিশুটি যে কোন সময়ের জন্য অজ্ঞান হয়েছিল? (During the last episode of illness was the child unconscious for any length of time?)).");
              rdoPUncons1.requestFocus();
              return;
           }
         else if(spnPDurUncons.getSelectedItemPosition()==0  & secPDurUncons.isShown())
           {
             Connection.MessageBox(PneumoniaCase.this, "Required field: কতক্ষন অজ্ঞান ছিল? (What was the duration of unconsciousness?).");
             spnPDurUncons.requestFocus(); 
             return;	
           }
         
         else if(!rdoPIlHCar1.isChecked() & !rdoPIlHCar2.isChecked() & !rdoPIlHCar3.isChecked() & secPIlHCar.isShown())
           {
              Connection.MessageBox(PneumoniaCase.this, "Select anyone options from (সর্বশেষ অসুস্থতার সময় এই শিশুটিকে কি কোন স্বাস্থ্যসেবা দানকারীর কাছে নিয়ে গিয়েছিলেন? (During the last episode of episode of illness, did you bring your child to a health care provider?)).");
              rdoPIlHCar1.requestFocus();
              return;
           }
         
         else if(!rdoPHC_PhyMBBS1.isChecked() & !rdoPHC_PhyMBBS2.isChecked() & !rdoPHC_PhyMBBS3.isChecked() & secPHC_PhyMBBS.isShown())
           {
              Connection.MessageBox(PneumoniaCase.this, "Select anyone options from (1.পাশ করা ডাক্তার যেমন MBBS বা এর উপর (MBBS and above) ).");
              rdoPHC_PhyMBBS1.requestFocus();
              return;
           }
         
         else if(!rdoPHC_UnquaDoctor1.isChecked() & !rdoPHC_UnquaDoctor2.isChecked() & !rdoPHC_UnquaDoctor3.isChecked() & secPHC_UnquaDoctor.isShown())
           {
              Connection.MessageBox(PneumoniaCase.this, "Select anyone options from (2.অদক্ষ ডাক্তার/ LMAF (Unqualified doctor/LMAF) ).");
              rdoPHC_UnquaDoctor1.requestFocus();
              return;
           }
         
         else if(!rdoPHC_Para1.isChecked() & !rdoPHC_Para2.isChecked() & !rdoPHC_Para3.isChecked() & secPHC_Para.isShown())
           {
              Connection.MessageBox(PneumoniaCase.this, "Select anyone options from (3.প্যারামেডিক (GoB/NGO) (Paramedics (GoB/NGO))  ).");
              rdoPHC_Para1.requestFocus();
              return;
           }
         
         else if(!rdoPHC_Com1.isChecked() & !rdoPHC_Com2.isChecked() & !rdoPHC_Com3.isChecked() & secPHC_Com.isShown())
           {
              Connection.MessageBox(PneumoniaCase.this, "Select anyone options from (4.কম্পাউণ্ডার (Compounder)).");
              rdoPHC_Com1.requestFocus();
              return;
           }
         
         else if(!rdoPHC_Pha1.isChecked() & !rdoPHC_Pha2.isChecked() & !rdoPHC_Pha3.isChecked() & secPHC_Pha.isShown())
           {
              Connection.MessageBox(PneumoniaCase.this, "Select anyone options from (5.ঔষধ বিক্রেতা/ফার্মেসি (Drug seller/Pharmacy)  ).");
              rdoPHC_Pha1.requestFocus();
              return;
           }
         
         else if(!rdoHC_Hompath1.isChecked() & !rdoHC_Hompath2.isChecked() & !rdoHC_Hompath3.isChecked() & secHC_Hompath.isShown())
           {
              Connection.MessageBox(PneumoniaCase.this, "Select anyone options from (6.হোমিওপ্যাঁথ (Homeopath)  ).");
              rdoHC_Hompath1.requestFocus();
              return;
           }
         
         else if(!rdoPHC_TrHeal1.isChecked() & !rdoPHC_TrHeal2.isChecked() & !rdoPHC_TrHeal3.isChecked() & secPHC_TrHeal.isShown())
           {
              Connection.MessageBox(PneumoniaCase.this, "Select anyone options from (7.কবিরাজ (Traditional care provider)  ).");
              rdoPHC_TrHeal1.requestFocus();
              return;
           }
         
         else if(!rdoPHC_SpiHeal1.isChecked() & !rdoPHC_SpiHeal2.isChecked() & !rdoPHC_SpiHeal3.isChecked() & secPHC_SpiHeal.isShown())
           {
              Connection.MessageBox(PneumoniaCase.this, "Select anyone options from (8.আধ্যাত্মিক চিকিৎসক (Spiritual healer) ).");
              rdoPHC_SpiHeal1.requestFocus();
              return;
           }
         
         else if(!rdoPHC_Oth1.isChecked() & !rdoPHC_Oth2.isChecked() & !rdoPHC_Oth3.isChecked() & secPHC_Oth.isShown())
           {
              Connection.MessageBox(PneumoniaCase.this, "Select anyone options from (9.অন্যান্য  (Other)).");
              rdoPHC_Oth1.requestFocus();
              return;
           }
         else if(txtPHC_OthName.getText().toString().length()==0 & secPHC_OthName.isShown())
           {
             Connection.MessageBox(PneumoniaCase.this, "Required field: 10.অন্যান্য উল্লেখ করুন (Others Specify).");
             txtPHC_OthName.requestFocus(); 
             return;	
           }
         
         else if(!rdoPDSHOPD1.isChecked() & !rdoPDSHOPD2.isChecked() & !rdoPDSHOPD3.isChecked() & secPDSHOPD.isShown())
           {
              Connection.MessageBox(PneumoniaCase.this, "Select anyone options from (শিশুটিকে কি ঢাকা শিশু হাসপাতালের বহির্বিভাগে নেয়া হয়েছিল? ( Was the child seen at outdoor patient at Dhaka Shishu Hospital?)).");
              rdoPDSHOPD1.requestFocus();
              return;
           }
         
         else if(!rdoPSSFOPD1.isChecked() & !rdoPSSFOPD2.isChecked() & !rdoPSSFOPD3.isChecked() & secPSSFOPD.isShown())
           {
              Connection.MessageBox(PneumoniaCase.this, "Select anyone options from (শিশুটিকে কি মিরপুর ডাঃ এম আর খান  শিশু হাসপাতাল  এর  বহির্বিভাগে নেয়া হয়েছিল ? (Was the child seen as an outdoor patient at Mirpur Dr. MR Khan Shishu Hospital?)).");
              rdoPSSFOPD1.requestFocus();
              return;
           }
         
         else if(!rdoPAdmHos1.isChecked() & !rdoPAdmHos2.isChecked() & !rdoPAdmHos3.isChecked() & secPAdmHos.isShown())
           {
              Connection.MessageBox(PneumoniaCase.this, "Select anyone options from (এই অসুস্থতার জন্য শিশুটিকে কি হাসপাতালে ভর্তি করা হয়েছিল?  (During this episode of illness, was your child hospitalized?)).");
              rdoPAdmHos1.requestFocus();
              return;
           }
         else if(spnPHosNam.getSelectedItemPosition()==0  & secPHosNam.isShown())
           {
             Connection.MessageBox(PneumoniaCase.this, "Required field: 1..");
             spnPHosNam.requestFocus(); 
             return;	
           }
         else if(txtPHosNamOth.getText().toString().length()==0 & secPHosNamOth.isShown())
           {
             Connection.MessageBox(PneumoniaCase.this, "Required field: Name of the other hospital-1.");
             txtPHosNamOth.requestFocus();
             return;
           }
//         else if(spnPHosNam2.getSelectedItemPosition()==0  & secPHosNam2.isShown())
//           {
//             Connection.MessageBox(PneumoniaCase.this, "Required field: 2..");
//             spnPHosNam2.requestFocus();
//             return;
//           }
         else if(txtPHosNamOth2.getText().toString().length()==0 & secPHosNamOth2.isShown())
           {
             Connection.MessageBox(PneumoniaCase.this, "Required field: Name of the other hospital-2.");
             txtPHosNamOth2.requestFocus();
             return;
           }
//         else if(spnPHosNam3.getSelectedItemPosition()==0  & secPHosNam3.isShown())
//           {
//             Connection.MessageBox(PneumoniaCase.this, "Required field: 3..");
//             spnPHosNam3.requestFocus();
//             return;
//           }
         else if(txtPHosNamOth3.getText().toString().length()==0 & secPHosNamOth3.isShown())
           {
             Connection.MessageBox(PneumoniaCase.this, "Required field: Name of the other hospital-3.");
             txtPHosNamOth3.requestFocus();
             return;
           }

//         else if(DV.length()!=0 & txtPAdmHosM.getText().toString().length()==0 & secPDtAdmHos.isShown())
//           {
//                   Connection.MessageBox(PneumoniaCase.this, DV);
//                   dtpPDtAdmHos.requestFocus();
//                   return;
//           }
         else if(txtPAdmHosM.getText().toString().length()==0 & dtpPDtAdmHos.getText().toString().length()==0 & secPAdmHosM.isShown())
           {
//               if(dtpPDtAdmHos.getText().toString().length()==0){
                   Connection.MessageBox(PneumoniaCase.this, "Required field: যদি ভর্তির তারিখ জানা না থাকে,  কত মাস আগে (How month ago).");
                   txtPAdmHosM.requestFocus();
                   return;
//               }

           }
         else if(Integer.valueOf(txtPAdmHosM.getText().toString().length()==0 ? "01" : txtPAdmHosM.getText().toString()) < 01 || Integer.valueOf(txtPAdmHosM.getText().toString().length()==0 ? "98" : txtPAdmHosM.getText().toString()) > 98& secPAdmHosM.isShown())
           {
             Connection.MessageBox(PneumoniaCase.this, "Value should be between 01 and 98(যদি ভর্তির তারিখ জানা না থাকে,  কত মাস আগে (How month ago)).");
             txtPAdmHosM.requestFocus(); 
             return;	
           }
         else if(txtPDurIlBeHos.getText().toString().length()==0 & secPDurIlBeHos.isShown())
           {
             Connection.MessageBox(PneumoniaCase.this, "Required field:  হাসপাতালে ভর্তির আগে শিশুটি কতদিন অসুস্থ ছিল?(যদি জানা না থাকে 98 বসান) (For how many days did the child appear ill before he/she was hospitalized?).");
             txtPDurIlBeHos.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtPDurIlBeHos.getText().toString().length()==0 ? "01" : txtPDurIlBeHos.getText().toString()) < 01 || Integer.valueOf(txtPDurIlBeHos.getText().toString().length()==0 ? "98" : txtPDurIlBeHos.getText().toString()) > 98& secPDurIlBeHos.isShown())
           {
             Connection.MessageBox(PneumoniaCase.this, "Value should be between 01 and 98( হাসপাতালে ভর্তির আগে শিশুটি কতদিন অসুস্থ ছিল?(যদি জানা না থাকে 98 বসান) (For how many days did the child appear ill before he/she was hospitalized?)).");
             txtPDurIlBeHos.requestFocus(); 
             return;	
           }
         else if(spnPDisDr.getSelectedItemPosition()==0  & secPDisDr.isShown())
           {
             Connection.MessageBox(PneumoniaCase.this, "Required field: চিকিৎসকরা শিশুটির কি রোগ ছিল বলে আপনাদের বলেছিলেন?  What illness did the doctors tell you that your child had?.");
             spnPDisDr.requestFocus(); 
             return;	
           }
         else if(txtPDisDrOth.getText().toString().length()==0 & secPDisDrOth.isShown())
           {
             Connection.MessageBox(PneumoniaCase.this, "Required field: অন্যান্য উল্লেখ করুন (Others Specify).");
             txtPDisDrOth.requestFocus(); 
             return;	
           }
         
         else if(!rdoPReco1.isChecked() & !rdoPReco2.isChecked() & !rdoPReco3.isChecked() & secPReco.isShown())
           {
              Connection.MessageBox(PneumoniaCase.this, "Select anyone options from (শিশুটি কি সম্পূর্ণ সুস্থ হয়ে গিয়েছিল? (Did the child recover completely?)).");
              rdoPReco1.requestFocus();
              return;
           }
         else if(txtPDurReco.getText().toString().length()==0 & secPDurReco.isShown())
           {
             Connection.MessageBox(PneumoniaCase.this, "Required field: শিশুটি সুস্থ হতে কতদিন লেগেছিল?(যদি জানা না থাকে 98 বসান) (How many days were required before the child recovered?).");
             txtPDurReco.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtPDurReco.getText().toString().length()==0 ? "01" : txtPDurReco.getText().toString()) < 01 || Integer.valueOf(txtPDurReco.getText().toString().length()==0 ? "98" : txtPDurReco.getText().toString()) > 98& secPDurReco.isShown())
           {
             Connection.MessageBox(PneumoniaCase.this, "Value should be between 01 and 98(শিশুটি সুস্থ হতে কতদিন লেগেছিল?(যদি জানা না থাকে 98 বসান) (How many days were required before the child recovered?)).");
             txtPDurReco.requestFocus(); 
             return;	
           }
//         else if(txtPAboIll.getText().toString().length()==0 & secPAboIll.isShown())
//           {
//             Connection.MessageBox(PneumoniaCase.this, "Required field: মন্তব্যঃ নিউমোনিয়া (Remarks: Pneumonia).");
//             txtPAboIll.requestFocus();
//             return;
//           }
 
         String SQL = "";
         RadioButton rb;

         PneumoniaCase_DataModel objSave = new PneumoniaCase_DataModel();
         objSave.setUNCode(txtUNCode.getText().toString());
         objSave.setStructureNo(txtStructureNo.getText().toString());
         objSave.setHouseholdSl(txtHouseholdSl.getText().toString());
         objSave.setVisitNo(txtVisitNo.getText().toString());
         objSave.setMemSl(txtMemSl.getText().toString());
         String[] d_rdogrpPDSign = new String[] {"1","2","8"};
         objSave.setPDSign(0);
         for (int i = 0; i < rdogrpPDSign.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpPDSign.getChildAt(i);
             if (rb.isChecked()) objSave.setPDSign(Integer.valueOf(d_rdogrpPDSign[i]));
         }

         objSave.setPEpiIlness(Integer.valueOf(txtPEpiIlness.getText().toString().length()==0?"0":txtPEpiIlness.getText().toString()));
         String[] d_rdogrpPFever = new String[] {"1","2","8"};
         objSave.setPFever(0);
         for (int i = 0; i < rdogrpPFever.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpPFever.getChildAt(i);
             if (rb.isChecked()) objSave.setPFever(Integer.valueOf(d_rdogrpPFever[i]));
         }

         objSave.setPDurFever(Integer.valueOf(txtPDurFever.getText().toString().length()==0?"0":txtPDurFever.getText().toString()));
         String[] d_rdogrpPCough = new String[] {"1","2","8"};
         objSave.setPCough(0);
         for (int i = 0; i < rdogrpPCough.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpPCough.getChildAt(i);
             if (rb.isChecked()) objSave.setPCough(Integer.valueOf(d_rdogrpPCough[i]));
         }

         objSave.setPDurCough(Integer.valueOf(txtPDurCough.getText().toString().length()==0?"0":txtPDurCough.getText().toString()));
         String[] d_rdogrpPDifBrea = new String[] {"1","2","8"};
         objSave.setPDifBrea(0);
         for (int i = 0; i < rdogrpPDifBrea.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpPDifBrea.getChildAt(i);
             if (rb.isChecked()) objSave.setPDifBrea(Integer.valueOf(d_rdogrpPDifBrea[i]));
         }

         objSave.setPDurDifBrea(Integer.valueOf(txtPDurDifBrea.getText().toString().length()==0?"0":txtPDurDifBrea.getText().toString()));
         String[] d_rdogrpPTurnBlue = new String[] {"1","2","8"};
         objSave.setPTurnBlue(0);
         for (int i = 0; i < rdogrpPTurnBlue.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpPTurnBlue.getChildAt(i);
             if (rb.isChecked()) objSave.setPTurnBlue(Integer.valueOf(d_rdogrpPTurnBlue[i]));
         }

         objSave.setPDurTurnBlue(Integer.valueOf(txtPDurTurnBlue.getText().toString().length()==0?"0":txtPDurTurnBlue.getText().toString()));
         String[] d_rdogrpPBreatNois = new String[] {"1","2","8"};
         objSave.setPBreatNois(0);
         for (int i = 0; i < rdogrpPBreatNois.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpPBreatNois.getChildAt(i);
             if (rb.isChecked()) objSave.setPBreatNois(Integer.valueOf(d_rdogrpPBreatNois[i]));
         }

         objSave.setPDurBreatNois(Integer.valueOf(txtPDurBreatNois.getText().toString().length()==0?"0":txtPDurBreatNois.getText().toString()));
         objSave.setPLethargy(Integer.valueOf(spnPLethargy.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnPLethargy.getSelectedItem().toString(), "-")));
         objSave.setPDurLethargy(Integer.valueOf(txtPDurLethargy.getText().toString().length()==0?"0":txtPDurLethargy.getText().toString()));
         objSave.setPUnDriBfeed(Integer.valueOf(spnPUnDriBfeed.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnPUnDriBfeed.getSelectedItem().toString(), "-")));
         objSave.setPDurUnDriBfeed(Integer.valueOf(txtPDurUnDriBfeed.getText().toString().length()==0?"0":txtPDurUnDriBfeed.getText().toString()));
         String[] d_rdogrpPVomit = new String[] {"1","2","8"};
         objSave.setPVomit(0);
         for (int i = 0; i < rdogrpPVomit.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpPVomit.getChildAt(i);
             if (rb.isChecked()) objSave.setPVomit(Integer.valueOf(d_rdogrpPVomit[i]));
         }

         String[] d_rdogrpPConv = new String[] {"1","2","8"};
         objSave.setPConv(0);
         for (int i = 0; i < rdogrpPConv.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpPConv.getChildAt(i);
             if (rb.isChecked()) objSave.setPConv(Integer.valueOf(d_rdogrpPConv[i]));
         }

         String[] d_rdogrpPUpRolEye = new String[] {"1","2","8"};
         objSave.setPUpRolEye(0);
         for (int i = 0; i < rdogrpPUpRolEye.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpPUpRolEye.getChildAt(i);
             if (rb.isChecked()) objSave.setPUpRolEye(Integer.valueOf(d_rdogrpPUpRolEye[i]));
         }

         String[] d_rdogrpPRigJaw = new String[] {"1","2","8"};
         objSave.setPRigJaw(0);
         for (int i = 0; i < rdogrpPRigJaw.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpPRigJaw.getChildAt(i);
             if (rb.isChecked()) objSave.setPRigJaw(Integer.valueOf(d_rdogrpPRigJaw[i]));
         }

         String[] d_rdogrpPRigLim = new String[] {"1","2","8"};
         objSave.setPRigLim(0);
         for (int i = 0; i < rdogrpPRigLim.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpPRigLim.getChildAt(i);
             if (rb.isChecked()) objSave.setPRigLim(Integer.valueOf(d_rdogrpPRigLim[i]));
         }

         objSave.setPDurConv(Integer.valueOf(spnPDurConv.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnPDurConv.getSelectedItem().toString(), "-")));
         String[] d_rdogrpPUncons = new String[] {"1","2","8"};
         objSave.setPUncons(0);
         for (int i = 0; i < rdogrpPUncons.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpPUncons.getChildAt(i);
             if (rb.isChecked()) objSave.setPUncons(Integer.valueOf(d_rdogrpPUncons[i]));
         }

         objSave.setPDurUncons(Integer.valueOf(spnPDurUncons.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnPDurUncons.getSelectedItem().toString(), "-")));
         String[] d_rdogrpPIlHCar = new String[] {"1","2","8"};
         objSave.setPIlHCar(0);
         for (int i = 0; i < rdogrpPIlHCar.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpPIlHCar.getChildAt(i);
             if (rb.isChecked()) objSave.setPIlHCar(Integer.valueOf(d_rdogrpPIlHCar[i]));
         }

         String[] d_rdogrpPHC_PhyMBBS = new String[] {"1","2","8"};
         objSave.setPHC_PhyMBBS(0);
         for (int i = 0; i < rdogrpPHC_PhyMBBS.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpPHC_PhyMBBS.getChildAt(i);
             if (rb.isChecked()) objSave.setPHC_PhyMBBS(Integer.valueOf(d_rdogrpPHC_PhyMBBS[i]));
         }

         String[] d_rdogrpPHC_UnquaDoctor = new String[] {"1","2","8"};
         objSave.setPHC_UnquaDoctor(0);
         for (int i = 0; i < rdogrpPHC_UnquaDoctor.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpPHC_UnquaDoctor.getChildAt(i);
             if (rb.isChecked()) objSave.setPHC_UnquaDoctor(Integer.valueOf(d_rdogrpPHC_UnquaDoctor[i]));
         }

         String[] d_rdogrpPHC_Para = new String[] {"1","2","8"};
         objSave.setPHC_Para(0);
         for (int i = 0; i < rdogrpPHC_Para.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpPHC_Para.getChildAt(i);
             if (rb.isChecked()) objSave.setPHC_Para(Integer.valueOf(d_rdogrpPHC_Para[i]));
         }

         String[] d_rdogrpPHC_Com = new String[] {"1","2","8"};
         objSave.setPHC_Com(0);
         for (int i = 0; i < rdogrpPHC_Com.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpPHC_Com.getChildAt(i);
             if (rb.isChecked()) objSave.setPHC_Com(Integer.valueOf(d_rdogrpPHC_Com[i]));
         }

         String[] d_rdogrpPHC_Pha = new String[] {"1","2","8"};
         objSave.setPHC_Pha(0);
         for (int i = 0; i < rdogrpPHC_Pha.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpPHC_Pha.getChildAt(i);
             if (rb.isChecked()) objSave.setPHC_Pha(Integer.valueOf(d_rdogrpPHC_Pha[i]));
         }

         String[] d_rdogrpHC_Hompath = new String[] {"1","2","8"};
         objSave.setHC_Hompath(0);
         for (int i = 0; i < rdogrpHC_Hompath.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpHC_Hompath.getChildAt(i);
             if (rb.isChecked()) objSave.setHC_Hompath(Integer.valueOf(d_rdogrpHC_Hompath[i]));
         }

         String[] d_rdogrpPHC_TrHeal = new String[] {"1","2","8"};
         objSave.setPHC_TrHeal(0);
         for (int i = 0; i < rdogrpPHC_TrHeal.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpPHC_TrHeal.getChildAt(i);
             if (rb.isChecked()) objSave.setPHC_TrHeal(Integer.valueOf(d_rdogrpPHC_TrHeal[i]));
         }

         String[] d_rdogrpPHC_SpiHeal = new String[] {"1","2","8"};
         objSave.setPHC_SpiHeal(0);
         for (int i = 0; i < rdogrpPHC_SpiHeal.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpPHC_SpiHeal.getChildAt(i);
             if (rb.isChecked()) objSave.setPHC_SpiHeal(Integer.valueOf(d_rdogrpPHC_SpiHeal[i]));
         }

         String[] d_rdogrpPHC_Oth = new String[] {"1","2","8"};
         objSave.setPHC_Oth(0);
         for (int i = 0; i < rdogrpPHC_Oth.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpPHC_Oth.getChildAt(i);
             if (rb.isChecked()) objSave.setPHC_Oth(Integer.valueOf(d_rdogrpPHC_Oth[i]));
         }

         objSave.setPHC_OthName(txtPHC_OthName.getText().toString());
         String[] d_rdogrpPDSHOPD = new String[] {"1","2","8"};
         objSave.setPDSHOPD(0);
         for (int i = 0; i < rdogrpPDSHOPD.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpPDSHOPD.getChildAt(i);
             if (rb.isChecked()) objSave.setPDSHOPD(Integer.valueOf(d_rdogrpPDSHOPD[i]));
         }

         String[] d_rdogrpPSSFOPD = new String[] {"1","2","8"};
         objSave.setPSSFOPD(0);
         for (int i = 0; i < rdogrpPSSFOPD.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpPSSFOPD.getChildAt(i);
             if (rb.isChecked()) objSave.setPSSFOPD(Integer.valueOf(d_rdogrpPSSFOPD[i]));
         }

         String[] d_rdogrpPAdmHos = new String[] {"1","2","8"};
         objSave.setPAdmHos(0);
         for (int i = 0; i < rdogrpPAdmHos.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpPAdmHos.getChildAt(i);
             if (rb.isChecked()) objSave.setPAdmHos(Integer.valueOf(d_rdogrpPAdmHos[i]));
         }

         objSave.setPHosNam(Integer.valueOf(spnPHosNam.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnPHosNam.getSelectedItem().toString(), "-")));
         objSave.setPHosNamOth(txtPHosNamOth.getText().toString());
         objSave.setPHosNam2(Integer.valueOf(spnPHosNam2.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnPHosNam2.getSelectedItem().toString(), "-")));
         objSave.setPHosNamOth2(txtPHosNamOth2.getText().toString());
         objSave.setPHosNam3(Integer.valueOf(spnPHosNam3.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnPHosNam3.getSelectedItem().toString(), "-")));
         objSave.setPHosNamOth3(txtPHosNamOth3.getText().toString());
         objSave.setPDtAdmHos(dtpPDtAdmHos.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpPDtAdmHos.getText().toString()) : dtpPDtAdmHos.getText().toString());
         objSave.setPAdmHosM(Integer.valueOf(txtPAdmHosM.getText().toString().length()==0?"0":txtPAdmHosM.getText().toString()));
         objSave.setPDurIlBeHos(Integer.valueOf(txtPDurIlBeHos.getText().toString().length()==0?"0":txtPDurIlBeHos.getText().toString()));
         objSave.setPDisDr(Integer.valueOf(spnPDisDr.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnPDisDr.getSelectedItem().toString(), "-")));
         objSave.setPDisDrOth(txtPDisDrOth.getText().toString());
         String[] d_rdogrpPReco = new String[] {"1","2","8"};
         objSave.setPReco(0);
         for (int i = 0; i < rdogrpPReco.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpPReco.getChildAt(i);
             if (rb.isChecked()) objSave.setPReco(Integer.valueOf(d_rdogrpPReco[i]));
         }

         objSave.setPDurReco(Integer.valueOf(txtPDurReco.getText().toString().length()==0?"0":txtPDurReco.getText().toString()));
         objSave.setPAboIll(txtPAboIll.getText().toString());
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

             Connection.MessageBox(PneumoniaCase.this, "Saved Successfully");
         }
         else{
             Connection.MessageBox(PneumoniaCase.this, status);
             return;
         }
     }
     catch(Exception  e)
     {
         Connection.MessageBox(PneumoniaCase.this, e.getMessage());
         return;
     }
 }

 private void DataSearch(String UNCode, String StructureNo, String HouseholdSl, String VisitNo, String MemSl)
     {
       try
        {
     
           RadioButton rb;
           PneumoniaCase_DataModel d = new PneumoniaCase_DataModel();
           String SQL = "Select * from "+ TableName +"  Where UNCode='"+ UNCode +"' and StructureNo='"+ StructureNo +"' and HouseholdSl='"+ HouseholdSl +"' and VisitNo='"+ VisitNo +"' and MemSl='"+ MemSl +"'";
           List<PneumoniaCase_DataModel> data = d.SelectAll(this, SQL);
           for(PneumoniaCase_DataModel item : data){
             txtUNCode.setText(item.getUNCode());
             txtStructureNo.setText(item.getStructureNo());
             txtHouseholdSl.setText(item.getHouseholdSl());
             txtVisitNo.setText(item.getVisitNo());
             txtMemSl.setText(item.getMemSl());
             String[] d_rdogrpPDSign = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpPDSign.length; i++)
             {
                 if (String.valueOf(item.getPDSign()).equals(String.valueOf(d_rdogrpPDSign[i])))
                 {
                     rb = (RadioButton)rdogrpPDSign.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtPEpiIlness.setText(String.valueOf(item.getPEpiIlness()));
             String[] d_rdogrpPFever = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpPFever.length; i++)
             {
                 if (String.valueOf(item.getPFever()).equals(String.valueOf(d_rdogrpPFever[i])))
                 {
                     rb = (RadioButton)rdogrpPFever.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtPDurFever.setText(String.valueOf(item.getPDurFever()));
             String[] d_rdogrpPCough = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpPCough.length; i++)
             {
                 if (String.valueOf(item.getPCough()).equals(String.valueOf(d_rdogrpPCough[i])))
                 {
                     rb = (RadioButton)rdogrpPCough.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtPDurCough.setText(String.valueOf(item.getPDurCough()));
             String[] d_rdogrpPDifBrea = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpPDifBrea.length; i++)
             {
                 if (String.valueOf(item.getPDifBrea()).equals(String.valueOf(d_rdogrpPDifBrea[i])))
                 {
                     rb = (RadioButton)rdogrpPDifBrea.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtPDurDifBrea.setText(String.valueOf(item.getPDurDifBrea()));
             String[] d_rdogrpPTurnBlue = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpPTurnBlue.length; i++)
             {
                 if (String.valueOf(item.getPTurnBlue()).equals(String.valueOf(d_rdogrpPTurnBlue[i])))
                 {
                     rb = (RadioButton)rdogrpPTurnBlue.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtPDurTurnBlue.setText(String.valueOf(item.getPDurTurnBlue()));
             String[] d_rdogrpPBreatNois = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpPBreatNois.length; i++)
             {
                 if (String.valueOf(item.getPBreatNois()).equals(String.valueOf(d_rdogrpPBreatNois[i])))
                 {
                     rb = (RadioButton)rdogrpPBreatNois.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtPDurBreatNois.setText(String.valueOf(item.getPDurBreatNois()));
             spnPLethargy.setSelection(Global.SpinnerItemPositionAnyLength(spnPLethargy, String.valueOf(item.getPLethargy())));
             txtPDurLethargy.setText(String.valueOf(item.getPDurLethargy()));
             spnPUnDriBfeed.setSelection(Global.SpinnerItemPositionAnyLength(spnPUnDriBfeed, String.valueOf(item.getPUnDriBfeed())));
             txtPDurUnDriBfeed.setText(String.valueOf(item.getPDurUnDriBfeed()));
             String[] d_rdogrpPVomit = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpPVomit.length; i++)
             {
                 if (String.valueOf(item.getPVomit()).equals(String.valueOf(d_rdogrpPVomit[i])))
                 {
                     rb = (RadioButton)rdogrpPVomit.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpPConv = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpPConv.length; i++)
             {
                 if (String.valueOf(item.getPConv()).equals(String.valueOf(d_rdogrpPConv[i])))
                 {
                     rb = (RadioButton)rdogrpPConv.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpPUpRolEye = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpPUpRolEye.length; i++)
             {
                 if (String.valueOf(item.getPUpRolEye()).equals(String.valueOf(d_rdogrpPUpRolEye[i])))
                 {
                     rb = (RadioButton)rdogrpPUpRolEye.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpPRigJaw = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpPRigJaw.length; i++)
             {
                 if (String.valueOf(item.getPRigJaw()).equals(String.valueOf(d_rdogrpPRigJaw[i])))
                 {
                     rb = (RadioButton)rdogrpPRigJaw.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpPRigLim = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpPRigLim.length; i++)
             {
                 if (String.valueOf(item.getPRigLim()).equals(String.valueOf(d_rdogrpPRigLim[i])))
                 {
                     rb = (RadioButton)rdogrpPRigLim.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             spnPDurConv.setSelection(Global.SpinnerItemPositionAnyLength(spnPDurConv, String.valueOf(item.getPDurConv())));
             String[] d_rdogrpPUncons = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpPUncons.length; i++)
             {
                 if (String.valueOf(item.getPUncons()).equals(String.valueOf(d_rdogrpPUncons[i])))
                 {
                     rb = (RadioButton)rdogrpPUncons.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             spnPDurUncons.setSelection(Global.SpinnerItemPositionAnyLength(spnPDurUncons, String.valueOf(item.getPDurUncons())));
             String[] d_rdogrpPIlHCar = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpPIlHCar.length; i++)
             {
                 if (String.valueOf(item.getPIlHCar()).equals(String.valueOf(d_rdogrpPIlHCar[i])))
                 {
                     rb = (RadioButton)rdogrpPIlHCar.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpPHC_PhyMBBS = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpPHC_PhyMBBS.length; i++)
             {
                 if (String.valueOf(item.getPHC_PhyMBBS()).equals(String.valueOf(d_rdogrpPHC_PhyMBBS[i])))
                 {
                     rb = (RadioButton)rdogrpPHC_PhyMBBS.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpPHC_UnquaDoctor = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpPHC_UnquaDoctor.length; i++)
             {
                 if (String.valueOf(item.getPHC_UnquaDoctor()).equals(String.valueOf(d_rdogrpPHC_UnquaDoctor[i])))
                 {
                     rb = (RadioButton)rdogrpPHC_UnquaDoctor.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpPHC_Para = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpPHC_Para.length; i++)
             {
                 if (String.valueOf(item.getPHC_Para()).equals(String.valueOf(d_rdogrpPHC_Para[i])))
                 {
                     rb = (RadioButton)rdogrpPHC_Para.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpPHC_Com = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpPHC_Com.length; i++)
             {
                 if (String.valueOf(item.getPHC_Com()).equals(String.valueOf(d_rdogrpPHC_Com[i])))
                 {
                     rb = (RadioButton)rdogrpPHC_Com.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpPHC_Pha = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpPHC_Pha.length; i++)
             {
                 if (String.valueOf(item.getPHC_Pha()).equals(String.valueOf(d_rdogrpPHC_Pha[i])))
                 {
                     rb = (RadioButton)rdogrpPHC_Pha.getChildAt(i);
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
             String[] d_rdogrpPHC_TrHeal = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpPHC_TrHeal.length; i++)
             {
                 if (String.valueOf(item.getPHC_TrHeal()).equals(String.valueOf(d_rdogrpPHC_TrHeal[i])))
                 {
                     rb = (RadioButton)rdogrpPHC_TrHeal.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpPHC_SpiHeal = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpPHC_SpiHeal.length; i++)
             {
                 if (String.valueOf(item.getPHC_SpiHeal()).equals(String.valueOf(d_rdogrpPHC_SpiHeal[i])))
                 {
                     rb = (RadioButton)rdogrpPHC_SpiHeal.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpPHC_Oth = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpPHC_Oth.length; i++)
             {
                 if (String.valueOf(item.getPHC_Oth()).equals(String.valueOf(d_rdogrpPHC_Oth[i])))
                 {
                     rb = (RadioButton)rdogrpPHC_Oth.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtPHC_OthName.setText(item.getPHC_OthName());
             String[] d_rdogrpPDSHOPD = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpPDSHOPD.length; i++)
             {
                 if (String.valueOf(item.getPDSHOPD()).equals(String.valueOf(d_rdogrpPDSHOPD[i])))
                 {
                     rb = (RadioButton)rdogrpPDSHOPD.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpPSSFOPD = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpPSSFOPD.length; i++)
             {
                 if (String.valueOf(item.getPSSFOPD()).equals(String.valueOf(d_rdogrpPSSFOPD[i])))
                 {
                     rb = (RadioButton)rdogrpPSSFOPD.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpPAdmHos = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpPAdmHos.length; i++)
             {
                 if (String.valueOf(item.getPAdmHos()).equals(String.valueOf(d_rdogrpPAdmHos[i])))
                 {
                     rb = (RadioButton)rdogrpPAdmHos.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             spnPHosNam.setSelection(Global.SpinnerItemPositionAnyLength(spnPHosNam, String.valueOf(item.getPHosNam())));
             txtPHosNamOth.setText(item.getPHosNamOth());
             spnPHosNam2.setSelection(Global.SpinnerItemPositionAnyLength(spnPHosNam2, String.valueOf(item.getPHosNam2())));
             txtPHosNamOth2.setText(item.getPHosNamOth2());
             spnPHosNam3.setSelection(Global.SpinnerItemPositionAnyLength(spnPHosNam3, String.valueOf(item.getPHosNam3())));
             txtPHosNamOth3.setText(item.getPHosNamOth3());
             dtpPDtAdmHos.setText(item.getPDtAdmHos().toString().length()==0 ? "" : Global.DateConvertDMY(item.getPDtAdmHos()));
             txtPAdmHosM.setText(item.getPAdmHosM()==0?"":String.valueOf(item.getPAdmHosM()));
             txtPDurIlBeHos.setText(String.valueOf(item.getPDurIlBeHos()));
             spnPDisDr.setSelection(Global.SpinnerItemPositionAnyLength(spnPDisDr, String.valueOf(item.getPDisDr())));
             txtPDisDrOth.setText(item.getPDisDrOth());
             String[] d_rdogrpPReco = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpPReco.length; i++)
             {
                 if (String.valueOf(item.getPReco()).equals(String.valueOf(d_rdogrpPReco[i])))
                 {
                     rb = (RadioButton)rdogrpPReco.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtPDurReco.setText(String.valueOf(item.getPDurReco()));
             txtPAboIll.setText(item.getPAboIll());
           }
        }
        catch(Exception  e)
        {
            Connection.MessageBox(PneumoniaCase.this, e.getMessage());
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


              dtpDate = (EditText)findViewById(R.id.dtpPDtAdmHos);
             if (VariableID.equals("btnPDtAdmHos"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpPDtAdmHos);
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