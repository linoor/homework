package homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Output {

    private List<Map<String, Integer>> results = new ArrayList<>();

    public List<Map<String, Integer>> getResults() {
        return results;
    }

    public Output addResult(int senior, int junior) {
        Map<String, Integer> entry = new HashMap<>();
        entry.put("senior", senior);
        entry.put("junior", junior);
        results.add(entry);

        return this;
    }
}
