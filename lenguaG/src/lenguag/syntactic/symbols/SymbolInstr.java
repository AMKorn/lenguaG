/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */

package lenguag.syntactic.symbols;

/*
 * This is a class which the next classes extend to more easily control instructions. 
 * 
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
public class SymbolInstr extends SymbolBase {
    public static enum instructionType {
        instDeclaration,
        instAssignation,
        instSwap,
        instFunctionCall,
        instReturn,
        instIf,
        instLoop,
        instFor,
        instIn,
        instOut,
        error
    }
    private instructionType instructionType;
    // SymbolBase instruction;

    public SymbolInstr(String variable, int value, instructionType instructionType){
        super(variable, value);
        this.instructionType = instructionType;
    }

    public instructionType getInstructionType(){
        return instructionType;
    }
    
}
