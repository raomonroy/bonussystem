package de.szut.Decorator;

import de.szut.Interface.BonusComponentInterface;
import de.szut.Model.Employee;

public class AbsencePenaltyDecorator extends BonusDecorator {

    private static final double PENALTY_MEDIUM = 300.0;
    private static final double PENALTY_HIGH = 600.0;

    public AbsencePenaltyDecorator(BonusComponentInterface bonusComponent) {
        super(bonusComponent);
    }

    @Override
    public double calculateBonus(Employee employee) {
        double bonus = super.calculateBonus(employee);

        if (employee.getAbsenceDays() > 25) {
            return bonus - PENALTY_HIGH;
        } else if (employee.getAbsenceDays() > 15) {
            return bonus - PENALTY_MEDIUM;
        }

        return bonus;
    }
}
