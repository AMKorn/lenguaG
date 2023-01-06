package lenguag.backend;

import java.util.ArrayList;
import java.util.Hashtable;

public class MachineCodeGenerator {
    
    public ArrayList<String> data;
    public ArrayList<String> text;

    private IntermediateCodeGenerator c3a;
    private ArrayList<Instruction> instructions;

    private Hashtable<String, VarTableEntry> variableTable;
    private Hashtable<String, ProcTableEntry> procedureTable;

    private boolean printUsed = false;
    private boolean scanUsed = false;

    public MachineCodeGenerator(IntermediateCodeGenerator c3a){
        this.c3a = c3a;
        instructions = c3a.getInstructions();
        variableTable = c3a.getVariableTable();
        procedureTable = c3a.getProcedureTable();
        data = new ArrayList<>();
        text = new ArrayList<>();
    }

    public void generateCode(){
        // Declarations initialization
        data.add("\tsection .data");

        for (String s : variableTable.keySet()) {
            if(s.startsWith(IntermediateCodeGenerator.DEF_FUNCTION)){
                VarTableEntry vte = variableTable.get(s);
                String t = vte.tName;
                int occupation = vte.getOccupation();
                data.add(t + ": \t" + "times " + occupation + " db 0");
            }
        }

        text.add("\tsection .text\n"
                + "\tglobal main\n"
                + "main:\n"
                + "\tpush rbp");

        // TODO code generation

        text.add("\tpop rbp\n"
                + "\tmov rax,0\n"
                + "ret");
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
}
