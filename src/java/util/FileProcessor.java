package util;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileProcessor {
    public static void createFolder(String folderpath) {
        File folder = new File(folderpath);

        if(!folder.exists()){
            folder.mkdir();
            System.out.println("Folder created:" + folderpath);
        }
    }
    public static boolean checkFolder(String folderpath) {
        File folder = new File(folderpath);

        return folder.exists();
    }
    public static void createFile(String filepath) {
        File obj = new File(filepath);

        try{
            obj.createNewFile();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void writeFile(String filepath, String[] lines, boolean flagA) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath, flagA))){
            for(String line:lines){
                writer.write(line);
                writer.newLine();
            }
        } catch(IOException e){
            System.err.println("error"+e.getMessage());
        }
    }
    
    public static String[] readFile(String filepath) {
        ArrayList<String> lines = new ArrayList<>();

        try {
            File file = new File(filepath);
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                lines.add(line);
            }

            reader.close();
        } catch (FileNotFoundException e) {
            System.err.println("Error while reading the file:");
            e.printStackTrace();
        }

        return lines.toArray(new String[0]);
    }
}
