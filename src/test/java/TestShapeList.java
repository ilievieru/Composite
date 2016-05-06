import base.Point;
import org.junit.Assert;
import org.junit.Test;
import poligons.Square;
import poligons.Rectangle;

import java.util.List;

/**
 * Created by V3790149 on 5/4/2016.
 */
public class TestShapeList {
    @Test
    public void testShapeList() {
        Point startPoint = new Point(1, 1);
        Square square = new Square(4, startPoint);
        Rectangle rectangle = new Rectangle(10, 4, startPoint);
        square.addShape(rectangle);
        List shape;
        shape = square.getShapeList();
        Assert.assertEquals(shape.size(),1);
    }
    @Test
    public void testStartPoint(){
        Point startPoint = new Point(1, 1);
        Square square = new Square(4, startPoint);
        Point actual = square.getStart();
        Assert.assertTrue(startPoint.getX()== actual.getX());
        Assert.assertTrue(startPoint.getY()== actual.getY());
    }



}
