
 package org.hcus_hhinterview;


 //Android Manifest Code
 //<activity android:name=".OtitisMediaCase " android:label="OtitisMediaCase " />
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
 import data_model.OtitisMediaCase_DataModel;

 public class OtitisMediaCase  extends Activity {
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
         LinearLayout secOMEDis;
         View lineOMEDis;
         TextView VlblOMEDis;
         RadioGroup rdogrpOMEDis;
         
         RadioButton rdoOMEDis1;
         RadioButton rdoOMEDis2;
         RadioButton rdoOMEDis3;
         LinearLayout secOMEDisEpi;
         View lineOMEDisEpi;
         TextView VlblOMEDisEpi;
         EditText txtOMEDisEpi;
         LinearLayout secOMHCar;
         View lineOMHCar;
         TextView VlblOMHCar;
         RadioGroup rdogrpOMHCar;
         
         RadioButton rdoOMHCar1;
         RadioButton rdoOMHCar2;
         RadioButton rdoOMHCar3;
         LinearLayout secOMHCarTypLabel;
         View lineOMHCarTypLabel;
         LinearLayout secOMHC_PhyMBBS;
         View lineOMHC_PhyMBBS;
         TextView VlblOMHC_PhyMBBS;
         RadioGroup rdogrpOMHC_PhyMBBS;
         
         RadioButton rdoOMHC_PhyMBBS1;
         RadioButton rdoOMHC_PhyMBBS2;
         RadioButton rdoOMHC_PhyMBBS3;
         LinearLayout secOMHC_UnquaDoctor;
         View lineOMHC_UnquaDoctor;
         TextView VlblOMHC_UnquaDoctor;
         RadioGroup rdogrpOMHC_UnquaDoctor;
         
         RadioButton rdoOMHC_UnquaDoctor1;
         RadioButton rdoOMHC_UnquaDoctor2;
         RadioButton rdoOMHC_UnquaDoctor3;
         LinearLayout secOMHC_Para;
         View lineOMHC_Para;
         TextView VlblOMHC_Para;
         RadioGroup rdogrpOMHC_Para;
         
         RadioButton rdoOMHC_Para1;
         RadioButton rdoOMHC_Para2;
         RadioButton rdoOMHC_Para3;
         LinearLayout secOMHC_Com;
         View lineOMHC_Com;
         TextView VlblOMHC_Com;
         RadioGroup rdogrpOMHC_Com;
         
         RadioButton rdoOMHC_Com1;
         RadioButton rdoOMHC_Com2;
         RadioButton rdoOMHC_Com3;
         LinearLayout secOMHC_Pha;
         View lineOMHC_Pha;
         TextView VlblOMHC_Pha;
         RadioGroup rdogrpOMHC_Pha;
         
         RadioButton rdoOMHC_Pha1;
         RadioButton rdoOMHC_Pha2;
         RadioButton rdoOMHC_Pha3;
         LinearLayout secOMHC_Hompath;
         View lineOMHC_Hompath;
         TextView VlblOMHC_Hompath;
         RadioGroup rdogrpOMHC_Hompath;
         
         RadioButton rdoOMHC_Hompath1;
         RadioButton rdoOMHC_Hompath2;
         RadioButton rdoOMHC_Hompath3;
         LinearLayout secOMHC_TrHeal;
         View lineOMHC_TrHeal;
         TextView VlblOMHC_TrHeal;
         RadioGroup rdogrpOMHC_TrHeal;
         
         RadioButton rdoOMHC_TrHeal1;
         RadioButton rdoOMHC_TrHeal2;
         RadioButton rdoOMHC_TrHeal3;
         LinearLayout secOMHC_SpiHeal;
         View lineOMHC_SpiHeal;
         TextView VlblOMHC_SpiHeal;
         RadioGroup rdogrpOMHC_SpiHeal;
         
         RadioButton rdoOMHC_SpiHeal1;
         RadioButton rdoOMHC_SpiHeal2;
         RadioButton rdoOMHC_SpiHeal3;
         LinearLayout secOMHC_Oth;
         View lineOMHC_Oth;
         TextView VlblOMHC_Oth;
         RadioGroup rdogrpOMHC_Oth;
         
         RadioButton rdoOMHC_Oth1;
         RadioButton rdoOMHC_Oth2;
         RadioButton rdoOMHC_Oth3;
         LinearLayout secOMHC_OthName;
         View lineOMHC_OthName;
         TextView VlblOMHC_OthName;
         EditText txtOMHC_OthName;
         LinearLayout secOMDSHOPD;
         View lineOMDSHOPD;
         TextView VlblOMDSHOPD;
         RadioGroup rdogrpOMDSHOPD;
         
         RadioButton rdoOMDSHOPD1;
         RadioButton rdoOMDSHOPD2;
         RadioButton rdoOMDSHOPD3;
         LinearLayout secOMSSFOPD;
         View lineOMSSFOPD;
         TextView VlblOMSSFOPD;
         RadioGroup rdogrpOMSSFOPD;
         
         RadioButton rdoOMSSFOPD1;
         RadioButton rdoOMSSFOPD2;
         RadioButton rdoOMSSFOPD3;
         LinearLayout secOMReco;
         View lineOMReco;
         TextView VlblOMReco;
         RadioGroup rdogrpOMReco;
         
         RadioButton rdoOMReco1;
         RadioButton rdoOMReco2;
         RadioButton rdoOMReco3;
         LinearLayout secOMDurReco;
         View lineOMDurReco;
         TextView VlblOMDurReco;
         EditText txtOMDurReco;
         LinearLayout secOMInRecoLabel;
         View lineOMInRecoLabel;
         LinearLayout secOMInReco;
         View lineOMInReco;
         TextView VlblOMInReco;
         Spinner spnOMInReco;
         LinearLayout secOMInRecoOth;
         View lineOMInRecoOth;
         TextView VlblOMInRecoOth;
         EditText txtOMInRecoOth;
         LinearLayout secOMInReco2;
         View lineOMInReco2;
         TextView VlblOMInReco2;
         Spinner spnOMInReco2;
         LinearLayout secOMInRecoOth2;
         View lineOMInRecoOth2;
         TextView VlblOMInRecoOth2;
         EditText txtOMInRecoOth2;
         LinearLayout secOMAboIll;
         View lineOMAboIll;
         TextView VlblOMAboIll;
         EditText txtOMAboIll;

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
         setContentView(R.layout.otitismediacase);
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

         TableName = "OtitisMediaCase ";

         //turnGPSOn();

         //GPS Location
         //FindLocation();
         // Double.toString(currentLatitude);
         // Double.toString(currentLongitude);
         lblHeading = (TextView)findViewById(R.id.lblHeading);

         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(OtitisMediaCase .this);
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
         secOMEDis=(LinearLayout)findViewById(R.id.secOMEDis);
         lineOMEDis=(View)findViewById(R.id.lineOMEDis);
         VlblOMEDis = (TextView) findViewById(R.id.VlblOMEDis);
         rdogrpOMEDis = (RadioGroup) findViewById(R.id.rdogrpOMEDis);

         txtUNCode.setText(UNCODE);
         txtStructureNo.setText(""+STRUCTURENO);
         txtHouseholdSl.setText(HOUSEHOLDSL);
         txtVisitNo.setText(VISITNO);
         txtMemSl.setText(MEMSL);


         rdoOMEDis1 = (RadioButton) findViewById(R.id.rdoOMEDis1);
         rdoOMEDis2 = (RadioButton) findViewById(R.id.rdoOMEDis2);
         rdoOMEDis3 = (RadioButton) findViewById(R.id.rdoOMEDis3);
         rdogrpOMEDis.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpOMEDis = new String[] {"1","2","8"};
             for (int i = 0; i < rdogrpOMEDis.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpOMEDis.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpOMEDis[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secOMEDisEpi.setVisibility(View.GONE);
                    lineOMEDisEpi.setVisibility(View.GONE);
                    txtOMEDisEpi.setText("");
                    secOMHCar.setVisibility(View.GONE);
                    lineOMHCar.setVisibility(View.GONE);
                    rdogrpOMHCar.clearCheck();
                    secOMHCarTypLabel.setVisibility(View.GONE);
                    lineOMHCarTypLabel.setVisibility(View.GONE);
                    secOMHC_PhyMBBS.setVisibility(View.GONE);
                    lineOMHC_PhyMBBS.setVisibility(View.GONE);
                    rdogrpOMHC_PhyMBBS.clearCheck();
                    secOMHC_UnquaDoctor.setVisibility(View.GONE);
                    lineOMHC_UnquaDoctor.setVisibility(View.GONE);
                    rdogrpOMHC_UnquaDoctor.clearCheck();
                    secOMHC_Para.setVisibility(View.GONE);
                    lineOMHC_Para.setVisibility(View.GONE);
                    rdogrpOMHC_Para.clearCheck();
                    secOMHC_Com.setVisibility(View.GONE);
                    lineOMHC_Com.setVisibility(View.GONE);
                    rdogrpOMHC_Com.clearCheck();
                    secOMHC_Pha.setVisibility(View.GONE);
                    lineOMHC_Pha.setVisibility(View.GONE);
                    rdogrpOMHC_Pha.clearCheck();
                    secOMHC_Hompath.setVisibility(View.GONE);
                    lineOMHC_Hompath.setVisibility(View.GONE);
                    rdogrpOMHC_Hompath.clearCheck();
                    secOMHC_TrHeal.setVisibility(View.GONE);
                    lineOMHC_TrHeal.setVisibility(View.GONE);
                    rdogrpOMHC_TrHeal.clearCheck();
                    secOMHC_SpiHeal.setVisibility(View.GONE);
                    lineOMHC_SpiHeal.setVisibility(View.GONE);
                    rdogrpOMHC_SpiHeal.clearCheck();
                    secOMHC_Oth.setVisibility(View.GONE);
                    lineOMHC_Oth.setVisibility(View.GONE);
                    rdogrpOMHC_Oth.clearCheck();
                    secOMHC_OthName.setVisibility(View.GONE);
                    lineOMHC_OthName.setVisibility(View.GONE);
                    txtOMHC_OthName.setText("");
                    secOMDSHOPD.setVisibility(View.GONE);
                    lineOMDSHOPD.setVisibility(View.GONE);
                    rdogrpOMDSHOPD.clearCheck();
                    secOMSSFOPD.setVisibility(View.GONE);
                    lineOMSSFOPD.setVisibility(View.GONE);
                    rdogrpOMSSFOPD.clearCheck();
                    secOMReco.setVisibility(View.GONE);
                    lineOMReco.setVisibility(View.GONE);
                    rdogrpOMReco.clearCheck();
                    secOMDurReco.setVisibility(View.GONE);
                    lineOMDurReco.setVisibility(View.GONE);
                    txtOMDurReco.setText("");
                    secOMInRecoLabel.setVisibility(View.GONE);
                    lineOMInRecoLabel.setVisibility(View.GONE);
                    secOMInReco.setVisibility(View.GONE);
                    lineOMInReco.setVisibility(View.GONE);
                    spnOMInReco.setSelection(0);
                    secOMInRecoOth.setVisibility(View.GONE);
                    lineOMInRecoOth.setVisibility(View.GONE);
                    txtOMInRecoOth.setText("");
                    secOMInReco2.setVisibility(View.GONE);
                    lineOMInReco2.setVisibility(View.GONE);
                    spnOMInReco2.setSelection(0);
                    secOMInRecoOth2.setVisibility(View.GONE);
                    lineOMInRecoOth2.setVisibility(View.GONE);
                    txtOMInRecoOth2.setText("");
                    secOMAboIll.setVisibility(View.GONE);
                    lineOMAboIll.setVisibility(View.GONE);
                    txtOMAboIll.setText("");
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secOMEDisEpi.setVisibility(View.GONE);
                    lineOMEDisEpi.setVisibility(View.GONE);
                    txtOMEDisEpi.setText("");
                    secOMHCar.setVisibility(View.GONE);
                    lineOMHCar.setVisibility(View.GONE);
                    rdogrpOMHCar.clearCheck();
                    secOMHCarTypLabel.setVisibility(View.GONE);
                    lineOMHCarTypLabel.setVisibility(View.GONE);
                    secOMHC_PhyMBBS.setVisibility(View.GONE);
                    lineOMHC_PhyMBBS.setVisibility(View.GONE);
                    rdogrpOMHC_PhyMBBS.clearCheck();
                    secOMHC_UnquaDoctor.setVisibility(View.GONE);
                    lineOMHC_UnquaDoctor.setVisibility(View.GONE);
                    rdogrpOMHC_UnquaDoctor.clearCheck();
                    secOMHC_Para.setVisibility(View.GONE);
                    lineOMHC_Para.setVisibility(View.GONE);
                    rdogrpOMHC_Para.clearCheck();
                    secOMHC_Com.setVisibility(View.GONE);
                    lineOMHC_Com.setVisibility(View.GONE);
                    rdogrpOMHC_Com.clearCheck();
                    secOMHC_Pha.setVisibility(View.GONE);
                    lineOMHC_Pha.setVisibility(View.GONE);
                    rdogrpOMHC_Pha.clearCheck();
                    secOMHC_Hompath.setVisibility(View.GONE);
                    lineOMHC_Hompath.setVisibility(View.GONE);
                    rdogrpOMHC_Hompath.clearCheck();
                    secOMHC_TrHeal.setVisibility(View.GONE);
                    lineOMHC_TrHeal.setVisibility(View.GONE);
                    rdogrpOMHC_TrHeal.clearCheck();
                    secOMHC_SpiHeal.setVisibility(View.GONE);
                    lineOMHC_SpiHeal.setVisibility(View.GONE);
                    rdogrpOMHC_SpiHeal.clearCheck();
                    secOMHC_Oth.setVisibility(View.GONE);
                    lineOMHC_Oth.setVisibility(View.GONE);
                    rdogrpOMHC_Oth.clearCheck();
                    secOMHC_OthName.setVisibility(View.GONE);
                    lineOMHC_OthName.setVisibility(View.GONE);
                    txtOMHC_OthName.setText("");
                    secOMDSHOPD.setVisibility(View.GONE);
                    lineOMDSHOPD.setVisibility(View.GONE);
                    rdogrpOMDSHOPD.clearCheck();
                    secOMSSFOPD.setVisibility(View.GONE);
                    lineOMSSFOPD.setVisibility(View.GONE);
                    rdogrpOMSSFOPD.clearCheck();
                    secOMReco.setVisibility(View.GONE);
                    lineOMReco.setVisibility(View.GONE);
                    rdogrpOMReco.clearCheck();
                    secOMDurReco.setVisibility(View.GONE);
                    lineOMDurReco.setVisibility(View.GONE);
                    txtOMDurReco.setText("");
                    secOMInRecoLabel.setVisibility(View.GONE);
                    lineOMInRecoLabel.setVisibility(View.GONE);
                    secOMInReco.setVisibility(View.GONE);
                    lineOMInReco.setVisibility(View.GONE);
                    spnOMInReco.setSelection(0);
                    secOMInRecoOth.setVisibility(View.GONE);
                    lineOMInRecoOth.setVisibility(View.GONE);
                    txtOMInRecoOth.setText("");
                    secOMInReco2.setVisibility(View.GONE);
                    lineOMInReco2.setVisibility(View.GONE);
                    spnOMInReco2.setSelection(0);
                    secOMInRecoOth2.setVisibility(View.GONE);
                    lineOMInRecoOth2.setVisibility(View.GONE);
                    txtOMInRecoOth2.setText("");
                    secOMAboIll.setVisibility(View.GONE);
                    lineOMAboIll.setVisibility(View.GONE);
                    txtOMAboIll.setText("");
             }
             else
             {
                    secOMEDisEpi.setVisibility(View.VISIBLE);
                    lineOMEDisEpi.setVisibility(View.VISIBLE);
                    secOMHCar.setVisibility(View.VISIBLE);
                    lineOMHCar.setVisibility(View.VISIBLE);


                    secOMDSHOPD.setVisibility(View.VISIBLE);
                    lineOMDSHOPD.setVisibility(View.VISIBLE);
                    secOMSSFOPD.setVisibility(View.VISIBLE);
                    lineOMSSFOPD.setVisibility(View.VISIBLE);
                    secOMReco.setVisibility(View.VISIBLE);
                    lineOMReco.setVisibility(View.VISIBLE);

                    secOMInRecoLabel.setVisibility(View.VISIBLE);
                    lineOMInRecoLabel.setVisibility(View.VISIBLE);
                    secOMInReco.setVisibility(View.VISIBLE);
                    lineOMInReco.setVisibility(View.VISIBLE);

                    secOMInReco2.setVisibility(View.VISIBLE);
                    lineOMInReco2.setVisibility(View.VISIBLE);
                    secOMAboIll.setVisibility(View.VISIBLE);
                    lineOMAboIll.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secOMEDisEpi=(LinearLayout)findViewById(R.id.secOMEDisEpi);
         lineOMEDisEpi=(View)findViewById(R.id.lineOMEDisEpi);
         VlblOMEDisEpi=(TextView) findViewById(R.id.VlblOMEDisEpi);
         txtOMEDisEpi=(EditText) findViewById(R.id.txtOMEDisEpi);
         secOMHCar=(LinearLayout)findViewById(R.id.secOMHCar);
         lineOMHCar=(View)findViewById(R.id.lineOMHCar);
         VlblOMHCar = (TextView) findViewById(R.id.VlblOMHCar);
         rdogrpOMHCar = (RadioGroup) findViewById(R.id.rdogrpOMHCar);
         
         rdoOMHCar1 = (RadioButton) findViewById(R.id.rdoOMHCar1);
         rdoOMHCar2 = (RadioButton) findViewById(R.id.rdoOMHCar2);
         rdoOMHCar3 = (RadioButton) findViewById(R.id.rdoOMHCar3);
         rdogrpOMHCar.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpOMHCar = new String[] {"1","2","8"};
             for (int i = 0; i < rdogrpOMHCar.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpOMHCar.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpOMHCar[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secOMHCarTypLabel.setVisibility(View.GONE);
                    lineOMHCarTypLabel.setVisibility(View.GONE);
                    secOMHC_PhyMBBS.setVisibility(View.GONE);
                    lineOMHC_PhyMBBS.setVisibility(View.GONE);
                    rdogrpOMHC_PhyMBBS.clearCheck();
                    secOMHC_UnquaDoctor.setVisibility(View.GONE);
                    lineOMHC_UnquaDoctor.setVisibility(View.GONE);
                    rdogrpOMHC_UnquaDoctor.clearCheck();
                    secOMHC_Para.setVisibility(View.GONE);
                    lineOMHC_Para.setVisibility(View.GONE);
                    rdogrpOMHC_Para.clearCheck();
                    secOMHC_Com.setVisibility(View.GONE);
                    lineOMHC_Com.setVisibility(View.GONE);
                    rdogrpOMHC_Com.clearCheck();
                    secOMHC_Pha.setVisibility(View.GONE);
                    lineOMHC_Pha.setVisibility(View.GONE);
                    rdogrpOMHC_Pha.clearCheck();
                    secOMHC_Hompath.setVisibility(View.GONE);
                    lineOMHC_Hompath.setVisibility(View.GONE);
                    rdogrpOMHC_Hompath.clearCheck();
                    secOMHC_TrHeal.setVisibility(View.GONE);
                    lineOMHC_TrHeal.setVisibility(View.GONE);
                    rdogrpOMHC_TrHeal.clearCheck();
                    secOMHC_SpiHeal.setVisibility(View.GONE);
                    lineOMHC_SpiHeal.setVisibility(View.GONE);
                    rdogrpOMHC_SpiHeal.clearCheck();
                    secOMHC_Oth.setVisibility(View.GONE);
                    lineOMHC_Oth.setVisibility(View.GONE);
                    rdogrpOMHC_Oth.clearCheck();
                    secOMHC_OthName.setVisibility(View.GONE);
                    lineOMHC_OthName.setVisibility(View.GONE);
                    txtOMHC_OthName.setText("");
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secOMHCarTypLabel.setVisibility(View.GONE);
                    lineOMHCarTypLabel.setVisibility(View.GONE);
                    secOMHC_PhyMBBS.setVisibility(View.GONE);
                    lineOMHC_PhyMBBS.setVisibility(View.GONE);
                    rdogrpOMHC_PhyMBBS.clearCheck();
                    secOMHC_UnquaDoctor.setVisibility(View.GONE);
                    lineOMHC_UnquaDoctor.setVisibility(View.GONE);
                    rdogrpOMHC_UnquaDoctor.clearCheck();
                    secOMHC_Para.setVisibility(View.GONE);
                    lineOMHC_Para.setVisibility(View.GONE);
                    rdogrpOMHC_Para.clearCheck();
                    secOMHC_Com.setVisibility(View.GONE);
                    lineOMHC_Com.setVisibility(View.GONE);
                    rdogrpOMHC_Com.clearCheck();
                    secOMHC_Pha.setVisibility(View.GONE);
                    lineOMHC_Pha.setVisibility(View.GONE);
                    rdogrpOMHC_Pha.clearCheck();
                    secOMHC_Hompath.setVisibility(View.GONE);
                    lineOMHC_Hompath.setVisibility(View.GONE);
                    rdogrpOMHC_Hompath.clearCheck();
                    secOMHC_TrHeal.setVisibility(View.GONE);
                    lineOMHC_TrHeal.setVisibility(View.GONE);
                    rdogrpOMHC_TrHeal.clearCheck();
                    secOMHC_SpiHeal.setVisibility(View.GONE);
                    lineOMHC_SpiHeal.setVisibility(View.GONE);
                    rdogrpOMHC_SpiHeal.clearCheck();
                    secOMHC_Oth.setVisibility(View.GONE);
                    lineOMHC_Oth.setVisibility(View.GONE);
                    rdogrpOMHC_Oth.clearCheck();
                    secOMHC_OthName.setVisibility(View.GONE);
                    lineOMHC_OthName.setVisibility(View.GONE);
                    txtOMHC_OthName.setText("");
             }
             else if(rbData.equalsIgnoreCase("1"))
             {
                    secOMHCarTypLabel.setVisibility(View.VISIBLE);
                    lineOMHCarTypLabel.setVisibility(View.VISIBLE);
                    secOMHC_PhyMBBS.setVisibility(View.VISIBLE);
                    lineOMHC_PhyMBBS.setVisibility(View.VISIBLE);
                    secOMHC_UnquaDoctor.setVisibility(View.VISIBLE);
                    lineOMHC_UnquaDoctor.setVisibility(View.VISIBLE);
                    secOMHC_Para.setVisibility(View.VISIBLE);
                    lineOMHC_Para.setVisibility(View.VISIBLE);
                    secOMHC_Com.setVisibility(View.VISIBLE);
                    lineOMHC_Com.setVisibility(View.VISIBLE);
                    secOMHC_Pha.setVisibility(View.VISIBLE);
                    lineOMHC_Pha.setVisibility(View.VISIBLE);
                    secOMHC_Hompath.setVisibility(View.VISIBLE);
                    lineOMHC_Hompath.setVisibility(View.VISIBLE);
                    secOMHC_TrHeal.setVisibility(View.VISIBLE);
                    lineOMHC_TrHeal.setVisibility(View.VISIBLE);
                    secOMHC_SpiHeal.setVisibility(View.VISIBLE);
                    lineOMHC_SpiHeal.setVisibility(View.VISIBLE);
                    secOMHC_Oth.setVisibility(View.VISIBLE);
                    lineOMHC_Oth.setVisibility(View.VISIBLE);
             }
             else{
                 secOMHCarTypLabel.setVisibility(View.GONE);
                 lineOMHCarTypLabel.setVisibility(View.GONE);
                 secOMHC_PhyMBBS.setVisibility(View.GONE);
                 lineOMHC_PhyMBBS.setVisibility(View.GONE);
                 rdogrpOMHC_PhyMBBS.clearCheck();
                 secOMHC_UnquaDoctor.setVisibility(View.GONE);
                 lineOMHC_UnquaDoctor.setVisibility(View.GONE);
                 rdogrpOMHC_UnquaDoctor.clearCheck();
                 secOMHC_Para.setVisibility(View.GONE);
                 lineOMHC_Para.setVisibility(View.GONE);
                 rdogrpOMHC_Para.clearCheck();
                 secOMHC_Com.setVisibility(View.GONE);
                 lineOMHC_Com.setVisibility(View.GONE);
                 rdogrpOMHC_Com.clearCheck();
                 secOMHC_Pha.setVisibility(View.GONE);
                 lineOMHC_Pha.setVisibility(View.GONE);
                 rdogrpOMHC_Pha.clearCheck();
                 secOMHC_Hompath.setVisibility(View.GONE);
                 lineOMHC_Hompath.setVisibility(View.GONE);
                 rdogrpOMHC_Hompath.clearCheck();
                 secOMHC_TrHeal.setVisibility(View.GONE);
                 lineOMHC_TrHeal.setVisibility(View.GONE);
                 rdogrpOMHC_TrHeal.clearCheck();
                 secOMHC_SpiHeal.setVisibility(View.GONE);
                 lineOMHC_SpiHeal.setVisibility(View.GONE);
                 rdogrpOMHC_SpiHeal.clearCheck();
                 secOMHC_Oth.setVisibility(View.GONE);
                 lineOMHC_Oth.setVisibility(View.GONE);
                 rdogrpOMHC_Oth.clearCheck();
                 secOMHC_OthName.setVisibility(View.GONE);
                 lineOMHC_OthName.setVisibility(View.GONE);
                 txtOMHC_OthName.setText("");
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secOMHCarTypLabel=(LinearLayout)findViewById(R.id.secOMHCarTypLabel);
         lineOMHCarTypLabel=(View)findViewById(R.id.lineOMHCarTypLabel);
         secOMHC_PhyMBBS=(LinearLayout)findViewById(R.id.secOMHC_PhyMBBS);
         lineOMHC_PhyMBBS=(View)findViewById(R.id.lineOMHC_PhyMBBS);
         VlblOMHC_PhyMBBS = (TextView) findViewById(R.id.VlblOMHC_PhyMBBS);
         rdogrpOMHC_PhyMBBS = (RadioGroup) findViewById(R.id.rdogrpOMHC_PhyMBBS);
         
         rdoOMHC_PhyMBBS1 = (RadioButton) findViewById(R.id.rdoOMHC_PhyMBBS1);
         rdoOMHC_PhyMBBS2 = (RadioButton) findViewById(R.id.rdoOMHC_PhyMBBS2);
         rdoOMHC_PhyMBBS3 = (RadioButton) findViewById(R.id.rdoOMHC_PhyMBBS3);
         secOMHC_UnquaDoctor=(LinearLayout)findViewById(R.id.secOMHC_UnquaDoctor);
         lineOMHC_UnquaDoctor=(View)findViewById(R.id.lineOMHC_UnquaDoctor);
         VlblOMHC_UnquaDoctor = (TextView) findViewById(R.id.VlblOMHC_UnquaDoctor);
         rdogrpOMHC_UnquaDoctor = (RadioGroup) findViewById(R.id.rdogrpOMHC_UnquaDoctor);
         
         rdoOMHC_UnquaDoctor1 = (RadioButton) findViewById(R.id.rdoOMHC_UnquaDoctor1);
         rdoOMHC_UnquaDoctor2 = (RadioButton) findViewById(R.id.rdoOMHC_UnquaDoctor2);
         rdoOMHC_UnquaDoctor3 = (RadioButton) findViewById(R.id.rdoOMHC_UnquaDoctor3);
         secOMHC_Para=(LinearLayout)findViewById(R.id.secOMHC_Para);
         lineOMHC_Para=(View)findViewById(R.id.lineOMHC_Para);
         VlblOMHC_Para = (TextView) findViewById(R.id.VlblOMHC_Para);
         rdogrpOMHC_Para = (RadioGroup) findViewById(R.id.rdogrpOMHC_Para);
         
         rdoOMHC_Para1 = (RadioButton) findViewById(R.id.rdoOMHC_Para1);
         rdoOMHC_Para2 = (RadioButton) findViewById(R.id.rdoOMHC_Para2);
         rdoOMHC_Para3 = (RadioButton) findViewById(R.id.rdoOMHC_Para3);
         secOMHC_Com=(LinearLayout)findViewById(R.id.secOMHC_Com);
         lineOMHC_Com=(View)findViewById(R.id.lineOMHC_Com);
         VlblOMHC_Com = (TextView) findViewById(R.id.VlblOMHC_Com);
         rdogrpOMHC_Com = (RadioGroup) findViewById(R.id.rdogrpOMHC_Com);
         
         rdoOMHC_Com1 = (RadioButton) findViewById(R.id.rdoOMHC_Com1);
         rdoOMHC_Com2 = (RadioButton) findViewById(R.id.rdoOMHC_Com2);
         rdoOMHC_Com3 = (RadioButton) findViewById(R.id.rdoOMHC_Com3);
         secOMHC_Pha=(LinearLayout)findViewById(R.id.secOMHC_Pha);
         lineOMHC_Pha=(View)findViewById(R.id.lineOMHC_Pha);
         VlblOMHC_Pha = (TextView) findViewById(R.id.VlblOMHC_Pha);
         rdogrpOMHC_Pha = (RadioGroup) findViewById(R.id.rdogrpOMHC_Pha);
         
         rdoOMHC_Pha1 = (RadioButton) findViewById(R.id.rdoOMHC_Pha1);
         rdoOMHC_Pha2 = (RadioButton) findViewById(R.id.rdoOMHC_Pha2);
         rdoOMHC_Pha3 = (RadioButton) findViewById(R.id.rdoOMHC_Pha3);
         secOMHC_Hompath=(LinearLayout)findViewById(R.id.secOMHC_Hompath);
         lineOMHC_Hompath=(View)findViewById(R.id.lineOMHC_Hompath);
         VlblOMHC_Hompath = (TextView) findViewById(R.id.VlblOMHC_Hompath);
         rdogrpOMHC_Hompath = (RadioGroup) findViewById(R.id.rdogrpOMHC_Hompath);
         
         rdoOMHC_Hompath1 = (RadioButton) findViewById(R.id.rdoOMHC_Hompath1);
         rdoOMHC_Hompath2 = (RadioButton) findViewById(R.id.rdoOMHC_Hompath2);
         rdoOMHC_Hompath3 = (RadioButton) findViewById(R.id.rdoOMHC_Hompath3);
         secOMHC_TrHeal=(LinearLayout)findViewById(R.id.secOMHC_TrHeal);
         lineOMHC_TrHeal=(View)findViewById(R.id.lineOMHC_TrHeal);
         VlblOMHC_TrHeal = (TextView) findViewById(R.id.VlblOMHC_TrHeal);
         rdogrpOMHC_TrHeal = (RadioGroup) findViewById(R.id.rdogrpOMHC_TrHeal);
         
         rdoOMHC_TrHeal1 = (RadioButton) findViewById(R.id.rdoOMHC_TrHeal1);
         rdoOMHC_TrHeal2 = (RadioButton) findViewById(R.id.rdoOMHC_TrHeal2);
         rdoOMHC_TrHeal3 = (RadioButton) findViewById(R.id.rdoOMHC_TrHeal3);
         secOMHC_SpiHeal=(LinearLayout)findViewById(R.id.secOMHC_SpiHeal);
         lineOMHC_SpiHeal=(View)findViewById(R.id.lineOMHC_SpiHeal);
         VlblOMHC_SpiHeal = (TextView) findViewById(R.id.VlblOMHC_SpiHeal);
         rdogrpOMHC_SpiHeal = (RadioGroup) findViewById(R.id.rdogrpOMHC_SpiHeal);
         
         rdoOMHC_SpiHeal1 = (RadioButton) findViewById(R.id.rdoOMHC_SpiHeal1);
         rdoOMHC_SpiHeal2 = (RadioButton) findViewById(R.id.rdoOMHC_SpiHeal2);
         rdoOMHC_SpiHeal3 = (RadioButton) findViewById(R.id.rdoOMHC_SpiHeal3);
         secOMHC_Oth=(LinearLayout)findViewById(R.id.secOMHC_Oth);
         lineOMHC_Oth=(View)findViewById(R.id.lineOMHC_Oth);
         VlblOMHC_Oth = (TextView) findViewById(R.id.VlblOMHC_Oth);
         rdogrpOMHC_Oth = (RadioGroup) findViewById(R.id.rdogrpOMHC_Oth);
         
         rdoOMHC_Oth1 = (RadioButton) findViewById(R.id.rdoOMHC_Oth1);
         rdoOMHC_Oth2 = (RadioButton) findViewById(R.id.rdoOMHC_Oth2);
         rdoOMHC_Oth3 = (RadioButton) findViewById(R.id.rdoOMHC_Oth3);
         rdogrpOMHC_Oth.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpOMHC_Oth = new String[] {"1","2","8"};
             for (int i = 0; i < rdogrpOMHC_Oth.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpOMHC_Oth.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpOMHC_Oth[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secOMHC_OthName.setVisibility(View.GONE);
                    lineOMHC_OthName.setVisibility(View.GONE);
                    txtOMHC_OthName.setText("");
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secOMHC_OthName.setVisibility(View.GONE);
                    lineOMHC_OthName.setVisibility(View.GONE);
                    txtOMHC_OthName.setText("");
             }
             else if(rbData.equalsIgnoreCase("1"))
             {
                    secOMHC_OthName.setVisibility(View.VISIBLE);
                    lineOMHC_OthName.setVisibility(View.VISIBLE);
             }
             else{
                 secOMHC_OthName.setVisibility(View.GONE);
                 lineOMHC_OthName.setVisibility(View.GONE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secOMHC_OthName=(LinearLayout)findViewById(R.id.secOMHC_OthName);
         lineOMHC_OthName=(View)findViewById(R.id.lineOMHC_OthName);
         VlblOMHC_OthName=(TextView) findViewById(R.id.VlblOMHC_OthName);
         txtOMHC_OthName=(EditText) findViewById(R.id.txtOMHC_OthName);
         secOMDSHOPD=(LinearLayout)findViewById(R.id.secOMDSHOPD);
         lineOMDSHOPD=(View)findViewById(R.id.lineOMDSHOPD);
         VlblOMDSHOPD = (TextView) findViewById(R.id.VlblOMDSHOPD);
         rdogrpOMDSHOPD = (RadioGroup) findViewById(R.id.rdogrpOMDSHOPD);
         
         rdoOMDSHOPD1 = (RadioButton) findViewById(R.id.rdoOMDSHOPD1);
         rdoOMDSHOPD2 = (RadioButton) findViewById(R.id.rdoOMDSHOPD2);
         rdoOMDSHOPD3 = (RadioButton) findViewById(R.id.rdoOMDSHOPD3);
         secOMSSFOPD=(LinearLayout)findViewById(R.id.secOMSSFOPD);
         lineOMSSFOPD=(View)findViewById(R.id.lineOMSSFOPD);
         VlblOMSSFOPD = (TextView) findViewById(R.id.VlblOMSSFOPD);
         rdogrpOMSSFOPD = (RadioGroup) findViewById(R.id.rdogrpOMSSFOPD);
         
         rdoOMSSFOPD1 = (RadioButton) findViewById(R.id.rdoOMSSFOPD1);
         rdoOMSSFOPD2 = (RadioButton) findViewById(R.id.rdoOMSSFOPD2);
         rdoOMSSFOPD3 = (RadioButton) findViewById(R.id.rdoOMSSFOPD3);
         secOMReco=(LinearLayout)findViewById(R.id.secOMReco);
         lineOMReco=(View)findViewById(R.id.lineOMReco);
         VlblOMReco = (TextView) findViewById(R.id.VlblOMReco);
         rdogrpOMReco = (RadioGroup) findViewById(R.id.rdogrpOMReco);
         
         rdoOMReco1 = (RadioButton) findViewById(R.id.rdoOMReco1);
         rdoOMReco2 = (RadioButton) findViewById(R.id.rdoOMReco2);
         rdoOMReco3 = (RadioButton) findViewById(R.id.rdoOMReco3);
         rdogrpOMReco.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpOMReco = new String[] {"1","2","8"};
             for (int i = 0; i < rdogrpOMReco.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpOMReco.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpOMReco[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                 secOMDurReco.setVisibility(View.GONE);
                 lineOMDurReco.setVisibility(View.GONE);

             }
             else if(rbData.equalsIgnoreCase("8"))
             {

                 secOMDurReco.setVisibility(View.GONE);
                 lineOMDurReco.setVisibility(View.GONE);
             }
             else if(rbData.equalsIgnoreCase("1"))
             {
                    secOMDurReco.setVisibility(View.VISIBLE);
                    lineOMDurReco.setVisibility(View.VISIBLE);
                ;
             }
             else{

                 secOMDurReco.setVisibility(View.GONE);
                 lineOMDurReco.setVisibility(View.GONE);
             }
            }


         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secOMDurReco=(LinearLayout)findViewById(R.id.secOMDurReco);
         lineOMDurReco=(View)findViewById(R.id.lineOMDurReco);
         VlblOMDurReco=(TextView) findViewById(R.id.VlblOMDurReco);
         txtOMDurReco=(EditText) findViewById(R.id.txtOMDurReco);
         secOMInRecoLabel=(LinearLayout)findViewById(R.id.secOMInRecoLabel);
         lineOMInRecoLabel=(View)findViewById(R.id.lineOMInRecoLabel);
         secOMInReco=(LinearLayout)findViewById(R.id.secOMInReco);
         lineOMInReco=(View)findViewById(R.id.lineOMInReco);
         VlblOMInReco=(TextView) findViewById(R.id.VlblOMInReco);
         spnOMInReco=(Spinner) findViewById(R.id.spnOMInReco);
         List<String> listOMInReco = new ArrayList<String>();
         
         listOMInReco.add("");
         listOMInReco.add("1-মৃত্যু (Death) ");
         listOMInReco.add("2-শ্রবণ শক্তি হারানো (Hearing loss) ");
         listOMInReco.add("7-অন্যান্য (Other) ");
         ArrayAdapter<String> adptrOMInReco= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listOMInReco);
         spnOMInReco.setAdapter(adptrOMInReco);

         spnOMInReco.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnOMInReco.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnOMInReco.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("1"))
                 {
                    secOMInRecoOth.setVisibility(View.GONE);
                    lineOMInRecoOth.setVisibility(View.GONE);
                    txtOMInRecoOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("2"))
                 {
                    secOMInRecoOth.setVisibility(View.GONE);
                    lineOMInRecoOth.setVisibility(View.GONE);
                    txtOMInRecoOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("7"))
                 {
                    secOMInRecoOth.setVisibility(View.VISIBLE);
                    lineOMInRecoOth.setVisibility(View.VISIBLE);
                 }
                 else{
                     secOMInRecoOth.setVisibility(View.GONE);
                     lineOMInRecoOth.setVisibility(View.GONE);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secOMInRecoOth=(LinearLayout)findViewById(R.id.secOMInRecoOth);
         lineOMInRecoOth=(View)findViewById(R.id.lineOMInRecoOth);
         VlblOMInRecoOth=(TextView) findViewById(R.id.VlblOMInRecoOth);
         txtOMInRecoOth=(EditText) findViewById(R.id.txtOMInRecoOth);
         secOMInReco2=(LinearLayout)findViewById(R.id.secOMInReco2);
         lineOMInReco2=(View)findViewById(R.id.lineOMInReco2);
         VlblOMInReco2=(TextView) findViewById(R.id.VlblOMInReco2);
         spnOMInReco2=(Spinner) findViewById(R.id.spnOMInReco2);
         List<String> listOMInReco2 = new ArrayList<String>();
         
         listOMInReco2.add("");
         listOMInReco2.add("1-মৃত্যু (Death) ");
         listOMInReco2.add("2-শ্রবণ শক্তি হারানো (Hearing loss) ");
         listOMInReco2.add("7-অন্যান্য (Other) ");
         ArrayAdapter<String> adptrOMInReco2= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listOMInReco2);
         spnOMInReco2.setAdapter(adptrOMInReco2);

         spnOMInReco2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnOMInReco2.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnOMInReco2.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("1"))
                 {
                    secOMInRecoOth2.setVisibility(View.GONE);
                    lineOMInRecoOth2.setVisibility(View.GONE);
                    txtOMInRecoOth2.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("2"))
                 {
                    secOMInRecoOth2.setVisibility(View.GONE);
                    lineOMInRecoOth2.setVisibility(View.GONE);
                    txtOMInRecoOth2.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("7"))
                 {
                    secOMInRecoOth2.setVisibility(View.VISIBLE);
                    lineOMInRecoOth2.setVisibility(View.VISIBLE);
                 }
                 else{
                     secOMInRecoOth2.setVisibility(View.GONE);
                     lineOMInRecoOth2.setVisibility(View.GONE);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         txtOMDurReco.addTextChangedListener(new TextWatcher() {
             @Override
             public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

             }

             @Override
             public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                 if(txtOMDurReco.getText().toString().length()>0)
                 {
                     secOMInRecoLabel.setVisibility(View.GONE);
                     lineOMInRecoLabel.setVisibility(View.GONE);
                     secOMInReco.setVisibility(View.GONE);
                     lineOMInReco.setVisibility(View.GONE);
                     spnOMInReco.setSelection(0);
                     secOMInRecoOth.setVisibility(View.GONE);
                     lineOMInRecoOth.setVisibility(View.GONE);
                     txtOMInRecoOth.setText("");
                     secOMInReco2.setVisibility(View.GONE);
                     lineOMInReco2.setVisibility(View.GONE);
                     spnOMInReco2.setSelection(0);
                     secOMInRecoOth2.setVisibility(View.GONE);
                     lineOMInRecoOth2.setVisibility(View.GONE);
                     txtOMInRecoOth2.setText("");
                 }else{
                     secOMInRecoLabel.setVisibility(View.VISIBLE);
                     lineOMInRecoLabel.setVisibility(View.VISIBLE);
                     secOMInReco.setVisibility(View.VISIBLE);
                     lineOMInReco.setVisibility(View.VISIBLE);
                     spnOMInReco.setSelection(0);

                     secOMInReco2.setVisibility(View.VISIBLE);
                     lineOMInReco2.setVisibility(View.VISIBLE);
                     spnOMInReco2.setSelection(0);

                 }



             }

             @Override
             public void afterTextChanged(Editable editable) {

             }
         });

         secOMInRecoOth2=(LinearLayout)findViewById(R.id.secOMInRecoOth2);
         lineOMInRecoOth2=(View)findViewById(R.id.lineOMInRecoOth2);
         VlblOMInRecoOth2=(TextView) findViewById(R.id.VlblOMInRecoOth2);
         txtOMInRecoOth2=(EditText) findViewById(R.id.txtOMInRecoOth2);
         secOMAboIll=(LinearLayout)findViewById(R.id.secOMAboIll);
         lineOMAboIll=(View)findViewById(R.id.lineOMAboIll);
         VlblOMAboIll=(TextView) findViewById(R.id.VlblOMAboIll);
         txtOMAboIll=(EditText) findViewById(R.id.txtOMAboIll);





         //Hide all skip variables
         secOMEDisEpi.setVisibility(View.GONE);
         lineOMEDisEpi.setVisibility(View.GONE);
         secOMHCar.setVisibility(View.GONE);
         lineOMHCar.setVisibility(View.GONE);
         secOMHCarTypLabel.setVisibility(View.GONE);
         lineOMHCarTypLabel.setVisibility(View.GONE);
         secOMHC_PhyMBBS.setVisibility(View.GONE);
         lineOMHC_PhyMBBS.setVisibility(View.GONE);
         secOMHC_UnquaDoctor.setVisibility(View.GONE);
         lineOMHC_UnquaDoctor.setVisibility(View.GONE);
         secOMHC_Para.setVisibility(View.GONE);
         lineOMHC_Para.setVisibility(View.GONE);
         secOMHC_Com.setVisibility(View.GONE);
         lineOMHC_Com.setVisibility(View.GONE);
         secOMHC_Pha.setVisibility(View.GONE);
         lineOMHC_Pha.setVisibility(View.GONE);
         secOMHC_Hompath.setVisibility(View.GONE);
         lineOMHC_Hompath.setVisibility(View.GONE);
         secOMHC_TrHeal.setVisibility(View.GONE);
         lineOMHC_TrHeal.setVisibility(View.GONE);
         secOMHC_SpiHeal.setVisibility(View.GONE);
         lineOMHC_SpiHeal.setVisibility(View.GONE);
         secOMHC_Oth.setVisibility(View.GONE);
         lineOMHC_Oth.setVisibility(View.GONE);
         secOMHC_OthName.setVisibility(View.GONE);
         lineOMHC_OthName.setVisibility(View.GONE);
         secOMDSHOPD.setVisibility(View.GONE);
         lineOMDSHOPD.setVisibility(View.GONE);
         secOMSSFOPD.setVisibility(View.GONE);
         lineOMSSFOPD.setVisibility(View.GONE);
         secOMReco.setVisibility(View.GONE);
         lineOMReco.setVisibility(View.GONE);
         secOMDurReco.setVisibility(View.GONE);
         lineOMDurReco.setVisibility(View.GONE);
         secOMInRecoLabel.setVisibility(View.GONE);
         lineOMInRecoLabel.setVisibility(View.GONE);
         secOMInReco.setVisibility(View.GONE);
         lineOMInReco.setVisibility(View.GONE);
         secOMInRecoOth.setVisibility(View.GONE);
         lineOMInRecoOth.setVisibility(View.GONE);
         secOMInReco2.setVisibility(View.GONE);
         lineOMInReco2.setVisibility(View.GONE);
         secOMInRecoOth2.setVisibility(View.GONE);
         lineOMInRecoOth2.setVisibility(View.GONE);
         secOMAboIll.setVisibility(View.GONE);
         lineOMAboIll.setVisibility(View.GONE);
         secOMEDisEpi.setVisibility(View.GONE);
         lineOMEDisEpi.setVisibility(View.GONE);
         secOMHCar.setVisibility(View.GONE);
         lineOMHCar.setVisibility(View.GONE);
         secOMHCarTypLabel.setVisibility(View.GONE);
         lineOMHCarTypLabel.setVisibility(View.GONE);
         secOMHC_PhyMBBS.setVisibility(View.GONE);
         lineOMHC_PhyMBBS.setVisibility(View.GONE);
         secOMHC_UnquaDoctor.setVisibility(View.GONE);
         lineOMHC_UnquaDoctor.setVisibility(View.GONE);
         secOMHC_Para.setVisibility(View.GONE);
         lineOMHC_Para.setVisibility(View.GONE);
         secOMHC_Com.setVisibility(View.GONE);
         lineOMHC_Com.setVisibility(View.GONE);
         secOMHC_Pha.setVisibility(View.GONE);
         lineOMHC_Pha.setVisibility(View.GONE);
         secOMHC_Hompath.setVisibility(View.GONE);
         lineOMHC_Hompath.setVisibility(View.GONE);
         secOMHC_TrHeal.setVisibility(View.GONE);
         lineOMHC_TrHeal.setVisibility(View.GONE);
         secOMHC_SpiHeal.setVisibility(View.GONE);
         lineOMHC_SpiHeal.setVisibility(View.GONE);
         secOMHC_Oth.setVisibility(View.GONE);
         lineOMHC_Oth.setVisibility(View.GONE);
         secOMHC_OthName.setVisibility(View.GONE);
         lineOMHC_OthName.setVisibility(View.GONE);
         secOMDSHOPD.setVisibility(View.GONE);
         lineOMDSHOPD.setVisibility(View.GONE);
         secOMSSFOPD.setVisibility(View.GONE);
         lineOMSSFOPD.setVisibility(View.GONE);
         secOMReco.setVisibility(View.GONE);
         lineOMReco.setVisibility(View.GONE);
         secOMDurReco.setVisibility(View.GONE);
         lineOMDurReco.setVisibility(View.GONE);
         secOMInRecoLabel.setVisibility(View.GONE);
         lineOMInRecoLabel.setVisibility(View.GONE);
         secOMInReco.setVisibility(View.GONE);
         lineOMInReco.setVisibility(View.GONE);
         secOMInRecoOth.setVisibility(View.GONE);
         lineOMInRecoOth.setVisibility(View.GONE);
         secOMInReco2.setVisibility(View.GONE);
         lineOMInReco2.setVisibility(View.GONE);
         secOMInRecoOth2.setVisibility(View.GONE);
         lineOMInRecoOth2.setVisibility(View.GONE);
         secOMAboIll.setVisibility(View.GONE);
         lineOMAboIll.setVisibility(View.GONE);
         secOMHCarTypLabel.setVisibility(View.GONE);
         lineOMHCarTypLabel.setVisibility(View.GONE);
         secOMHC_PhyMBBS.setVisibility(View.GONE);
         lineOMHC_PhyMBBS.setVisibility(View.GONE);
         secOMHC_UnquaDoctor.setVisibility(View.GONE);
         lineOMHC_UnquaDoctor.setVisibility(View.GONE);
         secOMHC_Para.setVisibility(View.GONE);
         lineOMHC_Para.setVisibility(View.GONE);
         secOMHC_Com.setVisibility(View.GONE);
         lineOMHC_Com.setVisibility(View.GONE);
         secOMHC_Pha.setVisibility(View.GONE);
         lineOMHC_Pha.setVisibility(View.GONE);
         secOMHC_Hompath.setVisibility(View.GONE);
         lineOMHC_Hompath.setVisibility(View.GONE);
         secOMHC_TrHeal.setVisibility(View.GONE);
         lineOMHC_TrHeal.setVisibility(View.GONE);
         secOMHC_SpiHeal.setVisibility(View.GONE);
         lineOMHC_SpiHeal.setVisibility(View.GONE);
         secOMHC_Oth.setVisibility(View.GONE);
         lineOMHC_Oth.setVisibility(View.GONE);
         secOMHC_OthName.setVisibility(View.GONE);
         lineOMHC_OthName.setVisibility(View.GONE);
         secOMHCarTypLabel.setVisibility(View.GONE);
         lineOMHCarTypLabel.setVisibility(View.GONE);
         secOMHC_PhyMBBS.setVisibility(View.GONE);
         lineOMHC_PhyMBBS.setVisibility(View.GONE);
         secOMHC_UnquaDoctor.setVisibility(View.GONE);
         lineOMHC_UnquaDoctor.setVisibility(View.GONE);
         secOMHC_Para.setVisibility(View.GONE);
         lineOMHC_Para.setVisibility(View.GONE);
         secOMHC_Com.setVisibility(View.GONE);
         lineOMHC_Com.setVisibility(View.GONE);
         secOMHC_Pha.setVisibility(View.GONE);
         lineOMHC_Pha.setVisibility(View.GONE);
         secOMHC_Hompath.setVisibility(View.GONE);
         lineOMHC_Hompath.setVisibility(View.GONE);
         secOMHC_TrHeal.setVisibility(View.GONE);
         lineOMHC_TrHeal.setVisibility(View.GONE);
         secOMHC_SpiHeal.setVisibility(View.GONE);
         lineOMHC_SpiHeal.setVisibility(View.GONE);
         secOMHC_Oth.setVisibility(View.GONE);
         lineOMHC_Oth.setVisibility(View.GONE);
         secOMHC_OthName.setVisibility(View.GONE);
         lineOMHC_OthName.setVisibility(View.GONE);
         secOMHC_OthName.setVisibility(View.GONE);
         lineOMHC_OthName.setVisibility(View.GONE);
         secOMHC_OthName.setVisibility(View.GONE);
         lineOMHC_OthName.setVisibility(View.GONE);
         secOMDurReco.setVisibility(View.GONE);
         lineOMDurReco.setVisibility(View.GONE);
         secOMInRecoLabel.setVisibility(View.GONE);
         lineOMInRecoLabel.setVisibility(View.GONE);
         secOMDurReco.setVisibility(View.GONE);
         lineOMDurReco.setVisibility(View.GONE);
         secOMInRecoLabel.setVisibility(View.GONE);
         lineOMInRecoLabel.setVisibility(View.GONE);
         secOMInRecoOth.setVisibility(View.GONE);
         lineOMInRecoOth.setVisibility(View.GONE);
         secOMInRecoOth.setVisibility(View.GONE);
         lineOMInRecoOth.setVisibility(View.GONE);
         secOMInRecoOth2.setVisibility(View.GONE);
         lineOMInRecoOth2.setVisibility(View.GONE);
         secOMInRecoOth2.setVisibility(View.GONE);
         lineOMInRecoOth2.setVisibility(View.GONE);


         DataSearch(UNCODE,STRUCTURENO,HOUSEHOLDSL,VISITNO,MEMSL);


        Button cmdSave = (Button) findViewById(R.id.cmdSave);
        cmdSave.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) { 
            DataSave();
        }});
     }
     catch(Exception  e)
     {
         Connection.MessageBox(OtitisMediaCase .this, e.getMessage());
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
             Connection.MessageBox(OtitisMediaCase .this, "Required field: Ward No.");
             txtUNCode.requestFocus(); 
             return;	
           }
         else if(txtStructureNo.getText().toString().length()==0 & secStructureNo.isShown())
           {
             Connection.MessageBox(OtitisMediaCase .this, "Required field: Structure No.");
             txtStructureNo.requestFocus(); 
             return;	
           }
         else if(txtHouseholdSl.getText().toString().length()==0 & secHouseholdSl.isShown())
           {
             Connection.MessageBox(OtitisMediaCase .this, "Required field: Household Sl.");
             txtHouseholdSl.requestFocus(); 
             return;	
           }
         else if(txtVisitNo.getText().toString().length()==0 & secVisitNo.isShown())
           {
             Connection.MessageBox(OtitisMediaCase .this, "Required field: Visit No.");
             txtVisitNo.requestFocus(); 
             return;	
           }
         else if(txtMemSl.getText().toString().length()==0 & secMemSl.isShown())
           {
             Connection.MessageBox(OtitisMediaCase .this, "Required field: Member Serial.");
             txtMemSl.requestFocus(); 
             return;	
           }
         
         else if(!rdoOMEDis1.isChecked() & !rdoOMEDis2.isChecked() & !rdoOMEDis3.isChecked() & secOMEDis.isShown())
           {
              Connection.MessageBox(OtitisMediaCase .this, "Select anyone options from (গত ১২ মাসে এই  শিশুটির কি এক কান বা উভয় কান দিয়ে পানি/পুঁজ গড়িয়ে পরেছিল? (পূর্বের বর্ণনা করা অসুস্থতা ছাড়া)  (Within the last 12 months did this child have an illness) ).");
              rdoOMEDis1.requestFocus();
              return;
           }
         else if(txtOMEDisEpi.getText().toString().length()==0 & secOMEDisEpi.isShown())
           {
             Connection.MessageBox(OtitisMediaCase .this, "Required field: গত ১২ মাসে এই শিশুর কতবার এই ধরনের অসুস্থতা হয়েছিল? (যদি একের অধিক এই অসুস্থতা হয়ে থাকে তবে অতিসম্প্রতি অসুস্থতা সম্পর্কে নিচের প্রশ্নগুলো করুন) (Within the last 12 months how many episodes of such an illness did this child have?).");
             txtOMEDisEpi.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtOMEDisEpi.getText().toString().length()==0 ? "1" : txtOMEDisEpi.getText().toString()) < 1 || Integer.valueOf(txtOMEDisEpi.getText().toString().length()==0 ? "88" : txtOMEDisEpi.getText().toString()) > 88)
           {
             Connection.MessageBox(OtitisMediaCase .this, "Value should be between 1 and 88(গত ১২ মাসে এই শিশুর কতবার এই ধরনের অসুস্থতা হয়েছিল? (যদি একের অধিক এই অসুস্থতা হয়ে থাকে তবে অতিসম্প্রতি অসুস্থতা সম্পর্কে নিচের প্রশ্নগুলো করুন) (Within the last 12 months how many episodes of such an illness did this child have?)).");
             txtOMEDisEpi.requestFocus(); 
             return;	
           }
         
         else if(!rdoOMHCar1.isChecked() & !rdoOMHCar2.isChecked() & !rdoOMHCar3.isChecked() & secOMHCar.isShown())
           {
              Connection.MessageBox(OtitisMediaCase .this, "Select anyone options from (এই অসুস্থতার সময় এই শিশুটিকে কি কোন স্বাস্থ্যসেবা দানকারীর কাছে নিয়ে গিয়েছিলেন ? (During this episode of illness, did you bring your child to a health care provider?)).");
              rdoOMHCar1.requestFocus();
              return;
           }
         
         else if(!rdoOMHC_PhyMBBS1.isChecked() & !rdoOMHC_PhyMBBS2.isChecked() & !rdoOMHC_PhyMBBS3.isChecked() & secOMHC_PhyMBBS.isShown())
           {
              Connection.MessageBox(OtitisMediaCase .this, "Select anyone options from (1.পাশ করা ডাক্তার যেমন MBBS বা এর উপর (MBBS and above) ).");
              rdoOMHC_PhyMBBS1.requestFocus();
              return;
           }
         
         else if(!rdoOMHC_UnquaDoctor1.isChecked() & !rdoOMHC_UnquaDoctor2.isChecked() & !rdoOMHC_UnquaDoctor3.isChecked() & secOMHC_UnquaDoctor.isShown())
           {
              Connection.MessageBox(OtitisMediaCase .this, "Select anyone options from (2.অদক্ষ ডাক্তার/ LMAF (Unqualified doctor/LMAF) ).");
              rdoOMHC_UnquaDoctor1.requestFocus();
              return;
           }
         
         else if(!rdoOMHC_Para1.isChecked() & !rdoOMHC_Para2.isChecked() & !rdoOMHC_Para3.isChecked() & secOMHC_Para.isShown())
           {
              Connection.MessageBox(OtitisMediaCase .this, "Select anyone options from (3.প্যারামেডিক (GoB/NGO) (Paramedics (GoB/NGO))  ).");
              rdoOMHC_Para1.requestFocus();
              return;
           }
         
         else if(!rdoOMHC_Com1.isChecked() & !rdoOMHC_Com2.isChecked() & !rdoOMHC_Com3.isChecked() & secOMHC_Com.isShown())
           {
              Connection.MessageBox(OtitisMediaCase .this, "Select anyone options from (4.কম্পাউণ্ডার (Compounder)).");
              rdoOMHC_Com1.requestFocus();
              return;
           }
         
         else if(!rdoOMHC_Pha1.isChecked() & !rdoOMHC_Pha2.isChecked() & !rdoOMHC_Pha3.isChecked() & secOMHC_Pha.isShown())
           {
              Connection.MessageBox(OtitisMediaCase .this, "Select anyone options from (5.ঔষধ বিক্রেতা/ফার্মেসি (Drug seller/Pharmacy)  ).");
              rdoOMHC_Pha1.requestFocus();
              return;
           }
         
         else if(!rdoOMHC_Hompath1.isChecked() & !rdoOMHC_Hompath2.isChecked() & !rdoOMHC_Hompath3.isChecked() & secOMHC_Hompath.isShown())
           {
              Connection.MessageBox(OtitisMediaCase .this, "Select anyone options from (6.হোমিওপ্যাঁথ (Homeopath)  ).");
              rdoOMHC_Hompath1.requestFocus();
              return;
           }
         
         else if(!rdoOMHC_TrHeal1.isChecked() & !rdoOMHC_TrHeal2.isChecked() & !rdoOMHC_TrHeal3.isChecked() & secOMHC_TrHeal.isShown())
           {
              Connection.MessageBox(OtitisMediaCase .this, "Select anyone options from (7.কবিরাজ (Traditional care provider)  ).");
              rdoOMHC_TrHeal1.requestFocus();
              return;
           }
         
         else if(!rdoOMHC_SpiHeal1.isChecked() & !rdoOMHC_SpiHeal2.isChecked() & !rdoOMHC_SpiHeal3.isChecked() & secOMHC_SpiHeal.isShown())
           {
              Connection.MessageBox(OtitisMediaCase .this, "Select anyone options from (8.আধ্যাত্মিক চিকিৎসক (Spiritual healer) ).");
              rdoOMHC_SpiHeal1.requestFocus();
              return;
           }
         
         else if(!rdoOMHC_Oth1.isChecked() & !rdoOMHC_Oth2.isChecked() & !rdoOMHC_Oth3.isChecked() & secOMHC_Oth.isShown())
           {
              Connection.MessageBox(OtitisMediaCase .this, "Select anyone options from (9.অন্যান্য  (Other)).");
              rdoOMHC_Oth1.requestFocus();
              return;
           }
         else if(txtOMHC_OthName.getText().toString().length()==0 & secOMHC_OthName.isShown())
           {
             Connection.MessageBox(OtitisMediaCase .this, "Required field: অন্যান্য উল্লেখ করুন (Others Specify).");
             txtOMHC_OthName.requestFocus(); 
             return;	
           }
         
         else if(!rdoOMDSHOPD1.isChecked() & !rdoOMDSHOPD2.isChecked() & !rdoOMDSHOPD3.isChecked() & secOMDSHOPD.isShown())
           {
              Connection.MessageBox(OtitisMediaCase .this, "Select anyone options from (শিশুটিকে কি ঢাকা শিশু হাসপাতালের বহির্বিভাগে (OPD)নেয়া হয়েছিল? (Was the child seen at outdoor patient department (OPD) of Dhaka Shishu Hospital?)).");
              rdoOMDSHOPD1.requestFocus();
              return;
           }
         
         else if(!rdoOMSSFOPD1.isChecked() & !rdoOMSSFOPD2.isChecked() & !rdoOMSSFOPD3.isChecked() & secOMSSFOPD.isShown())
           {
              Connection.MessageBox(OtitisMediaCase .this, "Select anyone options from (শিশুটিকে কি মিরপুর ডাঃ এম আর খান  শিশু হাসপাতাল  এর  বহির্বিভাগে নেয়া হয়েছিল ? (Was the child seen as an outdoor patient at Mirpur Dr. MR Khan Shishu Hospital?)).");
              rdoOMSSFOPD1.requestFocus();
              return;
           }
         
         else if(!rdoOMReco1.isChecked() & !rdoOMReco2.isChecked() & !rdoOMReco3.isChecked() & secOMReco.isShown())
           {
              Connection.MessageBox(OtitisMediaCase .this, "Select anyone options from (শিশুটি কি সম্পূর্ণ সুস্থ হয়ে গিয়েছিল? (Did the child recover completely?)).");
              rdoOMReco1.requestFocus();
              return;
           }
         else if(txtOMDurReco.getText().toString().length()==0 & secOMDurReco.isShown())
           {
             Connection.MessageBox(OtitisMediaCase .this, "Required field: শিশুটি সুস্থ হতে কতদিন লেগেছিল? (যদি  জানা না থাকে 98) (How long did it take for the child to completely recover?).");
             txtOMDurReco.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtOMDurReco.getText().toString().length()==0 ? "01" : txtOMDurReco.getText().toString()) < 01 || Integer.valueOf(txtOMDurReco.getText().toString().length()==0 ? "98" : txtOMDurReco.getText().toString()) > 98)
           {
             Connection.MessageBox(OtitisMediaCase .this, "Value should be between 01 and 98(শিশুটি সুস্থ হতে কতদিন লেগেছিল? (যদি  জানা না থাকে 98) (How long did it take for the child to completely recover?)).");
             txtOMDurReco.requestFocus(); 
             return;	
           }
         else if(spnOMInReco.getSelectedItemPosition()==0  & secOMInReco.isShown())
           {
             Connection.MessageBox(OtitisMediaCase .this, "Required field: 1..");
             spnOMInReco.requestFocus(); 
             return;	
           }
         else if(txtOMInRecoOth.getText().toString().length()==0 & secOMInRecoOth.isShown())
           {
             Connection.MessageBox(OtitisMediaCase .this, "Required field: অন্যান্য উল্লেখ করুন (Others Specify).");
             txtOMInRecoOth.requestFocus(); 
             return;	
           }
         else if(spnOMInReco2.getSelectedItemPosition()==0  & secOMInReco2.isShown())
           {
             Connection.MessageBox(OtitisMediaCase .this, "Required field: 2..");
             spnOMInReco2.requestFocus(); 
             return;	
           }
         else if(txtOMInRecoOth2.getText().toString().length()==0 & secOMInRecoOth2.isShown())
           {
             Connection.MessageBox(OtitisMediaCase .this, "Required field: অন্যান্য উল্লেখ করুন (Others Specify).");
             txtOMInRecoOth2.requestFocus(); 
             return;	
           }
