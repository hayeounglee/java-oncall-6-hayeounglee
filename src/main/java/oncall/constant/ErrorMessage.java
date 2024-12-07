package oncall.constant;

public enum ErrorMessage {
    EXCEPTION_MESSAGE_PREFIX("[ERROR] "),
    INVALID_DUPLICATE_NAME("중복되는 이름을 입력했습니다. 다시 입력해주세요."),
    INVALID_MONTH("존재하지 않는 달입니다. 다시 입력해 주세요."),
    INVALID_WEEK("존재하지 않는 요일입니다. 다시 입력해 주세요."),
    INVALID_FORM("올바르지 않은 형식으로 입력했습니다. 다시 입력해 주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return EXCEPTION_MESSAGE_PREFIX.message + message;
    }
}
