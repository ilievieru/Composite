import Visitor.ConcretVisitor;
import Visitor.JsonSerialize;
import Visitor.XmlSerialize;
import base.ID;
import base.Point;
import base.Shape;
import org.junit.Assert;
import org.junit.Test;
import poligons.Square;
import poligons.Rectangle;

/**
 * Created by V3790149 on 5/4/2016.
 */
public class TestVisitor {
    @Test
    public void testVisitor(){
        Point start = new Point(1,1);
        Rectangle rectangle = new Rectangle(10,11,start);
        rectangle.accept(new ConcretVisitor());
        //rectangle.draw();
        Shape square = new Square(1,start);
        square.accept(new ConcretVisitor());
    }
    @Test
    public void testVisitor1(){
        Point start = new Point(1,1);
        Rectangle rectangle = new Rectangle(10,11,start);
        Shape square = new Square(1,start);
        square.addShape(rectangle);
        square.drawSubShapes();
        square.accept(new ConcretVisitor());
    }
    @Test
    public void testJson(){
        Point start = new Point(1,1);
        Rectangle rectangle = new Rectangle(10,11,start);
        //rectangle.accept(new JsonSerialize());
        Shape square = new Square(1,start);
        square.addShape(rectangle);
        square.accept(new JsonSerialize());
        //square.drawSubShapes();
    }

    @Test
    public void testXml(){
        Point start = new Point(1,1);
        Rectangle rectangle = new Rectangle(10,11,start);
        Shape square = new Square(1,start);
        square.addShape(rectangle);
        String expected = square.drawSubShapes();
        square.accept(new XmlSerialize());
        String actual = square.drawSubShapes();
        Assert.assertEquals(expected,actual);
    }
}
