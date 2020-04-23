package televisao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class Televisao {
	
	
	/**
     * Constantes globais
     */

    public final static int VOLUME_MAXIMO = 10;
    public final static int VOLUME_MINIMO = 0;
    public final static int INCREMENTO = 1;
    public final static int DECREMENTO = -1;


    String id;
    public int volume;
    public Canal canalAtual;

    ArrayList<Canal> canaisDisponiveis = new ArrayList<>();
    ArrayList<Canal> canaisCadastrados = new ArrayList<>();


    /**
     * M�todo get/set do Id
     * @return
     */

    public String getId(){

        return id;

    }

    public void setId(String id){

        this.id = id;

    }

    /**
     * M�todo get/set do volume
     * @return
     */

    public int getVolume(){

        return volume;

    }

    public void setVolume(int volume){

        this.volume = volume;

    }

    /**
     * M�todo get/set do CanalAtual
     * @return
     */

    public Canal getCanalAtual(){

        return canalAtual;

    }

    public void setCanalAtual(Canal canalAtual){

        this.canalAtual = canalAtual;

    }

    /**
     * M�todo get do canaisCadastrados
     * @return
     */

    public ArrayList<Canal> getCanaisCadastrados(){

        return canaisCadastrados;

    }

    /**
     * Construtor padr�o da classe Televis�o
     * @param id
     * @param canaisCadastrados
     */

    public Televisao(String id, ArrayList<Canal> canaisCadastrados){

        this.volume = 5;
        this.id = id;
        this.canaisDisponiveis = canaisCadastrados;


    }

    /**
     * M�todo de cadastrar canais
     */

    public abstract void cadastrarCanais();

    /**
     * Mostra quais os canais que tem
     */

    public void mostarGrade(){

        this.canaisCadastrados.stream().sorted(Comparator.comparing(Canal::getCanal)).forEach(System.out::println);

    }

    /**
     * Mostra as informa��es do canal atual
     */

    public void informarDados(){

        System.out.println(canalAtual);

    }

    /**
     * Muda o volume
     * @param altVolume
     * @return
     */


    public boolean altVolume(String altVolume){

        int vol;
        vol = 0;

        if(altVolume.equalsIgnoreCase("diminuir")){

            vol = this.volume + DECREMENTO;

            if (vol < VOLUME_MINIMO){

                System.out.println("O volume n�o pode ser igual ou menor que ZERO!");

                return false;

            }

        } else if (altVolume.equalsIgnoreCase("aumentar")){

            vol = this.volume + INCREMENTO;

            if (vol > VOLUME_MAXIMO){

                System.out.println("O volume n�o pode ser maior que 10!");

                return false;

            }

        } else {

            System.out.println("N�o foi poss�vel realizar essa a��o!");

            return false;

        }

        this.setVolume(vol);

        return true;

    }

    /**
     * Muda de canal
     * @param altCanal
     */


    public void altCanal(String altCanal){

        int i;
        i = canaisCadastrados.indexOf(canalAtual);

        if (altCanal.equalsIgnoreCase("proximo")){

            i = ++i;
            i %= canaisCadastrados.size();

        } else if (altCanal.equalsIgnoreCase("anterior")){

            i = --i;

            if (i >= 0){

                i %= canaisCadastrados.size();

            } else {

                i = canaisCadastrados.size() + i;

            }

        }

        setCanalAtual(this.canaisCadastrados.get(i));

    }

    /**
     * Verifica se o canal existe
     * @param canal
     * @return
     */


    public boolean verificarCanal(Canal canal){
    	
    	return this.canaisCadastrados.contains(canal);


    }

    /**
     * Sintoniza os canais
     * @param canal1
     * @throws CanalInexistenteException
     */


    public void sintonia(int canal1) throws CanalInexistenteException{

        for(Canal canal : canaisCadastrados){
        	
            if (canal.getCanal() == canal1) {

               canalAtual.setCanal(canal1);
            }

                 else {

                	 throw new CanalInexistenteException("O canal " + canal1 + " n�o existe!", canal1);

                }

            }

        }

}
