package lenguag.syntactic.symbols;

/*
 * IN ::= RES_IN L_PAREN VARIABLE:variable R_PAREN
     ;
 */
public class SymbolIn extends SymbolInstr {
    private SymbolVar variable;

    public SymbolIn(SymbolVar variable, int line, int column) {
        super("In", 0, instructionType.instIn, line, column);
        this.variable = variable;
    }
    
    public SymbolVar getVar(){
        return variable;
    }
}
