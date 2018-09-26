
 package org.hcus_hhinterview;


 //Android Manifest Code
 //<activity android:name=".Household_Interview" android:label="Household_Interview" />
 import java.util.ArrayList;
 import java.util.Calendar;
 import java.util.List;
 import android.app.*;
 import android.app.AlertDialog;
 import android.app.DatePickerDialog;
 import android.app.Dialog;
 import android.app.TimePickerDialog;
 import android.content.Context;
 import android.content.DialogInterface;
 import android.content.Intent;
 import android.content.res.TypedArray;
 import android.graphics.Canvas;
 import android.graphics.Rect;
 import android.graphics.drawable.Drawable;
 import android.location.Location;
 import android.os.PersistableBundle;
 import android.support.annotation.Nullable;
 import android.support.v7.widget.DefaultItemAnimator;
 import android.support.v7.widget.LinearLayoutManager;
 import android.support.v7.widget.RecyclerView;
 import android.text.Editable;
 import android.text.TextWatcher;
 import android.view.KeyEvent;
 import android.os.Bundle;
 import android.view.View;
 import android.widget.CompoundButton;
 import android.widget.LinearLayout;
 import android.view.ViewGroup;
 import android.view.LayoutInflater;
 import android.widget.AdapterView;
 import android.widget.Button;
 import android.widget.CheckBox;
 import android.widget.DatePicker;
 import android.widget.EditText;
 import android.widget.ImageButton;
 import android.widget.RadioButton;
 import android.widget.RadioGroup;
 import android.widget.SimpleAdapter;
 import android.widget.Spinner;
 import android.widget.TextView;
 import android.widget.TimePicker;
 import android.widget.ArrayAdapter;
 import android.view.WindowManager;
 import Utility.*;
 import Common.*;
 import data_model.Household_Interview_DataModel;
 import data_model.Member_DataModel;




 public class Household_Interview extends Member_list {
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


     Member_list member=new Member_list();


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
//    ArrayList<HashMap<String, String>> dataList = new ArrayList<HashMap<String, String>>();
//     private List<Member_DataModel> dataList = new ArrayList<>();
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
         LinearLayout secBasicHHInfo;
         View lineBasicHHInfo;
         LinearLayout secFHeadAvail;
         View lineFHeadAvail;
         TextView VlblFHeadAvail;
         RadioGroup rdogrpFHeadAvail;
         
         RadioButton rdoFHeadAvail1;
         RadioButton rdoFHeadAvail2;
         LinearLayout secRelWithFHead;
         View lineRelWithFHead;
         TextView VlblRelWithFHead;
         Spinner spnRelWithFHead;
         LinearLayout secOthRelWithFHead;
         View lineOthRelWithFHead;
         TextView VlblOthRelWithFHead;
         EditText txtOthRelWithFHead;
         LinearLayout secFirstName;
         View lineFirstName;
         TextView VlblFirstName;
         EditText txtFirstName;
         LinearLayout secEduLevelFHead;
         View lineEduLevelFHead;
         TextView VlblEduLevelFHead;
         Spinner spnEduLevelFHead;
         LinearLayout secEduLevelMHead;
         View lineEduLevelMHead;
         TextView VlblEduLevelMHead;
         Spinner spnEduLevelMHead;
         LinearLayout seclblh1;
         View linelblh1;
         LinearLayout secliveHouseM;
         View lineliveHouseM;
         TextView VlblliveHouseM;
         EditText txtliveHouseM;
         LinearLayout secliveHouseY;
         View lineliveHouseY;
         TextView VlblliveHouseY;
         EditText txtliveHouseY;
         LinearLayout secLiveHH_Mon;
         View lineLiveHH_Mon;
         TextView VlblLiveHH_Mon;
         EditText txtLiveHH_Mon;
         LinearLayout secLiveHH_Year;
         View lineLiveHH_Year;
         TextView VlblLiveHH_Year;
         EditText txtLiveHH_Year;
         LinearLayout secLiveCity_Mon;
         View lineLiveCity_Mon;
         TextView VlblLiveCity_Mon;
         EditText txtLiveCity_Mon;
         LinearLayout secLiveCity_Year;
         View lineLiveCity_Year;
         TextView VlblLiveCity_Year;
         EditText txtLiveCity_Year;
         LinearLayout secHlive12m;
         View lineHlive12m;
         TextView VlblHlive12m;
         RadioGroup rdogrpHlive12m;
         
         RadioButton rdoHlive12m1;
         RadioButton rdoHlive12m2;
         RadioButton rdoHlive12m3;
         LinearLayout secChangedHouse;
         View lineChangedHouse;
         TextView VlblChangedHouse;
         EditText txtChangedHouse;
         LinearLayout secDistHome;
         View lineDistHome;
         TextView VlblDistHome;
         Spinner spnDistHome;
         LinearLayout secChildHcare;
         View lineChildHcare;
         TextView VlblChildHcare;
         Spinner spnChildHcare;
         LinearLayout secChildHcareOth;
         View lineChildHcareOth;
         TextView VlblChildHcareOth;
         EditText txtChildHcareOth;
         LinearLayout secSocioEconomic;
         View lineSocioEconomic;
         LinearLayout secMotherEdu;
         View lineMotherEdu;
         TextView VlblMotherEdu;
         EditText txtMotherEdu;
         LinearLayout secHeadOcp;
         View lineHeadOcp;
         TextView VlblHeadOcp;
         Spinner spnHeadOcp;
         LinearLayout secHeadOcpOth;
         View lineHeadOcpOth;
         TextView VlblHeadOcpOth;
         EditText txtHeadOcpOth;
         LinearLayout secRoom;
         View lineRoom;
         TextView VlblRoom;
         EditText txtRoom;
         LinearLayout secBedRoom;
         View lineBedRoom;
         TextView VlblBedRoom;
         EditText txtBedRoom;
         LinearLayout secHouseholdAccessories;
         View lineHouseholdAccessories;
         LinearLayout secElectricity;
         View lineElectricity;
         TextView VlblElectricity;
         RadioGroup rdogrpElectricity;
         
         RadioButton rdoElectricity1;
         RadioButton rdoElectricity2;
         RadioButton rdoElectricity3;
         RadioButton rdoElectricity4;
         LinearLayout secRadio;
         View lineRadio;
         TextView VlblRadio;
         RadioGroup rdogrpRadio;
         
         RadioButton rdoRadio1;
         RadioButton rdoRadio2;
         RadioButton rdoRadio3;
         RadioButton rdoRadio4;
         LinearLayout secTelevision;
         View lineTelevision;
         TextView VlblTelevision;
         RadioGroup rdogrpTelevision;
         
         RadioButton rdoTelevision1;
         RadioButton rdoTelevision2;
         RadioButton rdoTelevision3;
         RadioButton rdoTelevision4;
         LinearLayout secNonMobileTele;
         View lineNonMobileTele;
         TextView VlblNonMobileTele;
         RadioGroup rdogrpNonMobileTele;
         
         RadioButton rdoNonMobileTele1;
         RadioButton rdoNonMobileTele2;
         RadioButton rdoNonMobileTele3;
         RadioButton rdoNonMobileTele4;
         LinearLayout secComputer;
         View lineComputer;
         TextView VlblComputer;
         RadioGroup rdogrpComputer;
         
         RadioButton rdoComputer1;
         RadioButton rdoComputer2;
         RadioButton rdoComputer3;
         RadioButton rdoComputer4;
         LinearLayout secRefrigerator;
         View lineRefrigerator;
         TextView VlblRefrigerator;
         RadioGroup rdogrpRefrigerator;
         
         RadioButton rdoRefrigerator1;
         RadioButton rdoRefrigerator2;
         RadioButton rdoRefrigerator3;
         RadioButton rdoRefrigerator4;
         LinearLayout secHouseholdMemAccessories;
         View lineHouseholdMemAccessories;
         LinearLayout secWatch;
         View lineWatch;
         TextView VlblWatch;
         RadioGroup rdogrpWatch;
         RadioGroup rdogrpMobilePhone;
         RadioGroup rdogrpBicycle;
         RadioGroup rdogrpMotorcycleScooter;

         
         RadioButton rdoWatch1;
         RadioButton rdoWatch2;
         RadioButton rdoWatch3;
         RadioButton rdoWatch4;
         RadioButton rdoMobilePhone1;
         RadioButton rdoMobilePhone2;
         RadioButton rdoMobilePhone3;
         RadioButton rdoMobilePhone4;
         RadioButton rdoBicycle1;
         RadioButton rdoBicycle2;
         RadioButton rdoBicycle3;
         RadioButton rdoBicycle4;
         RadioButton rdoMotorcycleScooter1;
         RadioButton rdoMotorcycleScooter2;
         RadioButton rdoMotorcycleScooter3;
         RadioButton rdoMotorcycleScooter4;
         LinearLayout secMobilePhone;
         View lineMobilePhone;
         TextView VlblMobilePhone;
//         Spinner spnMobilePhone;
         LinearLayout secBicycle;
         View lineBicycle;
         TextView VlblBicycle;
//         Spinner spnBicycle;
         LinearLayout secMotorcycleScooter;
         View lineMotorcycleScooter;
         TextView VlblMotorcycleScooter;
//         Spinner spnMotorcycleScooter;
         LinearLayout secAnimalDrawnCart;
         View lineAnimalDrawnCart;
         TextView VlblAnimalDrawnCart;
         RadioGroup rdogrpAnimalDrawnCart;
         
         RadioButton rdoAnimalDrawnCart1;
         RadioButton rdoAnimalDrawnCart2;
         RadioButton rdoAnimalDrawnCart3;
         RadioButton rdoAnimalDrawnCart4;
         LinearLayout secCarOrTruck;
         View lineCarOrTruck;
         TextView VlblCarOrTruck;
         RadioGroup rdogrpCarOrTruck;
         
         RadioButton rdoCarOrTruck1;
         RadioButton rdoCarOrTruck2;
         RadioButton rdoCarOrTruck3;
         RadioButton rdoCarOrTruck4;
         LinearLayout secBankAccount;
         View lineBankAccount;
         TextView VlblBankAccount;
         RadioGroup rdogrpBankAccount;
         
         RadioButton rdoBankAccount1;
         RadioButton rdoBankAccount2;
         RadioButton rdoBankAccount3;
         RadioButton rdoBankAccount4;
         LinearLayout secHHOwner;
         View lineHHOwner;
         TextView VlblHHOwner;
         RadioGroup rdogrpHHOwner;
         
         RadioButton rdoHHOwner1;
         RadioButton rdoHHOwner2;
         RadioButton rdoHHOwner3;
         LinearLayout secRentOfDwelling;
         View lineRentOfDwelling;
         TextView VlblRentOfDwelling;
         EditText txtRentOfDwelling;
         LinearLayout secRentOfDwellDK;
         View lineRentOfDwellDK;
         TextView VlblRentOfDwellDK;
         CheckBox chkRentOfDwellDK;
         LinearLayout secConsMatFloor;
         View lineConsMatFloor;
         TextView VlblConsMatFloor;
         Spinner spnConsMatFloor;
         LinearLayout secConsMatFloorOth;
         View lineConsMatFloorOth;
         TextView VlblConsMatFloorOth;
         EditText txtConsMatFloorOth;
         LinearLayout secConsMatWall;
         View lineConsMatWall;
         TextView VlblConsMatWall;
         Spinner spnConsMatWall;
         LinearLayout secConsMatWallOth;
         View lineConsMatWallOth;
         TextView VlblConsMatWallOth;
         EditText txtConsMatWallOth;
         LinearLayout secConsMatRoof;
         View lineConsMatRoof;
         TextView VlblConsMatRoof;
         Spinner spnConsMatRoof;
         LinearLayout secConsMatRoofOth;
         View lineConsMatRoofOth;
         TextView VlblConsMatRoofOth;
         EditText txtConsMatRoofOth;
         LinearLayout secFuel;
         View lineFuel;
         TextView VlblFuel;
         Spinner spnFuel;
         LinearLayout secFuelOth;
         View lineFuelOth;
         TextView VlblFuelOth;
         EditText txtFuelOth;
         LinearLayout secTypeOfToilet;
         View lineTypeOfToilet;
         TextView VlblTypeOfToilet;
         Spinner spnTypeOfToilet;
         LinearLayout secTypeOfToiletOth;
         View lineTypeOfToiletOth;
         TextView VlblTypeOfToiletOth;
         EditText txtTypeOfToiletOth;
         LinearLayout secTypeOfChildToilet;
         View lineTypeOfChildToilet;
         TextView VlblTypeOfChildToilet;
         Spinner spnTypeOfChildToilet;
         LinearLayout secTypeOfChildToiletOth;
         View lineTypeOfChildToiletOth;
         TextView VlblTypeOfChildToiletOth;
         EditText txtTypeOfChildToiletOth;
         LinearLayout secToiletShare;
         View lineToiletShare;
         TextView VlblToiletShare;
         Spinner spnToiletShare;
         LinearLayout secSOfDrinkingWater;
         View lineSOfDrinkingWater;
         TextView VlblSOfDrinkingWater;
         Spinner spnSOfDrinkingWater;
         LinearLayout secTimeToWalkInMin;
         View lineTimeToWalkInMin;
         TextView VlblTimeToWalkInMin;
         EditText txtTimeToWalkInMin;
         LinearLayout secTimeToWalkInHours;
         View lineTimeToWalkInHours;
         TextView VlblTimeToWalkInHours;
         EditText txtTimeToWalkInHours;
         LinearLayout secWeeklyWSupplyInHour;
         View lineWeeklyWSupplyInHour;
         TextView VlblWeeklyWSupplyInHour;
         EditText txtWeeklyWSupplyInHour;
         LinearLayout secWeeklyWSuppHouse;
         View lineWeeklyWSuppHouse;
         TextView VlblWeeklyWSuppHouse;
         EditText txtWeeklyWSuppHouse;
         LinearLayout secTreatDKWater;
         View lineTreatDKWater;
         TextView VlblTreatDKWater;
         RadioGroup rdogrpTreatDKWater;
         
         RadioButton rdoTreatDKWater1;
         RadioButton rdoTreatDKWater2;
         LinearLayout secTreatMeth;
         View lineTreatMeth;
         TextView VlblTreatMeth;
         Spinner spnTreatMeth;
         LinearLayout secOpenSewers;
         View lineOpenSewers;
         TextView VlblOpenSewers;
         RadioGroup rdogrpOpenSewers;
         
         RadioButton rdoOpenSewers1;
         RadioButton rdoOpenSewers2;
         LinearLayout secObserve;
         View lineObserve;
         LinearLayout secHandwash;
         View lineHandwash;
         TextView VlblHandwash;
         RadioGroup rdogrpHandwash;
         
         RadioButton rdoHandwash1;
         RadioButton rdoHandwash2;
         RadioButton rdoHandwash3;
         LinearLayout secWater;
         View lineWater;
         TextView VlblWater;
         RadioGroup rdogrpWater;
         
         RadioButton rdoWater1;
         RadioButton rdoWater2;
         RadioButton rdoWater3;
     Button btnAdd;



    static String TableName;
     static String TableName_member;

    static String STARTTIME = "";
    static String DEVICEID  = "";
    static String ENTRYUSER = "";
    MySharedPreferences sp;

     private RecyclerView recyclerView;
//     private DataAdapter_member mAdapter;

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
         setContentView(R.layout.household_interview);
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
//         MEMSL = IDbundle.getString("MemSl");

         TableName = "Household_Interview";
         TableName_member = "Member";

         //turnGPSOn();

         //GPS Location
         //FindLocation();
         // Double.toString(currentLatitude);
         // Double.toString(currentLongitude);
         lblHeading = (TextView)findViewById(R.id.lblHeading);

         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(Household_Interview.this);
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
         secBasicHHInfo=(LinearLayout)findViewById(R.id.secBasicHHInfo);
         lineBasicHHInfo=(View)findViewById(R.id.lineBasicHHInfo);
         secFHeadAvail=(LinearLayout)findViewById(R.id.secFHeadAvail);
         lineFHeadAvail=(View)findViewById(R.id.lineFHeadAvail);
         VlblFHeadAvail = (TextView) findViewById(R.id.VlblFHeadAvail);
         rdogrpFHeadAvail = (RadioGroup) findViewById(R.id.rdogrpFHeadAvail);
         
         rdoFHeadAvail1 = (RadioButton) findViewById(R.id.rdoFHeadAvail1);
         rdoFHeadAvail2 = (RadioButton) findViewById(R.id.rdoFHeadAvail2);

         txtUNCode.setText(UNCODE);
         txtStructureNo.setText(STRUCTURENO);
         txtHouseholdSl.setText(HOUSEHOLDSL);
         txtVisitNo.setText(VISITNO);



         rdogrpFHeadAvail.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpFHeadAvail = new String[] {"1","2"};
             for (int i = 0; i < rdogrpFHeadAvail.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpFHeadAvail.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpFHeadAvail[i];
             }

             if(rbData.equalsIgnoreCase("1"))
             {
                    secRelWithFHead.setVisibility(View.GONE);
                    lineRelWithFHead.setVisibility(View.GONE);
                    spnRelWithFHead.setSelection(0);
                    secOthRelWithFHead.setVisibility(View.GONE);
                    lineOthRelWithFHead.setVisibility(View.GONE);
                    txtOthRelWithFHead.setText("");
             }
             else
             {
                    secRelWithFHead.setVisibility(View.VISIBLE);
                    lineRelWithFHead.setVisibility(View.VISIBLE);
                    secOthRelWithFHead.setVisibility(View.VISIBLE);
                    lineOthRelWithFHead.setVisibility(View.VISIBLE);
//                 secOthRelWithFHead.setVisibility(View.GONE);
//                 lineOthRelWithFHead.setVisibility(View.GONE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secRelWithFHead=(LinearLayout)findViewById(R.id.secRelWithFHead);
         lineRelWithFHead=(View)findViewById(R.id.lineRelWithFHead);
         VlblRelWithFHead=(TextView) findViewById(R.id.VlblRelWithFHead);
         spnRelWithFHead=(Spinner) findViewById(R.id.spnRelWithFHead);
         secOthRelWithFHead=(LinearLayout)findViewById(R.id.secOthRelWithFHead);
         lineOthRelWithFHead=(View)findViewById(R.id.lineOthRelWithFHead);
         VlblOthRelWithFHead=(TextView) findViewById(R.id.VlblOthRelWithFHead);
         txtOthRelWithFHead=(EditText) findViewById(R.id.txtOthRelWithFHead);


         List<String> listRelWithFHead = new ArrayList<String>();
         
         listRelWithFHead.add("");
         listRelWithFHead.add("1-মহিলা খানা প্রধানের স্বামী/স্ত্রী (Spouse of female head of household)");
         listRelWithFHead.add("2-মহিলা খানা প্রধানের ছেলে/মেয়ের স্বামী/মেয়ে/ছেলের বউ (Son/son-in-law/daughter/daughter-in-law of female head of household)");
         listRelWithFHead.add("3-মহিলা খানা প্রধানের মা/বাবা (Mother/father of female head of household)");
         listRelWithFHead.add("4-মহলিা খানা প্রধানের নানা/নান/দাদা/দাদি (Grandmother/grandfather of female head of household)");
         listRelWithFHead.add("5-মহিলা খানা প্রধানের ভাই/বোন/দেবর/ ননদ/শালা/ শালী (Sibling of head of female household)");
         listRelWithFHead.add("6-মহিলা খানা প্রধানের চাচা/মামা/চাচি/মামি/ফুপু/ফুপা/খালা/খালু (Aunt/uncle of female head of household)");
         listRelWithFHead.add("7-মহিলা খানা প্রধানের ভাগ্নে/ভাগ্নী/ভাইস্তা/ভাইস্তি (Niece/nephew of female head of household)");
         listRelWithFHead.add("8-মহিলা খানা প্রধানের খালাত/চাচাত/মামাত/ফুপাত ভাই/বোন (Cousin of female head of household)");
         listRelWithFHead.add("77-অন্যান্য (Other)");
         ArrayAdapter<String> adptrRelWithFHead= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listRelWithFHead);
         spnRelWithFHead.setAdapter(adptrRelWithFHead);

         spnRelWithFHead.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                 String spnData = "";
                 if (spnRelWithFHead.getSelectedItem().toString().length() != 0)
                 {
                     spnData = Connection.SelectedSpinnerValue(spnRelWithFHead.getSelectedItem().toString(), "-");
                 }
                 if(spnData.equalsIgnoreCase("1"))
                 {
                     secOthRelWithFHead.setVisibility(View.GONE);
                     lineOthRelWithFHead.setVisibility(View.GONE);
                     txtOthRelWithFHead.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("2"))
                 {
                     secOthRelWithFHead.setVisibility(View.GONE);
                     lineOthRelWithFHead.setVisibility(View.GONE);
                     txtOthRelWithFHead.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("3"))
                 {
                     secOthRelWithFHead.setVisibility(View.GONE);
                     lineOthRelWithFHead.setVisibility(View.GONE);
                     txtOthRelWithFHead.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("4"))
                 {
                     secOthRelWithFHead.setVisibility(View.GONE);
                     lineOthRelWithFHead.setVisibility(View.GONE);
                     txtOthRelWithFHead.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("5"))
                 {
                     secOthRelWithFHead.setVisibility(View.GONE);
                     lineOthRelWithFHead.setVisibility(View.GONE);
                     txtOthRelWithFHead.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("6"))
                 {
                     secOthRelWithFHead.setVisibility(View.GONE);
                     lineOthRelWithFHead.setVisibility(View.GONE);
                     txtOthRelWithFHead.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("7"))
                 {
                     secOthRelWithFHead.setVisibility(View.GONE);
                     lineOthRelWithFHead.setVisibility(View.GONE);
                     txtOthRelWithFHead.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("8"))
                 {
                     secOthRelWithFHead.setVisibility(View.GONE);
                     lineOthRelWithFHead.setVisibility(View.GONE);
                     txtOthRelWithFHead.setText("");
                 }

                 else if(spnData.equalsIgnoreCase("77"))
                 {
                     secOthRelWithFHead.setVisibility(View.VISIBLE);
                     lineOthRelWithFHead.setVisibility(View.VISIBLE);
//                     txtChildHcareOth.setText("");
                 }
                 else
                 {
                     secOthRelWithFHead.setVisibility(View.GONE);
                     lineOthRelWithFHead.setVisibility(View.GONE);
                     txtOthRelWithFHead.setText("");
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });







         secFirstName=(LinearLayout)findViewById(R.id.secFirstName);
         lineFirstName=(View)findViewById(R.id.lineFirstName);
         VlblFirstName=(TextView) findViewById(R.id.VlblFirstName);
         txtFirstName=(EditText) findViewById(R.id.txtFirstName);
         secEduLevelFHead=(LinearLayout)findViewById(R.id.secEduLevelFHead);
         lineEduLevelFHead=(View)findViewById(R.id.lineEduLevelFHead);
         VlblEduLevelFHead=(TextView) findViewById(R.id.VlblEduLevelFHead);
         spnEduLevelFHead=(Spinner) findViewById(R.id.spnEduLevelFHead);
         List<String> listEduLevelFHead = new ArrayList<String>();
         
         listEduLevelFHead.add("");
         listEduLevelFHead.add("0-পড়ালেখা করেননি (None)");
         listEduLevelFHead.add("1-প্রাথমিক (Primary)");
         listEduLevelFHead.add("2-মাধ্যমিক (Secondary)");
         listEduLevelFHead.add("3-মাধ্যমিক পরবর্তী (Post-Secondary)");
         listEduLevelFHead.add("5-অন্যান্য (ভোকেশনাল, ধর্মীয়) (Other (Vocational Training, Religious))");
         listEduLevelFHead.add("7-প্রযোজ্য নয়");
         ArrayAdapter<String> adptrEduLevelFHead= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listEduLevelFHead);
         spnEduLevelFHead.setAdapter(adptrEduLevelFHead);

         secEduLevelMHead=(LinearLayout)findViewById(R.id.secEduLevelMHead);
         lineEduLevelMHead=(View)findViewById(R.id.lineEduLevelMHead);
         VlblEduLevelMHead=(TextView) findViewById(R.id.VlblEduLevelMHead);
         spnEduLevelMHead=(Spinner) findViewById(R.id.spnEduLevelMHead);
         List<String> listEduLevelMHead = new ArrayList<String>();
         
         listEduLevelMHead.add("");
         listEduLevelMHead.add("0-পড়ালেখা করেননি (None)");
         listEduLevelMHead.add("1-প্রাথমিক (Primary)");
         listEduLevelMHead.add("2-মাধ্যমিক (Secondary)");
         listEduLevelMHead.add("3-মাধ্যমিক পরবর্তী (Post-Secondary)");
         listEduLevelMHead.add("5-অন্যান্য (ভোকেশনাল, ধর্মীয়) (Other (Vocational Training, Religious))");
         listEduLevelMHead.add("7-প্রযোজ্য নয়");
         ArrayAdapter<String> adptrEduLevelMHead= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listEduLevelMHead);
         spnEduLevelMHead.setAdapter(adptrEduLevelMHead);


