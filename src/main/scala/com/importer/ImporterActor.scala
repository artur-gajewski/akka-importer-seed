package com.importer

import akka.actor.{Actor, ActorLogging, Props}
import ImporterActor._

class ImporterActor extends Actor with ActorLogging {
  val dummyActor = context.actorOf(DummyActor.props, "dummyActor")

  def receive = {
    case Start =>
      dummyActor ! ImporterMessage("import")
    case DummyActor.DummyMessage(message: String) =>
      log.info(message)
      context.system.shutdown()
  }
}

object ImporterActor {
  val props = Props[ImporterActor]
  case object Start
  case class ImporterMessage(text: String)
}