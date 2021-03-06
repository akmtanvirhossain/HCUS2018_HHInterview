
 package org.hcus_hhinterview;


 //Android Manifest Code
 //<activity android:name=".Immunization_Master" android:label="Immunization_Master" />
 import java.io.File;
 import java.io.FileNotFoundException;
 import java.io.FileOutputStream;
 import java.io.IOException;
 import java.io.OutputStream;
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
 import android.graphics.Bitmap;
 import android.graphics.BitmapFactory;
 import android.graphics.drawable.BitmapDrawable;
 import android.graphics.drawable.Drawable;
 import android.location.Location;
 import android.location.LocationListener;
 import android.location.LocationManager;
 import android.net.Uri;
 import android.os.Environment;
 import android.provider.MediaStore;
 import android.provider.Settings;
 import android.support.v7.widget.DefaultItemAnimator;
 import android.support.v7.widget.LinearLayoutManager;
 import android.support.v7.widget.RecyclerView;
 import android.util.Log;
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
 import android.widget.ImageView;
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
 import data_model.Immunization_History_DataModel;
 import data_model.Immunization_List_DataModel;
 import data_model.Immunization_Master_DataModel;
 import data_model.Member_DataModel;

 public class Immunization_Master extends Immunization_List_list {
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
    Immunization_History_list immunise=new Immunization_History_list();
//    ArrayList<HashMap<String, String>> dataList = new ArrayList<HashMap<String, String>>();
//public List<Immunization_History_DataModel> dataList = new ArrayList<>();
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
         LinearLayout secRecVitA;
         View lineRecVitA;
         TextView VlblRecVitA;
         RadioGroup rdogrpRecVitA;
         
         RadioButton rdoRecVitA1;
         RadioButton rdoRecVitA2;
         RadioButton rdoRecVitA3;
         LinearLayout secReceive_Vacc;
         View lineReceive_Vacc;
         TextView VlblReceive_Vacc;
         RadioGroup rdogrpReceive_Vacc;
         
         RadioButton rdoReceive_Vacc1;
         RadioButton rdoReceive_Vacc2;
         RadioButton rdoReceive_Vacc3;
         LinearLayout secHCard;
         View lineHCard;
         TextView VlblHCard;
         RadioGroup rdogrpHCard;
         
         RadioButton rdoHCard1;
         RadioButton rdoHCard2;

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

    LinearLayout secImmunization;
    View linesecImmunization;

     private RecyclerView recyclerView;

     LinearLayout secImage;
     View lineImage;
     Button btnPhoto;
     ImageView imgCard;
     static final int REQUEST_IMAGE_CAPTURE = 99;
     static final String FOLDER_NAME ="Vaccination_Card";
     static String name; //image file name


 public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
   try
     {
         setContentView(R.layout.immunization_master);
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
         MEMNAME = IDbundle.getString("Name");

         DEVICEID = IDbundle.getString("DeviceId");

         if(DEVICEID.length()==0)
         {
             DEVICEID  = sp.getValue(this, "deviceid");
         }

         name=UNCODE+STRUCTURENO+HOUSEHOLDSL+VISITNO+MEMSL+DEVICEID;

         TableName = "Immunization_Master";

         //turnGPSOn();

         //GPS Location
         //FindLocation();
         // Double.toString(currentLatitude);
         // Double.toString(currentLongitude);
         lblHeading = (TextView)findViewById(R.id.lblHeading);

         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(Immunization_Master.this);
                 adb.setTitle("Close");
                 adb.setMessage("Do you want to close this form[Yes/No]?");
                 adb.setNegativeButton("No", null);
                 adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                     public void onClick(DialogInterface dialog, int which) {
                         finish();
                     }});
                 adb.show();
             }});

         secImmunization=findViewById(R.id.secImmunization);
         linesecImmunization=findViewById(R.id.linesecImmunization);

         secImage=findViewById(R.id.secImage);
         lineImage=findViewById(R.id.lineImage);
         btnPhoto=findViewById(R.id.btnPhoto);
         imgCard=findViewById(R.id.imgCard);

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
         secRecVitA=(LinearLayout)findViewById(R.id.secRecVitA);
         lineRecVitA=(View)findViewById(R.id.lineRecVitA);
         VlblRecVitA = (TextView) findViewById(R.id.VlblRecVitA);
         rdogrpRecVitA = (RadioGroup) findViewById(R.id.rdogrpRecVitA);
         
         rdoRecVitA1 = (RadioButton) findViewById(R.id.rdoRecVitA1);
         rdoRecVitA2 = (RadioButton) findViewById(R.id.rdoRecVitA2);
         rdoRecVitA3 = (RadioButton) findViewById(R.id.rdoRecVitA3);
         secReceive_Vacc=(LinearLayout)findViewById(R.id.secReceive_Vacc);
         lineReceive_Vacc=(View)findViewById(R.id.lineReceive_Vacc);
         VlblReceive_Vacc = (TextView) findViewById(R.id.VlblReceive_Vacc);
         rdogrpReceive_Vacc = (RadioGroup) findViewById(R.id.rdogrpReceive_Vacc);

         rdogrpReceive_Vacc.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(RadioGroup radioGroup, int radioButtonIDi) {
                 String rbData = "";
                 RadioButton rb;
                 String[] d_rdogrpSeriIlOnset = new String[] {"1","2","8"};
                 for (int i = 0; i < rdogrpReceive_Vacc.getChildCount(); i++)
                 {
                     rb = (RadioButton)rdogrpReceive_Vacc.getChildAt(i);
                     if (rb.isChecked()) rbData = d_rdogrpSeriIlOnset[i];
                 }

                 if(rbData.equalsIgnoreCase("2"))
                 {
                     secImmunization.setVisibility(View.GONE);
                     linesecImmunization.setVisibility(View.GONE);
                     secHCard.setVisibility(View.GONE);
                     rdogrpHCard.clearCheck();
                     lineHCard.setVisibility(View.GONE);


                 }else if(rbData.equalsIgnoreCase("8"))
                 {
                     secImmunization.setVisibility(View.GONE);
                     linesecImmunization.setVisibility(View.GONE);
                     secHCard.setVisibility(View.GONE);
                     rdogrpHCard.clearCheck();
                     lineHCard.setVisibility(View.GONE);
                 }
                 else if(rbData.equalsIgnoreCase("1"))
                 {
                     secImmunization.setVisibility(View.VISIBLE);
                     linesecImmunization.setVisibility(View.VISIBLE);
                     secHCard.setVisibility(View.VISIBLE);
                     lineHCard.setVisibility(View.VISIBLE);
                 }
                 else
                 {
                     secImmunization.setVisibility(View.GONE);
                     linesecImmunization.setVisibility(View.GONE);
                     secHCard.setVisibility(View.GONE);
                     lineHCard.setVisibility(View.GONE);
                 }

             }
         });
         
         rdoReceive_Vacc1 = (RadioButton) findViewById(R.id.rdoReceive_Vacc1);
         rdoReceive_Vacc2 = (RadioButton) findViewById(R.id.rdoReceive_Vacc2);
         rdoReceive_Vacc3 = (RadioButton) findViewById(R.id.rdoReceive_Vacc3);
         secHCard=(LinearLayout)findViewById(R.id.secHCard);
         lineHCard=(View)findViewById(R.id.lineHCard);
         VlblHCard = (TextView) findViewById(R.id.VlblHCard);
         rdogrpHCard = (RadioGroup) findViewById(R.id.rdogrpHCard);
         
         rdoHCard1 = (RadioButton) findViewById(R.id.rdoHCard1);
         rdoHCard2 = (RadioButton) findViewById(R.id.rdoHCard2);

         rdogrpHCard.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(RadioGroup radioGroup, int radioButtonId) {
                 String rbData = "";
                 RadioButton rb;
                 String[] d_rdogrpSeriIlOnset = new String[] {"1","2"};
                 for (int i = 0; i < rdogrpHCard.getChildCount(); i++)
                 {
                     rb = (RadioButton)rdogrpHCard.getChildAt(i);
                     if (rb.isChecked()) rbData = d_rdogrpSeriIlOnset[i];
                 }

                 if(rbData.equalsIgnoreCase("1"))
                 {
                     secImage.setVisibility(View.VISIBLE);
                     lineImage.setVisibility(View.VISIBLE);
                 }else
                 {
                     secImage.setVisibility(View.GONE);
                     lineImage.setVisibility(View.GONE);
                 }

             }
         });


         btnPhoto.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                 if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                     startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                 }
             }
         });

         btnRefresh = (Button) findViewById(R.id.btnRefresh);
         btnRefresh.setOnClickListener(new View.OnClickListener() {

             public void onClick(View view) {
                 //write your code here
                 DataSearch_Immunization("",DEVICEID);

             }});

