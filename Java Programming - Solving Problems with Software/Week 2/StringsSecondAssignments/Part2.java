
/**
 * Write a description of Part2 here.
 * 
 * @author (Enrique Rodrigo Ledesma Pinet) 
 * @version (8/7/2020)
 */
public class Part2 {
    public int howMany(String stringa, String stringb){
        int counter = 0;
        //Traverse stringb
        for(int i = 0;i<stringb.length();i++){
            int nextOccurrence = stringb.indexOf(stringa, i);
            if(nextOccurrence != -1){
                counter++;
                i = nextOccurrence+1;
            }
        }
        return counter;
    }
    public void testHowMany(){
        //Test 1, result: 3.
        System.out.println(" Test 1: " + howMany("GAA", "ATGAACGAATTGAATC"));
        //Test 2, result: 2.
        System.out.println(" Test 2: " + howMany("AA", "ATAAAA"));
    }
    
}
