import java.util.Scanner;

/*
Proje: Spor kursu için seçilecek öğrencileri belirleyen
       bir uygulama yazınız.

       kurs gereklilikleri:
            erkekler: boy: 1.60 ve üstü
                      kilo:70-90 kg
            kızlar: boy: 1.50 ve üstü
                    kilo:50-70 kg

       kullanıcıdan öğrenci sayısı ve herbir öğrenci
       için isim , cinsiyet, kilo ve boy bilgilerini girmesini
       isteyiniz.
 */
public class SelectStudent {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Merhaba, lütfen formu doldurunuz.");
        System.out.println("Öğrenci sayisini giriniz.");
        int numStudent = scan.nextInt();

        String[] students = new String[numStudent];
        String[] gender = new String[numStudent];
        double[] height = new double[numStudent];
        double[] weight = new double[numStudent];


        boolean isSuccess = true;
        do{

            isSuccess = true;

            for (int i = 0; i < numStudent; i++) {

                System.out.println((i + 1) + ". öğrenci ismi: ");
                students[i] = scan.next();

                System.out.println((i + 1) + ". öğrenci cinsiyeti: ");
                String gen = scan.next().toUpperCase().replaceAll("\\s+", " ").trim().substring(0, 1);
                if (gen.equals("K") || gen.equals("E")) {
                    gender[i] = gen;
                } else {
                    System.out.println("Hatalı giriş!");
                    isSuccess= false;
                    break;
                }

                System.out.println((i + 1) + ". öğrenci boyu: ");
                height[i] = scan.nextDouble();

                System.out.println((i + 1) + ". öğrenci kilosu: ");
                weight[i]=scan.nextDouble();

            }//for body

        }while (!isSuccess);

        int counter = 0;

        System.out.println("*** Kursa Seçilen Öğrenciler ***");
        for (int i = 0; i < numStudent; i++) {
            if (gender[i].equals("K") && height[i]>=1.50 && weight[i]>=50 && weight[i]<=70){
                System.out.println("isim: "+students[i]+"cinsiyet: "+gender[i]+"boy: "+height[i]+"kilo: "+weight[i]);
                counter++;
            }else if(gender[i].equals("E") && height[i]>=1.65 && weight[i]>=70 && weight[i]<=90){
                System.out.println("isim: "+students[i]+"cinsiyet: "+gender[i]+"boy: "+height[i]+"kilo: "+weight[i]);
                counter++;
            }
        }

        if (counter>0){
            System.out.println(counter+" Öğrenci kursa seçilmiştir...");
        }else System.out.println("Maalesef kurs gereksinimlerini karşılayan öğrenci bulunamadı.");




    }//main

}//class