//         btnAdd   = (Button) findViewById(R.id.btnAdd);
//         btnAdd.setOnClickListener(new View.OnClickListener() {
//
//             public void onClick(View view) {
//                 Bundle IDbundle = new Bundle();
//                 IDbundle.putString("UNCode", UNCODE);
//                 IDbundle.putString("StructureNo", STRUCTURENO);
//                 IDbundle.putString("HouseholdSl", HOUSEHOLDSL);
//                 IDbundle.putString("VisitNo", VISITNO);
//                 IDbundle.putString("MemSl",""+MEMSL);
//
//                 Intent intent = new Intent(getApplicationContext(), Immunization_List.class);
//                 intent.putExtras(IDbundle);
//                 startActivityForResult(intent, 1);
//
//             }});

         imgCard.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 ImageView imageView=new ImageView(Immunization_Master.this);
                 imageView.setImageDrawable(imgCard.getDrawable());
                 AlertDialog.Builder builder =
                         new AlertDialog.Builder(Immunization_Master.this).
                                 setMessage("Vaccination Card").
                                 setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                     @Override
                                     public void onClick(DialogInterface dialog, int which) {
                                         dialog.dismiss();
                                     }
                                 }).
                                 setView(imageView);

                 builder.create().show();
             }
         });

         txtUNCode.setText(UNCODE);
         txtStructureNo.setText(STRUCTURENO);
         txtHouseholdSl.setText(HOUSEHOLDSL);
         txtVisitNo.setText(VISITNO);
         txtMemSl.setText(MEMSL);
         txtMemName.setText(MEMNAME);

         recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
         mAdapter = new DataAdapter(dataList);
         recyclerView.setItemViewCacheSize(20);
         recyclerView.setDrawingCacheEnabled(true);
         recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
         recyclerView.setHasFixedSize(true);
         RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
         recyclerView.setLayoutManager(mLayoutManager);
         recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
         recyclerView.setItemAnimator(new DefaultItemAnimator());
         recyclerView.setAdapter(mAdapter);




         //Hide all skip variables

         //************* insert into immunization history **************
         Immunization_List_DataModel d = new Immunization_List_DataModel();
