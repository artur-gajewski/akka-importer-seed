package com.importer

import akka.actor.ActorSystem

object ApplicationMain extends App {
  val system = ActorSystem("ImporterSystem")
  val importerActor = system.actorOf(ImporterActor.props, "importerActor")

  importerActor ! ImporterActor.Start
  system.awaitTermination()
}