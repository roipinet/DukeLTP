import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        //Create a counter
        int counter = 0;
        //Iterate throught the shape
        for(Point currPt : s.getPoints()){
            counter++;
        }
        return counter;
         
    }

    public double getAverageLength(Shape s) {
        double average = 0;
        int counter = 0;
        double totalPerim = 0;
        //Traverse all points
        Point prevPt = s.getLastPoint();
        for(Point currPt : s.getPoints()){
            //Increase counter
            counter ++;
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
       //Calculate average
        average = totalPerim / counter;
        return average;
    }

    public double getLargestSide(Shape s) {
        double largest = 0;
        //Traverse the points
        Point prevPt = s.getLastPoint();
        for(Point currPt : s.getPoints()){
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            if(currDist > largest){
                largest = currDist;
            }
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        return largest;
    }

    public double getLargestX(Shape s) {
        double largestX = 0;
        //Traverse the points
        Point prevPt = s.getLastPoint();
        for(Point currPt : s.getPoints()){
            // Find distance from prevPt point to currPt 
            if(currPt.getX() > largestX){
                largestX = currPt.getX();
            }
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        DirectoryResource dr = new DirectoryResource();
        double maxPerimeter = 0.0;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            //Get the perimeter
            double thisPerimeter = getPerimeter(s);
            if(thisPerimeter > maxPerimeter){
                maxPerimeter = thisPerimeter;
            }   
        }
        return maxPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        DirectoryResource dr = new DirectoryResource();
        double maxPerimeter = 0.0;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            //Get the perimeter
            double thisPerimeter = getPerimeter(s);
            if(thisPerimeter > maxPerimeter){
                temp = f;
            }   
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource("datatest1.txt");
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int numPoints = getNumPoints(s);
        double average = getAverageLength(s);
        double largest = getLargestSide(s);
        double largestX = getLargestX(s);
        System.out.println("points = " + numPoints);
        System.out.println("perimeter = " + length);
        System.out.println("average distance = " + average);
        System.out.println("largest side = " + largest);
        System.out.println("largest x = " + largestX);
    }
    
    public void testPerimeterMultipleFiles() {
        System.out.println(getLargestPerimeterMultipleFiles());
    }

    public void testFileWithLargestPerimeter() {
        System.out.println(getFileWithLargestPerimeter());
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+ peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        //pr.testPerimeter();
        pr.testFileWithLargestPerimeter();
    }
}
