import edu.duke.*;

public class PerimeterRunner {
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

    public void testPerimeter () {
        FileResource fr = new FileResource("example1.txt");
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
    
    public int getNumPoints(Shape s){
        //Create a counter
        int counter = 0;
        //Iterate throught the shape
        for(Point currPt : s.getPoints()){
            counter++;
        }
        return counter;
            
    }
    
    public double getAverageLength(Shape s){
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
    
    public double getLargestSide(Shape s){
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
    
        public double getLargestX(Shape s){
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
    
    public static void main (String[] args) {
        PerimeterRunner pr = new PerimeterRunner();
        pr.testPerimeter();
    }
}
