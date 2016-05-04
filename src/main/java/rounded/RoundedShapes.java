/*<summary>
This is an abstract class witch defines rounded shapes,like circle , ellipses and manny other. It defines two constructors,
 a test points method and the rest of method from the Shape interface.
* </summary>*/
package rounded;

import base.Point;
import base.Shapes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by V3790149 on 4/26/2016.
 */
public abstract class RoundedShapes extends Shapes {
    float radius;
    Point origin;

    public RoundedShapes(Point p, float radius) {
        this.radius = radius;
        origin = new Point(p.getX(), p.getY());
    }

    public RoundedShapes(Point[] p) {
        points = p;
    }

    public Boolean testPoints(Point[] points) {
        for (int i = 0; i < points.length; i++)
            for (int j = 0; j < points.length; j++)
                if (points[i].getX() == points[j].getX() && points[i].getY() == points[j].getY())
                    return false;
        return true;
    }

    public float getRadius() {
        return radius;
    }

    @Override
    public String draw() {
        String rezultat = "";
        System.out.println("");
        for (int i = 0; i < points.length; i++) {
            System.out.println("Punctul " + i + "(" + points[i].getX() + ", " + points[i].getY() + ")");
            //Desenez o forma rotunda
            rezultat = rezultat + "\nPunctul " + i + "(" + points[i].getX() + ", " + points[i].getY() + ")";
        }
        return rezultat;
    }
}