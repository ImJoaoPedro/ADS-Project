package objects;

import com.n1analytics.paillier.EncryptedNumber;
import com.n1analytics.paillier.PaillierContext;
import com.n1analytics.paillier.PaillierPublicKey;
import java.io.Serializable;
import java.math.BigInteger;

public class EncryptedSolution implements Serializable {

    private BigInteger[] numbers;
    private int[] exponents;
    private BigInteger modulus;
    private BigInteger quality;
    private int qualityMod;

    public EncryptedSolution(KeyPair kp, Solution solution){
        PaillierPublicKey key = new PaillierPublicKey(kp.getPublicKey().getModulus());
        PaillierContext context = key.createSignedContext();

        modulus = kp.getPublicKey().getModulus();
        numbers = new BigInteger[solution.getSolution().length];
        exponents = new int[numbers.length];

        for(int i =0; i < solution.getSolution().length; i++){
            EncryptedNumber n = context.encrypt(solution.getSolution()[i]);
            exponents[i] = n.getExponent();
            numbers[i] = n.calculateCiphertext();
        }
    }

    public void setQuality(BigInteger quality) {
        this.quality = quality;
    }

    public BigInteger getQuality() {
        return quality;
    }

    public BigInteger[] getNumbers() {
        return numbers;
    }

    public BigInteger getModulus() {
        return modulus;
    }

    public int[] getExponents() {
        return exponents;
    }

    public void setQualityExponent(int qualityMod) {
        this.qualityMod = qualityMod;
    }

    public int getQualityExponent() {
        return qualityMod;
    }
}
