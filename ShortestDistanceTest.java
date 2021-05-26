import javax.swing.JOptionPane;

public class ShortestDistanceTest{
    static ShortestDistance shortestDistance = new ShortestDistance();
    
    public static void main(String[] args) {       

        String[] strAux = null; 
        int[] posicaoAux = new int[2];
        
        //POSICAO DO CLIENTE  
        do{ 
            strAux = JOptionPane
            .showInputDialog("Digite os valores de X e Y separados por virgula\nExemplo: 3,4\nPrecisam estar devidamente preenchidos")
            .split(",");
        }while(strAux.length < 2 || validacaoValores(Integer.parseInt(strAux[0]),Integer.parseInt(strAux[1]),false));
        posicaoAux[0] = Integer.parseInt(strAux[0]);
        posicaoAux[1] = Integer.parseInt(strAux[1]);
        shortestDistance.setPosicaoCliente(posicaoAux);
        

        //PLANO  
        strAux = null;
        do{
            strAux = JOptionPane
            .showInputDialog("Digite os valores de M e N separados por virgula\nExemplo: 20,40\nPrecisam estar devidamente preenchidos")
            .split(",");
        }while(strAux.length < 2 || validacaoValores(Integer.parseInt(strAux[0]),Integer.parseInt(strAux[1]),true));
        posicaoAux[0] = Integer.parseInt(strAux[0]);
        posicaoAux[1] = Integer.parseInt(strAux[1]);
        shortestDistance.setPlano(posicaoAux);
    }

    private static boolean validacaoValores(int xm, int yn, boolean plano){
        if(!plano){
            if(xm <=0 || yn<=0){
                return true;
            }
            return false;
        }
        if(xm<=shortestDistance.getPosicaoCliente()[0] 
            || yn<=shortestDistance.getPosicaoCliente()[1]
            || 1000<=shortestDistance.getPosicaoCliente()[0]
            || 1000<=shortestDistance.getPosicaoCliente()[1]){
            return true;
        }
        return false;
    }
}