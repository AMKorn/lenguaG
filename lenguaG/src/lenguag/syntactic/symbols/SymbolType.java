/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */

package lenguag.syntactic.symbols;

import lenguag.syntactic.ParserSym;

/*
 * TYPE ::= TYPE_INTEGER ARRAY_SUFFIX:v                                    {: RESULT = new SymbolType(ParserSym.TYPE_INTEGER, v); :}
    | TYPE_FLOAT ARRAY_SUFFIX:v                                         {: RESULT = new SymbolType(ParserSym.TYPE_FLOAT, v); :}
    | TYPE_CHARACTER ARRAY_SUFFIX:v                                     {: RESULT = new SymbolType(ParserSym.TYPE_CHARACTER, v); :}
    | TYPE_BOOLEAN ARRAY_SUFFIX:v                                       {: RESULT = new SymbolType(ParserSym.TYPE_BOOLEAN, v); :}
    | TYPE_VOID  
 */
public class SymbolType extends SymbolBase {

    private int type; // Possible values are from ParserSym
    private SymbolArrSuff arraySuffix;
    
    public SymbolType(int type, SymbolArrSuff arraySuffix){
        super("Type", 0);
        this.type = type;
        // TODO check whether the arraySuffix is empty or not
        this.arraySuffix = arraySuffix;
    }

    public SymbolType() {
        super("Type", 0);
        type = ParserSym.TYPE_VOID;
    }

    public int getType(){
        // TODO return type_array if it's an array
        return type;
    }

    public SymbolArrSuff getArraySuff(){
        // TODO return empty if empty
        return arraySuffix;
    }
}
