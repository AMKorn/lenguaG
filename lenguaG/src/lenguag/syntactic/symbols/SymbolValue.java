/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/*
 * VALUE ::= VARIABLE:v
        | FIXED_VALUE:fixedValue
        | FUNCTION_CALL:functionCall
 */
public class SymbolValue extends SymbolBase {
    
    public boolean isConstant;
    //public Object value;

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

    /* public boolean isLiteral(){
        return isLiteral;
    }
 */
    /**
     * @return SymbolVar, SymbolFuncCall, SymbolList or any of the wrapped primitives that we have implemented.
     */
    // public Object getValue(){
    //     return value;
    // }
}
