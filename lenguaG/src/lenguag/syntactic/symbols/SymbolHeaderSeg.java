/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/*
 * HEADER_SEGMENT ::= DECLARATION:v                                        {: RESULT = new SymbolHeaderSeg(v); :}
                 | ASSIGNATION:v                                        {: RESULT = new SymbolHeaderSeg(v); :}
                 | SWAP:v                                               {: RESULT = new SymbolHeaderSeg(v); :}
                 | FUNCTION_CALL:v                                      {: RESULT = new SymbolHeaderSeg(v); :}
                 ; 
 */
public class SymbolHeaderSeg extends SymbolBase {
    private SymbolDec declaration;
    private SymbolAssign assignation;
    private SymbolSwap swap;
    private SymbolFuncCall function_call;

    public SymbolHeaderSeg(SymbolDec declaration) {
        super("Header Segment", 0);
        this.declaration = declaration;
    }

    public SymbolHeaderSeg(SymbolAssign assignation) {
        super("Header Segment", 0);
        this.assignation = assignation;
    }

    public SymbolHeaderSeg(SymbolSwap swap) {
        super("Header Segment", 0);
        this.swap = swap;
    }

    public SymbolHeaderSeg(SymbolFuncCall function_call) {
        super("Header Segment", 0);
        this.function_call = function_call;
    }
}
