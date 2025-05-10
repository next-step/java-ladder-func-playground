package ladderdomain;

import java.util.List;

@FunctionalInterface
public interface MoveCondition {
    boolean test(int index, List<Connection> connections);
}
