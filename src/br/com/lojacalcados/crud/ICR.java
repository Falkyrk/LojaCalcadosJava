package br.com.lojacalcados.crud;

import java.util.List;

/**
 * <b>ICR - Interface Create And Read</b>
 * <br>
 * A interface ICR foi criada para padronizar as opera��es
 * comuns entre as classes da loja de cal�ados, s�o elas:
 * cadastrar(create) e ler dados(read).<br> 
 * Esta interface ser� utilizada posteriormente por 
 * classes e extendida por outras interfaces.
 * @author Edilson Silva
 * 
 * @param <T>
 * O parametro T � a indica��o da classe que deve ser 
 * utilizada para implementar o m�todo da interface
 * 
 * <a href="http://www.github.com/seu_usuario/lojacalcado">
 * 	Reposit�rio do GitHub
 * </a>
 */
public interface ICR<T> {
	/**
	 * <b>Create</b><br>
	 * Este m�todo � respons�vel por cadastrar os dados
	 * sobre o objeto T que ser� passado por parametro 
	 * para a interface ICR
	 * @param obj
	 * @return
	 * Retorna uma das mensagens: 1-Cadastrado com sucesso
	 * 2 - N�o foi poss�vel cadastrar
	 * 3 - Ocorreu um erro
	 */
	public String create(T obj);
	/**
	 * <b>read</b><br>
	 * Este m�todo � respons�vel por retornar um objeto espec�fico
	 *  de acordo com o parametro passado para a consulta
	 * @param obj
	 * 	parametro passado para a consulta
	 * @return
	 * 	Retorna um dois elementos: 1- O objeto consulta 2 - Erro
	 */
	public T read(T obj);
	
	/**
	 * <b>read</b><br>
	 * Este m�todo retorna uma lista com v�rios objetos de acordo
	 * com o seu cadastro em banco de dados.
	 * @return
	 * Retorna uma lista de dados ou null
	 */
	public List<T> read();
	
}
