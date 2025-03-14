package dto;

import model.Line;

import java.util.List;

import static model.LinkStatus.PRESENT;

public class LineDto {

    private final List<Boolean> linkExistCollection;

    private LineDto(List<Boolean> linkExistCollection) {
        this.linkExistCollection = linkExistCollection;
    }

    public static LineDto from(Line line) {
        List<Boolean> linkExistCollection = line.getLinks().stream()
                .map(link -> link.getLinkstatus() == PRESENT)
                .toList();

        return new LineDto(linkExistCollection);
    }

    public List<Boolean> getLinkExistCollection() {
        return linkExistCollection;
    }

}
