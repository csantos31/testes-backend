public class ShortestDistanceTest{
    public static void main(String[] args) {       
        ShortestDistance shortestDistance = new DistanceUtils().getShortestDistance();
        int j=0;
        for(int i=0;i<shortestDistance.getVetorDistancia().length;i++){
            if(!String.format("%.2f", shortestDistance.getVetorDistancia()[i][0]).equals("0,00") && j<3){
                j++;

                int index = (int) shortestDistance.getVetorDistancia()[i][1];

                //Aqui temos os resultados calculados de distancia de acordo com o que o usuario informou 
                //Na coluna seguinte temos o index da tabela inicial, com as informações dos pontos que o usuario informou
                System.out.println("\n\n\tPara as coordenadas "+shortestDistance.getLojas()[j][0]+","+shortestDistance.getLojas()[j][1]);

                System.out.println("\n\tDistancia: "+String.format("%.2f", shortestDistance.getVetorDistancia()[i][0]));

            }
        }
    }
}