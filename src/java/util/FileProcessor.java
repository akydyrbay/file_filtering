package util;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileProcessor {
    public static void createFolder(String folderpath) {
        File folder = new File(folderpath);

        if(!folder.exists()){
            folder.mkdir();
        }else{
            throw new IllegalArgumentException("Not a directory");
        }
    }

    public static void createFile(String filepath) {
        File obj = new File(filepath);

        try{
            obj.createNewFile();
        } catch(IOException e){
            System.err.println("error: "+e.getMessage());
        }
    }

    public static void writeFile(String filepath, String[] lines, boolean flagA) {
        File file = new File(filepath);
        boolean fileHasContent = file.exists() && file.length() > 0;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath, flagA))){
            if(flagA && fileHasContent) writer.newLine();
            for (int i = 0; i < lines.length; i++) {
                writer.write(lines[i]);
                if (i < lines.length - 1) {
                    writer.newLine();  
                }
            }
        } catch(IOException e){
            System.err.println("error: "+e.getMessage());
        }
    }
    
    public static ArrayList<String> readFile(String filepath) {
        ArrayList<String> lines = new ArrayList<>();

        try (Scanner reader = new Scanner(new File(filepath))) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error while reading the file:");
            System.err.println("error: "+e.getMessage());
        }

        return lines;
    }
}
