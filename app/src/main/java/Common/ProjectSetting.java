package Common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TanvirHossain on 19/07/2016.
 */
public class ProjectSetting {
    public static String ProjectName    = "hcus2018";
    public static String Namespace      = "http://chu.icddrb.org/";

    public static String apiName        = ProjectName.toLowerCase();
    public static String NewVersionName = ProjectName.toLowerCase() +"_update";
    public static String DatabaseFolder = ProjectName.toUpperCase() +"DB";
    public static String DatabaseName   = ProjectName.toUpperCase() +"Database.db";
    public static String zipDatabaseName= ProjectName.toUpperCase() +"Database.zip";
    public static String Organization   = "ICDDR,B";

    public static String VersionDate    = "25112018"; //Format: DDMMYYYY


    //Data Sync: Background Service
    //----------------------------------------------------------------------------------------------
    public static List<String> TableList_Upload(){
        List<String> tableList_Upload   = new ArrayList<String>();
        tableList_Upload.add("Admission_Refusal");
        tableList_Upload.add("Child_Final_Status");
        tableList_Upload.add("Cluster_Structure");
        tableList_Upload.add("DiarrhoeaCase");
        tableList_Upload.add("EmergencyOperation");
        tableList_Upload.add("Household_Interview");
        tableList_Upload.add("Household_Visit");
        tableList_Upload.add("Immunization_History");
        tableList_Upload.add("Immunization_Master");
        tableList_Upload.add("Knowledge_DSH_SSF");
        tableList_Upload.add("Member");
        tableList_Upload.add("MeningitisCase");
        tableList_Upload.add("OtitisMediaCase");
        tableList_Upload.add("PneumoniaCase");
        tableList_Upload.add("TyphoidCase");
        tableList_Upload.add("StructureListing");
        return tableList_Upload;
    }

    /*
    public static List<String> TableList_Download(){
        List<String> tableList_Download   = new ArrayList<String>();
        tableList_Download.add("");
        return tableList_Download;
    }*/

}
