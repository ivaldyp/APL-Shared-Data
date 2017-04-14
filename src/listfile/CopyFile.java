package listfile;

import java.io.*;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class CopyFile {
    
    public static void newfile(String filename, int input) throws IOException{
        String s;
        if (input == 1){
            s = "C:\\Users\\DELL\\Desktop\\b\\";
        }else{
            s = "C:\\Users\\DELL\\Desktop\\a\\";
        }
        s = s.concat(filename);
        File file = new File(s);
        file.createNewFile();
    }

    public static void copyfile(Path source, Path dest) throws IOException{
        CopyOption[] option = new CopyOption[]{
            StandardCopyOption.REPLACE_EXISTING
        };
        Files.copy(source, dest, option);
    }
    
}
