/*<summary>
This is an abstract class witch defines rounded shapes,like circle , ellipses and manny other. It defines two constructors,
 a test points method and the rest of method from the Shape interface.
* </summary>*/
package rounded;

import Visitor.Visitor;
import base.ID;
import base.Point;
import base.GenericShape;

import java.util.Random;

/**
 * Created by V3790149 on 4/26/2016.
 */
public abstract class RoundedShapes extends GenericShape implements java.io.Serializable {
    float radius;
    Point origin;

    public RoundedShapes(){

    }
    public RoundedShapes(Point p, float radius) {
        this.radius = radius;
        origin = new Point(p.getX(), p.getY());
        Random rand = new Random();
        this.id = rand.nextInt() + rand.nextInt() - rand.nextInt() + rand.nextInt() - rand.nextInt()/10 + rand.nextInt()*10;
        while(!ID.testId(this.id)){
            this.id = rand.nextInt() + rand.nextInt() - rand.nextInt() + rand.nextInt() - rand.nextInt()/10 + rand.nextInt()*10;
        }
        ID.addIdList(this.id);
    }

    public RoundedShapes(Point[] p) {
        points = p;
        Random rand = new Random();
        this.id = rand.nextInt() + rand.nextInt() - rand.nextInt() + rand.nextInt() - rand.nextInt()/10 + rand.nextInt()*10;
        while(!ID.testId(this.id)){
            this.id = rand.nextInt() + rand.nextInt() - rand.nextInt() + rand.nextInt() - rand.nextInt()/10 + rand.nextInt()*10;
        }
        ID.addIdList(this.id);
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
    @Override
    public void accept(Visitor visitor) {
        System.out.println("serializare:\n");
        visitor.serialize(this);
        System.out.println("Deserializare:\n ");
        visitor.deserialize(this);
    }
}