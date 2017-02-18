organization := "org.openbrazil"

name := "code-gestao-br"

version := "0.0.1.RELEASE"

libraryDependencies ++= Seq(
  "org.helianto"            %% "helianto-material-skin"       % "1.3.5.RELEASE",
  "org.scalatest"           %% "scalatest"                    % "3.0.0"        % "test",
  "org.mockito"              % "mockito-all"                  % "1.10.19"      % "test"
)

mainClass in Compile := Some("org.openbrazil.gestao.Application")

resolvers  ++= Seq(
  "Helianto Releases"  at "http://s3-sa-east-1.amazonaws.com/maven.helianto.org/release",
  "Helianto Snapshots" at "http://s3-sa-east-1.amazonaws.com/maven.helianto.org/snapshot"
)

licenses in ThisBuild := Seq("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0"))

sbtVersion := "0.13.9"

scalaVersion := "2.11.8"

