/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/*
 * VALUE ::= VARIABLE:v                                                    {: RESULT = new SymbolValue(v); :}
        | FIXED_VALUE:v                                                 {: RESULT = new SymbolValue(v); :}
        | FUNCTION_CALL:v                                               {: RESULT = new SymbolValue(v); :}
        ;
 */
public class SymbolValue extends SymbolBase {
    private SymbolVar variable;
    private Object fixed_value;
    private SymbolFuncCall function_call;

    public SymbolValue(SymbolVar variable){
        super("value", 0);
        this.variable = variable;
    }

    public SymbolValue(Object fixed_value){
        super("value", 0);
        this.fixed_value = fixed_value;
    }

    public SymbolValue(SymbolFuncCall function_call){
        super("value", 0);
        this.function_call = function_call;
    }
}
