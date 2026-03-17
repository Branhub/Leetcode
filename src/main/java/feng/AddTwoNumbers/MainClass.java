package feng.AddTwoNumbers;

import java.util.ArrayList;
import java.util.List;

public class MainClass
{
// You are given two non-empty linked lists representing two non-negative integers.
// The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
// You may assume the two numbers do not contain any leading zero, except the number 0 itself.
// Example:
//  Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//  Output: 7 -> 0 -> 8
//  Explanation: 342 + 465 = 807.

    public static void main(String[] args)
    {
        ListNode l1Three = new ListNode(3);
        ListNode l1Two = new ListNode(4,l1Three);
        ListNode l1One = new ListNode(2,l1Two);

        ListNode l2Three = new ListNode(4);
        ListNode l2Two = new ListNode(6,l2Three);
        ListNode l2One = new ListNode(5,l2Two);

        ListNode result = addTwoNumbers(l1One,l2One);
        ListNode resultCurrent = result;
        while (true)
        {
            System.out.println(resultCurrent.val);
            resultCurrent = resultCurrent.next;
            if (resultCurrent == null)
            {
                break;
            }
        }

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        // tmp是进位
        int tmp = 0;
        int l1Length = getListLength(l1);
        int l2Length = getListLength(l2);
        ListNode resultHead = new ListNode();
        ListNode resultCurrent = resultHead;
        int resultLength = Math.max(l1Length,l2Length);
        for (int i = 0;i < resultLength;i++)
        {
            int num1 = getNum(l1,i);
            int num2 = getNum(l2,i);
            int currentNum = num1 + num2 + tmp;
            if (currentNum >= 10)
            {
                tmp = currentNum / 10;
                currentNum = currentNum % 10;
            }
            else
            {
                tmp = 0;
            }
            resultCurrent.val = currentNum;
            if (i != resultLength - 1)
            {
                // 计算的不是最后一位时，新建一个节点
                ListNode newNode = new ListNode();
                resultCurrent.next = newNode;
                resultCurrent = newNode;
            }
            else
            {
                // 计算的是最后一位时，检查进位上有没有值，有的话就再建一个新节点，把进位的值放进去
                if (tmp != 0)
                {
                    ListNode newNode = new ListNode();
                    resultCurrent.next = newNode;
                    resultCurrent = newNode;
                    resultCurrent.val = tmp;
                }
            }
        }
        return resultHead;
    }

    /**
     * 获得链表长度
     * @param head
     * @return
     */
    public static int getListLength(ListNode head)
    {
        ListNode current = head;
        int result = 1;
        while (current.next != null)
        {
            result = result + 1;
            current = current.next;
        }
        return result;
    }

    /**
     * 获得链表某个index上的数字，如果超出链表长度就返回0
     * @param head
     * @param index
     * @return
     */
    public static int getNum(ListNode head,int index)
    {
        int currentIndex = 0;
        ListNode currentNode = head;
        while (true)
        {
            if (currentIndex == index)
            {
                return currentNode.val;
            }
            currentNode = currentNode.next;
            currentIndex = currentIndex + 1;
            if (currentNode == null)
            {
                break;
            }
        }
        return 0;
    }
}
