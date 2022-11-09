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

    private boolean isNegated;
    private SymbolBase expression;

    public SymbolExpr(SymbolBase expression){
        super("Expression", 0);
        this.expression = expression;
        isNegated = false;
    }

    public SymbolExpr(SymbolBase expression, boolean isNegated){
        super("Expression", 0);
        this.expression = expression;
        this.isNegated = isNegated;
    }
    
    // TODO getters
}
