package lenguag.semantic;

import java.util.ArrayList;
import java.util.Stack;

import lenguag.*;
import lenguag.syntactic.symbols.*;

/**
 * Class that represents a variable's description in the symbol table
 */
public class SymbolDescription {

    // TODO fix type
    // The variable's type
    private int type;
    private Object value;

    public int declaredLevel;
    public boolean isConstant;

    // Array information
    private SymbolType baseType;
    private int depth;
    private int length;

    // Function information
    private int nArgs;
    private SymbolType returnType;
    private ArrayList<Argument> args; // arguments are name and type

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
            depth = type.getArrayDepth();
            length = type.arrayLength;
        }
    }

    /**
     * Changes the type of the variable to which this description is associated, given the value of Constants.
     * If given TYPE_ARRAY, baseType and depth will be set to void and 0, respectively, so those should be set afterwards
     * using changeBaseType() and changeDepth().
     * Likewise, nArgs, returnType and args will be set to 0, void and an empty HashMap, respectively. 
     * Use addArgument() and setReturnType() to change them.
     * @param type
     */
    public void changeType(int type) {
        this.type = type;
        if(this.type == Constants.TYPE_ARRAY){
            baseType = new SymbolType();
            depth = 0;
            length = 0;
        } else if(this.type == Constants.TYPE_FUNCTION){
            nArgs = 0;
            returnType = new SymbolType(Constants.TYPE_VOID);
            args = new ArrayList<>();
        }
    }

    public void changeValue(Object value){
        this.value = value;
    }

    public Object getValue(){
        return value;
    }

    public int getType(){
        return type;
    }

    // Array methods
    public void changeBaseType(SymbolType baseType) {
        this.baseType = baseType;
    }

    public SymbolType getBaseType() {
        return baseType;
    }

    public void changeDepth(int depth) {
        this.depth = depth;
    }

    public int getDepth()  {
        return depth;
    }

    public void setLength(int length){
        this.length = length;
    }

    public int getLength(){
        return length;
    }

    // Function methods

    /**
     * Adds the param of the given type to the parameters of the function, incrementing nArgs
     * @param name
     * @param type
     */
    public void addArgument(String name, SymbolType type) {
        args.add(new Argument(name, type));
        nArgs++;
    }

    public int getNArgs() {
        return nArgs;
    }

    public Stack<SymbolType> getArgsTypes() {
        Stack<SymbolType> types = new Stack<>();
        for(Argument a : args){
            types.push(a.type);
        }
        return types;
    }

    public void setReturnType(SymbolType returnType) {
        this.returnType = returnType;
    }

    public SymbolType getReturnType() {
        return returnType;
    }

    @Override
    public String toString(){
        String sd = "[Type: " + Constants.getTypeName(type);
        if(type == Constants.TYPE_ARRAY) {
            SymbolType bt = baseType;
            for(int i = 1; i < depth; i++){
                bt = bt.getBaseType();
            }
            sd += " (Basetype: " + Constants.getTypeName(bt.getType()) + ", Length: " + length + ", Depth: " + depth + ")";
        } else if(type == Constants.TYPE_FUNCTION) sd += " (Returns: " + returnType + ", args:" + args + ")";
        sd += "\n\tConstant: " + isConstant;
        if(isConstant) sd += "\n\tValue: " + value;
        sd += "\n\tDeclared level: " + declaredLevel + "]";
        return sd;
    }

    private class Argument{
        public String name;
        public SymbolType type;

        public Argument(String name, SymbolType type){
            this.name = name;
            this.type = type;
        }

        @Override
        public String toString(){
            return type + " " + name;
        }
    }
}
