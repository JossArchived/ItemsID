package jossc.items;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;
import jossc.items.command.ItemIdCommand;
import jossc.items.listener.EventListener;
import jossc.items.storage.SessionsStorage;
import lombok.Getter;

public class Main extends PluginBase {

  @Getter
  private static Main instance;

  @Getter
  private SessionsStorage storage;

  @Override
  public void onEnable() {
    super.onEnable();

    instance = this;
    storage = new SessionsStorage();

    getServer().getCommandMap().register(
        "itemid",
        new ItemIdCommand()
    );
    getServer().getPluginManager().registerEvents(
        new EventListener(),
        this
    );

    getLogger().info(TextFormat.GREEN + "This plugin has been enabled!");
  }

  @Override
  public void onDisable() {
    super.onDisable();

    getLogger().info(TextFormat.RED + "This plugin has been disabled!");
  }
}
