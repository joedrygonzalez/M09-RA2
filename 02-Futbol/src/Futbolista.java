public class Futbolista extends Thread {
    private static final int NUM_JUGADORS = 11;
    private static final int NUM_TIRADES = 20;
    private static final float PROBABILITAT = 0.5f;
    
    private int ngols;
    private int ntirades;

    public Futbolista(String nom) {
        super(nom);
        ngols = 0;
        ntirades = 0;
    }
    
    public int getNgols() {
        return ngols;
    }

    public int getNtirades() {
        return ntirades;
    }

    @Override
    public void run() {
        for (int i = 0; i < NUM_TIRADES; i++) {
            ntirades++;
            if (Math.random() < PROBABILITAT) {
                ngols++;
            }
        }
    }

    public static void main(String[] args) {
        String[] noms = {
            "Piqué", "Vinicius", "Torres", "Ramos", "Ronaldo",
            "Lewan", "Belli", "Arnau", "Aspas", "Messi", "Mbappé"
        };

        System.out.println("Inici dels xuts --------------------");

        Futbolista[] jugadors = new Futbolista[NUM_JUGADORS];
        for (int i = 0; i < NUM_JUGADORS; i++) {
            jugadors[i] = new Futbolista(noms[i]);
        }

        for (Futbolista f : jugadors) {
            f.start();
        }

        for (Futbolista f : jugadors) {
            try {
                f.join();    
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Fi dels xuts -----------------------");

        System.out.println("--- Estadístiques ------");
        for (Futbolista f : jugadors) {
            System.out.printf("%-10s -> %2d gols%n", f.getName(), f.getNgols());
        }
    }

}
