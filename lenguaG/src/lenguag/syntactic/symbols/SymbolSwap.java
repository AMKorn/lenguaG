/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/*
 * SWAP ::= VARIABLE:v1 OP_SWAP VARIABLE:v2                                {: RESULT = new SymbolSwap(v1, v2); :}
       ;
 */
public class SymbolSwap extends Symbolbase {
    private SymbolVar variable1;
    private SymbolVar variable2;

    public SymbolSwap(SymbolVar variable1, SymbolVar variable2) {
        super("Swap", 0);
        this.variable1 = variable1;
        this.variable2 = variable2;
    }
}
