public class Fil extends Thread {
    private final int delayMs;
    private final boolean feina;
    private final String textFi;

    public Fil( String name, int prioritat, int delayMs, boolean feina, String textFi) {
        super(name);
        this.delayMs = delayMs;
        this.feina = feina;
        this.textFi = textFi;
        setPriority(prioritat);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 9; i++) {
            System.out.println(getName() + " " + i);

            if (feina) {
                long comptador = 0;
                for (int j = 0; j < 1000; j++) {
                    comptador++;
                }
            }

            if (delayMs > 0) {
                try {
                    Thread.sleep(delayMs);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }
        System.out.println(textFi + " el fil " + getName());
    }

}
