package List;

public class Node {
    // data fields: info, link
    protected int info;
    protected Node link;

    // constructor
    public Node (int info) {
        this.info = info;
        this.link = null;
    }

    //getters
    public int getInfo() {
        return info;
    }

    public Node getLink() {
        return link;
    }
}
