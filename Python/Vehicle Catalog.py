# ------------------------------------------------------------------------
# Pseudocode:
#               1. VehicleInventory Class
#                   - Creates private make, model, color strings and private year and mileage ints
#                   - Creates empty list of Catalog, and fills dataList of a single vehicle with
#                       the strings and ints created in last step
#               2. Add Vehicle
#                   - Function is overriden to give option for specificying index for addititon.
#                       If no index is provided the vehicle will be added to the last position
#                   - Collects the make, model, color, year, and mileage of a Vehicle and adds to catalog
#                   - If the index is invalid then an error will be printed and the code will return to menu
#               3. Remove Vehicle
#                   - Function is overriden to give option for specificying index for removal.
#                       If no index is provided the last vehicle will be removed
#                   - If the index is invalid then an error will be printed and the code will return to menu
#               4. Update Vehicle
#                   - Function is overriden to give option for specificying index for updating.
#                       If no index is provided the last vehicle will be updated
#                   - If the index is invalid then an error will be printed and the code will return to menu
#                   - The update will remove the specififed vehicle with the removeVehicle() function and then
#                       call the addVehicle() class to recieve new data for the vehicle
#               5. Get Inventory
#                   - Fills a string with the current Catalog
#                   - If no vehicles are in catalog a message displaying there are no vehicles will be added to the string
#                   - Returns the string with the Catalog
#               6. Print Inventory
#                   - Calls getInventory() to get a string list with the current Catalog
#                   - Uses a for loop to print the string Catalog
#               7. Output Inventory
#                   - Calls getInventory() to get a string list with the current Catalog
#                   - Uses a with loop to create and open a new text file
#                   - Uses a for loop inside the with loop to write the string list with Catalog to file
#               8. Main
#                   - Creates an instance of VehicleInventory
#                   - Uses a while loop to continue the menu until user decides to exit
#                   - Prints the menu from a string list
#                   - Gathers a single or two integers from user to specify a menu option and/or the index
#                   - Calls the function correspondnig to the user's selection. If integer is invalid then an
#                       error is printed and the menu is redisplayed.
#                   - After calling the function the menu is shown again and the user is prompted to select
#                       another menu option
# ------------------------------------------------------------------------
# Program Inputs: Vehile Model, Make, Color, Year, and Mileage.
#                 Index of Add, Remove, and Update for Catalog
# Program Outputs: Catalog of Vehicles and their Model, Make, Color, Year and Mileage
#                  Text File of Catalog
#                  Display Catalog with Print
# ------------------------------------------------------------------------


class VehicleInventory:
    dataNames = ["Make", "Model", "Color", "Year", "Mileage"]

    def __init__(self):
        self.__make = self.__model = self.__color = ""
        self.__year = self.__mileage = 0

        self.catalog = []
        self.dataList = [
            self.__make,
            self.__model,
            self.__color,
            self.__year,
            self.__mileage,
        ]

    def addVehicle(self, index=None):
        if index != None and (index < 0 or index > len(self.catalog)):
            print("Invalid Index to Add Vehicle")
            return

        self.vehicleData = []

        for i in range(len(self.dataNames)):
            if i < 3:
                while True:
                    try:
                        self.vehicleData.append(
                            str(input("Enter Vehicle " + self.dataNames[i] + ": "))
                        )
                        break
                    except:
                        print("Must Enter " + self.dataNames[i] + " as String")
            else:
                while True:
                    try:
                        self.vehicleData.append(
                            int(input("Enter Vehicle " + self.dataNames[i] + ": "))
                        )
                        break
                    except:
                        print("Must Enter " + self.dataNames[i] + " as Integer")

        self.__make, self.__model, self.__color = (
            self.vehicleData[0],
            self.vehicleData[1],
            self.vehicleData[2],
        )
        self.__year, self.__mileage = self.vehicleData[3], self.vehicleData[4]

        if index is None:
            self.catalog.append(self.vehicleData)
        else:
            self.catalog.insert(index, self.vehicleData)

    def removeVehicle(self, index=None):
        if index != None and (index < 0 or index >= len(self.catalog)):
            print("Invalid Index to Remove Vehicle")
            return

        if index == None:
            self.catalog.pop()
        else:
            del self.catalog[index]

    def updateVehicle(self, index=None):
        if index != None and (index < 0 or index >= len(self.catalog)):
            print("Invalid Index to Update Vehicle")
            return

        if index == None:
            self.removeVehicle()
            self.addVehicle()
        else:
            self.removeVehicle(index)
            self.addVehicle(index)

    def getInventory(self):
        outputString = ["Vehicle Inventory:\n"]

        if len(self.catalog) != 0:
            for i in range(len(self.catalog)):
                outputString.append("Vehicle #" + str(i + 1) + ":")
                for j in range(len(self.catalog[i])):
                    outputString.append(
                        self.dataNames[j] + " = " + str(self.catalog[i][j])
                    )
                outputString.append("")
        else:
            outputString.append("No Vehicles in Catalog")

        return outputString

    def printInventory(self):
        for i in self.getInventory():
            print(i)

    def outputInventory(self):
        self.getInventory()
        with open("VehicleInventory.txt", "w") as f:
            for i in self.getInventory():
                f.write(i + "\n")


def main():
    vehicleList = VehicleInventory()

    while True:
        menuTitles = [
            "\nUser Menu:",
            "X for Menu Option or X Y for Option and Index. Default Y is Last Index\n",
            "1 - Add Vehicle and Index",
            "2 - Remove Vehicle and Index",
            "3 - Update Vehicle and Index",
            "4 - List Vehicles",
            "5 - Export Vehicles",
            "6 - End Program",
        ]

        for x in menuTitles:
            print(x)

        while True:
            try:
                userChoice = list(
                    map(int, input("\nEnter Numbers to Execute Command: ").split())
                )
                break
            except:
                print("Enter One or Two Integers")

        if len(userChoice) == 1:
            userChoice.append(None)

        if userChoice[0] == 1:
            vehicleList.addVehicle(userChoice[1])
        elif userChoice[0] == 2:
            vehicleList.removeVehicle(userChoice[1])
        elif userChoice[0] == 3:
            vehicleList.updateVehicle(userChoice[1])
        elif userChoice[0] == 4:
            vehicleList.printInventory()
        elif userChoice[0] == 5:
            vehicleList.outputInventory()
        elif userChoice[0] == 6:
            quit()
        else:
            print("Invalid Menu Option")


main()
