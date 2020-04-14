n=int(input())
s=input()
# arr=list(s.split())
arr=list([s[i] for i in range(n)])
# print(arr)
back=0
front=0
need=0
stack=[]
count=0
startindex=n
for i in range(n):
	if(s[i]==')' ):
		back+=1
		# print("yo back",back,front)
		if(back>front and back==1):
			startindex=i
			need=1
	elif(s[i]=='('):
		front+=1
	stack.append(s[i])
	
	if(front==back and need==1):
		# print(i)
		# print(startindex)
		count+=(i+1-startindex)
		# print(stack)
		del stack[:]
		back=0
		front=0
		need=0

	elif(front==back and need==0):
		back=0
		front=0
		del stack[:]
	# print(stack)
	# print(startindex)
if(len(stack)!=0):
	print(-1)
else:
	print(count)