//         else if(txtOMAboIll.getText().toString().length()==0 & secOMAboIll.isShown())
//           {
//             Connection.MessageBox(OtitisMediaCase .this, "Required field: মন্তব্যঃ কানে সংক্রমন  (Remarks:Otitis Media).");
//             txtOMAboIll.requestFocus();
//             return;
//           }
 
         String SQL = "";
         RadioButton rb;

         OtitisMediaCase_DataModel objSave = new OtitisMediaCase_DataModel();
         objSave.setUNCode(txtUNCode.getText().toString());
         objSave.setStructureNo(txtStructureNo.getText().toString());
         objSave.setHouseholdSl(txtHouseholdSl.getText().toString());
         objSave.setVisitNo(txtVisitNo.getText().toString());
         objSave.setMemSl(txtMemSl.getText().toString());
         String[] d_rdogrpOMEDis = new String[] {"1","2","8"};
         objSave.setOMEDis(0);
         for (int i = 0; i < rdogrpOMEDis.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpOMEDis.getChildAt(i);
             if (rb.isChecked()) objSave.setOMEDis(Integer.valueOf(d_rdogrpOMEDis[i]));
         }

         objSave.setOMEDisEpi(Integer.valueOf(txtOMEDisEpi.getText().toString().length()==0?"0":txtOMEDisEpi.getText().toString()));
         String[] d_rdogrpOMHCar = new String[] {"1","2","8"};
         objSave.setOMHCar(0);
         for (int i = 0; i < rdogrpOMHCar.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpOMHCar.getChildAt(i);
             if (rb.isChecked()) objSave.setOMHCar(Integer.valueOf(d_rdogrpOMHCar[i]));
         }

         String[] d_rdogrpOMHC_PhyMBBS = new String[] {"1","2","8"};
         objSave.setOMHC_PhyMBBS(0);
         for (int i = 0; i < rdogrpOMHC_PhyMBBS.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpOMHC_PhyMBBS.getChildAt(i);
             if (rb.isChecked()) objSave.setOMHC_PhyMBBS(Integer.valueOf(d_rdogrpOMHC_PhyMBBS[i]));
         }

         String[] d_rdogrpOMHC_UnquaDoctor = new String[] {"1","2","8"};
         objSave.setOMHC_UnquaDoctor(0);
         for (int i = 0; i < rdogrpOMHC_UnquaDoctor.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpOMHC_UnquaDoctor.getChildAt(i);
             if (rb.isChecked()) objSave.setOMHC_UnquaDoctor(Integer.valueOf(d_rdogrpOMHC_UnquaDoctor[i]));
         }

         String[] d_rdogrpOMHC_Para = new String[] {"1","2","8"};
         objSave.setOMHC_Para(0);
         for (int i = 0; i < rdogrpOMHC_Para.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpOMHC_Para.getChildAt(i);
             if (rb.isChecked()) objSave.setOMHC_Para(Integer.valueOf(d_rdogrpOMHC_Para[i]));
         }

         String[] d_rdogrpOMHC_Com = new String[] {"1","2","8"};
         objSave.setOMHC_Com(0);
         for (int i = 0; i < rdogrpOMHC_Com.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpOMHC_Com.getChildAt(i);
             if (rb.isChecked()) objSave.setOMHC_Com(Integer.valueOf(d_rdogrpOMHC_Com[i]));
         }

         String[] d_rdogrpOMHC_Pha = new String[] {"1","2","8"};
         objSave.setOMHC_Pha(0);
         for (int i = 0; i < rdogrpOMHC_Pha.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpOMHC_Pha.getChildAt(i);
             if (rb.isChecked()) objSave.setOMHC_Pha(Integer.valueOf(d_rdogrpOMHC_Pha[i]));
         }

         String[] d_rdogrpOMHC_Hompath = new String[] {"1","2","8"};
         objSave.setOMHC_Hompath(0);
         for (int i = 0; i < rdogrpOMHC_Hompath.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpOMHC_Hompath.getChildAt(i);
             if (rb.isChecked()) objSave.setOMHC_Hompath(Integer.valueOf(d_rdogrpOMHC_Hompath[i]));
         }

         String[] d_rdogrpOMHC_TrHeal = new String[] {"1","2","8"};
         objSave.setOMHC_TrHeal(0);
         for (int i = 0; i < rdogrpOMHC_TrHeal.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpOMHC_TrHeal.getChildAt(i);
             if (rb.isChecked()) objSave.setOMHC_TrHeal(Integer.valueOf(d_rdogrpOMHC_TrHeal[i]));
         }

         String[] d_rdogrpOMHC_SpiHeal = new String[] {"1","2","8"};
         objSave.setOMHC_SpiHeal(0);
         for (int i = 0; i < rdogrpOMHC_SpiHeal.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpOMHC_SpiHeal.getChildAt(i);
             if (rb.isChecked()) objSave.setOMHC_SpiHeal(Integer.valueOf(d_rdogrpOMHC_SpiHeal[i]));
         }

         String[] d_rdogrpOMHC_Oth = new String[] {"1","2","8"};
         objSave.setOMHC_Oth(0);
         for (int i = 0; i < rdogrpOMHC_Oth.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpOMHC_Oth.getChildAt(i);
             if (rb.isChecked()) objSave.setOMHC_Oth(Integer.valueOf(d_rdogrpOMHC_Oth[i]));
         }

         objSave.setOMHC_OthName(txtOMHC_OthName.getText().toString());
         String[] d_rdogrpOMDSHOPD = new String[] {"1","2","8"};
         objSave.setOMDSHOPD(0);
         for (int i = 0; i < rdogrpOMDSHOPD.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpOMDSHOPD.getChildAt(i);
             if (rb.isChecked()) objSave.setOMDSHOPD(Integer.valueOf(d_rdogrpOMDSHOPD[i]));
         }

         String[] d_rdogrpOMSSFOPD = new String[] {"1","2","8"};
         objSave.setOMSSFOPD(0);
         for (int i = 0; i < rdogrpOMSSFOPD.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpOMSSFOPD.getChildAt(i);
             if (rb.isChecked()) objSave.setOMSSFOPD(Integer.valueOf(d_rdogrpOMSSFOPD[i]));
         }

         String[] d_rdogrpOMReco = new String[] {"1","2","8"};
         objSave.setOMReco(0);
         for (int i = 0; i < rdogrpOMReco.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpOMReco.getChildAt(i);
             if (rb.isChecked()) objSave.setOMReco(Integer.valueOf(d_rdogrpOMReco[i]));
         }

         objSave.setOMDurReco(Integer.valueOf(txtOMDurReco.getText().toString().length()==0?"0":txtOMDurReco.getText().toString()));
         objSave.setOMInReco(Integer.valueOf(spnOMInReco.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnOMInReco.getSelectedItem().toString(), "-")));
         objSave.setOMInRecoOth(txtOMInRecoOth.getText().toString());
         objSave.setOMInReco2(Integer.valueOf(spnOMInReco2.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnOMInReco2.getSelectedItem().toString(), "-")));
         objSave.setOMInRecoOth2(txtOMInRecoOth2.getText().toString());
         objSave.setOMAboIll(txtOMAboIll.getText().toString());
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

             Connection.MessageBox(OtitisMediaCase .this, "Saved Successfully");
         }
         else{
             Connection.MessageBox(OtitisMediaCase .this, status);
             return;
         }
     }
     catch(Exception  e)
     {
         Connection.MessageBox(OtitisMediaCase .this, e.getMessage());
         return;
     }
 }

 private void DataSearch(String UNCode, String StructureNo, String HouseholdSl, String VisitNo, String MemSl)
     {
       try
        {
     
           RadioButton rb;
           OtitisMediaCase_DataModel d = new OtitisMediaCase_DataModel();
           String SQL = "Select * from "+ TableName +"  Where UNCode='"+ UNCode +"' and StructureNo='"+ StructureNo +"' and HouseholdSl='"+ HouseholdSl +"' and VisitNo='"+ VisitNo +"' and MemSl='"+ MemSl +"'";
           List<OtitisMediaCase_DataModel> data = d.SelectAll(this, SQL);
           for(OtitisMediaCase_DataModel item : data){
             txtUNCode.setText(item.getUNCode());
             txtStructureNo.setText(item.getStructureNo());
             txtHouseholdSl.setText(item.getHouseholdSl());
             txtVisitNo.setText(item.getVisitNo());
             txtMemSl.setText(item.getMemSl());
             String[] d_rdogrpOMEDis = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpOMEDis.length; i++)
             {
                 if (String.valueOf(item.getOMEDis()).equals(String.valueOf(d_rdogrpOMEDis[i])))
                 {
                     rb = (RadioButton)rdogrpOMEDis.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtOMEDisEpi.setText(String.valueOf(item.getOMEDisEpi()));
             String[] d_rdogrpOMHCar = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpOMHCar.length; i++)
             {
                 if (String.valueOf(item.getOMHCar()).equals(String.valueOf(d_rdogrpOMHCar[i])))
                 {
                     rb = (RadioButton)rdogrpOMHCar.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpOMHC_PhyMBBS = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpOMHC_PhyMBBS.length; i++)
             {
                 if (String.valueOf(item.getOMHC_PhyMBBS()).equals(String.valueOf(d_rdogrpOMHC_PhyMBBS[i])))
                 {
                     rb = (RadioButton)rdogrpOMHC_PhyMBBS.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpOMHC_UnquaDoctor = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpOMHC_UnquaDoctor.length; i++)
             {
                 if (String.valueOf(item.getOMHC_UnquaDoctor()).equals(String.valueOf(d_rdogrpOMHC_UnquaDoctor[i])))
                 {
                     rb = (RadioButton)rdogrpOMHC_UnquaDoctor.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpOMHC_Para = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpOMHC_Para.length; i++)
             {
                 if (String.valueOf(item.getOMHC_Para()).equals(String.valueOf(d_rdogrpOMHC_Para[i])))
                 {
                     rb = (RadioButton)rdogrpOMHC_Para.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpOMHC_Com = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpOMHC_Com.length; i++)
             {
                 if (String.valueOf(item.getOMHC_Com()).equals(String.valueOf(d_rdogrpOMHC_Com[i])))
                 {
                     rb = (RadioButton)rdogrpOMHC_Com.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpOMHC_Pha = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpOMHC_Pha.length; i++)
             {
                 if (String.valueOf(item.getOMHC_Pha()).equals(String.valueOf(d_rdogrpOMHC_Pha[i])))
                 {
                     rb = (RadioButton)rdogrpOMHC_Pha.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpOMHC_Hompath = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpOMHC_Hompath.length; i++)
             {
                 if (String.valueOf(item.getOMHC_Hompath()).equals(String.valueOf(d_rdogrpOMHC_Hompath[i])))
                 {
                     rb = (RadioButton)rdogrpOMHC_Hompath.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpOMHC_TrHeal = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpOMHC_TrHeal.length; i++)
             {
                 if (String.valueOf(item.getOMHC_TrHeal()).equals(String.valueOf(d_rdogrpOMHC_TrHeal[i])))
                 {
                     rb = (RadioButton)rdogrpOMHC_TrHeal.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpOMHC_SpiHeal = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpOMHC_SpiHeal.length; i++)
             {
                 if (String.valueOf(item.getOMHC_SpiHeal()).equals(String.valueOf(d_rdogrpOMHC_SpiHeal[i])))
                 {
                     rb = (RadioButton)rdogrpOMHC_SpiHeal.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpOMHC_Oth = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpOMHC_Oth.length; i++)
             {
                 if (String.valueOf(item.getOMHC_Oth()).equals(String.valueOf(d_rdogrpOMHC_Oth[i])))
                 {
                     rb = (RadioButton)rdogrpOMHC_Oth.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtOMHC_OthName.setText(item.getOMHC_OthName());
             String[] d_rdogrpOMDSHOPD = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpOMDSHOPD.length; i++)
             {
                 if (String.valueOf(item.getOMDSHOPD()).equals(String.valueOf(d_rdogrpOMDSHOPD[i])))
                 {
                     rb = (RadioButton)rdogrpOMDSHOPD.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpOMSSFOPD = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpOMSSFOPD.length; i++)
             {
                 if (String.valueOf(item.getOMSSFOPD()).equals(String.valueOf(d_rdogrpOMSSFOPD[i])))
                 {
                     rb = (RadioButton)rdogrpOMSSFOPD.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpOMReco = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpOMReco.length; i++)
             {
                 if (String.valueOf(item.getOMReco()).equals(String.valueOf(d_rdogrpOMReco[i])))
                 {
                     rb = (RadioButton)rdogrpOMReco.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtOMDurReco.setText(String.valueOf(item.getOMDurReco()));
             spnOMInReco.setSelection(Global.SpinnerItemPositionAnyLength(spnOMInReco, String.valueOf(item.getOMInReco())));
             txtOMInRecoOth.setText(item.getOMInRecoOth());
             spnOMInReco2.setSelection(Global.SpinnerItemPositionAnyLength(spnOMInReco2, String.valueOf(item.getOMInReco2())));
             txtOMInRecoOth2.setText(item.getOMInRecoOth2());
             txtOMAboIll.setText(item.getOMAboIll());
           }
        }
        catch(Exception  e)
        {
            Connection.MessageBox(OtitisMediaCase .this, e.getMessage());
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