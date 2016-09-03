/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rosalindProblems.Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 *
 * @author Santiago
 */
public abstract class ADNFastaReader {
    protected BufferedReader dataOrigin;
    
    public abstract List<String> LeerCadenasFasta();
    public abstract List<String> LeerTodoFasta();
    public abstract char LeerChar();
    public abstract String LeerLinea();
    public abstract void Init(FileReader in);
    public abstract boolean CanRead();
    public abstract void Close();
    public abstract List<String> ReadAllLines();
    
}
