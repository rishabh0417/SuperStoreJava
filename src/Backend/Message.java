package Backend;

import java.util.HashMap;

public class Message {

    private HashMap<Product, Integer> recordList;
    private Store sender;

    public Message(HashMap<Product, Integer> r, Store s){
        recordList = r;
        sender = s;
    }

    public HashMap<Product, Integer> getRecordList() {
        return recordList;
    }

    public void setRecordList(HashMap<Product, Integer> recordList) {
        this.recordList = recordList;
    }

    public Store getSender() {
        return sender;
    }

    public void setSender(Store sender) {
        this.sender = sender;
    }
}
