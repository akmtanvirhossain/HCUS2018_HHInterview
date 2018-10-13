package org.hcus_hhinterview;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import Common.Connection;

public class ChildForm_Menu extends AppCompatActivity {

    Bundle IDbundle;
    static String UNCODE = "";
    static String STRUCTURENO = "";
    static String HOUSEHOLDSL = "";
    static String VISITNO = "";
    static String MEMSL = "";
    static String AGE = "";
    static String NAME = "";
    static String DEVICEID  = "";

    Button btnImu,btnTyphoid,btnMeningitis,btnPneumonia,btnDiarrhoea,btnOperation,btnOtitis,btnAddMissionRefusal,btnStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_form__menu);

        IDbundle = getIntent().getExtras();
        UNCODE = IDbundle.getString("UNCode");
        STRUCTURENO = IDbundle.getString("StructureNo");
        HOUSEHOLDSL = IDbundle.getString("HouseholdSl");
        VISITNO = IDbundle.getString("VisitNo");
        MEMSL = IDbundle.getString("MemSl");
        AGE = IDbundle.getString("Age");
        NAME = IDbundle.getString("Name");
        DEVICEID = IDbundle.getString("DeviceId");


        ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
        cmdBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder adb = new AlertDialog.Builder(ChildForm_Menu.this);
                adb.setTitle("Close");
                adb.setMessage("Do you want to close this form[Yes/No]?");
                adb.setNegativeButton("No", null);
                adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }});
                adb.show();
            }});


        btnImu=findViewById(R.id.btnImu);
        btnTyphoid=findViewById(R.id.btnTyphoid);
        btnMeningitis=findViewById(R.id.btnMeningitis);
        btnPneumonia=findViewById(R.id.btnPneumonia);
        btnDiarrhoea=findViewById(R.id.btnDiarrhoea);
        btnOperation=findViewById(R.id.btnOperation);
        btnOtitis=findViewById(R.id.btnOtitis);
        btnAddMissionRefusal=findViewById(R.id.btnAddMissionRefusal);
        btnStatus=findViewById(R.id.btnStatus);

        if(Double.parseDouble(AGE) < 60)
        {
            btnPneumonia.setVisibility(View.GONE);
//            btnPneumonia.setBackgroundResource(R.drawable.button_style_red);
        }
        else if(Double.parseDouble(AGE) >= 1826 & Double.parseDouble(AGE) < 6574)
        {
            btnImu.setVisibility(View.GONE);
//            btnImu.setBackgroundResource(R.drawable.button_style_red);
            btnMeningitis.setVisibility(View.GONE);
//            btnMeningitis.setBackgroundResource(R.drawable.button_style_red);
            btnPneumonia.setVisibility(View.GONE);
//            btnPneumonia.setBackgroundResource(R.drawable.button_style_red);
            btnDiarrhoea.setVisibility(View.GONE);
//            btnDiarrhoea.setBackgroundResource(R.drawable.button_style_red);
        }

        //*************************** button color *************************\
        changeButtonColor();

        //*************************** button color *************************


        btnImu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog progDailog = ProgressDialog.show(ChildForm_Menu.this, "", "Please Wait . . .", true);
                new Thread() {
                    public void run() {
                        try {
                            Bundle IDbundle = new Bundle();
                            IDbundle.putString("UNCode", UNCODE);
                            IDbundle.putString("StructureNo", STRUCTURENO);
                            IDbundle.putString("HouseholdSl", HOUSEHOLDSL);
                            IDbundle.putString("VisitNo", VISITNO);
                            IDbundle.putString("MemSl",""+MEMSL);
                            IDbundle.putString("Name",""+NAME);
//                            IDbundle.putString("Age",""+AGE);
                            IDbundle.putString("DeviceId", DEVICEID);
                            Intent f1 = new Intent(getApplicationContext(), Immunization_Master.class);
                            f1.putExtras(IDbundle);
                            startActivityForResult(f1,1);
                        }
                        catch (Exception e) {
                            Connection.MessageBox(ChildForm_Menu.this, e.getMessage());
                            return;
                        }
                        progDailog.dismiss();
                    }
                }.start();

            }
        });

        btnTyphoid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog progDailog = ProgressDialog.show(ChildForm_Menu.this, "", "Please Wait . . .", true);
                new Thread() {
                    public void run() {
                        try {
                            Bundle IDbundle = new Bundle();
                            IDbundle.putString("UNCode", UNCODE);
                            IDbundle.putString("StructureNo", STRUCTURENO);
                            IDbundle.putString("HouseholdSl", HOUSEHOLDSL);
                            IDbundle.putString("VisitNo", VISITNO);
                            IDbundle.putString("MemSl",""+MEMSL);
                            IDbundle.putString("Name",""+NAME);
                            IDbundle.putString("DeviceId", DEVICEID);
//                            IDbundle.putString("Age",""+AGE);
                            Intent f1 = new Intent(getApplicationContext(), TyphoidCase.class);
                            f1.putExtras(IDbundle);
                            startActivityForResult(f1,1);
                        }
                        catch (Exception e) {
                            Connection.MessageBox(ChildForm_Menu.this, e.getMessage());
                            return;
                        }
                        progDailog.dismiss();
                    }
                }.start();

            }
        });

        btnMeningitis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog progDailog = ProgressDialog.show(ChildForm_Menu.this, "", "Please Wait . . .", true);
                new Thread() {
                    public void run() {
                        try {
                            Bundle IDbundle = new Bundle();
                            IDbundle.putString("UNCode", UNCODE);
                            IDbundle.putString("StructureNo", STRUCTURENO);
                            IDbundle.putString("HouseholdSl", HOUSEHOLDSL);
                            IDbundle.putString("VisitNo", VISITNO);
                            IDbundle.putString("MemSl",""+MEMSL);
                            IDbundle.putString("Name",""+NAME);
                            IDbundle.putString("DeviceId", DEVICEID);
//                            IDbundle.putString("Age",""+AGE);
                            Intent f1 = new Intent(getApplicationContext(), MeningitisCase.class);
                            f1.putExtras(IDbundle);
                            startActivityForResult(f1,1);
                        }
                        catch (Exception e) {
                            Connection.MessageBox(ChildForm_Menu.this, e.getMessage());
                            return;
                        }
                        progDailog.dismiss();
                    }
                }.start();

            }
        });

        btnPneumonia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog progDailog = ProgressDialog.show(ChildForm_Menu.this, "", "Please Wait . . .", true);
                new Thread() {
                    public void run() {
                        try {
                            Bundle IDbundle = new Bundle();
                            IDbundle.putString("UNCode", UNCODE);
                            IDbundle.putString("StructureNo", STRUCTURENO);
                            IDbundle.putString("HouseholdSl", HOUSEHOLDSL);
                            IDbundle.putString("VisitNo", VISITNO);
                            IDbundle.putString("MemSl",""+MEMSL);
                            IDbundle.putString("Name",""+NAME);
                            IDbundle.putString("DeviceId", DEVICEID);
//                            IDbundle.putString("Age",""+AGE);
                            Intent f1 = new Intent(getApplicationContext(), PneumoniaCase.class);
                            f1.putExtras(IDbundle);
                            startActivityForResult(f1,1);
                        }
                        catch (Exception e) {
                            Connection.MessageBox(ChildForm_Menu.this, e.getMessage());
                            return;
                        }
                        progDailog.dismiss();
                    }
                }.start();

            }
        });

        btnDiarrhoea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog progDailog = ProgressDialog.show(ChildForm_Menu.this, "", "Please Wait . . .", true);
                new Thread() {
                    public void run() {
                        try {
                            Bundle IDbundle = new Bundle();
                            IDbundle.putString("UNCode", UNCODE);
                            IDbundle.putString("StructureNo", STRUCTURENO);
                            IDbundle.putString("HouseholdSl", HOUSEHOLDSL);
                            IDbundle.putString("VisitNo", VISITNO);
                            IDbundle.putString("MemSl",""+MEMSL);
                            IDbundle.putString("Name",""+NAME);
                            IDbundle.putString("DeviceId", DEVICEID);
//                            IDbundle.putString("Age",""+AGE);
                            Intent f1 = new Intent(getApplicationContext(), DiarrhoeaCase.class);
                            f1.putExtras(IDbundle);
                            startActivityForResult(f1,1);
                        }
                        catch (Exception e) {
                            Connection.MessageBox(ChildForm_Menu.this, e.getMessage());
                            return;
                        }
                        progDailog.dismiss();
                    }
                }.start();

            }
        });

        btnOperation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog progDailog = ProgressDialog.show(ChildForm_Menu.this, "", "Please Wait . . .", true);
                new Thread() {
                    public void run() {
                        try {
                            Bundle IDbundle = new Bundle();
                            IDbundle.putString("UNCode", UNCODE);
                            IDbundle.putString("StructureNo", STRUCTURENO);
                            IDbundle.putString("HouseholdSl", HOUSEHOLDSL);
                            IDbundle.putString("VisitNo", VISITNO);
                            IDbundle.putString("MemSl",""+MEMSL);
                            IDbundle.putString("Name",""+NAME);
                            IDbundle.putString("DeviceId", DEVICEID);
//                            IDbundle.putString("Age",""+AGE);
                            Intent f1 = new Intent(getApplicationContext(), EmergencyOperation.class);
                            f1.putExtras(IDbundle);
                            startActivityForResult(f1,1);
                        }
                        catch (Exception e) {
                            Connection.MessageBox(ChildForm_Menu.this, e.getMessage());
                            return;
                        }
                        progDailog.dismiss();
                    }
                }.start();

            }
        });

        btnOtitis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog progDailog = ProgressDialog.show(ChildForm_Menu.this, "", "Please Wait . . .", true);
                new Thread() {
                    public void run() {
                        try {
                            Bundle IDbundle = new Bundle();
                            IDbundle.putString("UNCode", UNCODE);
                            IDbundle.putString("StructureNo", STRUCTURENO);
                            IDbundle.putString("HouseholdSl", HOUSEHOLDSL);
                            IDbundle.putString("VisitNo", VISITNO);
                            IDbundle.putString("MemSl",""+MEMSL);
                            IDbundle.putString("Name",""+NAME);
                            IDbundle.putString("DeviceId", DEVICEID);
//                            IDbundle.putString("Age",""+AGE);
                            Intent f1 = new Intent(getApplicationContext(), OtitisMediaCase.class);
                            f1.putExtras(IDbundle);
                            startActivityForResult(f1,1);
                        }
                        catch (Exception e) {
                            Connection.MessageBox(ChildForm_Menu.this, e.getMessage());
                            return;
                        }
                        progDailog.dismiss();
                    }
                }.start();

            }
        });

        btnAddMissionRefusal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog progDailog = ProgressDialog.show(ChildForm_Menu.this, "", "Please Wait . . .", true);
                new Thread() {
                    public void run() {
                        try {
                            Bundle IDbundle = new Bundle();
                            IDbundle.putString("UNCode", UNCODE);
                            IDbundle.putString("StructureNo", STRUCTURENO);
                            IDbundle.putString("HouseholdSl", HOUSEHOLDSL);
                            IDbundle.putString("VisitNo", VISITNO);
                            IDbundle.putString("MemSl",""+MEMSL);
                            IDbundle.putString("Name",""+NAME);
                            IDbundle.putString("DeviceId", DEVICEID);
//                            IDbundle.putString("Age",""+AGE);
                            Intent f1 = new Intent(getApplicationContext(), Admission_Refusal.class);
                            f1.putExtras(IDbundle);
                            startActivityForResult(f1,1);
                        }
                        catch (Exception e) {
                            Connection.MessageBox(ChildForm_Menu.this, e.getMessage());
                            return;
                        }
                        progDailog.dismiss();
                    }
                }.start();
            }
        });


        btnStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog progDailog = ProgressDialog.show(ChildForm_Menu.this, "", "Please Wait . . .", true);
                new Thread() {
                    public void run() {
                        try {
                            Bundle IDbundle = new Bundle();
                            IDbundle.putString("UNCode", UNCODE);
                            IDbundle.putString("StructureNo", STRUCTURENO);
                            IDbundle.putString("HouseholdSl", HOUSEHOLDSL);
                            IDbundle.putString("VisitNo", VISITNO);
                            IDbundle.putString("MemSl",""+MEMSL);
                            IDbundle.putString("Name",""+NAME);
                            IDbundle.putString("DeviceId", DEVICEID);
                            Intent f1 = new Intent(getApplicationContext(), Child_Final_Status.class);
                            f1.putExtras(IDbundle);
                            startActivityForResult(f1,1);
                        }
                        catch (Exception e) {
                            Connection.MessageBox(ChildForm_Menu.this, e.getMessage());
                            return;
                        }
                        progDailog.dismiss();
                    }
                }.start();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_CANCELED) {
            //Write your code if there's no result
        } else {
            changeButtonColor();
        }
    }

    private void changeButtonColor()
    {
        String member,typhoid = null,meningitis = null,diarrhoea = null,operation = null,otitis = null,immunization = null,admission=null,finalstatus=null,pneumonia=null;

        String sql="select ifnull(m.memsl,'') member,ifnull(tc.memsl,'') typhoid,ifnull(pc.memsl,'') pneumonia,ifnull(mc.memsl,'') meningitis,ifnull(d.memsl,'') diarrhoea,ifnull(ie.memsl,'') operation,ifnull(oc.memsl,'') otitis, ifnull(im.memsl,'') immunization,ifnull(ad.memsl,'') admission,ifnull(cfs.memsl,'') finalstatus from member m\n" +
                "left outer join TyphoidCase tc on m.uncode=tc.uncode and m.StructureNo=tc.StructureNo and m.HouseholdSl=tc.HouseholdSl and m.VisitNo=tc.VisitNo and m.MemSl=tc.MemSl\n" +
                "left outer join MeningitisCase mc on m.uncode=mc.uncode and m.StructureNo=mc.StructureNo and m.HouseholdSl=mc.HouseholdSl and m.VisitNo=mc.VisitNo and m.MemSl=mc.MemSl\n" +
                "left outer join DiarrhoeaCase d on m.uncode=d.uncode and m.StructureNo=d.StructureNo and m.HouseholdSl=d.HouseholdSl and m.VisitNo=d.VisitNo and m.MemSl=d.MemSl\n" +
                "left outer join EmergencyOperation ie on m.uncode=ie.uncode and m.StructureNo=ie.StructureNo and m.HouseholdSl=ie.HouseholdSl and m.VisitNo=ie.VisitNo and m.MemSl=ie.MemSl\n" +
                "left outer join OtitisMediaCase oc on m.uncode=oc.uncode and m.StructureNo=oc.StructureNo and m.HouseholdSl=oc.HouseholdSl and m.VisitNo=oc.VisitNo and m.MemSl=oc.MemSl\n" +
                "left outer join Immunization_Master im on m.uncode=im .uncode and m.StructureNo=im .StructureNo and m.HouseholdSl=im .HouseholdSl and m.VisitNo=im .VisitNo and m.MemSl=im .MemSl\n" +
                "left outer join Admission_Refusal ad on m.uncode=ad .uncode and m.StructureNo=ad .StructureNo and m.HouseholdSl=ad .HouseholdSl and m.VisitNo=ad .VisitNo and m.MemSl=ad .MemSl\n" +
                "left outer join PneumoniaCase pc on m.uncode=pc .uncode and m.StructureNo=pc .StructureNo and m.HouseholdSl=pc .HouseholdSl and m.VisitNo=pc .VisitNo and m.MemSl=pc .MemSl\n" +
                "left outer join Child_Final_Status cfs on m.uncode=cfs .uncode and m.StructureNo=cfs .StructureNo and m.HouseholdSl=cfs .HouseholdSl and m.VisitNo=cfs .VisitNo and m.MemSl=cfs .MemSl\n" +
                "where m.uncode='"+UNCODE+"' and m.StructureNo='"+STRUCTURENO+"' and m.HouseholdSl='"+HOUSEHOLDSL+"' and m.VisitNo='"+VISITNO+"' and m.MemSl='"+MEMSL+"' and m.DeviceID='"+DEVICEID+"'";
        Connection c=new Connection(ChildForm_Menu.this);
        Cursor cur=c.ReadData(sql);
        cur.moveToFirst();
        while(!cur.isAfterLast())
        {
            member = cur.getString(cur.getColumnIndex("member"));
            typhoid = cur.getString(cur.getColumnIndex("typhoid"));
            meningitis = cur.getString(cur.getColumnIndex("meningitis"));
            diarrhoea = cur.getString(cur.getColumnIndex("diarrhoea"));
            operation = cur.getString(cur.getColumnIndex("operation"));
            otitis = cur.getString(cur.getColumnIndex("otitis"));
            immunization = cur.getString(cur.getColumnIndex("immunization"));
            admission = cur.getString(cur.getColumnIndex("admission"));
            finalstatus = cur.getString(cur.getColumnIndex("finalstatus"));
            pneumonia = cur.getString(cur.getColumnIndex("pneumonia"));
            cur.moveToNext();
        }
        cur.close();

        if(!immunization.equals(""))
        {
            btnImu.setBackgroundResource(R.drawable.button_style_green);
        }else
        {
            btnImu.setBackgroundResource(R.drawable.button_style_yellow);
        }

        if(!typhoid.equals(""))
        {
            btnTyphoid.setBackgroundResource(R.drawable.button_style_green);
        }else
        {
            btnTyphoid.setBackgroundResource(R.drawable.button_style_yellow);
        }

        if(!pneumonia.equals(""))
        {
            btnPneumonia.setBackgroundResource(R.drawable.button_style_green);
        }else
        {
            btnPneumonia.setBackgroundResource(R.drawable.button_style_yellow);
        }

        if(!meningitis.equals(""))
        {
            btnMeningitis.setBackgroundResource(R.drawable.button_style_green);
        }else
        {
            btnMeningitis.setBackgroundResource(R.drawable.button_style_yellow);
        }

        if(!diarrhoea.equals(""))
        {
            btnDiarrhoea.setBackgroundResource(R.drawable.button_style_green);
        }else
        {
            btnDiarrhoea.setBackgroundResource(R.drawable.button_style_yellow);
        }

        if(!operation.equals(""))
        {
            btnOperation.setBackgroundResource(R.drawable.button_style_green);
        }else
        {
            btnOperation.setBackgroundResource(R.drawable.button_style_yellow);
        }

        if(!otitis.equals(""))
        {
            btnOtitis.setBackgroundResource(R.drawable.button_style_green);
        }else
        {
            btnOtitis.setBackgroundResource(R.drawable.button_style_yellow);
        }

        if(!admission.equals(""))
        {
            btnAddMissionRefusal.setBackgroundResource(R.drawable.button_style_green);
        }else
        {
            btnAddMissionRefusal.setBackgroundResource(R.drawable.button_style_yellow);
        }

        if(!finalstatus.equals(""))
        {
            btnStatus.setBackgroundResource(R.drawable.button_style_green);
        }else
        {
            btnStatus.setBackgroundResource(R.drawable.button_style_yellow);
        }
    }
}
