public class Division{
	//int i;
	public static void main(String[] args){
	for(int i=0; i<=100; i++){
		int low=-5;
		int high=6;
		int numerator=121721;
		double randomNum = low + (int)(Math.random()*(high-low));
		//System.out.print("random number: "+randomNum);
		try{
			double out=numerator/randomNum;
			System.out.print(numerator+"/"+randomNum+"="+out+"\n");
		}catch(ArithmeticException e){
		}
	}
}
}
