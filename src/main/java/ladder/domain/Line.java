package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<ConnectionStatus> points;

    public Line(final int width, final BooleanGenerator booleanGenerator) {
        this.points = new ArrayList<>();
        for (int position = 0; position < width; position++) {
            points.add(decideConnection(position, booleanGenerator));
        }
    }

    public Line(Line line) {
        this.points = List.copyOf(line.points);
    }

    private ConnectionStatus decideConnection(final int position, final BooleanGenerator booleanGenerator) {
        if (position == 0) {
            return ConnectionStatus.convertConnectionStatus(booleanGenerator.generate());
        }
        if (points.get(position - 1) == ConnectionStatus.CONNECTED) {
            return ConnectionStatus.DISCONNECTED;
        }
        return ConnectionStatus.convertConnectionStatus(booleanGenerator.generate());
    }

    public List<ConnectionStatus> getLineStatus() {
        return List.copyOf(points);
    }

    public ConnectionStatus isConnectedAt(final int index) {
        if(points.size() <= index) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return points.get(index);
    }
}
