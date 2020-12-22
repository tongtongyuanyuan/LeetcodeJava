import java.util.HashMap;

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {
    }


    public Node(int _val, Node _next, Node _random) {
        val =  _val;
        next = _next;
        random = _random;
    }
};
//public class Solution {
//    public Node copyRandomList(Node head) {
//        HashMap<Node, Node> visited = new HashMap<Node, Node>();
//        return helper(head, visited);
//    }
//    Node helper(Node node, HashMap<Node, Node> visited) {
//        if(visited.containsKey(node)) {
//            return visited.get(node); //建立的是oldnode ->newnode 的映射关系
//        }
//        Node res = new Node(node.val, null, null);
//        visited.put(node, res);
//        res.next = helper(node.next, visited);
//        res.random = helper(node.random, visited);
//        return res;
//    }
//}
//iterative:
public class Solution{

    HashMap<Node, Node> visited = new HashMap<Node, Node> ();

    public Node getClonedNode(Node node) {
        if(node != null){
            if(this.visited.containsKey(node)) {
                return this.visited.get(node);
            }else {
                this.visited.put(node, new Node(node.val, null, null));
                return this.visited.get(node);
            }
        }
        return null;
    }

    public Node copyRandomList(Node head) {
            if(head == null) return null;

            Node oldnode = head;
            //create the clone of original node
        Node clonenode = new Node(oldnode.val, null, null);
        this.visited.put(oldnode, clonenode);
        while(oldnode != null) {
            clonenode.next = this.getClonedNode(oldnode.next);
            clonenode.random = this.getClonedNode(oldnode.random);

            //move the linkedlist
            oldnode = oldnode.next;
            clonenode = clonenode.next;
        }
        return this.visited.get(head);
    }
}

//138.ClonedNode