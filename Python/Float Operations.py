# ------------------------------------------------------------------------
# Pseudocode: Retrieves five floats from user and then finds the
# total, average, maximum, minimum, and interest at 20% for each value.
# ------------------------------------------------------------------------
# Program Inputs: Five floats
# Program Outputs: Total of five floats, average, maximum float, mininum
# float, interest at 20% of each float
# ------------------------------------------------------------------------
numList = ["First", "Second", "Third", "Fourth", "Fifth"]
inputList = []

for x in numList:
    inputList.append(float(input("Enter " + x + " Float:")))

total = 0
for x in inputList:
    total = total + x

average = total / 5

maximum = max(inputList)

minimum = min(inputList)

interest = []
for x in inputList:
    interest.append(x + x * 0.2)

print("Total   = ", total)
print("Average = ", average)
print("Maximum = ", maximum)
print("Minumum = ", minimum)
print("Interest: ")

for x in range(5):
    print(numList[x], " = ", interest[x])
