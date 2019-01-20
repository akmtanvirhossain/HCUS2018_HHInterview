package data_model;

import android.content.Context;
 import android.database.Cursor;
 import Common.Connection;
 import java.util.ArrayList;
 import java.util.List;
 import java.util.Date;
 public class Typhoid_Extra_DataModel{

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
        private int _HaveHosp = 0;
        public int getHaveHosp(){
              return _HaveHosp;
         }
        public void setHaveHosp(int newValue){
              _HaveHosp = newValue;
         }
        private int _HospName = 0;
        public int getHospName(){
              return _HospName;
         }
        public void setHospName(int newValue){
              _HospName = newValue;
         }
        private String _HospName_Oth = "";
        public String getHospName_Oth(){
              return _HospName_Oth;
         }
        public void setHospName_Oth(String newValue){
              _HospName_Oth = newValue;
         }
        private int _HaveRecords = 0;
        public int getHaveRecords(){
              return _HaveRecords;
         }
        public void setHaveRecords(int newValue){
              _HaveRecords = newValue;
         }
        private int _DidRecordMatch2 = 0;
        public int getDidRecordMatch2(){
              return _DidRecordMatch2;
         }
        public void setDidRecordMatch2(int newValue){
              _DidRecordMatch2 = newValue;
         }
        private int _DaysOfHosp = 0;
        public int getDaysOfHosp(){
              return _DaysOfHosp;
         }
        public void setDaysOfHosp(int newValue){
              _DaysOfHosp = newValue;
         }
        private int _DaysOfHospDK = 0;
        public int getDaysOfHospDK(){
              return _DaysOfHospDK;
         }
        public void setDaysOfHospDK(int newValue){
              _DaysOfHospDK = newValue;
         }
        private String _TAboIll = "";
        public String getTAboIll(){
              return _TAboIll;
         }
        public void setTAboIll(String newValue){
              _TAboIll = newValue;
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




        String TableName = "Typhoid_Extra";

        public String SaveUpdateData(Context context)
        {
            String response = "";
            C = new Connection(context);
            String SQL = "";
            try
            {
                 if(C.Existence("Select * from "+ TableName +"  Where UNCode='"+ _UNCode +"' and StructureNo='"+ _StructureNo +"' and HouseholdSl='"+ _HouseholdSl +"' and VisitNo='"+ _VisitNo +"' and MemSl='"+ _MemSl +"' and DeviceId='"+_DeviceID+"'"))
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
                 SQL = "Insert into "+ TableName +" (UNCode,StructureNo,HouseholdSl,VisitNo,MemSl,HaveHosp,HospName,HospName_Oth,HaveRecords,DidRecordMatch2,DaysOfHosp,DaysOfHospDK,TAboIll,StartTime,EndTime,DeviceID,EntryUser,Lat,Lon,EnDt,Upload,modifyDate)Values('"+ _UNCode +"', '"+ _StructureNo +"', '"+ _HouseholdSl +"', '"+ _VisitNo +"', '"+ _MemSl +"', '"+ _HaveHosp +"', '"+ _HospName +"', '"+ _HospName_Oth +"', '"+ _HaveRecords +"', '"+ _DidRecordMatch2 +"', '"+ _DaysOfHosp +"', '"+ _DaysOfHospDK +"', '"+ _TAboIll +"', '"+ _StartTime +"', '"+ _EndTime +"', '"+ _DeviceID +"', '"+ _EntryUser +"', '"+ _Lat +"', '"+ _Lon +"', '"+ _EnDt +"', '"+ _Upload +"', '"+ _modifyDate +"')";
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
                 SQL = "Update "+ TableName +" Set Upload='2',modifyDate='" + _modifyDate + "' ,UNCode = '"+ _UNCode +"',StructureNo = '"+ _StructureNo +"',HouseholdSl = '"+ _HouseholdSl +"',VisitNo = '"+ _VisitNo +"',MemSl = '"+ _MemSl +"',HaveHosp = '"+ _HaveHosp +"',HospName = '"+ _HospName +"',HospName_Oth = '"+ _HospName_Oth +"',HaveRecords = '"+ _HaveRecords +"',DidRecordMatch2 = '"+ _DidRecordMatch2 +"',DaysOfHosp = '"+ _DaysOfHosp +"',DaysOfHospDK = '"+ _DaysOfHospDK +"',TAboIll = '"+ _TAboIll +"'  Where UNCode='"+ _UNCode +"' and StructureNo='"+ _StructureNo +"' and HouseholdSl='"+ _HouseholdSl +"' and VisitNo='"+ _VisitNo +"' and MemSl='"+ _MemSl +"' and DeviceId='"+_DeviceID+"'";
                 response = C.SaveData(SQL);
                 C.close();
              }
              catch(Exception  e)
              {
                 response = e.getMessage();
              }
           return response;
        }


        public List<Typhoid_Extra_DataModel> SelectAll(Context context, String SQL)
        {
            Connection C = new Connection(context);
            List<Typhoid_Extra_DataModel> data = new ArrayList<Typhoid_Extra_DataModel>();
            Typhoid_Extra_DataModel d = new Typhoid_Extra_DataModel();
            Cursor cur = C.ReadData(SQL);

            cur.moveToFirst();
            while(!cur.isAfterLast())
            {
                d = new Typhoid_Extra_DataModel();
                d._UNCode = cur.getString(cur.getColumnIndex("UNCode"));
                d._StructureNo = cur.getString(cur.getColumnIndex("StructureNo"));
                d._HouseholdSl = cur.getString(cur.getColumnIndex("HouseholdSl"));
                d._VisitNo = cur.getString(cur.getColumnIndex("VisitNo"));
                d._MemSl = cur.getString(cur.getColumnIndex("MemSl"));
                d._HaveHosp = Integer.valueOf(cur.getString(cur.getColumnIndex("HaveHosp")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("HaveHosp")));
                d._HospName = Integer.valueOf(cur.getString(cur.getColumnIndex("HospName")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("HospName")));
                d._HospName_Oth = cur.getString(cur.getColumnIndex("HospName_Oth"));
                d._HaveRecords = Integer.valueOf(cur.getString(cur.getColumnIndex("HaveRecords")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("HaveRecords")));
                d._DidRecordMatch2 = Integer.valueOf(cur.getString(cur.getColumnIndex("DidRecordMatch2")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("DidRecordMatch2")));
                d._DaysOfHosp = Integer.valueOf(cur.getString(cur.getColumnIndex("DaysOfHosp")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("DaysOfHosp")));
                d._DaysOfHospDK = Integer.valueOf(cur.getString(cur.getColumnIndex("DaysOfHospDK")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("DaysOfHospDK")));
                d._TAboIll = cur.getString(cur.getColumnIndex("TAboIll"));

                data.add(d);

                cur.moveToNext();
            }
            cur.close();
          return data;
        }
 }