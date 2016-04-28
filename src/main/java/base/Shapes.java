/*//<summary>
    This is the interface of shape hierarchy. All the shapes that can be create have in my project have this structure.
    They have a set of points, a color, a function that test tha  points, a set method for color, a get method for for points
        a draw method and a show one to display the points
//</summary>*/
package base;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Shapes {
    List<Shapes> shapeList = new ArrayList<Shapes>();
    public Point[] points = null;
    int color = 0;
    public Point start;//This is the start point witch all the shapes have. It is the poit from where i start drawing

    public Point[] getPoints() {
        return points;
    }

    ;

    public String draw() {
        String rezultat = "";
        if (shapeList.isEmpty())
            rezultat = rezultat + this.show();
        else {
            for (Shapes s : shapeList) {
                rezultat = rezultat + s.draw();
            }
            rezultat = rezultat + this.show();
        }
        return rezultat;
    }

    public List getShapeList() {
        return shapeList;
    }

    public String show() {
        String rezultat = "";
        System.out.println("");
        for (int i = 0; i < points.length; i++) {
            System.out.println("Punctul " + i + "(" + points[i].getX() + ", " + points[i].getY() + ")");
            rezultat = rezultat + "\nPunctul " + i + "(" + points[i].getX() + ", " + points[i].getY() + ")";
        }
        return rezultat;
    }

    public Point getStart() {
        return start;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void addShape(Shapes shape) {
        shapeList.add(shape);
    }

    public void removeShape(Shapes shape) {
        shapeList.remove(shape);
    }

}
