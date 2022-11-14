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

public class SymbolAssign extends SymbolInstr {

    private SymbolVar variable;
    private SymbolOperation rSide;

    //private SymbolExpr expression;
    //private SymbolOper operation;

    public SymbolAssign(SymbolVar variable, SymbolOperation rSide) {
        super("Assignation", 0, instructionType.instAssignation);
        this.variable = variable;
        this.rSide = rSide;
    }

    public SymbolVar getVariable(){
        return variable;
    }

    public SymbolOperation getRightSide(){
        return rSide;
    }
}