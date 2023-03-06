# ID PASS Lite for Java
This is a Java wrapper of the [libidpasslite](https://github.com/idpass/idpass-lite) library that provides developers with an API to create and interact with ID PASS Lite cards.

## Building
```bash
./gradlew build
```

## Quick start
Sample usage....

### 1. Install
Install by adding the bintray repository and the dependency. For Maven users, please see ...

```groovy
// Top level build file
repositories {
    jcenter()
}

// Add to dependencies section
dependencies {
    implementation "org.idpass:idpass-lite-java:0.0.1-SNAPSHOT"
}
```

### 2. Usage

```java
KeySet keySet = KeySet.newBuilder()
	.setEncryptionKey(ByteString.copyFrom(encryptionKey))
	.setSignatureKey(ByteString.copyFrom(signatureKey))
	.build();

IDPassReader reader = new IDPassReader(keySet, rootCerts);

byte[] photo = Files.readAllBytes(Paths.get("testdata/manny1.bmp"));
Ident ident = Ident.newBuilder()
	.setGivenName("John")
	.setSurName("Doe")
	.setPin("1234")
	.setPlaceOfBirth("Aubusson, France")
	.setDateOfBirth(Dat.newBuilder().setYear(1980).setMonth(12).setDay(17))
	.setPhoto(ByteString.copyFrom(photo))
	.addPubExtra(KV.newBuilder().setKey("gender").setValue("male").setKey("height").setValue("5.5ft"))
	.addPrivExtra(KV.newBuilder().setKey("blood type").setValue("A"))
	.build();

Card card = reader.newCard(ident, intermedCerts);

BufferedImage qrCode = card.asQRCode();
Card readCard = reader.open(qrCode);
card.authenticateWithFace(photo);
readCard.getGivenName();
```
