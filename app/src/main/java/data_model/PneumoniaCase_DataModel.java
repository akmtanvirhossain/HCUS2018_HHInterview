package data_model;
 import android.content.Context;
 import android.database.Cursor;
 import Common.Connection;
 import java.util.ArrayList;
 import java.util.List;
 import java.util.Date;
 public class PneumoniaCase_DataModel{

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
        private int _PDSign = 0;
        public int getPDSign(){
              return _PDSign;
         }
        public void setPDSign(int newValue){
              _PDSign = newValue;
         }
        private int _PEpiIlness = 0;
        public int getPEpiIlness(){
              return _PEpiIlness;
         }
        public void setPEpiIlness(int newValue){
              _PEpiIlness = newValue;
         }
        private int _PFever = 0;
        public int getPFever(){
              return _PFever;
         }
        public void setPFever(int newValue){
              _PFever = newValue;
         }
        private int _PDurFever = 0;
        public int getPDurFever(){
              return _PDurFever;
         }
        public void setPDurFever(int newValue){
              _PDurFever = newValue;
         }
        private int _PCough = 0;
        public int getPCough(){
              return _PCough;
         }
        public void setPCough(int newValue){
              _PCough = newValue;
         }
        private int _PDurCough = 0;
        public int getPDurCough(){
              return _PDurCough;
         }
        public void setPDurCough(int newValue){
              _PDurCough = newValue;
         }
        private int _PDifBrea = 0;
        public int getPDifBrea(){
              return _PDifBrea;
         }
        public void setPDifBrea(int newValue){
              _PDifBrea = newValue;
         }
        private int _PDurDifBrea = 0;
        public int getPDurDifBrea(){
              return _PDurDifBrea;
         }
        public void setPDurDifBrea(int newValue){
              _PDurDifBrea = newValue;
         }
        private int _PTurnBlue = 0;
        public int getPTurnBlue(){
              return _PTurnBlue;
         }
        public void setPTurnBlue(int newValue){
              _PTurnBlue = newValue;
         }
        private int _PDurTurnBlue = 0;
        public int getPDurTurnBlue(){
              return _PDurTurnBlue;
         }
        public void setPDurTurnBlue(int newValue){
              _PDurTurnBlue = newValue;
         }
        private int _PBreatNois = 0;
        public int getPBreatNois(){
              return _PBreatNois;
         }
        public void setPBreatNois(int newValue){
              _PBreatNois = newValue;
         }
        private int _PDurBreatNois = 0;
        public int getPDurBreatNois(){
              return _PDurBreatNois;
         }
        public void setPDurBreatNois(int newValue){
              _PDurBreatNois = newValue;
         }
        private int _PLethargy = 0;
        public int getPLethargy(){
              return _PLethargy;
         }
        public void setPLethargy(int newValue){
              _PLethargy = newValue;
         }
        private int _PDurLethargy = 0;
        public int getPDurLethargy(){
              return _PDurLethargy;
         }
        public void setPDurLethargy(int newValue){
              _PDurLethargy = newValue;
         }
        private int _PUnDriBfeed = 0;
        public int getPUnDriBfeed(){
              return _PUnDriBfeed;
         }
        public void setPUnDriBfeed(int newValue){
              _PUnDriBfeed = newValue;
         }
        private int _PDurUnDriBfeed = 0;
        public int getPDurUnDriBfeed(){
              return _PDurUnDriBfeed;
         }
        public void setPDurUnDriBfeed(int newValue){
              _PDurUnDriBfeed = newValue;
         }
        private int _PVomit = 0;
        public int getPVomit(){
              return _PVomit;
         }
        public void setPVomit(int newValue){
              _PVomit = newValue;
         }
        private int _PConv = 0;
        public int getPConv(){
              return _PConv;
         }
        public void setPConv(int newValue){
              _PConv = newValue;
         }
        private int _PUpRolEye = 0;
        public int getPUpRolEye(){
              return _PUpRolEye;
         }
        public void setPUpRolEye(int newValue){
              _PUpRolEye = newValue;
         }
        private int _PRigJaw = 0;
        public int getPRigJaw(){
              return _PRigJaw;
         }
        public void setPRigJaw(int newValue){
              _PRigJaw = newValue;
         }
        private int _PRigLim = 0;
        public int getPRigLim(){
              return _PRigLim;
         }
        public void setPRigLim(int newValue){
              _PRigLim = newValue;
         }
        private int _PDurConv = 0;
        public int getPDurConv(){
              return _PDurConv;
         }
        public void setPDurConv(int newValue){
              _PDurConv = newValue;
         }
        private int _PUncons = 0;
        public int getPUncons(){
              return _PUncons;
         }
        public void setPUncons(int newValue){
              _PUncons = newValue;
         }
        private int _PDurUncons = 0;
        public int getPDurUncons(){
              return _PDurUncons;
         }
        public void setPDurUncons(int newValue){
              _PDurUncons = newValue;
         }
        private int _PIlHCar = 0;
        public int getPIlHCar(){
              return _PIlHCar;
         }
        public void setPIlHCar(int newValue){
              _PIlHCar = newValue;
         }
        private int _PHC_PhyMBBS = 0;
        public int getPHC_PhyMBBS(){
              return _PHC_PhyMBBS;
         }
        public void setPHC_PhyMBBS(int newValue){
              _PHC_PhyMBBS = newValue;
         }
        private int _PHC_UnquaDoctor = 0;
        public int getPHC_UnquaDoctor(){
              return _PHC_UnquaDoctor;
         }
        public void setPHC_UnquaDoctor(int newValue){
              _PHC_UnquaDoctor = newValue;
         }
        private int _PHC_Para = 0;
        public int getPHC_Para(){
              return _PHC_Para;
         }
        public void setPHC_Para(int newValue){
              _PHC_Para = newValue;
         }
        private int _PHC_Com = 0;
        public int getPHC_Com(){
              return _PHC_Com;
         }
        public void setPHC_Com(int newValue){
              _PHC_Com = newValue;
         }
        private int _PHC_Pha = 0;
        public int getPHC_Pha(){
              return _PHC_Pha;
         }
        public void setPHC_Pha(int newValue){
              _PHC_Pha = newValue;
         }
        private int _HC_Hompath = 0;
        public int getHC_Hompath(){
              return _HC_Hompath;
         }
        public void setHC_Hompath(int newValue){
              _HC_Hompath = newValue;
         }
        private int _PHC_TrHeal = 0;
        public int getPHC_TrHeal(){
              return _PHC_TrHeal;
         }
        public void setPHC_TrHeal(int newValue){
              _PHC_TrHeal = newValue;
         }
        private int _PHC_SpiHeal = 0;
        public int getPHC_SpiHeal(){
              return _PHC_SpiHeal;
         }
        public void setPHC_SpiHeal(int newValue){
              _PHC_SpiHeal = newValue;
         }
        private int _PHC_Oth = 0;
        public int getPHC_Oth(){
              return _PHC_Oth;
         }
        public void setPHC_Oth(int newValue){
              _PHC_Oth = newValue;
         }
        private String _PHC_OthName = "";
        public String getPHC_OthName(){
              return _PHC_OthName;
         }
        public void setPHC_OthName(String newValue){
              _PHC_OthName = newValue;
         }
        private int _PDSHOPD = 0;
        public int getPDSHOPD(){
              return _PDSHOPD;
         }
        public void setPDSHOPD(int newValue){
              _PDSHOPD = newValue;
         }
        private int _PSSFOPD = 0;
        public int getPSSFOPD(){
              return _PSSFOPD;
         }
        public void setPSSFOPD(int newValue){
              _PSSFOPD = newValue;
         }
        private int _PAdmHos = 0;
        public int getPAdmHos(){
              return _PAdmHos;
         }
        public void setPAdmHos(int newValue){
              _PAdmHos = newValue;
         }
        private int _PHosNam = 0;
        public int getPHosNam(){
              return _PHosNam;
         }
        public void setPHosNam(int newValue){
              _PHosNam = newValue;
         }
        private String _PHosNamOth = "";
        public String getPHosNamOth(){
              return _PHosNamOth;
         }
        public void setPHosNamOth(String newValue){
              _PHosNamOth = newValue;
         }
        private int _PHosNam2 = 0;
        public int getPHosNam2(){
              return _PHosNam2;
         }
        public void setPHosNam2(int newValue){
              _PHosNam2 = newValue;
         }
        private String _PHosNamOth2 = "";
        public String getPHosNamOth2(){
              return _PHosNamOth2;
         }
        public void setPHosNamOth2(String newValue){
              _PHosNamOth2 = newValue;
         }
        private int _PHosNam3 = 0;
        public int getPHosNam3(){
              return _PHosNam3;
         }
        public void setPHosNam3(int newValue){
              _PHosNam3 = newValue;
         }
        private String _PHosNamOth3 = "";
        public String getPHosNamOth3(){
              return _PHosNamOth3;
         }
        public void setPHosNamOth3(String newValue){
              _PHosNamOth3 = newValue;
         }
        private String _PDtAdmHos = "";
        public String getPDtAdmHos(){
              return _PDtAdmHos;
         }
        public void setPDtAdmHos(String newValue){
              _PDtAdmHos = newValue;
         }
        private int _PAdmHosM = 0;
        public int getPAdmHosM(){
              return _PAdmHosM;
         }
        public void setPAdmHosM(int newValue){
              _PAdmHosM = newValue;
         }
        private int _PDurIlBeHos = 0;
        public int getPDurIlBeHos(){
              return _PDurIlBeHos;
         }
        public void setPDurIlBeHos(int newValue){
              _PDurIlBeHos = newValue;
         }
        private int _PDisDr = 0;
        public int getPDisDr(){
              return _PDisDr;
         }
        public void setPDisDr(int newValue){
              _PDisDr = newValue;
         }
        private String _PDisDrOth = "";
        public String getPDisDrOth(){
              return _PDisDrOth;
         }
        public void setPDisDrOth(String newValue){
              _PDisDrOth = newValue;
         }
        private int _PReco = 0;
        public int getPReco(){
              return _PReco;
         }
        public void setPReco(int newValue){
              _PReco = newValue;
         }
        private int _PDurReco = 0;
        public int getPDurReco(){
              return _PDurReco;
         }
        public void setPDurReco(int newValue){
              _PDurReco = newValue;
         }
        private String _PAboIll = "";
        public String getPAboIll(){
              return _PAboIll;
         }
        public void setPAboIll(String newValue){
              _PAboIll = newValue;
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

        String TableName = "PneumoniaCase";

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
                 SQL = "Insert into "+ TableName +" (UNCode,StructureNo,HouseholdSl,VisitNo,MemSl,PDSign,PEpiIlness,PFever,PDurFever,PCough,PDurCough,PDifBrea,PDurDifBrea,PTurnBlue,PDurTurnBlue,PBreatNois,PDurBreatNois,PLethargy,PDurLethargy,PUnDriBfeed,PDurUnDriBfeed,PVomit,PConv,PUpRolEye,PRigJaw,PRigLim,PDurConv,PUncons,PDurUncons,PIlHCar,PHC_PhyMBBS,PHC_UnquaDoctor,PHC_Para,PHC_Com,PHC_Pha,HC_Hompath,PHC_TrHeal,PHC_SpiHeal,PHC_Oth,PHC_OthName,PDSHOPD,PSSFOPD,PAdmHos,PHosNam,PHosNamOth,PHosNam2,PHosNamOth2,PHosNam3,PHosNamOth3,PDtAdmHos,PAdmHosM,PDurIlBeHos,PDisDr,PDisDrOth,PReco,PDurReco,PAboIll,StartTime,EndTime,DeviceID,EntryUser,Lat,Lon,EnDt,Upload,modifyDate)Values('"+ _UNCode +"', '"+ _StructureNo +"', '"+ _HouseholdSl +"', '"+ _VisitNo +"', '"+ _MemSl +"', '"+ _PDSign +"', '"+ _PEpiIlness +"', '"+ _PFever +"', '"+ _PDurFever +"', '"+ _PCough +"', '"+ _PDurCough +"', '"+ _PDifBrea +"', '"+ _PDurDifBrea +"', '"+ _PTurnBlue +"', '"+ _PDurTurnBlue +"', '"+ _PBreatNois +"', '"+ _PDurBreatNois +"', '"+ _PLethargy +"', '"+ _PDurLethargy +"', '"+ _PUnDriBfeed +"', '"+ _PDurUnDriBfeed +"', '"+ _PVomit +"', '"+ _PConv +"', '"+ _PUpRolEye +"', '"+ _PRigJaw +"', '"+ _PRigLim +"', '"+ _PDurConv +"', '"+ _PUncons +"', '"+ _PDurUncons +"', '"+ _PIlHCar +"', '"+ _PHC_PhyMBBS +"', '"+ _PHC_UnquaDoctor +"', '"+ _PHC_Para +"', '"+ _PHC_Com +"', '"+ _PHC_Pha +"', '"+ _HC_Hompath +"', '"+ _PHC_TrHeal +"', '"+ _PHC_SpiHeal +"', '"+ _PHC_Oth +"', '"+ _PHC_OthName +"', '"+ _PDSHOPD +"', '"+ _PSSFOPD +"', '"+ _PAdmHos +"', '"+ _PHosNam +"', '"+ _PHosNamOth +"', '"+ _PHosNam2 +"', '"+ _PHosNamOth2 +"', '"+ _PHosNam3 +"', '"+ _PHosNamOth3 +"', '"+ _PDtAdmHos +"', '"+ _PAdmHosM +"', '"+ _PDurIlBeHos +"', '"+ _PDisDr +"', '"+ _PDisDrOth +"', '"+ _PReco +"', '"+ _PDurReco +"', '"+ _PAboIll +"', '"+ _StartTime +"', '"+ _EndTime +"', '"+ _DeviceID +"', '"+ _EntryUser +"', '"+ _Lat +"', '"+ _Lon +"', '"+ _EnDt +"', '"+ _Upload +"', '"+ _modifyDate +"')";
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
                 SQL = "Update "+ TableName +" Set Upload='2',modifyDate='" + _modifyDate + "' ,UNCode = '"+ _UNCode +"',StructureNo = '"+ _StructureNo +"',HouseholdSl = '"+ _HouseholdSl +"',VisitNo = '"+ _VisitNo +"',MemSl = '"+ _MemSl +"',PDSign = '"+ _PDSign +"',PEpiIlness = '"+ _PEpiIlness +"',PFever = '"+ _PFever +"',PDurFever = '"+ _PDurFever +"',PCough = '"+ _PCough +"',PDurCough = '"+ _PDurCough +"',PDifBrea = '"+ _PDifBrea +"',PDurDifBrea = '"+ _PDurDifBrea +"',PTurnBlue = '"+ _PTurnBlue +"',PDurTurnBlue = '"+ _PDurTurnBlue +"',PBreatNois = '"+ _PBreatNois +"',PDurBreatNois = '"+ _PDurBreatNois +"',PLethargy = '"+ _PLethargy +"',PDurLethargy = '"+ _PDurLethargy +"',PUnDriBfeed = '"+ _PUnDriBfeed +"',PDurUnDriBfeed = '"+ _PDurUnDriBfeed +"',PVomit = '"+ _PVomit +"',PConv = '"+ _PConv +"',PUpRolEye = '"+ _PUpRolEye +"',PRigJaw = '"+ _PRigJaw +"',PRigLim = '"+ _PRigLim +"',PDurConv = '"+ _PDurConv +"',PUncons = '"+ _PUncons +"',PDurUncons = '"+ _PDurUncons +"',PIlHCar = '"+ _PIlHCar +"',PHC_PhyMBBS = '"+ _PHC_PhyMBBS +"',PHC_UnquaDoctor = '"+ _PHC_UnquaDoctor +"',PHC_Para = '"+ _PHC_Para +"',PHC_Com = '"+ _PHC_Com +"',PHC_Pha = '"+ _PHC_Pha +"',HC_Hompath = '"+ _HC_Hompath +"',PHC_TrHeal = '"+ _PHC_TrHeal +"',PHC_SpiHeal = '"+ _PHC_SpiHeal +"',PHC_Oth = '"+ _PHC_Oth +"',PHC_OthName = '"+ _PHC_OthName +"',PDSHOPD = '"+ _PDSHOPD +"',PSSFOPD = '"+ _PSSFOPD +"',PAdmHos = '"+ _PAdmHos +"',PHosNam = '"+ _PHosNam +"',PHosNamOth = '"+ _PHosNamOth +"',PHosNam2 = '"+ _PHosNam2 +"',PHosNamOth2 = '"+ _PHosNamOth2 +"',PHosNam3 = '"+ _PHosNam3 +"',PHosNamOth3 = '"+ _PHosNamOth3 +"',PDtAdmHos = '"+ _PDtAdmHos +"',PAdmHosM = '"+ _PAdmHosM +"',PDurIlBeHos = '"+ _PDurIlBeHos +"',PDisDr = '"+ _PDisDr +"',PDisDrOth = '"+ _PDisDrOth +"',PReco = '"+ _PReco +"',PDurReco = '"+ _PDurReco +"',PAboIll = '"+ _PAboIll +"'  Where UNCode='"+ _UNCode +"' and StructureNo='"+ _StructureNo +"' and HouseholdSl='"+ _HouseholdSl +"' and VisitNo='"+ _VisitNo +"' and MemSl='"+ _MemSl +"' and DeviceID='"+_DeviceID+"'";
                 response = C.SaveData(SQL);
                 C.close();
              }
              catch(Exception  e)
              {
                 response = e.getMessage();
              }
           return response;
        }


        public List<PneumoniaCase_DataModel> SelectAll(Context context, String SQL)
        {
            Connection C = new Connection(context);
            List<PneumoniaCase_DataModel> data = new ArrayList<PneumoniaCase_DataModel>();
            PneumoniaCase_DataModel d = new PneumoniaCase_DataModel();
            Cursor cur = C.ReadData(SQL);

            cur.moveToFirst();
            while(!cur.isAfterLast())
            {
                d = new PneumoniaCase_DataModel();
                d._UNCode = cur.getString(cur.getColumnIndex("UNCode"));
                d._StructureNo = cur.getString(cur.getColumnIndex("StructureNo"));
                d._HouseholdSl = cur.getString(cur.getColumnIndex("HouseholdSl"));
                d._VisitNo = cur.getString(cur.getColumnIndex("VisitNo"));
                d._MemSl = cur.getString(cur.getColumnIndex("MemSl"));
                d._PDSign = Integer.valueOf(cur.getString(cur.getColumnIndex("PDSign")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PDSign")));
                d._PEpiIlness = Integer.valueOf(cur.getString(cur.getColumnIndex("PEpiIlness")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PEpiIlness")));
                d._PFever = Integer.valueOf(cur.getString(cur.getColumnIndex("PFever")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PFever")));
                d._PDurFever = Integer.valueOf(cur.getString(cur.getColumnIndex("PDurFever")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PDurFever")));
                d._PCough = Integer.valueOf(cur.getString(cur.getColumnIndex("PCough")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PCough")));
                d._PDurCough = Integer.valueOf(cur.getString(cur.getColumnIndex("PDurCough")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PDurCough")));
                d._PDifBrea = Integer.valueOf(cur.getString(cur.getColumnIndex("PDifBrea")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PDifBrea")));
                d._PDurDifBrea = Integer.valueOf(cur.getString(cur.getColumnIndex("PDurDifBrea")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PDurDifBrea")));
                d._PTurnBlue = Integer.valueOf(cur.getString(cur.getColumnIndex("PTurnBlue")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PTurnBlue")));
                d._PDurTurnBlue = Integer.valueOf(cur.getString(cur.getColumnIndex("PDurTurnBlue")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PDurTurnBlue")));
                d._PBreatNois = Integer.valueOf(cur.getString(cur.getColumnIndex("PBreatNois")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PBreatNois")));
                d._PDurBreatNois = Integer.valueOf(cur.getString(cur.getColumnIndex("PDurBreatNois")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PDurBreatNois")));
                d._PLethargy = Integer.valueOf(cur.getString(cur.getColumnIndex("PLethargy")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PLethargy")));
                d._PDurLethargy = Integer.valueOf(cur.getString(cur.getColumnIndex("PDurLethargy")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PDurLethargy")));
                d._PUnDriBfeed = Integer.valueOf(cur.getString(cur.getColumnIndex("PUnDriBfeed")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PUnDriBfeed")));
                d._PDurUnDriBfeed = Integer.valueOf(cur.getString(cur.getColumnIndex("PDurUnDriBfeed")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PDurUnDriBfeed")));
                d._PVomit = Integer.valueOf(cur.getString(cur.getColumnIndex("PVomit")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PVomit")));
                d._PConv = Integer.valueOf(cur.getString(cur.getColumnIndex("PConv")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PConv")));
                d._PUpRolEye = Integer.valueOf(cur.getString(cur.getColumnIndex("PUpRolEye")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PUpRolEye")));
                d._PRigJaw = Integer.valueOf(cur.getString(cur.getColumnIndex("PRigJaw")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PRigJaw")));
                d._PRigLim = Integer.valueOf(cur.getString(cur.getColumnIndex("PRigLim")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PRigLim")));
                d._PDurConv = Integer.valueOf(cur.getString(cur.getColumnIndex("PDurConv")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PDurConv")));
                d._PUncons = Integer.valueOf(cur.getString(cur.getColumnIndex("PUncons")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PUncons")));
                d._PDurUncons = Integer.valueOf(cur.getString(cur.getColumnIndex("PDurUncons")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PDurUncons")));
                d._PIlHCar = Integer.valueOf(cur.getString(cur.getColumnIndex("PIlHCar")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PIlHCar")));
                d._PHC_PhyMBBS = Integer.valueOf(cur.getString(cur.getColumnIndex("PHC_PhyMBBS")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PHC_PhyMBBS")));
                d._PHC_UnquaDoctor = Integer.valueOf(cur.getString(cur.getColumnIndex("PHC_UnquaDoctor")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PHC_UnquaDoctor")));
                d._PHC_Para = Integer.valueOf(cur.getString(cur.getColumnIndex("PHC_Para")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PHC_Para")));
                d._PHC_Com = Integer.valueOf(cur.getString(cur.getColumnIndex("PHC_Com")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PHC_Com")));
                d._PHC_Pha = Integer.valueOf(cur.getString(cur.getColumnIndex("PHC_Pha")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PHC_Pha")));
                d._HC_Hompath = Integer.valueOf(cur.getString(cur.getColumnIndex("HC_Hompath")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("HC_Hompath")));
                d._PHC_TrHeal = Integer.valueOf(cur.getString(cur.getColumnIndex("PHC_TrHeal")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PHC_TrHeal")));
                d._PHC_SpiHeal = Integer.valueOf(cur.getString(cur.getColumnIndex("PHC_SpiHeal")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PHC_SpiHeal")));
                d._PHC_Oth = Integer.valueOf(cur.getString(cur.getColumnIndex("PHC_Oth")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PHC_Oth")));
                d._PHC_OthName = cur.getString(cur.getColumnIndex("PHC_OthName"));
                d._PDSHOPD = Integer.valueOf(cur.getString(cur.getColumnIndex("PDSHOPD")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PDSHOPD")));
                d._PSSFOPD = Integer.valueOf(cur.getString(cur.getColumnIndex("PSSFOPD")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PSSFOPD")));
                d._PAdmHos = Integer.valueOf(cur.getString(cur.getColumnIndex("PAdmHos")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PAdmHos")));
                d._PHosNam = Integer.valueOf(cur.getString(cur.getColumnIndex("PHosNam")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PHosNam")));
                d._PHosNamOth = cur.getString(cur.getColumnIndex("PHosNamOth"));
                d._PHosNam2 = Integer.valueOf(cur.getString(cur.getColumnIndex("PHosNam2")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PHosNam2")));
                d._PHosNamOth2 = cur.getString(cur.getColumnIndex("PHosNamOth2"));
                d._PHosNam3 = Integer.valueOf(cur.getString(cur.getColumnIndex("PHosNam3")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PHosNam3")));
                d._PHosNamOth3 = cur.getString(cur.getColumnIndex("PHosNamOth3"));
                d._PDtAdmHos = cur.getString(cur.getColumnIndex("PDtAdmHos"));
                d._PAdmHosM = Integer.valueOf(cur.getString(cur.getColumnIndex("PAdmHosM")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PAdmHosM")));
                d._PDurIlBeHos = Integer.valueOf(cur.getString(cur.getColumnIndex("PDurIlBeHos")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PDurIlBeHos")));
                d._PDisDr = Integer.valueOf(cur.getString(cur.getColumnIndex("PDisDr")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PDisDr")));
                d._PDisDrOth = cur.getString(cur.getColumnIndex("PDisDrOth"));
                d._PReco = Integer.valueOf(cur.getString(cur.getColumnIndex("PReco")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PReco")));
                d._PDurReco = Integer.valueOf(cur.getString(cur.getColumnIndex("PDurReco")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PDurReco")));
                d._PAboIll = cur.getString(cur.getColumnIndex("PAboIll"));
                data.add(d);

                cur.moveToNext();
            }
            cur.close();
          return data;
        }
 }