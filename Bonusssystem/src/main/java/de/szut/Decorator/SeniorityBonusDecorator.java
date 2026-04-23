package de.szut.Decorator;

import de.szut.Interface.BonusComponentInterface;
import de.szut.Model.Employee;

public class SeniorityBonusDecorator extends BonusDecorator {

    private static final int INTERVAL_YEARS = 5;
    private static final double BONUS_PER_INTERVAL = 150.0;

    public SeniorityBonusDecorator(BonusComponentInterface componentInterface) {
        super(componentInterface);
    }

    @Override
    public double calculateBonus(Employee employee) {
        int intervals = employee.getYearsInCompany() / INTERVAL_YEARS;
        return super.calculateBonus(employee) + intervals * BONUS_PER_INTERVAL;
    }
}
