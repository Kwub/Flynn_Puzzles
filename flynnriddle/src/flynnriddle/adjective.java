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
					boolean check = checkforOW(line);
					
					if (check && (word.length() == 5 || (word.length() == 8 && word.substring(5,6).equals("("))) && (word.substring(4,5).equals("Y"))) {
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
