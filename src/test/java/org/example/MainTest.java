package org.example;
 
import org.junit.jupiter.api.Test;
 
import java.util.Arrays;
import java.util.List;
 
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
 
public class MainTest {
 
    @Test
    void testFindMax() {
        int[] arr = {1, 2, 3, 4, 5};
        int max = Main.findMax(arr);
        assertEquals(5, max);
    }
 
    @Test
    void testIsPrime() {
        int number = 7;
        boolean isPrime = Main.isPrime(number);
        assertTrue(isPrime);
    }
 
    @Test
    void testGetPrimesUntil() {
        int n = 10;
        List<Integer> primes = Main.getPrimesUntil(n);
        List<Integer> expected = Arrays.asList(2, 3, 5, 7);
        assertEquals(expected, primes);
    }
 
    @Test
    void testContainsOnlyDigits() {
        String str = "12345";
        boolean containsOnlyDigits = Main.containsOnlyDigits(str);
        assertTrue(containsOnlyDigits);
    }
 
    @Test
    void testBinarySearch() {
        List<Integer> arr = List.of(1, 2, 3, 4, 5);
        int key = 3;
        int index = Main.binarySearch(arr, key);
        assertEquals(2, index);
    }
}