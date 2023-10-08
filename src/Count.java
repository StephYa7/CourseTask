public class Count implements AutoCloseable {
    private int count = 0;
    private boolean resourceClosed = false;

    public void add() {
        if (resourceClosed) {
            throw new IllegalStateException("Ресурс закрыт.");
        }
        count++;
    }

    @Override
    public void close() {

        resourceClosed = true;
    }

    public boolean isResourceClosed() {
        return resourceClosed;
    }
}