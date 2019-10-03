/* 
 * Made by Kwabena Aduse-Poku and Yuvraj Nayak
 * For Mr. Flynn
 * 9/26/2019
 */

package flynnriddle;
import java.net.*;
import java.io.*;

public class adjective {

	public static void main(String[] arg) {
		try {
			URL url = new URL("http://svn.code.sf.net/p/cmusphinx/code/trunk/cmudict/cmudict-0.7b");
			BufferedReader read = new BufferedReader(new InputStreamReader(url.openStream()));

			String inputline;
			int counter = 1;
			while ((inputline = read.readLine()) != null) {
				if (counter >= 127) {
					String[] line = inputline.split(" ");
					String word = line[0];
					int eCounter = 0, iCounter = 0, oCounter = 0, uCounter = 0, aCounter = 0;
					for (int i = 0; i < word.length(); i++) {
						if (word.charAt(i) == 'E') {
							eCounter++;
						} else if (word.charAt(i) == 'I') { 
							iCounter++;
							
						} else if (word.charAt(i) == 'O') { 
							oCounter++;
							
						} else if (word.charAt(i) == 'U') { 
							uCounter++;
							
						} else if (word.charAt(i) == 'A') { 
							aCounter++;
						}
					}
					if (eCounter == 2 && iCounter == 1 && oCounter == 1 && uCounter == 1 && aCounter == 0) {
						System.out.println(inputline);
					}
				}
				counter++;
			}

			read.close();
		} catch (IOException e) {
			System.out.println("sorry");
		}
	}

	public static boolean checkforOW(String[] s) {
		boolean r = false;
		for (int i = 1; i < s.length; i++) {
			if (s[i].contains("OW")) {
				r = true;
			}
		}
		
		return r;
		
	}

}
