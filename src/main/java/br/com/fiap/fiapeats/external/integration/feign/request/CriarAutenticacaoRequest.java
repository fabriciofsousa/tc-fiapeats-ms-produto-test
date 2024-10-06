package br.com.fiap.fiapeats.external.integration.feign.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CriarAutenticacaoRequest {

  @JsonProperty("client_id")
  private String clientId;

  @JsonProperty("client_secret")
  private String clientSecret;

  @JsonProperty("grant_type")
  private String grantType;

  @JsonProperty("test_token")
  private String testToken;

  public CriarAutenticacaoRequest() {
    this.clientId = "7643347265125418";
    this.clientSecret = "FHhqSmS3qzVw5KxdINqqZJpk6UqGLxBq";
    this.grantType = "client_credentials";
    this.testToken = "false";
  }

  public String getClientId() {
    return clientId;
  }

  public String getClientSecret() {
    return clientSecret;
  }

  public String getGrantType() {
    return grantType;
  }

  public String getTestToken() {
    return testToken;
  }
}
