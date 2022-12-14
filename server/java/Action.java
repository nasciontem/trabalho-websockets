package server.java;

import java.net.*;
import java.io.*;

public class Action {
  /**
   * Método responsável por receber requisições do cliente.
   * 
   * @param CLIENT
   * @returns
   */
  protected String request(final Socket CLIENT) {
    try {
      return (new DataInputStream(CLIENT.getInputStream())).readUTF();
    } catch (IOException error) {
      error.printStackTrace();
    }

    return "";
  }

  /**
   * Método responsável pelo envio de resposta ao cliente quanto à requisição
   * realizada.
   * 
   * @param RESPONSE
   * @param CLIENT
   */
  protected void response(final String RESPONSE, final Socket CLIENT) {
    try {
      (new DataOutputStream(CLIENT.getOutputStream())).writeUTF(RESPONSE);
    } catch (IOException error) {
      error.printStackTrace();
    }
  }

  public void handle(Socket client) {
  }
}
