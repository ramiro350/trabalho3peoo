package televisao;

import televisao.Televisao;

public class TVCadastradaException extends Exception {
	
	public Televisao televisao;

    /**
     * Exce��o da TV j� cadastrada
     * @param msg
     * @param televisao
     */


    public TVCadastradaException (String msg, Televisao televisao){

        super(msg);
        this.televisao = televisao;

    }

}
