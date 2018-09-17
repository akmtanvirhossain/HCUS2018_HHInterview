
 package org.hcus_hhinterview;


 //Android Manifest Code
 //<activity android:name=".EmergencyOperation " android:label="EmergencyOperation " />
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
 import data_model.EmergencyOperation_DataModel;

 public class EmergencyOperation  extends Activity {
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
         LinearLayout secSAbd;
         View lineSAbd;
         TextView VlblSAbd;
         RadioGroup rdogrpSAbd;
         
         RadioButton rdoSAbd1;
         RadioButton rdoSAbd2;
         RadioButton rdoSAbd3;
         LinearLayout secOperNo;
         View lineOperNo;
         TextView VlblOperNo;
         EditText txtOperNo;
         LinearLayout secSDtHos;
         View lineSDtHos;
         TextView VlblSDtHos;
         EditText dtpSDtHos;
         LinearLayout secSHosM;
         View lineSHosM;
         TextView VlblSHosM;
         EditText txtSHosM;
         LinearLayout secSIlBeHosAdm;
         View lineSIlBeHosAdm;
         TextView VlblSIlBeHosAdm;
         EditText txtSIlBeHosAdm;
         LinearLayout secSurSymptLabel;
         View lineSurSymptLabel;
         LinearLayout secSurSympt;
         View lineSurSympt;
         TextView VlblSurSympt;
         Spinner spnSurSympt;
         LinearLayout secSurSymptOth;
         View lineSurSymptOth;
         TextView VlblSurSymptOth;
         EditText txtSurSymptOth;
         LinearLayout secSurSympt2;
         View lineSurSympt2;
         TextView VlblSurSympt2;
         Spinner spnSurSympt2;
         LinearLayout secSurSymptOth2;
         View lineSurSymptOth2;
         TextView VlblSurSymptOth2;
         EditText txtSurSymptOth2;
         LinearLayout secSurSympt3;
         View lineSurSympt3;
         TextView VlblSurSympt3;
         Spinner spnSurSympt3;
         LinearLayout secSurSymptOth3;
         View lineSurSymptOth3;
         TextView VlblSurSymptOth3;
         EditText txtSurSymptOth3;
         LinearLayout secSurSympt4;
         View lineSurSympt4;
         TextView VlblSurSympt4;
         Spinner spnSurSympt4;
         LinearLayout secSurSymptOth4;
         View lineSurSymptOth4;
         TextView VlblSurSymptOth4;
         EditText txtSurSymptOth4;
         LinearLayout secSurSympt5;
         View lineSurSympt5;
         TextView VlblSurSympt5;
         Spinner spnSurSympt5;
         LinearLayout secSurSymptOth5;
         View lineSurSymptOth5;
         TextView VlblSurSymptOth5;
         EditText txtSurSymptOth5;
         LinearLayout secSurSympt6;
         View lineSurSympt6;
         TextView VlblSurSympt6;
         Spinner spnSurSympt6;
         LinearLayout secSurSymptOth6;
         View lineSurSymptOth6;
         TextView VlblSurSymptOth6;
         EditText txtSurSymptOth6;
         LinearLayout secSurSympt7;
         View lineSurSympt7;
         TextView VlblSurSympt7;
         Spinner spnSurSympt7;
         LinearLayout secSurSymptOth7;
         View lineSurSymptOth7;
         TextView VlblSurSymptOth7;
         EditText txtSurSymptOth7;
         LinearLayout secSDurFever;
         View lineSDurFever;
         TextView VlblSDurFever;
         EditText txtSDurFever;
         LinearLayout secSPHosNam;
         View lineSPHosNam;
         TextView VlblSPHosNam;
         Spinner spnSPHosNam;
         LinearLayout secSPHosOth;
         View lineSPHosOth;
         TextView VlblSPHosOth;
         EditText txtSPHosOth;
         LinearLayout secSDisDr;
         View lineSDisDr;
         TextView VlblSDisDr;
         Spinner spnSDisDr;
         LinearLayout secSDisDrOth;
         View lineSDisDrOth;
         TextView VlblSDisDrOth;
         EditText txtSDisDrOth;
         LinearLayout secSReco;
         View lineSReco;
         TextView VlblSReco;
         RadioGroup rdogrpSReco;
         
         RadioButton rdoSReco1;
         RadioButton rdoSReco2;
         RadioButton rdoSReco3;
         LinearLayout secSDurReco;
         View lineSDurReco;
         TextView VlblSDurReco;
         EditText txtSDurReco;
         LinearLayout secSInRecoLabel;
         View lineSInRecoLabel;
         LinearLayout secSInReco;
         View lineSInReco;
         TextView VlblSInReco;
         RadioGroup rdogrpSInReco;
         
         RadioButton rdoSInReco1;
         RadioButton rdoSInReco2;
         LinearLayout secSInRecoOth;
         View lineSInRecoOth;
         TextView VlblSInRecoOth;
         EditText txtSInRecoOth;
         LinearLayout secSInReco2;
         View lineSInReco2;
         TextView VlblSInReco2;
         RadioGroup rdogrpSInReco2;
         
         RadioButton rdoSInReco21;
         RadioButton rdoSInReco22;
         LinearLayout secSInRecoOth2;
         View lineSInRecoOth2;
         TextView VlblSInRecoOth2;
         EditText txtSInRecoOth2;
         LinearLayout secSAboIll;
         View lineSAboIll;
         TextView VlblSAboIll;
         EditText txtSAboIll;

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
         setContentView(R.layout.emergencyoperation );
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

         TableName = "EmergencyOperation ";

         //turnGPSOn();

         //GPS Location
         //FindLocation();
         // Double.toString(currentLatitude);
         // Double.toString(currentLongitude);
         lblHeading = (TextView)findViewById(R.id.lblHeading);

         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(EmergencyOperation .this);
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
         secSAbd=(LinearLayout)findViewById(R.id.secSAbd);
         lineSAbd=(View)findViewById(R.id.lineSAbd);
         VlblSAbd = (TextView) findViewById(R.id.VlblSAbd);
         rdogrpSAbd = (RadioGroup) findViewById(R.id.rdogrpSAbd);

         txtUNCode.setText(UNCODE);
         txtStructureNo.setText(""+STRUCTURENO);
         txtHouseholdSl.setText(HOUSEHOLDSL);
         txtVisitNo.setText(VISITNO);
         txtMemSl.setText(MEMSL);


         
         rdoSAbd1 = (RadioButton) findViewById(R.id.rdoSAbd1);
         rdoSAbd2 = (RadioButton) findViewById(R.id.rdoSAbd2);
         rdoSAbd3 = (RadioButton) findViewById(R.id.rdoSAbd3);
         rdogrpSAbd.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpSAbd = new String[] {"1","2","8"};
             for (int i = 0; i < rdogrpSAbd.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpSAbd.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpSAbd[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secOperNo.setVisibility(View.GONE);
                    lineOperNo.setVisibility(View.GONE);
                    txtOperNo.setText("");
                    secSDtHos.setVisibility(View.GONE);
                    lineSDtHos.setVisibility(View.GONE);
                    dtpSDtHos.setText("");
                    secSHosM.setVisibility(View.GONE);
                    lineSHosM.setVisibility(View.GONE);
                    txtSHosM.setText("");
                    secSIlBeHosAdm.setVisibility(View.GONE);
                    lineSIlBeHosAdm.setVisibility(View.GONE);
                    txtSIlBeHosAdm.setText("");
                    secSurSymptLabel.setVisibility(View.GONE);
                    lineSurSymptLabel.setVisibility(View.GONE);
                    secSurSympt.setVisibility(View.GONE);
                    lineSurSympt.setVisibility(View.GONE);
                    spnSurSympt.setSelection(0);
                    secSurSymptOth.setVisibility(View.GONE);
                    lineSurSymptOth.setVisibility(View.GONE);
                    txtSurSymptOth.setText("");
                    secSurSympt2.setVisibility(View.GONE);
                    lineSurSympt2.setVisibility(View.GONE);
                    spnSurSympt2.setSelection(0);
                    secSurSymptOth2.setVisibility(View.GONE);
                    lineSurSymptOth2.setVisibility(View.GONE);
                    txtSurSymptOth2.setText("");
                    secSurSympt3.setVisibility(View.GONE);
                    lineSurSympt3.setVisibility(View.GONE);
                    spnSurSympt3.setSelection(0);
                    secSurSymptOth3.setVisibility(View.GONE);
                    lineSurSymptOth3.setVisibility(View.GONE);
                    txtSurSymptOth3.setText("");
                    secSurSympt4.setVisibility(View.GONE);
                    lineSurSympt4.setVisibility(View.GONE);
                    spnSurSympt4.setSelection(0);
                    secSurSymptOth4.setVisibility(View.GONE);
                    lineSurSymptOth4.setVisibility(View.GONE);
                    txtSurSymptOth4.setText("");
                    secSurSympt5.setVisibility(View.GONE);
                    lineSurSympt5.setVisibility(View.GONE);
                    spnSurSympt5.setSelection(0);
                    secSurSymptOth5.setVisibility(View.GONE);
                    lineSurSymptOth5.setVisibility(View.GONE);
                    txtSurSymptOth5.setText("");
                    secSurSympt6.setVisibility(View.GONE);
                    lineSurSympt6.setVisibility(View.GONE);
                    spnSurSympt6.setSelection(0);
                    secSurSymptOth6.setVisibility(View.GONE);
                    lineSurSymptOth6.setVisibility(View.GONE);
                    txtSurSymptOth6.setText("");
                    secSurSympt7.setVisibility(View.GONE);
                    lineSurSympt7.setVisibility(View.GONE);
                    spnSurSympt7.setSelection(0);
                    secSurSymptOth7.setVisibility(View.GONE);
                    lineSurSymptOth7.setVisibility(View.GONE);
                    txtSurSymptOth7.setText("");
                    secSDurFever.setVisibility(View.GONE);
                    lineSDurFever.setVisibility(View.GONE);
                    txtSDurFever.setText("");
                    secSPHosNam.setVisibility(View.GONE);
                    lineSPHosNam.setVisibility(View.GONE);
                    spnSPHosNam.setSelection(0);
                    secSPHosOth.setVisibility(View.GONE);
                    lineSPHosOth.setVisibility(View.GONE);
                    txtSPHosOth.setText("");
                    secSDisDr.setVisibility(View.GONE);
                    lineSDisDr.setVisibility(View.GONE);
                    spnSDisDr.setSelection(0);
                    secSDisDrOth.setVisibility(View.GONE);
                    lineSDisDrOth.setVisibility(View.GONE);
                    txtSDisDrOth.setText("");
                    secSReco.setVisibility(View.GONE);
                    lineSReco.setVisibility(View.GONE);
                    rdogrpSReco.clearCheck();
                    secSDurReco.setVisibility(View.GONE);
                    lineSDurReco.setVisibility(View.GONE);
                    txtSDurReco.setText("");
                    secSInRecoLabel.setVisibility(View.GONE);
                    lineSInRecoLabel.setVisibility(View.GONE);
                    secSInReco.setVisibility(View.GONE);
                    lineSInReco.setVisibility(View.GONE);
                    rdogrpSInReco.clearCheck();
                    secSInRecoOth.setVisibility(View.GONE);
                    lineSInRecoOth.setVisibility(View.GONE);
                    txtSInRecoOth.setText("");
                    secSInReco2.setVisibility(View.GONE);
                    lineSInReco2.setVisibility(View.GONE);
                    rdogrpSInReco2.clearCheck();
                    secSInRecoOth2.setVisibility(View.GONE);
                    lineSInRecoOth2.setVisibility(View.GONE);
                    txtSInRecoOth2.setText("");
                    secSAboIll.setVisibility(View.GONE);
                    lineSAboIll.setVisibility(View.GONE);
                    txtSAboIll.setText("");
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secOperNo.setVisibility(View.GONE);
                    lineOperNo.setVisibility(View.GONE);
                    txtOperNo.setText("");
                    secSDtHos.setVisibility(View.GONE);
                    lineSDtHos.setVisibility(View.GONE);
                    dtpSDtHos.setText("");
                    secSHosM.setVisibility(View.GONE);
                    lineSHosM.setVisibility(View.GONE);
                    txtSHosM.setText("");
                    secSIlBeHosAdm.setVisibility(View.GONE);
                    lineSIlBeHosAdm.setVisibility(View.GONE);
                    txtSIlBeHosAdm.setText("");
                    secSurSymptLabel.setVisibility(View.GONE);
                    lineSurSymptLabel.setVisibility(View.GONE);
                    secSurSympt.setVisibility(View.GONE);
                    lineSurSympt.setVisibility(View.GONE);
                    spnSurSympt.setSelection(0);
                    secSurSymptOth.setVisibility(View.GONE);
                    lineSurSymptOth.setVisibility(View.GONE);
                    txtSurSymptOth.setText("");
                    secSurSympt2.setVisibility(View.GONE);
                    lineSurSympt2.setVisibility(View.GONE);
                    spnSurSympt2.setSelection(0);
                    secSurSymptOth2.setVisibility(View.GONE);
                    lineSurSymptOth2.setVisibility(View.GONE);
                    txtSurSymptOth2.setText("");
                    secSurSympt3.setVisibility(View.GONE);
                    lineSurSympt3.setVisibility(View.GONE);
                    spnSurSympt3.setSelection(0);
                    secSurSymptOth3.setVisibility(View.GONE);
                    lineSurSymptOth3.setVisibility(View.GONE);
                    txtSurSymptOth3.setText("");
                    secSurSympt4.setVisibility(View.GONE);
                    lineSurSympt4.setVisibility(View.GONE);
                    spnSurSympt4.setSelection(0);
                    secSurSymptOth4.setVisibility(View.GONE);
                    lineSurSymptOth4.setVisibility(View.GONE);
                    txtSurSymptOth4.setText("");
                    secSurSympt5.setVisibility(View.GONE);
                    lineSurSympt5.setVisibility(View.GONE);
                    spnSurSympt5.setSelection(0);
                    secSurSymptOth5.setVisibility(View.GONE);
                    lineSurSymptOth5.setVisibility(View.GONE);
                    txtSurSymptOth5.setText("");
                    secSurSympt6.setVisibility(View.GONE);
                    lineSurSympt6.setVisibility(View.GONE);
                    spnSurSympt6.setSelection(0);
                    secSurSymptOth6.setVisibility(View.GONE);
                    lineSurSymptOth6.setVisibility(View.GONE);
                    txtSurSymptOth6.setText("");
                    secSurSympt7.setVisibility(View.GONE);
                    lineSurSympt7.setVisibility(View.GONE);
                    spnSurSympt7.setSelection(0);
                    secSurSymptOth7.setVisibility(View.GONE);
                    lineSurSymptOth7.setVisibility(View.GONE);
                    txtSurSymptOth7.setText("");
                    secSDurFever.setVisibility(View.GONE);
                    lineSDurFever.setVisibility(View.GONE);
                    txtSDurFever.setText("");
                    secSPHosNam.setVisibility(View.GONE);
                    lineSPHosNam.setVisibility(View.GONE);
                    spnSPHosNam.setSelection(0);
                    secSPHosOth.setVisibility(View.GONE);
                    lineSPHosOth.setVisibility(View.GONE);
                    txtSPHosOth.setText("");
                    secSDisDr.setVisibility(View.GONE);
                    lineSDisDr.setVisibility(View.GONE);
                    spnSDisDr.setSelection(0);
                    secSDisDrOth.setVisibility(View.GONE);
                    lineSDisDrOth.setVisibility(View.GONE);
                    txtSDisDrOth.setText("");
                    secSReco.setVisibility(View.GONE);
                    lineSReco.setVisibility(View.GONE);
                    rdogrpSReco.clearCheck();
                    secSDurReco.setVisibility(View.GONE);
                    lineSDurReco.setVisibility(View.GONE);
                    txtSDurReco.setText("");
                    secSInRecoLabel.setVisibility(View.GONE);
                    lineSInRecoLabel.setVisibility(View.GONE);
                    secSInReco.setVisibility(View.GONE);
                    lineSInReco.setVisibility(View.GONE);
                    rdogrpSInReco.clearCheck();
                    secSInRecoOth.setVisibility(View.GONE);
                    lineSInRecoOth.setVisibility(View.GONE);
                    txtSInRecoOth.setText("");
                    secSInReco2.setVisibility(View.GONE);
                    lineSInReco2.setVisibility(View.GONE);
                    rdogrpSInReco2.clearCheck();
                    secSInRecoOth2.setVisibility(View.GONE);
                    lineSInRecoOth2.setVisibility(View.GONE);
                    txtSInRecoOth2.setText("");
                    secSAboIll.setVisibility(View.GONE);
                    lineSAboIll.setVisibility(View.GONE);
                    txtSAboIll.setText("");
             }
             else
             {
                    secOperNo.setVisibility(View.VISIBLE);
                    lineOperNo.setVisibility(View.VISIBLE);
                    secSDtHos.setVisibility(View.VISIBLE);
                    lineSDtHos.setVisibility(View.VISIBLE);
                    secSHosM.setVisibility(View.VISIBLE);
                    lineSHosM.setVisibility(View.VISIBLE);
                    secSIlBeHosAdm.setVisibility(View.VISIBLE);
                    lineSIlBeHosAdm.setVisibility(View.VISIBLE);
                    secSurSymptLabel.setVisibility(View.VISIBLE);
                    lineSurSymptLabel.setVisibility(View.VISIBLE);
                    secSurSympt.setVisibility(View.VISIBLE);
                    lineSurSympt.setVisibility(View.VISIBLE);

                    secSurSympt2.setVisibility(View.VISIBLE);
                    lineSurSympt2.setVisibility(View.VISIBLE);

                    secSurSympt3.setVisibility(View.VISIBLE);
                    lineSurSympt3.setVisibility(View.VISIBLE);

                    secSurSympt4.setVisibility(View.VISIBLE);
                    lineSurSympt4.setVisibility(View.VISIBLE);

                    secSurSympt5.setVisibility(View.VISIBLE);
                    lineSurSympt5.setVisibility(View.VISIBLE);

                    secSurSympt6.setVisibility(View.VISIBLE);
                    lineSurSympt6.setVisibility(View.VISIBLE);

                    secSurSympt7.setVisibility(View.VISIBLE);
                    lineSurSympt7.setVisibility(View.VISIBLE);


                    secSPHosNam.setVisibility(View.VISIBLE);
                    lineSPHosNam.setVisibility(View.VISIBLE);

                 secSDisDr.setVisibility(View.VISIBLE);
                 lineSDisDr.setVisibility(View.VISIBLE);

                    secSReco.setVisibility(View.VISIBLE);
                    lineSReco.setVisibility(View.VISIBLE);

                    secSInRecoLabel.setVisibility(View.VISIBLE);
                    lineSInRecoLabel.setVisibility(View.VISIBLE);
                    secSInReco.setVisibility(View.VISIBLE);
                    lineSInReco.setVisibility(View.VISIBLE);

                    secSInReco2.setVisibility(View.VISIBLE);
                    lineSInReco2.setVisibility(View.VISIBLE);
                    secSAboIll.setVisibility(View.VISIBLE);
                    lineSAboIll.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secOperNo=(LinearLayout)findViewById(R.id.secOperNo);
         lineOperNo=(View)findViewById(R.id.lineOperNo);
         VlblOperNo=(TextView) findViewById(R.id.VlblOperNo);
         txtOperNo=(EditText) findViewById(R.id.txtOperNo);
         secSDtHos=(LinearLayout)findViewById(R.id.secSDtHos);
         lineSDtHos=(View)findViewById(R.id.lineSDtHos);
         VlblSDtHos=(TextView) findViewById(R.id.VlblSDtHos);
         dtpSDtHos=(EditText) findViewById(R.id.dtpSDtHos);
         secSHosM=(LinearLayout)findViewById(R.id.secSHosM);
         lineSHosM=(View)findViewById(R.id.lineSHosM);
         VlblSHosM=(TextView) findViewById(R.id.VlblSHosM);
         txtSHosM=(EditText) findViewById(R.id.txtSHosM);
         secSIlBeHosAdm=(LinearLayout)findViewById(R.id.secSIlBeHosAdm);
         lineSIlBeHosAdm=(View)findViewById(R.id.lineSIlBeHosAdm);
         VlblSIlBeHosAdm=(TextView) findViewById(R.id.VlblSIlBeHosAdm);
         txtSIlBeHosAdm=(EditText) findViewById(R.id.txtSIlBeHosAdm);
         secSurSymptLabel=(LinearLayout)findViewById(R.id.secSurSymptLabel);
         lineSurSymptLabel=(View)findViewById(R.id.lineSurSymptLabel);
         secSurSympt=(LinearLayout)findViewById(R.id.secSurSympt);
         lineSurSympt=(View)findViewById(R.id.lineSurSympt);
         VlblSurSympt=(TextView) findViewById(R.id.VlblSurSympt);
         spnSurSympt=(Spinner) findViewById(R.id.spnSurSympt);


         txtSHosM.addTextChangedListener(new TextWatcher() {
             @Override
             public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

             }

             @Override
             public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
dtpSDtHos.setText("");
             }

             @Override
             public void afterTextChanged(Editable editable) {

             }
         });


         List<String> listSurSympt = new ArrayList<String>();
         
         listSurSympt.add("");
         listSurSympt.add("01-পেট ব্যাথা (Abdominal pain) ");
         listSurSympt.add("02- কোস্ট কাঠিন্য (Constipation)");
         listSurSympt.add("03-মাথা ব্যাথা (Headache) ");
         listSurSympt.add("04-শরীরে দানা (Rash) ");
         listSurSympt.add("05-পাতলা পায়খানা (Diarrhoea)");
         listSurSympt.add("06- পায়খানার সাথে রক্ত (Blood with stool)");
         listSurSympt.add("07- পেট ফুলে যাওয়া (Abdominal distension)");
         listSurSympt.add("08- জিহ্বায় সাদা আবরণ (Coated tongue)");
         listSurSympt.add("09-জ্বর (Fever) ");
         listSurSympt.add("77-অন্যান্য (Other)  ");
         ArrayAdapter<String> adptrSurSympt= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listSurSympt);
         spnSurSympt.setAdapter(adptrSurSympt);

         spnSurSympt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnSurSympt.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnSurSympt.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("01"))
                 {
                    secSurSymptOth.setVisibility(View.GONE);
                    lineSurSymptOth.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt2.setEnabled(true);
                     spnSurSympt3.setEnabled(true);
                     spnSurSympt4.setEnabled(true);
                     spnSurSympt5.setEnabled(true);
                     spnSurSympt6.setEnabled(true);
                     spnSurSympt7.setEnabled(true);

                    txtSurSymptOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("02"))
                 {
                    secSurSymptOth.setVisibility(View.GONE);
                    lineSurSymptOth.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt2.setEnabled(true);
                     spnSurSympt3.setEnabled(true);
                     spnSurSympt4.setEnabled(true);
                     spnSurSympt5.setEnabled(true);
                     spnSurSympt6.setEnabled(true);
                     spnSurSympt7.setEnabled(true);
                    txtSurSymptOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("03"))
                 {
                    secSurSymptOth.setVisibility(View.GONE);
                    lineSurSymptOth.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt2.setEnabled(true);
                     spnSurSympt3.setEnabled(true);
                     spnSurSympt4.setEnabled(true);
                     spnSurSympt5.setEnabled(true);
                     spnSurSympt6.setEnabled(true);
                     spnSurSympt7.setEnabled(true);
                    txtSurSymptOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("04"))
                 {
                    secSurSymptOth.setVisibility(View.GONE);
                    lineSurSymptOth.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt2.setEnabled(true);
                     spnSurSympt3.setEnabled(true);
                     spnSurSympt4.setEnabled(true);
                     spnSurSympt5.setEnabled(true);
                     spnSurSympt6.setEnabled(true);
                     spnSurSympt7.setEnabled(true);
                    txtSurSymptOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("05"))
                 {
                    secSurSymptOth.setVisibility(View.GONE);
                    lineSurSymptOth.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt2.setEnabled(true);
                     spnSurSympt3.setEnabled(true);
                     spnSurSympt4.setEnabled(true);
                     spnSurSympt5.setEnabled(true);
                     spnSurSympt6.setEnabled(true);
                     spnSurSympt7.setEnabled(true);
                    txtSurSymptOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("06"))
                 {
                    secSurSymptOth.setVisibility(View.GONE);
                    lineSurSymptOth.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt2.setEnabled(true);
                     spnSurSympt3.setEnabled(true);
                     spnSurSympt4.setEnabled(true);
                     spnSurSympt5.setEnabled(true);
                     spnSurSympt6.setEnabled(true);
                     spnSurSympt7.setEnabled(true);
                    txtSurSymptOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("07"))
                 {
                    secSurSymptOth.setVisibility(View.GONE);
                    lineSurSymptOth.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt2.setEnabled(true);
                     spnSurSympt3.setEnabled(true);
                     spnSurSympt4.setEnabled(true);
                     spnSurSympt5.setEnabled(true);
                     spnSurSympt6.setEnabled(true);
                     spnSurSympt7.setEnabled(true);

                    txtSurSymptOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("08"))
                 {
                    secSurSymptOth.setVisibility(View.GONE);
                    lineSurSymptOth.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt2.setEnabled(true);
                     spnSurSympt3.setEnabled(true);
                     spnSurSympt4.setEnabled(true);
                     spnSurSympt5.setEnabled(true);
                     spnSurSympt6.setEnabled(true);
                     spnSurSympt7.setEnabled(true);
                    txtSurSymptOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("09"))
                 {
                    secSurSymptOth.setVisibility(View.GONE);
                    lineSurSymptOth.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.VISIBLE);
                     lineSDurFever.setVisibility(View.VISIBLE);
                     spnSurSympt2.setEnabled(true);
                     spnSurSympt3.setEnabled(true);
                     spnSurSympt4.setEnabled(true);
                     spnSurSympt5.setEnabled(true);
                     spnSurSympt6.setEnabled(true);
                     spnSurSympt7.setEnabled(true);
                    txtSurSymptOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("77"))
                 {
                    secSurSymptOth.setVisibility(View.VISIBLE);
                    lineSurSymptOth.setVisibility(View.VISIBLE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt2.setSelection(0);
                     spnSurSympt2.setEnabled(false);
                     spnSurSympt3.setSelection(0);
                     spnSurSympt3.setEnabled(false);
                     spnSurSympt4.setSelection(0);
                     spnSurSympt4.setEnabled(false);
                     spnSurSympt5.setSelection(0);
                     spnSurSympt5.setEnabled(false);
                     spnSurSympt6.setSelection(0);
                     spnSurSympt6.setEnabled(false);
                     spnSurSympt7.setSelection(0);
                     spnSurSympt7.setEnabled(false);
                 }
                 else{
                     secSurSymptOth.setVisibility(View.GONE);
                     lineSurSymptOth.setVisibility(View.GONE);
                      secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt2.setEnabled(true);
                     spnSurSympt3.setEnabled(true);
                     spnSurSympt4.setEnabled(true);
                     spnSurSympt5.setEnabled(true);
                     spnSurSympt6.setEnabled(true);
                     spnSurSympt7.setEnabled(true);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secSurSymptOth=(LinearLayout)findViewById(R.id.secSurSymptOth);
         lineSurSymptOth=(View)findViewById(R.id.lineSurSymptOth);
         VlblSurSymptOth=(TextView) findViewById(R.id.VlblSurSymptOth);
         txtSurSymptOth=(EditText) findViewById(R.id.txtSurSymptOth);
         secSurSympt2=(LinearLayout)findViewById(R.id.secSurSympt2);
         lineSurSympt2=(View)findViewById(R.id.lineSurSympt2);
         VlblSurSympt2=(TextView) findViewById(R.id.VlblSurSympt2);
         spnSurSympt2=(Spinner) findViewById(R.id.spnSurSympt2);
         List<String> listSurSympt2 = new ArrayList<String>();
         
         listSurSympt2.add("");
         listSurSympt2.add("01-পেট ব্যাথা (Abdominal pain) ");
         listSurSympt2.add("02- কোস্ট কাঠিন্য (Constipation)");
         listSurSympt2.add("03-মাথা ব্যাথা (Headache) ");
         listSurSympt2.add("04-শরীরে দানা (Rash) ");
         listSurSympt2.add("05-পাতলা পায়খানা (Diarrhoea)");
         listSurSympt2.add("06- পায়খানার সাথে রক্ত (Blood with stool)");
         listSurSympt2.add("07- পেট ফুলে যাওয়া (Abdominal distension)");
         listSurSympt2.add("08- জিহ্বায় সাদা আবরণ (Coated tongue)");
         listSurSympt2.add("09-জ্বর (Fever) ");
         listSurSympt2.add("77-অন্যান্য (Other)  ");
         ArrayAdapter<String> adptrSurSympt2= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listSurSympt2);
         spnSurSympt2.setAdapter(adptrSurSympt2);

         spnSurSympt2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnSurSympt2.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnSurSympt2.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("01"))
                 {
                    secSurSymptOth2.setVisibility(View.GONE);
                    lineSurSymptOth2.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);

                     spnSurSympt3.setEnabled(true);
                     spnSurSympt4.setEnabled(true);
                     spnSurSympt5.setEnabled(true);
                     spnSurSympt6.setEnabled(true);
                     spnSurSympt7.setEnabled(true);
                    txtSurSymptOth2.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("02"))
                 {
                    secSurSymptOth2.setVisibility(View.GONE);
                    lineSurSymptOth2.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt3.setEnabled(true);
                     spnSurSympt4.setEnabled(true);
                     spnSurSympt5.setEnabled(true);
                     spnSurSympt6.setEnabled(true);
                     spnSurSympt7.setEnabled(true);
                    txtSurSymptOth2.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("03"))
                 {
                    secSurSymptOth2.setVisibility(View.GONE);
                    lineSurSymptOth2.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt3.setEnabled(true);
                     spnSurSympt4.setEnabled(true);
                     spnSurSympt5.setEnabled(true);
                     spnSurSympt6.setEnabled(true);
                     spnSurSympt7.setEnabled(true);
                    txtSurSymptOth2.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("04"))
                 {
                    secSurSymptOth2.setVisibility(View.GONE);
                    lineSurSymptOth2.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt3.setEnabled(true);
                     spnSurSympt4.setEnabled(true);
                     spnSurSympt5.setEnabled(true);
                     spnSurSympt6.setEnabled(true);
                     spnSurSympt7.setEnabled(true);
                    txtSurSymptOth2.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("05"))
                 {
                    secSurSymptOth2.setVisibility(View.GONE);
                    lineSurSymptOth2.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt3.setEnabled(true);
                     spnSurSympt4.setEnabled(true);
                     spnSurSympt5.setEnabled(true);
                     spnSurSympt6.setEnabled(true);
                     spnSurSympt7.setEnabled(true);
                    txtSurSymptOth2.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("06"))
                 {
                    secSurSymptOth2.setVisibility(View.GONE);
                    lineSurSymptOth2.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt3.setEnabled(true);
                     spnSurSympt4.setEnabled(true);
                     spnSurSympt5.setEnabled(true);
                     spnSurSympt6.setEnabled(true);
                     spnSurSympt7.setEnabled(true);
                    txtSurSymptOth2.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("07"))
                 {
                    secSurSymptOth2.setVisibility(View.GONE);
                    lineSurSymptOth2.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt3.setEnabled(true);
                     spnSurSympt4.setEnabled(true);
                     spnSurSympt5.setEnabled(true);
                     spnSurSympt6.setEnabled(true);
                     spnSurSympt7.setEnabled(true);
                    txtSurSymptOth2.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("08"))
                 {
                    secSurSymptOth2.setVisibility(View.GONE);
                    lineSurSymptOth2.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt3.setEnabled(true);
                     spnSurSympt4.setEnabled(true);
                     spnSurSympt5.setEnabled(true);
                     spnSurSympt6.setEnabled(true);
                     spnSurSympt7.setEnabled(true);
                    txtSurSymptOth2.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("09"))
                 {
                    secSurSymptOth2.setVisibility(View.GONE);
                    lineSurSymptOth2.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.VISIBLE);
                     lineSDurFever.setVisibility(View.VISIBLE);
                     spnSurSympt3.setEnabled(true);
                     spnSurSympt4.setEnabled(true);
                     spnSurSympt5.setEnabled(true);
                     spnSurSympt6.setEnabled(true);
                     spnSurSympt7.setEnabled(true);
                    txtSurSymptOth2.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("77"))
                 {
                    secSurSymptOth2.setVisibility(View.VISIBLE);
                    lineSurSymptOth2.setVisibility(View.VISIBLE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt3.setEnabled(false);
                     spnSurSympt4.setEnabled(false);
                     spnSurSympt5.setEnabled(false);
                     spnSurSympt6.setEnabled(false);
                     spnSurSympt7.setEnabled(false);
                     spnSurSympt3.setSelection(0);
                     spnSurSympt4.setSelection(0);
                     spnSurSympt5.setSelection(0);
                     spnSurSympt6.setSelection(0);
                     spnSurSympt7.setSelection(0);
                 }
                 else{
                     secSurSymptOth2.setVisibility(View.GONE);
                     lineSurSymptOth2.setVisibility(View.GONE);
                      secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt3.setEnabled(true);
                     spnSurSympt4.setEnabled(true);
                     spnSurSympt5.setEnabled(true);
                     spnSurSympt6.setEnabled(true);
                     spnSurSympt7.setEnabled(true);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secSurSymptOth2=(LinearLayout)findViewById(R.id.secSurSymptOth2);
         lineSurSymptOth2=(View)findViewById(R.id.lineSurSymptOth2);
         VlblSurSymptOth2=(TextView) findViewById(R.id.VlblSurSymptOth2);
         txtSurSymptOth2=(EditText) findViewById(R.id.txtSurSymptOth2);
         secSurSympt3=(LinearLayout)findViewById(R.id.secSurSympt3);
         lineSurSympt3=(View)findViewById(R.id.lineSurSympt3);
         VlblSurSympt3=(TextView) findViewById(R.id.VlblSurSympt3);
         spnSurSympt3=(Spinner) findViewById(R.id.spnSurSympt3);
         List<String> listSurSympt3 = new ArrayList<String>();
         
         listSurSympt3.add("");
         listSurSympt3.add("01-পেট ব্যাথা (Abdominal pain) ");
         listSurSympt3.add("02- কোস্ট কাঠিন্য (Constipation)");
         listSurSympt3.add("03-মাথা ব্যাথা (Headache) ");
         listSurSympt3.add("04-শরীরে দানা (Rash) ");
         listSurSympt3.add("05-পাতলা পায়খানা (Diarrhoea)");
         listSurSympt3.add("06- পায়খানার সাথে রক্ত (Blood with stool)");
         listSurSympt3.add("07- পেট ফুলে যাওয়া (Abdominal distension)");
         listSurSympt3.add("08- জিহ্বায় সাদা আবরণ (Coated tongue)");
         listSurSympt3.add("09-জ্বর (Fever) ");
         listSurSympt3.add("77-অন্যান্য (Other)  ");
         ArrayAdapter<String> adptrSurSympt3= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listSurSympt3);
         spnSurSympt3.setAdapter(adptrSurSympt3);

         spnSurSympt3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnSurSympt3.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnSurSympt3.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("01"))
                 {
                    secSurSymptOth3.setVisibility(View.GONE);
                    lineSurSymptOth3.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt4.setEnabled(true);
                     spnSurSympt5.setEnabled(true);
                     spnSurSympt6.setEnabled(true);
                     spnSurSympt7.setEnabled(true);
                    txtSurSymptOth3.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("02"))
                 {
                    secSurSymptOth3.setVisibility(View.GONE);
                    lineSurSymptOth3.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt4.setEnabled(true);
                     spnSurSympt5.setEnabled(true);
                     spnSurSympt6.setEnabled(true);
                     spnSurSympt7.setEnabled(true);
                    txtSurSymptOth3.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("03"))
                 {
                    secSurSymptOth3.setVisibility(View.GONE);
                    lineSurSymptOth3.setVisibility(View.GONE);
                    secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt4.setEnabled(true);
                     spnSurSympt5.setEnabled(true);
                     spnSurSympt6.setEnabled(true);
                     spnSurSympt7.setEnabled(true);
                    txtSurSymptOth3.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("04"))
                 {
                    secSurSymptOth3.setVisibility(View.GONE);
                    lineSurSymptOth3.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt4.setEnabled(true);
                     spnSurSympt5.setEnabled(true);
                     spnSurSympt6.setEnabled(true);
                     spnSurSympt7.setEnabled(true);
                    txtSurSymptOth3.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("05"))
                 {
                    secSurSymptOth3.setVisibility(View.GONE);
                    lineSurSymptOth3.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt4.setEnabled(true);
                     spnSurSympt5.setEnabled(true);
                     spnSurSympt6.setEnabled(true);
                     spnSurSympt7.setEnabled(true);
                    txtSurSymptOth3.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("06"))
                 {
                    secSurSymptOth3.setVisibility(View.GONE);
                    lineSurSymptOth3.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt4.setEnabled(true);
                     spnSurSympt5.setEnabled(true);
                     spnSurSympt6.setEnabled(true);
                     spnSurSympt7.setEnabled(true);
                    txtSurSymptOth3.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("07"))
                 {
                    secSurSymptOth3.setVisibility(View.GONE);
                    lineSurSymptOth3.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt4.setEnabled(true);
                     spnSurSympt5.setEnabled(true);
                     spnSurSympt6.setEnabled(true);
                     spnSurSympt7.setEnabled(true);
                    txtSurSymptOth3.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("08"))
                 {
                    secSurSymptOth3.setVisibility(View.GONE);
                    lineSurSymptOth3.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt4.setEnabled(true);
                     spnSurSympt5.setEnabled(true);
                     spnSurSympt6.setEnabled(true);
                     spnSurSympt7.setEnabled(true);
                    txtSurSymptOth3.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("09"))
                 {
                    secSurSymptOth3.setVisibility(View.GONE);
                    lineSurSymptOth3.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.VISIBLE);
                     lineSDurFever.setVisibility(View.VISIBLE);
                     spnSurSympt4.setEnabled(true);
                     spnSurSympt5.setEnabled(true);
                     spnSurSympt6.setEnabled(true);
                     spnSurSympt7.setEnabled(true);
                    txtSurSymptOth3.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("77"))
                 {
                    secSurSymptOth3.setVisibility(View.VISIBLE);
                    lineSurSymptOth3.setVisibility(View.VISIBLE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt4.setEnabled(false);
                     spnSurSympt5.setEnabled(false);
                     spnSurSympt6.setEnabled(false);
                     spnSurSympt7.setEnabled(false);
                     spnSurSympt4.setSelection(0);
                     spnSurSympt5.setSelection(0);
                     spnSurSympt6.setSelection(0);
                     spnSurSympt7.setSelection(0);
                 }
                 else{
                     secSurSymptOth3.setVisibility(View.GONE);
                     lineSurSymptOth3.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt4.setEnabled(true);
                     spnSurSympt5.setEnabled(true);
                     spnSurSympt6.setEnabled(true);
                     spnSurSympt7.setEnabled(true);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secSurSymptOth3=(LinearLayout)findViewById(R.id.secSurSymptOth3);
         lineSurSymptOth3=(View)findViewById(R.id.lineSurSymptOth3);
         VlblSurSymptOth3=(TextView) findViewById(R.id.VlblSurSymptOth3);
         txtSurSymptOth3=(EditText) findViewById(R.id.txtSurSymptOth3);
         secSurSympt4=(LinearLayout)findViewById(R.id.secSurSympt4);
         lineSurSympt4=(View)findViewById(R.id.lineSurSympt4);
         VlblSurSympt4=(TextView) findViewById(R.id.VlblSurSympt4);
         spnSurSympt4=(Spinner) findViewById(R.id.spnSurSympt4);
         List<String> listSurSympt4 = new ArrayList<String>();
         
         listSurSympt4.add("");
         listSurSympt4.add("01-পেট ব্যাথা (Abdominal pain) ");
         listSurSympt4.add("02- কোস্ট কাঠিন্য (Constipation)");
         listSurSympt4.add("03-মাথা ব্যাথা (Headache) ");
         listSurSympt4.add("04-শরীরে দানা (Rash) ");
         listSurSympt4.add("05-পাতলা পায়খানা (Diarrhoea)");
         listSurSympt4.add("06- পায়খানার সাথে রক্ত (Blood with stool)");
         listSurSympt4.add("07- পেট ফুলে যাওয়া (Abdominal distension)");
         listSurSympt4.add("08- জিহ্বায় সাদা আবরণ (Coated tongue)");
         listSurSympt4.add("09-জ্বর (Fever) ");
         listSurSympt4.add("77-অন্যান্য (Other)   ");
         ArrayAdapter<String> adptrSurSympt4= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listSurSympt4);
         spnSurSympt4.setAdapter(adptrSurSympt4);

         spnSurSympt4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnSurSympt4.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnSurSympt4.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("01"))
                 {
                    secSurSymptOth4.setVisibility(View.GONE);
                    lineSurSymptOth4.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt5.setEnabled(true);
                     spnSurSympt6.setEnabled(true);
                     spnSurSympt7.setEnabled(true);
                    txtSurSymptOth4.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("02"))
                 {
                    secSurSymptOth4.setVisibility(View.GONE);
                    lineSurSymptOth4.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt5.setEnabled(true);
                     spnSurSympt6.setEnabled(true);
                     spnSurSympt7.setEnabled(true);
                    txtSurSymptOth4.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("03"))
                 {
                    secSurSymptOth4.setVisibility(View.GONE);
                    lineSurSymptOth4.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt5.setEnabled(true);
                     spnSurSympt6.setEnabled(true);
                     spnSurSympt7.setEnabled(true);
                    txtSurSymptOth4.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("04"))
                 {
                    secSurSymptOth4.setVisibility(View.GONE);
                    lineSurSymptOth4.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt5.setEnabled(true);
                     spnSurSympt6.setEnabled(true);
                     spnSurSympt7.setEnabled(true);
                    txtSurSymptOth4.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("05"))
                 {
                    secSurSymptOth4.setVisibility(View.GONE);
                    lineSurSymptOth4.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt5.setEnabled(true);
                     spnSurSympt6.setEnabled(true);
                     spnSurSympt7.setEnabled(true);
                    txtSurSymptOth4.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("06"))
                 {
                    secSurSymptOth4.setVisibility(View.GONE);
                    lineSurSymptOth4.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt5.setEnabled(true);
                     spnSurSympt6.setEnabled(true);
                     spnSurSympt7.setEnabled(true);
                    txtSurSymptOth4.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("07"))
                 {
                    secSurSymptOth4.setVisibility(View.GONE);
                    lineSurSymptOth4.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt5.setEnabled(true);
                     spnSurSympt6.setEnabled(true);
                     spnSurSympt7.setEnabled(true);
                    txtSurSymptOth4.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("08"))
                 {
                    secSurSymptOth4.setVisibility(View.GONE);
                    lineSurSymptOth4.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt5.setEnabled(true);
                     spnSurSympt6.setEnabled(true);
                     spnSurSympt7.setEnabled(true);
                    txtSurSymptOth4.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("09"))
                 {
                    secSurSymptOth4.setVisibility(View.GONE);
                    lineSurSymptOth4.setVisibility(View.GONE);
                    secSDurFever.setVisibility(View.VISIBLE);
                     lineSDurFever.setVisibility(View.VISIBLE);
                     spnSurSympt5.setEnabled(true);
                     spnSurSympt6.setEnabled(true);
                     spnSurSympt7.setEnabled(true);
                    txtSurSymptOth4.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("77"))
                 {
                    secSurSymptOth4.setVisibility(View.VISIBLE);
                    lineSurSymptOth4.setVisibility(View.VISIBLE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt5.setEnabled(false);
                     spnSurSympt6.setEnabled(false);
                     spnSurSympt7.setEnabled(false);
                     spnSurSympt5.setSelection(0);
                     spnSurSympt6.setSelection(0);
                     spnSurSympt7.setSelection(0);
                 }
                 else{
                     secSurSymptOth4.setVisibility(View.GONE);
                     lineSurSymptOth4.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt5.setEnabled(true);
                     spnSurSympt6.setEnabled(true);
                     spnSurSympt7.setEnabled(true);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secSurSymptOth4=(LinearLayout)findViewById(R.id.secSurSymptOth4);
         lineSurSymptOth4=(View)findViewById(R.id.lineSurSymptOth4);
         VlblSurSymptOth4=(TextView) findViewById(R.id.VlblSurSymptOth4);
         txtSurSymptOth4=(EditText) findViewById(R.id.txtSurSymptOth4);
         secSurSympt5=(LinearLayout)findViewById(R.id.secSurSympt5);
         lineSurSympt5=(View)findViewById(R.id.lineSurSympt5);
         VlblSurSympt5=(TextView) findViewById(R.id.VlblSurSympt5);
         spnSurSympt5=(Spinner) findViewById(R.id.spnSurSympt5);
         List<String> listSurSympt5 = new ArrayList<String>();
         
         listSurSympt5.add("");
         listSurSympt5.add("01-পেট ব্যাথা (Abdominal pain) ");
         listSurSympt5.add("02- কোস্ট কাঠিন্য (Constipation)");
         listSurSympt5.add("03-মাথা ব্যাথা (Headache) ");
         listSurSympt5.add("04-শরীরে দানা (Rash) ");
         listSurSympt5.add("05-পাতলা পায়খানা (Diarrhoea)");
         listSurSympt5.add("06- পায়খানার সাথে রক্ত (Blood with stool)");
         listSurSympt5.add("07- পেট ফুলে যাওয়া (Abdominal distension)");
         listSurSympt5.add("08- জিহ্বায় সাদা আবরণ (Coated tongue)");
         listSurSympt5.add("09-জ্বর (Fever) ");
         listSurSympt5.add("77-অন্যান্য (Other)  ");
         ArrayAdapter<String> adptrSurSympt5= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listSurSympt5);
         spnSurSympt5.setAdapter(adptrSurSympt5);

         spnSurSympt5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnSurSympt5.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnSurSympt5.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("01"))
                 {
                    secSurSymptOth5.setVisibility(View.GONE);
                    lineSurSymptOth5.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt6.setEnabled(true);
                     spnSurSympt7.setEnabled(true);
                    txtSurSymptOth5.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("02"))
                 {
                    secSurSymptOth5.setVisibility(View.GONE);
                    lineSurSymptOth5.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt6.setEnabled(true);
                     spnSurSympt7.setEnabled(true);
                    txtSurSymptOth5.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("03"))
                 {
                    secSurSymptOth5.setVisibility(View.GONE);
                    lineSurSymptOth5.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt6.setEnabled(true);
                     spnSurSympt7.setEnabled(true);
                    txtSurSymptOth5.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("04"))
                 {
                    secSurSymptOth5.setVisibility(View.GONE);
                    lineSurSymptOth5.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt6.setEnabled(true);
                     spnSurSympt7.setEnabled(true);
                    txtSurSymptOth5.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("05"))
                 {
                    secSurSymptOth5.setVisibility(View.GONE);
                    lineSurSymptOth5.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt6.setEnabled(true);
                     spnSurSympt7.setEnabled(true);
                    txtSurSymptOth5.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("06"))
                 {
                    secSurSymptOth5.setVisibility(View.GONE);
                    lineSurSymptOth5.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt6.setEnabled(true);
                     spnSurSympt7.setEnabled(true);
                    txtSurSymptOth5.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("07"))
                 {
                    secSurSymptOth5.setVisibility(View.GONE);
                    lineSurSymptOth5.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt6.setEnabled(true);
                     spnSurSympt7.setEnabled(true);
                    txtSurSymptOth5.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("08"))
                 {
                    secSurSymptOth5.setVisibility(View.GONE);
                    lineSurSymptOth5.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt6.setEnabled(true);
                     spnSurSympt7.setEnabled(true);
                    txtSurSymptOth5.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("09"))
                 {
                     secSurSymptOth5.setVisibility(View.GONE);
                     lineSurSymptOth5.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.VISIBLE);
                     lineSDurFever.setVisibility(View.VISIBLE);
                     spnSurSympt6.setEnabled(true);
                     spnSurSympt7.setEnabled(true);
                     txtSurSymptOth5.setText("");
                 }

                 else if(spnData.equalsIgnoreCase("77"))
                 {
                    secSurSymptOth5.setVisibility(View.VISIBLE);
                    lineSurSymptOth5.setVisibility(View.VISIBLE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt6.setEnabled(false);
                     spnSurSympt7.setEnabled(false);
                     spnSurSympt6.setSelection(0);
                     spnSurSympt7.setSelection(0);
                 }
                 else{
                     secSurSymptOth5.setVisibility(View.GONE);
                     lineSurSymptOth5.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt6.setEnabled(true);
                     spnSurSympt7.setEnabled(true);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secSurSymptOth5=(LinearLayout)findViewById(R.id.secSurSymptOth5);
         lineSurSymptOth5=(View)findViewById(R.id.lineSurSymptOth5);
         VlblSurSymptOth5=(TextView) findViewById(R.id.VlblSurSymptOth5);
         txtSurSymptOth5=(EditText) findViewById(R.id.txtSurSymptOth5);
         secSurSympt6=(LinearLayout)findViewById(R.id.secSurSympt6);
         lineSurSympt6=(View)findViewById(R.id.lineSurSympt6);
         VlblSurSympt6=(TextView) findViewById(R.id.VlblSurSympt6);
         spnSurSympt6=(Spinner) findViewById(R.id.spnSurSympt6);
         List<String> listSurSympt6 = new ArrayList<String>();
         
         listSurSympt6.add("");
         listSurSympt6.add("01-পেট ব্যাথা (Abdominal pain) ");
         listSurSympt6.add("02- কোস্ট কাঠিন্য (Constipation)");
         listSurSympt6.add("03-মাথা ব্যাথা (Headache) ");
         listSurSympt6.add("04-শরীরে দানা (Rash) ");
         listSurSympt6.add("05-পাতলা পায়খানা (Diarrhoea)");
         listSurSympt6.add("06- পায়খানার সাথে রক্ত (Blood with stool)");
         listSurSympt6.add("07- পেট ফুলে যাওয়া (Abdominal distension)");
         listSurSympt6.add("08- জিহ্বায় সাদা আবরণ (Coated tongue)");
         listSurSympt6.add("09-জ্বর (Fever) ");
         listSurSympt6.add("77-অন্যান্য (Other)  ");
         ArrayAdapter<String> adptrSurSympt6= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listSurSympt6);
         spnSurSympt6.setAdapter(adptrSurSympt6);

         spnSurSympt6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnSurSympt6.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnSurSympt6.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("01"))
                 {
                    secSurSymptOth6.setVisibility(View.GONE);
                    lineSurSymptOth6.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt7.setEnabled(true);
                    txtSurSymptOth6.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("02"))
                 {
                    secSurSymptOth6.setVisibility(View.GONE);
                    lineSurSymptOth6.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt7.setEnabled(true);
                    txtSurSymptOth6.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("03"))
                 {
                    secSurSymptOth6.setVisibility(View.GONE);
                    lineSurSymptOth6.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt7.setEnabled(true);
                    txtSurSymptOth6.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("04"))
                 {
                    secSurSymptOth6.setVisibility(View.GONE);
                    lineSurSymptOth6.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt7.setEnabled(true);
                    txtSurSymptOth6.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("05"))
                 {
                    secSurSymptOth6.setVisibility(View.GONE);
                    lineSurSymptOth6.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt7.setEnabled(true);
                    txtSurSymptOth6.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("06"))
                 {
                    secSurSymptOth6.setVisibility(View.GONE);
                    lineSurSymptOth6.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt7.setEnabled(true);
                    txtSurSymptOth6.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("07"))
                 {
                    secSurSymptOth6.setVisibility(View.GONE);
                    lineSurSymptOth6.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt7.setEnabled(true);
                    txtSurSymptOth6.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("08"))
                 {
                    secSurSymptOth6.setVisibility(View.GONE);
                    lineSurSymptOth6.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt7.setEnabled(true);
                    txtSurSymptOth6.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("09"))
                 {
                    secSurSymptOth6.setVisibility(View.GONE);
                    lineSurSymptOth6.setVisibility(View.GONE);
                    secSDurFever.setVisibility(View.VISIBLE);
                     lineSDurFever.setVisibility(View.VISIBLE);
                     spnSurSympt7.setEnabled(true);
                    txtSurSymptOth6.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("77"))
                 {
                    secSurSymptOth6.setVisibility(View.VISIBLE);
                    lineSurSymptOth6.setVisibility(View.VISIBLE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt7.setEnabled(false);
                     spnSurSympt7.setSelection(0);

                 }
                 else{
                     secSurSymptOth6.setVisibility(View.GONE);
                     lineSurSymptOth6.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.GONE);
                     lineSDurFever.setVisibility(View.GONE);
                     spnSurSympt7.setEnabled(true);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secSurSymptOth6=(LinearLayout)findViewById(R.id.secSurSymptOth6);
         lineSurSymptOth6=(View)findViewById(R.id.lineSurSymptOth6);
         VlblSurSymptOth6=(TextView) findViewById(R.id.VlblSurSymptOth6);
         txtSurSymptOth6=(EditText) findViewById(R.id.txtSurSymptOth6);
         secSurSympt7=(LinearLayout)findViewById(R.id.secSurSympt7);
         lineSurSympt7=(View)findViewById(R.id.lineSurSympt7);
         VlblSurSympt7=(TextView) findViewById(R.id.VlblSurSympt7);
         spnSurSympt7=(Spinner) findViewById(R.id.spnSurSympt7);
         List<String> listSurSympt7 = new ArrayList<String>();
         
         listSurSympt7.add("");
         listSurSympt7.add("01-পেট ব্যাথা (Abdominal pain) ");
         listSurSympt7.add("02- কোস্ট কাঠিন্য (Constipation)");
         listSurSympt7.add("03-মাথা ব্যাথা (Headache) ");
         listSurSympt7.add("04-শরীরে দানা (Rash) ");
         listSurSympt7.add("05-পাতলা পায়খানা (Diarrhoea)");
         listSurSympt7.add("06- পায়খানার সাথে রক্ত (Blood with stool)");
         listSurSympt7.add("07- পেট ফুলে যাওয়া (Abdominal distension)");
         listSurSympt7.add("08- জিহ্বায় সাদা আবরণ (Coated tongue)");
         listSurSympt7.add("09-জ্বর (Fever) ");
         listSurSympt7.add("77-অন্যান্য (Other) ");
         ArrayAdapter<String> adptrSurSympt7= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listSurSympt7);
         spnSurSympt7.setAdapter(adptrSurSympt7);

         spnSurSympt7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnSurSympt7.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnSurSympt7.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("01"))
                 {
                    secSurSymptOth7.setVisibility(View.GONE);
                    lineSurSymptOth7.setVisibility(View.GONE);
                    txtSurSymptOth7.setText("");
                    secSDurFever.setVisibility(View.GONE);
                    lineSDurFever.setVisibility(View.GONE);
                    txtSDurFever.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("02"))
                 {
                    secSurSymptOth7.setVisibility(View.GONE);
                    lineSurSymptOth7.setVisibility(View.GONE);
                    txtSurSymptOth7.setText("");
                    secSDurFever.setVisibility(View.GONE);
                    lineSDurFever.setVisibility(View.GONE);
                    txtSDurFever.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("03"))
                 {
                    secSurSymptOth7.setVisibility(View.GONE);
                    lineSurSymptOth7.setVisibility(View.GONE);
                    txtSurSymptOth7.setText("");
                    secSDurFever.setVisibility(View.GONE);
                    lineSDurFever.setVisibility(View.GONE);
                    txtSDurFever.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("04"))
                 {
                    secSurSymptOth7.setVisibility(View.GONE);
                    lineSurSymptOth7.setVisibility(View.GONE);
                    txtSurSymptOth7.setText("");
                    secSDurFever.setVisibility(View.GONE);
                    lineSDurFever.setVisibility(View.GONE);
                    txtSDurFever.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("05"))
                 {
                    secSurSymptOth7.setVisibility(View.GONE);
                    lineSurSymptOth7.setVisibility(View.GONE);
                    txtSurSymptOth7.setText("");
                    secSDurFever.setVisibility(View.GONE);
                    lineSDurFever.setVisibility(View.GONE);
                    txtSDurFever.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("06"))
                 {
                    secSurSymptOth7.setVisibility(View.GONE);
                    lineSurSymptOth7.setVisibility(View.GONE);
                    txtSurSymptOth7.setText("");
                    secSDurFever.setVisibility(View.GONE);
                    lineSDurFever.setVisibility(View.GONE);
                    txtSDurFever.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("07"))
                 {
                    secSurSymptOth7.setVisibility(View.GONE);
                    lineSurSymptOth7.setVisibility(View.GONE);
                    txtSurSymptOth7.setText("");
                    secSDurFever.setVisibility(View.GONE);
                    lineSDurFever.setVisibility(View.GONE);
                    txtSDurFever.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("08"))
                 {
                    secSurSymptOth7.setVisibility(View.GONE);
                    lineSurSymptOth7.setVisibility(View.GONE);
                    txtSurSymptOth7.setText("");
                    secSDurFever.setVisibility(View.GONE);
                    lineSDurFever.setVisibility(View.GONE);
                    txtSDurFever.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("09"))
                 {
                    secSurSymptOth7.setVisibility(View.GONE);
                    lineSurSymptOth7.setVisibility(View.GONE);
                     secSDurFever.setVisibility(View.VISIBLE);
                     lineSDurFever.setVisibility(View.VISIBLE);
                    txtSurSymptOth7.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("77"))
                 {
                    secSurSymptOth7.setVisibility(View.VISIBLE);
                    lineSurSymptOth7.setVisibility(View.VISIBLE);
                 }
                 else{
                     secSurSymptOth7.setVisibility(View.GONE);
                     lineSurSymptOth7.setVisibility(View.GONE);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secSurSymptOth7=(LinearLayout)findViewById(R.id.secSurSymptOth7);
         lineSurSymptOth7=(View)findViewById(R.id.lineSurSymptOth7);
         VlblSurSymptOth7=(TextView) findViewById(R.id.VlblSurSymptOth7);
         txtSurSymptOth7=(EditText) findViewById(R.id.txtSurSymptOth7);
         secSDurFever=(LinearLayout)findViewById(R.id.secSDurFever);
         lineSDurFever=(View)findViewById(R.id.lineSDurFever);
         VlblSDurFever=(TextView) findViewById(R.id.VlblSDurFever);
         txtSDurFever=(EditText) findViewById(R.id.txtSDurFever);
         secSPHosNam=(LinearLayout)findViewById(R.id.secSPHosNam);
         lineSPHosNam=(View)findViewById(R.id.lineSPHosNam);
         VlblSPHosNam=(TextView) findViewById(R.id.VlblSPHosNam);
         spnSPHosNam=(Spinner) findViewById(R.id.spnSPHosNam);
         List<String> listSPHosNam = new ArrayList<String>();
         
         listSPHosNam.add("");
         listSPHosNam.add("1-Dhaka Shishu Hospital");
         listSPHosNam.add("2-Dr. MR Khan Hospital");
         listSPHosNam.add("7-Other");
         listSPHosNam.add("8-Don’t know");
         ArrayAdapter<String> adptrSPHosNam= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listSPHosNam);
         spnSPHosNam.setAdapter(adptrSPHosNam);

         spnSPHosNam.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnSPHosNam.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnSPHosNam.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("1"))
                 {
                    secSPHosOth.setVisibility(View.GONE);
                    lineSPHosOth.setVisibility(View.GONE);
                    txtSPHosOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("2"))
                 {
                    secSPHosOth.setVisibility(View.GONE);
                    lineSPHosOth.setVisibility(View.GONE);
                    txtSPHosOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("8"))
                 {
                    secSPHosOth.setVisibility(View.GONE);
                    lineSPHosOth.setVisibility(View.GONE);
                    txtSPHosOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("7"))
                 {
                    secSPHosOth.setVisibility(View.VISIBLE);
                    lineSPHosOth.setVisibility(View.VISIBLE);
                 }
                 else{
                     secSPHosOth.setVisibility(View.GONE);
                     lineSPHosOth.setVisibility(View.GONE);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secSPHosOth=(LinearLayout)findViewById(R.id.secSPHosOth);
         lineSPHosOth=(View)findViewById(R.id.lineSPHosOth);
         VlblSPHosOth=(TextView) findViewById(R.id.VlblSPHosOth);
         txtSPHosOth=(EditText) findViewById(R.id.txtSPHosOth);
         secSDisDr=(LinearLayout)findViewById(R.id.secSDisDr);
         lineSDisDr=(View)findViewById(R.id.lineSDisDr);
         VlblSDisDr=(TextView) findViewById(R.id.VlblSDisDr);
         spnSDisDr=(Spinner) findViewById(R.id.spnSDisDr);
         List<String> listSDisDr = new ArrayList<String>();
         
         listSDisDr.add("");
         listSDisDr.add("1-নাড়ী ছিদ্র হয়েছিল (Hole in gastro-intestinal tract) ");
         listSDisDr.add("2- অ্যাপিণ্ডিসাইটিস (Appendicitis) ");
         listSDisDr.add("7-অন্যান্য (Other)  ");
         listSDisDr.add("8-জানিনা (Don’t know) ");
         ArrayAdapter<String> adptrSDisDr= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listSDisDr);
         spnSDisDr.setAdapter(adptrSDisDr);

         spnSDisDr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnSDisDr.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnSDisDr.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("1"))
                 {
                    secSDisDrOth.setVisibility(View.GONE);
                    lineSDisDrOth.setVisibility(View.GONE);
                    txtSDisDrOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("2"))
                 {
                    secSDisDrOth.setVisibility(View.GONE);
                    lineSDisDrOth.setVisibility(View.GONE);
                    txtSDisDrOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("8"))
                 {
                    secSDisDrOth.setVisibility(View.GONE);
                    lineSDisDrOth.setVisibility(View.GONE);
                    txtSDisDrOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("7"))
                 {
                    secSDisDrOth.setVisibility(View.VISIBLE);
                    lineSDisDrOth.setVisibility(View.VISIBLE);
                 }
                 else{
                     secSDisDrOth.setVisibility(View.GONE);
                     lineSDisDrOth.setVisibility(View.GONE);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secSDisDrOth=(LinearLayout)findViewById(R.id.secSDisDrOth);
         lineSDisDrOth=(View)findViewById(R.id.lineSDisDrOth);
         VlblSDisDrOth=(TextView) findViewById(R.id.VlblSDisDrOth);
         txtSDisDrOth=(EditText) findViewById(R.id.txtSDisDrOth);
         secSReco=(LinearLayout)findViewById(R.id.secSReco);
         lineSReco=(View)findViewById(R.id.lineSReco);
         VlblSReco = (TextView) findViewById(R.id.VlblSReco);
         rdogrpSReco = (RadioGroup) findViewById(R.id.rdogrpSReco);
         
         rdoSReco1 = (RadioButton) findViewById(R.id.rdoSReco1);
         rdoSReco2 = (RadioButton) findViewById(R.id.rdoSReco2);
         rdoSReco3 = (RadioButton) findViewById(R.id.rdoSReco3);
         rdogrpSReco.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpSReco = new String[] {"1","2","8"};
             for (int i = 0; i < rdogrpSReco.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpSReco.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpSReco[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                 secSDurReco.setVisibility(View.GONE);
                 lineSDurReco.setVisibility(View.GONE);
                 secSInRecoLabel.setVisibility(View.VISIBLE);
                 lineSInRecoLabel.setVisibility(View.VISIBLE);
                 secSInReco.setVisibility(View.VISIBLE);
                 lineSInReco.setVisibility(View.VISIBLE);
                 secSInReco2.setVisibility(View.VISIBLE);
                 lineSInReco2.setVisibility(View.VISIBLE);



             }
             else if(rbData.equalsIgnoreCase("8"))
             {

                 secSDurReco.setVisibility(View.GONE);
                 lineSDurReco.setVisibility(View.GONE);
                 secSInRecoLabel.setVisibility(View.VISIBLE);
                 lineSInRecoLabel.setVisibility(View.VISIBLE);

                 secSInReco.setVisibility(View.VISIBLE);
                 lineSInReco.setVisibility(View.VISIBLE);
                 secSInReco2.setVisibility(View.VISIBLE);
                 lineSInReco2.setVisibility(View.VISIBLE);

             }
             else if(rbData.equalsIgnoreCase("1"))
             {
                    secSDurReco.setVisibility(View.VISIBLE);
                    lineSDurReco.setVisibility(View.VISIBLE);
                 secSInRecoLabel.setVisibility(View.VISIBLE);
                 lineSInRecoLabel.setVisibility(View.VISIBLE);
                 secSInReco.setVisibility(View.VISIBLE);
                 lineSInReco.setVisibility(View.VISIBLE);
                 secSInReco2.setVisibility(View.VISIBLE);
                 lineSInReco2.setVisibility(View.VISIBLE);
             }
             else{
                 secSDurReco.setVisibility(View.GONE);
                 lineSDurReco.setVisibility(View.GONE);
                 secSInRecoLabel.setVisibility(View.VISIBLE);
                 lineSInRecoLabel.setVisibility(View.VISIBLE);
                 secSInReco.setVisibility(View.VISIBLE);
                 lineSInReco.setVisibility(View.VISIBLE);
                 secSInReco2.setVisibility(View.VISIBLE);
                 lineSInReco2.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secSDurReco=(LinearLayout)findViewById(R.id.secSDurReco);
         lineSDurReco=(View)findViewById(R.id.lineSDurReco);
         VlblSDurReco=(TextView) findViewById(R.id.VlblSDurReco);
         txtSDurReco=(EditText) findViewById(R.id.txtSDurReco);
         secSInRecoLabel=(LinearLayout)findViewById(R.id.secSInRecoLabel);
         lineSInRecoLabel=(View)findViewById(R.id.lineSInRecoLabel);
         secSInReco=(LinearLayout)findViewById(R.id.secSInReco);
         lineSInReco=(View)findViewById(R.id.lineSInReco);
         VlblSInReco = (TextView) findViewById(R.id.VlblSInReco);
         rdogrpSInReco = (RadioGroup) findViewById(R.id.rdogrpSInReco);
         
         rdoSInReco1 = (RadioButton) findViewById(R.id.rdoSInReco1);
         rdoSInReco2 = (RadioButton) findViewById(R.id.rdoSInReco2);
         rdogrpSInReco.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpSInReco = new String[] {"1","2"};
             for (int i = 0; i < rdogrpSInReco.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpSInReco.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpSInReco[i];
             }

             if(rbData.equalsIgnoreCase("1"))
             {
                    secSInRecoOth.setVisibility(View.GONE);
                    lineSInRecoOth.setVisibility(View.GONE);
                    txtSInRecoOth.setText("");
             }
             else
             {
                    secSInRecoOth.setVisibility(View.VISIBLE);
                    lineSInRecoOth.setVisibility(View.VISIBLE);
             }
            }



         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         });

         txtSDurReco.addTextChangedListener(new TextWatcher() {
             @Override
             public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

             }

             @Override
             public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                 secSInRecoLabel.setVisibility(View.GONE);
                 lineSInRecoLabel.setVisibility(View.GONE);
                 secSInReco.setVisibility(View.GONE);
                 lineSInReco.setVisibility(View.GONE);
                 secSInReco2.setVisibility(View.GONE);
                 lineSInReco2.setVisibility(View.GONE);
                 secSInRecoOth.setVisibility(View.GONE);
                 lineSInRecoOth.setVisibility(View.GONE);
                 secSInRecoOth2.setVisibility(View.GONE);
                 lineSInRecoOth2.setVisibility(View.GONE);
             }

             @Override
             public void afterTextChanged(Editable editable) {

             }
         });
         secSInRecoOth=(LinearLayout)findViewById(R.id.secSInRecoOth);
         lineSInRecoOth=(View)findViewById(R.id.lineSInRecoOth);
         VlblSInRecoOth=(TextView) findViewById(R.id.VlblSInRecoOth);
         txtSInRecoOth=(EditText) findViewById(R.id.txtSInRecoOth);
         secSInReco2=(LinearLayout)findViewById(R.id.secSInReco2);
         lineSInReco2=(View)findViewById(R.id.lineSInReco2);
         VlblSInReco2 = (TextView) findViewById(R.id.VlblSInReco2);
         rdogrpSInReco2 = (RadioGroup) findViewById(R.id.rdogrpSInReco2);
         
         rdoSInReco21 = (RadioButton) findViewById(R.id.rdoSInReco21);
         rdoSInReco22 = (RadioButton) findViewById(R.id.rdoSInReco22);
         rdogrpSInReco2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpSInReco2 = new String[] {"1","2"};
             for (int i = 0; i < rdogrpSInReco2.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpSInReco2.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpSInReco2[i];
             }

             if(rbData.equalsIgnoreCase("1"))
             {
                    secSInRecoOth2.setVisibility(View.GONE);
                    lineSInRecoOth2.setVisibility(View.GONE);
                    txtSInRecoOth2.setText("");
             }
             else
             {
                    secSInRecoOth2.setVisibility(View.VISIBLE);
                    lineSInRecoOth2.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secSInRecoOth2=(LinearLayout)findViewById(R.id.secSInRecoOth2);
         lineSInRecoOth2=(View)findViewById(R.id.lineSInRecoOth2);
         VlblSInRecoOth2=(TextView) findViewById(R.id.VlblSInRecoOth2);
         txtSInRecoOth2=(EditText) findViewById(R.id.txtSInRecoOth2);
         secSAboIll=(LinearLayout)findViewById(R.id.secSAboIll);
         lineSAboIll=(View)findViewById(R.id.lineSAboIll);
         VlblSAboIll=(TextView) findViewById(R.id.VlblSAboIll);
         txtSAboIll=(EditText) findViewById(R.id.txtSAboIll);






         dtpSDtHos.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpSDtHos.getRight() - dtpSDtHos.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btnSDtHos"; showDialog(DATE_DIALOG);
                         txtSHosM.setText("");
                      return true;
                     }
                 }
                 return false;
             }
         });



         //Hide all skip variables
         secOperNo.setVisibility(View.GONE);
         lineOperNo.setVisibility(View.GONE);
         secSDtHos.setVisibility(View.GONE);
         lineSDtHos.setVisibility(View.GONE);
         secSHosM.setVisibility(View.GONE);
         lineSHosM.setVisibility(View.GONE);
         secSIlBeHosAdm.setVisibility(View.GONE);
         lineSIlBeHosAdm.setVisibility(View.GONE);
         secSurSymptLabel.setVisibility(View.GONE);
         lineSurSymptLabel.setVisibility(View.GONE);
         secSurSympt.setVisibility(View.GONE);
         lineSurSympt.setVisibility(View.GONE);
         secSurSymptOth.setVisibility(View.GONE);
         lineSurSymptOth.setVisibility(View.GONE);
         secSurSympt2.setVisibility(View.GONE);
         lineSurSympt2.setVisibility(View.GONE);
         secSurSymptOth2.setVisibility(View.GONE);
         lineSurSymptOth2.setVisibility(View.GONE);
         secSurSympt3.setVisibility(View.GONE);
         lineSurSympt3.setVisibility(View.GONE);
         secSurSymptOth3.setVisibility(View.GONE);
         lineSurSymptOth3.setVisibility(View.GONE);
         secSurSympt4.setVisibility(View.GONE);
         lineSurSympt4.setVisibility(View.GONE);
         secSurSymptOth4.setVisibility(View.GONE);
         lineSurSymptOth4.setVisibility(View.GONE);
         secSurSympt5.setVisibility(View.GONE);
         lineSurSympt5.setVisibility(View.GONE);
         secSurSymptOth5.setVisibility(View.GONE);
         lineSurSymptOth5.setVisibility(View.GONE);
         secSurSympt6.setVisibility(View.GONE);
         lineSurSympt6.setVisibility(View.GONE);
         secSurSymptOth6.setVisibility(View.GONE);
         lineSurSymptOth6.setVisibility(View.GONE);
         secSurSympt7.setVisibility(View.GONE);
         lineSurSympt7.setVisibility(View.GONE);
         secSurSymptOth7.setVisibility(View.GONE);
         lineSurSymptOth7.setVisibility(View.GONE);
         secSDurFever.setVisibility(View.GONE);
         lineSDurFever.setVisibility(View.GONE);
         secSPHosNam.setVisibility(View.GONE);
         lineSPHosNam.setVisibility(View.GONE);
         secSPHosOth.setVisibility(View.GONE);
         lineSPHosOth.setVisibility(View.GONE);
         secSDisDr.setVisibility(View.GONE);
         lineSDisDr.setVisibility(View.GONE);
         secSDisDrOth.setVisibility(View.GONE);
         lineSDisDrOth.setVisibility(View.GONE);
         secSReco.setVisibility(View.GONE);
         lineSReco.setVisibility(View.GONE);
         secSDurReco.setVisibility(View.GONE);
         lineSDurReco.setVisibility(View.GONE);
         secSInRecoLabel.setVisibility(View.GONE);
         lineSInRecoLabel.setVisibility(View.GONE);
         secSInReco.setVisibility(View.GONE);
         lineSInReco.setVisibility(View.GONE);
         secSInRecoOth.setVisibility(View.GONE);
         lineSInRecoOth.setVisibility(View.GONE);
         secSInReco2.setVisibility(View.GONE);
         lineSInReco2.setVisibility(View.GONE);
         secSInRecoOth2.setVisibility(View.GONE);
         lineSInRecoOth2.setVisibility(View.GONE);
         secSAboIll.setVisibility(View.GONE);
         lineSAboIll.setVisibility(View.GONE);
         secOperNo.setVisibility(View.GONE);
         lineOperNo.setVisibility(View.GONE);
         secSDtHos.setVisibility(View.GONE);
         lineSDtHos.setVisibility(View.GONE);
         secSHosM.setVisibility(View.GONE);
         lineSHosM.setVisibility(View.GONE);
         secSIlBeHosAdm.setVisibility(View.GONE);
         lineSIlBeHosAdm.setVisibility(View.GONE);
         secSurSymptLabel.setVisibility(View.GONE);
         lineSurSymptLabel.setVisibility(View.GONE);
         secSurSympt.setVisibility(View.GONE);
         lineSurSympt.setVisibility(View.GONE);
         secSurSymptOth.setVisibility(View.GONE);
         lineSurSymptOth.setVisibility(View.GONE);
         secSurSympt2.setVisibility(View.GONE);
         lineSurSympt2.setVisibility(View.GONE);
         secSurSymptOth2.setVisibility(View.GONE);
         lineSurSymptOth2.setVisibility(View.GONE);
         secSurSympt3.setVisibility(View.GONE);
         lineSurSympt3.setVisibility(View.GONE);
         secSurSymptOth3.setVisibility(View.GONE);
         lineSurSymptOth3.setVisibility(View.GONE);
         secSurSympt4.setVisibility(View.GONE);
         lineSurSympt4.setVisibility(View.GONE);
         secSurSymptOth4.setVisibility(View.GONE);
         lineSurSymptOth4.setVisibility(View.GONE);
         secSurSympt5.setVisibility(View.GONE);
         lineSurSympt5.setVisibility(View.GONE);
         secSurSymptOth5.setVisibility(View.GONE);
         lineSurSymptOth5.setVisibility(View.GONE);
         secSurSympt6.setVisibility(View.GONE);
         lineSurSympt6.setVisibility(View.GONE);
         secSurSymptOth6.setVisibility(View.GONE);
         lineSurSymptOth6.setVisibility(View.GONE);
         secSurSympt7.setVisibility(View.GONE);
         lineSurSympt7.setVisibility(View.GONE);
         secSurSymptOth7.setVisibility(View.GONE);
         lineSurSymptOth7.setVisibility(View.GONE);
         secSDurFever.setVisibility(View.GONE);
         lineSDurFever.setVisibility(View.GONE);
         secSPHosNam.setVisibility(View.GONE);
         lineSPHosNam.setVisibility(View.GONE);
         secSPHosOth.setVisibility(View.GONE);
         lineSPHosOth.setVisibility(View.GONE);
         secSDisDr.setVisibility(View.GONE);
         lineSDisDr.setVisibility(View.GONE);
         secSDisDrOth.setVisibility(View.GONE);
         lineSDisDrOth.setVisibility(View.GONE);
         secSReco.setVisibility(View.GONE);
         lineSReco.setVisibility(View.GONE);
         secSDurReco.setVisibility(View.GONE);
         lineSDurReco.setVisibility(View.GONE);
         secSInRecoLabel.setVisibility(View.GONE);
         lineSInRecoLabel.setVisibility(View.GONE);
         secSInReco.setVisibility(View.GONE);
         lineSInReco.setVisibility(View.GONE);
         secSInRecoOth.setVisibility(View.GONE);
         lineSInRecoOth.setVisibility(View.GONE);
         secSInReco2.setVisibility(View.GONE);
         lineSInReco2.setVisibility(View.GONE);
         secSInRecoOth2.setVisibility(View.GONE);
         lineSInRecoOth2.setVisibility(View.GONE);
         secSAboIll.setVisibility(View.GONE);
         lineSAboIll.setVisibility(View.GONE);
         secSurSymptOth.setVisibility(View.GONE);
         lineSurSymptOth.setVisibility(View.GONE);
         secSurSymptOth.setVisibility(View.GONE);
         lineSurSymptOth.setVisibility(View.GONE);
         secSurSymptOth.setVisibility(View.GONE);
         lineSurSymptOth.setVisibility(View.GONE);
         secSurSymptOth.setVisibility(View.GONE);
         lineSurSymptOth.setVisibility(View.GONE);
         secSurSymptOth.setVisibility(View.GONE);
         lineSurSymptOth.setVisibility(View.GONE);
         secSurSymptOth.setVisibility(View.GONE);
         lineSurSymptOth.setVisibility(View.GONE);
         secSurSymptOth.setVisibility(View.GONE);
         lineSurSymptOth.setVisibility(View.GONE);
         secSurSymptOth.setVisibility(View.GONE);
         lineSurSymptOth.setVisibility(View.GONE);
         secSurSymptOth.setVisibility(View.GONE);
         lineSurSymptOth.setVisibility(View.GONE);
         secSurSymptOth2.setVisibility(View.GONE);
         lineSurSymptOth2.setVisibility(View.GONE);
         secSurSymptOth2.setVisibility(View.GONE);
         lineSurSymptOth2.setVisibility(View.GONE);
         secSurSymptOth2.setVisibility(View.GONE);
         lineSurSymptOth2.setVisibility(View.GONE);
         secSurSymptOth2.setVisibility(View.GONE);
         lineSurSymptOth2.setVisibility(View.GONE);
         secSurSymptOth2.setVisibility(View.GONE);
         lineSurSymptOth2.setVisibility(View.GONE);
         secSurSymptOth2.setVisibility(View.GONE);
         lineSurSymptOth2.setVisibility(View.GONE);
         secSurSymptOth2.setVisibility(View.GONE);
         lineSurSymptOth2.setVisibility(View.GONE);
         secSurSymptOth2.setVisibility(View.GONE);
         lineSurSymptOth2.setVisibility(View.GONE);
         secSurSymptOth2.setVisibility(View.GONE);
         lineSurSymptOth2.setVisibility(View.GONE);
         secSurSymptOth3.setVisibility(View.GONE);
         lineSurSymptOth3.setVisibility(View.GONE);
         secSurSymptOth3.setVisibility(View.GONE);
         lineSurSymptOth3.setVisibility(View.GONE);
         secSurSymptOth3.setVisibility(View.GONE);
         lineSurSymptOth3.setVisibility(View.GONE);
         secSurSymptOth3.setVisibility(View.GONE);
         lineSurSymptOth3.setVisibility(View.GONE);
         secSurSymptOth3.setVisibility(View.GONE);
         lineSurSymptOth3.setVisibility(View.GONE);
         secSurSymptOth3.setVisibility(View.GONE);
         lineSurSymptOth3.setVisibility(View.GONE);
         secSurSymptOth3.setVisibility(View.GONE);
         lineSurSymptOth3.setVisibility(View.GONE);
         secSurSymptOth3.setVisibility(View.GONE);
         lineSurSymptOth3.setVisibility(View.GONE);
         secSurSymptOth3.setVisibility(View.GONE);
         lineSurSymptOth3.setVisibility(View.GONE);
         secSurSymptOth4.setVisibility(View.GONE);
         lineSurSymptOth4.setVisibility(View.GONE);
         secSurSymptOth4.setVisibility(View.GONE);
         lineSurSymptOth4.setVisibility(View.GONE);
         secSurSymptOth4.setVisibility(View.GONE);
         lineSurSymptOth4.setVisibility(View.GONE);
         secSurSymptOth4.setVisibility(View.GONE);
         lineSurSymptOth4.setVisibility(View.GONE);
         secSurSymptOth4.setVisibility(View.GONE);
         lineSurSymptOth4.setVisibility(View.GONE);
         secSurSymptOth4.setVisibility(View.GONE);
         lineSurSymptOth4.setVisibility(View.GONE);
         secSurSymptOth4.setVisibility(View.GONE);
         lineSurSymptOth4.setVisibility(View.GONE);
         secSurSymptOth4.setVisibility(View.GONE);
         lineSurSymptOth4.setVisibility(View.GONE);
         secSurSymptOth4.setVisibility(View.GONE);
         lineSurSymptOth4.setVisibility(View.GONE);
         secSurSymptOth5.setVisibility(View.GONE);
         lineSurSymptOth5.setVisibility(View.GONE);
         secSurSymptOth5.setVisibility(View.GONE);
         lineSurSymptOth5.setVisibility(View.GONE);
         secSurSymptOth5.setVisibility(View.GONE);
         lineSurSymptOth5.setVisibility(View.GONE);
         secSurSymptOth5.setVisibility(View.GONE);
         lineSurSymptOth5.setVisibility(View.GONE);
         secSurSymptOth5.setVisibility(View.GONE);
         lineSurSymptOth5.setVisibility(View.GONE);
         secSurSymptOth5.setVisibility(View.GONE);
         lineSurSymptOth5.setVisibility(View.GONE);
         secSurSymptOth5.setVisibility(View.GONE);
         lineSurSymptOth5.setVisibility(View.GONE);
         secSurSymptOth5.setVisibility(View.GONE);
         lineSurSymptOth5.setVisibility(View.GONE);
         secSurSymptOth6.setVisibility(View.GONE);
         lineSurSymptOth6.setVisibility(View.GONE);
         secSurSymptOth6.setVisibility(View.GONE);
         lineSurSymptOth6.setVisibility(View.GONE);
         secSurSymptOth6.setVisibility(View.GONE);
         lineSurSymptOth6.setVisibility(View.GONE);
         secSurSymptOth6.setVisibility(View.GONE);
         lineSurSymptOth6.setVisibility(View.GONE);
         secSurSymptOth6.setVisibility(View.GONE);
         lineSurSymptOth6.setVisibility(View.GONE);
         secSurSymptOth6.setVisibility(View.GONE);
         lineSurSymptOth6.setVisibility(View.GONE);
         secSurSymptOth6.setVisibility(View.GONE);
         lineSurSymptOth6.setVisibility(View.GONE);
         secSurSymptOth6.setVisibility(View.GONE);
         lineSurSymptOth6.setVisibility(View.GONE);
         secSurSymptOth6.setVisibility(View.GONE);
         lineSurSymptOth6.setVisibility(View.GONE);
         secSurSymptOth7.setVisibility(View.GONE);
         lineSurSymptOth7.setVisibility(View.GONE);
         secSDurFever.setVisibility(View.GONE);
         lineSDurFever.setVisibility(View.GONE);
         secSurSymptOth7.setVisibility(View.GONE);
         lineSurSymptOth7.setVisibility(View.GONE);
         secSDurFever.setVisibility(View.GONE);
         lineSDurFever.setVisibility(View.GONE);
         secSurSymptOth7.setVisibility(View.GONE);
         lineSurSymptOth7.setVisibility(View.GONE);
         secSDurFever.setVisibility(View.GONE);
         lineSDurFever.setVisibility(View.GONE);
         secSurSymptOth7.setVisibility(View.GONE);
         lineSurSymptOth7.setVisibility(View.GONE);
         secSDurFever.setVisibility(View.GONE);
         lineSDurFever.setVisibility(View.GONE);
         secSurSymptOth7.setVisibility(View.GONE);
         lineSurSymptOth7.setVisibility(View.GONE);
         secSDurFever.setVisibility(View.GONE);
         lineSDurFever.setVisibility(View.GONE);
         secSurSymptOth7.setVisibility(View.GONE);
         lineSurSymptOth7.setVisibility(View.GONE);
         secSDurFever.setVisibility(View.GONE);
         lineSDurFever.setVisibility(View.GONE);
         secSurSymptOth7.setVisibility(View.GONE);
         lineSurSymptOth7.setVisibility(View.GONE);
         secSDurFever.setVisibility(View.GONE);
         lineSDurFever.setVisibility(View.GONE);
         secSurSymptOth7.setVisibility(View.GONE);
         lineSurSymptOth7.setVisibility(View.GONE);
         secSDurFever.setVisibility(View.GONE);
         lineSDurFever.setVisibility(View.GONE);
         secSurSymptOth7.setVisibility(View.GONE);
         lineSurSymptOth7.setVisibility(View.GONE);
         secSPHosOth.setVisibility(View.GONE);
         lineSPHosOth.setVisibility(View.GONE);
         secSPHosOth.setVisibility(View.GONE);
         lineSPHosOth.setVisibility(View.GONE);
         secSPHosOth.setVisibility(View.GONE);
         lineSPHosOth.setVisibility(View.GONE);
         secSDisDrOth.setVisibility(View.GONE);
         lineSDisDrOth.setVisibility(View.GONE);
         secSDisDrOth.setVisibility(View.GONE);
         lineSDisDrOth.setVisibility(View.GONE);
         secSDisDrOth.setVisibility(View.GONE);
         lineSDisDrOth.setVisibility(View.GONE);
         secSDurReco.setVisibility(View.GONE);
         lineSDurReco.setVisibility(View.GONE);
         secSInRecoLabel.setVisibility(View.GONE);
         lineSInRecoLabel.setVisibility(View.GONE);
         secSDurReco.setVisibility(View.GONE);
         lineSDurReco.setVisibility(View.GONE);
         secSInRecoLabel.setVisibility(View.GONE);
         lineSInRecoLabel.setVisibility(View.GONE);
         secSInRecoOth.setVisibility(View.GONE);
         lineSInRecoOth.setVisibility(View.GONE);
         secSInRecoOth2.setVisibility(View.GONE);
         lineSInRecoOth2.setVisibility(View.GONE);


         DataSearch(UNCODE,STRUCTURENO,HOUSEHOLDSL,VISITNO,MEMSL);

        Button cmdSave = (Button) findViewById(R.id.cmdSave);
        cmdSave.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) { 
            DataSave();
        }});
     }
     catch(Exception  e)
     {
         Connection.MessageBox(EmergencyOperation .this, e.getMessage());
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
             Connection.MessageBox(EmergencyOperation .this, "Required field: Ward No.");
             txtUNCode.requestFocus(); 
             return;	
           }
         else if(txtStructureNo.getText().toString().length()==0 & secStructureNo.isShown())
           {
             Connection.MessageBox(EmergencyOperation .this, "Required field: Structure No.");
             txtStructureNo.requestFocus(); 
             return;	
           }
         else if(txtHouseholdSl.getText().toString().length()==0 & secHouseholdSl.isShown())
           {
             Connection.MessageBox(EmergencyOperation .this, "Required field: Household Sl.");
             txtHouseholdSl.requestFocus(); 
             return;	
           }
         else if(txtVisitNo.getText().toString().length()==0 & secVisitNo.isShown())
           {
             Connection.MessageBox(EmergencyOperation .this, "Required field: Visit No.");
             txtVisitNo.requestFocus(); 
             return;	
           }
         else if(txtMemSl.getText().toString().length()==0 & secMemSl.isShown())
           {
             Connection.MessageBox(EmergencyOperation .this, "Required field: Member Serial.");
             txtMemSl.requestFocus(); 
             return;	
           }
         
         else if(!rdoSAbd1.isChecked() & !rdoSAbd2.isChecked() & !rdoSAbd3.isChecked() & secSAbd.isShown())
           {
              Connection.MessageBox(EmergencyOperation .this, "Select anyone options from (গত ২৪ মাসে আপনার শিশুর কি দুর্ঘটনা কবলিত ছাড়া জরুরী ভিত্তিতে পেটে অপারেশন করানো হয়েছিল? (Within the last 24 months did this child have an emergency non-traumatic abdominal surgery?)).");
              rdoSAbd1.requestFocus();
              return;
           }
         else if(txtOperNo.getText().toString().length()==0 & secOperNo.isShown())
           {
             Connection.MessageBox(EmergencyOperation .this, "Required field: গত ২৪ মাসে আপনার শিশুর কয়টি অপারেশন করানো হয়েছিল? (যদি একের অধিক এই অপারেশন হয়ে থাকে তবে অতিসম্প্রতি হয়ে যাওয়া অপারেশন সম্পর্কে নিচের প্রশ্নগুলো করুন) (Within the last 24 months how many operation did this child have? If >1 operations performed, ask about the following questions on the most recent operation).");
             txtOperNo.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtOperNo.getText().toString().length()==0 ? "1" : txtOperNo.getText().toString()) < 1 || Integer.valueOf(txtOperNo.getText().toString().length()==0 ? "12" : txtOperNo.getText().toString()) > 12)
           {
             Connection.MessageBox(EmergencyOperation .this, "Value should be between 1 and 12(গত ২৪ মাসে আপনার শিশুর কয়টি অপারেশন করানো হয়েছিল? (যদি একের অধিক এই অপারেশন হয়ে থাকে তবে অতিসম্প্রতি হয়ে যাওয়া অপারেশন সম্পর্কে নিচের প্রশ্নগুলো করুন) (Within the last 24 months how many operation did this child have? If >1 operations performed, ask about the following questions on the most recent operation)).");
             txtOperNo.requestFocus(); 
             return;	
           }
