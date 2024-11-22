// Step 1: Product Class

class Meal {
    private String burger;
    private String drink;

    // Setters for building parts
    public void setBurger(String burger) {
        this.burger = burger;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    // Display meal details
    public void showMeal() {
        System.out.println("Meal includes:");
        System.out.println("Burger: " + burger);
        System.out.println("Drink: " + drink);
    }
}


// Step 2: Abstract Builder
abstract class MealBuilder {
    protected Meal meal = new Meal();

    abstract void buildBurger();
    abstract void buildDrink();

    public Meal getMeal() {
        return meal;
    }
}


// Step 3: Concrete Builders
class VegMealBuilder extends MealBuilder {
    @Override
    void buildBurger() {
        meal.setBurger("Veggie Burger");
    }

    @Override
    void buildDrink() {
        meal.setDrink("Orange Juice");
    }
}

class NonVegMealBuilder extends MealBuilder {
    @Override
    void buildBurger() {
        meal.setBurger("Chicken Burger");
    }

    @Override
    void buildDrink() {
        meal.setDrink("Coke");
    }
}


// Step 4: Director
class MealDirector {
    private MealBuilder mealBuilder;

    public MealDirector(MealBuilder mealBuilder) {
        this.mealBuilder = mealBuilder;
    }

    public void constructMeal() {
        mealBuilder.buildBurger();
        mealBuilder.buildDrink();
    }

    public Meal getMeal() {
        return mealBuilder.getMeal();
    }
}


// Step 5: Client Code
public class BuilderPatternExample {
    public static void main(String[] args) {
        // Example 1: Build a Veg Meal
        MealBuilder vegMealBuilder = new VegMealBuilder();
        MealDirector vegDirector = new MealDirector(vegMealBuilder);
        vegDirector.constructMeal();
        Meal vegMeal = vegDirector.getMeal();
        vegMeal.showMeal();

        // Example 2: Build a Non-Veg Meal
        MealBuilder nonVegMealBuilder = new NonVegMealBuilder();
        MealDirector nonVegDirector = new MealDirector(nonVegMealBuilder);
        nonVegDirector.constructMeal();
        Meal nonVegMeal = nonVegDirector.getMeal();
        nonVegMeal.showMeal();
    }
}
