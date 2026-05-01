package domain;

import java.util.List;

public interface LadderRowStrategy {
    List<LadderStep> generate(int count);
}
