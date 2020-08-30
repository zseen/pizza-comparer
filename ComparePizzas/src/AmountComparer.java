import java.util.*;

class AmountComparer {
	public enum Values {
		FIRST ("The first pizza is better value"),
		EQUAL ("They are equal value - choose the one that you prefer!"),
		SECOND ("The second pizza is better value");

		private final String message;

	    Values (String message) {
	        this.message = message;
	    }
	    
	    public String getBetterValueMessage() {
	        return this.message;
	    }
		
	}

	public static Values comparePizzas(Pizza firstPizza, Pizza secondPizza) {	
		Values betterValue;
		if (firstPizza.getPricePerUnit() < secondPizza.getPricePerUnit()) {
			betterValue = Values.FIRST;	
		} else if (secondPizza.getPricePerUnit() < firstPizza.getPricePerUnit()) {
			betterValue = Values.SECOND;
		} else {
			betterValue = Values.EQUAL;;
		}
		return betterValue;
	}

	public static int getPizzaDiameterFromUser(String pizzaSequence) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.printf("Enter the diameter of the %s pizza please!: ", pizzaSequence);
		int diameter = sc.nextInt();
		return diameter;
	}

	public static double getPizzaPriceFromUser(String pizza) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.printf("Enter the price of the %s pizza please!: ", pizza);
		double price = sc.nextDouble();
		return price;
	}

	public static Pizza createPizzaFromUserInput(String pizzaSequenceNum) {
		Pizza pizza = new Pizza();
		int pizzaDiameter = getPizzaDiameterFromUser(pizzaSequenceNum);
		while (pizzaDiameter < 0) {
			System.out.printf("The diameter of a pizza cannot be smaller than 0! ");
			pizzaDiameter = getPizzaDiameterFromUser(pizzaSequenceNum);
		}

		double pizzaPrice = getPizzaPriceFromUser(pizzaSequenceNum);
		while (pizzaPrice < 0) {
			System.out.printf("The price of a pizza cannot be less than 0! ");
			pizzaPrice = getPizzaPriceFromUser(pizzaSequenceNum);
		}
		pizza.setDiameterAndPrice(pizzaDiameter, pizzaPrice);
		return pizza;

	}

	public static void main(String[] args) {
		Pizza firstPizza = createPizzaFromUserInput("first");
		Pizza secondPizza = createPizzaFromUserInput("second");

		Values betterValuePizzaSequence = comparePizzas(firstPizza, secondPizza);
		System.out.println(betterValuePizzaSequence.getBetterValueMessage());
		
	}

}