/**
 * @author ZuoHao
 * @date 2022/1/22
 */
public class Node {
    int val;
    Node left;
    Node right;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
