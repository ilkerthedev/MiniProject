package AppointmentApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//11-randevu işlemleri
public class AppointmentService {
    Scanner inp=new Scanner(System.in);
    List<Appointment> appointments=new ArrayList<>();

    //12-randevu oluşturma metodu
    public void getAppointment(DoctorService doctorService){
//13-dr listesi gösterilsin ve seçim yapılsın
        doctorService.printDoctors();
        System.out.println("Randevu almak istediğiniz doktoru seçiniz:(no) ");
        int selectDoctor=inp.nextInt();
        if(doctorService.getDoctorById(selectDoctor)!=null) {
            Doctor doctor = doctorService.getDoctorById(selectDoctor);
//14-tarih seçme işlemi:tarih listesinde randevu alınmamış tarih var mı
            if(!doctor.getDates().isEmpty()){
                System.out.println("Lütfen isminizi giriniz:");
                inp.nextLine();
                String name=inp.nextLine();
                System.out.println("Sayın "+name+", randevu alabileceğiniz tarihler :");
                for(int i=0;i<doctor.getDates().size();i++){
                    System.out.println((i+1)+" - "+doctor.getDates().get(i));//1-02.02.2023
                    //2-03.02.2023
                }
                System.out.println("Randevu almak istediğiniz tarihin numarasını giriniz: ");
                int select=inp.nextInt();
//15-tarih doğru seçildi mi
                if(select>0 && select<=doctor.getDates().size()){
                    Appointment appointment=new Appointment(name,doctor,doctor.getDates().get(select-1));//1
                    this.appointments.add(appointment);
                    System.out.println("Sayın "+name+", Randevu tarihiniz: "+doctor.getDates().get(select-1));
                    System.out.println("Randevu no:"+appointment.getId()+ " ile randevu bilgilerinizi görüntüleyebilirsiniz.");
//16-randevu başarılı bir şekilde oluşturulunca seçilen tarih doktorun takviminden silinmeli
                    doctor.getDates().remove(select-1);
                }else {
                    System.out.println("Hatalı giriş!!!");
                }
            }else{
                System.out.println(doctor.getName()+" un bu hafta tüm randevuları dolmuştur, daha sonra tekrar deneyiniz.");
            }
        }else{
            System.out.println("Hatalı giriş...");
        }

    }
    //17-kullanıcının girdiği randevu no ile eşleşen randevu bilgilerini yazdır
    public void printApp(){
        boolean isExist=true;
        System.out.println("Randevu no giriniz: ");
        int appId=inp.nextInt();
        for(Appointment app: this.appointments){
            if(app.getId()==appId){
                isExist=true;
                System.out.println("---------------------------------------");
                System.out.println(appId+" No'lu Randevu Bilgileri");
                System.out.println("Hasta adı: "+app.getName());
                System.out.println("Branş:"+app.getDoctor().getDepartment());
                System.out.println("Doktor:"+app.getDoctor().getName());
                System.out.println("Randevu tarihi:"+app.getDate());
                System.out.println("---------------------------------------");
                break;
            }else{
                isExist=false;
            }
        }
        if(!isExist){
            System.out.println("Randevu bulunamadı...");
        }
    }


}