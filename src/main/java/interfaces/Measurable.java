package interfaces;

public interface Measurable {
    Double area();

    default String show(){
        return "Not labelled yet.";
    }
}
