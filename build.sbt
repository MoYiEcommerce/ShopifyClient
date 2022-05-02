lazy val root = (project in file("."))
  .settings(
    name := "ShopifyClient",
    inThisBuild(
      List(
        scalaVersion                                   := "2.13.7",
        version                                        := "0.1.0-SNAPSHOT",
        organization                                   := "com.moyiecomm",
        semanticdbEnabled                              := true,
        semanticdbVersion                              := scalafixSemanticdb.revision,
        scalafixDependencies += "com.github.liancheng" %% "organize-imports" % "0.6.0"
      )
    ),
    libraryDependencies ++= Seq(
      "com.softwaremill.sttp.client3" %% "core"                             % "3.4.1",
      "com.softwaremill.sttp.client3" %% "circe"                            % "3.4.1",
      "io.circe"                      %% "circe-generic"                    % "0.14.1",
      "io.circe"                      %% "circe-generic-extras"             % "0.14.1",
      "com.typesafe"                   % "config"                           % "1.4.1",
      "org.scalatest"                 %% "scalatest"                        % "3.2.9"  % Test,
      "com.github.tomakehurst"         % "wiremock"                         % "2.27.2" % Test,
      "com.softwaremill.sttp.client3" %% "async-http-client-backend-future" % "3.4.1"  % Test,
      "io.circe"                      %% "circe-parser"                     % "0.14.1" % Test
    ),
//    scalacOptions += "-Wunused",
    Test / parallelExecution := false
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
