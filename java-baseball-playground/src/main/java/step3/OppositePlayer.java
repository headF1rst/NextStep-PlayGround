package step3;

import java.util.HashSet;
import java.util.Set;

public class OppositePlayer {

    private final Set<Integer> numbers = new HashSet();
    private final Umpire umpire = new Umpire();
    private final RandomGenerator randomGenerator = new RandomGenerator();

    public void pickNumbers() {
        int randomInteger = randomGenerator.getRandomInteger();

        while (numbers.contains(randomInteger)) {
            randomInteger = randomGenerator.getRandomInteger();
        }
        numbers.add(randomInteger);
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }
}
