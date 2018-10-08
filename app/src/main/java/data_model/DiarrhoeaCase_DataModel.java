package data_model;

import android.content.Context;
 import android.database.Cursor;
 import Common.Connection;
 import java.util.ArrayList;
 import java.util.List;
 import java.util.Date;
 public class DiarrhoeaCase_DataModel{

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
        private int _DWatStool = 0;
        public int getDWatStool(){
              return _DWatStool;
         }
        public void setDWatStool(int newValue){
              _DWatStool = newValue;
         }
        private int _DDisEpi = 0;
        public int getDDisEpi(){
              return _DDisEpi;
         }
        public void setDDisEpi(int newValue){
              _DDisEpi = newValue;
         }
        private int _StoolBlood = 0;
        public int getStoolBlood(){
              return _StoolBlood;
         }
        public void setStoolBlood(int newValue){
              _StoolBlood = newValue;
         }
        private int _FeedORS = 0;
        public int getFeedORS(){
              return _FeedORS;
         }
        public void setFeedORS(int newValue){
              _FeedORS = newValue;
         }
        private int _DHCar = 0;
        public int getDHCar(){
              return _DHCar;
         }
        public void setDHCar(int newValue){
              _DHCar = newValue;
         }
        private int _ORSBefHCar = 0;
        public int getORSBefHCar(){
              return _ORSBefHCar;
         }
        public void setORSBefHCar(int newValue){
              _ORSBefHCar = newValue;
         }
        private int _DHC_PhyMBBS = 0;
        public int getDHC_PhyMBBS(){
              return _DHC_PhyMBBS;
         }
        public void setDHC_PhyMBBS(int newValue){
              _DHC_PhyMBBS = newValue;
         }
        private int _DHC_UnquaDoctor = 0;
        public int getDHC_UnquaDoctor(){
              return _DHC_UnquaDoctor;
         }
        public void setDHC_UnquaDoctor(int newValue){
              _DHC_UnquaDoctor = newValue;
         }
        private int _DHC_Para = 0;
        public int getDHC_Para(){
              return _DHC_Para;
         }
        public void setDHC_Para(int newValue){
              _DHC_Para = newValue;
         }
        private int _DHC_Com = 0;
        public int getDHC_Com(){
              return _DHC_Com;
         }
        public void setDHC_Com(int newValue){
              _DHC_Com = newValue;
         }
        private int _DHC_Pha = 0;
        public int getDHC_Pha(){
              return _DHC_Pha;
         }
        public void setDHC_Pha(int newValue){
              _DHC_Pha = newValue;
         }
        private int _DHC_Hompath = 0;
        public int getDHC_Hompath(){
              return _DHC_Hompath;
         }
        public void setDHC_Hompath(int newValue){
              _DHC_Hompath = newValue;
         }
        private int _DHC_TrHeal = 0;
        public int getDHC_TrHeal(){
              return _DHC_TrHeal;
         }
        public void setDHC_TrHeal(int newValue){
              _DHC_TrHeal = newValue;
         }
        private int _DHC_SpiHeal = 0;
        public int getDHC_SpiHeal(){
              return _DHC_SpiHeal;
         }
        public void setDHC_SpiHeal(int newValue){
              _DHC_SpiHeal = newValue;
         }
        private int _DHC_Oth = 0;
        public int getDHC_Oth(){
              return _DHC_Oth;
         }
        public void setDHC_Oth(int newValue){
              _DHC_Oth = newValue;
         }
        private String _DHC_OthName = "";
        public String getDHC_OthName(){
              return _DHC_OthName;
         }
        public void setDHC_OthName(String newValue){
              _DHC_OthName = newValue;
         }
        private int _DDSHOPD = 0;
        public int getDDSHOPD(){
              return _DDSHOPD;
         }
        public void setDDSHOPD(int newValue){
              _DDSHOPD = newValue;
         }
        private int _DSSFOPD = 0;
        public int getDSSFOPD(){
              return _DSSFOPD;
         }
        public void setDSSFOPD(int newValue){
              _DSSFOPD = newValue;
         }
        private int _DAdmHos = 0;
        public int getDAdmHos(){
              return _DAdmHos;
         }
        public void setDAdmHos(int newValue){
              _DAdmHos = newValue;
         }
        private int _DIlBeHosAdm = 0;
        public int getDIlBeHosAdm(){
              return _DIlBeHosAdm;
         }
        public void setDIlBeHosAdm(int newValue){
              _DIlBeHosAdm = newValue;
         }
        private int _DHosNam = 0;
        public int getDHosNam(){
              return _DHosNam;
         }
        public void setDHosNam(int newValue){
              _DHosNam = newValue;
         }
        private String _DHosNamOth = "";
        public String getDHosNamOth(){
              return _DHosNamOth;
         }
        public void setDHosNamOth(String newValue){
              _DHosNamOth = newValue;
         }
        private int _DHosNam2 = 0;
        public int getDHosNam2(){
              return _DHosNam2;
         }
        public void setDHosNam2(int newValue){
              _DHosNam2 = newValue;
         }
        private String _DHosNamOth2 = "";
        public String getDHosNamOth2(){
              return _DHosNamOth2;
         }
        public void setDHosNamOth2(String newValue){
              _DHosNamOth2 = newValue;
         }
        private int _DHosNam3 = 0;
        public int getDHosNam3(){
              return _DHosNam3;
         }
        public void setDHosNam3(int newValue){
              _DHosNam3 = newValue;
         }
        private String _DHosNamOth3 = "";
        public String getDHosNamOth3(){
              return _DHosNamOth3;
         }
        public void setDHosNamOth3(String newValue){
              _DHosNamOth3 = newValue;
         }
        private int _DReco = 0;
        public int getDReco(){
              return _DReco;
         }
        public void setDReco(int newValue){
              _DReco = newValue;
         }
        private int _DDurReco = 0;
        public int getDDurReco(){
              return _DDurReco;
         }
        public void setDDurReco(int newValue){
              _DDurReco = newValue;
         }
        private int _DInReco = 0;
        public int getDInReco(){
              return _DInReco;
         }
        public void setDInReco(int newValue){
              _DInReco = newValue;
         }
        private String _DInRecoOth = "";
        public String getDInRecoOth(){
              return _DInRecoOth;
         }
        public void setDInRecoOth(String newValue){
              _DInRecoOth = newValue;
         }
        private String _DAboIll = "";
        public String getDAboIll(){
              return _DAboIll;
         }
        public void setDAboIll(String newValue){
              _DAboIll = newValue;
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

        String TableName = "DiarrhoeaCase ";

        public String SaveUpdateData(Context context)
        {
            String response = "";
            C = new Connection(context);
            String SQL = "";
            try
            {
                 if(C.Existence("Select * from "+ TableName +"  Where UNCode='"+ _UNCode +"' and StructureNo='"+ _StructureNo +"' and HouseholdSl='"+ _HouseholdSl +"' and VisitNo='"+ _VisitNo +"' and MemSl='"+ _MemSl +"' and DeviceID='"+_DeviceID+"'"))
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
                 SQL = "Insert into "+ TableName +" (UNCode,StructureNo,HouseholdSl,VisitNo,MemSl,DWatStool,DDisEpi,StoolBlood,FeedORS,DHCar,ORSBefHCar,DHC_PhyMBBS,DHC_UnquaDoctor,DHC_Para,DHC_Com,DHC_Pha,DHC_Hompath,DHC_TrHeal,DHC_SpiHeal,DHC_Oth,DHC_OthName,DDSHOPD,DSSFOPD,DAdmHos,DIlBeHosAdm,DHosNam,DHosNamOth,DHosNam2,DHosNamOth2,DHosNam3,DHosNamOth3,DReco,DDurReco,DInReco,DInRecoOth,DAboIll,StartTime,EndTime,DeviceID,EntryUser,Lat,Lon,EnDt,Upload,modifyDate)Values('"+ _UNCode +"', '"+ _StructureNo +"', '"+ _HouseholdSl +"', '"+ _VisitNo +"', '"+ _MemSl +"', '"+ _DWatStool +"', '"+ _DDisEpi +"', '"+ _StoolBlood +"', '"+ _FeedORS +"', '"+ _DHCar +"', '"+ _ORSBefHCar +"', '"+ _DHC_PhyMBBS +"', '"+ _DHC_UnquaDoctor +"', '"+ _DHC_Para +"', '"+ _DHC_Com +"', '"+ _DHC_Pha +"', '"+ _DHC_Hompath +"', '"+ _DHC_TrHeal +"', '"+ _DHC_SpiHeal +"', '"+ _DHC_Oth +"', '"+ _DHC_OthName +"', '"+ _DDSHOPD +"', '"+ _DSSFOPD +"', '"+ _DAdmHos +"', '"+ _DIlBeHosAdm +"', '"+ _DHosNam +"', '"+ _DHosNamOth +"', '"+ _DHosNam2 +"', '"+ _DHosNamOth2 +"', '"+ _DHosNam3 +"', '"+ _DHosNamOth3 +"', '"+ _DReco +"', '"+ _DDurReco +"', '"+ _DInReco +"', '"+ _DInRecoOth +"', '"+ _DAboIll +"', '"+ _StartTime +"', '"+ _EndTime +"', '"+ _DeviceID +"', '"+ _EntryUser +"', '"+ _Lat +"', '"+ _Lon +"', '"+ _EnDt +"', '"+ _Upload +"', '"+ _modifyDate +"')";
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
                 SQL = "Update "+ TableName +" Set Upload='2',modifyDate='" + _modifyDate + "' ,UNCode = '"+ _UNCode +"',StructureNo = '"+ _StructureNo +"',HouseholdSl = '"+ _HouseholdSl +"',VisitNo = '"+ _VisitNo +"',MemSl = '"+ _MemSl +"',DWatStool = '"+ _DWatStool +"',DDisEpi = '"+ _DDisEpi +"',StoolBlood = '"+ _StoolBlood +"',FeedORS = '"+ _FeedORS +"',DHCar = '"+ _DHCar +"',ORSBefHCar = '"+ _ORSBefHCar +"',DHC_PhyMBBS = '"+ _DHC_PhyMBBS +"',DHC_UnquaDoctor = '"+ _DHC_UnquaDoctor +"',DHC_Para = '"+ _DHC_Para +"',DHC_Com = '"+ _DHC_Com +"',DHC_Pha = '"+ _DHC_Pha +"',DHC_Hompath = '"+ _DHC_Hompath +"',DHC_TrHeal = '"+ _DHC_TrHeal +"',DHC_SpiHeal = '"+ _DHC_SpiHeal +"',DHC_Oth = '"+ _DHC_Oth +"',DHC_OthName = '"+ _DHC_OthName +"',DDSHOPD = '"+ _DDSHOPD +"',DSSFOPD = '"+ _DSSFOPD +"',DAdmHos = '"+ _DAdmHos +"',DIlBeHosAdm = '"+ _DIlBeHosAdm +"',DHosNam = '"+ _DHosNam +"',DHosNamOth = '"+ _DHosNamOth +"',DHosNam2 = '"+ _DHosNam2 +"',DHosNamOth2 = '"+ _DHosNamOth2 +"',DHosNam3 = '"+ _DHosNam3 +"',DHosNamOth3 = '"+ _DHosNamOth3 +"',DReco = '"+ _DReco +"',DDurReco = '"+ _DDurReco +"',DInReco = '"+ _DInReco +"',DInRecoOth = '"+ _DInRecoOth +"',DAboIll = '"+ _DAboIll +"'  Where UNCode='"+ _UNCode +"' and StructureNo='"+ _StructureNo +"' and HouseholdSl='"+ _HouseholdSl +"' and VisitNo='"+ _VisitNo +"' and MemSl='"+ _MemSl +"' and DeviceID='"+_DeviceID+"'";
                 response = C.SaveData(SQL);
                 C.close();
              }
              catch(Exception  e)
              {
                 response = e.getMessage();
              }
           return response;
        }


        public List<DiarrhoeaCase_DataModel> SelectAll(Context context, String SQL)
        {
            Connection C = new Connection(context);
            List<DiarrhoeaCase_DataModel> data = new ArrayList<DiarrhoeaCase_DataModel>();
            DiarrhoeaCase_DataModel d = new DiarrhoeaCase_DataModel();
            Cursor cur = C.ReadData(SQL);

            cur.moveToFirst();
            while(!cur.isAfterLast())
            {
                d = new DiarrhoeaCase_DataModel();
                d._UNCode = cur.getString(cur.getColumnIndex("UNCode"));
                d._StructureNo = cur.getString(cur.getColumnIndex("StructureNo"));
                d._HouseholdSl = cur.getString(cur.getColumnIndex("HouseholdSl"));
                d._VisitNo = cur.getString(cur.getColumnIndex("VisitNo"));
                d._MemSl = cur.getString(cur.getColumnIndex("MemSl"));
                d._DWatStool = Integer.valueOf(cur.getString(cur.getColumnIndex("DWatStool")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("DWatStool")));
                d._DDisEpi = Integer.valueOf(cur.getString(cur.getColumnIndex("DDisEpi")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("DDisEpi")));
                d._StoolBlood = Integer.valueOf(cur.getString(cur.getColumnIndex("StoolBlood")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("StoolBlood")));
                d._FeedORS = Integer.valueOf(cur.getString(cur.getColumnIndex("FeedORS")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("FeedORS")));
                d._DHCar = Integer.valueOf(cur.getString(cur.getColumnIndex("DHCar")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("DHCar")));
                d._ORSBefHCar = Integer.valueOf(cur.getString(cur.getColumnIndex("ORSBefHCar")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("ORSBefHCar")));
                d._DHC_PhyMBBS = Integer.valueOf(cur.getString(cur.getColumnIndex("DHC_PhyMBBS")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("DHC_PhyMBBS")));
                d._DHC_UnquaDoctor = Integer.valueOf(cur.getString(cur.getColumnIndex("DHC_UnquaDoctor")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("DHC_UnquaDoctor")));
                d._DHC_Para = Integer.valueOf(cur.getString(cur.getColumnIndex("DHC_Para")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("DHC_Para")));
                d._DHC_Com = Integer.valueOf(cur.getString(cur.getColumnIndex("DHC_Com")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("DHC_Com")));
                d._DHC_Pha = Integer.valueOf(cur.getString(cur.getColumnIndex("DHC_Pha")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("DHC_Pha")));
                d._DHC_Hompath = Integer.valueOf(cur.getString(cur.getColumnIndex("DHC_Hompath")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("DHC_Hompath")));
                d._DHC_TrHeal = Integer.valueOf(cur.getString(cur.getColumnIndex("DHC_TrHeal")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("DHC_TrHeal")));
                d._DHC_SpiHeal = Integer.valueOf(cur.getString(cur.getColumnIndex("DHC_SpiHeal")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("DHC_SpiHeal")));
                d._DHC_Oth = Integer.valueOf(cur.getString(cur.getColumnIndex("DHC_Oth")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("DHC_Oth")));
                d._DHC_OthName = cur.getString(cur.getColumnIndex("DHC_OthName"));
                d._DDSHOPD = Integer.valueOf(cur.getString(cur.getColumnIndex("DDSHOPD")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("DDSHOPD")));
                d._DSSFOPD = Integer.valueOf(cur.getString(cur.getColumnIndex("DSSFOPD")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("DSSFOPD")));
                d._DAdmHos = Integer.valueOf(cur.getString(cur.getColumnIndex("DAdmHos")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("DAdmHos")));
                d._DIlBeHosAdm = Integer.valueOf(cur.getString(cur.getColumnIndex("DIlBeHosAdm")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("DIlBeHosAdm")));
                d._DHosNam = Integer.valueOf(cur.getString(cur.getColumnIndex("DHosNam")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("DHosNam")));
                d._DHosNamOth = cur.getString(cur.getColumnIndex("DHosNamOth"));
                d._DHosNam2 = Integer.valueOf(cur.getString(cur.getColumnIndex("DHosNam2")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("DHosNam2")));
                d._DHosNamOth2 = cur.getString(cur.getColumnIndex("DHosNamOth2"));
                d._DHosNam3 = Integer.valueOf(cur.getString(cur.getColumnIndex("DHosNam3")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("DHosNam3")));
                d._DHosNamOth3 = cur.getString(cur.getColumnIndex("DHosNamOth3"));
                d._DReco = Integer.valueOf(cur.getString(cur.getColumnIndex("DReco")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("DReco")));
                d._DDurReco = Integer.valueOf(cur.getString(cur.getColumnIndex("DDurReco")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("DDurReco")));
                d._DInReco = Integer.valueOf(cur.getString(cur.getColumnIndex("DInReco")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("DInReco")));
                d._DInRecoOth = cur.getString(cur.getColumnIndex("DInRecoOth"));
                d._DAboIll = cur.getString(cur.getColumnIndex("DAboIll"));
                data.add(d);

                cur.moveToNext();
            }
            cur.close();
          return data;
        }
 }