package com.xir.NHUtilities.common.items;

import net.minecraft.item.ItemStack;

import com.xir.NHUtilities.common.items.itemFuelRod.DepletedFuelRod;
import com.xir.NHUtilities.common.items.itemFuelRod.FuelRod;

public class FuelFod {

    public static DepletedFuelRod depletedFuelRodExcitedRadianceUranium;
    public static DepletedFuelRod depletedFuelRodExcitedRadianceUranium_2;
    public static DepletedFuelRod depletedFuelRodExcitedRadianceUranium_4;

    public static DepletedFuelRod depletedFuelRodSuperExcitedPrimordialPearlPlutonium;
    public static DepletedFuelRod depletedFuelRodSuperExcitedPrimordialPearlPlutonium_2;
    public static DepletedFuelRod depletedFuelRodSuperExcitedPrimordialPearlPlutonium_4;

    public static FuelRod fuelRodExcitedRadianceUranium;
    public static FuelRod fuelRodExcitedRadianceUranium_2;
    public static FuelRod fuelRodExcitedRadianceUranium_4;

    public static FuelRod fuelRodSuperExcitedPrimordialPearlPlutonium;
    public static FuelRod fuelRodSuperExcitedPrimordialPearlPlutonium_2;
    public static FuelRod fuelRodSuperExcitedPrimordialPearlPlutonium_4;

    public static void fuelRodInit() {

        depletedFuelRodExcitedRadianceUranium = new DepletedFuelRod("depletedFuelRodExcitedRadianceUranium", 100);
        depletedFuelRodExcitedRadianceUranium_2 = new DepletedFuelRod("depletedFuelRodExcitedRadianceUranium_2", 200);
        depletedFuelRodExcitedRadianceUranium_4 = new DepletedFuelRod("depletedFuelRodExcitedRadianceUranium_4", 400);

        depletedFuelRodSuperExcitedPrimordialPearlPlutonium = new DepletedFuelRod(
            "depletedFuelRodSuperExcitedPrimordialPearlPlutonium",
            800);
        depletedFuelRodSuperExcitedPrimordialPearlPlutonium_2 = new DepletedFuelRod(
            "depletedFuelRodSuperExcitedPrimordialPearlPlutonium_2",
            1600);
        depletedFuelRodSuperExcitedPrimordialPearlPlutonium_4 = new DepletedFuelRod(
            "depletedFuelRodSuperExcitedPrimordialPearlPlutonium_4",
            3200);

        fuelRodExcitedRadianceUranium = new FuelRod(
            "fuelRodExcitedRadianceUranium",
            1,
            150,
            6,
            800,
            70000,
            0F,
            new ItemStack(depletedFuelRodExcitedRadianceUranium, 1));
        fuelRodExcitedRadianceUranium_2 = new FuelRod(
            "fuelRodExcitedRadianceUranium_2",
            2,
            600,
            36,
            1600,
            70000,
            0F,
            new ItemStack(depletedFuelRodExcitedRadianceUranium_2, 1));
        fuelRodExcitedRadianceUranium_4 = new FuelRod(
            "fuelRodExcitedRadianceUranium_4",
            4,
            1800,
            144,
            3200,
            70000,
            0F,
            new ItemStack(depletedFuelRodExcitedRadianceUranium_4, 1));

        fuelRodSuperExcitedPrimordialPearlPlutonium = new FuelRod(
            "fuelRodSuperExcitedPrimordialPearlPlutonium",
            1,
            3200,
            128,
            6400,
            10000,
            1.3F,
            new ItemStack(depletedFuelRodSuperExcitedPrimordialPearlPlutonium, 1));
        fuelRodSuperExcitedPrimordialPearlPlutonium_2 = new FuelRod(
            "fuelRodSuperExcitedPrimordialPearlPlutonium_2",
            2,
            12800,
            768,
            12800,
            10000,
            3.3F,
            new ItemStack(depletedFuelRodSuperExcitedPrimordialPearlPlutonium_2, 1));
        fuelRodSuperExcitedPrimordialPearlPlutonium_4 = new FuelRod(
            "fuelRodSuperExcitedPrimordialPearlPlutonium_4",
            4,
            38400,
            3064,
            25600,
            10000,
            1.3F,
            new ItemStack(depletedFuelRodSuperExcitedPrimordialPearlPlutonium_4, 1));
    }
}
