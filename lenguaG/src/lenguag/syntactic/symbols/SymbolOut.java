package lenguag.syntactic.symbols;

/*
 * OUT ::= RES_OUT L_PAREN OPERATION:value R_PAREN
      ;
 */
public class SymbolOut extends SymbolInstr {
    private SymbolOperation value;

    public SymbolOut(SymbolOperation value, int line, int column) {
        super("Out", 0, instructionType.instOut, line, column);
        this.value = value;
    }

    public SymbolOperation getValue(){
        return value;
    }
}
