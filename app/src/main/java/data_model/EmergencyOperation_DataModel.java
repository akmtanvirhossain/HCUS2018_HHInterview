package data_model;

import android.content.Context;
 import android.database.Cursor;
 import Common.Connection;
 import java.util.ArrayList;
 import java.util.List;
 import java.util.Date;
 public class EmergencyOperation_DataModel{

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
        private int _SAbd = 0;
        public int getSAbd(){
              return _SAbd;
         }
        public void setSAbd(int newValue){
              _SAbd = newValue;
         }
        private int _OperNo = 0;
        public int getOperNo(){
              return _OperNo;
         }
        public void setOperNo(int newValue){
              _OperNo = newValue;
         }
        private String _SDtHos = "";
        public String getSDtHos(){
              return _SDtHos;
         }
        public void setSDtHos(String newValue){
              _SDtHos = newValue;
         }
        private int _SHosM = 0;
        public int getSHosM(){
              return _SHosM;
         }
        public void setSHosM(int newValue){
              _SHosM = newValue;
         }
        private int _SIlBeHosAdm = 0;
        public int getSIlBeHosAdm(){
              return _SIlBeHosAdm;
         }
        public void setSIlBeHosAdm(int newValue){
              _SIlBeHosAdm = newValue;
         }
        private int _SurSympt = 0;
        public int getSurSympt(){
              return _SurSympt;
         }
        public void setSurSympt(int newValue){
              _SurSympt = newValue;
         }
        private String _SurSymptOth = "";
        public String getSurSymptOth(){
              return _SurSymptOth;
         }
        public void setSurSymptOth(String newValue){
              _SurSymptOth = newValue;
         }
        private int _SurSympt2 = 0;
        public int getSurSympt2(){
              return _SurSympt2;
         }
        public void setSurSympt2(int newValue){
              _SurSympt2 = newValue;
         }
        private String _SurSymptOth2 = "";
        public String getSurSymptOth2(){
              return _SurSymptOth2;
         }
        public void setSurSymptOth2(String newValue){
              _SurSymptOth2 = newValue;
         }
        private int _SurSympt3 = 0;
        public int getSurSympt3(){
              return _SurSympt3;
         }
        public void setSurSympt3(int newValue){
              _SurSympt3 = newValue;
         }
        private String _SurSymptOth3 = "";
        public String getSurSymptOth3(){
              return _SurSymptOth3;
         }
        public void setSurSymptOth3(String newValue){
              _SurSymptOth3 = newValue;
         }
        private int _SurSympt4 = 0;
        public int getSurSympt4(){
              return _SurSympt4;
         }
        public void setSurSympt4(int newValue){
              _SurSympt4 = newValue;
         }
        private String _SurSymptOth4 = "";
        public String getSurSymptOth4(){
              return _SurSymptOth4;
         }
        public void setSurSymptOth4(String newValue){
              _SurSymptOth4 = newValue;
         }
        private int _SurSympt5 = 0;
        public int getSurSympt5(){
              return _SurSympt5;
         }
        public void setSurSympt5(int newValue){
              _SurSympt5 = newValue;
         }
        private String _SurSymptOth5 = "";
        public String getSurSymptOth5(){
              return _SurSymptOth5;
         }
        public void setSurSymptOth5(String newValue){
              _SurSymptOth5 = newValue;
         }
        private int _SurSympt6 = 0;
        public int getSurSympt6(){
              return _SurSympt6;
         }
        public void setSurSympt6(int newValue){
              _SurSympt6 = newValue;
         }
        private String _SurSymptOth6 = "";
        public String getSurSymptOth6(){
              return _SurSymptOth6;
         }
        public void setSurSymptOth6(String newValue){
              _SurSymptOth6 = newValue;
         }
        private int _SurSympt7 = 0;
        public int getSurSympt7(){
              return _SurSympt7;
         }
        public void setSurSympt7(int newValue){
              _SurSympt7 = newValue;
         }
        private String _SurSymptOth7 = "";
        public String getSurSymptOth7(){
              return _SurSymptOth7;
         }
        public void setSurSymptOth7(String newValue){
              _SurSymptOth7 = newValue;
         }
        private int _SDurFever = 0;
        public int getSDurFever(){
              return _SDurFever;
         }
        public void setSDurFever(int newValue){
              _SDurFever = newValue;
         }
        private int _SPHosNam = 0;
        public int getSPHosNam(){
              return _SPHosNam;
         }
        public void setSPHosNam(int newValue){
              _SPHosNam = newValue;
         }
        private String _SPHosOth = "";
        public String getSPHosOth(){
              return _SPHosOth;
         }
        public void setSPHosOth(String newValue){
              _SPHosOth = newValue;
         }
        private int _SDisDr = 0;
        public int getSDisDr(){
              return _SDisDr;
         }
        public void setSDisDr(int newValue){
              _SDisDr = newValue;
         }
        private String _SDisDrOth = "";
        public String getSDisDrOth(){
              return _SDisDrOth;
         }
        public void setSDisDrOth(String newValue){
              _SDisDrOth = newValue;
         }
        private int _SReco = 0;
        public int getSReco(){
              return _SReco;
         }
        public void setSReco(int newValue){
              _SReco = newValue;
         }
        private int _SDurReco = 0;
        public int getSDurReco(){
              return _SDurReco;
         }
        public void setSDurReco(int newValue){
              _SDurReco = newValue;
         }
        private int _SInReco = 0;
        public int getSInReco(){
              return _SInReco;
         }
        public void setSInReco(int newValue){
              _SInReco = newValue;
         }
        private String _SInRecoOth = "";
        public String getSInRecoOth(){
              return _SInRecoOth;
         }
        public void setSInRecoOth(String newValue){
              _SInRecoOth = newValue;
         }
        private int _SInReco2 = 0;
        public int getSInReco2(){
              return _SInReco2;
         }
        public void setSInReco2(int newValue){
              _SInReco2 = newValue;
         }
        private String _SInRecoOth2 = "";
        public String getSInRecoOth2(){
              return _SInRecoOth2;
         }
        public void setSInRecoOth2(String newValue){
              _SInRecoOth2 = newValue;
         }
        private String _SAboIll = "";
        public String getSAboIll(){
              return _SAboIll;
         }
        public void setSAboIll(String newValue){
              _SAboIll = newValue;
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

        String TableName = "EmergencyOperation ";

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
                 SQL = "Insert into "+ TableName +" (UNCode,StructureNo,HouseholdSl,VisitNo,MemSl,SAbd,OperNo,SDtHos,SHosM,SIlBeHosAdm,SurSympt,SurSymptOth,SurSympt2,SurSymptOth2,SurSympt3,SurSymptOth3,SurSympt4,SurSymptOth4,SurSympt5,SurSymptOth5,SurSympt6,SurSymptOth6,SurSympt7,SurSymptOth7,SDurFever,SPHosNam,SPHosOth,SDisDr,SDisDrOth,SReco,SDurReco,SInReco,SInRecoOth,SInReco2,SInRecoOth2,SAboIll,StartTime,EndTime,DeviceID,EntryUser,Lat,Lon,EnDt,Upload,modifyDate)Values('"+ _UNCode +"', '"+ _StructureNo +"', '"+ _HouseholdSl +"', '"+ _VisitNo +"', '"+ _MemSl +"', '"+ _SAbd +"', '"+ _OperNo +"', '"+ _SDtHos +"', '"+ _SHosM +"', '"+ _SIlBeHosAdm +"', '"+ _SurSympt +"', '"+ _SurSymptOth +"', '"+ _SurSympt2 +"', '"+ _SurSymptOth2 +"', '"+ _SurSympt3 +"', '"+ _SurSymptOth3 +"', '"+ _SurSympt4 +"', '"+ _SurSymptOth4 +"', '"+ _SurSympt5 +"', '"+ _SurSymptOth5 +"', '"+ _SurSympt6 +"', '"+ _SurSymptOth6 +"', '"+ _SurSympt7 +"', '"+ _SurSymptOth7 +"', '"+ _SDurFever +"', '"+ _SPHosNam +"', '"+ _SPHosOth +"', '"+ _SDisDr +"', '"+ _SDisDrOth +"', '"+ _SReco +"', '"+ _SDurReco +"', '"+ _SInReco +"', '"+ _SInRecoOth +"', '"+ _SInReco2 +"', '"+ _SInRecoOth2 +"', '"+ _SAboIll +"', '"+ _StartTime +"', '"+ _EndTime +"', '"+ _DeviceID +"', '"+ _EntryUser +"', '"+ _Lat +"', '"+ _Lon +"', '"+ _EnDt +"', '"+ _Upload +"', '"+ _modifyDate +"')";
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
                 SQL = "Update "+ TableName +" Set Upload='2',modifyDate='" + _modifyDate + "' ,UNCode = '"+ _UNCode +"',StructureNo = '"+ _StructureNo +"',HouseholdSl = '"+ _HouseholdSl +"',VisitNo = '"+ _VisitNo +"',MemSl = '"+ _MemSl +"',SAbd = '"+ _SAbd +"',OperNo = '"+ _OperNo +"',SDtHos = '"+ _SDtHos +"',SHosM = '"+ _SHosM +"',SIlBeHosAdm = '"+ _SIlBeHosAdm +"',SurSympt = '"+ _SurSympt +"',SurSymptOth = '"+ _SurSymptOth +"',SurSympt2 = '"+ _SurSympt2 +"',SurSymptOth2 = '"+ _SurSymptOth2 +"',SurSympt3 = '"+ _SurSympt3 +"',SurSymptOth3 = '"+ _SurSymptOth3 +"',SurSympt4 = '"+ _SurSympt4 +"',SurSymptOth4 = '"+ _SurSymptOth4 +"',SurSympt5 = '"+ _SurSympt5 +"',SurSymptOth5 = '"+ _SurSymptOth5 +"',SurSympt6 = '"+ _SurSympt6 +"',SurSymptOth6 = '"+ _SurSymptOth6 +"',SurSympt7 = '"+ _SurSympt7 +"',SurSymptOth7 = '"+ _SurSymptOth7 +"',SDurFever = '"+ _SDurFever +"',SPHosNam = '"+ _SPHosNam +"',SPHosOth = '"+ _SPHosOth +"',SDisDr = '"+ _SDisDr +"',SDisDrOth = '"+ _SDisDrOth +"',SReco = '"+ _SReco +"',SDurReco = '"+ _SDurReco +"',SInReco = '"+ _SInReco +"',SInRecoOth = '"+ _SInRecoOth +"',SInReco2 = '"+ _SInReco2 +"',SInRecoOth2 = '"+ _SInRecoOth2 +"',SAboIll = '"+ _SAboIll +"'  Where UNCode='"+ _UNCode +"' and StructureNo='"+ _StructureNo +"' and HouseholdSl='"+ _HouseholdSl +"' and VisitNo='"+ _VisitNo +"' and MemSl='"+ _MemSl +"'";
                 response = C.SaveData(SQL);
                 C.close();
              }
              catch(Exception  e)
              {
                 response = e.getMessage();
              }
           return response;
        }


        public List<EmergencyOperation_DataModel> SelectAll(Context context, String SQL)
        {
            Connection C = new Connection(context);
            List<EmergencyOperation_DataModel> data = new ArrayList<EmergencyOperation_DataModel>();
            EmergencyOperation_DataModel d = new EmergencyOperation_DataModel();
            Cursor cur = C.ReadData(SQL);

            cur.moveToFirst();
            while(!cur.isAfterLast())
            {
                d = new EmergencyOperation_DataModel();
                d._UNCode = cur.getString(cur.getColumnIndex("UNCode"));
                d._StructureNo = cur.getString(cur.getColumnIndex("StructureNo"));
                d._HouseholdSl = cur.getString(cur.getColumnIndex("HouseholdSl"));
                d._VisitNo = cur.getString(cur.getColumnIndex("VisitNo"));
                d._MemSl = cur.getString(cur.getColumnIndex("MemSl"));
                d._SAbd = Integer.valueOf(cur.getString(cur.getColumnIndex("SAbd")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("SAbd")));
                d._OperNo = Integer.valueOf(cur.getString(cur.getColumnIndex("OperNo")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("OperNo")));
                d._SDtHos = cur.getString(cur.getColumnIndex("SDtHos"));
                d._SHosM = Integer.valueOf(cur.getString(cur.getColumnIndex("SHosM")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("SHosM")));
                d._SIlBeHosAdm = Integer.valueOf(cur.getString(cur.getColumnIndex("SIlBeHosAdm")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("SIlBeHosAdm")));
                d._SurSympt = Integer.valueOf(cur.getString(cur.getColumnIndex("SurSympt")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("SurSympt")));
                d._SurSymptOth = cur.getString(cur.getColumnIndex("SurSymptOth"));
                d._SurSympt2 = Integer.valueOf(cur.getString(cur.getColumnIndex("SurSympt2")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("SurSympt2")));
                d._SurSymptOth2 = cur.getString(cur.getColumnIndex("SurSymptOth2"));
                d._SurSympt3 = Integer.valueOf(cur.getString(cur.getColumnIndex("SurSympt3")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("SurSympt3")));
                d._SurSymptOth3 = cur.getString(cur.getColumnIndex("SurSymptOth3"));
                d._SurSympt4 = Integer.valueOf(cur.getString(cur.getColumnIndex("SurSympt4")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("SurSympt4")));
                d._SurSymptOth4 = cur.getString(cur.getColumnIndex("SurSymptOth4"));
                d._SurSympt5 = Integer.valueOf(cur.getString(cur.getColumnIndex("SurSympt5")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("SurSympt5")));
                d._SurSymptOth5 = cur.getString(cur.getColumnIndex("SurSymptOth5"));
                d._SurSympt6 = Integer.valueOf(cur.getString(cur.getColumnIndex("SurSympt6")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("SurSympt6")));
                d._SurSymptOth6 = cur.getString(cur.getColumnIndex("SurSymptOth6"));
                d._SurSympt7 = Integer.valueOf(cur.getString(cur.getColumnIndex("SurSympt7")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("SurSympt7")));
                d._SurSymptOth7 = cur.getString(cur.getColumnIndex("SurSymptOth7"));
                d._SDurFever = Integer.valueOf(cur.getString(cur.getColumnIndex("SDurFever")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("SDurFever")));
                d._SPHosNam = Integer.valueOf(cur.getString(cur.getColumnIndex("SPHosNam")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("SPHosNam")));
                d._SPHosOth = cur.getString(cur.getColumnIndex("SPHosOth"));
                d._SDisDr = Integer.valueOf(cur.getString(cur.getColumnIndex("SDisDr")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("SDisDr")));
                d._SDisDrOth = cur.getString(cur.getColumnIndex("SDisDrOth"));
                d._SReco = Integer.valueOf(cur.getString(cur.getColumnIndex("SReco")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("SReco")));
                d._SDurReco = Integer.valueOf(cur.getString(cur.getColumnIndex("SDurReco")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("SDurReco")));
                d._SInReco = Integer.valueOf(cur.getString(cur.getColumnIndex("SInReco")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("SInReco")));
                d._SInRecoOth = cur.getString(cur.getColumnIndex("SInRecoOth"));
                d._SInReco2 = Integer.valueOf(cur.getString(cur.getColumnIndex("SInReco2")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("SInReco2")));
                d._SInRecoOth2 = cur.getString(cur.getColumnIndex("SInRecoOth2"));
                d._SAboIll = cur.getString(cur.getColumnIndex("SAboIll"));
                data.add(d);

                cur.moveToNext();
            }
            cur.close();
          return data;
        }
 }