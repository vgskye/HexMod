package at.petrak.hexcasting.mixin;

import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.item.trading.MerchantOffers;

import at.petrak.hexcasting.xplat.IXplatAbstractions;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// Prevents the villager from having any offers if it's brainswept
@Mixin(AbstractVillager.class)
public class MixinAbstractVillager {
	@Inject(method = "getOffers", at = @At("HEAD"), cancellable = true)
	private void nixOffers(CallbackInfoReturnable<MerchantOffers> cir) {
		var self = (AbstractVillager) (Object) this;
		if (IXplatAbstractions.INSTANCE.isBrainswept(self)) {
			cir.setReturnValue(new MerchantOffers());
		}
	}
}
