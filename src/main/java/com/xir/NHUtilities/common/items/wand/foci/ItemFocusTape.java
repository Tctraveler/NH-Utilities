package com.xir.NHUtilities.common.items.wand.foci;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gregtech.api.metatileentity.BaseMetaTileEntity;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_Hatch_Maintenance;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.wands.ItemFocusBasic;
import thaumcraft.common.items.wands.ItemWandCasting;

public class ItemFocusTape extends ItemFocusBasic {

    private final String name = "focus_tape";
    private static final AspectList cost = new AspectList().add(Aspect.ORDER, 500);

    public ItemFocusTape() {
        setMaxDamage(0);
        setMaxStackSize(1);
        setNoRepair();
        setCreativeTab(CreativeTabs.tabTools);
        setUnlocalizedName(name);
    }

    @Override
    public AspectList getVisCost(ItemStack focus) {
        return cost;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister iconRegister) {
        icon = iconRegister.registerIcon("nhutilities:" + name);
    }

    @Override
    public String getSortingHelper(final ItemStack itemStack) {
        return "TAPE" + super.getSortingHelper(itemStack);
    }

    @Override
    public boolean isVisCostPerTick(ItemStack focusstack) {
        return false;
    }

    @Override
    public WandFocusAnimation getAnimation(ItemStack focusstack) {
        return WandFocusAnimation.CHARGE;
    }

    @Override
    public int getFocusColor(ItemStack focusstack) {
        return 0x404040;
    }

    @Override
    public ItemStack onFocusRightClick(ItemStack wandstack, World world, EntityPlayer player,
        MovingObjectPosition movingobjectposition) {
        if (world.isRemote || movingobjectposition == null) {
            return wandstack;
        }
        ItemWandCasting wandCasting = (ItemWandCasting) wandstack.getItem();
        int x = movingobjectposition.blockX;
        int y = movingobjectposition.blockY;
        int z = movingobjectposition.blockZ;
        TileEntity mTileEntity = world.getTileEntity(x, y, z);
        if (!(mTileEntity instanceof BaseMetaTileEntity mBaseMetaTileEntity)) {
            return wandstack;
        }
        if (wandCasting != null
            && (mBaseMetaTileEntity
                .getMetaTileEntity() instanceof GT_MetaTileEntity_Hatch_Maintenance gt_metaTileEntity_hatch_maintenance)
            && (!gt_metaTileEntity_hatch_maintenance.mWrench || !gt_metaTileEntity_hatch_maintenance.mSolderingTool
                || !gt_metaTileEntity_hatch_maintenance.mSoftHammer
                || !gt_metaTileEntity_hatch_maintenance.mHardHammer
                || !gt_metaTileEntity_hatch_maintenance.mScrewdriver
                || !gt_metaTileEntity_hatch_maintenance.mCrowbar
                || gt_metaTileEntity_hatch_maintenance.getBaseMetaTileEntity()
                    .isActive())) {
            if (wandCasting.consumeAllVis(wandstack, player, this.getVisCost(wandstack), true, false)) {
                gt_metaTileEntity_hatch_maintenance.mHardHammer = true;
                gt_metaTileEntity_hatch_maintenance.mCrowbar = true;
                gt_metaTileEntity_hatch_maintenance.mScrewdriver = true;
                gt_metaTileEntity_hatch_maintenance.mSoftHammer = true;
                gt_metaTileEntity_hatch_maintenance.mSolderingTool = true;
                gt_metaTileEntity_hatch_maintenance.mWrench = true;
                gt_metaTileEntity_hatch_maintenance.getBaseMetaTileEntity()
                    .setActive(false);
                world.playSoundEffect(x, y, z, "thaumcraft:wand", 1.0F, 1.0F);
            }
        }
        return wandstack;
    }

    @Override
    public int getActivationCooldown(ItemStack stack) {
        return 100;
    }
}
