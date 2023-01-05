package lenguag.syntactic.symbols;

/*
 * INSTRUCTIONS ::= INSTRUCTION:instruction INSTRUCTIONS:contInstruction
    |
 */
public class SymbolInstrs extends SymbolBase{
    private SymbolInstr instruction;
    private SymbolInstrs contInstruction;

    public SymbolInstrs(SymbolInstr v1, SymbolInstrs contInstruction, int line, int column) {
        super("Instructions", 0, line, column);
        this.instruction = v1;
        this.contInstruction = contInstruction;
    }

    public SymbolInstrs() {
        super("Instructions", 0);
    }

    public SymbolInstr getInstruction(){
        return instruction;
    }

    public SymbolInstrs getNext(){
        return contInstruction;
    }
}