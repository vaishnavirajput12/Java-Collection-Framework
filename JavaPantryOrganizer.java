import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;



public class JavaPantryOrganizer {
    private List<Ingredient> pantryIngredients;
    private List<Recipe> recipes;

    public JavaPantryOrganizer() {
        pantryIngredients = new ArrayList<>();
        recipes = new ArrayList<>();
    }

    public void addIngredient(Ingredient ingredient) {
        pantryIngredients.add(ingredient);
    }

    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
    }

    public void displayIngredients() {
        System.out.println("Pantry Ingredients:");
        for (Ingredient ingredient : pantryIngredients) {
            System.out.println("- " + ingredient.getName());
        }
        System.out.println();
    }

    public void displayRecipes() {
        System.out.println("Recipes:");
        for (Recipe recipe : recipes) {
            System.out.println("- " + recipe.getName());
        }
        System.out.println();
    }

    public void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Display Ingredients");
        System.out.println("2. Display Recipes");
        System.out.println("3. Add Ingredient");
        System.out.println("4. Add Recipe");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void main(String[] args) {
        JavaPantryOrganizer pantryOrganizer = new JavaPantryOrganizer();
        try (Scanner scanner = new Scanner(System.in)) {
            int choice;
            do {
                pantryOrganizer.displayMenu();
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        pantryOrganizer.displayIngredients();
                        break;
                    case 2:
                        pantryOrganizer.displayRecipes();
                        break;
                    case 3:
                        System.out.print("Enter ingredient name: ");
                        scanner.nextLine(); // Consume newline
                        String ingredientName = scanner.nextLine();
                        pantryOrganizer.addIngredient(new Ingredient(ingredientName));
                        System.out.println("Ingredient added successfully!\n");
                        break;
                    case 4:
                        System.out.print("Enter recipe name: ");
                        scanner.nextLine(); // Consume newline
                        String recipeName = scanner.nextLine();

                        List<Ingredient> recipeIngredients = new ArrayList<>();
                        int ingredientCount;
                        System.out.print("Enter the number of ingredients in the recipe: ");
                        ingredientCount = scanner.nextInt();

                        for (int i = 0; i < ingredientCount; i++) {
                            System.out.print("Enter ingredient #" + (i + 1) + ": ");
                            scanner.nextLine(); // Consume newline
                            String ingredient = scanner.nextLine();
                            recipeIngredients.add(new Ingredient(ingredient));
                        }

                        pantryOrganizer.addRecipe(new Recipe(recipeName, recipeIngredients));
                        System.out.println("Recipe added successfully!\n");
                        break;
                    case 0:
                        System.out.println("Exiting. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.\n");
                }
            } while (choice != 0);
        }
    }
}
