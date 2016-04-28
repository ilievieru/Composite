/*This is a concrete implementation of rounded shapes. It is a class witch creates Ellipses.
Also it has two constructors, one for a standard Ellipse and one for a Ellipse created from a number of points.
The test method for points is the standard one defined in RoundedShapes abstract class
* */
package rounded;
import base.Point;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

/**
 * Created by V3790149 on 4/26/2016.
 */
public class Ellipse extends RoundedShapes {

    public Ellipse(Point origin, float radius, float radius1){
        super(origin,radius);
        points = new Point[38];
        points[0] = new Point(origin.getX(),origin.getY());
        int index = 1;
        for(int i = 0;i<=360;i= i+10){
            double x = origin.getX() + (radius * sin(i));
            double y = origin.getY() + (radius1 * cos(i));
            points[index] = new Point((float)x,(float)y);
            index ++;
        }
    }

    public Ellipse(Point[] p){
        super(p);
        if (!testPoints(points))
            System.out.println("Fail: Wrong points");
    }
    public Ellipse setSize(float radius1,float radius2){
        if(radius1>0 && radius2>0 ){
            this.radius = radius1;
        }else
            System.out.println("Wrong size! ");
        Ellipse r = new Ellipse(origin,radius1,radius2);
        return r;
    }
}