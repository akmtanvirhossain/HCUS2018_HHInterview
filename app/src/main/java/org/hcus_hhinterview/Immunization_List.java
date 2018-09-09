package org.hcus_hhinterview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.List;

import Common.Connection;
import data_model.Immunization_List_DataModel;

public class Immunization_List extends AppCompatActivity {

    static String TableName;
    LinearLayout SecImmunization_List;

    Bundle IDbundle;
    static String UNCODE = "";
    static String STRUCTURENO = "";
    static String HOUSEHOLDSL = "";
    static String VISITNO = "";
    static String MEMSL = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_immunization__list);

        TableName = "Immunization_List";

        IDbundle = getIntent().getExtras();
        UNCODE = IDbundle.getString("UNCode");
        STRUCTURENO = IDbundle.getString("StructureNo");
        HOUSEHOLDSL = IDbundle.getString("HouseholdSl");
        VISITNO = IDbundle.getString("VisitNo");
        MEMSL = IDbundle.getString("MemSl");

        SecImmunization_List= findViewById(R.id.SecImmunization_List);

        DataSearch();
    }

    private void DataSearch()
    {
        try
        {
            Immunization_List_DataModel d = new Immunization_List_DataModel();
            String SQL = "Select * from "+ TableName; //+"  Where Vacc_Id='"+ Vacc_Id +"'";
            List<Immunization_List_DataModel> data = d.SelectAll(this, SQL);
            for(final Immunization_List_DataModel item : data){
                Button button=new Button(this);
                button.setId(Integer.parseInt(item.getVacc_Id()));
                button.setText(item.getVacc_Name());

                SecImmunization_List.addView(button);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Bundle IDbundle = new Bundle();
                        IDbundle.putString("UNCode", UNCODE);
                        IDbundle.putString("StructureNo", STRUCTURENO);
                        IDbundle.putString("HouseholdSl", HOUSEHOLDSL);
                        IDbundle.putString("VisitNo", VISITNO);
                        IDbundle.putString("MemSl",""+MEMSL);
                        IDbundle.putString("Vacc_Id",""+item.getVacc_Id());
//                            IDbundle.putString("Age",""+AGE);
                        Intent f1 = new Intent(getApplicationContext(), Immunization_History.class);
                        f1.putExtras(IDbundle);
                        startActivityForResult(f1,1);

                    }
                });

            }
        }
        catch(Exception  e)
        {
            Connection.MessageBox(Immunization_List.this, e.getMessage());
            return;
        }
    }
}
