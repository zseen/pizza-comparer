class PizzaValueComparer {
	public enum ComparisonResult {
		FIRST_IS_BETTER("The first pizza is better value"),
		EQUAL_VALUES("They are equal value - choose the one that you prefer!"),
		SECOND_IS_BETTER("The second pizza is better value");

		private final String messageToUser;

		ComparisonResult(String messageToUser) {
			this.messageToUser = messageToUser;
		}

		public String getBetterValueMessage() {
			return this.messageToUser;
		}

	}

	public static ComparisonResult comparePizzas(Pizza firstPizza, Pizza secondPizza) throws Exception {

		try {
			ComparisonResult betterValue;

			if (firstPizza.getPricePerUnit() < secondPizza.getPricePerUnit()) {
				betterValue = ComparisonResult.FIRST_IS_BETTER;
			} else if (secondPizza.getPricePerUnit() < firstPizza.getPricePerUnit()) {
				betterValue = ComparisonResult.SECOND_IS_BETTER;
			} else {
				betterValue = ComparisonResult.EQUAL_VALUES;
			}
			return betterValue;
		} catch (RuntimeException e) {
			throw new RuntimeException("Problem with unit of measurement.");

		}

	}

	public static void main(String[] args) {
		InputHandler ih = new InputHandler();

		Pizza firstPizza = ih.createPizzaFromUserInput("first");
		Pizza secondPizza = ih.createPizzaFromUserInput("second");

		ComparisonResult betterPizzaComparisonResult;
		try {
			betterPizzaComparisonResult = comparePizzas(firstPizza, secondPizza);
			System.out.println(betterPizzaComparisonResult.getBetterValueMessage());
		} catch (Exception e) {
			System.out.printf(e.getMessage(), "Something went wrong. Try again please.");
		}

	}

}