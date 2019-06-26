package com.turkey.flintBlock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(FlintBlockCore.MODID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class FlintBlockCore
{
	public static final String MODID = "flintblock";

	public static Block theBlock;

	@SubscribeEvent
	public static void onBlockRegistry(RegistryEvent.Register<Block> e)
	{
		theBlock = new Block(Block.Properties.create(Material.GROUND).hardnessAndResistance(5));
		theBlock.setRegistryName(MODID, "flint_block");
		e.getRegistry().register(theBlock);
	}

	@SubscribeEvent
	public static void onItemRegistry(RegistryEvent.Register<Item> e)
	{
		ItemBlock ib = new ItemBlock(theBlock, (new Item.Properties()).group(ItemGroup.BUILDING_BLOCKS));
		ib.setRegistryName(theBlock.getRegistryName());
		e.getRegistry().register(ib);
	}
}