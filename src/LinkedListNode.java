public class LinkedListNode {

    private String character;
    private LinkedListNode next;

    public LinkedListNode(String character) {
        this.setCharacter(character);
        this.setNext(null);
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public LinkedListNode getNext() {
        return next;
    }

    public void setNext(LinkedListNode next) {
        this.next = next;
    }
}