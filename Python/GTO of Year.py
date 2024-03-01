# ------------------------------------------------------------------------
# Pseudocode:
# 1. Gather Year
# 2. If Year is found to be in a range print the GTO
# 3. If Year isn't in a range then print "Invalid Year"
# ------------------------------------------------------------------------
# Program Inputs: A string of a set of numbers.
# Program Outputs: The GTO of the given year. If the year doesn't have
# an estimated GTO then "Invalid Year" will be returned instead.
# ------------------------------------------------------------------------
year = int(input("Enter Year:"))

if year >= 1962 and year <= 1964:
    print("GTO = $18,500")
elif year >= 1965 and year <= 1968:
    print("GTO = $6,000")
elif year >= 1969 and year <= 1971:
    print("GTO = $12,000")
elif year >= 1972 and year <= 1975:
    print("GTO = $48,000")
elif year >= 1976 and year <= 1980:
    print("GTO = $200,000")
elif year >= 1981 and year <= 1985:
    print("GTO = $650,000")
elif year >= 1986 and year <= 2012:
    print("GTO = $35,000,000")
elif year >= 2013 and year <= 2014:
    print("GTO = $52,000,000")
else:
    print("Invalid Year")
