
package rosalindProblems;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import rosalindProblems.Reader.DNAReader;
import rosalindProblems.Reader.RawDNAReader;


public class HAMM extends GenericProblem{
    

    @Override
    public DNAReader getReader(InputStream in) {
        DNAReader reader = new RawDNAReader();
        reader.Init(in);
        return reader;
    }

    @Override
    public String Solve(DNAReader Origin) {
        List<String> ls= Origin.ReadAllLines();
        String s=ls.get(0);
        String t=ls.get(1);
        int result=0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)!=t.charAt(i)) {
                result++;
            }
        }
        return (String.valueOf(result));
        
    }
}
