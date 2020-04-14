package olj.po.logic;

public enum Reasons {

    MIN_LENGTH("min_length"), MAX_LENGTH("max_length"), FORBIDDEN("forbidden");

    private String message;

    Reasons(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
