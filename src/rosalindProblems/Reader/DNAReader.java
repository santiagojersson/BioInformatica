/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rosalindProblems.Reader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author JuanFelipe
 */
public abstract class DNAReader {
    
    protected InputStreamReader dataOrigin;
    
    public abstract char ReadChar();
    public abstract String ReadLine();
    public abstract List<String> ReadAllLines();
    public abstract void Init(InputStream in);
    public abstract boolean CanRead();
    public abstract void Close();
    
}
