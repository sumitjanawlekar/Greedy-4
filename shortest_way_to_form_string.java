// Time Complexity : O(m*n), where m is the length of the source string and n is the length of the target string
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

//Three liner expalantion of your code in plain English
//Intuition -> As we have to find target is souce, 1 iteration on target is a substing in source. So keeping pointers in source and 
                //target, check 1 iteration on target can find how many continuos characters ( by including all OR by omitting
                // some characters of targert to form 1 substring). Then repeat this by reseting the poiter to 0 only in target 
                //string, to find the remaining character(s)/subtring in the source
//1. Iterate over the source String while checking if a character(s) (substring), is present in string target.
//2. If yes increase the count by 1. If there are still characters in the source left to be explored, reset the pointer in string   
        //target to 0 and again repeat the step 1, checking if character(s) (subtring) is present in string target.
//3. keep doing this till all the characters are explored in string source and return the count. Edge case check needs to be done
        //if a character in source is not present in target , return -1

// Your code here along with comments explaining your approach

class Solution {
    public int shortestWay(String source, String target) {
        //edge case
        if(source == null || target == null || source.length()==0 || target.length()==0) return -1;
        
        //result
        int count = 0;
        //length of the 2 strings
        int sl = source.length();
        int tl = target.length();
        //pointers to iterate over the 2 strings
        int tp = 0;
        int sp = 0;
        
        //iterate over each character in the target to see if it is present in the source
        while(tp < tl){
            count++;
            //reset the source pointer for each substring in target
            sp = 0;
            int curr = tp;
            //find all the characters of target in sorce for 1 substring
            while(sp < sl && tp < tl){
                if(source.charAt(sp) == target.charAt(tp)){
                    tp++;
                }
                sp++;
            }
            //if no character was matched in 1 substring cycle, meaning the character at target is not present in Source
            if(curr == tp) return -1;
        }
        return count;
    }
}