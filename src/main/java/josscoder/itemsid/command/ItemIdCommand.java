package josscoder.itemsid.command;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.item.Item;
import cn.nukkit.utils.TextFormat;
import josscoder.itemsid.ItemsIDPlugin;

public class ItemIdCommand extends Command {

    public ItemIdCommand() {
        super("itemid",
                "Show the id of the item you have in your hand",
                "/itemid",
                new String[]{"ii", "itemsid"}
        );
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(TextFormat.RED + "Please, use this command in-game!");
            return false;
        }

        Player player = (Player) sender;

        if (args.length < 1) {
            Item item = player.getInventory().getItemInHand();
            player.sendPopup(TextFormat.colorize(String.format("&6%s\n&r&7%s:%s", item.getName(), item.getId(), item.getDamage())));

            return true;
        }

        switch (args[0].toLowerCase()) {
            case "toggle":
                if (player.namedTag.getBoolean(ItemsIDPlugin.NBT_ITEMS_ID)) {

                    player.namedTag.putBoolean(ItemsIDPlugin.NBT_ITEMS_ID, false);
                    player.sendMessage(TextFormat.RED + "The information of the item you have in hand will no longer be shown to you!");

                    return false;
                }

                player.namedTag.putBoolean(ItemsIDPlugin.NBT_ITEMS_ID, true);
                player.sendMessage(TextFormat.GREEN + "Now the information of any item you have in hand will be displayed!");
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
