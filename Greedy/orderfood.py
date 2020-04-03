def nearestpower(pb):
	# print("input ",pb)
	count=0
	while(pb>=1):
		pb=pb/2
		if(pb>=1):
			count+=1
	# print("count ",count)
	return count

t=int(input())
for i in range(t):
	p=int(input())
	realcount=0

	remainder=p


	while(remainder>0):
		x=nearestpower(remainder)
		if(x>=12):
			x=11
		# print(x)
		remainder=remainder-(2**x)

		realcount+=1
	print(realcount)