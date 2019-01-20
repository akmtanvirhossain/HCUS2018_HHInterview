package data_model;

import android.content.Context;
 import android.database.Cursor;
 import Common.Connection;
 import java.util.ArrayList;
 import java.util.List;
 import java.util.Date;
 public class Typhoid_Extra_Master_DataModel{

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
        private String _Father = "";
        public String getFather(){
              return _Father;
         }
        public void setFather(String newValue){
              _Father = newValue;
         }
        private String _Mother = "";
        public String getMother(){
              return _Mother;
         }
        public void setMother(String newValue){
              _Mother = newValue;
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
                 SQL = "Insert into "+ TableName +" (UNCode,StructureNo,HouseholdSl,VisitNo,MemSl,HHHead,childName,Age,Sex,Father,Mother,Holding,Road,Address,StartTime,EndTime,DeviceID,EntryUser,Lat,Lon,EnDt,Upload,modifyDate)Values('"+ _UNCode +"', '"+ _StructureNo +"', '"+ _HouseholdSl +"', '"+ _VisitNo +"', '"+ _MemSl +"', '"+ _HHHead +"', '"+ _childName +"', '"+ _Age +"', '"+ _Sex +"', '"+ _Father +"', '"+ _Mother +"', '"+ _Holding +"', '"+ _Road +"', '"+ _Address +"', '"+ _StartTime +"', '"+ _EndTime +"', '"+ _DeviceID +"', '"+ _EntryUser +"', '"+ _Lat +"', '"+ _Lon +"', '"+ _EnDt +"', '"+ _Upload +"', '"+ _modifyDate +"')";
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
                 SQL = "Update "+ TableName +" Set Upload='2',modifyDate='" + _modifyDate + "' ,UNCode = '"+ _UNCode +"',StructureNo = '"+ _StructureNo +"',HouseholdSl = '"+ _HouseholdSl +"',VisitNo = '"+ _VisitNo +"',MemSl = '"+ _MemSl +"',HHHead = '"+ _HHHead +"',childName = '"+ _childName +"',Age = '"+ _Age +"',Sex = '"+ _Sex +"',Father = '"+ _Father +"',Mother = '"+ _Mother +"',Holding = '"+ _Holding +"',Road = '"+ _Road +"',Address = '"+ _Address +"'  Where UNCode='"+ _UNCode +"' and StructureNo='"+ _StructureNo +"' and HouseholdSl='"+ _HouseholdSl +"' and VisitNo='"+ _VisitNo +"' and MemSl='"+ _MemSl +"' and DeviceId='"+_DeviceID+"'";
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
                d._UNCode = cur.getString(cur.getColumnIndex("UNCode"));
                d._StructureNo = cur.getString(cur.getColumnIndex("StructureNo"));
                d._HouseholdSl = cur.getString(cur.getColumnIndex("HouseholdSl"));
                d._VisitNo = cur.getString(cur.getColumnIndex("VisitNo"));
                d._MemSl = cur.getString(cur.getColumnIndex("MemSl"));
                d._HHHead = cur.getString(cur.getColumnIndex("HHHead"));
                d._childName = cur.getString(cur.getColumnIndex("childName"));
                d._Age = cur.getString(cur.getColumnIndex("Age"));
                d._Sex = cur.getString(cur.getColumnIndex("Sex"));
                d._Father = cur.getString(cur.getColumnIndex("Father"));
                d._Mother = cur.getString(cur.getColumnIndex("Mother"));
                d._Holding = cur.getString(cur.getColumnIndex("Holding"));
                d._Road = cur.getString(cur.getColumnIndex("Road"));
                d._Address = cur.getString(cur.getColumnIndex("Address"));
                d._typhoid_extra = cur.getString(cur.getColumnIndex("typhoid_extra"));

                data.add(d);

                cur.moveToNext();
            }
            cur.close();
          return data;
        }
 }