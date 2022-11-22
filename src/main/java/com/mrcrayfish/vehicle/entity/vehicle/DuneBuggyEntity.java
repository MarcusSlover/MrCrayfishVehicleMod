package com.mrcrayfish.vehicle.entity.vehicle;

import com.mrcrayfish.vehicle.entity.EngineTier;
import com.mrcrayfish.vehicle.entity.IEngineTier;
import com.mrcrayfish.vehicle.entity.LandVehicleEntity;
import com.mrcrayfish.vehicle.entity.WheelType;
import com.mrcrayfish.vehicle.init.ModSounds;
import net.minecraft.entity.EntityType;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

import java.util.Optional;

/**
 * Author: MrCrayfish
 */
public class DuneBuggyEntity extends LandVehicleEntity
{
    public DuneBuggyEntity(EntityType<? extends DuneBuggyEntity> type, World worldIn)
    {
        super(type, worldIn);
        this.setMaxSpeed(10);
        this.maxUpStep = 0.5F;
        this.setFuelCapacity(5000F);
    }

    @Override
    public void defineSynchedData()
    {
        super.defineSynchedData();
        this.entityData.set(COLOR, 0xF2B116);
    }

    @Override
    public SoundEvent getEngineSound()
    {
        return ModSounds.ENTITY_BUMPER_CAR_ENGINE.get();
    }

    @Override
    public boolean isLockable()
    {
        return false;
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
                    return 7F;
                }
                if (tier == EngineTier.GOLD) {
                    return 6F;
                }
                if (tier == EngineTier.IRON) {
                    return 5F;
                }
            }
            maxSpeed += engineTier.get().getAdditionalMaxSpeed();
        }
        return maxSpeed;
    }
}
