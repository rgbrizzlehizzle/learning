fun main(args: Array<String>) {
  // Kotlin function creating a new Developer object and accessing the 'name'
  val kotlinDev = Developer("Your Name", "Kotlin")
  val name = kotlinDev.name
  // Kotlin function calling the static Java method Logger.logMessage
  Logger.logMessage(name)
  // Works even though Kotlin has not concept of static methods O__o
}


