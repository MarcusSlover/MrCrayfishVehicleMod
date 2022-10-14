package com.mrcrayfish.vehicle.entity.vehicle.pizza.pizza;

import com.mrcrayfish.vehicle.entity.LandVehicleEntity;
import com.mrcrayfish.vehicle.entity.vehicle.pizza.PizzaCarEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

/**
 * Author: MrCrayfish & MarcusSlover
 */
public class PizzaBrewCarEntity extends PizzaCarEntity<PizzaBrewCarEntity>
{
    public PizzaBrewCarEntity(EntityType<PizzaBrewCarEntity> type, World worldIn)
    {
        super(type, worldIn);
    }

    @Override
    public boolean isTransporter() {
        return true;
    }
}
