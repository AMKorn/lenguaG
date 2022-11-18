/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/*
 * IF ::= RES_IF L_PAREN OPERATION:condition R_PAREN L_KEY INSTRUCTIONS:instructions R_KEY ELSE:sElse 
 */
public class SymbolIf extends SymbolInstr {
    private SymbolOperation condition;
    private SymbolInstrs instructions;
    private SymbolElse sElse;

    public SymbolIf(SymbolOperation condition, SymbolInstrs instructions, SymbolElse sElse, int line, int column) {
        super("Condition", 0, instructionType.instIf, line, column);
        this.condition = condition;
        this.instructions = instructions;
        this.sElse = sElse;
    }
    
    public SymbolOperation getCondition(){
        return condition;
    }

    public SymbolInstrs getInstructions(){
        return instructions;
    }

    public SymbolElse getElse(){
        return sElse;
    }
}
