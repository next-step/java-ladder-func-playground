package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LineTest {

    private static final int DEFAULT_SIZE = 5;
    private static final LinksGenerator DEFAULT_LINKS_GENERATOR = new DetachedRandomLinksGenerator(DEFAULT_SIZE);

    @Test
    @DisplayName("내부적으로 지니고 있는 List<Link>를 반환한다")
    void getLinks() {
        Line line = new Line(DEFAULT_LINKS_GENERATOR);
        List<Link> links = line.getLinks();

        Assertions.assertThat(links.size()).isSameAs(DEFAULT_SIZE);
    }

}
