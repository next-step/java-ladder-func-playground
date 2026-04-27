package controller;

import domain.strategy.BooleanGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import view.InputView;
import view.OutputView;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LadderGameControllerTest {
    @Mock
    private InputView inputView;

    @Mock
    private OutputView outputView;

    @Mock
    private BooleanGenerator booleanGenerator;

    @Mock
    private Validator validator;

    @InjectMocks
    private LadderGameController ladderGameController;

    @Test
    void 게임의_흐름이_정상적으로_진행된다() {
        //given
        when(inputView.readInputSeparateByComma())
                .thenReturn(List.of("neo", "brown", "brie", "tommy"))
                .thenReturn(List.of("꽝", "5000", "꽝", "3000"));

        when(inputView.readInput())
                .thenReturn("3")
                .thenReturn("neo")
                .thenReturn("all");

        /*
        |-----|     |-----|
        |     |-----|     |
        |-----|     |     |
        |     |-----|     |
        |-----|     |-----|
         */
        when(booleanGenerator.generate())
                .thenReturn(true, true, false, true, true, false, false, true, true, true);

        when(validator.validateLadderSpec(anyString()))
                .thenReturn(3);

        // when
        ladderGameController.run();

        // then
        verify(outputView).printTargetResult("꽝");
        verify(outputView).printTotalTargetResult(anyMap());
    }
}
