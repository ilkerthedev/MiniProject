package RestaurantBillGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderService {

    Scanner inp = new Scanner(System.in);

    List<Order> orderList = new ArrayList<>();

    public void createOrder(DishService dishService) {
        int dishCode = -1;
        while (dishCode != 0) {
            System.out.println("Lutfen urun kodunu giriniz(CIKIS:0): ");
            dishCode = inp.nextInt();//code ile urunu bulmamiz gerekiyor
            Dish dish = dishService.findDishByCode(dishCode);
            if (dish.getCode() > 0) {
                System.out.println("Adet giriniz:");
                int number = inp.nextInt();
                Order order = new Order(dish, number);
                order.setPrice();
                order.setOrderCode(1000 + this.orderList.size());
                this.orderList.add(order);
            }
            for (Order order : this.orderList) {
                System.out.printf("Siparis kodu:%-5s  Lezzet kodu:%-4s  Adı:%-20s  Adet:%-3s  Fiyat:%-4s TL\n",
                        order.orderCode, order.dish.getCode(), order.dish.getName(), order.numOfDish, order.orderPrice);
            }
        }//while
    }//createOrder

    public void deleteOrder() {
        boolean isValid = true;
        if (this.orderList.isEmpty()) {
            System.out.println("Siparisiniz bulunmamaktadir.");
        } else {
            System.out.println("İptal etmek istediginiz siparisin kodunu giriniz:");
            int code = inp.nextInt();
            for (Order order : this.orderList) {
                if (order.orderCode == code) {
                    this.orderList.remove(order);
                    System.out.println("Siparisiniz iptal edildi: " + order.dish.toString());
                    isValid = true;
                    break;
                } else {
                    isValid = false;
                }
            }
            if (!isValid) {
                System.out.println("Siparis kodu gecersizdir!");
            }
        }
    }//deleteOrder

    public void printBill() {
        double totalPrice = 0.0;
        System.out.println("            Lezzet Fisiniz          ");
        for (Order order : this.orderList) {
            System.out.printf("Lezzet kodu:%-5s  Adı:%-20s  Adet:%-5s  Fiyat:%-4s TL\n",
                    order.dish.getCode(), order.dish.getName(), order.numOfDish, order.orderPrice);
            totalPrice += order.orderPrice;
        }
        System.out.println("Toptam tutar: " + totalPrice);
        System.out.println("Afiyet olsun...");
        this.orderList = new ArrayList<>();
    }


}//class
