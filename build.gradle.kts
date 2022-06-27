import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.6.7"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
	id("org.jetbrains.kotlin.plugin.noarg") version "1.5.31"
}

noArg {
	annotation("software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean")
}

group = "com.caiopassos"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.2")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:1.6.2")
	compileOnly("software.amazon.awssdk:aws-sdk-java:2.17.216")
	implementation("software.amazon.awssdk:dynamodb:2.17.216")
	implementation("software.amazon.awssdk:dynamodb-enhanced:2.17.216")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	testImplementation("io.mockk:mockk:1.12.4")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.2")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
