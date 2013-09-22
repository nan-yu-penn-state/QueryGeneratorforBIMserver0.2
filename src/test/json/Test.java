/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.json;

/**
 *
 * @author Nan Yu
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import net.sf.json.JSONObject;

public class Test {

    public static void main(String[] args) throws Exception {
//        JSONObject jo = JSONObject.fromObject(new T());
//        String str = (jo.toString());
//        System.out.println(str);
        String str = readFileByLines("C:\\Users\\yiyang\\Desktop\\test\\output\\test.json");
        
        JSONObject jo2 = JSONObject.fromObject(str);
        T t = (T) JSONObject.toBean(jo2, T.class);
        List<T2> lists2 = (t.getTest2());
        for (Object t2 : lists2) {//这里的Object如果直接写成T2的话，会出错的，原因是JSON转换后的lists2对象因为它不知道类型，就解析成JSON里的某种格式了，我们需要再调用相同的方法将其转成我们所知的JavaBean
            System.out.println(((T3) JSONObject.toBean(JSONObject.fromObject(t2), T3.class)).getAaa());
        }
        List<String> l3 = t.getListString();
        for (String s : l3) {
            System.out.println(s);
        }
    }
    
    public static String readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuffer sb = new StringBuffer();
        try {
//            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
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
        
        System.out.println(sb.toString());
        return sb.toString();
    }
}
