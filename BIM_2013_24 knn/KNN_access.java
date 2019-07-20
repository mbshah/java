
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class KNN_access {
	public static HashMap<String,Double> testhy=new HashMap<String,Double>();
	public static HashMap<String,Double> testch=new HashMap<String,Double>();
	public static HashMap<String,Integer> testty=new HashMap<String,Integer>();
	public static ArrayList<String> labl2=new ArrayList<String>();

	public static void main(String[] args){
		KNN2 kn=new KNN2();
		KNN_utils ku=new KNN_utils();

		try {
			kn.Calc();
			String testp=kn.test;
			ku.tempf(testp);
			testp=testp.replace(".fasta", ".tfasta");
			File fi=new File(testp);
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
							Double hyl=KNN2.hydro.get(aa);
							Integer chrl=KNN2.chrg.get(aa);
							seqhy=seqhy+hyl;
							
							seqch=(seqch+chrl)*1.0;
							
							count++;
							}
						seqhy=seqhy/(count);
						seqch=seqch/(count);
						line=br.readLine();
						
					}
					testhy.put(label, seqhy);
					testch.put(label, seqch);
					;
					labl2.add(label);
				}
				if (line.charAt(0)=='>');else{
				line=br.readLine();}
			}
			br.close();
			System.out.println("br closed");
			if(fi.delete()){
    			System.out.println(fi.getName() + " is deleted!");
    		}else{
    			System.out.println("Delete operation is failed.");
    		}
		} catch (IOException e) {
			e.printStackTrace();
		}catch(NullPointerException e){

		}

		check();
		
	}
		static void check(){
			KNN2 kn=new KNN2();
			KNN_utils ut=new KNN_utils();
			KNN_access ka=new KNN_access();
			
			Integer xloop=labl2.size();
			Integer yloop=KNN2.labl.size();
			for(Integer i=0;i<xloop;i++){
				HashMap<Integer,Double> hm=new HashMap<Integer,Double>();
				ArrayList<Integer> lis=new ArrayList<Integer>();
				System.out.println(labl2.get(i));
				for(Integer j=0;j<yloop;j++){
					String n1=labl2.get(i);
					String n2=KNN2.labl.get(j);
					Double x1=testhy.get(n1);
					Double y1=testch.get(n1);
					Double x2=KNN2.trainhy.get(n2);
					Double y2=KNN2.trainch.get(n2);
//					System.out.println(n1+"\t"+n2);
					Double dist=ut.dist(x1, y1, x2, y2);
//					System.out.println("dist="+dist);
					hm.put(j, dist);
					lis.add(j);
				}
				Map<Integer, Double> map = ut.sortByComparator(hm, true);
				Object[] rank=map.keySet().toArray();
				Integer[] t1=new Integer[kn.k];
				String[] top=new String[kn.k];
				Integer k=kn.k;
				for(int x=0;x<k;x++){
					String topx=kn.labl.get((int) rank[x]);
					t1[x]=kn.trainty.get(topx);
					top[x]=topx;
					System.out.print(t1[x]+"\t");
				}

				Integer ntype=ut.assignclass(t1,k);
				
//				System.out.println(top[0]+"\t"+top[1]+"\t"+top[2]);
//				System.out.println(hm.get(rank[0])+"\t"+hm.get(rank[1])+"\t"+hm.get(rank[2]));
				System.out.println("\nso assigned:"+ntype);
				testty.put(labl2.get(i), ntype);

				
				
			}
	}
		
		 	

	

}