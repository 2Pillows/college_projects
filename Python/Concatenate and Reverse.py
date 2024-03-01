# ------------------------------------------------------------------------
# Pseudocode:
#   1. Declare main() function:
#       Collect 3 Strings
#       Call reverse() function with 3 Strings as paramaters
#   2. Declare reverse() function:
#       Concatentate 3 Strings
#       Print Concatentation in Reverse Order
# ------------------------------------------------------------------------
# Program Inputs: 3 Strings
# Program Outputs: Concatentation of 3 Strings in Reverse
# ------------------------------------------------------------------------


def main():
    numList = ["First", "Second", "Third"]
    stringList = []
    for x in numList:
        stringList.append(input("Enter " + x + " String: "))
    revString = reverse(stringList[0], stringList[1], stringList[2])
    print(revString)


def reverse(firstString, secondString, thirdString):
    res = firstString + secondString + thirdString
    return res[::-1]


main()
