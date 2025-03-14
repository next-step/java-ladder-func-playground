package model;

public class Link {

    private final LinkStatus linkstatus;

    private Link(LinkStatus linkstatus) {
        this.linkstatus = linkstatus;
    }

    public static Link getUndefinedLink() {
        return new Link(LinkStatus.UNDEFINED);
    }

    public static Link getDefinedLink(boolean connectDecider, boolean connectable) {
        if (connectDecider && connectable) {
            return new Link(LinkStatus.PRESENT);
        }

        return new Link(LinkStatus.ABSENT);
    }

    public LinkStatus getLinkstatus() {
        return linkstatus;
    }

    public boolean isUndefined() {
        return this.linkstatus == LinkStatus.UNDEFINED;
    }

}