//         final String MSL = C.ReturnSingleValue("Select (ifnull(max(cast(MemSl as int)),0)+1) from Member where UNCode='"+UNCODE+"'and StructureNo='"+ STRUCTURENO +"'and HouseholdSl='"+ HOUSEHOLDSL +"'and VisitNo='"+ VISITNO +"'"); //where ParticipantID='"+ ParticipantID +"'");




         btnAdd   = (Button) findViewById(R.id.btnAdd_member);
         btnAdd.setOnClickListener(new View.OnClickListener() {

             public void onClick(View view) {
                         Bundle IDbundle = new Bundle();
                         IDbundle.putString("UNCode", UNCODE);
                         IDbundle.putString("StructureNo", STRUCTURENO);
                         IDbundle.putString("HouseholdSl", HOUSEHOLDSL);
                         IDbundle.putString("VisitNo", VISITNO);
                         IDbundle.putString("MemSl", "");
                         IDbundle.putString("DataMode", "1");
                         Intent intent = new Intent(getApplicationContext(), Member.class);
                         intent.putExtras(IDbundle);
                         startActivityForResult(intent, 1);

             }});


         recyclerView=(RecyclerView) findViewById(R.id.recycler_view_member);
         mAdapter=new DataAdapter_member(dataList);
         recyclerView.setItemViewCacheSize(20);
         recyclerView.setDrawingCacheEnabled(true);
         recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
         recyclerView.setHasFixedSize(true);
         RecyclerView.LayoutManager memberLayoutManager= new LinearLayoutManager(getApplicationContext());
         recyclerView.setLayoutManager(memberLayoutManager);
         recyclerView.addItemDecoration(new Member_list.DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
         recyclerView.setItemAnimator(new DefaultItemAnimator());
         recyclerView.setAdapter(mAdapter);

//         recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
//         mAdapter = new DataAdapter(dataList);
//         recyclerView.setItemViewCacheSize(20);
//         recyclerView.setDrawingCacheEnabled(true);
//         recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
//         recyclerView.setHasFixedSize(true);
//         RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
//         recyclerView.setLayoutManager(mLayoutManager);
//         recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
//         recyclerView.setItemAnimator(new DefaultItemAnimator());
//         recyclerView.setAdapter(mAdapter);
//

DataSearch_member(UNCODE,STRUCTURENO,HOUSEHOLDSL,VISITNO);

         seclblh1=(LinearLayout)findViewById(R.id.seclblh1);
         linelblh1=(View)findViewById(R.id.linelblh1);
         secliveHouseM=(LinearLayout)findViewById(R.id.secliveHouseM);
         lineliveHouseM=(View)findViewById(R.id.lineliveHouseM);
         VlblliveHouseM=(TextView) findViewById(R.id.VlblliveHouseM);
         txtliveHouseM=(EditText) findViewById(R.id.txtliveHouseM);
         secliveHouseY=(LinearLayout)findViewById(R.id.secliveHouseY);
         lineliveHouseY=(View)findViewById(R.id.lineliveHouseY);
         VlblliveHouseY=(TextView) findViewById(R.id.VlblliveHouseY);
         txtliveHouseY=(EditText) findViewById(R.id.txtliveHouseY);
         secLiveHH_Mon=(LinearLayout)findViewById(R.id.secLiveHH_Mon);
         lineLiveHH_Mon=(View)findViewById(R.id.lineLiveHH_Mon);
         VlblLiveHH_Mon=(TextView) findViewById(R.id.VlblLiveHH_Mon);
         txtLiveHH_Mon=(EditText) findViewById(R.id.txtLiveHH_Mon);
         secLiveHH_Year=(LinearLayout)findViewById(R.id.secLiveHH_Year);
         lineLiveHH_Year=(View)findViewById(R.id.lineLiveHH_Year);
         VlblLiveHH_Year=(TextView) findViewById(R.id.VlblLiveHH_Year);
         txtLiveHH_Year=(EditText) findViewById(R.id.txtLiveHH_Year);
         secLiveCity_Mon=(LinearLayout)findViewById(R.id.secLiveCity_Mon);
         lineLiveCity_Mon=(View)findViewById(R.id.lineLiveCity_Mon);
         VlblLiveCity_Mon=(TextView) findViewById(R.id.VlblLiveCity_Mon);
         txtLiveCity_Mon=(EditText) findViewById(R.id.txtLiveCity_Mon);
         secLiveCity_Year=(LinearLayout)findViewById(R.id.secLiveCity_Year);
         lineLiveCity_Year=(View)findViewById(R.id.lineLiveCity_Year);
         VlblLiveCity_Year=(TextView) findViewById(R.id.VlblLiveCity_Year);
         txtLiveCity_Year=(EditText) findViewById(R.id.txtLiveCity_Year);
         secHlive12m=(LinearLayout)findViewById(R.id.secHlive12m);
         lineHlive12m=(View)findViewById(R.id.lineHlive12m);
         VlblHlive12m = (TextView) findViewById(R.id.VlblHlive12m);
         rdogrpHlive12m = (RadioGroup) findViewById(R.id.rdogrpHlive12m);

         
         rdoHlive12m1 = (RadioButton) findViewById(R.id.rdoHlive12m1);
         rdoHlive12m2 = (RadioButton) findViewById(R.id.rdoHlive12m2);
         rdoHlive12m3 = (RadioButton) findViewById(R.id.rdoHlive12m3);
         secChangedHouse=(LinearLayout)findViewById(R.id.secChangedHouse);
         lineChangedHouse=(View)findViewById(R.id.lineChangedHouse);
         VlblChangedHouse=(TextView) findViewById(R.id.VlblChangedHouse);
         txtChangedHouse=(EditText) findViewById(R.id.txtChangedHouse);
         secDistHome=(LinearLayout)findViewById(R.id.secDistHome);
         lineDistHome=(View)findViewById(R.id.lineDistHome);
         VlblDistHome=(TextView) findViewById(R.id.VlblDistHome);
         spnDistHome=(Spinner) findViewById(R.id.spnDistHome);



         txtliveHouseM.addTextChangedListener(new TextWatcher() {
             @Override
             public void beforeTextChanged(CharSequence s, int start, int count, int after) {

             }

             @Override
             public void onTextChanged(CharSequence s, int start, int before, int count) {
                 if(txtliveHouseM.getText().toString().length()>0)
                     txtliveHouseY.setText("");
             }

             @Override
             public void afterTextChanged(Editable s) {
                 if(txtliveHouseM.getText().toString().length()>0)
                 {
                     int year = Integer.parseInt(txtliveHouseM.getText().toString());
                     if(year==96)
                     {
                         secLiveCity_Mon.setVisibility(View.GONE);
                         secLiveCity_Year.setVisibility(View.GONE);
                         secLiveHH_Mon.setVisibility(View.GONE);
                         secLiveHH_Year.setVisibility(View.GONE);
                         secHlive12m.setVisibility(View.GONE);
                         secChangedHouse.setVisibility(View.GONE);
                         secDistHome.setVisibility(View.GONE);
                         lineLiveCity_Year.setVisibility(View.GONE);
                         lineLiveHH_Mon.setVisibility(View.GONE);
                         lineLiveHH_Year.setVisibility(View.GONE);
                         lineHlive12m.setVisibility(View.GONE);
                         lineChangedHouse.setVisibility(View.GONE);
                         lineDistHome.setVisibility(View.GONE);
//
                     }
                     else{
                         secLiveCity_Mon.setVisibility(View.VISIBLE);
                         secLiveCity_Year.setVisibility(View.VISIBLE);
                         secLiveHH_Mon.setVisibility(View.VISIBLE);
                         secLiveHH_Year.setVisibility(View.VISIBLE);
                         secHlive12m.setVisibility(View.VISIBLE);
                         secChangedHouse.setVisibility(View.VISIBLE);
                         secDistHome.setVisibility(View.VISIBLE);
                         lineLiveCity_Year.setVisibility(View.VISIBLE);
                         lineLiveHH_Mon.setVisibility(View.VISIBLE);
                         lineLiveHH_Year.setVisibility(View.VISIBLE);
                         lineHlive12m.setVisibility(View.VISIBLE);
                         lineChangedHouse.setVisibility(View.VISIBLE);
                         lineDistHome.setVisibility(View.VISIBLE);
                     }
                 }
                 else{
                     secLiveCity_Mon.setVisibility(View.VISIBLE);
                     secLiveCity_Year.setVisibility(View.VISIBLE);
                     secLiveHH_Mon.setVisibility(View.VISIBLE);
                     secLiveHH_Year.setVisibility(View.VISIBLE);
                     secHlive12m.setVisibility(View.VISIBLE);
                     secChangedHouse.setVisibility(View.VISIBLE);
                     secDistHome.setVisibility(View.VISIBLE);
                     lineLiveCity_Year.setVisibility(View.VISIBLE);
                     lineLiveHH_Mon.setVisibility(View.VISIBLE);
                     lineLiveHH_Year.setVisibility(View.VISIBLE);
                     lineHlive12m.setVisibility(View.VISIBLE);
                     lineChangedHouse.setVisibility(View.VISIBLE);
                     lineDistHome.setVisibility(View.VISIBLE);
                 }
             }
         });



txtliveHouseY.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if(txtliveHouseY.getText().toString().length()>0 & !txtliveHouseY.getText().toString().equals("0")) {
            txtliveHouseM.setText("");

            //**********************************************************
            int year = Integer.parseInt(txtliveHouseY.getText().toString());
            if(year==96)
            {
                secHlive12m.setVisibility(View.GONE);
                lineHlive12m.setVisibility(View.GONE);
                rdogrpHlive12m.clearCheck();

                secChangedHouse.setVisibility(View.GONE);
                lineChangedHouse.setVisibility(View.GONE);
                txtChangedHouse.setText("");

                secDistHome.setVisibility(View.GONE);
                lineDistHome.setVisibility(View.GONE);
                spnDistHome.setSelection(0);
            }else if(year>=5 & year<=95)
            {
                secHlive12m.setVisibility(View.GONE);
                lineHlive12m.setVisibility(View.GONE);
                rdogrpHlive12m.clearCheck();

                secChangedHouse.setVisibility(View.GONE);
                lineChangedHouse.setVisibility(View.GONE);
                txtChangedHouse.setText("");
            }
            else{
                secHlive12m.setVisibility(View.VISIBLE);
                lineHlive12m.setVisibility(View.VISIBLE);

                secChangedHouse.setVisibility(View.VISIBLE);
                lineChangedHouse.setVisibility(View.VISIBLE);

                secDistHome.setVisibility(View.VISIBLE);
                lineDistHome.setVisibility(View.VISIBLE);

//                     secLiveCity_Mon.setVisibility(View.VISIBLE);
//                     secLiveCity_Year.setVisibility(View.VISIBLE);
//                     secLiveHH_Mon.setVisibility(View.VISIBLE);
//                     secLiveHH_Year.setVisibility(View.VISIBLE);
//                     secHlive12m.setVisibility(View.VISIBLE);
//                     secChangedHouse.setVisibility(View.VISIBLE);
//                     secDistHome.setVisibility(View.VISIBLE);
//                     lineLiveCity_Year.setVisibility(View.VISIBLE);
//                     lineLiveHH_Mon.setVisibility(View.VISIBLE);
//                     lineLiveHH_Year.setVisibility(View.VISIBLE);
//                     lineHlive12m.setVisibility(View.VISIBLE);
//                     lineChangedHouse.setVisibility(View.VISIBLE);
//                     lineDistHome.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

//        if(txtliveHouseY.getText().toString().length()>0)
//        {
//            int year = Integer.parseInt(txtliveHouseY.getText().toString());
//
//        }
//        else{
//            secLiveCity_Mon.setVisibility(View.VISIBLE);
//            secLiveCity_Year.setVisibility(View.VISIBLE);
//            secLiveHH_Mon.setVisibility(View.VISIBLE);
//            secLiveHH_Year.setVisibility(View.VISIBLE);
//            secHlive12m.setVisibility(View.VISIBLE);
//            secChangedHouse.setVisibility(View.VISIBLE);
//            secDistHome.setVisibility(View.VISIBLE);
//            lineLiveCity_Year.setVisibility(View.VISIBLE);
//            lineLiveHH_Mon.setVisibility(View.VISIBLE);
//            lineLiveHH_Year.setVisibility(View.VISIBLE);
//            lineHlive12m.setVisibility(View.VISIBLE);
//            lineChangedHouse.setVisibility(View.VISIBLE);
//            lineDistHome.setVisibility(View.VISIBLE);
//        }
    }
});

         txtLiveHH_Mon.addTextChangedListener(new TextWatcher() {
             @Override
             public void beforeTextChanged(CharSequence s, int start, int count, int after) {

             }

             @Override
             public void onTextChanged(CharSequence s, int start, int before, int count) {
                 if(txtLiveHH_Mon.getText().toString().length()>0 & !txtLiveHH_Mon.getText().toString().equals("0"))
                 {
                     txtLiveHH_Year.setText("");
                 }

             }

             @Override
             public void afterTextChanged(Editable s) {

             }
         });

         txtLiveHH_Year.addTextChangedListener(new TextWatcher() {
             @Override
             public void beforeTextChanged(CharSequence s, int start, int count, int after) {

             }

             @Override
             public void onTextChanged(CharSequence s, int start, int before, int count) {
                 if(txtLiveHH_Year.getText().toString().length()>0 & !txtLiveHH_Year.getText().toString().equals("0"))
                 {
                     txtLiveHH_Mon.setText("");
                 }

             }

             @Override
             public void afterTextChanged(Editable s) {

             }
         });

         txtLiveCity_Mon.addTextChangedListener(new TextWatcher() {
             @Override
             public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                 if(txtLiveCity_Year.getText().toString().length()>0)
                 {
                     txtLiveCity_Year.setText("");
                 }
             }

             @Override
             public void onTextChanged(CharSequence s, int start, int before, int count) {

             }

             @Override
             public void afterTextChanged(Editable s) {

             }
         });

         txtLiveCity_Year.addTextChangedListener(new TextWatcher() {
             @Override
             public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                 if(txtLiveCity_Mon.getText().toString().length()>0)
                 {
                     txtLiveCity_Mon.setText("");
                 }
             }

             @Override
             public void onTextChanged(CharSequence s, int start, int before, int count) {

             }

             @Override
             public void afterTextChanged(Editable s) {

             }
         });

