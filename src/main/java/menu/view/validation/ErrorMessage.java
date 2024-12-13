package menu.view.validation;

public enum ErrorMessage {
    INVALID_COACH_NAME("코치 이름은 최소 2글자, 최대 4글자여야 합니다"),
    INVALID_COACH_RANGE("코치는 최소 2명, 최대 5명이어야 합니다"),
    INVALID_COACH("코치 이름은 한글이어야 합니다"),
    INVALID_FOOD("음식 이름은 한글이어야 합니다"),
    INVALID_FOOD_RANGE("못 먹는 음식은 최소 0개, 최대 2개여야 합니다"),
    INVALID_FOOD_MENU("존재하지 않는 메뉴 이름입니다");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
