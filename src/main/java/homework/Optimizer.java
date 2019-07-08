package homework;

import java.util.List;
import java.util.Map;

public interface Optimizer {
    public List<Map<String, Integer>> calculate(int[] rooms, int senior, int junior);
}
