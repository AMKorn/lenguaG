package lenguag.backend;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Stack;

import lenguag.LenguaG;

public class MachineCodeGenerator {
    
    public ArrayList<String> data;
    public ArrayList<String> text;

    private ArrayList<Instruction> instructions;

    private Hashtable<String, VarTableEntry> variableTable;
    private Hashtable<String, String> variableDictionary;
    private Hashtable<String, ProcTableEntry> procedureTable;

    // Info from the current process
    private Stack<ProcTableEntry> pteStack;
    private ProcTableEntry currentPte;

    private boolean printUsed = false;
    private boolean scanUsed = false;

    public MachineCodeGenerator(IntermediateCodeGenerator c3a){
        instructions = c3a.getInstructions();
        variableTable = c3a.getVariableTable();
        procedureTable = c3a.getProcedureTable();
        variableDictionary = new Hashtable<>();
        data = new ArrayList<>();
        text = new ArrayList<>();
        pteStack = new Stack<>();
    }

    public void generateCode(){
        ProcTableEntry pte;
        // Declarations initialization
        data.add("\tsection .data");

        for (String s : variableTable.keySet()) {
            VarTableEntry vte = variableTable.get(s);
            if(s.startsWith(IntermediateCodeGenerator.DEF_FUNCTION)){
                String t = vte.tName;
                int occupation = vte.getOccupation();
                data.add(t + ": \t" + "times " + occupation + " db 0");
            } else variableDictionary.put(vte.tName, s);
        }

        text.add("\tsection .text\n"
                + "\tglobal main\n"
                + "main:\n"
                + "\tmov rbp, rsp\n"
                + "\tpush rbp\n");

        for (Instruction instruction : instructions) {
            //if (LenguaG.DEBUGGING) 
                text.add("\t; " + instruction);
            
            String des = instruction.destination;
            String left = instruction.left;
            String right = instruction.right;
            
            // We check if the variables are local variables/parameters
            String stackVar = variableDictionary.get(des);
            if(stackVar != null) {
                VarTableEntry vte = variableTable.get(stackVar);
                des = "rsp+"+(vte.displacement);
                if(LenguaG.DEBUGGING)
                    text.add("\t; //" + instruction.destination + " -> " + des);
            }
            String aDes = des; // String that contains the address of des.
            des = isNumber(des)? des : "[" + des + "]"; // des if it's a number, [des] if not. [des] mean the content of des
            if(left != null){
                stackVar = variableDictionary.get(left);
                if(stackVar != null) {
                    VarTableEntry vte = variableTable.get(stackVar);
                    left = "rsp+"+(vte.displacement);
                    if(LenguaG.DEBUGGING)
                        text.add("\t; //" + instruction.left + " -> " + left);
                }
            }
            String aLeft = left;
            left = isNumber(left)? left : "[" + left + "]";
            if(right != null){
                stackVar = variableDictionary.get(right);
                if(stackVar != null) {
                    VarTableEntry vte = variableTable.get(stackVar);
                    right = "rsp+"+(vte.displacement);
                    if(LenguaG.DEBUGGING)
                        text.add("\t; //" + instruction.right + " -> " + right);
                }
            }
            String aRight = right;
            right = isNumber(right)? right : "[" + right + "]";


            switch (instruction.instruction) {
                case copy:
                    // copy: des = left
                    text.add("\tmov eax," + left);
                    text.add("\tmov " + des + ",eax");
                    break;
                case add:
                    // add: des = left + right
                    text.add("\tmov eax," + left);
                    text.add("\tmov ebx," + right);
                    text.add("\tadd ebx,eax");
                    text.add("\tmov " + des + ",ebx");
                    break;
                case and:
                    // and: des = left and right
                    text.add("\tmov eax," + left);
                    text.add("\tmov ebx," + right);
                    text.add("\tand ebx,eax");
                    text.add("\tmov " + des + ",ebx");
                    break;
                case call:
                    pte = procedureTable.get(aLeft + IntermediateCodeGenerator.DEF_FUNCTION);
                    text.add("\tpush rax");
                    text.add("\tcall " + pte.eStart);
                    text.add("\tpop rbx"); // We store return into rbx

                    for(int i = 0; i < pte.numParams; i++){
                        text.add("\tpop rax");
                    }

                    text.add("\tmov " + des + ",ebx");
                    break;
                case div:
                    // DIV does EDX:EAX / ECX. Result goes in EAX
                    text.add("\tmov eax," + left);
                    text.add("\tmov edx,0");
                    text.add("\tmov ecx," + right);
                    text.add("\tdiv ecx");
                    text.add("\tmov " + des + ",eax");
                    break;
                case go_to:
                    text.add("\tjmp " + aDes);
                    break;
                case if_EQ:
                    // if left = right goto des
                    text.add("\tmov eax," + left);
                    text.add("\tmov ebx," + right);
                    text.add("\tcmp eax,ebx");
                    text.add("\tje " + aDes);
                    break;
                // case if_GE:
                //      Not used
                //     break;
                // case if_GT:
                //      Not used
                //     break;
                // case if_LE:
                //      Not used
                //     break;
                // case if_LT:
                //      Not used
                //     break;
                // case if_NE:
                //      Not used
                //     break;
                case in:
                    scanUsed = true;

                    // TODO differentiate ints and chars
                    
                    // This case is complex: we need the destionation's address into rsi instead of its contents
                    if(aDes.contains("rsp")){
                        String[] split = aDes.split("\\+");
                        text.add("\tmov rsi,[rsp]");
                        text.add("\tadd rsi," + split[1]);
                    }
                    else text.add("\tmov rsi," + aDes);
                    text.add("\tmov rdi,fmtInInt");
                    text.add("\tmov al, 0");
                    text.add("\tcall scanf");
                    break;
                case ind_ass:
                    // des[left] = right

                    // This case is complex: we need the destionation's address into eax instead of its contents, 
                    if(aDes.contains("rsp")){
                        String[] split = aDes.split("\\+");
                        text.add("\tmov eax,[rsp]");
                        text.add("\tadd eax," + split[1]);
                    }
                    else text.add("\tmov eax," + aDes);
                    text.add("\tadd eax," + left);
                    text.add("\tmov ebx," + right);
                    text.add("\tmov [eax],ebx");

                    break;
                case ind_val:
                    // des = left[right]
                    if(aLeft.contains("rsp")){
                        String[] split = aLeft.split("\\+");
                        text.add("\tmov eax,[rsp]");
                        text.add("\tadd eax," + split[1]);
                    }
                    else text.add("\tmov eax," + aLeft); // FIXME
                    text.add("\tadd eax," + right);
                    text.add("\tmov eax,[eax]");
                    text.add("\tmov " + des + ",eax");
                    break;
                case mod:
                    // DIV does EDX:EAX / ECX. Remainder goes in EDX
                    text.add("\tmov eax," + left);
                    text.add("\tmov edx,0");
                    text.add("\tmov ecx," + right);
                    text.add("\tdiv ecx");
                    text.add("\tmov " + des + ",eax");
                    break;
                case neg:
                    // and: des = - left
                    text.add("\tmov eax," + left);
                    text.add("\tneg eax");
                    text.add("\tmov " + des + ",eax");
                    break;
                case not:
                    // and: des = not left
                    text.add("\tmov eax," + left);
                    text.add("\tnot eax");
                    text.add("\tmov " + des + ",eax");
                    break;
                case or:
                    // and: des = left and right
                    text.add("\tmov eax," + left);
                    text.add("\tmov ebx," + right);
                    text.add("\tor ebx,eax");
                    text.add("\tmov " + des + ",ebx");
                    break;
                case out:
                    printUsed = true;

                    // TODO print characters and arrays

                    text.add("\tmov rdi,fmtOutInt");
                    text.add("\tmov rsi," + des);
                    text.add("\tmov rax, 0");
                    text.add("\tcall printf");
                    break;
                case param_c:
                    break;
                case param_s:
                    text.add("\txor rax,rax");
                    text.add("\tmov eax," + des);
                    text.add("\tpush rax");
                    break;
                case pmb:
                    // pmb: des
                    // Where des is the name of the function. As such, we should be able to find it in procedureTable
                    pteStack.push(currentPte);
                    currentPte = procedureTable.get(aDes + IntermediateCodeGenerator.DEF_FUNCTION);
                    
                    break;
                case point:
                    // des -> left
                    break;
                case prod:
                    // the operation mul multiplies the specified location
                    // (register or memory) with EAX. I use register because it
                    // is a bit faster.
                    text.add("\tmov eax," + left);
                    text.add("\tmov ecx," + right);
                    text.add("\tmul exc");
                    text.add("mov " + des + ",eax");
                    break;
                case rtn:
                    text.add("\tmov eax," + left);
                    text.add("\tmov [rsp+8],eax");
                    text.add("\tjmp " + currentPte.eEnd);
                    // We jump to the return point. This was done to more easily deal with the current function
                    break;
                case skip:
                    // des: skip
                    text.add(aDes + ":");
                    if(currentPte != null && aDes.equals(currentPte.eEnd)){
                        currentPte = pteStack.pop();
                        text.add("\tret");
                    }
                    break;
                case sub:
                    // des = left - right
                    text.add("\tmov eax," + left);
                    text.add("\tmov ebx," + right);
                    text.add("\tsub eax,ebx");
                    text.add("\tmov " + des + ",eax");
                    break;
                default:
                    throw new RuntimeException("Operation not implemented: " + instruction);
            }
        }

        text.add("\n\tpop rbp\n"
                + "\tmov rax,0\n"
                + "\tret");

        if(printUsed){
            //     text.add("fmtin:  db \"%d\", 0");
            data.add("fmtOutInt: db \"%d\",10,0");
            data.add("fmtOutChar: db \"%s\",10,0");
        }
        if(scanUsed){
            data.add("fmtInInt:  db \"%d\", 0");
            data.add("fmtInChar:  db \"%s\", 0");
        }
    }

