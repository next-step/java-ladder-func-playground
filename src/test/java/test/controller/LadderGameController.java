package test.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import controller.LadderGameController;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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
        controller.play();
        assertNotNull(controller);
    }
}

