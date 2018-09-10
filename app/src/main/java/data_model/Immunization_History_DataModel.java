package data_model;

import android.content.Context;
 import android.database.Cursor;
 import Common.Connection;
 import java.util.ArrayList;
 import java.util.List;
 import java.util.Date;
 public class Immunization_History_DataModel{

        private String _UNCode = "";
        public String getUNCode(){
              return _UNCode;
         }
        public void setUNCode(String newValue){
              _UNCode = newValue;
         }
        private String _StructureNo = "";
        public String getStructureNo(){
              return _StructureNo;
         }
        public void setStructureNo(String newValue){
              _StructureNo = newValue;
         }
        private String _HouseholdSl = "";
        public String getHouseholdSl(){
              return _HouseholdSl;
         }
        public void setHouseholdSl(String newValue){
              _HouseholdSl = newValue;
         }
        private String _VisitNo = "";
        public String getVisitNo(){
              return _VisitNo;
         }
        public void setVisitNo(String newValue){
              _VisitNo = newValue;
         }
        private String _MemSl = "";
        public String getMemSl(){
              return _MemSl;
         }
        public void setMemSl(String newValue){
              _MemSl = newValue;
         }
        private String _Vacc_Id = "";
        public String getVacc_Id(){
              return _Vacc_Id;
         }
        public void setVacc_Id(String newValue){
              _Vacc_Id = newValue;
         }
        private int _Given = 0;
        public int getGiven(){
              return _Given;
         }
        public void setGiven(int newValue){
              _Given = newValue;
         }
        private int _Source = 0;
        public int getSource(){
              return _Source;
         }
        public void setSource(int newValue){
              _Source = newValue;
         }
        private String _Vacc_Date = "";
        public String getVacc_Date(){
              return _Vacc_Date;
         }
        public void setVacc_Date(String newValue){
              _Vacc_Date = newValue;
         }
        private int _Date_Missing = 0;
        public int getDate_Missing(){
              return _Date_Missing;
         }
        public void setDate_Missing(int newValue){
              _Date_Missing = newValue;
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

        String TableName = "Immunization_History";

        public String SaveUpdateData(Context context)
        {
            String response = "";
            C = new Connection(context);
            String SQL = "";
            try
            {
                 if(C.Existence("Select * from "+ TableName +"  Where UNCode='"+ _UNCode +"' and StructureNo='"+ _StructureNo +"' and HouseholdSl='"+ _HouseholdSl +"' and VisitNo='"+ _VisitNo +"' and MemSl='"+ _MemSl +"' and Vacc_Id='"+ _Vacc_Id +"' "))
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
                 SQL = "Insert into "+ TableName +" (UNCode,StructureNo,HouseholdSl,VisitNo,MemSl,Vacc_Id,Given,Source,Vacc_Date,Date_Missing,StartTime,EndTime,DeviceID,EntryUser,Lat,Lon,EnDt,Upload,modifyDate)Values('"+ _UNCode +"', '"+ _StructureNo +"', '"+ _HouseholdSl +"', '"+ _VisitNo +"', '"+ _MemSl +"', '"+ _Vacc_Id +"', '"+ _Given +"', '"+ _Source +"', '"+ _Vacc_Date +"', '"+ _Date_Missing +"', '"+ _StartTime +"', '"+ _EndTime +"', '"+ _DeviceID +"', '"+ _EntryUser +"', '"+ _Lat +"', '"+ _Lon +"', '"+ _EnDt +"', '"+ _Upload +"', '"+ _modifyDate +"')";
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
                 SQL = "Update "+ TableName +" Set Upload='2',modifyDate='" + _modifyDate + "' ,UNCode = '"+ _UNCode +"',StructureNo = '"+ _StructureNo +"',HouseholdSl = '"+ _HouseholdSl +"',VisitNo = '"+ _VisitNo +"',MemSl = '"+ _MemSl +"',Vacc_Id = '"+ _Vacc_Id +"',Given = '"+ _Given +"',Source = '"+ _Source +"',Vacc_Date = '"+ _Vacc_Date +"',Date_Missing = '"+ _Date_Missing +"'  Where UNCode='"+ _UNCode +"' and StructureNo='"+ _StructureNo +"' and HouseholdSl='"+ _HouseholdSl +"' and VisitNo='"+ _VisitNo +"' and MemSl='"+ _MemSl +"' and Vacc_Id='"+ _Vacc_Id +"'";
                 response = C.SaveData(SQL);
                 C.close();
              }
              catch(Exception  e)
              {
                 response = e.getMessage();
              }
           return response;
        }


        public List<Immunization_History_DataModel> SelectAll(Context context, String SQL)
        {
            Connection C = new Connection(context);
            List<Immunization_History_DataModel> data = new ArrayList<Immunization_History_DataModel>();
            Immunization_History_DataModel d = new Immunization_History_DataModel();
            Cursor cur = C.ReadData(SQL);

            cur.moveToFirst();
            while(!cur.isAfterLast())
            {
                d = new Immunization_History_DataModel();
                d._UNCode = cur.getString(cur.getColumnIndex("UNCode"));
                d._StructureNo = cur.getString(cur.getColumnIndex("StructureNo"));
                d._HouseholdSl = cur.getString(cur.getColumnIndex("HouseholdSl"));
                d._VisitNo = cur.getString(cur.getColumnIndex("VisitNo"));
                d._MemSl = cur.getString(cur.getColumnIndex("MemSl"));
                d._Vacc_Id = cur.getString(cur.getColumnIndex("Vacc_Id"));
                d._Given = Integer.valueOf(cur.getString(cur.getColumnIndex("Given")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Given")));
                d._Source = Integer.valueOf(cur.getString(cur.getColumnIndex("Source")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Source")));
                d._Vacc_Date = cur.getString(cur.getColumnIndex("Vacc_Date"));
                d._Date_Missing = Integer.valueOf(cur.getString(cur.getColumnIndex("Date_Missing")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Date_Missing")));
                data.add(d);

                cur.moveToNext();
            }
            cur.close();
          return data;
        }
 }