package model;

/**
 * Created by Alex Stewart on 15/04/07.
 *
 * Implementors of this interface will exhibit the ability to be querried for a descriptive text string.
 */

public interface Describable {

    public String getDescription();

    public String getName();
    
    public String talk();
    
}
