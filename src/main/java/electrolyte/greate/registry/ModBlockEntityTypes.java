package electrolyte.greate.registry;

import com.simibubi.create.content.kinetics.base.KineticBlockEntityRenderer;
import com.simibubi.create.content.kinetics.base.ShaftRenderer;
import com.simibubi.create.content.kinetics.simpleRelays.encased.EncasedCogRenderer;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
import electrolyte.greate.content.kinetics.base.TieredShaftInstance;
import electrolyte.greate.content.kinetics.base.TieredSingleRotatingInstance;
import electrolyte.greate.content.kinetics.gearbox.TieredGearboxBlockEntity;
import electrolyte.greate.content.kinetics.gearbox.TieredGearboxInstance;
import electrolyte.greate.content.kinetics.gearbox.TieredGearboxRenderer;
import electrolyte.greate.content.kinetics.millstone.TieredMillstoneBlockEntity;
import electrolyte.greate.content.kinetics.millstone.TieredMillstoneCogInstance;
import electrolyte.greate.content.kinetics.millstone.TieredMillstoneRenderer;
import electrolyte.greate.content.kinetics.simpleRelays.*;
import electrolyte.greate.content.kinetics.simpleRelays.encased.TieredEncasedCogInstance;
import electrolyte.greate.content.kinetics.simpleRelays.encased.TieredEncasedCogRenderer;
import electrolyte.greate.content.kinetics.steamEngine.TieredPoweredShaftBlockEntity;

import static electrolyte.greate.Greate.REGISTRATE;

public class ModBlockEntityTypes {

    public static final BlockEntityEntry<TieredBracketedKineticBlockEntity> TIERED_KINETIC = REGISTRATE
            .blockEntity("tiered_kinetic", TieredBracketedKineticBlockEntity::new)
            .instance(() -> TieredBracketedKineticBlockEntityInstance::new, false)
            .validBlocks(Shafts.ANDESITE_SHAFT, Shafts.STEEL_SHAFT, Shafts.ALUMINIUM_SHAFT, Shafts.STAINLESS_STEEL_SHAFT,
                    Shafts.TITANIUM_SHAFT, Shafts.TUNGSTEN_STEEL_SHAFT, Shafts.PALLADIUM_SHAFT, Shafts.NAQUADAH_SHAFT,
                    Shafts.DARMSTADTIUM_SHAFT, Shafts.NEUTRONIUM_SHAFT, Cogwheels.ANDESITE_COGWHEEL, Cogwheels.LARGE_ANDESITE_COGWHEEL,
                    Cogwheels.STEEL_COGWHEEL, Cogwheels.LARGE_STEEL_COGWHEEL, Cogwheels.ALUMINIUM_COGWHEEL, Cogwheels.LARGE_ALUMINIUM_COGWHEEL,
                    Cogwheels.STAINLESS_STEEL_COGWHEEL, Cogwheels.LARGE_STAINLESS_STEEL_COGWHEEL, Cogwheels.TITANIUM_COGWHEEL, Cogwheels.LARGE_TITANIUM_COGWHEEL,
                    Cogwheels.TUNGSTEN_STEEL_COGWHEEL, Cogwheels.LARGE_TUNGSTEN_STEEL_COGWHEEL, Cogwheels.PALLADIUM_COGWHEEL, Cogwheels.LARGE_PALLADIUM_COGWHEEL,
                    Cogwheels.NAQUADAH_COGWHEEL, Cogwheels.LARGE_NAQUADAH_COGWHEEL, Cogwheels.DARMSTADTIUM_COGWHEEL, Cogwheels.LARGE_DARMSTADTIUM_COGWHEEL,
                    Cogwheels.NEUTRONIUM_COGWHEEL, Cogwheels.LARGE_NEUTRONIUM_COGWHEEL)
            .renderer(() -> TieredBracketedKineticBlockEntityRenderer::new)
            .register();
    public static final BlockEntityEntry<TieredKineticBlockEntity> TIERED_ENCASED_SHAFT = REGISTRATE
            .blockEntity("tiered_encased_shaft", TieredKineticBlockEntity::new)
            .instance(() -> TieredShaftInstance::new, false)
            .validBlocks(Shafts.ANDESITE_ENCASED_ANDESITE_SHAFT, Shafts.BRASS_ENCASED_ANDESITE_SHAFT, Shafts.ANDESITE_ENCASED_STEEL_SHAFT, Shafts.BRASS_ENCASED_STEEL_SHAFT,
                    Shafts.ANDESITE_ENCASED_ALUMINIUM_SHAFT, Shafts.BRASS_ENCASED_ALUMINIUM_SHAFT, Shafts.ANDESITE_ENCASED_STAINLESS_STEEL_SHAFT, Shafts.BRASS_ENCASED_STAINLESS_STEEL_SHAFT,
                    Shafts.ANDESITE_ENCASED_TITANIUM_SHAFT, Shafts.BRASS_ENCASED_TITANIUM_SHAFT, Shafts.ANDESITE_ENCASED_TUNGSTEN_STEEL_SHAFT, Shafts.BRASS_ENCASED_TUNGSTEN_STEEL_SHAFT,
                    Shafts.ANDESITE_ENCASED_PALLADIUM_SHAFT, Shafts.BRASS_ENCASED_PALLADIUM_SHAFT, Shafts.ANDESITE_ENCASED_NAQUADAH_SHAFT, Shafts.BRASS_ENCASED_NAQUADAH_SHAFT,
                    Shafts.ANDESITE_ENCASED_DARMSTADTIUM_SHAFT, Shafts.BRASS_ENCASED_DARMSTADTIUM_SHAFT, Shafts.ANDESITE_ENCASED_NEUTRONIUM_SHAFT, Shafts.BRASS_ENCASED_NEUTRONIUM_SHAFT,
                    Girders.METAL_GIRDER_ENCASED_ANDESITE_SHAFT, Girders.METAL_GIRDER_ENCASED_STEEL_SHAFT, Girders.METAL_GIRDER_ENCASED_ALUMINIUM_SHAFT, Girders.METAL_GIRDER_ENCASED_STAINLESS_STEEL_SHAFT,
                    Girders.METAL_GIRDER_ENCASED_TITANIUM_SHAFT, Girders.METAL_GIRDER_ENCASED_TUNGSTEN_STEEL_SHAFT, Girders.METAL_GIRDER_ENCASED_PALLADIUM_SHAFT, Girders.METAL_GIRDER_ENCASED_NAQUADAH_SHAFT,
                    Girders.METAL_GIRDER_ENCASED_DARMSTADTIUM_SHAFT, Girders.METAL_GIRDER_ENCASED_NEUTRONIUM_SHAFT)
            .renderer(() -> ShaftRenderer::new)
            .register();

