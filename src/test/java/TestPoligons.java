/*<summary>
This is a class used to test my code. In here I create same concrete shapes an test them to see if are created correctly
* </summary>*/

import Exceptions.WrongPointsExceptions;
import Exceptions.WrongSizeExceptions;
import base.Point;
import org.junit.Assert;
import org.junit.Test;
import poligons.*;
import rounded.Circle;
import rounded.Ellipse;

/**
 * Created by V3790149 on 4/26/2016.
 */
public class TestPoligons {
    @Test
    public void testPoint() {
        Point p = new Point(1, 1);
        float[] actual = p.get();
        Assert.assertTrue(actual[0] == p.getX());
        Assert.assertTrue(actual[1] == p.getY());
    }

    //this method tests a triangle
    @Test(expected = WrongPointsExceptions.class)
    public void testTriangle() {
        Point startPoint = new Point(10, 10);

        Assert.assertTrue(startPoint.getX() == 10);
        Assert.assertTrue(startPoint.getY() == 10);

        Triangle triangle = new Triangle(3, startPoint);
        triangle.draw();
        Point[] p = new Point[3];
        p[0] = new Point(1, 1);
        p[1] = new Point(2, 2);
        p[2] = new Point(3, 3);
        Triangle tr = new Triangle(p);
        Assert.assertEquals(3, tr.getPoints().length);
        Assert.assertNotNull(tr);
        tr.setSize(-2);
    }

    @Test(expected = WrongSizeExceptions.class)
    public void testTriangleSize() {
        Point startPoint = new Point(10, 10);
        Triangle triangle = new Triangle(3, startPoint);
        triangle.setSize(-2);
    }

    //this method tests a quarter
    @Test(expected = WrongPointsExceptions.class)
    public void testQuarter() {
        Point startPoint = new Point(1, 1);

        Assert.assertTrue(startPoint.getX() == 1);
        Assert.assertTrue(startPoint.getY() == 1);

        Quarter quarter = new Quarter(3, startPoint);
        Assert.assertTrue(quarter.getLength() == quarter.getWidth());
        Assert.assertNotNull(quarter);
        quarter.draw();
        System.out.println("After resize");
        quarter = quarter.setSize(8);
        quarter.draw();
        Point p[] = new Point[4];
        p[0] = new Point(1, 1);
        p[1] = new Point(4, 1);
        p[2] = new Point(4, 2);
        p[3] = new Point(1, -2);
        Quarter q = new Quarter(p);
        Assert.assertEquals(4, q.getPoints().length);
    }

    //this method tests a rectangle
    @Test(expected = WrongPointsExceptions.class)
    public void testRectangle() {
        Point startPoint = new Point(1, 1);

        Assert.assertTrue(startPoint.getX() == 1);
        Assert.assertTrue(startPoint.getY() == 1);

        Rectangle rectangle = new Rectangle(3, 1, startPoint);
        Assert.assertTrue(rectangle.getLength() != rectangle.getWidth());
        Assert.assertNotNull(rectangle);
        rectangle.draw();
        System.out.println("After resize");
        rectangle = rectangle.setSize(2, 5);
        rectangle.draw();

        Point p[] = new Point[4];
        p[0] = new Point(1, 10);
        p[1] = new Point(4, 1);
        p[2] = new Point(4, 0);
        p[3] = new Point(1, 0);
        //Aici exceptia
        Rectangle q = new Rectangle(p);

        Assert.assertEquals(4, q.getPoints().length);
        q.setLength(10);


    }

    //this method tests a polygon
    @Test(expected = WrongPointsExceptions.class)
    public void testConcretPoligin() {
        Point startPoint = new Point(1, 1);

        Assert.assertTrue(startPoint.getX() == 1);
        Assert.assertTrue(startPoint.getY() == 1);

        ConcretPoligon poligon = new ConcretPoligon(startPoint, 6);

        Assert.assertNotNull(poligon);
        poligon.draw();
        System.out.println("After resize: ");
        poligon = poligon.setSize(10);
        poligon.draw();
        Point p[] = new Point[6];
        p[0] = new Point(1, 10);
        p[1] = new Point(4, 1);
        p[2] = new Point(4, 0);
        p[3] = new Point(1, 1);
        p[4] = new Point(1, 2);
        p[5] = new Point(1, 3);
        ConcretPoligon pol = new ConcretPoligon(p);
        pol.setSize(10);
        Assert.assertEquals(6, pol.getPoints().length);
        //pol.show();
    }

    @Test
    public void testPoligon() {
        Point startPoint = new Point(1, 1);
        Poligon poligon = new ConcretPoligon(startPoint, 6);
        poligon.setLength(10);
        poligon.setWidth(11);
        Assert.assertTrue(10 == poligon.getLength());
        Assert.assertTrue(11 == poligon.getWidth());
    }


}

