
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class KNN2 {

	public static HashMap<String,Double> trainhy=new HashMap<String,Double>();
	public static HashMap<String,Double> trainch=new HashMap<String,Double>();
	public static HashMap<String,Integer> trainty=new HashMap<String,Integer>();
	public static ArrayList<String> labl=new ArrayList<String>();
	public static HashMap<Character, Double> hydro=new HashMap<Character,Double>();	
	public static HashMap<Character,Integer> chrg=new HashMap<Character,Integer>();
	public static String test="/home/manan/Study/TTBDM/knn/test.fasta";
	public static Integer k=3;
	void Calc () throws FileNotFoundException {
		KNN2 kn=new KNN2();
		KNN_utils ku=new KNN_utils();
//		HashMap<Character, Double> hydro=new HashMap<Character,Double>();
		hydro.put('I',-0.6);
		hydro.put('V',-0.31);
		hydro.put('L',-0.55);
		hydro.put('F',-0.32);
		hydro.put('C',-0.13);
		hydro.put('M',-0.1);
		hydro.put('A',0.11);
		hydro.put('G',0.74);
		hydro.put('T',0.52);
		hydro.put('S',0.84);
		hydro.put('W',0.3);
		hydro.put('Y',0.68);
		hydro.put('P',2.23);
		hydro.put('H',2.06);
		hydro.put('E',2.68);
		hydro.put('Q',2.36);
		hydro.put('D',3.49);
		hydro.put('N',2.05);
		hydro.put('K',2.71);
		hydro.put('R',2.58);

		
		
		chrg.put('I',0);
		chrg.put('V',0);
		chrg.put('L',0);
		chrg.put('F',0);
		chrg.put('C',0);
		chrg.put('M',0);
		chrg.put('A',0);
		chrg.put('G',0);
		chrg.put('T',0);
		chrg.put('S',0);
		chrg.put('W',0);
		chrg.put('Y',0);
		chrg.put('P',0);
		chrg.put('H',0);
		chrg.put('E',-1);
		chrg.put('Q',0);
		chrg.put('D',-1);
		chrg.put('N',0);
		chrg.put('K',1);
		chrg.put('R',1);
		
		
		
		String[] path=new String[2];
		path[0]="/home/manan/Study/TTBDM/knn/final_negatives.fasta";
		path[1]="/home/manan/Study/TTBDM/knn/final_positives.fasta";
		try {
			BufferedReader finput=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("path to negetives file:");
			path[0]=finput.readLine();
			System.out.println("path to positives file:");
			path[1]=finput.readLine();
			System.out.println("path to test file:");
			test=finput.readLine();
			System.out.print("Value for k (odd numbers please):");
			k=Integer.parseInt(finput.readLine());
			finput.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		int nof=path.length;
		int type=0;
		for(int x=0;x<nof;x++){
			type =x+1;
		
			try {
				ku.tempf(path[x]);
				path[x]=path[x].replace(".fasta", ".tfasta");
				File fi=new File(path[x]);
				BufferedReader br=new BufferedReader(new FileReader(fi));
				String line=br.readLine();
				while(line!=null){
					if(line.charAt(0)=='>'){
						String label=line;
						String[] labell=label.split(" ");
						label="";
						label=label.concat(labell[0]);
						
						line=br.readLine();
						
						Double seqhy=0.0;
						Double seqch=0.0;
						Integer count=0;
						while(line.charAt(0)!='>' ){
							Integer len=line.length();
							for(int i=0;i<len;i++){
								char aa=line.charAt(i);
								Double hyl=hydro.get(aa);
								Integer chrl=chrg.get(aa);
								seqhy=seqhy+hyl;
								
								seqch=(seqch+chrl)*1.0;
								
								count++;
								}
							seqhy=seqhy/(count);
							seqch=seqch/(count);
							line=br.readLine();
							
						}
						kn.trainhy.put(label, seqhy);
						kn.trainch.put(label, seqch);
						kn.trainty.put(label, type);
						kn.labl.add(label);
					}
					if (line.charAt(0)=='>');else{
					line=br.readLine();}
				}
				br.close();
				fi.delete();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch(NullPointerException e){
//				e.printStackTrace();
			}
		}
	}
	
	
	

}