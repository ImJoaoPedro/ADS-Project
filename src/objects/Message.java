package objects;

import java.io.Serializable;

public class Message implements Serializable {

    private static final long serialVersionUID = 5950169519310163575L;

    private EncryptedSolution solution;

    public Message(EncryptedSolution solution){
        this.solution=solution;
    }

    public EncryptedSolution getSolution() {
        return solution;
    }

    public void setSolution(EncryptedSolution solution) {
        this.solution = solution;
    }
}
