/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/**
 * MAIN ::= RES_MAIN L_PAREN ARGS:args R_PAREN L_KEY INSTRUCTIONS:instructions R_KEY
 */

public class SymbolMain extends SymbolBase {
    private SymbolArgs args;
    private int nArgs;
    private SymbolInstrs instructions;
    
    public SymbolMain(SymbolArgs args, SymbolInstrs instructions) {
        super("Main", 0);
        this.args = args;
        nArgs = args.getNArgs();
        this.instructions = instructions;
    }
    
    public SymbolArgs getArgs(){
        return args;
    }

    public int getNArgs(){
        return nArgs;
    }

    public SymbolInstrs getInstructions(){
        return instructions;
    }
}
