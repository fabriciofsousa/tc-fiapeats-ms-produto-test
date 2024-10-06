package br.com.fiap.fiapeats.domain.entities;

public class Autenticacao {

  private final String accessToken;
  private final String tokenType;

  public Autenticacao(String accessToken, String tokenType) {
    this.accessToken = accessToken;
    this.tokenType = tokenType;
  }

  public String getAccessToken() {
    return accessToken;
  }

  public String getTokenType() {
    return tokenType;
  }
}
