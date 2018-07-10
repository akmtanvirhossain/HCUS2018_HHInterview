package data_model;

import android.content.Context;
 import android.database.Cursor;
 import Common.Connection;
 import java.util.ArrayList;
 import java.util.List;
 import java.util.Date;
 public class StructureDB_DataModel{

        private String _Division = "";
        public String getDivision(){
              return _Division;
         }
        public void setDivision(String newValue){
              _Division = newValue;
         }
        private String _DivName = "";
        public String getDivName(){
              return _DivName;
         }
        public void setDivName(String newValue){
              _DivName = newValue;
         }
        private String _Zila = "";
        public String getZila(){
              return _Zila;
         }
        public void setZila(String newValue){
              _Zila = newValue;
         }
        private String _ZilaName = "";
        public String getZilaName(){
              return _ZilaName;
         }
        public void setZilaName(String newValue){
              _ZilaName = newValue;
         }
        private String _Upazila = "";
        public String getUpazila(){
              return _Upazila;
         }
        public void setUpazila(String newValue){
              _Upazila = newValue;
         }
        private String _UpName = "";
        public String getUpName(){
              return _UpName;
         }
        public void setUpName(String newValue){
              _UpName = newValue;
         }
        private String _UNCode = "";
        public String getUNCode(){
              return _UNCode;
         }
        public void setUNCode(String newValue){
              _UNCode = newValue;
         }
        private String _Uname = "";
        public String getUname(){
              return _Uname;
         }
        public void setUname(String newValue){
              _Uname = newValue;
         }
        private String _Cluster = "";
        public String getCluster(){
              return _Cluster;
         }
        public void setCluster(String newValue){
              _Cluster = newValue;
         }
        private String _StructureNo = "";
        public String getStructureNo(){
              return _StructureNo;
         }
        public void setStructureNo(String newValue){
              _StructureNo = newValue;
         }
        private String _StartTime = "";
        public void setStartTime(String newValue){
              _StartTime = newValue;
         }
        private String _EndTime = "";
        public void setEndTime(String newValue){
              _EndTime = newValue;
         }
        private String _DeviceID = "";
        public void setDeviceID(String newValue){
              _DeviceID = newValue;
         }
        private String _EntryUser = "";
        public void setEntryUser(String newValue){
              _EntryUser = newValue;
         }
        private String _Lat = "";
        public void setLat(String newValue){
              _Lat = newValue;
         }
        private String _Lon = "";
        public void setLon(String newValue){
              _Lon = newValue;
         }
        private String _EnDt = "";
        public void setEnDt(String newValue){
              _EnDt = newValue;
         }
        private int _Upload = 2;
        private String _modifyDate = "";
        public void setmodifyDate(String newValue){
        _modifyDate = newValue;
        }

        String TableName = "StructureDB";

        public String SaveUpdateData(Context context)
        {
            String response = "";
            C = new Connection(context);
            String SQL = "";
            try
            {
                 if(C.Existence("Select * from "+ TableName +"  Where Zila='"+ _Zila +"' and Upazila='"+ _Upazila +"' and UNCode='"+ _UNCode +"' and StructureNo='"+ _StructureNo +"' "))
                    response = UpdateData(context);
                 else
                    response = SaveData(context);
            }
            catch(Exception  e)
            {
                 response = e.getMessage();
            }
           return response;
        }
        Connection C;

        private String SaveData(Context context)
        {
            String response = "";
            C = new Connection(context);
            String SQL = "";
            try
              {
                 SQL = "Insert into "+ TableName +" (Division,DivName,Zila,ZilaName,Upazila,UpName,UNCode,Uname,Cluster,StructureNo,StartTime,EndTime,DeviceID,EntryUser,Lat,Lon,EnDt,Upload,modifyDate)Values('"+ _Division +"', '"+ _DivName +"', '"+ _Zila +"', '"+ _ZilaName +"', '"+ _Upazila +"', '"+ _UpName +"', '"+ _UNCode +"', '"+ _Uname +"', '"+ _Cluster +"', '"+ _StructureNo +"', '"+ _StartTime +"', '"+ _EndTime +"', '"+ _DeviceID +"', '"+ _EntryUser +"', '"+ _Lat +"', '"+ _Lon +"', '"+ _EnDt +"', '"+ _Upload +"', '"+ _modifyDate +"')";
                 response = C.SaveData(SQL);
                 C.close();
              }
              catch(Exception  e)
              {
                 response = e.getMessage();
              }
           return response;
        }

        private String UpdateData(Context context)
        {
            String response = "";
            C = new Connection(context);
            String SQL = "";
            try
              {
                 SQL = "Update "+ TableName +" Set Upload='2',modifyDate='" + _modifyDate + "' ,Division = '"+ _Division +"',DivName = '"+ _DivName +"',Zila = '"+ _Zila +"',ZilaName = '"+ _ZilaName +"',Upazila = '"+ _Upazila +"',UpName = '"+ _UpName +"',UNCode = '"+ _UNCode +"',Uname = '"+ _Uname +"',Cluster = '"+ _Cluster +"',StructureNo = '"+ _StructureNo +"'  Where Zila='"+ _Zila +"' and Upazila='"+ _Upazila +"' and UNCode='"+ _UNCode +"' and StructureNo='"+ _StructureNo +"'";
                 response = C.SaveData(SQL);
                 C.close();
              }
              catch(Exception  e)
              {
                 response = e.getMessage();
              }
           return response;
        }


        public List<StructureDB_DataModel> SelectAll(Context context, String SQL)
        {
            Connection C = new Connection(context);
            List<StructureDB_DataModel> data = new ArrayList<StructureDB_DataModel>();
            StructureDB_DataModel d = new StructureDB_DataModel();
            Cursor cur = C.ReadData(SQL);

            cur.moveToFirst();
            while(!cur.isAfterLast())
            {
                d = new StructureDB_DataModel();
                d._Division = cur.getString(cur.getColumnIndex("Division"));
                d._DivName = cur.getString(cur.getColumnIndex("DivName"));
                d._Zila = cur.getString(cur.getColumnIndex("Zila"));
                d._ZilaName = cur.getString(cur.getColumnIndex("ZilaName"));
                d._Upazila = cur.getString(cur.getColumnIndex("Upazila"));
                d._UpName = cur.getString(cur.getColumnIndex("UpName"));
                d._UNCode = cur.getString(cur.getColumnIndex("UNCode"));
                d._Uname = cur.getString(cur.getColumnIndex("Uname"));
                d._Cluster = cur.getString(cur.getColumnIndex("Cluster"));
                d._StructureNo = cur.getString(cur.getColumnIndex("StructureNo"));
                data.add(d);

                cur.moveToNext();
            }
            cur.close();
          return data;
        }
 }