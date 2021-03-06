organization := "com.github.alexarchambault"

name := "argonaut-shapeless"

version := "6.1"

scalaVersion := "2.11.5"

crossScalaVersions := Seq("2.10.4", "2.11.5")

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases")
  //Resolver.sonatypeRepo("snapshots")
)

libraryDependencies ++= Seq(
  "io.argonaut" %% "argonaut" % "6.1-M5",
  "org.scalatest" %% "scalatest" % "2.2.2" % "test",
  "org.scalacheck" %% "scalacheck" % "1.12.1" % "test",
  "com.github.alexarchambault" %% "scalacheck-shapeless" % "1.12.1" % "test"
)

libraryDependencies ++= {
  if (scalaVersion.value startsWith "2.10.")
    Seq(
      "com.chuusai" %% "shapeless" % "2.1.0-RC1" cross CrossVersion.full,
      compilerPlugin("org.scalamacros" % "paradise" % "2.0.1" cross CrossVersion.full)
    )
  else
    Seq(
      "com.chuusai" %% "shapeless" % "2.1.0-RC1"
    )
}


xerial.sbt.Sonatype.sonatypeSettings

publishMavenStyle := true

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

pomExtra := {
  <url>https://github.com/alexarchambault/argonaut-shapeless</url>
    <licenses>
      <license>
        <name>BSD-3-Clause</name>
        <url>http://www.opensource.org/licenses/BSD-3-Clause</url>
      </license>
    </licenses>
    <scm>
      <connection>scm:git:github.com/alexarchambault/argonaut-shapeless.git</connection>
      <developerConnection>scm:git:git@github.com:alexarchambault/argonaut-shapeless.git</developerConnection>
      <url>github.com/alexarchambault/argonaut-shapeless.git</url>
    </scm>
    <developers>
      <developer>
        <id>alexarchambault</id>
        <name>Alexandre Archambault</name>
        <url>https://github.com/alexarchambault</url>
      </developer>
    </developers>
}

