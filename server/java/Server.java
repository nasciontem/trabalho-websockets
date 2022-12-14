package server.java;

import java.net.*;
import java.io.*;

public class Server {
  Integer port;
  ServerSocket server;

  public Server(final Integer PORT) {
    this.port = PORT;

    this.createServer();
    this.openConnections();
  }

  void createServer() {
    try {
      this.server = new ServerSocket(this.port);

      System.out.println("Listening on port " + this.port + "...");
    } catch (IOException error) {
      error.printStackTrace();
    }
  }

  /**
   * Método responsável pela disponibilização do servidor para recepção de novas
   * conexões com clientes.
   */
  void openConnections() {
    while (true) {
      openConnection();
    }
  }

  /**
   * Método responsável pela abertura de conexão com cliente e atribuição do
   * cliente a uma nova thread.
   */
  void openConnection() {
    try {
      Socket client = this.server.accept();
      System.out.println("Connection stablished with " + client.toString() + "...");

      (new Connection(client)).start();
    } catch (IOException error) {
      error.printStackTrace();
    }
  }
}
