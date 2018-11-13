package Backend;

import java.util.Date;

public class Record {

    private Product item;
    private String name;
    private Long code;
    private int quantity;
    private Date arrivalDate;

    public Record(Product item, String name, Long code, int quantity, Date arrivalDate) {
        this.item = item;
        this.name = name;
        this.code = code;
        this.quantity = quantity;
        this.arrivalDate = arrivalDate;
    }

    public Product getItem() {
        return item;
    }

    public void setItem(Product item) {
        this.item = item;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
}
