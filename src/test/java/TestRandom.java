import org.junit.Test;

import java.util.Random;

/**
 * Created by V3790149 on 5/5/2016.
 */
public class TestRandom {
    @Test
    public void testRangom(){
        Random rand = new Random();
        int random = rand.nextInt() + rand.nextInt() - rand.nextInt() + rand.nextInt() - rand.nextInt()/10 + rand.nextInt()*10;
        System.out.println(random);
    }
}
