
/**
 * Part 1 of week 2 exercises. 
 * 
 * @author (Enrique Rodrigo Ledesma Pinet) 
 * @version (7/21/2020)
 */
import java.util.*;
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
        //Find the first ATG
        int firstATG = dna.indexOf("ATG");
        if(firstATG != -1){
            //Find the first occurence of TAA.
            int firstTAA = findStopCodon(dna, firstATG, "TAA");
            //Find the first occurence of TAG
            int firstTAG = findStopCodon(dna, firstATG, "TAG");
            //Find the first occurence of TGA
            int firstTGA = findStopCodon(dna, firstATG, "TGA");
            //Calculate distances
            int bestDistance = 0;
            if(firstTAA < dna.length()){
                bestDistance = firstTAA - firstATG;
            }
            if(firstTAG < dna.length() && (firstTAG - firstATG) < bestDistance){
                bestDistance = firstTAG - firstATG;
            }
            if(firstTGA < dna.length() && (firstTGA - firstATG) < bestDistance){
                bestDistance = firstTGA - firstATG;
            }
            if(bestDistance > 0){
                return dna.substring(firstATG, firstATG+bestDistance+3);
            }
            else{
                return "";
            }

        }
        else{
         return "";   
        }
    }
    public void testFindGene(){
        String test1 = "AATGATAGAATAAGATGATAG";
        //Test 1 result: ATGATAGAATAA
        String test2 = "AAAAAAATTTTTGGGGGGCCC";
        //Test 2 result: ""
        String test3 = "AATTGGGATGGGAAAATTTA";
        //Test 3 result: ""
        String test4 = "AATGATAGATAAGATGATAG";
        //Test 4 result: ""
        String test5 = "AAATCGTACAATGAAAGTTGGATAATG";
        //Test 5 result = ATGAAAGTTGGATAA
        
        //Perform tests
        System.out.println("Test 1 = " + findGene(test1));
        System.out.println("Test 2 = " + findGene(test2));
        System.out.println("Test 3 = " + findGene(test3));
        System.out.println("Test 4 = " + findGene(test4));
        System.out.println("Test 5 = " + findGene(test5));
    }
    public void printAllGenes(String dna){
        int currentIndex = 0;
        while(currentIndex < dna.length()){
            //Look for a gene
            String currentGene = findGene(dna.substring(currentIndex));
            //Update the index
            if(currentGene.length() > 0){
            System.out.println(currentGene);
            currentIndex = dna.indexOf(currentGene) + currentGene.length();
        }
        else{
            currentIndex++;
        }
            
        }
    }
    public void testAllGenes(){
        String test1 = "AATGATAGAATAAGATGATAGAAATCGTACAATGAAAGTTGGATAATG";
        printAllGenes(test1);
    }
}
