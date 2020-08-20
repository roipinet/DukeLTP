
/**
 * Write a description of Part1 here.
 * PENDING FIX. 
 * @author (Enrique Rodrigo Ledesma Pinet) 
 * @version (8/16/2020)
 */
import edu.duke.*;
import java.util.ArrayList;
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
        return -1;
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
            int bestDistance = dna.length();
            if(firstTAA != -1){
                bestDistance = firstTAA - firstATG;
            }
            if(firstTAG != -1 && (firstTAG - firstATG) < bestDistance){
                bestDistance = firstTAG - firstATG;
            }
            if(firstTGA != -1 && (firstTGA - firstATG) < bestDistance){
                bestDistance = firstTGA - firstATG;
            }
            if(bestDistance > 0 && bestDistance < dna.length()){
                System.out.println("String length: " + dna.length());
                System.out.println("ATG: " + firstATG);
                System.out.println("TAA: " + firstTAA);
                System.out.println("TAG: " + firstTAG);
                System.out.println("TGA: " + firstTGA);
                System.out.println("Stop: " + Integer.toString(firstATG+bestDistance));
                System.out.println("Gene: " + firstATG+bestDistance+3);
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
    public StorageResource getAllGenes(String dna){
        int currentIndex = 0;
        StorageResource geneList = new StorageResource();
        while(currentIndex < dna.length()){
            //Look for a gene
            String currentGene = findGene(dna.substring(currentIndex));
            //Update the index
            if(currentGene.length() > 0){
            geneList.add(currentGene);
            currentIndex = dna.indexOf(currentGene) + currentGene.length();
        }
        else{
            currentIndex++;
        }
            
        }
        return geneList;
    }
    public void testAllGenes(){
        String test1 = "AATGATAGAATAAGATGATAGAAATCGTACAATGAAAGTTGGATAATG";
        printAllGenes(test1);
    }
    public float cgRatio(String dna){
        //Count C's and G's
        int cgCounter = 0;
        for(int i = 0;i<dna.length();i++){
            if(dna.charAt(i) == 'C' || dna.charAt(i) == 'G'){
                cgCounter++;
            }
        }
        //Calculate the ratio
        return (float) cgCounter/dna.length();
    }
    public int countCTG(String dna){
        int counter = 0;
        int currentIndex = 0;
        //Iterate the string
        while(currentIndex <= dna.length()-3){
            System.out.println("Current index: " + currentIndex);
            if(dna.indexOf("CTG", currentIndex) >= currentIndex)
            {
                counter++;
                System.out.println("Found at index: " + dna.indexOf("CTG", currentIndex) + " Counter: " + counter + " New Index: " + Integer.toString(currentIndex+3));
                currentIndex= dna.indexOf("CTG", currentIndex) + 3;
            }
            else{
                currentIndex++;
            }
        }
        return counter;
    }
    public void testCTG(){
        //              01234567890123456789
        String test1 = "CTGAATTTGTCTGGGGTCTG";
        System.out.println("Test1: " + countCTG(test1));
    }
    public void processGenes(StorageResource sr){
        
        int numStringsLargerThanX = 0;
        int numStringsCGLarger = 0;
        ArrayList<String> stringsLargerThanX = new ArrayList<String>();
        ArrayList<String> stringsCGLarger = new ArrayList<String>();
        int longestGeneLength = 0;
        //Iterate the StorageResource to get all the results
        for( String s : sr.data()){
            if(s.length() > 60){
                numStringsLargerThanX++;
                stringsLargerThanX.add(s);
            }
            if(cgRatio(s) > 0.35){
                numStringsCGLarger++;
                stringsCGLarger.add(s);
            }
            if(s.length() > longestGeneLength){
               longestGeneLength = s.length(); 
            }
        }
        //Print the results
        //print all the Strings in sr that are longer than 9 characters
        System.out.println("Strings larger than 60: ");
        for (String s : stringsLargerThanX) {
            System.out.println(s);
        }
        //print the number of Strings in sr that are longer than 9 characters
        System.out.println("Number of strings larger than 60: " + numStringsLargerThanX);
        //print the Strings in sr whose C-G-ratio is higher than 0.35
        System.out.println("Strings with a C-G-Ratio higher than 0.35: ");
        for (String s : stringsCGLarger) {
            System.out.println(s);
        }
        //print the number of strings in sr whose C-G-ratio is higher than 0.35
        System.out.println("Number of strings with a C-G-Ratio higher than 0.35: " + numStringsCGLarger);
        //print the length of the longest gene in sr
        System.out.println("Length of the longest gene" + longestGeneLength);
    }
    public void testProcessGenes(){
        FileResource fr = new FileResource("brca1line.fa");
        String dna = fr.asString().toUpperCase();
        StorageResource genes = getAllGenes(dna);
        processGenes(genes);
    }
    
    
}
