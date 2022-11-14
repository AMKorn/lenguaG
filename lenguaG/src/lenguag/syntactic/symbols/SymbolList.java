/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/*
 * LIST ::= L_BRACKET OPERATION:value CONT_LIST:contList
 * 
 * 
CONT_LIST ::= COMMA VALUE:value CONT_LIST:contList
            | R_BRACKET
 */
public class SymbolList extends SymbolBase {
    private SymbolOperation value;
    private int length;
    private SymbolList contList;

    public SymbolList(SymbolOperation value, SymbolList contList) {
        super("List", 0);
        this.value = value;
        this.contList = contList;
        length = contList.getLength()+1;
    }

    public SymbolList(){
        super("List", 0);
        length = 0;
    }

    public SymbolOperation getValue(){
        return value;
    }

    public int getLength(){
        return length;
    }

    public SymbolList getNext(){
        return contList;
    }
}
