
public enum Color {
    CRIMSON("\u001B[38;2;220;20;60m"),
    VIOLET("\u001B[38;2;138;43;226m"),
    BEIGE("\u001B[38;2;245;245;220m"),
    GREEN("\u001B[32m");
    

    private final String code;
    

    private Color(String code) {
        this.code = code;
        
    }

    @Override
    public String toString() {

        return code + name();
        
    }
}
