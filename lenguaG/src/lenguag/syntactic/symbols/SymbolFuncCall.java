/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/*
 * FUNCTION_CALL ::= VARIABLE:functionName L_PAREN PARAMS:params R_PAREN
                ;
 */
public class SymbolFuncCall extends SymbolInstr {
    private SymbolVar functionName;
    private SymbolParams params;

    // Variables for semantic control
    public SymbolType type = new SymbolType();

    public SymbolFuncCall(SymbolVar functionName, SymbolParams params, int line, int column) {
        super("Function call", 0, instructionType.instFunctionCall, line, column);
        this.functionName = functionName;
        this.params = params;
    }
    
    public SymbolVar getFunctionName(){
        return functionName;
    }

    public int getNParams(){
        return params.getNParams();
    }

    public SymbolParams getParams(){
        return params;
    }
}
