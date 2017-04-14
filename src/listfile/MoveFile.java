package listfile;

import java.io.*;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class MoveFile {

    public static void movefile(Path source, Path dest) throws IOException{
        CopyOption[] option;
        option = new CopyOption[]{
            StandardCopyOption.REPLACE_EXISTING
        };
        Files.move(source, dest, option);
    }
    
}
