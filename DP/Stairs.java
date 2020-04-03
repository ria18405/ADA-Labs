import java.util.*;
class Stairs{
	public static void main(String [] args){
		Scanner Sc=new Scanner(System.in);
		int t=Sc.nextInt();
		for(int i=0;i<t;i++){
			int n=Sc.nextInt();
			int [] P=new int[n];
			for(int j=0;j<n;j++){
				int p=Sc.nextInt();
				P[j]=p;
			}
			
		adjacency(n,P);
		}
	}
	public static void add(LinkedList L,int toadd){

		// addition of a Node at the end
		Node ptr=L.head;
		Node y = new Node(toadd);
		while(ptr.next!=null){
			ptr=ptr.next;
		}
		ptr.next=y;
			
	}
	public static void delete(LinkedList L){
		//deletion of a no. placed at 1st position
		L.head=L.head.next;
	}
	public static void adjacency(int n,int [] P){
		// ArrayList<ArrayList<Integer>> adjacency=new ArrayList<ArrayList<Integer>>(n+1);
		LinkedList [] adjlist=new LinkedList [n+1];
		for(int i=0;i<=n;i++){			

			adjlist[i]=new LinkedList();
				
		}
		for(int j=0;j<n;j++){
			add(adjlist[j],j+1);
			if(j+P[j]<n+1 && P[j]!=1 && j+P[j]>0){
			add(adjlist[j],j+P[j]);
			}
		}


		// for(int p=0;p<=n;p++){
		// 	Node ptr=adjlist[p].head.next;
		// 	while(ptr!=null){
		// 		System.out.print(ptr.data+" ");
		// 		ptr=ptr.next;
		// 	}
		// 	System.out.println();	

		// }
		// for(int s=0;s<=n;s++){
			bfs(n,0,adjlist);
		// }
	}
	public static void bfs(int n,int s,LinkedList [] adjlist){
		// ArrayList<Integer> queue=new ArrayList<Integer>();
		LinkedList queue=new LinkedList();
		boolean visited[]=new boolean[n+1];
		int [] dist =new int[n+1];
		
		visited[s]=true;
		dist[s]=0;
		add(queue,s);

		Node check=queue.head;
		while(check.next!=null){
			int v=queue.head.next.data;		
			delete(queue);
			// System.out.println("v "+v);
			//neighbours of v-- (if not in visited , add to queue,visited=true)
			Node ptr= adjlist[v].head.next;	//only neighbours
			while(ptr!=null){
				// System.out.println("index "+ptr.data);
				if (visited[ptr.data]==false){
					dist[ptr.data]=0;
					dist[ptr.data]=dist[v]+1;
					add(queue,ptr.data);
					visited[ptr.data]=true;
				}
				ptr=ptr.next;
			}

			check=check.next;
			
		}

	    // for(int p=0;p<=n;p++){
	    // 	System.out.print(dist[p]+ " ");
	    // }
	    // System.out.println();
	    System.out.println(dist[n]);

	}

	



}
class Node{
	public int data;
	public Node next;
	public Node(int x)
	{

		data=x;
		next=null;
	}
}


class LinkedList
{	Node head;
	public LinkedList(){
	head=new Node(1);
	}
	
}