ThisBuild / version      := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.13.10"

Test / fork        := true
Test / logBuffered := false

lazy val zioDependencies: Seq[ModuleID] = Seq(
  "dev.zio" %% "zio" % "2.0.10"
)

lazy val catsDependencies: Seq[ModuleID] = Seq(
  "org.typelevel" %% "cats-core" % "2.9.0"
)

lazy val BlockChainZio =
  project
    .in(file("BlockChainZio"))
    .settings(libraryDependencies := zioDependencies)

lazy val BlockChainCats =
  project.in(file("BlockChainCats"))
    .settings(libraryDependencies := catsDependencies)

lazy val root = (project in file("."))
  .settings(
    name := "BlockChainScala"
  )
  .aggregate(BlockChainZio, BlockChainCats)
  .dependsOn(BlockChainZio, BlockChainCats)
