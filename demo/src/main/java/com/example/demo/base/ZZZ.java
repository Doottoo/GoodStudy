package com.example.demo.base;

import org.apache.commons.compress.utils.IOUtils;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZZZ {
    /**
     * 压缩单个文件
     *
     * @param source 源文件
     * @param dest   目的文件
     */
    public static void zipFile(File source, File dest) {
        InputStream inputStream = null;
        ZipOutputStream zipOutputStream = null;
        try {
            inputStream = new FileInputStream(source);
            zipOutputStream = new ZipOutputStream(new FileOutputStream(dest));
            zipOutputStream.putNextEntry(new ZipEntry(source.getName()));
            byte b[] = new byte[1024];
            while (inputStream.read(b) != -1) {
                zipOutputStream.write(b);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                zipOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 压缩多个文件
     *
     * @param dir  源文件目录
     * @param dest 目的文件
     */
    public static void zipFiles(File dir, File dest) {
        if (dir.isDirectory()) {
            zipFiles(dir.listFiles(), dest);
        }
    }

    /**
     * 压缩多个文件
     *
     * @param files 源文件数组
     * @param dest  目的文件
     */
    public static void zipFiles(File[] files, File dest) {
        InputStream inputStream = null;
        ZipOutputStream zipOutputStream = null;
        try {
            zipOutputStream = new ZipOutputStream(new FileOutputStream(dest));
            for (File f : files) {
                inputStream = new FileInputStream(f);
                zipOutputStream.putNextEntry(new ZipEntry(f.getName()));
                byte b[] = new byte[1024];
                while (inputStream.read(b) != -1) {
                    zipOutputStream.write(b);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                zipOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 解压多个文件
     *
     * @param file 待解压文件
     */
    public static void unzipFiles(File file) {
        String path = file.getParent();
        File outFile = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        ZipInputStream zipInputStream = null;
        ZipEntry entry;
        try {
            ZipFile zipFile = new ZipFile(file);
            zipInputStream = new ZipInputStream(new FileInputStream(file));
            while ((entry = zipInputStream.getNextEntry()) != null) {
                outFile = new File(path + File.separator + entry.getName());
                if (!outFile.getParentFile().exists()) {
                    outFile.getParentFile().mkdir();
                }
                if (!outFile.exists()) {
                    outFile.createNewFile();
                }
                inputStream = zipFile.getInputStream(entry);
                outputStream = new FileOutputStream(outFile);
                int temp = 0;
                while ((temp = inputStream.read()) != -1) {
                    outputStream.write(temp);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                outputStream.close();
                zipInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * unzip解压缩
     * <功能详细描述>
     * @param filePath 待解压的文件路径
     * @return 解压后的完整路径的文件名，如果不存在返回null
     * @throws Exception
     * @see [类、类#方法、类#成员]
     */
    public static String unzip(String filePath) throws Exception {
        File file = new File(filePath);
        if (!file.exists()) {
            return null;
        }

        String fullPath = file.getAbsolutePath();
        ZipFile zipFile = new ZipFile(file);
        Enumeration<? extends ZipEntry> zipEntries = zipFile.entries();
        // 遍历ZipEnty
        while (zipEntries.hasMoreElements()) {
            ZipEntry zipEntry = (ZipEntry) zipEntries.nextElement();
            File tmpFile = null;
            if (zipEntry.isDirectory()) {
                tmpFile = new File(fullPath, zipEntry.getName());
                tmpFile.mkdir();
                continue;
            }
            InputStream is = zipFile.getInputStream(zipEntry);
            tmpFile = new File(fullPath, zipEntry.getName());
            if (!tmpFile.getParentFile().exists()) {
                tmpFile.getParentFile().mkdirs();
            }
            FileOutputStream fos = new FileOutputStream(tmpFile);
            IOUtils.copy(is, fos);
            IOUtils.closeQuietly(fos);
        }
        IOUtils.closeQuietly(zipFile);
        return fullPath;
    }
}
