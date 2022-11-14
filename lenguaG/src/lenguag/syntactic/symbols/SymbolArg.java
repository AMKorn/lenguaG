/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/**
 * ARG ::= TYPE:type VARIABLE:variable
 */
public class SymbolArg extends SymbolBase {
    private SymbolType type;
    private SymbolVar variable;

    public SymbolArg(SymbolType type, SymbolVar variable) {
        super("Argument", 0);
        this.type = type;
        this.variable = variable;
    }

    public int getType(){
        return type.getType();
    }

    public SymbolVar getVariable(){
        return variable;
    }
}