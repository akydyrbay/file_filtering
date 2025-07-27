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
    public static void deleteFolder(String folderpath) {
        File folder = new File(folderpath);

        if(folder.exists()){
            for (File file:folder.listFiles()){
                file.delete();
            }
            folder.delete();
            System.out.println("Folder deleted:" + folderpath);
        }
    }
    public static void createFile(String filepath) {
        File obj = new File(filepath);

        try{
            if(obj.createNewFile()){
                System.out.println("Folder created:" + obj);
            }else{
                System.out.println("File already exists");
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void writeFile(String filepath, String[] lines) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))){
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
                System.err.println(line); // Optional: remove if you don't want to print
            }

            reader.close();
        } catch (FileNotFoundException e) {
            System.err.println("Error while reading the file:");
            e.printStackTrace();
        }

        return lines.toArray(new String[0]);
    }

    public static void renameFile(String oldpath, String newpath) {
        File oldfile = new File(oldpath);
        File newfile = new File(newpath);
        if(oldfile.renameTo(newfile)){
            System.err.println("file renamed");
        }else{
            System.err.println("cannot be renamed");
        }
    }
    public static void deleteFile(String filepath) {
        File obj = new File(filepath);
        if (obj.delete()){
            System.err.println("deleted"+obj.getName());
        }else{
            System.err.println("failed todeleted"+obj.getName());
        }
       
    }
}
