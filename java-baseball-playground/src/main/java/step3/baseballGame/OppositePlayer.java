package step3.baseballGame;

import java.util.Set;

public class OppositePlayer {

    private final Set<Integer> numbers;
    private final Umpire umpire;
    private final RandomGenerator randomGenerator;

    public OppositePlayer(Set<Integer> numbers, Umpire umpire, RandomGenerator randomGenerator) {
        this.numbers = numbers;
        this.umpire = umpire;
        this.randomGenerator = randomGenerator;
    }

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