//           else if(dtpSDtHos.getText().toString().length()==0 & secSDtHos.isShown()){
//             if(txtSHosM.getText().toString().length()==0)
//             {
//                 DV = Global.DateValidate(dtpSDtHos.getText().toString());
//                 if(DV.length()!=0 & secSDtHos.isShown())
//                 {
//                     Connection.MessageBox(EmergencyOperation .this, DV);
//                     dtpSDtHos.requestFocus();
//                     return;
//                 }
//             }
//
//         }


         else if(txtSHosM.getText().toString().length()==0 & dtpSDtHos.getText().toString().length()==0 & secSHosM.isShown())
           {
                   Connection.MessageBox(EmergencyOperation .this, "Required field: যদি ভর্তির তারিখ জানা না থাকে,  কত মাস আগে  (How much ago).");
                   txtSHosM.requestFocus();
                   return;

           }
         else if(Integer.valueOf(txtSHosM.getText().toString().length()==0 ? "01" : txtSHosM.getText().toString()) < 01 || Integer.valueOf(txtSHosM.getText().toString().length()==0 ? "99" : txtSHosM.getText().toString()) > 99)
           {
             Connection.MessageBox(EmergencyOperation .this, "Value should be between 01 and 99(যদি ভর্তির তারিখ জানা না থাকে,  কত মাস আগে  (How much ago)).");
             txtSHosM.requestFocus(); 
             return;	
           }
         else if(txtSIlBeHosAdm.getText().toString().length()==0 & secSIlBeHosAdm.isShown())
           {
             Connection.MessageBox(EmergencyOperation .this, "Required field: হাসপাতালে ভর্তির আগে শিশুটি কতদিন অসুস্থ ছিল? (যদি জানা না থাকে 98 বসান) (For how many days did the child appear ill before he/she was hospitalized?).");
             txtSIlBeHosAdm.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtSIlBeHosAdm.getText().toString().length()==0 ? "01" : txtSIlBeHosAdm.getText().toString()) < 01 || Integer.valueOf(txtSIlBeHosAdm.getText().toString().length()==0 ? "98" : txtSIlBeHosAdm.getText().toString()) > 98)
           {
             Connection.MessageBox(EmergencyOperation .this, "Value should be between 01 and 98(হাসপাতালে ভর্তির আগে শিশুটি কতদিন অসুস্থ ছিল? (যদি জানা না থাকে 98 বসান) (For how many days did the child appear ill before he/she was hospitalized?)).");
             txtSIlBeHosAdm.requestFocus(); 
             return;	
           }
         else if(spnSurSympt.getSelectedItemPosition()==0  & secSurSympt.isShown())
           {
             Connection.MessageBox(EmergencyOperation .this, "Required field: 1..");
             spnSurSympt.requestFocus(); 
             return;	
           }
         else if(txtSurSymptOth.getText().toString().length()==0 & secSurSymptOth.isShown())
           {
             Connection.MessageBox(EmergencyOperation .this, "Required field: অন্যান্য উল্লেখ করুন (Others Specify).");
             txtSurSymptOth.requestFocus(); 
             return;	
           }
