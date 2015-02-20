akka-importer-seed
==================

A minimal seed template for an Akka importer with Scala build.

## Usage

ImporterActor acts as a dispatcher to various importer actors. DummyActor is provided out-of-the-box that can be used as a template for real importer actors.

## Functionality

1. When application is started, ImporterActor.Start is called that sends messages to all defined actors in that function.
2. Each actor receives a message and starts an import. When finnished, a message is sent back to ImporterActor.
3. When all actors have completed, importer is shut down.

## Running

    $ activator run
