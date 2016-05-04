/*<summary>
This class creates only a specific type of polygon, a quarter. It is a specific class witch extends polygon template but creates only quarter.
Also I have two constructors, one that creates a standard quarter from a start point with a specific length, and one witch creates a quarter from
a given array of points.
Also I have a test points method, override for this specific polygon, witch checks if exist two identical points an fi le length between some specific  points is the same al length
</summary>
* */
package poligons;
import Exceptions.WrongPointsExceptions;
import base.Point;
import base.Shapes;

/**
 * Created by V3790149 on 4/26/2016.
 */
public class Quarter extends Poligon {

    public Quarter(float length, Point start) {
        super(start);
        this.name = "Square";
        this.length = length;
        this.width = length;
        points = new Point[4];
        points[0] = new Point(start.getX(), start.getY());
        points[1] = new Point(start.getX() + length, start.getY());
        points[2] = new Point(start.getX() + length, start.getY() - length);
        points[3] = new Point(start.getX(), start.getY() - length);

    }

    public Quarter(Point[] p) {
        super(p);
        this.name = "Square";
        if (!testPoints(points))
            throw new WrongPointsExceptions("Fail");
    }

    @Override
    public Boolean testPoints(Point[] points) {
        float length = points[1].getX() - points[0].getX();
        float width = points[0].getY() - points[3].getY();
        if (Math.abs(points[1].getX() - points[0].getX()) != Math.abs(points[2].getX() - points[3].getX()))
            return false;
        if (Math.abs(points[0].getY() - points[3].getY()) != Math.abs(points[1].getY() - points[2].getY()))
            return false;
        if (Math.abs(length) != Math.abs(width))
            return false;
        return true;
    }

    public Quarter setSize(float size){
        if(size>0){
            this.length = size;
            this.width = size;
        }else
            System.out.println("Wrong size! ");
        Quarter q = new Quarter(size,start);
        return  q;
    }
    @Override
    public String draw() {
        String rezultat = "Square:";
        System.out.println("Square:");
        for (int i = 0; i < points.length; i++) {
            System.out.println("Punctul " + i + "(" + points[i].getX() + ", " + points[i].getY() + ")");
            rezultat = rezultat + "\nPunctul " + i + "(" + points[i].getX() + ", " + points[i].getY() + ")";
        }
        return rezultat;
    }

}
