package pers.lxs.log;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;

public class LogTest {
	
	@Test
	public void test() {
		Logger log = Logger.getLogger("lavasoft"); 
        log.setLevel(Level.INFO); 
        Logger log1 = Logger.getLogger("lavasoft"); 
        System.out.println(log==log1);     //true 
        Logger log2 = Logger.getLogger("lavasoft.blog"); 
//        log2.setLevel(Level.WARNING); 

        log.info("aaa"); 
        log2.info("bbb"); 
        log2.fine("fine"); 
	}

}
