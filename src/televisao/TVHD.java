package televisao;

import java.util.ArrayList;
import java.util.List;

public class TVHD extends Televisao {
	/**
     * Modelo da TVHD
     */

    private model modelo;
    
    /**
     * Utilizamos enum para declarar
     *3 vari�veis globais que n�o podem ser 
     * mudadas como forma de modelo da
     *TVHD
     *
     */

    public enum model {

        LED, PLASMA, HD;

    }

    /**
     * Metodo get/set do modelo
     * @return
     */

    public model getModelo(){

        return modelo;

    }

    public void setModelo(model modelo){

        this.modelo = modelo;

    }

    /**
     * Construtor padr�o da classe TVHD
     * @param id
     * @param canaisDisponiveis
     * @param modelo
     */

    public TVHD(String id, ArrayList<Canal> canaisDisponiveis, model modelo){

        super(id, canaisDisponiveis);
        this.modelo = modelo;

    }

    /**
     * Certifica que ir� sobrescrever
     */

    @Override
    public void cadastrarCanais (){
    	
        for(Canal canal : canaisDisponiveis) if (canal.isHd()) this.canaisCadastrados.add(canal);
        this.canalAtual = this.canaisCadastrados.get(canaisCadastrados.size() - 1);

    }

    @Override
    public String toString(){

        return "TVHD " + modelo + "," + id + "," + canalAtual + "," + volume;

    }
}
