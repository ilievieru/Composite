/*<summary>
This is a class used to test my code. In here I create same concrete shapes an test them to see if are created correctly
* </summary>*/
import poligons.Poligon;
import base.Point;
import org.junit.Assert;
import org.junit.Test;
import poligons.*;
import rounded.Circle;
import rounded.Ellipse;

/**
 * Created by V3790149 on 4/26/2016.
 */
public class Test1 {
    //this method tests a triangle
    @Test
    public void testTriangle() {
        Point startPoint = new Point(10, 10);

        Assert.assertTrue(startPoint.getX() == 10);
        Assert.assertTrue(startPoint.getY() == 10);

        Triangle triangle = new Triangle(3, startPoint);
        triangle.show();
        Point[] p = new Point[3];
        p[0] = new Point(1, 1);
        p[1] = new Point(2, 2);
        p[2] = new Point(3, 3);
        Triangle tr = new Triangle(p);
        Assert.assertEquals(3, tr.getPoints().length);
        Assert.assertNotNull(tr);
    }

    //this method tests a quarter
    @Test
    public void testQuarter() {
        Point startPoint = new Point(1, 1);

        Assert.assertTrue(startPoint.getX() == 1);
        Assert.assertTrue(startPoint.getY() == 1);

        Quarter quarter = new Quarter(3, startPoint);
        Assert.assertTrue(quarter.getLength() == quarter.getWidth());
        Assert.assertNotNull(quarter);
        quarter.show();
        System.out.println("After resize");
        quarter = quarter.setSize(8);
        quarter.show();
        Point p[] = new Point[4];
        p[0] = new Point(1, 1);
        p[1] = new Point(4, 1);
        p[2] = new Point(4, 2);
        p[3] = new Point(1, -2);
        Quarter q = new Quarter(p);
        Assert.assertEquals(4, q.getPoints().length);
    }

    //this method tests a rectangle
    @Test
    public void testRectangle() {
        Point startPoint = new Point(1, 1);

        Assert.assertTrue(startPoint.getX() == 1);
        Assert.assertTrue(startPoint.getY() == 1);

        Rectangle rectangle = new Rectangle(3, 1, startPoint);
        Assert.assertTrue(rectangle.getLength() != rectangle.getWidth());
        Assert.assertNotNull(rectangle);
        rectangle.show();
        System.out.println("After resize");
        rectangle = rectangle.setSize(2,5);
        rectangle.show();
        Point p[] = new Point[4];
        p[0] = new Point(1, 10);
        p[1] = new Point(4, 1);
        p[2] = new Point(4, 0);
        p[3] = new Point(1, 0);
        Rectangle q = new Rectangle(p);
        Assert.assertEquals(4, q.getPoints().length);


    }

    //this method tests a polygon
    @Test
    public void testConcretPoligin() {
        Point startPoint = new Point(1, 1);

        Assert.assertTrue(startPoint.getX() == 1);
        Assert.assertTrue(startPoint.getY() == 1);

        ConcretPoligon poligon = new ConcretPoligon(startPoint, 6);

        Assert.assertNotNull(poligon);
        poligon.show();
        System.out.println("After resize: ");
        poligon = poligon.setSize(10);
        poligon.show();
        Point p[] = new Point[6];
        p[0] = new Point(1, 10);
        p[1] = new Point(4, 1);
        p[2] = new Point(4, 0);
        p[3] = new Point(1, 1);
        p[4] = new Point(1, 2);
        p[5] = new Point(1, 3);
        ConcretPoligon pol = new ConcretPoligon(p);

        Assert.assertEquals(6, pol.getPoints().length);
        //pol.show();
    }

    //this method tests a circle
    @Test(expected = ArrayIndexOutOfBoundsException.class )
    public void testCircle() {
        Point origin = new Point(1, 1);

        Assert.assertTrue(origin.getX() == 1);
        Assert.assertTrue(origin.getY() == 1);

        Circle cer = new Circle(origin, 6);
        Assert.assertNotNull(cer);
        cer.show();
        Assert.assertTrue(cer.getRadius() > 0);
        Point []p = cer.getPoints();
        for(int i = 0; i<p.length;i++){
            Assert.assertTrue(p[i].getX() <= cer.getRadius() + origin.getX());
            Assert.assertTrue(p[i].getY() <= cer.getRadius() + origin.getY());
        }
    }
    @Test
    public void testCircle1() {
        try {
            Point origin = new Point(1, 1);
            Circle cer = new Circle(origin, 6);
            Assert.assertNotNull(cer);
            cer.show();
            Assert.assertTrue(cer.getRadius() > 0);
        }catch(Exception e){
            System.out.println("Problems " + e.getMessage());
        }
    }
    @Test
    public void testEllipse() {
        Point origin = new Point(1, 1);

        Assert.assertTrue(origin.getX() == 1);
        Assert.assertTrue(origin.getY() == 1);

        Ellipse cer = new Ellipse(origin, 2,6);
        Assert.assertNotNull(cer);
        cer.show();
        Assert.assertTrue(cer.getRadius() > 0);
    }
}

