plugins {
	java
	id("org.springframework.boot") version "2.7.17"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
}

group = "com.tcgb02"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_11
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("com.oracle.database.jdbc:ojdbc8")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation 'com.fasterxml.jackson.datatype:jackson-datatype-hibernate5:2.13.0'
}

tasks.withType<Test> {
	useJUnitPlatform()
}
