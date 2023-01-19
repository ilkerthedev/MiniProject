package companymanagementsystem.entities.concretes;


import companymanagementsystem.entities.abstracts.Dish;
import companymanagementsystem.entities.abstracts.Order;

public class CafeOrder extends Order {

    public CafeOrder(Dish dish, int numOfDish) {
        super(dish, numOfDish);
    }
}