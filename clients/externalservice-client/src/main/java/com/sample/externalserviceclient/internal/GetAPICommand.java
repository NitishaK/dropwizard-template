package com.sample.externalserviceclient.internal;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

/**
 * Created by nitisha.khandelwal on 06/05/16.
 */

public class GetAPICommand extends HystrixCommand<Response> {

  private final BaseCommand baseCommand;

  public static final String EXTERNAL_SERVICE = "external-service";
  public static final String PATH = "/users/{id}";

  private String id;

  public GetAPICommand(BaseCommand baseCommand, String id) {
    super(HystrixCommandGroupKey.Factory.asKey(EXTERNAL_SERVICE));
    this.baseCommand = baseCommand;
    this.id = id;
  }

  @Override
  public Response run() throws Exception {

    URI link = UriBuilder.fromUri(baseCommand.getConfiguration().getUrl()).path(PATH).build(id);

    Response response = baseCommand.getClient().target(link).request(MediaType.APPLICATION_JSON_TYPE).get();

    return response;

  }
}
