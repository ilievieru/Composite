import Exceptions.WrongPointsExceptions;
import base.Point;
import org.junit.Assert;
import org.junit.Test;
import rounded.Circle;
import rounded.Ellipse;

/**
 * Created by V3790149 on 5/4/2016.
 */
public class TestRoundedShapes {
    @Test
    public void testCircle1() {
        try {
            Point origin = new Point(1, 1);
            Circle cer = new Circle(origin, 6);
            Assert.assertNotNull(cer);
            cer.draw();
            Assert.assertTrue(cer.getRadius() > 0);
        } catch (Exception e) {
            System.out.println("Problems " + e.getMessage());
        }
    }

    @Test(expected = WrongPointsExceptions.class)
    public void testCircle() {
        Point p[] = new Point[6];
        p[0] = new Point(1, 10);
        p[1] = new Point(4, 1);
        p[2] = new Point(4, 0);
        p[3] = new Point(1, 1);
        p[4] = new Point(1, 2);
        p[5] = new Point(1, 3);
        Circle circle = new Circle(p);
        circle.draw();
        circle.setSize(10);
        Assert.assertTrue(10 == circle.getRadius());
    }

    @Test
    public void testEllipse() {
        Point origin = new Point(1, 1);

        Assert.assertTrue(origin.getX() == 1);
        Assert.assertTrue(origin.getY() == 1);

        Ellipse cer = new Ellipse(origin, 2, 6);
        Assert.assertNotNull(cer);
        cer.draw();
        Assert.assertTrue(cer.getRadius() > 0);
    }

    @Test(expected = WrongPointsExceptions.class)
    public void testElipsepoints() {
        Point p[] = new Point[6];
        p[0] = new Point(1, 10);
        p[1] = new Point(4, 1);
        p[2] = new Point(4, 0);
        p[3] = new Point(1, 1);
        p[4] = new Point(1, 2);
        p[5] = new Point(1, 3);
        Ellipse ellipse = new Ellipse(p);
        ellipse.draw();
        ellipse.setSize(10,11);
        Assert.assertTrue(10 == ellipse.getRadius());
    }
}
