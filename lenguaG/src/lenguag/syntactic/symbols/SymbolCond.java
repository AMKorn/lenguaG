/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/*
 * CONDITION ::= EXPRESSION:v                                              {: RESULT = new SymbolCond(v); :}
            | OPERATION:v                                               {: RESULT = new SymbolCond(v); :}
            ;
 */
public class SymbolCond extends SymbolBase {
    private SymbolExpr expression;
    private SymbolOper operation;

    public SymbolCond(SymbolExpr expression) {
        super("Condition", 0);
        this.expression = expression;
    }

    public SymbolCond(SymbolOper operation) {
        super("Condition", 0);
        this.operation = operation;
    }
}
