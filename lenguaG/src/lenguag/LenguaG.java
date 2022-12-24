/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Korn, Andreas Manuel
 * 	- Román Colom, Marc
 * 	- Vilella Candía, Joan 
 */
package lenguag;

import java.io.*;
import java_cup.runtime.*;
import lenguag.lexic.*;
import lenguag.syntactic.*;
import lenguag.syntactic.symbols.*;
import lenguag.semantic.*;
import lenguag.LenguaGException.*;
import lenguag.backend.IntermediateCodeGenerator;

/**
 *
 * @authors Andreas, Joan, Marc
 */
public class LenguaG {

    public static final boolean DEBUGGING = true;
    public static final String OUTPUT_PATH = "../output/";

    public static String outputPath = OUTPUT_PATH;

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
            // Input and compilation start
            FileReader in = new FileReader(file);
            Lexic la = new Lexic(in);
            SymbolFactory sf = new ComplexSymbolFactory();
            Parser parser = new Parser(la, sf);
            Object resultSyn = parser.parse().value;

            // Error checking
            if(la.thereIsError()) 
                throw new LexicException("Lexic analysis failed. Ending compilation process.");
            // If the lexic analysis was correct, we print the tokens to outputPath/tokens.txt
            if(DEBUGGING) System.out.println("Writing tokens list...");
            writeFile(outputPath, "tokens.txt", la.writeTokens());
            
            if(parser.thereIsError || !(resultSyn instanceof SymbolBody)) 
                throw new SyntacticException("Syntactic analysis failed. Ending compilation process.");

            // Semantic analysis
            Semantic sem = new Semantic();
            sem.manage((SymbolBody) resultSyn);
            if(sem.thereIsError){
                System.err.println("Semantic analysis failed. Ending compilation process.");
                return;
            }
            if(DEBUGGING) System.out.println("Writing symbol table...");
            writeFile(outputPath, "Symbol Table.txt", sem.symbolTable.toString());
            IntermediateCodeGenerator c3a = new IntermediateCodeGenerator();
            try {
                c3a.generate((SymbolBody) resultSyn);
            } catch(NullPointerException TEMPORARY) {
                // TODO remove
                TEMPORARY.printStackTrace();
                writeFile(outputPath, "c3a.txt", c3a.toString());
            }
            if(DEBUGGING) System.out.println("Writing three address code...");
            writeFile(outputPath, "c3a.txt", c3a.toString());
            
        } catch (FileNotFoundException fnf) {
            // User error
            System.err.println("Input file " + file + " does not exist.");
            return;
        } catch(LexicException le){
            // User error
            System.err.println(le.getMessage());
        } catch(SyntacticException se){
            // User error 
            System.err.println(se.getMessage());
        }
        
        catch (IOException e) {
            // !!! COMPILER ERROR !!!
            e.printStackTrace();
        } catch (Exception e) {
            // !!! COMPILER ERROR !!!
            e.printStackTrace();
        }
    }

    /**
     * Method that writes the text to the given file on the given path, creating it if necessary.
     * File will be created in path/file, so file cannot be a path.
     * @param path
     * @param file
     * @param text 
     */
    static public void writeFile(String path, String file, String text) throws IOException {
        // In case the output folder does not exist, we create it.
        File outf = new File(path);
        outf.mkdirs();
        // We write the file with the tokens
        FileWriter fileOut = new FileWriter(path + file);
        fileOut.write(text);
        fileOut.close();
    }

    static private String getOutputPath(String file) {
        String[] fileSplitSlash = file.split("/");

        return fileSplitSlash[fileSplitSlash.length - 1] + "/";
    }
}
