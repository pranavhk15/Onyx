package com.onyx;

import net.minecraft.init.Blocks;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import onyx.Command;


@Mod(modid = "Onyx", useMetadata=true)
public class OnyxMain {
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        System.out.println("Dirt: " + Blocks.dirt.getUnlocalizedName());

        ClientCommandHandler.instance.registerCommand(new Command().getCommand());
    }



}




