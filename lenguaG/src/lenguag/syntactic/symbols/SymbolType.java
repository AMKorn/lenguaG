/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */

package lenguag.syntactic.symbols;

/*
 * TYPE ::= TYPE_INTEGER ARRAY_SUFFIX:v                                    {: RESULT = new SymbolType(ParserSym.TYPE_INTEGER, v); :}
    | TYPE_FLOAT ARRAY_SUFFIX:v                                         {: RESULT = new SymbolType(ParserSym.TYPE_FLOAT, v); :}
    | TYPE_CHARACTER ARRAY_SUFFIX:v                                     {: RESULT = new SymbolType(ParserSym.TYPE_CHARACTER, v); :}
    | TYPE_BOOLEAN ARRAY_SUFFIX:v                                       {: RESULT = new SymbolType(ParserSym.TYPE_BOOLEAN, v); :}
    | TYPE_VOID  
 */
public class SymbolType extends SymbolBase {
    
    public SymbolType() {
        super("Type", 0);
    }
}
