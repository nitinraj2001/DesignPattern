package DesignPattern.DecoratorDesignPattern.toppings;

import DesignPattern.DecoratorDesignPattern.pizza.BasePizza;

/**
 * This class is used to represents the cheese topping which is
 * used to add cheese topping to the pizza
 */
public class MozzarellaCheese extends ToppingDecorator{

    // This constructor is used to initialize the base pizza object
    public MozzarellaCheese(BasePizza basePizza){
        super(basePizza);
    }

    /**
     * This method is used to get the description of the pizza with cheese topping
     * @return it returns the description of the pizza with cheese topping
     */
    @Override
    public String getDescription() {
        return basePizza.getDescription() + ", Mozzarella Cheese";
    }

    /**
     * This method is used to get the cost of the pizza with cheese topping
     * @return it returns the cost of the pizza with cheese topping
     */
    @Override
    public double getCost() {
        return basePizza.getCost() + 50;
    }
}
