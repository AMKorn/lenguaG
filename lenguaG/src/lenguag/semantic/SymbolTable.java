package lenguag.semantic;

import java.util.HashMap;

public class SymbolTable {
    
    // The main structure of the symbol table is an ArrayList of the information of each symbol.
    private HashMap<String, SymbolDescription> symbolTable;

    public SymbolTable(){
        symbolTable = new HashMap<>();
    }

    public void insertVariable(String variable, SymbolDescription desc){
        symbolTable.put(variable, desc);
    }

    public SymbolDescription getDescription(String variable){
        return symbolTable.get(variable);
    }

    public void empty(){
        symbolTable.clear();
    }
}
