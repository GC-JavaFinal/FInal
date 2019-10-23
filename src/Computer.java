import java.util.Random;

public class Computer {
    private Random rand = new Random();
    private int randNum = 0;
    private final int MAX_NUM = 9;

    public Computer() {
        this.randomNum();
    }

    public void randomNum() {
        rand = new Random();
        this.randNum = rand.nextInt(MAX_NUM);
    }

    public int getNum() {
        return this.randNum;
    }
}
