package view;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputViewTest {

    @Test
    void 입력_테스트() {

        // given
        Scanner scanner = new Scanner("3\n5\n");

        // when
        InputView inputView = new InputView(scanner);

        // then
        assertEquals(3, inputView.widthLadder());
        assertEquals(5, inputView.heightLadder());
    }

}