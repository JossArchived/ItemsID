package jossc.items.utils;

import cn.nukkit.Player;
import cn.nukkit.item.Item;

public class Utils {

  public static void sendItemInformation(Player player, Item item) {
    player.sendPopup("§9" + item.getName() +
        "\n" + "§r§7" + item.getId() + ":" + item.getDamage()
    );
  }
}
