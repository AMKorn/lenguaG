/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/*
 * ASSIGNATION ::= VARIABLE:v1 EQUAL OPERATION:v2                          {: RESULT = new SymbolAssign(v1, v2); :} 
              | VARIABLE:v1 EQUAL EXPRESSION:v2                         {: RESULT = new SymbolAssign(v1, v2); :}
              ;
 */

public class SymbolAssign extends SymbolBase {
    private SymbolVar variable;
    private SymbolExpr expression;
    private SymbolOper operation;

    public SymbolAssign(SymbolVar variable, SymbolOper operation) {
        super("Assignation", 0);
        this.variable = variable;
        this.operation = operation;
    }

    public SymbolAssign(SymbolVar variable, SymbolExpr expression) {
        super("Assignation", 0);
        this.variable = variable;
        this.expression = expression;
    }
}