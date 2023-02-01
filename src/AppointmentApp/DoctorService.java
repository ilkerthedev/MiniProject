package AppointmentApp;

import java.util.ArrayList;
import java.util.List;

//7-doctor işlemleri
public class DoctorService {
    //8-doctorlar sistemde kayıtlı olmalı
    List<Doctor> doctorList=new ArrayList<>();

    public DoctorService(){
        Doctor doctor1=new Doctor(11,"Dr. Leonardo","KBB");
        Doctor doctor2=new Doctor(22,"Dr. Donatello","Göz");
        Doctor doctor3=new Doctor(33,"Dr. Raphael","Genel Cerrahi");
        this.doctorList.add(doctor1);
        this.doctorList.add(doctor2);
        this.doctorList.add(doctor3);
    }
//9-doktor listesi: No: Adı: Branşı: Takvim:tarihler alt alta

    public void printDoctors(){
        System.out.println("----------------------------- Doktorlar -----------------------------");
        for(Doctor dr:this.doctorList){
            //System.out.println(dr.toString);
            System.out.println("No: "+dr.getId()+" Adı : "+dr.getName()+" Branşı: "+dr.getDepartment());
            System.out.println("Takvim:");
            for (String date:dr.getDates() ){
                System.out.println(date);
            }
        }
        System.out.println("----------------------------------------------------------------------");
    }
//10-id ile doctor u bulmak için metod oluştur

    public Doctor getDoctorById(int id){
        for(Doctor dr:this.doctorList){
            if(dr.getId()==id){
                return dr;
            }
        }
        return null;
    }

}