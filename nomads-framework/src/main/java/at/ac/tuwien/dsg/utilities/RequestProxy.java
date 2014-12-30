package at.ac.tuwien.dsg.utilities;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpObject;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.littleshoot.proxy.HttpFilters;
import org.littleshoot.proxy.HttpFiltersAdapter;
import org.littleshoot.proxy.HttpFiltersSourceAdapter;
import org.littleshoot.proxy.HttpProxyServer;
import org.littleshoot.proxy.impl.DefaultHttpProxyServer;

/**
 * Created by jomis on 18/12/14.
 */
public class RequestProxy {

    public void createNewRequestProxy(int port) {
        //https://github.com/adamfisk/LittleProxy
        HttpProxyServer server =
                DefaultHttpProxyServer.bootstrap()
                        .withPort(port)
                        .withFiltersSource(new HttpFiltersSourceAdapter() {
                            public HttpFilters filterRequest(HttpRequest originalRequest, ChannelHandlerContext ctx) {
                                return new HttpFiltersAdapter(originalRequest) {
                                    @Override
                                    public HttpResponse clientToProxyRequest(HttpObject httpObject) {
                                        // TODO: implement your filtering here

                                        return null;
                                    }

                                    @Override
                                    public HttpResponse proxyToServerRequest(HttpObject httpObject) {
                                        // TODO: implement your filtering here
                                        return null;
                                    }

                                    @Override
                                    public HttpObject serverToProxyResponse(HttpObject httpObject) {
                                        // TODO: implement your filtering here
                                        return httpObject;
                                    }

                                    @Override
                                    public HttpObject proxyToClientResponse(HttpObject httpObject) {
                                        // TODO: implement your filtering here
                                        return httpObject;
                                    }
                                };
                            }
                        })
                        .start();


    }
}
