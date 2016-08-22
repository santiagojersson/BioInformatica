
package rosalindProblems;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class HAMM {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/rosalindProblems/in.txt"));
        
        String s=br.readLine();
        String t=br.readLine();
        int result=0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)!=t.charAt(i)) {
                result++;
            }
        }
        System.out.println(result);
        
    }
}
