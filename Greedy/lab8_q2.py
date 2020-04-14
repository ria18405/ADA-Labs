t=int(input())
for i in range(t):
	Arr=list(map(int,input().split()))
	n=Arr[0]
	Arr=Arr[1:]
	Arr.sort()
	size=1
	groups={}
	flag=0
	for k in range(n):
		groups[Arr[k]] = []
	# print(groups)
	for x in range(n):
		if(x<n-1 and x>0 and (Arr[x-1]+1!=Arr[x] and Arr[x+1]!=Arr[x]+1 ) and ( Arr[x-1]!=Arr[x] and Arr[x+1]!=Arr[x])):
			# print(1)
			flag=1
			# print("yo",Arr[x],Arr,x)
			break
		# print(len(groups[x]))
		if (Arr[x]-1 in groups and len(groups[Arr[x]-1])!=0):
			groups[Arr[x]].append(min(groups[Arr[x]-1])+1)
			# print(groups[Arr[x]])
			groups[Arr[x]-1].remove(min(groups[Arr[x]-1]))
			
		else:
			groups[Arr[x]].append(size)
	# print(groups)
	if (flag==1):
		print(1)
	else:	
		mini=n
		for j in groups:
			
			if( len(groups[j])!=0 and min(groups[j]) <mini):
				mini=min(groups[j])
		print(mini)



	# size=1
	# #key=last number, value=size
	# groups[Arr[0]].append(size)
	# # groups.append(seq)
	# for j in range(1,n):
	# 	if(j<n-1 and Arr[j-1]+1 !=Arr[j] and Arr[j+1]!=Arr[j]+1):
	# 		print(1)
	# 		break

	# 	#if in group, any sequence is there, with last letter Arr[j]-1
	# 	#if(Arr[j]-1 in groups):
	# 	if len(groups[Arr[j]-1])>0:
	# 		groups[Arr[j]-1]=min(groups[Arr[j]-1])+1
	# 		print(groups[Arr[j]-1])
			#update dictionary min(groups[Arr[j]-1])+1 and change key to last numebr.

		# if(Arr[j]==Arr[j-1]+1):
		# 	seq.append(Arr[j])
		# 	size+=1
		# else:
		# 	groups.append(seq)
		# elif (Arr[j]==Arr[j-1]):

