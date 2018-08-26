
 package org.hcus_hhinterview;


 //Android Manifest Code
 //<activity android:name=".Knowledge_DSH_SSF" android:label="Knowledge_DSH_SSF" />
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
 import data_model.Knowledge_DSH_SSF_DataModel;

 public class Knowledge_DSH_SSF extends Activity {
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
         LinearLayout secKnowledgeDSHSSF;
         View lineKnowledgeDSHSSF;
         LinearLayout secDSH;
         View lineDSH;
         TextView VlblDSH;
         RadioGroup rdogrpDSH;
         
         RadioButton rdoDSH1;
         RadioButton rdoDSH2;
         LinearLayout secDSHway;
         View lineDSHway;
         TextView VlblDSHway;
         Spinner spnDSHway;
         LinearLayout secDSHwayOth;
         View lineDSHwayOth;
         TextView VlblDSHwayOth;
         EditText txtDSHwayOth;
         LinearLayout secReachDSH;
         View lineReachDSH;
         TextView VlblReachDSH;
         EditText txtReachDSH;
         LinearLayout secSSF;
         View lineSSF;
         TextView VlblSSF;
         RadioGroup rdogrpSSF;
         
         RadioButton rdoSSF1;
         RadioButton rdoSSF2;
         RadioButton rdoSSF3;
         LinearLayout secSSFway;
         View lineSSFway;
         TextView VlblSSFway;
         Spinner spnSSFway;
         LinearLayout secSSFwayOth;
         View lineSSFwayOth;
         TextView VlblSSFwayOth;
         EditText txtSSFwayOth;
         LinearLayout secReachSSF;
         View lineReachSSF;
         TextView VlblReachSSF;
         EditText txtReachSSF;

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
         setContentView(R.layout.knowledge_dsh_ssf);
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

         TableName = "Knowledge_DSH_SSF";

         //turnGPSOn();

         //GPS Location
         //FindLocation();
         // Double.toString(currentLatitude);
         // Double.toString(currentLongitude);
         lblHeading = (TextView)findViewById(R.id.lblHeading);

         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(Knowledge_DSH_SSF.this);
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
         secKnowledgeDSHSSF=(LinearLayout)findViewById(R.id.secKnowledgeDSHSSF);
         lineKnowledgeDSHSSF=(View)findViewById(R.id.lineKnowledgeDSHSSF);
         secDSH=(LinearLayout)findViewById(R.id.secDSH);
         lineDSH=(View)findViewById(R.id.lineDSH);
         VlblDSH = (TextView) findViewById(R.id.VlblDSH);
         rdogrpDSH = (RadioGroup) findViewById(R.id.rdogrpDSH);
         
         rdoDSH1 = (RadioButton) findViewById(R.id.rdoDSH1);
         rdoDSH2 = (RadioButton) findViewById(R.id.rdoDSH2);


         txtUNCode.setText(UNCODE);
         txtStructureNo.setText(STRUCTURENO);
         txtHouseholdSl.setText(HOUSEHOLDSL);
         txtVisitNo.setText(VISITNO);
         rdogrpDSH.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpDSH = new String[] {"1","2"};
             for (int i = 0; i < rdogrpDSH.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpDSH.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpDSH[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secDSHway.setVisibility(View.GONE);
                    lineDSHway.setVisibility(View.GONE);
                    spnDSHway.setSelection(0);
                    secDSHwayOth.setVisibility(View.GONE);
                    lineDSHwayOth.setVisibility(View.GONE);
                    txtDSHwayOth.setText("");
                    secReachDSH.setVisibility(View.GONE);
                    lineReachDSH.setVisibility(View.GONE);
                    txtReachDSH.setText("");
             }
             else
             {
                    secDSHway.setVisibility(View.VISIBLE);
                    lineDSHway.setVisibility(View.VISIBLE);
                    secReachDSH.setVisibility(View.VISIBLE);
                    lineReachDSH.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secDSHway=(LinearLayout)findViewById(R.id.secDSHway);
         lineDSHway=(View)findViewById(R.id.lineDSHway);
         VlblDSHway=(TextView) findViewById(R.id.VlblDSHway);
         spnDSHway=(Spinner) findViewById(R.id.spnDSHway);
         List<String> listDSHway = new ArrayList<String>();
         
         listDSHway.add("");
         listDSHway.add("1-পায়ে হেঁটে (By walking)");
         listDSHway.add("2-রিক্সায়(Rickshaw)");
         listDSHway.add("3-বেবিটেক্সিতে/সি এন জি (Babytaxi/CNG)");
         listDSHway.add("4-টেক্সি ক্যাবে (Taxicab)");
         listDSHway.add("5-বাসে (By bus)");
         listDSHway.add("6-ব্যক্তিগত গাড়ীতে (নিজস্ব/অন্য কারো) (Private car (own/someone else’s))");
         listDSHway.add("97-অন্যান্য (Others)");
         listDSHway.add("98-জানি না (Don’t know)");
         ArrayAdapter<String> adptrDSHway= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listDSHway);
         spnDSHway.setAdapter(adptrDSHway);

         spnDSHway.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnDSHway.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnDSHway.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("1"))
                 {
                    secDSHwayOth.setVisibility(View.GONE);
                    lineDSHwayOth.setVisibility(View.GONE);
                    txtDSHwayOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("2"))
                 {
                    secDSHwayOth.setVisibility(View.GONE);
                    lineDSHwayOth.setVisibility(View.GONE);
                    txtDSHwayOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("3"))
                 {
                    secDSHwayOth.setVisibility(View.GONE);
                    lineDSHwayOth.setVisibility(View.GONE);
                    txtDSHwayOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("4"))
                 {
                    secDSHwayOth.setVisibility(View.GONE);
                    lineDSHwayOth.setVisibility(View.GONE);
                    txtDSHwayOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("5"))
                 {
                    secDSHwayOth.setVisibility(View.GONE);
                    lineDSHwayOth.setVisibility(View.GONE);
                    txtDSHwayOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("6"))
                 {
                    secDSHwayOth.setVisibility(View.GONE);
                    lineDSHwayOth.setVisibility(View.GONE);
                    txtDSHwayOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("98"))
                 {
                    secDSHwayOth.setVisibility(View.GONE);
                    lineDSHwayOth.setVisibility(View.GONE);
                    txtDSHwayOth.setText("");
                 }
                 else
                 {
                    secDSHwayOth.setVisibility(View.VISIBLE);
                    lineDSHwayOth.setVisibility(View.VISIBLE);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secDSHwayOth=(LinearLayout)findViewById(R.id.secDSHwayOth);
         lineDSHwayOth=(View)findViewById(R.id.lineDSHwayOth);
         VlblDSHwayOth=(TextView) findViewById(R.id.VlblDSHwayOth);
         txtDSHwayOth=(EditText) findViewById(R.id.txtDSHwayOth);
         secReachDSH=(LinearLayout)findViewById(R.id.secReachDSH);
         lineReachDSH=(View)findViewById(R.id.lineReachDSH);
         VlblReachDSH=(TextView) findViewById(R.id.VlblReachDSH);
         txtReachDSH=(EditText) findViewById(R.id.txtReachDSH);
         secSSF=(LinearLayout)findViewById(R.id.secSSF);
         lineSSF=(View)findViewById(R.id.lineSSF);
         VlblSSF = (TextView) findViewById(R.id.VlblSSF);
         rdogrpSSF = (RadioGroup) findViewById(R.id.rdogrpSSF);
         
         rdoSSF1 = (RadioButton) findViewById(R.id.rdoSSF1);
         rdoSSF2 = (RadioButton) findViewById(R.id.rdoSSF2);
         rdoSSF3 = (RadioButton) findViewById(R.id.rdoSSF3);
         rdogrpSSF.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpSSF = new String[] {"1","2",""};
             for (int i = 0; i < rdogrpSSF.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpSSF.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpSSF[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secSSFway.setVisibility(View.GONE);
                    lineSSFway.setVisibility(View.GONE);
                    spnSSFway.setSelection(0);
                    secSSFwayOth.setVisibility(View.GONE);
                    lineSSFwayOth.setVisibility(View.GONE);
                    txtSSFwayOth.setText("");
                    secReachSSF.setVisibility(View.GONE);
                    lineReachSSF.setVisibility(View.GONE);
                    txtReachSSF.setText("");
             }
             else
             {
                    secSSFway.setVisibility(View.VISIBLE);
                    lineSSFway.setVisibility(View.VISIBLE);
                    secReachSSF.setVisibility(View.VISIBLE);
                    lineReachSSF.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secSSFway=(LinearLayout)findViewById(R.id.secSSFway);
         lineSSFway=(View)findViewById(R.id.lineSSFway);
         VlblSSFway=(TextView) findViewById(R.id.VlblSSFway);
         spnSSFway=(Spinner) findViewById(R.id.spnSSFway);
         List<String> listSSFway = new ArrayList<String>();
         
         listSSFway.add("");
         listSSFway.add("1-পায়ে হেঁটে (By walking)");
         listSSFway.add("2-রিক্সায়(Rickshaw)");
         listSSFway.add("3-বেবিটেক্সিতে/সি এন জি (Babytaxi/CNG)");
         listSSFway.add("4-টেক্সি ক্যাবে (Taxicab)");
         listSSFway.add("5-বাসে (By bus)");
         listSSFway.add("6-ব্যক্তিগত গাড়ীতে (নিজস্ব/অন্য কারো) (Private car (own/someone else’s))");
         listSSFway.add("97-অন্যান্য (Others)");
         listSSFway.add("98-জানি না (Don’t know)");
         ArrayAdapter<String> adptrSSFway= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listSSFway);
         spnSSFway.setAdapter(adptrSSFway);

         spnSSFway.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnSSFway.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnSSFway.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("1"))
                 {
                    secSSFwayOth.setVisibility(View.GONE);
                    lineSSFwayOth.setVisibility(View.GONE);
                    txtSSFwayOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("2"))
                 {
                    secSSFwayOth.setVisibility(View.GONE);
                    lineSSFwayOth.setVisibility(View.GONE);
                    txtSSFwayOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("3"))
                 {
                    secSSFwayOth.setVisibility(View.GONE);
                    lineSSFwayOth.setVisibility(View.GONE);
                    txtSSFwayOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("4"))
                 {
                    secSSFwayOth.setVisibility(View.GONE);
                    lineSSFwayOth.setVisibility(View.GONE);
                    txtSSFwayOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("5"))
                 {
                    secSSFwayOth.setVisibility(View.GONE);
                    lineSSFwayOth.setVisibility(View.GONE);
                    txtSSFwayOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("6"))
                 {
                    secSSFwayOth.setVisibility(View.GONE);
                    lineSSFwayOth.setVisibility(View.GONE);
                    txtSSFwayOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("98"))
                 {
                    secSSFwayOth.setVisibility(View.GONE);
                    lineSSFwayOth.setVisibility(View.GONE);
                    txtSSFwayOth.setText("");
                 }
                 else
                 {
                    secSSFwayOth.setVisibility(View.VISIBLE);
                    lineSSFwayOth.setVisibility(View.VISIBLE);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secSSFwayOth=(LinearLayout)findViewById(R.id.secSSFwayOth);
         lineSSFwayOth=(View)findViewById(R.id.lineSSFwayOth);
         VlblSSFwayOth=(TextView) findViewById(R.id.VlblSSFwayOth);
         txtSSFwayOth=(EditText) findViewById(R.id.txtSSFwayOth);
         secReachSSF=(LinearLayout)findViewById(R.id.secReachSSF);
         lineReachSSF=(View)findViewById(R.id.lineReachSSF);
         VlblReachSSF=(TextView) findViewById(R.id.VlblReachSSF);
         txtReachSSF=(EditText) findViewById(R.id.txtReachSSF);





         //Hide all skip variables
         secDSHway.setVisibility(View.GONE);
         lineDSHway.setVisibility(View.GONE);
         secDSHwayOth.setVisibility(View.GONE);
         lineDSHwayOth.setVisibility(View.GONE);
         secReachDSH.setVisibility(View.GONE);
         lineReachDSH.setVisibility(View.GONE);
         secDSHwayOth.setVisibility(View.GONE);
         lineDSHwayOth.setVisibility(View.GONE);
         secDSHwayOth.setVisibility(View.GONE);
         lineDSHwayOth.setVisibility(View.GONE);
         secDSHwayOth.setVisibility(View.GONE);
         lineDSHwayOth.setVisibility(View.GONE);
         secDSHwayOth.setVisibility(View.GONE);
         lineDSHwayOth.setVisibility(View.GONE);
         secDSHwayOth.setVisibility(View.GONE);
         lineDSHwayOth.setVisibility(View.GONE);
         secDSHwayOth.setVisibility(View.GONE);
         lineDSHwayOth.setVisibility(View.GONE);
         secDSHwayOth.setVisibility(View.GONE);
         lineDSHwayOth.setVisibility(View.GONE);
         secSSFway.setVisibility(View.GONE);
         lineSSFway.setVisibility(View.GONE);
         secSSFwayOth.setVisibility(View.GONE);
         lineSSFwayOth.setVisibility(View.GONE);
         secReachSSF.setVisibility(View.GONE);
         lineReachSSF.setVisibility(View.GONE);
         secSSFwayOth.setVisibility(View.GONE);
         lineSSFwayOth.setVisibility(View.GONE);
         secSSFwayOth.setVisibility(View.GONE);
         lineSSFwayOth.setVisibility(View.GONE);
         secSSFwayOth.setVisibility(View.GONE);
         lineSSFwayOth.setVisibility(View.GONE);
         secSSFwayOth.setVisibility(View.GONE);
         lineSSFwayOth.setVisibility(View.GONE);
         secSSFwayOth.setVisibility(View.GONE);
         lineSSFwayOth.setVisibility(View.GONE);
         secSSFwayOth.setVisibility(View.GONE);
         lineSSFwayOth.setVisibility(View.GONE);
         secSSFwayOth.setVisibility(View.GONE);
         lineSSFwayOth.setVisibility(View.GONE);


        Button cmdSave = (Button) findViewById(R.id.cmdSave);
        cmdSave.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) { 
            DataSave();
        }});
     }
     catch(Exception  e)
     {
         Connection.MessageBox(Knowledge_DSH_SSF.this, e.getMessage());
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
             Connection.MessageBox(Knowledge_DSH_SSF.this, "Required field: Ward.");
             txtUNCode.requestFocus(); 
             return;	
           }
         else if(txtStructureNo.getText().toString().length()==0 & secStructureNo.isShown())
           {
             Connection.MessageBox(Knowledge_DSH_SSF.this, "Required field: Structure No.");
             txtStructureNo.requestFocus(); 
             return;	
           }
         else if(txtHouseholdSl.getText().toString().length()==0 & secHouseholdSl.isShown())
           {
             Connection.MessageBox(Knowledge_DSH_SSF.this, "Required field: Household Sl.");
             txtHouseholdSl.requestFocus(); 
             return;	
           }
         else if(txtVisitNo.getText().toString().length()==0 & secVisitNo.isShown())
           {
             Connection.MessageBox(Knowledge_DSH_SSF.this, "Required field: Visit No.");
             txtVisitNo.requestFocus(); 
             return;	
           }
         
         else if(!rdoDSH1.isChecked() & !rdoDSH2.isChecked() & secDSH.isShown())
           {
              Connection.MessageBox(Knowledge_DSH_SSF.this, "Select anyone options from (আপনি কি ঢাকা শিশু হাসপাতাল কোথায় সে সম্পর্কে বলতে পারবেন? (Do you know where is Dhaka Shishu Hospital located?)).");
              rdoDSH1.requestFocus();
              return;
           }
         else if(spnDSHway.getSelectedItemPosition()==0  & secDSHway.isShown())
           {
             Connection.MessageBox(Knowledge_DSH_SSF.this, "Required field: আপনি যদি ঢাকা শিশু হাসপাতালে যেতে চান, তাহলে কীভাবে যাবনে? (If you have to go to Dhaka Shishu Hospital, how would you go there?).");
             spnDSHway.requestFocus(); 
             return;	
           }
         else if(txtDSHwayOth.getText().toString().length()==0 & secDSHwayOth.isShown())
           {
             Connection.MessageBox(Knowledge_DSH_SSF.this, "Required field: অন্যান্য উল্লেখ করুন  (Others Specify).");
             txtDSHwayOth.requestFocus(); 
             return;	
           }
         else if(txtReachDSH.getText().toString().length()==0 & secReachDSH.isShown())
           {
             Connection.MessageBox(Knowledge_DSH_SSF.this, "Required field: আপনার বাড়ী থেকে ঢাকা শিশু হাসপাতালে যেতে কত মিনিট সময় লাগবে?  (How many minutes would it.");
             txtReachDSH.requestFocus(); 
             return;	
           }
         
         else if(!rdoSSF1.isChecked() & !rdoSSF2.isChecked() & !rdoSSF3.isChecked() & secSSF.isShown())
           {
              Connection.MessageBox(Knowledge_DSH_SSF.this, "Select anyone options from (আপনি কি শিশু স্বাস্থ্য ফাউন্ডেশন (মিরপুর শিশু) হাসপাতাল কোথায় সে সম্পর্কে বলতে পারবেন?  (Do you know ).");
              rdoSSF1.requestFocus();
              return;
           }
         else if(spnSSFway.getSelectedItemPosition()==0  & secSSFway.isShown())
           {
             Connection.MessageBox(Knowledge_DSH_SSF.this, "Required field: আপনি যদি শিশু স্বাস্থ্য ফাউন্ডেশন (মিরপুর শিশু) হাসপাতালে যেতে চান, তাহলে কীভাবে যাবনে? (If you have to go to Shishu Shastho Foundation (Mirpur Shishu Hospital), how would you go there?).");
             spnSSFway.requestFocus(); 
             return;	
           }
         else if(txtSSFwayOth.getText().toString().length()==0 & secSSFwayOth.isShown())
           {
             Connection.MessageBox(Knowledge_DSH_SSF.this, "Required field: অন্যান্য উল্লেখ করুন  (Others Specify).");
             txtSSFwayOth.requestFocus(); 
             return;	
           }
         else if(txtReachSSF.getText().toString().length()==0 & secReachSSF.isShown())
           {
             Connection.MessageBox(Knowledge_DSH_SSF.this, "Required field: আপনার বাড়ী থেকে শিশু স্বাস্থ্য ফাউন্ডেশন (মিরপুর শিশু) হাসপাতালে যেতে কত মিনিট সময় লাগবে? (How many minutes would it take to reach Shishu Shastho Foundation (Mirpur Shishu Hospital) from your house?).");
             txtReachSSF.requestFocus(); 
             return;	
           }
 
         String SQL = "";
         RadioButton rb;

         Knowledge_DSH_SSF_DataModel objSave = new Knowledge_DSH_SSF_DataModel();
         objSave.setUNCode(txtUNCode.getText().toString());
         objSave.setStructureNo(txtStructureNo.getText().toString());
         objSave.setHouseholdSl(txtHouseholdSl.getText().toString());
         objSave.setVisitNo(txtVisitNo.getText().toString());
         String[] d_rdogrpDSH = new String[] {"1","2"};
         objSave.setDSH(0);
         for (int i = 0; i < rdogrpDSH.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpDSH.getChildAt(i);
             if (rb.isChecked()) objSave.setDSH(Integer.valueOf(d_rdogrpDSH[i]));
         }

         objSave.setDSHway(Integer.valueOf(spnDSHway.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnDSHway.getSelectedItem().toString(), "-")));
         objSave.setDSHwayOth(txtDSHwayOth.getText().toString());
         objSave.setReachDSH(txtReachDSH.getText().toString());
         String[] d_rdogrpSSF = new String[] {"1","2",""};
         objSave.setSSF(0);
         for (int i = 0; i < rdogrpSSF.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpSSF.getChildAt(i);
             if (rb.isChecked()) objSave.setSSF(Integer.valueOf(d_rdogrpSSF[i]));
         }

         objSave.setSSFway(Integer.valueOf(spnSSFway.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnSSFway.getSelectedItem().toString(), "-")));
         objSave.setSSFwayOth(txtSSFwayOth.getText().toString());
         objSave.setReachSSF(txtReachSSF.getText().toString());
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

             Connection.MessageBox(Knowledge_DSH_SSF.this, "Saved Successfully");
         }
         else{
             Connection.MessageBox(Knowledge_DSH_SSF.this, status);
             return;
         }
     }
     catch(Exception  e)
     {
         Connection.MessageBox(Knowledge_DSH_SSF.this, e.getMessage());
         return;
     }
 }

 private void DataSearch(String UNCode, String StructureNo, String HouseholdSl, String VisitNo)
     {
       try
        {
     
           RadioButton rb;
           Knowledge_DSH_SSF_DataModel d = new Knowledge_DSH_SSF_DataModel();
           String SQL = "Select * from "+ TableName +"  Where UNCode='"+ UNCode +"' and StructureNo='"+ StructureNo +"' and HouseholdSl='"+ HouseholdSl +"' and VisitNo='"+ VisitNo +"'";
           List<Knowledge_DSH_SSF_DataModel> data = d.SelectAll(this, SQL);
           for(Knowledge_DSH_SSF_DataModel item : data){
             txtUNCode.setText(item.getUNCode());
             txtStructureNo.setText(item.getStructureNo());
             txtHouseholdSl.setText(item.getHouseholdSl());
             txtVisitNo.setText(item.getVisitNo());
             String[] d_rdogrpDSH = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpDSH.length; i++)
             {
                 if (String.valueOf(item.getDSH()).equals(String.valueOf(d_rdogrpDSH[i])))
                 {
                     rb = (RadioButton)rdogrpDSH.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             spnDSHway.setSelection(Global.SpinnerItemPositionAnyLength(spnDSHway, String.valueOf(item.getDSHway())));
             txtDSHwayOth.setText(item.getDSHwayOth());
             txtReachDSH.setText(item.getReachDSH());
             String[] d_rdogrpSSF = new String[] {"1","2",""};
             for (int i = 0; i < d_rdogrpSSF.length; i++)
             {
                 if (String.valueOf(item.getSSF()).equals(String.valueOf(d_rdogrpSSF[i])))
                 {
                     rb = (RadioButton)rdogrpSSF.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             spnSSFway.setSelection(Global.SpinnerItemPositionAnyLength(spnSSFway, String.valueOf(item.getSSFway())));
             txtSSFwayOth.setText(item.getSSFwayOth());
             txtReachSSF.setText(item.getReachSSF());
           }
        }
        catch(Exception  e)
        {
            Connection.MessageBox(Knowledge_DSH_SSF.this, e.getMessage());
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

        dtpDate = (EditText)findViewById(R.id.dtpDataCollDate);
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