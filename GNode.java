public class GNode {
    protected String item;
    protected GNode next;

    public GNode() {
        this.item = null;
        this.next = null;
    }

    public GNode(String item) {
        this.item = item;
        this.next = null;
    }

    public GNode(String item, GNode next) {
        this.item = item;
        this.next = next;
    }

    public String getItem() {
        return this.item;
    }

    public GNode getNext() {
        return this.next;
    }
}
