import javax.swing.JOptionPane;
import java.util.Arrays;
import java.lang.Math;

public class DistanceUtils{
    private ShortestDistance shortestDistance = new ShortestDistance();
    private String[] strAux = null; 
    private int[] posicaoAux = new int[2];
    private String[][] posicaoLojas = null;
    private int[][] lojasAux = new int[10][2];
    private double[] vetorDistancia = new double[10];

    public ShortestDistance getShortestDistance(){
        for(int x=0;x<this.lojasAux.length;x++){
            Arrays.fill(this.lojasAux[x], -1);
        }
        
        //POSICAO DO CLIENTE  
        this.definePosicaoCliente();
        
        //DEFINE LOJAS
        this.defineLojas();

        //PLANO  
        this.definePlano();

        //VETOR COM CALCULO DE DISTANCIAS
        this.calculaDistancias();

        return this.shortestDistance;
    }
    
    private void definePosicaoCliente(){
        do{ 
            this.strAux = JOptionPane
            .showInputDialog("Digite a localizacao: valores de X e Y  separados por virgula\nExemplo: 3,4\nPrecisam estar devidamente preenchidos")
            .split(",");
        }while(this.strAux.length < 2 || this.validacaoValores(Integer.parseInt(this.strAux[0]),Integer.parseInt(this.strAux[1]),false));
        this.posicaoAux[0] = Integer.parseInt(this.strAux[0]);
        this.posicaoAux[1] = Integer.parseInt(this.strAux[1]);
        this.shortestDistance.setPosicaoCliente(this.posicaoAux);
    }

    private void defineLojas(){
        this.strAux = JOptionPane
        .showInputDialog("Digite os pontos X e Y das lojas separadas por espaço\nExemplo: 2,7 11,11 9,7 Xn,Yn")
        .split("\\s+");
        
        for(int i=0; i<this.strAux.length; i++){
            String separatorXY[] = this.strAux[i].split(",");
            
            if(separatorXY.length == 2){
                this.lojasAux[i][0]= Integer.parseInt(separatorXY[0]);
                this.lojasAux[i][1]=Integer.parseInt(separatorXY[1]);
            }
        }
        this.shortestDistance.setLojas(this.lojasAux);
    }

    private void definePlano(){
        String[] auxPlano = null;
        do{
            auxPlano = JOptionPane
            .showInputDialog("Digite os valores de M e N separados por virgula\nExemplo: 20,40\nPrecisam estar devidamente preenchidos")
            .split(",");
        }while(auxPlano.length < 2 || this.validacaoValores(Integer.parseInt(auxPlano[0]),Integer.parseInt(auxPlano[1]),true));
        int[] posicaoAuxInt = new int[2]; 
        posicaoAuxInt[0] = Integer.parseInt(auxPlano[0]);
        posicaoAuxInt[1] = Integer.parseInt(auxPlano[1]);
        this.shortestDistance.setPlano(posicaoAuxInt);
    }

    private void calculaDistancias(){
        int x1 = this.shortestDistance.getPosicaoCliente()[0];
        int y1 = this.shortestDistance.getPosicaoCliente()[1];
        
        for(int i=0; i<this.shortestDistance.getLojas().length; i++){
            int x2=this.shortestDistance.getLojas()[i][0];
            int y2=this.shortestDistance.getLojas()[i][1];
            vetorDistancia[i] = Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1)); 
            if(this.shortestDistance.getLojas()[i+1][0]==-1){
                i = this.shortestDistance.getLojas().length;
            }
        }
        this.shortestDistance.setVetorDistancia(this.vetorDistancia);
    }

    private boolean validacaoValores(int xm, int yn, boolean plano){
        if(!plano){
            if(xm <=0 || yn<=0){
                return true;
            }
            return false;
        }
        if(xm<=this.shortestDistance.getPosicaoCliente()[0] 
            || yn<=this.shortestDistance.getPosicaoCliente()[1]
            || 1000<=this.shortestDistance.getPosicaoCliente()[0]
            || 1000<=this.shortestDistance.getPosicaoCliente()[1]){
            return true;
        }
        return false;
    }
}