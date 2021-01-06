package objects;

import java.io.Serializable;

public class Solution implements Serializable {

    private int[] numbers;
    private int quality;

    public Solution(int[] numbers){
        this.numbers = numbers;
    }

    public int[] getSolution() {
        return numbers;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public void setSolution(int[] numbers) {
        this.numbers = numbers;
    }

    public int getQuality() {
        return quality;
    }

    public void setNumber(int position, int newValue){
        numbers[position] = newValue;
    }

}
