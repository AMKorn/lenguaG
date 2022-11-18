package lenguag.semantic;

import java.util.HashMap;

import lenguag.*;
import lenguag.LenguaGException.CompilerException;
import lenguag.syntactic.symbols.*;

/**
 * Class that represents a variable's description in the symbol table
 */
public class SymbolDescription {

    // The variable's type
    private int type;
    private Object value;

    public int declaredLevel;
    public boolean isConstant;

    // Array information
    private int baseType;
    private int dimensions;

    // Function information
    private int nArgs;
    private int returnType;
    private HashMap<String, Integer> args; // arguments are name and type

    /**
     * Creates an empty description
     */
    public SymbolDescription(){
        type = Constants.TYPE_VOID;
        isConstant = false;
    }

    /**
     * Changes the type of the variable to which this description is associated. 
     * @param type
     */
    public void changeType(SymbolType type) {
        this.type = type.getType();
        switch(this.type){
            case Constants.TYPE_INTEGER:
                break;
            case Constants.TYPE_CHARACTER:
                break;
            case Constants.TYPE_BOOLEAN:
                break;
            case Constants.TYPE_ARRAY:
                baseType = type.getBaseType();
                dimensions = type.getArrayDimensions();
            case Constants.TYPE_FUNCTION:
                nArgs = 0;
                returnType = Constants.TYPE_VOID;
                args = new HashMap<>();
        }
    }

    public void changeValue(Object value){
        this.value = value;
    }

    public int getType(){
        return type;
    }

    // Array methods
    public void changeBaseType(int baseType) throws CompilerException {
        if(type != Constants.TYPE_ARRAY) throw new CompilerException(" !! Compiler error !! Can't change baseType of a non-array variable.");
        this.baseType = baseType;
    }

    public int getBaseType() throws CompilerException {
        if(type != Constants.TYPE_ARRAY) throw new CompilerException(" !! Compiler error !! Can't get baseType of a non-array variable.");
        return baseType;
    }

    public void changeDimensions(int dimensions) throws CompilerException {
        if(type != Constants.TYPE_ARRAY) throw new CompilerException(" !! Compiler error !! Can't change dimensions of a non-array variable.");
        this.dimensions = dimensions;
    }

    public int getDimensions() throws CompilerException {
        if(type != Constants.TYPE_ARRAY) throw new CompilerException(" !! Compiler error !! Can't get dimensions of a non-array variable.");
        return dimensions;
    }

    // Function methods
    public void addArgument(String name, int type) throws CompilerException {
        if(type != Constants.TYPE_FUNCTION) throw new CompilerException(" !! Compiler error !! Can't add arguments to a non-function");
        args.put(name, type);
        nArgs++;
    }

    @Override
    public String toString(){
        String sd = "[Type: " + Constants.getType(type);
        if(type == Constants.TYPE_ARRAY) sd += " (Basetype: " + Constants.getType(baseType) + ", Dimensions: " + dimensions + ") ";
        sd += ", Constant: " + isConstant;
        if(isConstant) sd += ", Value: " + value;
        sd += ", Declared level: " + declaredLevel + "]";
        return sd;
    }
}
