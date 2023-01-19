package companymanagementsystem.entities.concretes;

import companymanagementsystem.entities.abstracts.Dish;

public class RestaurantDish extends Dish {


    public RestaurantDish(int code, String name, double price) {
        super(code, name, price);
    }
}