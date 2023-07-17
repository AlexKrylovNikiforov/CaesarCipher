package Service;

public enum Pattern {
    EN("English", new String [] {
            "the",
            "of",
            "and",
            "to",
            "a",
            "in",
            "for",
            "is",
            "on",
            "that"
    }),
    FR("French", new String [] {
            "le",
            "de",
            "et",
            "à",
            "un",
            "en",
            "que",
            "les",
            "la",
            "c'est",
    }),
    ES("Spanish", new String [] {
            "de",
            "la",
            "que",
            "el",
            "en",
            "y",
            "a",
            "los",
            "del",
            "es"
    }),
    DE("German", new String [] {
            "der",
            "die",
            "und",
            "in",
            "den",
            "von",
            "zu",
            "das",
            "mit",
            "sich"
    }),
    IT("Italian", new String [] {
            "di",
            "e",
            "il",
            "la",
            "che",
            "è",
            "un",
            "a",
            "in",
            "non"
    }),
    UK("Ukrainian", new String [] {
            "і",
            "в",
            "не",
            "на",
            "з",
            "що",
            "а",
            "як",
            "по",
            "він"
    }),
    RU("Russian", new String [] {
            "и",
            "в",
            "не",
            "на",
            "с",
            "что",
            "а",
            "как",
            "по",
            "он"
    }),
    ;
    private final String label;
    private final String[] description;

    Pattern(String label, String[] description) {
        this.label = label;
        this.description = description;
    }

    public String getLabel() {
        return label;
    }

    public String[] getDescription() {
        return description;
    }
}
