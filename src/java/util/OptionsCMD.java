package util;
import java.util.ArrayList;

public class OptionsCMD {
    public boolean flagO = false;
    public boolean flagP = false;
    public boolean flagA = false;
    public boolean flagS = false;
    public boolean flagF = false;
    public boolean flagIn = false;

    public ArrayList<String> inpath = new ArrayList<>();;
    public String oPath = "";
    public String pPath = "";
    
    public static OptionsCMD parserCMD(String[] args) {
        OptionsCMD opt = new OptionsCMD();
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-o" ->{
                    if(i+1<args.length){
                        opt.flagO = true;
                        FileProcessor.createFolder(args[i+1]);
                        opt.oPath = args[i+1]+"/";
                    }else {
                        throw new IllegalArgumentException("-o requires a value");
                    }
                }
                case "-p" ->{
                    if(i+1<args.length){
                        opt.flagP = true;
                        opt.pPath = args[i+1];
                    }else{
                        throw new IllegalArgumentException("-p requires a value");
                    }
                }
                case "-a" -> opt.flagA = true;
                case "-s" -> opt.flagS = true;
                case "-f" -> opt.flagF = true;
                default ->{
                    if (args[i].endsWith(".txt")) {
                        opt.flagIn = true;
                        opt.inpath.add(args[i]);
                    }
                }
            }
        }
        return opt;
    }
}
