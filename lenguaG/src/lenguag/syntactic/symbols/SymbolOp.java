/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/*
 * OP ::= ADD                                                              {: RESULT = new SymbolOp(ParserSym.ADD); :}
     | SUB                                                              {: RESULT = new SymbolOp(ParserSym.SUB); :}
     | PROD                                                             {: RESULT = new SymbolOp(ParserSym.PROD); :}
     | DIV                                                              {: RESULT = new SymbolOp(ParserSym.DIV); :}
     | MOD                                                              {: RESULT = new SymbolOp(ParserSym.MOD); :}
     | OR                                                               {: RESULT = new SymbolOp(ParserSym.OR); :}
     | AND                                                              {: RESULT = new SymbolOp(ParserSym.AND); :}
     | OP_REL:v                                                         {: RESULT = new SymbolOp(v); :}
     ;
 */
public class SymbolOp extends Symbolbase {
    public SymbolOp() {
        super("Op", 0);
    }
}
