/*<summary>
This is a specific class witch creates a Triangle. It has two constructors, one for a standard Triangle, and one for a
specific Triangle. Also it has a testPoints method witch checks if the points respect certain conditions for creating a Triangle.
It test the existence of identical points and if all the point are on the same line
* </summary>*/
package poligons;

import Exceptions.WrongPointsExceptions;
import Exceptions.WrongSizeExceptions;
import Visitor.Visitor;
import base.Point;

/**
 * Created by V3790149 on 4/26/2016.
 */
public class Triangle extends Poligon implements java.io.Serializable  {

    public Triangle(){

    }
    public Triangle(float length, Point start) {
        super(start);
        this.name = "Triangle";
        points = new Point[3];
        points[0] = new Point(start.getX(), start.getY());
        points[1] = new Point(start.getX() - length, start.getY() - length);
        points[2] = new Point(start.getX() + length, start.getY() - length);
    }

    public Triangle(Point[] p) {
        super(p);
        this.name = "Triangle";
        if (!testPoints(points)) {
            throw new WrongPointsExceptions("Fail");
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
        if(length>0){
            this.length = length;
            this.width = length;
        }else
            throw new WrongSizeExceptions("Fail");
        Triangle r = new Triangle(length,start);
        return r;
    }

    @Override
    public String draw() {
        String rezultat = "Triangle:";
        System.out.println("Triangle:");
        for (int i = 0; i < points.length; i++) {
            System.out.println(" Punctul " + i + "(" + points[i].getX() + ", " + points[i].getY() + ")");
            rezultat = rezultat + " \nPunctul " + i + "(" + points[i].getX() + ", " + points[i].getY() + ")";
        }
        return rezultat;
    }
    @Override
    public void accept(Visitor visitor) {
        System.out.println("serializare:\n");
        visitor.serialize(this);
        System.out.println("Deserializare:\n ");
        visitor.deserialize(this);
    }
}
