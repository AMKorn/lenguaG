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
 */

public class SymbolAssign extends SymbolBase {

    private SymbolVar variable;
    private SymbolOper rSide;

    //private SymbolExpr expression;
    //private SymbolOper operation;

    public SymbolAssign(SymbolVar variable, SymbolOper rSide) {
        super("Assignation", 0);
        this.variable = variable;
        this.rSide = rSide;
    }

    public SymbolVar getVariable(){
        return variable;
    }

    public SymbolOper getRightSide(){
        return rSide;
    }
}