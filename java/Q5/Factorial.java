public class Factorial{
	public static void main(String[] args){
	int no=5;
	int i=1,fact=1;
	for(i=1;i<=no;i++){
		fact=fact*i;
	}
	System.out.println("factorial of "+no+" is :"+fact);
}
}