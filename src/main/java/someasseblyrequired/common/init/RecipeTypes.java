package someasseblyrequired.common.init;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import someasseblyrequired.SomeAssemblyRequired;
import someasseblyrequired.common.recipe.CuttingRecipe;
import someasseblyrequired.common.recipe.SingleIngredientRecipe;
import someasseblyrequired.common.recipe.ToastingRecipe;

public class RecipeTypes {

    public static final DeferredRegister<IRecipeSerializer<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, SomeAssemblyRequired.MODID);

    public static final IRecipeType<CuttingRecipe> CUTTING = IRecipeType.register(new ResourceLocation(SomeAssemblyRequired.MODID, "cutting").toString());
    public static final IRecipeType<SingleIngredientRecipe> TOASTING = IRecipeType.register(new ResourceLocation(SomeAssemblyRequired.MODID, "toasting").toString());

    public static final RegistryObject<IRecipeSerializer<?>> CUTTING_SERIALIZER = REGISTRY.register(
            "cutting",
            CuttingRecipe.Serializer::new
    );

    public static final RegistryObject<IRecipeSerializer<?>> TOASTING_SERIALIZER = REGISTRY.register(
            "toasting",
            ToastingRecipe.Serializer::new
    );

    public static void registerBrewingRecipes() {
        BrewingRecipeRegistry.addRecipe(Ingredient.fromStacks(PotionUtils.addPotionToItemStack(new ItemStack(net.minecraft.item.Items.POTION), Potions.THICK)), Ingredient.fromItems(net.minecraft.item.Items.EGG), new ItemStack(Items.MAYONNAISE_BOTTLE.get()));
    }
}
