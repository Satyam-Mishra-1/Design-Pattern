
// 1. Define the Abstract Class
abstract class Meal {
    // Template method
    public final void prepareMeal() {
        gatherIngredients();
        cook();
        serve();
    }

    protected abstract void gatherIngredients();

    protected abstract void cook();

    private void serve() {
        System.out.println("Meal is served.");
    }
}



//  2. Create Concrete Classes
class Pasta extends Meal {
    @Override
    protected void gatherIngredients() {
        System.out.println("Gathering ingredients for Pasta: pasta, sauce, cheese.");
    }

    @Override
    protected void cook() {
        System.out.println("Cooking Pasta: boiling pasta, preparing sauce, mixing.");
    }
}


// Concrete Class: Salad
class Salad extends Meal {
    @Override
    protected void gatherIngredients() {
        System.out.println("Gathering ingredients for Salad: lettuce, tomatoes, dressing.");
    }

    @Override
    protected void cook() {
        System.out.println("Preparing Salad: chopping vegetables, mixing dressing.");
    }
}



//   3. Client Code
public class Template {
    public static void main(String[] args) {
        Meal pastaMeal = new Pasta();
        Meal saladMeal = new Salad();

        System.out.println("Preparing Pasta Meal:");
        pastaMeal.prepareMeal();
        System.out.println();

        System.out.println("Preparing Salad Meal:");
        saladMeal.prepareMeal();
    }
}

