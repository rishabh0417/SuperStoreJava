package Backend;


/**
 * This class is the store admin which manages the store coming under it.
 */
public class StoreAdmin extends User {

    /**
     * The store under the admin.
     */
    private Store store;

    /**
     * constructor
     * @param a
     * @param b
     */
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
