package domain;

import java.util.List;

public interface RungsBuilder {

    List<Boolean> buildAndGetRungsStatus(List<Boolean> prevRungsStatus);

    List<Boolean> buildTemporaryRungsStatus(int height);

}
