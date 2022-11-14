/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/**
 * ARGS ::= ARG:argument MORE_ARGS:contArgs
 *        | 
 */
public class SymbolArgs extends SymbolBase {

    private int nArgs;
    private SymbolArg argument;
    private SymbolArgs contArgs;

    public SymbolArgs(SymbolArg argument, SymbolArgs contArgs) {
        super("Arguments", 0);
        this.argument = argument;
        this.contArgs = contArgs;
        nArgs = contArgs.getNArgs()+1;
    }

    public SymbolArgs(){
        super("Arguments", 0);
        nArgs = 0;
    }
    
    public SymbolArg getArg(){
        return argument;
    }

    public SymbolArgs getNext(){
        return contArgs;
    }

    public int getNArgs(){
        return nArgs;
    }
}