/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/*
 * ARG ::= TYPE:v1 VARIABLE:v2 
 */
public class SymbolArg extends SymbolBase {
    SymbolType type;
    SymbolVar variable;

    public SymbolArg(SymbolType v1, SymbolVar v2) {
        super("Argument", 0)
        this.type = v1;
        this.variable = v2;
    }
}