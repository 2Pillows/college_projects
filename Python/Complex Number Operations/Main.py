# ------------------------------------------------------------------------
# Pseudocode:
# 1. Import Python File with Complex class
# 2. Main function
#   - Get 2 Numbers from User
#   - Print Operations of Numbers
# ------------------------------------------------------------------------
# Program Inputs: 2 Complex Numbers (C, D)
# Program Outputs: Addition, subtraction, multiplication, division, and
# modulus operations of the 2 complex numbers.
#    C + D
#    C - D
#    C * D
#    C / D
#    mod(C)
#    mod(D)
# ------------------------------------------------------------------------
from Complex import *


def main():
    C = map(float, input("Enter A Complex Number (2 + 3i = 2 3): ").split())
    D = map(float, input("Enter A Complex Number (2 + 3i = 2 3): ").split())
    x = Complex(*C)
    y = Complex(*D)
    print("\n".join(map(str, [x + y, x - y, x * y, x / y, x.mod(), y.mod()])))


main()
