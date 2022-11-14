/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/*
 * OP_REL ::= IS_EQUAL                                                     {: RESULT = new SymbolOpRel(ParserSym.IS_EQUAL); :}
         | BIGGER                                                       {: RESULT = new SymbolOpRel(ParserSym.IS_EQUAL); :}
         | BEQ                                                          {: RESULT = new SymbolOpRel(ParserSym.BEQ); :}
         | LESSER                                                       {: RESULT = new SymbolOpRel(ParserSym.LESSER); :}
         | LEQ                                                          {: RESULT = new SymbolOpRel(ParserSym.LEQ); :}
         | NEQ                                                          {: RESULT = new SymbolOpRel(ParserSym.NEQ); :}
         ;
 */
public class SymbolOpRel extends SymbolBase {
    public SymbolOpRel() {
        super("OpRel", 0);
    }
    
}
