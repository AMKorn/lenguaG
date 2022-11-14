/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/**
 * DECLARATION ::= CONSTANT:isConstant CONT_DECLARATION:contDeclaration
 *               | CONT_DECLARATION:contDeclaration
 */
public class SymbolDec extends SymbolBase {
    private boolean isConstant;

    private SymbolType type;
    private SymbolVar variable;
    private SymbolOper value;
    // private SymbolDecCont contDeclaration;
    
    public SymbolDec(SymbolDecCont contDeclaration) {
        super("Declaration", 0);
        type = contDeclaration.getType();
        variable = contDeclaration.getVar();
        value = contDeclaration.getValue();
        isConstant = false;
        // Add variable to tabla de variables
    }
    
    public SymbolDec(SymbolDecCont contDeclaration, boolean isConstant){
        super("Declaration", 0);
        type = contDeclaration.getType();
        variable = contDeclaration.getVar();
        value = contDeclaration.getValue();
        this.isConstant = isConstant;
        // Add variable to tabla de variables
    }

    public boolean isConstant(){
        return isConstant;
    }
    
    public SymbolType getType(){
        return type;
    }

    public SymbolVar getVar(){
        return variable;
    }

    public SymbolOper getValue(){
        return value;
    }
}
