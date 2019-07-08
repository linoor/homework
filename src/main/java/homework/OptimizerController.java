package homework;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class OptimizerController {

    private ObjectMapper objectMapper = new ObjectMapper();
    private Optimizer optimizer = new SimpleOptimizer();

    @RequestMapping("/")
    public String index() {
        return "Greetings from cleaners Optimizer!";
    }

    @RequestMapping(name="/optimizer", method=RequestMethod.POST)
    public String optimizer(@RequestBody Input input) throws IOException {
        int[] rooms = input.getRooms();
        int seniorCap = input.getSenior();
        int juniorCap = input.getJunior();

        List<Map<String, Integer>> calculate = optimizer.calculate(rooms, seniorCap, juniorCap);

        return objectMapper.writeValueAsString(calculate);
    }

}
