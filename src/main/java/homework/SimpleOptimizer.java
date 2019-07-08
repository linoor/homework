package homework;

import homework.Optimizer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SimpleOptimizer implements Optimizer {
    @Override
    public List<Map<String, Integer>> calculate(int[] rooms, int seniorCap, int juniorCap) {
        return Arrays.stream(rooms).mapToObj(roomSize -> {
            int numSeniors = (int) Math.ceil((double)roomSize / seniorCap);
            int numJuniors = 0;

            // try to get more juniors
            while (true) {
                int currentScore = getScore(numSeniors, seniorCap, numJuniors, juniorCap);
                int newSeniorsNum = numSeniors - 1;
                int newJuniorsNum = numJuniors + 1;
                int newScore = getScore(newSeniorsNum, seniorCap, newJuniorsNum, juniorCap);
                if (newScore >= roomSize && newScore < currentScore && numSeniors > 1) {
                    numSeniors = newSeniorsNum;
                    numJuniors = newJuniorsNum;
                    continue;
                }
                break;
            }



            Map<String, Integer> result = new HashMap<>();
            result.put("senior", numSeniors);
            result.put("junior", numJuniors);

            return result;
        }).collect(Collectors.toList());
    }

    public int getScore(int numSeniors, int seniorCap, int numJuniors, int juniorCap) {
        return numSeniors * seniorCap + numJuniors * juniorCap;
    }
}
