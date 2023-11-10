lazy val root = (project in file("."))
  .settings(
    name              := "ShopifyClient",
    githubOwner       := "MoYiEcommerce",
    githubRepository  := "ShopifyClient",
    githubTokenSource := TokenSource.Or(TokenSource.GitConfig("github.token"), TokenSource.Environment("PUBLISH_TOKEN")),
    inThisBuild(
      List(
        scalaVersion                                   := "2.13.7",
        version                                        := "0.1.1-SNAPSHOT",
        organization                                   := "com.moyiecomm",
        semanticdbEnabled                              := true,
        semanticdbVersion                              := scalafixSemanticdb.revision,
        scalafixDependencies += "com.github.liancheng" %% "organize-imports" % "0.6.0"
      )
    ),
    libraryDependencies ++= Seq(
      "com.softwaremill.sttp.client3" %% "core"                             % "3.9.0",
      "com.softwaremill.sttp.client3" %% "circe"                            % "3.9.0",
      "io.circe"                      %% "circe-generic"                    % "0.14.1",
      "io.circe"                      %% "circe-generic-extras"             % "0.14.1",
      "com.typesafe"                   % "config"                           % "1.4.1",
      "org.scalatest"                 %% "scalatest"                        % "3.2.17" % Test,
      "org.wiremock"                   % "wiremock"                         % "3.2.0"  % Test,
      "com.softwaremill.sttp.client3" %% "async-http-client-backend-future" % "3.4.1"  % Test,
      "io.circe"                      %% "circe-parser"                     % "0.14.1" % Test
    ),
    scalacOptions += "-Wunused",
    Test / parallelExecution := false
  )
