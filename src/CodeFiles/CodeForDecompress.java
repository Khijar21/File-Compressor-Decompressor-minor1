/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;


/**
 *
 * @author VULCUN
 */
public class CodeForDecompress {
    public static void decompressFunction(File file) throws FileNotFoundException, IOException{
        String fileDirectory = file.getParent();
        System.out.println(fileDirectory);
        
        FileInputStream fis = new FileInputStream(file);
        GZIPInputStream gzipIS = new GZIPInputStream(fis);
        FileOutputStream fos = new FileOutputStream(fileDirectory + "/DecompressedFile.txt");
        
        byte[] buffer = new byte[1024];
        int len;
        
        while((len = gzipIS.read(buffer)) != -1){
            fos.write(buffer , 0, len);
        }
        fis.close();
        gzipIS.close();
        fos.close();
        
    }
    public static void main(String[] args)throws FileNotFoundException, IOException{
        File path = new File("C:\\Documents\\NetBeansProjects\\CompressorDecompressorProject\\src\\CodeFiles\\CompressedFile.gz");
        decompressFunction(path);
    }
}
