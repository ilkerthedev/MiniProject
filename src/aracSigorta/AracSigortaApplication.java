package aracSigorta;

/*
Proje: Araç Sigorta Prim Hesaplama
       Araç tipleri:otomobil, kamyon, otobüs, motosiklet
                    -otobüs: 18-30 koltuk veya 31 ve üstü koltuk
       Tarife dönemi:Aralık 2022,Haziran 2022
       1.dönemi:Haziran 2022                  2.dönem:Aralık 2022
          otomobil: 2000                       otomobil: 2500
          kamyon:   3000                       kamyon:   3500
          otobüs: tip1: 4000 tip2: 5000        otobüs: tip1: 4500 tip2: 5500
          motosiklet: 1500                     motosiklet: 1750
        Hatalı girişte hesaplama başarısız uyarsı verip tekrar menü gösterilsin.
 */

import java.util.Scanner;

public class AracSigortaApplication {

    public static void main(String[] args) {
        start();
    }

    public static void start(){
        Scanner inp=new Scanner(System.in);
        boolean isFail;
        do {
            isFail=false;
            //menü ve tarife dönemi seçimi
            System.out.println("---Zorunlu Sigorta Primi Hesaplama---");
            System.out.println("Tarife dönemi seçiniz: ");
            System.out.println("1.Haziran 2022");
            System.out.println("2.Aralık 2022");
            int term=inp.nextInt();
            //tarife dönemi doğru girilmişse işleme devam et
            //değilse uyarı ver başa dön
            if(term==1 || term==2){
                String termName=term==1 ? "Haziran 2022" : "Aralık 2022";
                Arac arac=new Arac();
                System.out.println("Araç tipini giriniz: ");
                System.out.println("(otomobil,kamyon,otobüs,motosiklet)");
                arac.type=inp.next();
                arac.prim=arac.countPrim(term);
                int select;
                if(arac.prim>0){
                    System.out.println("Hesaplama başarıyla tamamlandı.");
                    System.out.println("Araç tipi:"+arac.type);
                    System.out.println("Tarife dönemi:"+termName);
                    System.out.println("Aracınızın ilgili tarife dönemi sigorta primi: "+arac.prim);
                    System.out.println("Yeni işlem için 1, çıkış için 0 giriniz: ");
                    select=inp.nextInt();
                    if(select==1){
                        isFail=true;
                    }else{
                        isFail=false;
                    }

                }else{
                    System.out.println("Hesaplama başarısız!");
                    System.out.println("Yeni işlem için 1, çıkış için 0 giriniz: ");
                    select=inp.nextInt();
                    if(select==1){
                        isFail=true;
                    }else{
                        isFail=false;
                    }
                }
            }else{
                System.out.println("Hatalı giriş!");
                isFail=true;
            }
        }while(isFail);
        System.out.println("İyi günler dileriz...");


    }

}