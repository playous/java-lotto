package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.OutPut;

import java.util.ArrayList;
import java.util.List;

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
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("에러");
        }
    }

    // TODO: 추가 기능 구현
}
