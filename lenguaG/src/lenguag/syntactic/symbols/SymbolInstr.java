/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
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
public class SymbolInstr extends SymbolBase {
    SymbolBase instruction;

    public SymbolInstr(SymbolBase instruction){
        super("Instruction", 0);
        this.instruction = instruction;
    }

    // TODO detectar qué tipo de instrucción es, aunque me veo venir que eso tendremos que hacerlo desde la funcion gestionar del semantico
}
