package homework;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class SimpleOptimizerTest {
    @Test
    public void should_calculate_for_an_example() {
        // given
        int[] rooms = {35, 21, 17};
        int senior = 10;
        int junior = 6;
        Output output = new Output();
        List<Map<String, Integer>> expected = output.addResult(3, 1)
                .addResult(1, 2)
                .addResult(2, 0)
                .getResults();
        Optimizer optimizer = new SimpleOptimizer();

        // when
        List<Map<String, Integer>> result = optimizer.calculate(rooms, senior, junior);

        // then
        assertEquals(expected, result);
    }

    @Test
    public void another_example() {
        // given
        int[] rooms = {24, 28};
        int senior = 11;
        int junior = 6;
        Output output = new Output();
        List<Map<String, Integer>> expected = output.addResult(2, 1)
                .addResult(2, 1)
                .getResults();
        Optimizer optimizer = new SimpleOptimizer();

        // when
        List<Map<String, Integer>> result = optimizer.calculate(rooms, senior, junior);

        // then
        assertEquals(expected, result);
    }
}