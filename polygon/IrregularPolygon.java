package polygon; 

import java.awt.geom.*; // for Point2D.Double
import java.util.ArrayList; // for ArrayList
import gpdraw.*; // for DrawingTool

public class IrregularPolygon {
    private ArrayList<Point2D.Double> myPolygon = new ArrayList<Point2D.Double>();

    // constructor
    public IrregularPolygon() {}

    // public methods
    public void add(Point2D.Double aPoint)
    {
        myPolygon.add(aPoint);
    }

    public double perimeter() {
        if (myPolygon.size() < 2) { //one point doesn't have a perimeter
            return 0.0;
        }

        double perimeter = 0.0;
        for (int i = 0; i < myPolygon.size(); i++) {
            Point2D.Double current = myPolygon.get(i); 
            Point2D.Double next = myPolygon.get((i + 1) % myPolygon.size()); //takes the next point, and the modulus prevents overflow

            perimeter += current.distance(next); //distance function applies the formula to the points
        }
        return perimeter;
    }

    public double area() {
        if (myPolygon.size() < 3) { //polygons must have a minimum of 3 sides to be enclosed
            return 0.0;
        }

        double area = 0.0; //area is calculated with the shoelace formula as you showed on the slides

        for (int i = 0; i < myPolygon.size(); i++) {
            Point2D.Double current = myPolygon.get(i);
            Point2D.Double next = myPolygon.get((i + 1) % myPolygon.size()); //same logic as the perimeter method

            area += (current.getX() * next.getY()); //diagonal downward values are positive
            area -= (current.getY() * next.getX()); //diagonal upward values are negative
        }
        return Math.abs(area) * 0.5; //ensures area is positive and takes half of the value since the formula returns double the area
    }

    public void draw()
    {
        // Wrap the DrawingTool in a try/catch to allow development without need for graphics.
        try {
            // TODO: Draw the polygon.
            // Documents: https://pavao.org/compsci/gpdraw/html/gpdraw/DrawingTool.html
            //DrawingTool myDrawingTool = new DrawingTool(new SketchPad(500, 500));
            //myDrawingTool.move(50, 50);
        } catch (java.awt.HeadlessException e) {
            System.out.println("Exception: No graphics support available.");
        }
    }

}
