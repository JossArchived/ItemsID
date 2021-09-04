package jossc.items.command;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.TextFormat;
import jossc.items.Main;
import jossc.items.storage.SessionsStorage;
import jossc.items.utils.Utils;

public class ItemIdCommand extends Command {

  private final SessionsStorage storage;

  public ItemIdCommand() {
    super(
        "itemid",
        "Show the id of the item you have in your hand",
        "/itemid",
        new String[] {"ii"}
    );

    storage = Main.getInstance().getStorage();
  }

  @Override
  public boolean execute(CommandSender sender, String label, String[] args) {
    if (!(sender instanceof Player)) {
      sender.sendMessage(TextFormat.RED + "Please, use this command in-game!");

      return false;
    }

    Player player = (Player) sender;

    if (args.length < 1) {
      Utils.sendItemInformation(player, player.getInventory().getItemInHand());

      return true;
    }

    switch (args[0].toLowerCase()) {
      case "toggle":
        if (storage.contains(player)) {
          storage.remove(player);

          player.sendMessage(
              TextFormat.RED + "The information of the item you have in hand will no longer be shown to you!"
          );

          return true;
        }

        storage.add(player);

        player.sendMessage(
            TextFormat.GREEN + "Now the information of any item you have in hand will be displayed!"
        );
        break;
      case "help":
        player.sendMessage(TextFormat.BOLD.toString() + TextFormat.YELLOW + "Item Id Commands List");

        String prefix = TextFormat.DARK_GRAY + "-" + TextFormat.GRAY + "/" + label;
        player.sendMessage(prefix + " toggle");
        player.sendMessage(prefix + " help");
        break;
      default:
        player.sendMessage(TextFormat.RED + "Unknown sub-command!");
        break;
    }

    return false;
  }
}
