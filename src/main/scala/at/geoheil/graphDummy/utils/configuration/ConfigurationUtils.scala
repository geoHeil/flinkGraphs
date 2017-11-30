// Copyright (C) 2017 geoHeil

package at.geoheil.graphDummy.utils.configuration.configuration

import at.geoheil.graphDummy.utils.configuration.ConfigurationInvalidException
import org.apache.flink.api.scala.ExecutionEnvironment
import pureconfig._

object ConfigurationUtils {

  def loadConfiguration[T <: Product](implicit reader: ConfigReader[T]): T = {
    loadConfig[T] match {
      case Right(s) => s
      case Left(l) => throw new ConfigurationInvalidException(s"Failed to start. There is a problem with the configuration: $l")
    }
  }

  def createFlinkExecutionEnvironment(): ExecutionEnvironment = {
    // TODO apply configuration here as well
    ExecutionEnvironment.getExecutionEnvironment
  }

}
