package org.hcus_hhinterview;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import Common.Connection;
import Common.Global;


public class SettingForm extends Activity {
    Connection C;
    Global g;
    static String DeviceID = "";
    ProgressDialog progDailog;
    int jumpTime = 0;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            setContentView(R.layout.devicesetting);
            C = new Connection(this);
            g = Global.getInstance();

            if (!Connection.haveNetworkConnection(SettingForm.this)) {
                Connection.MessageBox(SettingForm.this, "Inernet connection is not available for device setting.");
                return;
            }

            final Spinner spnUser = (Spinner)findViewById(R.id.spnUser);
            SpinnerItem(spnUser, "select DeviceId+'-'+DeviceName from DeviceList order by DeviceId");

            Button cmdSave = (Button)findViewById(R.id.cmdSave);
            cmdSave.setOnClickListener(new View.OnClickListener() {
                public void onClick(View arg0) {
                    try {
                        String SQLStr   = "";

                        String[] User = spnUser.getSelectedItem().toString().split("-");
                        DeviceID = User[0];

                        String Setting = C.ReturnResult("Existence", "Select DeviceId from DeviceList where DeviceId='"+ Connection.SelectedSpinnerValue(spnUser.getSelectedItem().toString(),"-") +"' and Setting='1'");
                        if (Setting.equals("2")) {
                            Connection.MessageBox(SettingForm.this, "Device ID :"+ spnUser.getSelectedItem().toString() +" is not allowed to configure a mobile device, contact with administrator.");
                            return;
                        }

                        String ResponseString="Status:";

                        progDailog = new ProgressDialog(SettingForm.this);
                        progDailog.setMessage("Rebuilding database, Please Wait . . .");
                        progDailog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                        //progDailog.setIcon(R.drawable.champsicon);
                        progDailog.setIndeterminate(false);
                        progDailog.setCancelable(false);
                        progDailog.setProgress(0);
                        progDailog.show();

                        new Thread() {
                            public void run() {
                                try {
                                    C.RebuildDatabase(DeviceID, progDailog, progressHandler);
                                } catch (Exception e) {

                                }
                                progDailog.dismiss();

                                //Call Login Form
                                finish();
                                Intent f1 = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(f1);

                            }
                        }.start();
                    }
                    catch(Exception ex)
                    {
                        Connection.MessageBox(SettingForm.this, ex.getMessage());
                        return;
                    }
                }


                Handler progressHandler = new Handler() {
                    public void handleMessage(Message msg) {
                        progDailog.setMessage(Global.getInstance().getProgressMessage());
                        progDailog.incrementProgressBy(jumpTime);
                    }
                };
            });
        }
        catch(Exception ex)
        {
            Connection.MessageBox(SettingForm.this, ex.getMessage());
            return;
        }
    }

    private void SpinnerItem(Spinner SpinnerName, String SQL)
    {
        List<String> listItem = new ArrayList<String>();
        listItem = C.DataListJSON(SQL);
        ArrayAdapter<String> adptrList= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listItem);
        SpinnerName.setAdapter(adptrList);
    }
}