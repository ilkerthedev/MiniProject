package RestaurantBillGenerator;
/*
Proje: Restaurant Fiş Üretme Uygulaması(BillGenerator)
       1-Bir restaurantın online sipariş sisteminde hesabı
       yazdıran uygulama tasarlayınız.

       2-Restauranttaki yiyecekler bir listte tutulsun.
         Yiyeceklerin kodu, ismi ve ücreti olsun.

       3-Yiyecek menüsü, sipariş oluşturma/iptal ve hesap
         oluşturma için seçim menüsü gösterilsin.

       4-Yiyecek menü:Listedeki yiyecekler menü şeklinde listelensin
         Sipariş girme:Yiyeceğin kodu ve istenilen adet girilerek sipariş oluşturulsun
                       Her sipariş için kod üretilsin(başlangıç 1000 artarak devam eder)
                       Her bir yiyecek siparişi için tutar hesaplansın

         Sipariş iptal:Sipariş kodu girilerek sipariş silinsin
         Hesap oluşturma: Tutarları ile birlikte tüm siparişleri ve
                          toplam tutarı gösteren bir hesap fişi yazdırılsın.
*/
/*
ÖDEV: Şirket büyüdü, cafe kısmı açıldı.
      Aynı uygulama cafe kısmında da kullanılsın.
      Cafede farklı menü var.
        Dish dish1=new Dish(401,"Tiramisu",35.0);
        Dish dish2=new Dish(402,"Dondurma",25.0);
        Dish dish3=new Dish(402,"Profiterol",25.0);
        Dish dish4=new Dish(403,"Kahve",17.5);
        Dish dish5=new Dish(404,"Çay",7.5);
        Dish dish6=new Dish(405,"Portakal Suyu",25.5);
      Uygulama başladığında restaurant/cafe seçeneği olsun.

*/

import java.util.Scanner;

public class RestaurantBillGenerator {

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        OrderService orderService = new OrderService();
        DishService dishService = new DishService();
        dishService.fillDishList();
        getSelectionMenu(dishService, orderService);
    }

    public static void getSelectionMenu(DishService dishService, OrderService orderService) {
        Scanner inp = new Scanner(System.in);
        int select = -1;

        while (select != 0) {
            System.out.println("----------------------------------------");
            System.out.println(" *** Lezzet Restaurant Siparis Uygulamasi *** ");
            System.out.println("1-Menu");
            System.out.println("2-Siparis girme");
            System.out.println("3-Siparis iptal etme");
            System.out.println("4-Hesap(fis) olusturma");
            System.out.println("0-CIKIS");
            System.out.println("Seciminiz:");
            select = inp.nextInt();
            System.out.println("----------------------------------------");
            switch (select) {
                case 1://menu
                    dishService.showDishMenu();
                    break;
                case 2://siparis
                    orderService.createOrder(dishService);
                    break;
                case 3://iptal
                    orderService.deleteOrder();
                    break;
                case 4://fis
                    orderService.printBill();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Hatali giris yaptiniz!");
                    break;
            }
        }
        System.out.println("Iyi gunler dileriz...");

    }

}
