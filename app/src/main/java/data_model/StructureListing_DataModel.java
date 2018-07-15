package data_model;

import android.content.Context;
 import android.database.Cursor;
 import Common.Connection;
 import java.util.ArrayList;
 import java.util.List;
 import java.util.Date;
 public class StructureListing_DataModel{

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
        private String _VCode = "";
        public String getVCode(){
              return _VCode;
         }
        public void setVCode(String newValue){
              _VCode = newValue;
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
        private String _ColDate = "";
        public String getColDate(){
              return _ColDate;
         }
        public void setColDate(String newValue){
              _ColDate = newValue;
         }
        private String _ColTime = "";
        public String getColTime(){
              return _ColTime;
         }
        public void setColTime(String newValue){
              _ColTime = newValue;
         }
        private int _StructureStatus = 0;
        public int getStructureStatus(){
              return _StructureStatus;
         }
        public void setStructureStatus(int newValue){
              _StructureStatus = newValue;
         }
        private String _Holding = "";
        public String getHolding(){
              return _Holding;
         }
        public void setHolding(String newValue){
              _Holding = newValue;
         }
        private String _Address = "";
        public String getAddress(){
              return _Address;
         }
        public void setAddress(String newValue){
              _Address = newValue;
         }
        private int _BuildingType = 0;
        public int getBuildingType(){
              return _BuildingType;
         }
        public void setBuildingType(int newValue){
              _BuildingType = newValue;
         }
        private String _BuildingTypeOth = "";
        public String getBuildingTypeOth(){
              return _BuildingTypeOth;
         }
        public void setBuildingTypeOth(String newValue){
              _BuildingTypeOth = newValue;
         }
        private int _Srtoried = 0;
        public int getSrtoried(){
              return _Srtoried;
         }
        public void setSrtoried(int newValue){
              _Srtoried = newValue;
         }
        private int _Landmark1 = 0;
        public int getLandmark1(){
              return _Landmark1;
         }
        public void setLandmark1(int newValue){
              _Landmark1 = newValue;
         }
        private int _Landmark1Code = 0;
        public int getLandmark1Code(){
              return _Landmark1Code;
         }
        public void setLandmark1Code(int newValue){
              _Landmark1Code = newValue;
         }
        private String _LandmarkOth1 = "";
        public String getLandmarkOth1(){
              return _LandmarkOth1;
         }
        public void setLandmarkOth1(String newValue){
              _LandmarkOth1 = newValue;
         }
        private String _LandmarkName1 = "";
        public String getLandmarkName1(){
              return _LandmarkName1;
         }
        public void setLandmarkName1(String newValue){
              _LandmarkName1 = newValue;
         }
        private int _Landmark2 = 0;
        public int getLandmark2(){
              return _Landmark2;
         }
        public void setLandmark2(int newValue){
              _Landmark2 = newValue;
         }
        private int _Landmark2Code = 0;
        public int getLandmark2Code(){
              return _Landmark2Code;
         }
        public void setLandmark2Code(int newValue){
              _Landmark2Code = newValue;
         }
        private String _LandmarkOth2 = "";
        public String getLandmarkOth2(){
              return _LandmarkOth2;
         }
        public void setLandmarkOth2(String newValue){
              _LandmarkOth2 = newValue;
         }
        private String _Landmark2Name = "";
        public String getLandmark2Name(){
              return _Landmark2Name;
         }
        public void setLandmark2Name(String newValue){
              _Landmark2Name = newValue;
         }
        private int _Landmark3 = 0;
        public int getLandmark3(){
              return _Landmark3;
         }
        public void setLandmark3(int newValue){
              _Landmark3 = newValue;
         }
        private int _Landmark3Code = 0;
        public int getLandmark3Code(){
              return _Landmark3Code;
         }
        public void setLandmark3Code(int newValue){
              _Landmark3Code = newValue;
         }
        private String _LandmarkOth3 = "";
        public String getLandmarkOth3(){
              return _LandmarkOth3;
         }
        public void setLandmarkOth3(String newValue){
              _LandmarkOth3 = newValue;
         }
        private String _Landmark3Name = "";
        public String getLandmark3Name(){
              return _Landmark3Name;
         }
        public void setLandmark3Name(String newValue){
              _Landmark3Name = newValue;
         }
        private int _Landmark4 = 0;
        public int getLandmark4(){
              return _Landmark4;
         }
        public void setLandmark4(int newValue){
              _Landmark4 = newValue;
         }
        private int _Landmark4Code = 0;
        public int getLandmark4Code(){
              return _Landmark4Code;
         }
        public void setLandmark4Code(int newValue){
              _Landmark4Code = newValue;
         }
        private String _LandmarkOth4 = "";
        public String getLandmarkOth4(){
              return _LandmarkOth4;
         }
        public void setLandmarkOth4(String newValue){
              _LandmarkOth4 = newValue;
         }
        private String _Landmark4Name = "";
        public String getLandmark4Name(){
              return _Landmark4Name;
         }
        public void setLandmark4Name(String newValue){
              _Landmark4Name = newValue;
         }
        private String _OwnerName = "";
        public String getOwnerName(){
              return _OwnerName;
         }
        public void setOwnerName(String newValue){
              _OwnerName = newValue;
         }
        private String _OccupantName = "";
        public String getOccupantName(){
              return _OccupantName;
         }
        public void setOccupantName(String newValue){
              _OccupantName = newValue;
         }
        private int _TotHH = 0;
        public int getTotHH(){
              return _TotHH;
         }
        public void setTotHH(int newValue){
              _TotHH = newValue;
         }
        private int _Slum = 0;
        public int getSlum(){
              return _Slum;
         }
        public void setSlum(int newValue){
              _Slum = newValue;
         }
        private int _Waypoint = 0;
        public int getWaypoint(){
              return _Waypoint;
         }
        public void setWaypoint(int newValue){
              _Waypoint = newValue;
         }
        private int _LatDeg = 0;
        public int getLatDeg(){
              return _LatDeg;
         }
        public void setLatDeg(int newValue){
              _LatDeg = newValue;
         }
        private int _LatMin = 0;
        public int getLatMin(){
              return _LatMin;
         }
        public void setLatMin(int newValue){
              _LatMin = newValue;
         }
        private int _LatSec = 0;
        public int getLatSec(){
              return _LatSec;
         }
        public void setLatSec(int newValue){
              _LatSec = newValue;
         }
        private int _LonDeg = 0;
        public int getLonDeg(){
              return _LonDeg;
         }
        public void setLonDeg(int newValue){
              _LonDeg = newValue;
         }
        private int _LonMin = 0;
        public int getLonMin(){
              return _LonMin;
         }
        public void setLonMin(int newValue){
              _LonMin = newValue;
         }
        private int _LonSec = 0;
        public int getLonSec(){
              return _LonSec;
         }
        public void setLonSec(int newValue){
              _LonSec = newValue;
         }
        private String _Remarks = "";
        public String getRemarks(){
              return _Remarks;
         }
        public void setRemarks(String newValue){
              _Remarks = newValue;
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

        private String _Vname_Oth;

     public String getVname_Oth() {
         return _Vname_Oth;
     }

     public void setVname_Oth(String vname_Oth) {
         _Vname_Oth = vname_Oth;
     }

     String TableName = "StructureListing";

        public String SaveUpdateData(Context context)
        {
            String response = "";
            C = new Connection(context);
            String SQL = "";
            try
            {
                 if(C.Existence("Select * from "+ TableName +"  Where Upazila='"+ _Upazila +"' and UNCode='"+ _UNCode +"' and vcode='"+_VCode+"' and Cluster='"+_Cluster+"' and StructureNo='"+_StructureNo+"'"))
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
                 SQL = "Insert into "+ TableName +" (Upazila,UNCode,VCode,Cluster,StructureNo,ColDate,ColTime,StructureStatus,Holding,Address,BuildingType,BuildingTypeOth,Srtoried,Landmark1,Landmark1Code,LandmarkOth1,LandmarkName1,Landmark2,Landmark2Code,LandmarkOth2,Landmark2Name,Landmark3,Landmark3Code,LandmarkOth3,Landmark3Name,Landmark4,Landmark4Code,LandmarkOth4,Landmark4Name,OwnerName,OccupantName,TotHH,Slum,Waypoint,LatDeg,LatMin,LatSec,LonDeg,LonMin,LonSec,Remarks,StartTime,EndTime,DeviceID,EntryUser,Lat,Lon,EnDt,Upload,modifyDate,VName_Oth)Values('"+ _Upazila +"', '"+ _UNCode +"', '"+ _VCode +"', '"+ _Cluster +"', '"+ _StructureNo +"', '"+ _ColDate +"', '"+ _ColTime +"', '"+ _StructureStatus +"', '"+ _Holding +"', '"+ _Address +"', '"+ _BuildingType +"', '"+ _BuildingTypeOth +"', '"+ _Srtoried +"', '"+ _Landmark1 +"', '"+ _Landmark1Code +"', '"+ _LandmarkOth1 +"', '"+ _LandmarkName1 +"', '"+ _Landmark2 +"', '"+ _Landmark2Code +"', '"+ _LandmarkOth2 +"', '"+ _Landmark2Name +"', '"+ _Landmark3 +"', '"+ _Landmark3Code +"', '"+ _LandmarkOth3 +"', '"+ _Landmark3Name +"', '"+ _Landmark4 +"', '"+ _Landmark4Code +"', '"+ _LandmarkOth4 +"', '"+ _Landmark4Name +"', '"+ _OwnerName +"', '"+ _OccupantName +"', '"+ _TotHH +"', '"+ _Slum +"', '"+ _Waypoint +"', '"+ _LatDeg +"', '"+ _LatMin +"', '"+ _LatSec +"', '"+ _LonDeg +"', '"+ _LonMin +"', '"+ _LonSec +"', '"+ _Remarks +"', '"+ _StartTime +"', '"+ _EndTime +"', '"+ _DeviceID +"', '"+ _EntryUser +"', '"+ _Lat +"', '"+ _Lon +"', '"+ _EnDt +"', '"+ _Upload +"', '"+ _modifyDate+"', '"+_Vname_Oth +"')";
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
                 SQL = "Update "+ TableName +" Set Upload='2',modifyDate='" + _modifyDate + "' ,Upazila = '"+ _Upazila +"',UNCode = '"+ _UNCode +"',VCode = '"+ _VCode+"',VName_Oth = '"+ _Vname_Oth  +"',Cluster = '"+ _Cluster +"',StructureNo = '"+ _StructureNo +"',ColDate = '"+ _ColDate +"',ColTime = '"+ _ColTime +"',StructureStatus = '"+ _StructureStatus +"',Holding = '"+ _Holding +"',Address = '"+ _Address +"',BuildingType = '"+ _BuildingType +"',BuildingTypeOth = '"+ _BuildingTypeOth +"',Srtoried = '"+ _Srtoried +"',Landmark1 = '"+ _Landmark1 +"',Landmark1Code = '"+ _Landmark1Code +"',LandmarkOth1 = '"+ _LandmarkOth1 +"',LandmarkName1 = '"+ _LandmarkName1 +"',Landmark2 = '"+ _Landmark2 +"',Landmark2Code = '"+ _Landmark2Code +"',LandmarkOth2 = '"+ _LandmarkOth2 +"',Landmark2Name = '"+ _Landmark2Name +"',Landmark3 = '"+ _Landmark3 +"',Landmark3Code = '"+ _Landmark3Code +"',LandmarkOth3 = '"+ _LandmarkOth3 +"',Landmark3Name = '"+ _Landmark3Name +"',Landmark4 = '"+ _Landmark4 +"',Landmark4Code = '"+ _Landmark4Code +"',LandmarkOth4 = '"+ _LandmarkOth4 +"',Landmark4Name = '"+ _Landmark4Name +"',OwnerName = '"+ _OwnerName +"',OccupantName = '"+ _OccupantName +"',TotHH = '"+ _TotHH +"',Slum = '"+ _Slum +"',Waypoint = '"+ _Waypoint +"',LatDeg = '"+ _LatDeg +"',LatMin = '"+ _LatMin +"',LatSec = '"+ _LatSec +"',LonDeg = '"+ _LonDeg +"',LonMin = '"+ _LonMin +"',LonSec = '"+ _LonSec +"',Remarks = '"+ _Remarks +"'  Where Upazila='"+ _Upazila +"' and UNCode='"+ _UNCode +"' and vcode='"+_VCode+"' and Cluster='"+_Cluster+"' and StructureNo='"+_StructureNo+"'";
                 response = C.SaveData(SQL);
                 C.close();
              }
              catch(Exception  e)
              {
                 response = e.getMessage();
              }
           return response;
        }


        public List<StructureListing_DataModel> SelectAll(Context context, String SQL)
        {
            Connection C = new Connection(context);
            List<StructureListing_DataModel> data = new ArrayList<StructureListing_DataModel>();
            StructureListing_DataModel d = new StructureListing_DataModel();
            Cursor cur = C.ReadData(SQL);

            cur.moveToFirst();
            while(!cur.isAfterLast())
            {
                d = new StructureListing_DataModel();
                d._Upazila = cur.getString(cur.getColumnIndex("Upazila"));
                d._UNCode = cur.getString(cur.getColumnIndex("UNCode"));
                d._VCode = cur.getString(cur.getColumnIndex("VCode"));
                d._Cluster = cur.getString(cur.getColumnIndex("Cluster"));
                d._StructureNo = cur.getString(cur.getColumnIndex("StructureNo"));
                d._ColDate = cur.getString(cur.getColumnIndex("ColDate"));
                d._ColTime = cur.getString(cur.getColumnIndex("ColTime"));
                d._StructureStatus = Integer.valueOf(cur.getString(cur.getColumnIndex("StructureStatus")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("StructureStatus")));
                d._Holding = cur.getString(cur.getColumnIndex("Holding"));
                d._Address = cur.getString(cur.getColumnIndex("Address"));
                d._BuildingType = Integer.valueOf(cur.getString(cur.getColumnIndex("BuildingType")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("BuildingType")));
                d._BuildingTypeOth = cur.getString(cur.getColumnIndex("BuildingTypeOth"));
                d._Srtoried = Integer.valueOf(cur.getString(cur.getColumnIndex("Srtoried")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Srtoried")));
                d._Landmark1 = Integer.valueOf(cur.getString(cur.getColumnIndex("Landmark1")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Landmark1")));
                d._Landmark1Code = Integer.valueOf(cur.getString(cur.getColumnIndex("Landmark1Code")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Landmark1Code")));
                d._LandmarkOth1 = cur.getString(cur.getColumnIndex("LandmarkOth1"));
                d._LandmarkName1 = cur.getString(cur.getColumnIndex("LandmarkName1"));
                d._Landmark2 = Integer.valueOf(cur.getString(cur.getColumnIndex("Landmark2")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Landmark2")));
                d._Landmark2Code = Integer.valueOf(cur.getString(cur.getColumnIndex("Landmark2Code")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Landmark2Code")));
                d._LandmarkOth2 = cur.getString(cur.getColumnIndex("LandmarkOth2"));
                d._Landmark2Name = cur.getString(cur.getColumnIndex("Landmark2Name"));
                d._Landmark3 = Integer.valueOf(cur.getString(cur.getColumnIndex("Landmark3")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Landmark3")));
                d._Landmark3Code = Integer.valueOf(cur.getString(cur.getColumnIndex("Landmark3Code")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Landmark3Code")));
                d._LandmarkOth3 = cur.getString(cur.getColumnIndex("LandmarkOth3"));
                d._Landmark3Name = cur.getString(cur.getColumnIndex("Landmark3Name"));
                d._Landmark4 = Integer.valueOf(cur.getString(cur.getColumnIndex("Landmark4")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Landmark4")));
                d._Landmark4Code = Integer.valueOf(cur.getString(cur.getColumnIndex("Landmark4Code")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Landmark4Code")));
                d._LandmarkOth4 = cur.getString(cur.getColumnIndex("LandmarkOth4"));
                d._Landmark4Name = cur.getString(cur.getColumnIndex("Landmark4Name"));
                d._OwnerName = cur.getString(cur.getColumnIndex("OwnerName"));
                d._OccupantName = cur.getString(cur.getColumnIndex("OccupantName"));
                d._TotHH = Integer.valueOf(cur.getString(cur.getColumnIndex("TotHH")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("TotHH")));
                d._Slum = Integer.valueOf(cur.getString(cur.getColumnIndex("Slum")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Slum")));
                d._Waypoint = Integer.valueOf(cur.getString(cur.getColumnIndex("Waypoint")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Waypoint")));
                d._LatDeg = Integer.valueOf(cur.getString(cur.getColumnIndex("LatDeg")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("LatDeg")));
                d._LatMin = Integer.valueOf(cur.getString(cur.getColumnIndex("LatMin")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("LatMin")));
                d._LatSec = Integer.valueOf(cur.getString(cur.getColumnIndex("LatSec")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("LatSec")));
                d._LonDeg = Integer.valueOf(cur.getString(cur.getColumnIndex("LonDeg")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("LonDeg")));
                d._LonMin = Integer.valueOf(cur.getString(cur.getColumnIndex("LonMin")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("LonMin")));
                d._LonSec = Integer.valueOf(cur.getString(cur.getColumnIndex("LonSec")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("LonSec")));
                d._Remarks = cur.getString(cur.getColumnIndex("Remarks"));
                d._Vname_Oth=cur.getString(cur.getColumnIndex("VName_Oth"));
                data.add(d);

                cur.moveToNext();
            }
            cur.close();
          return data;
        }
 }