package electrolyte.greate.foundation.data;

import electrolyte.greate.registry.GreateTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.resources.ResourceLocation;

public class GreateTagGen extends ItemTagsProvider {

    public GreateTagGen(DataGenerator dataGenerator, BlockTagsProvider blockTagProvider, String modId, ExistingFileHelper existingFileHelper) {
        super(dataGenerator, blockTagProvider, modId, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(GreateTags.forgeItemTag("plates/tungstensteel"))
                .addOptionalTag(new ResourceLocation("forge", "plates/tungsten_steel"));
        tag(GreateTags.forgeItemTag("nuggets/tungstensteel"))
                .addOptionalTag(new ResourceLocation("forge", "nuggets/tungsten_steel"));
    }

    public static class GreateBlockTagGen extends BlockTagsProvider {

        public GreateBlockTagGen(DataGenerator dataGenerator, String modId, ExistingFileHelper existingFileHelper) {
            super(dataGenerator, modId, existingFileHelper);
        }

        @Override
        protected void addTags() {}
    }
}