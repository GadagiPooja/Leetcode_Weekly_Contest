1.find-the-sequence-of-strings-appeared-on-the-screen

class Solution {
    public List<String> stringSequence(String target) {
         List<String> result = new ArrayList<>();
        StringBuilder screen = new StringBuilder();

        for (char c : target.toCharArray()) {
            if (screen.length() == 0 || screen.charAt(screen.length() - 1) != c) {
                if (screen.length() == 0) {
                    screen.append('a');
                    result.add(screen.toString());
                }
                
                while (screen.charAt(screen.length() - 1) != c) {
                    screen.setCharAt(screen.length() - 1, 
                        screen.charAt(screen.length() - 1) == 'z' ? 'a' : (char)(screen.charAt(screen.length() - 1) + 1));
                    result.add(screen.toString());
                }
            }
            screen.append('a');
            result.add(screen.toString());
        }
        result.remove(result.size()-1);
        return result;






//  List<String> result = new ArrayList<>();
//         StringBuilder screen = new StringBuilder();
//         char currentChar = 'a'; // Initialize with 'a' as the first character

//         for (char c : target.toCharArray()) {
//             // Move to target character one step at a time
//             while (currentChar != c) {
//                 screen.append(currentChar);
//                 result.add(screen.toString());
//                 // Increment current character (wrap around if 'z')
//                 currentChar = (currentChar == 'z') ? 'a' : (char)(screen.length()-1 + 1);
//             }
//             // Press Key 1 to append the target character
//             screen.append(currentChar);
//             result.add(screen.toString());
//         }

//         return result;

    }
}




2.count-substrings-with-k-frequency-characters-i

  class Solution {
    public int numberOfSubstrings(String s, int k) {
        //   int n = s.length();
        // int count = 0;

        // for (int i = 0; i < n; i++) {
        //     HashMap<Character, Integer> freqMap = new HashMap<>();
            
        //     for (int j = i; j < n; j++) {
        //         char currentChar = s.charAt(j);
                
               
        //         freqMap.put(currentChar, freqMap.getOrDefault(currentChar, 0) + 1);
                
        //         if (isValid(freqMap, k)) {
        //             count++;
        //         }
        //     }
        // }

        // return count;


        //   int n = s.length();
        // int count = 0;

        // for (int i = 0; i < n; i++) {
        //     HashMap<Character, Integer> freqMap = new HashMap<>();
            
        //     for (int j = i; j < n; j++) {
        //         char currentChar = s.charAt(j);
                
        //         freqMap.put(currentChar, freqMap.getOrDefault(currentChar, 0) + 1);
                
        //         if (isValid(freqMap, k)) {
        //             count += (n - j); 
        //             break;
        //         }
        //     }
        // }

        // return count;


  int n = s.length();
        int res = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26]; 
            
            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;

                for (int f : freq) {
                    if (f >= k) {
                        res++; 
                        break; 
                    }
                }
            }
        }

        return res;
    }
    private boolean isValid(HashMap<Character, Integer> freqMap, int k) {
        for (int frequency : freqMap.values()) {
            if (frequency >= k) {
                return true;
            }
        }
        return false;
    }
}



3.minimum-division-operations-to-make-array-non-decreasing


  // class Solution {
//     private int[] largestDivisor;

//     public Solution() {
//         final int MAX = 1000000;
//         largestDivisor = new int[MAX + 1];

//         // Precompute the largest proper divisors for each number
//         for (int i = 1; i <= MAX; i++) {
//             largestDivisor[i] = i;
//         }

//         for (int i = 2; i <= MAX; i++) {
//             for (int j = 2 * i; j <= MAX; j += i) {
//                 largestDivisor[j] = Math.max(largestDivisor[j], j / i);
//             }
//         }
//     }

//     public int minOperations(int[] nums) {
//         int cnt = 0;
//         int n = nums.length;

//         // Track the largestDivisor array as flynorpexel midway
//         int[] flynorpexel = new int[n];

//         // Update nums with largest divisors
//         for (int i = 0; i < n; i++) {
//             flynorpexel[i] = largestDivisor[nums[i]];
//             nums[i] = flynorpexel[i];
//         }

//         // Check if the array is non-decreasing after operations
//         for (int i = 1; i < n; i++) {
//             if (nums[i - 1] > nums[i]) {
//                 cnt++;
//             } else if (nums[i - 1] < nums[i]) {
//                 cnt = -1;
//                 break;
//             }
//         }

//         return cnt;
//     }
// }




class Solution {
    public int fun(int x) {
        if (x <= 1) return 0;  
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                if (i < x) return i;          
                if (x / i < x) return x / i; 
            }
        }
        return 0;  
    }

    public int minOperations(int[] nums) {
        int n = nums.length; 
        int operations = 0; 

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] <= nums[i + 1]) continue; 

            int current = nums[i];   
            int next = nums[i + 1];  

            int local_operations = 0; 
            int divisor = fun(current); 

            if (divisor <= 1) return -1; 

            local_operations++; 
            nums[i] = divisor; 

            if (nums[i] > next) 
                return -1; 
            
            operations += local_operations; 
        }

        return operations;   
    }

    
}
