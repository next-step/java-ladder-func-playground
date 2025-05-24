import domain.Size;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SizeTest {

    @Test
    void SaveWeightAndHeight() {
        Size size = new Size(4, 5);

        assertThat(size.getWidth()).isEqualTo(4);
        assertThat(size.getHeight()).isEqualTo(5);
    }
}
