
/**
 * Write a description of Part3 here.
 * 
 * @author (Enrique Rodrigo Ledesma Pinet) 
 * @version (7/19/2020)
 */
public class Part3 {
    public boolean twoOccurrences(String stringa, String stringb){
        if(stringb.indexOf(stringa) != -1){
            //First occurrence found
            int firstIndex = stringb.indexOf(stringa);
            if(stringb.indexOf(stringa, firstIndex+1) != -1){
                //Second occurence found
                return true;
            }
        }
        return false;
    }
    
    public void testing(){
        //Create true test strings
        String true1 = "the lord of the rings";
        String true2 = "my friend and myself";
        String true3 = "master of masters";
        //Create false test strings
        String false1 = "a tale of two cities";
        String false2 = "star wars";
        String false3 = "another title";
        //Run tests
        System.out.println(twoOccurrences("the", true1));
        System.out.println(twoOccurrences("my", true2));
        System.out.println(twoOccurrences("master", true3));
        System.out.println(twoOccurrences("tale;", false1));
        System.out.println(twoOccurrences("star", false2));
        System.out.println(twoOccurrences("another", false3));
        //Create laspart test strings
        String test1 = "banana";
        String test2 = "forest";
        System.out.println("The last part of the string after an in banana is " + lastPart("an", test1));
        System.out.println("The last part of the string after zoo in forest is " + lastPart("zoo", test2));
    }
    
    public String lastPart(String stringa, String stringb){
        //Create the output string
        String output = stringb;
        if(stringb.indexOf(stringa) != -1){
            //Update output string
            output = output.substring(stringb.indexOf(stringa)+stringa.length());
            return output;
        }
        else{
            return output;
        }
    }
}
