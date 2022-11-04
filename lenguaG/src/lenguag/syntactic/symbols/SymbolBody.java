/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/*
 * BODY -> DECLARATIONS MAIN.
 */
public class SymbolBody extends SymbolBase {
    SymbolDecs declarations;
    SymbolMain main;

    public SymbolBody(SymbolDecs declarations, SymbolMain main){
        super("Body", 0);
        this.declarations = declarations;
        this.main = main;
    }
}
