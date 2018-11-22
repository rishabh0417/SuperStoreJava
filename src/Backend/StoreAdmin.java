package Backend;

public class StoreAdmin extends User {

    private Store store;

    public StoreAdmin(String a, String b){
        super(a, b);
    }

    public void generateMessage(){

    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
