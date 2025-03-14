package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static model.LinkStatus.*;
import static org.assertj.core.api.Assertions.assertThat;

class LinkTest {

    private static final boolean DEFAULT_CONNECT_DECIDER = true;
    private static final boolean TRUE_CONNECT_DECIDER = true;
    private static final boolean FALSE_CONNECT_DECIDER = false;
    private static final boolean DEFAULT_CONNECTABLE = true;
    private static final boolean TRUE_CONNECTABLE = true;
    private static final boolean FALSE_CONNECTABLE = false;

    @Test
    @DisplayName("상태 값이 UNDEFINED인 Link 인스턴스를 생성한다")
    void createUndefinedLink() {
        Link undefinedLink = Link.getUndefinedLink();

        assertThat(undefinedLink.getLinkstatus()).isSameAs(UNDEFINED);
    }

    @Test
    @DisplayName("상태 값이 UNDEFINED가 아닌 Link 인스턴스를 생성한다")
    void createNotUndefinedLink() {
        Link definedLink = Link.getDefinedLink(DEFAULT_CONNECT_DECIDER, DEFAULT_CONNECTABLE);

        assertThat(definedLink.getLinkstatus()).isNotSameAs(UNDEFINED);
    }

    @Test
    @DisplayName("전달 값이 둘 다 ture라면, 상태 값이 PRESENT인 Link 인스턴스를 생성한다")
    void createPresentLink() {
        Link link = Link.getDefinedLink(TRUE_CONNECT_DECIDER, TRUE_CONNECTABLE);

        assertThat(link.getLinkstatus()).isSameAs(PRESENT);
    }

    @ParameterizedTest
    @DisplayName("ConnectDecider가 false 값을 지닌다면, 상태 값이 ABSENT인 Link 인스턴스를 생성한다")
    @ValueSource(booleans = {true, false})
    void createAbsentLinkByConnectDecider(boolean connectable) {
        Link link = Link.getDefinedLink(FALSE_CONNECT_DECIDER, connectable);

        assertThat(link.getLinkstatus()).isSameAs(ABSENT);
    }

    @ParameterizedTest
    @DisplayName("connectable 값이 false라면, 상태 값이 ABSENT인 Link 인스턴스를 생성한다")
    @ValueSource(booleans = {true, false})
    void createAbsentLinkByConnectable(boolean connectDecider) {
        Link link = Link.getDefinedLink(connectDecider, FALSE_CONNECTABLE);

        assertThat(link.getLinkstatus()).isSameAs(ABSENT);
    }

    @Test
    @DisplayName("LinkStatus 값이 UNDEFINED인지 여부를 반환한다")
    void returnIsUndefined() {
        Link definedLink = Link.getDefinedLink(DEFAULT_CONNECT_DECIDER, DEFAULT_CONNECTABLE);
        Link undefinedLink = Link.getUndefinedLink();

        assertThat(definedLink.isUndefined()).isFalse();
        assertThat(undefinedLink.isUndefined()).isTrue();
    }

}
