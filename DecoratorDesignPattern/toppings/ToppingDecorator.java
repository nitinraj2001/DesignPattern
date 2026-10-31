package DesignPattern.DecoratorDesignPattern.toppings;

import DesignPattern.DecoratorDesignPattern.pizza.BasePizza;

/**
 *  This class is used to represents the topping decorator which is used to add toppings to the pizza
 */
public abstract class ToppingDecorator implements BasePizza {

    // This variable is used to hold the reference of the base pizza object
    protected BasePizza basePizza;

    public ToppingDecorator(BasePizza basePizza){
        this.basePizza = basePizza;
    }

}
