package utility;

public enum StringUtilEnum {
    SUMMONER_DESCRIPTION(new String("Summoners cast spells and wields a staff. ")),
    SMASHER_DESCRIPTION(new String("Smashers smash things and have the strength of 10 oxes.")),
    SNEAK_DESCRIPTION(new String("Sneaks are sly bastards. They will steal your watch while you're telling time."));
    private String description;

    StringUtilEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