    public static final BlockEntityEntry<TieredSimpleKineticBlockEntity> TIERED_ENCASED_COGWHEEL = REGISTRATE
            .blockEntity("tiered_encased_cogwheel", TieredSimpleKineticBlockEntity::new)
            .instance(() -> TieredEncasedCogInstance::small, false)
            .validBlocks(Cogwheels.ANDESITE_ENCASED_ANDESITE_COGWHEEL, Cogwheels.BRASS_ENCASED_ANDESITE_COGWHEEL, Cogwheels.ANDESITE_ENCASED_STEEL_COGWHEEL, Cogwheels.BRASS_ENCASED_STEEL_COGWHEEL,
                    Cogwheels.ANDESITE_ENCASED_ALUMINIUM_COGWHEEL, Cogwheels.BRASS_ENCASED_ALUMINIUM_COGWHEEL, Cogwheels.ANDESITE_ENCASED_STAINLESS_STEEL_COGWHEEL, Cogwheels.BRASS_ENCASED_STAINLESS_STEEL_COGWHEEL,
                    Cogwheels.ANDESITE_ENCASED_TITANIUM_COGWHEEL, Cogwheels.BRASS_ENCASED_TITANIUM_COGWHEEL, Cogwheels.ANDESITE_ENCASED_TUNGSTEN_STEEL_COGWHEEL, Cogwheels.BRASS_ENCASED_TUNGSTEN_STEEL_COGWHEEL,
                    Cogwheels.ANDESITE_ENCASED_PALLADIUM_COGWHEEL, Cogwheels.BRASS_ENCASED_PALLADIUM_COGWHEEL, Cogwheels.ANDESITE_ENCASED_NAQUADAH_COGWHEEL, Cogwheels.BRASS_ENCASED_NAQUADAH_COGWHEEL,
                    Cogwheels.ANDESITE_ENCASED_DARMSTADTIUM_COGWHEEL, Cogwheels.BRASS_ENCASED_DARMSTADTIUM_COGWHEEL, Cogwheels.ANDESITE_ENCASED_NEUTRONIUM_COGWHEEL, Cogwheels.BRASS_ENCASED_NEUTRONIUM_COGWHEEL)
            .renderer(() -> TieredEncasedCogRenderer::small)
            .register();

