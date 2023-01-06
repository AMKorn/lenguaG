package lenguag.syntactic.symbols;

/*
 * LOOP ::= RES_WHILE L_PAREN OPERATION:condition R_PAREN L_KEY INSTRUCTIONS:instructions R_KEY 
 */
public class SymbolLoop extends SymbolInstr {
    private SymbolOperation condition;
    private SymbolInstrs instructions;
    
    public SymbolLoop(SymbolOperation condition, SymbolInstrs instructions, int line, int column) {
        super("Loop", 0, instructionType.instLoop, line, column);
        this.condition = condition;
        this.instructions = instructions;
    }

    public SymbolOperation getCondition() {
        return condition;
    }

    public SymbolInstrs getInstructions() {
        return instructions;
    }
}
