public class ShortestDistanceTest{
    public static void main(String[] args) {       
        ShortestDistance shortestDistance = new DistanceUtils().getShortestDistance();
        for(int i=0;i<shortestDistance.getVetorDistancia().length;i++){
            if(!String.format("%.2f", shortestDistance.getVetorDistancia()[i]).equals("0,00")){
                System.out.println("Distancia: "+String.format("%.2f", shortestDistance.getVetorDistancia()[i]));
            }
        }
    }
}