package electrolyte.greate.content.kinetics.press;

import com.jozufozu.flywheel.api.MaterialManager;
import com.jozufozu.flywheel.api.instance.DynamicInstance;
import com.jozufozu.flywheel.core.Materials;
import com.jozufozu.flywheel.core.materials.oriented.OrientedData;
import com.mojang.math.Quaternion;
import com.mojang.math.Vector3f;
import com.simibubi.create.content.kinetics.press.PressingBehaviour;
import com.simibubi.create.foundation.utility.AngleHelper;
import com.simibubi.create.foundation.utility.AnimationTickHolder;
import electrolyte.greate.content.kinetics.base.TieredShaftInstance;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class TieredMechanicalPressInstance extends TieredShaftInstance<TieredMechanicalPressBlockEntity> implements DynamicInstance {

    private final OrientedData pressHead;

    public TieredMechanicalPressInstance(MaterialManager materialManager, TieredMechanicalPressBlockEntity blockEntity) {
        super(materialManager, blockEntity);
        pressHead = materialManager.defaultSolid().material(Materials.ORIENTED).getModel(((TieredMechanicalPressBlock)blockEntity.getBlockState().getBlock()).getPartialModel(), blockState).createInstance();
        BlockState blockState = blockEntity.getBlockState();
        float angle = AngleHelper.horizontalAngle(blockState.getValue(BlockStateProperties.HORIZONTAL_FACING));
        Quaternion q = Vector3f.YP.rotationDegrees(angle);
        pressHead.setRotation(q);
        transformModels();
    }

    @Override
    public void beginFrame() {
        transformModels();
    }

    private void transformModels() {
        float renderedHeadOffset = getRenderedHeadOffset(blockEntity);
        pressHead.setPosition(getInstancePosition()).nudge(0, -renderedHeadOffset, 0);
    }

    private float getRenderedHeadOffset(TieredMechanicalPressBlockEntity press) {
        PressingBehaviour pressingBehaviour = press.getPressingBehaviour();
        return pressingBehaviour.getRenderedHeadOffset(AnimationTickHolder.getPartialTicks()) * pressingBehaviour.mode.headOffset;
    }

    @Override
    public void updateLight() {
        super.updateLight();
        relight(pos, pressHead);
    }

    @Override
    protected void remove() {
        super.remove();
        pressHead.delete();
    }
}
