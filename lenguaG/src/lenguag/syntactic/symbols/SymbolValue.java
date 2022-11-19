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
    
    private boolean isLiteral;
    private Object value;

    // Variables for semantic control
    public SymbolType type; 

    public SymbolValue(Object value, int line, int column){
        super("Value", 0, line, column);
        this.value = value;
        isLiteral = !(value instanceof SymbolBase);
    }

    public boolean isLiteral(){
        return isLiteral;
    }

    /**
     * @return SymbolVar, SymbolFuncCall or any of the wrapped primitives that we have implemented.
     */
    public Object getValue(){
        return value;
    }
}
