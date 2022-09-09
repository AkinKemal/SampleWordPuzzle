public class LinkedListOperations {
    public LinkedListNode head;

    public LinkedListOperations() {
        head = null;
    }

    public LinkedListNode getHead() {
        return head;
    }

    public void add(String character) {

        LinkedListNode newNode = new LinkedListNode(character);

        if (head == null) {
            head = newNode;
            head.setNext(null);
        } else {
            LinkedListNode walk = head;

            while (walk.getNext() != null) {
                walk = walk.getNext();
            }

            walk.setNext(newNode);
            newNode.setNext(null);
        }
    }

    public void clear() {
        head = null;
    }
}