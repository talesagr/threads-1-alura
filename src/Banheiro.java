public class Banheiro {

    private boolean ehSujo = true;
    public void fazNumero1(){

        String nome = Thread.currentThread().getName();

        System.out.println(nome + " batendo na porta");
        synchronized (this) {
            System.out.println(nome + " Entrando no banheiro");

            while(ehSujo){
                esperaLaFora(nome);
            }

            System.out.println(nome +" Fazendo coisa rapida");
            this.ehSujo = true;

            dormeUmPouco(5000);
            System.out.println(nome +" Dando descarga");
            System.out.println(nome +" Lavando as maos");
            System.out.println(nome + "Saindo do banheiro");
        }

    }

    private static void dormeUmPouco(long millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void fazNumero2(){

        String nome = Thread.currentThread().getName();
        System.out.println(nome + " batendo na porta");
        synchronized (this) {
            System.out.println(nome + " Entrando no banheiro");
            while(ehSujo){
                esperaLaFora(nome);
            }
            System.out.println(nome + " Fazendo coisa demorada");
            this.ehSujo=true;
            dormeUmPouco(10000);
            System.out.println(nome + " Dando descarga");
            System.out.println(nome + " Lavando as maos");
            System.out.println(nome + " Saindo do banheiro");
        }
    }
    private void esperaLaFora(String nome) {
        System.out.println(nome + ", eca, banheiro ta sujo");
        try {
            this.wait();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void limpa() {
        String nome = Thread.currentThread().getName();
        System.out.println(nome + " batendo na porta");
        synchronized (this) {
            System.out.println(nome + " Entrando no banheiro");
            if (!ehSujo) {
                System.out.println(nome + ", não esta sujo, vou sair");
                return;
            }
            System.out.println(nome + " limpando banheiro");
            this.ehSujo = false;
            dormeUmPouco(13000);

            this.notifyAll();


            System.out.println(nome + " Dando descarga");
            System.out.println(nome + " Lavando as maos");
            System.out.println(nome + " Saindo do banheiro");
            this.ehSujo = false;
        }
    }
}
