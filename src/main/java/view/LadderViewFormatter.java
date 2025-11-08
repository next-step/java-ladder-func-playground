package view;

import Model.Bridge;
import Model.BridgeRow;
import Model.BridgeStep;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LadderViewFormatter {

    public List<String> formatBridge(Bridge bridge) {
        List<String> bridgeLines = new ArrayList<>();
        for (BridgeRow row : bridge.getRows()) {
            StringBuilder sb = new StringBuilder();
            formatBridgeRow(sb, row);
            sb.append("|");
            bridgeLines.add(sb.toString());
        }
        return bridgeLines;
    }

    private void formatBridgeRow(StringBuilder sb, BridgeRow row) {
        row.getSteps().forEach(bridgeStep -> {
            sb.append("|");
            formatBridgeStep(sb, bridgeStep);
        });
    }

    private void formatBridgeStep(StringBuilder sb, BridgeStep bridgeStep) {
        if (bridgeStep == BridgeStep.EXIST) {
            sb.append("-----");
        } else {
            sb.append("     ");
        }
    }

    public String formatNamesLine(List<String> names) {
        return names.stream()
                .map(name -> String.format("%-6s", name))
                .collect(Collectors.joining());
    }

    public String formatResultsLine(List<String> rewards) {
        return rewards.stream()
                .map(reward -> String.format("%-6s", reward))
                .collect(Collectors.joining());
    }
}
