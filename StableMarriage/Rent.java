import java.util.*;
class Rent{
	public static void main(String [] args){
		Scanner Sc=new Scanner(System.in);
		int t=Sc.nextInt();
		for(int i=0;i<t;i++){
			int n=Sc.nextInt();

			int [][] owners_pref =new int[n][n+1];
			int [][] students_pref =new int[n][n+1];

			for(int j=0;j<n;j++){
				int faltu=Sc.nextInt();		
				owners_pref[faltu-1][0]=-1;		//not matched
				for(int k=1;k<=n;k++){
					int p=Sc.nextInt();
					owners_pref[faltu-1][k]=p;
				}
			}
			for(int jj=0;jj<n;jj++){
				int faltu=Sc.nextInt();
				students_pref[faltu-1][0]=-1;	//not matched
				for(int kk=1;kk<=n;kk++){
					int pp=Sc.nextInt();
					students_pref[faltu-1][kk]=pp;
				}
			}
			for (int y=0;y<n;y++){
				if(students_pref[y][0]==-1){

				}
			}


			int r=0; 	//r = student number
			while(r<n){
				// System.out.println("r "+r);
				// int check=0;
				// for(int fin=r;fin<n;fin++){
				// 	if(students_pref[fin][0]==-1){
				// 		check=1;
				// 		break;
				// 	}
				// }
				// if(check==0){
				// 	break;
				// }
			if(students_pref[r][0]==-1){
			
				// System.out.println((r+1)+"th student");
				for(int q=1;q<=n;q++){
					if(owners_pref[students_pref[r][q] -1][0] ==-1 ){
						//match them
						// System.out.println("normal macthing of "+ (r+1)+"th student with "+students_pref[r][q]);
						owners_pref[students_pref[r][q] -1][0] =r+1;
						students_pref[r][0]=students_pref[r][q];
						break;
					}
					else{
						//matched but pref of student is higher
						//iterate through owners pref list and search for (r+1) and owners_pref[students_pref[r][q] -1][0]
						int present_index=0;
						int new_index=0;
						for(int qq=1;qq<=n;qq++){
							if(owners_pref[students_pref[r][q] -1][qq]==owners_pref[students_pref[r][q] -1][0]){
								present_index=qq;
							}
							else if(owners_pref[students_pref[r][q] -1][qq]== r+1){
								new_index=qq;
							}

						}
						// System.out.println("matching taking place "+present_index+"new "+new_index);
						// if(present_index<new_index){
							//everything fine- no swapping
						// }
						if(present_index>new_index){
							// System.out.println("new addition at owners side "+owners_pref[students_pref[r][q] -1][new_index]);
							owners_pref[students_pref[r][q] -1][0]=owners_pref[students_pref[r][q] -1][new_index];
							students_pref[r][0]=students_pref[r][q];
							// System.out.println("student whose match is removed "+owners_pref[students_pref[r][q]-1][present_index]);
							// students_pref[students_pref[r][q] -1][0]=-1;
							students_pref[owners_pref[students_pref[r][q] -1][present_index] -1][0]=-1;
							// r=students_pref[r][q] -2;
							r=owners_pref[students_pref[r][q]-1][present_index] -2;
							// System.out.println("r set to"+ r);
							break;
							//set r=(old student)
						}
					}
				}
			}
			else{
				// System.out.println("passng the legacy");
				// r++;
				// System.out.println(r);
			}
			r++;
			}

			//OUTPUT 
			for(int y=0;y<n;y++){
				System.out.println(y+1+" "+students_pref[y][0]);
			}



		}
	}
}