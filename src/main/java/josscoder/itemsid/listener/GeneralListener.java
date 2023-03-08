package josscoder.itemsid.listener;

import cn.nukkit.Player;
import cn.nukkit.block.BlockID;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerItemHeldEvent;
import cn.nukkit.item.Item;
import cn.nukkit.utils.TextFormat;
import josscoder.itemsid.ItemsIDPlugin;

public class GeneralListener implements Listener {

  @EventHandler
  public void onItemHeld(PlayerItemHeldEvent event) {
    Item item = event.getItem();
    if (item.getId() == BlockID.AIR) {
      return;
    }

    Player player = event.getPlayer();

    if (!player.namedTag.getBoolean(ItemsIDPlugin.NBT_ITEMS_ID)) {
      return;
    }

    player.sendActionBar(TextFormat.colorize(String.format("&9%s\n&r&7%s:%s", item.getName(), item.getId(), item.getDamage())));
  }
}
