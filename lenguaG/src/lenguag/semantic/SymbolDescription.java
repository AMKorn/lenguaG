package lenguag.semantic;

import lenguag.*;
import lenguag.syntactic.ParserSym;
import lenguag.syntactic.symbols.*;

/**
 * Class that represents a variable's description in the symbol table
 */
public class SymbolDescription {

    // The variable's type
    private int type;
    private int nBytes;
    private Object value;

    public int declaredLevel;
    public boolean isConstant;

    // Array information
    private int baseType;
    private int dimensions;

    /**
     * Creates an empty description
     */
    public SymbolDescription(){
        type = ParserSym.TYPE_VOID;
        nBytes = 0;
        isConstant = false;
    }

    /**
     * Changes the type of the variable to which this description is associated. 
     * @param type
     */
    public void changeType(SymbolType type) {
        this.type = type.getType();
        switch(this.type){
            case ParserSym.TYPE_INTEGER:
                nBytes = Constants.INTEGER_BYTES;
                break;
            case ParserSym.TYPE_CHARACTER:
                nBytes = Constants.CHAR_BYTES;
                break;
            case ParserSym.TYPE_BOOLEAN:
                nBytes = Constants.BOOL_BYTES;
                break;
            case ParserSym.TYPE_ARRAY:
                baseType = type.getBaseType();
                dimensions = type.getArrayDimensions();
        }
    }

    public void changeValue(Object value){
        this.value = value;
    }

    public int getType(){
        return type;
    }

    public int getSize(){
        return nBytes;
    }

    @Override
    public String toString(){
        String sd = "[Type: " + type;
        if(type == ParserSym.TYPE_ARRAY) sd += " (Basetype: " + baseType + ", Dimensions: " + dimensions + ") ";
        sd += ", Constant: " + isConstant;
        if(isConstant) sd += ", Value: " + value;
        sd += ", Declared level: " + declaredLevel + "]";
        return sd;
    }
}
