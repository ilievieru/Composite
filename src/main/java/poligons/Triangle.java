/*<summary>
This is a specific class witch creates a Triangle. It has two constructors, one for a standard Triangle, and one for a
specific Triangle. Also it has a testPoints method witch checks if the points respect certain conditions for creating a Triangle.
It test the existence of identical points and if all the point are on the same line
* </summary>*/
package poligons;

import base.Point;

/**
 * Created by V3790149 on 4/26/2016.
 */
public class Triangle extends Poligon {

    public Triangle(float length, Point start) {
        super(start);
        points = new Point[3];
        points[0] = new Point(start.getX(), start.getY());
        points[1] = new Point(start.getX() - length, start.getY() - length);
        points[2] = new Point(start.getX() + length, start.getY() - length);
    }

    public Triangle(Point[] p) {
        super(p);
        if (!testPoints(points)) {
            System.out.println("Fail: Wrong points");
        }
    }

    @Override
    public Boolean testPoints(Point[] points) {
        if (points[0].equals(points[1]) || points[1].equals(points[2]) || points[0].equals(points[2]))
            return false;
        if (points[0].getX() == (points[1].getX() + points[2].getX()) / 2 && points[0].getY() == (points[1].getY() + points[2].getY()) / 2)
            return false;
        if (points[1].getX() == (points[0].getX() + points[2].getX()) / 2 && points[1].getY() == (points[0].getY() + points[2].getY()) / 2)
            return false;
        if (points[2].getX() == (points[0].getX() + points[1].getX()) / 2 && points[2].getY() == (points[0].getY() + points[1].getY()) / 2)
            return false;
        return true;
    }

    public Triangle setSize(float length){
        if(length>0 && width>0){
            this.length = length;
            this.width = length;
        }else
            System.out.println("Wrong size! ");
        Triangle r = new Triangle(length,start);
        return r;
    }
}
