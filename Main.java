import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("Start test");

        int N=10;
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = (int) (Math.random()*1000)+1;
            System.out.print(arr[i]+", ");
        }
        Arrays.sort(arr);
        System.out.println(exists(arr, arr[8]));
        System.out.println("End test");
    }

    public static boolean exists(int[] nums, int target){
        int size = nums.length;
        int l=0, r=size-1, m=0;
        int num=0;

        while(l<=r){
            m=(l+r)/2;
            num = nums[m];
            if(num == target){
                return true;
            } else if (num < target){
                l=m+1;
            } else if (num > target){
                r=m-1;
            }
        }

        return false;
    }
    
} 
