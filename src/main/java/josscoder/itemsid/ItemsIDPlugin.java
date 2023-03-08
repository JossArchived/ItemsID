package josscoder.itemsid;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;
import josscoder.itemsid.command.ItemIdCommand;
import josscoder.itemsid.listener.GeneralListener;
import lombok.Getter;

public class ItemsIDPlugin extends PluginBase {

    public static final String NBT_ITEMS_ID = "itemsIdToggle";

    @Getter
    private static ItemsIDPlugin instance;

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        getServer().getCommandMap().register("itemid", new ItemIdCommand());
        getServer().getPluginManager().registerEvents(new GeneralListener(), this);

        getLogger().info(TextFormat.GREEN + "ItemsID has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info(TextFormat.RED + "ItemsID has been disabled!");
    }
}
