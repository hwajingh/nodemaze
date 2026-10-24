import java.util.Scanner;


public class Maze {
    static Node a = new Node('A'), b = new Node('B'), c = new Node('C');
    static Node d = new Node('D'), e = new Node('E'), f = new Node('F');
    static Node g = new Node('G'), h = new Node('H'), i = new Node('I');
    static Node j = new Node('J'), k = new Node('K'), l = new Node('L');

    public static void main(String[] args) {
        initMaze();

        Scanner sc = new Scanner(System.in);
        Node node = a;
        while (node != null && node.symbol != 'L') {
            printMessage(node);
            String direction = sc.nextLine();
            // FIX: only move when the edge exists. Previously moving in a
            // direction with no edge set node = null, and the next loop
            // iteration dereferenced node.symbol -> NullPointerException.
            Node next = null;
            switch (direction) {
                case "N": case "n":
                    next = node.up;
                    break;
                case "E": case "e":
                    next = node.right;
                    break;
                case "S": case "s":
                    next = node.down;
                    break;
                case "W": case "w":
                    next = node.left;
                    break;
                default:
                    System.out.println("Unknown direction. Use N/E/S/W.");
                    continue;
            }
            if (next == null) {
                System.out.println("No passage that way.");
            } else {
                node = next;
            }
        }
        System.out.print("You escaped the maze.");
    }

    public static void initMaze() {
        a.setDown(e);
        e.setUp(a);

        a.setRight(b);
        b.setLeft(a);

        e.setDown(i);
        i.setUp(e);

        i.setRight(j);
        j.setLeft(i);

        b.setDown(f);
        f.setUp(b);

        f.setRight(g);
        g.setLeft(f);

        g.setUp(c);
        c.setDown(g);

        g.setDown(k);
        k.setUp(g);

        d.setLeft(c);
        c.setRight(d);

        g.setRight(h);
        h.setLeft(g);

        h.setDown(l);
        l.setUp(h);
    }

    public static void printMessage(Node n) {
        System.out.println("You are in room " + n.symbol + " of a maze of twisty little passages, all alike. You can go " + n.outputEdges());
}}
