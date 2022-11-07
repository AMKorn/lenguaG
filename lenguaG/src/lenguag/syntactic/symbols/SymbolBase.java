/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

import java_cup.runtime.ComplexSymbolFactory.ComplexSymbol;

public class SymbolBase extends ComplexSymbol {
    private static int idSymbol = 0;

    public SymbolBase(String variable, Object value){
        super(variable, idSymbol++, value);
    }
    
}