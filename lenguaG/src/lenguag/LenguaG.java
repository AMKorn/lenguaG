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

    public static String outputPath = "../output/";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Args management
        if(args.length < 1){
            // User error
            System.err.println("Input file is required.");
            return;
        }
        String file = args[0];
        if(args.length > 1) outputPath += args[1];

        // Compilation
        if(DEBUGGING) System.out.println("Proceeding to read " + file.split("/")[1]);
        try { 
            FileReader in = new FileReader(file);
            Lexic la = new Lexic(in);
            SymbolFactory sf = new ComplexSymbolFactory();
            Parser parser = new Parser(la, sf);
            parser.parse();

            la.printTokens();
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
