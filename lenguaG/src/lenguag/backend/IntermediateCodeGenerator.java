/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Korn, Andreas Manuel
 * 	- Román Colom, Marc
 * 	- Vilella Candía, Joan 
 */
package lenguag.backend;

import java.util.ArrayList;
import java.util.Hashtable;

import lenguag.Constants;
import lenguag.syntactic.symbols.*;
import lenguag.syntactic.symbols.SymbolInstr.instructionType;
import lenguag.backend.Instruction.InstructionType;

public class IntermediateCodeGenerator {

    private ArrayList<Instruction> c3a;

    private Hashtable<String, VarTableEntry> variableTable;
    private Hashtable<String, ProcTableEntry> procedureTable;
    private Hashtable<String, Integer> eList;
    
    private int depth;
    private int numE;
    private int numT;
   
    public IntermediateCodeGenerator(){
        c3a = new ArrayList<>();
        variableTable = new Hashtable<>();
        procedureTable = new Hashtable<>();
        numE = 0;
        numT = 0;
    }

    /**
     * Starts the intermediate code generation. 
     * @param body - The root node of what should be the whole tree generated by the parser and which has been analyzed by the semantic analyzer.
     */
    public void generate(SymbolBody body){
        // No code is generated here, equal to its semantic.manage() equivalent
        SymbolDecs decs = body.getDeclarations();
        if(decs != null) generate(decs);
        SymbolMain main = body.getMain();
        generate(main);
    }
    
    /**
     * Arg: getType(), identifier
     * @param arg
     */
    private void generate(SymbolArg arg){
    }

    /**
     * Args: getArg(), getNext()
     * @param args
     */
    private void generate(SymbolArgs args){
    }

    /**
     * ArrSuff: getIndex(), getNext(), getDimensions()
     * @param arrSuff
     */
    private void generate(SymbolArrSuff arrSuff){
    }

    /**
     * Assign: getVariable(), getRightSide()
     * @param assign
     */
    private void generate(SymbolAssign assign){

    }

    /**
     * Declaration: isConstant, variableName, getType(), getValue()
     * @param dec
     */
    private void generate(SymbolDec dec){
        String t;
        if(dec.isConstant){
            t = newVariable();
            addInstruction(InstructionType.copy, dec.getValue().getSemanticValue().toString(), t);
            replaceVarTableKey(t, dec.variableName);
            return;
        }
        SymbolOperation value = dec.getValue();
        generate(value);
        t = value.reference;
        // addInstruction(InstructionType.copy, value.reference, t);
        dec.reference = t;
    }

    /**
     * Decs: Dec/Func, Decs.1
     * @param decs
     */
    private void generate(SymbolDecs decs){
        // No code is generated here, equal to its semantic.manage() equivalent
        SymbolBase dec = decs.getDeclaration();
        if(dec instanceof SymbolDec) generate((SymbolDec) dec);
        else if (dec instanceof SymbolFunc) {
            String eContDecs = newTag();
            addInstruction(InstructionType.go_to, eContDecs); // We must skip the function during executions unless called
            generate((SymbolFunc) dec);
            addInstruction(InstructionType.skip, eContDecs);
        }
        
        SymbolDecs nextDecs = decs.getNext();
        if (nextDecs != null) generate(nextDecs);
    }

    /**
     * sElse: getIf() | getInstructions()
     * @param sElse
     */
    private void generate(SymbolElse sElse){
        
    }

    /**
     * sFor: getInit(), getCondition(), getFinal(), getInstructions()
     * @param sFor
     */
    private void generate(SymbolFor sFor){
        
    }

    /**
     * Function: getType(), getFunctionName(), getArgs(), getInstructions()
     * @param func
     */
    private void generate(SymbolFunc func){
        
    }

    /**
     * functionCall: getFunctionName(), getNParams(), getParams()
     * @param functionCall
     */
    private void generate(SymbolFuncCall functionCall){
        
    }

    /**
     * sIf: getCondition(), getInstructions(), getElse()
     * @param sIf
     */
    private void generate(SymbolIf sIf){
        
    }

    private void generate(SymbolIn in){
        
    }

    /**
     * Instruction: instructionType
     * @param instruction
     */
    private void generate(SymbolInstr instruction){
        
    }

    /**
     * Instructions: getInstruction(), getNext()
     * @param instructions
     */
    private void generate(SymbolInstrs instructions){
        
    }

    /**
     * List: getValue(), getNext(), length
     * @param list
     */
    private void generate(SymbolList list){
        String t = newVariable();
        
        list.reference = t;
    }

    private void generate(SymbolLoop loop){
        
    }

    /**
     * Main: getInstructions()
     * @param main
     */
    private void generate(SymbolMain main){
        
    }

