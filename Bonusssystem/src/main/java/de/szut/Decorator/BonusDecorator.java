package de.szut.Decorator;

import de.szut.Interface.BonusComponentInterface;

public class BonusDecorator implements BonusComponentInterface {

    protected BonusComponentInterface bonusComponent;

    public BonusDecorator(BonusComponentInterface bonusComponent) {
        this.bonusComponent = bonusComponent;
    }

    @Override
    public double calculateBonus() {
        return bonusComponent.calculateBonus();
    }
}
