package bill;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

public class MainClass {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String filename="D:/test/expense.txt";
		
		FileReader fr = new FileReader(filename);
		BufferedReader br=new BufferedReader(fr);

		FileWriter fw = new FileWriter(filename+".out");
		PrintWriter pw = new PrintWriter(fw);
		
		
		String str;
		while((str=br.readLine())!=null){
			int n;
			int p;
			float total=0.0f;
			float average=0.0f;
			
			if(str=="0") break;

			n=Integer.parseInt(str);
			
			float []amount=new float[n];
			
			for(int i=0;i<n;i++){
				str=br.readLine();
				p=Integer.parseInt(str);
				amount[i]=0;
				for(int j=0;j<p;j++){
					str=br.readLine();
					amount[i]+=Float.parseFloat(str);
				}
				total+=amount[i];
//				pw.println(amount[i]);
			}
			
			average=total/n;
			DecimalFormat df = new DecimalFormat("#.##");
			
			for(int i=0;i<n;i++){
				if(average-amount[i]>0){
					pw.println(df.format(average-amount[i]));
				}
				else{
					pw.println("("+df.format(average-amount[i])+")");

				}
					
			}
		pw.println();
		}
		
		pw.flush();

		pw.close();
		fw.close();
		br.close();
		fr.close();

	}

}
