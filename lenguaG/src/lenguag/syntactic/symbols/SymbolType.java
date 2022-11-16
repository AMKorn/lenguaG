/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */

package lenguag.syntactic.symbols;

/*
TYPE ::= TYPE_INTEGER
       | TYPE_CHARACTER
       | TYPE_BOOLEAN
       | TYPE_VOID
       | TYPE:v L_BRACKET R_BRACKET
       ;
 */
public class SymbolType extends SymbolBase {

    private int type; // Possible values are from ParserSym
    private int baseType;
    private int arrayDimensions;
    
    public SymbolType(int type, SymbolType baseType){
        super("Type", 0);
        this.type = type;
        this.baseType = baseType.getBaseType();
        arrayDimensions = baseType.getArrayDimensions()+1;
    }

    public SymbolType(int type){
        super("Type", 0);
        this.type = type;
        this.baseType = type;
        arrayDimensions = 0;
    }

    public int getArrayDimensions(){
        return arrayDimensions;
    }

    public int getType(){
        return type;
    }

    public int getBaseType(){
        return baseType;
    }
}
