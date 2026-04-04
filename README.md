# nolmax's packet specifications
This repository holds the Java library of nolmax's packet specifications.

This will be used mainly by the two main parts in nolmax's network communications: the server and the client.

## How was this made?
Packet schemas are built on [Google's Protocol Buffers](https://protobuf.dev). A [proto file](./src/main/proto/chatPacket.proto) holding the schema is converted into functional Java object classes, ready to be used in a [Netty](https://netty.io) pipeline.

## Requirements
- JDK 21 (or later)

## Build
Simply run `gradlew.bat build` if you're on Windows, `./gradlew build` if you are on *nix, or `gradle build` if you have Gradle installed already.