package lenguag.backend;

import java.util.ArrayList;
import java.util.Hashtable;

public class MachineCodeGenerator {
    
    public ArrayList<String> machineCodeExtern;
    public ArrayList<String> machineCodeData;
    public ArrayList<String> machineCodeText;

    private IntermediateCodeGenerator c3a;
    private ArrayList<Instruction> instructions;

    private Hashtable<String, VarTableEntry> variableTable;
    private Hashtable<String, ProcTableEntry> procedureTable;

    public MachineCodeGenerator(IntermediateCodeGenerator c3a){
        this.c3a = c3a;
        instructions = c3a.getInstructions();
        variableTable = c3a.getVariableTable();
        procedureTable = c3a.getProcedureTable();
        machineCodeExtern = new ArrayList<>();
        machineCodeData = new ArrayList<>();
        machineCodeText = new ArrayList<>();
    }

    // public void generateCode(){
    //     // Declarations initialization

    // }

    /**
     * This is a dummy code generation to test the correctness of the run.sh script
     */
    public void generateCode(){
        machineCodeText.add("; hello_64.asm    print a string using printf");
        machineCodeText.add("; Assemble:	  nasm -f elf64 -l hello_64.lst  hello_64.asm");
        machineCodeText.add("; Link:		  gcc --no-pie -o hello_64  hello_64.o");
        machineCodeText.add("; Run:		  ./hello_64 > hello_64.out");
        machineCodeText.add("; Output:	  cat hello_64.out");
        
        machineCodeText.add("; Equivalent C code");
        machineCodeText.add("; // hello.c");
        machineCodeText.add("; #include <stdio.h>");
        machineCodeText.add("; int main()");
        machineCodeText.add("; {");
        machineCodeText.add(";   char msg[] = \"Hello world\\n\";");
        machineCodeText.add(";   printf(\"%s\\n\",msg);");
        machineCodeText.add(";   return 0;");
        machineCodeText.add("; }");
            
        machineCodeText.add("; Declare needed C  functions");
        machineCodeText.add("    extern	printf		; the C function, to be called");
        machineCodeText.add("    extern  scanf");
        
        machineCodeText.add("    section .data		; Data section, initialized variables");
        machineCodeText.add("msg:	db \"Hello world\", 0	; C string needs 0");
        machineCodeText.add("fmt:    db \"%d\", 10, 0       ; The printf format, \"\\n\",'0'");
        machineCodeText.add("int:    times 4 db 0");
        machineCodeText.add("fmtin:  db \"%d\", 0");
        
        machineCodeText.add("    section .text         ; Code section.");
        
        machineCodeText.add("    global main		; the standard gcc entry point");
        machineCodeText.add("main:				; the program label for the entry point");
        machineCodeText.add("    push    rbp		; set up stack frame, must be alligned");
        
        machineCodeText.add("    mov     rsi, int");
        machineCodeText.add("    mov     rdi, fmtin");
        machineCodeText.add("    mov     al, 0");
        machineCodeText.add("    call    scanf");
            
        machineCodeText.add("    mov	rdi,fmt");
        machineCodeText.add("    mov	rsi,[int]");
        machineCodeText.add("    mov	rax,0		; or can be  xor  rax,rax");
        machineCodeText.add("    call    printf		; Call C function");
        
        machineCodeText.add("    pop	rbp		; restore stack");
        
        machineCodeText.add("    mov	rax,0		; normal, no error, return value");
        machineCodeText.add("    ret			; return");
    }

    @Override
    public String toString(){
        String s = "";
        for(String i : machineCodeExtern){
            s += i + "\n";
        }
        for(String i : machineCodeData){
            s += i + "\n";
        }
        for(String i : machineCodeText){
            s += i + "\n";
        }
        return s;
    }
}
