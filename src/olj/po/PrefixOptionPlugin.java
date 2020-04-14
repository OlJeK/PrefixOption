package olj.po;

import olj.main.df.spigot.PluginInfo;
import olj.main.df.spigot.util.Language;
import olj.po.command.PrefixCommand;
import olj.po.config.Config;
import olj.po.util.MessageUtil;
import org.bukkit.plugin.java.JavaPlugin;

public class PrefixOptionPlugin extends JavaPlugin {

    private PluginInfo pluginInfo;
    private Config config;
    private Language language;

    public void onEnable() {
        pluginInfo = new PluginInfo(this);
        config = MessageUtil.fillDefaultConfig(pluginInfo);
        language = pluginInfo.getLanguage();

        pluginInfo.registerCommand(new PrefixCommand(this));
    }

    public Config getModifiedConfig() {
        return config;
    }

    public PluginInfo getPluginInfo() {
        return pluginInfo;
    }

    public Language getLanguage() {
        return language;
    }

}
