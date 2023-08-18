package lista;

import lista.Lista;

public class TarefaImprimir implements Runnable {
    private Lista lista;
    public TarefaImprimir(Lista lista) {
        this.lista=lista;
    }

    @Override
    public void run(){

//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        synchronized (lista) {
            if(!lista.estaCheia()) {
                try {
                    System.out.println("Indo esperar, aguardando notificacao");
                    lista.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                for (int i = 0; i < lista.tamanho(); i++) {
                    System.out.println(i + " - " + lista.pegaElemento(i));
                }
            }
        }
    }
}
