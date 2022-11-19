package lenguag.semantic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import lenguag.LenguaGException.CompilerException;
import lenguag.LenguaGException.SemanticException;

public class SymbolTable {
    
    // The main structure of the symbol table is an ArrayList of the information of each symbol.
    private HashMap<String, SymbolDescription> symbolTable;

    private int currentLevel;
    private ArrayList<Integer> ambitsTable;
    private ArrayList<tableEntry> expansionTable;

    public SymbolTable(){
        symbolTable = new HashMap<>();
        currentLevel = 0;
        ambitsTable = new ArrayList<>();
        ambitsTable.add(currentLevel, 0);
        expansionTable = new ArrayList<>();
    }

    /**
     * Inserts the variable to the SymbolTable. Variable must be unique in the current level, otherwise SemanticException is thrown.
     * @param variable
     * @param desc
     * @throws SemanticException
     */
    public void insertVariable(String variable, SymbolDescription desc) throws SemanticException {
        // We search for the string (which functions as the hashmap key) in the symbol table
        SymbolDescription oldVarDesc = symbolTable.get(variable);
        if(oldVarDesc != null){
            if(oldVarDesc.declaredLevel == currentLevel) throw new SemanticException("Variable '" + variable + "' already declared in this level");
            // We add the old obscured variable to the expansion table.
            int idxe = ambitsTable.get(currentLevel); // idxe = ambitsTable[currentLevel]
            idxe++;
            ambitsTable.set(currentLevel, idxe); // ambitsTable[currentLevel] = idxe
            expansionTable.add(new tableEntry(variable, oldVarDesc)); // expansionTable[idxe] = description of the obscured variable
        }
        desc.declaredLevel = currentLevel;
        symbolTable.put(variable, desc);
    }

    public SymbolDescription getDescription(String variable) {
        return symbolTable.get(variable);
    }

    public void empty(){
        currentLevel = 0;
        symbolTable.clear();
        ambitsTable.clear();
        expansionTable.clear();
    }

    public void enterBlock(){
        int prevAmbit = ambitsTable.get(currentLevel);
        currentLevel++;
        ambitsTable.add(prevAmbit);
    }

    public void exitBlock() throws CompilerException {
        if(currentLevel == 0) throw new CompilerException(" !!! Compiler error !!! Tried to exit last block in symbol table.");
        int to = ambitsTable.get(currentLevel); // Finishing index: indicates the last variable added to the expansion table.
        ambitsTable.remove(currentLevel);       // we decrement the current level
        currentLevel--;
        int from = ambitsTable.get(currentLevel); // Starting index: first variable added to the expansion table in this level
        for(tableEntry te : expansionTable.subList(from, to)){
            symbolTable.replace(te.variable, te.desc); // We restore the previous value
        }
        expansionTable.subList(from, to).clear(); // We clear the expansion table
        
        // Removal of symbols from the previous level
        Iterator<HashMap.Entry<String, SymbolDescription>> it = symbolTable.entrySet().iterator();
        while(it.hasNext()){
            if(it.next().getValue().declaredLevel > currentLevel) it.remove();
        }
    }

    @Override
    public String toString(){
        String st = "Current level: " + currentLevel + "\n";
        st += "Symbol Table: " + symbolTable.toString() + "\n";
        st += "Ambit table:" + ambitsTable.toString() + "\n";
        st += "Expansion table:" + expansionTable.toString() + "\n";
        return st;
    }

    // private class to simplify entry to expansion table.
    private class tableEntry {
        String variable;
        SymbolDescription desc;

        public tableEntry(String variable, SymbolDescription desc){
            this.variable = variable;
            this.desc = desc;
        }

        @Override
        public String toString(){
            String te = "Variable: " + variable + "\n";
            te += "Description: " + desc + "\n";
            return te;
        }
    }
}
