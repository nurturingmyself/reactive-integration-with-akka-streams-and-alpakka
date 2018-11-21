package org.kunicki.reactive_integration;

import akka.actor.ActorSystem;
import akka.stream.ActorMaterializer;
import akka.util.ByteString;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CsvImporter {

    class Model {

        final int id;
        final String value;

        Model(List<ByteString> fields) {
            this.id = Integer.valueOf(fields.get(0).utf8String());
            this.value = fields.get(1).utf8String();
        }
    }

    private static final Path DATA_PATH = Paths.get("src/main/resources/data.csv");
    private static final String INSERT_QUERY = "insert into alpakka.test (id, value) values (now(), ?)";

    private final ActorSystem actorSystem = ActorSystem.create();
    private final ActorMaterializer materializer = ActorMaterializer.create(actorSystem);
}