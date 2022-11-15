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

    public SymbolVar(String idName, SymbolArrSuff arraySuffix) {
        super("Variable", 0);
        this.idName = idName;
        this.arraySuffix = arraySuffix;
    }
    
    public String getName(){
        return idName;
    }

    public SymbolArrSuff getArrSuff() {
        return arraySuffix;
    }

    public boolean isArray(){
        return arraySuffix != null;
    }
}
