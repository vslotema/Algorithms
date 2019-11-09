import java.util.Scanner;

/**
 *weightedQuickUnion Find with a move function
 */
public class UnionFindMove{

    private GroupID[] groupID;


    public DSufm(int n) {

        groupID = new GroupID[n];
        for (int i = 0; i < n; i++) groupID[i] = new GroupID();
    }

    /** Union works similar to the union in weightedQuickUnion, but instead of storing ints, it stores GroupID object.
     *  If the size of the parent of p is bigger than the parent of q, then parentQ will set itself to parentP object, else
     * the other way around.
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        GroupID parentP = groupID[p].getParent();
        GroupID parentQ = groupID[q].getParent();

        if(parentP.equals(parentQ)) return;

       if(parentP.size > parentQ.size) {
           parentQ.parent = parentP;
           parentP.size += parentQ.size;
        } else {
           parentP.parent = parentQ;
           parentQ.size += parentP.size;
       }
    }

    /**
     * Returns true when s and t are connected.
     * @param s
     * @param t
     * @return
     */
    public boolean connected(int s, int t) {
        return groupID[s].getParent() == groupID[t].getParent();
    }


    /**
     * Moves s to t. If s and t turn out to refer to the same groupID object, meaning they are in the same set, then return.
     * Else, we create a new GroupID object and assign it to parentT object. We then increment its size by one and assign the object
     * to index s.
     * @param s
     * @param t
     */
    public void move(int s, int t) {

        GroupID parentT = groupID[t].getParent();
        GroupID parentS = groupID[s].getParent();

        if(parentS.equals(parentT)) return;

        GroupID newNode = new GroupID();
        newNode.parent = parentT;
        parentT.size += 1;
        groupID[s] = newNode;

    }

    class GroupID  {
        GroupID parent = null;
        int size = 1;

        private GroupID() {

        }

        private GroupID getParent() {
            if (this.parent == null) return this;
            return this.parent.getParent();
        }

    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] array = input.nextLine().split(" ");
        int n = Integer.parseInt(array[0]);
        int m = Integer.parseInt(array[1]);

        DSufm uf = new UnionFindMove(n);

        for(int i = 0; i < m ; i++) {
            String line = input.nextLine();
            String[] arr = line.split(" ");
            String o = arr[0];
            int s = Integer.parseInt(arr[1]);
            int t = Integer.parseInt(arr[2]);
            if (o.equals("u")) {
                uf.union(s, t);
            } else if (o.equals("q")) {
                System.out.println( uf.connected(s,t) ? "yes" : "no");
            } else {
                uf.move(s,t);
            }
        }
    }
}
