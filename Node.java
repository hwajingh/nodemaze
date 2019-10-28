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
        String res = "";
        if(up != null) res += "North or ";
        if(down != null) res += "South or ";
        if(right != null) res += "East or ";
        if(left != null) res += "West or ";
        if(res.charAt(res.length() - 3) == 'o') res = res.substring(0, res.length() - 3);
        return res;
    }

}
