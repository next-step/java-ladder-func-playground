package domain;

import domain.prize.PrizeName;
import domain.prize.PrizeNames;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrizeNamesTest {

    @Test
    void 인덱스로_조회할_수_있다() {
        PrizeNames prizes = new PrizeNames(List.of(new PrizeName("100")));
        assertEquals("100", prizes.get(0).getValue());
    }

    @Test
    void 전체_리스트_조회_가능() {
        List<PrizeName> prizeList = List.of(new PrizeName("1"), new PrizeName("2"));
        PrizeNames prizes = new PrizeNames(prizeList);
        assertEquals(2, prizes.getAll().size());
    }
}
