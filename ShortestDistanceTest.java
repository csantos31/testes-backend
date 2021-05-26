import javax.swing.JOptionPane;

public class ShortestDistanceTest{
    public static void main(String[] args) {       
        String[] strAux = JOptionPane
                .showInputDialog("Digite os pontos X e Y separados por espaco como no exemplo: 2,3")
                .split(",");

        while(strAux.length < 2 || Integer.parseInt(strAux[0]) <=0 || Integer.parseInt(strAux[1])<=0){
            strAux = JOptionPane
            .showInputDialog("X e Y precisam ser maior que 0\nPrecisam estar no formato x,y\nPrecisam estar devidamente preenchidos")
            .split(",");
        }

        ShortestDistance shortestDistance = new ShortestDistance();
        int[] posicaoAux = {Integer.parseInt(strAux[0]),Integer.parseInt(strAux[1])};

        


        //shortestDistance.setPosicaoCliente(posicaoAux);
        
        // for(int i=0;i<shortestDistance.getPosicaoCliente().length;i++){
            //     System.out.println(shortestDistance.getPosicaoCliente()[i]);
        // }                
    }
}