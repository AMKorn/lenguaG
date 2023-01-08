package lenguag.backend;

import java.util.ArrayList;
import java.util.Hashtable;

import lenguag.Constants;

public class ProcTableEntry {
    public int depth;
    public String eStart;
    public int numParams;
    // private int localVarsOccup;
    // public String tReturn;
    public ArrayList<String> params; // Arraylist to have the parameters in order
    public Hashtable<String, VarTableEntry> variableTable;

    public ProcTableEntry(){
        // default values
        depth = 1;
        numParams = 0;
        variableTable = new Hashtable<>();
        params = new ArrayList<>();
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
        cleanVariables();
        calculateDisplacements();
    }

    private void calculateDisplacements(){
        VarTableEntry vte;
        // if(tReturn != null){
        //     vte = variableTable.get("0" + tReturn);
        //     vte.displacement = paramDisplacement;
        //     paramDisplacement += vte.getOccupation();
        // }

        // We calculate the displacements of the parameters. They are positive.
        int paramDisplacement = Constants.REGISTER_SIZE * 2; // We reserve space for DISP and BP and for the return
        for(String s : params){
            vte = variableTable.get(s);
            vte.displacement = paramDisplacement;
            paramDisplacement += Constants.REGISTER_SIZE;
        }

        int localVarDisplacement = 0;
        for (String s : variableTable.keySet()) {
            vte = variableTable.get(s);
            if(vte.displacement == 0 && vte.getOccupation() != Constants.UNKNOWN){
                localVarDisplacement -= vte.getOccupation();
                vte.displacement = localVarDisplacement;
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
