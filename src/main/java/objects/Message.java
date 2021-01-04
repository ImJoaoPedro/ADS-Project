package objects;

import java.io.Serializable;

public class Message implements Serializable {

    private static final long serialVersionUID = 5950169519310163575L;

    private PublicKey publicKey;
    private Solution solution;

    public Message(PublicKey publicKey, Solution solution){
        this.publicKey=publicKey;
        this.solution=solution;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public Solution getSolution() {
        return solution;
    }

    public void setSolution(Solution solution) {
        this.solution = solution;
    }
}
