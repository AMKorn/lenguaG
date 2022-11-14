/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/**
 * FOR ::= RES_FOR ( HEADER_SEGMENT:initialization ; OPERATION:condition ; HEADER_SEGMENT:finalStatement ) { INSTRUCTIONS:instructions }
 */
public class SymbolFor extends SymbolInstr {
    private SymbolBase initialization;
    private SymbolOperation condition;
    private SymbolBase finalStatement;
    private SymbolInstrs instructions;

    public SymbolFor(SymbolBase initialization, SymbolOperation condition, SymbolBase finalStatement,
            SymbolInstrs instructions) {
        super("For", 0, instructionType.instFor);
        this.initialization = initialization;
        this.condition = condition;
        this.finalStatement = finalStatement;
        this.instructions = instructions;
    }

    /**
     * 
     * @return an instance of either SymbolDec, SymbolAssign, SymbolSwap or SymbolFuncCall
     */
    public SymbolBase getInit(){
        return initialization;
    }

    public SymbolOperation getCondition(){
        return condition;
    }

    /**
     * 
     * @return an instance of either SymbolDec, SymbolAssign, SymbolSwap or SymbolFuncCall
     */
    public SymbolBase getFinal(){
        return finalStatement;
    }

    public SymbolInstrs getInstructions(){
        return instructions;
    }
}
