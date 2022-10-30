/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candía, Joan 
 */
package lenguag;

import lenguag.lexic.*;
import java.io.*;

/**
 *
 * @authors Andreas, Joan, Marc
 */
public class LenguaG {

    public static final boolean DEBUGGING = true;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if(args.length < 1){
            // User error
            System.err.println("Input file is required.");
            return;
        }
        lexicAnalysis(args[0]);
    }
    
    /**
     * Prepares and analyses the file given by parameter.
     * @param sourceCode - path to the source code.
     */
    private static void lexicAnalysis(String sourceCode){
        String file = sourceCode;
        if(DEBUGGING) System.out.println("Proceeding to read " + file);
        FileReader in;
        try { 
            in = new FileReader(file);
        } catch(FileNotFoundException fnf) {
            // User error
            System.err.println("Input file " + file + " does not exist.");
            return;
        }
        Lexic la = new Lexic(in);
        la.analyze();
    }
}
