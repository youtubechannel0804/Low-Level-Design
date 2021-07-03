package util;

import model.Ladder;
import model.Snake;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SnakeGenerator {

    public static Map<Integer, Snake> generate(int cellCount, int limit) {

        Map<Integer, Snake> ladderPosition = new HashMap<>();
        Random random = new Random();
        while (ladderPosition.size() < limit) {
            int start = random.nextInt(cellCount);
            int end = random.nextInt(cellCount);
            if (start > end) {
                ladderPosition.put(start, new Snake(start, end));
            }
        }
        return ladderPosition;
    }
}
