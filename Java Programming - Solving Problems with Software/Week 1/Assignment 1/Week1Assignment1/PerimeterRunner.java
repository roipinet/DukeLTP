
/**
 * Duke LTP Course 2 Week 1
 * Perimeter Assignment
 * 
 * @author (Enrique Rodrigo Ledesma Pinet) 
 * @version (7/13/2020)
 */
import edu.duke.*;
public class PerimeterRunner {
    public double getPerimeter(Shape s){
        //Variable to store the total perimeter.
        double totalPerim = 0;
        //We start on the last point of the shape.
        Point prevPt = s.getLastPoint();
        for(Point currPt: s.getPoints()){
            //Find the distance between this point and the next.
            double currDist = prevPt.distance(currPt);
            //Update the total perimeter y adding the newfound distance.
            totalPerim = totalPerim + currDist;
            //Move to the next point.
            prevPt = currPt;
        }
        return totalPerim;
    }
}
