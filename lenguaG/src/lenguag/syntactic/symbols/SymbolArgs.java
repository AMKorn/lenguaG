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
    SymbolArg argument;
    SymbolArgs arguments;

    public SymbolArgs(SymbolArg v1, SymbolArgs v2) {
        super("Arguments", 0);
        this.argument = v1;
        this.arguments = v2;
    }
    
}