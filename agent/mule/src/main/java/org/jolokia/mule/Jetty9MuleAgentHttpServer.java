package org.jolokia.mule;/*
 * 
 * Copyright 2014 Roland Huss
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.jolokia.util.ClassUtil;
import org.mule.api.agent.Agent;

/**
 * Mule Agent Server for Jetty 9
 *
 * @author roland
 * @since 05/03/15
 */
public class Jetty9MuleAgentHttpServer extends EclipseMuleAgentHttpServer {

    public static final String SERVER_CONNECTOR_CLASS = "org.eclipse.jetty.server.ServerConnector";

    /**
     * Constructor
     *
     * @param pParent parent for creating proper exceptions
     * @param pConfig configuration of the server
     */
    Jetty9MuleAgentHttpServer(Agent pParent, MuleAgentConfig pConfig) {
        super(pParent, pConfig);
    }

    /** {@inheritDoc} */
    protected Connector createConnector(Server pServer) {
        return ClassUtil.newInstance(SERVER_CONNECTOR_CLASS,pServer);
    }

    public static boolean detect() {
        return ClassUtil.checkForClass(SERVER_CONNECTOR_CLASS);
    }
}
