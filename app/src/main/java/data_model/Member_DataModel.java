package data_model;

import android.content.Context;
 import android.database.Cursor;
 import Common.Connection;
 import java.util.ArrayList;
 import java.util.List;
 import java.util.Date;
 public class Member_DataModel{

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
        private int _MemSl = 0;
        public int getMemSl(){
              return _MemSl;
         }
        public void setMemSl(int newValue){
              _MemSl = newValue;
         }
        private String _Name = "";
        public String getName(){
              return _Name;
         }
        public void setName(String newValue){
              _Name = newValue;
         }
        private int _Sex = 0;
        public int getSex(){
              return _Sex;
         }
        public void setSex(int newValue){
              _Sex = newValue;
         }
        private String _DOB = "";
        public String getDOB(){
              return _DOB;
         }
        public void setDOB(String newValue){
              _DOB = newValue;
         }
        private int _DOBDk = 0;
        public int getDOBDk(){
              return _DOBDk;
         }
        public void setDOBDk(int newValue){
              _DOBDk = newValue;
         }
        private int _Age = 0;
        public int getAge(){
              return _Age;
         }
        public void setAge(int newValue){
              _Age = newValue;
         }
        private int _AgeU = 0;
        public int getAgeU(){
              return _AgeU;
         }
        public void setAgeU(int newValue){
              _AgeU = newValue;
         }
        private int _Relation = 0;
        public int getRelation(){
              return _Relation;
         }
        public void setRelation(int newValue){
              _Relation = newValue;
         }
        private String _OthRelation = "";
        public String getOthRelation(){
              return _OthRelation;
         }
        public void setOthRelation(String newValue){
              _OthRelation = newValue;
         }
        private int _PreStatus = 0;
        public int getPreStatus(){
              return _PreStatus;
         }
        public void setPreStatus(int newValue){
              _PreStatus = newValue;
         }
        private String _DtofDeath = "";
        public String getDtofDeath(){
              return _DtofDeath;
         }
        public void setDtofDeath(String newValue){
              _DtofDeath = newValue;
         }
        private int _DAge = 0;
        public int getDAge(){
              return _DAge;
         }
        public void setDAge(int newValue){
              _DAge = newValue;
         }
        private int _DAgeU = 0;
        public int getDAgeU(){
              return _DAgeU;
         }
        public void setDAgeU(int newValue){
              _DAgeU = newValue;
         }
        private int _LiveInHouse = 0;
        public int getLiveInHouse(){
              return _LiveInHouse;
         }
        public void setLiveInHouse(int newValue){
              _LiveInHouse = newValue;
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

        String TableName = "Member";

        public String SaveUpdateData(Context context)
        {
            String response = "";
            C = new Connection(context);
            String SQL = "";
            try
            {
                 if(C.Existence("Select * from "+ TableName +"  Where UNCode='"+ _UNCode +"' and StructureNo='"+ _StructureNo +"' and HouseholdSl='"+ _HouseholdSl +"' and VisitNo='"+ _VisitNo +"' and MemSl='"+ _MemSl +"' "))
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
                 SQL = "Insert into "+ TableName +" (UNCode,StructureNo,HouseholdSl,VisitNo,MemSl,Name,Sex,DOB,DOBDk,Age,AgeU,Relation,OthRelation,PreStatus,DtofDeath,DAge,DAgeU,LiveInHouse,StartTime,EndTime,DeviceID,EntryUser,Lat,Lon,EnDt,Upload,modifyDate)Values('"+ _UNCode +"', '"+ _StructureNo +"', '"+ _HouseholdSl +"', '"+ _VisitNo +"', '"+ _MemSl +"', '"+ _Name +"', '"+ _Sex +"', '"+ _DOB +"', '"+ _DOBDk +"', '"+ _Age +"', '"+ _AgeU +"', '"+ _Relation +"', '"+ _OthRelation +"', '"+ _PreStatus +"', '"+ _DtofDeath +"', '"+ _DAge +"', '"+ _DAgeU +"', '"+ _LiveInHouse +"', '"+ _StartTime +"', '"+ _EndTime +"', '"+ _DeviceID +"', '"+ _EntryUser +"', '"+ _Lat +"', '"+ _Lon +"', '"+ _EnDt +"', '"+ _Upload +"', '"+ _modifyDate +"')";
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
                 SQL = "Update "+ TableName +" Set Upload='2',modifyDate='" + _modifyDate + "' ,UNCode = '"+ _UNCode +"',StructureNo = '"+ _StructureNo +"',HouseholdSl = '"+ _HouseholdSl +"',VisitNo = '"+ _VisitNo +"',MemSl = '"+ _MemSl +"',Name = '"+ _Name +"',Sex = '"+ _Sex +"',DOB = '"+ _DOB +"',DOBDk = '"+ _DOBDk +"',Age = '"+ _Age +"',AgeU = '"+ _AgeU +"',Relation = '"+ _Relation +"',OthRelation = '"+ _OthRelation +"',PreStatus = '"+ _PreStatus +"',DtofDeath = '"+ _DtofDeath +"',DAge = '"+ _DAge +"',DAgeU = '"+ _DAgeU +"',LiveInHouse = '"+ _LiveInHouse +"'  Where UNCode='"+ _UNCode +"' and StructureNo='"+ _StructureNo +"' and HouseholdSl='"+ _HouseholdSl +"' and VisitNo='"+ _VisitNo +"' and MemSl='"+ _MemSl +"'";
                 response = C.SaveData(SQL);
                 C.close();
              }
              catch(Exception  e)
              {
                 response = e.getMessage();
              }
           return response;
        }


        public List<Member_DataModel> SelectAll(Context context, String SQL)
        {
            Connection C = new Connection(context);
            List<Member_DataModel> data = new ArrayList<Member_DataModel>();
            Member_DataModel d = new Member_DataModel();
            Cursor cur = C.ReadData(SQL);

            cur.moveToFirst();
            while(!cur.isAfterLast())
            {
                d = new Member_DataModel();
                d._UNCode = cur.getString(cur.getColumnIndex("UNCode"));
                d._StructureNo = cur.getString(cur.getColumnIndex("StructureNo"));
                d._HouseholdSl = cur.getString(cur.getColumnIndex("HouseholdSl"));
                d._VisitNo = cur.getString(cur.getColumnIndex("VisitNo"));
                d._MemSl = Integer.valueOf(cur.getString(cur.getColumnIndex("MemSl")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MemSl")));
                d._Name = cur.getString(cur.getColumnIndex("Name"));
                d._Sex = Integer.valueOf(cur.getString(cur.getColumnIndex("Sex")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Sex")));
                d._DOB = cur.getString(cur.getColumnIndex("DOB"));
                d._DOBDk = Integer.valueOf(cur.getString(cur.getColumnIndex("DOBDk")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("DOBDk")));
                d._Age = Integer.valueOf(cur.getString(cur.getColumnIndex("Age")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Age")));
                d._AgeU = Integer.valueOf(cur.getString(cur.getColumnIndex("AgeU")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("AgeU")));
                d._Relation = Integer.valueOf(cur.getString(cur.getColumnIndex("Relation")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Relation")));
                d._OthRelation = cur.getString(cur.getColumnIndex("OthRelation"));
                d._PreStatus = Integer.valueOf(cur.getString(cur.getColumnIndex("PreStatus")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PreStatus")));
                d._DtofDeath = cur.getString(cur.getColumnIndex("DtofDeath"));
                d._DAge = Integer.valueOf(cur.getString(cur.getColumnIndex("DAge")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("DAge")));
                d._DAgeU = Integer.valueOf(cur.getString(cur.getColumnIndex("DAgeU")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("DAgeU")));
                d._LiveInHouse = Integer.valueOf(cur.getString(cur.getColumnIndex("LiveInHouse")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("LiveInHouse")));
                data.add(d);

                cur.moveToNext();
            }
            cur.close();
          return data;
        }
 }