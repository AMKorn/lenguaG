package lenguag.semantic;

import java.util.ArrayList;
import java.util.Stack;

import lenguag.*;
import lenguag.syntactic.symbols.*;

/**
 * Class that represents a variable's description in the symbol table
 */
public class SymbolDescription {

    // The variable's type
    private SymbolType type; // Acts as the return type when a function.
    private Object value;

    public int declaredLevel;
    public boolean isConstant;

    // Function information
    private boolean isFunction;
    private int nArgs;
    private ArrayList<Argument> args; // arguments are name and type

    /**
     * Creates an empty description
     */
    public SymbolDescription(){
        type = new SymbolType();
        isConstant = false;
        isFunction = false;
    }

    /**
     * Changes the type of the variable to which this description is associated, given a symbol created by Parser.java.
     * @param type
     */
    public void changeType(SymbolType type) {
        this.type = type;
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
        if(type == Constants.TYPE_FUNCTION){
            isFunction = true;
            nArgs = 0;
            this.type = new SymbolType();
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
        if(isFunction) return Constants.TYPE_FUNCTION;
        return type.getType();
    }

    // Array methods
    public void changeBaseType(SymbolType baseType) {
        type.setBaseType(baseType);
    }

    public SymbolType getBaseType() {
        return type.getBaseType();
    }

    public int getDepth()  {
        return type.getArrayDepth();
    }

    public void setLength(int length){
        type.arrayLength = length;
    }

    public int getLength(){
        return type.arrayLength;
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
        if(!isFunction) throw new RuntimeException(" !! Compiler error");
        type = returnType;
    }

    public SymbolType getReturnType() {
        return type;
    }

    @Override
    public String toString(){
        String sd = "[Type: " + (isFunction ? Constants.getTypeName(Constants.TYPE_FUNCTION) : type);
        if(isFunction) sd += " (Returns: " + type + ", args:" + args + ")";
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
