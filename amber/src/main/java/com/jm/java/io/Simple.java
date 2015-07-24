package com.jm.java.io;

import java.io.*;
import java.net.URL;

/**
 * This is Project project_book
 * Created by jmwmj
 * On 2015/7/24
 * At 11:00
 */
public class Simple {
    static final String projectPath = "F:\\workspaces\\github\\project_book";
    static final String projectResourcesPath = "amber/src/main/resources";

    public File createFileInResourcePath(String directory ,String fileName) throws FileNotFoundException {
        File newFile;
        File root = new File(projectPath, projectResourcesPath);
        System.out.println(root.getPath());
        if(!root.exists()){
            throw new FileNotFoundException("the resource directory is not exist!");
        }
        if(directory==null){
            File defaultPkg = new File(root,"file");
            if(!defaultPkg.exists()){
                defaultPkg.mkdir();
            }

            newFile = new File(defaultPkg ,fileName);
        }else{
            File newDirectory = new File(root,directory);
            if(!newDirectory.exists()){
               newDirectory.mkdir();
            }
            newFile = new File(newDirectory ,fileName);
        }
        try {
            if(newFile.exists()){
                return newFile;
            }
            System.out.println(newFile.getPath());
            newFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newFile;
    }

    public File createFileInResourcePath(String fileName) throws FileNotFoundException {
        return createFileInResourcePath(null,fileName);
    }

    public void cleanTestFiles(){
        File resources = new File(projectPath,projectResourcesPath);
        //System.out.println(resources.getName());
        delFiles(resources);
    }

    private void delFiles(File dirctory){
        if(!dirctory.exists()){
            return;
        }
        for (File f: dirctory.listFiles()){
            if(f.isDirectory()){
                delFiles(f);
            }else{
                f.delete();
            }
        }
        if(!dirctory.getName().equals("resources")){
            System.out.println(dirctory.getName());
            dirctory.delete();
        }
    }

    public String createFile(){
        String path = "";
        try {
           //path = Simple.class.getClassLoader().getResource(fileName).toURI().getPath();
            URL filUrl = Simple.class.getClassLoader().getResource("file");
            if(filUrl==null){
                System.out.println("is null");
            }else{
                System.out.println(filUrl.getPath());
                File file = new File(filUrl.getFile());
                System.out.println(file.exists());
                new File(file,"text2.txt").createNewFile();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return path;
    }

    public void readTxt(){
        File file2 = null;
        FileInputStream fis = null;

        try {
            file2 = createFileInResourcePath("file2.txt");
            System.out.println(file2.getName());
            fis = new FileInputStream(file2);
            byte[] bytes = new byte[100];
            //int b = fis.read();
            int l=0;
            while((l=fis.read(bytes))!=-1){
                System.out.println("l:" + l);
                StringBuilder sb = new StringBuilder();;
                for(int i=0;i<l;i++){
                    sb.append((char)bytes[i]);
                }
                System.out.print(sb.toString());
            }
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readBuffer(){
        File file2 = null;
        FileInputStream fis = null;
        BufferedReader br = null;
        try {
            file2 = createFileInResourcePath("file2.txt");
            fis = new FileInputStream(file2);
            br = new BufferedReader(new InputStreamReader(fis));

            String line = br.readLine();
            while(line!=null){
                System.out.println(line);
                line = br.readLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
