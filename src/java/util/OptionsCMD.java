package util;

public class OptionsCMD {
    public boolean flagO = false;
    public boolean flagP = false;
    public boolean flagA = false;
    public boolean flagS = false;
    public boolean flagF = false;
    public boolean flagIn1 = false;
    public boolean flagIn2 = false;

    public String in1path = "";
    public String in2path = "";
    public String oPath = "";
    public String pPath = "";
    
    public static OptionsCMD parserCMD(String[] args) {
        OptionsCMD opt = new OptionsCMD();
        FileProcessor f = new FileProcessor();
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-o":
                    if(i+1<args.length){
                        opt.flagO = true;
                        f.createFolder(args[i+1]);
                        opt.oPath = args[i+1]+"/";
                    }else {
                        throw new IllegalArgumentException("-o requires a value");
                    }
                    break;
                case "-p":
                    if(i+1<args.length){
                        opt.flagP = true;
                        opt.pPath = args[i+1];
                    }else{
                        throw new IllegalArgumentException("-p requires a value");
                    }
                    break;
                case "-a":
                    opt.flagA = true;
                    break;
                case "-s":
                    opt.flagS = true;
                    break;
                case "-f":
                    opt.flagF = true;
                    break;
                case "in1.txt":
                    opt.flagIn1 = true;
                    opt.in1path = "inputFiles/in1.txt";
                    break;
                case "in2.txt":
                    opt.flagIn2 = true;
                    opt.in2path = "inputFiles/in2.txt";
                    break;
            }
        }
        return opt;
    }
}
