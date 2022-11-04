/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candía, Joan 
 */
package lenguag;

import java.io.*;
import java_cup.runtime.*;

import lenguag.lexic.*;
import lenguag.syntactic.*;

/**
 *
 * @authors Andreas, Joan, Marc
 */
public class LenguaG {

    public static final boolean DEBUGGING = true;
    public static final String OUTPUT_PATH = "../output/";

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
            Lexic la = new Lexic(in);
            SymbolFactory sf = new ComplexSymbolFactory();
            Parser parser = new Parser(la, sf);
            parser.parse();

            la.printTokens();
            /* String tokens = la.writeTokens();
            System.out.println(tokens);
            FileWriter out;
            out = new FileWriter(OUTPUT_PATH + "tokens.txt");
            out.write(tokens);
            out.close(); */
        } catch(FileNotFoundException fnf) {
            // User error
            System.err.println("Input file " + file + " does not exist.");
            return;
        } catch (IOException e) {
            // !!! COMPILER ERROR !!!
            e.printStackTrace();
        } catch (Exception e) {
            // !!! COMPILER ERROR !!!
            e.printStackTrace();
        }
    }
}
