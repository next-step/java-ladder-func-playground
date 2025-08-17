package util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.Test;

import exception.CustomException;
import exception.ErrorMessage;

public class ParserTest {

    @Test
    void 쉼표로_구분된_문자열을_리스트로_파싱한다() {
        String input = "neo, brown, brie, tommy";
        List<String> result = Parser.parseStringToList(input);

        assertThat(result).containsExactly("neo", "brown", "brie", "tommy");
    }

    @Test
    void 공백만_있는_요소도_포함하여_리스트로_파싱한다() {
        String input = "neo,   , brie";
        List<String> result = Parser.parseStringToList(input);

        assertThat(result).containsExactly("neo", "", "brie");
    }

    @Test
    void 빈_문자열_입력시_빈_리스트_반환() {
        String input = "";
        List<String> result = Parser.parseStringToList(input);

        assertThat(result).containsExactly("");
    }

    @Test
    void null_입력시_예외_발생_여부_테스트() {
        assertThatThrownBy(() -> Parser.parseStringToList(null))
            .isInstanceOf(CustomException.class)
            .extracting("message")
            .isEqualTo(ErrorMessage.NULL_INPUT_STRING.getMessage());
    }
}
