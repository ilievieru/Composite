/*//<summary>
    This is the interface of shape hierarchy. All the shapes that can be create have in my project have this structure.
    They have a set of points, a color, a function that test tha  points, a set method for color, a get method for for points
        a draw method and a show one to display the points
//</summary>*/
package base;

import Visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public abstract class GenericShape implements Shape, java.io.Serializable {
    public List<GenericShape> shapeList = new ArrayList<GenericShape>();
    public String name = "Shape";
    public Point start;//This is the start point witch all the shapes have. It is the poit from where i start drawing
    public Point[] points = null;
    public int id;

    public Point[] getPoints() {
        return points;
    }

    public String drawSubShapes() {
        String rezultat = "";
        if (shapeList.isEmpty())
            rezultat = rezultat + this.draw();
        else {
            System.out.println("SubShape of " + this.getName());
            for (GenericShape s : shapeList) {
                System.out.println("The SubShape is " + s.getName());
                rezultat = rezultat + s.drawSubShapes();
            }
            rezultat = rezultat + this.draw();
        }
        return rezultat;
    }

    public List getShapeList() {
        return shapeList;
    }

    public String draw() {
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


    public void addShape(GenericShape shape) {
        shapeList.add(shape);
    }

    public void removeShape(GenericShape shape) {
        shapeList.remove(shape);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return this.id;
    }

    public void accept(Visitor visitor) {
        System.out.println("serializare:\n");
        visitor.serialize(this);
        System.out.println("Deserializare:\n ");
        visitor.deserialize(this);
    }
}
