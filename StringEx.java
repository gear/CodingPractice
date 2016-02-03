import java.util.HashSet;

public class StringEx {

    /* Assuming we are checking over ASCII character set.
     * There are 256 characters. */
    public boolean hasDuplicate(String str) {
        boolean[] hit = new boolean[256];
        for (int i = 0; i < str.length(); ++i) {
            int c = str.charAt(i);
            if (hit[c]) return false;
            hit[c] = true;
        }
        return true;
    }

    /* Assuming we are check over 26 characters of the
     * English alphabet => We can use bit vector */
     public boolean hasDuplicateAlphabet(String str) {
        
     }



}
