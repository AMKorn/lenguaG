/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/*
 * FOR ::= RES_FOR L_PAREN HEADER_SEGMENT:v1 ENDLINE CONDITION:v2 ENDLINE HEADER_SEGMENT:v3 R_PAREN L_KEY INSTRUCTIONS:v4 R_KEY
                                                                        {: RESULT = new SymbolFor(v1, v2, v3, v4); :}
      ;
 */
public class SymbolFor extends SymbolBase {
    private SymbolHeaderSeg header_segment1;
    private SymbolHeaderSeg header_segment2;
    private SymbolCond condition;
    private SymbolInstrs instructions;

    public SymbolFor(SymbolHeaderSeg header_segment1, SymbolCond condition, SymbolHeaderSeg header_segment2,
            SymbolInstrs instructions) {
        super("For", 0);
        this.header_segment1 = header_segment1;
        this.condition = condition;
        this.header_segment2 = header_segment2;
        this.instructions = instructions;
    }
}
