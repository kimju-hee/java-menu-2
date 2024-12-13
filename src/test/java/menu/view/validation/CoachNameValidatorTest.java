package menu.view.validation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Fail.fail;

class CoachNameValidatorTest {

    @Test
    void validateCoachNames_withValidInput_shouldNotThrowException() {
        // given
        String validInput = "홍길동,이순신,김유신";

        // when & then
        // 유효한 입력이므로 예외가 발생하지 않아야 한다.
        try {
            CoachNameValidator.validator(validInput);
        } catch (Exception e) {
            // 예외가 발생하면 실패하도록 한다.
            fail("예외가 발생하지 않아야 한다.");
        }
    }


    @Test
    void validateCoachNames_withTooShortName_shouldThrowException() {
        // given
        String invalidInput = "홍,이순신,김유신";

        // when & then
        // 이름의 길이가 너무 짧을 경우 예외가 발생해야 한다.
        assertThatThrownBy(() -> CoachNameValidator.validator(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_COACH_NAME.getMessage());
    }

    @Test
    void validateCoachNames_withTooLongName_shouldThrowException() {
        // given
        String invalidInput = "홍길동,이순신,김유신길동";

        // when & then
        // 이름의 길이가 너무 길 경우 예외가 발생해야 한다.
        assertThatThrownBy(() -> CoachNameValidator.validator(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_COACH_NAME.getMessage());
    }

    @Test
    void validateCoachNames_withInvalidCharacterName_shouldThrowException() {
        // given
        String invalidInput = "홍길동,이순신,김!유신";

        // when & then
        // 이름에 유효하지 않은 문자가 포함될 경우 예외가 발생해야 한다.
        assertThatThrownBy(() -> CoachNameValidator.validator(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_COACH.getMessage());
    }

    @Test
    void validateCoachNames_withTooFewCoaches_shouldThrowException() {
        // given
        String invalidInput = "홍길동";

        // when & then
        // 코치 수가 너무 적을 경우 예외가 발생해야 한다 (최소 2명 이상이어야 한다).
        assertThatThrownBy(() -> CoachNameValidator.validator(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_COACH_RANGE.getMessage());
    }

    @Test
    void validateCoachNames_withTooManyCoaches_shouldThrowException() {
        // given
        String invalidInput = "홍길동,이순신,김유신,강감찬,을지문덕,이몽룡";

        // when & then
        // 코치 수가 너무 많을 경우 예외가 발생해야 한다 (최대 5명 이하이어야 한다).
        assertThatThrownBy(() -> CoachNameValidator.validator(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_COACH_RANGE.getMessage());
    }
}
