package com.example.demo.base;

import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;

import java.io.*;
import java.util.logging.FileHandler;

public class ZipUtil {

    /**
     * 判断是否是zip文件
     * @param fileNme
     * @return
     */
    private static boolean isZip(String fileNme) {
        boolean flag = false;
        if (fileNme != null) {
            if (fileNme.endsWith(".zip") || fileNme.endsWith(".ZIP")) {
                flag = true;
            }
        }
        return flag;
    }

    private static void decompressZip(String inputFile, String outputFile){
        File file = new File(inputFile);
        if (file.exists()){
            InputStream in = null;
            ArchiveInputStream s = null;
            try {
                in = new FileInputStream(file);
                s =  new ArchiveStreamFactory().createArchiveInputStream("zip",in);
                ArchiveEntry entry = null;
                while ((entry = s.getNextEntry()) != null){
                    String fileName = entry.getName();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (ArchiveException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
