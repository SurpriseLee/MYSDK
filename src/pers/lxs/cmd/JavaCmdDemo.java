package pers.lxs.cmd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Test;

public class JavaCmdDemo {

	@Test
	public void testCmd() {
		Runtime runtime = Runtime.getRuntime();

		// need to specify the absolutely path for the executable file!!!
		String command = "C:/Program Files (x86)/Tesseract-OCR/tesseract.exe C:/Users/SurpriseLee/Desktop/eurotext.png C:/Users/SurpriseLee/Desktop/eurotext -l eng";

		Process ps;
		try {
			ps = runtime.exec(command);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(ps.getInputStream()));

			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	@Test
	public void test2() {  
        String javaExcute="cmd.exe /c start java -version";   //javaExcute为你要在CMD中执行的字符串  
 
        Process p;  
           try {  
             //执行CMD代码,返回一个Process  
             p = Runtime.getRuntime().exec(javaExcute);  
             InputStream is = p.getInputStream();  
             //得到相应的控制台输出信息  
             InputStreamReader bi = new InputStreamReader(is);  
             BufferedReader br = new BufferedReader(bi);  
             String message;  
             message =  br.readLine();        
             while(message != null && !"".equals(message)){  
               //将信息输出  
               System.out.println(message);  
               message =  br.readLine();  
             }  
           } catch (IOException e) {  
             e.printStackTrace();  
             return;  
           }  
        }  
	

}
