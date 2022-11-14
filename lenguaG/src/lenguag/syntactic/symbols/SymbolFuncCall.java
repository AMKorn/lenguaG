/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/*
 * FUNCTION_CALL ::= VARIABLE:v1 L_PAREN PARAMS:v2 R_PAREN                 {: RESULT = new SymbolFuncCall(v1, v2); :}
                ;
 */
public class SymbolFuncCall extends SymbolBase {
    private SymbolVar variable;
    private SymbolParams params;

    public SymbolFuncCall(SymbolVar variable, SymbolParams params) {
        super("Function call", 0);
        this.variable = variable;
        this.params = params;
    }
    
}
