package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Collections;

public class Bridge {

    private final List<BridgeRow> rows;
    private final Random random = new Random();

    private Bridge(int height, int width) {
        this.rows = new ArrayList<>();
        initializeBridgeRows(height, width);
    }

    public static Bridge of(int height, int width)
    {
        return new Bridge(height,width);
    }

    private Bridge(List<BridgeRow> rows) {
        this.rows = new ArrayList<>(rows);
    }

    public static Bridge fromRows(List<BridgeRow> rows) {
        return new Bridge(rows);
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
