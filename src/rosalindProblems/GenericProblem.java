/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rosalindProblems;

import rosalindProblems.Reader.DNAReader;
import java.io.InputStream;

/**
 *
 * @author JuanFelipe
 */
public abstract class GenericProblem {
    
    public abstract DNAReader getReader(InputStream in);
    public abstract String Solve(DNAReader Origin);
    
}
