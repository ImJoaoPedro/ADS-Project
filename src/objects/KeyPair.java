package objects;

public class KeyPair {

    PrivateKey privateKey;
    PublicKey publicKey;

    public KeyPair(PrivateKey privatek, PublicKey publick){
        privateKey = privatek;
        publicKey = publick;
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }
}
