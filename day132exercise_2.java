package day132;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
//剑指 Offer 59 - II. 队列的最大值
public class day132exercise_2 {
    Queue<Integer> A = new LinkedList<>();
    Deque<Integer> B = new LinkedList<>();
    public day132exercise_2() {

    }

    public int max_value() {
        if(B.isEmpty()){
            return -1;
        }
        return B.peekFirst();
    }

    public void push_back(int value) {
        A.offer(value);
        while(!B.isEmpty() && value > B.peekLast()){
            B.pollLast();
        }
        B.offerLast(value);
    }

    public int pop_front() {
        if(A.isEmpty()){
            return -1;
        }
        if(B.peekFirst().equals(A.peek())){
            B.pollFirst();
        }
        return A.poll();
    }
}
