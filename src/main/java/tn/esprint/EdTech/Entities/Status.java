package tn.esprint.EdTech.Entities;

public enum Status {
    //EN_COURS("en cours"), TERMINE("terminé"), EN_ATTENTE("en attente")
    EN_COURS("en cours"),
    TERMINE("terminé"),
    CANCELED("Annulé"),
    EN_ATTENTE("en attente");

    private final String displayName;

    Status(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
