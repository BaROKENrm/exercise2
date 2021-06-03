package day159;

import java.util.PriorityQueue;

public class day159exercise_5 {
    static PriorityQueue<Integer> A = new PriorityQueue<>();//大堆
    static PriorityQueue<Integer> B = new PriorityQueue<>((o1,o2) -> {return o2 - o1;});//大堆

    //大的数放到小堆 小的数放到大堆
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        double res = 0;
        for(int i = 0; i < n; i ++){
            if(A.size() != B.size()){
                A.offer(nums1[i]);
                B.offer(A.poll());
            }
            else{
                B.offer(nums1[i]);
                A.offer(B.poll());
            }
        }
        for(int i = 0; i < m; i ++){
            if(A.size() != B.size()){
                A.offer(nums2[i]);
                B.offer(A.poll());
            }
            else{
                B.offer(nums2[i]);
                A.offer(B.poll());
            }
        }

        if(A.size() == B.size()){
            res = (A.peek() + B.peek()) / 2.0;
        }
        else{
            res = A.peek() / 1.0;
        }
        return res;
    }
}
