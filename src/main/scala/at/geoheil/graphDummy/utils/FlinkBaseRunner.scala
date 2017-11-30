// Copyright (C) 2017 geoHeil
package at.geoheil.graphDummy.utils

import at.geoheil.graphDummy.utils.configuration.GraphDummyConfigurationClass
import at.geoheil.graphDummy.utils.configuration.configuration.ConfigurationUtils
import org.apache.flink.api.scala.ExecutionEnvironment
import org.slf4j.LoggerFactory

trait FlinkBaseRunner extends App {

  @transient lazy val LOG = LoggerFactory.getLogger(this.getClass)
  val c = ConfigurationUtils.loadConfiguration[GraphDummyConfigurationClass]
  val env = createFlinkExecutionEnvironment

  def createFlinkExecutionEnvironment(): ExecutionEnvironment = {
    ConfigurationUtils.createFlinkExecutionEnvironment
  }

}
