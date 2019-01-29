
 package org.hcus_hhinterview;


 //Android Manifest Code
 //<activity android:name=".Typhoid_Extra" android:label="Typhoid_Extra" />
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
 import data_model.Typhoid_Extra_DataModel;

 import android.widget.AutoCompleteTextView;
 import android.support.v4.content.ContextCompat;

 public class Typhoid_Extra extends Activity {
    //Disabled Back/Home key
    //--------------------------------------------------------------------------------------------------
    @Override 
    public boolean onKeyDown(int iKeyCode, KeyEvent event)
    {
        if(iKeyCode == KeyEvent.KEYCODE_BACK || iKeyCode == KeyEvent.KEYCODE_HOME) 
             { return false; }
        else { return true;  }
    }

    boolean networkAvailable=false;
    Location currentLocation; 
    double currentLatitude,currentLongitude; 
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

     LinearLayout secPhone;
     View linePhone;
     TextView VlblPhone;
     EditText txtPhone;

     TextView txtChildName;

    LinearLayout secTAboIll;
    View lineTAboIll;
    TextView VlblTAboIll;
    EditText txtTAboIll;

    static int MODULEID   = 0;
    static int LANGUAGEID = 0;
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
    static String CHILDNAME = "";

 public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
   try
     {
         setContentView(R.layout.typhoid_extra);
         getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

         C = new Connection(this);
         g = Global.getInstance();

         STARTTIME = g.CurrentTime24();
//         DEVICEID  = sp.getValue(this, "deviceid");
         ENTRYUSER = sp.getValue(this, "userid");

         IDbundle = getIntent().getExtras();
         UNCODE = IDbundle.getString("UNCode");
         STRUCTURENO = IDbundle.getString("StructureNo");
         HOUSEHOLDSL = IDbundle.getString("HouseholdSl");
         VISITNO = IDbundle.getString("VisitNo");
         MEMSL = IDbundle.getString("MemSl");
         DEVICEID = IDbundle.getString("DeviceID");
         CHILDNAME = IDbundle.getString("ChildName");

         txtChildName=findViewById(R.id.txtChildName);
         txtChildName.setText(CHILDNAME);
         txtChildName.setEnabled(false);

         TableName = "Typhoid_Extra";
         MODULEID = 0;
//         LANGUAGEID = Integer.parseInt(sp.getValue(this, "languageid"));
         lblHeading = (TextView)findViewById(R.id.lblHeading);

         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(Typhoid_Extra.this);
                 adb.setTitle("Close");
                 adb.setMessage("Do you want to close this form[Yes/No]?");
                 adb.setNegativeButton("No", null);
                 adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                     public void onClick(DialogInterface dialog, int which) {
                         finish();
                     }});
                 adb.show();
             }});

        Initialization();
