package data_model;

import android.content.Context;
 import android.database.Cursor;
 import Common.Connection;
 import java.util.ArrayList;
 import java.util.List;
 import java.util.Date;
 public class StructureID_Serial_DataModel{

        private String _DeviceId = "";
        public String getDeviceId(){
              return _DeviceId;
         }
        public void setDeviceId(String newValue){
              _DeviceId = newValue;
         }
        private String _Ward = "";
        public String getWard(){
              return _Ward;
         }
        public void setWard(String newValue){
              _Ward = newValue;
         }
        private String _NewStructure = "";
        public String getNewStructure(){
              return _NewStructure;
         }
        public void setNewStructure(String newValue){
              _NewStructure = newValue;
         }
//        private String _StartTime = "";
//        public void setStartTime(String newValue){
//              _StartTime = newValue;
//         }
//        private String _EndTime = "";
//        public void setEndTime(String newValue){
//              _EndTime = newValue;
//         }
//        private String _DeviceID = "";
//        public void setDeviceID(String newValue){
//              _DeviceID = newValue;
//         }
//        private String _EntryUser = "";
//        public void setEntryUser(String newValue){
//              _EntryUser = newValue;
//         }
//        private String _Lat = "";
//        public void setLat(String newValue){
//              _Lat = newValue;
//         }
//        private String _Lon = "";
//        public void setLon(String newValue){
//              _Lon = newValue;
//         }
//        private String _EnDt = "";
//        public void setEnDt(String newValue){
//              _EnDt = newValue;
//         }
//        private int _Upload = 2;
        private String _modifyDate = "";
        public void setmodifyDate(String newValue){
        _modifyDate = newValue;
        }

        String TableName = "StructureID_Serial";

        public String SaveUpdateData(Context context)
        {
            String response = "";
            C = new Connection(context);
            String SQL = "";
            try
            {
                 if(C.Existence("Select * from "+ TableName +"  Where DeviceId='"+ _DeviceId +"' and Ward='"+ _Ward +"' and NewStructure='"+ _NewStructure +"' "))
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
                 SQL = "Insert into "+ TableName +" (DeviceId,Ward,NewStructure,modifyDate)Values('"+ _DeviceId +"', '"+ _Ward +"', '"+ _NewStructure +"', '"+ _modifyDate +"')";
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
                 SQL = "Update "+ TableName +" Set Upload='2',modifyDate='" + _modifyDate + "' ,DeviceId = '"+ _DeviceId +"',Ward = '"+ _Ward +"',NewStructure = '"+ _NewStructure +"'  Where DeviceId='"+ _DeviceId +"' and Ward='"+ _Ward +"' and NewStructure='"+ _NewStructure +"'";
                 response = C.SaveData(SQL);
                 C.close();
              }
              catch(Exception  e)
              {
                 response = e.getMessage();
              }
           return response;
        }


        public List<StructureID_Serial_DataModel> SelectAll(Context context, String SQL)
        {
            Connection C = new Connection(context);
            List<StructureID_Serial_DataModel> data = new ArrayList<StructureID_Serial_DataModel>();
            StructureID_Serial_DataModel d = new StructureID_Serial_DataModel();
            Cursor cur = C.ReadData(SQL);

            cur.moveToFirst();
            while(!cur.isAfterLast())
            {
                d = new StructureID_Serial_DataModel();
                d._DeviceId = cur.getString(cur.getColumnIndex("DeviceId"));
                d._Ward = cur.getString(cur.getColumnIndex("Ward"));
                d._NewStructure = cur.getString(cur.getColumnIndex("NewStructure"));
                data.add(d);

                cur.moveToNext();
            }
            cur.close();
          return data;
        }
 }