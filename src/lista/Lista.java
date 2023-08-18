package lista;

public class Lista {
    private String[] elementos = new String[1000];
    private int i = 0;

    public synchronized void adicionaElementos(String elemento){
        this.elementos[i] = elemento;
        this.i++;

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if(this.i==this.elementos.length){
            System.out.println("Lista ta cheia, notificando");
            this.notify();
        }

    }
    public int tamanho(){
        return this.elementos.length;
    }

    public String pegaElemento(int posicao){
        return this.elementos[posicao];
    }

    public boolean estaCheia(){
        return this.i == this.tamanho();
    }
}
