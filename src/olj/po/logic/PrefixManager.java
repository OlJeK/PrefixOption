package olj.po.logic;

import olj.main.df.util.StringUtil;
import olj.po.PrefixOptionPlugin;
import org.bukkit.entity.Player;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class PrefixManager {

    private Player p;
    private PrefixOptionPlugin plugin;
    public static final String SYMBOLS = "&QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm";

    public PrefixManager(Player p, PrefixOptionPlugin plugin) {
        this.p = p;
        this.plugin = plugin;
    }

    public CancelReason checkPrefix(String prefix) {
        if (prefix.length() < 3)
            return new CancelReason(Reasons.MIN_LENGTH.getMessage(), true);

        if (prefix.length() > 5)
            return new CancelReason(Reasons.MAX_LENGTH.getMessage(), true);

        for (char c: prefix.toCharArray()) {
            if (!SYMBOLS.contains(String.valueOf(c)))
                return new CancelReason(Reasons.FORBIDDEN.getMessage(), true);
        }

        return new CancelReason(null, false);
    }

    public void changePrefix(String nextPrefix) {
        PermissionUser user = PermissionsEx.getUser(p);

        if (user == null)
            return;

        user.setPrefix(StringUtil.inColor(nextPrefix), null);
    }

    public void clearPrefix() {
        PermissionUser user = PermissionsEx.getUser(p);

        if (user == null)
            return;

        user.setPrefix(null, null);
    }

}