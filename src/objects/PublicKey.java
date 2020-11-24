package objects;

import java.io.Serializable;

public class PublicKey implements Serializable {

    String key;

    public PublicKey(String key){
        this.key=key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
