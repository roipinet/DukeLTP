
/**
 * Part 1 of week 2 exercises. 
 * 
 * @author (Enrique Rodrigo Ledesma Pinet) 
 * @version (7/21/2020)
 */
public class Part1 {
    public int findStopCodon(String dna, int startIndex, String stopCodon){
        int stopIndex = 0;
        int currentIndex = startIndex;
        //Iterate through the dna string
        while(stopIndex != -1){
            //Search for the stop codon
            stopIndex = dna.indexOf(stopCodon, currentIndex);
            //Check the length of the possible gene.
            if(stopIndex != -1 && (stopIndex+stopCodon.length()-startIndex) % 3 == 0){
                 return stopIndex;
                
            }
            else{
                currentIndex++;
            }
        }
        return dna.length();
    }
    
    public void testFindStopCodon(){
        String test1 = "AATGATAGAATAAGATGATAG";
        //Test 1 result: 10
        String test2 = "AAAAAAATTTTTGGGGGGCCC";
        //Test 2 result: length
        String test3 = "AATTGGGATGGGAAAATTTA";
        //Test 3 result: length
        String test4 = "AATGATAGATAAGATGATAG";
        //Test 4 result: length
        String test5 = "AAATCGTACAATGAAAGTTGGATAATG";
        //Test 5 result = 22
        
        //Perform tests
        System.out.println("Test 1 (Length = " + test1.length() + "): " + findStopCodon(test1, 1, "TAA"));
        System.out.println("Test 2 (Length = " + test2.length() + "): " + findStopCodon(test2, 0, "TAA"));
        System.out.println("Test 3 (Length = " + test3.length() + "): " + findStopCodon(test3, 7, "TAA"));
        System.out.println("Test 4 (Length = " + test4.length() + "): " + findStopCodon(test4, 1, "TAA"));
        System.out.println("Test 5 (Length = " + test5.length() + "): " + findStopCodon(test5, 10, "TAA"));
    }
    
    public String findGene(String dna){
        
    }
}
