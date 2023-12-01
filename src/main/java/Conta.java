import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Uma classe simples de conta bancária
 * @author wncassillo
 * @version 1.0
 * @since Release 1.0 
 * 
 */
public class Conta {
	private float saldo;
	private boolean contaEspecial;
	private float saque;
	
	/**
	 * Construtor da classe conta
	 * @param nome Nome do dono da conta
	 * @param especial Se a conta é especial ou não
	 * @param saldo Valor do saldo da conta
	 */
	 public Conta(float saldo, boolean especial) {
	        this.saldo = saldo;
	        this.contaEspecial = especial;
	    }
	
	/**
	 * Método que cria uma conta de cliente especial com saldo de -200 reais.
	 * @param Conta especial
	 */
	@Given("^Um cliente especial com saldo atual de -(\\d+) reais$")
	public void um_cliente_especial_com_saldo_atual_de_reais(Conta especial) throws Throwable{
	    saldo = -200;
	    contaEspecial = true;
	    throw new PendingException();
	}
	
	/**
	 * Método que representa a soliticação de um saque
	 * @param Conta especial
	 */
	@When("^for solicitado um saque no valor de (\\d+) reais$")
	public void for_solicitado_um_saque_no_valor_de_reais(Conta especial) throws Throwable{
	    saque = 200;
	    throw new PendingException();
	}

	/**
	 * Método que representa o sistema de saque;
	 * @param Conta especial
	 */
	@Then("^deve efetuar o saque e atualizar o saldo da conta para -(\\d+) reais$")
	public void deve_efetuar_o_saque_e_atualizar_o_saldo_da_conta_para_reais(Conta especial) throws Throwable{
	    if(saldo >= saque) {
	    	saldo = saldo - saque;
	    	System.out.println(String.format("Saque realizado com sucesso. Seu saldo atual é de %d reais", saldo));
	    } else if (contaEspecial) {
	    	saldo = saldo - saque;
	    	System.out.println(String.format("Saque realizado com sucesso. Seu saldo atual é de %d reais", saldo));
	    } else if (!contaEspecial) {
	    	System.out.println(String.format("Saldo insuficiente. Seu saldo atual é de %d reais", saldo));
	    }
	    throw new PendingException();
	}

	/**
	 * Checa outros resultados;
	 * conta sem ser comum;
	 * cria o saque;
	 * realiza a operação do saque;
	 * @param Conta comum;
	 */
	@Then("^check more outcomes$")
	public void check_more_outcomes(Conta comum) {
		comum.saldo = -200;
	    comum.contaEspecial = false;
	    saque = 200;
	    if(saldo >= saque) {
	    	saldo = saldo - saque;
	    	System.out.println(String.format("Saque realizado com sucesso. Seu saldo atual é de %d reais", saldo));
	    } else if (contaEspecial) {
	    	saldo = saldo - saque;
	    	System.out.println(String.format("Saque realizado com sucesso. Seu saldo atual é de %d reais", saldo));
	    } else if (!contaEspecial) {
	    	System.out.println(String.format("Saldo insuficiente. Seu saldo atual é de %d reais", saldo));
	    }
	    throw new PendingException();
	}

}
