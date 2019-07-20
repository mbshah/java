
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class KNN_utils {

	Double dist(Double x1,Double y1,Double x2,Double y2){
		Double dis=(x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);
		Double distance = Math.sqrt(dis);
		return distance;
	}
	
	Integer assignclass(Integer[] t1,int k){
		Integer type=0;
		int len=k;
		Integer count1=0;
		Integer count2=0;
		for(int i=0;i<len;i++){
			if(t1[i]==1)count1++;
			if(t1[i]==2)count2++;
		}
		if(count1>count2)type=1;
		else type=2;
		return type;
	}
	
	Map<Integer, Double> sortByComparator(Map<Integer,Double> unsortMap, final boolean order)
    {

        List<Entry<Integer, Double>> list = new LinkedList<Entry<Integer, Double>>(unsortMap.entrySet());

        // Sorting the list based on values
        Collections.sort(list, new Comparator<Entry<Integer, Double>>()
        {
            public int compare(Entry<Integer, Double> o1,
                    Entry<Integer, Double> o2)
            {
                if (order)
                {
                    return o1.getValue().compareTo(o2.getValue());
                }
                else
                {
                    return o2.getValue().compareTo(o1.getValue());

                }
            }
        });

        // Maintaining insertion order with the help of LinkedList
        Map<Integer, Double> sortedMap = new LinkedHashMap<Integer, Double>();
        for (Entry<Integer, Double> entry : list)
        {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
	void tempf(String fil1) throws IOException{
		String fix=fil1.replace(".fasta", ".tfasta");
		BufferedReader br=new BufferedReader(new FileReader(new File(fil1)));
		BufferedWriter bw=new BufferedWriter(new FileWriter(new File(fix)));
		String line=br.readLine();
		while(line!=null){
//			System.out.println(line);
			
			bw.append(line);
			bw.newLine();
			line=br.readLine();
		}
		bw.append('>');
		bw.close();
		br.close();
	}

}
