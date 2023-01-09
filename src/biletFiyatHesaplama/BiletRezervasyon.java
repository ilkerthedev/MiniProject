package biletFiyatHesaplama;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Project: mesafeye ve şartlara göre otobüs bileti fiyatı hesaplayan uygulama
         Kullanıcıdan Mesafe (KM), yaşı ve yolculuk tipi (Tek Yön, Gidiş-Dönüş)
         koltuk no  bilgilerini alın.
         Mesafe başına ücret 1 TL / km olarak alın.(Gidiş-Dönüş için *2)
         İlk olarak yolculuğun toplam fiyatını hesaplayın ve sonrasında ki koşullara göre müşteriye aşağıdaki kuralları uygulayın ;

        Kullanıcıdan alınan değerler geçerli (mesafe ve yaş değerleri pozitif sayı, yolculuk tipi ise 1 veya 2) olmalıdır.
        Aksi takdirde kullanıcıya "Hatalı Veri Girdiniz !" şeklinde bir uyarı verilmelidir.
       1- Kişi "Yolculuk Tipini" gidiş dönüş seçmiş ise bilet fiyatı üzerinden %20 indirim uygulanır.
       2-Yaş indirimi:
        Kişi 12 yaşından küçükse bilet fiyatı üzerinden %50 indirim uygulanır.
        Kişi 12-24 yaşları arasında ise bilet fiyatı üzerinden %10 indirim uygulanır.
        Kişi 65 yaşından büyük ise bilet fiyatı üzerinden %30 indirim uygulanır.
       3-Tekli Koltuk ücreti:
        Koltuk numarası 3 veya 3 ün katı ise bilet fiyatı %20 artırılır.

 */
public class BiletRezervasyon {

    public static void main(String[] args) {
        List<String> seatNo = new ArrayList<>();
        for (int i = 1; i < 33 ; i++) {
            seatNo.add(String.valueOf(i));
        }

        Bilet bilet=new Bilet();
        Bus bus=new Bus("34 IST 78",seatNo );
        start(bilet, bus);

    }//main

    public static void start(Bilet bilet, Bus bus){
        Scanner input = new Scanner(System.in);
        int select;
        do {
            System.out.println("Bilet Rezervasyon Sistemine Hoşgeldiniz");
            System.out.println("Lütfen gidilecek mesafeyi 'km' cinsinden giriniz");
            bilet.distance = input.nextInt();
            System.out.println("Lütfen yaşınızı giriniz");
            int age = input.nextInt();
            System.out.println("Lütfen yolculuk tipini seçiniz: ");
            System.out.println("1) Tek Yön\n2) Gidiş-Dönüş");
            bilet.typeNo=input.nextInt();
            System.out.println("Koltuk no seçiniz: ");
            System.out.println("(Tekli koltuk ücreti %20 daha fazladır)");
            System.out.println(bus.seats);
            bilet.seatNo=input.nextInt();
            bus.seats.remove(String.valueOf(bilet.seatNo));
            boolean check = bilet.typeNo==1 || bilet.typeNo==2;
            if (bilet.distance>0 && age>0 && check){
                bilet.price=getTotal(bilet, age);
                bilet.printBilet(bus);
            }else{
                System.out.println("Hatalı giriş yaptınız.");
            }

            System.out.println("Yeniden işlem yapmak için herhangi bir rakam, çıkış için 0 giriniz.");
            select=input.nextInt();
        }while (select!=0);
        System.out.println("İyi günler dileriz...");

    }//start body

    public static double getTotal(Bilet bilet,int age){
        double total = 0;
        int dist=bilet.distance;
        int seatNo = bilet.seatNo;
        int type = bilet.typeNo;

        switch (type){

            case 1:
                if (seatNo%3==0){
                    total = dist*1.2;
                }else {
                    total = dist;
                }
                break;
            case 2:
                if (seatNo%3==0){
                    total = dist*2.4;
                }else {
                    total = dist*2;
                }
                total= total*0.8;
                break;
        }

        if (age<=12){
            total = total/2 ;
        } else if (age<=24) {
            total = total*0.9;
        } else if (age>65) {
            total = total*0.7;
        }

        return total;
    }

}//class
