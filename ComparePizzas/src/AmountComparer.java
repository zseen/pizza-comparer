class AmountComparer {
	public enum Values {
		FIRST("The first pizza is better value"), EQUAL("They are equal value - choose the one that you prefer!"),
		SECOND("The second pizza is better value");

		private final String messageToUser;

		Values(String messageToUser) {
			this.messageToUser = messageToUser;
		}

		public String getBetterValueMessage() {
			return this.messageToUser;
		}

	}

	public static Values comparePizzas(Pizza firstPizza, Pizza secondPizza) {
		Values betterValue;
		if (firstPizza.getPricePerUnit() < secondPizza.getPricePerUnit()) {
			betterValue = Values.FIRST;
		} else if (secondPizza.getPricePerUnit() < firstPizza.getPricePerUnit()) {
			betterValue = Values.SECOND;
		} else {
			betterValue = Values.EQUAL;

		}
		return betterValue;
	}

	public static void main(String[] args) {
		InputHandler ih = new InputHandler();
		Pizza firstPizza = ih.createPizzaFromUserInput("first");
		Pizza secondPizza = ih.createPizzaFromUserInput("second");

		Values betterValuePizzaSequence = comparePizzas(firstPizza, secondPizza);
		System.out.println(betterValuePizzaSequence.getBetterValueMessage());

	}

}