txtChangedHouse.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

        if(s.length()!=0) {
            int year = Integer.parseInt(txtChangedHouse.getText().toString());
            if (year == 0) {

                secDistHome.setVisibility(View.GONE);
                lineDistHome.setVisibility(View.GONE);

            }
        }
        else{
            secDistHome.setVisibility(View.VISIBLE);
            lineDistHome.setVisibility(View.VISIBLE);
        }


    }
});






         List<String> listDistHome = new ArrayList<String>();
         
         listDistHome.add("");
         listDistHome.add("1-এক মাইলের কম দূরতে (Less than a mile) ");
         listDistHome.add("2-১-৫ মাইল (1-5 miles)");
         listDistHome.add("3-৫-৫০ মাইল (5 - 50 miles) ");
         listDistHome.add("4-৫০ মাইলের উপরে (More than 50 miles)");
         listDistHome.add("8-জানি না (Don’t Know)");
         ArrayAdapter<String> adptrDistHome= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listDistHome);
         spnDistHome.setAdapter(adptrDistHome);

         secChildHcare=(LinearLayout)findViewById(R.id.secChildHcare);
         lineChildHcare=(View)findViewById(R.id.lineChildHcare);
         VlblChildHcare=(TextView) findViewById(R.id.VlblChildHcare);
         spnChildHcare=(Spinner) findViewById(R.id.spnChildHcare);
         List<String> listChildHcare = new ArrayList<String>();
         
         listChildHcare.add("");
         listChildHcare.add("1-DSH বহির্বিভাগ (DSH outpatient department)");
         listChildHcare.add("2-SSF বহির্বিভাগ (SSF outpatient department)");
         listChildHcare.add("3-নিকটবর্তি প্রশিক্ষন প্রাপ্ত ডাক্তারের কাছ থেকে (MBBS বা তদোর্থ) (Local qualified doctor (MBBS and above))");
         listChildHcare.add("4-অন্য সরকারী হাসপাতালের বহির্বিভাগ  (Outpatient department of other government hospital)");
         listChildHcare.add("5-অন্য বেসরকারী হাসপাতালের বহির্বিভাগ  (Outpatient department of other private clinic/hospital)");
         listChildHcare.add("6-আশে পাশের ফার্মেসি থেকে (Local pharmacy) ");
         listChildHcare.add("7-অপ্রশিক্ষন প্রাপ্ত স্বাস্থ্যসেবা প্রদানকারি  (Untrained providers)");
         listChildHcare.add("8-স্বাস্থ্যসেবা গ্রহনের নির্দিষ্ট কোন জায়গা নেই (Do not have a specific place for receiving health care)");
         listChildHcare.add("9-কবিরাজ (Traditional Hiller)");
         listChildHcare.add("10-হোমিওপ্যাথি (Homeopathy)");
         listChildHcare.add("11-এখনো কোন স্বাস্থ্যসেবা গ্রহন  করেনি (has not received any health care yet)");
         listChildHcare.add("77-অন্যান্য (Others)");
         listChildHcare.add("88-জানিনা  (Don’t Know)");

         ArrayAdapter<String> adptrChildHcare= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listChildHcare);
         spnChildHcare.setAdapter(adptrChildHcare);

         spnChildHcare.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnChildHcare.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnChildHcare.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("1"))
                 {
                    secChildHcareOth.setVisibility(View.GONE);
                    lineChildHcareOth.setVisibility(View.GONE);
                    txtChildHcareOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("2"))
                 {
                    secChildHcareOth.setVisibility(View.GONE);
                    lineChildHcareOth.setVisibility(View.GONE);
                    txtChildHcareOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("3"))
                 {
                    secChildHcareOth.setVisibility(View.GONE);
                    lineChildHcareOth.setVisibility(View.GONE);
                    txtChildHcareOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("4"))
                 {
                    secChildHcareOth.setVisibility(View.GONE);
                    lineChildHcareOth.setVisibility(View.GONE);
                    txtChildHcareOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("5"))
                 {
                    secChildHcareOth.setVisibility(View.GONE);
                    lineChildHcareOth.setVisibility(View.GONE);
                    txtChildHcareOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("6"))
                 {
                    secChildHcareOth.setVisibility(View.GONE);
                    lineChildHcareOth.setVisibility(View.GONE);
                    txtChildHcareOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("7"))
                 {
                    secChildHcareOth.setVisibility(View.GONE);
                    lineChildHcareOth.setVisibility(View.GONE);
                    txtChildHcareOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("8"))
                 {
                    secChildHcareOth.setVisibility(View.GONE);
                    lineChildHcareOth.setVisibility(View.GONE);
                    txtChildHcareOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("9"))
                 {
                    secChildHcareOth.setVisibility(View.GONE);
                    lineChildHcareOth.setVisibility(View.GONE);
                    txtChildHcareOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("10"))
                 {
                    secChildHcareOth.setVisibility(View.GONE);
                    lineChildHcareOth.setVisibility(View.GONE);
                    txtChildHcareOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("11"))
                 {
                    secChildHcareOth.setVisibility(View.GONE);
                    lineChildHcareOth.setVisibility(View.GONE);
                    txtChildHcareOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("13"))
                 {
                    secChildHcareOth.setVisibility(View.GONE);
                    lineChildHcareOth.setVisibility(View.GONE);
                    txtChildHcareOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("77"))
                 {
                     secChildHcareOth.setVisibility(View.VISIBLE);
                     lineChildHcareOth.setVisibility(View.VISIBLE);
//                     txtChildHcareOth.setText("");
                 }
                 else
                 {
                    secChildHcareOth.setVisibility(View.GONE);
                    lineChildHcareOth.setVisibility(View.GONE);
                     txtChildHcareOth.setText("");
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secChildHcareOth=(LinearLayout)findViewById(R.id.secChildHcareOth);
         lineChildHcareOth=(View)findViewById(R.id.lineChildHcareOth);
         VlblChildHcareOth=(TextView) findViewById(R.id.VlblChildHcareOth);
         txtChildHcareOth=(EditText) findViewById(R.id.txtChildHcareOth);
         secSocioEconomic=(LinearLayout)findViewById(R.id.secSocioEconomic);
         lineSocioEconomic=(View)findViewById(R.id.lineSocioEconomic);
         secMotherEdu=(LinearLayout)findViewById(R.id.secMotherEdu);
         lineMotherEdu=(View)findViewById(R.id.lineMotherEdu);
         VlblMotherEdu=(TextView) findViewById(R.id.VlblMotherEdu);
         txtMotherEdu=(EditText) findViewById(R.id.txtMotherEdu);
         secHeadOcp=(LinearLayout)findViewById(R.id.secHeadOcp);
         lineHeadOcp=(View)findViewById(R.id.lineHeadOcp);
         VlblHeadOcp=(TextView) findViewById(R.id.VlblHeadOcp);
         spnHeadOcp=(Spinner) findViewById(R.id.spnHeadOcp);
         secHeadOcpOth=(LinearLayout)findViewById(R.id.secHeadOcpOth);
         lineHeadOcpOth=(View)findViewById(R.id.lineHeadOcpOth);
         VlblHeadOcpOth=(TextView) findViewById(R.id.VlblHeadOcpOth);
         txtHeadOcpOth=(EditText) findViewById(R.id.txtHeadOcpOth);
         List<String> listHeadOcp = new ArrayList<String>();
         
         listHeadOcp.add("");
         listHeadOcp.add("1-কৃষক (Farmer)");
         listHeadOcp.add("2-ঘরে কাজ করে (Work at home)");
         listHeadOcp.add("3-কৃষি শ্রমিক (Farm labourer)");
         listHeadOcp.add("4-শ্রমিক (কৃষি শ্রমিক ছাড়া)  (Labourer, except farm labourer)");
         listHeadOcp.add("5-কারখানার শ্রমিক  (Factory labourer)");
         listHeadOcp.add("6-ফেরিওয়ালা   (Street vendor)");
         listHeadOcp.add("7-বেতনভুক্ত কর্মচারী (সরকারী/প্রাইভেট/এন.জি.ও) (Paid Employer(Govt./Private/N.G.O)");
         listHeadOcp.add("8-রাজমিস্ত্রী  (Mason)");
         listHeadOcp.add("9-কাঠ মিস্ত্রী (Carpenter)");
         listHeadOcp.add("10-ভ্যান/রিকশা চালক  (Van/Rickshaw driver)");
         listHeadOcp.add("11-জেলে  (Fisherman)");
         listHeadOcp.add("12-নৌকা চালক/মাঝি (Steersman)");
         listHeadOcp.add("13-কর্মকার (Blacksmith)");
         listHeadOcp.add("14-স্বর্ণকার (Jeweller)");
         listHeadOcp.add("15-কুমার/কুম্ভকার (Potter)");
         listHeadOcp.add("16-মুচি (Cobbler)");
         listHeadOcp.add("17-দোকানদার (Shopkeeper)");
         listHeadOcp.add("18-ক্ষুদ্র ব্যবসায়ী (ব্যবসার মূলধন ১০,০০০ টাকার বা তার কম) (Small Trader (Business capital is 10000 taka or less))");
         listHeadOcp.add("19-ব্যবসায়ী (ব্যবসার মূলধন ১০,০০০ টাকার বেশী)  (Buisness man (Business capital is more than 10000 taka))	");
         listHeadOcp.add("20-দর্জি (Tailor)");
         listHeadOcp.add("21-ড্রাইভার (Driver)");
         listHeadOcp.add("22-কুটিরশিল্প (Cottage Industry)");
         listHeadOcp.add("23-পোলট্রি/ ব্যবসার জন্য পশু লালন-পালনকারী (Poultry)");
         listHeadOcp.add("24-বৈদ্যুতিক মিস্ত্রী (Electrician)");
         listHeadOcp.add("25-হোমিওপ্যাথি ডাক্তার (Homiopathy Physician)");
         listHeadOcp.add("26-আধ্যাতিক চিকিৎসক/ কবিরাজ/ ওঝাঁ (Herbalists)");
         listHeadOcp.add("27-পেশাদার ডাক্তার/উকিল /ইঞ্জিনিয়ার/প্রাইভেট শিক্ষক(Professional Doctor/Engineer/Lawyer/Private Teacher)");
         listHeadOcp.add("28-ইমাম/ ধর্মযাজক (Imam/Preist)");
         listHeadOcp.add("29-অবসরপ্রাপ্ত চাকুরীজীবী (Retired Employer)");
         listHeadOcp.add("30-ছাত্র (Student)");
         listHeadOcp.add("31-বেকার (Unemployed)");
         listHeadOcp.add("32-অক্ষম (Incapable)");
         listHeadOcp.add("33-কাজের লোক (Servant)");
         listHeadOcp.add("34-জমিদার (শস্য উৎপাদন অথবা অন্য কোন কাজে কৃষকদের জমি বর্গা দেয়) (Land lord)");
         listHeadOcp.add("35-বিদেশে থাকে (Emigrant)");
         listHeadOcp.add("36-গার্মেন্টস কর্মী (Garment Workers)");
         listHeadOcp.add("37-বাড়িওয়ালা (Landlord)");
         listHeadOcp.add("38-সিকিউরিটি/ গার্ড/ কেয়ার টেকার (Security/Guard/Care taker)");
         listHeadOcp.add("39-রঙ/ টাইলস/ স্যানিটারি মিস্ত্রি (Rong/Tiles/Sanitary Mistri)");
         listHeadOcp.add("88-জানিনা (Dont know)");
         listHeadOcp.add("77-অন্যান্য");

         ArrayAdapter<String> adptrHeadOcp= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listHeadOcp);
         spnHeadOcp.setAdapter(adptrHeadOcp);

         spnHeadOcp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                 String spnData = "";
                 if (spnHeadOcp.getSelectedItem().toString().length() != 0)
                 {
                     spnData = Connection.SelectedSpinnerValue(spnHeadOcp.getSelectedItem().toString(), "-");
                 }
                 if(spnData.equalsIgnoreCase("1"))
                 {
                     secHeadOcpOth.setVisibility(View.GONE);
                     lineHeadOcpOth.setVisibility(View.GONE);
                     txtHeadOcpOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("2"))
                 {
                     secHeadOcpOth.setVisibility(View.GONE);
                     lineHeadOcpOth.setVisibility(View.GONE);
                     txtHeadOcpOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("3"))
                 {
                     secHeadOcpOth.setVisibility(View.GONE);
                     lineHeadOcpOth.setVisibility(View.GONE);
                     txtHeadOcpOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("4"))
                 {
                     secHeadOcpOth.setVisibility(View.GONE);
                     lineHeadOcpOth.setVisibility(View.GONE);
                     txtHeadOcpOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("5"))
                 {
                     secHeadOcpOth.setVisibility(View.GONE);
                     lineHeadOcpOth.setVisibility(View.GONE);
                     txtHeadOcpOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("6"))
                 {
                     secHeadOcpOth.setVisibility(View.GONE);
                     lineHeadOcpOth.setVisibility(View.GONE);
                     txtHeadOcpOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("7"))
                 {
                     secHeadOcpOth.setVisibility(View.GONE);
                     lineHeadOcpOth.setVisibility(View.GONE);
                     txtHeadOcpOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("8"))
                 {
                     secHeadOcpOth.setVisibility(View.GONE);
                     lineHeadOcpOth.setVisibility(View.GONE);
                     txtHeadOcpOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("9"))
                 {
                     secHeadOcpOth.setVisibility(View.GONE);
                     lineHeadOcpOth.setVisibility(View.GONE);
                     txtHeadOcpOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("10"))
                 {
                     secHeadOcpOth.setVisibility(View.GONE);
                     lineHeadOcpOth.setVisibility(View.GONE);
                     txtHeadOcpOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("11"))
                 {
                     secHeadOcpOth.setVisibility(View.GONE);
                     lineHeadOcpOth.setVisibility(View.GONE);
                     txtHeadOcpOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("13"))
                 {
                     secHeadOcpOth.setVisibility(View.GONE);
                     lineHeadOcpOth.setVisibility(View.GONE);
                     txtHeadOcpOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("14"))
                 {
                     secHeadOcpOth.setVisibility(View.GONE);
                     lineHeadOcpOth.setVisibility(View.GONE);
                     txtHeadOcpOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("15"))
                 {
                     secHeadOcpOth.setVisibility(View.GONE);
                     lineHeadOcpOth.setVisibility(View.GONE);
                     txtHeadOcpOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("16"))
                 {
                     secHeadOcpOth.setVisibility(View.GONE);
                     lineHeadOcpOth.setVisibility(View.GONE);
                     txtHeadOcpOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("17"))
                 {
                     secHeadOcpOth.setVisibility(View.GONE);
                     lineHeadOcpOth.setVisibility(View.GONE);
                     txtHeadOcpOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("18"))
                 {
                     secHeadOcpOth.setVisibility(View.GONE);
                     lineHeadOcpOth.setVisibility(View.GONE);
                     txtHeadOcpOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("19"))
                 {
                     secHeadOcpOth.setVisibility(View.GONE);
                     lineHeadOcpOth.setVisibility(View.GONE);
                     txtHeadOcpOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("20"))
                 {
                     secHeadOcpOth.setVisibility(View.GONE);
                     lineHeadOcpOth.setVisibility(View.GONE);
                     txtHeadOcpOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("21"))
                 {
                     secHeadOcpOth.setVisibility(View.GONE);
                     lineHeadOcpOth.setVisibility(View.GONE);
                     txtHeadOcpOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("22"))
                 {
                     secHeadOcpOth.setVisibility(View.GONE);
                     lineHeadOcpOth.setVisibility(View.GONE);
                     txtHeadOcpOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("23"))
                 {
                     secHeadOcpOth.setVisibility(View.GONE);
                     lineHeadOcpOth.setVisibility(View.GONE);
                     txtHeadOcpOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("24"))
                 {
                     secHeadOcpOth.setVisibility(View.GONE);
                     lineHeadOcpOth.setVisibility(View.GONE);
                     txtHeadOcpOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("25"))
                 {
                     secHeadOcpOth.setVisibility(View.GONE);
                     lineHeadOcpOth.setVisibility(View.GONE);
                     txtHeadOcpOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("26"))
                 {
                     secHeadOcpOth.setVisibility(View.GONE);
                     lineHeadOcpOth.setVisibility(View.GONE);
                     txtHeadOcpOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("27"))
                 {
                     secHeadOcpOth.setVisibility(View.GONE);
                     lineHeadOcpOth.setVisibility(View.GONE);
                     txtHeadOcpOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("28"))
                 {
                     secHeadOcpOth.setVisibility(View.GONE);
                     lineHeadOcpOth.setVisibility(View.GONE);
                     txtHeadOcpOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("29"))
                 {
                     secHeadOcpOth.setVisibility(View.GONE);
                     lineHeadOcpOth.setVisibility(View.GONE);
                     txtHeadOcpOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("30"))
                 {
                     secHeadOcpOth.setVisibility(View.GONE);
                     lineHeadOcpOth.setVisibility(View.GONE);
                     txtHeadOcpOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("31"))
                 {
                     secHeadOcpOth.setVisibility(View.GONE);
                     lineHeadOcpOth.setVisibility(View.GONE);
                     txtHeadOcpOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("32"))
                 {
                     secHeadOcpOth.setVisibility(View.GONE);
                     lineHeadOcpOth.setVisibility(View.GONE);
                     txtHeadOcpOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("33"))
                 {
                     secHeadOcpOth.setVisibility(View.GONE);
                     lineHeadOcpOth.setVisibility(View.GONE);
                     txtHeadOcpOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("34"))
                 {
                     secHeadOcpOth.setVisibility(View.GONE);
                     lineHeadOcpOth.setVisibility(View.GONE);
                     txtHeadOcpOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("35"))
                 {
                     secHeadOcpOth.setVisibility(View.GONE);
                     lineHeadOcpOth.setVisibility(View.GONE);
                     txtHeadOcpOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("36"))
                 {
                     secHeadOcpOth.setVisibility(View.GONE);
                     lineHeadOcpOth.setVisibility(View.GONE);
                     txtHeadOcpOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("37"))
                 {
                     secHeadOcpOth.setVisibility(View.GONE);
                     lineHeadOcpOth.setVisibility(View.GONE);
                     txtHeadOcpOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("38"))
                 {
                     secHeadOcpOth.setVisibility(View.GONE);
                     lineHeadOcpOth.setVisibility(View.GONE);
                     txtHeadOcpOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("39"))
                 {
                     secHeadOcpOth.setVisibility(View.GONE);
                     lineHeadOcpOth.setVisibility(View.GONE);
                     txtHeadOcpOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("88"))
                 {
                     secHeadOcpOth.setVisibility(View.GONE);
                     lineHeadOcpOth.setVisibility(View.GONE);
                     txtHeadOcpOth.setText("");
                 }

                 else if(spnData.equalsIgnoreCase("77"))
                 {
                     secHeadOcpOth.setVisibility(View.VISIBLE);
                     lineHeadOcpOth.setVisibility(View.VISIBLE);
//                     txtHeadOcpOth.setText("");
                 }
                 else
                 {
                     secHeadOcpOth.setVisibility(View.GONE);
                     lineHeadOcpOth.setVisibility(View.GONE);
                     txtHeadOcpOth.setText("");
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });




         secRoom=(LinearLayout)findViewById(R.id.secRoom);
         lineRoom=(View)findViewById(R.id.lineRoom);
         VlblRoom=(TextView) findViewById(R.id.VlblRoom);
         txtRoom=(EditText) findViewById(R.id.txtRoom);
         secBedRoom=(LinearLayout)findViewById(R.id.secBedRoom);
         lineBedRoom=(View)findViewById(R.id.lineBedRoom);
         VlblBedRoom=(TextView) findViewById(R.id.VlblBedRoom);
         txtBedRoom=(EditText) findViewById(R.id.txtBedRoom);
         secHouseholdAccessories=(LinearLayout)findViewById(R.id.secHouseholdAccessories);
         lineHouseholdAccessories=(View)findViewById(R.id.lineHouseholdAccessories);
         secElectricity=(LinearLayout)findViewById(R.id.secElectricity);
         lineElectricity=(View)findViewById(R.id.lineElectricity);
         VlblElectricity = (TextView) findViewById(R.id.VlblElectricity);
         rdogrpElectricity = (RadioGroup) findViewById(R.id.rdogrpElectricity);
         
         rdoElectricity1 = (RadioButton) findViewById(R.id.rdoElectricity1);
         rdoElectricity2 = (RadioButton) findViewById(R.id.rdoElectricity2);
         rdoElectricity3 = (RadioButton) findViewById(R.id.rdoElectricity3);
         rdoElectricity4 = (RadioButton) findViewById(R.id.rdoElectricity4);
         secRadio=(LinearLayout)findViewById(R.id.secRadio);
         lineRadio=(View)findViewById(R.id.lineRadio);
         VlblRadio = (TextView) findViewById(R.id.VlblRadio);
         rdogrpRadio = (RadioGroup) findViewById(R.id.rdogrpRadio);
         
         rdoRadio1 = (RadioButton) findViewById(R.id.rdoRadio1);
         rdoRadio2 = (RadioButton) findViewById(R.id.rdoRadio2);
         rdoRadio3 = (RadioButton) findViewById(R.id.rdoRadio3);
         rdoRadio4 = (RadioButton) findViewById(R.id.rdoRadio4);
         secTelevision=(LinearLayout)findViewById(R.id.secTelevision);
         lineTelevision=(View)findViewById(R.id.lineTelevision);
         VlblTelevision = (TextView) findViewById(R.id.VlblTelevision);
         rdogrpTelevision = (RadioGroup) findViewById(R.id.rdogrpTelevision);
         
         rdoTelevision1 = (RadioButton) findViewById(R.id.rdoTelevision1);
         rdoTelevision2 = (RadioButton) findViewById(R.id.rdoTelevision2);
         rdoTelevision3 = (RadioButton) findViewById(R.id.rdoTelevision3);
         rdoTelevision4 = (RadioButton) findViewById(R.id.rdoTelevision4);
         secNonMobileTele=(LinearLayout)findViewById(R.id.secNonMobileTele);
         lineNonMobileTele=(View)findViewById(R.id.lineNonMobileTele);
         VlblNonMobileTele = (TextView) findViewById(R.id.VlblNonMobileTele);
         rdogrpNonMobileTele = (RadioGroup) findViewById(R.id.rdogrpNonMobileTele);
         
         rdoNonMobileTele1 = (RadioButton) findViewById(R.id.rdoNonMobileTele1);
         rdoNonMobileTele2 = (RadioButton) findViewById(R.id.rdoNonMobileTele2);
         rdoNonMobileTele3 = (RadioButton) findViewById(R.id.rdoNonMobileTele3);
         rdoNonMobileTele4 = (RadioButton) findViewById(R.id.rdoNonMobileTele4);
         secComputer=(LinearLayout)findViewById(R.id.secComputer);
         lineComputer=(View)findViewById(R.id.lineComputer);
         VlblComputer = (TextView) findViewById(R.id.VlblComputer);
         rdogrpComputer = (RadioGroup) findViewById(R.id.rdogrpComputer);
         
         rdoComputer1 = (RadioButton) findViewById(R.id.rdoComputer1);
         rdoComputer2 = (RadioButton) findViewById(R.id.rdoComputer2);
         rdoComputer3 = (RadioButton) findViewById(R.id.rdoComputer3);
         rdoComputer4 = (RadioButton) findViewById(R.id.rdoComputer4);
         secRefrigerator=(LinearLayout)findViewById(R.id.secRefrigerator);
         lineRefrigerator=(View)findViewById(R.id.lineRefrigerator);
         VlblRefrigerator = (TextView) findViewById(R.id.VlblRefrigerator);
         rdogrpRefrigerator = (RadioGroup) findViewById(R.id.rdogrpRefrigerator);
         
         rdoRefrigerator1 = (RadioButton) findViewById(R.id.rdoRefrigerator1);
         rdoRefrigerator2 = (RadioButton) findViewById(R.id.rdoRefrigerator2);
         rdoRefrigerator3 = (RadioButton) findViewById(R.id.rdoRefrigerator3);
         rdoRefrigerator4 = (RadioButton) findViewById(R.id.rdoRefrigerator4);
         secHouseholdMemAccessories=(LinearLayout)findViewById(R.id.secHouseholdMemAccessories);
         lineHouseholdMemAccessories=(View)findViewById(R.id.lineHouseholdMemAccessories);
         secWatch=(LinearLayout)findViewById(R.id.secWatch);
         lineWatch=(View)findViewById(R.id.lineWatch);
         VlblWatch = (TextView) findViewById(R.id.VlblWatch);
         rdogrpWatch = (RadioGroup) findViewById(R.id.rdogrpWatch);
         rdogrpMobilePhone = (RadioGroup) findViewById(R.id.rdogrpMobilePhone);
         rdogrpBicycle = (RadioGroup) findViewById(R.id.rdogrpBicycle);
         rdogrpMotorcycleScooter = (RadioGroup) findViewById(R.id.rdogrpMotorcycleScooter);

         rdoWatch1 = (RadioButton) findViewById(R.id.rdoWatch1);
         rdoWatch2 = (RadioButton) findViewById(R.id.rdoWatch2);
         rdoWatch3 = (RadioButton) findViewById(R.id.rdoWatch3);
         rdoWatch4 = (RadioButton) findViewById(R.id.rdoWatch4);

         rdoMobilePhone1 = (RadioButton) findViewById(R.id.rdoMobilePhone1);
         rdoMobilePhone2 = (RadioButton) findViewById(R.id.rdoMobilePhone2);
         rdoMobilePhone3 = (RadioButton) findViewById(R.id.rdoMobilePhone3);
         rdoMobilePhone4 = (RadioButton) findViewById(R.id.rdoMobilePhone4);
         secMobilePhone=(LinearLayout)findViewById(R.id.secMobilePhone);
         lineMobilePhone=(View)findViewById(R.id.lineMobilePhone);
         VlblMobilePhone=(TextView) findViewById(R.id.VlblMobilePhone);
//         spnMobilePhone=(Spinner) findViewById(R.id.spnMobilePhone);
//         List<String> listMobilePhone = new ArrayList<String>();
//
//         listMobilePhone.add("");
//         listMobilePhone.add("1-Yes");
//         listMobilePhone.add("2-No");
//         listMobilePhone.add("3-Not Sure");
//         listMobilePhone.add("4-Reduse to answer");
//         ArrayAdapter<String> adptrMobilePhone= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listMobilePhone);
//         spnMobilePhone.setAdapter(adptrMobilePhone);

         secBicycle=(LinearLayout)findViewById(R.id.secBicycle);
         lineBicycle=(View)findViewById(R.id.lineBicycle);
         VlblBicycle=(TextView) findViewById(R.id.VlblBicycle);

         rdoBicycle1 = (RadioButton) findViewById(R.id.rdoBicycle1);
         rdoBicycle2 = (RadioButton) findViewById(R.id.rdoBicycle2);
         rdoBicycle3 = (RadioButton) findViewById(R.id.rdoBicycle3);
         rdoBicycle4 = (RadioButton) findViewById(R.id.rdoBicycle4);

         rdoMotorcycleScooter1 = (RadioButton) findViewById(R.id.rdoMotorcycleScooter1);
         rdoMotorcycleScooter2 = (RadioButton) findViewById(R.id.rdoMotorcycleScooter2);
         rdoMotorcycleScooter3 = (RadioButton) findViewById(R.id.rdoMotorcycleScooter3);
         rdoMotorcycleScooter4 = (RadioButton) findViewById(R.id.rdoMotorcycleScooter4);
         secMotorcycleScooter=(LinearLayout)findViewById(R.id.secMotorcycleScooter);
         lineMotorcycleScooter=(View)findViewById(R.id.lineMotorcycleScooter);
         VlblMotorcycleScooter=(TextView) findViewById(R.id.VlblMotorcycleScooter);



//         spnBicycle=(Spinner) findViewById(R.id.spnBicycle);
//         List<String> listBicycle = new ArrayList<String>();
//
//         listBicycle.add("");
//         listBicycle.add("1-Yes");
//         listBicycle.add("2-No");
//         listBicycle.add("3-Not Sure");
//         listBicycle.add("4-Reduse to answer");
//         ArrayAdapter<String> adptrBicycle= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listBicycle);
//         spnBicycle.setAdapter(adptrBicycle);


