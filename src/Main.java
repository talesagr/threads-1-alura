import lista.Lista;
import lista.TarefaAdicionarElemento;
import lista.TarefaImprimir;

public class Main {
    public static void main(String[] args) throws InterruptedException {

      Lista lista = new Lista();

        for (int i = 0; i < 10; i++) {
            new Thread(new TarefaAdicionarElemento(lista,i)).start();
        }

        new Thread(new TarefaImprimir(lista)).start();


    }
}