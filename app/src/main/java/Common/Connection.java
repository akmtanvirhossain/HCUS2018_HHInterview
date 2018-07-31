package Common;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.os.Handler;
import android.widget.ArrayAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
//import org.icddrb.standard.R;
import org.hcus_hhinterview.R;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import Utility.CompressZip;

//--------------------------------------------------------------------------------------------------
// Created by TanvirHossain on 17/03/2015.
//--------------------------------------------------------------------------------------------------
public class Connection extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DB_NAME    = Global.DatabaseName;
    private static final String DBLocation = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + Global.DatabaseFolder + File.separator + DB_NAME;
    //public static final String PASS_PHRASE="!@#ABC";

    // Todo table name
    private static final String TABLE_TODO = "todo_items";
    private static Context ud_context;
    private Context dbContext;

    public Connection(Context context) {
        super(context, DBLocation, null, DATABASE_VERSION);
        dbContext = context;
        ud_context = context;

    }

    /*private static Connection instance;
    static public  synchronized  Connection getInstance(Context context)
    {
        if(instance == null)
            instance= new Connection(context);
        return instance;
    }*/


    //Split function
    //----------------------------------------------------------------------------------------------
    public static String[] split(String s, char separator) {
        ArrayList<String> d = new ArrayList<String>();
        for (int ini = 0, end = 0; ini <= s.length(); ini = end + 1) {
            end = s.indexOf(separator, ini);
            if (end == -1) {
                end = s.length();
            }

            String st = s.substring(ini, end).trim();

            if (st.length() > 0) {
                d.add(st);
            } else {
                d.add("");
            }
        }

        String[] temp = new String[d.size()];
        temp = d.toArray(temp);
        return temp;
    }

    public static void MessageBox(final Context ClassName, final String Msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(ClassName);
        builder.setMessage(Msg)
                .setTitle("Message")
                .setCancelable(true)
                //.setIcon(R.drawable.logo)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if (Msg.equals("Saved Successfully")) {
                            ((Activity) ClassName).finish();
                        }
                    }
                });
        builder.show();
    }

    public static void MessageBoxNotClose(Context ClassName, String Msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(ClassName);
        builder.setMessage(Msg)
                .setTitle("Message")
                .setCancelable(true)
                //.setIcon(R.drawable.logo)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton("Ok", null);
        builder.show();
    }

    //Check whether internet connectivity available or not
    //----------------------------------------------------------------------------------------------
    public static boolean haveNetworkConnection(Context con) {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;
        try {
            ConnectivityManager cm = (ConnectivityManager) con.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo[] netInfo = cm.getAllNetworkInfo();
            for (NetworkInfo ni : netInfo) {
                if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                    if (ni.isConnected())
                        haveConnectedWifi = true;
                if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                    if (ni.isConnected())
                        haveConnectedMobile = true;
            }
        } catch (Exception e) {

        }
        return haveConnectedWifi || haveConnectedMobile;
    }

    public static String SelectedSpinnerValue(String SelectedTest, String SplitValue) {
        String[] D = SelectedTest.split(SplitValue);
        return D[0];
    }

    public static void ExecuteSQLFromFile(String fileName) {
        List<String> dataList = Global.ReadTextFile(fileName);
        Connection C = new Connection(ud_context);
        for (int i = 0; i < dataList.size(); i++) {
            C.Save(dataList.get(i));
        }
    }

    // Creating our initial tables
    // These is where we need to write create table statements.
    // This is called when database is created.
    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.execSQL("Create Table abc(sid varchar(10))");
    }

    // Upgrading the database between versions
    // This method is called when database is upgraded like modifying the table structure,
    // adding constraints to database, etc
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion == 1) {
            // Wipe older tables if existed
            //db.execSQL("DROP TABLE IF EXISTS " + TABLE_TODO);
            // Create tables again
            onCreate(db);
        }
    }

    //Check the existence of database table
    //----------------------------------------------------------------------------------------------
    public boolean TableExists(String TableName) {
        Cursor c = null;
        boolean tableExists = false;
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            c = db.rawQuery("Select * from " + TableName, null);
            tableExists = true;
            c.close();
            db.close();
        } catch (Exception e) {
        }
        return tableExists;
    }

    //Create database tables
    //----------------------------------------------------------------------------------------------
    public void CreateTable(String TableName, String SQL) {
        SQLiteDatabase db = getWritableDatabase();
        try {
            if (!TableExists(TableName)) {
                db.execSQL(SQL);
            }
        }catch(Exception ex){

        }finally {
            db.close();
        }

    }


    //Message Box
    //----------------------------------------------------------------------------------------------
