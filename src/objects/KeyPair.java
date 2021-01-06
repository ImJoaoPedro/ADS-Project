package objects;

import com.n1analytics.paillier.PaillierPrivateKey;
import com.n1analytics.paillier.PaillierPublicKey;

import java.io.Serializable;

public class KeyPair implements Serializable {

    PaillierPrivateKey privateKey;
    PaillierPublicKey publicKey;

    public KeyPair(PaillierPrivateKey privatek, PaillierPublicKey publick){
        privateKey = privatek;
        publicKey = publick;
    }

    public PaillierPrivateKey getPrivateKey() {
        return privateKey;
    }

    public PaillierPublicKey getPublicKey() {
        return publicKey;
    }
}
