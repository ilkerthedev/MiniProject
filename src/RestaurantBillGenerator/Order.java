package RestaurantBillGenerator;

public class Order {

    public int orderCode;

    public Dish dish;

    public int numOfDish;

    public double orderPrice;

    public Order(Dish dish, int numOfDish) {
        this.dish = dish;
        this.numOfDish = numOfDish;
    }

    public void setOrderCode(int orderCode) {
        this.orderCode = orderCode;
    }

    public void setPrice() {
        this.orderPrice = dish.getPrice() * numOfDish;
    }


}
