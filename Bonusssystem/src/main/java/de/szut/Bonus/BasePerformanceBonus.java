package de.szut.Bonus;

import de.szut.Interface.BonusComponentInterface;
import de.szut.Model.Employee;

public class BasePerformanceBonus implements BonusComponentInterface {
    private static final double BASE_AMOUNT = 500.0;

    @Override
    public double calculateBonus(Employee employee) {
        return BASE_AMOUNT;
    }
}
