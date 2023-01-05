package lenguag.syntactic.symbols;

import lenguag.Constants;

/*
TYPE ::= TYPE_INTEGER
       | TYPE_CHARACTER
       | TYPE_BOOLEAN
       | TYPE_VOID
       | TYPE:v L_BRACKET R_BRACKET
       ;
 */
public class SymbolType extends SymbolBase {

    private int type; // Possible values are from Constants/ParserSym
    private SymbolType baseType;
    private int arrayDepth;

    // Variables for semantic control
    public int arrayLength = Constants.UNKNOWN; // The length of the current level of the array.

    public SymbolType(int type, SymbolType baseType){
        super("Type", 0);
        this.type = type;
        this.baseType = baseType;
        if(type != Constants.TYPE_ARRAY) throw new RuntimeException(" !! Compiler error");
        arrayDepth = baseType.arrayDepth + 1;
    }

    public SymbolType(int type){
        super("Type", 0);
        this.type = type;
        arrayDepth = 0;
    }
    
    public SymbolType(){
        super("Type", 0);
        type = Constants.TYPE_VOID;
        baseType = null;
        arrayDepth = 0;
    }

    public boolean isType(int type){
        return this.type == type;
    }

    public int getArrayDepth(){
        return arrayDepth;
    }

    public int getType(){
        return type;
    }

    public void setBaseType(SymbolType baseType){
        if(type != Constants.TYPE_ARRAY) throw new RuntimeException(" !! Compiler error");
        this.baseType = baseType;
        arrayDepth = baseType.arrayDepth + 1;
    }
    
    public SymbolType getBaseType(){
        return baseType;
    }

    @Override
    public String toString(){
        if(type == Constants.TYPE_ARRAY) return baseType + "[" + (arrayLength!=Constants.UNKNOWN ? arrayLength : "") + "]";
        return Constants.getTypeName(type);
    }

    public boolean equals(SymbolType other){
        if(this.type != other.type) return false;
        if(this.arrayDepth != other.arrayDepth) return false;
        // if(this.arrayLength != other.arrayLength) return false;
        if(this.arrayLength != Constants.UNKNOWN && other.arrayLength != Constants.UNKNOWN && this.arrayLength != other.arrayLength) return false;
        if(arrayDepth > 1) return this.baseType.equals(other.baseType);
        return true;
    }
}
