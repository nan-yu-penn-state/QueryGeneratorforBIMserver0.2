/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Nan Yu
 */
public class FileOperator {
    public boolean isFileExist(String filePath){
        File file = new File(filePath);
        return file.exists();
    }
    
    public boolean isFolderEmpty(String filePath){
        File file = new File(filePath);
        if(file.isDirectory() && file.listFiles().length <= 0){
            return true;
        }
        return false;
    }
    
    public boolean isFolder(String filePath){
        File file = new File(filePath);
        return file.isDirectory();
    }
    
    public boolean isValidFolder(String filePath){
        File file = new File(filePath);
        if(!file.exists()){
            return file.mkdir();
        }
        return true;
    }
    
    public void getInputFileNameList(String strPath) {
        File dir = new File(strPath);
        File[] files = dir.listFiles();
        if(files == null) {
            return;
        }
        
        for(File file : files){
            if(file.isDirectory()) {
                getInputFileNameList(file.getAbsolutePath());
            }
            else{
                String fileName = file.getName().toLowerCase();
                if(fileName.endsWith(".mvd")) {
                    Global.mvdInputFileNameList.add(file.getName());
                }
                else if(fileName.endsWith(".json")){
                    Global.jsonInputFileNameList.add(file.getName());   
                }
                else if(fileName.endsWith(".osm")){
                    Global.osmInputFileNameList.add(file.getName());
                }
            }
        }
    }
    
    public String readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuffer sb = new StringBuffer();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                sb.append(tempString);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
       
        return sb.toString();
    }
    
    public void writeFile(String folder, String fileName, String content){
        File finalResult = new File(folder+"\\" + fileName);
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(finalResult, false)); 
            bw.write(content);
            bw.close();
        } catch (IOException ex) {
            System.out.println("IOException ex");
        }
    }
    
    public String getTempFolder(){
        String tempPath = "";
        Properties property = System.getProperties();    
        String osName = property.getProperty("os.name");  
        if(osName.equalsIgnoreCase("Linux")){
            tempPath = "/tmp/BIM/CONTAM/jsons/";
        }
        else if (osName.startsWith("Windows")) {
            tempPath = "C:\\tmp\\BIM\\CONTAM\\jsons\\";
        }
        return tempPath;
    }
}
