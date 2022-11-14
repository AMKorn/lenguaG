/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/*
 * PARAMS ::= VALUE:value MORE_PARAMS:contParams
         |

MORE_PARAMS ::= COMMA VALUE:value MORE_PARAMS:contParams
              |
 */
public class SymbolParams extends SymbolBase {
    
    private SymbolValue value;
    private SymbolParams contParams;
    private int nParams;

    public SymbolParams(SymbolValue value, SymbolParams contParams) {
        super("Params", 0);
        this.value = value;
        this.contParams = contParams;
        nParams = contParams.getNParams()+1;
    }

    public SymbolParams(){
        super("Params", 0);
        nParams = 0;
    }

    public SymbolValue getValue(){
        return value;
    }

    public SymbolParams getNext(){
        return contParams;
    }

    public int getNParams(){
        return nParams;
    }
}
