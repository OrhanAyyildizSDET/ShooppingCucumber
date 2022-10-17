package utilities;

import pojo.MedunnaPhysiciansPojo;
import pojo.Medunna_Patients_FullPacket;
import pojo.Medunna_Patients_Pojo;
import pojo.Medunna_pojo;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class TextReader {
    public static void saveUIRegistrants(Medunna_pojo[] registrants){
        try {
            FileWriter fw = new FileWriter(ConfigReader.getProperty("applicants_datas"),true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (var i = 0; i < registrants.length; i++) {
                bw.append(registrants[i].toString()+"\n");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void saveApiPhysicians(MedunnaPhysiciansPojo[] physiciansPojo){
        try {
            FileWriter fw = new FileWriter(ConfigReader.getProperty("physicians_datas"),false);
            BufferedWriter bw = new BufferedWriter(fw);
            for (var i = 0; i < physiciansPojo.length; i++) {
                bw.append(physiciansPojo[i].toString()+"\n");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void saveApiPatients(Medunna_Patients_FullPacket[] patientsPojos){
        try {
            FileWriter fw = new FileWriter(ConfigReader.getProperty("patients_datas"),false);
            BufferedWriter bw = new BufferedWriter(fw);
            for (var i = 0; i < patientsPojos.length; i++) {
                bw.append(patientsPojos[i].toString()+"\n");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
