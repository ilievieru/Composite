/*<summary>
This class is a concrete implementation of polygons. This class creates any type of polygon as long as the point are correct given
 In this class I have two constructors. One that creates a standard polygon from a start point and a given number of points
 and one that creates a polygon from an array of points
</summary>*/
package poligons;
import Exceptions.WrongPointsExceptions;
import Visitor.Visitor;
import base.Point;
import java.util.Random;

/**
 * Created by V3790149 on 4/26/2016.
 */
public class ConcretPoligon extends Poligon implements java.io.Serializable  {
    //this creates a standard poligon starting from a start point
    public ConcretPoligon(Point p, int numberOfPoints){
        super(p);
        points = new Point[numberOfPoints];
        points[0] = p;
        for(int i = 1 ;i< numberOfPoints/2 ;i++) {
            Random r = new Random();
            int rand1 = r.nextInt((10));
            int rand2 = r.nextInt((10));
            //System.out.println(rand1 + " "+ rand2);
            Point point = new Point((points[i-1].getX() + rand1),points[i-1].getY()+rand2);
            points[i] = new Point(point.getX(),point.getY());
        }
        for(int i = numberOfPoints/2 ;i< numberOfPoints ;i++) {
            Random r = new Random();
            int rand1 = r.nextInt((10));
            int rand2 = r.nextInt((10));
            //System.out.println(rand1 + " "+ rand2);
            Point point = new Point((points[i-1].getX() - rand1),points[i-1].getY()-rand2);
            points[i] = new Point(point.getX(),point.getY());
        }
    }
    //this creates a poligon from a given set of points
    public ConcretPoligon(Point[] p){
        super(p);
        if (!testPoints(points))
            throw new WrongPointsExceptions("Fail");
            //
    }

    public ConcretPoligon setSize(float size){
        if(size!=0){
            for(int i = 0; i<points.length;i++){
                float x,y;
                if(points[i].getX()>=0)
                    x = points[i].getX() + size;
                else
                    x = points[i].getX() - size;
                if(points[i].getY() >= 0)
                    y = points[i].getX() + size;
                else
                y = points[i].getY() - size;

                points[i] = new Point(x, y);
            }
        }
        ConcretPoligon c = new ConcretPoligon(points);
        return  c;
    }
    @Override
    public String draw() {
        String rezultat = "\n" +
                " Nameless Poligon:";
        System.out.println("Nameless Poligon: ");
        for (int i = 0; i < points.length; i++) {
            System.out.println("Punctul " + i + "(" + points[i].getX() + ", " + points[i].getY() + ")");
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
