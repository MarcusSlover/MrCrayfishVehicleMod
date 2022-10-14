package com.mrcrayfish.vehicle.entity.vehicle.pizza.service;

import com.mrcrayfish.vehicle.entity.LandVehicleEntity;
import com.mrcrayfish.vehicle.entity.vehicle.pizza.PizzaCarEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

/**
 * Author: MrCrayfish & MarcusSlover
 */
public class AngelCarEntity extends PizzaCarEntity<AngelCarEntity>
{
    public AngelCarEntity(EntityType<AngelCarEntity> type, World worldIn)
    {
        super(type, worldIn);
    }
}
