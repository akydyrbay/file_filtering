package util;

public class FilePaths{
    public String intpath = "integers.txt";
    public String floatpath = "floats.txt";
    public String stringpath = "strings.txt";

    public static FilePaths BuildPath(OptionsCMD opts){
        if (!opts.flagIn){
            throw new IllegalArgumentException("No input files provided");
        }
        FilePaths p = new FilePaths();
        if (opts.flagO && opts.flagP){
            p.intpath = opts.oPath+opts.pPath+p.intpath;
            p.floatpath = opts.oPath+opts.pPath+p.floatpath;
            p.stringpath = opts.oPath+opts.pPath+p.stringpath;
        }else if(opts.flagO && !opts.flagP){
            p.intpath = opts.oPath+p.intpath;
            p.floatpath = opts.oPath+p.floatpath;
            p.stringpath = opts.oPath+p.stringpath;
        }
        else if(!opts.flagO && opts.flagP){
            p.intpath = opts.pPath+p.intpath;
            p.floatpath = opts.pPath+p.floatpath;
            p.stringpath = opts.pPath+p.stringpath;
        }
        return p;
    }
}