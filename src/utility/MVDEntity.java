/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yzj107
 */
public class MVDEntity {
    
    public String entityName;
    public String leaveEntiyName;
    public List<Attribute> attributeList = new ArrayList<Attribute>();
    public List<Attribute> inverseList = new ArrayList<Attribute>();
    
    public MVDEntity(){
        attributeList=new ArrayList();
        inverseList=new ArrayList();
    }
    
}