//        Connection.LocalizeLanguage(Typhoid_Extra.this, MODULEID, LANGUAGEID);





         //Hide all skip variables
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
         secHospName_Oth.setVisibility(View.GONE);
         lineHospName_Oth.setVisibility(View.GONE);
         secHaveRecordsLabel.setVisibility(View.GONE);
         lineHaveRecordsLabel.setVisibility(View.GONE);
         secHospName_Oth.setVisibility(View.GONE);
         lineHospName_Oth.setVisibility(View.GONE);
         secHaveRecordsLabel.setVisibility(View.GONE);
         lineHaveRecordsLabel.setVisibility(View.GONE);
         secHospName_Oth.setVisibility(View.GONE);
         lineHospName_Oth.setVisibility(View.GONE);
         secHaveRecordsLabel.setVisibility(View.GONE);
         lineHaveRecordsLabel.setVisibility(View.GONE);
         secHospName_Oth.setVisibility(View.GONE);
         lineHospName_Oth.setVisibility(View.GONE);
         secHaveRecordsLabel.setVisibility(View.GONE);
         lineHaveRecordsLabel.setVisibility(View.GONE);
         secHospName_Oth.setVisibility(View.GONE);
         lineHospName_Oth.setVisibility(View.GONE);
         secHaveRecordsLabel.setVisibility(View.GONE);
         lineHaveRecordsLabel.setVisibility(View.GONE);
         secDidRecordMatch2.setVisibility(View.GONE);
         lineDidRecordMatch2.setVisibility(View.GONE);


        DataSearch(UNCODE, STRUCTURENO, HOUSEHOLDSL, VISITNO, MEMSL);


        Button cmdSave = (Button) findViewById(R.id.cmdSave);
        cmdSave.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) { 
            DataSave();
        }});
     }
     catch(Exception  e)
     {
         Connection.MessageBox(Typhoid_Extra.this, e.getMessage());
         return;
     }
 }

 private void Initialization()
 {
   try
     {
         secUNCode=(LinearLayout)findViewById(R.id.secUNCode);
         lineUNCode=(View)findViewById(R.id.lineUNCode);
         VlblUNCode=(TextView) findViewById(R.id.VlblUNCode);
         txtUNCode=(EditText) findViewById(R.id.txtUNCode);
         txtUNCode.setText(UNCODE);
         txtUNCode.setEnabled(false);
         secStructureNo=(LinearLayout)findViewById(R.id.secStructureNo);
         lineStructureNo=(View)findViewById(R.id.lineStructureNo);
         VlblStructureNo=(TextView) findViewById(R.id.VlblStructureNo);
         txtStructureNo=(EditText) findViewById(R.id.txtStructureNo);
         txtStructureNo.setText(STRUCTURENO);
         txtStructureNo.setEnabled(false);
         secHouseholdSl=(LinearLayout)findViewById(R.id.secHouseholdSl);
         lineHouseholdSl=(View)findViewById(R.id.lineHouseholdSl);
         VlblHouseholdSl=(TextView) findViewById(R.id.VlblHouseholdSl);
         txtHouseholdSl=(EditText) findViewById(R.id.txtHouseholdSl);
         txtHouseholdSl.setText(HOUSEHOLDSL);
         txtHouseholdSl.setEnabled(false);
         secVisitNo=(LinearLayout)findViewById(R.id.secVisitNo);
         lineVisitNo=(View)findViewById(R.id.lineVisitNo);
         VlblVisitNo=(TextView) findViewById(R.id.VlblVisitNo);
         txtVisitNo=(EditText) findViewById(R.id.txtVisitNo);
         txtVisitNo.setText(VISITNO);
         txtVisitNo.setEnabled(false);
         secMemSl=(LinearLayout)findViewById(R.id.secMemSl);
         lineMemSl=(View)findViewById(R.id.lineMemSl);
         VlblMemSl=(TextView) findViewById(R.id.VlblMemSl);
         txtMemSl=(EditText) findViewById(R.id.txtMemSl);
         txtMemSl.setText(MEMSL);
         txtMemSl.setEnabled(false);
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
                    spnHospName.setSelection(0);
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
                    spnHospName.setSelection(0);
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
             else
             {
                    secHospNameLabel.setVisibility(View.VISIBLE);
                    lineHospNameLabel.setVisibility(View.VISIBLE);
                    secHospName.setVisibility(View.VISIBLE);
                    lineHospName.setVisibility(View.VISIBLE);
//                    secHospName_Oth.setVisibility(View.VISIBLE);
//                    lineHospName_Oth.setVisibility(View.VISIBLE);
                    secHaveRecordsLabel.setVisibility(View.VISIBLE);
                    lineHaveRecordsLabel.setVisibility(View.VISIBLE);
                    secHaveRecords.setVisibility(View.VISIBLE);
                    lineHaveRecords.setVisibility(View.VISIBLE);
                    secDaysOfHosp.setVisibility(View.VISIBLE);
                    lineDaysOfHosp.setVisibility(View.VISIBLE);
                    secDaysOfHospDK.setVisibility(View.VISIBLE);
                    lineDaysOfHospDK.setVisibility(View.VISIBLE);
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
             if (spnHospName.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnHospName.getSelectedItem().toString(), "-");
             }

             if(spnData.equalsIgnoreCase("77"))
             {
                 secHospName_Oth.setVisibility(View.VISIBLE);
                 lineHospName_Oth.setVisibility(View.VISIBLE);
             }else
             {
                 secHospName_Oth.setVisibility(View.GONE);
                 lineHospName_Oth.setVisibility(View.GONE);
                 txtHospName_Oth.setText("");
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

         secPhone=(LinearLayout)findViewById(R.id.secPhone);
         linePhone=(View)findViewById(R.id.linePhone);
         VlblPhone=(TextView) findViewById(R.id.VlblPhone);
         txtPhone=(EditText) findViewById(R.id.txtPhone);

         secTAboIll=(LinearLayout)findViewById(R.id.secTAboIll);
         lineTAboIll=(View)findViewById(R.id.lineTAboIll);
         VlblTAboIll=(TextView) findViewById(R.id.VlblTAboIll);
         txtTAboIll=(EditText) findViewById(R.id.txtTAboIll);

         txtDaysOfHosp.addTextChangedListener(new TextWatcher() {
             @Override
             public void beforeTextChanged(CharSequence s, int start, int count, int after) {

             }

             @Override
             public void onTextChanged(CharSequence s, int start, int before, int count) {
                 if(txtDaysOfHosp.getText().length()>0)
                 {
                     chkDaysOfHospDK.setChecked(false);
                 }
             }

             @Override
             public void afterTextChanged(Editable s) {

             }
         });

         chkDaysOfHospDK.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if(isChecked)
                 {
                     txtDaysOfHosp.setText("");
                 }
             }
         });

     }
     catch(Exception  e)
     {
         Connection.MessageBox(Typhoid_Extra.this, e.getMessage());
         return;
     }
 }

 private void DataSave()
 {
   try
     {
         String ValidationMSG = ValidationCheck();
         if(ValidationMSG.length()>0)
         {
         	Connection.MessageBox(Typhoid_Extra.this, ValidationMSG);
         	return;
         }
 
         String SQL = "";
         RadioButton rb;

         Typhoid_Extra_DataModel objSave = new Typhoid_Extra_DataModel();
         objSave.setUNCode(txtUNCode.getText().toString());
         objSave.setStructureNo(txtStructureNo.getText().toString());
         objSave.setHouseholdSl(txtHouseholdSl.getText().toString());
         objSave.setVisitNo(txtVisitNo.getText().toString());
         objSave.setMemSl(txtMemSl.getText().toString());
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
         objSave.setPhone(txtPhone.getText().toString());
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

             Connection.MessageBox(Typhoid_Extra.this, "Saved Successfully");
         }
         else{
             Connection.MessageBox(Typhoid_Extra.this, status);
             return;
         }
     }
     catch(Exception  e)
     {
         Connection.MessageBox(Typhoid_Extra.this, e.getMessage());
         return;
     }
 }

 private String ValidationCheck()
 {
   String ValidationMsg = "";
   try
     {
         ResetSectionColor();
         if(txtUNCode.getText().toString().length()==0 & secUNCode.isShown())
           {
             ValidationMsg += "\nRequired field: Ward No.";
             secUNCode.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.color_Section_Highlight));
           }
         if(txtStructureNo.getText().toString().length()==0 & secStructureNo.isShown())
           {
             ValidationMsg += "\nRequired field: Structure No.";
             secStructureNo.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.color_Section_Highlight));
           }
         if(txtHouseholdSl.getText().toString().length()==0 & secHouseholdSl.isShown())
           {
             ValidationMsg += "\nRequired field: Household Sl.";
             secHouseholdSl.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.color_Section_Highlight));
           }
         if(txtVisitNo.getText().toString().length()==0 & secVisitNo.isShown())
           {
             ValidationMsg += "\nRequired field: Visit No.";
             secVisitNo.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.color_Section_Highlight));
           }
         if(txtMemSl.getText().toString().length()==0 & secMemSl.isShown())
           {
             ValidationMsg += "\nRequired field: Member Serial.";
             secMemSl.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.color_Section_Highlight));
           }
         if(!rdoHaveHosp1.isChecked() & !rdoHaveHosp2.isChecked() & !rdoHaveHosp3.isChecked() & secHaveHosp.isShown())
           {
             ValidationMsg += "\n2.19 Required field: গত এক বছরে জ্বর জনিত কোন অসুস্থতার কারনে শিশুটি হাসপাতালে ভর্তি হয়েছিল? (Did he/she have any cases of febrile illness that led to hospitalization in the past year?).";
             secHaveHosp.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.color_Section_Highlight));
           }
         if(spnHospName.getSelectedItemPosition()==0  & secHospName.isShown())
           {
             ValidationMsg += "\n2.19.1 Required field: শিশুকে কোন হাসপাতালে ভর্তি করেছিলেন? (What hospital was he/she taken to?).";
             secHospName.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.color_Section_Highlight));
           }
         if(txtHospName_Oth.getText().toString().length()==0 & secHospName_Oth.isShown())
           {
             ValidationMsg += "\nRequired field: Name of the other hospital.";
             secHospName_Oth.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.color_Section_Highlight));
           }
         if(!rdoHaveRecords1.isChecked() & !rdoHaveRecords2.isChecked() & secHaveRecords.isShown())
           {
             ValidationMsg += "\n2.19.2 Required field: উত্তরদাতা কি হাসপাতালের প্রেসক্রিপশন অথবা অন্য কোন প্রমানাদি/কাগজপত্র দেখাতে পেরেছেন? (Was the respondent able to produce records of this visit?).";
             secHaveRecords.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.color_Section_Highlight));
           }
         if(!rdoDidRecordMatch21.isChecked() & !rdoDidRecordMatch22.isChecked() & secDidRecordMatch2.isShown())
           {
             ValidationMsg += "\n2.19.3 Required field: হাসপাতালের প্রেসক্রিপশন অথবা প্রমানাদি/কাগজপত্র কি শিশু যে হাসপাতাল ভর্তি ছিল সেই হাসপাতালের?  (Did the records match the healthcare facility they stated the person was taken to?).";
             secDidRecordMatch2.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.color_Section_Highlight));
           }
         if(txtDaysOfHosp.getText().toString().length()==0 & secDaysOfHosp.isShown() & !chkDaysOfHospDK.isChecked())
           {
             ValidationMsg += "\n2.19.4 Required field: শিশুটি কত দিন হাসপাতালে ভর্তি ছিল? (How many days was he/she hospitalized?).";
             secDaysOfHosp.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.color_Section_Highlight));
           }
         if(!chkDaysOfHospDK.isChecked()&(secDaysOfHosp.isShown() & (Integer.valueOf(txtDaysOfHosp.getText().toString().length()==0 ? "1" : txtDaysOfHosp.getText().toString()) < 1 || Integer.valueOf(txtDaysOfHosp.getText().toString().length()==0 ? "99" : txtDaysOfHosp.getText().toString()) > 99)))
           {
             ValidationMsg += "\n2.19.4 Value should be between 1 and 99(শিশুটি কত দিন হাসপাতালে ভর্তি ছিল? (How many days was he/she hospitalized?)).";
             secDaysOfHosp.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.color_Section_Highlight));
           }
