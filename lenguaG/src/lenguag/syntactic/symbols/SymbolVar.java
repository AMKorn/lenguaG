/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/*
 * VARIABLE ::= IDENTIFIER:idName ARRAY_SUFFIX:arraySuffix
 */
public class SymbolVar extends SymbolBase {

    private String idName;
    private SymbolArrSuff arraySuffix;

    // Variables for semantic control
    public SymbolType type = new SymbolType();                 // Not set until known
    public boolean isConstant;
    //public Object semanticValue;            // To set as a primitive object during semantic control if it's a constant

    public SymbolVar(String idName, SymbolArrSuff arraySuffix, int line, int column) {
        super("Variable", 0, line, column);
        this.idName = idName;
        this.arraySuffix = arraySuffix;
    }
    
    public String getId(){
        return idName;
    }

    public SymbolArrSuff getArrSuff() {
        return arraySuffix;
    }

    public boolean isArray(){
        return arraySuffix != null;
    }

    public Object getSemanticValue(){
        return value;
    }

    public void setSemanticValue(Object value){
        this.value = value;
    }
}
