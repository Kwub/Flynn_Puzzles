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
					if ((word.length() == 5) && (word.substring(word.length() - 1).equals("y")) && (checkforOW(line)))
						System.out.println(inputline);
				}
				counter++;
			}

			read.close();
		} catch (IOException e) {
			System.out.println("sorry");
		}
	}

	public static boolean checkforOW(String[] s) {
		for (int i = 1; i < s.length; i++) {
			if (s[i].equals("OW")) {
				return true;
			}
		}
		return false;
	}

}
