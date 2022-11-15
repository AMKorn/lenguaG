/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/*
 * PARAMS ::= OPERATION:operation MORE_PARAMS:contParams
         |

MORE_PARAMS ::= COMMA OPERATION:operation MORE_PARAMS:contParams
              |
 */
public class SymbolParams extends SymbolBase {
    
    private SymbolOperation operation;
    private SymbolParams contParams;
    private int nParams;

    public SymbolParams(SymbolOperation operation, SymbolParams contParams) {
        super("Params", 0);
        this.operation = operation;
        this.contParams = contParams;
        if(contParams == null) nParams = 1;
        else nParams = contParams.getNParams()+1;
    }

    public SymbolParams(){
        super("Params", 0);
        nParams = 0;
    }

    public SymbolOperation getValue(){
        return operation;
    }

    public SymbolParams getNext(){
        return contParams;
    }

    public int getNParams(){
        return nParams;
    }
}
