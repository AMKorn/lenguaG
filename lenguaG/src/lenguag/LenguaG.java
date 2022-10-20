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
 * @author jvile
 */
public class LenguaG {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if(args.length < 1){
            System.err.println("Input file is required.");
            System.exit(-1);
        }
        Lexic.lexicAnalysis(args[0]);
    }
    
}