    /**
     * Operand: Value/Operation, isNegated
     * @param operand
     */
    private void generate(SymbolOperand operand){
        String t = "";

        Object value = operand.getValue();
        System.out.println(value.toString());

        if(!operand.isLeaf()){
            SymbolOperation operation = (SymbolOperation) operand.getValue();
            generate(operation);
            t = operation.reference;
        } else if(value instanceof SymbolValue){
            SymbolValue sValue = (SymbolValue) operand.getValue();
            generate(sValue);
            t = sValue.reference;
        } else if(value instanceof Integer){
            t = newVariable();
            addInstruction(InstructionType.copy, value.toString(), t);
            variableTable.get(t).occupation = Constants.INTEGER_BYTES;
        } else if(value instanceof Character){
            t = newVariable();
            char cVal = (Character) value;
            addInstruction(InstructionType.copy, "" + (int) cVal, t);
        } else if(value instanceof Boolean){
            t = newVariable();
            boolean bVal = (Boolean) value;
            addInstruction(InstructionType.copy, "" + (bVal ? Constants.TRUE : Constants.FALSE), t);
        }

        operand.reference = t;
        // if(operand.isConstant) {
        //     String t = newVariable();
        //     addInstruction(InstructionType.copy, operand.getSemanticValue().toString(), t);
        // }

        // if(operand.isLeaf()) {
        //     SymbolValue value = (SymbolValue) operand.getValue();
        //     generate(value);
        //     operand.type = value.type;
        //     if(operand.isConstant = value.isConstant) {operand.setSemanticValue(value.getSemanticValue());}
        // } else if(operand.getValue() instanceof SymbolOperation){
        //     SymbolOperation operation = (SymbolOperation) operand.getValue();
        //     generate(operation);
        //     operand.type = operation.type;
        //     if(operand.isConstant = operation.isConstant) operand.setSemanticValue(operation.getSemanticValue());
        // }
        
        // if(operand.isConstant){
        //     if(operand.isNegated()){
        //         if(operand.getSemanticValue() instanceof Integer)
        //             operand.setSemanticValue(-(Integer) operand.getSemanticValue());
        //         else if(operand.getSemanticValue() instanceof Boolean)
        //             operand.setSemanticValue(!(Boolean) operand.getSemanticValue());
        //     }
        // }
    }

    /**
     * Operation: getLValue(), getOp(), getRValue().
     * @param operation
    */
    private void generate(SymbolOperation operation){
        SymbolOperand lValue = operation.getLValue();
        generate(lValue);
        SymbolOp op = operation.getOperation();
        SymbolOperand rValue = operation.getRValue();
        if(op == null || rValue == null) return;
        generate(rValue);
    }

    /**
     * 
     * @param out
     */
    private void generate(SymbolOut out){
        
    }

    /**
     * Params: getValue(), getNext()
     * @param params
     */
    private void generate(SymbolParams params){
        
    }

    /**
     * sReturn: getValue()
     * @param sReturn
    */
    private void generate(SymbolReturn sReturn){
        
    }

    /**
     * Swap: getVar1(), getVar2()
     * @param swap
     */
    private void generate(SymbolSwap swap){
        
    }

    /**
     * Value: getValue(), isConstant
     * @param value
     */
    private void generate(SymbolValue value){
        Object val = value.getSemanticValue();
        String t = "";
        if(val instanceof SymbolVar) {
            SymbolVar var = (SymbolVar) val;
            generate(var);
            t = var.reference;
        } else if(val instanceof SymbolFuncCall) {
            SymbolFuncCall fcall = (SymbolFuncCall) val;
            generate(fcall);
            t = fcall.reference;
        } else if(val instanceof SymbolList) {
            SymbolList list = (SymbolList) val;
            generate(list);
            t = list.reference;
            // We calculate the total occupation on this variable, starting by the first level's length
            int occupation = list.type.arrayLength;
            SymbolType subLevel = list.type.getBaseType();
            // We go through each sublevel so that we can calculate the occupation accordingly.
            while(subLevel.getArrayDepth() > 0){
                occupation *= subLevel.arrayLength;
                subLevel = subLevel.getBaseType();
            }
            // If the occupation of a single value is different to 1, we must multiply by the single value's occupation.
            if(subLevel.isType(Constants.TYPE_INTEGER)){
                occupation *= Constants.INTEGER_BYTES;
            }
            variableTable.get(t).occupation = occupation;
        } else if(val instanceof Integer) {
            int intValue = (Integer) val; 
            t = newVariable();
            addInstruction(InstructionType.copy, "" + intValue, t);
            variableTable.get(t).occupation = Constants.INTEGER_BYTES;
        } else if(val instanceof Boolean) {
            boolean boolValue = (Boolean) val;
            t = newVariable();
            addInstruction(InstructionType.copy, "" + (boolValue ? Constants.TRUE : Constants.FALSE), t);
            variableTable.get(t).occupation = Constants.BOOL_BYTES;
        } else if(val instanceof Character) {
            char cValue = (Character) val;
            t = newVariable();
            addInstruction(InstructionType.copy, "" + cValue, t);
        }
        value.reference = t;
    }

    /**
     * Var: getId(), getArrSuffix()
     * @param var
    */
    private void generate(SymbolVar var){
        
    }

    private String newVariable(){
        String t = "t" + numT++;
        VarTableEntry vte = new VarTableEntry(t);
        variableTable.put(t, vte);
        return t;
    }

    private String newTag(){
        return "e" + numE++;
    }
    
    private void replaceVarTableKey(String oldKey, String newKey){
        VarTableEntry vte = variableTable.get(oldKey);
        variableTable.remove(oldKey);
        variableTable.put(newKey, vte);
    }

    private void addInstruction(InstructionType instruction, String left, String right, String destination){
        Instruction i = new Instruction(instruction, left, right, destination);
        c3a.add(i);
    }
    
    private void addInstruction(InstructionType instruction, String left, String destination){
        Instruction i = new Instruction(instruction, left, destination);
        c3a.add(i);
    }
    
    private void addInstruction(InstructionType instruction, String destination){
        Instruction i = new Instruction(instruction, destination);
        c3a.add(i);
    }

    public String toString(){
        String s = "";
        for(Instruction i : c3a){
            s += i + "\n";
        }
        return s;
    }
}
