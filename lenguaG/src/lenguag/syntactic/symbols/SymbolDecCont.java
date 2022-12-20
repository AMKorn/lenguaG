package lenguag.syntactic.symbols;

/**
 * This is a support class of sort, used mostly by SymbolDec
 * 
 * CONT_DECLARATION ::= TYPE:v1 IDENTIFIER:v2 EQUAL OPERATION:v3
 *                    | TYPE:v1 IDENTIFIER:v2
 */
public class SymbolDecCont extends SymbolBase {

    private SymbolType type;
    private String variable;
    private SymbolOperation value;

    public SymbolDecCont(SymbolType v1, String v2, SymbolOperation v3) {
        super("Cont_Declaration", v3.value);
        this.type = v1;
        this.variable = v2;
        this.value = v3;
    }

    public SymbolDecCont(SymbolType v1, String v2) {
        super("Cont_Declaration", 0);
        this.type = v1;
        this.variable = v2;
    }

    public SymbolType getType(){
        return type;
    }

    public String getVar(){
        return variable;
    }

    public SymbolOperation getValue(){
        return value;
    }    
}
