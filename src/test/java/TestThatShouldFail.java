import base.Point;
import org.junit.Assert;
import org.junit.Test;
import rounded.Circle;

/**
 * Created by V3790149 on 5/4/2016.
 */
public class TestThatShouldFail {
    //this method tests a circle
    @Test(expected = ArrayIndexOutOfBoundsException.class )
    public void testCircle() {
        Point origin = new Point(1, 1);

        Assert.assertTrue(origin.getX() == 1);
        Assert.assertTrue(origin.getY() == 1);

        Circle cer = new Circle(origin, 6);
        Assert.assertNotNull(cer);
        cer.draw();
        Assert.assertTrue(cer.getRadius() > 0);
        Point []p = cer.getPoints();
        for(int i = 0; i<p.length;i++){
            Assert.assertTrue(p[i].getX() <= cer.getRadius() + origin.getX());
            Assert.assertTrue(p[i].getY() <= cer.getRadius() + origin.getY());
        }
    }
}
