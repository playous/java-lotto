package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    public List<Integer> getNumbers(){
        return numbers;
    }

    public String toString() {
        return numbers.toString();
    }
    private void validate(List<Integer> numbers) {
        if (!isSizeSix(numbers) || isDuplicate(numbers)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개 입력 가능합니다.");
        }
    }
    private boolean isSizeSix(List<Integer> numbers) {
        return numbers.size() == 6;
    }

    private boolean isDuplicate(List<Integer> numbers) {
        Set<Integer> duplicateChecker = new HashSet<>(numbers);
        return duplicateChecker.size() != 6;
    }


    // TODO: 추가 기능 구현
}
