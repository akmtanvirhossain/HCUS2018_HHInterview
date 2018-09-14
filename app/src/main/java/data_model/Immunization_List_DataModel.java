package data_model;

import android.content.Context;
 import android.database.Cursor;
 import Common.Connection;
 import java.util.ArrayList;
 import java.util.List;
 import java.util.Date;
 public class Immunization_List_DataModel{

        private String _Vacc_Id = "";
        public String getVacc_Id(){
              return _Vacc_Id;
         }
        public void setVacc_Id(String newValue){
              _Vacc_Id = newValue;
         }
        private String _Vacc_Name = "";
        public String getVacc_Name(){
              return _Vacc_Name;
         }
        public void setVacc_Name(String newValue){
              _Vacc_Name = newValue;
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

//        private String _history_status;


//     public String getHistory_status() {
//         return _history_status;
//     }

//     public void setHistory_status(String history_status) {
//         this._history_status = history_status;
//     }

     private String _Given;

     public String get_Given() {
         return _Given;
     }

     public void set_Given(String _Given) {
         this._Given = _Given;
     }

     private String _Source;

     public String get_Source() {
         return _Source;
     }

     public void set_Source(String _Source) {
         this._Source = _Source;
     }

     String TableName = "Immunization_List";

        public String SaveUpdateData(Context context)
        {
            String response = "";
            C = new Connection(context);
            String SQL = "";
            try
            {
                 if(C.Existence("Select * from "+ TableName +"  Where Vacc_Id='"+ _Vacc_Id +"' "))
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
                 SQL = "Insert into "+ TableName +" (Vacc_Id,Vacc_Name,StartTime,EndTime,DeviceID,EntryUser,Lat,Lon,EnDt,Upload,modifyDate)Values('"+ _Vacc_Id +"', '"+ _Vacc_Name +"', '"+ _StartTime +"', '"+ _EndTime +"', '"+ _DeviceID +"', '"+ _EntryUser +"', '"+ _Lat +"', '"+ _Lon +"', '"+ _EnDt +"', '"+ _Upload +"', '"+ _modifyDate +"')";
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
                 SQL = "Update "+ TableName +" Set Upload='2',modifyDate='" + _modifyDate + "' ,Vacc_Id = '"+ _Vacc_Id +"',Vacc_Name = '"+ _Vacc_Name +"'  Where Vacc_Id='"+ _Vacc_Id +"'";
                 response = C.SaveData(SQL);
                 C.close();
              }
              catch(Exception  e)
              {
                 response = e.getMessage();
              }
           return response;
        }


        public List<Immunization_List_DataModel> SelectAll_WithHistory(Context context, String SQL)
        {
            Connection C = new Connection(context);
            List<Immunization_List_DataModel> data = new ArrayList<Immunization_List_DataModel>();
            Immunization_List_DataModel d = new Immunization_List_DataModel();
            Cursor cur = C.ReadData(SQL);

            cur.moveToFirst();
            while(!cur.isAfterLast())
            {
                d = new Immunization_List_DataModel();
                d._Vacc_Id = cur.getString(cur.getColumnIndex("Vacc_Id"));
                d._Vacc_Name = cur.getString(cur.getColumnIndex("Vacc_Name"));
//                d._history_status = cur.getString(cur.getColumnIndex("history_status"));
                d._Given = cur.getString(cur.getColumnIndex("Given"));
                d._Source = cur.getString(cur.getColumnIndex("Source"));

                data.add(d);

                cur.moveToNext();
            }
            cur.close();
          return data;
        }

     public List<Immunization_List_DataModel> SelectAll(Context context, String SQL)
     {
         Connection C = new Connection(context);
         List<Immunization_List_DataModel> data = new ArrayList<Immunization_List_DataModel>();
         Immunization_List_DataModel d = new Immunization_List_DataModel();
         Cursor cur = C.ReadData(SQL);

         cur.moveToFirst();
         while(!cur.isAfterLast())
         {
             d = new Immunization_List_DataModel();
             d._Vacc_Id = cur.getString(cur.getColumnIndex("Vacc_Id"));
             d._Vacc_Name = cur.getString(cur.getColumnIndex("Vacc_Name"));
//                d._history_status = cur.getString(cur.getColumnIndex("history_status"));
//             d._Given = cur.getString(cur.getColumnIndex("Given"));
//             d._Source = cur.getString(cur.getColumnIndex("Source"));

             data.add(d);

             cur.moveToNext();
         }
         cur.close();
         return data;
     }
 }