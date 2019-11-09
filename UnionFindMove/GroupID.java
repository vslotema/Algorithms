public class GroupID {

    GroupID parent = null;
    private int ID;
    private int count;

    public GroupID(int ID) {
        this.ID = ID;
        this.count = 0;
    }

    public GroupID getParent() {
        if (this.parent == null) return this;

        return this.parent;
    }

    public void setID(int n) {
        this.ID = n;
    }

    public int getID() {
        return ID;
    }

    public void incrementCount(int n) {
        count = count + n;
    }

    public void decrementCount() {
        count--;
    }

    public int getSize() {
        return count;
    }
}