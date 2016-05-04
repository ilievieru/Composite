import base.Point;
import base.Shapes;
import org.junit.Assert;
import org.junit.Test;
import poligons.*;
import poligons.Rectangle;
import rounded.Circle;
import rounded.Ellipse;

/**
 * Created by v3790149 on 4/28/2016.
 */
public class TestComposite {
    @Test
    public void test1() {
        Point start = new Point(1, 1);
        Quarter square = new Quarter(3, start);
        Shapes triangle = new Triangle(3, start);
        Shapes recrangle = new Rectangle(3, 2, start);
        Shapes circle = new Circle(start,6);
        Shapes elipse = new Ellipse(start,3,2);

        String expected = triangle.draw()+ triangle.draw() + circle.draw() + elipse.draw()+ recrangle.draw() + square.draw() ;

        recrangle.addShape(triangle);
        recrangle.addShape(circle);
        recrangle.addShape(elipse);
        square.addShape(triangle);
        square.addShape(recrangle);

        square.draw();
        System.out.println("Composite");
        String actual = square.drawSubShapes();
        Assert.assertEquals(expected,actual);

    }
}
