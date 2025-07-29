package util;

public class Main {
    public static void main(String[] args) {
        OptionsCMD opts = new OptionsCMD();
        opts = opts.parserCMD(args);

        FileProcessor f = new FileProcessor();

        FilePaths p = new FilePaths();
        p = p.BuildPath(opts);

        f.createFile(p.intpath);
        f.createFile(p.floatpath);
        f.createFile(p.stringpath);

        FileContent c = new FileContent();
        c = c.ReadContent(opts);
        
        FileStats s = new FileStats();
        s.PrintStats(opts, c);
        
        f.writeFile(p.intpath, c.ints.toArray(new String[0]), opts.flagA);
        f.writeFile(p.floatpath, c.floats.toArray(new String[0]), opts.flagA);
        f.writeFile(p.stringpath, c.strings.toArray(new String[0]), opts.flagA);
    }
}
