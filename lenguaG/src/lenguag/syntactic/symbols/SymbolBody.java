/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/*
 * BODY ::= DECLARATIONS:declarations MAIN:main
 */
public class SymbolBody extends SymbolBase {
    private SymbolDecs declarations;
    private SymbolMain main;

    public SymbolBody(SymbolDecs declarations, SymbolMain main){
        super("Body", 0);
        this.declarations = declarations;
        this.main = main;
    }

    public SymbolDecs getDeclarations(){
        return declarations;
    }

    public SymbolMain getMain(){
        return main;
    }
}
