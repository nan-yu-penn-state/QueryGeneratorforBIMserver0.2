/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.json;

/**
 *
 * @author Nan Yu
 */
import java.util.ArrayList;
import java.util.List;

public class T {
	private String str = "testStr";
	private int age = 15;
	private List<String> listString = new ArrayList<String>();
//	{
//		this.listString.add("中华人民共和国");
//		this.listString.add("中华人民共和国");
//		this.listString.add("中华人民共和国");
//	}
	public List<String> getListString() {
		return this.listString;
	}
	public void setListString(List<String> listString) {
		this.listString = listString;
	}
	private List<T2> test2 = new ArrayList<T2>();
//	{
//		this.test2.add(new T2());
//		this.test2.add(new T2());
//		this.test2.add(new T2());
//		this.test2.add(new T2());
//		this.test2.add(new T2());
//	}
	public String getStr() {
		return this.str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public int getAge() {
		return this.age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<T2> getTest2() {
		return this.test2;
	}
	public void setTest2(List<T2> test2) {
		this.test2 = test2;
	}
}
