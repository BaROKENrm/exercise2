package day147;

class MyPriorityQueue{
    int[] arr;
    int size = 0;
    public MyPriorityQueue() {
        arr = new int[100];
    }

    public int peek(){
        return arr[0];
    }

    public int remove(){
        if(size < 0){
            throw new RuntimeException("队列空");
        }
        int ret = arr[0];
        arr[0] = arr[size - 1];
        size --;
        addJustDown(0);
        return ret;
    }

    public void add(int x){
        if(size > 100){
            throw new RuntimeException("full");
        }
        arr[size ++] = x;
        addUp(size - 1);
    }

    private void addUp(int index){
        while(index != 0){
            int parentIndex = (index - 1) / 2;
            if(arr[index] > arr[parentIndex]){
                return;
            }
            swap(index,parentIndex);
            index = parentIndex;
        }
    }

    private void addJustDown(int index){
        while(index * 2 + 1 < size){
            int minIndex = index * 2 + 1;
            if(minIndex + 1 < size && arr[minIndex + 1] < arr[minIndex]){
                minIndex ++;
            }
            if(arr[minIndex] > arr[index]){
                return;
            }
            swap(minIndex,index);
            index = minIndex;
        }
    }

    private void swap(int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}

public class day147exercise_2 {

}
