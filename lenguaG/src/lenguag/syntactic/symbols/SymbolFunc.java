/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */

package lenguag.syntactic.symbols;

/*
 * FUNCTION ::= TYPE:v1 VARIABLE:v2 L_PAREN ARGS:v3 R_PAREN L_KEY INSTRUCTIONS:v4 R_KEY 
 */
public class SymbolFunc extends SymbolBase {
    SymbolType type;
    SymbolVar variable;
    SymbolArgs args;
    SymbolInstrs instructions;

    public SymbolFunc(SymbolType type, SymbolVar variable, SymbolArgs args, SymbolInstrs instructions) {
        super("Function", 0);
        this.type = type;
        this.variable = variable;
        this.args = args;
        this.instructions = instructions;
    }

}
