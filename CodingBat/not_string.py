testCases = ['candy', 'x', 'not bad', 'bad', 'not', 'is not', 'no']

def not_string(str):
    if len(str) >= 3 and str[:3] == "not":
        return str
    return "not " + str

for i in testCases:
	print not_string(i)