/*<summary>
    This is am abstract class whitch represents all the poligons. It containes all the method witch are common between
    poligons and atributes that all poligon have. They have points, length, width, and color
</summary>
* */

package poligons;

import base.Point;
import base.Shapes;

import java.util.ArrayList;
import java.util.List;

public abstract class Poligon extends Shapes {
    float length;
    float width;

    public Poligon(Point p) {
        start = new Point(p.getX(), p.getY());
        this.name = "Poligon";

    }

    public Poligon(Point[] p) {
        points = p;
        start = points[0];
        this.name = "Poligon";
    }

    //This is a method to test the points that my poligon has. More precisely it test the existence of two identical points
    // and also display this points, if exists
    public Boolean testPoints(Point[] points) {
        for (int i = 0; i < points.length; i++)
            for (int j = 0; j < points.length; j++)
                if (points[i].getX() == points[j].getX() && points[i].getY() == points[j].getY() && i != j) {
                    System.out.println(points[i].getX() + "," + points[i].getY() + " " + points[j].getX() + "," + points[j].getY());
                    return false;
                }
        return true;
    }

    public float getLength() {
        return length;
    }

    public float getWidth() {
        return width;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public void setWidth(float width) {
        this.width = width;
    }
}
