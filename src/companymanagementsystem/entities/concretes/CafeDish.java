package companymanagementsystem.entities.concretes;

import companymanagementsystem.entities.abstracts.Dish;

public class CafeDish extends Dish {

    private String details;

    public CafeDish(int code, String name, double price) {
        super(code, name, price);
    }
}