package com.importer

import akka.actor.{Actor, ActorLogging, Props}
import DummyActor._

class DummyActor extends Actor with ActorLogging {
  def receive = {
    case ImporterActor.ImporterMessage(message) => sender() ! process(message)
  }

  private def process(message: String) = {

    // Implement your data import here //

    DummyMessage(this.getClass.getSimpleName + ": data imported.")
  }
}

object DummyActor {
  val props = Props[DummyActor]
  case class DummyMessage(text: String)
}
