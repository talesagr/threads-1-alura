package deadlock;

public class Principal {
    public static void main(String[] args) throws InterruptedException {
        GerenciadorDeTransacao tx = new GerenciadorDeTransacao();
        PoolDeConexao pool = new PoolDeConexao();

        new Thread(new TarefaAcessaBanco(pool,tx)).start();
        new Thread(new TarefaAcessaBancoProcedimento(pool,tx)).start();

    }
}
