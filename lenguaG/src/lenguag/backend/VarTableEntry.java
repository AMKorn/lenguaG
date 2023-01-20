package lenguag.backend;

import java.util.ArrayList;

import lenguag.Constants;

public class VarTableEntry {
    public String tName;
    public int displacement;
    public int type;
    public int subyacentType;
    public ArrayList<String> dimensions;
    public String initialValue = "0";

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

    public int getOccupation(){
        int occupation;
        if(type == Constants.TYPE_INTEGER){
            occupation = Constants.INTEGER_BYTES;
        }
        else occupation = Constants.CHAR_BYTES;
        for (String s : dimensions) {
            try {
                occupation *= Integer.parseInt(s);
            } catch (NumberFormatException e){
                occupation = Constants.UNKNOWN;
            }
        }
        return occupation;
    }

    @Override
    public String toString(){
        String s = "[var: " + tName + ", occup: " + getOccupation() + ", disp: " + displacement + ", type: " + Constants.getTypeName(type);
        for (String d : dimensions) {
            s += "[" + d + "]";
        }
        s += ", tsb: " + Constants.getTypeName(subyacentType) + "]";
        return s;
    }
}
