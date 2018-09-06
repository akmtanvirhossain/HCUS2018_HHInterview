package data_model;

import android.content.Context;
 import android.database.Cursor;
 import Common.Connection;
 import java.util.ArrayList;
 import java.util.List;
 import java.util.Date;
 public class TyphoidCase_DataModel{

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
        private int _HaveFever = 0;
        public int getHaveFever(){
              return _HaveFever;
         }
        public void setHaveFever(int newValue){
              _HaveFever = newValue;
         }
        private int _AbdomPain = 0;
        public int getAbdomPain(){
              return _AbdomPain;
         }
        public void setAbdomPain(int newValue){
              _AbdomPain = newValue;
         }
        private int _Constipation = 0;
        public int getConstipation(){
              return _Constipation;
         }
        public void setConstipation(int newValue){
              _Constipation = newValue;
         }
        private int _Headache = 0;
        public int getHeadache(){
              return _Headache;
         }
        public void setHeadache(int newValue){
              _Headache = newValue;
         }
        private int _Rash = 0;
        public int getRash(){
              return _Rash;
         }
        public void setRash(int newValue){
              _Rash = newValue;
         }
        private int _Diarrhoea = 0;
        public int getDiarrhoea(){
              return _Diarrhoea;
         }
        public void setDiarrhoea(int newValue){
              _Diarrhoea = newValue;
         }
        private int _AbdomDist = 0;
        public int getAbdomDist(){
              return _AbdomDist;
         }
        public void setAbdomDist(int newValue){
              _AbdomDist = newValue;
         }
        private int _CoaTon = 0;
        public int getCoaTon(){
              return _CoaTon;
         }
        public void setCoaTon(int newValue){
              _CoaTon = newValue;
         }
        private int _Cough = 0;
        public int getCough(){
              return _Cough;
         }
        public void setCough(int newValue){
              _Cough = newValue;
         }
        private int _Tnone = 0;
        public int getTnone(){
              return _Tnone;
         }
        public void setTnone(int newValue){
              _Tnone = newValue;
         }
        private int _Other = 0;
        public int getOther(){
              return _Other;
         }
        public void setOther(int newValue){
              _Other = newValue;
         }
        private String _TsymptOthName = "";
        public String getTsymptOthName(){
              return _TsymptOthName;
         }
        public void setTsymptOthName(String newValue){
              _TsymptOthName = newValue;
         }
        private int _TakenHCFacility = 0;
        public int getTakenHCFacility(){
              return _TakenHCFacility;
         }
        public void setTakenHCFacility(int newValue){
              _TakenHCFacility = newValue;
         }
        private int _HC_PhyMBBS = 0;
        public int getHC_PhyMBBS(){
              return _HC_PhyMBBS;
         }
        public void setHC_PhyMBBS(int newValue){
              _HC_PhyMBBS = newValue;
         }
        private int _HC_UnquaDoctor = 0;
        public int getHC_UnquaDoctor(){
              return _HC_UnquaDoctor;
         }
        public void setHC_UnquaDoctor(int newValue){
              _HC_UnquaDoctor = newValue;
         }
        private int _HC_Para = 0;
        public int getHC_Para(){
              return _HC_Para;
         }
        public void setHC_Para(int newValue){
              _HC_Para = newValue;
         }
        private int _HC_Com = 0;
        public int getHC_Com(){
              return _HC_Com;
         }
        public void setHC_Com(int newValue){
              _HC_Com = newValue;
         }
        private int _HC_Pha = 0;
        public int getHC_Pha(){
              return _HC_Pha;
         }
        public void setHC_Pha(int newValue){
              _HC_Pha = newValue;
         }
        private int _HC_Hompath = 0;
        public int getHC_Hompath(){
              return _HC_Hompath;
         }
        public void setHC_Hompath(int newValue){
              _HC_Hompath = newValue;
         }
        private int _HC_TrHeal = 0;
        public int getHC_TrHeal(){
              return _HC_TrHeal;
         }
        public void setHC_TrHeal(int newValue){
              _HC_TrHeal = newValue;
         }
        private int _HC_SpiHeal = 0;
        public int getHC_SpiHeal(){
              return _HC_SpiHeal;
         }
        public void setHC_SpiHeal(int newValue){
              _HC_SpiHeal = newValue;
         }
        private int _THC_Oth = 0;
        public int getTHC_Oth(){
              return _THC_Oth;
         }
        public void setTHC_Oth(int newValue){
              _THC_Oth = newValue;
         }
        private String _THC_OthName = "";
        public String getTHC_OthName(){
              return _THC_OthName;
         }
        public void setTHC_OthName(String newValue){
              _THC_OthName = newValue;
         }
        private int _HC_Hosp = 0;
        public int getHC_Hosp(){
              return _HC_Hosp;
         }
        public void setHC_Hosp(int newValue){
              _HC_Hosp = newValue;
         }
        private int _HC_Hosp_a1 = 0;
        public int getHC_Hosp_a1(){
              return _HC_Hosp_a1;
         }
        public void setHC_Hosp_a1(int newValue){
              _HC_Hosp_a1 = newValue;
         }
        private String _HC_Hosp_a1_Oth = "";
        public String getHC_Hosp_a1_Oth(){
              return _HC_Hosp_a1_Oth;
         }
        public void setHC_Hosp_a1_Oth(String newValue){
              _HC_Hosp_a1_Oth = newValue;
         }
        private int _HC_Hosp_a2 = 0;
        public int getHC_Hosp_a2(){
              return _HC_Hosp_a2;
         }
        public void setHC_Hosp_a2(int newValue){
              _HC_Hosp_a2 = newValue;
         }
        private String _HC_Hosp_a2_Oth = "";
        public String getHC_Hosp_a2_Oth(){
              return _HC_Hosp_a2_Oth;
         }
        public void setHC_Hosp_a2_Oth(String newValue){
              _HC_Hosp_a2_Oth = newValue;
         }
        private int _HC_Hosp_a3 = 0;
        public int getHC_Hosp_a3(){
              return _HC_Hosp_a3;
         }
        public void setHC_Hosp_a3(int newValue){
              _HC_Hosp_a3 = newValue;
         }
        private String _HC_Hosp_a3_Oth = "";
        public String getHC_Hosp_a3_Oth(){
              return _HC_Hosp_a3_Oth;
         }
        public void setHC_Hosp_a3_Oth(String newValue){
              _HC_Hosp_a3_Oth = newValue;
         }
        private int _HC_Hosp_a4 = 0;
        public int getHC_Hosp_a4(){
              return _HC_Hosp_a4;
         }
        public void setHC_Hosp_a4(int newValue){
              _HC_Hosp_a4 = newValue;
         }
        private String _HC_Hosp_a4_Oth = "";
        public String getHC_Hosp_a4_Oth(){
              return _HC_Hosp_a4_Oth;
         }
        public void setHC_Hosp_a4_Oth(String newValue){
              _HC_Hosp_a4_Oth = newValue;
         }
        private int _HC_Hosp_a5 = 0;
        public int getHC_Hosp_a5(){
              return _HC_Hosp_a5;
         }
        public void setHC_Hosp_a5(int newValue){
              _HC_Hosp_a5 = newValue;
         }
        private String _HC_Hosp_a5_Oth = "";
        public String getHC_Hosp_a5_Oth(){
              return _HC_Hosp_a5_Oth;
         }
        public void setHC_Hosp_a5_Oth(String newValue){
              _HC_Hosp_a5_Oth = newValue;
         }
        private int _HC_Hosp_b = 0;
        public int getHC_Hosp_b(){
              return _HC_Hosp_b;
         }
        public void setHC_Hosp_b(int newValue){
              _HC_Hosp_b = newValue;
         }
        private int _HC_Hosp_b_i = 0;
        public int getHC_Hosp_b_i(){
              return _HC_Hosp_b_i;
         }
        public void setHC_Hosp_b_i(int newValue){
              _HC_Hosp_b_i = newValue;
         }
        private int _HC_Clin = 0;
        public int getHC_Clin(){
              return _HC_Clin;
         }
        public void setHC_Clin(int newValue){
              _HC_Clin = newValue;
         }
        private int _HC_Phy = 0;
        public int getHC_Phy(){
              return _HC_Phy;
         }
        public void setHC_Phy(int newValue){
              _HC_Phy = newValue;
         }
        private int _DaysOfSymp = 0;
        public int getDaysOfSymp(){
              return _DaysOfSymp;
         }
        public void setDaysOfSymp(int newValue){
              _DaysOfSymp = newValue;
         }
        private int _DaysOfSympDK = 0;
        public int getDaysOfSympDK(){
              return _DaysOfSympDK;
         }
        public void setDaysOfSympDK(int newValue){
              _DaysOfSympDK = newValue;
         }
        private int _WorstHour = 0;
        public int getWorstHour(){
              return _WorstHour;
         }
        public void setWorstHour(int newValue){
              _WorstHour = newValue;
         }
        private int _WorstHourDK = 0;
        public int getWorstHourDK(){
              return _WorstHourDK;
         }
        public void setWorstHourDK(int newValue){
              _WorstHourDK = newValue;
         }
        private int _DaysOfUnable = 0;
        public int getDaysOfUnable(){
              return _DaysOfUnable;
         }
        public void setDaysOfUnable(int newValue){
              _DaysOfUnable = newValue;
         }
        private int _DaysOfUnableDK = 0;
        public int getDaysOfUnableDK(){
              return _DaysOfUnableDK;
         }
        public void setDaysOfUnableDK(int newValue){
              _DaysOfUnableDK = newValue;
         }
        private int _TAdmHos = 0;
        public int getTAdmHos(){
              return _TAdmHos;
         }
        public void setTAdmHos(int newValue){
              _TAdmHos = newValue;
         }
        private int _THosNam = 0;
        public int getTHosNam(){
              return _THosNam;
         }
        public void setTHosNam(int newValue){
              _THosNam = newValue;
         }
        private String _THosNam_Oth = "";
        public String getTHosNam_Oth(){
              return _THosNam_Oth;
         }
        public void setTHosNam_Oth(String newValue){
              _THosNam_Oth = newValue;
         }
        private int _THosNam2 = 0;
        public int getTHosNam2(){
              return _THosNam2;
         }
        public void setTHosNam2(int newValue){
              _THosNam2 = newValue;
         }
        private String _THosNam2_Oth = "";
        public String getTHosNam2_Oth(){
              return _THosNam2_Oth;
         }
        public void setTHosNam2_Oth(String newValue){
              _THosNam2_Oth = newValue;
         }
        private int _THosNam3 = 0;
        public int getTHosNam3(){
              return _THosNam3;
         }
        public void setTHosNam3(int newValue){
              _THosNam3 = newValue;
         }
        private String _THosNam3_Oth = "";
        public String getTHosNam3_Oth(){
              return _THosNam3_Oth;
         }
        public void setTHosNam3_Oth(String newValue){
              _THosNam3_Oth = newValue;
         }
        private int _THosNamDK = 0;
        public int getTHosNamDK(){
              return _THosNamDK;
         }
        public void setTHosNamDK(int newValue){
              _THosNamDK = newValue;
         }
        private String _TDtAdmHos = "";
        public String getTDtAdmHos(){
              return _TDtAdmHos;
         }
        public void setTDtAdmHos(String newValue){
              _TDtAdmHos = newValue;
         }
        private int _TAdmHosD = 0;
        public int getTAdmHosD(){
              return _TAdmHosD;
         }
        public void setTAdmHosD(int newValue){
              _TAdmHosD = newValue;
         }
        private int _TDurIlBeHos = 0;
        public int getTDurIlBeHos(){
              return _TDurIlBeHos;
         }
        public void setTDurIlBeHos(int newValue){
              _TDurIlBeHos = newValue;
         }
        private int _TDurIlBeHosDK = 0;
        public int getTDurIlBeHosDK(){
              return _TDurIlBeHosDK;
         }
        public void setTDurIlBeHosDK(int newValue){
              _TDurIlBeHosDK = newValue;
         }
        private int _TDisDr = 0;
        public int getTDisDr(){
              return _TDisDr;
         }
        public void setTDisDr(int newValue){
              _TDisDr = newValue;
         }
        private String _TDisDrOth = "";
        public String getTDisDrOth(){
              return _TDisDrOth;
         }
        public void setTDisDrOth(String newValue){
              _TDisDrOth = newValue;
         }
        private int _TReco = 0;
        public int getTReco(){
              return _TReco;
         }
        public void setTReco(int newValue){
              _TReco = newValue;
         }
        private int _TDurReco = 0;
        public int getTDurReco(){
              return _TDurReco;
         }
        public void setTDurReco(int newValue){
              _TDurReco = newValue;
         }
        private int _TInReco = 0;
        public int getTInReco(){
              return _TInReco;
         }
        public void setTInReco(int newValue){
              _TInReco = newValue;
         }
        private String _TInRecoOth = "";
        public String getTInRecoOth(){
              return _TInRecoOth;
         }
        public void setTInRecoOth(String newValue){
              _TInRecoOth = newValue;
         }
        private int _TInReco2 = 0;
        public int getTInReco2(){
              return _TInReco2;
         }
        public void setTInReco2(int newValue){
              _TInReco2 = newValue;
         }
        private String _TInRecoOth2 = "";
        public String getTInRecoOth2(){
              return _TInRecoOth2;
         }
        public void setTInRecoOth2(String newValue){
              _TInRecoOth2 = newValue;
         }
        private int _HaveHosp = 0;
        public int getHaveHosp(){
              return _HaveHosp;
         }
        public void setHaveHosp(int newValue){
              _HaveHosp = newValue;
         }
        private int _HospName = 0;
        public int getHospName(){
              return _HospName;
         }
        public void setHospName(int newValue){
              _HospName = newValue;
         }
        private String _HospName_Oth = "";
        public String getHospName_Oth(){
              return _HospName_Oth;
         }
        public void setHospName_Oth(String newValue){
              _HospName_Oth = newValue;
         }
        private int _HaveRecords = 0;
        public int getHaveRecords(){
              return _HaveRecords;
         }
        public void setHaveRecords(int newValue){
              _HaveRecords = newValue;
         }
        private int _DidRecordMatch2 = 0;
        public int getDidRecordMatch2(){
              return _DidRecordMatch2;
         }
        public void setDidRecordMatch2(int newValue){
              _DidRecordMatch2 = newValue;
         }
        private int _DaysOfHosp = 0;
        public int getDaysOfHosp(){
              return _DaysOfHosp;
         }
        public void setDaysOfHosp(int newValue){
              _DaysOfHosp = newValue;
         }
        private int _DaysOfHospDK = 0;
        public int getDaysOfHospDK(){
              return _DaysOfHospDK;
         }
        public void setDaysOfHospDK(int newValue){
              _DaysOfHospDK = newValue;
         }
        private String _TAboIll = "";
        public String getTAboIll(){
              return _TAboIll;
         }
        public void setTAboIll(String newValue){
              _TAboIll = newValue;
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

        String TableName = "TyphoidCase";

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
                 SQL = "Insert into "+ TableName +" (UNCode,StructureNo,HouseholdSl,VisitNo,MemSl,HaveFever,AbdomPain,Constipation,Headache,Rash,Diarrhoea,AbdomDist,CoaTon,Cough,Tnone,Other,TsymptOthName,TakenHCFacility,HC_PhyMBBS,HC_UnquaDoctor,HC_Para,HC_Com,HC_Pha,HC_Hompath,HC_TrHeal,HC_SpiHeal,THC_Oth,THC_OthName,HC_Hosp,HC_Hosp_a1,HC_Hosp_a1_Oth,HC_Hosp_a2,HC_Hosp_a2_Oth,HC_Hosp_a3,HC_Hosp_a3_Oth,HC_Hosp_a4,HC_Hosp_a4_Oth,HC_Hosp_a5,HC_Hosp_a5_Oth,HC_Hosp_b,HC_Hosp_b_i,HC_Clin,HC_Phy,DaysOfSymp,DaysOfSympDK,WorstHour,WorstHourDK,DaysOfUnable,DaysOfUnableDK,TAdmHos,THosNam,THosNam_Oth,THosNam2,THosNam2_Oth,THosNam3,THosNam3_Oth,THosNamDK,TDtAdmHos,TAdmHosD,TDurIlBeHos,TDurIlBeHosDK,TDisDr,TDisDrOth,TReco,TDurReco,TInReco,TInRecoOth,TInReco2,TInRecoOth2,HaveHosp,HospName,HospName_Oth,HaveRecords,DidRecordMatch2,DaysOfHosp,DaysOfHospDK,TAboIll,StartTime,EndTime,DeviceID,EntryUser,Lat,Lon,EnDt,Upload,modifyDate)Values('"+ _UNCode +"', '"+ _StructureNo +"', '"+ _HouseholdSl +"', '"+ _VisitNo +"', '"+ _MemSl +"', '"+ _HaveFever +"', '"+ _AbdomPain +"', '"+ _Constipation +"', '"+ _Headache +"', '"+ _Rash +"', '"+ _Diarrhoea +"', '"+ _AbdomDist +"', '"+ _CoaTon +"', '"+ _Cough +"', '"+ _Tnone +"', '"+ _Other +"', '"+ _TsymptOthName +"', '"+ _TakenHCFacility +"', '"+ _HC_PhyMBBS +"', '"+ _HC_UnquaDoctor +"', '"+ _HC_Para +"', '"+ _HC_Com +"', '"+ _HC_Pha +"', '"+ _HC_Hompath +"', '"+ _HC_TrHeal +"', '"+ _HC_SpiHeal +"', '"+ _THC_Oth +"', '"+ _THC_OthName +"', '"+ _HC_Hosp +"', '"+ _HC_Hosp_a1 +"', '"+ _HC_Hosp_a1_Oth +"', '"+ _HC_Hosp_a2 +"', '"+ _HC_Hosp_a2_Oth +"', '"+ _HC_Hosp_a3 +"', '"+ _HC_Hosp_a3_Oth +"', '"+ _HC_Hosp_a4 +"', '"+ _HC_Hosp_a4_Oth +"', '"+ _HC_Hosp_a5 +"', '"+ _HC_Hosp_a5_Oth +"', '"+ _HC_Hosp_b +"', '"+ _HC_Hosp_b_i +"', '"+ _HC_Clin +"', '"+ _HC_Phy +"', '"+ _DaysOfSymp +"', '"+ _DaysOfSympDK +"', '"+ _WorstHour +"', '"+ _WorstHourDK +"', '"+ _DaysOfUnable +"', '"+ _DaysOfUnableDK +"', '"+ _TAdmHos +"', '"+ _THosNam +"', '"+ _THosNam_Oth +"', '"+ _THosNam2 +"', '"+ _THosNam2_Oth +"', '"+ _THosNam3 +"', '"+ _THosNam3_Oth +"', '"+ _THosNamDK +"', '"+ _TDtAdmHos +"', '"+ _TAdmHosD +"', '"+ _TDurIlBeHos +"', '"+ _TDurIlBeHosDK +"', '"+ _TDisDr +"', '"+ _TDisDrOth +"', '"+ _TReco +"', '"+ _TDurReco +"', '"+ _TInReco +"', '"+ _TInRecoOth +"', '"+ _TInReco2 +"', '"+ _TInRecoOth2 +"', '"+ _HaveHosp +"', '"+ _HospName +"', '"+ _HospName_Oth +"', '"+ _HaveRecords +"', '"+ _DidRecordMatch2 +"', '"+ _DaysOfHosp +"', '"+ _DaysOfHospDK +"', '"+ _TAboIll +"', '"+ _StartTime +"', '"+ _EndTime +"', '"+ _DeviceID +"', '"+ _EntryUser +"', '"+ _Lat +"', '"+ _Lon +"', '"+ _EnDt +"', '"+ _Upload +"', '"+ _modifyDate +"')";
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
                 SQL = "Update "+ TableName +" Set Upload='2',modifyDate='" + _modifyDate + "' ,UNCode = '"+ _UNCode +"',StructureNo = '"+ _StructureNo +"',HouseholdSl = '"+ _HouseholdSl +"',VisitNo = '"+ _VisitNo +"',MemSl = '"+ _MemSl +"',HaveFever = '"+ _HaveFever +"',AbdomPain = '"+ _AbdomPain +"',Constipation = '"+ _Constipation +"',Headache = '"+ _Headache +"',Rash = '"+ _Rash +"',Diarrhoea = '"+ _Diarrhoea +"',AbdomDist = '"+ _AbdomDist +"',CoaTon = '"+ _CoaTon +"',Cough = '"+ _Cough +"',Tnone = '"+ _Tnone +"',Other = '"+ _Other +"',TsymptOthName = '"+ _TsymptOthName +"',TakenHCFacility = '"+ _TakenHCFacility +"',HC_PhyMBBS = '"+ _HC_PhyMBBS +"',HC_UnquaDoctor = '"+ _HC_UnquaDoctor +"',HC_Para = '"+ _HC_Para +"',HC_Com = '"+ _HC_Com +"',HC_Pha = '"+ _HC_Pha +"',HC_Hompath = '"+ _HC_Hompath +"',HC_TrHeal = '"+ _HC_TrHeal +"',HC_SpiHeal = '"+ _HC_SpiHeal +"',THC_Oth = '"+ _THC_Oth +"',THC_OthName = '"+ _THC_OthName +"',HC_Hosp = '"+ _HC_Hosp +"',HC_Hosp_a1 = '"+ _HC_Hosp_a1 +"',HC_Hosp_a1_Oth = '"+ _HC_Hosp_a1_Oth +"',HC_Hosp_a2 = '"+ _HC_Hosp_a2 +"',HC_Hosp_a2_Oth = '"+ _HC_Hosp_a2_Oth +"',HC_Hosp_a3 = '"+ _HC_Hosp_a3 +"',HC_Hosp_a3_Oth = '"+ _HC_Hosp_a3_Oth +"',HC_Hosp_a4 = '"+ _HC_Hosp_a4 +"',HC_Hosp_a4_Oth = '"+ _HC_Hosp_a4_Oth +"',HC_Hosp_a5 = '"+ _HC_Hosp_a5 +"',HC_Hosp_a5_Oth = '"+ _HC_Hosp_a5_Oth +"',HC_Hosp_b = '"+ _HC_Hosp_b +"',HC_Hosp_b_i = '"+ _HC_Hosp_b_i +"',HC_Clin = '"+ _HC_Clin +"',HC_Phy = '"+ _HC_Phy +"',DaysOfSymp = '"+ _DaysOfSymp +"',DaysOfSympDK = '"+ _DaysOfSympDK +"',WorstHour = '"+ _WorstHour +"',WorstHourDK = '"+ _WorstHourDK +"',DaysOfUnable = '"+ _DaysOfUnable +"',DaysOfUnableDK = '"+ _DaysOfUnableDK +"',TAdmHos = '"+ _TAdmHos +"',THosNam = '"+ _THosNam +"',THosNam_Oth = '"+ _THosNam_Oth +"',THosNam2 = '"+ _THosNam2 +"',THosNam2_Oth = '"+ _THosNam2_Oth +"',THosNam3 = '"+ _THosNam3 +"',THosNam3_Oth = '"+ _THosNam3_Oth +"',THosNamDK = '"+ _THosNamDK +"',TDtAdmHos = '"+ _TDtAdmHos +"',TAdmHosD = '"+ _TAdmHosD +"',TDurIlBeHos = '"+ _TDurIlBeHos +"',TDurIlBeHosDK = '"+ _TDurIlBeHosDK +"',TDisDr = '"+ _TDisDr +"',TDisDrOth = '"+ _TDisDrOth +"',TReco = '"+ _TReco +"',TDurReco = '"+ _TDurReco +"',TInReco = '"+ _TInReco +"',TInRecoOth = '"+ _TInRecoOth +"',TInReco2 = '"+ _TInReco2 +"',TInRecoOth2 = '"+ _TInRecoOth2 +"',HaveHosp = '"+ _HaveHosp +"',HospName = '"+ _HospName +"',HospName_Oth = '"+ _HospName_Oth +"',HaveRecords = '"+ _HaveRecords +"',DidRecordMatch2 = '"+ _DidRecordMatch2 +"',DaysOfHosp = '"+ _DaysOfHosp +"',DaysOfHospDK = '"+ _DaysOfHospDK +"',TAboIll = '"+ _TAboIll +"'  Where UNCode='"+ _UNCode +"' and StructureNo='"+ _StructureNo +"' and HouseholdSl='"+ _HouseholdSl +"' and VisitNo='"+ _VisitNo +"' and MemSl='"+ _MemSl +"'";
                 response = C.SaveData(SQL);
                 C.close();
              }
              catch(Exception  e)
              {
                 response = e.getMessage();
              }
           return response;
        }


        public List<TyphoidCase_DataModel> SelectAll(Context context, String SQL)
        {
            Connection C = new Connection(context);
            List<TyphoidCase_DataModel> data = new ArrayList<TyphoidCase_DataModel>();
            TyphoidCase_DataModel d = new TyphoidCase_DataModel();
            Cursor cur = C.ReadData(SQL);

            cur.moveToFirst();
            while(!cur.isAfterLast())
            {
                d = new TyphoidCase_DataModel();
                d._UNCode = cur.getString(cur.getColumnIndex("UNCode"));
                d._StructureNo = cur.getString(cur.getColumnIndex("StructureNo"));
                d._HouseholdSl = cur.getString(cur.getColumnIndex("HouseholdSl"));
                d._VisitNo = cur.getString(cur.getColumnIndex("VisitNo"));
                d._MemSl = cur.getString(cur.getColumnIndex("MemSl"));
                d._HaveFever = Integer.valueOf(cur.getString(cur.getColumnIndex("HaveFever")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("HaveFever")));
                d._AbdomPain = Integer.valueOf(cur.getString(cur.getColumnIndex("AbdomPain")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("AbdomPain")));
                d._Constipation = Integer.valueOf(cur.getString(cur.getColumnIndex("Constipation")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Constipation")));
                d._Headache = Integer.valueOf(cur.getString(cur.getColumnIndex("Headache")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Headache")));
                d._Rash = Integer.valueOf(cur.getString(cur.getColumnIndex("Rash")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Rash")));
                d._Diarrhoea = Integer.valueOf(cur.getString(cur.getColumnIndex("Diarrhoea")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Diarrhoea")));
                d._AbdomDist = Integer.valueOf(cur.getString(cur.getColumnIndex("AbdomDist")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("AbdomDist")));
                d._CoaTon = Integer.valueOf(cur.getString(cur.getColumnIndex("CoaTon")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("CoaTon")));
                d._Cough = Integer.valueOf(cur.getString(cur.getColumnIndex("Cough")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Cough")));
                d._Tnone = Integer.valueOf(cur.getString(cur.getColumnIndex("Tnone")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Tnone")));
                d._Other = Integer.valueOf(cur.getString(cur.getColumnIndex("Other")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Other")));
                d._TsymptOthName = cur.getString(cur.getColumnIndex("TsymptOthName"));
                d._TakenHCFacility = Integer.valueOf(cur.getString(cur.getColumnIndex("TakenHCFacility")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("TakenHCFacility")));
                d._HC_PhyMBBS = Integer.valueOf(cur.getString(cur.getColumnIndex("HC_PhyMBBS")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("HC_PhyMBBS")));
                d._HC_UnquaDoctor = Integer.valueOf(cur.getString(cur.getColumnIndex("HC_UnquaDoctor")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("HC_UnquaDoctor")));
                d._HC_Para = Integer.valueOf(cur.getString(cur.getColumnIndex("HC_Para")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("HC_Para")));
                d._HC_Com = Integer.valueOf(cur.getString(cur.getColumnIndex("HC_Com")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("HC_Com")));
                d._HC_Pha = Integer.valueOf(cur.getString(cur.getColumnIndex("HC_Pha")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("HC_Pha")));
                d._HC_Hompath = Integer.valueOf(cur.getString(cur.getColumnIndex("HC_Hompath")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("HC_Hompath")));
                d._HC_TrHeal = Integer.valueOf(cur.getString(cur.getColumnIndex("HC_TrHeal")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("HC_TrHeal")));
                d._HC_SpiHeal = Integer.valueOf(cur.getString(cur.getColumnIndex("HC_SpiHeal")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("HC_SpiHeal")));
                d._THC_Oth = Integer.valueOf(cur.getString(cur.getColumnIndex("THC_Oth")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("THC_Oth")));
                d._THC_OthName = cur.getString(cur.getColumnIndex("THC_OthName"));
                d._HC_Hosp = Integer.valueOf(cur.getString(cur.getColumnIndex("HC_Hosp")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("HC_Hosp")));
                d._HC_Hosp_a1 = Integer.valueOf(cur.getString(cur.getColumnIndex("HC_Hosp_a1")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("HC_Hosp_a1")));
                d._HC_Hosp_a1_Oth = cur.getString(cur.getColumnIndex("HC_Hosp_a1_Oth"));
                d._HC_Hosp_a2 = Integer.valueOf(cur.getString(cur.getColumnIndex("HC_Hosp_a2")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("HC_Hosp_a2")));
                d._HC_Hosp_a2_Oth = cur.getString(cur.getColumnIndex("HC_Hosp_a2_Oth"));
                d._HC_Hosp_a3 = Integer.valueOf(cur.getString(cur.getColumnIndex("HC_Hosp_a3")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("HC_Hosp_a3")));
                d._HC_Hosp_a3_Oth = cur.getString(cur.getColumnIndex("HC_Hosp_a3_Oth"));
                d._HC_Hosp_a4 = Integer.valueOf(cur.getString(cur.getColumnIndex("HC_Hosp_a4")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("HC_Hosp_a4")));
                d._HC_Hosp_a4_Oth = cur.getString(cur.getColumnIndex("HC_Hosp_a4_Oth"));
                d._HC_Hosp_a5 = Integer.valueOf(cur.getString(cur.getColumnIndex("HC_Hosp_a5")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("HC_Hosp_a5")));
                d._HC_Hosp_a5_Oth = cur.getString(cur.getColumnIndex("HC_Hosp_a5_Oth"));
                d._HC_Hosp_b = Integer.valueOf(cur.getString(cur.getColumnIndex("HC_Hosp_b")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("HC_Hosp_b")));
                d._HC_Hosp_b_i = Integer.valueOf(cur.getString(cur.getColumnIndex("HC_Hosp_b_i")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("HC_Hosp_b_i")));
                d._HC_Clin = Integer.valueOf(cur.getString(cur.getColumnIndex("HC_Clin")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("HC_Clin")));
                d._HC_Phy = Integer.valueOf(cur.getString(cur.getColumnIndex("HC_Phy")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("HC_Phy")));
                d._DaysOfSymp = Integer.valueOf(cur.getString(cur.getColumnIndex("DaysOfSymp")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("DaysOfSymp")));
                d._DaysOfSympDK = Integer.valueOf(cur.getString(cur.getColumnIndex("DaysOfSympDK")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("DaysOfSympDK")));
                d._WorstHour = Integer.valueOf(cur.getString(cur.getColumnIndex("WorstHour")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("WorstHour")));
                d._WorstHourDK = Integer.valueOf(cur.getString(cur.getColumnIndex("WorstHourDK")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("WorstHourDK")));
                d._DaysOfUnable = Integer.valueOf(cur.getString(cur.getColumnIndex("DaysOfUnable")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("DaysOfUnable")));
                d._DaysOfUnableDK = Integer.valueOf(cur.getString(cur.getColumnIndex("DaysOfUnableDK")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("DaysOfUnableDK")));
                d._TAdmHos = Integer.valueOf(cur.getString(cur.getColumnIndex("TAdmHos")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("TAdmHos")));
                d._THosNam = Integer.valueOf(cur.getString(cur.getColumnIndex("THosNam")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("THosNam")));
                d._THosNam_Oth = cur.getString(cur.getColumnIndex("THosNam_Oth"));
                d._THosNam2 = Integer.valueOf(cur.getString(cur.getColumnIndex("THosNam2")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("THosNam2")));
                d._THosNam2_Oth = cur.getString(cur.getColumnIndex("THosNam2_Oth"));
                d._THosNam3 = Integer.valueOf(cur.getString(cur.getColumnIndex("THosNam3")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("THosNam3")));
                d._THosNam3_Oth = cur.getString(cur.getColumnIndex("THosNam3_Oth"));
                d._THosNamDK = Integer.valueOf(cur.getString(cur.getColumnIndex("THosNamDK")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("THosNamDK")));
                d._TDtAdmHos = cur.getString(cur.getColumnIndex("TDtAdmHos"));
                d._TAdmHosD = Integer.valueOf(cur.getString(cur.getColumnIndex("TAdmHosD")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("TAdmHosD")));
                d._TDurIlBeHos = Integer.valueOf(cur.getString(cur.getColumnIndex("TDurIlBeHos")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("TDurIlBeHos")));
                d._TDurIlBeHosDK = Integer.valueOf(cur.getString(cur.getColumnIndex("TDurIlBeHosDK")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("TDurIlBeHosDK")));
                d._TDisDr = Integer.valueOf(cur.getString(cur.getColumnIndex("TDisDr")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("TDisDr")));
                d._TDisDrOth = cur.getString(cur.getColumnIndex("TDisDrOth"));
                d._TReco = Integer.valueOf(cur.getString(cur.getColumnIndex("TReco")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("TReco")));
                d._TDurReco = Integer.valueOf(cur.getString(cur.getColumnIndex("TDurReco")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("TDurReco")));
                d._TInReco = Integer.valueOf(cur.getString(cur.getColumnIndex("TInReco")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("TInReco")));
                d._TInRecoOth = cur.getString(cur.getColumnIndex("TInRecoOth"));
                d._TInReco2 = Integer.valueOf(cur.getString(cur.getColumnIndex("TInReco2")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("TInReco2")));
                d._TInRecoOth2 = cur.getString(cur.getColumnIndex("TInRecoOth2"));
                d._HaveHosp = Integer.valueOf(cur.getString(cur.getColumnIndex("HaveHosp")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("HaveHosp")));
                d._HospName = Integer.valueOf(cur.getString(cur.getColumnIndex("HospName")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("HospName")));
                d._HospName_Oth = cur.getString(cur.getColumnIndex("HospName_Oth"));
                d._HaveRecords = Integer.valueOf(cur.getString(cur.getColumnIndex("HaveRecords")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("HaveRecords")));
                d._DidRecordMatch2 = Integer.valueOf(cur.getString(cur.getColumnIndex("DidRecordMatch2")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("DidRecordMatch2")));
                d._DaysOfHosp = Integer.valueOf(cur.getString(cur.getColumnIndex("DaysOfHosp")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("DaysOfHosp")));
                d._DaysOfHospDK = Integer.valueOf(cur.getString(cur.getColumnIndex("DaysOfHospDK")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("DaysOfHospDK")));
                d._TAboIll = cur.getString(cur.getColumnIndex("TAboIll"));
                data.add(d);

                cur.moveToNext();
            }
            cur.close();
          return data;
        }
 }