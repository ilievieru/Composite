/*//<summary>
    This is the interface of shape hierarchy. All the shapes that can be create have in my project have this structure.
    They have a set of points, a color, a function that test tha  points, a set method for color, a get method for for points
        a draw method and a show one to display the points
//</summary>*/
package base;
public interface Shapes {
    Point[] points = null;
    int color = 0;
    Boolean testPoints(Point[] points);
    void setColor(int color);
    Point[] getPoints();
    void deseneaza();
    void show();
}
