package com.mrcrayfish.vehicle.entity.vehicle.pizza.pizza;

import com.mrcrayfish.vehicle.entity.EngineTier;
import com.mrcrayfish.vehicle.entity.IEngineTier;
import com.mrcrayfish.vehicle.entity.LandVehicleEntity;
import com.mrcrayfish.vehicle.entity.vehicle.pizza.PizzaCarEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

import java.util.Optional;

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

    @Override
    public float getActualMaxSpeed()
    {
        float maxSpeed = this.entityData.get(MAX_SPEED);
        Optional<IEngineTier> engineTier = this.getEngineTier();
        if(engineTier.isPresent()) {

            IEngineTier iEngineTier = engineTier.get();
            if (iEngineTier instanceof EngineTier) {
                EngineTier tier = (EngineTier) iEngineTier;
                if (tier == EngineTier.DIAMOND || tier == EngineTier.NETHERITE) {
                    return 15F;
                }
                if (tier == EngineTier.GOLD) {
                    return 13F;
                }
                if (tier == EngineTier.IRON) {
                    return 11F;
                }
            }
            maxSpeed += engineTier.get().getAdditionalMaxSpeed();
        }
        return maxSpeed;
    }
}
