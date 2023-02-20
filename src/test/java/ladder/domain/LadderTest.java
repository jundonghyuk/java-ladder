package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LadderTest {


    @Test
    @DisplayName("사다리가 라인 수에 맞게 생성된다.")
    void generateLadderTest() {

        class IntendedBooleanGenerator implements BooleanGenerator {

            @Override
            public Boolean generate() {
                return Boolean.TRUE;
            }
        }

        BooleanGenerator intendedBooleanGenerator = new IntendedBooleanGenerator();

        List<Line> lines = List.of(
                new Line(4, intendedBooleanGenerator),
                new Line(4, intendedBooleanGenerator),
                new Line(4, intendedBooleanGenerator),
                new Line(4, intendedBooleanGenerator),
                new Line(4, intendedBooleanGenerator)
        );

        Ladder ladder = new Ladder(lines);
        List<Line> copiedLines = ladder.getLines();
        assertEquals(5, copiedLines.size());
    }
}
