import java.util.Stack;



class ListNode {
    int val;
    int size = 0;
    ListNode next = null;
    ListNode(int val) {this.val = val;} 
    ListNode(int val, ListNode next){this.val = val; this.next = next;}
    
}


public class Solution19 {

    public int size(ListNode head){
       int count = (head == null)?0:1;
        while(head != null && head.next != null){
            head = head.next;
            count++;
        }
        return count;
    }
    public ListNode onePass(ListNode head, int n) {
        if(head == null)
            return null;
     
        ListNode fast = head;
        ListNode slow = head;
     
        for(int i=0; i<n; i++){
            fast = fast.next;
        }
     
        //if remove the first node
        if(fast == null){
            head = head.next;
            return head;
        }
     
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
     
        slow.next = slow.next.next;
     
        return head;
    }


    public ListNode naiveTwoPasses(ListNode head, int n) {
        if(head == null)
            return null;
     
        //get length of list
        ListNode p = head;
        int len = 0;
        while(p != null){
            len++;
            p = p.next;
        }
     
        //if remove first node
        int fromStart = len-n+1;
        if(fromStart==1)
            return head.next;
     
        //remove non-first node    
        p = head;
        int i=0;
        while(p!=null){
            i++;
            if(i==fromStart-1){
                p.next = p.next.next;
            }
            p=p.next;
        }
        return head;
    }
    

    public ListNode removeNthFromEnd(ListNode head, int n){
        
        // size of list is zero
        if(head == null) return null;
        

        // size of list is not zero
        int size = 0;
        ListNode p = head;
        while(p != null){
            size++;
            p = p.next;
        }

        // if remove last element
        if(n == 1) return head.next;
        
        // remove non-last element 
        p = head;
        int i = 0;
        while(p != null){
            i++;
            if(i == (size - n)){
                p.next = p.next.next;
            }
            p=p.next;
            
        }

        printList(head);
        return head;
    }

    public void printList(ListNode head){
        Stack<Integer> stack = new Stack<Integer>();
        ListNode list = head;
        
        while(list != null){
            System.out.println(list.val);
            stack.push(list.val);
            list = list.next;
        }

        
        while(stack.size() > 0){
            System.out.print(stack.pop() + ",");
        }
       
    }

    public static void main(String[] args){
        Solution19 solution = new Solution19();
        
        // scenario 1
        // ListNode ln5 = new ListNode(5);
        // ListNode ln4 = new ListNode(4, ln5);
        // ListNode ln3 = new ListNode(3, ln4);i
        // ListNode ln2 = new ListNode(2, ln3);
        // ListNode ln1 = new ListNode(1, ln2);
        // solution.removeNthFromEnd(ln1, 2);


        // scenario 2
        // ListNode ln1 = new ListNode(1);
        // solution.removeNthFromEnd(ln1, 1);


         // scenario 3
        ListNode ln2 = new ListNode(2);
        ListNode ln1 = new ListNode(1, ln2);
        solution.removeNthFromEnd(ln1, 1);
        solution.naiveTwoPasses(ln1, 1);



    }
    
}
