package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.view.validation.CoachNameValidator;

public class InputView {

    public String coachInput() {
        String coachName = Console.readLine();
        CoachNameValidator.validator(coachName);
        return coachName;
    }

}
