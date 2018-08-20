package data_model;

import android.content.Context;
 import android.database.Cursor;
 import Common.Connection;
 import java.util.ArrayList;
 import java.util.List;

public class  Household_Visit_DataModel{

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
        private int _HouseholdSl = 0;
        public int getHouseholdSl(){
              return _HouseholdSl;
         }
        public void setHouseholdSl(int newValue){
              _HouseholdSl = newValue;
         }
        private String _VisitNo = "";
        public String getVisitNo(){
              return _VisitNo;
         }
        public void setVisitNo(String newValue){
              _VisitNo = newValue;
         }
        private int _HHVisited = 0;
        public int getHHVisited(){
              return _HHVisited;
         }
        public void setHHVisited(int newValue){
              _HHVisited = newValue;
         }
        private int _Outcome = 0;
        public int getOutcome(){
              return _Outcome;
         }
        public void setOutcome(int newValue){
              _Outcome = newValue;
         }
        private String _OutcomeOth = "";
        public String getOutcomeOth(){
              return _OutcomeOth;
         }
        public void setOutcomeOth(String newValue){
              _OutcomeOth = newValue;
         }
        private int _HHMember = 0;
        public int getHHMember(){ return _HHMember; }
        public void setHHMember(int newValue){
              _HHMember = newValue;
         }
        private int _U18Yrs = 0;
        public int getU18Yrs(){
              return _U18Yrs;
         }
        public void setU18Yrs(int newValue){
              _U18Yrs = newValue;
         }
        private int _U18Alive = 0;
        public int getU18Alive(){
              return _U18Alive;
         }
        public void setU18Alive(int newValue){
              _U18Alive = newValue;
         }
        private int _U18YrsDie = 0;
        public int getU18YrsDie(){
              return _U18YrsDie;
         }
        public void setU18YrsDie(int newValue){
              _U18YrsDie = newValue;
         }
        private int _U18Death = 0;
        public int getU18Death(){
              return _U18Death;
         }
        public void setU18Death(int newValue){
              _U18Death = newValue;
         }
        private int _OfferedStudy = 0;
        public int getOfferedStudy(){
              return _OfferedStudy;
         }
        public void setOfferedStudy(int newValue){
              _OfferedStudy = newValue;
         }
        private int _NotOffered = 0;
        public int getNotOffered(){
              return _NotOffered;
         }
        public void setNotOffered(int newValue){
              _NotOffered = newValue;
         }
        private String _NotOfferedOth = "";
        public String getNotOfferedOth(){
              return _NotOfferedOth;
         }
        public void setNotOfferedOth(String newValue){
              _NotOfferedOth = newValue;
         }
        private int _Consent = 0;
        public int getConsent(){
              return _Consent;
         }
        public void setConsent(int newValue){
              _Consent = newValue;
         }
        private String _Remarks = "";
        public String getRemarks(){
              return _Remarks;
         }
        public void setRemarks(String newValue){
              _Remarks = newValue;
         }
        private String _DataCollDate = "";
        public String getDataCollDate(){
              return _DataCollDate;
         }
        public void setDataCollDate(String newValue){
              _DataCollDate = newValue;
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

        String TableName = "Household_Visit";

        public String SaveUpdateData(Context context)
        {
            String response = "";
            C = new Connection(context);
            String SQL = "";
            try
            {
                 if(C.Existence("Select * from "+ TableName +"  Where UNCode='"+ _UNCode +"' and StructureNo='"+ _StructureNo +"' and HouseholdSl='"+ _HouseholdSl +"' and VisitNo='"+ _VisitNo +"' "))
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
                 SQL = "Insert into "+ TableName +" (UNCode,StructureNo,HouseholdSl,VisitNo,HHVisited,Outcome,OutcomeOth,HHMember,U18Yrs,U18Alive,U18YrsDie,U18Death,OfferedStudy,NotOffered,NotOfferedOth,Consent,Remarks,DataCollDate,StartTime,EndTime,DeviceID,EntryUser,Lat,Lon,EnDt,Upload,modifyDate)Values('"+ _UNCode +"', '"+ _StructureNo +"', '"+ _HouseholdSl +"', '"+ _VisitNo +"', '"+ _HHVisited +"', '"+ _Outcome +"', '"+ _OutcomeOth +"', '"+ _HHMember +"', '"+ _U18Yrs +"', '"+ _U18Alive +"', '"+ _U18YrsDie +"', '"+ _U18Death +"', '"+ _OfferedStudy +"', '"+ _NotOffered +"', '"+ _NotOfferedOth +"', '"+ _Consent +"', '"+ _Remarks +"', '"+ _DataCollDate +"', '"+ _StartTime +"', '"+ _EndTime +"', '"+ _DeviceID +"', '"+ _EntryUser +"', '"+ _Lat +"', '"+ _Lon +"', '"+ _EnDt +"', '"+ _Upload +"', '"+ _modifyDate +"')";
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
                 SQL = "Update "+ TableName +" Set Upload='2',modifyDate='" + _modifyDate + "' ,UNCode = '"+ _UNCode +"',StructureNo = '"+ _StructureNo +"',HouseholdSl = '"+ _HouseholdSl +"',VisitNo = '"+ _VisitNo +"',HHVisited = '"+ _HHVisited +"',Outcome = '"+ _Outcome +"',OutcomeOth = '"+ _OutcomeOth +"',HHMember = '"+ _HHMember +"',U18Yrs = '"+ _U18Yrs +"',U18Alive = '"+ _U18Alive +"',U18YrsDie = '"+ _U18YrsDie +"',U18Death = '"+ _U18Death +"',OfferedStudy = '"+ _OfferedStudy +"',NotOffered = '"+ _NotOffered +"',NotOfferedOth = '"+ _NotOfferedOth +"',Consent = '"+ _Consent +"',Remarks = '"+ _Remarks +"',DataCollDate = '"+ _DataCollDate +"'  Where UNCode='"+ _UNCode +"' and StructureNo='"+ _StructureNo +"' and HouseholdSl='"+ _HouseholdSl +"' and VisitNo='"+ _VisitNo +"'";
                 response = C.SaveData(SQL);
                 C.close();
              }
              catch(Exception  e)
              {
                 response = e.getMessage();
              }
           return response;
        }


        public List<Household_Visit_DataModel> SelectAll(Context context, String SQL)
        {
            Connection C = new Connection(context);
            List<Household_Visit_DataModel> data = new ArrayList<Household_Visit_DataModel>();
            Household_Visit_DataModel d = new Household_Visit_DataModel();
            Cursor cur = C.ReadData(SQL);

            cur.moveToFirst();
            while(!cur.isAfterLast())
            {
                d = new Household_Visit_DataModel();
                d._UNCode = cur.getString(cur.getColumnIndex("UNCode"));
                d._StructureNo = cur.getString(cur.getColumnIndex("StructureNo"));
                d._HouseholdSl = Integer.valueOf(cur.getString(cur.getColumnIndex("HouseholdSl")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("HouseholdSl")));
                d._VisitNo = cur.getString(cur.getColumnIndex("VisitNo"));
                d._HHVisited = Integer.valueOf(cur.getString(cur.getColumnIndex("HHVisited")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("HHVisited")));
                d._Outcome = Integer.valueOf(cur.getString(cur.getColumnIndex("Outcome")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Outcome")));
                d._OutcomeOth = cur.getString(cur.getColumnIndex("OutcomeOth"));
                d._HHMember = Integer.valueOf(cur.getString(cur.getColumnIndex("HHMember")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("HHMember")));
                d._U18Yrs = Integer.valueOf(cur.getString(cur.getColumnIndex("U18Yrs")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("U18Yrs")));
                d._U18Alive = Integer.valueOf(cur.getString(cur.getColumnIndex("U18Alive")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("U18Alive")));
                d._U18YrsDie = Integer.valueOf(cur.getString(cur.getColumnIndex("U18YrsDie")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("U18YrsDie")));
                d._U18Death = Integer.valueOf(cur.getString(cur.getColumnIndex("U18Death")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("U18Death")));
                d._OfferedStudy = Integer.valueOf(cur.getString(cur.getColumnIndex("OfferedStudy")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("OfferedStudy")));
                d._NotOffered = Integer.valueOf(cur.getString(cur.getColumnIndex("NotOffered")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("NotOffered")));
                d._NotOfferedOth = cur.getString(cur.getColumnIndex("NotOfferedOth"));
                d._Consent = Integer.valueOf(cur.getString(cur.getColumnIndex("Consent")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Consent")));
                d._Remarks = cur.getString(cur.getColumnIndex("Remarks"));
                d._DataCollDate = cur.getString(cur.getColumnIndex("DataCollDate"));
                data.add(d);

                cur.moveToNext();
            }
            cur.close();
          return data;
        }
 }