n=int(input())
A=[]
food=[0]*n
for i in range(n):
	a=int(input())
	A.append(a)
food[0]=1
for j in range(1,n):
	if (A[j]>A[j-1]):
		food[j]=food[j-1]+1
	else:
		food[j]=1


for k in range(n-1,0,-1):
	if(A[k-1]>A[k] and food[k-1]<=food[k]):
		food[k-1]=food[k]+1

# print(food)
print(sum(food))