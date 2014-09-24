package codejam.t9spelling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class T9Spelling {

	private Map<String, String> map = new HashMap<String, String>();
	
	public T9Spelling() {
		map.put("A", "2");
		map.put("B", "22");
		map.put("C", "222");
		map.put("D", "3");
		map.put("E", "33");
		map.put("F", "333");
		map.put("G", "4");
		map.put("H", "44");
		map.put("I", "444");
		map.put("J", "5");
		map.put("K", "55");
		map.put("L", "555");
		map.put("M", "6");
		map.put("N", "66");
		map.put("O", "666");
		map.put("P", "7");
		map.put("Q", "77");
		map.put("R", "777");
		map.put("S", "7777");
		map.put("T", "8");
		map.put("U", "88");
		map.put("V", "888");
		map.put("W", "9");
		map.put("X", "99");
		map.put("Y", "999");
		map.put("Z", "9999");
		
	}
	
	
	private void doMain(BufferedReader reader, PrintStream writer) throws Exception {

		int n = Integer.parseInt(reader.readLine());
		
		for (int i = 0; i != n; ++i) {
			
			String message = reader.readLine().toUpperCase();
			
			StringBuilder code = new StringBuilder();
			
			for (int c = 0; c != message.length(); ++c) {
				
				char ch = message.charAt(c);
				
				if (ch == ' ') {
					if (code.length() > 0 && code.charAt(code.length() - 1) == '0') {
						code.append(' ');
					}
					code.append('0');
				}
				else {
					String sequence = map.get(Character.toString(ch));
					if (sequence != null) {
						
						if (code.length() > 0 && sequence.charAt(0) == code.charAt(code.length()-1)) {
							code.append(' ');
						}
						
						code.append(sequence);
					}
				}

			}
			
			//while(code.length() > 0 && code.charAt(code.length() -1) == '0') {
			//	code.setLength(code.length() - 1);
			//}
			
			writer.println("Case #" + (i+1) + ": " + code);
			
		}
		
	}
	
	public static void main(String[] args) {
		
		try {
			
			String folder = new File("").getAbsolutePath() + "/src/" + T9Spelling.class.getPackage().getName().replace(".", "/");
			
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
			
			new T9Spelling().doMain(reader, writer);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
