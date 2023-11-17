package electrolyte.greate;

import com.mojang.logging.LogUtils;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.providers.ProviderType;
import electrolyte.greate.foundation.advancement.GreateAdvancements;
import electrolyte.greate.foundation.data.GreateTagGen;
import electrolyte.greate.foundation.data.GreateTagGen.GreateBlockTagGen;
import electrolyte.greate.foundation.data.recipe.GreateMechanicalCraftingRecipeGen;
import electrolyte.greate.foundation.data.recipe.GreateStandardRecipeGen;
import electrolyte.greate.infrastructure.config.GreateConfigs;
import electrolyte.greate.registry.*;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(Greate.MOD_ID)
public class Greate {

    public static final String MOD_ID = "greate";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(Greate.MOD_ID);

    public Greate() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::gatherData);
        // CREATIVE_TABS.register(eventBus);
        REGISTRATE.registerEventListeners(eventBus);
        GreateLang.register();
        GreateTags.init();
        Belts.register();
        Cogwheels.register();
        CrushingWheels.register();
        Gearboxes.register();
        Girders.register();
        MechanicalPresses.register();
        Millstones.register();
        Shafts.register();
        ModBlockEntityTypes.register();
        ModItems.register();
        ModRecipeTypes.register(eventBus);
        GreateConfigs.register(ModLoadingContext.get());
    }

    public static final CreativeModeTab GREATE_TAB = new CreativeModeTab("greate") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.GOLDEN_APPLE);
        }
    };

    private void clientSetup(FMLClientSetupEvent event) {
        GreatePartialModels.register();
    }

    private void gatherData(GatherDataEvent event) {
        if(event.includeServer()) {
            REGISTRATE.addDataGenerator(ProviderType.LANG, p -> GreateAdvancements.provideLang(p::add));
            event.getGenerator().addProvider(true, new GreateAdvancements(event.getGenerator()));
            event.getGenerator().addProvider(true, new GreateStandardRecipeGen(event.getGenerator()));
            event.getGenerator().addProvider(true, new GreateMechanicalCraftingRecipeGen(event.getGenerator()));
            GreateBlockTagGen blockTags = new GreateBlockTagGen(event.getGenerator(), Greate.MOD_ID, event.getExistingFileHelper());
            event.getGenerator().addProvider(true, blockTags);
            event.getGenerator().addProvider(true, new GreateTagGen(event.getGenerator(), blockTags, Greate.MOD_ID, event.getExistingFileHelper()));
        }
    }
}