//             String SQL = "Select * from "+ TableName ;//+"  Where Vacc_Id='"+ Vacc_Id +"'";
         String SQL = "Select * FROM Immunization_List ";
         List<Immunization_List_DataModel> immunizationList = d.SelectAll(this, SQL);

         for (Immunization_List_DataModel item:immunizationList) {

             if(C.Existence("Select * from Immunization_History Where UNCode='"+ UNCODE +"' and StructureNo='"+ STRUCTURENO +"' and HouseholdSl='"+ HOUSEHOLDSL +"' and VisitNo='"+ VISITNO +"' and MemSl='"+ MEMSL +"' and Vacc_Id='"+ item.getVacc_Id() +"' and DeviceID='"+DEVICEID+"'"))
             {

             }
             else
             {
                 Immunization_History_DataModel objSave = new Immunization_History_DataModel();
                 objSave.setUNCode(UNCODE);
                 objSave.setStructureNo(STRUCTURENO);
                 objSave.setHouseholdSl(HOUSEHOLDSL);
                 objSave.setVisitNo(VISITNO);
                 objSave.setMemSl(MEMSL);
                 objSave.setVacc_Id(item.getVacc_Id());
                 objSave.setGiven(0);
                 objSave.setSource(0);
                 objSave.setVacc_Date("");
                 objSave.setDate_Missing(2);
                 objSave.setEnDt(Global.DateTimeNowYMDHMS());
                 objSave.setStartTime(STARTTIME);
                 objSave.setEndTime(g.CurrentTime24());
                 objSave.setDeviceID(DEVICEID);
                 objSave.setEntryUser(ENTRYUSER); //from data entry user list
                 objSave.setmodifyDate(Global.DateTimeNowYMDHMS());
                 objSave.SaveUpdateData(this);
             }
         }

         //************* insert into immunization history **************

         secHCard.setVisibility(View.GONE);
         lineHCard.setVisibility(View.GONE);
         secImmunization.setVisibility(View.GONE);
         linesecImmunization.setVisibility(View.GONE);
         secImage.setVisibility(View.GONE);
         lineImage.setVisibility(View.GONE);


         DataSearch(UNCODE,STRUCTURENO,HOUSEHOLDSL,VISITNO,MEMSL);

         DataSearch_Immunization("",DEVICEID);







        Button cmdSave = (Button) findViewById(R.id.cmdSave);
        cmdSave.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) { 
            DataSave();
        }});
     }
     catch(Exception  e)
     {
         Connection.MessageBox(Immunization_Master.this, e.getMessage());
         return;
     }
 }
     @Override
     protected void onActivityResult(int requestCode, int resultCode, Intent data) {
         if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
             Bundle extras = data.getExtras();
             Bitmap imageBitmap = (Bitmap) extras.get("data");
             imgCard.setImageBitmap(imageBitmap);

             File dir = new File(Environment.getExternalStorageDirectory() + File.separator + Global.DatabaseFolder+File.separator + FOLDER_NAME);
             if(!dir.exists()) {
                 dir.mkdirs();
             }


             String path = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + Global.DatabaseFolder+File.separator + FOLDER_NAME;
             OutputStream fOut = null;
             File file = new File(path, name+".jpg"); // the File to save , append increasing numeric counter to prevent files from getting overwritten.
             try {
                 fOut = new FileOutputStream(file);
             } catch (FileNotFoundException e) {
                 e.printStackTrace();
             }

//             Bitmap pictureBitmap = ((BitmapDrawable) imgCard.getDrawable()).getBitmap();
//             Bitmap pictureBitmap = BitmapFactory.decodeResource(getResources(), R.id.imgCard);
             imageBitmap.compress(Bitmap.CompressFormat.JPEG, 85, fOut); // saving the Bitmap to a file compressed as a JPEG with 85% compression rate
             try {
                 fOut.flush(); // Not really required
             } catch (IOException e) {
                 e.printStackTrace();
             }
             try {
                 fOut.close(); // do not forget to close the stream
             } catch (IOException e) {
                 e.printStackTrace();
             }

             try {
                 MediaStore.Images.Media.insertImage(getContentResolver(),file.getAbsolutePath(),file.getName(),file.getName());
             } catch (FileNotFoundException e) {
                 e.printStackTrace();
             }
         }
         if (requestCode != REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
             DataSearch_Immunization("",DEVICEID);
         }
     }

 private void DataSave()
 {
   try
     {
 
         String DV="";

         if(txtUNCode.getText().toString().length()==0 & secUNCode.isShown())
           {
             Connection.MessageBox(Immunization_Master.this, "Required field: Ward No.");
             txtUNCode.requestFocus(); 
             return;	
           }
         else if(txtStructureNo.getText().toString().length()==0 & secStructureNo.isShown())
           {
             Connection.MessageBox(Immunization_Master.this, "Required field: Structure No.");
             txtStructureNo.requestFocus(); 
             return;	
           }
         else if(txtHouseholdSl.getText().toString().length()==0 & secHouseholdSl.isShown())
           {
             Connection.MessageBox(Immunization_Master.this, "Required field: Household Sl.");
             txtHouseholdSl.requestFocus(); 
             return;	
           }
         else if(txtVisitNo.getText().toString().length()==0 & secVisitNo.isShown())
           {
             Connection.MessageBox(Immunization_Master.this, "Required field: Visit No.");
             txtVisitNo.requestFocus(); 
             return;	
           }
         else if(txtMemSl.getText().toString().length()==0 & secMemSl.isShown())
           {
             Connection.MessageBox(Immunization_Master.this, "Required field: Member Serial.");
             txtMemSl.requestFocus(); 
             return;	
           }
         
         else if(!rdoRecVitA1.isChecked() & !rdoRecVitA2.isChecked() & !rdoRecVitA3.isChecked() & secRecVitA.isShown())
           {
              Connection.MessageBox(Immunization_Master.this, "Select anyone options from (শিশুটি (নাম) গত ৬ মাসে ভিটামিন A ক্যাপসুল খেয়েছিল?  (Did (NAME) receive a Vitamin A dose like this during the last 6 months? SHOW CAPSULE)).");
              rdoRecVitA1.requestFocus();
              return;
           }
         
         else if(!rdoReceive_Vacc1.isChecked() & !rdoReceive_Vacc2.isChecked() & !rdoReceive_Vacc3.isChecked() & secReceive_Vacc.isShown())
           {
              Connection.MessageBox(Immunization_Master.this, "Select anyone options from (শিশুটি (নাম) কি রোগ প্রতিরোধের জন্য কোন টিকা গ্রহন করেছে? (Did (NAME) ever receive any vaccinations to prevent him/her from getting disease?)).");
              rdoReceive_Vacc1.requestFocus();
              return;
           }
         
         else if(!rdoHCard1.isChecked() & !rdoHCard2.isChecked() & secHCard.isShown())
           {
              Connection.MessageBox(Immunization_Master.this, "Select anyone options from (আপনার কাছে কি এই শিশুর টিকার কার্ড আছে? যদি হ্যাঁ হয়, আমি কি দেখতে পারি? (Do you have a card where (NAME’S) vaccinations are written down? IF YES, May I see it please?)).");
              rdoHCard1.requestFocus();
              return;
           }
 
         String SQL = "";
         RadioButton rb;

         Immunization_Master_DataModel objSave = new Immunization_Master_DataModel();
         objSave.setUNCode(txtUNCode.getText().toString());
         objSave.setStructureNo(txtStructureNo.getText().toString());
         objSave.setHouseholdSl(txtHouseholdSl.getText().toString());
         objSave.setVisitNo(txtVisitNo.getText().toString());
         objSave.setMemSl(txtMemSl.getText().toString());
         String[] d_rdogrpRecVitA = new String[] {"1","2","8"};
         objSave.setRecVitA(0);
         for (int i = 0; i < rdogrpRecVitA.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpRecVitA.getChildAt(i);
             if (rb.isChecked()) objSave.setRecVitA(Integer.valueOf(d_rdogrpRecVitA[i]));
         }

         String[] d_rdogrpReceive_Vacc = new String[] {"1","2","8"};
         objSave.setReceive_Vacc(0);
         for (int i = 0; i < rdogrpReceive_Vacc.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpReceive_Vacc.getChildAt(i);
             if (rb.isChecked()) objSave.setReceive_Vacc(Integer.valueOf(d_rdogrpReceive_Vacc[i]));
         }

         String[] d_rdogrpHCard = new String[] {"1","2"};
         objSave.setHCard(0);
         for (int i = 0; i < rdogrpHCard.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpHCard.getChildAt(i);
             if (rb.isChecked()) objSave.setHCard(Integer.valueOf(d_rdogrpHCard[i]));

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
             Intent returnIntent = new Intent();
             returnIntent.putExtra("res", "");
             setResult(Activity.RESULT_OK, returnIntent);

             Connection.MessageBox(Immunization_Master.this, "Saved Successfully");
         }
         else{
             Connection.MessageBox(Immunization_Master.this, status);
             return;
         }
     }
     catch(Exception  e)
     {
         Connection.MessageBox(Immunization_Master.this, e.getMessage());
         return;
     }
 }

 private void DataSearch(String UNCode, String StructureNo, String HouseholdSl, String VisitNo, String MemSl)
     {
       try
        {
     
           RadioButton rb;
           Immunization_Master_DataModel d = new Immunization_Master_DataModel();
           String SQL = "Select * from "+ TableName +"  Where UNCode='"+ UNCode +"' and StructureNo='"+ StructureNo +"' and HouseholdSl='"+ HouseholdSl +"' and VisitNo='"+ VisitNo +"' and MemSl='"+ MemSl +"'  and DeviceID='"+DEVICEID+"'";
           List<Immunization_Master_DataModel> data = d.SelectAll(this, SQL);
           for(Immunization_Master_DataModel item : data){
             txtUNCode.setText(item.getUNCode());
             txtStructureNo.setText(item.getStructureNo());
             txtHouseholdSl.setText(item.getHouseholdSl());
             txtVisitNo.setText(item.getVisitNo());
             txtMemSl.setText(item.getMemSl());
             String[] d_rdogrpRecVitA = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpRecVitA.length; i++)
             {
                 if (String.valueOf(item.getRecVitA()).equals(String.valueOf(d_rdogrpRecVitA[i])))
                 {
                     rb = (RadioButton)rdogrpRecVitA.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpReceive_Vacc = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpReceive_Vacc.length; i++)
             {
                 if (String.valueOf(item.getReceive_Vacc()).equals(String.valueOf(d_rdogrpReceive_Vacc[i])))
                 {
                     rb = (RadioButton)rdogrpReceive_Vacc.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpHCard = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpHCard.length; i++)
             {
                 if (String.valueOf(item.getHCard()).equals(String.valueOf(d_rdogrpHCard[i])))
                 {
                     rb = (RadioButton)rdogrpHCard.getChildAt(i);
                     rb.setChecked(true);

                     if(d_rdogrpHCard[i].equals("1"))
                     {
                         secImage.setVisibility(View.VISIBLE);
                         lineImage.setVisibility(View.VISIBLE);
                         Drawable drawable=Drawable.createFromPath(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + Global.DatabaseFolder + File.separator +FOLDER_NAME + File.separator + name+".jpg");
//                         imgCard.setImageDrawable(drawable);
                         if (drawable != null) {
                             imgCard.setImageDrawable(drawable);
                         }


                     }else
                     {
                         secImage.setVisibility(View.GONE);
                         lineImage.setVisibility(View.GONE);
                     }
                 }
             }
           }
        }
        catch(Exception  e)
        {
            Connection.MessageBox(Immunization_Master.this, e.getMessage());
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