package listfile;

import java.io.*;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ListFile  {
    
//    ListFile2 lf2 = new ListFile2();
//    ListFile lf = new ListFile();
//    CopyFile cf = new CopyFile();

    public ListFile(){
       
    }
    
    public static void main(String[] args) throws IOException{
        
        int input2, input, input3;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pilih metode yang diinginkan: ");
        System.out.println("1. Download");
        System.out.println("2. Upload");
        System.out.println("\nInput: "); 
        
        input2 = scanner.nextInt();
        String namapath;
        if (input2 == 1){
            namapath = "C:\\Users\\DELL\\Desktop\\a";
        }else{
            namapath = "C:\\Users\\DELL\\Desktop\\b";
        }
        
        System.out.println("\nPilih file yang diinginkan: ");
        
        //simpan file nya kedalam hashmap
        HashMap<Integer, String> directory = new HashMap<Integer, String>();
        int i=1;
        File curDir = new File(namapath);
        for(File f : curDir.listFiles()){
            if(f.isDirectory()){
                directory.put(i, f.getName());
                System.out.println(i + " " + f.getName());
                i++;
            }
            if(f.isFile()){
                directory.put(i, f.getName());
                System.out.println(i + " " + f.getName());
                i++;
            }
        }
        
        //input pilihan file
        System.out.println("\nInput: " ); 
        input = scanner.nextInt();
        System.out.println("Pilihan anda adalah: " + directory.get(input));
        
        //cari path dari file yang dipilih
        int counter = 0;
        Path source = path(directory.get(input), counter);counter++;
        Path dest = path(directory.get(input), counter);
        
        //normalisasi path
        String source2 = ListFile.normalise(source);
        String dest2 = ListFile.normalise(dest);
    
        System.out.println("\nPilih metode pemindahan:");
        System.out.println("1. Copy");
        System.out.println("2. Move");
        System.out.println("\nInput: " ); 
        input3 = scanner.nextInt();
        
        if (input2 == 1 && input3 == 1){
            CopyFile.newfile(directory.get(input), input2);
            CopyFile.copyfile(source, dest);
            System.out.println("File " + directory.get(input) + " is successfully copied");
        }else if (input2 == 1 && input3 == 2){
            MoveFile.movefile(source, dest);
            System.out.println("File " + directory.get(input) + " is successfully moved");
        }else if (input2 == 2 && input3 == 1){
            CopyFile.newfile(directory.get(input), input2);
            CopyFile.copyfile(dest, source);
            System.out.println("File " + directory.get(input) + " is successfully copied");
        }else if (input2 == 2 && input3 == 2){
            MoveFile.movefile(dest, source);
            System.out.println("File " + directory.get(input) + " is successfully moved");
        }
        
    }
    
    public static Path path(String path, int count){
        String s = "C:\\Users\\DELL\\Desktop\\";
        if (count == 0){
            s = s.concat("a\\");
        }else{
            s = s.concat("b\\");
        }
        s = s.concat(path);
        Path output = Paths.get(s);
//        System.out.println(s);
        return output;
    }
    
    public static String normalise(Path path){
        //NORMALIZE PATH TO STRING
        String output = path.normalize().toString();
        return output;
    }
}
