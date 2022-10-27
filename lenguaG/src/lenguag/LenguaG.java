/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candía, Joan 
 */
package lenguag;

import lenguag.lexic.*;

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
            System.err.println("Input file is required.");
            System.exit(-1);
        }
        if(DEBUGGING) System.out.println("Proceeding to read " + args[0]);
        Lexic.lexicAnalysis(args[0]);
    }
    
}
