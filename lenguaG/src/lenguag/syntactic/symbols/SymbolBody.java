package lenguag.syntactic.symbols;

/*
 * BODY ::= DECLARATIONS:declarations MAIN:main
 */
public class SymbolBody extends SymbolBase {
    private SymbolDecs declarations;
    private SymbolMain main;

    public SymbolBody(SymbolDecs declarations, SymbolMain main, int line, int column){
        super("Body", 0, line, column);
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
