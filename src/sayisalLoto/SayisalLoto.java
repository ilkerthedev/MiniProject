package sayisalLoto;

import java.util.Random;
import java.util.Scanner;

/*
Proje: Sayısal Loto Uygulaması
       bilet için rastgele n tane sayı üretilsin.
       loto sonucu rastgele n tane sayı ile üretilsin.
       sayısal lotoda tekrarlı sayılar olmamalı.

       n(hane sayısı), sayılar için min ve max değerler
       kullanıcıdan alınsın.

       sonuç ve bilet karşılaştırılsın, kaç eşleşme olduğu
       kullanıcıya bildirilsin.

*/
public class SayisalLoto {
    public static void main(String[] args) {
        startLoto();


    }//main

    public static void startLoto() {
        Scanner inp=new Scanner(System.in);
        System.out.println("Sayısal loto için hane sayısı giriniz: ");
        int slots=inp.nextInt();
        System.out.println("Sayılar için min değer giriniz:");
        int min=inp.nextInt();
        System.out.println("Sayılar için max değer giriniz: ");
        int max=inp.nextInt();
        //başlangıçta hepsi 0
        int[] lotoArr=new int[slots];
        int[] ticketArr=new int[slots];

        Random random=new Random();
        int randomNumber1=0;
        int randomNumber2=0;
        boolean isRepeated;
        for(int i=0;i<slots;i++){
            //0-11 arasında int sayılar ancak 10 dahil [0,10], [5-10] arasında olsun istiyoruz
            //[5,15]
            // random.nextInt(6)+5;-->[0,5]+5-->[5,10]
            //lotoArr yi doldur
            do {
                isRepeated=false;
                randomNumber1=random.nextInt(max+1-min)+min;
                for (int j=0;j<i;j++){
                    if(lotoArr[j]==randomNumber1){
                        isRepeated=true;
                        break;
                    }
                }

            }while(isRepeated);
            lotoArr[i]=randomNumber1;

            //ticketArr yi aynı şekilde doldur
            do {
                isRepeated=false;
                randomNumber2=random.nextInt(max+1-min)+min;
                for (int j=0;j<i;j++){
                    if(ticketArr[j]==randomNumber2){
                        isRepeated=true;
                        break;
                    }
                }

            }while(isRepeated);
            ticketArr[i]=randomNumber2;
        }
        System.out.println("Benim biletim: ");
        for(int i=0;i<slots;i++){
            System.out.print(ticketArr[i]+" ");
        }
        System.out.println();
        System.out.println("Loto sonucu: ");
        for(int i=0;i<slots;i++){
            System.out.print(lotoArr[i]+" ");
        }
        System.out.println();
        int result = compareArr(ticketArr, lotoArr);
        if(result>0){
            System.out.println("Tebrikler! "+result+"eşleşme var.");
        }else System.out.println("Maalesef hiç eşleşme yok :(");
    }

    public static int compareArr(int[] arr, int[] brr){
        int counter = 0;

        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j < brr.length; j++) {
                if (arr[i]==brr[j]){
                    counter++;
                }
            }//inner for

        }//outer for


        return counter;
    }


}//class