//         else if(spnSurSympt2.getSelectedItemPosition()==0  & secSurSympt2.isShown())
//           {
//             Connection.MessageBox(EmergencyOperation .this, "Required field: 2..");
//             spnSurSympt2.requestFocus();
//             return;
//           }
//         else if(txtSurSymptOth2.getText().toString().length()==0 & secSurSymptOth2.isShown())
//           {
//             Connection.MessageBox(EmergencyOperation .this, "Required field: অন্যান্য উল্লেখ করুন (Others Specify).");
//             txtSurSymptOth2.requestFocus();
//             return;
//           }
//         else if(spnSurSympt3.getSelectedItemPosition()==0  & secSurSympt3.isShown())
//           {
//             Connection.MessageBox(EmergencyOperation .this, "Required field: 3..");
//             spnSurSympt3.requestFocus();
//             return;
//           }
//         else if(txtSurSymptOth3.getText().toString().length()==0 & secSurSymptOth3.isShown())
//           {
//             Connection.MessageBox(EmergencyOperation .this, "Required field: অন্যান্য উল্লেখ করুন (Others Specify).");
//             txtSurSymptOth3.requestFocus();
//             return;
//           }
//         else if(spnSurSympt4.getSelectedItemPosition()==0  & secSurSympt4.isShown())
//           {
//             Connection.MessageBox(EmergencyOperation .this, "Required field: 4..");
//             spnSurSympt4.requestFocus();
//             return;
//           }
//         else if(txtSurSymptOth4.getText().toString().length()==0 & secSurSymptOth4.isShown())
//           {
//             Connection.MessageBox(EmergencyOperation .this, "Required field: অন্যান্য উল্লেখ করুন (Others Specify).");
//             txtSurSymptOth4.requestFocus();
//             return;
//           }
//         else if(spnSurSympt5.getSelectedItemPosition()==0  & secSurSympt5.isShown())
//           {
//             Connection.MessageBox(EmergencyOperation .this, "Required field: 5..");
//             spnSurSympt5.requestFocus();
//             return;
//           }
//         else if(txtSurSymptOth5.getText().toString().length()==0 & secSurSymptOth5.isShown())
//           {
//             Connection.MessageBox(EmergencyOperation .this, "Required field: অন্যান্য উল্লেখ করুন (Others Specify).");
//             txtSurSymptOth5.requestFocus();
//             return;
//           }
//         else if(spnSurSympt6.getSelectedItemPosition()==0  & secSurSympt6.isShown())
//           {
//             Connection.MessageBox(EmergencyOperation .this, "Required field: 6..");
//             spnSurSympt6.requestFocus();
//             return;
//           }
//         else if(txtSurSymptOth6.getText().toString().length()==0 & secSurSymptOth6.isShown())
//           {
//             Connection.MessageBox(EmergencyOperation .this, "Required field: অন্যান্য উল্লেখ করুন (Others Specify).");
//             txtSurSymptOth6.requestFocus();
//             return;
//           }
//         else if(spnSurSympt7.getSelectedItemPosition()==0  & secSurSympt7.isShown())
//           {
//             Connection.MessageBox(EmergencyOperation .this, "Required field: 7..");
//             spnSurSympt7.requestFocus();
//             return;
//           }
//         else if(txtSurSymptOth7.getText().toString().length()==0 & secSurSymptOth7.isShown())
//           {
//             Connection.MessageBox(EmergencyOperation .this, "Required field: অন্যান্য উল্লেখ করুন (Others Specify).");
//             txtSurSymptOth7.requestFocus();
//             return;
//           }
         else if(txtSDurFever.getText().toString().length()==0 & secSDurFever.isShown())
           {
             Connection.MessageBox(EmergencyOperation .this, "Required field: যদি শিশুটির জ্বর থেকে থাকে তবে তা কতদিনের ধরে ছিল?(যদি জানা না থাকে 98 বসান) (If the child had fever, what was the total duration of fever?).");
             txtSDurFever.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtSDurFever.getText().toString().length()==0 ? "01" : txtSDurFever.getText().toString()) < 01 || Integer.valueOf(txtSDurFever.getText().toString().length()==0 ? "98" : txtSDurFever.getText().toString()) > 98)
           {
             Connection.MessageBox(EmergencyOperation .this, "Value should be between 01 and 98(যদি শিশুটির জ্বর থেকে থাকে তবে তা কতদিনের ধরে ছিল?(যদি জানা না থাকে 98 বসান) (If the child had fever, what was the total duration of fever?)).");
             txtSDurFever.requestFocus(); 
             return;	
           }
         else if(spnSPHosNam.getSelectedItemPosition()==0  & secSPHosNam.isShown())
           {
             Connection.MessageBox(EmergencyOperation .this, "Required field: অপারেশন কোথায় করা হয়েছিল? (was the surgery performed?).");
             spnSPHosNam.requestFocus(); 
             return;	
           }
         else if(txtSPHosOth.getText().toString().length()==0 & secSPHosOth.isShown())
           {
             Connection.MessageBox(EmergencyOperation .this, "Required field: Name of the other hospital.");
             txtSPHosOth.requestFocus(); 
             return;	
           }
         else if(spnSDisDr.getSelectedItemPosition()==0  & secSDisDr.isShown())
           {
             Connection.MessageBox(EmergencyOperation .this, "Required field: চিকিৎসকরা শিশুটির কি রোগ ছিল বলে আপনাদের বলেছিলেন?  (What illness did the doctors tell you that your child had?).");
             spnSDisDr.requestFocus(); 
             return;	
           }
         else if(txtSDisDrOth.getText().toString().length()==0 & secSDisDrOth.isShown())
           {
             Connection.MessageBox(EmergencyOperation .this, "Required field: অন্যান্য উল্লেখ করুন (Others Specify).");
             txtSDisDrOth.requestFocus(); 
             return;	
           }
         
         else if(!rdoSReco1.isChecked() & !rdoSReco2.isChecked() & !rdoSReco3.isChecked() & secSReco.isShown())
           {
              Connection.MessageBox(EmergencyOperation .this, "Select anyone options from (শিশুটি কি সম্পূর্ণ সুস্থ হয়ে গিয়েছিল ? (Did the child recover completely?)).");
              rdoSReco1.requestFocus();
              return;
           }
         else if(txtSDurReco.getText().toString().length()==0 & secSDurReco.isShown())
           {
             Connection.MessageBox(EmergencyOperation .this, "Required field: শিশুটি সুস্থ হতে কতদিন লেগেছিল? (যদি জানা না থাকে 98 বসান) (How many days were required before the child recovered?).");
             txtSDurReco.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtSDurReco.getText().toString().length()==0 ? "01" : txtSDurReco.getText().toString()) < 01 || Integer.valueOf(txtSDurReco.getText().toString().length()==0 ? "98" : txtSDurReco.getText().toString()) > 98)
           {
             Connection.MessageBox(EmergencyOperation .this, "Value should be between 01 and 98(শিশুটি সুস্থ হতে কতদিন লেগেছিল? (যদি জানা না থাকে 98 বসান) (How many days were required before the child recovered?)).");
             txtSDurReco.requestFocus(); 
             return;	
           }
         
         else if(!rdoSInReco1.isChecked() & !rdoSInReco2.isChecked() & secSInReco.isShown())
           {
              Connection.MessageBox(EmergencyOperation .this, "Select anyone options from (1.).");
              rdoSInReco1.requestFocus();
              return;
           }
         else if(txtSInRecoOth.getText().toString().length()==0 & secSInRecoOth.isShown())
           {
             Connection.MessageBox(EmergencyOperation .this, "Required field: অন্যান্য উল্লেখ করুন (Others Specify).");
             txtSInRecoOth.requestFocus(); 
             return;	
           }
         
         else if(!rdoSInReco21.isChecked() & !rdoSInReco22.isChecked() & secSInReco2.isShown())
           {
              Connection.MessageBox(EmergencyOperation .this, "Select anyone options from (2.).");
              rdoSInReco21.requestFocus();
              return;
           }
         else if(txtSInRecoOth2.getText().toString().length()==0 & secSInRecoOth2.isShown())
           {
             Connection.MessageBox(EmergencyOperation .this, "Required field: অন্যান্য উল্লেখ করুন (Others Specify).");
             txtSInRecoOth2.requestFocus(); 
             return;	
           }
