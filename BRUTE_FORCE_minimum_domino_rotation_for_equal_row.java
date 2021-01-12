// Time Complexity : O(n), where n is the size of the input array (exactly O(2n))
// Space Complexity : O(n), where n is the size of the input array (hashMap space)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Three liner approach of your code in plain English
//Intuition -> First find the number that has maximum frequency, or to be precised, find and element that has frequency atleast equal
                //to the length of the array(as that many elements will be required to make A OR B having only that particular 
                //elemnt). Then calculate the number of rotations for making all the elements in A as maxFreq and number of 
                //rotation to make all the elements in B as maxFreq. In the end return minimum of the 2 rotations. If not possible
                //return -1
//1. create a hashMap to store all the elements in the 2 arrays, with their frequency. Iterate over the array and fill out the frequencies
        //While inserting each element of each array, update the current count. Whereever the count becomes equal to the array length
        //record the element, as that is the element with the max frequency
//2. Once again, iterate over the 2 arrays, and find the number of rotations if we make all the elements in A as maxFreq AND if we
        // make all the elements in B as maxFreq
//3. In the end return the minimum of the rotations that will be required either to make A OR B with all maxFrequencies

// Your code here along with comments explaining your approach

class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        //edge case
        if(A == null || B == null || A.length == 0 || B.length == 0) return 0;
        
        //create hashMap to store the frequency of each element in the 2 arrays
        HashMap<Integer, Integer> map = new HashMap<>();
        //variable to store maxFrequency
        int maxFreq = 0;
        //variable to maintian the current maximum count
        int count = 0;
        
        //iterate over the 2 arrays to find the element with frequency greater than or equal to array length
        for(int i=0; i<A.length; i++){
            //update the map with A's element
            map.put(A[i], map.getOrDefault(A[i], 0) +1);
            //update the count and check, if count just became equal or greater than the array length, if yes, you got the element with max frequency
            count = Math.max(count, map.get(A[i]));
            if(count == A.length){
                maxFreq = A[i];
                break;
            }
            
            //update the map with B's element
            map.put(B[i], map.getOrDefault(B[i], 0) +1);
            //update the count and check, if count just became equal or greater than the array length, if yes, you got the element with max frequency
            count = Math.max(count, map.get(B[i]));
            if(count == A.length){
                maxFreq = B[i];
                break;
            }
        }
        //itertate over the Arrays once again to find the minumum swaps required to make any of the 2 arrays with the maxFrequency
        int aRot = 0;
        int bRot = 0;
        for(int i=0; i<A.length; i++){
            //no rotation possible
            if(A[i] != maxFreq && B[i] != maxFreq) return -1;
            if(A[i] != maxFreq) aRot++;
            if(B[i] != maxFreq) bRot++;
        }
        //return the minimum rotations required
        return Math.min(aRot, bRot);
    }
}