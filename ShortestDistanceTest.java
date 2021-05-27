import javax.swing.JOptionPane;
import java.util.Arrays;

public class ShortestDistanceTest{
    
    static ShortestDistance shortestDistance = new ShortestDistance();
    static String[] strAux = null; 
    static int[] posicaoAux = new int[2];
    static String[][] posicaoLojas = null;
    static int[][] lojasAux = new int[10][2];


    public static void main(String[] args) {       
        for(int x=0;x<lojasAux.length;x++){
            Arrays.fill(lojasAux[x], -1);
        }
        
        //POSICAO DO CLIENTE  
        definePosicaoCliente();
        
        //DEFINE LOJAS
        defineLojas();

        //PLANO  
        definePlano();
    }

    private static void definePosicaoCliente(){
        do{ 
            strAux = JOptionPane
            .showInputDialog("Digite os valores de X e Y separados por virgula\nExemplo: 3,4\nPrecisam estar devidamente preenchidos")
            .split(",");
        }while(strAux.length < 2 || validacaoValores(Integer.parseInt(strAux[0]),Integer.parseInt(strAux[1]),false));
        posicaoAux[0] = Integer.parseInt(strAux[0]);
        posicaoAux[1] = Integer.parseInt(strAux[1]);
        shortestDistance.setPosicaoCliente(posicaoAux);
    }

    private static void defineLojas(){
        strAux = JOptionPane
        .showInputDialog("Digite os pontos X e Y das lojas separadas por espaço\nExemplo: 2,7 11,11 9,7 Xn,Yn")
        .split("\\s+");
        
        for(int i=0; i<strAux.length; i++){
            String separatorXY[] = strAux[i].split(",");
            
            if(separatorXY.length == 2){
                lojasAux[i][0]= Integer.parseInt(separatorXY[0]);
                lojasAux[i][1]=Integer.parseInt(separatorXY[1]);
            }
        }

        shortestDistance.setLojas(lojasAux);
        // for(int i=0; i<shortestDistance.getLojas().length; i++){
        //     System.out.println(shortestDistance.getLojas()[i][0]+ " "+shortestDistance.getLojas()[i][1]);
        //     if(shortestDistance.getLojas()[i+1][0]==-1){
        //         i = shortestDistance.getLojas().length;
        //         System.out.println("entrou aqui");
        //     }
        // }       
    }

    private static void definePlano(){
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