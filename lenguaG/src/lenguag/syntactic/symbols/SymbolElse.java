/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/**
 * ELSE ::= RES_ELSE IF:nextIf
 *        | RES_ELSE L_KEY INSTRUCTIONS:instructions R_KEY
 *        |
 */
public class SymbolElse extends SymbolBase {
    
    private SymbolIf nextIf;
    private SymbolInstrs instructions;

    public SymbolElse(SymbolIf nextIf, int line, int column){
        super("else", 0, line, column);
        this.nextIf = nextIf;
    }

    public SymbolElse(SymbolInstrs instructions, int line, int column){
        super("else", 0, line, column);
        this.instructions = instructions;
    }

    public SymbolElse(){
        super("else", 0);
    }

    public SymbolIf getIf(){
        return nextIf;
    }

    public SymbolInstrs getInstructions(){
        return instructions;
    }
}
