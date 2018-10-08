package data_model;
 import android.content.Context;
 import android.database.Cursor;
 import Common.Connection;
 import java.util.ArrayList;
 import java.util.List;
 import java.util.Date;
 public class Household_Interview_DataModel{

        private String _UNCode = "";
        public String getUNCode(){
              return _UNCode;
         }
        public void setUNCode(String newValue){
              _UNCode = newValue;
         }
        private int _StructureNo = 0;
        public int getStructureNo(){
              return _StructureNo;
         }
        public void setStructureNo(int newValue){
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
        private int _FHeadAvail = 0;
        public int getFHeadAvail(){
              return _FHeadAvail;
         }
        public void setFHeadAvail(int newValue){
              _FHeadAvail = newValue;
         }
        private int _RelWithFHead = 0;
        public int getRelWithFHead(){
              return _RelWithFHead;
         }
        public void setRelWithFHead(int newValue){
              _RelWithFHead = newValue;
         }
        private String _OthRelWithFHead = "";
        public String getOthRelWithFHead(){
              return _OthRelWithFHead;
         }
        public void setOthRelWithFHead(String newValue){
              _OthRelWithFHead = newValue;
         }
        private String _FirstName = "";
        public String getFirstName(){
              return _FirstName;
         }
        public void setFirstName(String newValue){
              _FirstName = newValue;
         }
        private int _EduLevelFHead = 0;
        public int getEduLevelFHead(){
              return _EduLevelFHead;
         }
        public void setEduLevelFHead(int newValue){
              _EduLevelFHead = newValue;
         }
        private int _EduLevelMHead = 0;
        public int getEduLevelMHead(){
              return _EduLevelMHead;
         }
        public void setEduLevelMHead(int newValue){
              _EduLevelMHead = newValue;
         }
        private int _liveHouseM = 0;
        public int getliveHouseM(){
              return _liveHouseM;
         }
        public void setliveHouseM(int newValue){
              _liveHouseM = newValue;
         }
        private int _liveHouseY = 0;
        public int getliveHouseY(){
              return _liveHouseY;
         }
        public void setliveHouseY(int newValue){
              _liveHouseY = newValue;
         }
        private int _LiveHH_Mon = 0;
        public int getLiveHH_Mon(){
              return _LiveHH_Mon;
         }
        public void setLiveHH_Mon(int newValue){
              _LiveHH_Mon = newValue;
         }
        private int _LiveHH_Year = 0;
        public int getLiveHH_Year(){
              return _LiveHH_Year;
         }
        public void setLiveHH_Year(int newValue){
              _LiveHH_Year = newValue;
         }
        private int _LiveCity_Mon = 0;
        public int getLiveCity_Mon(){
              return _LiveCity_Mon;
         }
        public void setLiveCity_Mon(int newValue){
              _LiveCity_Mon = newValue;
         }
        private int _LiveCity_Year = 0;
        public int getLiveCity_Year(){
              return _LiveCity_Year;
         }
        public void setLiveCity_Year(int newValue){
              _LiveCity_Year = newValue;
         }
        private int _Hlive12m = 0;
        public int getHlive12m(){
              return _Hlive12m;
         }
        public void setHlive12m(int newValue){
              _Hlive12m = newValue;
         }
        private int _ChangedHouse = 0;
        public int getChangedHouse(){
              return _ChangedHouse;
         }
        public void setChangedHouse(int newValue){
              _ChangedHouse = newValue;
         }
        private int _DistHome = 0;
        public int getDistHome(){
              return _DistHome;
         }
        public void setDistHome(int newValue){
              _DistHome = newValue;
         }
        private int _ChildHcare = 0;
        public int getChildHcare(){
              return _ChildHcare;
         }
        public void setChildHcare(int newValue){
              _ChildHcare = newValue;
         }
        private String _ChildHcareOth = "";
        public String getChildHcareOth(){
              return _ChildHcareOth;
         }
        public void setChildHcareOth(String newValue){
              _ChildHcareOth = newValue;
         }
        private int _MotherEdu = 0;
        public int getMotherEdu(){
              return _MotherEdu;
         }
        public void setMotherEdu(int newValue){
              _MotherEdu = newValue;
         }
        private int _HeadOcp = 0;
        public int getHeadOcp(){
              return _HeadOcp;
         }
        public void setHeadOcp(int newValue){
              _HeadOcp = newValue;
         }
        private String _HeadOcpOth = "";
        public String getHeadOcpOth(){
              return _HeadOcpOth;
         }
        public void setHeadOcpOth(String newValue){
              _HeadOcpOth = newValue;
         }
        private int _Room = 0;
        public int getRoom(){
              return _Room;
         }
        public void setRoom(int newValue){
              _Room = newValue;
         }
        private int _BedRoom = 0;
        public int getBedRoom(){
              return _BedRoom;
         }
        public void setBedRoom(int newValue){
              _BedRoom = newValue;
         }
        private int _Electricity = 0;
        public int getElectricity(){
              return _Electricity;
         }
        public void setElectricity(int newValue){
              _Electricity = newValue;
         }
        private int _Radio = 0;
        public int getRadio(){
              return _Radio;
         }
        public void setRadio(int newValue){
              _Radio = newValue;
         }
        private int _Television = 0;
        public int getTelevision(){
              return _Television;
         }
        public void setTelevision(int newValue){
              _Television = newValue;
         }
        private int _NonMobileTele = 0;
        public int getNonMobileTele(){
              return _NonMobileTele;
         }
        public void setNonMobileTele(int newValue){
              _NonMobileTele = newValue;
         }
        private int _Computer = 0;
        public int getComputer(){
              return _Computer;
         }
        public void setComputer(int newValue){
              _Computer = newValue;
         }
        private int _Refrigerator = 0;
        public int getRefrigerator(){
              return _Refrigerator;
         }
        public void setRefrigerator(int newValue){
              _Refrigerator = newValue;
         }
        private int _Watch = 0;
        public int getWatch(){
              return _Watch;
         }
        public void setWatch(int newValue){
              _Watch = newValue;
         }
        private int _MobilePhone = 0;
        public int getMobilePhone(){
              return _MobilePhone;
         }
        public void setMobilePhone(int newValue){
              _MobilePhone = newValue;
         }
        private int _Bicycle = 0;
        public int getBicycle(){
              return _Bicycle;
         }
        public void setBicycle(int newValue){
              _Bicycle = newValue;
         }
        private int _MotorcycleScooter = 0;
        public int getMotorcycleScooter(){
              return _MotorcycleScooter;
         }
        public void setMotorcycleScooter(int newValue){
              _MotorcycleScooter = newValue;
         }
        private int _AnimalDrawnCart = 0;
        public int getAnimalDrawnCart(){
              return _AnimalDrawnCart;
         }
        public void setAnimalDrawnCart(int newValue){
              _AnimalDrawnCart = newValue;
         }
        private int _CarOrTruck = 0;
        public int getCarOrTruck(){
              return _CarOrTruck;
         }
        public void setCarOrTruck(int newValue){
              _CarOrTruck = newValue;
         }
        private int _BankAccount = 0;
        public int getBankAccount(){
              return _BankAccount;
         }
        public void setBankAccount(int newValue){
              _BankAccount = newValue;
         }
        private int _HHOwner = 0;
        public int getHHOwner(){
              return _HHOwner;
         }
        public void setHHOwner(int newValue){
              _HHOwner = newValue;
         }
        private int _RentOfDwelling = 0;
        public int getRentOfDwelling(){
              return _RentOfDwelling;
         }
        public void setRentOfDwelling(int newValue){
              _RentOfDwelling = newValue;
         }
        private int _RentOfDwellDK = 0;
        public int getRentOfDwellDK(){
              return _RentOfDwellDK;
         }
        public void setRentOfDwellDK(int newValue){
              _RentOfDwellDK = newValue;
         }
        private int _ConsMatFloor = 0;
        public int getConsMatFloor(){
              return _ConsMatFloor;
         }
        public void setConsMatFloor(int newValue){
              _ConsMatFloor = newValue;
         }
        private String _ConsMatFloorOth = "";
        public String getConsMatFloorOth(){
              return _ConsMatFloorOth;
         }
        public void setConsMatFloorOth(String newValue){
              _ConsMatFloorOth = newValue;
         }
        private int _ConsMatWall = 0;
        public int getConsMatWall(){
              return _ConsMatWall;
         }
        public void setConsMatWall(int newValue){
              _ConsMatWall = newValue;
         }
        private String _ConsMatWallOth = "";
        public String getConsMatWallOth(){
              return _ConsMatWallOth;
         }
        public void setConsMatWallOth(String newValue){
              _ConsMatWallOth = newValue;
         }
        private int _ConsMatRoof = 0;
        public int getConsMatRoof(){
              return _ConsMatRoof;
         }
        public void setConsMatRoof(int newValue){
              _ConsMatRoof = newValue;
         }
        private String _ConsMatRoofOth = "";
        public String getConsMatRoofOth(){
              return _ConsMatRoofOth;
         }
        public void setConsMatRoofOth(String newValue){
              _ConsMatRoofOth = newValue;
         }
        private int _Fuel = 0;
        public int getFuel(){
              return _Fuel;
         }
        public void setFuel(int newValue){
              _Fuel = newValue;
         }
        private String _FuelOth = "";
        public String getFuelOth(){
              return _FuelOth;
         }
        public void setFuelOth(String newValue){
              _FuelOth = newValue;
         }
        private int _TypeOfToilet = 0;
        public int getTypeOfToilet(){
              return _TypeOfToilet;
         }
        public void setTypeOfToilet(int newValue){
              _TypeOfToilet = newValue;
         }
        private String _TypeOfToiletOth = "";
        public String getTypeOfToiletOth(){
              return _TypeOfToiletOth;
         }
        public void setTypeOfToiletOth(String newValue){
              _TypeOfToiletOth = newValue;
         }
        private int _TypeOfChildToilet = 0;
        public int getTypeOfChildToilet(){
              return _TypeOfChildToilet;
         }
        public void setTypeOfChildToilet(int newValue){
              _TypeOfChildToilet = newValue;
         }
        private String _TypeOfChildToiletOth = "";
        public String getTypeOfChildToiletOth(){
              return _TypeOfChildToiletOth;
         }
        public void setTypeOfChildToiletOth(String newValue){
              _TypeOfChildToiletOth = newValue;
         }
        private int _ToiletShare = 0;
        public int getToiletShare(){
              return _ToiletShare;
         }
        public void setToiletShare(int newValue){
              _ToiletShare = newValue;
         }
        private int _SOfDrinkingWater = 0;
        public int getSOfDrinkingWater(){
              return _SOfDrinkingWater;
         }
        public void setSOfDrinkingWater(int newValue){
              _SOfDrinkingWater = newValue;
         }
        private String _TimeToWalkInMin = "";
        public String getTimeToWalkInMin(){
              return _TimeToWalkInMin;
         }
        public void setTimeToWalkInMin(String newValue){
              _TimeToWalkInMin = newValue;
         }
        private String _TimeToWalkInHours = "";
        public String getTimeToWalkInHours(){
              return _TimeToWalkInHours;
         }
        public void setTimeToWalkInHours(String newValue){
              _TimeToWalkInHours = newValue;
         }
        private String _WeeklyWSupplyInHour = "";
        public String getWeeklyWSupplyInHour(){
              return _WeeklyWSupplyInHour;
         }
        public void setWeeklyWSupplyInHour(String newValue){
              _WeeklyWSupplyInHour = newValue;
         }
        private String _WeeklyWSuppHouse = "";
        public String getWeeklyWSuppHouse(){
              return _WeeklyWSuppHouse;
         }
        public void setWeeklyWSuppHouse(String newValue){
              _WeeklyWSuppHouse = newValue;
         }
        private int _TreatDKWater = 0;
        public int getTreatDKWater(){
              return _TreatDKWater;
         }
        public void setTreatDKWater(int newValue){
              _TreatDKWater = newValue;
         }
        private int _TreatMeth = 0;
        public int getTreatMeth(){
              return _TreatMeth;
         }
        public void setTreatMeth(int newValue){
              _TreatMeth = newValue;
         }
        private int _OpenSewers = 0;
        public int getOpenSewers(){
              return _OpenSewers;
         }
        public void setOpenSewers(int newValue){
              _OpenSewers = newValue;
         }
        private int _Handwash = 0;
        public int getHandwash(){
              return _Handwash;
         }
        public void setHandwash(int newValue){
              _Handwash = newValue;
         }
        private int _Water = 0;
        public int getWater(){
              return _Water;
         }
        public void setWater(int newValue){
              _Water = newValue;
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

        String TableName = "Household_Interview";

        public String SaveUpdateData(Context context)
        {
            String response = "";
            C = new Connection(context);
            String SQL = "";
            try
            {
                 if(C.Existence("Select * from "+ TableName +"  Where UNCode='"+ _UNCode +"' and StructureNo='"+ _StructureNo +"' and HouseholdSl='"+ _HouseholdSl +"' and VisitNo='"+ _VisitNo +"' and DeviceID='"+_DeviceID+"'"))
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
                 SQL = "Insert into "+ TableName +" (UNCode,StructureNo,HouseholdSl,VisitNo,FHeadAvail,RelWithFHead,OthRelWithFHead,FirstName,EduLevelFHead,EduLevelMHead,liveHouseM,liveHouseY,LiveHH_Mon,LiveHH_Year,LiveCity_Mon,LiveCity_Year,Hlive12m,ChangedHouse,DistHome,ChildHcare,ChildHcareOth,MotherEdu,HeadOcp,HeadOcpOth,Room,BedRoom,Electricity,Radio,Television,NonMobileTele,Computer,Refrigerator,Watch,MobilePhone,Bicycle,MotorcycleScooter,AnimalDrawnCart,CarOrTruck,BankAccount,HHOwner,RentOfDwelling,RentOfDwellDK,ConsMatFloor,ConsMatFloorOth,ConsMatWall,ConsMatWallOth,ConsMatRoof,ConsMatRoofOth,Fuel,FuelOth,TypeOfToilet,TypeOfToiletOth,TypeOfChildToilet,TypeOfChildToiletOth,ToiletShare,SOfDrinkingWater,TimeToWalkInMin,TimeToWalkInHours,WeeklyWSupplyInHour,WeeklyWSuppHouse,TreatDKWater,TreatMeth,OpenSewers,Handwash,Water,StartTime,EndTime,DeviceID,EntryUser,Lat,Lon,EnDt,Upload,modifyDate)Values('"+ _UNCode +"', '"+ _StructureNo +"', '"+ _HouseholdSl +"', '"+ _VisitNo +"', '"+ _FHeadAvail +"', '"+ _RelWithFHead +"', '"+ _OthRelWithFHead +"', '"+ _FirstName +"', '"+ _EduLevelFHead +"', '"+ _EduLevelMHead +"', '"+ _liveHouseM +"', '"+ _liveHouseY +"', '"+ _LiveHH_Mon +"', '"+ _LiveHH_Year +"', '"+ _LiveCity_Mon +"', '"+ _LiveCity_Year +"', '"+ _Hlive12m +"', '"+ _ChangedHouse +"', '"+ _DistHome +"', '"+ _ChildHcare +"', '"+ _ChildHcareOth +"', '"+ _MotherEdu +"', '"+ _HeadOcp +"', '"+ _HeadOcpOth +"', '"+ _Room +"', '"+ _BedRoom +"', '"+ _Electricity +"', '"+ _Radio +"', '"+ _Television +"', '"+ _NonMobileTele +"', '"+ _Computer +"', '"+ _Refrigerator +"', '"+ _Watch +"', '"+ _MobilePhone +"', '"+ _Bicycle +"', '"+ _MotorcycleScooter +"', '"+ _AnimalDrawnCart +"', '"+ _CarOrTruck +"', '"+ _BankAccount +"', '"+ _HHOwner +"', '"+ _RentOfDwelling +"', '"+ _RentOfDwellDK +"', '"+ _ConsMatFloor +"', '"+ _ConsMatFloorOth +"', '"+ _ConsMatWall +"', '"+ _ConsMatWallOth +"', '"+ _ConsMatRoof +"', '"+ _ConsMatRoofOth +"', '"+ _Fuel +"', '"+ _FuelOth +"', '"+ _TypeOfToilet +"', '"+ _TypeOfToiletOth +"', '"+ _TypeOfChildToilet +"', '"+ _TypeOfChildToiletOth +"', '"+ _ToiletShare +"', '"+ _SOfDrinkingWater +"', '"+ _TimeToWalkInMin +"', '"+ _TimeToWalkInHours +"', '"+ _WeeklyWSupplyInHour +"', '"+ _WeeklyWSuppHouse +"', '"+ _TreatDKWater +"', '"+ _TreatMeth +"', '"+ _OpenSewers +"', '"+ _Handwash +"', '"+ _Water +"', '"+ _StartTime +"', '"+ _EndTime +"', '"+ _DeviceID +"', '"+ _EntryUser +"', '"+ _Lat +"', '"+ _Lon +"', '"+ _EnDt +"', '"+ _Upload +"', '"+ _modifyDate +"')";
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
                 SQL = "Update "+ TableName +" Set Upload='2',modifyDate='" + _modifyDate + "' ,UNCode = '"+ _UNCode +"',StructureNo = '"+ _StructureNo +"',HouseholdSl = '"+ _HouseholdSl +"',VisitNo = '"+ _VisitNo +"',FHeadAvail = '"+ _FHeadAvail +"',RelWithFHead = '"+ _RelWithFHead +"',OthRelWithFHead = '"+ _OthRelWithFHead +"',FirstName = '"+ _FirstName +"',EduLevelFHead = '"+ _EduLevelFHead +"',EduLevelMHead = '"+ _EduLevelMHead +"',liveHouseM = '"+ _liveHouseM +"',liveHouseY = '"+ _liveHouseY +"',LiveHH_Mon = '"+ _LiveHH_Mon +"',LiveHH_Year = '"+ _LiveHH_Year +"',LiveCity_Mon = '"+ _LiveCity_Mon +"',LiveCity_Year = '"+ _LiveCity_Year +"',Hlive12m = '"+ _Hlive12m +"',ChangedHouse = '"+ _ChangedHouse +"',DistHome = '"+ _DistHome +"',ChildHcare = '"+ _ChildHcare +"',ChildHcareOth = '"+ _ChildHcareOth +"',MotherEdu = '"+ _MotherEdu +"',HeadOcp = '"+ _HeadOcp +"',HeadOcpOth = '"+ _HeadOcpOth +"',Room = '"+ _Room +"',BedRoom = '"+ _BedRoom +"',Electricity = '"+ _Electricity +"',Radio = '"+ _Radio +"',Television = '"+ _Television +"',NonMobileTele = '"+ _NonMobileTele +"',Computer = '"+ _Computer +"',Refrigerator = '"+ _Refrigerator +"',Watch = '"+ _Watch +"',MobilePhone = '"+ _MobilePhone +"',Bicycle = '"+ _Bicycle +"',MotorcycleScooter = '"+ _MotorcycleScooter +"',AnimalDrawnCart = '"+ _AnimalDrawnCart +"',CarOrTruck = '"+ _CarOrTruck +"',BankAccount = '"+ _BankAccount +"',HHOwner = '"+ _HHOwner +"',RentOfDwelling = '"+ _RentOfDwelling +"',RentOfDwellDK = '"+ _RentOfDwellDK +"',ConsMatFloor = '"+ _ConsMatFloor +"',ConsMatFloorOth = '"+ _ConsMatFloorOth +"',ConsMatWall = '"+ _ConsMatWall +"',ConsMatWallOth = '"+ _ConsMatWallOth +"',ConsMatRoof = '"+ _ConsMatRoof +"',ConsMatRoofOth = '"+ _ConsMatRoofOth +"',Fuel = '"+ _Fuel +"',FuelOth = '"+ _FuelOth +"',TypeOfToilet = '"+ _TypeOfToilet +"',TypeOfToiletOth = '"+ _TypeOfToiletOth +"',TypeOfChildToilet = '"+ _TypeOfChildToilet +"',TypeOfChildToiletOth = '"+ _TypeOfChildToiletOth +"',ToiletShare = '"+ _ToiletShare +"',SOfDrinkingWater = '"+ _SOfDrinkingWater +"',TimeToWalkInMin = '"+ _TimeToWalkInMin +"',TimeToWalkInHours = '"+ _TimeToWalkInHours +"',WeeklyWSupplyInHour = '"+ _WeeklyWSupplyInHour +"',WeeklyWSuppHouse = '"+ _WeeklyWSuppHouse +"',TreatDKWater = '"+ _TreatDKWater +"',TreatMeth = '"+ _TreatMeth +"',OpenSewers = '"+ _OpenSewers +"',Handwash = '"+ _Handwash +"',Water = '"+ _Water +"'  Where UNCode='"+ _UNCode +"' and StructureNo='"+ _StructureNo +"' and HouseholdSl='"+ _HouseholdSl +"' and VisitNo='"+ _VisitNo +"' and DeviceID='"+_DeviceID+"'";
                 response = C.SaveData(SQL);
                 C.close();
              }
              catch(Exception  e)
              {
                 response = e.getMessage();
              }
           return response;
        }


        public List<Household_Interview_DataModel> SelectAll(Context context, String SQL)
        {
            Connection C = new Connection(context);
            List<Household_Interview_DataModel> data = new ArrayList<Household_Interview_DataModel>();
            Household_Interview_DataModel d = new Household_Interview_DataModel();
            Cursor cur = C.ReadData(SQL);

            cur.moveToFirst();
            while(!cur.isAfterLast())
            {
                d = new Household_Interview_DataModel();
                d._UNCode = cur.getString(cur.getColumnIndex("UNCode"));
                d._StructureNo = Integer.valueOf(cur.getString(cur.getColumnIndex("StructureNo")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("StructureNo")));
                d._HouseholdSl = cur.getString(cur.getColumnIndex("HouseholdSl"));
                d._VisitNo = cur.getString(cur.getColumnIndex("VisitNo"));
                d._FHeadAvail = Integer.valueOf(cur.getString(cur.getColumnIndex("FHeadAvail")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("FHeadAvail")));
                d._RelWithFHead = Integer.valueOf(cur.getString(cur.getColumnIndex("RelWithFHead")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("RelWithFHead")));
                d._OthRelWithFHead = cur.getString(cur.getColumnIndex("OthRelWithFHead"));
                d._FirstName = cur.getString(cur.getColumnIndex("FirstName"));
                d._EduLevelFHead = Integer.valueOf(cur.getString(cur.getColumnIndex("EduLevelFHead")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("EduLevelFHead")));
                d._EduLevelMHead = Integer.valueOf(cur.getString(cur.getColumnIndex("EduLevelMHead")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("EduLevelMHead")));
                d._liveHouseM = Integer.valueOf(cur.getString(cur.getColumnIndex("liveHouseM")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("liveHouseM")));
                d._liveHouseY = Integer.valueOf(cur.getString(cur.getColumnIndex("liveHouseY")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("liveHouseY")));
                d._LiveHH_Mon = Integer.valueOf(cur.getString(cur.getColumnIndex("LiveHH_Mon")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("LiveHH_Mon")));
                d._LiveHH_Year = Integer.valueOf(cur.getString(cur.getColumnIndex("LiveHH_Year")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("LiveHH_Year")));
                d._LiveCity_Mon = Integer.valueOf(cur.getString(cur.getColumnIndex("LiveCity_Mon")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("LiveCity_Mon")));
                d._LiveCity_Year = Integer.valueOf(cur.getString(cur.getColumnIndex("LiveCity_Year")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("LiveCity_Year")));
                d._Hlive12m = Integer.valueOf(cur.getString(cur.getColumnIndex("Hlive12m")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Hlive12m")));
                d._ChangedHouse = Integer.valueOf(cur.getString(cur.getColumnIndex("ChangedHouse")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("ChangedHouse")));
                d._DistHome = Integer.valueOf(cur.getString(cur.getColumnIndex("DistHome")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("DistHome")));
                d._ChildHcare = Integer.valueOf(cur.getString(cur.getColumnIndex("ChildHcare")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("ChildHcare")));
                d._ChildHcareOth = cur.getString(cur.getColumnIndex("ChildHcareOth"));
                d._MotherEdu = Integer.valueOf(cur.getString(cur.getColumnIndex("MotherEdu")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MotherEdu")));
                d._HeadOcp = Integer.valueOf(cur.getString(cur.getColumnIndex("HeadOcp")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("HeadOcp")));
                d._HeadOcpOth = cur.getString(cur.getColumnIndex("HeadOcpOth"));
                d._Room = Integer.valueOf(cur.getString(cur.getColumnIndex("Room")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Room")));
                d._BedRoom = Integer.valueOf(cur.getString(cur.getColumnIndex("BedRoom")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("BedRoom")));
                d._Electricity = Integer.valueOf(cur.getString(cur.getColumnIndex("Electricity")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Electricity")));
                d._Radio = Integer.valueOf(cur.getString(cur.getColumnIndex("Radio")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Radio")));
                d._Television = Integer.valueOf(cur.getString(cur.getColumnIndex("Television")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Television")));
                d._NonMobileTele = Integer.valueOf(cur.getString(cur.getColumnIndex("NonMobileTele")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("NonMobileTele")));
                d._Computer = Integer.valueOf(cur.getString(cur.getColumnIndex("Computer")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Computer")));
                d._Refrigerator = Integer.valueOf(cur.getString(cur.getColumnIndex("Refrigerator")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Refrigerator")));
                d._Watch = Integer.valueOf(cur.getString(cur.getColumnIndex("Watch")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Watch")));
                d._MobilePhone = Integer.valueOf(cur.getString(cur.getColumnIndex("MobilePhone")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MobilePhone")));
                d._Bicycle = Integer.valueOf(cur.getString(cur.getColumnIndex("Bicycle")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Bicycle")));
                d._MotorcycleScooter = Integer.valueOf(cur.getString(cur.getColumnIndex("MotorcycleScooter")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("MotorcycleScooter")));
                d._AnimalDrawnCart = Integer.valueOf(cur.getString(cur.getColumnIndex("AnimalDrawnCart")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("AnimalDrawnCart")));
                d._CarOrTruck = Integer.valueOf(cur.getString(cur.getColumnIndex("CarOrTruck")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("CarOrTruck")));
                d._BankAccount = Integer.valueOf(cur.getString(cur.getColumnIndex("BankAccount")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("BankAccount")));
                d._HHOwner = Integer.valueOf(cur.getString(cur.getColumnIndex("HHOwner")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("HHOwner")));
                d._RentOfDwelling = Integer.valueOf(cur.getString(cur.getColumnIndex("RentOfDwelling")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("RentOfDwelling")));
                d._RentOfDwellDK = Integer.valueOf(cur.getString(cur.getColumnIndex("RentOfDwellDK")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("RentOfDwellDK")));
                d._ConsMatFloor = Integer.valueOf(cur.getString(cur.getColumnIndex("ConsMatFloor")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("ConsMatFloor")));
                d._ConsMatFloorOth = cur.getString(cur.getColumnIndex("ConsMatFloorOth"));
                d._ConsMatWall = Integer.valueOf(cur.getString(cur.getColumnIndex("ConsMatWall")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("ConsMatWall")));
                d._ConsMatWallOth = cur.getString(cur.getColumnIndex("ConsMatWallOth"));
                d._ConsMatRoof = Integer.valueOf(cur.getString(cur.getColumnIndex("ConsMatRoof")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("ConsMatRoof")));
                d._ConsMatRoofOth = cur.getString(cur.getColumnIndex("ConsMatRoofOth"));
                d._Fuel = Integer.valueOf(cur.getString(cur.getColumnIndex("Fuel")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Fuel")));
                d._FuelOth = cur.getString(cur.getColumnIndex("FuelOth"));
                d._TypeOfToilet = Integer.valueOf(cur.getString(cur.getColumnIndex("TypeOfToilet")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("TypeOfToilet")));
                d._TypeOfToiletOth = cur.getString(cur.getColumnIndex("TypeOfToiletOth"));
                d._TypeOfChildToilet = Integer.valueOf(cur.getString(cur.getColumnIndex("TypeOfChildToilet")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("TypeOfChildToilet")));
                d._TypeOfChildToiletOth = cur.getString(cur.getColumnIndex("TypeOfChildToiletOth"));
                d._ToiletShare = Integer.valueOf(cur.getString(cur.getColumnIndex("ToiletShare")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("ToiletShare")));
                d._SOfDrinkingWater = Integer.valueOf(cur.getString(cur.getColumnIndex("SOfDrinkingWater")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("SOfDrinkingWater")));
                d._TimeToWalkInMin = cur.getString(cur.getColumnIndex("TimeToWalkInMin"));
                d._TimeToWalkInHours = cur.getString(cur.getColumnIndex("TimeToWalkInHours"));
                d._WeeklyWSupplyInHour = cur.getString(cur.getColumnIndex("WeeklyWSupplyInHour"));
                d._WeeklyWSuppHouse = cur.getString(cur.getColumnIndex("WeeklyWSuppHouse"));
                d._TreatDKWater = Integer.valueOf(cur.getString(cur.getColumnIndex("TreatDKWater")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("TreatDKWater")));
                d._TreatMeth = Integer.valueOf(cur.getString(cur.getColumnIndex("TreatMeth")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("TreatMeth")));
                d._OpenSewers = Integer.valueOf(cur.getString(cur.getColumnIndex("OpenSewers")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("OpenSewers")));
                d._Handwash = Integer.valueOf(cur.getString(cur.getColumnIndex("Handwash")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Handwash")));
                d._Water = Integer.valueOf(cur.getString(cur.getColumnIndex("Water")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Water")));
                data.add(d);

                cur.moveToNext();
            }
            cur.close();
          return data;
        }
 }