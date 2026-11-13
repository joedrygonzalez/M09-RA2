public class PrincipalEstricte {
    public static void main(String[] args) {
        Fil juan = new Fil("Juan", Thread.NORM_PRIORITY, 1, false, "Termina");
        Fil pepe = new Fil("Pepe", Thread.NORM_PRIORITY, 1, false, "Termina");
            
        juan.start();
        pepe.start();

        System.out.println("Termina thread main");
    }
}
