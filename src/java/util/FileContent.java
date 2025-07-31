package util;

import java.util.ArrayList;

public class FileContent{
    public ArrayList<String> ints = new ArrayList<>();
    public ArrayList<String> floats = new ArrayList<>();
    public ArrayList<String> strings = new ArrayList<>();
        
    public String[] lines = {};
    public String[] in1 = {};
    public String[] in2 = {};

    public static FileContent ReadContent(OptionsCMD opts){
        FileContent c = new FileContent();
        if (opts.flagIn1 && opts.flagIn2) {
            c.in1 = FileProcessor.readFile(opts.in1path);
            c.in2 = FileProcessor.readFile(opts.in2path);
            c.lines = new String[c.in1.length+c.in2.length];

            System.arraycopy(c.in1, 0, c.lines, 0, c.in1.length);
            System.arraycopy(c.in2, 0, c.lines, c.in1.length, c.in2.length);
        }else if(opts.flagIn1 && !opts.flagIn2){
            c.in1 = FileProcessor.readFile(opts.in1path);
            c.lines = c.in1;
        }else if(!opts.flagIn1 && opts.flagIn2){
            c.in2 = FileProcessor.readFile(opts.in2path);
            c.lines = c.in2;
        }
        for (String line : c.lines){
            if (isInt(line) || isLong(line)){
                c.ints.add(line);
            } else if(isFloat(line)){
                c.floats.add(line);
            }else if(line instanceof String){
                c.strings.add(line);
            }else{
                System.err.println("not the required type");
            }
        }
        return c;
    }
    public static boolean isInt(String line) {
        if(line == null || line.isEmpty()){
            return false;
        }
        try {
            int _ = Integer.parseInt(line);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static boolean isLong(String line) {
        if (line == null || line.isEmpty()) return false;
        try {
            long _ = Long.parseLong(line);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static boolean isFloat(String line) {
        if(line == null || line.isEmpty()){
            return false;
        }
        try {
            float _ = Float.parseFloat(line);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}