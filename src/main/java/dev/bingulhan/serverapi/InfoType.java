package dev.bingulhan.serverapi;

public enum InfoType {
    ONLINE_SIZE(2), PORT(1), ACTIVE(0);

    public int id;
    InfoType(int id) {
        this.id = id;
    }
}
