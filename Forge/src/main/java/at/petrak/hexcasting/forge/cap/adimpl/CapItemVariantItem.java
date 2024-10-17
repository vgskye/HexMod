package at.petrak.hexcasting.forge.cap.adimpl;

import net.minecraft.world.item.ItemStack;

import at.petrak.hexcasting.api.addldata.ADVariantItem;
import at.petrak.hexcasting.api.item.VariantItem;

public record CapItemVariantItem(VariantItem variantItem, ItemStack stack)
		implements ADVariantItem {
	@Override
	public int numVariants() {
		return variantItem.numVariants();
	}

	@Override
	public int getVariant() {
		return variantItem.getVariant(stack);
	}

	@Override
	public void setVariant(int variant) {
		variantItem.setVariant(stack, variant);
	}
}
