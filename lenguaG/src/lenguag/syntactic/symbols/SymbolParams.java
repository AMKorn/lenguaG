/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/*
 * PARAMS ::= VALUE:v1 MORE_PARAMS:v2                                      {: RESULT = new SymbolParams(v1, v2); :}
         |                                                              {: RESULT = new SymbolParams(); :}
         ;

    MORE_PARAMS ::= COMMA VALUE:v1 MORE_PARAMS:v2                           {: RESULT = new SymbolParams(v1, v2); :}
              |                                                         {: RESULT = new SymbolParams(); :}
              ;
 */
public class SymbolParams extends SymbolBase {
    private SymbolValue value;
    private SymbolParams more_params;

    public SymbolParams(SymbolValue value, SymbolParams more_params) {
        super("Params", 0);
        this.value = value;
        this.more_params = more_params;
    }
    
    public int getNParams(){
        return 1; // TODO
    }
}
