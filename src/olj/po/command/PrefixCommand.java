package olj.po.command;

import olj.main.df.spigot.command.APICommand;
import olj.main.df.spigot.util.LanguageReplace;
import olj.main.df.util.StringUtil;
import olj.po.PrefixOptionPlugin;
import olj.po.logic.CancelReason;
import olj.po.logic.PrefixManager;
import olj.po.logic.Reasons;
import org.bukkit.entity.Player;

public class PrefixCommand extends APICommand {

    private PrefixOptionPlugin plugin;

    public PrefixCommand(PrefixOptionPlugin plugin) {
        super("prefix");
        this.plugin = plugin;
    }

    @Override
    public void execute(Player player, String[] args) {
        if (!player.hasPermission(plugin.getModifiedConfig().getDefaultPermission())) {
            player.sendMessage(plugin.getLanguage().getColoredMessage("no_permission"));
            return;
        }

        if (args.length < 1) {
            plugin.getLanguage().sendMessage(player, "example_command");
            return;
        }

        switch (args[0].toLowerCase()) {
            case "set": {
                if (args.length < 2) {
                    plugin.getLanguage().sendMessage(player, "example_command");
                    return;
                }

                String prefix = args[1];
                PrefixManager prefixManager = new PrefixManager(player, plugin);
                CancelReason reason = prefixManager.checkPrefix(prefix);

                if (reason.isCancel()) {
                    String reasonString = reason.getReason();

                    if (reasonString.equals(Reasons.FORBIDDEN.getMessage())) {
                        player.sendMessage(plugin.getLanguage().getColoredMessage("prefix_contains_forbidden_words"));
                        return;
                    } else if (reasonString.equals(Reasons.MAX_LENGTH.getMessage())) {
                        player.sendMessage(plugin.getLanguage().getColoredMessage("prefix_max_length"));
                        return;
                    } else if (reasonString.equals(Reasons.MAX_LENGTH.getMessage())) {
                        player.sendMessage(plugin.getLanguage().getColoredMessage("prefix_min_length"));
                        return;
                    }

                    return;
                }

                prefixManager.changePrefix(prefix);
                player.sendMessage(plugin.getLanguage().getReplacedMessage("prefix_changed", new LanguageReplace("%prefix%", StringUtil.inColor(prefix))));
                return;
            }

            case "clear": {
                PrefixManager prefixManager = new PrefixManager(player, plugin);

                prefixManager.clearPrefix();
                player.sendMessage(plugin.getLanguage().getColoredMessage("prefix_clear"));
                return;
            }

            default: {
                plugin.getLanguage().sendMessage(player, "example_command");
                return;
            }
        }
    }

}
