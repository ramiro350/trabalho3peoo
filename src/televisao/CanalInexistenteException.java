package televisao;

public class CanalInexistenteException extends Exception {
	public int canal;

    /**
     * Exce��o do Canal Inexistente
     * @param msg
     * @param canal
     */


    public CanalInexistenteException(String msg, int canal){

        super(msg);
        this.canal = canal;

    }

}
