package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Collections;

public class Bridge {

    private final List<BridgeRow> rows;
    private final Random random = new Random();

    public Bridge(int height, int width) {
        this.rows = new ArrayList<>();
        initializeBridgeRows(height, width);
    }

    public Bridge(List<BridgeRow> rows) {
        this.rows = rows;
    }


    private void initializeBridgeRows(int height, int width) {
        for (int i = 0; i < height; i++) {
            this.rows.add(new BridgeRow(width, this.random));
        }
    }

    public List<BridgeRow> getRows() {
        return Collections.unmodifiableList(this.rows);
    }
}
