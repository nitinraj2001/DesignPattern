package DesignPattern.DecoratorDesignPattern.pizza;

/**
 *  This class is used to represents the FarmHouse pizza with initial cost and description
 */
public class FarmHousePizza implements BasePizza {

    /**
     * This method is used to get the description of the pizza
     * @return it returns the description of the pizza
     */
    @Override
    public String getDescription() {
        return "FarmHouse Pizza";
    }

    /**
     * This method is used to get the cost of the pizza
     * @return it returns the cost of the pizza
     */
    @Override
    public double getCost() {
        return 200;
    }
}
