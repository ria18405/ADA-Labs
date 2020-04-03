import java.util.*;
class Banana{
	// public static int summation=0;
	public static void main(String [] args){
		Scanner Sc=new Scanner(System.in);
		int n=Sc.nextInt();
		int [] A=new int[n];
		for(int i=0;i<n;i++){
			int a=Sc.nextInt();
			A[i]=a;
		}
		System.out.println(func(A,0,n));
		
	}


	public static int func(int [] A,int start,int end){

		int parta=A[start];
		int partb=0;
		int temp;
		for(int i=start+1;i<end;i++){
			if(parta>partb){
				temp=parta;
				parta=partb+A[i];
				partb=temp;
			}
			else {
				temp=partb;
				parta=partb+A[i];
				partb=temp;
			}	
			// System.out.println("parta "+parta+" partb "+partb);
		}
		if(parta>partb){
			return parta;
		}
		else{
			return partb;
		}
}
}