    public static final BlockEntityEntry<TieredSimpleKineticBlockEntity> TIERED_ENCASED_LARGE_COGWHEEL = REGISTRATE
            .blockEntity("tiered_encased_large_cogwheel", TieredSimpleKineticBlockEntity::new)
            .instance(() -> TieredEncasedCogInstance::large, false)
            .validBlocks(Cogwheels.ANDESITE_ENCASED_LARGE_ANDESITE_COGWHEEL, Cogwheels.BRASS_ENCASED_LARGE_ANDESITE_COGWHEEL, Cogwheels.ANDESITE_ENCASED_LARGE_STEEL_COGWHEEL, Cogwheels.BRASS_ENCASED_LARGE_STEEL_COGWHEEL,
                    Cogwheels.ANDESITE_ENCASED_LARGE_ALUMINIUM_COGWHEEL, Cogwheels.BRASS_ENCASED_LARGE_ALUMINIUM_COGWHEEL, Cogwheels.ANDESITE_ENCASED_LARGE_STAINLESS_STEEL_COGWHEEL, Cogwheels.BRASS_ENCASED_LARGE_STAINLESS_STEEL_COGWHEEL,
                    Cogwheels.ANDESITE_ENCASED_LARGE_TITANIUM_COGWHEEL, Cogwheels.BRASS_ENCASED_LARGE_TITANIUM_COGWHEEL, Cogwheels.ANDESITE_ENCASED_LARGE_TUNGSTEN_STEEL_COGWHEEL, Cogwheels.BRASS_ENCASED_LARGE_TUNGSTEN_STEEL_COGWHEEL,
                    Cogwheels.ANDESITE_ENCASED_LARGE_PALLADIUM_COGWHEEL, Cogwheels.BRASS_ENCASED_LARGE_PALLADIUM_COGWHEEL, Cogwheels.ANDESITE_ENCASED_LARGE_NAQUADAH_COGWHEEL, Cogwheels.BRASS_ENCASED_LARGE_NAQUADAH_COGWHEEL,
                    Cogwheels.ANDESITE_ENCASED_LARGE_DARMSTADTIUM_COGWHEEL, Cogwheels.BRASS_ENCASED_LARGE_DARMSTADTIUM_COGWHEEL, Cogwheels.ANDESITE_ENCASED_LARGE_NEUTRONIUM_COGWHEEL, Cogwheels.BRASS_ENCASED_LARGE_NEUTRONIUM_COGWHEEL)
            .renderer(() -> TieredEncasedCogRenderer::large)
            .register();

    public static final BlockEntityEntry<TieredGearboxBlockEntity> TIERED_GEARBOX = REGISTRATE
            .blockEntity("tiered_gearbox", TieredGearboxBlockEntity::new)
            .instance(() -> TieredGearboxInstance::new, false)
            .validBlocks(Gearboxes.ANDESITE_GEARBOX, Gearboxes.STEEL_GEARBOX, Gearboxes.ALUMINIUM_GEARBOX, Gearboxes.STAINLESS_STEEL_GEARBOX,
                    Gearboxes.TITANIUM_GEARBOX, Gearboxes.TUNGSTEN_STEEL_GEARBOX, Gearboxes.PALLADIUM_GEARBOX, Gearboxes.NAQUADAH_GEARBOX,
                    Gearboxes.DARMSTADTIUM_GEARBOX, Gearboxes.NEUTRONIUM_GEARBOX)
            .renderer(() -> TieredGearboxRenderer::new)
            .register();

    public static final BlockEntityEntry<TieredPoweredShaftBlockEntity> TIERED_POWERED_SHAFT = REGISTRATE
            .blockEntity("tiered_powered_shaft", TieredPoweredShaftBlockEntity::new)
            .instance(() -> TieredSingleRotatingInstance::new)
            .validBlocks(Shafts.POWERED_ANDESITE_SHAFT, Shafts.POWERED_STEEL_SHAFT, Shafts.POWERED_ALUMINIUM_SHAFT, Shafts.POWERED_STAINLESS_STEEL_SHAFT,
                    Shafts.POWERED_TITANIUM_SHAFT, Shafts.POWERED_TUNGSTEN_STEEL_SHAFT, Shafts.POWERED_PALLADIUM_SHAFT, Shafts.POWERED_NAQUADAH_SHAFT,
                    Shafts.POWERED_DARMSTADTIUM_SHAFT, Shafts.POWERED_NEUTRONIUM_SHAFT)
            .renderer(() -> KineticBlockEntityRenderer::new)
            .register();

    public static final BlockEntityEntry<TieredMillstoneBlockEntity> TIERED_MILLSTONE = REGISTRATE
            .blockEntity("tiered_millstone", TieredMillstoneBlockEntity::new)
            .instance(() -> TieredMillstoneCogInstance::new, false)
            .validBlocks(Millstones.ANDESITE_MILLSTONE, Millstones.STEEL_MILLSTONE, Millstones.ALUMINIUM_MILLSTONE, Millstones.STAINLESS_STEEL_MILLSTONE,
                    Millstones.TITANIUM_MILLSTONE, Millstones.TUNGSTEN_STEEL_MILLSTONE, Millstones.PALLADIUM_MILLSTONE, Millstones.NAQUADAH_MILLSTONE,
                    Millstones.DARMSTADTIUM_MILLSTONE, Millstones.NEUTRONIUM_MILLSTONE)
            .renderer(() -> TieredMillstoneRenderer::new)
            .register();

    public static void register() {}
}
