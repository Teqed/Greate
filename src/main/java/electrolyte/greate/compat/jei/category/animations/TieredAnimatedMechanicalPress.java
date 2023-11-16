package electrolyte.greate.compat.jei.category.animations;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.compat.jei.category.animations.AnimatedKinetics;
import com.simibubi.create.foundation.utility.AnimationTickHolder;
import electrolyte.greate.content.kinetics.press.TieredMechanicalPressBlock;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class TieredAnimatedMechanicalPress extends AnimatedKinetics {

    private boolean basin;
    private final TieredMechanicalPressBlock block;

    public TieredAnimatedMechanicalPress(TieredMechanicalPressBlock block, boolean basin) {
        this.block = block;
        this.basin = basin;
    }

    @Override
    public void draw(PoseStack poseStack, int xOffset, int yOffset) {
        poseStack.pushPose();
        poseStack.translate(xOffset, yOffset, 200);
        poseStack.mulPose(Vector3f.XP.rotationDegrees(-15.5f));
        poseStack.mulPose(Vector3f.YP.rotationDegrees(22.5f));
        int scale = basin ? 23 : 24;

        blockElement(shaft(block)).rotateBlock(0, 0, getCurrentAngle()).scale(scale).render(poseStack);
        blockElement(block.defaultBlockState()).scale(scale).render(poseStack);
        blockElement(block.getPartialModel())
                .atLocal(0, -getAnimatedHeadOffset(), 0).scale(scale).render(poseStack);

        if (basin) {
            blockElement(AllBlocks.BASIN.getDefaultState()).atLocal(0, 1.65, 0).scale(scale).render(poseStack);
        }

        poseStack.popPose();
    }

    private float getAnimatedHeadOffset() {
        float cycle = (AnimationTickHolder.getRenderTime() - offset * 8) % 30;
        if (cycle < 10) {
            float progress = cycle / 10;
            return -(progress * progress * progress);
        }
        if (cycle < 15)
            return -1;
        if (cycle < 20)
            return -1 + (1 - ((20 - cycle) / 5));
        return 0;
    }

    private BlockState shaft(Block block) {
        return ((TieredMechanicalPressBlock) block).getShaft().defaultBlockState().setValue(BlockStateProperties.AXIS, Direction.Axis.Z);
    }
}
