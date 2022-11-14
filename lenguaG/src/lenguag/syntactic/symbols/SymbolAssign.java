/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/*
 * ASSIGNATION ::= VARIABLE:variable EQUAL OPERATION:rSide
              | VARIABLE:variable EQUAL EXPRESSION:rSide
              ;
 */

public class SymbolAssign extends SymbolBase {

    private SymbolVar variable;
    private Object rSide;

    //private SymbolExpr expression;
    //private SymbolOper operation;

    public SymbolAssign(SymbolVar variable, Object rSide) {
        super("Assignation", 0);
        this.variable = variable;
        this.rSide = rSide;
    }

    // TODO return right side
}