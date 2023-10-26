public class VetorDinamico {
    private int qtde;
    private int cap;
    private int [] elementos;
    private static int LIMIAR_DE_CORTE = 4;
    
    VetorDinamico(){
        qtde = 0;
        cap = LIMIAR_DE_CORTE;
        elementos = new int[cap];
    }

    public void adicionar(int e){
        if (estaCheio()){
            aumentarCapacidade();
        }
        elementos[qtde] = e;
        qtde++;
    }

    public void remover(){
        if (!estaVazio())
            qtde--;
        if (cap > LIMIAR_DE_CORTE && qtde <= (cap / 4))
            reduzirCapacidade();
    }

    public boolean estaVazio(){
        return qtde == 0;
    }

    public boolean estaCheio(){
        //if(qtde == cap) 
        //    return true;
        //return false;
        //return qtde == cap ? true : false;
        return qtde == cap;
    }

    public String toString(){
        //String resultado = "";
        StringBuilder sb = new StringBuilder();
        //for(int e : elementos){
            //resultdo = resultado + e + " ";
        //    sb.append(e).append(" ");
        //}
        //return String.format("Qtde: %d, Cap: %d,\nElementos: %s", qtde,cap,sb.toString());
        for(int i = 0; i < qtde; i++){
            sb.append(elementos[i]).append(" ");
        }
        return String.format("Qtde: %d, Cap: %d,\nElementos: %s", qtde,cap,sb.toString());
    }
    private void aumentarCapacidade(){
        //1. Alocar um vetor auxiliar com o dobro da capacidade
        int [] aux = new int[cap*2];
        //2. Copiar todo mundo de elementos para o vetor auxiliar
        for(int i= 0; i < qtde; i++) {
            aux[i] = elementos[i];
        }
        //3. Retornar o valor de cap
        cap *= 2;
        //4. Ajustar elementos para que ele referencie o vetor referenciado por aux
        elementos = aux;
    }

    private void reduzirCapacidade(){
        //1. Alocar um vetor auxiliar com a metade da capacidade
        int [] aux = new int[cap / 2];
        //2. Copiar todo mundo de elementos para o vetor auxiliar
        for (int i = 0; i < qtde; i++) {
            aux[i] = elementos[i];
        }
        //3. cortar o valor de cap pela metade
        cap = cap / 2;
        //4. Ajustar elementos para que ele referencie o vetor referenciado por aux
        elementos = aux;
    }
}
