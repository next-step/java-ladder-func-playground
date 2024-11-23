package model;

import model.tool.Splitter;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

public class SplitterTest {
    @Test
    void 이름을_구분자_기준으로_잘_자르는_지_확인(){
        //Given
        Splitter splitter = new Splitter();
        SoftAssertions softly = new SoftAssertions();
        String beforeSplit = "참여자1, 참여자2, 참여자3,참여자4";

        //When
        String[] afterSplit = splitter.splitWithComma(beforeSplit);

        //Then
        softly.assertThat(afterSplit.length).isEqualTo(4);
        softly.assertThat(afterSplit[0]).isEqualTo("참여자1");
        softly.assertThat(afterSplit[1]).isEqualTo("참여자2");
        softly.assertThat(afterSplit[2]).isEqualTo("참여자3");
        softly.assertThat(afterSplit[3]).isEqualTo("참여자4");
        softly.assertAll();
    }
}
