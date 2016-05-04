package rounded;

import Exceptions.WrongPointsExceptions;
import base.Point;
import poligons.ConcretPoligon;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

/**
 * Created by V3790149 on 4/27/2016.
 */
public class ConcretRoundedShapes extends RoundedShapes {

    public ConcretRoundedShapes(Point origin, float radius){
        super(origin,radius);
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
    public ConcretRoundedShapes(Point[] p){
        super(p);
        if(!testPoints(p)){
            throw new WrongPointsExceptions("Fail");
        }
    }
    public ConcretRoundedShapes setSize(float size){
        if(size!=0){
            for(int i = 1; i<points.length;i++){
                float x1,y1;
                if(points[i].getX()>=0)
                    x1 = points[i].getX() + size;
                else
                    x1 = points[i].getX() - size;
                if(points[i].getY() >= 0)
                    y1 = points[i].getX() + size;
                else
                    y1 = points[i].getY() - size;

                points[i] = new Point(x1, y1);
            }
        }
        ConcretRoundedShapes c = new ConcretRoundedShapes(points);
        return  c;
    }
    @Override
    public String draw() {
        String rezultat = "Nameless Rounded shape: ";
        System.out.println("Nameless Rounded shape: ");
        for (int i = 0; i < points.length; i++) {
            System.out.println("\nPunctul " + i + "(" + points[i].getX() + ", " + points[i].getY() + ")");
            rezultat = rezultat + " \nPunctul " + i + "(" + points[i].getX() + ", " + points[i].getY() + ")";
        }
        return rezultat;
    }
}
