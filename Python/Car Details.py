# ------------------------------------------------------------------------
# Pseudocode:
# 1. Gather the Brand, Model, Year, Start and End Odometer, and Miles Per Gallon
# 2. Create Dictionary with Model as the Key and other information as the Value in a List
# 3. Print all of the following information about the car from the Dictionary
# ------------------------------------------------------------------------
# Program Inputs: Brand, Model, Year, Start Odometer, End Odometer, Miles per Gallon
# Program Outputs: Brand, Model, Year, Start Odometer, End Odometer, Miles per Gallon
# ------------------------------------------------------------------------
brand = input("Enter Car Brand: ")
model = input("Enter Model: ")
year = input("Enter year: ")
startOdometer = input("Enter starting odometer reading: ")
endOdometer = input("Enter ending odometer reading: ")
milesPerGallon = input("Enter estimated miles per gallon consumed: ")

carDict = {model: [brand, year, startOdometer, endOdometer, milesPerGallon]}

print("For", list(carDict.keys())[0], ":")
print("Brand =", carDict[model][0])
print("Year =", carDict[model][1])
print("Start Odometer =", carDict[model][2])
print("End Odometer =", carDict[model][3])
print("Miles per Gallon =", carDict[model][4])
