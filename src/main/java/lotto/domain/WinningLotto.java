package lotto.domain;

import lotto.view.InPut;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto {
    InPut input = new InPut();
    private Lotto winningnumbers;
    private int bonus;

    public List<Integer> getWinningnumbers(){
        return winningnumbers.getNumbers();
    }

    public int getBonus(){
        return bonus;
    }
    public WinningLotto(List<Integer> list , int bonus){
        validateWinningNumbers(list);
        validateBonusNumber(bonus);
        validateDuplicate(list, bonus);
        this.winningnumbers = new Lotto(list);
        this.bonus = bonus;
    }
    private void  validateWinningNumbers(List<Integer> numbers){
        if (!isSixDifferentNumbers(numbers)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 서로 다른 6개의 수여야 합니다.");
        }
        for (int token : numbers){
            if (token < 1 || token > 45){
                throw new IllegalArgumentException("\"[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }
    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private boolean isSixDifferentNumbers(List<Integer> winningNumbers) {
        Set<Integer> duplicateChecker = new HashSet<>(winningNumbers);
        return duplicateChecker.size() == 6;
    }
    private void validateDuplicate(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호가 중복됩니다.");
        }
    }
}
