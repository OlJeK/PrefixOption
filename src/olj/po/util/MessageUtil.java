package olj.po.util;

import com.google.common.collect.Lists;
import olj.main.df.spigot.PluginInfo;
import olj.main.df.spigot.util.ConfigUtil;
import olj.po.config.Config;

public class MessageUtil {

    public static Config fillDefaultConfig(PluginInfo pluginInfo) {
        ConfigUtil configUtil = pluginInfo.getConfigUtil();
        ConfigUtil messagesUtil = pluginInfo.getConfigUtil("message");

        configUtil.addDefault("permissions.default_prefix", "prefix.default");
        configUtil.addDefault("permissions.colored_prefix", "prefix.colored");

        messagesUtil.addDefault("no_permission", "&cУ Вас нет прав!");
        messagesUtil.addDefault("prefix_contains_forbidden_words", "&cУказанный префикс содержит запрещенные символы!");
        messagesUtil.addDefault("prefix_max_length", "&cУказанный префикс слишком длинный!");
        messagesUtil.addDefault("prefix_min_length", "&cУказанный префикс слишком короткий!");
        messagesUtil.addDefault("prefix_changed", "&aВаш префикс успешно был изменен на: &f%prefix%!");
        messagesUtil.addDefault("prefix_clear", "&aВаш префикс изменен на префикс группы!");
        messagesUtil.addDefault("example_command", Lists.newArrayList("&a/prefix set $prefix$ &7- устанавливает префикс",
                "&a/prefix clear &7- очищает префикс"));

        return new Config((String) configUtil.getFileManager().get("permissions.default_prefix"),
                (String) configUtil.getFileManager().get("permissions.colored_prefix"));
    }

}
