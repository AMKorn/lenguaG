package lenguag.syntactic.symbols;

/*
 * VALUE ::= VARIABLE:v
        | FIXED_VALUE:fixedValue
        | FUNCTION_CALL:functionCall
 */
public class SymbolValue extends SymbolBase {
    
    public boolean isConstant;

    // Variables for semantic control
    public SymbolType type = new SymbolType();

    public SymbolValue(Object value, int line, int column){
        super("Value", value, line, column);
        //this.value = value;
        isConstant = !(value instanceof SymbolBase);
    }

    public Object getSemanticValue(){
        return value;
    }

    public void setSemanticValue(Object value){
        this.value = value;
    }
}
