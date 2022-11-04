package lenguag;

import java.io.*;

public class WriteFile {
    private String file;
    private FileWriter out;

    public WriteFile(String file) {
        this.file = file;
        out = new FileWriter(file);
    }

    public void write(){

    }
}
