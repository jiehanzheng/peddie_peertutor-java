Peddie Peer Tutor Lookup API
============================

Javadoc
-------

The latest Javadoc now lives happily [here on my server](https://static.jiehan.org/pub/peddie_peertutor-java/doc/).

Packaging and usage
-------------------

```bash
mvn clean package
java -jar peer_tutoring-*-jar-with-dependencies.jar /path/to/database/folder
```

Note that the `/path/to/database/folder` is not currently used, but you will have to supply it since it's positional.

Web front-end
-------------

There is a front-end written in AngularJS for this Java backend.  Refer to [peddie_peertutor-web](https://github.com/jiehanzheng/peddie_peertutor-web) project for its usage.
