package objects;

import java.io.Serializable;

public class PrivateKey implements Serializable {

    String key;

    public PrivateKey(String key){
        this.key=key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
