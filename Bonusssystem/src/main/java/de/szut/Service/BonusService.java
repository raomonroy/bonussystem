package de.szut.Service;

public class BonusService {

    private final double minBonus = 500.0;
    private final double maxBonus = 10000.00;

    public double applyCompanyRestrictions(double bonus) {
        if (bonus > this.maxBonus) {
            return this.maxBonus;
        } else if (bonus < this.minBonus) {
            return this.minBonus;
        }

        return bonus;
    }

    public double getMinBonus() {
        return minBonus;
    }

    public double getMaxBonus() {
        return maxBonus;
    }
}
