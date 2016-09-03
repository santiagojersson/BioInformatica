/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rosalindProblems;

import java.io.FileReader;
import rosalindProblems.Reader.DNAReader;
import java.io.InputStream;
import rosalindProblems.Reader.ADNFastaReader;

/**
 *
 * @author JuanFelipe
 */
public abstract class GenericProblem {
    public abstract ADNFastaReader getFastaReader(FileReader in);
    public abstract String Solve(ADNFastaReader Origin);
    
}
