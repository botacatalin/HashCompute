package general;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/***
 * Author Bota Catalin
 * Email  bota.catalin@gmail.com
 * Desc This software can compute several hash functions used in verification of messages / file integrity. 
 */
public class WriteToFile {

	public static void go(File fd, String md5, String sha1, String sha256) {
		String filename = fd.getPath() + ".HASH";
		 FileWriter fstream = null ;
		 BufferedWriter out = null;
		 String newline = System.getProperty("line.separator");

			  // Create file 
			   try {
				fstream = new FileWriter(filename);
				 out = new BufferedWriter(fstream);
				
				 out.write("MD5: "+md5+newline);
				 out.write("SHA1: "+sha1+newline);
				 out.write("SHA256: "+sha256+newline);
			} catch (IOException e) {
				e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}
}

