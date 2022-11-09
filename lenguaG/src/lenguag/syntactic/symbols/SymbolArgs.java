/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/**
 * ARGS ::= ARG:v1 MORE_ARGS:v2
    | 
 */
public class SymbolArgs extends SymbolBase {
    private SymbolArg argument;
    private SymbolArgs arguments;

    public SymbolArgs(SymbolArg v1, SymbolArgs v2) {
        super("Arguments", 0);
        this.argument = v1;
        this.arguments = v2;
    }
    
    public SymbolArg getArg(){
        return argument;
    }

    public SymbolArgs getNext(){
        return arguments;
    }
}