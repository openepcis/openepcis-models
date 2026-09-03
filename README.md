<p align="center">
  <img src="https://openepcis.io/img/openepcis-logo.svg" alt="OpenEPCIS" width="30%">
</p>

[![License](https://img.shields.io/badge/License-Apache_2.0-blue.svg)](LICENSE)
[![Maven Central](https://img.shields.io/maven-central/v/io.openepcis/openepcis-model-epcis?label=Maven%20Central)](https://central.sonatype.com/namespace/io.openepcis)
[![Stars](https://img.shields.io/github/stars/openepcis/openepcis-models?style=social)](https://github.com/openepcis/openepcis-models)

<h1 align="center">OpenEPCIS Models</h1>

Java model classes for [EPCIS](https://www.gs1.org/standards/epcis) 2.0 documents, events, master data and REST API messages. The same class reads and writes EPCIS 2.0 JSON/JSON-LD and EPCIS XML, so you do not need to keep two sets of models in sync.

## Why

An EPCIS event carries a lot of attributes: `epcList`, `quantityList`, `bizTransactionList`, `sensorElementList`, `errorDeclaration` and user extensions. Writing all of that accurately as Java classes manually takes time, and the XML and the JSON shape of the same event differ enough that most projects end up with two sets of classes which can slowly drift apart if not correctly maintained.

This module provides you one set. `ObjectEvent`, `AggregationEvent`, `TransactionEvent`, `TransformationEvent` and `AssociationEvent` carry both the Jackson and the JAXB annotations, so the same object can be written as EPCIS JSON-LD or as EPCIS XML depending on which writer you hand it to. Every OpenEPCIS service (capture, query, document converter) is built on these classes.

## Getting started

Add the module you need. `openepcis-model-epcis` is the usual starting point and it pulls in `openepcis-model-core` and `openepcis-model-rest`:

```xml
<dependency>
    <groupId>io.openepcis</groupId>
    <artifactId>openepcis-model-epcis</artifactId>
</dependency>
```

Jackson and the JAXB API are declared as `provided`, so add the versions your application already uses.

### Build an event and write it as EPCIS JSON

```java
ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

ObjectEvent event = ObjectEvent.objectEventBuilder()
        .action(Action.OBSERVE)
        .bizStep("urn:epcglobal:cbv:bizstep:shipping")
        .disposition("urn:epcglobal:cbv:disp:in_transit")
        .epcList(List.of("urn:epc:id:sgtin:0614141.107346.2017"))
        .readPoint(ReadPoint.builder().id(URI.create("urn:epc:id:sgln:0614141.07346.1234")).build())
        .build();

System.out.println(mapper.writeValueAsString(event));
```

Output:

```json
{
  "type" : "ObjectEvent",
  "epcList" : [ "urn:epc:id:sgtin:0614141.107346.2017" ],
  "action" : "OBSERVE",
  "bizStep" : "urn:epcglobal:cbv:bizstep:shipping",
  "disposition" : "urn:epcglobal:cbv:disp:in_transit",
  "readPoint" : {
    "id" : "urn:epc:id:sgln:0614141.07346.1234"
  }
}
```

Reading works the same way. Deserialize into `EPCISEvent` and the `type` field decides the class you get back:

```java
EPCISEvent parsed = mapper.readValue(json, EPCISEvent.class);   // returns an ObjectEvent
```

### Switch between EPC URN and GS1 Digital Link

EPCIS 1.2 used URN identifiers (a URN cannot resolve to anything). EPCIS 2.0 also allows [GS1 Digital Link](https://www.gs1.org/standards/gs1-digital-link) Web URIs, which can be resolved. The `openepcis-model-format` module translates a whole event from one to the other, including `bizStep`, `disposition`, `readPoint`, `bizLocation`, `sourceList` and `destinationList`:

```java
FormatPreference preference =
        FormatPreference.getInstance(EPCFormat.Always_GS1_Digital_Link, CBVFormat.Always_Web_URI);

ObjectEvent converted = (ObjectEvent) EventFormatConverter.translate(event, preference, null);

System.out.println(converted.getEpcList());          // [https://id.gs1.org/01/10614141073464/21/2017]
System.out.println(converted.getBizStep());          // https://ref.gs1.org/cbv/BizStep-shipping
System.out.println(converted.getReadPoint().getId());// https://id.gs1.org/414/0614141073467/254/1234
```

Use `EPCFormat.Always_EPC_URN` with `CBVFormat.Always_URN` for the other direction, and `No_Preference` to leave values untouched.

### Quarkus

The Quarkus extension registers the model classes for reflection so native builds work, publishes a ready `JAXBContext` bean, and adds a health check:

```xml
<dependency>
    <groupId>io.openepcis.quarkus</groupId>
    <artifactId>quarkus-openepcis-model</artifactId>
    <version>0.9.3</version>
</dependency>
```

The health check is on by default. Turn it off with `openepcis.health.enabled=false`.

## Project layout

| Module          | What it holds                                                                                                       |
|-----------------|---------------------------------------------------------------------------------------------------------------------|
| `core`          | shared exceptions such as `ValidationException` and `UnsupportedGS1IdentifierException`, plus pagination support      |
| `rest`          | EPCIS REST API messages: queries, subscriptions and the `ProblemResponseBody` error format                           |
| `epcis`         | the EPCIS 2.0 document, event and master data classes, and the capture job and query result DTOs                     |
| `format`        | translation of a full event between EPC URN and GS1 Digital Link, and between CBV URN and Web URI                    |
| `gs1-web-vocab` | Java interfaces for the GS1 Web Vocabulary (`Product`, `Organization`, `PostalAddress` and the rest)                 |
| `quarkus`       | Quarkus extension, runtime and deployment                                                                            |

## Building

Java 25 and Maven. The parent POM is the external OpenEPCIS BOM, so the first build downloads it.

```bash
mvn clean install              # everything
mvn -pl format test            # one module
```

To move all modules to a new version:

```bash
mvn versions:set -DnewVersion=0.9.4
mvn -N versions:update-child-modules
```

## Related

- [OpenEPCIS Tools](https://tools.openepcis.io/) - open source EPCIS 2.0 tools and services
- [OpenEPCIS](https://openepcis.io/) - Read more about OpenEPCIS
- [OpenEPCIS Document Converter](https://github.com/openepcis/openepcis-document-converter) - converts EPCIS documents between XML and JSON/JSON-LD
- [OpenEPCIS EPC Digital Link Translator](https://github.com/openepcis/openepcis-epc-digitallink-translator) - translates single identifiers between EPC URN and GS1 Digital Link
- [OpenEPCIS EPCIS Constants](https://github.com/openepcis/openepcis-epcis-constants) - shared EPCIS and CBV constants
- [OpenEPCIS Test Resources](https://github.com/openepcis/openepcis-test-resources) - EPCIS documents used for testing
- [benelog GmbH & Co. KG](https://www.benelog.com/) - Company behind OpenEPCIS
- [GS1 EPCIS Standard](https://www.gs1.org/standards/epcis) - Learn more about EPCIS

## License

Licensed under the [Apache License 2.0](LICENSE).
