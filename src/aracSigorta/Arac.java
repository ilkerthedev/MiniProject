package aracSigorta;

import java.util.Scanner;

//1.dönemi:Haziran 2022                  2.dönem:Aralık 2022
//        otomobil: 2000                       otomobil: 2500
//        kamyon:   3000                       kamyon:   3500
//        otobüs: tip1: 4000 tip2: 5000        otobüs: tip1: 4500 tip2: 5500
//        motosiklet: 1500                     motosiklet: 1750
public class Arac {

    public String type;

    public int prim;

    public int countPrim(int term){
        if(term==1){
            switch (type){
                case "otomobil":
                    prim=2000;
                    break;
                case "kamyon":
                    prim=3000;
                    break;
                case "otobüs":
                    prim=countBusPrim(term);
                    break;
                case "motosiklet":
                    prim=1500;
                    break;
                default:
                    System.out.println("Hatalı giriş!");
                    prim=0;
                    break;
            }
        }else if(term==2){
            switch (type){
                case "otomobil":
                    prim=2500;
                    break;
                case "kamyon":
                    prim=3500;
                    break;
                case "otobüs":
                    prim=countBusPrim(term);
                    break;
                case "motosiklet":
                    prim=1750;
                    break;
                default:
                    System.out.println("Hatalı giriş!");
                    prim=0;
                    break;
            }
        }else {
            System.out.println("Hatalı giriş!");
            prim=0;
        }
        return prim;
    }

    public int countBusPrim(int term){
        Scanner inp=new Scanner(System.in);
        System.out.println("Otobüs tipini giriniz: ");
        System.out.println("1-(18-30 koltuk) 2-(31 ve üzeri koltuk)");
        int busType=inp.nextInt();
        switch (busType){
            case 1:
                if (term==1){
                    prim=4000;
                }else {
                    prim=4500;
                }
                break;
            case 2:
                if (term==1){
                    prim=5000;
                }else {
                    prim=5500;
                }
                break;
            default:
                System.out.println("Hatalı giriş!");
                prim=0;
                break;
        }

        return prim;
    }
}