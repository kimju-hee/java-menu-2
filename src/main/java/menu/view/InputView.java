package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.dto.MenuBoard;
import menu.view.validation.CoachFoodValidator;
import menu.view.validation.CoachNameValidator;

public class InputView {
    public final MenuBoard menuBoard;
    private CoachFoodValidator coachFoodValidator;

    // MenuBoard가 전달된 후에 CoachFoodValidator 초기화
    public InputView(MenuBoard menuBoard) {
        this.menuBoard = menuBoard;
        this.coachFoodValidator = new CoachFoodValidator(menuBoard);  // menuBoard 초기화 후 사용
    }

    public String coachInput() {
        String coachName = Console.readLine();
        CoachNameValidator.validator(coachName);
        return coachName;
    }

    public String coachCantEatInput() {
        String foodName = Console.readLine();
        coachFoodValidator.validator(foodName);  // 인스턴스를 통해 호출
        return foodName;
    }
}
