import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Hierachical_IFC {
	public static void main(String[] args){
		
		String filename = null;
		int num = 0;
		if (args.length != 2) {
		    System.err.println("Hierachical_IFC [filename] [number]");
		    System.exit(1);
		}else{
		    filename = (args[0]);
		    num = Integer.valueOf(args[1]);
		}
		// filename = "101.ifc";
	 //    num = 125;
		
		
		//read file and store data
		String[] str = new String[500000];
	    try {
	    	BufferedReader br = new BufferedReader(new FileReader(filename));
	        String line = br.readLine();
	        while (line.charAt(0) != '#') {
	            line = br.readLine();
	        }
	        int index = 0;
	        while (line != null && line!="ENDSEC;" && line.indexOf("=")>1) {	        	
	        	index = Integer.valueOf(line.substring(1, line.indexOf("=")));
	            str[index] = line;  
	            line = br.readLine();
	        }
	        br.close();	        
	    } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    Hierachical_IFC h = new Hierachical_IFC();
	    
	    //function (str, #, 0)
	    h.func(str, num, 0);
	    
	}
	public void func(String[] str, int num, int bef){
        String contents = str[num].substring(1);
        StringBuffer a = new StringBuffer();
        for(int i=0;i<bef;i++){
        	a.append("\t");
        }
        System.out.println(a.toString()+"#"+contents);
        String regEx="(#.+?,)|(#.+?\\))";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(contents);
        while (m.find()) {
            func(str, Integer.valueOf(contents.substring(m.start()+1, m.end()-1)), bef+1);
            //System.out.println(contents.substring(m.start()+1, m.end()-1));
        }
	}
}
