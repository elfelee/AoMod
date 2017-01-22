package com.ao.aomod;

import com.ao.aomod.proxy.CommonProxy;
import com.ao.aomod.tab.CreativeTabAo;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Mod.MOD_ID, version = Mod.MOD_VER, name = Mod.MOD_NAME)
public class Mod {
    public static final String MOD_ID = "ao";
    public static final String MOD_VER = "0.1";
    public static final String MOD_NAME = "Ao mod";

    @SidedProxy(clientSide = "com.ao.aomod.proxy.ClientProxy", serverSide = "com.ao.aomod.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static Mod instance;

    public static CreativeTabAo tabAo;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        tabAo = new CreativeTabAo(CreativeTabs.getNextID(), "tabAo");
        ModItems.preInit();
        ModBlocks.preInit();
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new TutorialModEventHandler());
        proxy.postInit(event);
    }
}
