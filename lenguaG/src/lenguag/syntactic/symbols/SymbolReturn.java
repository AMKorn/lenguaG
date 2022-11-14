/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/*
 * RETURN ::= RES_RETURN EXPRESSION:v                                      {: RESULT = new SymbolReturn(v); :}
         | RES_RETURN OPERATION:v                                       {: RESULT = new SymbolReturn(v); :}
         | RES_RETURN                                                   {: RESULT = new SymbolReturn(); :}
         ;
 */
public class SymbolReturn extends SymbolBase {
    private SymbolExpr expression;
    private SymbolOper operation;

    public SymbolReturn(SymbolExpr expression) {
        super("Return", 0);
        this.expression = expression;
    }

    public SymbolReturn(SymbolOper operation) {
        super("Return", 0);
        this.operation = operation;
    }

    public SymbolReturn() {
        super("Return", 0);
    }
}
