package data_model;

import android.content.Context;
 import android.database.Cursor;
 import Common.Connection;
 import java.util.ArrayList;
 import java.util.List;
 import java.util.Date;
 public class Knowledge_DSH_SSF_DataModel{

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
        private int _DSH = 0;
        public int getDSH(){
              return _DSH;
         }
        public void setDSH(int newValue){
              _DSH = newValue;
         }
        private int _DSHway = 0;
        public int getDSHway(){
              return _DSHway;
         }
        public void setDSHway(int newValue){
              _DSHway = newValue;
         }
        private String _DSHwayOth = "";
        public String getDSHwayOth(){
              return _DSHwayOth;
         }
        public void setDSHwayOth(String newValue){
              _DSHwayOth = newValue;
         }
        private String _ReachDSH = "";
        public String getReachDSH(){
              return _ReachDSH;
         }
        public void setReachDSH(String newValue){
              _ReachDSH = newValue;
         }
        private int _SSF = 0;
        public int getSSF(){
              return _SSF;
         }
        public void setSSF(int newValue){
              _SSF = newValue;
         }
        private int _SSFway = 0;
        public int getSSFway(){
              return _SSFway;
         }
        public void setSSFway(int newValue){
              _SSFway = newValue;
         }
        private String _SSFwayOth = "";
        public String getSSFwayOth(){
              return _SSFwayOth;
         }
        public void setSSFwayOth(String newValue){
              _SSFwayOth = newValue;
         }
        private String _ReachSSF = "";
        public String getReachSSF(){
              return _ReachSSF;
         }
        public void setReachSSF(String newValue){
              _ReachSSF = newValue;
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

        String TableName = "Knowledge_DSH_SSF";

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
                 SQL = "Insert into "+ TableName +" (UNCode,StructureNo,HouseholdSl,VisitNo,DSH,DSHway,DSHwayOth,ReachDSH,SSF,SSFway,SSFwayOth,ReachSSF,StartTime,EndTime,DeviceID,EntryUser,Lat,Lon,EnDt,Upload,modifyDate)Values('"+ _UNCode +"', '"+ _StructureNo +"', '"+ _HouseholdSl +"', '"+ _VisitNo +"', '"+ _DSH +"', '"+ _DSHway +"', '"+ _DSHwayOth +"', '"+ _ReachDSH +"', '"+ _SSF +"', '"+ _SSFway +"', '"+ _SSFwayOth +"', '"+ _ReachSSF +"', '"+ _StartTime +"', '"+ _EndTime +"', '"+ _DeviceID +"', '"+ _EntryUser +"', '"+ _Lat +"', '"+ _Lon +"', '"+ _EnDt +"', '"+ _Upload +"', '"+ _modifyDate +"')";
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
                 SQL = "Update "+ TableName +" Set Upload='2',modifyDate='" + _modifyDate + "' ,UNCode = '"+ _UNCode +"',StructureNo = '"+ _StructureNo +"',HouseholdSl = '"+ _HouseholdSl +"',VisitNo = '"+ _VisitNo +"',DSH = '"+ _DSH +"',DSHway = '"+ _DSHway +"',DSHwayOth = '"+ _DSHwayOth +"',ReachDSH = '"+ _ReachDSH +"',SSF = '"+ _SSF +"',SSFway = '"+ _SSFway +"',SSFwayOth = '"+ _SSFwayOth +"',ReachSSF = '"+ _ReachSSF +"'  Where UNCode='"+ _UNCode +"' and StructureNo='"+ _StructureNo +"' and HouseholdSl='"+ _HouseholdSl +"' and VisitNo='"+ _VisitNo +"'";
                 response = C.SaveData(SQL);
                 C.close();
              }
              catch(Exception  e)
              {
                 response = e.getMessage();
              }
           return response;
        }


        public List<Knowledge_DSH_SSF_DataModel> SelectAll(Context context, String SQL)
        {
            Connection C = new Connection(context);
            List<Knowledge_DSH_SSF_DataModel> data = new ArrayList<Knowledge_DSH_SSF_DataModel>();
            Knowledge_DSH_SSF_DataModel d = new Knowledge_DSH_SSF_DataModel();
            Cursor cur = C.ReadData(SQL);

            cur.moveToFirst();
            while(!cur.isAfterLast())
            {
                d = new Knowledge_DSH_SSF_DataModel();
                d._UNCode = cur.getString(cur.getColumnIndex("UNCode"));
                d._StructureNo = cur.getString(cur.getColumnIndex("StructureNo"));
                d._HouseholdSl = cur.getString(cur.getColumnIndex("HouseholdSl"));
                d._VisitNo = cur.getString(cur.getColumnIndex("VisitNo"));
                d._DSH = Integer.valueOf(cur.getString(cur.getColumnIndex("DSH")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("DSH")));
                d._DSHway = Integer.valueOf(cur.getString(cur.getColumnIndex("DSHway")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("DSHway")));
                d._DSHwayOth = cur.getString(cur.getColumnIndex("DSHwayOth"));
                d._ReachDSH = cur.getString(cur.getColumnIndex("ReachDSH"));
                d._SSF = Integer.valueOf(cur.getString(cur.getColumnIndex("SSF")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("SSF")));
                d._SSFway = Integer.valueOf(cur.getString(cur.getColumnIndex("SSFway")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("SSFway")));
                d._SSFwayOth = cur.getString(cur.getColumnIndex("SSFwayOth"));
                d._ReachSSF = cur.getString(cur.getColumnIndex("ReachSSF"));
                data.add(d);

                cur.moveToNext();
            }
            cur.close();
          return data;
        }
 }