package day101;

public class day101exercise_1 {
    public static void main(String[] args) {
        MyPriorityQueue myPriorityQueue = new MyPriorityQueue();
        myPriorityQueue.add(5);
        myPriorityQueue.add(1);
        myPriorityQueue.add(3);
        myPriorityQueue.add(4);
        myPriorityQueue.add(6);
        myPriorityQueue.add(8);




        System.out.println(myPriorityQueue.remove());
        System.out.println(myPriorityQueue.remove());
        System.out.println(myPriorityQueue.remove());
        System.out.println(myPriorityQueue.remove());
        System.out.println(myPriorityQueue.remove());
        System.out.println(myPriorityQueue.remove());
        System.out.println(myPriorityQueue.remove());

    }
}

class MyPriorityQueue{
    int[] queue;
    int size;

    public MyPriorityQueue(){
        queue = new int[100];
        size = 0;
    }

    public int remove(){
        if(size == 0){
            throw new RuntimeException("空");
        }
        int temp = queue[0];
        queue[0] = queue[size - 1];
        size --;
        adjustDown(size,0);
        return temp;
    }

    public int peek(){
        if(size == 0){
            throw new RuntimeException("空");
        }
        return queue[0];
    }

    public void add(int x){
        queue[size ++] = x;
        adjustUp(size,size - 1);
    }

    private void adjustUp(int size,int index){
        while(index != 0){
            int parentIndex = (index - 1) / 2;
            if(queue[index] < queue[parentIndex]){
                return;
            }
            swap(queue,parentIndex,index);
            index = parentIndex;
        }
    }

    private void adjustDown(int size,int index){
        while(index * 2 + 1 < size){
            int maxIndex = index * 2 + 1;
            if(maxIndex + 1 < size && queue[maxIndex + 1] > queue[maxIndex]){
                maxIndex ++;
            }
            if(queue[maxIndex] < queue[index]){
                return;
            }
            swap(queue,index,maxIndex);
            index = maxIndex;
        }
    }


    private void swap(int[] queue,int i,int j){
        int temp = queue[i];
        queue[i] = queue[j];
        queue[j] = temp;
    }
}
