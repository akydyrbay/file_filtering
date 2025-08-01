package util;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Error no arguments");
            System.exit(1);
        }
        try{
            OptionsCMD opts = OptionsCMD.parserCMD(args);

            FilePaths p = FilePaths.BuildPath(opts);

            FileContent c = FileContent.ReadContent(opts);

            FileProcessor.createFile(p.intpath);
            FileProcessor.createFile(p.floatpath);
            FileProcessor.createFile(p.stringpath);
            
            FileStats.PrintStats(opts, c);
            
            FileProcessor.writeFile(p.intpath, c.ints.toArray(String[]::new), opts.flagA);
            FileProcessor.writeFile(p.floatpath, c.floats.toArray(String[]::new), opts.flagA);
            FileProcessor.writeFile(p.stringpath, c.strings.toArray(String[]::new), opts.flagA);
        }catch (IllegalArgumentException e) {
            System.err.println("error: " + e.getMessage());
            System.exit(1);
        }
    }
}
