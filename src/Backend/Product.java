package Backend;

import java.io.Serializable;

public class Product implements Serializable {

    final private String name;
    private int units;
    private int cost;
    private String path;
    int D, H, K;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    Product(String name){
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
