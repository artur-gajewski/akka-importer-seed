package com.importer

import akka.actor.{Actor, ActorLogging, Props}

class ImporterActor extends Actor with ActorLogging {
  import ImporterActor._

  val dummyActor = context.actorOf(DummyActor.props, "dummyActor")

  def receive = {
    case Start =>
      dummyActor ! ImporterMessage("import")
    case DummyActor.DummyMessage(message) =>
      log.info(message)
      context.system.shutdown()
  }
}

object ImporterActor {
  val props = Props[ImporterActor]
  case object Start
  case class ImporterMessage(text: String)
}