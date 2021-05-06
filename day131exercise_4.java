package day131;
//1720. 解码异或后的数组
public class day131exercise_4 {
    public int[] decode(int[] encoded, int first) {
        int len = encoded.length;
        int[] arr = new int[len + 1];
        arr[0] = first;
        for(int i = 1; i <= len; i ++){
            arr[i] = encoded[i - 1] ^ arr[i - 1];
        }
        return arr;
    }
}
