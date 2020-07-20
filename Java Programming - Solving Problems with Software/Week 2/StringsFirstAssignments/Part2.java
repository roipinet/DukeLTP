
/**
 * Write a description of Part2 here.
 * 
 * @author (Enrique Rodrigo Ledesma Pinet) 
 * @version (7/19/2020)
 */
public class Part2 {
    public String findSimpleGene(String dnaInput, String startCodonInput, String stopCodonInput){
        int startIndex = 0;
        int stopIndex = 0;
        boolean isLower = false;
        String dna = dnaInput;
        String startCodon = startCodonInput;
        String stopCodon = stopCodonInput;
        
        //Check for lowercase
        if(dna.charAt(0) == 'a' || dna.charAt(0) == 't' || dna.charAt(0) == 'g' || dna.charAt(0) == 'c'){
            //Set lowercase flag
            isLower = true;
            //Set strings to uppercase
            dna = dna.toUpperCase();
            startCodon = startCodon.toUpperCase();
            stopCodon = stopCodon.toUpperCase();
        }
        //Find the index position of the start codon "ATG".
        if(dna.indexOf(startCodon) != -1){
            startIndex = dna.indexOf(startCodon);
            //Find the index of the stop codon "TAA".
            if(dna.indexOf(stopCodon, startIndex) != -1){
               stopIndex =  dna.indexOf(stopCodon, startIndex);
               //Check the length requirement
               if((stopIndex - startIndex) % 3 == 0){
                   if(isLower){
                       return dna.substring(startIndex, stopIndex+3).toLowerCase();
                   }
                   else{
                       return dna.substring(startIndex, stopIndex+3);
                    }
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
        System.out.println("Test 1: " + findSimpleGene(test1.toLowerCase(), "ATG", "TAA"));
        System.out.println("Test 2: " + findSimpleGene(test2.toLowerCase(), "ATG", "TAA"));
        System.out.println("Test 3: " + findSimpleGene(test3.toLowerCase(), "ATG", "TAA"));
        System.out.println("Test 4: " + findSimpleGene(test4.toLowerCase(), "ATG", "TAA"));
        System.out.println("Test 5: " + findSimpleGene(test5.toLowerCase(), "ATG", "TAA"));
    }
}
