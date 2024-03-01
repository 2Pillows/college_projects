# ------------------------------------------------------------------------
# Pseudocode:
#   1. Complex Class
#       - Contructor named __init__ which creates self.real and self.imaginary
#       - based on given complex number
#   2. Add function
#       - Returns the addition of two complex numbers
#   2. Subract function
#       - Returns the sbtraction of two complex numbers
#   2. Multiply function
#       - Returns the multiplication of two complex numbers
#   2. Division function
#       - Returns the division of two the complex number
#   2. Mod function
#       - Returns the modulus of one complex number
#   2. Str function
#       - Formats the output of one complex number to 2 decimal places
# ------------------------------------------------------------------------
# Program Inputs: One complex number
# Program Outputs: Add, sub, mul, truediv, mod, str function outputs
# ------------------------------------------------------------------------
import math


class Complex(object):
    def __init__(self, real, imaginary):
        self.real = real
        self.imaginary = imaginary

    def __add__(self, no):
        real = self.real + no.real
        imaginary = self.imaginary + no.imaginary
        return Complex(real, imaginary)

    def __sub__(self, no):
        real = self.real - no.real
        imaginary = self.imaginary - no.imaginary
        return Complex(real, imaginary)

    def __mul__(self, no):
        real = self.real * no.real - self.imaginary * no.imaginary
        imaginary = self.real * no.imaginary + self.imaginary * no.real
        return Complex(real, imaginary)

    def __truediv__(self, no):
        divisor = no.real**2 + no.imaginary**2
        real = (self.real * no.real + self.imaginary * no.imaginary) / divisor
        imaginary = (self.imaginary * no.real - self.real * no.imaginary) / divisor
        return Complex(real, imaginary)

    def mod(self):
        real = math.sqrt(self.real**2 + self.imaginary**2)
        return Complex(real, 0)

    def __str__(self):
        if self.imaginary == 0:
            return "%.2f + 0.00i" % (self.real)
        if self.real == 0:
            return "0.00 + %.2fi" % (self.imaginary)
        if self.imaginary < 0:
            return "%.2f - %.2fi" % (self.real, -self.imaginary)
        else:
            return "%.2f + %.2fi" % (self.real, self.imaginary)
        return result
