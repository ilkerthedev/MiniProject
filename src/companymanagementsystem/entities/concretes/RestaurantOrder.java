package companymanagementsystem.entities.concretes;

import companymanagementsystem.entities.abstracts.Dish;
import companymanagementsystem.entities.abstracts.Order;


public class RestaurantOrder extends Order {


    public RestaurantOrder(Dish dish, int numOfDish) {
        super(dish, numOfDish);
    }
}