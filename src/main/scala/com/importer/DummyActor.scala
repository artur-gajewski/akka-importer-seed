package com.importer

import akka.actor.{Actor, ActorLogging, Props}

class DummyActor extends Actor with ActorLogging {
  import DummyActor._

  def receive = {
    case ImporterActor.ImporterMessage(text) =>

      /*
       Implement data import here
       */

      sender() ! DummyMessage(this.getClass.getSimpleName + ": data imported.")
  }	
}

object DummyActor {
  val props = Props[DummyActor]
  case class DummyMessage(text: String)
}
