/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yufei Jiang
 */
//这个类是MVD(IFC schema)读取器，
//这个类把MVD(IFC schema)脚本进行解析，并且把必要的元素放在相应的链表中。
public class MVDContentReader {
     
    public List<String> line_list;//这个文件的所有内容，以行为单位存储
    private List<String> line_list_for_remove;
    public List<MVDEntity> entity_inheritance_list;
//    private String leaveEntityName;
    
    
    //这个list中每个元素是一个自定义数据类型，每个数据类型存储了一个控件
//    private StringBuffer buf_of_class;
//    List<ArrayList> key_word_of_many_lines=new ArrayList();//这个list的每一个元素是一个list，每一个list是一行的MVD
    


    public MVDContentReader(){
        line_list=new ArrayList();
//        buf_of_class=new StringBuffer();
        this.line_list_for_remove=new ArrayList();
    }

    //把一个EXP文件逐行读入。
    //用一个list来存储一个exp文件的全部内容，
    //这个list的每一个元素是一个String
    //每一个String存储了MVD(IFC Schema)的一行
    //有junit测试
    public void readFileByLines(String fileName) {
        File file = new File(Global.inputFolderPath + "//" + fileName);
        this.line_list=new ArrayList();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                //省去空行，只加有内容的行
                String testString=tempString;
                //trim只省略开头和末尾的空格，这里的用法是正确的
                if (!testString.trim().equals("")) {
                    line_list.add(tempString);
                }
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
    
    
    public String parseContent(){       
        
        
        this.line_list_for_remove=new ArrayList();
        this.entity_inheritance_list=new ArrayList();
        
        //把line_list中的内容照抄到line_list_for_remove中
        for(String str:this.line_list){
            this.line_list_for_remove.add(str);
        }
        
        //第一行的内容就是叶节点的名字
        String leave_name=this.getEntityName(line_list_for_remove.get(0));
        
        //添加到这个链表中，以后用来生成java文件。
        
        line_list_for_remove.remove(0);
        
        MVDEntity anEntity=new MVDEntity();
        boolean isInverse = false;
        
        for(String line:this.line_list_for_remove){
            //如果是entity,就新建一个entity
            //如果不是以entity开始，就把读到的内容加入到这个entity里

            if(line.startsWith("ENTITY")){
                //把遇到下一个entity之前的内容加到这个entity里
                //结束后把这个entity加到这个entity链表里
                isInverse=false;
                anEntity = new MVDEntity();
                entity_inheritance_list.add(anEntity);
                anEntity.leaveEntiyName = leave_name;
                anEntity.entityName=getEntityName(line);
                continue;
            }
            
            if (line.startsWith("INVERSE")) {
                isInverse = true;
                continue;
            }
            
            if (line.startsWith("END_ENTITY")){
                Global.entity_inheritance_list=this.entity_inheritance_list;
                break;
            }

            Attribute attribute = new Attribute();
            attribute = getThisLineAttribute(line);
            
            if(isInverse){
                anEntity.inverseList.add(attribute);
            }else{
                anEntity.attributeList.add(attribute);
            }
            
        }
        //第一个entity标明目标内容
        //第二个entity遇到一个entity，写一个
        return leave_name;
    }
    
    public Attribute getThisLineAttribute(String line){
        Attribute aam = new Attribute();
        String[] no_semicolon_array=new String [0];
        String str=line;
        //String trim_string=str.trim();
        no_semicolon_array=str.split(";");
        String[] two_string=new String[2];
        two_string=no_semicolon_array[0].split(":",2);

        
        aam.attributeName=two_string[0].trim();
        aam.attributeType=two_string[1].trim();
        return aam;
    }
    
    //junit测试通过
    public String getEntityName(String str){
        //如果前面是ENTITY这几个字母
        String[] entity_name=new String[2];
        String[] name=new String[2];
        if(str.startsWith("ENTITY")){
            entity_name=str.split(" ");
        }
        //那么去掉一个空格
        //获得分号之后的内容
        name=entity_name[1].split(";");
        
        return name[0];
    }

    //这一个方法多次调用findKeyWordForOneLine，把这个子方法得到的一行的MVD(IFC Schema)
    //放在一个以list为元素的list里
    //这样就得到了一个MVD(IFC Schema)中的所有有效信息，并且把他们以易识别易查找的方法进行存储。
    //这个方法逐行解析MVD(IFC Schema)，把每一行的解析结果都放在一个list里
  
}
