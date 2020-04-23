package televisao;

import java.util.ArrayList;
import java.util.List;

public class SmartTV extends Televisao {
	

	public int pol;

    /**
     * M�todo get/set do pol
     * @return
     */

    public int getPol(){

        return pol;

    }

    public void setPol(int pol){

        this.pol = pol;

    }

    /**
     * Construtor padr�o da classe SmartTV
     * @param id
     * @param canaisDisponiveis
     * @param pol
     */

    public SmartTV(String id, ArrayList<Canal> canaisDisponiveis, int pol){

        super(id, canaisDisponiveis);
        this.pol = pol;

    }

    /**
     * Insere todos os canais existentes na lista de canais cadastrados
     */
    @Override
    public void cadastrarCanais(){

       for(Canal canal: canaisDisponiveis) {
    	   this.canaisCadastrados.add(canal);
    	   this.canalAtual = this.canaisCadastrados.get(canaisCadastrados.size() - 1);

       }

    }

}
