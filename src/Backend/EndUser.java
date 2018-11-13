package Backend;

import java.util.ArrayList;

public class EndUser extends User {

    private double budget;
    private Cart cart;

    public EndUser(String a, String b){
        super(a, b);
    }

    public void checkout(){

    }

    public void addBudget(){

    }


    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
