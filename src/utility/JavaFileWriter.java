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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yzj107
 */
public class JavaFileWriter {
    
    public JavaFileWriter(){
        Global.list_of_query_code_of_building_element=new ArrayList();
        Global.list_of_query_code_of_IfcSpace=new ArrayList();
    }
    
    public void writeFile(String folderPath, String fileName){
        
        //初始化list_of_buildingElement，可以改成文件读取
        Global.list_of_IfcBuildingElement=new ArrayList();
        Global.list_of_IfcBuildingElement.add("IfcBuildingElementProxy");
        Global.list_of_IfcBuildingElement.add("IfcCovering");
        Global.list_of_IfcBuildingElement.add("IfcBeam");
        Global.list_of_IfcBuildingElement.add("IfcColumn");
        Global.list_of_IfcBuildingElement.add("IfcCurtainWall");
        Global.list_of_IfcBuildingElement.add("IfcDoor");
        Global.list_of_IfcBuildingElement.add("IfcMember");
        Global.list_of_IfcBuildingElement.add("IfcRailing");
        Global.list_of_IfcBuildingElement.add("IfcRamp");
        Global.list_of_IfcBuildingElement.add("IfcRampFlight");
        Global.list_of_IfcBuildingElement.add("IfcWall");
        Global.list_of_IfcBuildingElement.add("IfcSlab");
        Global.list_of_IfcBuildingElement.add("IfcStairFlight");
        Global.list_of_IfcBuildingElement.add("IfcWindow");
        Global.list_of_IfcBuildingElement.add("IfcStair");
        Global.list_of_IfcBuildingElement.add("IfcRoof");
        Global.list_of_IfcBuildingElement.add("IfcPile");
        Global.list_of_IfcBuildingElement.add("IfcFooting");
        Global.list_of_IfcBuildingElement.add("IfcBuildingElementComponent");
        Global.list_of_IfcBuildingElement.add("IfcPlate");
            
        Global.list_of_IfcDistributionElement=new ArrayList();
        Global.list_of_IfcDistributionElement.add("IfcFlowFitting");
        Global.list_of_IfcDistributionElement.add("IfcFlowSegment");
        Global.list_of_IfcDistributionElement.add("IfcFlowController");
        Global.list_of_IfcDistributionElement.add("IfcFlowTerminal");
        Global.list_of_IfcDistributionElement.add("IfcFlowMovingDevice");
        Global.list_of_IfcDistributionElement.add("IfcEnergyConversionDevice");
        Global.list_of_IfcDistributionElement.add("IfcFlowStorageDevice");
        Global.list_of_IfcDistributionElement.add("IfcFlowTreatmentDevice");
        Global.list_of_IfcDistributionElement.add("IfcDistributionChamberElement");
        
        //如果是IfcBuildingElement的一部分，我们就用另一种方法去生成（.class法）
        
        Global.list_of_query_code_of_building_element = new ArrayList();
        Global.list_of_query_code_of_IfcSpace=new ArrayList();
        Global.list_of_query_code_of_distribution_element=new ArrayList();

        //如果要switch,那么就在这里switch
        choose_a_content_maker_to_write(folderPath, fileName);
    }
    
    public void writeGeoExtrctCode(String folderPath, String fileName){
        List<String> list_of_query_code=new ArrayList();
        fileReader("src\\resources\\GeometricInfo.txt",list_of_query_code);
        createFile(folderPath, fileName, list_of_query_code);
    }
    
    public void writeJSONCode(String folderPath, String fileName){
        List<String> list_of_query_code=new ArrayList();
        fileReader("src\\resources\\CONTAMGenerator.txt",list_of_query_code);
        createFile(folderPath, fileName, list_of_query_code);
    }
    
    void choose_a_content_maker_to_write(String folderPath, String fileName) {
        if(fileName.equals("IfcSpace")){
            fileReader("src\\resources\\IfcSpaceCode.txt",Global.list_of_query_code_of_IfcSpace );
            createFile(folderPath, fileName, Global.list_of_query_code_of_IfcSpace);
        }
        if(Global.list_of_IfcBuildingElement.contains(fileName)){
            fileReader("src\\resources\\IfcBuildingElementPreparation.txt",Global.list_of_query_code_of_building_element);
            BuildingElementContentMaker(fileName);
            fileReader("src\\resources\\IfcBuildingElementSecondHalf.txt",Global.list_of_query_code_of_building_element);
            createFile(folderPath, fileName, Global.list_of_query_code_of_building_element);
        }
        if(Global.list_of_IfcDistributionElement.contains(fileName)){
            fileReader("src\\resources\\DistributionElementPreparation.txt",Global.list_of_query_code_of_distribution_element);
            DistributionElementContentMaker(fileName);
            fileReader("src\\resources\\DistributionElementSecondHalf.txt", Global.list_of_query_code_of_distribution_element);
            createFile(folderPath, fileName, Global.list_of_query_code_of_distribution_element);
        }    
    }
    
    public void createFile(String folderPath, String fileName, List<String> list){
        File java_query_file = new File(folderPath + "//" + fileName + ".java");//我的输出
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(java_query_file, false)); //此处true为追加
            for (String str: list) {
                bw.write(str+"\n");
            }
            bw.close();
        } catch (IOException ex) {
            System.out.println("IOException ex");
        }
    }
    
    public void fileReader(String filePathAndName, List<String> list) {
        File file = new File(filePathAndName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                list.add(tempString);
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
    }
    
    public void DistributionElementContentMaker(String str){
        String instance=str;
        
        Global.list_of_query_code_of_distribution_element.add("        List<"+instance+"> list_of_instance = model.getAll("+instance+".class);");
        Global.list_of_query_code_of_distribution_element.add("        for ("+instance+" instance : list_of_instance) {");
        
    }
    
    public void BuildingElementContentMaker(String str){
        String instance=str;
        Global.list_of_query_code_of_building_element.add("                        if (product instanceof "+instance+") {");
        Global.list_of_query_code_of_building_element.add("                            "+instance+" "+instance+"instance=("+instance+") product;");
        Global.list_of_query_code_of_building_element.add("                                out.println("+instance+"instance.getName());");
        Global.list_of_query_code_of_building_element.add("                            List<IfcRelDefines> list_defines = "+instance+"instance.getIsDefinedBy();");
    }
}
