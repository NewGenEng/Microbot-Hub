package net.runelite.client.plugins.microbot.thievingstalls.model;

import lombok.AllArgsConstructor;
import net.runelite.api.GameObject;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.microbot.thievingstalls.StallThievingConfig;
import net.runelite.client.plugins.microbot.util.bank.Rs2Bank;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(onConstructor_ = @Inject)
public class HosidiusFruitThievingSpot implements IStallThievingSpot {
    private static WorldPoint SAFESPOT = new WorldPoint(1800, 3607, 0);
    private static final int STALL_ID = 28823;

    private BotApi botApi;
    private StallThievingConfig config;

    @Override
    public void thieve() {
        if (!botApi.walkTo(SAFESPOT))
        {
            return;
        }

        final GameObject stall = botApi.getGameObject(STALL_ID, SAFESPOT.dx(1));
        if (stall == null)
        {
            return;
        }

        botApi.steal(stall);
        botApi.sleepUntilNextTick();
    }

    @Override
    public void bank() {
        Rs2Bank.walkToBankAndUseBank();
        Rs2Bank.depositAll();
        Rs2Bank.closeBank();
    }

    @Override
    public Integer[] getItemIdsToDrop() {
        List<Integer> itemsToDrop = new ArrayList<>();

        // Check each fruit checkbox and add to drop list if selected
        if (config.dropCookingApple()) {
            itemsToDrop.add(1955); // Cooking apple
        }
        if (config.dropBanana()) {
            itemsToDrop.add(1963); // Banana
        }
        if (config.dropStrawberry()) {
            itemsToDrop.add(5504); // Strawberry
        }
        if (config.dropJangerberries()) {
            itemsToDrop.add(247); // Jangerberries
        }
        if (config.dropLemon()) {
            itemsToDrop.add(2102); // Lemon
        }
        if (config.dropRedberries()) {
            itemsToDrop.add(1951); // Redberries
        }
        if (config.dropPineapple()) {
            itemsToDrop.add(2114); // Pineapple
        }
        if (config.dropLime()) {
            itemsToDrop.add(2120); // Lime
        }
        if (config.dropGolovanvaFruit()) {
            itemsToDrop.add(19653); // Golovanova fruit top
        }
        if (config.dropPapayaFruit()) {
            itemsToDrop.add(5972); // Papaya fruit
        }
        if (config.dropStrangeFruit()) {
            itemsToDrop.add(464); // Strange fruit
        }

        return itemsToDrop.toArray(new Integer[0]);
    }
}
