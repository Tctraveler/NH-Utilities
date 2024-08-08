package com.xir.NHUtilities.Mixins.late;

import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.brandon3055.brandonscore.common.utills.InfoHelper;
import com.brandon3055.draconicevolution.common.items.tools.TeleporterMKII;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import cpw.mods.fml.common.Optional;

// Before modifying this code, please comment out the annotation below.
@SuppressWarnings("all")
@Mixin(value = TeleporterMKII.class, remap = true)
@Optional.Interface(iface = "baubles.api.IBauble", modid = "Baubles")
public class DE_TeleporterMKII_Mixin implements IBauble {

    @Inject(
        method = "addInformation",
        at = @At(
            value = "INVOKE",
            target = "Ljava/util/List;add(Ljava/lang/Object;)Z",
            ordinal = 3,
            shift = At.Shift.AFTER))
    private void addInfo(ItemStack teleporter, EntityPlayer player, List list2, boolean extraInformation,
        CallbackInfo ci) {
        if (InfoHelper.holdShiftForDetails(list2)) {
            list2.add(
                EnumChatFormatting.GOLD + ""
                    + EnumChatFormatting.ITALIC
                    + StatCollector.translateToLocal("info.teleporterInfBaubles.txt"));
            list2.add(
                EnumChatFormatting.GOLD + ""
                    + EnumChatFormatting.ITALIC
                    + StatCollector.translateToLocal("info.teleporterInfBaublesButton.txt"));
        }
    }

    @Override
    @Optional.Method(modid = "Baubles")
    public BaubleType getBaubleType(ItemStack itemstack) {
        return BaubleType.UNIVERSAL;
    }

    @Override
    @Optional.Method(modid = "Baubles")
    public void onWornTick(ItemStack itemstack, EntityLivingBase player) {

    }

    @Override
    @Optional.Method(modid = "Baubles")
    public void onEquipped(ItemStack itemstack, EntityLivingBase player) {

    }

    @Override
    @Optional.Method(modid = "Baubles")
    public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {

    }

    @Override
    @Optional.Method(modid = "Baubles")
    public boolean canEquip(ItemStack itemstack, EntityLivingBase player) {
        return true;
    }

    @Override
    @Optional.Method(modid = "Baubles")
    public boolean canUnequip(ItemStack itemstack, EntityLivingBase player) {
        return true;
    }
}