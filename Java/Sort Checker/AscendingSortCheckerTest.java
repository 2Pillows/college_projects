import java.util.Comparator;

/**
 * Testing Class
 */
public class AscendingSortCheckerTest {

    /**
     * Main method
     * 
     * @param args
     */
    public static void main(String[] args) {
        // Sort Checker object
        AscendingSortChecker sortChecker = new AscendingSortChecker();

        // Integer test with sorted array
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        // Call isSorted function with ascending comparator
        boolean isIntSorted = sortChecker.isSorted(intArray, Comparator.naturalOrder());
        // Display results
        displayTestCheck("Integer", intArray, isIntSorted);

        // String test with sorted array
        String[] strArray = { "apple", "banana", "cherry" };
        // Call isSorted with ascending comparator
        boolean isStrSorted = sortChecker.isSorted(strArray, Comparator.naturalOrder());
        // Display results
        displayTestCheck("String", strArray, isStrSorted);

        /**
         * Class test with reverse sorted array
         */
        class TestClass {
            // Value to be sorted
            private int value;

            // Constructor to get value
            public TestClass(int value) {
                this.value = value;
            }

            // Getter to create Comparator
            public int getValue() {
                return value;
            }

            // toString method to display class value
            @Override
            public String toString() {
                return Integer.toString(value);
            }
        }

        // Create Comparator using getValue() function
        Comparator<TestClass> customComparator = Comparator.comparingInt(TestClass::getValue);
        // Create reverse sorted array of Class objects
        TestClass[] classArray = {
                new TestClass(3),
                new TestClass(2),
                new TestClass(1)
        };
        // Call isSorted
        boolean isClassSorted = sortChecker.isSorted(classArray, customComparator);
        // Display results
        displayTestCheck("Class", classArray, isClassSorted);
    }

    /**
     * Helper function to display results of tests
     * 
     * @param <T>     Type of object in array
     * @param objType String of object type
     * @param array   Array of objects that was tested
     * @param result  Result of calling isSorted with array
     */
    private static <T> void displayTestCheck(String objType, T[] array, boolean result) {
        // {Name of Object} Array
        System.out.println(objType + " array:");
        // Display each object in array
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        // Is it Sorted {boolean True or False}
        System.out.println("Is it Sorted: " + result);
        System.out.println("----------");
    }
}
