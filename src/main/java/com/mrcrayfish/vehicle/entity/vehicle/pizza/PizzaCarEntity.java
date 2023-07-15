package com.mrcrayfish.vehicle.entity.vehicle.pizza;

import com.mrcrayfish.vehicle.common.Seat;
import com.mrcrayfish.vehicle.common.SeatTracker;
import com.mrcrayfish.vehicle.entity.LandVehicleEntity;
import com.mrcrayfish.vehicle.entity.VehicleProperties;
import com.mrcrayfish.vehicle.init.ModSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import java.util.List;

public abstract class PizzaCarEntity<T extends Entity> extends LandVehicleEntity {

    public PizzaCarEntity(EntityType<T> entityType, World worldIn) {
        super(entityType, worldIn);
        if (this.isTransporter()) {
            VehicleProperties properties = this.getProperties();
            if (properties != null) {
                List<Seat> seats = properties.getSeats();
                for (Seat seat : seats) {
                    Vector3d position = seat.getPosition();
                    seat.setPosition(new Vector3d(position.x, 4.0, position.z));
                }
                for (Entity passenger : this.getPassengers()) {
                    updatePassengerPosition(passenger);
                }
            }
        }
    }

    @Override
    public SoundEvent getEngineSound()
    {
        return ModSounds.ENTITY_SPEED_BOAT_ENGINE.get();
    }

    @Override
    public float getMinEnginePitch()
    {
        return 0.8F;
    }

    @Override
    public float getMaxEnginePitch()
    {
        return 1.6F;
    }

    @Override
    public boolean canBeColored()
    {
        return true;
    }

    @Override
    public boolean canMountTrailer()
    {
        return false;
    }
}
