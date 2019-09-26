package flynnriddle;

import java.net.*;
import java.io.*;

public class adjective {

	public static void main(String[] arg) {
		try {
			URL url = new URL("https://raw.githubusercontent.com/dwyl/english-words/master/words_alpha.txt");
			BufferedReader read = new BufferedReader(new InputStreamReader(url.openStream()));

			String inputline;
			while ((inputline = read.readLine()) != null) {
				if ((inputline.length() == 5) && (inputline.substring(inputline.length() - 1).equals("y")))
					System.out.println(inputline);
			}

			read.close();
		} catch (IOException e) {
			System.out.println("sorry");
		}
	}

}