/*    public static void MessageBox(Context ClassName,String Msg)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(ClassName);
        builder.setMessage(Msg)
                .setTitle("Message")
                .setCancelable(true)
                //.setIcon(R.drawable.logo)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton("Ok", null);
        builder.show();
    }*/

    //Read data from database and return to Cursor variable
    //----------------------------------------------------------------------------------------------
    public Cursor ReadData(String SQL) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur = db.rawQuery(SQL, null);
        //db.close();
        return cur;
    }

    //Check existence of data in database
    //----------------------------------------------------------------------------------------------
    public boolean Existence(String SQL) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur = db.rawQuery(SQL, null);
        if (cur.getCount() == 0) {
            cur.close();
            db.close();
            return false;
        } else {
            cur.close();
            db.close();
            return true;
        }
    }

    //Return single result based on the SQL query
    //----------------------------------------------------------------------------------------------
    public String ReturnSingleValue(String SQL) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur = db.rawQuery(SQL, null);
        String retValue = "";
        cur.moveToFirst();
        while (!cur.isAfterLast()) {
            retValue = cur.getString(0);
            cur.moveToNext();
        }
        cur.close();
        db.close();
        return retValue;
    }

    //Save/Update/Delete data in to database
    //----------------------------------------------------------------------------------------------
    public void Save(String SQL) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            db.execSQL(SQL);
        }catch(Exception ex){
            String a = ex.getMessage();
        }finally {
            db.close();
        }
    }

    //Date: 22 Jun 2017 for DataSync
    public String SaveData(String SQL) {
        String response = "";
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            db.execSQL(SQL);
        }catch(Exception ex){
            response = ex.getMessage();
        }finally {
            db.close();
        }
        return response;
    }

    //Generate data list
    //----------------------------------------------------------------------------------------------
    public List<String> getDataList(String SQL) {
        List<String> data = new ArrayList<String>();
        Cursor cursor = ReadData(SQL);
        if (cursor.moveToFirst()) {
            do {
                data.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }

        cursor.close();
        return data;
    }

    public String[] getArrayList(String SQL) {
        List<String> data = new ArrayList<String>();
        Cursor cursor = ReadData(SQL);
        if (cursor.moveToFirst()) {
            do {
                data.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }

        String[] mStringArray = new String[data.size()];
        mStringArray = data.toArray(mStringArray);

        cursor.close();
        return mStringArray;
    }

    //Array adapter for spinner item
    //----------------------------------------------------------------------------------------------
    public ArrayAdapter<String> getArrayAdapter(String SQL) {
        List<String> dataList = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(SQL, null);
        if (cursor.moveToFirst()) {
            do {
                dataList.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this.dbContext,
                R.layout.multiline_spinner_dropdown_item, dataList);

        return dataAdapter;
    }

    //Execute command on Database Server
    //----------------------------------------------------------------------------------------------
    public String ExecuteCommandOnServer(String SQLStr) {
        String response = "";
        String result = "";
        ExecuteCommand e = new ExecuteCommand();

        try {
            response = e.execute(SQLStr).get();
            if (response.equals("done")) {
                result = "done";
            } else {
                result = "not";
            }
        } catch (Exception e1) {
            result = "not";
        }

        return result;
    }

    //Find the variable positions in an array list
    //----------------------------------------------------------------------------------------------
    public int VarPosition(String VariableName, String[] ColumnList) {
        int pos = 0;
        for (int i = 0; i < ColumnList.length; i++) {
            if (VariableName.trim().equalsIgnoreCase(ColumnList[i].toString().trim())) {
                pos = i;
                i = ColumnList.length;
            }
        }
        return pos;
    }

    // Getting array list for Upload with ^ separator from Cursor
    //----------------------------------------------------------------------------------------------
    public String[] GenerateArrayList(String VariableList, String TableName) {
        Cursor cur_H;
        cur_H = ReadData("Select " + VariableList + " from " + TableName + " where Upload='2'");

        cur_H.moveToFirst();
        String[] Data = new String[cur_H.getCount()];
        String DataList = "";
        String[] Count = VariableList.toString().split(",");
        int RecordCount = 0;

        while (!cur_H.isAfterLast()) {
            for (int c = 0; c < Count.length; c++) {
                if (c == 0) {
                    if (cur_H.getString(c) == null)
                        DataList = "";
                    else if (cur_H.getString(c).equals("null"))
                        DataList = "";
                    else
                        DataList = cur_H.getString(c).toString();

                } else {
                    if (cur_H.getString(c) == null)
                        DataList += "^" + "";
                    else if (cur_H.getString(c).equals("null"))
                        DataList += "^" + "";
                    else
                        DataList += "^" + cur_H.getString(c).toString();
                }
            }
            Data[RecordCount] = DataList;
            RecordCount += 1;
            cur_H.moveToNext();
        }
        cur_H.close();

        return Data;
    }

    public List<String> DataListJSON(String SQL) {
        Gson gson = new Gson();
        DownloadDataJSON dload = new DownloadDataJSON();
        String response = null;
        try {
            response = dload.execute(SQL).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        List<String> data = new ArrayList<String>();
        DownloadClass responseData = gson.fromJson(response, DownloadClass.class);
        data = responseData.getdata();
        return data;
    }

    public List<DataClassProperty> GetDataListJSON(String VariableList, String TableName, String UniqueField) {
        String SQL = "";
        SQL = "Select " + VariableList + " from " + TableName + " where Upload='2'";

        Cursor cur_H = ReadData(SQL);
        cur_H.moveToFirst();
        List<DataClassProperty> data = new ArrayList<DataClassProperty>();
        DataClassProperty d;

        String DataList = "";
        String[] Count = VariableList.toString().split(",");
        String[] UField = UniqueField.toString().split(",");
        int RecordCount = 0;

        String WhereClause = "";
        String VarData[];
        int varPos = 0;
        while (!cur_H.isAfterLast()) {
            //Prepare Data List
            for (int c = 0; c < Count.length; c++) {
                if (c == 0) {
                    if (cur_H.getString(c) == null)
                        DataList = "";
                    else if (cur_H.getString(c).equals("null"))
                        DataList = "";
                    else
                        DataList = cur_H.getString(c).toString().trim();

                } else {
                    if (cur_H.getString(c) == null)
                        DataList += "^" + "";
                    else if (cur_H.getString(c).equals("null"))
                        DataList += "^" + "";
                    else
                        DataList += "^" + cur_H.getString(c).toString().trim();
                }
            }

            //Prepare Where Clause
            VarData = DataList.split("\\^");
            varPos = 0;


            for (int j = 0; j < UField.length; j++) {
                varPos = VarPosition(UField[j].toString(), Count);
                if (j == 0) {
                    WhereClause = UField[j].toString() + "=" + "'" + VarData[varPos].toString() + "'";
                } else {
                    WhereClause += " and " + UField[j].toString() + "=" + "'" + VarData[varPos].toString() + "'";
                }
            }

            d = new DataClassProperty();
            d.setdatalist(DataList);
            d.setuniquefieldwithdata(WhereClause);
            data.add(d);

            RecordCount += 1;
            cur_H.moveToNext();
        }
        cur_H.close();

        return data;
    }

    public List<DataClassProperty> GetDataListJSON_Bangla(String VariableList, String TableName, String UniqueField) {
        Cursor cur_H = ReadData("Select " + VariableList + " from " + TableName + " where Upload='2'");
        cur_H.moveToFirst();
        List<DataClassProperty> data = new ArrayList<DataClassProperty>();
        DataClassProperty d;

        String DataList = "";
        String[] Count = VariableList.toString().split(",");
        String[] UField = UniqueField.toString().split(",");
        int RecordCount = 0;

        String WhereClause = "";
        String VarData[];
        int varPos = 0;
        while (!cur_H.isAfterLast()) {
            //Prepare Data List
            for (int c = 0; c < Count.length; c++) {
                if (c == 0) {
                    if (cur_H.getString(c) == null)
                        DataList = "";
                    else if (cur_H.getString(c).equals("null"))
                        DataList = "";
                    else
                        DataList = "N" + cur_H.getString(c).toString().trim();

                } else {
                    if (cur_H.getString(c) == null)
                        DataList += "^N" + "";
                    else if (cur_H.getString(c).equals("null"))
                        DataList += "^N" + "";
                    else
                        DataList += "^N" + cur_H.getString(c).toString().trim();
                }
            }

            //Prepare Where Clause
            VarData = DataList.split("\\^");
            varPos = 0;


            for (int j = 0; j < UField.length; j++) {
                varPos = VarPosition(UField[j].toString(), Count);
                if (j == 0) {
                    WhereClause = UField[j].toString() + "=" + "'" + VarData[varPos].toString() + "'";
                } else {
                    WhereClause += " and " + UField[j].toString() + "=" + "'" + VarData[varPos].toString() + "'";
                }
            }

            d = new DataClassProperty();
            d.setdatalist(DataList);
            d.setuniquefieldwithdata(WhereClause);
            data.add(d);

            RecordCount += 1;
            cur_H.moveToNext();
        }
        cur_H.close();

        return data;
    }

    //Final
    public String DownloadJSON(String SQL, String TableName, String ColumnList, String UniqueField, String UserId) {
        String WhereClause = "";
        int varPos = 0;
        int varPos_modifyDate = 0;

        String response = "";
        String resp = "";

        try {
            DownloadDataJSON dload = new DownloadDataJSON();
            response = dload.execute(SQL).get();

            //Process Response
            DownloadClass d = new DownloadClass();
            Gson gson = new Gson();
            Type collType = new TypeToken<DownloadClass>() {
            }.getType();
            DownloadClass responseData = gson.fromJson(response, collType);

            String UField[] = UniqueField.split(",");
            String VarList[] = ColumnList.split(",");

            List<String> dataStatus = new ArrayList<>();
            String modifyDate = "";
            String UID = "";
            String USID = "";
            String DataList = "";
            DataClassProperty dd;
            List<DataClassProperty> dataTemp = new ArrayList<DataClassProperty>();
            List<DataClassProperty> data     = new ArrayList<DataClassProperty>();

            String downloadSyncStatus = "";

            if (responseData != null & responseData.getdata().size()>0) {
                SQL = "Insert or replace into "+ TableName +"("+ ColumnList +")Values";
                for (int i = 0; i < responseData.getdata().size(); i++) {
                    String VarData[] = split(responseData.getdata().get(i).toString(), '^');

                    //Generate where clause/Unique ID
                    //------------------------------------------------------------------------------
                    //Generate Unique ID
                    //------------------------------------------------------------------------------
                    for (int j = 0; j < UField.length; j++) {
                        varPos = VarPosition(UField[j].toString(), VarList);

                        if (j == 0) {
                            UID += VarData[varPos].toString();
                        } else {
                            UID += VarData[varPos].toString();
                        }
                    }

                    varPos_modifyDate = VarPosition("modifyDate", VarList);
                    modifyDate = VarData[varPos_modifyDate].toString();//.replace("null", "");

                    //------------------------------------------------------------------------------
                    if (i == 0) {
                        SQL += "('" + responseData.getdata().get(i).toString().replace("^","','").replace("null","") +"')";
                    } else {
                        SQL += ",('" + responseData.getdata().get(i).toString().replace("^","','").replace("null","") +"')";
                    }

                    //Populate class with data for sync_management
                    //------------------------------------------------------------------------------
                    DataList = TableName + "^" + UID + "^" + UserId + "^" + modifyDate;
                    dd = new DataClassProperty();
                    dd.setdatalist(DataList);
                    dd.setuniquefieldwithdata("" +
                            "TableName='" + TableName + "' and " +
                            "UniqueID='" + UID + "' and " +
                            "UserId='" + UserId + "' and " +
                            "modifyDate='" + modifyDate + "'");
                    dataTemp.add(dd);

                    UID = "";
                }

                //If there have no error then response send back to server
                downloadSyncStatus = SaveData(SQL);
                if(downloadSyncStatus.length()==0){
                    data = dataTemp;
                }else{
                    resp = downloadSyncStatus;
                }

                //Update data to Server on sync management
                //------------------------------------------------------------------------------
                DataClass dt = new DataClass();
                dt.settablename("Sync_Management");
                dt.setcolumnlist("TableName, UniqueID, UserId, modifyDate");
                dt.setuniquefields("TableName, UniqueID, UserId, modifyDate");
                dt.setdata(data);

                Gson gson1 = new Gson();
                String json1 = gson1.toJson(dt);
                String resp1 = "";

                UploadDataJSON u = new UploadDataJSON();

                try {
                    resp1 = u.execute(json1).get();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        } catch (Exception e) {
            resp += e.getMessage();
            e.printStackTrace();
        }
        return resp;
    }

    public String DownloadJSON_UpdateServer(String SQL, String TableName, String ColumnList, String UniqueField) {
        String WhereClause = "";
        int varPos = 0;

        String response = "";
        String resp = "";

        try {
            DownloadDataJSON dload = new DownloadDataJSON();
            response = dload.execute(SQL).get();

            //Process Response
            DownloadClass d = new DownloadClass();
            Gson gson = new Gson();
            Type collType = new TypeToken<DownloadClass>() {
            }.getType();
            DownloadClass responseData = gson.fromJson(response, collType);

            String UField[] = UniqueField.split(",");
            String VarList[] = ColumnList.split(",");

            List<String> dataStatus = new ArrayList<>();

            for (int i = 0; i < responseData.getdata().size(); i++) {
                String VarData[] = split(responseData.getdata().get(i).toString(), '^');

                //Generate where clause
                SQL = "";
                WhereClause = "";
                varPos = 0;
                for (int j = 0; j < UField.length; j++) {
                    varPos = VarPosition(UField[j].toString(), VarList);
                    if (j == 0) {
                        WhereClause = UField[j].toString() + "=" + "'" + VarData[varPos].toString() + "'";
                    } else {
                        WhereClause += " and " + UField[j].toString() + "=" + "'" + VarData[varPos].toString() + "'";
                    }
                }

                //Update command
                if (Existence("Select " + VarList[0] + " from " + TableName + " Where " + WhereClause)) {
                    for (int r = 0; r < VarList.length; r++) {
                        if (r == 0) {
                            SQL = "Update " + TableName + " Set ";
                            SQL += VarList[r] + " = '" + VarData[r].toString() + "'";
                        } else {
                            if (r == VarData.length - 1) {
                                SQL += "," + VarList[r] + " = '" + VarData[r].toString() + "'";
                                SQL += " Where " + WhereClause;
                            } else {
                                SQL += "," + VarList[r] + " = '" + VarData[r].toString() + "'";
                            }
                        }
                    }

                    Save(SQL);
                }
                //Insert command
                else {
                    for (int r = 0; r < VarList.length; r++) {
                        if (r == 0) {
                            SQL = "Insert into " + TableName + "(" + ColumnList + ")Values(";
                            SQL += "'" + VarData[r].toString() + "'";
                        } else {
                            SQL += ",'" + VarData[r].toString() + "'";
                        }
                    }
                    SQL += ")";

                    Save(SQL);
                }

                dataStatus.add(WhereClause);
            }


            //Status back to server
            if (dataStatus.size() > 0) {
                //Generate SQL String
                List<String> sqlString = new ArrayList<>();
                for (String data : dataStatus) {
                    sqlString.add("Update " + TableName + " Set Upload='1' Where " + data);
                }

                DataClass_SQL_Update dt = new DataClass_SQL_Update();
                dt.setSQLString(sqlString);

                String json = gson.toJson(dt);
                UploadDataSQLJSON u = new UploadDataSQLJSON();
                try {
                    response = u.execute(json).get();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        } catch (Exception e) {
            resp = e.getMessage();
            e.printStackTrace();
        }

        return resp;
    }

    //Remove data on local device
    public String DownloadJSON_Delete_UpdateServer(String SQL, String LocalTableName, String ServerTableName, String ColumnList, String UniqueField) {
        String WhereClause = "";
        int varPos = 0;

        String response = "";
        String resp = "";

        try {
            DownloadDataJSON dload = new DownloadDataJSON();
            response = dload.execute(SQL).get();

            //Process Response
            DownloadClass d = new DownloadClass();
            Gson gson = new Gson();
            Type collType = new TypeToken<DownloadClass>() {
            }.getType();
            DownloadClass responseData = gson.fromJson(response, collType);

            String UField[] = UniqueField.split(",");
            String VarList[] = ColumnList.split(",");

            List<String> dataStatus = new ArrayList<>();

            for (int i = 0; i < responseData.getdata().size(); i++) {
                String VarData[] = split(responseData.getdata().get(i).toString(), '^');

                //Generate where clause
                SQL = "";
                WhereClause = "";
                varPos = 0;
                for (int j = 0; j < UField.length; j++) {
                    varPos = VarPosition(UField[j].toString(), VarList);
                    if (j == 0) {
                        WhereClause = UField[j].toString() + "=" + "'" + VarData[varPos].toString() + "'";
                    } else {
                        WhereClause += " and " + UField[j].toString() + "=" + "'" + VarData[varPos].toString() + "'";
                    }
                }

                //Delete command
                SQL = "Delete from " + LocalTableName + " Where " + WhereClause;

                Save(SQL);

                dataStatus.add(WhereClause);
            }


            //Status back to server
            if (dataStatus.size() > 0) {
                //Generate SQL String
                List<String> sqlString = new ArrayList<>();
                for (String data : dataStatus) {
                    sqlString.add("Update " + ServerTableName + " Set Upload='2' Where " + data);
                }

                DataClass_SQL_Update dt = new DataClass_SQL_Update();
                dt.setSQLString(sqlString);

                String json = gson.toJson(dt);
                UploadDataSQLJSON u = new UploadDataSQLJSON();
                try {
                    response = u.execute(json).get();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        } catch (Exception e) {
            resp = e.getMessage();
            e.printStackTrace();
        }

        return resp;
    }

    public String DownloadJSON_BlockUpdate_UpdateServer(String SQL, String LocalTableName, String ColumnList, String UniqueField) {
        String WhereClause = "";
        int varPos = 0;

        String response = "";
        String resp = "";

        try {
            DownloadDataJSON dload = new DownloadDataJSON();
            response = dload.execute(SQL).get();

            //Process Response
            DownloadClass d = new DownloadClass();
            Gson gson = new Gson();
            Type collType = new TypeToken<DownloadClass>() {
            }.getType();
            DownloadClass responseData = gson.fromJson(response, collType);

            String UField[] = UniqueField.split(",");
            String VarList[] = ColumnList.split(",");

            List<String> dataStatus = new ArrayList<>();

            for (int i = 0; i < responseData.getdata().size(); i++) {
                String VarData[] = split(responseData.getdata().get(i).toString(), '^');

                //Generate where clause
                SQL = "";
                WhereClause = "";
                varPos = 0;
                for (int j = 0; j < UField.length; j++) {
                    varPos = VarPosition(UField[j].toString(), VarList);
                    if (j == 0) {
                        WhereClause = UField[j].toString() + "=" + "'" + VarData[varPos].toString() + "'";
                    } else {
                        WhereClause += " and " + UField[j].toString() + "=" + "'" + VarData[varPos].toString() + "'";
                    }
                }

                //Delete command
                SQL = "Delete from " + LocalTableName + " Where " + WhereClause;

                Save(SQL);

                dataStatus.add(WhereClause);
            }


            //Status back to server
            if (dataStatus.size() > 0) {
                //Generate SQL String
                List<String> sqlString = new ArrayList<>();
                for (String data : dataStatus) {
                    sqlString.add("Update BariRemove Set Upload='2' Where " + data);
                }

                DataClass_SQL_Update dt = new DataClass_SQL_Update();
                dt.setSQLString(sqlString);

                String json = gson.toJson(dt);
                UploadDataSQLJSON u = new UploadDataSQLJSON();
                try {
                    response = u.execute(json).get();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        } catch (Exception e) {
            resp = e.getMessage();
            e.printStackTrace();
        }

        return resp;
    }

    //Download list item from server based on SQl query
    public List<String> DownloadJSONList(String SQL) {
        String response = "";
        String resp = "";

        List<String> dataStatus = new ArrayList<>();
        try {

            DownloadDataJSON dload = new DownloadDataJSON();
            response = dload.execute(SQL).get();

            //Process Response
            DownloadClass d = new DownloadClass();
            Gson gson = new Gson();
            Type collType = new TypeToken<DownloadClass>() {
            }.getType();
            DownloadClass responseData = gson.fromJson(response, collType);
            dataStatus = responseData.getdata();

        } catch (Exception e) {
            resp = e.getMessage();
            e.printStackTrace();
        }

        return dataStatus;
    }

    public String UploadJSON_orig(String TableName, String ColumnList, String UniqueFields) {
        String response = "";
        List<DataClassProperty> data = GetDataListJSON(ColumnList, TableName, UniqueFields);

        if (data.size() > 0) {
            DataClass dt = new DataClass();
            dt.settablename(TableName);
            dt.setcolumnlist(ColumnList);
            dt.setuniquefields(UniqueFields);

            dt.setdata(data);
            Gson gson = new Gson();
            String json = gson.toJson(dt);
            UploadDataJSON u = new UploadDataJSON();

            try {
                response = u.execute(json).get();

                //Process Response
                if (response != null) {
                    DownloadClass d = new DownloadClass();
                    Type collType = new TypeToken<DownloadClass>() {
                    }.getType();
                    DownloadClass responseData = gson.fromJson(response, collType);

                    //upload all records as successfull upload then update status of upload=2 for unsuccessfull
                    /*for (int i = 0; i < responseData.getdata().size(); i++) {
                        Save("Update " + TableName + " Set Upload='1' where " + responseData.getdata().get(i).toString());
                    }*/

                    String UpdateSQL = "";
                    for (int i = 0; i < responseData.getdata().size(); i++) {
                        UpdateSQL += "Update " + TableName + " Set Upload='1' where " + responseData.getdata().get(i).toString() +";";
                    }
                    Save(UpdateSQL);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return response;
    }

    //23 Jun 2017
    public String UploadJSON(String TableName, String ColumnList, String UniqueFields) {
        String response = "";
        List<DataClassProperty> data = GetDataListJSON(ColumnList, TableName, UniqueFields);

        if (data.size() > 0) {
            DataClass dt = new DataClass();
            dt.settablename(TableName);
            dt.setcolumnlist(ColumnList);
            dt.setuniquefields(UniqueFields);

            dt.setdata(data);
            Gson gson = new Gson();
            String json = gson.toJson(dt);
            UploadDataJSON u = new UploadDataJSON();
            try {
                response = u.execute(json).get();

                //Process Response
                if (response != null) {
                    DownloadClass d = new DownloadClass();
                    Type collType = new TypeToken<DownloadClass>() {
                    }.getType();
                    DownloadClass responseData = gson.fromJson(response, collType);

                    //upload all records as successfull upload then update status of upload=2 for unsuccessfull
                    for (int i = 0; i < responseData.getdata().size(); i++) {
                        Save("Update " + TableName + " Set Upload='1' where " + responseData.getdata().get(i).toString());
                    }

                    /*String UpdateSQL = "";
                    for (int i = 0; i < responseData.getdata().size(); i++) {
                        UpdateSQL += "Update " + TableName + " Set Upload='1' where " + responseData.getdata().get(i).toString() +";";
                    }
                    SaveDT(UpdateSQL);*/
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return response;
    }

    // Getting result from database server based on SQL
    //----------------------------------------------------------------------------------------------
    public String ReturnResult(String MethodName, String SQL) {
        ReturnResult r = new ReturnResult();
        String response = "";
        r.Method_Name = MethodName;
        r.SQLStr = SQL;
        try {
            response = r.execute("").get();
        } catch (InterruptedException e) {

            e.printStackTrace();
        } catch (ExecutionException e) {

            e.printStackTrace();
        }
        return response;
    }

    //Rebuild Local Database from Server
    //----------------------------------------------------------------------------------------------
    int count = 0;
    public void RebuildDatabase(String DeviceID, final ProgressDialog progDialog, Handler progHandler) {
        //------------------------------------------------------------------------------------------
        //Data Sync: Download data from server
        //------------------------------------------------------------------------------------------
        String Res = "";
        String TableName;
        String VariableList;
        String UniqueField;
        String SQLStr;

        try {
            //Remove data from Sync_Management
            //--------------------------------------------------------------------------------------
            ExecuteCommandOnServer("Delete from Sync_Management where UserId='" + DeviceID + "'");

            progHandler.post(new Runnable() {
                public void run() {
                    progDialog.setProgress(3);
                    progDialog.setMessage("Rebuilding database ...");
                }
            });
            List<String> listItem = new ArrayList<String>();
            listItem = DownloadJSONList("Select TableName+'^'+TableScript from DatabaseTab");
            for (int i = 0; i < listItem.size(); i++) {
                String VarData[] = split(listItem.get(i), '^');
                CreateTable(VarData[0], VarData[1]);
            }
            //Master Database Sync (Required for any database system)
            //--------------------------------------------------------------------------------------
            progHandler.post(new Runnable() {
                public void run() {
                    progDialog.setProgress(6);
                    progDialog.setMessage("Downloading Master Data ...");
                }
            });
            TableName = "DatabaseTab";
            VariableList = "TableName, TableScript, ColumnList, UniqueID, Sync_Upload, Sync_Download, BatchSize, modifyDate";
            UniqueField = "TableName";
            this.Sync_Download_DatabaseTab(TableName, VariableList, UniqueField,DeviceID,"");
            //--------------------------------------------------------------------------------------

            this.Sync_Download("DeviceList", DeviceID, "DeviceId='" + DeviceID + "'");

            progHandler.post(new Runnable() {
                public void run() {
                    progDialog.setProgress(0);
                    progDialog.setMessage("Downloading Data Collectors Data ...");
                }
            });
            final List<String> tableList = new ArrayList<String>();
            tableList.add("DataCollector");
            tableList.add("AreaDB");
            tableList.add("StructureDB");
            tableList.add("StructureID_Serial");
            tableList.add("StructureIDSlot");
            tableList.add("StructureListing");
            int progressCount = 100/tableList.size();

            for (int i = 0; i < tableList.size(); i++) {
                try {
                    this.Sync_Download(tableList.get(i).toString(), DeviceID, "");
                    count +=progressCount;
                    progHandler.post(new Runnable() {
                        public void run() {
                            progDialog.setProgress(count);
                            progDialog.setMessage("Downloading data, please wait...");
                        }
                    });
                }catch(Exception ex){

                }
            }

/*            this.Sync_Download("DataCollector", DeviceID, "");
            this.Sync_Download("AreaDB", DeviceID, "");
            this.Sync_Download("StructureDB", DeviceID, "");
            this.Sync_Download("StructureID_Serial", DeviceID, "");
            this.Sync_Download("StructureIDSlot", DeviceID, "");
            this.Sync_Download("StructureListing", DeviceID, "");*/

            //Download data from server
            //------------------------------------------------------------------------------

            //Update status on server
            //--------------------------------------------------------------------------------------
            progHandler.post(new Runnable() {
                public void run() {
                    progDialog.setProgress(100);
                    progDialog.setMessage("Finishing Setting ...");
                }
            });
            ExecuteCommandOnServer("Update DeviceList set Setting='2' where DeviceId='" + DeviceID + "'");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //For Rebuild database: done
    /*public void Sync_Download_Rebuild(String TableName, String WhereCondition) {
        String VariableList = "";
        String SQL_VariableList = "";
        String UniqueField = "";
        String SQLString = "";
        String Res = "";

        Cursor cur_H = ReadData("Select ColumnList as columnlist, UniqueID as uniqueid from DatabaseTab where lower(tablename)='" + TableName.toLowerCase() + "'");
        cur_H.moveToFirst();

        while (!cur_H.isAfterLast()) {
            VariableList = cur_H.getString(cur_H.getColumnIndex("columnlist"));
            UniqueField = cur_H.getString(cur_H.getColumnIndex("uniqueid"));
            SQL_VariableList = Convert_VariableList(TableName, VariableList);

            if (WhereCondition.length() == 0) {
                SQLString = "Select " + SQL_VariableList + " from " + TableName;
            } else {
                SQLString = "Select " + SQL_VariableList + " from " + TableName + " Where " + WhereCondition;
            }

            cur_H.moveToNext();
        }
        cur_H.close();

        Res = DownloadJSON(SQLString, TableName, VariableList, UniqueField);
    }*/

    public void DataSync_UploadDownload(List<String> tableList, String UserId) {

        //Upload data to server
        //------------------------------------------------------------------------------
        Sync_Upload(tableList);

        //Download data from server
        //------------------------------------------------------------------------------


        for (int i = 0; i < tableList.size(); i++)
            Sync_Download(tableList.get(i).toString(), UserId, "");

        /*for(int i=0;i<TableList.length;i++)
            Sync_Download(TableList[i], UserId, "");*/
    }

    //Final
    //batch wise data sync : based on the value of Column BatchSize in DatabaseTab table
    public void Sync_Download(String TableName, String UserId, String WhereClause) {
        //Retrieve sync parameter
        //------------------------------------------------------------------------------------------
        String[] SyncParam = Sync_Parameter(TableName);

        String SQLStr = SyncParam[0];
        String VariableList = SyncParam[1];
        String UniqueField = SyncParam[2];
        String SQL_VariableList = SyncParam[3];
        String Res = "";
        String SQL = "";

        //Generate Unique ID field
        //------------------------------------------------------------------------------------------
        String[] U = UniqueField.split(",");
        String UID = "";
        //String UID_Sync = "";
        for (int i = 0; i < U.length; i++) {
            if (i == 0)
                UID = "cast(t." + U[i] + " as varchar(50))";
            else
                UID += "+cast(t." + U[i] + " as varchar(50))";
        }

        //calculate total records
        //------------------------------------------------------------------------------------------
        Integer totalRecords = 0;
        SQL = "Select Count(*)totalRec from " + TableName + " as t";
        SQL += " where not exists(select * from Sync_Management where";
        SQL += " lower(TableName)  = lower('" + TableName + "') and";
        SQL += " UniqueID   = " + UID + " and";
        SQL += " convert(varchar(19),modifydate,120) = convert(varchar(19),t.modifydate,120) and";

        SQL += " UserId   ='" + UserId + "')";
        if (WhereClause.length() > 0) {
            SQL += " and " + WhereClause;
        }

        String totalRec = ReturnResult("ReturnSingleValue", SQL);
        if (totalRec == null)
            totalRecords = 0;
        else
            totalRecords = Integer.valueOf(totalRec);

        //Calculate batch size
        //------------------------------------------------------------------------------------------
        //0(zero) means all selected data
        //Integer batchSize = Integer.valueOf(ReturnSingleValue("select ifnull(batchsize,0)batchsize from DatabaseTab where TableName='" + TableName + "'"));
        Integer batchSize = 400;
        Integer totalBatch = 1;

        if (batchSize == 0) {
            totalBatch = 1;
            batchSize = totalRecords;
        } else if (batchSize > 0) {
            totalBatch = totalRecords / batchSize;
            if (totalRecords % batchSize > 0)
                totalBatch += 1;
        }

        //Execute batch download
        //------------------------------------------------------------------------------------------
        try {
            for (int i = 0; i < totalBatch; i++) {
                SQL = "Select top " + batchSize + " " + SQL_VariableList + " from " + TableName + " as t";
                SQL += " where not exists(select * from Sync_Management where";
                SQL += " lower(TableName)  = lower('" + TableName + "') and";
                SQL += " UniqueID   = " + UID + " and";
                SQL += " convert(varchar(19),modifydate,120) = convert(varchar(19),t.modifydate,120) and";
                SQL += " UserId   ='" + UserId + "')";
                if (WhereClause.length() > 0) {
                    SQL += " and " + WhereClause;
                }

                Res = DownloadJSON(SQL, TableName, VariableList, UniqueField, UserId);
            }
        }catch(Exception ex){

        }
    }


    //Final
    public void Sync_Download_DatabaseTab(String TableName, String VariableList, String UniqueField, String UserId, String WhereClause) {
        String SQL = "";
        String Res = "";

        //Generate Unique ID field
        //------------------------------------------------------------------------------------------
        String[] U = UniqueField.split(",");
        String UID = "";
        for (int i = 0; i < U.length; i++) {
            if (i == 0)
                UID = "cast(t." + U[i] + " as varchar(50))";
            else
                UID += "+cast(t." + U[i] + " as varchar(50))";
        }

        //calculate total records
        //------------------------------------------------------------------------------------------
        Integer totalRecords = 0;
        SQL = "Select Count(*)totalRec from " + TableName + " as t";
        SQL += " where not exists(select * from Sync_Management where";
        SQL += " lower(TableName)  = lower('" + TableName + "') and";
        SQL += " UniqueID   = " + UID + " and";
        SQL += " convert(varchar(19),modifydate,120) = convert(varchar(19),t.modifydate,120) and";

        SQL += " UserId   ='" + UserId + "')";
        if (WhereClause.length() > 0) {
            SQL += " and " + WhereClause;
        }

        String totalRec = ReturnResult("ReturnSingleValue", SQL);
        if (totalRec == null)
            totalRecords = 0;
        else
            totalRecords = Integer.valueOf(totalRec);

        //Calculate batch size
        //------------------------------------------------------------------------------------------
         Integer batchSize = 400;
        Integer totalBatch = 1;

        if (batchSize == 0) {
            totalBatch = 1;
            batchSize = totalRecords;
        } else if (batchSize > 0) {
            totalBatch = totalRecords / batchSize;
            if (totalRecords % batchSize > 0)
                totalBatch += 1;
        }

        //Execute batch download
        //------------------------------------------------------------------------------------------
        try {
            for (int i = 0; i < totalBatch; i++) {
                SQL = "Select top " + batchSize + " " + VariableList + " from " + TableName + " as t";
                SQL += " where not exists(select * from Sync_Management where";
                SQL += " lower(TableName)  = lower('" + TableName + "') and";
                SQL += " UniqueID   = " + UID + " and";
                SQL += " convert(varchar(19),modifydate,120) = convert(varchar(19),t.modifydate,120) and";
                SQL += " UserId   ='" + UserId + "')";
                if (WhereClause.length() > 0) {
                    SQL += " and " + WhereClause;
                }

                Res = DownloadJSON(SQL, TableName, VariableList, UniqueField, UserId);
            }
        }catch(Exception ex){

        }
    }

    private String Sync_UID(String[] UField, String[] VarList, String[] VarData){
        String UID = "";
        for (int x = 0; x < UField.length; x++) {
            for (int y = 0; y < VarList.length; y++) {
                if (UField[x].trim().equalsIgnoreCase(VarList[y].toString().trim())) {
                    UID +=  VarData[y].toString();
                    y = VarList.length;
                }
            }
        }
        return UID;
    }

    private String Sync_modifyDate(String modifyDate, String[] VarList, String[] VarData){
        String ModDate = "";
            for (int y = 0; y < VarList.length; y++) {
                if (modifyDate.trim().equalsIgnoreCase(VarList[y].toString().trim())) {
                    ModDate +=  VarData[y].toString();
                    y = VarList.length;
                }
            }
        return ModDate;
    }

    //Tanvir: Date: 19 Jun 2017
    private String DownloadJSON_Sync(String SQL, String TableName, String ColumnList, String UniqueField, String UserId) {
        String WhereClause = "";
        int varPos = 0;
        int varPos_modifyDate = 0;

        String response = "";
        String resp = "";

        try {

            DownloadDataJSON dload = new DownloadDataJSON();
            response = dload.execute(SQL).get();

            //Process Response
            DownloadClass d = new DownloadClass();
            Gson gson = new Gson();
            Type collType = new TypeToken<DownloadClass>() {
            }.getType();
            DownloadClass responseData = gson.fromJson(response, collType);

            String UField[] = UniqueField.split(",");
            String VarList[] = ColumnList.split(",");

            List<String> dataStatus = new ArrayList<>();
            String modifyDate = "";
            String UID = "";
            String USID = "";
            String DataList = "";
            DataClassProperty dd;
            List<DataClassProperty> dataTemp = new ArrayList<DataClassProperty>();
            List<DataClassProperty> data     = new ArrayList<DataClassProperty>();

            String downloadSyncStatus = "";

            if (responseData != null) {
                SQL = "Insert or replace into "+ TableName +"("+ ColumnList +")Values";
                for (int i = 0; i < responseData.getdata().size(); i++) {
                    String VarData[] = split(responseData.getdata().get(i).toString(), '^');

                    //Generate where clause/Unique ID
                    //------------------------------------------------------------------------------
                    UID = Sync_UID(UField, VarList, VarData);
                    modifyDate = Sync_modifyDate("modifyDate", VarList, VarData);

                    //------------------------------------------------------------------------------
                    if (i == 0) {
                        SQL += "('" + responseData.getdata().get(i).toString().replace("^","','").replace("null","") +"')";
                    } else {
                        SQL += ",('" + responseData.getdata().get(i).toString().replace("^","','").replace("null","") +"')";
                    }

                    //Populate class with data for sync_management
                    //------------------------------------------------------------------------------
                    DataList = TableName + "^" + UID + "^" + UserId + "^" + modifyDate;
                    dd = new DataClassProperty();
                    dd.setdatalist(DataList);
                    dd.setuniquefieldwithdata("" +
                            "TableName='" + TableName + "' and " +
                            "UniqueID='" + UID + "' and " +
                            "UserId='" + UserId + "' and " +
                            "modifyDate='" + modifyDate + "'");
                    dataTemp.add(dd);
                }

                //If there have no error then response send back to server
                downloadSyncStatus = SaveData(SQL);
                if(downloadSyncStatus.length()==0){
                    data = dataTemp;
                }else{
                    resp = downloadSyncStatus;
                }
            }

            //Update data to Server on sync management
            //------------------------------------------------------------------------------
            DataClass dt = new DataClass();
            dt.settablename("Sync_Management");
            dt.setcolumnlist("TableName, UniqueID, UserId, modifyDate");
            dt.setuniquefields(UniqueField);
            dt.setdata(data);

            Gson gson1 = new Gson();
            String json1 = gson1.toJson(dt);
            String resp1 = "";

            UploadDataJSON u = new UploadDataJSON();

            try {
                resp1 = u.execute(json1).get();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            resp += e.getMessage();
            e.printStackTrace();
        }

        return resp;
    }

    //done
    public String[] Sync_Parameter(String TableName) {
        String VariableList = "";
        String UniqueField = "";
        String SQLStr = "";
        String SQL_VariableList = "";

        Cursor cur_H = ReadData("Select ColumnList as columnlist, UniqueID as uniqueid from DatabaseTab where tablename='" + TableName + "'");
        cur_H.moveToFirst();

        while (!cur_H.isAfterLast()) {
            SQLStr = "Select " + cur_H.getString(cur_H.getColumnIndex("columnlist")) + " from " + TableName + " Where Upload='2'";
            VariableList = cur_H.getString(cur_H.getColumnIndex("columnlist"));
            SQL_VariableList = Convert_VariableList(TableName, VariableList);
            UniqueField = cur_H.getString(cur_H.getColumnIndex("uniqueid"));

            cur_H.moveToNext();
        }
        cur_H.close();
        String[] ParaList = new String[]{
                SQLStr,
                VariableList,
                UniqueField,
                SQL_VariableList
        };

        return ParaList;
    }

    private String Convert_VariableList(String TableName, String VariableList) {
        String finalVariableList = "";
        String[] tempList = VariableList.split(",");
        String tempVar = "";
        String temp = "";
        String[] DateVarList = DateVariableList(TableName).split(",");
        int matched = 2;
        for (int i = 0; i < tempList.length; i++) {
            temp = tempList[i];
            matched = 2;

            for (int j = 0; j < DateVarList.length; j++) {
                if (temp.equalsIgnoreCase(DateVarList[j]))
                    matched = 1;
            }

            if (matched == 1) {
                if (temp.equalsIgnoreCase("endt") | temp.equalsIgnoreCase("modifydate") | temp.equalsIgnoreCase("uploaddt"))
                    finalVariableList += finalVariableList.length() == 0 ? "Convert(varchar(19)," + tempList[i] + ",120)" : ", Convert(varchar(19)," + tempList[i] + ",120)";
                else
                    finalVariableList += finalVariableList.length() == 0 ? "Convert(varchar(10)," + tempList[i] + ",120)" : ", Convert(varchar(10)," + tempList[i] + ",120)";
            } else {
                if (temp.equalsIgnoreCase("upload"))
                    finalVariableList += finalVariableList.length() == 0 ? "'1'" : ", '1'";
                else
                    finalVariableList += finalVariableList.length() == 0 ? tempList[i] : ", " + tempList[i];
            }
        }
        return finalVariableList;
    }

    private String DateVariableList(String TableName) {
        Cursor cur_H = ReadData("PRAGMA table_info('" + TableName + "')");
        cur_H.moveToFirst();
        String temp = "";
        String type = "";
        String name = "";
        String dateVariable = "";
        while (!cur_H.isAfterLast()) {
            type = cur_H.getString(cur_H.getColumnIndex("type"));
            name = cur_H.getString(cur_H.getColumnIndex("name")).toLowerCase();

            if (type.equalsIgnoreCase("date") | type.equalsIgnoreCase("datetime")) {
                dateVariable += dateVariable.length() == 0 ? cur_H.getString(cur_H.getColumnIndex("name")) : "," + cur_H.getString(cur_H.getColumnIndex("name"));
            }

            cur_H.moveToNext();
        }
        cur_H.close();

        return dateVariable;
    }

    //Upload data to server
    public void Sync_Upload(List<String> tableList) {
        for (int i = 0; i < tableList.size(); i++) {
            Sync_Upload_Process(tableList.get(i).toString());
        }
    }

    private void Sync_Upload_Process(String TableName) {
        String VariableList = "";
        String UniqueField = "";
        String SQLStr = "";
        String Res = "";

        Cursor cur_H = ReadData("Select ColumnList as columnlist, UniqueID as uniqueid from DatabaseTab where tablename='" + TableName + "'");
        cur_H.moveToFirst();

        while (!cur_H.isAfterLast()) {
            SQLStr = "Select " + cur_H.getString(cur_H.getColumnIndex("columnlist")) + " from " + TableName + " Where Upload='2'";
            VariableList = cur_H.getString(cur_H.getColumnIndex("columnlist"));
            UniqueField = cur_H.getString(cur_H.getColumnIndex("uniqueid"));
            cur_H.moveToNext();
        }
        cur_H.close();

        Res = UploadJSON(TableName, VariableList, UniqueField);
    }

    //TableStructureSync
    public void TableStructureSync(String TableName) {
        //Creating Table if not exists
        String tableScript  = ReturnSingleValue("Select TableScript from DatabaseTab where TableName='"+ TableName +"'");
        CreateTable(TableName, tableScript);

        //Local database
        String[] local = GetColumnListArray(TableName);

        //Server database
        String[] Server = ReturnSingleValue("select ColumnList from DatabaseTab where TableName='"+ TableName +"'").toString().split(",");

        String[] C;
        Boolean matched = false;
        String newVariable = "";

        //matched database columns(local and server)
        for (int i = 0; i < Server.length; i++) {
            matched = false;
            for (int j = 0; j < local.length; j++) {
                newVariable = Server[i].toString();
                if (Server[i].toString().toLowerCase().equals(local[j].toString().toLowerCase())) {
                    matched = true;
                    j = local.length;
                }
            }
            if (matched == false) {
                Save("Alter table " + TableName + " add column " + newVariable + " varchar(50) default ''");
            }
        }
    }

    //TableStructureSync
    public void Sync_DatabaseStructure(String UserId)
    {
        //Retrieve sync parameter
        //------------------------------------------------------------------------------------------
        String TableName = "DatabaseTab";
        String[] SyncParam = Sync_Parameter(TableName);

        String SQLStr       = SyncParam[0];
        String VariableList = SyncParam[1];
        String UniqueField  = SyncParam[2];
        String SQL_VariableList  = SyncParam[3];
        String Res = "";
        String SQL = "";

        //Generate Unique ID field
        //------------------------------------------------------------------------------------------
        String[] U = UniqueField.split(",");
        String UID = "";
        //String UID_Sync = "";
        for(int i=0; i<U.length; i++){
            if(i==0)
                UID = "cast(t."+ U[i] +" as varchar(50))";
            else
                UID += "+cast(t."+ U[i] +" as varchar(50))";
        }

        SQL  = "Select "+ SQL_VariableList +" from "+ TableName +" as t";
        SQL += " where not exists(select * from Sync_Management where";
        SQL += " lower(TableName)  = lower('"+ TableName +"') and";
        SQL += " UniqueID   = "+ UID +" and";
        SQL += " convert(varchar(19),modifydate,120) = convert(varchar(19),t.modifydate,120) and";
        SQL += " UserId   ='"+ UserId +"')";

        Res = Sync_DatabaseTab_Management(SQL, TableName, VariableList, UniqueField, UserId);
    }

    //TableStructureSync
    private String Sync_DatabaseTab_Management(String SQL, String TableName,String ColumnList, String UniqueField, String UserId)
    {
        String WhereClause="";
        int varPos=0;

        String response = "";
        String resp = "";

        try{

            DownloadDataJSON dload = new DownloadDataJSON();
            response=dload.execute(SQL).get();

            //Process Response
            DownloadClass d = new DownloadClass();
            Gson gson = new Gson();
            Type collType = new TypeToken<DownloadClass>() {
            }.getType();
            DownloadClass responseData = gson.fromJson(response, collType);

            String UField[]  = UniqueField.split(",");
            String VarList[] = ColumnList.split(",");

            List<String> dataStatus = new ArrayList<>();
            String modifyDate = "";
            String UID        = "";
            String USID       = "";
            String DataList = "";
            DataClassProperty dd;
            List<DataClassProperty> data = new ArrayList<DataClassProperty>();
            String rowTableName = "";
            for(int i=0; i<responseData.getdata().size(); i++)
            {
                String VarData[] = split(responseData.getdata().get(i).toString(),'^');

                //Generate where clause
                SQL="";
                WhereClause="";
                varPos=0;
                for(int j=0; j< UField.length; j++)
                {
                    varPos = VarPosition(UField[j].toString(),VarList);
                    if(j==0)
                    {
                        WhereClause = UField[j].toString()+"="+ "'"+ VarData[varPos].toString().replace("'","") +"'";
                        UID = VarData[varPos].toString();
                    }
                    else
                    {
                        WhereClause += " and "+ UField[j].toString()+"="+ "'"+ VarData[varPos].toString().replace("'","") +"'";
                        UID += VarData[varPos].toString();
                    }
                }

                //Update command
                if(Existence("Select "+ VarList[0] +" from "+ TableName +" Where "+ WhereClause))
                {
                    for(int r=0;r<VarList.length;r++)
                    {
                        if(r==0)
                        {
                            SQL = "Update "+ TableName +" Set ";
                            SQL+= VarList[r] + " = '"+ VarData[r].toString().replace("'","") +"'";
                        }
                        else
                        {
                            if(r == VarData.length-1)
                            {
                                SQL+= ","+ VarList[r] + " = '"+ VarData[r].toString().replace("'","") +"'";
                                SQL += " Where "+ WhereClause;
                            }
                            else
                            {
                                SQL+= ","+ VarList[r] + " = '"+ VarData[r].toString().replace("'","") +"'";
                            }
                        }

                        if(VarList[r].toString().toLowerCase().equals("modifydate"))
                            modifyDate = VarData[r].toString();

                        if(VarList[r].toString().toLowerCase().equals("tablename"))
                            rowTableName = VarData[r].toString();

                    }

                    Save(SQL);

                    TableStructureSync(rowTableName);
                }
                //Insert command
                else
                {
                    for(int r=0;r<VarList.length;r++)
                    {
                        if(r==0)
                        {
                            SQL = "Insert into "+ TableName +"("+ ColumnList +")Values(";
                            SQL+= "'"+ VarData[r].toString().replace("'","") +"'";
                        }
                        else
                        {
                            SQL+= ",'"+ VarData[r].toString().replace("'","") +"'";
                        }

                        if(VarList[r].toString().toLowerCase().equals("modifydate"))
                            modifyDate = VarData[r].toString();

                        if(VarList[r].toString().toLowerCase().equals("tablename"))
                            rowTableName = VarData[r].toString();
                    }
                    SQL += ")";

                    Save(SQL);
                    TableStructureSync(rowTableName);
                }

                DataList = TableName + "^" + UID + "^"+ UserId + "^" + modifyDate;
                dd = new DataClassProperty();
                dd.setdatalist(DataList);
                dd.setuniquefieldwithdata("" +
                        "TableName='"+ TableName +"' and " +
                        "UniqueID='"+ UID +"' and " +
                        "UserId='"+ UserId +"' and " +
                        "modifyDate='"+ modifyDate +"'");
                data.add(dd);
            }

            DataClass dt = new DataClass();
            dt.settablename("Sync_Management");
            dt.setcolumnlist("TableName, UniqueID, UserId, modifyDate");
            dt.setuniquefields(UniqueField);
            dt.setdata(data);

            Gson gson1   = new Gson();
            String json1 = gson1.toJson(dt);
            String resp1 = "";

            UploadDataJSON u = new UploadDataJSON();

            try{
                resp1=u.execute(json1).get();
            } catch (Exception e) {
                e.printStackTrace();
            }



        } catch (Exception e) {
            resp = e.getMessage();
            e.printStackTrace();
        }

        return resp;
    }

    //To get the list of columns(string array) in table
    //----------------------------------------------------------------------------------------------
    public String[] GetColumnListArray(String TableName)
    {
        Cursor cur = ReadData("SELECT * FROM " + TableName + " WHERE 0");
        String[] columnNames;
        try {
            columnNames = cur.getColumnNames();
        } finally {
            cur.close();
        }
        return columnNames;
    }

    public boolean InsertData(String TableName, ContentValues content_value) {
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TableName, null, content_value);
        return true;
    }

    public boolean UpdateData(String TableName, String UniqueID_Field, String UniqueID, ContentValues content_value) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.update(TableName, content_value, UniqueID_Field + " = ? ", new String[]{UniqueID});
        return true;
    }

    public Integer DeleteData(String TableName, String UniqueID_Field, String UniqueID) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TableName,
                UniqueID_Field + " = ? ",
                new String[]{UniqueID});
    }

    public Cursor GetData(String TableName, String UniqueID_Field, String UniqueID) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TableName + " WHERE " +
                UniqueID_Field + "=?", new String[]{UniqueID});
        return res;
    }

    public Cursor GetAllData(String TableName) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TableName, null);
        return res;
    }


    public void DatabaseUpload(String DeviceID) {
        //Upload File from Specific Folder
        String[] FilePathStrings;
        String[] FileNameStrings;
        File[] listFile;

        File file = new File(Environment.getExternalStorageDirectory() + File.separator + Global.DatabaseFolder);
        file.mkdirs();
        if (file.isDirectory()) {
            listFile = file.listFiles();
            FilePathStrings = new String[listFile.length];
            FileNameStrings = new String[listFile.length];

            for (int i = 0; i < listFile.length; i++) {
                FilePathStrings[i] = listFile[i].getAbsolutePath();
                FileNameStrings[i] = listFile[i].getName();

                //Upload file to server
                FileUpload myTask = new FileUpload();
                String[] params = new String[2];
                if (listFile[i].getName().equalsIgnoreCase(ProjectSetting.DatabaseName)) {
                    params[0] = listFile[i].getName();
                    params[1] = DeviceID + "_" + Global.CurrentDMY() + "_" + listFile[i].getName();
                    myTask.execute(params);
                }
            }
        }
    }

    private void zipDatabase(String DeviceID)
    {
        CompressZip compressZip = new CompressZip();
        String[] dbFile = new String[1];
        dbFile[0] = Environment.getExternalStorageDirectory() + File.separator + Global.DatabaseFolder + File.separator + ProjectSetting.DatabaseName;
        String dbFolder = Environment.getExternalStorageDirectory() + File.separator + Global.DatabaseFolder;
        String output   = ProjectSetting.zipDatabaseName;
        compressZip.zip(dbFile, dbFolder, output);
    }

    public void DatabaseUploadZip(String DeviceID) {

        //Compress database
        zipDatabase(DeviceID);

        //Upload File from Specific Folder
        String[] FilePathStrings;
        String[] FileNameStrings;
        File[] listFile;

        //
        File file = new File(Environment.getExternalStorageDirectory() + File.separator + Global.DatabaseFolder);
        file.mkdirs();
        if (file.isDirectory()) {
            listFile = file.listFiles();
            FilePathStrings = new String[listFile.length];
            FileNameStrings = new String[listFile.length];

            for (int i = 0; i < listFile.length; i++) {
                FilePathStrings[i] = listFile[i].getAbsolutePath();
                FileNameStrings[i] = listFile[i].getName();

                //Upload file to server
                FileUpload myTask = new FileUpload();
                String[] params = new String[2];

                if (listFile[i].getName().equalsIgnoreCase(ProjectSetting.zipDatabaseName)) {
                    params[0] = listFile[i].getName();
                    params[1] = DeviceID + "_" + Global.CurrentDMY() + "_" + listFile[i].getName();
                    myTask.execute(params);
                }
            }
        }
    }

    public static void SyncDataService(String UniqueID)
    {
        try {
            Connection C = new Connection(ud_context);

            //Reqular data sync
            //--------------------------------------------------------------------------------------
            C.Sync_DatabaseStructure(UniqueID);
            C.Sync_Download("DataCollector", UniqueID, "");

//            C.Sync_Download("module_variable", UniqueID, "");
            C.Sync_Download("StructureListing", UniqueID, "");
            C.Sync_Download("AreaDB", UniqueID, "");
            C.Sync_Download("StructureDB", UniqueID, "");
            C.Sync_Download("StructureIDSlot", UniqueID, "");
            C.Sync_Download("StructureID_Serial", UniqueID, "");

            //Sync_Download
            // Parameter 1: table Name
            // Parameter 2: UniqueID of Device
            // Parameter 3: Where Condition
            //--------------------------------------------------------------------------------------

            //Sync_Upload
            // Parameter 1: table list
            //--------------------------------------------------------------------------------------
            //C.Sync_Upload(ProjectSetting.TableList_Upload());

            //Database File Upload
            //C.DatabaseUploadZip(UniqueID);
        }
        catch(Exception ex)
        {
        }

    }

    //Data Sync only Registration and Assignment of Patient
    public static void RegistrationDataSync(Context cont)
    {
        Connection C = new Connection(ud_context);
        if (Connection.haveNetworkConnection(cont)) {
            List<String> tableList = new ArrayList<String>();
            tableList.add("Registration");
            C.Sync_Upload(tableList);
        }
    }

    //Complete Data sync
    public static String DataSync(String COUNTRYCODE, String FACICODE, String DEVICEID, String ENTRYUSER)
    {
        String response = "";
        try {
            Connection C = new Connection(ud_context);

            //Upload
            List<String> tableList = new ArrayList<String>();
            tableList.add("Registration");
            tableList.add("ObsHisCurPreg");
            tableList.add("KmcPreObs");

            tableList.add("KMC_DataExt");
            tableList.add("LD_DataExt");

            tableList.add("KMC_Feed");
            tableList.add("KMC_Init");
            tableList.add("KMC_Pos");
            tableList.add("KMC_Treat");
            tableList.add("KMC_Outcome");

            tableList.add("Observation");
            tableList.add("LD_Outcome");
            tableList.add("ObjPauseLog");

            tableList.add("RecallSurvS1");
            tableList.add("RecallSurvS2");
            tableList.add("RecallSurvS3");
            tableList.add("RecallSurvS4");
            tableList.add("RecallSurvS5");
            tableList.add("MRS_FinalStatus");
            tableList.add("MRS_FollowUp");
            tableList.add("Acs_Veri");

            tableList.add("Infver_Pdetail");
            tableList.add("Infver_Denomin");
            tableList.add("Infver_SupCare");
            tableList.add("Infver_Anti");
            tableList.add("Infver_labInv");
            tableList.add("Infver_Outcome");

            C.Sync_Upload(tableList);


            //Download
            C.Sync_Download("DataCollector",DEVICEID,"CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"'");
            C.Sync_Download("DCJobType",   DEVICEID,"");
            C.Sync_Download("ObjTableList",DEVICEID,"");
            C.Sync_Download("ObjVarList",  DEVICEID,"");

            C.Sync_Download("Registration", DEVICEID,"CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"'");
            C.Sync_Download("KmcPreObs",    DEVICEID,"CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"'");
            C.Sync_Download("ObsHisCurPreg",DEVICEID,"CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"'");

            C.Sync_Download("Observation",DEVICEID,"CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"'");
            C.Sync_Download("LD_Outcome", DEVICEID,"CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"'");
            C.Sync_Download("ObjPauseLog", DEVICEID,"CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"'");

            C.Sync_Download("KMC_Init", DEVICEID,"CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"'");
            C.Sync_Download("KMC_Pos",  DEVICEID,"CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"'");
            C.Sync_Download("KMC_Feed", DEVICEID,"CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"'");
            C.Sync_Download("KMC_Treat",DEVICEID,"CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"'");
            C.Sync_Download("KMC_Outcome",DEVICEID,"CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"'");

            C.Sync_Download("KMC_DataExt",DEVICEID,"CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"'");
            C.Sync_Download("LD_DataExt",DEVICEID,"CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"'");

            C.Sync_Download("RecallSurvS1",DEVICEID,"CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"'");
            C.Sync_Download("RecallSurvS2",DEVICEID,"CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"'");
            C.Sync_Download("RecallSurvS3",DEVICEID,"CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"'");
            C.Sync_Download("RecallSurvS4",DEVICEID,"CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"'");
            C.Sync_Download("RecallSurvS5",DEVICEID,"CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"'");
            C.Sync_Download("MRS_FinalStatus",DEVICEID,"CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"'");

            C.Sync_Download("Acs_Veri",DEVICEID,"CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"'");

            C.Sync_Download("Infver_Pdetail",DEVICEID,"CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"'");
            C.Sync_Download("Infver_Denomin",DEVICEID,"CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"'");
            C.Sync_Download("Infver_SupCare",DEVICEID,"CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"'");
            C.Sync_Download("Infver_Anti",DEVICEID,"CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"'");
            C.Sync_Download("Infver_labInv",DEVICEID,"CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"'");
            C.Sync_Download("Infver_Outcome",DEVICEID,"CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"'");

            response = "done";
        }
        catch(Exception ex)
        {
            response = ex.getMessage();
        }
        return response;
    }

    //DC wise Access , different location
    public static String[] DCLocationAccess(String UserId){
        Connection C = new Connection(ud_context);
        //Select d.UserId,d.UserName,l.LocCode from DataCollector d inner join LocationDC l on d.FaciCode=l.FaciCode and d.UserId=l.UserId
        String[] d = C.getArrayList("Select l.LocCode from DataCollector d inner join LocationDC l on d.FaciCode=l.FaciCode and d.UserId=l.UserId");
        return d;
    }







    //Sync Management: 12 Apr 2017
    //**********************************************************************************************
    public List<DataClassProperty> GetDataList_Sync_Management(String VariableList, String TableName, String UniqueField) {
        Cursor cur_H = ReadData("Select " + VariableList + " from " + TableName + " where Upload='2'");
        cur_H.moveToFirst();
        List<DataClassProperty> data = new ArrayList<DataClassProperty>();
        DataClassProperty d;

        String DataList = "";
        String[] Count  = VariableList.toString().split(",");
        String[] UField = UniqueField.toString().split(",");
        int RecordCount = 0;

        String WhereClause = "";
        String VarData[];
        int varPos = 0;
        while (!cur_H.isAfterLast()) {
            //Prepare Data List
            for (int c = 0; c < Count.length; c++) {
                if (c == 0) {
                    if (cur_H.getString(c) == null)
                        DataList = "";
                    else if (cur_H.getString(c).equals("null"))
                        DataList = "";
                    else
                        DataList = cur_H.getString(c).toString().trim();

                } else {
                    if (cur_H.getString(c) == null)
                        DataList += "^" + "";
                    else if (cur_H.getString(c).equals("null"))
                        DataList += "^" + "";
                    else
                        DataList += "^" + cur_H.getString(c).toString().trim();
                }
            }

            //Prepare Where Clause
            VarData = DataList.split("\\^");
            varPos = 0;


            for (int j = 0; j < UField.length; j++) {
                varPos = VarPosition(UField[j].toString(), Count);
                if (j == 0) {
                    WhereClause = UField[j].toString() + "=" + "'" + VarData[varPos].toString() + "'";
                } else {
                    WhereClause += " and " + UField[j].toString() + "=" + "'" + VarData[varPos].toString() + "'";
                }
            }

            d = new DataClassProperty();
            d.setdatalist(DataList);
            d.setuniquefieldwithdata(WhereClause);
            data.add(d);

            RecordCount += 1;
            cur_H.moveToNext();
        }
        cur_H.close();

        return data;
    }

/*    public String UploadJSON_Sync_Management(String TableName, String ColumnList, String UniqueFields) {
        String response = "";
        List<DataClassProperty> data = GetDataListJSON(ColumnList, TableName, UniqueFields);

        if (data.size() > 0) {
            DataClass dt = new DataClass();
            dt.settablename(TableName);
            dt.setcolumnlist(ColumnList);
            dt.setdata(data);

            Gson gson = new Gson();
            String json = gson.toJson(dt);
            UploadDataJSON u = new UploadDataJSON();
            try {
                response = u.execute(json).get();

                //Process Response
                if (response != null) {
                    DownloadClass d = new DownloadClass();
                    Type collType = new TypeToken<DownloadClass>() {
                    }.getType();
                    DownloadClass responseData = gson.fromJson(response, collType);

                    //upload all records as successfull upload then update status of upload=2 for unsuccessfull
                    for (int i = 0; i < responseData.getdata().size(); i++) {
                        Save("Update " + TableName + " Set Upload='1' where " + responseData.getdata().get(i).toString());
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return response;
    }

    private String Upload_Sync_Management(String SQL, String TableName, String ColumnList, String UniqueField, String UserId) {
        String WhereClause = "";
        int varPos = 0;

        String response = "";
        String resp = "";

        try {
             /*//*******
            String DataList = "";
            List<DataClassProperty> data = new ArrayList<DataClassProperty>();
            DataClassProperty dd;
            String UID = "";
            String modifyDate = "";

            // loop start ****
            String UField[] = UniqueField.split(",");
            String VarList[] = ColumnList.split(",");
            List<DataClassProperty> datalist = GetDataListJSON(ColumnList, TableName, UniqueField);

            //if (datalist.size() > 0) {
            for(int i=0;i<datalist.size();i++){
                DataClass dt = new DataClass();
                dt.settablename(TableName);
                dt.setcolumnlist(ColumnList);
                dt.setdata(datalist);
                Gson gson = new Gson();
                String json = gson.toJson(dt);
                UploadDataJSON u = new UploadDataJSON();

                String VarData[] = split(datalist.get(i).toString(), '^');

                for (int j = 0; j < UField.length; j++) {
                    varPos = VarPosition(UField[j].toString(), VarList);
                    if (j == 0) {
                        WhereClause = UField[j].toString() + "=" + "'" + VarData[varPos].toString().replace("'", "") + "'";
                        UID = VarData[varPos].toString();
                    } else {
                        WhereClause += " and " + UField[j].toString() + "=" + "'" + VarData[varPos].toString().replace("'", "") + "'";
                        UID += VarData[varPos].toString();
                    }
                }

                DataList = TableName + "^" + UID + "^" + UserId + "^" + modifyDate;
                dd = new DataClassProperty();
                dd.setdatalist(DataList);
                dd.setuniquefieldwithdata("" +
                        "TableName='" + TableName + "' and " +
                        "UniqueID='" + UID + "' and " +
                        "UserId='" + UserId + "' and " +
                        "modifyDate='" + modifyDate + "'");
                data.add(dd);
            }
            /*//**Loop End*****

            DataClass dt = new DataClass();
            dt.settablename("Sync_Management");
            dt.setcolumnlist("TableName, UniqueID, UserId, modifyDate");
            dt.setdata(data);

            Gson gson1 = new Gson();
            String json1 = gson1.toJson(dt);
            String resp1 = "";

            UploadDataJSON u = new UploadDataJSON();

            try {
                resp1 = u.execute(json1).get();
            } catch (Exception e) {
                e.printStackTrace();
            }



        } catch (Exception e) {
            resp = e.getMessage();
            e.printStackTrace();
        }

        return resp;
    }

    */
}