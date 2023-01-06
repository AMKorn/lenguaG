package lenguag.syntactic.symbols;

import java_cup.runtime.ComplexSymbolFactory.ComplexSymbol;

public class SymbolBase extends ComplexSymbol {
    private static int idSymbol = 0;
    public int line;
    public int column;

    // Intermediate code generation variable
    public String reference;

    public SymbolBase(String variable, Object value){
        super(variable, idSymbol++, value);
    }

    public SymbolBase(String variable, Object value, int line, int column){
        super(variable, idSymbol++, value);
        this.line = line;
        this.column = column;
    }
    
}