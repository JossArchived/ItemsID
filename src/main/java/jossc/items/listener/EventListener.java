package jossc.items.listener;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerItemHeldEvent;
import jossc.items.Main;
import jossc.items.storage.SessionsStorage;
import jossc.items.utils.Utils;

public class EventListener implements Listener {

  private final SessionsStorage storage;

  public EventListener() {
    storage = Main.getInstance().getStorage();
  }

  @EventHandler
  public void onItemHeld(PlayerItemHeldEvent event) {
    Player player = event.getPlayer();

    if (storage.contains(player)) {
      Utils.sendItemInformation(player, event.getItem());
    }
  }
}
