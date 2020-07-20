
/**
 * Write a description of Part1 here.
 * 
 * @author (Enrique Rodrigo Ledesma Pinet) 
 * @version (7/19/2020)
 */
public class Part1 {
    public String findSimpleGene(String dna){
        int startIndex = 0;
        int stopIndex = 0;
        //Find the index position of the start codon "ATG".
        if(dna.indexOf("ATG") != -1){
            startIndex = dna.indexOf("ATG");
            //Find the index of the stop codon "TAA".
            if(dna.indexOf("TAA", startIndex) != -1){
               stopIndex =  dna.indexOf("TAA", startIndex);
               //Check the length requirement
               if((stopIndex - startIndex) % 3 == 0){
                   return dna.substring(startIndex, stopIndex+3);
                }
            }
        }
        return "";
    }
    public void testSimpleGene(){
        String test1 = "AATGATAGAATAAGATGATAG";
        //Test 1 result: ATGATAGAATAA
        String test2 = "AAAAAAATTTTTGGGGGGCCC";
        //Test 2 result: 
        String test3 = "AATTGGGATGGGAAAATTTA";
        //Test 3 result:
        String test4 = "AATGATAGATAAGATGATAG";
        //Test 4 result: 
        String test5 = "AAATCGTACAATGAAAGTTGGATAATG";
        //Test 5 result = ATGAAAGTTGATAA
        
        //Perform tests
        System.out.println("Test 1: " + findSimpleGene(test1));
        System.out.println("Test 2: " + findSimpleGene(test2));
        System.out.println("Test 3: " + findSimpleGene(test3));
        System.out.println("Test 4: " + findSimpleGene(test4));
        System.out.println("Test 5: " + findSimpleGene(test5));
    }
}
