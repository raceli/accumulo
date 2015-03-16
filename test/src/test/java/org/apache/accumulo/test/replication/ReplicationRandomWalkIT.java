/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.accumulo.test.replication;

import java.util.Properties;

import org.apache.accumulo.core.client.AccumuloException;
import org.apache.accumulo.core.client.AccumuloSecurityException;
import org.apache.accumulo.core.client.Connector;
import org.apache.accumulo.test.functional.ConfigurableMacIT;
import org.apache.accumulo.test.randomwalk.Environment;
import org.apache.accumulo.test.randomwalk.concurrent.Replication;
import org.junit.Test;

public class ReplicationRandomWalkIT extends ConfigurableMacIT {

  @Test
  public void runReplicationRandomWalkStep() throws Exception {
    Replication r = new Replication();

    Environment env = new Environment(new Properties()) {
      @Override
      public String getUserName() {
        return "root";
      }

      @Override
      public String getPassword() {
        return ROOT_PASSWORD;
      }

      @Override
      public Connector getConnector() throws AccumuloException, AccumuloSecurityException {
        return ReplicationRandomWalkIT.this.getConnector();
      }

    };
    r.visit(null, env, null);
  }

}
