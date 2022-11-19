/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/* 
OPERATION ::= OPERAND:lValue OP:operation OPERAND:rValue
            | OPERAND:lValue
*/
public class SymbolOperation extends SymbolBase {

    private SymbolOperand lValue;
    private SymbolOp operation;
    private SymbolOperand rValue;

    // Variables for semantic control
    public SymbolType type;                 // Not set until known
    public boolean isConstant = true;       // Set as true by default so that as soon as we find a variable component we will know that this is not constant.
    public Object semanticValue;            // To set as a primitive object during semantic control if it's a constant

    public SymbolOperation(SymbolOperand lValue, SymbolOp operation, SymbolOperand rValue, int line, int column){
        super("Operation", 0, line, column);
        this.lValue = lValue;
        this.operation = operation;
        this.rValue = rValue;
    }
    
    public SymbolOperation(SymbolOperand lValue, int line, int column){
        super("Operation", 0, line, column);
        this.lValue = lValue;
    }

    public SymbolOperand getLValue(){
        return lValue;
    }

    public SymbolOp getOperation(){
        return operation;
    }

    public SymbolOperand getRValue(){
        return rValue;
    }
}
