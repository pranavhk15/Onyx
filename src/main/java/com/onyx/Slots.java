package com.onyx;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Slot;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import java.util.HashMap;

public class Slots {
    private static final Slots INSTANCE = new Slots();

    public static Slots getInstance() {
        return INSTANCE;
    }

    public static class LockedSlot {
        public boolean locked = false;
        public int boundTo = -1;
    }

    public static class SlotLockData {
        public LockedSlot[] lockedSlots = new LockedSlot[40];
    }

    public static class SlotLockProfile {
        int currentProfile = 0;
        public SlotLockData[] slotLockData = new SlotLockData[9];
    }


}