//         spnMotorcycleScooter=(Spinner) findViewById(R.id.spnMotorcycleScooter);
//         List<String> listMotorcycleScooter = new ArrayList<String>();
//
//         listMotorcycleScooter.add("");
//         listMotorcycleScooter.add("1-Yes");
//         listMotorcycleScooter.add("2-No");
//         listMotorcycleScooter.add("3-Not Sure");
//         listMotorcycleScooter.add("4-Reduse to answer");
//         ArrayAdapter<String> adptrMotorcycleScooter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listMotorcycleScooter);
//         spnMotorcycleScooter.setAdapter(adptrMotorcycleScooter);

         secAnimalDrawnCart=(LinearLayout)findViewById(R.id.secAnimalDrawnCart);
         lineAnimalDrawnCart=(View)findViewById(R.id.lineAnimalDrawnCart);
         VlblAnimalDrawnCart = (TextView) findViewById(R.id.VlblAnimalDrawnCart);
         rdogrpAnimalDrawnCart = (RadioGroup) findViewById(R.id.rdogrpAnimalDrawnCart);
         
         rdoAnimalDrawnCart1 = (RadioButton) findViewById(R.id.rdoAnimalDrawnCart1);
         rdoAnimalDrawnCart2 = (RadioButton) findViewById(R.id.rdoAnimalDrawnCart2);
         rdoAnimalDrawnCart3 = (RadioButton) findViewById(R.id.rdoAnimalDrawnCart3);
         rdoAnimalDrawnCart4 = (RadioButton) findViewById(R.id.rdoAnimalDrawnCart4);
         secCarOrTruck=(LinearLayout)findViewById(R.id.secCarOrTruck);
         lineCarOrTruck=(View)findViewById(R.id.lineCarOrTruck);
         VlblCarOrTruck = (TextView) findViewById(R.id.VlblCarOrTruck);
         rdogrpCarOrTruck = (RadioGroup) findViewById(R.id.rdogrpCarOrTruck);
         
         rdoCarOrTruck1 = (RadioButton) findViewById(R.id.rdoCarOrTruck1);
         rdoCarOrTruck2 = (RadioButton) findViewById(R.id.rdoCarOrTruck2);
         rdoCarOrTruck3 = (RadioButton) findViewById(R.id.rdoCarOrTruck3);
         rdoCarOrTruck4 = (RadioButton) findViewById(R.id.rdoCarOrTruck4);
         secBankAccount=(LinearLayout)findViewById(R.id.secBankAccount);
         lineBankAccount=(View)findViewById(R.id.lineBankAccount);
         VlblBankAccount = (TextView) findViewById(R.id.VlblBankAccount);
         rdogrpBankAccount = (RadioGroup) findViewById(R.id.rdogrpBankAccount);
         
         rdoBankAccount1 = (RadioButton) findViewById(R.id.rdoBankAccount1);
         rdoBankAccount2 = (RadioButton) findViewById(R.id.rdoBankAccount2);
         rdoBankAccount3 = (RadioButton) findViewById(R.id.rdoBankAccount3);
         rdoBankAccount4 = (RadioButton) findViewById(R.id.rdoBankAccount4);
         secHHOwner=(LinearLayout)findViewById(R.id.secHHOwner);
         lineHHOwner=(View)findViewById(R.id.lineHHOwner);
         VlblHHOwner = (TextView) findViewById(R.id.VlblHHOwner);
         rdogrpHHOwner = (RadioGroup) findViewById(R.id.rdogrpHHOwner);
         
         rdoHHOwner1 = (RadioButton) findViewById(R.id.rdoHHOwner1);
         rdoHHOwner2 = (RadioButton) findViewById(R.id.rdoHHOwner2);
         rdoHHOwner3 = (RadioButton) findViewById(R.id.rdoHHOwner3);
         secRentOfDwelling=(LinearLayout)findViewById(R.id.secRentOfDwelling);
         lineRentOfDwelling=(View)findViewById(R.id.lineRentOfDwelling);
         VlblRentOfDwelling=(TextView) findViewById(R.id.VlblRentOfDwelling);
         txtRentOfDwelling=(EditText) findViewById(R.id.txtRentOfDwelling);
         secRentOfDwellDK=(LinearLayout)findViewById(R.id.secRentOfDwellDK);
         lineRentOfDwellDK=(View)findViewById(R.id.lineRentOfDwellDK);
         VlblRentOfDwellDK=(TextView) findViewById(R.id.VlblRentOfDwellDK);
         chkRentOfDwellDK=(CheckBox) findViewById(R.id.chkRentOfDwellDK);
         secConsMatFloor=(LinearLayout)findViewById(R.id.secConsMatFloor);
         lineConsMatFloor=(View)findViewById(R.id.lineConsMatFloor);
         VlblConsMatFloor=(TextView) findViewById(R.id.VlblConsMatFloor);
         spnConsMatFloor=(Spinner) findViewById(R.id.spnConsMatFloor);


         chkRentOfDwellDK.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 txtRentOfDwelling.setText("");

             }
         });
         txtRentOfDwelling.addTextChangedListener(new TextWatcher() {
             @Override
             public void beforeTextChanged(CharSequence s, int start, int count, int after) {

             }

             @Override
             public void onTextChanged(CharSequence s, int start, int before, int count) {
                 if(txtRentOfDwelling.getText().toString().length()>0)
                 {
                     chkRentOfDwellDK.setChecked(false);
                 }

             }

             @Override
             public void afterTextChanged(Editable s) {

             }
         });


         List<String> listConsMatFloor = new ArrayList<String>();
         
         listConsMatFloor.add("");
         listConsMatFloor.add("1-মাটি/বাঁশ (কাঁচা) (Natural floor)");
         listConsMatFloor.add("2-কাঠ  (Rudimentary floor) 	");
         listConsMatFloor.add("3-ইট/ সিমেন্ট/ পাকা (Brick/Cement/Finished floor (pukka))");
         listConsMatFloor.add("7-অন্যান্য");
         ArrayAdapter<String> adptrConsMatFloor= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listConsMatFloor);
         spnConsMatFloor.setAdapter(adptrConsMatFloor);

         spnConsMatFloor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnConsMatFloor.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnConsMatFloor.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("1"))
                 {
                    secConsMatFloorOth.setVisibility(View.GONE);
                    lineConsMatFloorOth.setVisibility(View.GONE);
                    txtConsMatFloorOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("2"))
                 {
                    secConsMatFloorOth.setVisibility(View.GONE);
                    lineConsMatFloorOth.setVisibility(View.GONE);
                    txtConsMatFloorOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("3"))
                 {
                    secConsMatFloorOth.setVisibility(View.GONE);
                    lineConsMatFloorOth.setVisibility(View.GONE);
                    txtConsMatFloorOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("7"))
                 {
                     secConsMatFloorOth.setVisibility(View.VISIBLE);
                     lineConsMatFloorOth.setVisibility(View.VISIBLE);
                 }
                 else
                 {
                     secConsMatFloorOth.setVisibility(View.GONE);
                     lineConsMatFloorOth.setVisibility(View.GONE);
                     txtConsMatFloorOth.setText("");
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secConsMatFloorOth=(LinearLayout)findViewById(R.id.secConsMatFloorOth);
         lineConsMatFloorOth=(View)findViewById(R.id.lineConsMatFloorOth);
         VlblConsMatFloorOth=(TextView) findViewById(R.id.VlblConsMatFloorOth);
         txtConsMatFloorOth=(EditText) findViewById(R.id.txtConsMatFloorOth);
         secConsMatWall=(LinearLayout)findViewById(R.id.secConsMatWall);
         lineConsMatWall=(View)findViewById(R.id.lineConsMatWall);
         VlblConsMatWall=(TextView) findViewById(R.id.VlblConsMatWall);
         spnConsMatWall=(Spinner) findViewById(R.id.spnConsMatWall);
         List<String> listConsMatWall = new ArrayList<String>();
         
         listConsMatWall.add("");
         listConsMatWall.add("1-দেয়াল নেই (No walls)");
         listConsMatWall.add("2-বাঁশ/ বেত/ লতা/ পাতা (Bamboo/cane/palm/leaves)");
         listConsMatWall.add("3-কাদা/ মাটি (Dirt/mud/uncovered adobe)");
         listConsMatWall.add("4-কার্ড বোর্ড (Cardboard)");
         listConsMatWall.add("5-পুরনো কাঠ/ প্লাই উড (Plywood/reused wood/unfinished wood)");
         listConsMatWall.add("6-কাঠের তক্তা (Wood planks/shingles)");
         listConsMatWall.add("7-টিন (Metal sheets)");
         listConsMatWall.add("8-কাচা ইট (Unbaked bricks)");
         listConsMatWall.add("9-মাটি দিয়ে যুক্ত ইট/পাথর (Mud-bonded bricks/stone)");
         listConsMatWall.add("10-সিমেন্ট দিয়ে যুক্ত ইট/পাথর (Cement-bonded bricks/stone)");
         listConsMatWall.add("11-সিমেন্ট/ সিমেন্ট ব্লক (Cement/cement blocks)");
         listConsMatWall.add("77-অন্যান্য (Other)");
         ArrayAdapter<String> adptrConsMatWall= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listConsMatWall);
         spnConsMatWall.setAdapter(adptrConsMatWall);

         spnConsMatWall.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnConsMatWall.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnConsMatWall.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("1"))
                 {
                    secConsMatWallOth.setVisibility(View.GONE);
                    lineConsMatWallOth.setVisibility(View.GONE);
                    txtConsMatWallOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("2"))
                 {
                    secConsMatWallOth.setVisibility(View.GONE);
                    lineConsMatWallOth.setVisibility(View.GONE);
                    txtConsMatWallOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("3"))
                 {
                    secConsMatWallOth.setVisibility(View.GONE);
                    lineConsMatWallOth.setVisibility(View.GONE);
                    txtConsMatWallOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("4"))
                 {
                    secConsMatWallOth.setVisibility(View.GONE);
                    lineConsMatWallOth.setVisibility(View.GONE);
                    txtConsMatWallOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("5"))
                 {
                    secConsMatWallOth.setVisibility(View.GONE);
                    lineConsMatWallOth.setVisibility(View.GONE);
                    txtConsMatWallOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("6"))
                 {
                    secConsMatWallOth.setVisibility(View.GONE);
                    lineConsMatWallOth.setVisibility(View.GONE);
                    txtConsMatWallOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("7"))
                 {
                    secConsMatWallOth.setVisibility(View.GONE);
                    lineConsMatWallOth.setVisibility(View.GONE);
                    txtConsMatWallOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("8"))
                 {
                    secConsMatWallOth.setVisibility(View.GONE);
                    lineConsMatWallOth.setVisibility(View.GONE);
                    txtConsMatWallOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("9"))
                 {
                    secConsMatWallOth.setVisibility(View.GONE);
                    lineConsMatWallOth.setVisibility(View.GONE);
                    txtConsMatWallOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("10"))
                 {
                    secConsMatWallOth.setVisibility(View.GONE);
                    lineConsMatWallOth.setVisibility(View.GONE);
                    txtConsMatWallOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("11"))
                 {
                    secConsMatWallOth.setVisibility(View.GONE);
                    lineConsMatWallOth.setVisibility(View.GONE);
                    txtConsMatWallOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("77"))
                 {
                     secConsMatWallOth.setVisibility(View.VISIBLE);
                     lineConsMatWallOth.setVisibility(View.VISIBLE);
                 }
                 else
                 {
                     secConsMatWallOth.setVisibility(View.GONE);
                     lineConsMatWallOth.setVisibility(View.GONE);
                     txtConsMatWallOth.setText("");
                 }

             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secConsMatWallOth=(LinearLayout)findViewById(R.id.secConsMatWallOth);
         lineConsMatWallOth=(View)findViewById(R.id.lineConsMatWallOth);
         VlblConsMatWallOth=(TextView) findViewById(R.id.VlblConsMatWallOth);
         txtConsMatWallOth=(EditText) findViewById(R.id.txtConsMatWallOth);
         secConsMatRoof=(LinearLayout)findViewById(R.id.secConsMatRoof);
         lineConsMatRoof=(View)findViewById(R.id.lineConsMatRoof);
         VlblConsMatRoof=(TextView) findViewById(R.id.VlblConsMatRoof);
         spnConsMatRoof=(Spinner) findViewById(R.id.spnConsMatRoof);
         List<String> listConsMatRoof = new ArrayList<String>();
         
         listConsMatRoof.add("");
         listConsMatRoof.add("1-ছাদ নেই (No walls)");
         listConsMatRoof.add("2-বাঁশ/ বেত/ লতা/ পাতা (Bamboo/cane/palm/leaves)");
         listConsMatRoof.add("3-ঘাসের চাপড়া (Sod)");
         listConsMatRoof.add("4-কার্ড বোর্ড (Cardboard)");
         listConsMatRoof.add("5-পুরনো কাঠ/ প্লাই উড (Plywood/reused wood/unfinished wood)");
         listConsMatRoof.add("6-কাঠের তক্তা (Wood planks)");
         listConsMatRoof.add("7- টিন (Metal sheets)");
         listConsMatRoof.add("8-মাদুর (Mats)");
         listConsMatRoof.add("9-সিরামিক টাইলস (Ceramic tile)");
         listConsMatRoof.add("10-কাঠের তক্তা (Roofing shingles)");
         listConsMatRoof.add("11-সিমেন্ট (Cement)");
         listConsMatRoof.add("77-অন্যান্য (Other)");
         ArrayAdapter<String> adptrConsMatRoof= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listConsMatRoof);
         spnConsMatRoof.setAdapter(adptrConsMatRoof);

         spnConsMatRoof.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnConsMatRoof.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnConsMatRoof.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("1"))
                 {
                    secConsMatRoofOth.setVisibility(View.GONE);
                    lineConsMatRoofOth.setVisibility(View.GONE);
                    txtConsMatRoofOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("2"))
                 {
                    secConsMatRoofOth.setVisibility(View.GONE);
                    lineConsMatRoofOth.setVisibility(View.GONE);
                    txtConsMatRoofOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("3"))
                 {
                    secConsMatRoofOth.setVisibility(View.GONE);
                    lineConsMatRoofOth.setVisibility(View.GONE);
                    txtConsMatRoofOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("4"))
                 {
                    secConsMatRoofOth.setVisibility(View.GONE);
                    lineConsMatRoofOth.setVisibility(View.GONE);
                    txtConsMatRoofOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("5"))
                 {
                    secConsMatRoofOth.setVisibility(View.GONE);
                    lineConsMatRoofOth.setVisibility(View.GONE);
                    txtConsMatRoofOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("6"))
                 {
                    secConsMatRoofOth.setVisibility(View.GONE);
                    lineConsMatRoofOth.setVisibility(View.GONE);
                    txtConsMatRoofOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("7"))
                 {
                    secConsMatRoofOth.setVisibility(View.GONE);
                    lineConsMatRoofOth.setVisibility(View.GONE);
                    txtConsMatRoofOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("8"))
                 {
                    secConsMatRoofOth.setVisibility(View.GONE);
                    lineConsMatRoofOth.setVisibility(View.GONE);
                    txtConsMatRoofOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("9"))
                 {
                    secConsMatRoofOth.setVisibility(View.GONE);
                    lineConsMatRoofOth.setVisibility(View.GONE);
                    txtConsMatRoofOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("10"))
                 {
                    secConsMatRoofOth.setVisibility(View.GONE);
                    lineConsMatRoofOth.setVisibility(View.GONE);
                    txtConsMatRoofOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("11"))
                 {
                    secConsMatRoofOth.setVisibility(View.GONE);
                    lineConsMatRoofOth.setVisibility(View.GONE);
                    txtConsMatRoofOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("77"))
                 {
                     secConsMatRoofOth.setVisibility(View.VISIBLE);
                     lineConsMatRoofOth.setVisibility(View.VISIBLE);
                 }
                 else
                 {
                     secConsMatRoofOth.setVisibility(View.GONE);
                     lineConsMatRoofOth.setVisibility(View.GONE);
                     txtConsMatRoofOth.setText("");

                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secConsMatRoofOth=(LinearLayout)findViewById(R.id.secConsMatRoofOth);
         lineConsMatRoofOth=(View)findViewById(R.id.lineConsMatRoofOth);
         VlblConsMatRoofOth=(TextView) findViewById(R.id.VlblConsMatRoofOth);
         txtConsMatRoofOth=(EditText) findViewById(R.id.txtConsMatRoofOth);
         secFuel=(LinearLayout)findViewById(R.id.secFuel);
         lineFuel=(View)findViewById(R.id.lineFuel);
         VlblFuel=(TextView) findViewById(R.id.VlblFuel);
         spnFuel=(Spinner) findViewById(R.id.spnFuel);
         List<String> listFuel = new ArrayList<String>();
         
         listFuel.add("");
         listFuel.add("1-কাঠ (Wood)");
         listFuel.add("2-শস্যের অবশিষ্টাংশ/ঘাস (Residue harvest/grass)");
         listFuel.add("3-শুকনা গোবর(Animal residue)");
         listFuel.add("4-কয়লা (Charcoal)");
         listFuel.add("5-কাঠ কয়লা (Firewood)");
         listFuel.add("6-কেরোসিন (Kerosene)");
         listFuel.add("7-বিদ্যুৎ (Electricity)");
         listFuel.add("8-তরল গ্যাস/প্রাকৃতিক গ্যাস (Natural Gas/LPG/LNG)");
         listFuel.add("9-বায়ো-গ্যাস(Biogas)");
         listFuel.add("97-অন্যান্য(Others) ");
         listFuel.add("98-জানি না (Don’t know)");
         ArrayAdapter<String> adptrFuel= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listFuel);
         spnFuel.setAdapter(adptrFuel);

         spnFuel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnFuel.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnFuel.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("1"))
                 {
                    secFuelOth.setVisibility(View.GONE);
                    lineFuelOth.setVisibility(View.GONE);
                    txtFuelOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("2"))
                 {
                    secFuelOth.setVisibility(View.GONE);
                    lineFuelOth.setVisibility(View.GONE);
                    txtFuelOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("3"))
                 {
                    secFuelOth.setVisibility(View.GONE);
                    lineFuelOth.setVisibility(View.GONE);
                    txtFuelOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("4"))
                 {
                    secFuelOth.setVisibility(View.GONE);
                    lineFuelOth.setVisibility(View.GONE);
                    txtFuelOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("5"))
                 {
                    secFuelOth.setVisibility(View.GONE);
                    lineFuelOth.setVisibility(View.GONE);
                    txtFuelOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("6"))
                 {
                    secFuelOth.setVisibility(View.GONE);
                    lineFuelOth.setVisibility(View.GONE);
                    txtFuelOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("7"))
                 {
                    secFuelOth.setVisibility(View.GONE);
                    lineFuelOth.setVisibility(View.GONE);
                    txtFuelOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("8"))
                 {
                    secFuelOth.setVisibility(View.GONE);
                    lineFuelOth.setVisibility(View.GONE);
                    txtFuelOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("9"))
                 {
                    secFuelOth.setVisibility(View.GONE);
                    lineFuelOth.setVisibility(View.GONE);
                    txtFuelOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("98"))
                 {
                    secFuelOth.setVisibility(View.GONE);
                    lineFuelOth.setVisibility(View.GONE);
                    txtFuelOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("97"))
                 {
                     secFuelOth.setVisibility(View.VISIBLE);
                     secFuelOth.setVisibility(View.VISIBLE);
                 }
                 else {
                     secFuelOth.setVisibility(View.GONE);
                     secFuelOth.setVisibility(View.GONE);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secFuelOth=(LinearLayout)findViewById(R.id.secFuelOth);
         lineFuelOth=(View)findViewById(R.id.lineFuelOth);
         VlblFuelOth=(TextView) findViewById(R.id.VlblFuelOth);
         txtFuelOth=(EditText) findViewById(R.id.txtFuelOth);
         secTypeOfToilet=(LinearLayout)findViewById(R.id.secTypeOfToilet);
         lineTypeOfToilet=(View)findViewById(R.id.lineTypeOfToilet);
         VlblTypeOfToilet=(TextView) findViewById(R.id.VlblTypeOfToilet);
         spnTypeOfToilet=(Spinner) findViewById(R.id.spnTypeOfToilet);
         List<String> listTypeOfToilet = new ArrayList<String>();
         
         listTypeOfToilet.add("");
         listTypeOfToilet.add("1-ফ্লাশ-টয়েলেট, পয়ঃনিষ্কাশন পাইপের সাথে সংযোগ করে দেয়া (Household flush (piped water or pour flush) to sewer system)");
         listTypeOfToilet.add("2-ফ্লাশ-টয়েলেট, সেপটিক ট্যাংক এর সাথে সংযোগ করে দেয়া (Household flush (piped water or pour flush) to septic tank)");
         listTypeOfToilet.add("3-ফ্লাশ-টয়েলেট, অন্য কোথাও সংযোগ করে দেয়া (Household flush (piped water or pour flush) to somewhere else)");
         listTypeOfToilet.add("4-পিট-টয়লেট (ওয়াটার সিল আছে) (Household pit latrine (water sealed))");
         listTypeOfToilet.add("5-পিট-টয়লেট (ওয়াটার সিল নেই)(Household pit latrine (not water sealed))");
         listTypeOfToilet.add("6-বালতি/ ঝুলন্ত পায়খানা (Household bucket or hanging toilet)");
         listTypeOfToilet.add("7-পাড়ার পায়খানা (Communal toilet or latrine)");
         listTypeOfToilet.add("8-কোন পায়খানা নেই/জঙ্গলে/ঝোপে ঝাড়ে/ খোলা জায়গায় (No toilet/bush/field)");
         listTypeOfToilet.add("9-অন্যান্য(Other)");
         ArrayAdapter<String> adptrTypeOfToilet= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listTypeOfToilet);
         spnTypeOfToilet.setAdapter(adptrTypeOfToilet);

         spnTypeOfToilet.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnTypeOfToilet.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnTypeOfToilet.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("1"))
                 {
                    secTypeOfToiletOth.setVisibility(View.GONE);
                    lineTypeOfToiletOth.setVisibility(View.GONE);
                    txtTypeOfToiletOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("2"))
                 {
                    secTypeOfToiletOth.setVisibility(View.GONE);
                    lineTypeOfToiletOth.setVisibility(View.GONE);
                    txtTypeOfToiletOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("3"))
                 {
                    secTypeOfToiletOth.setVisibility(View.GONE);
                    lineTypeOfToiletOth.setVisibility(View.GONE);
                    txtTypeOfToiletOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("4"))
                 {
                    secTypeOfToiletOth.setVisibility(View.GONE);
                    lineTypeOfToiletOth.setVisibility(View.GONE);
                    txtTypeOfToiletOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("5"))
                 {
                    secTypeOfToiletOth.setVisibility(View.GONE);
                    lineTypeOfToiletOth.setVisibility(View.GONE);
                    txtTypeOfToiletOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("6"))
                 {
                    secTypeOfToiletOth.setVisibility(View.GONE);
                    lineTypeOfToiletOth.setVisibility(View.GONE);
                    txtTypeOfToiletOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("7"))
                 {
                    secTypeOfToiletOth.setVisibility(View.GONE);
                    lineTypeOfToiletOth.setVisibility(View.GONE);
                    txtTypeOfToiletOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("8"))
                 {
                    secTypeOfToiletOth.setVisibility(View.GONE);
                    lineTypeOfToiletOth.setVisibility(View.GONE);
                    txtTypeOfToiletOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("9"))
                 {
                    secTypeOfToiletOth.setVisibility(View.VISIBLE);
                    lineTypeOfToiletOth.setVisibility(View.VISIBLE);
                 }
                 else
                 {
                     secTypeOfToiletOth.setVisibility(View.GONE);
                     lineTypeOfToiletOth.setVisibility(View.GONE);
                     txtTypeOfToiletOth.setText("");
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secTypeOfToiletOth=(LinearLayout)findViewById(R.id.secTypeOfToiletOth);
         lineTypeOfToiletOth=(View)findViewById(R.id.lineTypeOfToiletOth);
         VlblTypeOfToiletOth=(TextView) findViewById(R.id.VlblTypeOfToiletOth);
         txtTypeOfToiletOth=(EditText) findViewById(R.id.txtTypeOfToiletOth);
         secTypeOfChildToilet=(LinearLayout)findViewById(R.id.secTypeOfChildToilet);
         lineTypeOfChildToilet=(View)findViewById(R.id.lineTypeOfChildToilet);
         VlblTypeOfChildToilet=(TextView) findViewById(R.id.VlblTypeOfChildToilet);
         spnTypeOfChildToilet=(Spinner) findViewById(R.id.spnTypeOfChildToilet);
         List<String> listTypeOfChildToilet = new ArrayList<String>();
         
         listTypeOfChildToilet.add("");
         listTypeOfChildToilet.add("1-টয়লেটিতে পয়ঃনিষ্কাশন পাইপের সাথে সংযোগ করে দেয়া (Toilet with piped latrine)");
         listTypeOfChildToilet.add("2-টয়লেটিতে সেপটিক ট্যাংক বসানো আছে  (Toilet with septic tank)");
         listTypeOfChildToilet.add("3-সেপটিক ট্যাংক নাই কিন্তু ফ্লাস করে বা পানি ঢেলে পায়খানা দুরে পিটের মধ্যে সরিয়ে দেয়া যায়   (Toilet without septic tank but with water drainage system) ");
         listTypeOfChildToilet.add("4-পিট-টয়লেট (স্লাব এবং ওয়াটার সিল আছে) (Pit latrine with slab and water sealed)");
         listTypeOfChildToilet.add("5-পিট-টয়লেট (স্লাব আছে কিন্তু ওয়াটার সিল নেই তবে ঢাকনা দেয়ার ব্যবস্থা আছে) (Pit latrine not water sealed but with slab)");
         listTypeOfChildToilet.add("6-কমপোষ্টিং টয়লেট (Composting toilet) (পায়খানা এবং প্রস্রাব করার জন্য আলাদা আলাদা ঘর এবং সাথে আলাদা কোথাও পানির ব্যাবস্থা আছে)  (Separate toilet for micturation and defaecation with separate water supply)");
         listTypeOfChildToilet.add("7-ফ্লাশ-টয়েলেট অথবা পানি ঢেলে ফ্লাস করা টয়লেট যা কোন খাল, ড্রেন, নদী ইত্যাদির সাথে সংযোজন  (Flash toilet or water drainage system to local lake/pond/river which creats nuisance)");
         listTypeOfChildToilet.add("8-পিট/গর্ত পায়খানা, স্লাব নেই এবং যেখান থেকে মশা/মাছি যাওয়া আসা করতে পারে এবং দূর্গন্ধ ছড়ায় (Pit latrine without slab and which creats free movements for flies/mosquitoes ");
         listTypeOfChildToilet.add("and nuisance)");
         listTypeOfChildToilet.add("9-পিট/গর্ত পায়খানা স্লাব আছে তবে,ওয়াটার সিল নেই অথবা ওয়াটার সিল ভাঙ্গা এবং কোন ঢাকনাও নেই");
         listTypeOfChildToilet.add("(Pit latrine with slab but not water sealed/broken water seal system and without");
         listTypeOfChildToilet.add(" cover)");
         listTypeOfChildToilet.add("10-ঝুলন্ত পায়খানা (Hanging latrine)");
         listTypeOfChildToilet.add("11- কোন পায়খানা নেই/জঙ্গলে/ঝোপে ঝাড়ে/ খোলা জায়গায় (No latrine system/open place)");
         listTypeOfChildToilet.add("12-পট  (Pot)");
         listTypeOfChildToilet.add("13-ন্যাপী/ ডাইপার (Nappy/Diaper)");
         listTypeOfChildToilet.add("14-নির্দিষ্ট কোন স্থান নেই (No fixed place)");
         listTypeOfChildToilet.add("77-অন্যান্য (Other)");
         listTypeOfChildToilet.add("97-জানি না (Don’t know)");
         listTypeOfChildToilet.add("98-প্রযোজ্য নয়");
         ArrayAdapter<String> adptrTypeOfChildToilet= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listTypeOfChildToilet);
         spnTypeOfChildToilet.setAdapter(adptrTypeOfChildToilet);

         spnTypeOfChildToilet.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnTypeOfChildToilet.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnTypeOfChildToilet.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("1"))
                 {
                    secTypeOfChildToiletOth.setVisibility(View.GONE);
                    lineTypeOfChildToiletOth.setVisibility(View.GONE);
                    txtTypeOfChildToiletOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("2"))
                 {
                    secTypeOfChildToiletOth.setVisibility(View.GONE);
                    lineTypeOfChildToiletOth.setVisibility(View.GONE);
                    txtTypeOfChildToiletOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("3"))
                 {
                    secTypeOfChildToiletOth.setVisibility(View.GONE);
                    lineTypeOfChildToiletOth.setVisibility(View.GONE);
                    txtTypeOfChildToiletOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("4"))
                 {
                    secTypeOfChildToiletOth.setVisibility(View.GONE);
                    lineTypeOfChildToiletOth.setVisibility(View.GONE);
                    txtTypeOfChildToiletOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("5"))
                 {
                    secTypeOfChildToiletOth.setVisibility(View.GONE);
                    lineTypeOfChildToiletOth.setVisibility(View.GONE);
                    txtTypeOfChildToiletOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("6"))
                 {
                    secTypeOfChildToiletOth.setVisibility(View.GONE);
                    lineTypeOfChildToiletOth.setVisibility(View.GONE);
                    txtTypeOfChildToiletOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("7"))
                 {
                    secTypeOfChildToiletOth.setVisibility(View.GONE);
                    lineTypeOfChildToiletOth.setVisibility(View.GONE);
                    txtTypeOfChildToiletOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("8"))
                 {
                    secTypeOfChildToiletOth.setVisibility(View.GONE);
                    lineTypeOfChildToiletOth.setVisibility(View.GONE);
                    txtTypeOfChildToiletOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("9"))
                 {
                    secTypeOfChildToiletOth.setVisibility(View.GONE);
                    lineTypeOfChildToiletOth.setVisibility(View.GONE);
                    txtTypeOfChildToiletOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("10"))
                 {
                    secTypeOfChildToiletOth.setVisibility(View.GONE);
                    lineTypeOfChildToiletOth.setVisibility(View.GONE);
                    txtTypeOfChildToiletOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("11"))
                 {
                    secTypeOfChildToiletOth.setVisibility(View.GONE);
                    lineTypeOfChildToiletOth.setVisibility(View.GONE);
                    txtTypeOfChildToiletOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("12"))
                 {
                    secTypeOfChildToiletOth.setVisibility(View.GONE);
                    lineTypeOfChildToiletOth.setVisibility(View.GONE);
                    txtTypeOfChildToiletOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("13"))
                 {
                    secTypeOfChildToiletOth.setVisibility(View.GONE);
                    lineTypeOfChildToiletOth.setVisibility(View.GONE);
                    txtTypeOfChildToiletOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("14"))
                 {
                    secTypeOfChildToiletOth.setVisibility(View.GONE);
                    lineTypeOfChildToiletOth.setVisibility(View.GONE);
                    txtTypeOfChildToiletOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("97"))
                 {
                    secTypeOfChildToiletOth.setVisibility(View.GONE);
                    lineTypeOfChildToiletOth.setVisibility(View.GONE);
                    txtTypeOfChildToiletOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("98"))
                 {
                    secTypeOfChildToiletOth.setVisibility(View.GONE);
                    lineTypeOfChildToiletOth.setVisibility(View.GONE);
                    txtTypeOfChildToiletOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("77"))
                 {
                    secTypeOfChildToiletOth.setVisibility(View.VISIBLE);
                    lineTypeOfChildToiletOth.setVisibility(View.VISIBLE);
                 }
                 else
                     {
                         secTypeOfChildToiletOth.setVisibility(View.GONE);
                         lineTypeOfChildToiletOth.setVisibility(View.GONE);
                         txtTypeOfChildToiletOth.setText("");

                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secTypeOfChildToiletOth=(LinearLayout)findViewById(R.id.secTypeOfChildToiletOth);
         lineTypeOfChildToiletOth=(View)findViewById(R.id.lineTypeOfChildToiletOth);
         VlblTypeOfChildToiletOth=(TextView) findViewById(R.id.VlblTypeOfChildToiletOth);
         txtTypeOfChildToiletOth=(EditText) findViewById(R.id.txtTypeOfChildToiletOth);
         secToiletShare=(LinearLayout)findViewById(R.id.secToiletShare);
         lineToiletShare=(View)findViewById(R.id.lineToiletShare);
         VlblToiletShare=(TextView) findViewById(R.id.VlblToiletShare);
         spnToiletShare=(Spinner) findViewById(R.id.spnToiletShare);
         List<String> listToiletShare = new ArrayList<String>();
         
         listToiletShare.add("");
         listToiletShare.add("1-একজন (Individual)");
         listToiletShare.add("2-দুইজন (Two)");
         listToiletShare.add("3- তিন- পাঁচজন (3 to 5)");
         listToiletShare.add("4-পাঁচজনের বেশি (More than 5)");
         ArrayAdapter<String> adptrToiletShare= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listToiletShare);
         spnToiletShare.setAdapter(adptrToiletShare);

         secSOfDrinkingWater=(LinearLayout)findViewById(R.id.secSOfDrinkingWater);
         lineSOfDrinkingWater=(View)findViewById(R.id.lineSOfDrinkingWater);
         VlblSOfDrinkingWater=(TextView) findViewById(R.id.VlblSOfDrinkingWater);
         spnSOfDrinkingWater=(Spinner) findViewById(R.id.spnSOfDrinkingWater);
         List<String> listSOfDrinkingWater = new ArrayList<String>();
         
         listSOfDrinkingWater.add("");
         listSOfDrinkingWater.add("1-বাসায় পাইপ যোগে (Piped into dwelling)");
         listSOfDrinkingWater.add("2-উঠানে পাইপ যোগে (Piped into yard/plot but not into dwelling)");
         listSOfDrinkingWater.add("3-পাবলিক/সরকারি কল (Public tap/standpipe)");
         listSOfDrinkingWater.add("4-টিউব অয়েল (Tube well/borehole)");
         listSOfDrinkingWater.add("5-কুয়া (ঢাকনা দেয়া) (Covered well)");
         listSOfDrinkingWater.add("6-কুয়া (খোলা) (Open well)");
         listSOfDrinkingWater.add("7-পুকুর/ঝরনার পানি (Surface water (spring, lake, pond))");
         listSOfDrinkingWater.add("8-বৃষ্টির পানি (Rainwater)");
         listSOfDrinkingWater.add("9-গাড়ির পানি (Truck or cart with tank)");
         listSOfDrinkingWater.add("10-বোতলজাত পানি (Bottled water) ");
         listSOfDrinkingWater.add("11-অন্যান্য (Other)");
         ArrayAdapter<String> adptrSOfDrinkingWater= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listSOfDrinkingWater);
         spnSOfDrinkingWater.setAdapter(adptrSOfDrinkingWater);

         secTimeToWalkInMin=(LinearLayout)findViewById(R.id.secTimeToWalkInMin);
         lineTimeToWalkInMin=(View)findViewById(R.id.lineTimeToWalkInMin);
         VlblTimeToWalkInMin=(TextView) findViewById(R.id.VlblTimeToWalkInMin);
         txtTimeToWalkInMin=(EditText) findViewById(R.id.txtTimeToWalkInMin);
         secTimeToWalkInHours=(LinearLayout)findViewById(R.id.secTimeToWalkInHours);
         lineTimeToWalkInHours=(View)findViewById(R.id.lineTimeToWalkInHours);
         VlblTimeToWalkInHours=(TextView) findViewById(R.id.VlblTimeToWalkInHours);
         txtTimeToWalkInHours=(EditText) findViewById(R.id.txtTimeToWalkInHours);
         secWeeklyWSupplyInHour=(LinearLayout)findViewById(R.id.secWeeklyWSupplyInHour);
         lineWeeklyWSupplyInHour=(View)findViewById(R.id.lineWeeklyWSupplyInHour);
         VlblWeeklyWSupplyInHour=(TextView) findViewById(R.id.VlblWeeklyWSupplyInHour);
         txtWeeklyWSupplyInHour=(EditText) findViewById(R.id.txtWeeklyWSupplyInHour);
         secWeeklyWSuppHouse=(LinearLayout)findViewById(R.id.secWeeklyWSuppHouse);
         lineWeeklyWSuppHouse=(View)findViewById(R.id.lineWeeklyWSuppHouse);
         VlblWeeklyWSuppHouse=(TextView) findViewById(R.id.VlblWeeklyWSuppHouse);
         txtWeeklyWSuppHouse=(EditText) findViewById(R.id.txtWeeklyWSuppHouse);
         secTreatDKWater=(LinearLayout)findViewById(R.id.secTreatDKWater);
         lineTreatDKWater=(View)findViewById(R.id.lineTreatDKWater);
         VlblTreatDKWater = (TextView) findViewById(R.id.VlblTreatDKWater);
         rdogrpTreatDKWater = (RadioGroup) findViewById(R.id.rdogrpTreatDKWater);
         
         rdoTreatDKWater1 = (RadioButton) findViewById(R.id.rdoTreatDKWater1);
         rdoTreatDKWater2 = (RadioButton) findViewById(R.id.rdoTreatDKWater2);
         secTreatMeth=(LinearLayout)findViewById(R.id.secTreatMeth);
         lineTreatMeth=(View)findViewById(R.id.lineTreatMeth);
         VlblTreatMeth=(TextView) findViewById(R.id.VlblTreatMeth);
         spnTreatMeth=(Spinner) findViewById(R.id.spnTreatMeth);

         rdogrpTreatDKWater.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId) {
                 String rbData = "";
                 RadioButton rb;
                 String[] d_rdogrpTreatDKWater = new String[] {"1","2","7"};
                 for (int i = 0; i < rdogrpTreatDKWater.getChildCount(); i++)
                 {
                     rb = (RadioButton)rdogrpTreatDKWater.getChildAt(i);
                     if (rb.isChecked()) rbData = d_rdogrpTreatDKWater[i];
                 }

                 if(rbData.equalsIgnoreCase("2"))
                 {
                     secTreatMeth.setVisibility(View.GONE);
                     lineTreatMeth.setVisibility(View.GONE);
                 }
                 else if(rbData.equalsIgnoreCase("1"))
                 {
                     secTreatMeth.setVisibility(View.VISIBLE);
                     lineTreatMeth.setVisibility(View.VISIBLE);
                 }
                 else{
                     secTreatMeth.setVisibility(View.GONE);
                     lineTreatMeth.setVisibility(View.GONE);
                 }
             }
         });


         List<String> listTreatMeth = new ArrayList<String>();
         
         listTreatMeth.add("");
         listTreatMeth.add("1-রোদে রেখে (Leave water in sun to disinfect)");
         listTreatMeth.add("2-ফুটিয়ে (Boil)");
         listTreatMeth.add("3-কাপড়ে ফিলটারে ছেঁকে (Filter through a cloth)");
         listTreatMeth.add("4-ক্লোরিন তরল/পাউডার/ ট্যাবলেট দিয়ে (Chlorine liquid, powder, or tablets)");
         listTreatMeth.add("5-ফিলটারে ছেঁকে (Filter through ceramic or other filter)");
         listTreatMeth.add("7-অন্যান্য (Other)");
         ArrayAdapter<String> adptrTreatMeth= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listTreatMeth);
         spnTreatMeth.setAdapter(adptrTreatMeth);

         secOpenSewers=(LinearLayout)findViewById(R.id.secOpenSewers);
         lineOpenSewers=(View)findViewById(R.id.lineOpenSewers);
         VlblOpenSewers = (TextView) findViewById(R.id.VlblOpenSewers);
         rdogrpOpenSewers = (RadioGroup) findViewById(R.id.rdogrpOpenSewers);
         
         rdoOpenSewers1 = (RadioButton) findViewById(R.id.rdoOpenSewers1);
         rdoOpenSewers2 = (RadioButton) findViewById(R.id.rdoOpenSewers2);
         secObserve=(LinearLayout)findViewById(R.id.secObserve);
         lineObserve=(View)findViewById(R.id.lineObserve);
         secHandwash=(LinearLayout)findViewById(R.id.secHandwash);
         lineHandwash=(View)findViewById(R.id.lineHandwash);
         VlblHandwash = (TextView) findViewById(R.id.VlblHandwash);
         rdogrpHandwash = (RadioGroup) findViewById(R.id.rdogrpHandwash);
         
         rdoHandwash1 = (RadioButton) findViewById(R.id.rdoHandwash1);
         rdoHandwash2 = (RadioButton) findViewById(R.id.rdoHandwash2);
         rdoHandwash3 = (RadioButton) findViewById(R.id.rdoHandwash3);
         secWater=(LinearLayout)findViewById(R.id.secWater);
         lineWater=(View)findViewById(R.id.lineWater);
         VlblWater = (TextView) findViewById(R.id.VlblWater);
         rdogrpWater = (RadioGroup) findViewById(R.id.rdogrpWater);
         
         rdoWater1 = (RadioButton) findViewById(R.id.rdoWater1);
         rdoWater2 = (RadioButton) findViewById(R.id.rdoWater2);
         rdoWater3 = (RadioButton) findViewById(R.id.rdoWater3);





         //Hide all skip variables
         secRelWithFHead.setVisibility(View.GONE);
         lineRelWithFHead.setVisibility(View.GONE);
         secOthRelWithFHead.setVisibility(View.GONE);
         lineOthRelWithFHead.setVisibility(View.GONE);
         secChildHcareOth.setVisibility(View.GONE);
         lineChildHcareOth.setVisibility(View.GONE);
         secChildHcareOth.setVisibility(View.GONE);
         lineChildHcareOth.setVisibility(View.GONE);
         secChildHcareOth.setVisibility(View.GONE);
         lineChildHcareOth.setVisibility(View.GONE);
         secChildHcareOth.setVisibility(View.GONE);
         lineChildHcareOth.setVisibility(View.GONE);
         secChildHcareOth.setVisibility(View.GONE);
         lineChildHcareOth.setVisibility(View.GONE);
         secChildHcareOth.setVisibility(View.GONE);
         lineChildHcareOth.setVisibility(View.GONE);
         secChildHcareOth.setVisibility(View.GONE);
         lineChildHcareOth.setVisibility(View.GONE);
         secChildHcareOth.setVisibility(View.GONE);
         lineChildHcareOth.setVisibility(View.GONE);
         secChildHcareOth.setVisibility(View.GONE);
         lineChildHcareOth.setVisibility(View.GONE);
         secChildHcareOth.setVisibility(View.GONE);
         lineChildHcareOth.setVisibility(View.GONE);
         secChildHcareOth.setVisibility(View.GONE);
         lineChildHcareOth.setVisibility(View.GONE);
         secChildHcareOth.setVisibility(View.GONE);
         lineChildHcareOth.setVisibility(View.GONE);
