package de.szut.Decorator;

import de.szut.Interface.BonusComponentInterface;
import de.szut.Model.Employee;

public class BonusDecorator implements BonusComponentInterface {

    protected BonusComponentInterface bonusComponent;

    public BonusDecorator(BonusComponentInterface bonusComponent) {
        this.bonusComponent = bonusComponent;
    }

    @Override
    public double calculateBonus(Employee employee) {
        return bonusComponent.calculateBonus(employee);
    }
}
