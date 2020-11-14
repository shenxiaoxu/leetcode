class Solution {
    public Node connect(Node root) {
        Node head = null;
        Node cur = root;
        Node prev = null;
        while(cur != null){
            while(cur != null){
                if(cur.left != null){
                    if(prev != null){
                        prev.next = cur.left;
                    }else{
                        head = cur.left;
                    }
                    prev = cur.left;
                }
                if(cur.right != null){
                    if(prev != null){
                        prev.next = cur.right;
                    }else{
                        head = cur.right;
                    }
                    prev = cur.right;
                }
                cur = cur.next;
            }
            cur = head;
            prev = null;
            head = null;
        }
        return root;
    }
}
