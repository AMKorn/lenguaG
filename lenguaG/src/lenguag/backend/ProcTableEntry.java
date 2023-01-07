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

    public void prepareForMachineCode(){
        calculateDisplacements();
        cleanVariables();
    }

    private void calculateDisplacements(){
        int paramDisplacement = 8; // We reserve space for DISP and BP
        int localVarDisplacement = -4;
        VarTableEntry vte;
        if(tReturn != null){
            vte = variableTable.get("0" + tReturn);
            vte.displacement = paramDisplacement;
            paramDisplacement += vte.getOccupation();
        }
        for (String s : variableTable.keySet()) {
            vte = variableTable.get(s);
            if(s.startsWith("-")){
                // It's a parameter
                if(vte.getOccupation() == Constants.UNKNOWN) {
                    
                } else {
                    vte.displacement = paramDisplacement;
                    paramDisplacement += vte.getOccupation();
                }
            } else {
                vte.displacement = localVarDisplacement;
                localVarDisplacement -= vte.getOccupation();
            }
        }
    }

    private void cleanVariables(){
        Hashtable<String, VarTableEntry> cleanVariableTable = new Hashtable<>();
        for (String s : variableTable.keySet()) {
            VarTableEntry vte = variableTable.get(s);
            cleanVariableTable.put(vte.tName, vte);
        }
        variableTable = cleanVariableTable;
    }

    @Override
    public String toString(){
        return "[depth: " + depth + ", eStart: " + eStart + ", numParams: " + numParams + ", varsOccup: " + getVarsOccupation() + "]";
    }
}
