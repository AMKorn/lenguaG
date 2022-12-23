package lenguag.backend;

import java.util.ArrayList;

import lenguag.Constants;

public class VarTableEntry {
    public String tName;
    public int occupation;
    public int displacement;
    public int type;
    public int subyacentType;
    public ArrayList<Integer> dimensions;

    public VarTableEntry(String tName){
        this.tName = tName;
        type = Constants.TYPE_INTEGER;
        subyacentType = Constants.TYPE_INTEGER;
        dimensions = new ArrayList<>();
    }
}
