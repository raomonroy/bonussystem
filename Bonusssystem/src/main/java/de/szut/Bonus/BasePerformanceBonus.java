package de.szut.Bonus;

import de.szut.Component.BonusComponent;
import de.szut.Model.Employee;

public class BasePerformanceBonus implements BonusComponent {
    private static final double BASE_AMOUNT = 500.0;

    @Override
    public double calculateBonus(Employee employee) {
        return BASE_AMOUNT;
    }
}
