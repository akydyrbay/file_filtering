package util;

public class FileStats{
    public static void PrintStats(OptionsCMD opts, FileContent c){
        String[] intRes = statInt(c.ints.toArray(new String[0]));
        String[] floatRes = statFloat(c.floats.toArray(new String[0]));
        String[] stringRes = statString(c.strings.toArray(new String[0]));

        int intNum = c.ints.toArray(new String[0]).length;
        int floatNum = c.floats.toArray(new String[0]).length;
        int stringNum = c.strings.toArray(new String[0]).length;

        if(opts.flagS){
            System.out.println("Num Of Ints: "+intNum);
            System.out.println("Num Of Floats: "+floatNum);
            System.out.println("Num Of Strings: "+stringNum);
        }

        if (opts.flagF){
            System.out.println("Num Of Ints: "+intNum);
            for(String i : intRes){
                System.out.println(i);
            }

            System.out.println("Num Of Floats: "+floatNum);
            for(String f : floatRes){
                System.out.println(f);
            }

            System.out.println("Num Of Strings: "+stringNum);
            for(String s : stringRes){
                System.out.println(s);
            }
        }
    }
    
    public static String[] statInt (String[] ints) {
        if (ints == null || ints.length == 0){
            return new String[]{"no ints"};
        }
        long[] nums = new long[ints.length];
        for (int i = 0; i < ints.length; i++) {
            nums[i]= Long.parseLong(ints[i]);
        }

        long min = nums[0];
        long max = nums[0];
        double sum = 0;

        for(long num : nums){
            if (num<min) min = num;
            if (num>max) max = num;
            sum+=num;
        }

        double avg = sum/nums.length;

        return new String[]{
            "Min Int: " + min,
            "Max Int: " + max,
            "Sum Int: " + sum,
            "Average Int: " + avg
        };
    }
    public static String[] statFloat (String[] floats) {
        if (floats == null || floats.length == 0){
            return new String[]{"no ints"};
        }
        float[] nums = new float[floats.length];
        for (int i = 0; i < floats.length; i++) {
            nums[i]= Float.parseFloat(floats[i]);
        }

        float min = nums[0];
        float max = nums[0];
        double sum = 0;

        for(float num : nums){
            if (num<min) min = num;
            if (num>max) max = num;
            sum+=num;
        }

        double avg = sum/nums.length;

        return new String[]{
            "Min Float: " + min,
            "Max Float: " + max,
            "Sum Float: " + sum,
            "Average Float: " + avg
        };
    }
    public static String[] statString (String[] strings) {
        if (strings == null || strings.length == 0){
            return new String[]{"no ints"};
        }

        int min = strings[0].length();
        int max = strings[0].length();
        

        for(String str : strings){
            if (str.length()<min) min = str.length();
            if (str.length()>max) max = str.length();
        }

        return new String[]{
            "Min Str: " + min,
            "Max Str: " + max,
        };
    }
}