package data_model;

import android.content.Context;
 import android.database.Cursor;
 import Common.Connection;
 import java.util.ArrayList;
 import java.util.List;
 import java.util.Date;
 public class Cluster_Structure_DataModel{

        private String _Upazila = "";
        public String getUpazila(){
              return _Upazila;
         }
        public void setUpazila(String newValue){
              _Upazila = newValue;
         }
        private String _UNCode = "";
        public String getUNCode(){
              return _UNCode;
         }
        public void setUNCode(String newValue){
              _UNCode = newValue;
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
        private String _VisitNo = "";
        public String getVisitNo(){
              return _VisitNo;
         }
        public void setVisitNo(String newValue){
              _VisitNo = newValue;
         }
        private int _VisitOutcome = 0;
        public int getVisitOutcome(){
              return _VisitOutcome;
         }
        public void setVisitOutcome(int newValue){
              _VisitOutcome = newValue;
         }
        private String _VisitOutcomeOth = "";
        public String getVisitOutcomeOth(){
              return _VisitOutcomeOth;
         }
        public void setVisitOutcomeOth(String newValue){
              _VisitOutcomeOth = newValue;
         }
        private int _ReasonInVisit = 0;
        public int getReasonInVisit(){
              return _ReasonInVisit;
         }
        public void setReasonInVisit(int newValue){
              _ReasonInVisit = newValue;
         }
        private String _ReasonInVisitOth = "";
        public String getReasonInVisitOth(){
              return _ReasonInVisitOth;
         }
        public void setReasonInVisitOth(String newValue){
              _ReasonInVisitOth = newValue;
         }
        private String _TotalHH = "";
        public String getTotalHH(){
              return _TotalHH;
         }
        public void setTotalHH(String newValue){
              _TotalHH = newValue;
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

        String TableName = "Cluster_Structure";

        public String SaveUpdateData(Context context)
        {
            String response = "";
            C = new Connection(context);
            String SQL = "";
            try
            {
                 if(C.Existence("Select * from "+ TableName +"  Where Upazila='"+ _Upazila +"' and UNCode='"+ _UNCode +"' and Cluster='"+ _Cluster +"' and StructureNo='"+ _StructureNo +"' and VisitNo='"+ _VisitNo +"' and DeviceID='"+_DeviceID+"'"))
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
                 SQL = "Insert into "+ TableName +" (Upazila,UNCode,Cluster,StructureNo,VisitNo,VisitOutcome,VisitOutcomeOth,ReasonInVisit,ReasonInVisitOth,TotalHH,StartTime,EndTime,DeviceID,EntryUser,Lat,Lon,EnDt,Upload,modifyDate)Values('"+ _Upazila +"', '"+ _UNCode +"', '"+ _Cluster +"', '"+ _StructureNo +"', '"+ _VisitNo +"', '"+ _VisitOutcome +"', '"+ _VisitOutcomeOth +"', '"+ _ReasonInVisit +"', '"+ _ReasonInVisitOth +"', '"+ _TotalHH +"', '"+ _StartTime +"', '"+ _EndTime +"', '"+ _DeviceID +"', '"+ _EntryUser +"', '"+ _Lat +"', '"+ _Lon +"', '"+ _EnDt +"', '"+ _Upload +"', '"+ _modifyDate +"')";
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
                 SQL = "Update "+ TableName +" Set Upload='2',modifyDate='" + _modifyDate + "' ,Upazila = '"+ _Upazila +"',UNCode = '"+ _UNCode +"',Cluster = '"+ _Cluster +"',StructureNo = '"+ _StructureNo +"',VisitNo = '"+ _VisitNo +"',VisitOutcome = '"+ _VisitOutcome +"',VisitOutcomeOth = '"+ _VisitOutcomeOth +"',ReasonInVisit = '"+ _ReasonInVisit +"',ReasonInVisitOth = '"+ _ReasonInVisitOth +"',TotalHH = '"+ _TotalHH +"'  Where Upazila='"+ _Upazila +"' and UNCode='"+ _UNCode +"' and Cluster='"+ _Cluster +"' and StructureNo='"+ _StructureNo +"' and VisitNo='"+ _VisitNo +"' and VisitNo='"+ _VisitNo +"' and DeviceID='"+_DeviceID+"'";
                 response = C.SaveData(SQL);
                 C.close();
              }
              catch(Exception  e)
              {
                 response = e.getMessage();
              }
           return response;
        }


        public List<Cluster_Structure_DataModel> SelectAll(Context context, String SQL)
        {
            Connection C = new Connection(context);
            List<Cluster_Structure_DataModel> data = new ArrayList<Cluster_Structure_DataModel>();
            Cluster_Structure_DataModel d = new Cluster_Structure_DataModel();
            Cursor cur = C.ReadData(SQL);

            cur.moveToFirst();
            while(!cur.isAfterLast())
            {
                d = new Cluster_Structure_DataModel();
                d._Upazila = cur.getString(cur.getColumnIndex("Upazila"));
                d._UNCode = cur.getString(cur.getColumnIndex("UNCode"));
                d._Cluster = cur.getString(cur.getColumnIndex("Cluster"));
                d._StructureNo = cur.getString(cur.getColumnIndex("StructureNo"));
                d._VisitNo = cur.getString(cur.getColumnIndex("VisitNo"));
                d._VisitOutcome = Integer.valueOf(cur.getString(cur.getColumnIndex("VisitOutcome")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("VisitOutcome")));
                d._VisitOutcomeOth = cur.getString(cur.getColumnIndex("VisitOutcomeOth"));
                d._ReasonInVisit = Integer.valueOf(cur.getString(cur.getColumnIndex("ReasonInVisit")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("ReasonInVisit")));
                d._ReasonInVisitOth = cur.getString(cur.getColumnIndex("ReasonInVisitOth"));
                d._TotalHH = cur.getString(cur.getColumnIndex("TotalHH"));
                data.add(d);

                cur.moveToNext();
            }
            cur.close();
          return data;
        }
 }