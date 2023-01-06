package lenguag.backend;

import java.util.Hashtable;

import lenguag.Constants;

public class ProcTableEntry {
    public int depth;
    public String eStart;
    public int numParams;
    // private int localVarsOccup;
    public String tReturn;
    public Hashtable<String, VarTableEntry> variableTable;

    public ProcTableEntry(){
        // default values
        depth = 1;
        numParams = 0;
        variableTable = new Hashtable<>();
    }

    public int getVarsOccupation(){
        int occupation = 0;
        for (VarTableEntry vte : variableTable.values()) {
            int o = vte.getOccupation();
            if(o == Constants.UNKNOWN) return Constants.UNKNOWN;
            occupation += o;
        }
        return occupation;
    }

    @Override
    public String toString(){
        return "[depth: " + depth + ", eStart: " + eStart + ", numParams: " + numParams + ", varsOccup: " + getVarsOccupation() + "]";
    }
}
