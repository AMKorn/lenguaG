/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/*
 * OPERATION ::= EXPRESSION:v1 OP:v2 EXPRESSION:v3                         {: RESULT = new SymbolOper(v1, v2, v3); :}
            ;
 */
public class SymbolOper extends SymbolBase {
    private SymbolExpr expression1;
    private SymbolExpr expression2;

    public SymbolOper(SymbolExpr expression1, SymbolExpr expression2) {
        super("Operation", 0);
        this.expression1 = expression1;
        this.expression2 = expression2;
    }
}
