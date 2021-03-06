package Backend;

import java.io.Serializable;

/**
 * The objects of this class are the products that the user wants to buy.
 */
public class Product implements Serializable, Comparable<Product> {

    /**
     * Overriding the compareto method to compare products based on name. (case sensitive)
     * @param o
     * @return
     */
    @Override
    public int compareTo(Product o) {
        return this.name.compareTo(o.name);
    }

    final private String name;
    private int units;
    private int cost;
    private String path;
    private String description;

    public int calcEOQ(){
        if (H == 0) return 0;
        else return (int) Math.sqrt(2*D*K/H);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getD() {
        return D;
    }

    public void setD(int d) {
        D = d;
    }

    public int getH() {
        return H;
    }

    public void setH(int h) {
        H = h;
    }

    public int getK() {
        return K;
    }

    public void setK(int k) {
        K = k;
    }

    int D, H, K;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /**
     * constructor for product.
     * @param name
     */
    public Product(String name){
        this.name = name;
        units = 0;
        cost = 0;
    }

    public String getName() {
        return name;
    }

    public String toString(){
        return name + ", units = " + this.units + ", cost = " + this.cost;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;

        if (this.units < 0) this.units = 0;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;

        if (this.cost < 0 ) this.cost = 0;
    }
}
