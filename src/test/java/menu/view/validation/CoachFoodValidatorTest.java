package menu.view.validation;

import static org.assertj.core.api.Fail.fail;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import menu.dto.MenuBoard;
import org.junit.jupiter.api.Test;

public class CoachFoodValidatorTest {

    @Test
    void validateFoodNames_withValidInput_shouldNotThrowException() {
        // given
        LinkedHashMap<String, List<String>> menuMap = new LinkedHashMap<>();
        menuMap.put("food1", Arrays.asList("김밥", "라면"));
        menuMap.put("food2", Arrays.asList("떡볶이", "순대"));

        MenuBoard menuBoard = new MenuBoard(menuMap);  // MenuBoard 객체 초기화
        String validInput = "김밥,라면";  // 공백 문자열

        try {
            new CoachFoodValidator(menuBoard).validator(validInput);  // 실제 validator 호출
        } catch (Exception e) {
            fail("예외가 발생하지 않아야 한다.");
        }
    }
}
