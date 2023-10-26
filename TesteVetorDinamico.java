public class TesteVetorDinamico {
    public static void main(String[] args) throws Exception{
        //1. Constroir vetor dinaminco:
        var v = new VetorDinamico();
        var gerador = new java.util.Random();
        //2. Loop infinito
        System.out.println("Começamos removendo...");
        v.remover();
        while (true) {
            
            boolean eParaAdicionar = gerador.nextDouble() <= 0.7;
            if (eParaAdicionar) {
            System.out.println("Adicionando...");    
            //3. Gerar um valor aleatório entre 1 e 6
            var numero  = gerador.nextInt(6) + 1;
            //4. Adicionar Vetor dinaminco
            v.adicionar(numero);
        }
        else {
            System.out.println("Removendo...");
            v.remover();
        }
        //5. Exibir estado do VetorDinamico
        System.out.println(v);
        System.out.println("******************");
        //6. Dormir por 5 segundos
        Thread.sleep(5000);
        }    
    }
}
