package org.example;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
 
public class Main {
 
    public static String generateRandomPassword(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characters.length());
            password.append(characters.charAt(index));
        }
        return password.toString();
    }
 
    public static void shuffleArray(int[] arr) {
        Random rand = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
 
    public static boolean containsOnlyDigits(String str) {
        return str.matches("\\d+");
    }
 
    public static byte[] hmacWithJava(String algorithm, String data)
throws NoSuchAlgorithmException, InvalidKeyException {
    String key = "secret";
    SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), algorithm);
    Mac mac = Mac.getInstance(algorithm);
    mac.init(secretKeySpec);
    return mac.doFinal(data.getBytes());
}
 
    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
 
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
 
    public static List<Integer> getPrimesUntil(int n) {
        List<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        int m = (int) Math.sqrt(n);
        for (int i = 2; i <= m; i++) {
            if (isPrime[i]) {
                for (int k = i * i; k <= n; k += i) {
                    isPrime[k] = false;
                }
            }
        }
        for (int i = 0; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }
 
    public static Long binPow(Long a, Long b) {
        if (b == 0) {
            return 1L;
        }
        Long res = binPow(a, b / 2);
        if (b % 2 == 1) {
            return res * res * a;
        } else {
            return res * res;
        }
    }
 
    public static Integer binarySearch(List<Integer> arr, Integer x) {
        int l = 0;
        int r = arr.size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr.get(m).equals(x)) {
                return m;
            }
            if (arr.get(m) < x) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }
 
    public static Integer ternarySearch(List<Integer> arr, Integer x) {
        int l = 0;
        int r = arr.size() - 1;
        while (r >= l) {
            int mid1 = l + (r - l) / 3;
            int mid2 = r - (r - l) / 3;
            if (arr.get(mid1).equals(x)) {
                return mid1;
            }
            if (arr.get(mid2).equals(x)) {
                return mid2;
            }
            if (x < arr.get(mid1)) {
                r = mid1 - 1;
            } else if (x > arr.get(mid2)) {
                l = mid2 + 1;
            } else {
                l = mid1 + 1;
                r = mid2 - 1;
            }
        }
        return -1;
    }
 
}