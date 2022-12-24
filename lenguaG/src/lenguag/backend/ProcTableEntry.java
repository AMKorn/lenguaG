package lenguag.backend;

public class ProcTableEntry {
    public int depth;
    public String eStart;
    public int numParams;
    public int localVarsOccup;

    public ProcTableEntry(){
        // default values
        depth = 1;
        numParams = 0;
    }

    @Override
    public String toString(){
        return "[depth: " + depth + ", eStart: " + eStart + ", numParams: " + numParams + ", occup: " + localVarsOccup + "]";
    }
}
