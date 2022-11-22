package com.mrcrayfish.vehicle.entity.vehicle.pizza.police;

import com.mrcrayfish.vehicle.entity.LandVehicleEntity;
import com.mrcrayfish.vehicle.entity.vehicle.pizza.PizzaCarEntity;
import com.mrcrayfish.vehicle.init.ModSounds;
import net.minecraft.entity.EntityType;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

/**
 * Author: MrCrayfish & MarcusSlover
 */
public class PoliceCarEntity extends PizzaCarEntity<PoliceCarEntity>
{
    public PoliceCarEntity(EntityType<PoliceCarEntity> type, World worldIn)
    {
        super(type, worldIn);
    }

    public SoundEvent getHornSound()
    {
        return ModSounds.ENTITY_POLICE_HORN.get();
    }
}