//         secHeadOcpOth.setVisibility(View.GONE);
//         lineHeadOcpOth.setVisibility(View.GONE);
         secConsMatFloorOth.setVisibility(View.GONE);
         lineConsMatFloorOth.setVisibility(View.GONE);
         secConsMatFloorOth.setVisibility(View.GONE);
         lineConsMatFloorOth.setVisibility(View.GONE);
         secConsMatFloorOth.setVisibility(View.GONE);
         lineConsMatFloorOth.setVisibility(View.GONE);
         secConsMatWallOth.setVisibility(View.GONE);
         lineConsMatWallOth.setVisibility(View.GONE);
         secConsMatWallOth.setVisibility(View.GONE);
         lineConsMatWallOth.setVisibility(View.GONE);
         secConsMatWallOth.setVisibility(View.GONE);
         lineConsMatWallOth.setVisibility(View.GONE);
         secConsMatWallOth.setVisibility(View.GONE);
         lineConsMatWallOth.setVisibility(View.GONE);
         secConsMatWallOth.setVisibility(View.GONE);
         lineConsMatWallOth.setVisibility(View.GONE);
         secConsMatWallOth.setVisibility(View.GONE);
         lineConsMatWallOth.setVisibility(View.GONE);
         secConsMatWallOth.setVisibility(View.GONE);
         lineConsMatWallOth.setVisibility(View.GONE);
         secConsMatWallOth.setVisibility(View.GONE);
         lineConsMatWallOth.setVisibility(View.GONE);
         secConsMatWallOth.setVisibility(View.GONE);
         lineConsMatWallOth.setVisibility(View.GONE);
         secConsMatWallOth.setVisibility(View.GONE);
         lineConsMatWallOth.setVisibility(View.GONE);
         secConsMatWallOth.setVisibility(View.GONE);
         lineConsMatWallOth.setVisibility(View.GONE);
         secConsMatRoofOth.setVisibility(View.GONE);
         lineConsMatRoofOth.setVisibility(View.GONE);
         secConsMatRoofOth.setVisibility(View.GONE);
         lineConsMatRoofOth.setVisibility(View.GONE);
         secConsMatRoofOth.setVisibility(View.GONE);
         lineConsMatRoofOth.setVisibility(View.GONE);
         secConsMatRoofOth.setVisibility(View.GONE);
         lineConsMatRoofOth.setVisibility(View.GONE);
         secConsMatRoofOth.setVisibility(View.GONE);
         lineConsMatRoofOth.setVisibility(View.GONE);
         secConsMatRoofOth.setVisibility(View.GONE);
         lineConsMatRoofOth.setVisibility(View.GONE);
         secConsMatRoofOth.setVisibility(View.GONE);
         lineConsMatRoofOth.setVisibility(View.GONE);
         secConsMatRoofOth.setVisibility(View.GONE);
         lineConsMatRoofOth.setVisibility(View.GONE);
         secConsMatRoofOth.setVisibility(View.GONE);
         lineConsMatRoofOth.setVisibility(View.GONE);
         secConsMatRoofOth.setVisibility(View.GONE);
         lineConsMatRoofOth.setVisibility(View.GONE);
         secConsMatRoofOth.setVisibility(View.GONE);
         lineConsMatRoofOth.setVisibility(View.GONE);
         secFuelOth.setVisibility(View.GONE);
         lineFuelOth.setVisibility(View.GONE);
         secFuelOth.setVisibility(View.GONE);
         lineFuelOth.setVisibility(View.GONE);
         secFuelOth.setVisibility(View.GONE);
         lineFuelOth.setVisibility(View.GONE);
         secFuelOth.setVisibility(View.GONE);
         lineFuelOth.setVisibility(View.GONE);
         secFuelOth.setVisibility(View.GONE);
         lineFuelOth.setVisibility(View.GONE);
         secFuelOth.setVisibility(View.GONE);
         lineFuelOth.setVisibility(View.GONE);
         secFuelOth.setVisibility(View.GONE);
         lineFuelOth.setVisibility(View.GONE);
         secFuelOth.setVisibility(View.GONE);
         lineFuelOth.setVisibility(View.GONE);
         secFuelOth.setVisibility(View.GONE);
         lineFuelOth.setVisibility(View.GONE);
         secFuelOth.setVisibility(View.GONE);
         lineFuelOth.setVisibility(View.GONE);
         secTypeOfToiletOth.setVisibility(View.GONE);
         lineTypeOfToiletOth.setVisibility(View.GONE);
         secTypeOfToiletOth.setVisibility(View.GONE);
         lineTypeOfToiletOth.setVisibility(View.GONE);
         secTypeOfToiletOth.setVisibility(View.GONE);
         lineTypeOfToiletOth.setVisibility(View.GONE);
         secTypeOfToiletOth.setVisibility(View.GONE);
         lineTypeOfToiletOth.setVisibility(View.GONE);
         secTypeOfToiletOth.setVisibility(View.GONE);
         lineTypeOfToiletOth.setVisibility(View.GONE);
         secTypeOfToiletOth.setVisibility(View.GONE);
         lineTypeOfToiletOth.setVisibility(View.GONE);
         secTypeOfToiletOth.setVisibility(View.GONE);
         lineTypeOfToiletOth.setVisibility(View.GONE);
         secTypeOfToiletOth.setVisibility(View.GONE);
         lineTypeOfToiletOth.setVisibility(View.GONE);
         secTypeOfChildToiletOth.setVisibility(View.GONE);
         lineTypeOfChildToiletOth.setVisibility(View.GONE);
         secTypeOfChildToiletOth.setVisibility(View.GONE);
         lineTypeOfChildToiletOth.setVisibility(View.GONE);
         secTypeOfChildToiletOth.setVisibility(View.GONE);
         lineTypeOfChildToiletOth.setVisibility(View.GONE);
         secTypeOfChildToiletOth.setVisibility(View.GONE);
         lineTypeOfChildToiletOth.setVisibility(View.GONE);
         secTypeOfChildToiletOth.setVisibility(View.GONE);
         lineTypeOfChildToiletOth.setVisibility(View.GONE);
         secTypeOfChildToiletOth.setVisibility(View.GONE);
         lineTypeOfChildToiletOth.setVisibility(View.GONE);
         secTypeOfChildToiletOth.setVisibility(View.GONE);
         lineTypeOfChildToiletOth.setVisibility(View.GONE);
         secTypeOfChildToiletOth.setVisibility(View.GONE);
         lineTypeOfChildToiletOth.setVisibility(View.GONE);
         secTypeOfChildToiletOth.setVisibility(View.GONE);
         lineTypeOfChildToiletOth.setVisibility(View.GONE);
         secTypeOfChildToiletOth.setVisibility(View.GONE);
         lineTypeOfChildToiletOth.setVisibility(View.GONE);
         secTypeOfChildToiletOth.setVisibility(View.GONE);
         lineTypeOfChildToiletOth.setVisibility(View.GONE);
         secTypeOfChildToiletOth.setVisibility(View.GONE);
         lineTypeOfChildToiletOth.setVisibility(View.GONE);
         secTypeOfChildToiletOth.setVisibility(View.GONE);
         lineTypeOfChildToiletOth.setVisibility(View.GONE);
         secTypeOfChildToiletOth.setVisibility(View.GONE);
         lineTypeOfChildToiletOth.setVisibility(View.GONE);
         secTypeOfChildToiletOth.setVisibility(View.GONE);
         lineTypeOfChildToiletOth.setVisibility(View.GONE);
         secTypeOfChildToiletOth.setVisibility(View.GONE);
         lineTypeOfChildToiletOth.setVisibility(View.GONE);

         DataSearch(UNCODE,STRUCTURENO,HOUSEHOLDSL,VISITNO);




        Button cmdSave = (Button) findViewById(R.id.cmdSave);
        cmdSave.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) { 
            DataSave();


        }});
     }
     catch(Exception  e)
     {
         Connection.MessageBox(Household_Interview.this, e.getMessage());
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
             Connection.MessageBox(Household_Interview.this, "Required field: Ward.");
             txtUNCode.requestFocus(); 
             return;	
           }
         else if(txtStructureNo.getText().toString().length()==0 & secStructureNo.isShown())
           {
             Connection.MessageBox(Household_Interview.this, "Required field: Structure No.");
             txtStructureNo.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtStructureNo.getText().toString().length()==0 ? "1" : txtStructureNo.getText().toString()) < 1 || Integer.valueOf(txtStructureNo.getText().toString().length()==0 ? "99999" : txtStructureNo.getText().toString()) > 99999)
           {
             Connection.MessageBox(Household_Interview.this, "Value should be between 1 and 99999(Structure No).");
             txtStructureNo.requestFocus(); 
             return;	
           }
         else if(txtHouseholdSl.getText().toString().length()==0 & secHouseholdSl.isShown())
           {
             Connection.MessageBox(Household_Interview.this, "Required field: Household Sl.");
             txtHouseholdSl.requestFocus(); 
             return;	
           }
         else if(txtVisitNo.getText().toString().length()==0 & secVisitNo.isShown())
           {
             Connection.MessageBox(Household_Interview.this, "Required field: Visit No.");
             txtVisitNo.requestFocus(); 
             return;	
           }
         
         else if(!rdoFHeadAvail1.isChecked() & !rdoFHeadAvail2.isChecked() & secFHeadAvail.isShown())
           {
              Connection.MessageBox(Household_Interview.this, "Select anyone options from (মহিলা খানাপ্রধান বাসায় আছেন? (Was female head of household available?)).");
              rdoFHeadAvail1.requestFocus();
              return;
           }
         else if(spnRelWithFHead.getSelectedItemPosition()==0  & secRelWithFHead.isShown())
           {
             Connection.MessageBox(Household_Interview.this, "Required field: মহিলা খানা প্রধানের সাথে আপনার সম্পর্ক কি? (What is your relationship to the female head of the household?).");
             spnRelWithFHead.requestFocus(); 
             return;	
           }
         else if(txtOthRelWithFHead.getText().toString().length()==0 & secOthRelWithFHead.isShown())
           {
             Connection.MessageBox(Household_Interview.this, "Required field: অন্যান্য উল্লেখ করুন  (Others Specify).");
             txtOthRelWithFHead.requestFocus(); 
             return;	
           }
         else if(txtFirstName.getText().toString().length()==0 & secFirstName.isShown())
           {
             Connection.MessageBox(Household_Interview.this, "Required field: আপনার নাম কি? What is your first name (respondent)?.");
             txtFirstName.requestFocus(); 
             return;	
           }
         else if(spnEduLevelFHead.getSelectedItemPosition()==0  & secEduLevelFHead.isShown())
           {
             Connection.MessageBox(Household_Interview.this, "Required field: মহিলা খানাপ্রধান সর্বোচ্চ কোন পর্যায় পর্যন্ত পড়াশোনা শেষ করেছে?(What is the highest level of school completed by the female head of the household?).");
             spnEduLevelFHead.requestFocus(); 
             return;	
           }
         else if(spnEduLevelMHead.getSelectedItemPosition()==0  & secEduLevelMHead.isShown())
           {
             Connection.MessageBox(Household_Interview.this, "Required field: খানাপ্রধান সর্বোচ্চ কোন পর্যায় পর্যন্ত পড়াশোনা শেষ করেছে? (What is the highest level of school completed by the male head of the household?).");
             spnEduLevelMHead.requestFocus(); 
             return;	
           }
         else if(txtliveHouseM.getText().toString().length()==0 & secliveHouseM.isShown())
           {
               if(txtliveHouseY.getText().toString().length()==0)
               {
                   Connection.MessageBox(Household_Interview.this, "Required field: কতমাস যাবৎ আপনার খানা/পরিবার এই বাড়িতে বাস করছে ? (How long has your household/family been living in this house for?).");
                   txtliveHouseM.requestFocus();
                   return;
               }
           }
         else if(Integer.valueOf(txtliveHouseM.getText().toString().length()==0 ? "00" : txtliveHouseM.getText().toString()) < 00 || Integer.valueOf(txtliveHouseM.getText().toString().length()==0 ? "11" : txtliveHouseM.getText().toString()) > 11 && Integer.valueOf(txtliveHouseM.getText().toString())!=96)
           {
             Connection.MessageBox(Household_Interview.this, "Value should be between 00 and 11(কতমাস যাবৎ আপনার খানা/পরিবার এই বাড়িতে বাস করছে ? (How long has your household/family been living in this house for?)).");
             txtliveHouseM.requestFocus(); 
             return;	
           }
         else if(txtliveHouseY.getText().toString().length()==0 & secliveHouseY.isShown() & txtliveHouseM.getText().toString().length()==0)
           {

                    Connection.MessageBox(Household_Interview.this, "Required field: .");
                    txtliveHouseY.requestFocus();
                    return;

           }
         else if(Integer.valueOf(txtliveHouseY.getText().toString().length()==0 ? "02" : txtliveHouseY.getText().toString()) < 02 || Integer.valueOf(txtliveHouseY.getText().toString().length()==0 ? "99" : txtliveHouseY.getText().toString()) > 99)
           {
             Connection.MessageBox(Household_Interview.this, "Value should be between 02 and 99().");
             txtliveHouseY.requestFocus(); 
             return;	
           }
         else if(txtLiveHH_Mon.getText().toString().length()==0 & secLiveHH_Mon.isShown() & txtLiveHH_Year.getText().toString().length()==0)
           {

                   Connection.MessageBox(Household_Interview.this, "Required field: এই খানায় আপনি (যে সবচেয়ে বেশি দিন যাবত আছেন) কতদিন যাবত বাস করছেন? (How many months/Years have you lived at this household?).");
                   txtLiveHH_Mon.requestFocus();
                   return;

           }
         else if(Integer.valueOf(txtLiveHH_Mon.getText().toString().length()==0 ? "00" : txtLiveHH_Mon.getText().toString()) < 00 || Integer.valueOf(txtLiveHH_Mon.getText().toString().length()==0 ? "11" : txtLiveHH_Mon.getText().toString()) > 11)
           {
             Connection.MessageBox(Household_Interview.this, "Value should be between 00 and 11(এই খানায় আপনি (যে সবচেয়ে বেশি দিন যাবত আছেন) কতদিন যাবত বাস করছেন? (How many months/Years have you lived at this household?)).");
             txtLiveHH_Mon.requestFocus(); 
             return;	
           }
         else if(txtLiveHH_Year.getText().toString().length()==0 & secLiveHH_Year.isShown() & txtLiveHH_Mon.getText().toString().length()==0)
           {

                   Connection.MessageBox(Household_Interview.this, "Required field: .");
                   txtLiveHH_Year.requestFocus();
                   return;

           }
         else if(Integer.valueOf(txtLiveHH_Year.getText().toString().length()==0 ? "00" : txtLiveHH_Year.getText().toString()) < 00 || Integer.valueOf(txtLiveHH_Year.getText().toString().length()==0 ? "99" : txtLiveHH_Year.getText().toString()) > 99)
           {
             Connection.MessageBox(Household_Interview.this, "Value should be between 00 and 99().");
             txtLiveHH_Year.requestFocus(); 
             return;	
           }
         else if(txtLiveCity_Mon.getText().toString().length()==0 & secLiveCity_Mon.isShown() & txtLiveCity_Year.getText().toString().length()==0)
           {

                   Connection.MessageBox(Household_Interview.this, "Required field: এই শহরে আপনি (যে সবচেয়ে বেশি দিন যাবত আছেন) কতদিন যাবত বাস করছেন? (How many months/Years have you lived in this city?).");
                   txtLiveCity_Mon.requestFocus();
                   return;

           }
         else if(Integer.valueOf(txtLiveCity_Mon.getText().toString().length()==0 ? "0" : txtLiveCity_Mon.getText().toString()) < 0 || Integer.valueOf(txtLiveCity_Mon.getText().toString().length()==0 ? "11" : txtLiveCity_Mon.getText().toString()) > 11)
           {
             Connection.MessageBox(Household_Interview.this, "Value should be between 0 and 11(এই শহরে আপনি (যে সবচেয়ে বেশি দিন যাবত আছেন) কতদিন যাবত বাস করছেন? (How many months/Years have you lived in this city?)).");
             txtLiveCity_Mon.requestFocus(); 
             return;	
           }
         else if(txtLiveCity_Year.getText().toString().length()==0 & secLiveCity_Year.isShown() & txtLiveCity_Mon.getText().toString().length()==0)
           {

                   Connection.MessageBox(Household_Interview.this, "Required field: .");
                   txtLiveCity_Year.requestFocus();
                   return;


           }
         else if(Integer.valueOf(txtLiveCity_Year.getText().toString().length()==0 ? "0" : txtLiveCity_Year.getText().toString()) < 0 || Integer.valueOf(txtLiveCity_Year.getText().toString().length()==0 ? "99" : txtLiveCity_Year.getText().toString()) > 99)
           {
             Connection.MessageBox(Household_Interview.this, "Value should be between 0 and 99().");
             txtLiveCity_Year.requestFocus(); 
             return;	
           }
         
         else if(!rdoHlive12m1.isChecked() & !rdoHlive12m2.isChecked() & !rdoHlive12m3.isChecked() & secHlive12m.isShown())
           {
              Connection.MessageBox(Household_Interview.this, "Select anyone options from (আপনার কি আগামী ১২ মাস এই বাড়িতে বসবাস করার পরিকল্পনা রয়েছে? (Do you have a plan to live in this house for next 12 months?) ).");
              rdoHlive12m1.requestFocus();
              return;
           }
         else if(txtChangedHouse.getText().toString().length()==0 & secChangedHouse.isShown())
           {
             Connection.MessageBox(Household_Interview.this, "Required field: গত ৫ বৎরের ভিতরে, আপনি সর্বমোট কতবার আপনার বাড়ি/ বাসা/ বাসস্থান বদল করেছেন? (Altogether how many times have you changed your house/home/residence in the last five years?).");
             txtChangedHouse.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtChangedHouse.getText().toString().length()==0 ? "1" : txtChangedHouse.getText().toString()) < 1 || Integer.valueOf(txtChangedHouse.getText().toString().length()==0 ? "9" : txtChangedHouse.getText().toString()) > 9)
           {
             Connection.MessageBox(Household_Interview.this, "Value should be between 1 and 9(গত ৫ বৎরের ভিতরে, আপনি সর্বমোট কতবার আপনার বাড়ি/ বাসা/ বাসস্থান বদল করেছেন? (Altogether how many times have you changed your house/home/residence in the last five years?)).");
             txtChangedHouse.requestFocus(); 
             return;	
           }
         else if(spnDistHome.getSelectedItemPosition()==0  & secDistHome.isShown())
           {
             Connection.MessageBox(Household_Interview.this, "Required field: আপনার বর্তমান বাসা থেকে আপনার ঠিক আগের বাসাটি কতদুরে ছিল? (How far is the home you lived before from your current home?).");
             spnDistHome.requestFocus(); 
             return;	
           }
         else if(spnChildHcare.getSelectedItemPosition()==0  & secChildHcare.isShown())
           {
             Connection.MessageBox(Household_Interview.this, "Required field:   আপনার বাসার সবচেয়ে ছোট বাচ্চা কার বা কোথা থেকে সচরাচর স্বাস্থ্যসেবা গ্রহন করে থাকে ? (Where does your youngest child ususaly receive health care from?).");
             spnChildHcare.requestFocus(); 
             return;	
           }
         else if(txtChildHcareOth.getText().toString().length()==0 & secChildHcareOth.isShown())
           {
             Connection.MessageBox(Household_Interview.this, "Required field: অন্যান্য উল্লেখ করুন  (Others Specify).");
             txtChildHcareOth.requestFocus(); 
             return;	
           }
         else if(txtMotherEdu.getText().toString().length()==0 & secMotherEdu.isShown())
           {
             Connection.MessageBox(Household_Interview.this, "Required field: এই পরিবারের সবচেয়ে ছোট সন্তানরে মা কতক্লাস পর্যন্ত  পড়াশোনা শেষ করেছে? (How many educational years has the Mother of the youngest child of this family completed?).");
             txtMotherEdu.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtMotherEdu.getText().toString().length()==0 ? "1" : txtMotherEdu.getText().toString()) < 1 || Integer.valueOf(txtMotherEdu.getText().toString().length()==0 ? "14" : txtMotherEdu.getText().toString()) > 14)
           {
             Connection.MessageBox(Household_Interview.this, "Value should be between 1 and 14(এই পরিবারের সবচেয়ে ছোট সন্তানরে মা কতক্লাস পর্যন্ত  পড়াশোনা শেষ করেছে? (How many educational years has the Mother of the youngest child of this family completed?)).");
             txtMotherEdu.requestFocus(); 
             return;	
           }
         else if(spnHeadOcp.getSelectedItemPosition()==0  & secHeadOcp.isShown())
           {
             Connection.MessageBox(Household_Interview.this, "Required field: এই পরিবারের খানা প্রধানের প্রধান পেশা কি ? (What is the main occupation of the Household Head of this family?).");
             spnHeadOcp.requestFocus(); 
             return;	
           }
         else if(txtHeadOcpOth.getText().toString().length()==0 & secHeadOcpOth.isShown())
           {
             Connection.MessageBox(Household_Interview.this, "Required field: অন্যান্য উল্লেখ করুন  (Others Specify).");
             txtHeadOcpOth.requestFocus(); 
             return;	
           }
         else if(txtRoom.getText().toString().length()==0 & secRoom.isShown())
           {
             Connection.MessageBox(Household_Interview.this, "Required field:  আপনার খানার ঘরটিতে কয়টি কক্ষ আছে (রান্নাঘর ও বাথরুম বাদে)? (How many rooms are there in your household (except kitchen and bathroom)?.");
             txtRoom.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtRoom.getText().toString().length()==0 ? "1" : txtRoom.getText().toString()) < 1 || Integer.valueOf(txtRoom.getText().toString().length()==0 ? "15" : txtRoom.getText().toString()) > 15)
           {
             Connection.MessageBox(Household_Interview.this, "Value should be between 1 and 15( আপনার খানার ঘরটিতে কয়টি কক্ষ আছে (রান্নাঘর ও বাথরুম বাদে)? (How many rooms are there in your household (except kitchen and bathroom)?).");
             txtRoom.requestFocus(); 
             return;	
           }
         else if(txtBedRoom.getText().toString().length()==0 & secBedRoom.isShown())
           {
             Connection.MessageBox(Household_Interview.this, "Required field: আপনার খানার ঘরটিতে ঘুমানোর জন্য কয়টি কক্ষ আছে? (How many bedrooms are there in your household)?.");
             txtBedRoom.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtBedRoom.getText().toString().length()==0 ? "1" : txtBedRoom.getText().toString()) < 1 || Integer.valueOf(txtBedRoom.getText().toString().length()==0 ? "9" : txtBedRoom.getText().toString()) > 9)
           {
             Connection.MessageBox(Household_Interview.this, "Value should be between 1 and 9(আপনার খানার ঘরটিতে ঘুমানোর জন্য কয়টি কক্ষ আছে? (How many bedrooms are there in your household)?).");
             txtBedRoom.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtBedRoom.getText().toString()) > Integer.valueOf(txtRoom.getText().toString()))
         {
             Connection.MessageBox(Household_Interview.this, "Number of bedroom should not be greater than total number of room.");
             txtBedRoom.requestFocus();
             return;
         }
         
         else if(!rdoElectricity1.isChecked() & !rdoElectricity2.isChecked() & !rdoElectricity3.isChecked() & !rdoElectricity4.isChecked() & secElectricity.isShown())
           {
              Connection.MessageBox(Household_Interview.this, "Select anyone options from (1) বিদ্যুৎ (Electricity) ).");
              rdoElectricity1.requestFocus();
              return;
           }
         
         else if(!rdoRadio1.isChecked() & !rdoRadio2.isChecked() & !rdoRadio3.isChecked() & !rdoRadio4.isChecked() & secRadio.isShown())
           {
              Connection.MessageBox(Household_Interview.this, "Select anyone options from (2) রেডিও (Radio)).");
              rdoRadio1.requestFocus();
              return;
           }
         
         else if(!rdoTelevision1.isChecked() & !rdoTelevision2.isChecked() & !rdoTelevision3.isChecked() & !rdoTelevision4.isChecked() & secTelevision.isShown())
           {
              Connection.MessageBox(Household_Interview.this, "Select anyone options from (3) টেলিভিশন (Television)).");
              rdoTelevision1.requestFocus();
              return;
           }
         
         else if(!rdoNonMobileTele1.isChecked() & !rdoNonMobileTele2.isChecked() & !rdoNonMobileTele3.isChecked() & !rdoNonMobileTele4.isChecked() & secNonMobileTele.isShown())
           {
              Connection.MessageBox(Household_Interview.this, "Select anyone options from (4) মোবাইল ফোন ব্যতিত অন্য ফোন (Non-mobile telephone)).");
              rdoNonMobileTele1.requestFocus();
              return;
           }
         
         else if(!rdoComputer1.isChecked() & !rdoComputer2.isChecked() & !rdoComputer3.isChecked() & !rdoComputer4.isChecked() & secComputer.isShown())
           {
              Connection.MessageBox(Household_Interview.this, "Select anyone options from (5) কম্পিউটার (Computer)).");
              rdoComputer1.requestFocus();
              return;
           }
         
         else if(!rdoRefrigerator1.isChecked() & !rdoRefrigerator2.isChecked() & !rdoRefrigerator3.isChecked() & !rdoRefrigerator4.isChecked() & secRefrigerator.isShown())
           {
              Connection.MessageBox(Household_Interview.this, "Select anyone options from (6) রেফ্রিজারেটর (Refrigerator)).");
              rdoRefrigerator1.requestFocus();
              return;
           }
         
         else if(!rdoWatch1.isChecked() & !rdoWatch2.isChecked() & !rdoWatch3.isChecked() & !rdoWatch4.isChecked() & secWatch.isShown())
           {
              Connection.MessageBox(Household_Interview.this, "Select anyone options from (1) ঘড়ি (Watch)).");
              rdoWatch1.requestFocus();
              return;
           }
