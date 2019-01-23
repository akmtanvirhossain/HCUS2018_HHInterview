package data_model;

import android.content.Context;
 import android.database.Cursor;
 import Common.Connection;
 import java.util.ArrayList;
 import java.util.List;
 import java.util.Date;
 public class Typhoid_Extra_Master_DataModel{

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
        private String _VCode = "";
        public String getVCode(){
              return _VCode;
         }
        public void setVCode(String newValue){
              _VCode = newValue;
         }
        private String _Vname = "";
        public String getVname(){
              return _Vname;
         }
        public void setVname(String newValue){
              _Vname = newValue;
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
        private String _HHHead = "";
        public String getHHHead(){
              return _HHHead;
         }
        public void setHHHead(String newValue){
              _HHHead = newValue;
         }
        private String _childName = "";
        public String getchildName(){
              return _childName;
         }
        public void setchildName(String newValue){
              _childName = newValue;
         }
        private String _Age = "";
        public String getAge(){
              return _Age;
         }
        public void setAge(String newValue){
              _Age = newValue;
         }
        private String _Sex = "";
        public String getSex(){
              return _Sex;
         }
        public void setSex(String newValue){
              _Sex = newValue;
         }
        private String _Member = "";
        public String getMember(){
              return _Member;
         }
        public void setMember(String newValue){
              _Member = newValue;
         }
        private String _Holding = "";
        public String getHolding(){
              return _Holding;
         }
        public void setHolding(String newValue){
              _Holding = newValue;
         }
        private String _Road = "";
        public String getRoad(){
              return _Road;
         }
        public void setRoad(String newValue){
              _Road = newValue;
         }
        private String _Address = "";
        public String getAddress(){
              return _Address;
         }
        public void setAddress(String newValue){
              _Address = newValue;
         }
        private String _VisitDate = "";
        public String getVisitDate(){
              return _VisitDate;
         }
        public void setVisitDate(String newValue){
              _VisitDate = newValue;
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

         private String _typhoid_extra;

         public String get_typhoid_extra() {
             return _typhoid_extra;
         }

         public String get_DeviceID() {
             return _DeviceID;
         }

        String TableName = "Typhoid_Extra_Master";

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
                 SQL = "Insert into "+ TableName +" (Upazila,UpName,UNCode,Uname,VCode,Vname,Cluster,StructureNo,HouseholdSl,VisitNo,MemSl,HHHead,childName,Age,Sex,Member,Holding,Road,Address,VisitDate,StartTime,EndTime,DeviceID,EntryUser,Lat,Lon,EnDt,Upload,modifyDate)Values('"+ _Upazila +"', '"+ _UpName +"', '"+ _UNCode +"', '"+ _Uname +"', '"+ _VCode +"', '"+ _Vname +"', '"+ _Cluster +"', '"+ _StructureNo +"', '"+ _HouseholdSl +"', '"+ _VisitNo +"', '"+ _MemSl +"', '"+ _HHHead +"', '"+ _childName +"', '"+ _Age +"', '"+ _Sex +"', '"+ _Member +"', '"+ _Holding +"', '"+ _Road +"', '"+ _Address +"', '"+ _VisitDate +"', '"+ _StartTime +"', '"+ _EndTime +"', '"+ _DeviceID +"', '"+ _EntryUser +"', '"+ _Lat +"', '"+ _Lon +"', '"+ _EnDt +"', '"+ _Upload +"', '"+ _modifyDate +"')";
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
                 SQL = "Update "+ TableName +" Set Upload='2',modifyDate='" + _modifyDate + "' ,Upazila = '"+ _Upazila +"',UpName = '"+ _UpName +"',UNCode = '"+ _UNCode +"',Uname = '"+ _Uname +"',VCode = '"+ _VCode +"',Vname = '"+ _Vname +"',Cluster = '"+ _Cluster +"',StructureNo = '"+ _StructureNo +"',HouseholdSl = '"+ _HouseholdSl +"',VisitNo = '"+ _VisitNo +"',MemSl = '"+ _MemSl +"',HHHead = '"+ _HHHead +"',childName = '"+ _childName +"',Age = '"+ _Age +"',Sex = '"+ _Sex +"',Member = '"+ _Member +"',Holding = '"+ _Holding +"',Road = '"+ _Road +"',Address = '"+ _Address +"',VisitDate = '"+ _VisitDate +"'  Where UNCode='"+ _UNCode +"' and StructureNo='"+ _StructureNo +"' and HouseholdSl='"+ _HouseholdSl +"' and VisitNo='"+ _VisitNo +"' and MemSl='"+ _MemSl +"' and DeviceId='"+_DeviceID+"'";
                 response = C.SaveData(SQL);
                 C.close();
              }
              catch(Exception  e)
              {
                 response = e.getMessage();
              }
           return response;
        }


        public List<Typhoid_Extra_Master_DataModel> SelectAll(Context context, String SQL)
        {
            Connection C = new Connection(context);
            List<Typhoid_Extra_Master_DataModel> data = new ArrayList<Typhoid_Extra_Master_DataModel>();
            Typhoid_Extra_Master_DataModel d = new Typhoid_Extra_Master_DataModel();
            Cursor cur = C.ReadData(SQL);

            cur.moveToFirst();
            while(!cur.isAfterLast())
            {
                d = new Typhoid_Extra_Master_DataModel();
                d._Upazila = cur.getString(cur.getColumnIndex("Upazila"));
                d._UpName = cur.getString(cur.getColumnIndex("UpName"));
                d._UNCode = cur.getString(cur.getColumnIndex("UNCode"));
                d._Uname = cur.getString(cur.getColumnIndex("Uname"));
                d._VCode = cur.getString(cur.getColumnIndex("VCode"));
                d._Vname = cur.getString(cur.getColumnIndex("Vname"));
                d._Cluster = cur.getString(cur.getColumnIndex("Cluster"));
                d._StructureNo = cur.getString(cur.getColumnIndex("StructureNo"));
                d._HouseholdSl = cur.getString(cur.getColumnIndex("HouseholdSl"));
                d._VisitNo = cur.getString(cur.getColumnIndex("VisitNo"));
                d._MemSl = cur.getString(cur.getColumnIndex("MemSl"));
                d._HHHead = cur.getString(cur.getColumnIndex("HHHead"));
                d._childName = cur.getString(cur.getColumnIndex("childName"));
                d._Age = cur.getString(cur.getColumnIndex("Age"));
                d._Sex = cur.getString(cur.getColumnIndex("Sex"));
                d._Member = cur.getString(cur.getColumnIndex("Member"));
                d._Holding = cur.getString(cur.getColumnIndex("Holding"));
                d._Road = cur.getString(cur.getColumnIndex("Road"));
                d._Address = cur.getString(cur.getColumnIndex("Address"));
                d._VisitDate = cur.getString(cur.getColumnIndex("VisitDate"));
                d._typhoid_extra = cur.getString(cur.getColumnIndex("typhoid_extra"));
                d._DeviceID = cur.getString(cur.getColumnIndex("DeviceID"));
                data.add(d);

                cur.moveToNext();
            }
            cur.close();
          return data;
        }
 }