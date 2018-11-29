package br.com.kahoot.negocio;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Classe de Funcoes que Recebem e Enviam Dados via ServerSocket
 *
 * @author William Bigas Mauro
 * @since 29/11/2018
 */
public class ManterSocketNegocio {

    /**
     * Funcao que Cria um Server Socket e fica Escutando uma determinada porta.
     *
     * @param porta
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws InterruptedException
     */
    public static Object recebendoDadosViaSocket(Integer porta) throws IOException, ClassNotFoundException, InterruptedException {
        ServerSocket servidor = new ServerSocket(porta);
        Socket entradaDados = servidor.accept();
        ObjectInputStream input = new ObjectInputStream(entradaDados.getInputStream());
        Object objRecebido = input.readObject();
        servidor.close();
        entradaDados.close();
        return objRecebido;
    }

    /**
     * Funcao que envia arquivos para um IP/Porta via ServerSocket.
     *
     * @param enderecoIp
     * @param porta
     * @param objParaEnviar
     * @throws Exception
     */
    public static void enviandoDadosViaSocket(String enderecoIp, Integer porta, Object objParaEnviar) throws Exception {
        InetAddress endereco = InetAddress.getByName(enderecoIp);
        Socket saidaDados = new Socket(endereco, porta);
        ObjectOutputStream saida = new ObjectOutputStream(saidaDados.getOutputStream());
        saida.flush();
        saida.writeObject(objParaEnviar);
        saida.close();
        saidaDados.close();

    }

}