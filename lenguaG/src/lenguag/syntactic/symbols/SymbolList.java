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
