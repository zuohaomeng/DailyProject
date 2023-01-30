import javax.annotation.Priority;
import javax.annotation.Resource;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Main().findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},4));

    }
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k,(a1,a2)->a1-a2);
        for (int i = 0; i < nums.length; i++) {
            if(queue.size() < k){
                queue.add(nums[i]);
            }else if (nums[i] > queue.peek()){
                queue.poll();
                queue.add(nums[i]);
            }
        }
        return queue.peek();
    }
}
