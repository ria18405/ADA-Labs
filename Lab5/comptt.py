def func(str1,str2):
	cutlen=len(str1)//2
	str3=str1[:cutlen]
	str4=str1[cutlen:]
	str5=str2[:cutlen]
	str6=str2[cutlen:]
	if(str3==str5 and str4==str6 ) or( str3==str6 and str4==str5):
		return True
	elif cutlen==1:
		return False
	elif (str3==str5):
		return func(str4,str6)

	elif (str4==str6):
		return func(str3,str5)
	elif (str3==str6):
		return func(str4,str5)
	elif (str4==str5):
		return func(str3,str6)
	else:
		return (func(str3,str5) and func(str4,str6)) or(func(str3,str6) and func(str4,str5))
str1=input()
str2=input()
y=func(str1,str2)
if(y==True):
	print("YES")
else:
	print("NO")

