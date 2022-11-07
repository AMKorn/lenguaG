/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/**
 * DECLARATION -> CONSTANT CONT_DECLARATION
    | CONT_DECLARATION.
 */
public class SymbolDec extends SymbolBase {    
    SymbolDecCont cont_declaration;
    
    public SymbolDec(SymbolDecCont cont_declaration) {
        super("Declaration", 0);
        this.cont_declaration = cont_declaration;
    }
    
}
