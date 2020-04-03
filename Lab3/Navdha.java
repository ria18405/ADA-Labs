import java.util.*;
import java.lang.Math;
class Navdha{
	public static int y=0;
	public static void main(String [] args){
		Scanner Sc=new Scanner(System.in);
		long n=Sc.nextLong();
		long k=Sc.nextLong();
		long A=Sc.nextLong();
		long B=Sc.nextLong();

		long [] Base=new long[(int)k];
		
		for(int i=0;i<k;i++){
			long a=Sc.nextInt();
			Base[i]=a;
		}
		Arrays.sort(Base);


		long p=function(Base,1,(long)Math.pow(2,n), A,B);
		System.out.println(p);
		}

	public static long function(long[] Base,long l,long r,long A,long B){
		long power=0;
		long len=(r-l+1);
		int i=0;
		int n=Base.length-1;
		// System.out.println("hdfjshjfd");
		//finding lower bound for l and upperbound for u
		long lo=lowerbound(Base,l);
		long u= upperbound(Base,r);
		// System.out.println("lo "+lo+" u "+u);
		long x=u-lo;
		// System.out.println("x "+x);
		// System.out.println("length "+len);
		if(x==0){
			power=A;
			return power;
		}
		
		else{
			power=B*x*len;
		}
		if(l==r){
			return power;
		}
		long mid=(l+r)/2;

		// System.out.println("power "+power);
			long z=Math.min(power,function(Base,l,mid,A,B)+function(Base,mid+1,r,A,B));
			// System.out.println("minimum "+z);
			return z;
		
		
		// return 0;
		
	}
public static long lowerbound(long [] Base,long l){
		long lo=0;
		long i=0;
		Long n=(long)Base.length;
		while(n>i){
			long mid=(n+i)/2;
			
			if(Base[(int)mid]>=l) {
				//left
				n=mid;
			}
			else if(Base[(int)mid]<l){
				//right
				i=mid+1;
				lo=mid+1;
			}
		}
		return lo;
	}
	public static long upperbound(long [] Base,long r){
		long u=0;
		long i=0;
		long n=Base.length;
		while(n>i){
			long mid=(n+i)/2;
			if(Base[(int)mid]>r){
				//left
				n=mid;
				
				
			}
			else if(Base[(int)mid]<=r){
				//right
				i=mid+1;
				u=mid+1;
			}
		}
		return u;
	}
	
   


	
}