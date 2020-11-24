package objects;

import java.io.Serializable;

public class CipherText implements Serializable {

    private String text;

    public CipherText(String text){
        this.text=text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