//         else if(spnMobilePhone.getSelectedItemPosition()==0  & secMobilePhone.isShown())
//           {
//             Connection.MessageBox(Household_Interview.this, "Required field: 2) মোবাইল ফোন (Mobile phone)	.");
//             spnMobilePhone.requestFocus();
//             return;
//           }
         else if(!rdoMobilePhone1.isChecked() & !rdoMobilePhone2.isChecked() & !rdoMobilePhone3.isChecked() & !rdoMobilePhone4.isChecked() & secMobilePhone.isShown())
         {
             Connection.MessageBox(Household_Interview.this, "Required field: 2) মোবাইল ফোন (Mobile phone)\t.");
             rdoMobilePhone1.requestFocus();
             return;
         }

         else if(!rdoBicycle1.isChecked() & !rdoBicycle2.isChecked() & !rdoBicycle3.isChecked() & !rdoBicycle4.isChecked() & secBicycle.isShown())
         {
             Connection.MessageBox(Household_Interview.this, "Required field: 3) বাই সাইকেল (Bicycle).");
             rdoBicycle1.requestFocus();
             return;
         }
         else if(!rdoMotorcycleScooter1.isChecked() & !rdoMotorcycleScooter2.isChecked() & !rdoMotorcycleScooter3.isChecked() & !rdoMotorcycleScooter4.isChecked() & secMotorcycleScooter.isShown())
         {
             Connection.MessageBox(Household_Interview.this, "Required field: 4) মোটর সাইকেল/স্কুটার (Motorcycle or motor scooter).");
             rdoMotorcycleScooter1.requestFocus();
             return;
         }

