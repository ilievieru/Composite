/*<summary>
This is a specific class witch creates a rectangle. It has two constructors, one for a standard rectangle, and one for a
specific rectangle. Also it has a testPoints method witch checks if the points respect certain conditions for creating a rectangle
More precise this method checks if the length si different from width.
</summary>
*/
package poligons;
import base.Point;

/**
 * Created by V3790149 on 4/26/2016.
 */
public class Rectangle extends Poligon {


    //length is Horizontal length and  width is vertical length
    public Rectangle(float length, float width, Point start) {
        super(start);
        this.length = length;
        this.width = width;
        points = new Point[4];
        points[0] = new Point(start.getX(), start.getY());
        points[1] = new Point(start.getX() + length, start.getY());
        points[2] = new Point(start.getX() + length, start.getY() - width);
        points[3] = new Point(start.getX(), start.getY() - width);
    }

    public Rectangle(Point[] p) {
        super(p);
        if (!testPoints(points))
            System.out.println("Fail: Wrong points");
    }

    @Override
    public Boolean testPoints(Point[] points) {
        if (points[1].getX() - points[0].getX() != points[2].getX() - points[3].getX())
            return false;
        if (points[0].getY() - points[3].getY() != points[1].getY() - points[2].getY())
            return false;

        return true;
    }
    public Rectangle setSize(float length, float width){
        if(length>0 && width>0){
            this.length = length;
            this.width = width;
        }else
            System.out.println("Wrong size! ");
        Rectangle r = new Rectangle(length,width,start);
        return r;
    }
}