    private boolean isNumber(String string){
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    @Override
    public String toString(){
        String s = "";
        if(printUsed) s += "\textern printf\n";
        if(scanUsed) s += "\textern scanf\n";
        for(String i : data){
            s += i + "\n";
        }
        for(String i : text){
            s += i + "\n";
        }
        return s;
    }

    /**
     * This is a dummy code generation to test the correctness of the run.sh script and as a baseline for working code. 
     * // TODO remove
     */
    // public void generateCode(){
    //     text.add("; hello_64.asm    print a string using printf");
    //     text.add("; Assemble:	  nasm -f elf64 -l hello_64.lst  hello_64.asm");
    //     text.add("; Link:		  gcc --no-pie -o hello_64  hello_64.o");
    //     text.add("; Run:		  ./hello_64 > hello_64.out");
    //     text.add("; Output:	  cat hello_64.out");
        
    //     text.add("; Equivalent C code");
    //     text.add("; // hello.c");
    //     text.add("; #include <stdio.h>");
    //     text.add("; int main()");
    //     text.add("; {");
    //     text.add(";   char msg[] = \"Hello world\\n\";");
    //     text.add(";   printf(\"%s\\n\",msg);");
    //     text.add(";   return 0;");
    //     text.add("; }");
            
    //     text.add("; Declare needed C  functions");
    //     text.add("    extern	printf		; the C function, to be called");
    //     text.add("    extern  scanf");
        
    //     text.add("    section .data		; Data section, initialized variables");
    //     text.add("msg:	db \"Hello world\", 0	; C string needs 0");
    //     text.add("fmt:    db \"%d\", 10, 0       ; The printf format, \"\\n\",'0'");
    //     text.add("int:    times 4 db 0");
    //     text.add("fmtin:  db \"%d\", 0");
        
    //     text.add("    section .text         ; Code section.");
        
    //     text.add("    global main		; the standard gcc entry point");
    //     text.add("main:				; the program label for the entry point");
    //     text.add("    push    rbp		; set up stack frame, must be alligned");
        
    //     text.add("    mov     rsi, int");
    //     text.add("    mov     rdi, fmtin");
    //     text.add("    mov     al, 0");
    //     text.add("    call    scanf");
            
    //     text.add("    mov	rdi,fmt");
    //     text.add("    mov	rsi,[int]");
    //     text.add("    mov	rax,0		; or can be  xor  rax,rax");
    //     text.add("    call    printf		; Call C function");
        
    //     text.add("    pop	rbp		; restore stack");
        
    //     text.add("    mov	rax,0		; normal, no error, return value");
    //     text.add("    ret			; return");
    // }
}