//         else if(spnBicycle.getSelectedItemPosition()==0  & secBicycle.isShown())
//           {
//             Connection.MessageBox(Household_Interview.this, "Required field: 3) বাই সাইকেল (Bicycle).");
//             spnBicycle.requestFocus();
//             return;
//           }
//         else if(spnMotorcycleScooter.getSelectedItemPosition()==0  & secMotorcycleScooter.isShown())
//           {
//             Connection.MessageBox(Household_Interview.this, "Required field: 4) মোটর সাইকেল/স্কুটার (Motorcycle or motor scooter).");
//             spnMotorcycleScooter.requestFocus();
//             return;
//           }
         
         else if(!rdoAnimalDrawnCart1.isChecked() & !rdoAnimalDrawnCart2.isChecked() & !rdoAnimalDrawnCart3.isChecked() & !rdoAnimalDrawnCart4.isChecked() & secAnimalDrawnCart.isShown())
           {
              Connection.MessageBox(Household_Interview.this, "Select anyone options from (5) গরুর/ঘোড়ার গাড়ি (Animal-drawn cart)).");
              rdoAnimalDrawnCart1.requestFocus();
              return;
           }
         
         else if(!rdoCarOrTruck1.isChecked() & !rdoCarOrTruck2.isChecked() & !rdoCarOrTruck3.isChecked() & !rdoCarOrTruck4.isChecked() & secCarOrTruck.isShown())
           {
              Connection.MessageBox(Household_Interview.this, "Select anyone options from (6) গাড়ি/বাস/ ট্রাক (Car or truck)).");
              rdoCarOrTruck1.requestFocus();
              return;
           }
         
         else if(!rdoBankAccount1.isChecked() & !rdoBankAccount2.isChecked() & !rdoBankAccount3.isChecked() & !rdoBankAccount4.isChecked() & secBankAccount.isShown())
           {
              Connection.MessageBox(Household_Interview.this, "Select anyone options from (7) ব্যাংক একাউণ্ট (Bank account)).");
              rdoBankAccount1.requestFocus();
              return;
           }
         
         else if(!rdoHHOwner1.isChecked() & !rdoHHOwner2.isChecked() & !rdoHHOwner3.isChecked() & secHHOwner.isShown())
           {
              Connection.MessageBox(Household_Interview.this, "Select anyone options from (বসতবাড়ির মালিকানা ? (Household Ownership)      ).");
              rdoHHOwner1.requestFocus();
              return;
           }
         else if(txtRentOfDwelling.getText().toString().length()==0 & secRentOfDwelling.isShown())
           {
               if(!chkRentOfDwellDK.isChecked())
               {
                   Connection.MessageBox(Household_Interview.this, "Required field: আপনার এই বাসাটি আজ কেউ ভাড়া নিতে চাইলে তাকে মাসে কত টাকা ভাড়া দিতে হবে? If someone wanted to rent this dwelling today, how much money would they have to pay each month, considering just the part of the dwelling where your household is living?টাকা (amount in local currency)\nএই বাড়িটি তৈরিতে মূল কি কি উপাদান ব্যবহার করা হয়েছে (পরিদর্শন করে যাচাই করুন).");
                   txtRentOfDwelling.requestFocus();
                   return;
               }

           }
         else if(Integer.valueOf(txtRentOfDwelling.getText().toString().length()==0 ? "1" : txtRentOfDwelling.getText().toString()) < 1 || Integer.valueOf(txtRentOfDwelling.getText().toString().length()==0 ? "99999" : txtRentOfDwelling.getText().toString()) > 99999)
           {
             Connection.MessageBox(Household_Interview.this, "Value should be between 1 and 99999(আপনার এই বাসাটি আজ কেউ ভাড়া নিতে চাইলে তাকে মাসে কত টাকা ভাড়া দিতে হবে? If someone wanted to rent this dwelling today, how much money would they have to pay each month, considering just the part of the dwelling where your household is living?টাকা (amount in local currency)\nএই বাড়িটি তৈরিতে মূল কি কি উপাদান ব্যবহার করা হয়েছে (পরিদর্শন করে যাচাই করুন)).");
             txtRentOfDwelling.requestFocus(); 
             return;	
           }
         else if(spnConsMatFloor.getSelectedItemPosition()==0  & secConsMatFloor.isShown())
           {
             Connection.MessageBox(Household_Interview.this, "Required field: বাড়িটির মেঝে তৈরীতে মূল কি উপাদান ব্যবহার করা হয়েছ ? (what type of  materials were used to construct the  floor?).");
             spnConsMatFloor.requestFocus(); 
             return;	
           }
         else if(txtConsMatFloorOth.getText().toString().length()==0 & secConsMatFloorOth.isShown())
           {
             Connection.MessageBox(Household_Interview.this, "Required field: অন্যান্য উল্লেখ করুন  (Others Specify).");
             txtConsMatFloorOth.requestFocus(); 
             return;	
           }
         else if(spnConsMatWall.getSelectedItemPosition()==0  & secConsMatWall.isShown())
           {
             Connection.MessageBox(Household_Interview.this, "Required field: দেয়াল তৈরীতে মূল কি উপাদান ব্যবহার করা হয়েছ ? What is the main construction material of the outside walls of your dwelling?.");
             spnConsMatWall.requestFocus(); 
             return;	
           }
         else if(txtConsMatWallOth.getText().toString().length()==0 & secConsMatWallOth.isShown())
           {
             Connection.MessageBox(Household_Interview.this, "Required field: অন্যান্য উল্লেখ করুন  (Others Specify).");
             txtConsMatWallOth.requestFocus(); 
             return;	
           }
         else if(spnConsMatRoof.getSelectedItemPosition()==0  & secConsMatRoof.isShown())
           {
             Connection.MessageBox(Household_Interview.this, "Required field: ছাদ তৈরীতে মূল কি উপাদান ব্যবহার করা হয়েছ ? What is the main construction material of the roof of your dwelling?.");
             spnConsMatRoof.requestFocus(); 
             return;	
           }
         else if(txtConsMatRoofOth.getText().toString().length()==0 & secConsMatRoofOth.isShown())
           {
             Connection.MessageBox(Household_Interview.this, "Required field: অন্যান্য উল্লেখ করুন  (Others Specify).");
             txtConsMatRoofOth.requestFocus(); 
             return;	
           }
         else if(spnFuel.getSelectedItemPosition()==0  & secFuel.isShown())
           {
             Connection.MessageBox(Household_Interview.this, "Required field: আপনার খানায় রান্নার জন্য প্রধানত কি ধরনের জ্বালানী ব্যবহার করা হয় ?.");
             spnFuel.requestFocus(); 
             return;	
           }
         else if(txtFuelOth.getText().toString().length()==0 & secFuelOth.isShown())
           {
             Connection.MessageBox(Household_Interview.this, "Required field: অন্যান্য উল্লেখ করুন  (Others Specify).");
             txtFuelOth.requestFocus(); 
             return;	
           }
         else if(spnTypeOfToilet.getSelectedItemPosition()==0  & secTypeOfToilet.isShown())
           {
             Connection.MessageBox(Household_Interview.this, "Required field: আপনার খানার সদস্যরা কি ধরনের পায়খানা ব্যাবহার করেন? What kind of toilet do members of your household usually use?.");
             spnTypeOfToilet.requestFocus(); 
             return;	
           }
         else if(txtTypeOfToiletOth.getText().toString().length()==0 & secTypeOfToiletOth.isShown())
           {
             Connection.MessageBox(Household_Interview.this, "Required field: অন্যান্য উল্লেখ করুন  (Others Specify).");
             txtTypeOfToiletOth.requestFocus(); 
             return;	
           }
         else if(spnTypeOfChildToilet.getSelectedItemPosition()==0  & secTypeOfChildToilet.isShown())
           {
             Connection.MessageBox(Household_Interview.this, "Required field: আপনার পরিবারের সবচেয়ে ছোট শিশুটি (যদি <৫ বছর বয়সী, নাম বলুন) প্রধানত কী ধরনের পায়খানা ব্যবহার করে ? (What type of latrine does the youngest child (if  <5 years old; please mention the name) of your family use?.");
             spnTypeOfChildToilet.requestFocus(); 
             return;	
           }
         else if(txtTypeOfChildToiletOth.getText().toString().length()==0 & secTypeOfChildToiletOth.isShown())
           {
             Connection.MessageBox(Household_Interview.this, "Required field: অন্যান্য উল্লেখ করুন  (Others Specify).");
             txtTypeOfChildToiletOth.requestFocus(); 
             return;	
           }
         else if(spnToiletShare.getSelectedItemPosition()==0  & secToiletShare.isShown())
           {
             Connection.MessageBox(Household_Interview.this, "Required field: একটি পায়খানা কতজন লোক ব্যাবহার করেন? How many people share toilet at your home.");
             spnToiletShare.requestFocus(); 
             return;	
           }
         else if(spnSOfDrinkingWater.getSelectedItemPosition()==0  & secSOfDrinkingWater.isShown())
           {
             Connection.MessageBox(Household_Interview.this, "Required field: খানায় খাবার পানির প্রধান উৎস কি? What is the main source of drinking water for members of your household?.");
             spnSOfDrinkingWater.requestFocus(); 
             return;	
           }
//         else if(txtTimeToWalkInMin.getText().toString().length()==0  & secTimeToWalkInMin.isShown())
//           {
//             Connection.MessageBox(Household_Interview.this, "Required field: পানি সংগ্রহের জন্য কত সময় হাটতে হয়? How long would you have to walk to collect water?.");
//             txtTimeToWalkInMin.requestFocus();
//             return;
//           }
//
//         else if(Integer.valueOf(txtTimeToWalkInMin.getText().toString())>59  & secTimeToWalkInMin.isShown())
//         {
//             Connection.MessageBox(Household_Interview.this, "Required field: Value should be 0 to 59");
//             txtTimeToWalkInMin.requestFocus();
//             return;
//         }

//         else if(txtTimeToWalkInHours.getText().toString().length()==0 & secTimeToWalkInHours.isShown())
//           {
//             Connection.MessageBox(Household_Interview.this, "Required field: ঘণ্টা (Hours).");
//             txtTimeToWalkInHours.requestFocus();
//             return;
//           }
         else if(txtWeeklyWSupplyInHour.getText().toString().length()==0 & secWeeklyWSupplyInHour.isShown())
           {
             Connection.MessageBox(Household_Interview.this, "Required field: সপ্তাহে গড়ে কত ঘণ্টা আপনার এলাকায় পানি থাকে? How many hours per week on average does water run in your community?.");
             txtWeeklyWSupplyInHour.requestFocus(); 
             return;	
           }

         else if(Integer.valueOf(txtWeeklyWSupplyInHour.getText().toString())>168 & secWeeklyWSupplyInHour.isShown())
         {
             Connection.MessageBox(Household_Interview.this, "Required field: Value should be 0 to 168.");
             txtWeeklyWSupplyInHour.requestFocus();
             return;
         }

         else if(txtWeeklyWSuppHouse.getText().toString().length()==0 & secWeeklyWSuppHouse.isShown())
           {
             Connection.MessageBox(Household_Interview.this, "Required field: গত মাসে প্রতি সপ্তাহে গড়ে কত ঘণ্টা আপনার বাসায় পানি ছিল? On the average in last month how many hours per week does water run in your house?.");
             txtWeeklyWSuppHouse.requestFocus(); 
             return;	
           }
         
         else if(!rdoTreatDKWater1.isChecked() & !rdoTreatDKWater2.isChecked() & secTreatDKWater.isShown())
           {
              Connection.MessageBox(Household_Interview.this, "Select anyone options from (আপনি কি বাসায় সাধারনত খাবার পানি বিশুদ্ধ করেন? Do you usually treat drinking water at home?  ).");
              rdoTreatDKWater1.requestFocus();
              return;
           }
         else if(spnTreatMeth.getSelectedItemPosition()==0  & secTreatMeth.isShown())
           {
             Connection.MessageBox(Household_Interview.this, "Required field: কি উপায়ে সাধারনত বাসায় খাবার পানি বিশুদ্ধ করেন? Which method do you use the most to treat drinking water at home?.");
             spnTreatMeth.requestFocus(); 
             return;	
           }
         
         else if(!rdoOpenSewers1.isChecked() & !rdoOpenSewers2.isChecked() & secOpenSewers.isShown())
           {
              Connection.MessageBox(Household_Interview.this, "Select anyone options from (আপনার এলাকায় কি কোন খোলা নর্দমা আছে? Are there open sewers in your locality? ).");
              rdoOpenSewers1.requestFocus();
              return;
           }
         
         else if(!rdoHandwash1.isChecked() & !rdoHandwash2.isChecked() & !rdoHandwash3.isChecked() & secHandwash.isShown())
           {
              Connection.MessageBox(Household_Interview.this, "Select anyone options from (উত্তরদাতা কি আপনাকে হাত ধোয়ার স্থানে কাপর কাচার সাবান / পাউডার / গুড়া সাবান (ডিটারজেনট) / যে কোন ধরনের সাবান দেখাতে পেরেছেন? (Could the interviewee show you any soap/detergent/powdered or liquid soap/cloth washing soap at hand washing station?)).");
              rdoHandwash1.requestFocus();
              return;
           }
         
         else if(!rdoWater1.isChecked() & !rdoWater2.isChecked() & !rdoWater3.isChecked() & secWater.isShown())
           {
              Connection.MessageBox(Household_Interview.this, "Select anyone options from (উত্তরদাতা কি আপনাকে হাত ধোয়ার স্থানে পানি দেখাতে পেরেছেন? (Could the interviewee show you availability of water for washing hand at hand washing station?)   ).");
              rdoWater1.requestFocus();
              return;
           }
 
         String SQL = "";
         RadioButton rb;

         Household_Interview_DataModel objSave = new Household_Interview_DataModel();
         objSave.setUNCode(txtUNCode.getText().toString());
         objSave.setStructureNo(Integer.valueOf(txtStructureNo.getText().toString().length()==0?"0":txtStructureNo.getText().toString()));
         objSave.setHouseholdSl(txtHouseholdSl.getText().toString());
         objSave.setVisitNo(txtVisitNo.getText().toString());
         String[] d_rdogrpFHeadAvail = new String[] {"1","2"};
         objSave.setFHeadAvail(0);
         for (int i = 0; i < rdogrpFHeadAvail.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpFHeadAvail.getChildAt(i);
             if (rb.isChecked()) objSave.setFHeadAvail(Integer.valueOf(d_rdogrpFHeadAvail[i]));
         }

         objSave.setRelWithFHead(Integer.valueOf(spnRelWithFHead.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnRelWithFHead.getSelectedItem().toString(), "-")));
         objSave.setOthRelWithFHead(txtOthRelWithFHead.getText().toString());
         objSave.setFirstName(txtFirstName.getText().toString());
         objSave.setEduLevelFHead(Integer.valueOf(spnEduLevelFHead.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnEduLevelFHead.getSelectedItem().toString(), "-")));
         objSave.setEduLevelMHead(Integer.valueOf(spnEduLevelMHead.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnEduLevelMHead.getSelectedItem().toString(), "-")));
         objSave.setliveHouseM(Integer.valueOf(txtliveHouseM.getText().toString().length()==0?"0":txtliveHouseM.getText().toString()));
         objSave.setliveHouseY(Integer.valueOf(txtliveHouseY.getText().toString().length()==0?"0":txtliveHouseY.getText().toString()));
         objSave.setLiveHH_Mon(Integer.valueOf(txtLiveHH_Mon.getText().toString().length()==0?"0":txtLiveHH_Mon.getText().toString()));
         objSave.setLiveHH_Year(Integer.valueOf(txtLiveHH_Year.getText().toString().length()==0?"0":txtLiveHH_Year.getText().toString()));
         objSave.setLiveCity_Mon(Integer.valueOf(txtLiveCity_Mon.getText().toString().length()==0?"0":txtLiveCity_Mon.getText().toString()));
         objSave.setLiveCity_Year(Integer.valueOf(txtLiveCity_Year.getText().toString().length()==0?"0":txtLiveCity_Year.getText().toString()));
         String[] d_rdogrpHlive12m = new String[] {"1","2","8"};
         objSave.setHlive12m(0);
         for (int i = 0; i < rdogrpHlive12m.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpHlive12m.getChildAt(i);
             if (rb.isChecked()) objSave.setHlive12m(Integer.valueOf(d_rdogrpHlive12m[i]));
         }

         objSave.setChangedHouse(Integer.valueOf(txtChangedHouse.getText().toString().length()==0?"0":txtChangedHouse.getText().toString()));
         objSave.setDistHome(Integer.valueOf(spnDistHome.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnDistHome.getSelectedItem().toString(), "-")));
         objSave.setChildHcare(Integer.valueOf(spnChildHcare.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnChildHcare.getSelectedItem().toString(), "-")));
         objSave.setChildHcareOth(txtChildHcareOth.getText().toString());
         objSave.setMotherEdu(Integer.valueOf(txtMotherEdu.getText().toString().length()==0?"0":txtMotherEdu.getText().toString()));
         objSave.setHeadOcp(Integer.valueOf(spnHeadOcp.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnHeadOcp.getSelectedItem().toString(), "-")));
         objSave.setHeadOcpOth(txtHeadOcpOth.getText().toString());
         objSave.setRoom(Integer.valueOf(txtRoom.getText().toString().length()==0?"0":txtRoom.getText().toString()));
         objSave.setBedRoom(Integer.valueOf(txtBedRoom.getText().toString().length()==0?"0":txtBedRoom.getText().toString()));
         String[] d_rdogrpElectricity = new String[] {"1","2","3","4"};
         objSave.setElectricity(0);
         for (int i = 0; i < rdogrpElectricity.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpElectricity.getChildAt(i);
             if (rb.isChecked()) objSave.setElectricity(Integer.valueOf(d_rdogrpElectricity[i]));
         }

         String[] d_rdogrpRadio = new String[] {"1","2","3","4"};
         objSave.setRadio(0);
         for (int i = 0; i < rdogrpRadio.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpRadio.getChildAt(i);
             if (rb.isChecked()) objSave.setRadio(Integer.valueOf(d_rdogrpRadio[i]));
         }

         String[] d_rdogrpTelevision = new String[] {"1","2","3","4"};
         objSave.setTelevision(0);
         for (int i = 0; i < rdogrpTelevision.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpTelevision.getChildAt(i);
             if (rb.isChecked()) objSave.setTelevision(Integer.valueOf(d_rdogrpTelevision[i]));
         }

         String[] d_rdogrpNonMobileTele = new String[] {"1","2","3","4"};
         objSave.setNonMobileTele(0);
         for (int i = 0; i < rdogrpNonMobileTele.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpNonMobileTele.getChildAt(i);
             if (rb.isChecked()) objSave.setNonMobileTele(Integer.valueOf(d_rdogrpNonMobileTele[i]));
         }

         String[] d_rdogrpComputer = new String[] {"1","2","3","4"};
         objSave.setComputer(0);
         for (int i = 0; i < rdogrpComputer.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpComputer.getChildAt(i);
             if (rb.isChecked()) objSave.setComputer(Integer.valueOf(d_rdogrpComputer[i]));
         }

         String[] d_rdogrpRefrigerator = new String[] {"1","2","3","4"};
         objSave.setRefrigerator(0);
         for (int i = 0; i < rdogrpRefrigerator.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpRefrigerator.getChildAt(i);
             if (rb.isChecked()) objSave.setRefrigerator(Integer.valueOf(d_rdogrpRefrigerator[i]));
         }

         String[] d_rdogrpWatch = new String[] {"1","2","3","4"};
         objSave.setWatch(0);
         for (int i = 0; i < rdogrpWatch.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpWatch.getChildAt(i);
             if (rb.isChecked()) objSave.setWatch(Integer.valueOf(d_rdogrpWatch[i]));
         }

         String[] d_rdogrpMobilePhone = new String[] {"1","2","3","4"};
         objSave.setMobilePhone(0);
         for (int i = 0; i < rdogrpMobilePhone.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpMobilePhone.getChildAt(i);
             if (rb.isChecked()) objSave.setMobilePhone(Integer.valueOf(d_rdogrpMobilePhone[i]));
         }

         String[] d_rdogrpBicycle = new String[] {"1","2","3","4"};
         objSave.setBicycle(0);
         for (int i = 0; i < rdogrpBicycle.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpBicycle.getChildAt(i);
             if (rb.isChecked()) objSave.setBicycle(Integer.valueOf(d_rdogrpBicycle[i]));
         }

         String[] d_rdogrpMotorcycleScooter = new String[] {"1","2","3","4"};
         objSave.setMotorcycleScooter(0);
         for (int i = 0; i < rdogrpMotorcycleScooter.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpMotorcycleScooter.getChildAt(i);
             if (rb.isChecked()) objSave.setMotorcycleScooter(Integer.valueOf(d_rdogrpMotorcycleScooter[i]));
         }

