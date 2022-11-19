package lenguag.semantic;

import java.util.HashMap;

import lenguag.*;
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
    private SymbolType returnType;
    private HashMap<String, SymbolType> args; // arguments are name and type

    /**
     * Creates an empty description
     */
    public SymbolDescription(){
        type = Constants.TYPE_VOID;
        isConstant = false;
    }

    /**
     * Changes the type of the variable to which this description is associated, given a symbol created by Parser.java.
     * @param type
     */
    public void changeType(SymbolType type) {
        this.type = type.getType();
        if(this.type == Constants.TYPE_ARRAY){
            baseType = type.getBaseType();
            dimensions = type.getArrayDimensions();
        }
    }

    /**
     * Changes the type of the variable to which this description is associated, given the value of Constants.
     * If given TYPE_ARRAY, baseType and dimensions will be set to void and 0, respectively, so those should be set afterwards
     * using changeBaseType() and changeDimensions().
     * Likewise, nArgs, returnType and args will be set to 0, void and an empty HashMap, respectively. 
     * Use addArgument() and setReturnType() to change them.
     * @param type
     */
    public void changeType(int type) {
        this.type = type;
        if(this.type == Constants.TYPE_ARRAY){
            baseType = Constants.TYPE_VOID;
            dimensions = 0;
        } else if(this.type == Constants.TYPE_FUNCTION){
            nArgs = 0;
            returnType = new SymbolType(Constants.TYPE_VOID);
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
    public void changeBaseType(int baseType) {
        this.baseType = baseType;
    }

    public int getBaseType() {
        return baseType;
    }

    public void changeDimensions(int dimensions) {
        this.dimensions = dimensions;
    }

    public int getDimensions()  {
        return dimensions;
    }

    // Function methods

    /**
     * Adds the param of the given type to the parameters of the function, incrementing nArgs
     * @param name
     * @param type
     */
    public void addArgument(String name, SymbolType type) {
        args.put(name, type);
        nArgs++;
    }

    public void setReturnType(SymbolType returnType) {
        this.returnType = returnType;
    }

    public int getNArgs() {
        return nArgs;
    }

    public HashMap<String, SymbolType> getArgs() {
        return args;
    }

    public SymbolType getReturnType() {
        return returnType;
    }

    @Override
    public String toString(){
        String sd = "[Type: " + Constants.getTypeName(type);
        if(type == Constants.TYPE_ARRAY) sd += " (Basetype: " + Constants.getTypeName(baseType) + ", Dimensions: " + dimensions + ")";
        else if(type == Constants.TYPE_FUNCTION) sd += " (Returns: " + returnType + ", args:" + args + ")";
        sd += ", Constant: " + isConstant;
        if(isConstant) sd += ", Value: " + value;
        sd += ", Declared level: " + declaredLevel + "]";
        return sd;
    }
}
