public class ShortestDistanceTest{
    public static void main(String[] args) {       
        ShortestDistance shortestDistance = new DistanceUtils().getShortestDistance();
        for(int i=0;i<shortestDistance.getVetorDistancia().length;i++){
            System.out.println("Distancia: "+shortestDistance.getVetorDistancia()[i]);
        }
    }
}