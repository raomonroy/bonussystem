package de.szut.Decorator;

import de.szut.Interface.BonusComponentInterface;
import de.szut.Model.Employee;

public class PerformanceMultiplierDecorator extends BonusDecorator {

    public PerformanceMultiplierDecorator(BonusComponentInterface bonusComponent) {
        super(bonusComponent);
    }

    @Override
    public double calculateBonus(Employee employee) {
        double bonus = super.calculateBonus(employee);
        return bonus * multiplierFor(employee.getPerformanceScore());
    }

    private double multiplierFor(int score) {
        if (score >= 90) {
            return 1.5;
        }

        if (score >= 75) {
            return 1.25;
        }

        if (score >= 60) {
            return 1.1;
        }

        return 1.0;
    }
}
