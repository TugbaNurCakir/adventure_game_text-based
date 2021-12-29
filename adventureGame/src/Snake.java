import java.util.Random;

public class Snake extends Obstacle{
    public Snake() {
        super(4, randomDamage(), 12, "snake", 0);
    }

    public static int randomDamage(){
        Random r = new Random();
        int damage = r.nextInt(4)+3;
        return damage;
    }
}
