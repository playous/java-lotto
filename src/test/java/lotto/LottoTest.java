package lotto;

import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 중 보너스 숫자와 같은 숫자가 있으면 예외가 발생한다.")
    @Test
    void duplicateWinningNumberAndBonusNumberTest() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 45);
        int bonusNumber = 3;

        assertThatThrownBy(() -> new WinningLotto(winningNumbers,bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @ValueSource(ints = {-4, 0, 46, 101, -45})
    @DisplayName("보너스 번호에 1~45의 범위를 벗어나는 수가 들어올 경우 실패")
    void bonusNumberOutsideTheRangeOfOneToFortyFiveTest(int bonusNumber) {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("당첨 번호에 1~45의 범위를 벗어나는 수가 들어올 경우 실패")
    void winningNumberOutsideTheRangeOfOneToFortyFiveTest() {
        List<Integer> winningNumbers1 = List.of(-1, 2, 3, 4, 5, 7);
        int bonusNumber = 45;

        assertThatThrownBy(() -> new WinningLotto(winningNumbers1, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
    @Test
    @DisplayName("당첨 번호에 중복되는 번호가 있을 경우 실패")
    void winningNumbersContainDuplicateNumberTest() {
        List<Integer> winningNumbers1 = List.of(1, 2, 3, 3, 4, 5);
        int bonusNumber = 45;
        assertThatThrownBy(() -> new WinningLotto(winningNumbers1, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("구입 금액이 1000원으로 나누어 떨어지지 않으면 실패")
    void WhenIsNotMoneyIsDivisibleBy1000() {
         Money money= new Money();

        assertThatThrownBy(() -> money.returnCount(4500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
