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
    private SymbolDecCont cont_declaration;
    
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
    
    // TODO get SymbolDecCont - tengo que pensar como quiero hacerlo. Creo que voy a meter todos los metodos getter y setter de DecCont aqui
    // por ahora lo dejo asi
    SymbolType getType(){
        return cont_declaration.type;
    }

    SymbolVar getVar(){
        return cont_declaration.variable;
    }

    SymbolBase getValue(){
        return cont_declaration.value;
    }
}