//         else if(txtSAboIll.getText().toString().length()==0 & secSAboIll.isShown())
//           {
//             Connection.MessageBox(EmergencyOperation .this, "Required field: মন্তব্যঃ ইমারজেন্সি অপারেশন  (Remarks: Emergency operation).");
//             txtSAboIll.requestFocus();
//             return;
//           }
 
         String SQL = "";
         RadioButton rb;

         EmergencyOperation_DataModel objSave = new EmergencyOperation_DataModel();
         objSave.setUNCode(txtUNCode.getText().toString());
         objSave.setStructureNo(txtStructureNo.getText().toString());
         objSave.setHouseholdSl(txtHouseholdSl.getText().toString());
         objSave.setVisitNo(txtVisitNo.getText().toString());
         objSave.setMemSl(txtMemSl.getText().toString());
         String[] d_rdogrpSAbd = new String[] {"1","2","8"};
         objSave.setSAbd(0);
         for (int i = 0; i < rdogrpSAbd.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpSAbd.getChildAt(i);
             if (rb.isChecked()) objSave.setSAbd(Integer.valueOf(d_rdogrpSAbd[i]));
         }

         objSave.setOperNo(Integer.valueOf(txtOperNo.getText().toString().length()==0?"0":txtOperNo.getText().toString()));
         objSave.setSDtHos(dtpSDtHos.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpSDtHos.getText().toString()) : dtpSDtHos.getText().toString());
         objSave.setSHosM(Integer.valueOf(txtSHosM.getText().toString().length()==0?"0":txtSHosM.getText().toString()));
         objSave.setSIlBeHosAdm(Integer.valueOf(txtSIlBeHosAdm.getText().toString().length()==0?"0":txtSIlBeHosAdm.getText().toString()));
         objSave.setSurSympt(Integer.valueOf(spnSurSympt.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnSurSympt.getSelectedItem().toString(), "-")));
         objSave.setSurSymptOth(txtSurSymptOth.getText().toString());
         objSave.setSurSympt2(Integer.valueOf(spnSurSympt2.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnSurSympt2.getSelectedItem().toString(), "-")));
         objSave.setSurSymptOth2(txtSurSymptOth2.getText().toString());
         objSave.setSurSympt3(Integer.valueOf(spnSurSympt3.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnSurSympt3.getSelectedItem().toString(), "-")));
         objSave.setSurSymptOth3(txtSurSymptOth3.getText().toString());
         objSave.setSurSympt4(Integer.valueOf(spnSurSympt4.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnSurSympt4.getSelectedItem().toString(), "-")));
         objSave.setSurSymptOth4(txtSurSymptOth4.getText().toString());
         objSave.setSurSympt5(Integer.valueOf(spnSurSympt5.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnSurSympt5.getSelectedItem().toString(), "-")));
         objSave.setSurSymptOth5(txtSurSymptOth5.getText().toString());
         objSave.setSurSympt6(Integer.valueOf(spnSurSympt6.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnSurSympt6.getSelectedItem().toString(), "-")));
         objSave.setSurSymptOth6(txtSurSymptOth6.getText().toString());
         objSave.setSurSympt7(Integer.valueOf(spnSurSympt7.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnSurSympt7.getSelectedItem().toString(), "-")));
         objSave.setSurSymptOth7(txtSurSymptOth7.getText().toString());
         objSave.setSDurFever(Integer.valueOf(txtSDurFever.getText().toString().length()==0?"0":txtSDurFever.getText().toString()));
         objSave.setSPHosNam(Integer.valueOf(spnSPHosNam.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnSPHosNam.getSelectedItem().toString(), "-")));
         objSave.setSPHosOth(txtSPHosOth.getText().toString());
         objSave.setSDisDr(Integer.valueOf(spnSDisDr.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnSDisDr.getSelectedItem().toString(), "-")));
         objSave.setSDisDrOth(txtSDisDrOth.getText().toString());
         String[] d_rdogrpSReco = new String[] {"1","2","8"};
         objSave.setSReco(0);
         for (int i = 0; i < rdogrpSReco.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpSReco.getChildAt(i);
             if (rb.isChecked()) objSave.setSReco(Integer.valueOf(d_rdogrpSReco[i]));
         }

         objSave.setSDurReco(Integer.valueOf(txtSDurReco.getText().toString().length()==0?"0":txtSDurReco.getText().toString()));
         String[] d_rdogrpSInReco = new String[] {"1","2"};
         objSave.setSInReco(0);
         for (int i = 0; i < rdogrpSInReco.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpSInReco.getChildAt(i);
             if (rb.isChecked()) objSave.setSInReco(Integer.valueOf(d_rdogrpSInReco[i]));
         }

         objSave.setSInRecoOth(txtSInRecoOth.getText().toString());
         String[] d_rdogrpSInReco2 = new String[] {"1","2"};
         objSave.setSInReco2(0);
         for (int i = 0; i < rdogrpSInReco2.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpSInReco2.getChildAt(i);
             if (rb.isChecked()) objSave.setSInReco2(Integer.valueOf(d_rdogrpSInReco2[i]));
         }

         objSave.setSInRecoOth2(txtSInRecoOth2.getText().toString());
         objSave.setSAboIll(txtSAboIll.getText().toString());
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

             Connection.MessageBox(EmergencyOperation .this, "Saved Successfully");
         }
         else{
             Connection.MessageBox(EmergencyOperation .this, status);
             return;
         }
     }
     catch(Exception  e)
     {
         Connection.MessageBox(EmergencyOperation .this, e.getMessage());
         return;
     }
 }

 private void DataSearch(String UNCode, String StructureNo, String HouseholdSl, String VisitNo, String MemSl)
     {
       try
        {
     
           RadioButton rb;
           EmergencyOperation_DataModel d = new EmergencyOperation_DataModel();
           String SQL = "Select * from "+ TableName +"  Where UNCode='"+ UNCode +"' and StructureNo='"+ StructureNo +"' and HouseholdSl='"+ HouseholdSl +"' and VisitNo='"+ VisitNo +"' and MemSl='"+ MemSl +"'";
           List<EmergencyOperation_DataModel> data = d.SelectAll(this, SQL);
           for(EmergencyOperation_DataModel item : data){
             txtUNCode.setText(item.getUNCode());
             txtStructureNo.setText(item.getStructureNo());
             txtHouseholdSl.setText(item.getHouseholdSl());
             txtVisitNo.setText(item.getVisitNo());
             txtMemSl.setText(item.getMemSl());
             String[] d_rdogrpSAbd = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpSAbd.length; i++)
             {
                 if (String.valueOf(item.getSAbd()).equals(String.valueOf(d_rdogrpSAbd[i])))
                 {
                     rb = (RadioButton)rdogrpSAbd.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtOperNo.setText(String.valueOf(item.getOperNo()));
             dtpSDtHos.setText(item.getSDtHos().toString().length()==0 ? "" : Global.DateConvertDMY(item.getSDtHos()));
             txtSHosM.setText(String.valueOf(item.getSHosM()));
             txtSIlBeHosAdm.setText(String.valueOf(item.getSIlBeHosAdm()));
             spnSurSympt.setSelection(Global.SpinnerItemPositionAnyLength(spnSurSympt, String.valueOf(item.getSurSympt())));
             txtSurSymptOth.setText(item.getSurSymptOth());
             spnSurSympt2.setSelection(Global.SpinnerItemPositionAnyLength(spnSurSympt2, String.valueOf(item.getSurSympt2())));
             txtSurSymptOth2.setText(item.getSurSymptOth2());
             spnSurSympt3.setSelection(Global.SpinnerItemPositionAnyLength(spnSurSympt3, String.valueOf(item.getSurSympt3())));
             txtSurSymptOth3.setText(item.getSurSymptOth3());
             spnSurSympt4.setSelection(Global.SpinnerItemPositionAnyLength(spnSurSympt4, String.valueOf(item.getSurSympt4())));
             txtSurSymptOth4.setText(item.getSurSymptOth4());
             spnSurSympt5.setSelection(Global.SpinnerItemPositionAnyLength(spnSurSympt5, String.valueOf(item.getSurSympt5())));
             txtSurSymptOth5.setText(item.getSurSymptOth5());
             spnSurSympt6.setSelection(Global.SpinnerItemPositionAnyLength(spnSurSympt6, String.valueOf(item.getSurSympt6())));
             txtSurSymptOth6.setText(item.getSurSymptOth6());
             spnSurSympt7.setSelection(Global.SpinnerItemPositionAnyLength(spnSurSympt7, String.valueOf(item.getSurSympt7())));
             txtSurSymptOth7.setText(item.getSurSymptOth7());
             txtSDurFever.setText(String.valueOf(item.getSDurFever()));
             spnSPHosNam.setSelection(Global.SpinnerItemPositionAnyLength(spnSPHosNam, String.valueOf(item.getSPHosNam())));
             txtSPHosOth.setText(item.getSPHosOth());
             spnSDisDr.setSelection(Global.SpinnerItemPositionAnyLength(spnSDisDr, String.valueOf(item.getSDisDr())));
             txtSDisDrOth.setText(item.getSDisDrOth());
             String[] d_rdogrpSReco = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpSReco.length; i++)
             {
                 if (String.valueOf(item.getSReco()).equals(String.valueOf(d_rdogrpSReco[i])))
                 {
                     rb = (RadioButton)rdogrpSReco.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtSDurReco.setText(String.valueOf(item.getSDurReco()));
             String[] d_rdogrpSInReco = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpSInReco.length; i++)
             {
                 if (String.valueOf(item.getSInReco()).equals(String.valueOf(d_rdogrpSInReco[i])))
                 {
                     rb = (RadioButton)rdogrpSInReco.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtSInRecoOth.setText(item.getSInRecoOth());
             String[] d_rdogrpSInReco2 = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpSInReco2.length; i++)
             {
                 if (String.valueOf(item.getSInReco2()).equals(String.valueOf(d_rdogrpSInReco2[i])))
                 {
                     rb = (RadioButton)rdogrpSInReco2.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtSInRecoOth2.setText(item.getSInRecoOth2());
             txtSAboIll.setText(item.getSAboIll());
           }
        }
        catch(Exception  e)
        {
            Connection.MessageBox(EmergencyOperation .this, e.getMessage());
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


              dtpDate = (EditText)findViewById(R.id.dtpSDtHos);
             if (VariableID.equals("btnSDtHos"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpSDtHos);
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