/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/*
 * IF ::= RES_IF L_PAREN OPERATION:condition R_PAREN L_KEY INSTRUCTIONS:v2 R_KEY ELSE:v3 
 */
public class SymbolIf extends SymbolBase {
    private SymbolOper condition;
    private SymbolInstrs instructions;
    private SymbolElse s_else;

    public SymbolIf(SymbolCond condition, SymbolInstrs instructions, SymbolElse s_else) {
        super("Condition", 0);
        this.condition = condition;
        this.instructions = instructions;
        this.s_else = s_else;
    }
    
}
