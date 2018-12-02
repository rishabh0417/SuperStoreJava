package Backend;

import java.util.ArrayList;

/**
 * end user is the customer that is going to buy the products.<br> This software is built to cater to the needs of the end user.
 */
public class EndUser extends User {

    /**
     * Balance of the end user.
     */
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
