/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/*
 * SWAP ::= VARIABLE:variable1 OP_SWAP VARIABLE:variable2
 */
public class SymbolSwap extends SymbolInstr {
    private SymbolVar variable1;
    private SymbolVar variable2;

    public SymbolSwap(SymbolVar variable1, SymbolVar variable2, int line, int column) {
        super("Swap", 0, instructionType.instSwap, line, column);
        this.variable1 = variable1;
        this.variable2 = variable2;
    }

    public SymbolVar getVar1(){
        return variable1;
    }

    public SymbolVar getVar2(){
        return variable2;
    }
}
