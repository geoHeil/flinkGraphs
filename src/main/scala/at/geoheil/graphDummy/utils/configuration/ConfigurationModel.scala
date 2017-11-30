// Copyright (C) 2017 geoHeil
package at.geoheil.graphDummy.utils.configuration

case class ConfigurationInvalidException(
  private val message: String = "",
  private val cause: Throwable = None.orNull)
  extends Exception(message, cause)

sealed case class GraphDummyConfigurationClass(levelsOfNetwork: Int) {
  require(levelsOfNetwork > 0, "At least a single level of social network needs to be considered")
}