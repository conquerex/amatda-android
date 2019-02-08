package com.amatda;

import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;


public class MockServer {

  public void test() throws Exception {
    // Create a MockWebServer. These are lean enough that you can create a new
    // instance for every unit test.
    MockWebServer server = new MockWebServer();

    // Schedule some responses.
    server.enqueue(new MockResponse().setBody("hello, world!"));
    server.enqueue(new MockResponse().setBody("sup, bra?"));
    server.enqueue(new MockResponse().setBody("yo dog"));

    // Start the server.
    server.start();

    // Ask the server for its URL. You'll need this to make HTTP requests.
    HttpUrl baseUrl = server.url("/v1/chat/");

    // Exercise your application code, which should make those HTTP requests.
    // Responses are returned in the same order that they are enqueued.
    /*
    Chat chat = new Chat(baseUrl);

    chat.loadMore();
    assertEquals("hello, world!", chat.messages());

    chat.loadMore();
    chat.loadMore();
    assertEquals(""
            + "hello, world!\n"
            + "sup, bra?\n"
            + "yo dog", chat.messages());
*/
    // Optional: confirm that your app made the HTTP requests you were expecting.
    RecordedRequest request1 = server.takeRequest();
    assertEquals("/v1/chat/messages/", request1.getPath());
    assertNotNull(request1.getHeader("Authorization"));

    RecordedRequest request2 = server.takeRequest();
    assertEquals("/v1/chat/messages/2", request2.getPath());

    RecordedRequest request3 = server.takeRequest();
    assertEquals("/v1/chat/messages/3", request3.getPath());

    // Shut down the server. Instances cannot be reused.
    server.shutdown();
  }

}
