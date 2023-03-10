package org.multicoder.mcpaintball.item.weapons.pistol;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.multicoder.mcpaintball.entity.BluePaintballArrowEntity;
import org.multicoder.mcpaintball.init.soundinit;
import org.multicoder.mcpaintball.init.tabinit;

public class BluePistol extends Item
{

    public BluePistol()
    {
        super(new FabricItemSettings().group(tabinit.paintball));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand)
    {
        user.playSound(soundinit.SINGLE,1.0f,1.0f);
        PersistentProjectileEntity AAE = new BluePaintballArrowEntity(world,user);
        AAE.setVelocity(user.getPitch(),user.getYaw(),user.getRoll(),3.0f,0.0f);
        world.spawnEntity(AAE);
        user.getItemCooldownManager().set(this,20);
        return TypedActionResult.pass(user.getStackInHand(hand));
    }
}
