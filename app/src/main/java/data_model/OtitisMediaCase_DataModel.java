package data_model;
 import android.content.Context;
 import android.database.Cursor;
 import Common.Connection;
 import java.util.ArrayList;
 import java.util.List;
 import java.util.Date;
 public class OtitisMediaCase_DataModel{

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
        private int _OMEDis = 0;
        public int getOMEDis(){
              return _OMEDis;
         }
        public void setOMEDis(int newValue){
              _OMEDis = newValue;
         }
        private int _OMEDisEpi = 0;
        public int getOMEDisEpi(){
              return _OMEDisEpi;
         }
        public void setOMEDisEpi(int newValue){
              _OMEDisEpi = newValue;
         }
        private int _OMHCar = 0;
        public int getOMHCar(){
              return _OMHCar;
         }
        public void setOMHCar(int newValue){
              _OMHCar = newValue;
         }
        private int _OMHC_PhyMBBS = 0;
        public int getOMHC_PhyMBBS(){
              return _OMHC_PhyMBBS;
         }
        public void setOMHC_PhyMBBS(int newValue){
              _OMHC_PhyMBBS = newValue;
         }
        private int _OMHC_UnquaDoctor = 0;
        public int getOMHC_UnquaDoctor(){
              return _OMHC_UnquaDoctor;
         }
        public void setOMHC_UnquaDoctor(int newValue){
              _OMHC_UnquaDoctor = newValue;
         }
        private int _OMHC_Para = 0;
        public int getOMHC_Para(){
              return _OMHC_Para;
         }
        public void setOMHC_Para(int newValue){
              _OMHC_Para = newValue;
         }
        private int _OMHC_Com = 0;
        public int getOMHC_Com(){
              return _OMHC_Com;
         }
        public void setOMHC_Com(int newValue){
              _OMHC_Com = newValue;
         }
        private int _OMHC_Pha = 0;
        public int getOMHC_Pha(){
              return _OMHC_Pha;
         }
        public void setOMHC_Pha(int newValue){
              _OMHC_Pha = newValue;
         }
        private int _OMHC_Hompath = 0;
        public int getOMHC_Hompath(){
              return _OMHC_Hompath;
         }
        public void setOMHC_Hompath(int newValue){
              _OMHC_Hompath = newValue;
         }
        private int _OMHC_TrHeal = 0;
        public int getOMHC_TrHeal(){
              return _OMHC_TrHeal;
         }
        public void setOMHC_TrHeal(int newValue){
              _OMHC_TrHeal = newValue;
         }
        private int _OMHC_SpiHeal = 0;
        public int getOMHC_SpiHeal(){
              return _OMHC_SpiHeal;
         }
        public void setOMHC_SpiHeal(int newValue){
              _OMHC_SpiHeal = newValue;
         }
        private int _OMHC_Oth = 0;
        public int getOMHC_Oth(){
              return _OMHC_Oth;
         }
        public void setOMHC_Oth(int newValue){
              _OMHC_Oth = newValue;
         }
        private String _OMHC_OthName = "";
        public String getOMHC_OthName(){
              return _OMHC_OthName;
         }
        public void setOMHC_OthName(String newValue){
              _OMHC_OthName = newValue;
         }
        private int _OMDSHOPD = 0;
        public int getOMDSHOPD(){
              return _OMDSHOPD;
         }
        public void setOMDSHOPD(int newValue){
              _OMDSHOPD = newValue;
         }
        private int _OMSSFOPD = 0;
        public int getOMSSFOPD(){
              return _OMSSFOPD;
         }
        public void setOMSSFOPD(int newValue){
              _OMSSFOPD = newValue;
         }
        private int _OMReco = 0;
        public int getOMReco(){
              return _OMReco;
         }
        public void setOMReco(int newValue){
              _OMReco = newValue;
         }
        private int _OMDurReco = 0;
        public int getOMDurReco(){
              return _OMDurReco;
         }
        public void setOMDurReco(int newValue){
              _OMDurReco = newValue;
         }
        private int _OMInReco = 0;
        public int getOMInReco(){
              return _OMInReco;
         }
        public void setOMInReco(int newValue){
              _OMInReco = newValue;
         }
        private String _OMInRecoOth = "";
        public String getOMInRecoOth(){
              return _OMInRecoOth;
         }
        public void setOMInRecoOth(String newValue){
              _OMInRecoOth = newValue;
         }
        private int _OMInReco2 = 0;
        public int getOMInReco2(){
              return _OMInReco2;
         }
        public void setOMInReco2(int newValue){
              _OMInReco2 = newValue;
         }
        private String _OMInRecoOth2 = "";
        public String getOMInRecoOth2(){
              return _OMInRecoOth2;
         }
        public void setOMInRecoOth2(String newValue){
              _OMInRecoOth2 = newValue;
         }
        private String _OMAboIll = "";
        public String getOMAboIll(){
              return _OMAboIll;
         }
        public void setOMAboIll(String newValue){
              _OMAboIll = newValue;
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

        String TableName = "OtitisMediaCase ";

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
                 SQL = "Insert into "+ TableName +" (UNCode,StructureNo,HouseholdSl,VisitNo,MemSl,OMEDis,OMEDisEpi,OMHCar,OMHC_PhyMBBS,OMHC_UnquaDoctor,OMHC_Para,OMHC_Com,OMHC_Pha,OMHC_Hompath,OMHC_TrHeal,OMHC_SpiHeal,OMHC_Oth,OMHC_OthName,OMDSHOPD,OMSSFOPD,OMReco,OMDurReco,OMInReco,OMInRecoOth,OMInReco2,OMInRecoOth2,OMAboIll,StartTime,EndTime,DeviceID,EntryUser,Lat,Lon,EnDt,Upload,modifyDate)Values('"+ _UNCode +"', '"+ _StructureNo +"', '"+ _HouseholdSl +"', '"+ _VisitNo +"', '"+ _MemSl +"', '"+ _OMEDis +"', '"+ _OMEDisEpi +"', '"+ _OMHCar +"', '"+ _OMHC_PhyMBBS +"', '"+ _OMHC_UnquaDoctor +"', '"+ _OMHC_Para +"', '"+ _OMHC_Com +"', '"+ _OMHC_Pha +"', '"+ _OMHC_Hompath +"', '"+ _OMHC_TrHeal +"', '"+ _OMHC_SpiHeal +"', '"+ _OMHC_Oth +"', '"+ _OMHC_OthName +"', '"+ _OMDSHOPD +"', '"+ _OMSSFOPD +"', '"+ _OMReco +"', '"+ _OMDurReco +"', '"+ _OMInReco +"', '"+ _OMInRecoOth +"', '"+ _OMInReco2 +"', '"+ _OMInRecoOth2 +"', '"+ _OMAboIll +"', '"+ _StartTime +"', '"+ _EndTime +"', '"+ _DeviceID +"', '"+ _EntryUser +"', '"+ _Lat +"', '"+ _Lon +"', '"+ _EnDt +"', '"+ _Upload +"', '"+ _modifyDate +"')";
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
                 SQL = "Update "+ TableName +" Set Upload='2',modifyDate='" + _modifyDate + "' ,UNCode = '"+ _UNCode +"',StructureNo = '"+ _StructureNo +"',HouseholdSl = '"+ _HouseholdSl +"',VisitNo = '"+ _VisitNo +"',MemSl = '"+ _MemSl +"',OMEDis = '"+ _OMEDis +"',OMEDisEpi = '"+ _OMEDisEpi +"',OMHCar = '"+ _OMHCar +"',OMHC_PhyMBBS = '"+ _OMHC_PhyMBBS +"',OMHC_UnquaDoctor = '"+ _OMHC_UnquaDoctor +"',OMHC_Para = '"+ _OMHC_Para +"',OMHC_Com = '"+ _OMHC_Com +"',OMHC_Pha = '"+ _OMHC_Pha +"',OMHC_Hompath = '"+ _OMHC_Hompath +"',OMHC_TrHeal = '"+ _OMHC_TrHeal +"',OMHC_SpiHeal = '"+ _OMHC_SpiHeal +"',OMHC_Oth = '"+ _OMHC_Oth +"',OMHC_OthName = '"+ _OMHC_OthName +"',OMDSHOPD = '"+ _OMDSHOPD +"',OMSSFOPD = '"+ _OMSSFOPD +"',OMReco = '"+ _OMReco +"',OMDurReco = '"+ _OMDurReco +"',OMInReco = '"+ _OMInReco +"',OMInRecoOth = '"+ _OMInRecoOth +"',OMInReco2 = '"+ _OMInReco2 +"',OMInRecoOth2 = '"+ _OMInRecoOth2 +"',OMAboIll = '"+ _OMAboIll +"'  Where UNCode='"+ _UNCode +"' and StructureNo='"+ _StructureNo +"' and HouseholdSl='"+ _HouseholdSl +"' and VisitNo='"+ _VisitNo +"' and MemSl='"+ _MemSl +"'";
                 response = C.SaveData(SQL);
                 C.close();
              }
              catch(Exception  e)
              {
                 response = e.getMessage();
              }
           return response;
        }


        public List<OtitisMediaCase_DataModel> SelectAll(Context context, String SQL)
        {
            Connection C = new Connection(context);
            List<OtitisMediaCase_DataModel> data = new ArrayList<OtitisMediaCase_DataModel>();
            OtitisMediaCase_DataModel d = new OtitisMediaCase_DataModel();
            Cursor cur = C.ReadData(SQL);

            cur.moveToFirst();
            while(!cur.isAfterLast())
            {
                d = new OtitisMediaCase_DataModel();
                d._UNCode = cur.getString(cur.getColumnIndex("UNCode"));
                d._StructureNo = cur.getString(cur.getColumnIndex("StructureNo"));
                d._HouseholdSl = cur.getString(cur.getColumnIndex("HouseholdSl"));
                d._VisitNo = cur.getString(cur.getColumnIndex("VisitNo"));
                d._MemSl = cur.getString(cur.getColumnIndex("MemSl"));
                d._OMEDis = Integer.valueOf(cur.getString(cur.getColumnIndex("OMEDis")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("OMEDis")));
                d._OMEDisEpi = Integer.valueOf(cur.getString(cur.getColumnIndex("OMEDisEpi")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("OMEDisEpi")));
                d._OMHCar = Integer.valueOf(cur.getString(cur.getColumnIndex("OMHCar")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("OMHCar")));
                d._OMHC_PhyMBBS = Integer.valueOf(cur.getString(cur.getColumnIndex("OMHC_PhyMBBS")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("OMHC_PhyMBBS")));
                d._OMHC_UnquaDoctor = Integer.valueOf(cur.getString(cur.getColumnIndex("OMHC_UnquaDoctor")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("OMHC_UnquaDoctor")));
                d._OMHC_Para = Integer.valueOf(cur.getString(cur.getColumnIndex("OMHC_Para")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("OMHC_Para")));
                d._OMHC_Com = Integer.valueOf(cur.getString(cur.getColumnIndex("OMHC_Com")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("OMHC_Com")));
                d._OMHC_Pha = Integer.valueOf(cur.getString(cur.getColumnIndex("OMHC_Pha")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("OMHC_Pha")));
                d._OMHC_Hompath = Integer.valueOf(cur.getString(cur.getColumnIndex("OMHC_Hompath")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("OMHC_Hompath")));
                d._OMHC_TrHeal = Integer.valueOf(cur.getString(cur.getColumnIndex("OMHC_TrHeal")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("OMHC_TrHeal")));
                d._OMHC_SpiHeal = Integer.valueOf(cur.getString(cur.getColumnIndex("OMHC_SpiHeal")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("OMHC_SpiHeal")));
                d._OMHC_Oth = Integer.valueOf(cur.getString(cur.getColumnIndex("OMHC_Oth")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("OMHC_Oth")));
                d._OMHC_OthName = cur.getString(cur.getColumnIndex("OMHC_OthName"));
                d._OMDSHOPD = Integer.valueOf(cur.getString(cur.getColumnIndex("OMDSHOPD")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("OMDSHOPD")));
                d._OMSSFOPD = Integer.valueOf(cur.getString(cur.getColumnIndex("OMSSFOPD")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("OMSSFOPD")));
                d._OMReco = Integer.valueOf(cur.getString(cur.getColumnIndex("OMReco")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("OMReco")));
                d._OMDurReco = Integer.valueOf(cur.getString(cur.getColumnIndex("OMDurReco")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("OMDurReco")));
                d._OMInReco = Integer.valueOf(cur.getString(cur.getColumnIndex("OMInReco")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("OMInReco")));
                d._OMInRecoOth = cur.getString(cur.getColumnIndex("OMInRecoOth"));
                d._OMInReco2 = Integer.valueOf(cur.getString(cur.getColumnIndex("OMInReco2")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("OMInReco2")));
                d._OMInRecoOth2 = cur.getString(cur.getColumnIndex("OMInRecoOth2"));
                d._OMAboIll = cur.getString(cur.getColumnIndex("OMAboIll"));
                data.add(d);

                cur.moveToNext();
            }
            cur.close();
          return data;
        }
 }