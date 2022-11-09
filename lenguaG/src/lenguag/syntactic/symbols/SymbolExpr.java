/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/*
 * EXPRESSION ::= VALUE:v                                                  {: RESULT = new SymbolExpr(v); :}
    | L_PAREN EXPRESSION:v R_PAREN                                      {: RESULT = new SymbolExpr(v); :}
    | L_PAREN OPERATION:v R_PAREN                                       {: RESULT = new SymbolExpr(v); :}
    | NOT EXPRESSION:v1  
 */
public class SymbolExpr extends SymbolBase {
    private boolean isExpr;
    SymbolValue value;
    SymbolExpr expression;
    SymbolOper operation;

    public SymbolExpr(SymbolValue value, boolean isExpr) {
        super("Value", 0);
        this.value = value;
        this.isExpr = isExpr;
    }

    public SymbolExpr(SymbolExpr expression, boolean isExpr) {
        super("Value", 0);
        this.expression = expression;
        this.isExpr = isExpr;
    }

    public SymbolExpr(SymbolOper operation, boolean isExpr) {
        super("Value", 0);
        this.operation = operation;
        this.isExpr = isExpr;
    }

    public SymbolExpr(SymbolExpr expression) {
        super("Value", 0);
        this.expression = expression;
        this.isExpr = false;
    }
}
