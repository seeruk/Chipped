package com.grimbo.chipped;

import java.util.HashMap;
import java.util.Map;

import com.grimbo.chipped.api.BlockRegistry;

import com.mojang.datafixers.util.Pair;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;

public class ChippedTags {

	public static final Map<String, Pair<ITag.INamedTag<Block>, ITag.INamedTag<Item>>> tags = new HashMap<>();

	public static void register() {
		for (String type : BlockRegistry.getBlockTypes()) {
			if (BlockRegistry.doesHaveTag(type)) tags.put(type, Pair.of(modBlock(type), modItem(type)));
		}
	}

	private static ITag.INamedTag<Block> modBlock(String id) {
		return BlockTags.bind(Chipped.MOD_ID + ":" + id);
	}

	private static ITag.INamedTag<Item> modItem(String id) {
		return ItemTags.bind(Chipped.MOD_ID + ":" + id);
	}
}
