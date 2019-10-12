package com.example.demo.base.Tar;

import java.io.*;
import java.util.zip.GZIPInputStream;

public class Z {

        /**
         * 3 * 解压tar.gz 文件 4 * @param file 要解压的tar.gz文件对象 5 * @param outputDir
         * 要解压到某个指定的目录下 6 * @throws IOException 7
         */
//        public static void unTarGz(File file, String outputDir) throws IOException {
//           // TarInputStream tarIn = null;
//            try {
//               // tarIn = new TarInputStream(new GZIPInputStream(new BufferedInputStream(new FileInputStream(file))),
//                        1024 * 2);
//
//               // createDirectory(outputDir, null);// 创建输出目录
//
//               // TarEntry entry = null;
//               // while ((entry = tarIn.getNextEntry()) != null) {
//
//                   // if (entry.isDirectory()) {// 是目录
//                        entry.getName();
//                        createDirectory(outputDir, entry.getName());// 创建空目录
//                    } else {// 是文件
//                        File tmpFile = new File(outputDir + "/" + entry.getName());
//                        createDirectory(tmpFile.getParent() + "/", null);// 创建输出目录
//                        OutputStream out = null;
//                        try {
//                            out = new FileOutputStream(tmpFile);
//                            int length = 0;
//
//                            byte[] b = new byte[2048];
//
//                            while ((length = tarIn.read(b)) != -1) {
//                                out.write(b, 0, length);
//                            }
//
//                        } catch (IOException ex) {
//                            throw ex;
//                        } finally {
//
//                            if (out != null)
//                                out.close();
//                        }
//                    }
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                try {
//                    if (tarIn != null) {
//                        tarIn.close();
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//        /**
//         * 构建目录
//         *
//         * @param outputDir
//         * @param subDir
//         */
//        public  void createDirectory(String outputDir, String subDir) {
//            File file = new File(outputDir);
//            if (!(subDir == null || subDir.trim().equals(""))) {// 子目录不为空
//                file = new File(outputDir + "/" + subDir);
//            }
//            if (!file.exists()) {
//                if (!file.getParentFile().exists())
//                    file.getParentFile().mkdirs();
//                file.mkdirs();
//            }
//        }
//    }
}
