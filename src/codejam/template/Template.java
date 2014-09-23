package codejam.template;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Template {

	private void doMain(BufferedReader reader, PrintStream writer) throws Exception {

		int n = Integer.parseInt(reader.readLine());
		
	}
	
	public static void main(String[] args) {
		
		try {
			
			String folder = new File("").getAbsolutePath() + "/src/" + Template.class.getPackage().getName().replace(".", "/");
			
			BufferedReader reader;
			PrintStream writer;
			
			if (args.length > 0) {
				reader = new BufferedReader(new InputStreamReader(new FileInputStream(folder + "/" + args[0])));
			}
			else {
				reader = new BufferedReader(new InputStreamReader(System.in));
			}
			
			if (args.length > 1) {
				writer = new PrintStream(new FileOutputStream(folder + "/" + args[1]));
			}
			else {
				writer = System.out;
			}
			
			new Template().doMain(reader, writer);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
