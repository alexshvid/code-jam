package codejam.storecredit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;

public class StoreCredit {

	private void doMain(BufferedReader reader, PrintStream writer) throws Exception {
		
		int n = Integer.parseInt(reader.readLine());

		for (int icase = 0; icase !=n; ++icase) {
		
			int c = Integer.parseInt(reader.readLine());

			int itemsNum = Integer.parseInt(reader.readLine());
		
			String itemsLine = reader.readLine();
			
			int[] items = new int[itemsNum];

			int l = 0;
			StringTokenizer tokenizer = new StringTokenizer(itemsLine, " ");
			while(tokenizer.hasMoreTokens()) {
				items[l++] = Integer.parseInt(tokenizer.nextToken());
			}
			
			int sol = Integer.MAX_VALUE;
			int firstItemSol = 0;
			int secondItemSol = 0;
			
			for (int i = 0; i != items.length; ++i) {
				
				if (items[i] <= c) {
					
					for (int j = i+1; j < items.length; ++j) {
						
						int rest  = c - ( items[i] + items[j] );
						if (rest >= 0 && rest < sol) {
							firstItemSol = i + 1;
							secondItemSol = j + 1;
							sol = rest;
						}
						
					}
					
				}
				
			}
			
			
			writer.println("Case #" + (icase+1) + ": " + firstItemSol + " " + secondItemSol);
			
		}
		

	}

	public static void main(String[] args) {
		
		try {
			
			String folder = new File("").getAbsolutePath() + "/src/" + StoreCredit.class.getPackage().getName().replace(".", "/");
			
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
			
			new StoreCredit().doMain(reader, writer);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
