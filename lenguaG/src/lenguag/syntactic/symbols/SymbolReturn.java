package lenguag.syntactic.symbols;

/*
RETURN ::= RES_RETURN OPERATION:value
         | RES_RETURN
 */
public class SymbolReturn extends SymbolInstr {
    
    private SymbolOperation value;

    public SymbolReturn(SymbolOperation value, int line, int column) {
        super("Return", 0, instructionType.instReturn, line, column);
        this.value = value;
    }

    public SymbolReturn(int line, int column) {
        super("Return", 0, instructionType.instReturn, line, column);
    }

    public SymbolOperation getValue(){
        return value;
    }
}
