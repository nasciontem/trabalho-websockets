package server.java;

import java.net.Socket;

public class InspectEvent extends Event {
  @Override
  public void handle(final Socket CLIENT) {
    this.response("", CLIENT);
  }
}
