import java.util.ArrayList;
import java.util.List;

public class Node {
    Node up = null;
    Node down = null;
    Node right = null;
    Node left = null;
    char symbol;

    public Node(char symbol) {
        this.symbol = symbol;
    }

    public void setLeft(Node n) {
        this.left = n;
    }

    public void setUp(Node n) {
        this.up = n;
    }

    public void setRight(Node n) {
        this.right = n;
    }

    public void setDown(Node n) {
        this.down = n;
    }

    public String outputEdges() {
        // FIX: the original did res.charAt(res.length() - 3) with no guard,
        // crashing on a room with no edges, and hand-trimmed " or ".
        // Build a list and join it instead.
        List<String> parts = new ArrayList<>();
        if (up != null) parts.add("North");
        if (down != null) parts.add("South");
        if (right != null) parts.add("East");
        if (left != null) parts.add("West");
        return String.join(" or ", parts);
    }

}
