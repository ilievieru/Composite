/*<summary>
* This is one of base class. Every shape has point, so i created this class to have the base of every shape.
* This class creates objects witch contains two values. One for  coordinates on ox axis and another for oy axis.
 * Also same get methods to manipulate this points and a draw method to draw a point
* </summary>
* */
package base;
public class Point {
    float px = 0, py = 0;

    public Point(float x, float y) {
        px = x;
        py = y;
    }

    public float[] get() {
        float[] punct = new float[2];
        punct[0] = px;
        punct[1] = py;
        return punct;
    }

    public float getX() {
        return px;
    }

    public float getY() {
        return py;
    }
}
