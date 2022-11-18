/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/**
 * MAIN ::= RES_MAIN L_KEY INSTRUCTIONS:instructions R_KEY
 */

public class SymbolMain extends SymbolBase {
    private SymbolInstrs instructions;
    
    public SymbolMain(SymbolInstrs instructions, int line, int column) {
        super("Main", 0, line, column);
        this.instructions = instructions;
    }

    public SymbolInstrs getInstructions(){
        return instructions;
    }
}
