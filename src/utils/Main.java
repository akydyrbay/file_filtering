import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        FileProcessor f = new FileProcessor();

        String in1path = "inFiles/"+args[0];
        String in2path = "inFiles/"+args[1];

        String intpath = "outFiles/integers.txt";
        String floatpath = "outFiles/floats.txt";
        String stringpath = "outFiles/strings.txt";
        
        f.createFile(intpath);
        f.createFile(floatpath);
        f.createFile(stringpath);

        ArrayList<String> ints = new ArrayList<>();
        ArrayList<String> floats = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();
        
        String[] in1 = f.readFile(in1path);
        String[] in2 = f.readFile(in2path);
        String[] lines = new String[in1.length+in2.length];

        System.arraycopy(in1, 0, lines, 0, in1.length);
        System.arraycopy(in2, 0, lines, in1.length, in2.length);
        
        for (String line : lines){
            if (isInt(line)){
                ints.add(line);
            } else if(isFloat(line)){
                floats.add(line);
            }else if(line instanceof String){
                strings.add(line);
            }else{
                System.err.println("not the required type");
            }
        }

        f.writeFile(intpath, ints.toArray(new String[0]));
        f.writeFile(floatpath, floats.toArray(new String[0]));
        f.writeFile(stringpath, strings.toArray(new String[0]));
    }

    public static boolean isInt(String line) {
        if(line == null || line.isEmpty()){
            return false;
        }
        try {
            Integer.parseInt(line);
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
            Float.parseFloat(line);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
