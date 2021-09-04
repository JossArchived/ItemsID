package jossc.items.storage;

import cn.nukkit.Player;

import java.util.ArrayList;
import java.util.List;

public class SessionsStorage {

  private final List<Player> storage;

  public SessionsStorage() {
    storage = new ArrayList<>();
  }

  public boolean contains(Player player) {
    return storage.contains(player);
  }

  public void add(Player player) {
    storage.add(player);
  }

  public void remove(Player player) {
    storage.remove(player);
  }
}
