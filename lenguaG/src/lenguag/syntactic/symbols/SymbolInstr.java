/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */

/*
 * REVISAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAR!!!!!!!!!!!!!!!!!
 */

package lenguag.syntactic.symbols;

/*
 * INSTRUCTION ::= DECLARATION:v ENDLINE                                   
    | ASSIGNATION:v ENDLINE                                             
    | SWAP:v ENDLINE                                                    
    | FUNCTION_CALL:v ENDLINE                                           
    | RETURN:v ENDLINE                                                  
    | IF:v                                                              
    | LOOP:v                                                            
    | FOR:v                                                             
    | IN:v ENDLINE                                                      
    | OUT:v ENDLINE                                                     
 */
public class SymbolInstr extends Symbolbase {
    SymbolDec declaration;
    SymbolAssign assignation;
    SymbolSwap swap;
    SymbolFuncCall function_call;
    SymbolReturn s_return;
    SymbolIf s_if;
    SymbolLoop loop;
    SymbolFor s_for;
    SymbolIn in;
    SymbolOut out;

    public SymbolInstr(SymbolDec declaration) {
        super("Instruction", 0);
    }

    public SymbolInstr(SymbolAssign assignation) {
        super("Instruction", 0);
    }

    public SymbolInstr(SymbolSwap swap) {
        super("Instruction", 0);
    }

    public SymbolInstr(SymbolFuncCall function_call) {
        super("Instruction", 0);
    }

    public SymbolInstr(SymbolReturn s_return) {
        super("Instruction", 0);
    }

    public SymbolInstr(SymbolIf s_if) {
        super("Instruction", 0);
    }

    public SymbolInstr(SymbolLoop loop) {
        super("Instruction", 0);
    }

    public SymbolInstr(SymbolFor s_for) {
        super("Instruction", 0);
    }

    public SymbolInstr(SymbolIn in) {
        super("Instruction", 0);
    }

    public SymbolInstr(SymbolOut ou) {
        super("Instruction", 0);
    }

}
