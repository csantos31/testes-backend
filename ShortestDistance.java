public class ShortestDistance{
    //posicaoDoCliente = [X,Y]
    //lojas = [[X,Y]...[Xn, Yn]]
    
    //plano = [M,N] MAIOR QUE 0 e MENOR QUE 1000
    
    //M maior que X
    //N maior que Y

    private int[] posicaoCliente;
    private int[][] lojas;
    private int[] plano;

    
    
	public int[] getPosicaoCliente() {
        return this.posicaoCliente;
	}
    
	public void setPosicaoCliente(int[] posicaoCliente) {
        this.posicaoCliente = posicaoCliente;
	}
    
	public int[][] getLojas() {
        return this.lojas;
	}
    
	public void setLojas(int[][] lojas) {
        this.lojas = lojas;
	}
    
    public int[] getPlano() {
        return this.plano;
    }
    
    public void setPlano(int[] plano) {
        this.plano = plano;
    }
    
}