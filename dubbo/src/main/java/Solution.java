/**
 * @Description
 * @Author ZuoHao
 * @Date 2020/9/4 14:56
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(layToys(9));
    }
    public static int layToys (int n) {
        // write code here
        if(n <=0){
            return 0;
        }
        int i = 1;
        while (n >= i){
            n = n - i;
            i++;
        }
        return i-1;
    }
}
