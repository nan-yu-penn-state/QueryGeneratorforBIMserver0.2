/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import utility.FileOperator;

/**
 *
 * @author Nan Yu
 */
public class Test {
    public static void main(String[] args){
        String filePath = "C:\\tmp\\BIM\\CONTAM\\jsons\\Office Building_MEP2013_V51.1.airflow.queried.json";
        File file = new File(filePath);
        System.out.println(file.getName());
        
//        List<Teacher> teacherList = new ArrayList<Teacher>();
//        for(int i = 0; i < 10; i ++){
//            Teacher teacher = new Teacher();
//            teacher.setName("teacher" + i);
//            teacher.setAge(20+i);
//            teacherList.add(teacher);
//        }
//        
//        Teacher test = teacherList.get(5);
//        test.setName("test");
//        test.setAge(0);
//        
//        for(Teacher each : teacherList)
//            System.out.println(each);
        
//        String test = "hello.json";
//        System.out.println(test.substring(0, test.length() - 5));
        
        
    }
}

    
class Teacher{
    private String name;
    private int age;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }
    
    public String toString(){
        return this.name + "'s age is " + this.age;
    }
}