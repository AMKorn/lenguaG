/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/*
 * OPERAND ::= VALUE:value                                                     {: RESULT = new SymbolOperand(v); :}
          | L_PAREN OPERATION:v R_PAREN                                 {: RESULT = new SymbolOperand(v); :}
          | NOT OPERAND:v                                               {: v.negate(); RESULT = v; :}
          | SUB OPERAND:v                                               {: v.negate(); RESULT = v; :}
          ;
 */
public class SymbolOperand extends SymbolBase {

    // private SymbolValue value;
    // private SymbolOperation operation;

    private SymbolBase value;
    private boolean isNegated; // this boolean is used both for boolean values and for integers
    
    public SymbolOperand(SymbolValue value){
        super("Operand", 0);
        this.value = value;
        isNegated = false;
    }

    public SymbolOperand(SymbolOperation operation){
        super("Operand", 0);
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
