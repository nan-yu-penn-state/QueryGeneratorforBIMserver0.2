/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nan Yu
 */
public class Global {
    public static List<String> mvdInputFileNameList = new ArrayList();//所有待生成query的mvd的文件名
    public static List<String> jsonInputFileNameList = new ArrayList();//所有待生成query的json的文件名
    public static List<String> osmInputFileNameList = new ArrayList();//所有待生成query的osm的文件名
    public static String inputFolderPath;   //查询条件的所在文件夹
    public static String outputFolderPath;  //所有待生成query的文件夹
    
    //Based on Yufei's code, not modified yet
    public static List<MVDEntity> entity_inheritance_list =null;    
//    public static List<String> list_of_java_filenames=new ArrayList();  
    public static List<String> list_of_query_code_of_building_element=new ArrayList(); //用到了，在JavaFileWriter中初始化
    public static List<String> list_of_query_code_of_IfcSpace=new ArrayList(); //用到了，在JavaFileWriter中被初始化
    public static List<String> list_of_IfcBuildingElement=null; //用到了，在JavaFileWriter中初始化
    public static List<String> list_of_IfcDistributionElement=null;//用到了，在JavaFileWriter中初始化
    public static List<String> list_of_query_code_of_distribution_element=new ArrayList();//用到了，在JavaFileWriter中被初始化
//    public static String queryJavaCode="empty java code";//用于存放输出的目录
}
