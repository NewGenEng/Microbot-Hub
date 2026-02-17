package net.runelite.client;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import net.runelite.client.plugins.fishing.FishingPlugin;
import net.runelite.client.plugins.microbot.aiofighter.AIOFighterPlugin;
import net.runelite.client.plugins.microbot.astralrc.AstralRunesPlugin;
import net.runelite.client.plugins.microbot.autofishing.AutoFishingPlugin;
import net.runelite.client.plugins.microbot.example.ExamplePlugin;
import net.runelite.client.plugins.microbot.mke_wintertodt.MKE_WintertodtPlugin;
import net.runelite.client.plugins.microbot.roguesden.RoguesDenPlugin;
import net.runelite.client.plugins.microbot.thievingstalls.StallThievingPlugin;

public class Microbot {

    private static final Class<?>[] debugPlugins = {
            AIOFighterPlugin.class,
            RoguesDenPlugin.class
    };

    public static void main(String[] args) throws Exception {
        List<Class<?>> _debugPlugins = Arrays.stream(debugPlugins).collect(Collectors.toList());
        RuneLiteDebug.pluginsToDebug.addAll(_debugPlugins);
        RuneLiteDebug.main(args);
    }
}