//         if(txtPhone.getText().toString().length()==0 & secPhone.isShown())
//         {
//             ValidationMsg += "\nRequired field: Phone Number.";
//             secPhone.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.color_Section_Highlight));
//         }
//         if(txtTAboIll.getText().toString().length()==0 & secTAboIll.isShown())
//           {
//             ValidationMsg += "\nRequired field: মন্তব্যঃ টাইফয়েড (Remarks:Typhoid).";
//             secTAboIll.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.color_Section_Highlight));
//           }
     }
     catch(Exception  e)
     {
     }

     return ValidationMsg;
 }

 private void ResetSectionColor()
 {
   try
     {
             secUNCode.setBackgroundColor(Color.WHITE);
             secStructureNo.setBackgroundColor(Color.WHITE);
             secHouseholdSl.setBackgroundColor(Color.WHITE);
             secVisitNo.setBackgroundColor(Color.WHITE);
             secMemSl.setBackgroundColor(Color.WHITE);
             secHaveHosp.setBackgroundColor(Color.WHITE);
             secHospName.setBackgroundColor(Color.WHITE);
             secHospName_Oth.setBackgroundColor(Color.WHITE);
             secHaveRecords.setBackgroundColor(Color.WHITE);
             secDidRecordMatch2.setBackgroundColor(Color.WHITE);
             secDaysOfHosp.setBackgroundColor(Color.WHITE);
             secDaysOfHosp.setBackgroundColor(Color.WHITE);
             secTAboIll.setBackgroundColor(Color.WHITE);
     }
     catch(Exception  e)
     {
     }
 }

 private void DataSearch(String UNCode, String StructureNo, String HouseholdSl, String VisitNo, String MemSl)
     {
       try
        {     
           RadioButton rb;
           Typhoid_Extra_DataModel d = new Typhoid_Extra_DataModel();
           String SQL = "Select * from "+ TableName +"  Where UNCode='"+ UNCode +"' and StructureNo='"+ StructureNo +"' and HouseholdSl='"+ HouseholdSl +"' and VisitNo='"+ VisitNo +"' and MemSl='"+ MemSl +"' and DeviceId='"+DEVICEID+"'";

           List<Typhoid_Extra_DataModel> data = d.SelectAll(this, SQL);
           for(Typhoid_Extra_DataModel item : data){
             txtUNCode.setText(item.getUNCode());
             txtStructureNo.setText(item.getStructureNo());
             txtHouseholdSl.setText(item.getHouseholdSl());
             txtVisitNo.setText(item.getVisitNo());
             txtMemSl.setText(item.getMemSl());
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
               txtPhone.setText(item.getPhone());
             txtTAboIll.setText(item.getTAboIll());
           }
        }
        catch(Exception  e)
        {
            Connection.MessageBox(Typhoid_Extra.this, e.getMessage());
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
      EditText dtpDate = null;


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