/*This is a concrete implementation of rounded shapes. It is a class witch creates circles.
Also it has two constructors, one for a standard circle and one for a circle created from a number of points.
The test method for points is the standard one defined in RoundedShapes abstract class
* */
package rounded;

import Exceptions.WrongPointsExceptions;
import Visitor.Visitor;
import base.Point;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

/**
 * Created by V3790149 on 4/26/2016.
 */
public class Circle extends RoundedShapes implements java.io.Serializable  {

    public Circle(){

    }
    public Circle(Point origin, float radius){
        super(origin,radius);
        this.name = "Circle";
        points = new Point[38];
        points[0] = new Point(origin.getX(),origin.getY());
        int index = 1;
        for(int i = 0;i<=360;i= i+10){
            double x = origin.getX() + (radius * sin(i));
            double y = origin.getY() + (radius * cos(i));
            points[index] = new Point((float)x,(float)y);
            index ++;
        }
    }
    public Circle(Point[] p){
        super(p);
        this.name = "Circle";
        if (!testPoints(points))
            throw new WrongPointsExceptions("Fail");
    }
    public Circle setSize(float length){
        if(length>0 ){
           this.radius = length;
        }else
            System.out.println("Wrong size! ");
        Circle r = new Circle(origin,length);
        return r;
    }
    @Override
    public String draw() {
        String rezultat = "Circle:";
        System.out.println("Circle:");
        for (int i = 0; i < points.length; i++) {
            System.out.println(" Punctul " + i + "(" + points[i].getX() + ", " + points[i].getY() + ")");
            rezultat = rezultat + "\nPunctul " + i + "(" + points[i].getX() + ", " + points[i].getY() + ")";
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
