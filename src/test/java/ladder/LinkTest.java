package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LinkTest {
    @Test
    @DisplayName("Link 객체는 초기 생성 시 연결 상태가 false여야 한다")
    void shouldBeFalseWhenLinkIsCreated() {
        // given
        Link link = new Link();

        // then
        assertThat(link.isLinked()).isFalse();
    }

    @Test
    @DisplayName("link() 호출 시 연결 상태가 true로 변경되어야 한다")
    void shouldBeTrueAfterCallingLink() {
        // given
        Link link = new Link();

        // when
        link.link();

        // then
        assertThat(link.isLinked()).isTrue();
    }
}