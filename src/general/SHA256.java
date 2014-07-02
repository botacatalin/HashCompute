package general;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/***
 * Author Bota Catalin
 * Email  bota.catalin@gmail.com
 * Desc This software can compute several hash functions used in verification of messages / file integrity. 
 */
public class SHA256 implements IHash{

	MessageDigest md;
	DigestInputStream dis;
	byte[] buffer = new byte[512];
	
	@Override
	public String computeHash(File fd)  {

		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		InputStream is;
		Path path = Paths.get(fd.getPath()); 
		try {
			is = Files.newInputStream(path);
			dis = new DigestInputStream(is, md);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			while ((dis.read(buffer)) != -1){}
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] digest = md.digest();
	
		//convert the byte to hex format 
        StringBuffer hash = new StringBuffer();
        for (int i = 0; i < digest.length; i++) {
        	hash.append(Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1));
        }
        
		System.out.println("SHA256 hash("+fd.getName()+") : " + hash);

		return hash.toString();
	}


}
