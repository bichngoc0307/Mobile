package .pattern;

import lombok.Getter;

public enum SharedPreferencesEnum {
    KEY("notes"),SHAREDPREFERENCESNAME("shared preferences");

    public String getValue() {
        return value;
    }

    private String value;
    private SharedPreferencesEnum(String value){
        this.value = value;
    }
}
