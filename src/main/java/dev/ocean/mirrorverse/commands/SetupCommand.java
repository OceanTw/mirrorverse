package dev.ocean.mirrorverse.commands;

import dev.ocean.mirrorverse.Mirrorverse;
import dev.ocean.mirrorverse.mirrors.impl.NormalMirror;
import dev.ocean.mirrorverse.utils.ItemUtils;
import dev.ocean.mirrorverse.utils.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetupCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player = (Player) commandSender;
        if (strings.length != 0) {
            switch (strings[0].toLowerCase()) {
                case "normal":
                    player.getInventory().addItem(ItemUtils.getSetupWand());
                    player.updateInventory();
                    player.sendMessage(StringUtils.handle("&7"));
                    player.sendMessage(StringUtils.handle("&5&lSetup mode enabled!"));
                    player.sendMessage(StringUtils.handle("&7I have given you the setup wand, left click to"));
                    player.sendMessage(StringUtils.handle("&7select the first position and right click to select"));
                    player.sendMessage(StringUtils.handle("&7the second position. Once you have selected the"));
                    player.sendMessage(StringUtils.handle("&7positions, type &a/setup confirm &7to confirm the"));
                    player.sendMessage(StringUtils.handle("&7selections and create the region."));
                    player.sendMessage(StringUtils.handle("&7"));
                    break;
                case "confirm":
                    player.getInventory().remove(ItemUtils.getSetupWand());
                    player.sendMessage(StringUtils.handle("&5Setup confirmed!"));
                    // TODO: Confirm for different types of mirrors
                    NormalMirror normalMirror = new NormalMirror();
                    normalMirror.setPos1(Mirrorverse.getInstance().getSelection().pos1);
                    normalMirror.setPos2(Mirrorverse.getInstance().getSelection().pos2);
                    normalMirror.setup();
                    break;
            }
        }
        return true;
    }
}
