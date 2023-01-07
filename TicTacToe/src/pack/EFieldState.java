package pack;

public enum EFieldState {
    CROSS('x'), CIRCLE('o'), EMPTY(' ');
    
    private final char symbol;
    
    private EFieldState(char symbol) {
        this.symbol = symbol;
    }
    
    public char getSymbol() {
        return symbol;
    }

}
