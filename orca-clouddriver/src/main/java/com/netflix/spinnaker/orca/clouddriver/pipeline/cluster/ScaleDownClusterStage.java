/*
 * Copyright 2015 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.netflix.spinnaker.orca.clouddriver.pipeline.cluster;

import com.netflix.spinnaker.kork.dynamicconfig.DynamicConfigService;
import com.netflix.spinnaker.orca.api.pipeline.graph.StageDefinitionBuilder;
import com.netflix.spinnaker.orca.clouddriver.tasks.cluster.AbstractClusterWideClouddriverTask;
import com.netflix.spinnaker.orca.clouddriver.tasks.cluster.AbstractWaitForClusterWideClouddriverTask;
import com.netflix.spinnaker.orca.clouddriver.tasks.cluster.ScaleDownClusterTask;
import com.netflix.spinnaker.orca.clouddriver.tasks.cluster.WaitForScaleDownClusterTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ScaleDownClusterStage extends AbstractClusterWideClouddriverOperationStage {
  public static String PIPELINE_CONFIG_TYPE =
      StageDefinitionBuilder.getType(ScaleDownClusterStage.class);

  @Autowired
  public ScaleDownClusterStage(DynamicConfigService dynamicConfigService) {
    super(dynamicConfigService);
  }

  @Override
  protected Class<? extends AbstractClusterWideClouddriverTask> getClusterOperationTask() {
    return ScaleDownClusterTask.class;
  }

  @Override
  protected Class<? extends AbstractWaitForClusterWideClouddriverTask> getWaitForTask() {
    return WaitForScaleDownClusterTask.class;
  }
}
