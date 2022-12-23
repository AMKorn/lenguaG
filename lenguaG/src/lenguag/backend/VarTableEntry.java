package lenguag.backend;

import lenguag.Constants;

public class VarTableEntry {
    public String tName;
    public int occupation;
    public int displacement;
    public int subyacentType;

    public VarTableEntry(String tName){
        this.tName = tName;
        subyacentType = Constants.TYPE_INTEGER;
    }
}
