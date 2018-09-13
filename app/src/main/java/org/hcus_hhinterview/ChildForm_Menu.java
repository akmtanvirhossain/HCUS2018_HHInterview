package org.hcus_hhinterview;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import Common.Connection;

public class ChildForm_Menu extends AppCompatActivity {

    Bundle IDbundle;
    static String UNCODE = "";
    static String STRUCTURENO = "";
    static String HOUSEHOLDSL = "";
    static String VISITNO = "";
    static String MEMSL = "";
    static String AGE = "";

    Button btnImu,btnTyphoid,btnMeningitis,btnPneumonia,btnDiarrhoea,btnOperation,btnOtitis;

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

        btnImu=findViewById(R.id.btnImu);
        btnTyphoid=findViewById(R.id.btnTyphoid);
        btnMeningitis=findViewById(R.id.btnMeningitis);
        btnPneumonia=findViewById(R.id.btnPneumonia);
        btnDiarrhoea=findViewById(R.id.btnDiarrhoea);
        btnOperation=findViewById(R.id.btnOperation);
        btnOtitis=findViewById(R.id.btnOtitis);

        if(Integer.parseInt(AGE) < 60)
        {
            btnPneumonia.setEnabled(false);
            btnPneumonia.setBackgroundResource(R.drawable.button_style_red);
        }
        else if(Integer.parseInt(AGE) >= 1826 & Integer.parseInt(AGE) < 6574)
        {
            btnImu.setEnabled(false);
            btnImu.setBackgroundResource(R.drawable.button_style_red);
            btnMeningitis.setEnabled(false);
            btnMeningitis.setBackgroundResource(R.drawable.button_style_red);
            btnPneumonia.setEnabled(false);
            btnPneumonia.setBackgroundResource(R.drawable.button_style_red);
            btnDiarrhoea.setEnabled(false);
            btnDiarrhoea.setBackgroundResource(R.drawable.button_style_red);
        }


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
//                            IDbundle.putString("Age",""+AGE);
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



    }
}
