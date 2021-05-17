/**
 * Priority Queue implemented using a singly-linked list
 */
public class PriorityIntersectionSelector {
    /**
     * The Head of the Priority Queue is the Node with the lowest priority
     * and is always the next Node removed by the pop() method
     */
    Node head;

    /**
     * Each Node holds the name of an intersection/crossroad from the
     * Graph representation of the map
     * Constant Integer.MAX_VALUE is used to denote the highest priority
     * (a Node with Integer.MAX_VALUE priority should be processed last)
     */
    static class Node {
        String name;
        int priority;
        Node next;

        /**
         * Queue Node Constructor
         */
        public Node() {
            this.name = null;
            this.priority = Integer.MAX_VALUE;
            this.next = null;
        }

        /**
         * Queue Node Constructor
         * @param name specifies the name of the Node
         * @param priority specifies the priority of the Node
         * @param next specifies the next Node in the Queue
         */
        public Node(String name, int priority, Node next) {
            this.name = name;
            this.priority = priority;
            this.next = next;
        }
    }

    /**
     * Queue Constructor
     */
    public PriorityIntersectionSelector() {
        this.head = null;
    }

    /**
     * @return Returns the (boolean) state of emptiness of the Queue
     */
    public boolean isEmpty() {
        return this.head == null;
    }

    /**
     * @return Returns the (String) name of the Head of the Queue,
     * without removing it from the Queue
     */
    public String peek() {
        if (this.isEmpty()) return null;
        else return head.name;
    }

    /**
     * @return Returns the (String) name of the Head of the Queue
     * and removes it from the Queue
     */
    public String pop() {
        if (this.isEmpty()) return null;
        else {
            Node popped = this.head;
            this.head = this.head.next;
            return popped.name;
        }
    }

    /**
     * Pushes a new Node in the Queue according to its priority
     * @param name specifies the name of the inserted Node
     * @param priority specifies the priority of the inserted Node
     */
    public void push(String name, int priority) {
        if (this.isEmpty()) this.head = new Node(name, priority, null);
        else if (this.head.priority > priority) {
            this.head = new Node(name, priority, this.head);
        } else {
            Node current = this.head;
            while (current.next != null && current.next.priority < priority) {
                current = current.next;
            }
            current.next = new Node(name, priority, current.next);
        }
    }

}
