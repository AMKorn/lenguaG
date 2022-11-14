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

    public SymbolOperation(SymbolOperand lValue, SymbolOp operation, SymbolOperand rValue){
        super("Operation", 0);
        this.lValue = lValue;
        this.operation = operation;
        this.rValue = rValue;
    }
    
    public SymbolOperation(SymbolOperand lValue){
        super("Operation", 0);
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
