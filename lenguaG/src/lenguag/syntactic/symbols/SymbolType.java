/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */

package lenguag.syntactic.symbols;

/*
TYPE ::= TYPE_INTEGER                                                   {: RESULT = new SymbolType(ParserSym.TYPE_INTEGER); :}
       | TYPE_CHARACTER                                                 {: RESULT = new SymbolType(ParserSym.TYPE_CHARACTER); :}
       | TYPE_BOOLEAN                                                   {: RESULT = new SymbolType(ParserSym.TYPE_BOOLEAN); :}
       | TYPE_VOID                                                      {: RESULT = new SymbolType(ParserSym.TYPE_VOID); :}
       | TYPE:v L_BRACKET R_BRACKET                                     {: RESULT = new SymbolType(ParserSym.TYPE_ARRAY, v) :}
       ;
 */
public class SymbolType extends SymbolBase {

    private int type; // Possible values are from ParserSym
    private int baseType;
    
    public SymbolType(int type, SymbolType baseType){
        super("Type", 0);
        this.type = type;
        this.baseType = baseType.getType();
    }

    public SymbolType(int type){
        super("Type", 0);
        this.type = type;
        this.baseType = type;
    }

    public int getType(){
        return type;
    }

    public int getBaseType(){
        return baseType;
    }
}
