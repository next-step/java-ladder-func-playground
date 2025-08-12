package test.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import controller.LadderGameController;
import view.InputView;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mockStatic;
import org.mockito.MockedStatic;

import java.util.List;

class LadderGameControllerTest {
    private LadderGameController controller;

    @BeforeEach
    void setUp() {
        List<String> names = List.of("Neo", "Tommy", "Brie");
        List<String> results = List.of("꽝", "5000", "3000");
        controller = new LadderGameController(names, results, 5);
    }

    @Test
    void 사다리_게임_플레이() {
        try (MockedStatic<InputView> mockedInputView = mockStatic(InputView.class)) {
            mockedInputView.when(InputView::getQuery).thenReturn("all");

            controller.play();
            assertNotNull(controller);
        }
    }
}

