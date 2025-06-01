package ladder;


public class Link {
    private boolean isLinked;

    public Link() {
        this.isLinked = false;
    }

    public boolean isLinked() {
        return isLinked;
    }

    public void link() {
        this.isLinked = true;
    }

    public void unlink() {
        this.isLinked = false;
    }

}



