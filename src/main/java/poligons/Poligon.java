/*<summary>
    This is am abstract class whitch represents all the poligons. It containes all the method witch are common between
    poligons and atributes that all poligon have. They have points, length, width, and color
</summary>
* */

package poligons;
import base.Point;
import base.Shapes;

public abstract  class  Poligon implements Shapes {
    Point[] points;
    int color;
    Point start;//This is the start point witch all the shapes have. It is the poit from where i start drawing
    float length;
    float width;

    public  Poligon(Point p){
        start = new Point(p.getX(),p.getY());
    }
    public Poligon(Point[] p){
        points = p;
        start = points[0];
    }
    //This is a method to test the points that my poligon has. More precisely it test the existence of two identical points
    // and also display this points, if exists
    public Boolean testPoints(Point[] points) {
        for(int i = 0; i< points.length;i++)
            for(int j = 0; j< points.length ; j++)
                if(points[i].getX() == points[j].getX() && points[i].getY() == points[j].getY() && i != j) {
                    System.out.println(points[i].getX()+","+points[i].getY() + " " + points[j].getX()+","+points[j].getY());
                    return false;
                }
        return true;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Point getStart(){
        return  start;
    }
    public Point[] getPoints() {
        return points;
    }

    public void deseneaza() {

    }

    public void show() {
        for (int i = 0; i < points.length; i++) {
            System.out.println("Punctul " + i + "(" + points[i].getX() + ", " + points[i].getY() + ")");
        }
    }

    public float getLength(){
        return  length;
    }

    public float getWidth(){
        return  width;
    }

    public void setLength(float length){
        this.length = length;
    }

    public void setWidth(float width){
        this.width = width;
    }
}
