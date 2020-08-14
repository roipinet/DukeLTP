
/**
 * Write a description of Part1 here.
 * 
 * @author (Enrique Rodrigo Ledesma Pineet) 
 * @version (8/13/2020)
 */
public class Part1 {
    public void findAbc(String input) {
    int index = input.indexOf("abc");
    while (true) {
        if (index == -1 || index > input.length() - 4) {
            break;
        }
        System.out.println("1: " + index+1 + " 4: " + index+4);
        String found = input.substring(index+1, index+4);
        System.out.println(found);
        index = input.indexOf("abc", index+4);
    }
}
   public void test() {
     
     findAbc("abcbbbabcdddabc");
     //findAbc("eusabce");
     //findAbc("woiehabchi");
     //findAbc("yabcyabc");
     //findAbc("aaaaabc");
}
}