/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* left;
    Node* right;
    Node* next;

    Node() : val(0), left(NULL), right(NULL), next(NULL) {}

    Node(int _val) : val(_val), left(NULL), right(NULL), next(NULL) {}

    Node(int _val, Node* _left, Node* _right, Node* _next)
        : val(_val), left(_left), right(_right), next(_next) {}
};
*/

class Solution {
public:
    Node* connect(Node* root) {
        Node* cur = root;
        Node* prev = NULL;
        Node* head = NULL;
        while(cur){
            while(cur){
                if(cur->left){
                    if(prev){
                        prev->next = cur->left;
                    }else{
                        head = cur->left;
                    }
                    prev = cur->left;
                }
                if(cur->right){
                    if(prev){
                        prev->next = cur->right;
                    }else{
                        head = cur->right;
                    }
                    prev = cur->right;
                }
                cur = cur->next;
            }
            cur = head;
            prev = NULL;
            head = NULL;
        }
        return root;
    }
};
