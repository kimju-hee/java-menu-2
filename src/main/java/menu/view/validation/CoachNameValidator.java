package menu.view.validation;

public class CoachNameValidator {
    private static final int MIN_NAME_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 4;
    private static final int MIN_COACH_NUMBER = 2;
    private static final int MAX_COACH_NUMBER = 5;

    public static void validator(String input) {
        String[] string = input.split(",");
        isValidCoach(string);
        isValidCoachNumber(string);
        isValidName(string);
    }

    public static void isValidCoach(String[] input) {
        for (String i : input) {
            if (i.length() < MIN_NAME_LENGTH || i.length() > MAX_NAME_LENGTH) {
                        throwError();
            }
        }
    }

    public static void isValidCoachNumber(String[] input) {
        if (input.length < MIN_COACH_NUMBER || input.length > MAX_COACH_NUMBER) {
            throwError2();
        }
    }

    public static void isValidName(String[] input) {
        for (String i : input) {
            if (!i.matches("^[ㄱ-ㅎ가-힣]+$")) {
                throwError3();
            }
        }
    }

    private static void throwError() {
        throw new IllegalArgumentException(ErrorMessage.INVALID_COACH_NAME.getMessage());
    }

    private static void throwError2() {
        throw new IllegalArgumentException(ErrorMessage.INVALID_COACH_RANGE.getMessage());
    }

    private static void throwError3() {
        throw new IllegalArgumentException(ErrorMessage.INVALID_COACH.getMessage());
    }
}
