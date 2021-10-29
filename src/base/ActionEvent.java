package base;

public abstract class ActionEvent {
    private final String name;
    private final Object target;

    public ActionEvent(final String name,
                       final Object target) {
        this.name = name;
        this.target = target;
    }

    public String getName() {
        return this.name;
    }

    protected Object getTarget() {
        return this.target;
    }
}
