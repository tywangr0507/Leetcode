public class Solution23 {



    /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        if(l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }



    public ListNode mergeKLists(ListNode[] lists) {
        

        int listCnt = lists.length;
        int i = 0;
        int j = listCnt - 1;

        if(listCnt == 0){
            return null;

        } else {
            while(i < j){
                lists[i] = mergeTwoLists(lists[i], lists[j]);
                i++;
                j--;
            }

            if()
            return lists[0];
        }


    }
    public static void main(String[] args){
        Solution23 solution = new Solution23();
        ListNode[] arr = new ListNode[3];

        arr[0] = new ListNode(1);
        arr[0].next = new ListNode(3);
        arr[0].next.next = new ListNode(5);
        arr[0].next.next.next = new ListNode(7);
 
        arr[1] = new ListNode(2);
        arr[1].next = new ListNode(4);
        arr[1].next.next = new ListNode(6);
        arr[1].next.next.next = new ListNode(8);
 
        arr[2] = new ListNode(0);
        arr[2].next = new ListNode(9);
        arr[2].next.next = new ListNode(10);
        arr[2].next.next.next = new ListNode(11);


        ListNode result = solution.mergeKLists(arr);
        printList(result);  // 0 1 2 3 4 5 6 7 8 9 10 11
        
    }

    public static void printList(ListNode node)
    {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }



    
}
