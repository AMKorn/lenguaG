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
    private boolean isConstant;
    SymbolDecCont cont_declaration;
    
    public SymbolDec(SymbolDecCont cont_declaration) {
        super("Declaration", 0);
        this.cont_declaration = cont_declaration;
        isConstant = false;
        // Add variable to tabla de variables
    }
    
    public SymbolDec(SymbolDecCont cont_declaration, boolean isConstant){
        super("Declaration", 0);
        this.cont_declaration = cont_declaration;
        this.isConstant = isConstant;
        // Add variable to tabla de variables
    }

    public boolean isConstant(){
        return isConstant;
    }
}
