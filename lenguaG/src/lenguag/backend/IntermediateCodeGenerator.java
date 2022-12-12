package lenguag.backend;

import java.util.ArrayList;

public class IntermediateCodeGenerator {

    private ArrayList<Instruction> c3a;

    //private SymbolTable symbolTable;
    
    private int numE;
    private int numT;
   
    public IntermediateCodeGenerator(){
        c3a = new ArrayList<>();
        numE = 0;
        numT = 0;
    }

    public void addInstruction(Instruction inst){
        c3a.add(inst);
    }

    public String newVariable(){
        return "t" + numT++;
    }

    public String newTag(){
        return "e" + numE++;
    }

    public String toString(){
        String s = "";
        for(Instruction i : c3a){
            s += i + "\n";
        }
        return s;
    }
}
