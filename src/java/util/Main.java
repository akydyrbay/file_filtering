package util;

public class Main {
    public static void main(String[] args) {
        OptionsCMD opts = OptionsCMD.parserCMD(args);

        FilePaths p = FilePaths.BuildPath(opts);

        FileProcessor.createFile(p.intpath);
        FileProcessor.createFile(p.floatpath);
        FileProcessor.createFile(p.stringpath);

        FileContent c = FileContent.ReadContent(opts);
        
        FileStats.PrintStats(opts, c);
        
        FileProcessor.writeFile(p.intpath, c.ints.toArray(String[]::new), opts.flagA);
        FileProcessor.writeFile(p.floatpath, c.floats.toArray(String[]::new), opts.flagA);
        FileProcessor.writeFile(p.stringpath, c.strings.toArray(String[]::new), opts.flagA);
    }
}
