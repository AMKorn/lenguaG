package lenguag.backend;

import java.util.ArrayList;

import lenguag.Constants;

public class VarTableEntry {
    public String tName;
    public int occupation;
    public int displacement;
    public int type;
    public int subyacentType;
    public ArrayList<String> dimensions;

    public VarTableEntry(String tName){
        this.tName = tName;
        type = Constants.TYPE_INTEGER;
        subyacentType = Constants.TYPE_INTEGER;
        dimensions = new ArrayList<>();
    }

    public ArrayList<String> cloneDimensions(){
        ArrayList<String> i = new ArrayList<>();
        for (String d : dimensions) {
            i.add(d);
        }
        return i;
    }
}
