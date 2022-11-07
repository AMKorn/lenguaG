/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/**
 * MAIN -> main L_PAREN ARGS R_PAREN L_KEY INSTRUCTIONS R_KEY.
 */

public class SymbolMain extends SymbolBase {
    SymbolArgs args;
    SymbolInstrs instructions;
    
    public SymbolMain(SymbolArgs args, SymbolInstrs instructions) {
        super("Main", 1);
        this.args = args;
        this.instructions = instructions;
    }
    
    
}
