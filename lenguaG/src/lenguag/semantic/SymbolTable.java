package lenguag.semantic;

import java.util.ArrayList;
import java.util.HashMap;

public class SymbolTable {
    
    // The main structure of the symbol table is an ArrayList of the information of each symbol.
    private HashMap<String, SymbolDescription> symbolTable;

    private int currentLevel;
    private ArrayList<Integer> ambitsTable;
    private ArrayList<Object[]> expansionTable;

    public SymbolTable(){
        symbolTable = new HashMap<>();
        currentLevel = 0;
        ambitsTable = new ArrayList<>();
        expansionTable = new ArrayList<>();
    }

    public void insertVariable(String variable, SymbolDescription desc){
        desc.setLevel(currentLevel);
        symbolTable.put(variable, desc);
    }

    public SymbolDescription getDescription(String variable){
        return symbolTable.get(variable);
    }

    public boolean contains(String variable){
        return symbolTable.containsKey(variable);
    }

    public void empty(){
        currentLevel = 0;
        symbolTable.clear();
        ambitsTable.clear();
    }
}
