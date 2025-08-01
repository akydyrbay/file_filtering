package util;

import java.util.ArrayList;
import java.util.List;

public class FileContent{
    public ArrayList<String> ints = new ArrayList<>();
    public ArrayList<String> floats = new ArrayList<>();
    public ArrayList<String> strings = new ArrayList<>();
        
    public String[] lines = {};

    public static FileContent ReadContent(OptionsCMD opts){
        FileContent c = new FileContent();
        String[] inputFiles = opts.inpath.toArray(String[]::new);
        List<String> allLines = new ArrayList<>();
        for (String filepath : inputFiles) {
            ArrayList<String> lines = FileProcessor.readFile(filepath);
            allLines.addAll(lines);
        }
        if(allLines.isEmpty()){
            throw new IllegalArgumentException("All the files are empty or not exists");
        }
        c.lines = allLines.toArray(String[]::new);
        
        for (String line : c.lines){
            if (line == null || line.trim().isEmpty()) {
                continue;
            }
            if (isInt(line)){
                c.ints.add(line);
            } else if(isFloat(line)){
                c.floats.add(line);
            }else{
                c.strings.add(line);
            }
        }
        return c;
    }
   
    public static boolean isInt(String line) {
        if (line == null || line.isEmpty()) return false;
        try {
            long _ = Long.parseLong(line);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static boolean isFloat(String line) {
        if(line == null || line.isEmpty())return false;
        try {
            float _ = Float.parseFloat(line);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}