package at.petrak.hexcasting.mixin;

import net.minecraft.world.entity.monster.Witch;

import at.petrak.hexcasting.xplat.IXplatAbstractions;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

// Prevents the witch from drinking potions
@Mixin(Witch.class)
public class MixinWitch {
	@Redirect(
			method = "aiStep",
			at =
					@At(
							value = "INVOKE",
							target = "Lnet/minecraft/world/entity/monster/Witch;" + "isAlive()Z"))
	private boolean isAliveForAiPurposes(Witch instance) {
		var self = (Witch) (Object) this;
		return self.isAlive() && !IXplatAbstractions.INSTANCE.isBrainswept(self);
	}
}
