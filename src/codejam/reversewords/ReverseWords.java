package codejam.reversewords;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class ReverseWords {

	private void doMain(BufferedReader reader, PrintStream writer) throws Exception {
		
		int n = Integer.parseInt(reader.readLine());
		
		for (int i = 0; i != n; ++i) {
			String line = reader.readLine();
			writer.println("Case #" + (i+1) + ": " + reverseWords(line));
		}
		
	}

	private String reverseWords(String line) {
		
		List<String> tokens = new ArrayList<String>();
		StringTokenizer tokenizer = new StringTokenizer(line, " ");
		while(tokenizer.hasMoreTokens()) {
			tokens.add(tokenizer.nextToken());
		}
		
		Collections.reverse(tokens);

		StringBuilder str = new StringBuilder();
		for (String token : tokens) {
			if (str.length() > 0) {
				str.append(" ");
			}
			str.append(token);
		}
		
		return str.toString();
		
	}
	
	public static void main(String[] args) {
		
		try {
			
			String folder = new File("").getAbsolutePath() + "/src/" + ReverseWords.class.getPackage().getName().replace(".", "/");
			
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
			
			new ReverseWords().doMain(reader, writer);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
