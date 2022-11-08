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

    public static String outputFile = OUTPUT_PATH;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Args management
        if(args.length < 1){
            // User error. No file given as input.
            System.err.println("Input file is required.");
            return;
        }
        // Input file is given on the first arg
        String file = args[0];
        // Output file is either given on the second arg, or defaulted to out.
        outputFile += (args.length > 1) ? args[1] : "out";

        // Compilation
        if(DEBUGGING) {
            System.out.println("Proceeding to read " + file);
            System.out.println("Will write to " + outputFile);
        }
        try { 
            // DO NOT DELETE YET! To be used later
            // // In case the output folder does not exist, we create it.
            // File outf = new File(OUTPUT_PATH);
            // outf.mkdirs();
            // // We write the file
            // FileWriter out = new FileWriter(outputFile);
            // out.write("Hola");
            // out.close();

            FileReader in = new FileReader(file);
            Lexic la = new Lexic(in);
            SymbolFactory sf = new ComplexSymbolFactory();
            Parser parser = new Parser(la, sf);
            parser.parse();

            if(la.getError()){
                System.err.println("Lexic analysis failed due to: " 
                                + la.writeErrors()
                                + "Ending compilation process.");
                return;
            }

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
