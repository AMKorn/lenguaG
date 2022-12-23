package lenguag.syntactic.symbols;

/*
 * OPERAND ::= VALUE:value                                                     {: RESULT = new SymbolOperand(v); :}
          | L_PAREN OPERATION:v R_PAREN                                 {: RESULT = new SymbolOperand(v); :}
          | NOT OPERAND:v                                               {: v.negate(); RESULT = v; :}
          | SUB OPERAND:v                                               {: v.negate(); RESULT = v; :}
          ;
 */
public class SymbolOperand extends SymbolBase {

    //private SymbolBase value;
    private boolean isNegated; // this boolean is used both for boolean values and for integers

    // Variables for semantic control
    public SymbolType type = new SymbolType();
    public boolean isConstant = true;       // Set as true by default so that as soon as we find a variable component we will know that this is not constant.
    //public Object semanticValue;            // To set as a primitive object during semantic control if it's a constant
    
    public SymbolOperand(SymbolValue value, int line, int column){
        super("Operand", value, line, column);
        //this.value = value;
        isNegated = false;
    }

    public SymbolOperand(SymbolOperation operation, int line, int column){
        super("Operand", operation, line, column);
        //this.value = operation;
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

    public Object getValue(){
        return value;
    }

    public boolean isNegated(){
        return isNegated;
    }

    public Object getSemanticValue(){
        return value;
    }

    public void setSemanticValue(Object value){
        this.value = value;
    }
}
