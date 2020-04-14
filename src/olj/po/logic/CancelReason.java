package olj.po.logic;

public class CancelReason {

    private String reason;
    private boolean isCancel;

    public CancelReason(String reason, boolean isCancel) {
        this.reason = reason;
        this.isCancel = isCancel;
    }

    public String getReason() {
        return reason;
    }

    public boolean isCancel() {
        return isCancel;
    }

}
