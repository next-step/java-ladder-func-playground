package model.player;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerNameTest {

    @Test
    public void 이름이_유효한_경우_입력한_이름이_올바르게_저장된다(){
        String validName = "test";
        PlayerName playerName = new PlayerName(validName);

        assertThat(playerName.getName()).isEqualTo(validName);
    }

    @Test
    public void 이름이_최소_길이보다_짧은_경우_예외가_발생한다(){
        String emptyName = "";

        assertThatThrownBy(()->new PlayerName(emptyName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("플레이어의 이름은 1자 이상, 5자 이하여야 합니다.");
    }

    @Test
    public void 이름이_최대_길이를_초과하는_경우_예외가_발생한다(){
        String longName = "Iamtester";

        assertThatThrownBy(()->new PlayerName(longName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("플레이어의 이름은 1자 이상, 5자 이하여야 합니다.");
    }

    @Test
    public void 이름이_공백인_경우_에외가_발생한다(){
        String blankName = "   ";

        assertThatThrownBy(()-> new PlayerName(blankName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참여자 이름은 비어있을 수 없습니다.");
    }
}
