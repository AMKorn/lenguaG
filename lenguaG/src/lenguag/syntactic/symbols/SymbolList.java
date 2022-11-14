/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/*
 * LIST ::= L_BRACKET VALUE:v1 CONT_LIST:v2                                {: RESULT = new SymbolList(v1, v2); :}
       ;
 */
public class SymbolList extends SymbolBase {
    private SymbolValue value;
    private SymbolList cont_list;

    public SymbolList(SymbolValue value, SymbolList cont_list) {
        super("List", 0);
        this.value = value;
        this.cont_list = cont_list;
    }
}
