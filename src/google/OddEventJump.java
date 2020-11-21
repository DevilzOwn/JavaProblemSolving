package google;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class OddEventJump {

    public int oddEvenJumps(int[] A) {
        int[] org = A.clone();
        Integer[] indexArray = new Integer[A.length];
        for (int i = 0; i < A.length; i++) {
            indexArray[i] = i;
        }
        Comparator<Integer> arrayIndexIncreasingComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return A[o1] < A[o2] ? -1 : (A[o1] == A[o2] ? 0 : 1);
            }
        };

        Comparator<Integer> arrayIndexDecreasingComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return A[o1] < A[o2] ? 1 : (A[o1] == A[o2] ? 0 : -1);
            }
        };
        Arrays.sort(indexArray, arrayIndexIncreasingComparator);
        int[] nextOdd = make(indexArray);

        Arrays.sort(indexArray, arrayIndexDecreasingComparator);
        int[] nextEven = make(indexArray);

        boolean[] odd = new boolean[indexArray.length];
        Arrays.fill(odd, false);
        odd[indexArray.length-1] = true;
        boolean[] even = new boolean[indexArray.length];
        Arrays.fill(even, false);
        even[indexArray.length-1] = true;

        for(int i = indexArray.length-2;i>=0;i--){
            if(nextOdd[i] != -1){
                odd[i] = even[nextOdd[i]];
            }

            if(nextEven[i] != -1){
                even[i] = odd[nextEven[i]];
            }
        }
        int count = 0;
        for(boolean flag:odd){
            count+=flag?1:0;
        }
        return count;
    }

    private int[] make(Integer[] indexArray){
        Stack<Integer> stack= new Stack<>();
        int[] ans = new int[indexArray.length];
        Arrays.fill(ans, -1);
        for(int i:indexArray){
            while(!stack.empty() && stack.peek()<i){
                ans[stack.peek()]=i;
                stack.pop();
            }
            stack.push(i);
        }
        return ans;
    }

}
