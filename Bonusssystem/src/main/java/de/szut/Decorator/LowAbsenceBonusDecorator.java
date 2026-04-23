package de.szut.Decorator;

import de.szut.Interface.BonusComponentInterface;
import de.szut.Model.Employee;

public class LowAbsenceBonusDecorator extends BonusDecorator {

    private static final double TIER_ONE_BONUS = 300.0;
    private static final double TIER_TWO_BONUS = 150.0;

    public LowAbsenceBonusDecorator(BonusComponentInterface bonusComponent) {
        super(bonusComponent);
    }

    @Override
    public double calculateBonus(Employee employee) {
        double base = super.calculateBonus(employee);

        if (employee.getAbsenceDays() <= 3) {
            return base + TIER_ONE_BONUS;
        } else if (employee.getAbsenceDays() <= 7) {
            return base + TIER_TWO_BONUS;
        }

        return base;
    }

}
