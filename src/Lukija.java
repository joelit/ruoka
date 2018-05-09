import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.naming.NamingException;


public class Lukija {

	
	
	public static void main(String[] args) {

		
		String fileName = "/home/joeli/Documents/resultset.csv";
		ArrayList<Aine> aineet = new ArrayList<Aine>();

		java.util.List<String> rivit = new ArrayList<String>();
		
		try {
			
			rivit = Files.readAllLines(Paths.get(fileName), Charset.defaultCharset());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e.getCause());
		}

		int i=0;
		for (int index=1; index < rivit.size() ; index++) {
			String rivi = rivit.get(index);
			
			try {
				Aine a = new Aine(rivi);
				aineet.add(a);
			} catch (NamingException e) {
				System.err.println("WARNING: input line " + (i+1) + " contains a malformed number field: " + e.getMessage());
				break;
			}
			i++;
			
		}
		//tee tästä loki
		System.out.println("Luettu " + i + " ainetta.");
		
				System.out.println(aineet.get(50));
	}
}
