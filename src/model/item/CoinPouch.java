package model.item;

import model.entity.occupation.Occupation;
import utility.Util;

/**
 * This class represents a 'coin pouch' within the game world. Coin pouches are
 * usually carried by entities.
 * @author Alex Stewart
 */
public class CoinPouch extends TakeableItem {

    private static final String NAME = "Coin Pouch";
    private static final String DESC = "A pouch of gold coins.";
    private static final int POUCH_VALUE = 0;
	
	private int value = 0;

    public CoinPouch () {
        super(NAME, POUCH_VALUE);
    }

    public CoinPouch (int starting_value) {
        super(NAME, POUCH_VALUE);
        setValue(starting_value);
    }

    public String getDescription() {
        return this.DESC;
    }

    /**
     * Gets the current value of the coin purse.
     * @return The value of the coin purse as an int
     */
    public int getValue() { return value; }

    /**
     * Modifies the value of the coin purse by the amount specified. If the
     * modified value is less than 0, the coin pouch will be bounded to 0.
     * @param addition The change to the value of the coin purse (positive
     * values increase, negatives decrease)
     * @return The resultant value of the coin purse, after the modification.
     */
    public int modValue(int addition) {

        Util.dbgOut("Modifying coin pouch value: " + Integer.toString(this.value) + " + " + Integer.toString(addition), 4);
        this.value += addition;

        if (!nonNegative(this.value)) {// if value is negative
            Util.dbgOut("Modified value of coin pouch is negative; setting to 0.", 3);
            this.value = 0;
        }
        return getValue();
    }

    /**
     * Determines if the given integer value is negative
     * @param value The integer value to evaluate
     * @return TRUE, if the value is >= 0; FALSE, otherwise
     */
    private boolean nonNegative(int value) {
        if (value < 0) { return false; }
        else { return true; }
    }

    /**
     * Sets the value of the coin purse to the new value, if it is non-negative
     * @param newValue The new, non-negative int value
     * @return The resultant value of the coin purse
     */
    public int setValue(int newValue) {
        if (nonNegative(newValue))
            this.value = newValue;
        return getValue();
    }

    @Override
    public boolean use(Occupation occupation) {
        return false;
    }

    @Override
    public boolean unUse(Occupation occupation) { return false;}
}
