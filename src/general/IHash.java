package general;

import java.io.File;
/***
 * Author Bota Catalin
 * Email  bota.catalin@gmail.com
 * Desc This software can compute several hash functions used in verification of messages / file integrity. 
 */
public interface IHash {

	//Compute hash algorithm
	public String computeHash(File fd);
	
	
}
