/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/*
 * VARIABLE ::= IDENTIFIER:v1 ARRAY_SUFFIX:v2
 */
public class SymbolVar extends SymbolBase {

    private String idName;
    private boolean isArray;
    private SymbolArrSuff arraySuffix;

    public SymbolVar(String idName, SymbolArrSuff arraySuffix) {
        super("Variable", 0);
        // TODO check if variable es constante?
        this.idName = idName;
        this.arraySuffix = arraySuffix;
        isArray = arraySuffix.isEmpty()? false : true;
    }
    
    public String getName(){
        return idName;
    }

    public SymbolArrSuff getArrSuff() {
        return arraySuffix;
    }

    public boolean isArray(){
        return isArray;
    }
}
