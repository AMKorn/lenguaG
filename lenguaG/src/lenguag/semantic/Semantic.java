package lenguag.semantic;

import java.util.ArrayList;

import lenguag.*;
import lenguag.LenguaGException.CompilerException;
import lenguag.LenguaGException.SemanticException;
import lenguag.syntactic.symbols.*;

public class Semantic {
    
    public SymbolTable symbolTable;

    // Variables that specify inside which function we are currently.
    SymbolDescription currentFunction;

    private ArrayList<String> errors;
    public boolean thereIsError = false;

    public Semantic(){
        symbolTable = new SymbolTable();
        errors = new ArrayList<>();
    }

    /**
     * Starts the semantic analysis. There should be no possible errors in this symbol if syntactical analysis was correct.
     * Body: getDeclarations(), getMain()
     * @param body - The root node of what should be the whole tree generated by the parser.
     */
    public void manage(SymbolBody body){
        SymbolDecs decs = body.getDeclarations();
        if(decs != null) manage(decs);
        SymbolMain main = body.getMain();
        manage(main);
    }
    
    private void manage(SymbolArg arg){
        // TODO
    }

    private void manage(SymbolArgs args){
        // TODO
    }

    private void manage(SymbolArrSuff arrSuff){
        // TODO
    }

    private void manage(SymbolAssign assign){
        // TODO
    }

    /**
     * Declaration: isConstant, variableName, getType(), getValue()
     * @param dec
     */
    private void manage(SymbolDec dec){
        /* Possible errors:
         * 1. Set as constant but has a variable value or no value
         * 2. type and the value's type are incompatible
         * 3. variableName already present in symbolTable at this level.
         *      This is detected INSIDE SymbolTable, but error must be caught here
         */
        SymbolType type = dec.getType();
        manage(type);
        SymbolOperation value = dec.getValue();
        if(value != null) {
            manage(value);
            // Incompatible types
            if(type.getBaseType() != value.type) {
                reportError("Type incongruency with " + dec.variableName + ": "
                + Constants.getType(value.type) + " cannot be cast into " + Constants.getType(type.getType()), dec.line, dec.column);
                return;
            }
            // Constant declared, but value is variable.
            if(dec.isConstant && !value.isConstant){
                reportError("Cannot assign variable value to constant " + dec.variableName, dec.line, dec.column);
                return;
            }
        } else if(dec.isConstant){
            // Set as constant but no value given
            reportError("Constant " + dec.variableName + " declared without value", dec.line, dec.column);
        }

        // Everything ok!
        // We add the variable to the symbol table 
        SymbolDescription description = new SymbolDescription();
        description.changeType(type);
        description.isConstant = dec.isConstant;
        // if(dec.isConstant) TODO add value to description if constant
        try{ 
            symbolTable.insertVariable(dec.variableName, description);
        } catch(SemanticException se){
            reportError(se.getMessage(), dec.line, dec.column);
        }
    }

    /**
     * Decs: Dec/Func, Decs.1
     * @param decs
     */
    private void manage(SymbolDecs decs){
        SymbolBase dec = decs.getDeclaration();
        if(dec instanceof SymbolDec) manage((SymbolDec) dec);
        else if (dec instanceof SymbolFunc) manage((SymbolFunc) dec);
        else // Impossible case. Here as a safeguard to notify us if we did something wrong.
            System.err.println(" !!! Compiler error !!!");
        
        SymbolDecs nextDecs = decs.getNext();
        if (nextDecs != null) manage(nextDecs);
    }

    private void manage(SymbolElse sElse){
        // TODO
    }

    private void manage(SymbolFor sFor){
        // TODO
    }

    /**
     * Function: getType(), getFunctionName(), getArgs(), getInstructions()
     * @param func
     */
    private void manage(SymbolFunc func){
        /* Possible errors:
         * 1. Function already declared (checked inside of symbolTable)
         * 2. Function type and return type are not compatible.
         *      Complex solution. No direct connection between SymbolFunc and any instruction in the function.
         */
        String name = func.getFunctionName();
        // We check whether the function was already declared or not. 
        try {
            // We set current function to the current function's empty description so that we can fill it up further in the process.
            currentFunction = new SymbolDescription(); 
            symbolTable.insertVariable(name, currentFunction);
        } catch(SemanticException se){
            // If symbol table already found the name of the function, it's a compilation error. 
            // This means that a variable and a function cannot share the same name. FIXME later if we have enough time to think of an easy solution,
            // otherwise this is by design. Sort of.
            reportError(se.getMessage(), func.line, func.column);
            return;
        }
        /* The following logic would work if we had a way to insert different names in the symbol table. Delete this if we end up not implementing it.
        // Fortunately, the number of arguments is calculated during syntactical analysis so it is trivial to check for polymorphism.
        SymbolDescription funcPrima = symbolTable.getDescription(name);
        if(funcPrima != null) {
            if(funcPrima.getType() == Constants.TYPE_FUNCTION && funcPrima.getNArgs() == func.getNArgs()){
                reportError("Function already declared", func.line, func.column);
            }
        } */

        // Everything ok so far!
        // We enter a new ambit on the symbol table
        symbolTable.enterBlock();
        // We change the type of the created symbol on the symbol table to TYPE_FUNCTION
        currentFunction.changeType(Constants.TYPE_FUNCTION);
        // We manage the return type of the function.
        SymbolType type = func.getType();
        manage(type);
        currentFunction.setReturnType(type); // and set it in the description.

        // Arguments treatment. Inside here, currentFunction should receive the different arguments of the function.
        SymbolArgs args = func.getArgs();
        manage(args);

        // Instructions treatment. Inside here, we will deal with the return statement being of a compatible type with the function's return type
        SymbolInstrs instrs = func.getInstructions();
        manage(instrs);

        // We return to the previous ambit
        try{
            symbolTable.exitBlock();
        } catch(CompilerException ce){
            // !!! Compiler error !!!
            ce.printStackTrace();
        }
    }

    private void manage(SymbolFuncCall functionCall){
        // TODO
    }

    private void manage(SymbolIf sIf){
        // TODO
    }

    private void manage(SymbolIn in){
        // TODO
    }

    private void manage(SymbolInstr instruction){
        // TODO
    }

    private void manage(SymbolInstrs instructions){
        // TODO
    }

    private void manage(SymbolList list){
        // TODO
    }

    private void manage(SymbolLoop loop){
        // TODO
    }

    private void manage(SymbolMain main){
        // TODO
    }

    private void manage(SymbolOp op){
        // TODO
    }

    private void manage(SymbolOperand operand){
        // TODO
    }

    private void manage(SymbolOperation operation){
        // TODO
    }

    private void manage(SymbolOut out){
        // TODO
    }

    private void manage(SymbolParams params){
        // TODO
    }

    private void manage(SymbolReturn sReturn){
        // TODO
    }

    private void manage(SymbolSwap swap){
        // TODO
    }

    private void manage(SymbolType type){
        // TODO
    }

    private void manage(SymbolValue value){
        // TODO
    }

    private void manage(SymbolVar var){
        // TODO
    }

    private void reportError(String errorMessage, int line, int column){
        thereIsError = true;
        errorMessage = " !! Semantic error: " + errorMessage + " at position [line: " + line + ", column: " + column + "]";
        System.err.println(errorMessage);
        errors.add(errorMessage);
    }

}
