package pack;

public interface IModel {
    void setFieldState(int row,int column, EFieldState state);
    EFieldState getFieldState(int row, int column);
}
