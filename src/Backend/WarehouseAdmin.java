package Backend;

import java.util.List;

/**
 * WareHouse admin has warehouses under it.
 */
public class WarehouseAdmin extends User {

    private List<Warehouse> list_of_warehouses;
    private Boolean messageReceivedFlag;
    private Message messageReceived;
    private Warehouse warehouse;

    /**
     * constructor
     * @param a
     * @param b
     */
    public WarehouseAdmin(String a, String b){
        super(a, b);
        messageReceivedFlag = false;
    }

    public void forwardMessage(){

    }

    public void checkEmptyStatus(){

    }

    public void alertLessInventory(){

    }

    public void transact(Store s){

    }

    public List<Warehouse> getList_of_warehouses() {
        return list_of_warehouses;
    }

    public void setList_of_warehouses(List<Warehouse> list_of_warehouses) {
        this.list_of_warehouses = list_of_warehouses;
    }

    public Boolean getMessageReceivedFlag() {
        return messageReceivedFlag;
    }

    public void setMessageReceivedFlag(Boolean messageReceivedFlag) {
        this.messageReceivedFlag = messageReceivedFlag;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public String getUsername(){ return username; }

    /**
     * sets user name for the wareHouse admin.
     * @param s
     */
    public void setUsername(String s){ this.username = s; }

    public String getPassword(){ return password; }

    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * sets passwords for the wareHouse admin.
     * @param s
     */
    public void setPassword(String s){ this.password = s; }

}
