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
    private SymbolList contList;
    private int length;

    // Variables for semantic control
    public SymbolType type = new SymbolType();

    public SymbolList(SymbolOperation value, SymbolList contList, int line, int column) {
        super("List", 0, line, column);
        this.value = value;
        this.contList = contList;
        length = contList.length+1;
    }

    public SymbolList(String s, int line, int column){
        super("String", 0);
        Character c;
        if(s.length() == 0){
            length = 0;
            c = 0;
        } else c = s.charAt(0);
        SymbolValue val = new SymbolValue(c, line, column);
        SymbolOperand operand = new SymbolOperand(val, line, column);
        this.value = new SymbolOperation(operand, line, column);
        if(s.length()>1){
            String unprocessedString = s.substring(1);
            this.contList = new SymbolList(unprocessedString, line, column);
            length = contList.length+1;
        } else {
            length = 1;
        }
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

    @Override
    public String toString(){
        String s = "";
        SymbolList l = this;
        while(l!=null){
            SymbolOperation lo = l.getValue();
            SymbolOperand loo = lo.getLValue();
            SymbolValue loov = (SymbolValue) loo.getValue();
            Character loovc = (Character) loov.value;
            s += loovc;
            l = l.getNext();
        }
        return s;
    }
}
