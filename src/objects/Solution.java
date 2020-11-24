package objects;

import java.io.Serializable;

public class Solution implements Serializable {

    private String text;

    public Solution(String text){
        this.text=text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
