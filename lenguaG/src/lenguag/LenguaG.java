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
import lenguag.syntactic.symbols.*;

/**
 *
 * @authors Andreas, Joan, Marc
 */
public class LenguaG {

    public static final boolean DEBUGGING = true;
    public static final String OUTPUT_PATH = "../output/";

    public static String outputPath = OUTPUT_PATH;
    private static boolean continueCompilation = true;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Args management
        if (args.length < 1) {
            // User error. No file given as input.
            System.err.println("Input file is required.");
            return;
        }
        // Input file is given on the first arg
        String file = args[0];
        // Output file is either given on the second arg, or defaulted to the name of
        // the output.
        if (args.length > 1)
            outputPath += getOutputPath(args[1]);
        else
            outputPath += getOutputPath(file);

        // Compilation
        if (DEBUGGING) {
            System.out.println("Proceeding to read " + file);
            System.out.println("Will write to " + outputPath);
        }
        try {
            // DO NOT DELETE YET! To be used later
            // // In case the output folder does not exist, we create it.
            // File outf = new File(OUTPUT_PATH);
            // outf.mkdirs();
            // // We write the file
            // FileWriter out = new FileWriter(outputPath);
            // out.write("Hola");
            // out.close();

            // Input and compilation start
            FileReader in = new FileReader(file);
            Lexic la = new Lexic(in);
            SymbolFactory sf = new ComplexSymbolFactory();
            Parser parser = new Parser(la, sf);
            Object resultSyn = parser.parse().value;

            if(la.thereIsError() || !(resultSyn instanceof SymbolBody)){
                System.err.println("Lexic-syntactical analysis failed. Ending compilation process.");
                continueCompilation = false;
            }
            
            // Output
            // In case the output folder does not exist, we create it.
            File outf = new File(outputPath);
            outf.mkdirs();
            // We write the file
            FileWriter lexicOut = new FileWriter(outputPath + "tokens.txt");
            lexicOut.write(la.writeTokens());
            lexicOut.close();
        } catch (FileNotFoundException fnf) {
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

    static private String getOutputPath(String file) {
        String[] fileSplitSlash = file.split("/");

        return fileSplitSlash[fileSplitSlash.length - 1] + "/";
    }
}