//         objSave.setMobilePhone(Integer.valueOf(spnMobilePhone.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnMobilePhone.getSelectedItem().toString(), "-")));
//         objSave.setBicycle(Integer.valueOf(spnBicycle.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnBicycle.getSelectedItem().toString(), "-")));
//         objSave.setMotorcycleScooter(Integer.valueOf(spnMotorcycleScooter.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnMotorcycleScooter.getSelectedItem().toString(), "-")));
         String[] d_rdogrpAnimalDrawnCart = new String[] {"1","2","3","4"};
         objSave.setAnimalDrawnCart(0);
         for (int i = 0; i < rdogrpAnimalDrawnCart.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpAnimalDrawnCart.getChildAt(i);
             if (rb.isChecked()) objSave.setAnimalDrawnCart(Integer.valueOf(d_rdogrpAnimalDrawnCart[i]));
         }

         String[] d_rdogrpCarOrTruck = new String[] {"1","2","3","4"};
         objSave.setCarOrTruck(0);
         for (int i = 0; i < rdogrpCarOrTruck.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpCarOrTruck.getChildAt(i);
             if (rb.isChecked()) objSave.setCarOrTruck(Integer.valueOf(d_rdogrpCarOrTruck[i]));
         }

         String[] d_rdogrpBankAccount = new String[] {"1","2","3","4"};
         objSave.setBankAccount(0);
         for (int i = 0; i < rdogrpBankAccount.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpBankAccount.getChildAt(i);
             if (rb.isChecked()) objSave.setBankAccount(Integer.valueOf(d_rdogrpBankAccount[i]));
         }

         String[] d_rdogrpHHOwner = new String[] {"1","2","3"};
         objSave.setHHOwner(0);
         for (int i = 0; i < rdogrpHHOwner.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpHHOwner.getChildAt(i);
             if (rb.isChecked()) objSave.setHHOwner(Integer.valueOf(d_rdogrpHHOwner[i]));
         }

         objSave.setRentOfDwelling(Integer.valueOf(txtRentOfDwelling.getText().toString().length()==0?"0":txtRentOfDwelling.getText().toString()));
         objSave.setRentOfDwellDK(Integer.valueOf(chkRentOfDwellDK.isChecked()?"1":(secRentOfDwellDK.isShown()?"2":"0")));
         objSave.setConsMatFloor(Integer.valueOf(spnConsMatFloor.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnConsMatFloor.getSelectedItem().toString(), "-")));
         objSave.setConsMatFloorOth(txtConsMatFloorOth.getText().toString());
         objSave.setConsMatWall(Integer.valueOf(spnConsMatWall.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnConsMatWall.getSelectedItem().toString(), "-")));
         objSave.setConsMatWallOth(txtConsMatWallOth.getText().toString());
         objSave.setConsMatRoof(Integer.valueOf(spnConsMatRoof.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnConsMatRoof.getSelectedItem().toString(), "-")));
         objSave.setConsMatRoofOth(txtConsMatRoofOth.getText().toString());
         objSave.setFuel(Integer.valueOf(spnFuel.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnFuel.getSelectedItem().toString(), "-")));
         objSave.setFuelOth(txtFuelOth.getText().toString());
         objSave.setTypeOfToilet(Integer.valueOf(spnTypeOfToilet.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnTypeOfToilet.getSelectedItem().toString(), "-")));
         objSave.setTypeOfToiletOth(txtTypeOfToiletOth.getText().toString());
         objSave.setTypeOfChildToilet(Integer.valueOf(spnTypeOfChildToilet.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnTypeOfChildToilet.getSelectedItem().toString(), "-")));
         objSave.setTypeOfChildToiletOth(txtTypeOfChildToiletOth.getText().toString());
         objSave.setToiletShare(Integer.valueOf(spnToiletShare.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnToiletShare.getSelectedItem().toString(), "-")));
         objSave.setSOfDrinkingWater(Integer.valueOf(spnSOfDrinkingWater.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnSOfDrinkingWater.getSelectedItem().toString(), "-")));
         objSave.setTimeToWalkInMin(txtTimeToWalkInMin.getText().toString());
         objSave.setTimeToWalkInHours(txtTimeToWalkInHours.getText().toString());
         objSave.setWeeklyWSupplyInHour(txtWeeklyWSupplyInHour.getText().toString());
         objSave.setWeeklyWSuppHouse(txtWeeklyWSuppHouse.getText().toString());
         String[] d_rdogrpTreatDKWater = new String[] {"1","2"};
         objSave.setTreatDKWater(0);
         for (int i = 0; i < rdogrpTreatDKWater.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpTreatDKWater.getChildAt(i);
             if (rb.isChecked()) objSave.setTreatDKWater(Integer.valueOf(d_rdogrpTreatDKWater[i]));
         }

         objSave.setTreatMeth(Integer.valueOf(spnTreatMeth.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnTreatMeth.getSelectedItem().toString(), "-")));
         String[] d_rdogrpOpenSewers = new String[] {"1","2"};
         objSave.setOpenSewers(0);
         for (int i = 0; i < rdogrpOpenSewers.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpOpenSewers.getChildAt(i);
             if (rb.isChecked()) objSave.setOpenSewers(Integer.valueOf(d_rdogrpOpenSewers[i]));
         }

         String[] d_rdogrpHandwash = new String[] {"1","2","3"};
         objSave.setHandwash(0);
         for (int i = 0; i < rdogrpHandwash.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpHandwash.getChildAt(i);
             if (rb.isChecked()) objSave.setHandwash(Integer.valueOf(d_rdogrpHandwash[i]));
         }

         String[] d_rdogrpWater = new String[] {"1","2","3"};
         objSave.setWater(0);
         for (int i = 0; i < rdogrpWater.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpWater.getChildAt(i);
             if (rb.isChecked()) objSave.setWater(Integer.valueOf(d_rdogrpWater[i]));
         }

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
                     Intent intent = new Intent(getApplicationContext(), Knowledge_DSH_SSF.class);
                     intent.putExtras(IDbundle);
                     startActivityForResult(intent, 1);
                 }
             });
             alert.show();

             Bundle IDbundle = new Bundle();
             IDbundle.putString("UNCode",UNCODE  );
             IDbundle.putString("StructureNo",STRUCTURENO );
             IDbundle.putString("HouseholdSl", HOUSEHOLDSL);
             IDbundle.putString("VisitNo", VISITNO);
         }
         else{
             Connection.MessageBox(Household_Interview.this, status);
             return;
         }


     }
     catch(Exception  e)
     {
         Connection.MessageBox(Household_Interview.this, e.getMessage());
         return;
     }
 }

 private void DataSearch(String UNCode, String StructureNo, String HouseholdSl, String VisitNo)
     {
       try
        {
     
           RadioButton rb;
           Household_Interview_DataModel d = new Household_Interview_DataModel();
           String SQL = "Select * from "+ TableName +"  Where UNCode='"+ UNCode +"' and StructureNo='"+ StructureNo +"' and HouseholdSl='"+ HouseholdSl +"' and VisitNo='"+ VisitNo +"'";
           List<Household_Interview_DataModel> data = d.SelectAll(this, SQL);
           for(Household_Interview_DataModel item : data){
             txtUNCode.setText(item.getUNCode());
             txtStructureNo.setText(String.valueOf(item.getStructureNo()));
             txtHouseholdSl.setText(item.getHouseholdSl());
             txtVisitNo.setText(item.getVisitNo());
             String[] d_rdogrpFHeadAvail = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpFHeadAvail.length; i++)
             {
                 if (String.valueOf(item.getFHeadAvail()).equals(String.valueOf(d_rdogrpFHeadAvail[i])))
                 {
                     rb = (RadioButton)rdogrpFHeadAvail.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             spnRelWithFHead.setSelection(Global.SpinnerItemPositionAnyLength(spnRelWithFHead, String.valueOf(item.getRelWithFHead())));
             txtOthRelWithFHead.setText(item.getOthRelWithFHead());
             txtFirstName.setText(item.getFirstName());
             spnEduLevelFHead.setSelection(Global.SpinnerItemPositionAnyLength(spnEduLevelFHead, String.valueOf(item.getEduLevelFHead())));
             spnEduLevelMHead.setSelection(Global.SpinnerItemPositionAnyLength(spnEduLevelMHead, String.valueOf(item.getEduLevelMHead())));
             txtliveHouseM.setText(String.valueOf(item.getliveHouseM()));
             txtliveHouseY.setText(String.valueOf(item.getliveHouseY()));
             txtLiveHH_Mon.setText(String.valueOf(item.getLiveHH_Mon()));
             txtLiveHH_Year.setText(String.valueOf(item.getLiveHH_Year()));
             txtLiveCity_Mon.setText(String.valueOf(item.getLiveCity_Mon()));
             txtLiveCity_Year.setText(String.valueOf(item.getLiveCity_Year()));
             String[] d_rdogrpHlive12m = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpHlive12m.length; i++)
             {
                 if (String.valueOf(item.getHlive12m()).equals(String.valueOf(d_rdogrpHlive12m[i])))
                 {
                     rb = (RadioButton)rdogrpHlive12m.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtChangedHouse.setText(String.valueOf(item.getChangedHouse()));
             spnDistHome.setSelection(Global.SpinnerItemPositionAnyLength(spnDistHome, String.valueOf(item.getDistHome())));
             spnChildHcare.setSelection(Global.SpinnerItemPositionAnyLength(spnChildHcare, String.valueOf(item.getChildHcare())));
             txtChildHcareOth.setText(item.getChildHcareOth());
             txtMotherEdu.setText(String.valueOf(item.getMotherEdu()));
             spnHeadOcp.setSelection(Global.SpinnerItemPositionAnyLength(spnHeadOcp, String.valueOf(item.getHeadOcp())));
             txtHeadOcpOth.setText(item.getHeadOcpOth());
             txtRoom.setText(String.valueOf(item.getRoom()));
             txtBedRoom.setText(String.valueOf(item.getBedRoom()));
             String[] d_rdogrpElectricity = new String[] {"1","2","3","4"};
             for (int i = 0; i < d_rdogrpElectricity.length; i++)
             {
                 if (String.valueOf(item.getElectricity()).equals(String.valueOf(d_rdogrpElectricity[i])))
                 {
                     rb = (RadioButton)rdogrpElectricity.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpRadio = new String[] {"1","2","3","4"};
             for (int i = 0; i < d_rdogrpRadio.length; i++)
             {
                 if (String.valueOf(item.getRadio()).equals(String.valueOf(d_rdogrpRadio[i])))
                 {
                     rb = (RadioButton)rdogrpRadio.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpTelevision = new String[] {"1","2","3","4"};
             for (int i = 0; i < d_rdogrpTelevision.length; i++)
             {
                 if (String.valueOf(item.getTelevision()).equals(String.valueOf(d_rdogrpTelevision[i])))
                 {
                     rb = (RadioButton)rdogrpTelevision.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpNonMobileTele = new String[] {"1","2","3","4"};
             for (int i = 0; i < d_rdogrpNonMobileTele.length; i++)
             {
                 if (String.valueOf(item.getNonMobileTele()).equals(String.valueOf(d_rdogrpNonMobileTele[i])))
                 {
                     rb = (RadioButton)rdogrpNonMobileTele.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpComputer = new String[] {"1","2","3","4"};
             for (int i = 0; i < d_rdogrpComputer.length; i++)
             {
                 if (String.valueOf(item.getComputer()).equals(String.valueOf(d_rdogrpComputer[i])))
                 {
                     rb = (RadioButton)rdogrpComputer.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpRefrigerator = new String[] {"1","2","3","4"};
             for (int i = 0; i < d_rdogrpRefrigerator.length; i++)
             {
                 if (String.valueOf(item.getRefrigerator()).equals(String.valueOf(d_rdogrpRefrigerator[i])))
                 {
                     rb = (RadioButton)rdogrpRefrigerator.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpWatch = new String[] {"1","2","3","4"};
             for (int i = 0; i < d_rdogrpWatch.length; i++)
             {
                 if (String.valueOf(item.getWatch()).equals(String.valueOf(d_rdogrpWatch[i])))
                 {
                     rb = (RadioButton)rdogrpWatch.getChildAt(i);
                     rb.setChecked(true);
                 }
             }

               String[] d_rdogrpMobilePhone = new String[] {"1","2","3","4"};
               for (int i = 0; i < d_rdogrpMobilePhone.length; i++)
               {
                   if (String.valueOf(item.getMobilePhone()).equals(String.valueOf(d_rdogrpMobilePhone[i])))
                   {
                       rb = (RadioButton)rdogrpMobilePhone.getChildAt(i);
                       rb.setChecked(true);
                   }
               }

               String[] d_rdogrpBicycle = new String[] {"1","2","3","4"};
               for (int i = 0; i < d_rdogrpBicycle.length; i++)
               {
                   if (String.valueOf(item.getBicycle()).equals(String.valueOf(d_rdogrpBicycle[i])))
                   {
                       rb = (RadioButton)rdogrpBicycle.getChildAt(i);
                       rb.setChecked(true);
                   }
               }

                String[] d_rdogrpMotorcycleScooter = new String[] {"1","2","3","4"};
               for (int i = 0; i < d_rdogrpMotorcycleScooter.length; i++)
               {
                   if (String.valueOf(item.getMotorcycleScooter()).equals(String.valueOf(d_rdogrpMotorcycleScooter[i])))
                   {
                       rb = (RadioButton)rdogrpMotorcycleScooter.getChildAt(i);
                       rb.setChecked(true);
                   }
               }


//             spnMobilePhone.setSelection(Global.SpinnerItemPositionAnyLength(spnMobilePhone, String.valueOf(item.getMobilePhone())));
//             spnBicycle.setSelection(Global.SpinnerItemPositionAnyLength(spnBicycle, String.valueOf(item.getBicycle())));
//             spnMotorcycleScooter.setSelection(Global.SpinnerItemPositionAnyLength(spnMotorcycleScooter, String.valueOf(item.getMotorcycleScooter())));
             String[] d_rdogrpAnimalDrawnCart = new String[] {"1","2","3","4"};
             for (int i = 0; i < d_rdogrpAnimalDrawnCart.length; i++)
             {
                 if (String.valueOf(item.getAnimalDrawnCart()).equals(String.valueOf(d_rdogrpAnimalDrawnCart[i])))
                 {
                     rb = (RadioButton)rdogrpAnimalDrawnCart.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpCarOrTruck = new String[] {"1","2","3","4"};
             for (int i = 0; i < d_rdogrpCarOrTruck.length; i++)
             {
                 if (String.valueOf(item.getCarOrTruck()).equals(String.valueOf(d_rdogrpCarOrTruck[i])))
                 {
                     rb = (RadioButton)rdogrpCarOrTruck.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpBankAccount = new String[] {"1","2","3","4"};
             for (int i = 0; i < d_rdogrpBankAccount.length; i++)
             {
                 if (String.valueOf(item.getBankAccount()).equals(String.valueOf(d_rdogrpBankAccount[i])))
                 {
                     rb = (RadioButton)rdogrpBankAccount.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpHHOwner = new String[] {"1","2","3"};
             for (int i = 0; i < d_rdogrpHHOwner.length; i++)
             {
                 if (String.valueOf(item.getHHOwner()).equals(String.valueOf(d_rdogrpHHOwner[i])))
                 {
                     rb = (RadioButton)rdogrpHHOwner.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtRentOfDwelling.setText(String.valueOf(item.getRentOfDwelling()));

             if(String.valueOf(item.getRentOfDwellDK()).equals("1"))
             {
                chkRentOfDwellDK.setChecked(true);
             }
             else if(String.valueOf(item.getRentOfDwellDK()).equals("2"))
             {
                chkRentOfDwellDK.setChecked(false);
             }
             spnConsMatFloor.setSelection(Global.SpinnerItemPositionAnyLength(spnConsMatFloor, String.valueOf(item.getConsMatFloor())));
             txtConsMatFloorOth.setText(item.getConsMatFloorOth());
             spnConsMatWall.setSelection(Global.SpinnerItemPositionAnyLength(spnConsMatWall, String.valueOf(item.getConsMatWall())));
             txtConsMatWallOth.setText(item.getConsMatWallOth());
             spnConsMatRoof.setSelection(Global.SpinnerItemPositionAnyLength(spnConsMatRoof, String.valueOf(item.getConsMatRoof())));
             txtConsMatRoofOth.setText(item.getConsMatRoofOth());
             spnFuel.setSelection(Global.SpinnerItemPositionAnyLength(spnFuel, String.valueOf(item.getFuel())));
             txtFuelOth.setText(item.getFuelOth());
             spnTypeOfToilet.setSelection(Global.SpinnerItemPositionAnyLength(spnTypeOfToilet, String.valueOf(item.getTypeOfToilet())));
             txtTypeOfToiletOth.setText(item.getTypeOfToiletOth());
             spnTypeOfChildToilet.setSelection(Global.SpinnerItemPositionAnyLength(spnTypeOfChildToilet, String.valueOf(item.getTypeOfChildToilet())));
             txtTypeOfChildToiletOth.setText(item.getTypeOfChildToiletOth());
             spnToiletShare.setSelection(Global.SpinnerItemPositionAnyLength(spnToiletShare, String.valueOf(item.getToiletShare())));
             spnSOfDrinkingWater.setSelection(Global.SpinnerItemPositionAnyLength(spnSOfDrinkingWater, String.valueOf(item.getSOfDrinkingWater())));
             txtTimeToWalkInMin.setText(item.getTimeToWalkInMin());
             txtTimeToWalkInHours.setText(item.getTimeToWalkInHours());
             txtWeeklyWSupplyInHour.setText(item.getWeeklyWSupplyInHour());
             txtWeeklyWSuppHouse.setText(item.getWeeklyWSuppHouse());
             String[] d_rdogrpTreatDKWater = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpTreatDKWater.length; i++)
             {
                 if (String.valueOf(item.getTreatDKWater()).equals(String.valueOf(d_rdogrpTreatDKWater[i])))
                 {
                     rb = (RadioButton)rdogrpTreatDKWater.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             spnTreatMeth.setSelection(Global.SpinnerItemPositionAnyLength(spnTreatMeth, String.valueOf(item.getTreatMeth())));
             String[] d_rdogrpOpenSewers = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpOpenSewers.length; i++)
             {
                 if (String.valueOf(item.getOpenSewers()).equals(String.valueOf(d_rdogrpOpenSewers[i])))
                 {
                     rb = (RadioButton)rdogrpOpenSewers.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpHandwash = new String[] {"1","2","3"};
             for (int i = 0; i < d_rdogrpHandwash.length; i++)
             {
                 if (String.valueOf(item.getHandwash()).equals(String.valueOf(d_rdogrpHandwash[i])))
                 {
                     rb = (RadioButton)rdogrpHandwash.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpWater = new String[] {"1","2","3"};
             for (int i = 0; i < d_rdogrpWater.length; i++)
             {
                 if (String.valueOf(item.getWater()).equals(String.valueOf(d_rdogrpWater[i])))
                 {
                     rb = (RadioButton)rdogrpWater.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
           }
        }
        catch(Exception  e)
        {
            Connection.MessageBox(Household_Interview.this, e.getMessage());
            return;
        }
     }











     public static class DividerItemDecoration extends RecyclerView.ItemDecoration {
         private final int[] ATTRS = new int[]{
                 android.R.attr.listDivider
         };
         public static final int HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL;
         public static final int VERTICAL_LIST = LinearLayoutManager.VERTICAL;
         private Drawable mDivider;
         private int mOrientation;
         public DividerItemDecoration(Context context, int orientation) {
             final TypedArray a = context.obtainStyledAttributes(ATTRS);
             mDivider = a.getDrawable(0);
             a.recycle();
             setOrientation(orientation);
         }
         public void setOrientation(int orientation) {
             if (orientation != HORIZONTAL_LIST && orientation != VERTICAL_LIST) {
                 throw new IllegalArgumentException("invalid orientation");
             }
             mOrientation = orientation;
         }
         @Override
         public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
             if (mOrientation == VERTICAL_LIST) {
                 drawVertical(c, parent);
             } else {
                 drawHorizontal(c, parent);
             }
         }
         public void drawVertical(Canvas c, RecyclerView parent) {
             final int left = parent.getPaddingLeft();
             final int right = parent.getWidth() - parent.getPaddingRight();

             final int childCount = parent.getChildCount();
             for (int i = 0; i < childCount; i++) {
                 final View child = parent.getChildAt(i);
                 final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                         .getLayoutParams();
                 final int top = child.getBottom() + params.bottomMargin;
                 final int bottom = top + mDivider.getIntrinsicHeight();
                 mDivider.setBounds(left, top, right, bottom);
                 mDivider.draw(c);
             }
         }
         public void drawHorizontal(Canvas c, RecyclerView parent) {
             final int top = parent.getPaddingTop();
             final int bottom = parent.getHeight() - parent.getPaddingBottom();
             final int childCount = parent.getChildCount();
             for (int i = 0; i < childCount; i++) {
                 final View child = parent.getChildAt(i);
                 final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                         .getLayoutParams();
                 final int left = child.getRight() + params.rightMargin;
                 final int right = left + mDivider.getIntrinsicHeight();
                 mDivider.setBounds(left, top, right, bottom);
                 mDivider.draw(c);
             }
         }
         @Override
         public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
             if (mOrientation == VERTICAL_LIST) {
                 outRect.set(0, 0, 0, mDivider.getIntrinsicHeight());
             } else {
                 outRect.set(0, 0, mDivider.getIntrinsicWidth(), 0);
             }
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