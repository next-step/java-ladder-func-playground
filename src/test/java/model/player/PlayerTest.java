package model.player;

import model.ladder.Ladder;
import model.ladder.LadderLine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PlayerTest {

    private Player player;
    private PlayerName playerName;
    private Position position;

    @BeforeEach
    public void 초기_세팅() {
        playerName = new PlayerName("test");
        position = new Position(0);
        player = new Player(playerName, position);
    }

    @Test
    public void 플레이어가_사다리를_타고_이동할_때_위치가_올바르게_변경되어야_한다()  {

        Ladder ladder = Mockito.mock(Ladder.class);
        LadderLine ladderLine1 = Mockito.mock(LadderLine.class);
        LadderLine ladderLine2 = Mockito.mock(LadderLine.class);
        LadderLine ladderLine3 = Mockito.mock(LadderLine.class);

        List<LadderLine> ladderLines = new ArrayList<>();
        ladderLines.add(ladderLine1);
        ladderLines.add(ladderLine2);
        ladderLines.add(ladderLine3);

        when(ladder.getLadder()).thenReturn(ladderLines);
        when(ladderLine1.determinePlayerPossibleDirection(0)).thenReturn(1);
        when(ladderLine2.determinePlayerPossibleDirection(1)).thenReturn(0);
        when(ladderLine3.determinePlayerPossibleDirection(1)).thenReturn(-1);

        player.climbLadder(ladder);

        assertEquals(0, player.getPosition());
    }
}
