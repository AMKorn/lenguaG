/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/*
 * LOOP ::= RES_WHILE L_PAREN CONDITION:v1 R_PAREN L_KEY INSTRUCTIONS:v2 R_KEY 
                                                                        {: RESULT = new SymbolLoop(v1, v2); :}
       ;
 */
public class SymbolLoop extends SymbolBase {
    private SymbolCond condition;
    private SymbolInstrs instructions;
    
    public SymbolLoop(SymbolCond condition, SymbolInstrs instructions) {
        super("Loop", 0);
        this.condition = condition;
        this.instructions = instructions;
    }
}
