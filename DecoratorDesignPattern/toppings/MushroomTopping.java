package DesignPattern.DecoratorDesignPattern.toppings;

import DesignPattern.DecoratorDesignPattern.pizza.BasePizza;

/*
 * This class is used to represent the mushroom topping which is
 * used to add mushroom topping to the pizza
 */
public class MushroomTopping extends ToppingDecorator {

    /**
     * This constructor is used to initialize the base pizza object
     * @param basePizza it represents the base pizza object which is
     * used to add the topping to the pizza
     */
    public MushroomTopping(BasePizza basePizza){
        super(basePizza);
    }

    /**
     * This method is used to get the description of the pizza with mushroom topping
     * @return it returns the description of the pizza with mushroom topping
     **/
    @Override
    public String getDescription() {
        return basePizza.getDescription() + ", Mushroom Topping";
    }

    /**
     * This method is used to get the cost of the pizza with mushroom topping
     * @return it returns the cost of the pizza with mushroom topping
     */
    @Override
    public double getCost() {
        return basePizza.getCost() + 30;
    }
}
