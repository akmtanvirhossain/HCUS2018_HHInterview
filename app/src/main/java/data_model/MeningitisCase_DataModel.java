package data_model;

import android.content.Context;
 import android.database.Cursor;
 import Common.Connection;
 import java.util.ArrayList;
 import java.util.List;
 import java.util.Date;
 public class MeningitisCase_DataModel{

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
        private int _SeriIlOnset = 0;
        public int getSeriIlOnset(){
              return _SeriIlOnset;
         }
        public void setSeriIlOnset(int newValue){
              _SeriIlOnset = newValue;
         }
        private int _SameIllSec2 = 0;
        public int getSameIllSec2(){
              return _SameIllSec2;
         }
        public void setSameIllSec2(int newValue){
              _SameIllSec2 = newValue;
         }
        private int _EpiSeriIlOnset = 0;
        public int getEpiSeriIlOnset(){
              return _EpiSeriIlOnset;
         }
        public void setEpiSeriIlOnset(int newValue){
              _EpiSeriIlOnset = newValue;
         }
        private int _IlnessFev = 0;
        public int getIlnessFev(){
              return _IlnessFev;
         }
        public void setIlnessFev(int newValue){
              _IlnessFev = newValue;
         }
        private int _IlnessConv = 0;
        public int getIlnessConv(){
              return _IlnessConv;
         }
        public void setIlnessConv(int newValue){
              _IlnessConv = newValue;
         }
        private int _UpRolEye = 0;
        public int getUpRolEye(){
              return _UpRolEye;
         }
        public void setUpRolEye(int newValue){
              _UpRolEye = newValue;
         }
        private int _MRigJaw = 0;
        public int getMRigJaw(){
              return _MRigJaw;
         }
        public void setMRigJaw(int newValue){
              _MRigJaw = newValue;
         }
        private int _MRigLimbs = 0;
        public int getMRigLimbs(){
              return _MRigLimbs;
         }
        public void setMRigLimbs(int newValue){
              _MRigLimbs = newValue;
         }
        private int _MDurConv = 0;
        public int getMDurConv(){
              return _MDurConv;
         }
        public void setMDurConv(int newValue){
              _MDurConv = newValue;
         }
        private int _MDrowsin = 0;
        public int getMDrowsin(){
              return _MDrowsin;
         }
        public void setMDrowsin(int newValue){
              _MDrowsin = newValue;
         }
        private int _MDurDrowsin = 0;
        public int getMDurDrowsin(){
              return _MDurDrowsin;
         }
        public void setMDurDrowsin(int newValue){
              _MDurDrowsin = newValue;
         }
        private int _MUntoFeed = 0;
        public int getMUntoFeed(){
              return _MUntoFeed;
         }
        public void setMUntoFeed(int newValue){
              _MUntoFeed = newValue;
         }
        private int _MDurUntoFeed = 0;
        public int getMDurUntoFeed(){
              return _MDurUntoFeed;
         }
        public void setMDurUntoFeed(int newValue){
              _MDurUntoFeed = newValue;
         }
        private int _MCalNoRes = 0;
        public int getMCalNoRes(){
              return _MCalNoRes;
         }
        public void setMCalNoRes(int newValue){
              _MCalNoRes = newValue;
         }
        private int _MDurCalNoRes = 0;
        public int getMDurCalNoRes(){
              return _MDurCalNoRes;
         }
        public void setMDurCalNoRes(int newValue){
              _MDurCalNoRes = newValue;
         }
        private int _MEverConf = 0;
        public int getMEverConf(){
              return _MEverConf;
         }
        public void setMEverConf(int newValue){
              _MEverConf = newValue;
         }
        private int _MDurEverConf = 0;
        public int getMDurEverConf(){
              return _MDurEverConf;
         }
        public void setMDurEverConf(int newValue){
              _MDurEverConf = newValue;
         }
        private int _MFlicker = 0;
        public int getMFlicker(){
              return _MFlicker;
         }
        public void setMFlicker(int newValue){
              _MFlicker = newValue;
         }
        private int _MDurFliker = 0;
        public int getMDurFliker(){
              return _MDurFliker;
         }
        public void setMDurFliker(int newValue){
              _MDurFliker = newValue;
         }
        private int _MUnconsci = 0;
        public int getMUnconsci(){
              return _MUnconsci;
         }
        public void setMUnconsci(int newValue){
              _MUnconsci = newValue;
         }
        private int _MDurUnconsci = 0;
        public int getMDurUnconsci(){
              return _MDurUnconsci;
         }
        public void setMDurUnconsci(int newValue){
              _MDurUnconsci = newValue;
         }
        private int _MIlCry = 0;
        public int getMIlCry(){
              return _MIlCry;
         }
        public void setMIlCry(int newValue){
              _MIlCry = newValue;
         }
        private int _MDurIlCry = 0;
        public int getMDurIlCry(){
              return _MDurIlCry;
         }
        public void setMDurIlCry(int newValue){
              _MDurIlCry = newValue;
         }
        private int _MUnCraWalk = 0;
        public int getMUnCraWalk(){
              return _MUnCraWalk;
         }
        public void setMUnCraWalk(int newValue){
              _MUnCraWalk = newValue;
         }
        private int _MDurUnCraWalk = 0;
        public int getMDurUnCraWalk(){
              return _MDurUnCraWalk;
         }
        public void setMDurUnCraWalk(int newValue){
              _MDurUnCraWalk = newValue;
         }
        private int _MDifBreath = 0;
        public int getMDifBreath(){
              return _MDifBreath;
         }
        public void setMDifBreath(int newValue){
              _MDifBreath = newValue;
         }
        private int _MCough = 0;
        public int getMCough(){
              return _MCough;
         }
        public void setMCough(int newValue){
              _MCough = newValue;
         }
        private int _MRash = 0;
        public int getMRash(){
              return _MRash;
         }
        public void setMRash(int newValue){
              _MRash = newValue;
         }
        private int _MVomit = 0;
        public int getMVomit(){
              return _MVomit;
         }
        public void setMVomit(int newValue){
              _MVomit = newValue;
         }
        private int _MDiarrhoea = 0;
        public int getMDiarrhoea(){
              return _MDiarrhoea;
         }
        public void setMDiarrhoea(int newValue){
              _MDiarrhoea = newValue;
         }
        private int _MHCar = 0;
        public int getMHCar(){
              return _MHCar;
         }
        public void setMHCar(int newValue){
              _MHCar = newValue;
         }
        private int _MHC_Phy = 0;
        public int getMHC_Phy(){
              return _MHC_Phy;
         }
        public void setMHC_Phy(int newValue){
              _MHC_Phy = newValue;
         }
        private int _MHC_UnquaDoctor = 0;
        public int getMHC_UnquaDoctor(){
              return _MHC_UnquaDoctor;
         }
        public void setMHC_UnquaDoctor(int newValue){
              _MHC_UnquaDoctor = newValue;
         }
        private int _MHC_Para = 0;
        public int getMHC_Para(){
              return _MHC_Para;
         }
        public void setMHC_Para(int newValue){
              _MHC_Para = newValue;
         }
        private int _MHC_Com = 0;
        public int getMHC_Com(){
              return _MHC_Com;
         }
        public void setMHC_Com(int newValue){
              _MHC_Com = newValue;
         }
        private int _MHC_Pha = 0;
        public int getMHC_Pha(){
              return _MHC_Pha;
         }
        public void setMHC_Pha(int newValue){
              _MHC_Pha = newValue;
         }
        private int _MHC_Hompath = 0;
        public int getMHC_Hompath(){
              return _MHC_Hompath;
         }
        public void setMHC_Hompath(int newValue){
              _MHC_Hompath = newValue;
         }
        private int _MHC_TrHeal = 0;
        public int getMHC_TrHeal(){
              return _MHC_TrHeal;
         }
        public void setMHC_TrHeal(int newValue){
              _MHC_TrHeal = newValue;
         }
        private int _MHC_SpiHeal = 0;
        public int getMHC_SpiHeal(){
              return _MHC_SpiHeal;
         }
        public void setMHC_SpiHeal(int newValue){
              _MHC_SpiHeal = newValue;
         }
        private int _MHC_Oth = 0;
        public int getMHC_Oth(){
              return _MHC_Oth;
         }
        public void setMHC_Oth(int newValue){
              _MHC_Oth = newValue;
         }
        private String _MHC_OthName = "";
        public String getMHC_OthName(){
              return _MHC_OthName;
         }
        public void setMHC_OthName(String newValue){
              _MHC_OthName = newValue;
         }
        private int _MDSHOPD = 0;
        public int getMDSHOPD(){
              return _MDSHOPD;
         }
        public void setMDSHOPD(int newValue){
              _MDSHOPD = newValue;
         }
        private int _MSSFOPD = 0;
        public int getMSSFOPD(){
              return _MSSFOPD;
         }
        public void setMSSFOPD(int newValue){
              _MSSFOPD = newValue;
         }
        private int _MHosAdm = 0;
        public int getMHosAdm(){
              return _MHosAdm;
         }
        public void setMHosAdm(int newValue){
              _MHosAdm = newValue;
         }
        private int _MHC_Hosp_a1 = 0;
        public int getMHC_Hosp_a1(){
              return _MHC_Hosp_a1;
         }
        public void setMHC_Hosp_a1(int newValue){
              _MHC_Hosp_a1 = newValue;
         }
        private String _MHC_Hosp_a1_Oth = "";
        public String getMHC_Hosp_a1_Oth(){
              return _MHC_Hosp_a1_Oth;
         }
        public void setMHC_Hosp_a1_Oth(String newValue){
              _MHC_Hosp_a1_Oth = newValue;
         }
        private int _MHC_Hosp_a2 = 0;
        public int getMHC_Hosp_a2(){
              return _MHC_Hosp_a2;
         }
        public void setMHC_Hosp_a2(int newValue){
              _MHC_Hosp_a2 = newValue;
         }
        private String _MHC_Hosp_a2_Oth = "";
        public String getMHC_Hosp_a2_Oth(){
              return _MHC_Hosp_a2_Oth;
         }
        public void setMHC_Hosp_a2_Oth(String newValue){
              _MHC_Hosp_a2_Oth = newValue;
         }
        private int _MHC_Hosp_a3 = 0;
        public int getMHC_Hosp_a3(){
              return _MHC_Hosp_a3;
         }
        public void setMHC_Hosp_a3(int newValue){
              _MHC_Hosp_a3 = newValue;
         }
        private String _MHC_Hosp_a3_Oth = "";
        public String getMHC_Hosp_a3_Oth(){
              return _MHC_Hosp_a3_Oth;
         }
        public void setMHC_Hosp_a3_Oth(String newValue){
              _MHC_Hosp_a3_Oth = newValue;
         }
        private String _MDtHos = "";
        public String getMDtHos(){
              return _MDtHos;
         }
        public void setMDtHos(String newValue){
              _MDtHos = newValue;
         }
        private int _MHosM = 0;
        public int getMHosM(){
              return _MHosM;
         }
        public void setMHosM(int newValue){
              _MHosM = newValue;
         }
        private int _MDurIlBeHos = 0;
        public int getMDurIlBeHos(){
              return _MDurIlBeHos;
         }
        public void setMDurIlBeHos(int newValue){
              _MDurIlBeHos = newValue;
         }
        private int _MChildIlDr = 0;
        public int getMChildIlDr(){
              return _MChildIlDr;
         }
        public void setMChildIlDr(int newValue){
              _MChildIlDr = newValue;
         }
        private String _MChildIlDrOth = "";
        public String getMChildIlDrOth(){
              return _MChildIlDrOth;
         }
        public void setMChildIlDrOth(String newValue){
              _MChildIlDrOth = newValue;
         }
        private int _MReco = 0;
        public int getMReco(){
              return _MReco;
         }
        public void setMReco(int newValue){
              _MReco = newValue;
         }
        private int _MDurReco = 0;
        public int getMDurReco(){
              return _MDurReco;
         }
        public void setMDurReco(int newValue){
              _MDurReco = newValue;
         }
        private int _MInReco = 0;
        public int getMInReco(){
              return _MInReco;
         }
        public void setMInReco(int newValue){
              _MInReco = newValue;
         }
        private String _MInRecoOth = "";
        public String getMInRecoOth(){
              return _MInRecoOth;
         }
        public void setMInRecoOth(String newValue){
              _MInRecoOth = newValue;
         }
        private int _MInReco2 = 0;
        public int getMInReco2(){
              return _MInReco2;
         }
        public void setMInReco2(int newValue){
              _MInReco2 = newValue;
         }
        private String _MInRecoOth2 = "";
        public String getMInRecoOth2(){
              return _MInRecoOth2;
         }
        public void setMInRecoOth2(String newValue){
              _MInRecoOth2 = newValue;
         }
        private int _MInReco3 = 0;
        public int getMInReco3(){
              return _MInReco3;
         }
        public void setMInReco3(int newValue){
              _MInReco3 = newValue;
         }
        private String _MInRecoOth3 = "";
        public String getMInRecoOth3(){
              return _MInRecoOth3;
         }
        public void setMInRecoOth3(String newValue){
              _MInRecoOth3 = newValue;
         }
        private String _AboSeriIlOnset = "";
        public String getAboSeriIlOnset(){
              return _AboSeriIlOnset;
         }
        public void setAboSeriIlOnset(String newValue){
              _AboSeriIlOnset = newValue;
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

        String TableName = "MeningitisCase";

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
                 SQL = "Insert into "+ TableName +" (UNCode,StructureNo,HouseholdSl,VisitNo,MemSl,SeriIlOnset,SameIllSec2,EpiSeriIlOnset,IlnessFev,IlnessConv,UpRolEye,MRigJaw,MRigLimbs,MDurConv,MDrowsin,MDurDrowsin,MUntoFeed,MDurUntoFeed,MCalNoRes,MDurCalNoRes,MEverConf,MDurEverConf,MFlicker,MDurFliker,MUnconsci,MDurUnconsci,MIlCry,MDurIlCry,MUnCraWalk,MDurUnCraWalk,MDifBreath,MCough,MRash,MVomit,MDiarrhoea,MHCar,MHC_Phy,MHC_UnquaDoctor,MHC_Para,MHC_Com,MHC_Pha,MHC_Hompath,MHC_TrHeal,MHC_SpiHeal,MHC_Oth,MHC_OthName,MDSHOPD,MSSFOPD,MHosAdm,MHC_Hosp_a1,MHC_Hosp_a1_Oth,MHC_Hosp_a2,MHC_Hosp_a2_Oth,MHC_Hosp_a3,MHC_Hosp_a3_Oth,MDtHos,MHosM,MDurIlBeHos,MChildIlDr,MChildIlDrOth,MReco,MDurReco,MInReco,MInRecoOth,MInReco2,MInRecoOth2,MInReco3,MInRecoOth3,AboSeriIlOnset,StartTime,EndTime,DeviceID,EntryUser,Lat,Lon,EnDt,Upload,modifyDate)Values('"+ _UNCode +"', '"+ _StructureNo +"', '"+ _HouseholdSl +"', '"+ _VisitNo +"', '"+ _MemSl +"', '"+ _SeriIlOnset +"', '"+ _SameIllSec2 +"', '"+ _EpiSeriIlOnset +"', '"+ _IlnessFev +"', '"+ _IlnessConv +"', '"+ _UpRolEye +"', '"+ _MRigJaw +"', '"+ _MRigLimbs +"', '"+ _MDurConv +"', '"+ _MDrowsin +"', '"+ _MDurDrowsin +"', '"+ _MUntoFeed +"', '"+ _MDurUntoFeed +"', '"+ _MCalNoRes +"', '"+ _MDurCalNoRes +"', '"+ _MEverConf +"', '"+ _MDurEverConf +"', '"+ _MFlicker +"', '"+ _MDurFliker +"', '"+ _MUnconsci +"', '"+ _MDurUnconsci +"', '"+ _MIlCry +"', '"+ _MDurIlCry +"', '"+ _MUnCraWalk +"', '"+ _MDurUnCraWalk +"', '"+ _MDifBreath +"', '"+ _MCough +"', '"+ _MRash +"', '"+ _MVomit +"', '"+ _MDiarrhoea +"', '"+ _MHCar +"', '"+ _MHC_Phy +"', '"+ _MHC_UnquaDoctor +"', '"+ _MHC_Para +"', '"+ _MHC_Com +"', '"+ _MHC_Pha +"', '"+ _MHC_Hompath +"', '"+ _MHC_TrHeal +"', '"+ _MHC_SpiHeal +"', '"+ _MHC_Oth +"', '"+ _MHC_OthName +"', '"+ _MDSHOPD +"', '"+ _MSSFOPD +"', '"+ _MHosAdm +"', '"+ _MHC_Hosp_a1 +"', '"+ _MHC_Hosp_a1_Oth +"', '"+ _MHC_Hosp_a2 +"', '"+ _MHC_Hosp_a2_Oth +"', '"+ _MHC_Hosp_a3 +"', '"+ _MHC_Hosp_a3_Oth +"', '"+ _MDtHos +"', '"+ _MHosM +"', '"+ _MDurIlBeHos +"', '"+ _MChildIlDr +"', '"+ _MChildIlDrOth +"', '"+ _MReco +"', '"+ _MDurReco +"', '"+ _MInReco +"', '"+ _MInRecoOth +"', '"+ _MInReco2 +"', '"+ _MInRecoOth2 +"', '"+ _MInReco3 +"', '"+ _MInRecoOth3 +"', '"+ _AboSeriIlOnset +"', '"+ _StartTime +"', '"+ _EndTime +"', '"+ _DeviceID +"', '"+ _EntryUser +"', '"+ _Lat +"', '"+ _Lon +"', '"+ _EnDt +"', '"+ _Upload +"', '"+ _modifyDate +"')";
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
                 SQL = "Update "+ TableName +" Set Upload='2',modifyDate='" + _modifyDate + "' ,UNCode = '"+ _UNCode +"',StructureNo = '"+ _StructureNo +"',HouseholdSl = '"+ _HouseholdSl +"',VisitNo = '"+ _VisitNo +"',MemSl = '"+ _MemSl +"',SeriIlOnset = '"+ _SeriIlOnset +"',SameIllSec2 = '"+ _SameIllSec2 +"',EpiSeriIlOnset = '"+ _EpiSeriIlOnset +"',IlnessFev = '"+ _IlnessFev +"',IlnessConv = '"+ _IlnessConv +"',UpRolEye = '"+ _UpRolEye +"',MRigJaw = '"+ _MRigJaw +"',MRigLimbs = '"+ _MRigLimbs +"',MDurConv = '"+ _MDurConv +"',MDrowsin = '"+ _MDrowsin +"',MDurDrowsin = '"+ _MDurDrowsin +"',MUntoFeed = '"+ _MUntoFeed +"',MDurUntoFeed = '"+ _MDurUntoFeed +"',MCalNoRes = '"+ _MCalNoRes +"',MDurCalNoRes = '"+ _MDurCalNoRes +"',MEverConf = '"+ _MEverConf +"',MDurEverConf = '"+ _MDurEverConf +"',MFlicker = '"+ _MFlicker +"',MDurFliker = '"+ _MDurFliker +"',MUnconsci = '"+ _MUnconsci +"',MDurUnconsci = '"+ _MDurUnconsci +"',MIlCry = '"+ _MIlCry +"',MDurIlCry = '"+ _MDurIlCry +"',MUnCraWalk = '"+ _MUnCraWalk +"',MDurUnCraWalk = '"+ _MDurUnCraWalk +"',MDifBreath = '"+ _MDifBreath +"',MCough = '"+ _MCough +"',MRash = '"+ _MRash +"',MVomit = '"+ _MVomit +"',MDiarrhoea = '"+ _MDiarrhoea +"',MHCar = '"+ _MHCar +"',MHC_Phy = '"+ _MHC_Phy +"',MHC_UnquaDoctor = '"+ _MHC_UnquaDoctor +"',MHC_Para = '"+ _MHC_Para +"',MHC_Com = '"+ _MHC_Com +"',MHC_Pha = '"+ _MHC_Pha +"',MHC_Hompath = '"+ _MHC_Hompath +"',MHC_TrHeal = '"+ _MHC_TrHeal +"',MHC_SpiHeal = '"+ _MHC_SpiHeal +"',MHC_Oth = '"+ _MHC_Oth +"',MHC_OthName = '"+ _MHC_OthName +"',MDSHOPD = '"+ _MDSHOPD +"',MSSFOPD = '"+ _MSSFOPD +"',MHosAdm = '"+ _MHosAdm +"',MHC_Hosp_a1 = '"+ _MHC_Hosp_a1 +"',MHC_Hosp_a1_Oth = '"+ _MHC_Hosp_a1_Oth +"',MHC_Hosp_a2 = '"+ _MHC_Hosp_a2 +"',MHC_Hosp_a2_Oth = '"+ _MHC_Hosp_a2_Oth +"',MHC_Hosp_a3 = '"+ _MHC_Hosp_a3 +"',MHC_Hosp_a3_Oth = '"+ _MHC_Hosp_a3_Oth +"',MDtHos = '"+ _MDtHos +"',MHosM = '"+ _MHosM +"',MDurIlBeHos = '"+ _MDurIlBeHos +"',MChildIlDr = '"+ _MChildIlDr +"',MChildIlDrOth = '"+ _MChildIlDrOth +"',MReco = '"+ _MReco +"',MDurReco = '"+ _MDurReco +"',MInReco = '"+ _MInReco +"',MInRecoOth = '"+ _MInRecoOth +"',MInReco2 = '"+ _MInReco2 +"',MInRecoOth2 = '"+ _MInRecoOth2 +"',MInReco3 = '"+ _MInReco3 +"',MInRecoOth3 = '"+ _MInRecoOth3 +"',AboSeriIlOnset = '"+ _AboSeriIlOnset +"'  Where UNCode='"+ _UNCode +"' and StructureNo='"+ _StructureNo +"' and HouseholdSl='"+ _HouseholdSl +"' and VisitNo='"+ _VisitNo +"' and MemSl='"+ _MemSl +"' and DeviceID='"+_DeviceID+"'";
                 response = C.SaveData(SQL);
                 C.close();
              }
              catch(Exception  e)
              {
                 response = e.getMessage();
              }
           return response;
        }


        public List<MeningitisCase_DataModel> SelectAll(Context context, String SQL)
        {
            Connection C = new Connection(context);
            List<MeningitisCase_DataModel> data = new ArrayList<MeningitisCase_DataModel>();
            MeningitisCase_DataModel d = new MeningitisCase_DataModel();
            Cursor cur = C.ReadData(SQL);

            cur.moveToFirst();
            while(!cur.isAfterLast())
            {
                d = new MeningitisCase_DataModel();
                d._UNCode = cur.getString(cur.getColumnIndex("UNCode"));
                d._StructureNo = cur.getString(cur.getColumnIndex("StructureNo"));
                d._HouseholdSl = cur.getString(cur.getColumnIndex("HouseholdSl"));
                d._VisitNo = cur.getString(cur.getColumnIndex("VisitNo"));
                d._MemSl = cur.getString(cur.getColumnIndex("MemSl"));
                d._SeriIlOnset = Integer.valueOf(cur.getString(cur.getColumnIndex("SeriIlOnset")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("SeriIlOnset")));
                d._SameIllSec2 = Integer.valueOf(cur.getString(cur.getColumnIndex("SameIllSec2")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("SameIllSec2")));
                d._EpiSeriIlOnset = Integer.valueOf(cur.getString(cur.getColumnIndex("EpiSeriIlOnset")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("EpiSeriIlOnset")));
                d._IlnessFev = Integer.valueOf(cur.getString(cur.getColumnIndex("IlnessFev")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("IlnessFev")));
                d._IlnessConv = Integer.valueOf(cur.getString(cur.getColumnIndex("IlnessConv")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("IlnessConv")));
                d._UpRolEye = Integer.valueOf(cur.getString(cur.getColumnIndex("UpRolEye")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("UpRolEye")));
                d._MRigJaw = Integer.valueOf(cur.getString(cur.getColumnIndex("MRigJaw")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MRigJaw")));
                d._MRigLimbs = Integer.valueOf(cur.getString(cur.getColumnIndex("MRigLimbs")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MRigLimbs")));
                d._MDurConv = Integer.valueOf(cur.getString(cur.getColumnIndex("MDurConv")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MDurConv")));
                d._MDrowsin = Integer.valueOf(cur.getString(cur.getColumnIndex("MDrowsin")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MDrowsin")));
                d._MDurDrowsin = Integer.valueOf(cur.getString(cur.getColumnIndex("MDurDrowsin")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MDurDrowsin")));
                d._MUntoFeed = Integer.valueOf(cur.getString(cur.getColumnIndex("MUntoFeed")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MUntoFeed")));
                d._MDurUntoFeed = Integer.valueOf(cur.getString(cur.getColumnIndex("MDurUntoFeed")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MDurUntoFeed")));
                d._MCalNoRes = Integer.valueOf(cur.getString(cur.getColumnIndex("MCalNoRes")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MCalNoRes")));
                d._MDurCalNoRes = Integer.valueOf(cur.getString(cur.getColumnIndex("MDurCalNoRes")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MDurCalNoRes")));
                d._MEverConf = Integer.valueOf(cur.getString(cur.getColumnIndex("MEverConf")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MEverConf")));
                d._MDurEverConf = Integer.valueOf(cur.getString(cur.getColumnIndex("MDurEverConf")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MDurEverConf")));
                d._MFlicker = Integer.valueOf(cur.getString(cur.getColumnIndex("MFlicker")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MFlicker")));
                d._MDurFliker = Integer.valueOf(cur.getString(cur.getColumnIndex("MDurFliker")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MDurFliker")));
                d._MUnconsci = Integer.valueOf(cur.getString(cur.getColumnIndex("MUnconsci")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MUnconsci")));
                d._MDurUnconsci = Integer.valueOf(cur.getString(cur.getColumnIndex("MDurUnconsci")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MDurUnconsci")));
                d._MIlCry = Integer.valueOf(cur.getString(cur.getColumnIndex("MIlCry")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MIlCry")));
                d._MDurIlCry = Integer.valueOf(cur.getString(cur.getColumnIndex("MDurIlCry")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MDurIlCry")));
                d._MUnCraWalk = Integer.valueOf(cur.getString(cur.getColumnIndex("MUnCraWalk")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MUnCraWalk")));
                d._MDurUnCraWalk = Integer.valueOf(cur.getString(cur.getColumnIndex("MDurUnCraWalk")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MDurUnCraWalk")));
                d._MDifBreath = Integer.valueOf(cur.getString(cur.getColumnIndex("MDifBreath")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MDifBreath")));
                d._MCough = Integer.valueOf(cur.getString(cur.getColumnIndex("MCough")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MCough")));
                d._MRash = Integer.valueOf(cur.getString(cur.getColumnIndex("MRash")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MRash")));
                d._MVomit = Integer.valueOf(cur.getString(cur.getColumnIndex("MVomit")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MVomit")));
                d._MDiarrhoea = Integer.valueOf(cur.getString(cur.getColumnIndex("MDiarrhoea")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MDiarrhoea")));
                d._MHCar = Integer.valueOf(cur.getString(cur.getColumnIndex("MHCar")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MHCar")));
                d._MHC_Phy = Integer.valueOf(cur.getString(cur.getColumnIndex("MHC_Phy")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MHC_Phy")));
                d._MHC_UnquaDoctor = Integer.valueOf(cur.getString(cur.getColumnIndex("MHC_UnquaDoctor")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MHC_UnquaDoctor")));
                d._MHC_Para = Integer.valueOf(cur.getString(cur.getColumnIndex("MHC_Para")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MHC_Para")));
                d._MHC_Com = Integer.valueOf(cur.getString(cur.getColumnIndex("MHC_Com")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MHC_Com")));
                d._MHC_Pha = Integer.valueOf(cur.getString(cur.getColumnIndex("MHC_Pha")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MHC_Pha")));
                d._MHC_Hompath = Integer.valueOf(cur.getString(cur.getColumnIndex("MHC_Hompath")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MHC_Hompath")));
                d._MHC_TrHeal = Integer.valueOf(cur.getString(cur.getColumnIndex("MHC_TrHeal")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MHC_TrHeal")));
                d._MHC_SpiHeal = Integer.valueOf(cur.getString(cur.getColumnIndex("MHC_SpiHeal")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MHC_SpiHeal")));
                d._MHC_Oth = Integer.valueOf(cur.getString(cur.getColumnIndex("MHC_Oth")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MHC_Oth")));
                d._MHC_OthName = cur.getString(cur.getColumnIndex("MHC_OthName"));
                d._MDSHOPD = Integer.valueOf(cur.getString(cur.getColumnIndex("MDSHOPD")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MDSHOPD")));
                d._MSSFOPD = Integer.valueOf(cur.getString(cur.getColumnIndex("MSSFOPD")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MSSFOPD")));
                d._MHosAdm = Integer.valueOf(cur.getString(cur.getColumnIndex("MHosAdm")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MHosAdm")));
                d._MHC_Hosp_a1 = Integer.valueOf(cur.getString(cur.getColumnIndex("MHC_Hosp_a1")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MHC_Hosp_a1")));
                d._MHC_Hosp_a1_Oth = cur.getString(cur.getColumnIndex("MHC_Hosp_a1_Oth"));
                d._MHC_Hosp_a2 = Integer.valueOf(cur.getString(cur.getColumnIndex("MHC_Hosp_a2")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MHC_Hosp_a2")));
                d._MHC_Hosp_a2_Oth = cur.getString(cur.getColumnIndex("MHC_Hosp_a2_Oth"));
                d._MHC_Hosp_a3 = Integer.valueOf(cur.getString(cur.getColumnIndex("MHC_Hosp_a3")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MHC_Hosp_a3")));
                d._MHC_Hosp_a3_Oth = cur.getString(cur.getColumnIndex("MHC_Hosp_a3_Oth"));
                d._MDtHos = cur.getString(cur.getColumnIndex("MDtHos"));
                d._MHosM = Integer.valueOf(cur.getString(cur.getColumnIndex("MHosM")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MHosM")));
                d._MDurIlBeHos = Integer.valueOf(cur.getString(cur.getColumnIndex("MDurIlBeHos")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MDurIlBeHos")));
                d._MChildIlDr = Integer.valueOf(cur.getString(cur.getColumnIndex("MChildIlDr")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MChildIlDr")));
                d._MChildIlDrOth = cur.getString(cur.getColumnIndex("MChildIlDrOth"));
                d._MReco = Integer.valueOf(cur.getString(cur.getColumnIndex("MReco")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MReco")));
                d._MDurReco = Integer.valueOf(cur.getString(cur.getColumnIndex("MDurReco")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MDurReco")));
                d._MInReco = Integer.valueOf(cur.getString(cur.getColumnIndex("MInReco")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MInReco")));
                d._MInRecoOth = cur.getString(cur.getColumnIndex("MInRecoOth"));
                d._MInReco2 = Integer.valueOf(cur.getString(cur.getColumnIndex("MInReco2")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MInReco2")));
                d._MInRecoOth2 = cur.getString(cur.getColumnIndex("MInRecoOth2"));
                d._MInReco3 = Integer.valueOf(cur.getString(cur.getColumnIndex("MInReco3")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MInReco3")));
                d._MInRecoOth3 = cur.getString(cur.getColumnIndex("MInRecoOth3"));
                d._AboSeriIlOnset = cur.getString(cur.getColumnIndex("AboSeriIlOnset"));
                data.add(d);

                cur.moveToNext();
            }
            cur.close();
          return data;
        }
 }