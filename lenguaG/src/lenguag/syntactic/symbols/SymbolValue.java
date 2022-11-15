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

    public SymbolValue(Object value){
        super("Value", 0);
        this.value = value;
        isLiteral = !(value instanceof SymbolBase);
    }

    // public SymbolValue(SymbolVar variable){
    //     super("value", 0);
    //     this.value = variable;
    //     isLiteral = false;
    // }

    // public SymbolValue(Object fixedValue){
    //     super("value", fixedValue);
    //     this.value = fixedValue;
    //     isLiteral = true;
    // }

    // public SymbolValue(SymbolFuncCall functionCall){
    //     super("value", 0);
    //     this.value = functionCall;
    //     isLiteral = false;
    // }

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
