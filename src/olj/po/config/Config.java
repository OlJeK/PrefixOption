package olj.po.config;

public class Config {

    private String defaultPermission;
    private String coloredPermission;

    public Config(String defaultPermission, String coloredPermission) {
        this.defaultPermission = defaultPermission;
        this.coloredPermission = coloredPermission;
    }

    public String getColoredPermission() {
        return coloredPermission;
    }

    public String getDefaultPermission() {
        return defaultPermission;
    }

}
