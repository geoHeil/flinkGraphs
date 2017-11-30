// Copyright (C) 2017 geoHeil
package at.geoheil.graphDummy.application

import at.geoheil.graphDummy.utils.FlinkBaseRunner
import org.apache.flink.streaming.api.scala._

object GraphSample extends FlinkBaseRunner {

  // get input data
  val text = env.fromElements(
    "To be, or not to be,--that is the question:--",
    "Whether 'tis nobler in the mind to suffer", "The slings and arrows of outrageous fortune",
    "Or to take arms against a sea of troubles,")

  val counts = text.flatMap {
    _.toLowerCase.split("\\W+")
  }
    .map {
      (_, 1)
    }
    .groupBy(0)
    .sum(1)

  // execute and print result
  counts.print()

}
