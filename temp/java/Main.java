package temp.java;

import java.util.*;
// (i+2) % len(nums)
public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        queue.add(5);
        queue.add(2);
        queue.add(10);
        queue.add(1);

        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }

    }
    public static void rotateHelper(int left, int right,int[] nums){
        int temp=0;
        while(left < right) {
            temp=nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
    }

}

