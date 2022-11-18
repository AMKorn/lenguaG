/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

import lenguag.syntactic.ParserSym;

/*
 * OPERAND ::= VALUE:value                                                     {: RESULT = new SymbolOperand(v); :}
          | L_PAREN OPERATION:v R_PAREN                                 {: RESULT = new SymbolOperand(v); :}
          | NOT OPERAND:v                                               {: v.negate(); RESULT = v; :}
          | SUB OPERAND:v                                               {: v.negate(); RESULT = v; :}
          ;
 */
public class SymbolOperand extends SymbolBase {

    private SymbolBase value;
    private boolean isNegated; // this boolean is used both for boolean values and for integers

    // Variables for semantic control
    public int type = ParserSym.TYPE_VOID;  // Set as void until known
    public boolean isConstant = true;       // Set as true by default so that as soon as we find a variable component we will know that this is not constant.
    
    public SymbolOperand(SymbolValue value, int line, int column){
        super("Operand", 0, line, column);
        this.value = value;
        isNegated = false;
    }

    public SymbolOperand(SymbolOperation operation, int line, int column){
        super("Operand", 0, line, column);
        this.value = operation;
        isNegated = false;
    }

    /**
     * @returns whether the given operand is a leaf of the tree formed by the operations. 
     */
    public boolean isLeaf(){
        return !(value instanceof SymbolOperation);
    }

    /**
     * Reverses the negation status of the operand.
     */
    public void negate(){
        isNegated = !isNegated;
    }

    public SymbolBase getValue(){
        return value;
    }

    public boolean isNegated(){
        return isNegated;
    }
}
