strnum=input()

arr=list(map(int,str(strnum)))
# print(arr)
n=len(arr)
count=[]
for j in range (n+1):
	count.append(0)
count[0]=1
count[1]=1
if(arr[0]==0):
	count[n]=0	

for i in range(2,n+1):
	if(arr[i-1]>0 and (arr[i-2]==1 or (arr[i-2]==2 and arr[i-1]<7) )):
		# print("one")
		count[i]=count[i-1]+count[i-2]
	elif (arr[i-1]==0 and (arr[i-2]==1 or arr[i-2]==2)):
		# print("yo")
		count[i]=count[i-2]
	elif(arr[i-1]>0):
		count[i]=count[i-1]
	elif(arr[i-1]==0):
		count[i]=0
# print(count)
print(count[n])